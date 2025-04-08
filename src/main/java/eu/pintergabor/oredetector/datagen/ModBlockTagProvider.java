package eu.pintergabor.oredetector.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.tag.ModBlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;


public class ModBlockTagProvider extends BlockTagsProvider {

	public ModBlockTagProvider(
		PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, Global.MODID);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
		tag(ModBlockTags.AIR)
			.add(Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR);
		tag(ModBlockTags.WATER)
			.add(Blocks.WATER, Blocks.WATER_CAULDRON);
		tag(ModBlockTags.LAVA)
			.add(Blocks.LAVA, Blocks.LAVA_CAULDRON);
		tag(ModBlockTags.COAL)
			.addTag(Tags.Blocks.ORES_COAL)
			.addTag(BlockTags.COAL_ORES)
			.add(Blocks.COAL_BLOCK, Blocks.TORCH);
		tag(ModBlockTags.COPPER)
			.addTag(Tags.Blocks.ORES_COPPER)
			.addTag(BlockTags.COPPER_ORES)
			.add(
				Blocks.COPPER_BLOCK, Blocks.RAW_COPPER_BLOCK,
				Blocks.COPPER_GRATE,
				Blocks.COPPER_DOOR, Blocks.COPPER_TRAPDOOR,
				Blocks.COPPER_BULB,
				Blocks.CHISELED_COPPER, Blocks.CUT_COPPER,
				Blocks.EXPOSED_COPPER,
				Blocks.EXPOSED_COPPER_GRATE, Blocks.EXPOSED_COPPER_BULB,
				Blocks.EXPOSED_COPPER_DOOR, Blocks.EXPOSED_COPPER_TRAPDOOR,
				Blocks.EXPOSED_CHISELED_COPPER, Blocks.EXPOSED_CUT_COPPER,
				Blocks.WEATHERED_COPPER,
				Blocks.WEATHERED_COPPER_GRATE, Blocks.WEATHERED_COPPER_BULB,
				Blocks.WEATHERED_COPPER_DOOR, Blocks.WEATHERED_COPPER_TRAPDOOR,
				Blocks.WEATHERED_CHISELED_COPPER, Blocks.WEATHERED_CUT_COPPER,
				Blocks.OXIDIZED_COPPER,
				Blocks.OXIDIZED_COPPER_GRATE, Blocks.OXIDIZED_COPPER_BULB,
				Blocks.OXIDIZED_COPPER_DOOR, Blocks.OXIDIZED_COPPER_TRAPDOOR,
				Blocks.OXIDIZED_CHISELED_COPPER, Blocks.OXIDIZED_CUT_COPPER,
				Blocks.WAXED_COPPER_BLOCK,
				Blocks.WAXED_COPPER_GRATE, Blocks.WAXED_COPPER_BULB,
				Blocks.WAXED_COPPER_DOOR, Blocks.WAXED_COPPER_TRAPDOOR,
				Blocks.WAXED_CHISELED_COPPER, Blocks.WAXED_CUT_COPPER,
				Blocks.WAXED_EXPOSED_COPPER,
				Blocks.WAXED_EXPOSED_COPPER_GRATE, Blocks.WAXED_EXPOSED_COPPER_BULB,
				Blocks.WAXED_EXPOSED_COPPER_DOOR, Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
				Blocks.WAXED_EXPOSED_CHISELED_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER,
				Blocks.WAXED_WEATHERED_COPPER,
				Blocks.WAXED_WEATHERED_COPPER_GRATE, Blocks.WAXED_WEATHERED_COPPER_BULB,
				Blocks.WAXED_WEATHERED_COPPER_DOOR, Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR,
				Blocks.WAXED_WEATHERED_CHISELED_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER,
				Blocks.WAXED_OXIDIZED_COPPER,
				Blocks.WAXED_OXIDIZED_COPPER_GRATE, Blocks.WAXED_OXIDIZED_COPPER_BULB,
				Blocks.WAXED_OXIDIZED_COPPER_DOOR, Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,
				Blocks.WAXED_OXIDIZED_CHISELED_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER);
		tag(ModBlockTags.IRON)
			.addTag(Tags.Blocks.ORES_IRON)
			.addTag(BlockTags.IRON_ORES)
			.add(
				Blocks.IRON_BLOCK, Blocks.RAW_IRON_BLOCK,
				Blocks.IRON_BARS, Blocks.IRON_DOOR, Blocks.IRON_TRAPDOOR);
		tag(ModBlockTags.GOLD)
			.addTag(Tags.Blocks.ORES_GOLD)
			.addTag(BlockTags.GOLD_ORES)
			.add(Blocks.GOLD_BLOCK, Blocks.RAW_GOLD_BLOCK);
		tag(ModBlockTags.REDSTONE)
			.addTag(Tags.Blocks.ORES_REDSTONE)
			.addTag(BlockTags.REDSTONE_ORES)
			.add(
				Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WALL_TORCH,
				Blocks.REDSTONE_LAMP, Blocks.REDSTONE_WIRE);
		tag(ModBlockTags.LAPIS)
			.addTag(Tags.Blocks.ORES_LAPIS)
			.addTag(BlockTags.LAPIS_ORES)
			.add(Blocks.LAPIS_BLOCK);
		tag(ModBlockTags.DIAMOND)
			.addTag(Tags.Blocks.ORES_DIAMOND)
			.addTag(BlockTags.DIAMOND_ORES)
			.add(Blocks.DIAMOND_BLOCK);
		tag(ModBlockTags.EMERALD)
			.addTag(Tags.Blocks.ORES_EMERALD)
			.addTag(BlockTags.EMERALD_ORES)
			.add(Blocks.EMERALD_BLOCK);
		tag(ModBlockTags.QUARTZ)
			.addTag(Tags.Blocks.ORES_QUARTZ)
			.add(
				Blocks.QUARTZ_BLOCK,
				Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_PILLAR,
				Blocks.QUARTZ_SLAB, Blocks.QUARTZ_STAIRS,
				Blocks.CHISELED_QUARTZ_BLOCK,
				Blocks.SMOOTH_QUARTZ,
				Blocks.SMOOTH_QUARTZ_SLAB, Blocks.SMOOTH_QUARTZ_STAIRS);
		tag(ModBlockTags.NETHER)
			.add(Blocks.NETHERITE_BLOCK, Blocks.ANCIENT_DEBRIS);
	}
}
