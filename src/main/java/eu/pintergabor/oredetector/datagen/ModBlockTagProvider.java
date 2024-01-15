package eu.pintergabor.oredetector.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output,
		CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		getOrCreateTagBuilder(ModBlockTags.AIR)
			.add(Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR);
		getOrCreateTagBuilder(ModBlockTags.WATER)
			.add(Blocks.WATER, Blocks.WATER_CAULDRON);
		getOrCreateTagBuilder(ModBlockTags.LAVA)
			.add(Blocks.LAVA, Blocks.LAVA_CAULDRON);
		getOrCreateTagBuilder(ModBlockTags.COAL)
			.forceAddTag(BlockTags.COAL_ORES)
			.add(Blocks.COAL_BLOCK, Blocks.TORCH);
		getOrCreateTagBuilder(ModBlockTags.COPPER)
			.forceAddTag(BlockTags.COPPER_ORES)
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
		getOrCreateTagBuilder(ModBlockTags.IRON)
			.forceAddTag(BlockTags.IRON_ORES)
			.add(Blocks.IRON_BLOCK, Blocks.RAW_IRON_BLOCK,
				Blocks.IRON_BARS, Blocks.IRON_DOOR, Blocks.IRON_TRAPDOOR);
		getOrCreateTagBuilder(ModBlockTags.GOLD)
			.forceAddTag(BlockTags.GOLD_ORES)
			.add(Blocks.GOLD_BLOCK, Blocks.RAW_GOLD_BLOCK);
		getOrCreateTagBuilder(ModBlockTags.REDSTONE)
			.forceAddTag(BlockTags.REDSTONE_ORES)
			.add(Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WALL_TORCH,
				Blocks.REDSTONE_LAMP, Blocks.REDSTONE_WIRE);
		getOrCreateTagBuilder(ModBlockTags.LAPIS)
			.forceAddTag(BlockTags.LAPIS_ORES)
			.add(Blocks.LAPIS_BLOCK);
		getOrCreateTagBuilder(ModBlockTags.DIAMOND)
			.forceAddTag(BlockTags.DIAMOND_ORES)
			.add(Blocks.DIAMOND_BLOCK);
		getOrCreateTagBuilder(ModBlockTags.EMERALD)
			.forceAddTag(BlockTags.EMERALD_ORES)
			.add(Blocks.EMERALD_BLOCK);
		getOrCreateTagBuilder(ModBlockTags.QUARTZ)
			.forceAddTag(ConventionalBlockTags.QUARTZ_ORES)
			.add(Blocks.QUARTZ_BLOCK,
				Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_PILLAR,
				Blocks.QUARTZ_SLAB, Blocks.QUARTZ_STAIRS,
				Blocks.CHISELED_QUARTZ_BLOCK,
				Blocks.SMOOTH_QUARTZ,
				Blocks.SMOOTH_QUARTZ_SLAB, Blocks.SMOOTH_QUARTZ_STAIRS);
		getOrCreateTagBuilder(ModBlockTags.NETHER)
			.add(Blocks.NETHERITE_BLOCK, Blocks.ANCIENT_DEBRIS);
	}
}
