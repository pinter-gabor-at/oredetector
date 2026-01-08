package eu.pintergabor.oredetector.item;

import static eu.pintergabor.oredetector.item.ModItems.DETECTORS;

import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.jspecify.annotations.NonNull;

import net.minecraft.world.item.CreativeModeTabs;


public final class CreativeTabs {

	/**
	 * Add items to creative tabs.
	 */
	public static void init(@NonNull BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			DETECTORS.forEach(event::accept);
		}
	}
}
