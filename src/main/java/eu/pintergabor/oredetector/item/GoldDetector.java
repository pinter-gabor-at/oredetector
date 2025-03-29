package eu.pintergabor.oredetector.item;

import java.util.List;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.Blocks;


/**
 * Detect gold, redstone, lapis, diamond, and emerald.
 * <p>
 * plus Tech Reborn silver and iridium.
 */
public class GoldDetector extends DetectOreDetector {
	public GoldDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[3];
	}

	{
		ECHOLIST = List.of(
			new DetectOreDetector.Echo(ImportBlockTags.C_GALENA_ORES, 1, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_TIN_ORES, 2, Blocks.IRON_BLOCK),
			new DetectOreDetector.Echo(ImportBlockTags.C_LEAD_ORES, 3, Blocks.IRON_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.COPPER, 4, Blocks.COPPER_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.IRON, 5, Blocks.IRON_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.QUARTZ, 6, Blocks.QUARTZ_BLOCK),
			new DetectOreDetector.Echo(ImportBlockTags.C_CERTUS_QUARTZ_ORES, 6, Blocks.QUARTZ_BLOCK),
			new DetectOreDetector.Echo(ImportBlockTags.C_RUBY_ORES, 7, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_SAPPHIRE_ORES, 7, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_BAUXITE_ORES, 8, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_SILVER_ORES, 9, Blocks.IRON_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.GOLD, 10, Blocks.GOLD_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.REDSTONE, 11, Blocks.REDSTONE_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.LAPIS, 12, Blocks.LAPIS_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.DIAMOND, 13, Blocks.DIAMOND_BLOCK),
			new DetectOreDetector.Echo(ImportBlockTags.C_IRIDIUM_ORES, 14, Blocks.LAPIS_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.EMERALD, 15, Blocks.EMERALD_BLOCK)
		);
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeGoldDetector;
	}
}
