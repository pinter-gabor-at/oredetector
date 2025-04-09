package eu.pintergabor.oredetector.util;

import java.util.Map;

import eu.pintergabor.oredetector.config.ModConfigData;
import eu.pintergabor.oredetector.item.ModItems;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;


public class RecipeManagerUtil {

	/**
	 * Remove {@code item} recipe from map.
	 *
	 * @param map Map of all recipes.
	 */
	private static void removeItemRecipe(
		Map<ResourceLocation, Recipe<?>> map, ItemLike item) {
		map.remove(BuiltInRegistries.ITEM.getKey(item.asItem()));
	}

	/**
	 * Remove recipes, if they are disabled in ModConfigData.
	 *
	 * @param map Map of all recipes.
	 */
	public static void configRecipes(Map<ResourceLocation, Recipe<?>> map) {
		if (!ModConfigData.ENABLE_VOID_DETECTOR.get()) {
			removeItemRecipe(map, ModItems.VOID_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_VOID_DETECTOR_ITEM);
		}
		if (!ModConfigData.ENABLE_COAL_DETECTOR.get()) {
			removeItemRecipe(map, ModItems.COAL_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_COAL_DETECTOR_ITEM);
		}
		if (!ModConfigData.ENABLE_IRON_DETECTOR.get()) {
			removeItemRecipe(map, ModItems.IRON_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_IRON_DETECTOR_ITEM);
		}
		if (!ModConfigData.ENABLE_GOLD_DETECTOR.get()) {
			removeItemRecipe(map, ModItems.GOLD_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_GOLD_DETECTOR_ITEM);
		}
		if (!ModConfigData.ENABLE_DIAMOND_DETECTOR.get()) {
			removeItemRecipe(map, ModItems.DIAMOND_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_DIAMOND_DETECTOR_ITEM);
		}
	}
}
