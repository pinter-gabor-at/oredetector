package eu.pintergabor.oredetector.item;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class IronDetector extends AbstractOreDetector {
	public IronDetector(Settings settings) {
		super(settings);
	}

	@Override
	protected boolean isDetectable(BlockPos pos, Direction facing) {
		distance = 0;
		type = 0;
		return false;
	}
}
