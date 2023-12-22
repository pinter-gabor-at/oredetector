package eu.pintergabor.oredetector.tag;

import java.util.ArrayList;

import eu.pintergabor.oredetector.util.ModIdentifier;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
	private ModBlockTags() {
	}


	public static TagKey<Block> VOID_DETECT0;
	public static TagKey<Block> VOID_DETECT1;
	public static TagKey<Block> VOID_DETECT2;

	@SuppressWarnings("unused")
	private static TagKey<Block> createBlockTag(String name) {
		return TagKey.of(RegistryKeys.BLOCK, new ModIdentifier(name));
	}

	@SuppressWarnings("unused")
	private static TagKey<Block> createCommonBlockTag(String name) {
		return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
	}

	public static void register() {
		VOID_DETECT0 = createBlockTag("void_detect_0");
		VOID_DETECT1 = createBlockTag("void_detect_1");
		VOID_DETECT2 = createBlockTag("void_detect_2");
	}
}
