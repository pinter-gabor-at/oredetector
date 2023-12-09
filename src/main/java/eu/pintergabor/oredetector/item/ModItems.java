package eu.pintergabor.oredetector.item;

import static eu.pintergabor.oredetector.util.Register.registerItem;

import net.minecraft.item.ItemGroups;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public final class ModItems {
	private ModItems() {
		// Static class
	}

	// Ore Detectors
	public static final VoidDetector VOID_DETECTOR_ITEM =
		new VoidDetector(new FabricItemSettings());

	public static void register() {
		// Create and register Ore Detectors
		registerItem(
			"void_detector", VOID_DETECTOR_ITEM);
		// Item groups
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(
			entries -> {
				entries.add(VOID_DETECTOR_ITEM);
			});
	}
}
