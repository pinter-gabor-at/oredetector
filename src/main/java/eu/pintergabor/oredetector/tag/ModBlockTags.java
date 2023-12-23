package eu.pintergabor.oredetector.tag;

import eu.pintergabor.oredetector.util.ModIdentifier;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
	private ModBlockTags() {
	}

	public static TagKey<Block> AIR;
	public static TagKey<Block> WATER;
	public static TagKey<Block> LAVA;

	@SuppressWarnings("unused")
	private static TagKey<Block> createBlockTag(String name) {
		return TagKey.of(RegistryKeys.BLOCK, new ModIdentifier(name));
	}

	@SuppressWarnings("unused")
	private static TagKey<Block> createCommonBlockTag(String name) {
		return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
	}

	public static void register() {
		AIR = createBlockTag("void_detect_0");
		WATER = createBlockTag("void_detect_1");
		LAVA = createBlockTag("void_detect_2");
	}
}
