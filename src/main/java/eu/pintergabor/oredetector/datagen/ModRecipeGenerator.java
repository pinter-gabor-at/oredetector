package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.item.ModItems;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;


public class ModRecipeGenerator extends RecipeGenerator {

	protected ModRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
		super(registries, exporter);
	}

	/**
	 * Generate one basic item recipe.
	 *
	 * @param keyItem    Item in the top right slot.
	 * @param resultItem Result.
	 */
	private void generateBasic(
		Item keyItem, Item resultItem) {
		createShaped(RecipeCategory.MISC, resultItem)
			.pattern("  B")
			.pattern("@/ ")
			.pattern("/@ ")
			.input('/', Items.STICK)
			.input('@', Items.STRING)
			.input('B', keyItem)
			.criterion(hasItem(keyItem), conditionsFromItem(keyItem))
			.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
			.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
			.offerTo(exporter);
	}

	/**
	 * Generate one focused item recipe.
	 *
	 * @param keyItem    Item in the top right slot.
	 * @param resultItem Result.
	 */
	private void generateFocused(
		Item keyItem, Item resultItem) {
		createShaped(RecipeCategory.MISC, resultItem)
			.pattern(" BB")
			.pattern("@BB")
			.pattern("/@ ")
			.input('/', Items.STICK)
			.input('@', Items.STRING)
			.input('B', keyItem)
			.criterion(hasItem(keyItem), conditionsFromItem(keyItem))
			.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
			.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
			.offerTo(exporter);
	}


	/**
	 * Generate recipes.
	 */
	@Override
	public void generate() {
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
