package eu.pintergabor.oredetector.util;

import java.util.Map;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.item.ModItems;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;


public final class RecipeManagerUtil {

	private RecipeManagerUtil() {
		// Static class.
	}

	/**
	 * Remove {@code item} recipe from map.
	 *
	 * @param map Map of all recipes.
	 */
	private static void removeItemRecipe(
		Map<ResourceLocation, Recipe<?>> map, Item item) {
		map.remove(BuiltInRegistries.ITEM.getKey(item));
	}

	/**
	 * Remove recipes, if they are disabled in config.
	 *
	 * @param map Map of all recipes.
	 */
	public static void configRecipes(Map<ResourceLocation, Recipe<?>> map) {
		final ModConfig config = ModConfig.getInstance();
		if (!config.enableVoidDetector) {
			removeItemRecipe(map, ModItems.VOID_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_VOID_DETECTOR_ITEM);
		}
		if (!config.enableCoalDetector) {
			removeItemRecipe(map, ModItems.COAL_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_COAL_DETECTOR_ITEM);
		}
		if (!config.enableIronDetector) {
			removeItemRecipe(map, ModItems.IRON_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_IRON_DETECTOR_ITEM);
		}
		if (!config.enableGoldDetector) {
			removeItemRecipe(map, ModItems.GOLD_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_GOLD_DETECTOR_ITEM);
		}
		if (!config.enableDiamondDetector) {
			removeItemRecipe(map, ModItems.DIAMOND_DETECTOR_ITEM);
			removeItemRecipe(map, ModItems.FOCUSED_DIAMOND_DETECTOR_ITEM);
		}
	}
}
