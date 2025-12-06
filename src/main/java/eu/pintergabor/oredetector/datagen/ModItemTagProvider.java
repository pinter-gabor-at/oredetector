package eu.pintergabor.oredetector.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.Global;

import net.minecraft.core.registries.Registries;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModItemTagProvider extends KeyTagProvider<Item> {

	@SuppressWarnings("unused")
	public ModItemTagProvider(
		PackOutput output,
		CompletableFuture<HolderLookup.Provider> lookupProvider,
		CompletableFuture<TagLookup<Block>> blockTagProvider
	) {
		super(output, Registries.ITEM, lookupProvider, Global.MODID);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
	}
}
