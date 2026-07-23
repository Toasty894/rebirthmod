package io.github.toasty894.rebirthmod.datagen;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PITCHBLENDE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PITCHBLENDE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PITCHBLENDE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GALENA_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_GALENA_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GALENA_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHEELITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SCHEELITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHEELITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUNGSTEN_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GALENA, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.SCHEELITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNGSTEN_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_PITCHBLENDE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PITCHBLENDE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_CAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_235, Models.GENERATED);

        itemModelGenerator.register(ModItems.PITCHBLENDE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PITCHBLENDE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PITCHBLENDE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PITCHBLENDE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PITCHBLENDE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.PITCHBLENDE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.PITCHBLENDE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.PITCHBLENDE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.PITCHBLENDE_BOOTS);

        itemModelGenerator.register(ModItems.GEIGER_COUNTER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PASSION_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PASSION_FRUIT_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PASSION_FRUIT_CAKE.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.RELIC.asItem(), Models.GENERATED);
    }
}

