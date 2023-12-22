package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.mixinutil.DelayedExecute;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public abstract class AbstractOreDetector extends Item {
	public AbstractOreDetector(Settings settings) {
		super(settings);
	}

	protected int distance;
	protected int type;

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		final var world = context.getWorld();
		final var pos = context.getBlockPos();
		final var player = context.getPlayer();
		final var stack = context.getStack();
		final var facing = context.getSide();
		if (!world.isClient()) {
			if (player != null) {
				// Cannot start new scanning while the previous one is still running
				if (((DelayedExecute) player).oredetector$isRunning()) {
					return ActionResult.FAIL;
				}
				// Scanning damages the tool
				if (!player.isCreative()) {
					stack.damage(1, player,
						(e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
				}
				// Everybody can hear the bangs on the server
				world.playSound(null, pos,
					ModSounds.DETECTOR_3BANGS, SoundCategory.BLOCKS,
					1f, 1f);
				// Scan
				if (scan(world, pos, facing)) {
					// Play echo delayed
					final float volume = 1f - 0.5f * distance / getRange();
					final var sound = ModSounds.DETECTOR_3ECHOS[type];
					((DelayedExecute) player)
						.oredetector$delayedExecute(10 + 2 * distance, () -> {
							world.playSound(null, pos,
								sound, SoundCategory.BLOCKS,
								volume, 1f);
						});
				}

			}
		}
		return ActionResult.SUCCESS;
	}

//	@Override
//	public ActionResult useOnBlock(ItemUsageContext context) {
//		final World world = context.getWorld();
//		final BlockPos pos = context.getBlockPos();
//		final BlockState clickedBlockState = world.getBlockState(pos);
//		final PlayerEntity player = context.getPlayer();
//		final ItemStack stack = context.getStack();
//		Direction clickedFace = context.getSide();
//		BlockPos markPosition = pos.offset(clickedFace);
//		if (world.isAir(markPosition) || world.getBlockState(markPosition).getBlock() instanceof ChalkMarkBlock) {
//			if (clickedBlockState.getBlock() instanceof ChalkMarkBlock) { // replace mark
//				clickedFace = clickedBlockState.get(ChalkMarkBlock.FACING);
//				markPosition = pos;
//				world.removeBlock(pos, false);
//			} else if (player != null &&
//				!Block.isFaceFullSquare(clickedBlockState.getCollisionShape(world, pos, ShapeContext.of(player)), clickedFace)) {
//				return ActionResult.PASS;
//			} else if ((!world.isAir(markPosition) && world.getBlockState(markPosition).getBlock() instanceof ChalkMarkBlock) || stack.getItem() != this) {
//				return ActionResult.PASS;
//			}
//
//			if (world.isClient) {
//				Random r = new Random();
//				if ((boolean) ConfigHelper.getConfig("emit_particles"))
//					world.addParticle(ParticleTypes.CLOUD, markPosition.getX() + (0.5 * (r.nextFloat() + 0.4)), markPosition.getY() + 0.65, markPosition.getZ() + (0.5 * (r.nextFloat() + 0.4)), 0.0D, 0.005D, 0.0D);
//				return ActionResult.SUCCESS;
//			}
//
//			final int orientation = getClickedRegion(context.getHitPos(), clickedFace);
//
//			BlockState blockState = getChalkMarkBlock().getDefaultState()
//				.with(ChalkMarkBlock.FACING, clickedFace)
//				.with(ChalkMarkBlock.ORIENTATION, orientation);
//
//			if (world.setBlockState(markPosition, blockState, 1 | 2)) {
//				if (player != null &&
//					!player.isCreative()) {
//					if (stack.getDamage() >= stack.getMaxDamage()) {
//						world.playSound(null, markPosition, SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 0.5f, 1f);
//					}
//					stack.damage(1, player, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
//				}
//
//				world.playSound(null, markPosition, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundCategory.BLOCKS, 0.6f, world.random.nextFloat() * 0.2f + 0.8f);
//				return ActionResult.CONSUME;
//			}
//		}
//		return ActionResult.FAIL;
//	}

	/**
	 * @return Max detection range
	 */
	protected abstract int getRange();

	/**
	 * Check one block
	 * @return -1 if not detectable, or 0..15 if detectable
	 */
	protected abstract int detect(BlockState blockState);

	/**
	 * Check one block with {@link #detect(BlockState)}
	 */
	private int detect(World world, BlockPos pos) {
		final BlockState blockState = world.getBlockState(pos);
		@SuppressWarnings("UnnecessaryLocalVariable")
		final int ret = detect(blockState);
		// DEBUG: Write the block type into the log
		// if (0 <= ret) Global.LOGGER.info("Found: {}, type: {}", blockState.getBlock().toString(), ret);
		// DEBUG: Replace the scanned and not detectable blocks with glass to see the detected block
		// if (ret < 0) world.setBlockState(pos, Blocks.GLASS.getDefaultState(), Block.NOTIFY_ALL);
		return ret;
	}

	/**
	 * Translate {@code x}, {@code y}, {@code z} depending on the scanning direction
	 * @param facing Direction of blockface clicked (= opposit of scanning)
	 * @return {@code x}, {@code y}, {@code z} translated
	 */
	private Vec3i translate(int x, int y, int z, Direction facing) {
		return switch (facing) {
			default -> new Vec3i(x, y, z);
			case DOWN -> new Vec3i(-x, -y, +z);
			case EAST -> new Vec3i(+y, -x, +z);
			case WEST -> new Vec3i(-y, +x, +z);
			case NORTH -> new Vec3i(+x, +z, -y);
			case SOUTH -> new Vec3i(+x, +z, +y);
		};
	}

	/**
	 * Call {@link #translate(int, int, int, Direction)} and then {@link #detect(World, BlockPos)}
	 * <p>
	 * Set {@link #distance} and {@link #type} according to the first detected block.
	 * @param d Current scanning distance (Will be copied into {@link #distance} if detected anything)
	 * @return true if detected anything
	 */
	private boolean transDetect(World world, BlockPos pos, int x, int y, int z, Direction facing, int d) {
		final int t = detect(world, pos.add(translate(x, y, z, facing)));
		if (t < 0) return false;
		distance = d;
		type = t;
		return true;
	}

	/**
	 * Rotate {@code (x,y,z)} in the 4 horizontal directions and call
	 * {@link #transDetect(World, BlockPos, int, int, int, Direction, int)} with each of them
	 * @param d Current scanning distance (Will be copied into {@link #distance} if detected anything)
	 * @return true if detected anything
	 */
	private boolean transDetect4(World world, BlockPos pos, int x, int y, int z, Direction facing, int d) {
		return (transDetect(world, pos, +x, y, +z, facing, d)) ||
			(transDetect(world, pos, +z, y, -x, facing, d)) ||
			(transDetect(world, pos, -x, y, -z, facing, d)) ||
			(transDetect(world, pos, -z, y, +x, facing, d));
	}

	/**
	 * Scans blocks
	 * <p>
	 * Also sets {@link ##distance} and {@link ##type} according to the first detected block.
	 * @param pos Starting position
	 * @param facing Direction of blockface clicked (= opposit of scanning)
	 * @return true if detected anything
	 */
	@SuppressWarnings("UnusedReturnValue")
	protected boolean scan(World world, BlockPos pos, Direction facing) {
		final int range = getRange();
		for (int d = 0; d < range; d++) {
			// Center
			if (transDetect(world, pos, 0, -d, 0, facing, d)) return true;
			// Square
			for (int y = 0; y < d; y++) {
				// Only for even numbers
				if (((d - y) & 1) == 0) {
					final int n = (d - y) / 2;
					for (int x = 0; x < n; x++) {
						if (transDetect4(world, pos, x, -y, n - x, facing, d)) return true;
					}
				}
			}
		}
		return false;
	}
}

