package eu.pintergabor.oredetector.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;

/**
 * Detector where the detect rules can be expressed as a list
 */
public abstract class DetectOreDetector extends AbstractOreDetector {
	public DetectOreDetector(Settings settings) {
		super(settings);
	}

	/**
	 * List of detection rules
	 */
	protected List<Echo> ECHOLIST;

	/**
	 * Detection rule
	 * <p>
	 * If the block is in {@code tag} then create an echo {@code type} and generate {@code pBlock} particles.
	 */
	protected record Echo(TagKey<Block> tag, int type, @Nullable Block pBlock) {
	}

	@Override
	protected boolean detect(BlockPos pos, int distance) {
		final BlockState blockState = clickWorld.getBlockState(pos);
		for (var e : ECHOLIST) {
			if (blockState.isIn(e.tag)) {
				calcEcho(e.type, distance, e.pBlock == null ? blockState.getBlock() : e.pBlock);
				return true;
			}
		}
		return false;
	}
}
