package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;

import net.minecraft.block.BlockState;

public class GoldDetector extends AbstractOreDetector {
	public GoldDetector(Settings settings) {
		super(settings);
	}

	@Override
	protected int detect(BlockState blockState) {
		return -1;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeGoldDetector;
	}
}
