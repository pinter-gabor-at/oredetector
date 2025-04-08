package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.item.ModItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;


public class ModRecipeGenerator extends RecipeProvider {

	public ModRecipeGenerator(
		HolderLookup.Provider registries, RecipeOutput output) {
		super(registries, output);
	}

	/**
	 * Generate one basic item recipe.
	 *
	 * @param keyItem    Item in the top right slot.
	 * @param resultItem Result.
	 */
	private void generateBasic(
		Item keyItem, Item resultItem) {
		shaped(RecipeCategory.MISC, resultItem)
			.pattern("  B")
			.pattern("@/ ")
			.pattern("/@ ")
			.define('/', Items.STICK)
			.define('@', Items.STRING)
			.define('B', keyItem)
			.unlockedBy(getHasName(keyItem), has(keyItem))
			.unlockedBy(getHasName(Items.STICK), has(Items.STICK))
			.unlockedBy(getHasName(Items.STRING), has(Items.STRING))
			.save(output);
	}

	/**
	 * Generate one focused item recipe.
	 *
	 * @param keyItem    Item in the top right slot.
	 * @param resultItem Result.
	 */
	private void generateFocused(
		Item keyItem, Item resultItem) {
		shaped(RecipeCategory.MISC, resultItem)
			.pattern(" BB")
			.pattern("@BB")
			.pattern("/@ ")
			.define('/', Items.STICK)
			.define('@', Items.STRING)
			.define('B', keyItem)
			.unlockedBy(getHasName(keyItem), has(keyItem))
			.unlockedBy(getHasName(Items.STICK), has(Items.STICK))
			.unlockedBy(getHasName(Items.STRING), has(Items.STRING))
			.save(output);
	}

	/**
	 * Generate recipes.
	 */
	@Override
	public void buildRecipes() {
		generateBasic(Items.COBBLESTONE, ModItems.VOID_DETECTOR_ITEM);
		generateFocused(Items.COBBLESTONE, ModItems.FOCUSED_VOID_DETECTOR_ITEM);
		generateBasic(Items.COAL, ModItems.COAL_DETECTOR_ITEM);
		generateFocused(Items.COAL, ModItems.FOCUSED_COAL_DETECTOR_ITEM);
		generateBasic(Items.IRON_INGOT, ModItems.IRON_DETECTOR_ITEM);
		generateFocused(Items.IRON_INGOT, ModItems.FOCUSED_IRON_DETECTOR_ITEM);
		generateBasic(Items.GOLD_INGOT, ModItems.GOLD_DETECTOR_ITEM);
		generateFocused(Items.GOLD_INGOT, ModItems.FOCUSED_GOLD_DETECTOR_ITEM);
		generateBasic(Items.DIAMOND, ModItems.DIAMOND_DETECTOR_ITEM);
		generateFocused(Items.DIAMOND, ModItems.FOCUSED_DIAMOND_DETECTOR_ITEM);
	}
}
