package eu.pintergabor.oredetector.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfigData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;


public final class ModItems {
	public static final DeferredRegister.Items ITEMS =
		DeferredRegister.createItems(Global.MODID);

	// Ore Detectors.
	public static DeferredItem<Item> VOID_DETECTOR_ITEM;
	public static DeferredItem<Item> FOCUSED_VOID_DETECTOR_ITEM;
	public static DeferredItem<Item> COAL_DETECTOR_ITEM;
	public static DeferredItem<Item> FOCUSED_COAL_DETECTOR_ITEM;
	public static DeferredItem<Item> IRON_DETECTOR_ITEM;
	public static DeferredItem<Item> FOCUSED_IRON_DETECTOR_ITEM;
	public static DeferredItem<Item> GOLD_DETECTOR_ITEM;
	public static DeferredItem<Item> FOCUSED_GOLD_DETECTOR_ITEM;
	public static DeferredItem<Item> DIAMOND_DETECTOR_ITEM;
	public static DeferredItem<Item> FOCUSED_DIAMOND_DETECTOR_ITEM;
	public static List<DeferredItem<Item>> DETECTORS = new ArrayList<>(10);

	/**
	 * Register one item.
	 */
	private static DeferredItem<Item> register(
		String path, Function<Item.Properties, Item> factory) {
		DeferredItem<Item> detector = ITEMS.registerItem(
			path, factory);
		DETECTORS.add(detector);
		return detector;
	}

	/**
	 * Create and register items.
	 */
	public static void init(IEventBus modEventBus) {
		// Create Ore Detectors.
		VOID_DETECTOR_ITEM = register("void_detector",
			props -> new VoidDetector(props
				.durability(ModConfigData.DURABILITY_VOID_DETECTOR.get())));
		FOCUSED_VOID_DETECTOR_ITEM = register("focused_void_detector",
			props -> new VoidDetector(props
				.durability(ModConfigData.DURABILITY_VOID_DETECTOR.get()), 2));
		COAL_DETECTOR_ITEM = register("coal_detector",
			props -> new CoalDetector(props
				.durability(ModConfigData.DURABILITY_COAL_DETECTOR.get())));
		FOCUSED_COAL_DETECTOR_ITEM = register("focused_coal_detector",
			props -> new CoalDetector(props
				.durability(ModConfigData.DURABILITY_COAL_DETECTOR.get()), 2));
		IRON_DETECTOR_ITEM = register("iron_detector",
			props -> new IronDetector(props
				.durability(ModConfigData.DURABILITY_IRON_DETECTOR.get())));
		FOCUSED_IRON_DETECTOR_ITEM = register("focused_iron_detector",
			props -> new IronDetector(props
				.durability(ModConfigData.DURABILITY_IRON_DETECTOR.get()), 2));
		GOLD_DETECTOR_ITEM = register("gold_detector",
			props -> new GoldDetector(props
				.durability(ModConfigData.DURABILITY_GOLD_DETECTOR.get())));
		FOCUSED_GOLD_DETECTOR_ITEM = register("focused_gold_detector",
			props -> new GoldDetector(props
				.durability(ModConfigData.DURABILITY_GOLD_DETECTOR.get()), 2));
		DIAMOND_DETECTOR_ITEM = register("diamond_detector",
			props -> new DiamondDetector(props
				.durability(ModConfigData.DURABILITY_DIAMOND_DETECTOR.get())));
		FOCUSED_DIAMOND_DETECTOR_ITEM = register("focused_diamond_detector",
			props -> new DiamondDetector(props
				.durability(ModConfigData.DURABILITY_DIAMOND_DETECTOR.get()), 2));
		// Register them on the mod event bus.
		ITEMS.register(modEventBus);
	}
}
