package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfigData;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


/**
 * Detect air, water, lava and other non-solid blocks.
 */
public class VoidDetector extends AbstractOreDetector {

	public VoidDetector(Properties props, int focus) {
		super(props, focus);
		bangs = ModSounds.DETECTOR_3BANGS[0].value();
	}

	public VoidDetector(Properties props) {
		this(props, 1);
	}

	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.is(ModBlockTags.AIR) || blockState.isAir()) {
			calcEcho(0, distance, Blocks.SNOW);
			return true;
		}
		if (blockState.is(ModBlockTags.WATER)) {
			calcEcho(2, distance, Blocks.WATER);
			return true;
		}
		if (blockState.is(ModBlockTags.LAVA)) {
			calcEcho(3, distance, Blocks.LAVA);
			return true;
		}
		if (!blockState.getFluidState().isEmpty()) {
			// Some fluid, which is not water or lava.
			calcEcho(4, distance, Blocks.WATER);
			return true;
		}
		if (!blockState.isSolidRender()) {
			// Something partly transparent.
			calcEcho(1, distance, Blocks.SHORT_GRASS);
			return true;
		}
		return false;
	}

	@Override
	public int getRange() {
		return ModConfigData.rangeVoidDetector;
	}
}
