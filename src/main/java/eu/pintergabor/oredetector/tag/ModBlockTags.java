package eu.pintergabor.oredetector.tag;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.datagen.ModBlockTagProvider;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;


/**
 * Primary block tags of this mod.
 * <p>
 * See {@link ModBlockTagProvider}.
 */
public final class ModBlockTags {
	public static TagKey<Block> AIR;
	public static TagKey<Block> WATER;
	public static TagKey<Block> LAVA;
	public static TagKey<Block> COAL;
	public static TagKey<Block> COPPER;
	public static TagKey<Block> IRON;
	public static TagKey<Block> GOLD;
	public static TagKey<Block> REDSTONE;
	public static TagKey<Block> LAPIS;
	public static TagKey<Block> DIAMOND;
	public static TagKey<Block> EMERALD;
	public static TagKey<Block> QUARTZ;
	public static TagKey<Block> NETHER;

	public static TagKey<Block> createBlockTag(String name) {
		return TagKey.create(Registries.BLOCK, Global.modId(name));
	}

	public static void init() {
		AIR = createBlockTag("air");
		WATER = createBlockTag("water");
		LAVA = createBlockTag("lava");
		COAL = createBlockTag("coal");
		COPPER = createBlockTag("copper");
		IRON = createBlockTag("iron");
		GOLD = createBlockTag("gold");
		REDSTONE = createBlockTag("redstone");
		LAPIS = createBlockTag("lapis");
		DIAMOND = createBlockTag("diamond");
		EMERALD = createBlockTag("emerald");
		QUARTZ = createBlockTag("quartz");
		NETHER = createBlockTag("nether");
	}
}
