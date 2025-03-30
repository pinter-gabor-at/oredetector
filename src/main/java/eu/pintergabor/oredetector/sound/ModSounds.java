package eu.pintergabor.oredetector.sound;

import eu.pintergabor.oredetector.Global;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class ModSounds {
	public static SoundEvent[] DETECTOR_3BANGS = new SoundEvent[5];
	public static SoundEvent[] DETECTOR_3ECHOS = new SoundEvent[16];

	private static SoundEvent register(String name) {
		Identifier id = Global.modId(name);
		return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
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
