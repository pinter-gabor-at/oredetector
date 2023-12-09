package eu.pintergabor.oredetector.sound;

import eu.pintergabor.oredetector.util.ModIdentifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent DETECTOR_3BANGS;

    @SuppressWarnings("SameParameterValue")
	private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new ModIdentifier(name);
        return Registry.register(Registries.SOUND_EVENT,
			identifier,
			SoundEvent.of(identifier));
    }

    public static void register() {
		DETECTOR_3BANGS = registerSoundEvent("detector_3bangs");
    }
}
