package eu.pintergabor.oredetector.mixin;

import java.util.Map;

import com.google.gson.JsonElement;
import eu.pintergabor.oredetector.mixinutil.RecipeManagerCallback;
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
	 * Create an event before loading recipes from json
	 * <p>
	 * Listeners, registered to this event, can add or remove recipes
	 */
	@Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("HEAD"))
	private void apply(
		Map<Identifier, JsonElement> map,
		ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
		RecipeManagerCallback.EVENT.invoker().config(map);
	}
}
