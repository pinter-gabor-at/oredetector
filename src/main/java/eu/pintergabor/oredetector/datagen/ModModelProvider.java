package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.item.ModItems;
import org.jetbrains.annotations.NotNull;

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

	private static void generateModel(ItemModelGenerators generators, Item item) {
		generators.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	/**
	 * Generate blockstates, block and item models.
	 */
	@Override
	protected void registerModels(
		@NotNull BlockModelGenerators blockModels,
		@NotNull ItemModelGenerators itemModels
	) {
		ModItems.DETECTORS
			.forEach(detector ->
				generateModel(itemModels, detector.get()));
	}
}
