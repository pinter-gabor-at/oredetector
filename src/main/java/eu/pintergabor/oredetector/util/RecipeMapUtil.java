package eu.pintergabor.oredetector.util;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.item.ModItems;
import org.jspecify.annotations.NonNull;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;


public final class RecipeMapUtil {

	/**
	 * Check if path matches the path of any of these items.
	 */
	private static boolean isAnyOfThese(
		@NonNull String path,
		@NonNull Item item0,
		@NonNull Item item1
	) {
		return path.equals(BuiltInRegistries.ITEM.getKey(item0).getPath()) ||
			path.equals(BuiltInRegistries.ITEM.getKey(item1).getPath());
	}

	/**
	 * Remove recipes, if they are disabled in ModConfigData.
	 *
	 * @param recipeId recipe id to check.
	 * @return true if this recipe shall be removed.
	 */
	public static boolean isDisabledRecipe(@NonNull Identifier recipeId) {
		final String recipeName = recipeId.getPath();
		final ModConfig config = ModConfig.getInstance();
		if (recipeId.getNamespace().equals(Global.MODID)) {
			if (isAnyOfThese(recipeName,
				ModItems.VOID_DETECTOR_ITEM,
				ModItems.FOCUSED_VOID_DETECTOR_ITEM)) {
				return !config.enableVoidDetector;
			}
			if (isAnyOfThese(recipeName,
				ModItems.COAL_DETECTOR_ITEM,
				ModItems.FOCUSED_COAL_DETECTOR_ITEM)) {
				return !config.enableCoalDetector;
			}
			if (isAnyOfThese(recipeName,
				ModItems.IRON_DETECTOR_ITEM,
				ModItems.FOCUSED_IRON_DETECTOR_ITEM)) {
				return !config.enableIronDetector;
			}
			if (isAnyOfThese(recipeName,
				ModItems.GOLD_DETECTOR_ITEM,
				ModItems.FOCUSED_GOLD_DETECTOR_ITEM)) {
				return !config.enableGoldDetector;
			}
			if (isAnyOfThese(recipeName,
				ModItems.DIAMOND_DETECTOR_ITEM,
				ModItems.FOCUSED_DIAMOND_DETECTOR_ITEM)) {
				return !config.enableDiamondDetector;
			}
		}
		return false;
	}
}
