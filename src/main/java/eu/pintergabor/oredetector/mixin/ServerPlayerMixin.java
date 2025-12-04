package eu.pintergabor.oredetector.mixin;

import eu.pintergabor.oredetector.mixinutil.DelayedExecute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;


/**
 * Inject delayed action method that is linked to the player,
 * and ticked by the {@link ServerPlayer#tick()}.
 */
@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin
	extends LivingEntity
	implements DelayedExecute {

	private ServerPlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
		super(entityType, level);
	}

	@Unique
	private boolean balancedOreDetector$running = false;
	@Unique
	private long balancedOreDetector$triggerTime;
	@Unique
	private Runnable balancedOreDetector$action;

	@Inject(method = "tick", at = @At(value = "HEAD"))
	private void playerTick(CallbackInfo ci) {
		if (balancedOreDetector$running && balancedOreDetector$triggerTime <= level().getGameTime()) {
			balancedOreDetector$action.run();
			balancedOreDetector$running = false;
		}
	}

	/**
	 * @return true if the previous delayed action is still waiting to be triggered.
	 */
	@Unique
	public boolean oredetector$isRunning() {
		return balancedOreDetector$running;
	}

	/**
	 * Execute {@code action} after {@code delay} ticks.
	 * <p>
	 * There can be only one delayed action at any time.
	 * New delayed action cannot be started until the previous one gets triggered.
	 *
	 * @return true on success.
	 */
	@Unique
	@SuppressWarnings("UnusedReturnValue")
	public boolean oredetector$delayedExecute(int delay, Runnable action) {
		if (balancedOreDetector$running) return false;
		balancedOreDetector$triggerTime = level().getGameTime() + delay;
		balancedOreDetector$action = action;
		balancedOreDetector$running = true;
		return true;
	}
}
