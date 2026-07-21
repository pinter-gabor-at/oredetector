package eu.pintergabor.oredetector.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.tag.ModBlockTags;
import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.references.BlockIds;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopperCollection;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;


public final class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

	public ModBlockTagProvider(
		FabricPackOutput output,
		CompletableFuture<HolderLookup.Provider> registriesFuture
	) {
		super(output, registriesFuture);
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagAir() {
		final TagAppender<Block> tag = tag(BlockTags.AIR);
		tag.add(BlockItemIds.AIR.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagWater() {
		final TagAppender<Block> tag = tag(ModBlockTags.WATER);
		tag.addOptionalTag(BlockTags.ICE);
		tag.addOptionalTag(BlockTags.SNOW);
		tag.add(
			BlockIds.WATER,
			BlockItemIds.SNOW.block(),
			BlockItemIds.SNOW_BLOCK.block(),
			BlockItemIds.POWDER_SNOW.block(),
			BlockItemIds.ICE.block(),
			BlockItemIds.BLUE_ICE.block(),
			BlockItemIds.PACKED_ICE.block(),
			BlockIds.FROSTED_ICE,
			BlockIds.POWDER_SNOW_CAULDRON,
			BlockIds.WATER_CAULDRON);
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagLava() {
		final TagAppender<Block> tag = tag(ModBlockTags.LAVA);
		tag.add(
			BlockIds.LAVA,
			BlockIds.LAVA_CAULDRON);
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagCoal() {
		final TagAppender<Block> tag = tag(ModBlockTags.COAL);
		tag.addOptionalTag(ConventionalBlockTags.COAL_ORES);
		tag.add(
			BlockItemIds.COAL_ORE.block(),
			BlockItemIds.DEEPSLATE_COAL_ORE.block(),
			BlockItemIds.COAL_BLOCK.block(),
			BlockItemIds.TORCH.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagAddWeatheringCopperCollection(
		final @NonNull TagAppender<Block> tag,
		final @NonNull WeatheringCopperCollection<BlockItemId> collection
	) {
		tag.addAll(collection.map(BlockItemId::block).asList());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagCopper() {
		final TagAppender<Block> tag = tag(ModBlockTags.COPPER);
		tag.addOptionalTag(BlockTags.COPPER);
		tag.addOptionalTag(ConventionalBlockTags.COPPER_ORES);
		tag.addOptionalTag(ConventionalBlockTags.COPPER_BARS);
		tag.add(
			BlockItemIds.COPPER_ORE.block(),
			BlockItemIds.DEEPSLATE_COPPER_ORE.block(),
			BlockItemIds.COPPER_TORCH.block());
		List<WeatheringCopperCollection<BlockItemId>> copperBlockCollections = List.of(
			BlockItemIds.COPPER_BLOCK,
			BlockItemIds.COPPER_BARS,
			BlockItemIds.COPPER_CHAIN,
			BlockItemIds.COPPER_LANTERN,
			BlockItemIds.CUT_COPPER,
			BlockItemIds.CHISELED_COPPER,
			BlockItemIds.CUT_COPPER_STAIRS,
			BlockItemIds.CUT_COPPER_SLAB,
			BlockItemIds.COPPER_DOOR,
			BlockItemIds.COPPER_TRAPDOOR,
			BlockItemIds.COPPER_GRATE,
			BlockItemIds.COPPER_BULB,
			BlockItemIds.COPPER_CHEST,
			BlockItemIds.COPPER_GOLEM_STATUE,
			BlockItemIds.LIGHTNING_ROD);
		copperBlockCollections.forEach(collection ->
			tagAddWeatheringCopperCollection(tag, collection));
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagIron() {
		final TagAppender<Block> tag = tag(ModBlockTags.IRON);
		tag.addOptionalTag(ConventionalBlockTags.IRON_ORES);
		tag.addOptionalTag(BlockTags.IRON_ORES);
		tag.addOptionalTag(BlockTags.ANVIL);
		tag.addOptionalTag(BlockTags.RAILS);
		tag.add(
			BlockItemIds.IRON_ORE.block(),
			BlockItemIds.DEEPSLATE_IRON_ORE.block(),
			BlockItemIds.IRON_BLOCK.block(),
			BlockItemIds.RAW_IRON_BLOCK.block(),
			BlockItemIds.IRON_BARS.block(),
			BlockItemIds.IRON_CHAIN.block(),
			BlockItemIds.IRON_DOOR.block(),
			BlockItemIds.ANVIL.block(),
			BlockItemIds.CHIPPED_ANVIL.block(),
			BlockItemIds.DAMAGED_ANVIL.block(),
			BlockItemIds.RAIL.block(),
			BlockItemIds.ACTIVATOR_RAIL.block(),
			BlockItemIds.IRON_TRAPDOOR.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagGold() {
		final TagAppender<Block> tag = tag(ModBlockTags.GOLD);
		tag.addOptionalTag(ConventionalBlockTags.GOLD_ORES);
		tag.addOptionalTag(BlockTags.GOLD_ORES);
		tag.add(
			BlockItemIds.GOLD_ORE.block(),
			BlockItemIds.DEEPSLATE_GOLD_ORE.block(),
			BlockItemIds.NETHER_GOLD_ORE.block(),
			BlockItemIds.GOLD_BLOCK.block(),
			BlockItemIds.RAW_GOLD_BLOCK.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagRedstone() {
		final TagAppender<Block> tag = tag(ModBlockTags.REDSTONE);
		tag.add(
			BlockItemIds.REDSTONE_ORE.block(),
			BlockItemIds.DEEPSLATE_REDSTONE_ORE.block(),
			BlockItemIds.REDSTONE_BLOCK.block(),
			BlockItemIds.REDSTONE_TORCH.block(),
			BlockIds.REDSTONE_WALL_TORCH,
			BlockItemIds.REDSTONE_LAMP.block(),
			BlockItemIds.REDSTONE_DUST.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagLapis() {
		final TagAppender<Block> tag = tag(ModBlockTags.LAPIS);
		tag.addOptionalTag(ConventionalBlockTags.LAPIS_ORES);
		tag.add(
			BlockItemIds.LAPIS_ORE.block(),
			BlockItemIds.DEEPSLATE_LAPIS_ORE.block(),
			BlockItemIds.LAPIS_BLOCK.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagDiamond() {
		final TagAppender<Block> tag = tag(ModBlockTags.DIAMOND);
		tag.addOptionalTag(ConventionalBlockTags.DIAMOND_ORES);
		tag.add(
			BlockItemIds.DIAMOND_ORE.block(),
			BlockItemIds.DEEPSLATE_DIAMOND_ORE.block(),
			BlockItemIds.DIAMOND_BLOCK.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagEmerald() {
		final TagAppender<Block> tag = tag(ModBlockTags.EMERALD);
		tag.addOptionalTag(ConventionalBlockTags.EMERALD_ORES);
		tag.add(
			BlockItemIds.EMERALD_ORE.block(),
			BlockItemIds.DEEPSLATE_EMERALD_ORE.block(),
			BlockItemIds.EMERALD_BLOCK.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagQuartz() {
		final TagAppender<Block> tag = tag(ModBlockTags.QUARTZ);
		tag.addOptionalTag(ConventionalBlockTags.QUARTZ_ORES);
		tag.add(
			BlockItemIds.NETHER_QUARTZ_ORE.block(),
			BlockItemIds.QUARTZ_BLOCK.block(),
			BlockItemIds.QUARTZ_BRICKS.block(),
			BlockItemIds.QUARTZ_PILLAR.block(),
			BlockItemIds.QUARTZ_SLAB.block(),
			BlockItemIds.QUARTZ_STAIRS.block(),
			BlockItemIds.CHISELED_QUARTZ_BLOCK.block(),
			BlockItemIds.SMOOTH_QUARTZ.block(),
			BlockItemIds.SMOOTH_QUARTZ_SLAB.block(),
			BlockItemIds.SMOOTH_QUARTZ_STAIRS.block());
	}

	@SuppressWarnings({"unchecked", "RedundantSuppression"})
	private void tagNether() {
		final TagAppender<Block> tag = tag(ModBlockTags.NETHER);
		tag.add(
			BlockItemIds.NETHERITE_BLOCK.block(),
			BlockItemIds.ANCIENT_DEBRIS.block());
	}


	@Override
	protected void addTags(final HolderLookup.@NonNull Provider registries) {
		tagAir();
		tagWater();
		tagLava();
		tagCoal();
		tagCopper();
		tagIron();
		tagGold();
		tagRedstone();
		tagLapis();
		tagDiamond();
		tagEmerald();
		tagQuartz();
		tagNether();
	}
}
