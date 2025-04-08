package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.item.ModItems;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;


public class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators generators) {
	}


	private static void generateModel(ItemModelGenerators generators, Item item) {
		generators.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	@Override
	public void generateItemModels(ItemModelGenerators generators) {
		for (Item detector : ModItems.DETECTORS) {
			generateModel(generators, detector);
		}
	}
}
