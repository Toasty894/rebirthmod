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
        // Tools requirement
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.ACAI_LOG, ModBlocks.STRIPPED_ACAI_LOG, ModBlocks.ACAI_WOOD, ModBlocks.STRIPPED_ACAI_WOOD, ModBlocks.ACAI_PLANKS)
                .add(ModBlocks.CASHEW_LOG, ModBlocks.STRIPPED_CASHEW_LOG, ModBlocks.CASHEW_WOOD, ModBlocks.STRIPPED_CASHEW_WOOD, ModBlocks.CASHEW_PLANKS);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.ACAI_LEAVES, ModBlocks.CASHEW_LEAVES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PITCHBLENDE_ORE)
                .add(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE)
                .add(ModBlocks.RAW_PITCHBLENDE_BLOCK)
                .add(ModBlocks.PITCHBLENDE_BLOCK)

                .add(ModBlocks.SCHEELITE_ORE)
                .add(ModBlocks.DEEPSLATE_SCHEELITE_ORE)
                .add(ModBlocks.SCHEELITE_BLOCK)
                .add(ModBlocks.TUNGSTEN_BLOCK)

                .add(ModBlocks.GALENA_ORE)
                .add(ModBlocks.DEEPSLATE_GALENA_ORE)
                .add(ModBlocks.GALENA_BLOCK)
                .add(ModBlocks.LEAD_BLOCK);

        // Tools material (minimum)
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PITCHBLENDE_ORE)
                .add(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE)
                .add(ModBlocks.RAW_PITCHBLENDE_BLOCK)
                .add(ModBlocks.PITCHBLENDE_BLOCK)

                .add(ModBlocks.GALENA_ORE)
                .add(ModBlocks.DEEPSLATE_GALENA_ORE)
                .add(ModBlocks.GALENA_BLOCK)
                .add(ModBlocks.LEAD_BLOCK)

                .add(ModBlocks.SCHEELITE_ORE)
                .add(ModBlocks.DEEPSLATE_SCHEELITE_ORE)
                .add(ModBlocks.SCHEELITE_BLOCK)
                .add(ModBlocks.TUNGSTEN_BLOCK);

        // Wood & Burnable Wood
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ACAI_LOG)
                .add(ModBlocks.ACAI_WOOD)
                .add(ModBlocks.STRIPPED_ACAI_LOG)
                .add(ModBlocks.STRIPPED_ACAI_WOOD)
                .add(ModBlocks.CASHEW_LOG)
                .add(ModBlocks.CASHEW_WOOD)
                .add(ModBlocks.STRIPPED_CASHEW_LOG)
                .add(ModBlocks.STRIPPED_CASHEW_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.ACAI_LOG)
                .add(ModBlocks.ACAI_WOOD)
                .add(ModBlocks.STRIPPED_ACAI_LOG)
                .add(ModBlocks.STRIPPED_ACAI_WOOD)
                .add(ModBlocks.CASHEW_LOG)
                .add(ModBlocks.CASHEW_WOOD)
                .add(ModBlocks.STRIPPED_CASHEW_LOG)
                .add(ModBlocks.STRIPPED_CASHEW_WOOD);

        // Planks
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.ACAI_PLANKS)
                .add(ModBlocks.CASHEW_PLANKS);

        // Leaves
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.ACAI_LEAVES)
                .add(ModBlocks.CASHEW_LEAVES);

        // Wood Stuff
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.ACAI_STAIRS, ModBlocks.CASHEW_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.ACAI_SLAB, ModBlocks.CASHEW_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.ACAI_FENCE, ModBlocks.CASHEW_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.ACAI_FENCE_GATE, ModBlocks.CASHEW_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.ACAI_DOOR, ModBlocks.CASHEW_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.ACAI_TRAPDOOR, ModBlocks.CASHEW_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.ACAI_BUTTON, ModBlocks.CASHEW_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.ACAI_PRESSURE_PLATE, ModBlocks.CASHEW_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(ModBlocks.ACAI_SAPLING, ModBlocks.CASHEW_SAPLING);
    }
}
