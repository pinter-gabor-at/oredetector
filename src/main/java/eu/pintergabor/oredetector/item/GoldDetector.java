package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class GoldDetector extends AbstractOreDetector {
	public GoldDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[3];
	}

	/**
	 * Detect gold, redstone, lapis, diamond, emerald and netherite ores
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(BlockTags.IRON_ORES) || blockState.isIn(ModBlockTags.IRON)) {
			calcEcho(7, distance, Blocks.IRON_BLOCK);
		} else if (blockState.isIn(BlockTags.GOLD_ORES) || blockState.isIn(ModBlockTags.GOLD)) {
			calcEcho(8, distance, Blocks.GOLD_BLOCK);
		} else if (blockState.isIn(BlockTags.REDSTONE_ORES) || blockState.isIn(ModBlockTags.REDSTONE)) {
			calcEcho(9, distance, Blocks.REDSTONE_BLOCK);
		} else if (blockState.isIn(BlockTags.LAPIS_ORES) || blockState.isIn(ModBlockTags.LAPIS)) {
			calcEcho(10, distance, Blocks.LAPIS_BLOCK);
		} else if (blockState.isIn(BlockTags.DIAMOND_ORES) || blockState.isIn(ModBlockTags.DIAMOND)) {
			calcEcho(11, distance, Blocks.DIAMOND_BLOCK);
		} else if (blockState.isIn(BlockTags.EMERALD_ORES) || blockState.isIn(ModBlockTags.EMERALD)) {
			calcEcho(12, distance, Blocks.EMERALD_BLOCK);
		} else {
			return false;
		}
		return true;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeGoldDetector;
	}
}
