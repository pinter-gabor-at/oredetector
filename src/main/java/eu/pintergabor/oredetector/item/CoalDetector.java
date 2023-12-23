package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class CoalDetector extends AbstractOreDetector {
	public CoalDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[1];
	}

	/**
	 * Detect coal, copper and iron ores
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(BlockTags.COAL_ORES) || blockState.isIn(ModBlockTags.COAL)) {
			calcEcho(5, distance, Blocks.COAL_BLOCK);
		} else if (blockState.isIn(BlockTags.COPPER_ORES) || blockState.isIn(ModBlockTags.COPPER)) {
			calcEcho(6, distance, Blocks.COPPER_BLOCK);
		} else if (blockState.isIn(BlockTags.IRON_ORES) || blockState.isIn(ModBlockTags.IRON)) {
			calcEcho(7, distance, Blocks.IRON_BLOCK);
		} else {
			return false;
		}
		return true;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeCoalDetector;
	}
}
