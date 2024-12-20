package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VOID_DETECTOR_ITEM, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COAL_DETECTOR_ITEM, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_DETECTOR_ITEM, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_DETECTOR_ITEM, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_DETECTOR_ITEM, Models.HANDHELD);
    }
}
