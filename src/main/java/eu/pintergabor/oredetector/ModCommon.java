package eu.pintergabor.oredetector;

import eu.pintergabor.oredetector.config.ModConfigData;
import eu.pintergabor.oredetector.item.ModItems;
import eu.pintergabor.oredetector.sound.ModSounds;
import eu.pintergabor.oredetector.tag.ImportBlockTags;
import eu.pintergabor.oredetector.tag.ModBlockTags;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;


/**
 * Common startup.
 */
@Mod(Global.MODID)
public final class ModCommon {

	@SuppressWarnings("unused")
	public ModCommon(IEventBus modEventBus, ModContainer modContainer, Dist dist) {
		// Use configuration parameters on both sides and load them on startup.
		modContainer.registerConfig(ModConfig.Type.STARTUP, ModConfigData.SPEC);
		// Register sounds.
		ModSounds.init(modEventBus);
		// Register tags.
		ImportBlockTags.init();
		ModBlockTags.init();
		// Register items.
		ModItems.init(modEventBus);
	}
}
