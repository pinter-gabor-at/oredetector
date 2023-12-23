package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;

import net.minecraft.util.math.BlockPos;

public class GoldDetector extends AbstractOreDetector {
	public GoldDetector(Settings settings) {
		super(settings);
	}

	@Override
	protected boolean detect(BlockPos pos, int distance) {
		return false;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeGoldDetector;
	}
}
