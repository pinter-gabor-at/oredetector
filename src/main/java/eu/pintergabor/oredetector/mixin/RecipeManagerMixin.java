package eu.pintergabor.oredetector.mixin;

import java.util.SortedMap;

import com.llamalad7.mixinextras.sugar.Local;
import eu.pintergabor.oredetector.util.RecipeManagerUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.recipe.PreparedRecipes;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;


@Mixin(ServerRecipeManager.class)
public abstract class RecipeManagerMixin {

	/**
	 * Remove recipes, if they are disabled in config.
	 * <p>
	 * Inject code right after loading the recipes from JSON.
	 */
	@Inject(method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Lnet/minecraft/recipe/PreparedRecipes;",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/resource/JsonDataLoader;load(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/resource/ResourceFinder;Lcom/mojang/serialization/DynamicOps;Lcom/mojang/serialization/Codec;Ljava/util/Map;)V",
			shift = At.Shift.AFTER))
	private void editMap(
		ResourceManager resourceManager,
		Profiler profiler,
		CallbackInfoReturnable<PreparedRecipes> cir,
		@Local SortedMap<Identifier, Recipe<?>> sortedMap) {
		RecipeManagerUtil.configRecipes(sortedMap);
	}
}
