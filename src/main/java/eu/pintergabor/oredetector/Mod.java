package eu.pintergabor.oredetector;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.item.ModItems;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import eu.pintergabor.oredetector.util.ModRecipes;

import net.fabricmc.api.ModInitializer;

public class Mod implements ModInitializer {
	@Override
	public void onInitialize() {
		// Init config
		ModConfig.init();
		// Register sounds
		ModSounds.register();
		// Register tags
		ModBlockTags.register();
		// Register items
		ModItems.register();
		// Register recipes
		ModRecipes.register();
	}
}
