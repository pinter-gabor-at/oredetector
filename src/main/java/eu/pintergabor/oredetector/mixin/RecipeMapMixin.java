package eu.pintergabor.oredetector.mixin;

import java.util.List;
import java.util.stream.Stream;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import eu.pintergabor.oredetector.util.RecipeMapUtil;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeMap;


/**
 * Remove the disabled recipes.
 * <p>
 * Inspired by <a href="https://github.com/Globox1997/RecipeRemover/tree/26.3">RecipeRemover</a>
 */
@Mixin(RecipeMap.class)
public class RecipeMapMixin {

	@WrapOperation(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/HolderLookup;listElements()Ljava/util/stream/Stream;"))
	private static Stream<Holder.Reference<Recipe<?>>> createMixin(
		final @NonNull HolderLookup<Recipe<?>> lookup,
		@NonNull Operation<Stream<Holder.Reference<Recipe<?>>>> original
	) {
		// Create the original list.
		List<Holder.Reference<Recipe<?>>> recipes = original.call(lookup).toList();
		// Remove the recipes that are disabled.
		return recipes.stream().filter(recipe ->
			!RecipeMapUtil.isDisabledRecipe(recipe.key().identifier()));
	}
}
