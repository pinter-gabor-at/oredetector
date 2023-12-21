package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.main.ClientTick;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class VoidDetector extends AbstractOreDetector {
	public VoidDetector(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		final var world = context.getWorld();
		BlockPos positionClicked = context.getBlockPos();
		if (!world.isClient()) {
			// Everybody can hear the bangs on the server
			world.playSound(null, positionClicked,
				ModSounds.DETECTOR_3BANGS, SoundCategory.BLOCKS,
				1f, 1f);
		} else {
			// But only the player can hear the echo on the client
			synchronized (ClientTick.class) {
				ClientTick.delay = 40;
				ClientTick.position = positionClicked;
				ClientTick.sound = ModSounds.DETECTOR_3ECHOS[14];
				ClientTick.volume = 0.9f;
				ClientTick.pitch = 1f;
			}
		}
		return ActionResult.SUCCESS;
	}
}
