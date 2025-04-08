package eu.pintergabor.oredetector.sound;

import eu.pintergabor.oredetector.Global;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;


public class ModSounds {
	public static SoundEvent[] DETECTOR_3BANGS = new SoundEvent[5];
	public static SoundEvent[] DETECTOR_3ECHOS = new SoundEvent[16];

	private static SoundEvent register(String name) {
		ResourceLocation id = Global.modId(name);
		return Registry.register(
			BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
	}

	public static void init() {
		for (int i = 0; i < DETECTOR_3BANGS.length; i++) {
			DETECTOR_3BANGS[i] = register(String.format("detector_3bangs%d", i));
		}
		for (int i = 0; i < DETECTOR_3ECHOS.length; i++) {
			DETECTOR_3ECHOS[i] = register(String.format("detector_3echos%02d", i));
		}
	}
}
