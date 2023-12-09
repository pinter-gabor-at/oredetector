package eu.pintergabor.oredetector.mixin;

import java.util.Map;

import com.google.gson.JsonElement;
import eu.pintergabor.oredetector.util.RecipeManagerUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {

	/**
	 * Remove recipes, if they are disabled in config
	 */
	@Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("HEAD"))
	private void apply(
		Map<Identifier, JsonElement> map,
		ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
		RecipeManagerUtil.configRecipes(map);
	}
}
