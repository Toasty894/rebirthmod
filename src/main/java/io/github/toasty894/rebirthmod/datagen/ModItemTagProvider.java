package io.github.toasty894.rebirthmod.datagen;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PITCHBLENDE_HELMET)
                .add(ModItems.PITCHBLENDE_CHESTPLATE)
                .add(ModItems.PITCHBLENDE_LEGGINGS)
                .add(ModItems.PITCHBLENDE_BOOTS);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.ACAI_PLANKS.asItem())
                .add(ModBlocks.CASHEW_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ACAI_LOG.asItem())
                .add(ModBlocks.ACAI_WOOD.asItem())
                .add(ModBlocks.STRIPPED_ACAI_LOG.asItem())
                .add(ModBlocks.STRIPPED_ACAI_WOOD.asItem())
                .add(ModBlocks.CASHEW_LOG.asItem())
                .add(ModBlocks.CASHEW_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CASHEW_LOG.asItem())
                .add(ModBlocks.STRIPPED_CASHEW_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBlocks.ACAI_LEAVES.asItem())
                .add(ModBlocks.CASHEW_LEAVES.asItem());
    }
}
