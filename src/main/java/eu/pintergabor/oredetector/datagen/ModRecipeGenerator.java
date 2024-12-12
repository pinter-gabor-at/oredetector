package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(
            FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    /**
     * Generate recipes
     */
    @Override
    public void generate(RecipeExporter exporter) {
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
                .pattern("  B")
                .pattern(" /@")
                .pattern("/@ ")
                .input('/', Items.STICK)
                .input('@', Items.STRING)
                .input('B', keyItem)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, Global.ModIdentifier(getRecipeName(resultItem)));
    }
}
