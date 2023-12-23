package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class DiamondDetector extends AbstractOreDetector {
	public DiamondDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[4];
	}

	/**
	 * Detect only diamond, emerald and netherite ores
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(BlockTags.DIAMOND_ORES) || blockState.isIn(ModBlockTags.DIAMOND)) {
			calcEcho(11, distance, Blocks.DIAMOND_BLOCK);
		} else if (blockState.isIn(BlockTags.EMERALD_ORES) || blockState.isIn(ModBlockTags.EMERALD)) {
			calcEcho(12, distance, Blocks.EMERALD_BLOCK);
		} else if (blockState.isIn(ModBlockTags.NETHER)) {
			calcEcho(13, distance, Blocks.NETHERITE_BLOCK);
		} else {
			return false;
		}
		return true;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeDiamondDetector;
	}
}
