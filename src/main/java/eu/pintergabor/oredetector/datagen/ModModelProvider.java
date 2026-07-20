package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.item.ModItems;
import org.jspecify.annotations.NonNull;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;


public final class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(final @NonNull BlockModelGenerators generators) {
	}

	private static void generateModel(
		final @NonNull ItemModelGenerators generators,
		final @NonNull Item item
	) {
		generators.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	@Override
	public void generateItemModels(final @NonNull ItemModelGenerators generators) {
		for (Item detector : ModItems.DETECTORS) {
			generateModel(generators, detector);
		}
	}
}
