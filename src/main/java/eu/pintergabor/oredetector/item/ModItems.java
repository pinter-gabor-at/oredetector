package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfig;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

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
        VOID_DETECTOR_ITEM = (VoidDetector) Items.register(
                RegistryKey.of(RegistryKeys.ITEM, Global.ModIdentifier("void_detector")),
                VoidDetector::new,
                new Item.Settings().maxDamage(config.durabilityVoidDetector));
        COAL_DETECTOR_ITEM = (CoalDetector) Items.register(
                RegistryKey.of(RegistryKeys.ITEM, Global.ModIdentifier("coal_detector")),
                CoalDetector::new,
                new Item.Settings().maxDamage(config.durabilityCoalDetector));
        IRON_DETECTOR_ITEM = (IronDetector) Items.register(
                RegistryKey.of(RegistryKeys.ITEM, Global.ModIdentifier("iron_detector")),
                IronDetector::new,
                new Item.Settings().maxDamage(config.durabilityIronDetector));
        GOLD_DETECTOR_ITEM = (GoldDetector) Items.register(
                RegistryKey.of(RegistryKeys.ITEM, Global.ModIdentifier("gold_detector")),
                GoldDetector::new,
                new Item.Settings().maxDamage(config.durabilityGoldDetector));
        DIAMOND_DETECTOR_ITEM = (DiamondDetector) Items.register(
                RegistryKey.of(RegistryKeys.ITEM, Global.ModIdentifier("diamond_detector")),
                DiamondDetector::new,
                new Item.Settings().maxDamage(config.durabilityDiamondDetector));
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
