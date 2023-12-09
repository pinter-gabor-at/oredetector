package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.mixinutil.DelayedExecute;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;

public abstract class AbstractOreDetector extends Item {
	public AbstractOreDetector(Settings settings) {
		super(settings);
		bangs = null;
		bangVolume = 1f;
	}

	// region Fields

	/**
	 * The transmitted bangs
	 * <p>
	 * Set in the constructor
	 */
	protected SoundEvent bangs;

	/**
	 * Volume of the transmitted bangs
	 * <p>
	 * Set in the constructor
	 */
	protected float bangVolume;

	/**
	 * World in which the block is clicked
	 * <p>
	 * Set before scanning
	 */
	protected ServerWorld clickWorld;

	/**
	 * Position of block clicked
	 * <p>
	 * Set before scanning
	 */
	protected BlockPos clickPos;

	/**
	 * Direction of blockface clicked (= opposit of scanning)
	 * <p>
	 * Set before scanning
	 */
	protected Direction clickFacing;

	/**
	 * The distance of the detected block
	 * <p>
	 * Set by {@link #scan()} if it detects anything
	 */
	protected int distance;

	/**
	 * The type code of the detected block (0..15)
	 * <p>
	 * Set by {@link #scan()} if it detects anything
	 */
	protected int type;

	/**
	 * The received echoes
	 * <p>
	 * Set by {@link #scan()} if it detects anything
	 */
	protected SoundEvent echoes;

	/**
	 * Volume of received echoes
	 * <p>
	 * Set by {@link #scan()} if it detects anything
	 */
	protected float echoVolume;

	/**
	 * Delay time in ticks of the echo
	 * <p>
	 * Set by {@link #scan()} if it detects anything
	 */
	protected int echoDelay;

	protected ParticleEffect particleEffect;

	protected int particleCount;
	// endregion

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		if (!context.getWorld().isClient()) {
			clickWorld = (ServerWorld) context.getWorld();
			clickPos = context.getBlockPos();
			clickFacing = context.getSide();
			final var player = context.getPlayer();
			if (player != null) {
				// Cannot start new scanning while the previous one is still running
				if (((DelayedExecute) player).oredetector$isRunning()) {
					return ActionResult.FAIL;
				}
				// Scanning damages the tool
				if (!player.isCreative()) {
					final var stack = context.getStack();
					stack.damage(1, player,
						(e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
				}
				// Everybody can hear the bangs on the server
				clickWorld.playSound(null, clickPos,
					bangs, SoundCategory.BLOCKS,
					bangVolume, 1f);
				// Scan
				if (scan()) {
					// Play echo delayed
					((DelayedExecute) player)
						.oredetector$delayedExecute(echoDelay, () -> {
							clickWorld.playSound(null, clickPos,
								echoes, SoundCategory.BLOCKS,
								echoVolume, 1f);
							final var ppos = clickPos.offset(clickFacing);
							if (particleEffect != null) {
								clickWorld.spawnParticles(particleEffect,
									ppos.getX() + 0.5d, ppos.getY() + 0.5d, ppos.getZ() + 0.5d,
									particleCount,
									0, 0, 0, 1f);
							}
						});
				}

			}
		}
		return ActionResult.SUCCESS;
	}

	/**
	 * @return Max detection range
	 */
	protected abstract int getRange();

	/**
	 * Check one block
	 * <p>
	 * Set {@link #distance} to {@code distance}, and set echo properties if detected anything
	 * @return true if detected something
	 */
	protected abstract boolean detect(BlockPos pos, int distance);

	/**
	 * Debug hook before calling {@link #detect(BlockPos, int)}
	 */
	private boolean priDetect(BlockPos pos, int distance) {
		final boolean ret = detect(pos, distance);
		final ModConfig config = ModConfig.getInstance();
		if (0 < config.debugLevel && ret) {
			Global.LOGGER.info("Found: {}, type: {}, at ({})",
				clickWorld.getBlockState(pos).getBlock().toString(),
				type,
				pos.subtract(clickPos).toShortString());
		}
		if (1 < config.debugLevel && !ret) {
			// Replace the scanned and not detectable block with glass to see the detected block
			clickWorld.setBlockState(pos, Blocks.GLASS.getDefaultState(), Block.NOTIFY_ALL);
		}
		return ret;
	}

	/**
	 * Translate {@code (x, y, z)} depending on the scanning direction
	 * @return {@code (x,y,z)} translated
	 */
	private Vec3i translate(int x, int y, int z) {
		return switch (clickFacing) {
			default -> new Vec3i(x, y, z);
			case DOWN -> new Vec3i(-x, -y, +z);
			case EAST -> new Vec3i(+y, -x, +z);
			case WEST -> new Vec3i(-y, +x, +z);
			case NORTH -> new Vec3i(+x, +z, -y);
			case SOUTH -> new Vec3i(+x, +z, +y);
		};
	}

	/**
	 * Call {@link #translate(int, int, int)} and then {@link #detect(BlockPos, int)}
	 * <p>
	 * Set {@link #distance}, {@link #type} and the other echo properties according to the first detected block.
	 * @param d Current scanning distance (Will be copied into {@link #distance} if detected anything)
	 * @return true if detected anything
	 */
	private boolean transDetect(int x, int y, int z, int d) {
		return priDetect(clickPos.add(translate(x, y, z)), d);
	}

	/**
	 * Rotate {@code (x,y,z)} in the 4 horizontal directions and call {@link #transDetect(int, int, int, int)} with each
	 * of them
	 * @param d Current scanning distance (Will be copied into {@link #distance} if detected anything)
	 * @return true if detected anything
	 */
	private boolean transDetect4(int x, int y, int z, int d) {
		return (transDetect(+x, y, +z, d)) ||
			(transDetect(+z, y, -x, d)) ||
			(transDetect(-x, y, -z, d)) ||
			(transDetect(-z, y, +x, d));
	}

	/**
	 * Scans blocks
	 * <p>
	 * Also sets {@link #distance} and {@link #type} according to the first detected block.
	 * @return true if detected anything
	 */
	@SuppressWarnings("UnusedReturnValue")
	protected boolean scan() {
		final int range = getRange();
		for (int d = 0; d < range; d++) {
			// Center
			if (transDetect(0, -d, 0, d)) return true;
			// Square
			for (int y = 0; y < d; y++) {
				// Only for even numbers
				if (((d - y) & 1) == 0) {
					final int n = (d - y) / 2;
					for (int x = 0; x < n; x++) {
						if (transDetect4(x, -y, n - x, d)) return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Common echo calculations
	 */
	protected void calcEcho(int type, int distance) {
		this.type = type;
		this.distance = distance;
		echoes = ModSounds.DETECTOR_3ECHOS[type];
		echoVolume = 1f - 0.9f * distance / getRange();
		echoDelay = 10 + 2 * distance;
		// For echos that do not generate particles
		particleEffect = null;
	}

	/**
	 * Common echo and particle calculations
	 */
	protected void calcEcho(int type, int distance, Block pBlock) {
		calcEcho(type, distance);
		final var config = ModConfig.getInstance();
		if (config.enableParticles) {
			particleEffect = new BlockStateParticleEffect(
				ParticleTypes.BLOCK, pBlock.getDefaultState());
			particleCount = (int) (40 * (1f - 0.9f * distance / getRange()));
		}
	}
}

