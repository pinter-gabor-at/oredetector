package eu.pintergabor.oredetector;

import eu.pintergabor.oredetector.main.ClientTick;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTick.register();
	}
}
