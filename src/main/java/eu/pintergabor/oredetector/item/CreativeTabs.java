package eu.pintergabor.oredetector.item;

import static eu.pintergabor.oredetector.item.ModItems.DETECTORS;

import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import net.neoforged.neoforge.registries.DeferredItem;


public final class CreativeTabs {

	/**
	 * Add items to creative tabs.
	 */
	public static void init(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			for (DeferredItem<Item> detector : DETECTORS) {
				event.accept(detector);
			}
		}
	}
}
