package eu.pintergabor.oredetector.item;

import eu.pintergabor.oredetector.Global;
import eu.pintergabor.oredetector.config.ModConfig;
import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

public class VoidDetector extends AbstractOreDetector {
	public VoidDetector(Settings settings) {
		super(settings);
	}

	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		if (blockState.isIn(ModBlockTags.AIR) || blockState.isAir()) {
			// Air
			calcEcho(0, distance);
		} else if (blockState.isIn(ModBlockTags.WATER)) {
			// Water
			calcEcho(2, distance);
		} else if (blockState.isIn(ModBlockTags.LAVA)) {
			// Lava
			calcEcho(3, distance);
		} else if (!blockState.getFluidState().isEmpty()) {
			// Some fluid, which is not water or lava
			calcEcho(4, distance);
		} else if (!blockState.isOpaqueFullCube(clickWorld, clickPos)) {
			// Something partly transparent
			calcEcho(1, distance);
		} else {
			// DEBUG: Replace the scanned and not detectable block with glass to see the detected block
			// clickWorld.setBlockState(pos, Blocks.GLASS.getDefaultState(), Block.NOTIFY_ALL);
			return false;
		}
		// DEBUG: Found
		Global.LOGGER.info("Found: {}, type: {}, at ({})",
			blockState.getBlock().toString(), type, pos.subtract(clickPos).toShortString());
		return true;
	}

	@Override
	protected int getRange() {
		final var config = ModConfig.getInstance();
		return config.rangeVoidDetector;
	}
}
