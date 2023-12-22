package eu.pintergabor.oredetector.mixin;

import eu.pintergabor.oredetector.mixinutil.DelayedExecute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin
	extends LivingEntity
	implements DelayedExecute {
	private ServerPlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Unique
	private boolean running = false;
	@Unique
	private long triggerTime;
	@Unique
	private Runnable action;

	@Inject(method = "tick", at = @At(value = "HEAD"))
	private void tick(CallbackInfo ci) {
		if (!getWorld().isClient()) {
			if (running && triggerTime <= getWorld().getTime()) {
				action.run();
				running = false;
			}
		}
	}

	/**
	 * @return true if the previous delayed action is still waiting to be triggered.
	 */
	@Unique
	public boolean oredetector$isRunning(){
		return running;
	}

	/**
	 * Execute {@code action} after {@code delay} ticks
	 * <p>
	 * There can be only one delayed action at any time. New delayed action cannot be started until the previous one
	 * gets triggered.
	 * @return true on success
	 */
	@Unique
	@SuppressWarnings("UnusedReturnValue")
	public boolean oredetector$delayedExecute(int delay, Runnable action) {
		if (running) return false;
		this.triggerTime = getWorld().getTime() + delay;
		this.action = action;
		running = true;
		return true;
	}
}
