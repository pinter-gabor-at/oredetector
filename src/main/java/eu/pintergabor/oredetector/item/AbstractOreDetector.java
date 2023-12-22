package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.main.ServerTick;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

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
			if (player != null &&
				!player.isCreative()) {
				stack.damage(1, player,
					(e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
			}
			// Everybody can hear the bangs on the server
			world.playSound(null, pos,
				ModSounds.DETECTOR_3BANGS, SoundCategory.BLOCKS,
				1f, 1f);
			ServerTick.delayedExecute((ServerWorld) world, 40, () ->{
				world.playSound(null, pos,
				ModSounds.DETECTOR_3ECHOS[14], SoundCategory.BLOCKS,
					0.5f, 1f);
			});
//			synchronized (ServerTick.class) {
//				ServerTick.delay = 40;
//				ServerTick.pos = pos;
//				ServerTick.sound = ModSounds.DETECTOR_3ECHOS[14];
//				ServerTick.volume = 0.9f;
//				ServerTick.pitch = 1f;
//			}
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
	 * Scans blocks
	 * <p>
	 * Also sets {@link ##distance} and {@link ##type} according to the first detectable block.
	 * @param pos Starting position
	 * @param facing Direction of scanning
	 * @return true if detected anything
	 */
	protected abstract boolean isDetectable(BlockPos pos, Direction facing);

}

