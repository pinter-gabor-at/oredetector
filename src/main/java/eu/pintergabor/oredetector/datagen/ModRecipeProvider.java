package eu.pintergabor.oredetector.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.Global;
import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;


public final class ModRecipeProvider extends FabricRecipeProvider {

	public ModRecipeProvider(
		FabricPackOutput output,
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
