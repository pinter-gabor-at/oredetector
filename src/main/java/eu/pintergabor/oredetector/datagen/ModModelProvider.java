package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.item.ModItems;
import org.jspecify.annotations.NonNull;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;


public final class ModModelProvider extends ModelProvider {

	public ModModelProvider(PackOutput output) {
		super(output, Global.MODID);
	}

	private static void generateModel(
		@NonNull ItemModelGenerators generators,
		@NonNull Item item
	) {
		generators.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	/**
	 * Generate blockstates, block and item models.
	 */
	@Override
	protected void registerModels(
		@NonNull BlockModelGenerators blockModels,
		@NonNull ItemModelGenerators itemModels
	) {
		ModItems.DETECTORS
			.forEach(detector ->
				generateModel(itemModels, detector.get()));
	}
}
