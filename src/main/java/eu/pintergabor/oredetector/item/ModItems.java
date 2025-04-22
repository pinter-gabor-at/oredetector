package eu.pintergabor.oredetector.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfig;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;


public final class ModItems {

	// Ore Detectors.
	public static Item VOID_DETECTOR_ITEM;
	public static Item FOCUSED_VOID_DETECTOR_ITEM;
	public static Item COAL_DETECTOR_ITEM;
	public static Item FOCUSED_COAL_DETECTOR_ITEM;
	public static Item IRON_DETECTOR_ITEM;
	public static Item FOCUSED_IRON_DETECTOR_ITEM;
	public static Item GOLD_DETECTOR_ITEM;
	public static Item FOCUSED_GOLD_DETECTOR_ITEM;
	public static Item DIAMOND_DETECTOR_ITEM;
	public static Item FOCUSED_DIAMOND_DETECTOR_ITEM;
	public static List<Item> DETECTORS;

	/**
	 * Register one item.
	 */
	private static Item register(
		String path, Function<Item.Properties, Item> factory, int durability
	) {
		Item detector = Items.registerItem(
			ResourceKey.create(Registries.ITEM, Global.modId(path)),
			factory,
			new Item.Properties().durability(durability));
		DETECTORS.add(detector);
		return detector;
	}

	/**
	 * Create and register items.
	 */
	public static void init() {
		final var config = ModConfig.getInstance();
		DETECTORS = new ArrayList<>(10);
		// Create and register Ore Detectors.
		VOID_DETECTOR_ITEM =
			register("void_detector",
				VoidDetector::new,
				config.durabilityVoidDetector);
		FOCUSED_VOID_DETECTOR_ITEM =
			register("focused_void_detector",
				props -> new VoidDetector(props, 2),
				config.durabilityVoidDetector);
		COAL_DETECTOR_ITEM = register("coal_detector",
			CoalDetector::new,
			config.durabilityCoalDetector);
		FOCUSED_COAL_DETECTOR_ITEM = register("focused_coal_detector",
			props -> new CoalDetector(props, 2),
			config.durabilityCoalDetector);
		IRON_DETECTOR_ITEM = register("iron_detector",
			IronDetector::new,
			config.durabilityIronDetector);
		FOCUSED_IRON_DETECTOR_ITEM = register("focused_iron_detector",
			props -> new IronDetector(props, 2),
			config.durabilityIronDetector);
		GOLD_DETECTOR_ITEM = register("gold_detector",
			GoldDetector::new,
			config.durabilityGoldDetector);
		FOCUSED_GOLD_DETECTOR_ITEM = register("focused_gold_detector",
			props -> new GoldDetector(props, 2),
			config.durabilityGoldDetector);
		DIAMOND_DETECTOR_ITEM = register("diamond_detector",
			DiamondDetector::new,
			config.durabilityDiamondDetector);
		FOCUSED_DIAMOND_DETECTOR_ITEM = register("focused_diamond_detector",
			props -> new DiamondDetector(props, 2),
			config.durabilityDiamondDetector);
		// Item groups.
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(
			entries -> {
				for (Item detector : DETECTORS) {
					entries.accept(detector);
				}
			});
	}
}
