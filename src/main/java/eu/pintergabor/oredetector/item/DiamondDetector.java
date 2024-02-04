package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class DiamondDetector extends DetectOreDetector {
	public DiamondDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[4];
	}

	/**
	 * Detect only diamond, emerald and netherite ores
	 * <p>
	 * plus Tech Reborn iridium, pyrite, cinnabar, sphalerite, tungsten, sheldonite, peridot and sodalite
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		return detectDiamond(blockState, distance) ||
			detectIridium(blockState, distance) ||
			detectEmerald(blockState, distance) ||
			detectNether(blockState, distance) ||
			detectPyrite(blockState, distance) ||
			detectCinnabar(blockState, distance) ||
			detectSphalerite(blockState, distance) ||
			detectTungsten(blockState, distance) ||
			detectSheldonite(blockState, distance) ||
			detectPeridot(blockState, distance) ||
			detectSodalite(blockState, distance);
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeDiamondDetector;
	}
}
