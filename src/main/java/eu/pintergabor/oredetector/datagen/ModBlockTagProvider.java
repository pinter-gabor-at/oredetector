package eu.pintergabor.oredetector.datagen;

import java.util.concurrent.CompletableFuture;

import eu.pintergabor.oredetector.tag.ModBlockTags;

import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output,
		CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
		getOrCreateTagBuilder(ModBlockTags.VOID_DETECT0)
			.add(Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR);
		getOrCreateTagBuilder(ModBlockTags.VOID_DETECT1)
			.add(Blocks.WATER);
		getOrCreateTagBuilder(ModBlockTags.VOID_DETECT2)
			.add(Blocks.LAVA);
    }
}
