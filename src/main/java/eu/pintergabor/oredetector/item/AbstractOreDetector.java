package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.mixinutil.DelayedExecute;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.world.phys.Vec3;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import org.joml.Vector3fc;


/**
 * Base class for all Ore Detectors.
 */
public abstract class AbstractOreDetector extends Item {

	public AbstractOreDetector(Properties props, int focus) {
		super(props);
		this.bangs = null;
		this.bangVolume = 1F;
		this.debugLevel = ModConfig.getInstance().debugLevel;
		this.focus = focus;
	}

	// region Fields

	/**
	 * The transmitted bangs.
	 * <p>
	 * Set in the constructor.
	 */
	protected @Nullable SoundEvent bangs;

	/**
	 * Volume of the transmitted bangs.
	 * <p>
	 * Set in the constructor.
	 */
	protected float bangVolume;

	/**
	 * Focus.
	 * <p>
	 * Set in the constructor.
	 */
	protected int focus;

	/**
	 * Debug level.
	 * <p>
	 * Set in the constructor.
	 * See {@link ModConfig#debugLevel} for details.
	 */
	protected int debugLevel;

	/**
	 * World in which the block is clicked.
	 * <p>
	 * Set before scanning.
	 */
	protected ServerLevel clickWorld;

	/**
	 * Position of block clicked.
	 * <p>
	 * Set before scanning.
	 */
	protected BlockPos clickPos;

	/**
	 * Direction of blockface clicked (= opposite of scanning).
	 * <p>
	 * Set before scanning.
	 */
	protected Direction clickFacing;

	/**
	 * The distance of the detected block.
	 * <p>
	 * Set by {@link #scan()} if it detects anything.
	 */
	protected int distance;

	/**
	 * The type code of the detected block (0..15).
	 * <p>
	 * Set by {@link #scan()} if it detects anything.
	 */
	protected int type;

	/**
	 * The received echoes.
	 * <p>
	 * Set by {@link #scan()} if it detects anything.
	 */
	protected @Nullable SoundEvent echoes;

	/**
	 * Volume of received echoes.
	 * <p>
	 * Set by {@link #scan()} if it detects anything.
	 */
	protected float echoVolume;

	/**
	 * Delay time in ticks of the echo.
	 * <p>
	 * Set by {@link #scan()} if it detects anything.
	 */
	protected int echoDelay;

	/**
	 * The particles of the found block.
	 */
	protected @Nullable ParticleOptions particleBlock;

	/**
	 * Number of particles.
	 */
	protected int particleCount;
	// endregion

	/**
	 * Scanning damages the tool.
	 * <p>
	 * Called from {@link #useOn(UseOnContext)}.
	 */
	private void damageTool(UseOnContext context, Player player) {
		if (!player.isCreative()) {
			final ItemStack stack = context.getItemInHand();
			stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
		}
	}

	/**
	 * Play echo and show particles.
	 */
	@NotNull
	private Runnable playEcho() {
		return () -> {
			// Play sound coming from the clicked block.
			if (echoes != null) {
				clickWorld.playSound(null, clickPos,
					echoes, SoundSource.BLOCKS,
					echoVolume, 1F);
			}
			// Spawn particles in front of the clicked block, at the center,
			// with a speed vector pointing outwards.
			final Vec3 ppos = clickPos.relative(clickFacing).getCenter();
			final Vector3fc pspeed = clickFacing.getUnitVec3f();
			if (particleBlock != null) {
				clickWorld.sendParticles(particleBlock,
					ppos.x, ppos.y, ppos.z,
					particleCount,
					pspeed.x(), pspeed.y(), pspeed.z(), 0.005F);
			}
		};
	}

	/**
	 * Play sound, scan and play delayed echo.
	 * <p>
	 * Called from {@link #useOn(UseOnContext)}.
	 */
	private void soundScanEcho(DelayedExecute delayedExecute) {
		// Everybody can hear the bangs on the server.
		clickWorld.playSound(null, clickPos,
			bangs, SoundSource.BLOCKS,
			bangVolume, 1F);
		// Scan.
		if (scan()) {
			// Play echo delayed.
			delayedExecute.oredetector$delayedExecute(echoDelay, playEcho());
		}
	}

	@Override
	@NotNull
	public InteractionResult useOn(UseOnContext context) {
		if (!context.getLevel().isClientSide) {
			clickWorld = (ServerLevel) context.getLevel();
			clickPos = context.getClickedPos();
			clickFacing = context.getClickedFace();
			final Player player = context.getPlayer();
			if (player != null) {
				DelayedExecute delayedExecute = (DelayedExecute) player;
				// Cannot start new scanning while the previous one is still running.
				if (delayedExecute.oredetector$isRunning()) {
					return InteractionResult.FAIL;
				}
				// Scanning damages the tool.
				damageTool(context, player);
				// Play sound, scan and play echo.
				soundScanEcho(delayedExecute);
			}
		}
		return InteractionResult.SUCCESS;
	}

	/**
	 * @return Max detection range.
	 * <p>
	 * Valid values: 1..
	 */
	protected abstract int getRange();

	/**
	 * @return Focus.
	 * <p>
	 * Valid values: 1..4
	 */
	protected int getFocus() {
		return focus;
	}

	/**
	 * Check one block.
	 * <p>
	 * Set {@link #distance} to {@code distance}, and set echo properties if detected anything.
	 *
	 * @param pos Check block at this position.
	 * @return true if detected something.
	 */
	protected abstract boolean detect(BlockPos pos, int distance);

	/**
	 * Debug hook before calling {@link #detect(BlockPos, int)}.
	 */
	private boolean priDetect(BlockPos pos, int distance) {
		final boolean ret = detect(pos, distance);
		if (0 < debugLevel && ret) {
			Global.LOGGER.info("Found: {}, type: {}, at ({})",
				clickWorld.getBlockState(pos).getBlock(),
				type,
				pos.subtract(clickPos).toShortString());
		}
		if (2 < debugLevel && !ret) {
			// Replace the scanned and not detectable block with glass to see the detected block.
			clickWorld.setBlockAndUpdate(pos, Blocks.TINTED_GLASS.defaultBlockState());
		}
		return ret;
	}

	/**
	 * Translate {@code (x, y, z)} depending on the scanning direction.
	 *
	 * @return {@code (x,y,z)} translated.
	 */
	private Vec3i translate(int x, int y, int z) {
		return switch (clickFacing) {
			case DOWN -> new Vec3i(-x, -y, +z);
			case EAST -> new Vec3i(+y, -x, +z);
			case WEST -> new Vec3i(-y, +x, +z);
			case NORTH -> new Vec3i(+x, +z, -y);
			case SOUTH -> new Vec3i(+x, +z, +y);
			default -> new Vec3i(x, y, z);
		};
	}

	/**
	 * Call {@link #translate(int, int, int)} and then {@link #detect(BlockPos, int)}.
	 * <p>
	 * Set {@link #distance}, {@link #type} and the other echo properties according to the first detected block.
	 * <p>
	 * Called indirectly from {@link #scan()}.
	 *
	 * @param d Current scanning distance.
	 * @return true if anything is detected.
	 */
	private boolean transDetect(int x, int y, int z, int d) {
		return priDetect(clickPos.offset(translate(x, y, z)), d);
	}

	/**
	 * Rotate {@code (x,y,z)} in the 4 horizontal directions
	 * and call {@link #transDetect(int, int, int, int)}
	 * with each of them.
	 * <p>
	 * Called indirectly from {@link #scan()}.
	 *
	 * @param d Current scanning distance.
	 *          (Will be copied into {@link #distance} if anything is detected).
	 * @return true if anything is detected.
	 */
	private boolean transDetect4(int x, int y, int z, int d) {
		return (transDetect(+x, y, +z, d)) ||
			(transDetect(+z, y, -x, d)) ||
			(transDetect(-x, y, -z, d)) ||
			(transDetect(-z, y, +x, d));
	}

	/**
	 * Scan {@code 4*r} blocks at level {@code y} in a radius of {@code r}.
	 * <p>
	 * Example: Blocks to scan for r = [1..4] on the XZ plane.
	 * <pre>
	 *     4
	 *    434
	 *   43234
	 *  4321234
	 * 4321 1234
	 *  4321234
	 *   43234
	 *    434
	 *     4
	 * </pre>
	 * (r can be larger, but the picture shows scans only up to 4.)
	 * <p>
	 * Called indirectly from {@link #scan()}.
	 *
	 * @param y Y level.
	 * @param r Radius.
	 * @param d Current scanning distance.
	 *          (Will be copied into {@link #distance} if anything is detected).
	 * @return true if anything is detected.
	 */
	private boolean scanSquareYR(int y, int r, int d) {
		for (int x = 0; x < r; x++) {
			if (transDetect4(x, -y, r - x, d)) return true;
		}
		return false;
	}

	/**
	 * Scan blocks in a square at a distance of {@code d}.
	 * <p>
	 * Called from {@link #scan()}.
	 * <p>
	 * See also {@link #scanCenter}.
	 * <p>
	 * Example: Blocks to scan for d = [1..8] on the YX or YZ plane, when focus=1.
	 * <pre>
	 *     8
	 *     78
	 *    5678
	 *  2345678
	 * 012345678 <-- scanned by scanCenter
	 *  2345678
	 *    5678
	 *     78
	 *     8
	 * </pre>
	 * (d can be larger, but the picture shows scans only up to 8.)
	 * <p>
	 * Example: Blocks to scan for d = [1..4] on the YX or YZ plane, when focus=2.
	 * <pre>
	 *     678
	 *   345678
	 * 012345678 <-- scanned by scanCenter
	 *   345678
	 *     678
	 * </pre>
	 * (d can be larger, but the picture shows scans only up to 8.)
	 */
	private boolean scanSquare(int d) {
		for (int y = 0; y < d; y++) {
			int r = d - y;
			if (r <= y / getFocus()) {
				if (1 < debugLevel) {
					Global.LOGGER.info("Scanning square d={}, y={}, r={}", d, y, r);
				}
				if (scanSquareYR(y, r, d)) return true;
			}
		}
		return false;
	}

	/**
	 * Scan the block at the center at {@code y=-d} level.
	 * <p>
	 * Called from {@link #scan()}.
	 * <p>
	 * See also {@link #scanSquare(int)}.
	 */
	private boolean scanCenter(int d) {
		if (1 < debugLevel) {
			Global.LOGGER.info("Scanning center d={}, y={}", d, d);
		}
		return transDetect(0, -d, 0, d);
	}

	/**
	 * Scans blocks.
	 * <p>
	 * Also sets {@link #distance} and {@link #type} according to the first detected block.
	 *
	 * @return true if anything is detected.
	 */
	@SuppressWarnings("UnusedReturnValue")
	protected boolean scan() {
		final int range = getRange();
		for (int d = 0; d < range; d++) {
			if (scanCenter(d) || scanSquare(d)) return true;
		}
		return false;
	}

	/**
	 * Common echo calculations.
	 */
	protected void calcEcho(int type, int distance) {
		this.type = type;
		this.distance = distance;
		echoes = ModSounds.DETECTOR_3ECHOS[type];
		echoVolume = 1F - 0.9F * distance / getRange();
		echoDelay = 10 + 2 * distance;
		// For echos that do not generate particles.
		particleBlock = null;
	}

	/**
	 * Common echo and particle calculations.
	 */
	protected void calcEcho(int type, int distance, Block pBlock) {
		calcEcho(type, distance);
		final var config = ModConfig.getInstance();
		if (config.enableParticles) {
			particleBlock = new BlockParticleOption(
				ParticleTypes.BLOCK, pBlock.defaultBlockState());
			particleCount = (int) (40 * (1F - 0.9F * distance / getRange()));
		}
	}
}
