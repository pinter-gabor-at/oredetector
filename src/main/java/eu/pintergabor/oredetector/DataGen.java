package eu.pintergabor.oredetector;

import java.util.List;
import java.util.Set;

import eu.pintergabor.oredetector.datagen.ModBlockTagProvider;
import eu.pintergabor.oredetector.datagen.ModItemTagProvider;
import eu.pintergabor.oredetector.datagen.ModModelProvider;
import eu.pintergabor.oredetector.datagen.ModRecipeRunner;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;


public final class DataGen {

	public DataGen() {
		// Static class.
	}

	public static void init(GatherDataEvent.Client event) {
		// Create recipes.
		event.createProvider(ModRecipeRunner::new);
		// Create models.
		event.createProvider(ModModelProvider::new);
		// Create tags.
		event.createBlockAndItemTags(ModBlockTagProvider::new, ModItemTagProvider::new);
	}
}
