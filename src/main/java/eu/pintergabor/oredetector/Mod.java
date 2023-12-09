package eu.pintergabor.oredetector;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.item.ModItems;

import eu.pintergabor.oredetector.sound.ModSounds;

import net.fabricmc.api.ModInitializer;

public class Mod implements ModInitializer {
	@Override
	public void onInitialize() {
		// Register items
		ModItems.register();
		// Register sounds
		ModSounds.register();
		// Init config
		ModConfig.init();
	}
}
