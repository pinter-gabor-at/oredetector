package eu.pintergabor.oredetector.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfigClient;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;


@Environment(EnvType.CLIENT)
public final class ModMenu implements ModMenuApi {

	@Contract(pure = true)
	@Override
	public @NonNull ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> AutoConfigClient.getConfigScreen(ModConfig.class, parent).get();
	}
}
