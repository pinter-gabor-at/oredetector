package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

public class GoldDetector extends AbstractOreDetector {
	public GoldDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[3];
	}

	/**
	 * Detect gold, redstone, lapis, diamond, and emerald
	 * <p>
	 * plus Tech Reborn silver and iridium
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(ImportBlockTags.C_SILVER_ORES)) {
			calcEcho(9, distance, Blocks.IRON_BLOCK);
		} else if (blockState.isIn(ModBlockTags.GOLD)) {
			calcEcho(10, distance, Blocks.GOLD_BLOCK);
		} else if (blockState.isIn(ModBlockTags.REDSTONE)) {
			calcEcho(11, distance, Blocks.REDSTONE_BLOCK);
		} else if (blockState.isIn(ModBlockTags.LAPIS)) {
			calcEcho(12, distance, Blocks.LAPIS_BLOCK);
		} else if (blockState.isIn(ModBlockTags.DIAMOND)) {
			calcEcho(13, distance, Blocks.DIAMOND_BLOCK);
		} else if (blockState.isIn(ImportBlockTags.C_IRIDIUM_ORES)) {
			calcEcho(14, distance, Blocks.IRON_BLOCK);
		} else if (blockState.isIn(ModBlockTags.EMERALD)) {
			calcEcho(15, distance, Blocks.EMERALD_BLOCK);
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
