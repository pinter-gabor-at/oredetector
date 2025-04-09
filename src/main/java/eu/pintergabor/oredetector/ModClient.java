package eu.pintergabor.oredetector;

import eu.pintergabor.oredetector.item.CreativeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;


/**
 * Client side startup.
 */
@Mod(value = Global.MODID, dist = Dist.CLIENT)
public final class ModClient {

	@SuppressWarnings("unused")
	public ModClient(IEventBus modEventBus, ModContainer modContainer) {
		// Config screen.
		modContainer.registerExtensionPoint(
			IConfigScreenFactory.class,
			// Do not display config parameters whose names are starting with "debug".
			(mod, parent) -> {
				return new ConfigurationScreen(mod, parent,
					(context, key, original) ->
						key.matches("^debug.*") ? null : original);
			});
		// Creative tabs.
		modEventBus.addListener(CreativeTabs::init);
		// Data generator.
		modEventBus.addListener(DataGen::init);
	}
}
