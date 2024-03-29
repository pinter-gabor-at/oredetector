package eu.pintergabor.oredetector.util;

import java.util.Map;

import com.google.gson.JsonElement;
import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.item.ModItems;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class RecipeManagerUtil {
	/**
	 * Remove recipes, if they are disabled in config
	 * @param map Map of all recipes
	 */
	public static void configRecipes(Map<Identifier, JsonElement> map) {
		final var config = ModConfig.getInstance();
		if (!config.enableVoidDetector) {
			removeItemRecipe(map, ModItems.VOID_DETECTOR_ITEM);
		}
		if (!config.enableCoalDetector) {
			removeItemRecipe(map, ModItems.COAL_DETECTOR_ITEM);
		}
		if (!config.enableIronDetector) {
			removeItemRecipe(map, ModItems.IRON_DETECTOR_ITEM);
		}
		if (!config.enableGoldDetector) {
			removeItemRecipe(map, ModItems.GOLD_DETECTOR_ITEM);
		}
		if (!config.enableDiamondDetector) {
			removeItemRecipe(map, ModItems.DIAMOND_DETECTOR_ITEM);
		}
	}

	/**
	 * Remove {@code item} recipe from map
	 * @param map Map of all recipes
	 */
	private static void removeItemRecipe(
		Map<Identifier, JsonElement> map, Item item) {
		map.remove(new ModIdentifier(item.toString()));
	}
}
