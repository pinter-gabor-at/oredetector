package eu.pintergabor.oredetector.sound;

import eu.pintergabor.oredetector.Global;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jspecify.annotations.NonNull;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

import java.util.stream.IntStream;


public final class ModSounds {
	// Registry.
	private static final DeferredRegister<SoundEvent> SOUND_EVENTS =
		DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Global.MODID);

	private ModSounds() {
		// Static class.
	}

	@SuppressWarnings("unchecked")
	public static final Holder<SoundEvent>[] DETECTOR_3BANGS = new Holder[5];
	@SuppressWarnings("unchecked")
	public static final Holder<SoundEvent>[] DETECTOR_3ECHOS = new Holder[16];

	/**
	 * Create and add one sound to the registry.
	 */
	private static @NonNull Holder<SoundEvent> register(String name) {
		return SOUND_EVENTS.register(name, SoundEvent::createVariableRangeEvent);
	}

	/**
	 * Register all sounds.
	 */
	public static void init(IEventBus modEventBus) {
		IntStream.range(0, DETECTOR_3BANGS.length).forEach(
			i -> DETECTOR_3BANGS[i] = register(String.format("detector_3bangs%d", i)));
		IntStream.range(0, DETECTOR_3ECHOS.length).forEach(
			i -> DETECTOR_3ECHOS[i] = register(String.format("detector_3echos%02d", i)));
		SOUND_EVENTS.register(modEventBus);
	}
}
