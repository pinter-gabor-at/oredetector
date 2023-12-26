package eu.pintergabor.oredetector.mixinutil;

import com.google.gson.JsonElement;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.Map;

/**
 * Callback from {@link ServerPlayerEntity#playerTick()}
 */
public interface ServerPlayerTickCallback {
	Event<ServerPlayerTickCallback> EVENT =
		EventFactory.createArrayBacked(ServerPlayerTickCallback.class,
		(listeners) -> (world, player) -> {
			for (ServerPlayerTickCallback listener : listeners) {
				listener.playerTick(world, player);
			}
		});

	void playerTick(ServerWorld world, ServerPlayerEntity player);
}
