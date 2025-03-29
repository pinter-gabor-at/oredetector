package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

/**
 * Detect air, water, lava and other non-solid blocks.
 */
public class VoidDetector extends AbstractOreDetector {

	public VoidDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[0];
	}

	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(ModBlockTags.AIR) || blockState.isAir()) {
			calcEcho(0, distance, Blocks.SNOW);
			return true;
		}
		if (blockState.isIn(ModBlockTags.WATER)) {
			calcEcho(2, distance, Blocks.WATER);
			return true;
		}
		if (blockState.isIn(ModBlockTags.LAVA)) {
			calcEcho(3, distance, Blocks.LAVA);
			return true;
		}
		if (!blockState.getFluidState().isEmpty()) {
			// Some fluid, which is not water or lava
			calcEcho(4, distance, Blocks.WATER);
			return true;
		}
		if (!blockState.isOpaqueFullCube()) {
			// Something partly transparent
			calcEcho(1, distance, Blocks.SHORT_GRASS);
			return true;
		}
		return false;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeVoidDetector;
	}
}
