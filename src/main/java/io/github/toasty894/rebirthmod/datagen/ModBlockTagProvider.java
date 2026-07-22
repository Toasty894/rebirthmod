package io.github.toasty894.rebirthmod.datagen;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PITCHBLENDE_ORE)
                .add(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE)
                .add(ModBlocks.RAW_PITCHBLENDE_BLOCK)
                .add(ModBlocks.PITCHBLENDE_BLOCK)

                .add(ModBlocks.SCHEELITE_ORE)
                .add(ModBlocks.DEEPSLATE_SCHEELITE_ORE)
                .add(ModBlocks.RAW_SCHEELITE_BLOCK)
                .add(ModBlocks.TUNGSTEN_BLOCK)

                .add(ModBlocks.GALENA_ORE)
                .add(ModBlocks.DEEPSLATE_GALENA_ORE)
                .add(ModBlocks.RAW_GALENA_BLOCK)
                .add(ModBlocks.LEAD_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PITCHBLENDE_ORE)
                .add(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE)
                .add(ModBlocks.RAW_PITCHBLENDE_BLOCK)
                .add(ModBlocks.PITCHBLENDE_BLOCK)

                .add(ModBlocks.GALENA_ORE)
                .add(ModBlocks.DEEPSLATE_GALENA_ORE)
                .add(ModBlocks.RAW_GALENA_BLOCK)
                .add(ModBlocks.LEAD_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SCHEELITE_ORE)
                .add(ModBlocks.DEEPSLATE_SCHEELITE_ORE)
                .add(ModBlocks.RAW_SCHEELITE_BLOCK)
                .add(ModBlocks.TUNGSTEN_BLOCK);
    }
}
