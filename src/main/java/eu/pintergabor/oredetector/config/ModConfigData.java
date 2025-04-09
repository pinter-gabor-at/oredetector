package eu.pintergabor.oredetector.config;


import eu.pintergabor.oredetector.Global;
import net.neoforged.neoforge.common.ModConfigSpec;


public class ModConfigData {
	/**
	 * Builder.
	 */
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	/**
	 * Enable Void Detector.
	 */
	public static final ModConfigSpec.BooleanValue enableVoidDetector = BUILDER
		.translation(Global.modName("config.enableVoidDetector"))
		.define("enableVoidDetector", true);
	public static final ModConfigSpec.IntValue rangeVoidDetector = BUILDER
		.translation(Global.modName("config.rangeVoidDetector"))
		.defineInRange("rangeVoidDetector", 10, 1, 20);
	public static final ModConfigSpec.IntValue durabilityVoidDetector = BUILDER
		.translation(Global.modName("config.durabilityVoidDetector"))
		.defineInRange("durabilityVoidDetector", 100, 1, 999);

	/**
	 * Enable Coal Detector.
	 */
	public static final ModConfigSpec.BooleanValue enableCoalDetector = BUILDER
		.translation(Global.modName("config.enableCoalDetector"))
		.define("enableCoalDetector", true);
	public static final ModConfigSpec.IntValue rangeCoalDetector = BUILDER
		.translation(Global.modName("config.rangeCoalDetector"))
		.defineInRange("rangeCoalDetector", 9, 1, 20);
	public static final ModConfigSpec.IntValue durabilityCoalDetector = BUILDER
		.translation(Global.modName("config.durabilityCoalDetector"))
		.defineInRange("durabilityCoalDetector", 100, 1, 999);

	/**
	 * Enable Iron Detector.
	 */
	public static final ModConfigSpec.BooleanValue enableIronDetector = BUILDER
		.translation(Global.modName("config.enableIronDetector"))
		.define("enableIronDetector", true);
	public static final ModConfigSpec.IntValue rangeIronDetector = BUILDER
		.translation(Global.modName("config.rangeIronDetector"))
		.defineInRange("rangeIronDetector", 10, 1, 20);
	public static final ModConfigSpec.IntValue durabilityIronDetector = BUILDER
		.translation(Global.modName("config.durabilityIronDetector"))
		.defineInRange("durabilityIronDetector", 150, 1, 999);

	/**
	 * Enable Gold Detector.
	 */
	public static final ModConfigSpec.BooleanValue enableGoldDetector = BUILDER
		.translation(Global.modName("config.enableGoldDetector"))
		.define("enableGoldDetector", true);
	public static final ModConfigSpec.IntValue rangeGoldDetector = BUILDER
		.translation(Global.modName("config.rangeGoldDetector"))
		.defineInRange("rangeGoldDetector", 11, 1, 20);
	public static final ModConfigSpec.IntValue durabilityGoldDetector = BUILDER
		.translation(Global.modName("config.durabilityGoldDetector"))
		.defineInRange("durabilityGoldDetector", 200, 1, 999);

	/**
	 * Enable Diamond Detector.
	 */
	public static final ModConfigSpec.BooleanValue enableDiamondDetector = BUILDER
		.translation(Global.modName("config.enableDiamondDetector"))
		.define("enableDiamondDetector", true);
	public static final ModConfigSpec.IntValue rangeDiamondDetector = BUILDER
		.translation(Global.modName("config.rangeDiamondDetector"))
		.defineInRange("rangeDiamondDetector", 12, 1, 20);
	public static final ModConfigSpec.IntValue durabilityDiamondDetector = BUILDER
		.translation(Global.modName("config.durabilityDiamondDetector"))
		.defineInRange("durabilityDiamondDetector", 250, 1, 999);

	/**
	 * Enable Particles.
	 */
	public static final ModConfigSpec.BooleanValue enableParticles = BUILDER
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
	public static final ModConfigSpec.IntValue debugLevel = BUILDER
		.translation(Global.modName("config.debugLevel"))
		.defineInRange("debugLevel", 0, 0, 3);

	// Build and prepare for registration.
	public static final ModConfigSpec SPEC = BUILDER.build();
}
