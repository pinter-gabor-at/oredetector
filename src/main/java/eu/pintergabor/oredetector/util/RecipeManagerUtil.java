package eu.pintergabor.oredetector.util;

import java.util.Map;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.item.ModItems;

import net.minecraft.item.Item;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;


public class RecipeManagerUtil {

	/**
	 * Remove recipes, if they are disabled in config.
	 *
	 * @param map Map of all recipes.
	 */
	public static void configRecipes(Map<Identifier, Recipe<?>> map) {
		final var config = ModConfig.getInstance();
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

	/**
	 * Remove {@code item} recipe from map.
	 *
	 * @param map Map of all recipes.
	 */
	private static void removeItemRecipe(
		Map<Identifier, Recipe<?>> map, Item item) {
		map.remove(Registries.ITEM.getId(item));
	}
}
