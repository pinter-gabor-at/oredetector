package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import org.jetbrains.annotations.NotNull;

/**
 * {@link AbstractOreDetector} + lots of detect utilities
 */
public abstract class DetectOreDetector extends AbstractOreDetector {
	public DetectOreDetector(Settings settings) {
		super(settings);
	}

	/**
	 * Coal
	 */
	protected boolean detectCoal(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.COAL)) {
			calcEcho(0, distance, Blocks.COAL_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Galena
	 */
	protected boolean detectGalena(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_GALENA_ORES)) {
			calcEcho(1, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Tin
	 */
	protected boolean detectTin(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_TIN_ORES)) {
			calcEcho(2, distance, Blocks.IRON_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Lead
	 */
	protected boolean detectLead(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_LEAD_ORES)) {
			calcEcho(3, distance, Blocks.IRON_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Copper
	 */
	protected boolean detectCopper(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.COPPER)) {
			calcEcho(4, distance, Blocks.COPPER_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Iron
	 */
	protected boolean detectIron(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.IRON)) {
			calcEcho(5, distance, Blocks.IRON_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Quartz
	 */
	protected boolean detectQuartz(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.QUARTZ) ||
			blockState.isIn(ImportBlockTags.C_CERTUS_QUARTZ_ORES)) {
			calcEcho(6, distance, Blocks.QUARTZ_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Ruby and sapphire
	 */
	protected boolean detectRuby(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_RUBY_ORES) ||
			blockState.isIn(ImportBlockTags.C_SAPPHIRE_ORES)) {
			calcEcho(7, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Bauxite
	 */
	protected boolean detectBauxite(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_BAUXITE_ORES)) {
			calcEcho(8, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Silver
	 */
	protected boolean detectSilver(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_SILVER_ORES)) {
			calcEcho(9, distance, Blocks.IRON_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Gold
	 */
	protected boolean detectGold(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.GOLD)) {
			calcEcho(10, distance, Blocks.GOLD_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Redstone
	 */
	protected boolean detectRedstone(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.REDSTONE)) {
			calcEcho(11, distance, Blocks.REDSTONE_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Lapis
	 */
	protected boolean detectLapis(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.LAPIS)) {
			calcEcho(12, distance, Blocks.LAPIS_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Diamond
	 */
	protected boolean detectDiamond(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.DIAMOND)) {
			calcEcho(13, distance, Blocks.DIAMOND_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Iridium
	 */
	protected boolean detectIridium(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_IRIDIUM_ORES)) {
			calcEcho(14, distance, Blocks.IRON_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Emerald
	 */
	protected boolean detectEmerald(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.EMERALD)) {
			calcEcho(15, distance, Blocks.EMERALD_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Nether stuff
	 */
	protected boolean detectNether(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.NETHER)) {
			calcEcho(1, distance, Blocks.NETHERITE_BLOCK);
			return true;
		}
		return false;
	}

	/**
	 * Pyrite
	 */
	protected boolean detectPyrite(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_PYRITE_ORES)) {
			calcEcho(2, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Cinnabar
	 */
	protected boolean detectCinnabar(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_CINNABAR_ORES)) {
			calcEcho(3, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Sphalerite
	 */
	protected boolean detectSphalerite(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_SPHALERITE_ORES)) {
			calcEcho(4, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Tungsten
	 */
	protected boolean detectTungsten(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_TUNGSTEN_ORES)) {
			calcEcho(7, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Sheldonite
	 */
	protected boolean detectSheldonite(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_SHELDONITE_ORES)) {
			calcEcho(8, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Peridot
	 */
	protected boolean detectPeridot(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_PERIDOT_ORES)) {
			calcEcho(9, distance, blockState.getBlock());
			return true;
		}
		return false;
	}

	/**
	 * Sodalite
	 */
	protected boolean detectSodalite(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ImportBlockTags.C_SODALITE_ORES)) {
			calcEcho(10, distance, blockState.getBlock());
			return true;
		}
		return false;
	}
}
