package eu.pintergabor.oredetector.item;

import static eu.pintergabor.oredetector.util.Register.registerItem;

import eu.pintergabor.oredetector.config.ModConfig;

import net.minecraft.item.ItemGroups;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public final class ModItems {
	private ModItems() {
	}

	// Ore Detectors
	public static VoidDetector VOID_DETECTOR_ITEM;
	public static CoalDetector COAL_DETECTOR_ITEM;
	public static IronDetector IRON_DETECTOR_ITEM;
	public static GoldDetector GOLD_DETECTOR_ITEM;
	public static DiamondDetector DIAMOND_DETECTOR_ITEM;

	public static void register() {
		var config = ModConfig.getInstance();
		// Create and register Ore Detectors
		VOID_DETECTOR_ITEM =
			new VoidDetector(new FabricItemSettings()
				.maxDamage(config.durabilityVoidDetector));
		registerItem(
			"void_detector", VOID_DETECTOR_ITEM);
		COAL_DETECTOR_ITEM =
			new CoalDetector(new FabricItemSettings()
				.maxDamage(config.durabilityCoalDetector));
		registerItem(
			"coal_detector", COAL_DETECTOR_ITEM);
		IRON_DETECTOR_ITEM =
			new IronDetector(new FabricItemSettings()
				.maxDamage(config.durabilityIronDetector));
		registerItem(
			"iron_detector", IRON_DETECTOR_ITEM);
		GOLD_DETECTOR_ITEM =
			new GoldDetector(new FabricItemSettings()
				.maxDamage(config.durabilityGoldDetector));
		registerItem(
			"gold_detector", GOLD_DETECTOR_ITEM);
		DIAMOND_DETECTOR_ITEM =
			new DiamondDetector(new FabricItemSettings()
				.maxDamage(config.durabilityDiamondDetector));
		registerItem(
			"diamond_detector", DIAMOND_DETECTOR_ITEM);
		// Item groups
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(
			entries -> {
				entries.add(VOID_DETECTOR_ITEM);
				entries.add(COAL_DETECTOR_ITEM);
				entries.add(IRON_DETECTOR_ITEM);
				entries.add(GOLD_DETECTOR_ITEM);
				entries.add(DIAMOND_DETECTOR_ITEM);
			});
	}
}
