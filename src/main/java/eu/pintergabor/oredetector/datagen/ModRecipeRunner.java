package eu.pintergabor.oredetector.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.Global;
import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;


public final class ModRecipeRunner extends RecipeProvider.Runner {

	public ModRecipeRunner(
		PackOutput output,
		CompletableFuture<HolderLookup.Provider> registriesFuture
	) {
		super(output, registriesFuture);
	}

	@Override
	protected @NonNull RecipeProvider createRecipeProvider(
		HolderLookup.@NonNull Provider registryLookup,
		@NonNull RecipeOutput output
	) {
		return new ModRecipeGenerator(registryLookup, output);
	}

	@Override
	public @NonNull String getName() {
		return Global.MODID + " recipes";
	}
}
