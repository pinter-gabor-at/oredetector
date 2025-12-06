package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.item.ModItems;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;


public final class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators generators) {
	}

	private static void generateModel(@NotNull ItemModelGenerators generators, Item item) {
		generators.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	@Override
	public void generateItemModels(ItemModelGenerators generators) {
		for (Item detector : ModItems.DETECTORS) {
			generateModel(generators, detector);
		}
	}
}
