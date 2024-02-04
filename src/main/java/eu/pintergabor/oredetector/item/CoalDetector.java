package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CoalDetector extends DetectOreDetector {
	public CoalDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[1];
	}

	/**
	 * Detect coal, copper and iron ores
	 * <p>
	 * plus Tech Reborn galena, tin, lead, ruby and sapphire
	 * <p>
	 * plus Applied Energistics certus quartz
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		return detectCoal(blockState, distance) ||
			detectGalena(blockState, distance) ||
			detectTin(blockState, distance) ||
			detectLead(blockState, distance) ||
			detectCopper(blockState, distance) ||
			detectIron(blockState, distance) ||
			detectQuartz(blockState, distance) ||
			detectRuby(blockState, distance);
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeCoalDetector;
	}
}
