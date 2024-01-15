package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

public class CoalDetector extends AbstractOreDetector {
	public CoalDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[1];
	}

	/**
	 * Detect coal, copper and iron ores
	 * <p>
	 * plus Tech Reborn galena, tin, lead, ruby and sapphire
	 * <p>
	 * plus Applied Energistics certus quartz
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(ModBlockTags.COAL)) {
			calcEcho(0, distance, Blocks.COAL_BLOCK);
		} else if (blockState.isIn(ImportBlockTags.C_GALENA_ORES)) {
			calcEcho(1, distance, blockState.getBlock());
		} else if (blockState.isIn(ImportBlockTags.C_TIN_ORES)) {
			calcEcho(2, distance, Blocks.IRON_BLOCK);
		} else if (blockState.isIn(ImportBlockTags.C_LEAD_ORES)) {
			calcEcho(3, distance, Blocks.IRON_BLOCK);
		} else if (blockState.isIn(ModBlockTags.COPPER)) {
			calcEcho(4, distance, Blocks.COPPER_BLOCK);
		} else if (blockState.isIn(ModBlockTags.IRON)) {
			calcEcho(5, distance, Blocks.IRON_BLOCK);
		} else if (blockState.isIn(ModBlockTags.QUARTZ) ||
			blockState.isIn(ImportBlockTags.C_CERTUS_QUARTZ_ORES)) {
			calcEcho(6, distance, Blocks.QUARTZ_BLOCK);
		} else if (blockState.isIn(ImportBlockTags.C_RUBY_ORES) ||
			blockState.isIn(ImportBlockTags.C_SAPPHIRE_ORES)) {
			calcEcho(7, distance, blockState.getBlock());
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
