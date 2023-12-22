package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;

public class VoidDetector extends AbstractOreDetector {
	public VoidDetector(Settings settings) {
		super(settings);
	}

	@Override
	protected int detect(BlockState blockState) {
		if (blockState.isIn(ModBlockTags.VOID_DETECT0) || blockState.isAir()) {
			return 0;
		}
		if (blockState.isIn(ModBlockTags.VOID_DETECT1)) {
			return 4;
		}
		if (blockState.isIn(ModBlockTags.VOID_DETECT2)) {
			return 8;
		}
		return -1;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeVoidDetector;
	}
}
