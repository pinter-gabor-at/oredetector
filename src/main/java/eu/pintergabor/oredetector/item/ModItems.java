package eu.pintergabor.oredetector.item;

import java.util.function.Function;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfig;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;


public final class ModItems {

	// Ore Detectors.
	public static Item VOID_DETECTOR_ITEM;
	public static Item FOCUSED_VOID_DETECTOR_ITEM;
	public static Item IRON_DETECTOR_ITEM;
	public static Item FOCUSED_IRON_DETECTOR_ITEM;
	public static Item DIAMOND_DETECTOR_ITEM;
	public static Item COAL_DETECTOR_ITEM;
	public static Item FOCUSED_COAL_DETECTOR_ITEM;
	public static Item GOLD_DETECTOR_ITEM;
	public static Item FOCUSED_GOLD_DETECTOR_ITEM;
	public static Item FOCUSED_DIAMOND_DETECTOR_ITEM;

	/**
	 * Create and register items.
	 */
	public static void init() {
		var config = ModConfig.getInstance();
		// Create and register Ore Detectors.
		VOID_DETECTOR_ITEM =
			register("void_detector",
				VoidDetector::new,
				config.durabilityVoidDetector);
		FOCUSED_VOID_DETECTOR_ITEM =
			register("focused_void_detector",
				settings -> new VoidDetector(settings, 2),
				config.durabilityVoidDetector);
		COAL_DETECTOR_ITEM = register("coal_detector",
			CoalDetector::new,
			config.durabilityCoalDetector);
		FOCUSED_COAL_DETECTOR_ITEM = register("focused_coal_detector",
			settings -> new CoalDetector(settings, 2),
			config.durabilityCoalDetector);
		IRON_DETECTOR_ITEM = register("iron_detector",
			IronDetector::new,
			config.durabilityIronDetector);
		FOCUSED_IRON_DETECTOR_ITEM = register("focused_iron_detector",
			settings -> new IronDetector(settings, 2),
			config.durabilityIronDetector);
		GOLD_DETECTOR_ITEM = register("gold_detector",
			GoldDetector::new,
			config.durabilityGoldDetector);
		FOCUSED_GOLD_DETECTOR_ITEM = register("focused_gold_detector",
			settings -> new GoldDetector(settings, 2),
			config.durabilityGoldDetector);
		DIAMOND_DETECTOR_ITEM = register("diamond_detector",
			DiamondDetector::new,
			config.durabilityDiamondDetector);
		FOCUSED_DIAMOND_DETECTOR_ITEM = register("focused_diamond_detector",
			settings -> new DiamondDetector(settings, 2),
			config.durabilityDiamondDetector);
		// Item groups.
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(
			entries -> {
				entries.add(VOID_DETECTOR_ITEM);
				entries.add(FOCUSED_VOID_DETECTOR_ITEM);
				entries.add(IRON_DETECTOR_ITEM);
				entries.add(FOCUSED_IRON_DETECTOR_ITEM);
				entries.add(DIAMOND_DETECTOR_ITEM);
				entries.add(COAL_DETECTOR_ITEM);
				entries.add(FOCUSED_COAL_DETECTOR_ITEM);
				entries.add(GOLD_DETECTOR_ITEM);
				entries.add(FOCUSED_GOLD_DETECTOR_ITEM);
				entries.add(FOCUSED_DIAMOND_DETECTOR_ITEM);
			});
	}

	private static Item register(String path, Function<Item.Settings, Item> factory, int durability) {
		return Items.register(
			RegistryKey.of(RegistryKeys.ITEM, Global.modId(path)),
			factory,
			new Item.Settings().maxDamage(durability));
	}
}
