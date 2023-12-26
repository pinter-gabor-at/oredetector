package eu.pintergabor.oredetector.mixinutil;

import java.util.Map;

import com.google.gson.JsonElement;

import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

/**
 * Callback for modifying recipes
 * <p>
 * Called before recipes are loaded from json files. Listener can add or remove recipes as needed.
 */
public interface RecipeManagerCallback {
	Event<RecipeManagerCallback> EVENT = EventFactory.createArrayBacked(RecipeManagerCallback.class,
		(listeners) -> (map) -> {
			for (RecipeManagerCallback listener : listeners) {
				listener.config(map);
			}
		});

	void config(Map<Identifier, JsonElement> map);
}
