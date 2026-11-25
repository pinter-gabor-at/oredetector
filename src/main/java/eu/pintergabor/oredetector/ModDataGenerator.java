package eu.pintergabor.oredetector;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.datagen.ModBlockTagProvider;
import eu.pintergabor.oredetector.datagen.ModModelProvider;
import eu.pintergabor.oredetector.datagen.ModRecipeGenerator;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;


public final class ModDataGenerator {

	private ModDataGenerator() {
		// Static class.
	}

	public static void listen0(@NonNull GatherDataRegistryEntriesEvent event) {
		event
			// Create recipes.
			.add(ModRecipeGenerator.create());
	}

	public static void listen1(GatherDataEvent.@NonNull Client event) {
		final DataGenerator generator = event.getGenerator();
		final PackOutput output = generator.getPackOutput();
		final CompletableFuture<HolderLookup.Provider> lookup =
			event.getReloadableLookupProvider();
		// Create models.
		generator.addProvider(true, new ModModelProvider(output));
		// Create tags.
		generator.addProvider(true, new ModBlockTagProvider(output, lookup));
	}
}
