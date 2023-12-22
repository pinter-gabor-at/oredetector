package eu.pintergabor.oredetector.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@Config(name = "oredetector")
public class ModConfig implements ConfigData {
	@ConfigEntry.Gui.Tooltip
	public boolean enableVoidDetector = true;

	@ConfigEntry.Gui.Tooltip
	public int rangeVoidDetector = 8;

	@ConfigEntry.Gui.Tooltip
	public int durabilityVoidDetector = 200;

	@ConfigEntry.Gui.Tooltip
	public boolean enableCoalDetector = true;

	@ConfigEntry.Gui.Tooltip
	public int rangeCoalDetector = 8;

	@ConfigEntry.Gui.Tooltip
	public int durabilityCoalDetector = 200;

	@ConfigEntry.Gui.Tooltip
	public boolean enableIronDetector = true;

	@ConfigEntry.Gui.Tooltip
	public int rangeIronDetector = 8;

	@ConfigEntry.Gui.Tooltip
	public int durabilityIronDetector = 250;

	@ConfigEntry.Gui.Tooltip
	public boolean enableGoldDetector = true;

	@ConfigEntry.Gui.Tooltip
	public int rangeGoldDetector = 8;

	@ConfigEntry.Gui.Tooltip
	public int durabilityGoldDetector = 300;

	@ConfigEntry.Gui.Tooltip
	public boolean enableDiamondDetector = true;

	@ConfigEntry.Gui.Tooltip
	public int rangeDiamondDetector = 8;

	@ConfigEntry.Gui.Tooltip
	public int durabilityDiamondDetector = 350;

	public static void init() {
		AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
	}

	public static ModConfig getInstance() {
		return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
	}

	@Override
	public void validatePostLoad() throws ValidationException {
		rangeVoidDetector = Math.min(Math.max(1, rangeVoidDetector), 16);
		durabilityVoidDetector = Math.min(Math.max(1, durabilityVoidDetector), 999);
		rangeCoalDetector = Math.min(Math.max(1, rangeCoalDetector), 16);
		durabilityCoalDetector = Math.min(Math.max(1, durabilityCoalDetector), 999);
		rangeIronDetector = Math.min(Math.max(1, rangeIronDetector), 16);
		durabilityIronDetector = Math.min(Math.max(1, durabilityIronDetector), 999);
		rangeGoldDetector = Math.min(Math.max(1, rangeGoldDetector), 16);
		durabilityGoldDetector = Math.min(Math.max(1, durabilityGoldDetector), 999);
		rangeDiamondDetector = Math.min(Math.max(1, rangeDiamondDetector), 16);
		durabilityDiamondDetector = Math.min(Math.max(1, durabilityDiamondDetector), 999);
	}
}
