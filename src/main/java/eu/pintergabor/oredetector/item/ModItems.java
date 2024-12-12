package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfig;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class ModItems {

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
                new VoidDetector(new Item.Settings()
                        .maxDamage(config.durabilityVoidDetector));
        registerItem(
                "void_detector", VOID_DETECTOR_ITEM);
        COAL_DETECTOR_ITEM =
                new CoalDetector(new Item.Settings()
                        .maxDamage(config.durabilityCoalDetector));
        registerItem(
                "coal_detector", COAL_DETECTOR_ITEM);
        IRON_DETECTOR_ITEM =
                new IronDetector(new Item.Settings()
                        .maxDamage(config.durabilityIronDetector));
        registerItem(
                "iron_detector", IRON_DETECTOR_ITEM);
        GOLD_DETECTOR_ITEM =
                new GoldDetector(new Item.Settings()
                        .maxDamage(config.durabilityGoldDetector));
        registerItem(
                "gold_detector", GOLD_DETECTOR_ITEM);
        DIAMOND_DETECTOR_ITEM =
                new DiamondDetector(new Item.Settings()
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

    /**
     * Register mod item
     *
     * @param name Name, as in lang/*.json files without the "item.modid." prefix
     * @param item Item
     * @return The same item
     */
    @SuppressWarnings("UnusedReturnValue")
    public static Item registerItem(String name, Item item) {
        return Registry.register(
                Registries.ITEM,
                Global.ModIdentifier(name),
                item);
    }
}
