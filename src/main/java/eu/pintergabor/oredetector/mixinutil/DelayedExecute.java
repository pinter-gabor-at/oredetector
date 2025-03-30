package eu.pintergabor.oredetector.mixinutil;


public interface DelayedExecute {

	boolean oredetector$isRunning();

	@SuppressWarnings("UnusedReturnValue")
	boolean oredetector$delayedExecute(int delay, Runnable action);
}
