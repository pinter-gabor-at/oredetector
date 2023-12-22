package eu.pintergabor.oredetector.item;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class DiamondDetector extends AbstractOreDetector {
	public DiamondDetector(Settings settings) {
		super(settings);
	}

	@Override
	protected boolean isDetectable(BlockPos pos, Direction facing) {
		distance = 0;
		type = 0;
		return false;
	}
}
