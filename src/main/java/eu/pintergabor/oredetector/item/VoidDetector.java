package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.sound.ModSounds;

import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

import org.jetbrains.annotations.NotNull;

public class VoidDetector extends AbstractOreDetector {
	public VoidDetector(Settings settings) {
		super(settings);
		bangs = ModSounds.DETECTOR_3BANGS[0];
	}

	/**
	 * Air
	 */
	protected boolean detectAir(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.AIR) || blockState.isAir()) {
			calcEcho(0, distance, Blocks.SNOW);
			return true;
		}
		return false;
	}

	/**
	 * Water
	 */
	protected boolean detectWater(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.WATER)) {
			calcEcho(2, distance, Blocks.WATER);
			return true;
		}
		return false;
	}

	/**
	 * Lava
	 */
	protected boolean detectLava(@NotNull BlockState blockState, int distance) {
		if (blockState.isIn(ModBlockTags.LAVA)) {
			calcEcho(3, distance, Blocks.LAVA);
			return true;
		}
		return false;
	}

	/**
	 * Some fluid
	 * <p>
	 * Called after checking water and lava
	 */
	protected boolean detectFluid(@NotNull BlockState blockState, int distance) {
		if (!blockState.getFluidState().isEmpty()) {
			calcEcho(4, distance, Blocks.WATER);
			return true;
		}
		return false;
	}

	/**
	 * Something partly transparent
	 * <p>
	 * Called last
	 */
	protected boolean detectTransparent(@NotNull BlockState blockState, int distance) {
		if (!blockState.isOpaqueFullCube(clickWorld, clickPos)) {
			calcEcho(1, distance, Blocks.SHORT_GRASS);
			return true;
		}
		return false;
	}

	/**
	 * Detect air, water, lava and other non-solid blocks
	 */
	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		return detectAir(blockState, distance) ||
			detectWater(blockState, distance) ||
			detectLava(blockState, distance) ||
			detectFluid(blockState, distance) ||
			detectTransparent(blockState, distance);
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeVoidDetector;
	}
}
