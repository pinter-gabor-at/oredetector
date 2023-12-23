package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;

import net.minecraft.util.math.BlockPos;

public class CoalDetector extends AbstractOreDetector {
	public CoalDetector(Settings settings) {
		super(settings);
	}

	@Override
	protected boolean detect(BlockPos pos, int distance) {
		return false;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeCoalDetector;
	}
}
