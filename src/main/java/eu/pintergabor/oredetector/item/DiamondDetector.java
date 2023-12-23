package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;

import net.minecraft.util.math.BlockPos;

public class DiamondDetector extends AbstractOreDetector {
	public DiamondDetector(Settings settings) {
		super(settings);
	}

	@Override
	protected boolean detect(BlockPos pos, int distance) {
		return false;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeDiamondDetector;
	}
}
