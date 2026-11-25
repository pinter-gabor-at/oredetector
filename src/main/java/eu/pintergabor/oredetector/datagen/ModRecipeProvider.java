package eu.pintergabor.oredetector.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.Global;
import org.jspecify.annotations.NonNull;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.Recipe;

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
		HolderLookup.@NonNull Provider registries,
		@NonNull BootstrapContext<Recipe<?>> recipes,
		@NonNull BootstrapContext<Advancement> advancements
	) {
		return new ModRecipeGenerator(recipes, advancements);
	}

	@Override
	public @NonNull String getName() {
		return Global.MODID + " recipes";
	}
}
