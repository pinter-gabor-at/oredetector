package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VoidDetector extends AbstractOreDetector {
	public VoidDetector(Settings settings) {
		super(settings);
	}

	@Override
	public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
		super.usageTick(world, user, stack, remainingUseTicks);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		return super.finishUsing(stack, world, user);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		final var world = context.getWorld();
		BlockPos positionClicked = context.getBlockPos();
		PlayerEntity player = context.getPlayer();
		if (!world.isClient()) {
//			world.playSound(null, positionClicked,
//				ModSounds.DETECTOR_3BANGS, SoundCategory.BLOCKS,
//				1f, 1f);
		} else {
			world.playSoundAtBlockCenter(positionClicked,
				ModSounds.DETECTOR_3BANGS, SoundCategory.BLOCKS,
				1f, 1f, true);
		}
		return ActionResult.CONSUME;
	}
}
