package eu.pintergabor.oredetector.sound;

import java.util.stream.IntStream;

import eu.pintergabor.oredetector.Global;
import org.jspecify.annotations.NonNull;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;


public final class ModSounds {
	public static final SoundEvent[] DETECTOR_3BANGS = new SoundEvent[5];
	public static final SoundEvent[] DETECTOR_3ECHOS = new SoundEvent[16];

	private static @NonNull SoundEvent register(String name) {
		final Identifier id = Global.modId(name);
		return Registry.register(
			BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
	}

	public static void init() {
		IntStream.range(0, DETECTOR_3BANGS.length).forEach(
			i -> DETECTOR_3BANGS[i] = register(String.format("detector_3bangs%d", i)));
		IntStream.range(0, DETECTOR_3ECHOS.length).forEach(
			i -> DETECTOR_3ECHOS[i] = register(String.format("detector_3echos%02d", i)));
	}
}
