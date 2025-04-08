package eu.pintergabor.oredetector.datagen;

import eu.pintergabor.oredetector.Global;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends ItemTagsProvider {

	public ModItemTagProvider(
		PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagProvider) {
		super(output, lookupProvider, blockTagProvider, Global.MODID);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
	}
}
