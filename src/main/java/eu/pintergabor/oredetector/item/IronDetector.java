package eu.pintergabor.oredetector.item;

import java.util.List;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.world.level.block.Blocks;


/**
 * Detect iron, gold, redstone and lapis ores.
 * <p>
 * plus Tech Reborn galena, tin, lead, ruby, sapphire, silver and bauxite.
 * <p>
 * plus Applied Energistics certus quartz.
 */
public class IronDetector extends DetectOreDetector {

	public IronDetector(Properties props, int focus) {
		super(props, focus);
		bangs = ModSounds.DETECTOR_3BANGS[2];
	}

	public IronDetector(Properties props) {
		this(props, 1);
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
			new DetectOreDetector.Echo(ModBlockTags.LAPIS, 12, Blocks.LAPIS_BLOCK)
		);
	}

	@Override
	public int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeVoidDetector;
	}
}
