package eu.pintergabor.oredetector.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


/**
 * Conventional block tags from popular mods
 */
public final class ImportBlockTags {
	// Tech Reborn, Overworld.
	// https://wiki.techreborn.ovh/doku.php?id=world_generation:ore
	public static TagKey<Block> C_GALENA_ORES;
	public static TagKey<Block> C_IRIDIUM_ORES;
	public static TagKey<Block> C_RUBY_ORES;
	public static TagKey<Block> C_SAPPHIRE_ORES;
	public static TagKey<Block> C_BAUXITE_ORES;
	public static TagKey<Block> C_LEAD_ORES;
	public static TagKey<Block> C_SILVER_ORES;
	public static TagKey<Block> C_TIN_ORES;
	// Tech Reborn, The Nether.
	// https://wiki.techreborn.ovh/doku.php?id=world_generation:ore
	public static TagKey<Block> C_PYRITE_ORES;
	public static TagKey<Block> C_CINNABAR_ORES;
	public static TagKey<Block> C_SPHALERITE_ORES;
	// Tech Reborn, Overworld.
	// https://wiki.techreborn.ovh/doku.php?id=world_generation:ore
	public static TagKey<Block> C_TUNGSTEN_ORES;
	public static TagKey<Block> C_SHELDONITE_ORES;
	public static TagKey<Block> C_PERIDOT_ORES;
	public static TagKey<Block> C_SODALITE_ORES;
	// Applied Energistics 2.
	public static TagKey<Block> C_CERTUS_QUARTZ_ORES;

	@SuppressWarnings("unused")
	public static TagKey<Block> createCommonBlockTag(String name) {
		return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
	}

	public static void init() {
		// Tech Reborn, Overworld.
		// https://wiki.techreborn.ovh/doku.php?id=world_generation:ore
		C_GALENA_ORES = createCommonBlockTag("galena_ores");
		C_IRIDIUM_ORES = createCommonBlockTag("iridium_ores");
		C_RUBY_ORES = createCommonBlockTag("ruby_ores");
		C_SAPPHIRE_ORES = createCommonBlockTag("sapphire_ores");
		C_BAUXITE_ORES = createCommonBlockTag("bauxite_ores");
		C_LEAD_ORES = createCommonBlockTag("lead_ores");
		C_SILVER_ORES = createCommonBlockTag("silver_ores");
		C_TIN_ORES = createCommonBlockTag("tin_ores");
		// Tech Reborn, The Nether.
		// https://wiki.techreborn.ovh/doku.php?id=world_generation:ore
		C_PYRITE_ORES = createCommonBlockTag("pyrite_ores");
		C_CINNABAR_ORES = createCommonBlockTag("cinnabar_ores");
		C_SPHALERITE_ORES = createCommonBlockTag("sphalerite_ores");
		// Tech Reborn, Overworld.
		// https://wiki.techreborn.ovh/doku.php?id=world_generation:ore
		C_TUNGSTEN_ORES = createCommonBlockTag("tungsten_ores");
		C_SHELDONITE_ORES = createCommonBlockTag("sheldonite_ores");
		C_PERIDOT_ORES = createCommonBlockTag("peridot_ores");
		C_SODALITE_ORES = createCommonBlockTag("sodalite_ores");
		// Applied Energistics 2.
		C_CERTUS_QUARTZ_ORES = createCommonBlockTag("certus_quartz_ores");
	}
}
