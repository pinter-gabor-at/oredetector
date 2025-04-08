package eu.pintergabor.oredetector.item;

import java.util.List;

import eu.pintergabor.oredetector.config.ModConfigData;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.world.level.block.Blocks;


/**
 * Detect coal, copper and iron ores.
 * <p>
 * plus Tech Reborn galena, tin, lead, ruby and sapphire.
 * <p>
 * plus Applied Energistics certus quartz.
 */
public class CoalDetector extends DetectOreDetector {

	public CoalDetector(Properties props, int focus) {
		super(props, focus);
		bangs = ModSounds.DETECTOR_3BANGS[1].value();
	}

	public CoalDetector(Properties props) {
		this(props, 1);
	}

	{
		ECHOLIST = List.of(
			new Echo(ModBlockTags.COAL, 0, Blocks.COAL_BLOCK),
			new Echo(ImportBlockTags.C_GALENA_ORES, 1, null),
			new Echo(ImportBlockTags.C_TIN_ORES, 2, Blocks.IRON_BLOCK),
			new Echo(ImportBlockTags.C_LEAD_ORES, 3, Blocks.IRON_BLOCK),
			new Echo(ModBlockTags.COPPER, 4, Blocks.COPPER_BLOCK),
			new Echo(ModBlockTags.IRON, 5, Blocks.IRON_BLOCK),
			new Echo(ModBlockTags.QUARTZ, 6, Blocks.QUARTZ_BLOCK),
			new Echo(ImportBlockTags.C_CERTUS_QUARTZ_ORES, 6, Blocks.QUARTZ_BLOCK),
			new Echo(ImportBlockTags.C_RUBY_ORES, 7, null),
			new Echo(ImportBlockTags.C_SAPPHIRE_ORES, 7, null)
		);
	}

	@Override
	public int getRange() {
		return ModConfigData.rangeVoidDetector;
	}
}
