package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

public class IronDetector extends AbstractOreDetector {
	public IronDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[2];
	}

	/**
	 * Detect iron, gold, redstone and lapis ores
	 * <p>
	 * plus Tech Reborn galena, tin, lead, ruby, sapphire, silver and bauxite
	 * <p>
	 * plus Applied Energistics certus quartz
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(ImportBlockTags.C_GALENA_ORES)) {
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
		} else if (blockState.isIn(ImportBlockTags.C_BAUXITE_ORES)) {
			calcEcho(8, distance, blockState.getBlock());
		} else if (blockState.isIn(ImportBlockTags.C_SILVER_ORES)) {
			calcEcho(9, distance, Blocks.IRON_BLOCK);
		} else if (blockState.isIn(ModBlockTags.GOLD)) {
			calcEcho(10, distance, Blocks.GOLD_BLOCK);
		} else if (blockState.isIn(ModBlockTags.REDSTONE)) {
			calcEcho(11, distance, Blocks.REDSTONE_BLOCK);
		} else if (blockState.isIn(ModBlockTags.LAPIS)) {
			calcEcho(12, distance, Blocks.LAPIS_BLOCK);
		} else {
			return false;
		}
		return true;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeIronDetector;
	}
}
