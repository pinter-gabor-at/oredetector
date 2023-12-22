package eu.pintergabor.oredetector.main;

import static eu.pintergabor.oredetector.Global.LOGGER;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class ServerTick {
	private ServerTick() {
	}

	private static boolean running = false;
	private static int delay = 0;
	private static long triggerTime;
	private static Runnable action;



	public static BlockPos pos;
	public static SoundEvent sound;
	public static float volume = 1f;
	public static float pitch = 1f;

	public static void register() {
		ServerTickEvents.END_WORLD_TICK.register(world -> {
			synchronized (ServerTick.class) {
				if (running && triggerTime <= world.getTime()) {
					running=false;
					action.run();
				}
//				LOGGER.info("Tick: {}", world.getTime());
//				if (delay == 1) {
//					world.playSound(null, pos,
//						sound, SoundCategory.BLOCKS, volume, pitch);
//				}
//				if (0 < delay) {
//					delay--;
//				}
			}
		});
	}

	public static boolean isRunning(){
		return running;
//		delayedExecute(3, ()->{
//			LOGGER.info("Bang");
//		});
	}

	@SuppressWarnings("UnusedReturnValue")
	public static boolean delayedExecute(ServerWorld world, int delay, Runnable bang) {
		if (running) {
			return false;
		}
		triggerTime = world.getTime()+delay;
		action = bang;
		running = true;
		return true;
	}


}
