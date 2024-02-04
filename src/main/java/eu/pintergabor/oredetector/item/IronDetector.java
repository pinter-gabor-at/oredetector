package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class IronDetector extends DetectOreDetector {
	public IronDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[2];
	}

	/**
	 * Detect iron, gold, redstone and lapis ores
	 * <p>
	 * plus Tech Reborn galena, tin, lead, ruby, sapphire, silver and bauxite
	 * <p>
	 * plus Applied Energistics certus quartz
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		return detectGalena(blockState, distance) ||
			detectTin(blockState, distance) ||
			detectLead(blockState, distance) ||
			detectCopper(blockState, distance) ||
			detectIron(blockState, distance) ||
			detectQuartz(blockState, distance) ||
			detectRuby(blockState, distance) ||
			detectBauxite(blockState, distance) ||
			detectSilver(blockState, distance) ||
			detectGold(blockState, distance) ||
			detectRedstone(blockState, distance) ||
			detectLapis(blockState, distance);
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeIronDetector;
	}
}
