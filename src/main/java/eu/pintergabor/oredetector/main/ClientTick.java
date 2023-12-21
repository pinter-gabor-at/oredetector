package eu.pintergabor.oredetector.main;

import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ClientTick {
	private ClientTick() {
	}

	public static int delay = 0;
	public static BlockPos position;
	public static SoundEvent sound;
	public static float volume = 1f;
	public static float pitch = 1f;

	public static void register() {
		ClientTickEvents.START_WORLD_TICK.register(client -> {
			synchronized (ClientTick.class) {
				if (delay == 1) {
					client.playSoundAtBlockCenter(position,
						sound, SoundCategory.BLOCKS, volume, pitch, true);
				}
				if (0 < delay) {
					delay--;
				}
			}
		});
	}
}
