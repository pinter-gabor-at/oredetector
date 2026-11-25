package eu.pintergabor.oredetector.util;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfigData;
import eu.pintergabor.oredetector.item.ModItems;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jspecify.annotations.NonNull;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;


public final class RecipeMapUtil {

	/**
	 * Check if path matches the path of any of these items.
	 */
	private static boolean isAnyOfThese(
		@NonNull String path,
		@NonNull DeferredItem<Item> item0,
		@NonNull DeferredItem<Item> item1
	) {
		return path.equals(item0.getId().getPath()) ||
			path.equals(item1.getId().getPath());
	}

	/**
	 * Remove recipes, if they are disabled in ModConfigData.
	 *
	 * @param recipeId recipe id to check.
	 * @return true if this recipe shall be removed.
	 */
	public static boolean isDisabledRecipe(@NonNull Identifier recipeId) {
		final String recipeName = recipeId.getPath();
		if (recipeId.getNamespace().equals(Global.MODID)) {
			if (isAnyOfThese(recipeName,
				ModItems.VOID_DETECTOR_ITEM,
				ModItems.FOCUSED_VOID_DETECTOR_ITEM)) {
				return !ModConfigData.ENABLE_VOID_DETECTOR.get();
			}
			if (isAnyOfThese(recipeName,
				ModItems.COAL_DETECTOR_ITEM,
				ModItems.FOCUSED_COAL_DETECTOR_ITEM)) {
				return !ModConfigData.ENABLE_COAL_DETECTOR.get();
			}
			if (isAnyOfThese(recipeName,
				ModItems.IRON_DETECTOR_ITEM,
				ModItems.FOCUSED_IRON_DETECTOR_ITEM)) {
				return !ModConfigData.ENABLE_IRON_DETECTOR.get();
			}
			if (isAnyOfThese(recipeName,
				ModItems.GOLD_DETECTOR_ITEM,
				ModItems.FOCUSED_GOLD_DETECTOR_ITEM)) {
				return !ModConfigData.ENABLE_GOLD_DETECTOR.get();
			}
			if (isAnyOfThese(recipeName,
				ModItems.DIAMOND_DETECTOR_ITEM,
				ModItems.FOCUSED_DIAMOND_DETECTOR_ITEM)) {
				return !ModConfigData.ENABLE_DIAMOND_DETECTOR.get();
			}
		}
		return false;
	}
}
