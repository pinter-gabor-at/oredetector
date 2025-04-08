package eu.pintergabor.oredetector.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;


/**
 * Detector where the detect rules can be expressed as a list.
 */
public abstract class DetectOreDetector extends AbstractOreDetector {

	public DetectOreDetector(Properties props, int focus) {
		super(props, focus);
	}

	/**
	 * List of detection rules.
	 */
	protected List<Echo> ECHOLIST;

	/**
	 * Detection rule.
	 * <p>
	 * If the block is in {@code tag} then create an echo {@code type} and generate {@code pBlock} particles.
	 */
	protected record Echo(TagKey<Block> tag, int type, @Nullable Block pBlock) {
	}

	@Override
	protected boolean detect(BlockPos pos, int distance) {
		// Check the block at this position.
		final BlockState blockState = clickWorld.getBlockState(pos);
		for (Echo e : ECHOLIST) {
			// If it is in the list...
			if (blockState.is(e.tag)) {
				// Calculate echo parameters from the distance.
				// Generate particles either as defined in the table,
				// or from the found block.
				calcEcho(e.type, distance,
					e.pBlock != null ? e.pBlock : blockState.getBlock());
				return true;
			}
		}
		return false;
	}
}
