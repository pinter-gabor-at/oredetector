package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

public class VoidDetector extends AbstractOreDetector {
	public VoidDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[0];
	}

	/**
	 * Detect air, water, lava and other non-solid blocks
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(ModBlockTags.AIR) || blockState.isAir()) {
			calcEcho(0, distance, Blocks.SNOW);
		} else if (blockState.isIn(ModBlockTags.WATER)) {
			calcEcho(2, distance, Blocks.WATER);
		} else if (blockState.isIn(ModBlockTags.LAVA)) {
			calcEcho(3, distance, Blocks.LAVA);
		} else if (!blockState.getFluidState().isEmpty()) {
			// Some fluid, which is not water or lava
			calcEcho(4, distance, Blocks.WATER);
		} else if (!blockState.isOpaqueFullCube(clickWorld, clickPos)) {
			// Something partly transparent
			calcEcho(1, distance, Blocks.GRASS);
		} else {
			return false;
		}
		return true;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeVoidDetector;
	}
}
