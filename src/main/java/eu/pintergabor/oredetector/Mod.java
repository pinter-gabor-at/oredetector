package eu.pintergabor.oredetector;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.item.ModItems;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.fabricmc.api.ModInitializer;


public final class Mod implements ModInitializer {

	@Override
	public void onInitialize() {
		// Init config.
		ModConfig.init();
		// Register sounds.
		ModSounds.init();
		// Register tags.
		ImportBlockTags.init();
		ModBlockTags.init();
		// Register items.
		ModItems.init();
	}
}
