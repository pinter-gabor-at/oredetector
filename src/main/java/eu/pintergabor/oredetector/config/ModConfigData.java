package eu.pintergabor.oredetector.config;

import eu.pintergabor.oredetector.Global;
import net.neoforged.neoforge.common.ModConfigSpec;


public final class ModConfigData {
	/**
	 * Builder.
	 */
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	/**
	 * Enable Void Detector.
	 */
	public static final ModConfigSpec.BooleanValue ENABLE_VOID_DETECTOR = BUILDER
		.translation(Global.modName("config.enableVoidDetector"))
		.define("enableVoidDetector", true);
	public static final ModConfigSpec.IntValue RANGE_VOID_DETECTOR = BUILDER
		.translation(Global.modName("config.rangeVoidDetector"))
		.defineInRange("rangeVoidDetector", 10, 1, 20);
	public static final ModConfigSpec.IntValue DURABILITY_VOID_DETECTOR = BUILDER
		.translation(Global.modName("config.durabilityVoidDetector"))
		.defineInRange("durabilityVoidDetector", 100, 1, 999);

	/**
	 * Enable Coal Detector.
	 */
	public static final ModConfigSpec.BooleanValue ENABLE_COAL_DETECTOR = BUILDER
		.translation(Global.modName("config.enableCoalDetector"))
		.define("enableCoalDetector", true);
	public static final ModConfigSpec.IntValue RANGE_COAL_DETECTOR = BUILDER
		.translation(Global.modName("config.rangeCoalDetector"))
		.defineInRange("rangeCoalDetector", 9, 1, 20);
	public static final ModConfigSpec.IntValue DURABILITY_COAL_DETECTOR = BUILDER
		.translation(Global.modName("config.durabilityCoalDetector"))
		.defineInRange("durabilityCoalDetector", 100, 1, 999);

	/**
	 * Enable Iron Detector.
	 */
	public static final ModConfigSpec.BooleanValue ENABLE_IRON_DETECTOR = BUILDER
		.translation(Global.modName("config.enableIronDetector"))
		.define("enableIronDetector", true);
	public static final ModConfigSpec.IntValue RANGE_IRON_DETECTOR = BUILDER
		.translation(Global.modName("config.rangeIronDetector"))
		.defineInRange("rangeIronDetector", 10, 1, 20);
	public static final ModConfigSpec.IntValue DURABILITY_IRON_DETECTOR = BUILDER
		.translation(Global.modName("config.durabilityIronDetector"))
		.defineInRange("durabilityIronDetector", 150, 1, 999);

	/**
	 * Enable Gold Detector.
	 */
	public static final ModConfigSpec.BooleanValue ENABLE_GOLD_DETECTOR = BUILDER
		.translation(Global.modName("config.enableGoldDetector"))
		.define("enableGoldDetector", true);
	public static final ModConfigSpec.IntValue RANGE_GOLD_DETECTOR = BUILDER
		.translation(Global.modName("config.rangeGoldDetector"))
		.defineInRange("rangeGoldDetector", 11, 1, 20);
	public static final ModConfigSpec.IntValue DURABILITY_GOLD_DETECTOR = BUILDER
		.translation(Global.modName("config.durabilityGoldDetector"))
		.defineInRange("durabilityGoldDetector", 200, 1, 999);

	/**
	 * Enable Diamond Detector.
	 */
	public static final ModConfigSpec.BooleanValue ENABLE_DIAMOND_DETECTOR = BUILDER
		.translation(Global.modName("config.enableDiamondDetector"))
		.define("enableDiamondDetector", true);
	public static final ModConfigSpec.IntValue RANGE_DIAMOND_DETECTOR = BUILDER
		.translation(Global.modName("config.rangeDiamondDetector"))
		.defineInRange("rangeDiamondDetector", 12, 1, 20);
	public static final ModConfigSpec.IntValue DURABILITY_DIAMOND_DETECTOR = BUILDER
		.translation(Global.modName("config.durabilityDiamondDetector"))
		.defineInRange("durabilityDiamondDetector", 250, 1, 999);

	/**
	 * Enable Particles.
	 */
	public static final ModConfigSpec.BooleanValue ENABLE_PARTICLES = BUILDER
		.translation(Global.modName("config.enableParticles"))
		.define("enableParticles", true);

	/**
	 * Hidden debug level control for developers.
	 * <p>
	 * <div>0 = No debugging (default).</div>
	 * <div>1 = Only non-destructive debugging.</div>
	 * <div>2 = More verbose.</div>
	 * <div>3 = Destructive and time consuming debugging.</div>
	 */
	public static final ModConfigSpec.IntValue DEBUG_LEVEL = BUILDER
		.translation(Global.modName("config.debugLevel"))
		.defineInRange("debugLevel", 0, 0, 3);

	// Build and prepare for registration.
	public static final ModConfigSpec SPEC = BUILDER.build();
}
