package eu.pintergabor.oredetector.item;

import java.util.List;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.world.level.block.Blocks;


/**
 * Detect only diamond, emerald and netherite ores.
 * <p>
 * plus Tech Reborn iridium, pyrite, cinnabar, sphalerite, tungsten, sheldonite, peridot and sodalite.
 */
public class DiamondDetector extends DetectOreDetector {

	public DiamondDetector(Properties props, int focus) {
		super(props, focus);
		bangs = ModSounds.DETECTOR_3BANGS[4];
	}

	public DiamondDetector(Properties props) {
		this(props, 1);
	}

	{
		ECHOLIST = List.of(
			new DetectOreDetector.Echo(ModBlockTags.DIAMOND, 13, Blocks.DIAMOND_BLOCK),
			new DetectOreDetector.Echo(ImportBlockTags.C_IRIDIUM_ORES, 14, Blocks.LAPIS_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.EMERALD, 15, Blocks.EMERALD_BLOCK),
			new DetectOreDetector.Echo(ModBlockTags.NETHER, 1, Blocks.NETHERITE_BLOCK),
			new DetectOreDetector.Echo(ImportBlockTags.C_PYRITE_ORES, 2, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_CINNABAR_ORES, 3, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_SPHALERITE_ORES, 4, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_TUNGSTEN_ORES, 7, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_SHELDONITE_ORES, 8, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_PERIDOT_ORES, 9, null),
			new DetectOreDetector.Echo(ImportBlockTags.C_SODALITE_ORES, 10, null)
		);
	}

	@Override
	public int getRange() {
		final ModConfig config = ModConfig.getInstance();
		return config.rangeDiamondDetector;
	}
}
