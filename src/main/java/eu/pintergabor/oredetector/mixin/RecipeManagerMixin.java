package eu.pintergabor.oredetector.mixin;

import java.util.SortedMap;

import com.llamalad7.mixinextras.sugar.Local;
import eu.pintergabor.oredetector.util.RecipeManagerUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;


@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {

	/**
	 * Remove recipes, if they are disabled in config.
	 * <p>
	 * Inject code right after loading the recipes from JSON.
	 */
	@Inject(method = "prepare(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)Lnet/minecraft/world/item/crafting/RecipeMap;",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/resources/SimpleJsonResourceReloadListener;scanDirectory(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/resources/FileToIdConverter;Lcom/mojang/serialization/DynamicOps;Lcom/mojang/serialization/Codec;Ljava/util/Map;)V",
			shift = At.Shift.AFTER))
	private void editMap(
		ResourceManager resourceManager, ProfilerFiller profilerFiller, CallbackInfoReturnable<RecipeMap> cir,
		@Local SortedMap<ResourceLocation, Recipe<?>> sortedMap
	) {
		RecipeManagerUtil.configRecipes(sortedMap);
	}
}
