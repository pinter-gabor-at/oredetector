package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class GoldDetector extends DetectOreDetector {
	public GoldDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[3];
	}

	/**
	 * Detect gold, redstone, lapis, diamond, and emerald
	 * <p>
	 * plus Tech Reborn silver and iridium
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		return detectSilver(blockState, distance) ||
			detectGold(blockState, distance) ||
			detectRedstone(blockState, distance) ||
			detectLapis(blockState, distance) ||
			detectDiamond(blockState, distance) ||
			detectIridium(blockState, distance) ||
			detectEmerald(blockState, distance);
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeGoldDetector;
	}
}
