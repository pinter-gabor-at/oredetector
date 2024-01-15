package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

public class DiamondDetector extends AbstractOreDetector {
	public DiamondDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[4];
	}

	/**
	 * Detect only diamond, emerald and netherite ores
	 * <p>
	 * plus Tech Reborn iridium, pyrite, cinnabar, sphalerite, tungsten, sheldonite, peridot and sodalite
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(ModBlockTags.DIAMOND)) {
			calcEcho(13, distance, Blocks.DIAMOND_BLOCK);
		} else if (blockState.isIn(ImportBlockTags.C_IRIDIUM_ORES)) {
			calcEcho(14, distance, Blocks.IRON_BLOCK);
		} else if (blockState.isIn(ModBlockTags.EMERALD)) {
			calcEcho(15, distance, Blocks.EMERALD_BLOCK);
		} else if (blockState.isIn(ModBlockTags.NETHER)) {
			calcEcho(1, distance, Blocks.NETHERITE_BLOCK);
		} else if (blockState.isIn(ImportBlockTags.C_PYRITE_ORES)) {
			calcEcho(2, distance, blockState.getBlock());
		} else if (blockState.isIn(ImportBlockTags.C_CINNABAR_ORES)) {
			calcEcho(3, distance, blockState.getBlock());
		} else if (blockState.isIn(ImportBlockTags.C_SPHALERITE_ORES)) {
			calcEcho(4, distance, blockState.getBlock());
		} else if (blockState.isIn(ImportBlockTags.C_TUNGSTEN_ORES)) {
			calcEcho(7, distance, blockState.getBlock());
		} else if (blockState.isIn(ImportBlockTags.C_SHELDONITE_ORES)) {
			calcEcho(8, distance, blockState.getBlock());
		} else if (blockState.isIn(ImportBlockTags.C_PERIDOT_ORES)) {
			calcEcho(9, distance, blockState.getBlock());
		} else if (blockState.isIn(ImportBlockTags.C_SODALITE_ORES)) {
			calcEcho(10, distance, blockState.getBlock());
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
