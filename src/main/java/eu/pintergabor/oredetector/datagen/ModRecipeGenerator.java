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
     * Generate recipes
     */
    @Override
    public void generate() {
        generateOne(exporter, Items.COBBLESTONE, ModItems.VOID_DETECTOR_ITEM);
        generateOne(exporter, Items.COAL, ModItems.COAL_DETECTOR_ITEM);
        generateOne(exporter, Items.IRON_INGOT, ModItems.IRON_DETECTOR_ITEM);
        generateOne(exporter, Items.GOLD_INGOT, ModItems.GOLD_DETECTOR_ITEM);
        generateOne(exporter, Items.DIAMOND, ModItems.DIAMOND_DETECTOR_ITEM);
    }

    /**
     * Generate one recipe
     *
     * @param keyItem    Item in the top right slot
     * @param resultItem Result
     */
    private void generateOne(
            RecipeExporter exporter,
            Item keyItem, Item resultItem) {
        createShaped(RecipeCategory.MISC, resultItem)
                .pattern("  B")
                .pattern(" /@")
                .pattern("/@ ")
                .input('/', Items.STICK)
                .input('@', Items.STRING)
                .input('B', keyItem)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);
    }
}
