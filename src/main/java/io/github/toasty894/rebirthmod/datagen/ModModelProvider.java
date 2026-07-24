package io.github.toasty894.rebirthmod.datagen;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.block.custom.AcaiClusterBlock;
import io.github.toasty894.rebirthmod.block.custom.GuaranaBushBlock;
import io.github.toasty894.rebirthmod.datagen.util.ModelUtils;
import io.github.toasty894.rebirthmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.data.client.BlockStateVariantMap;

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

        // Guarana
        var guaranaAgeMap = BlockStateVariantMap.create(GuaranaBushBlock.AGE);

        for (int age = 0; age <= 7; age++) {
            Identifier textureId = new Identifier("rebirthmod", "block/guarana_bush_stage" + age);

            Identifier modelId = Models.CROSS.upload(
                    ModBlocks.GUARANA_BUSH,
                    "_stage" + age,
                    TextureMap.cross(textureId),
                    blockStateModelGenerator.modelCollector
            );

            guaranaAgeMap.register(age, BlockStateVariant.create().put(VariantSettings.MODEL, modelId));
        }

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.GUARANA_BUSH).coordinate(guaranaAgeMap));

        var acaiAgeMap = BlockStateVariantMap.create(AcaiClusterBlock.AGE);

        for (int age = 0; age <= 3; age++) {
            Identifier textureId = new Identifier("rebirthmod", "block/acai_cluster_stage" + age);

            Identifier modelId = Models.CROSS.upload(
                    ModBlocks.ACAI_CLUSTER,
                    "_stage" + age,
                    TextureMap.cross(textureId),
                    blockStateModelGenerator.modelCollector
            );

            acaiAgeMap.register(age, BlockStateVariant.create().put(VariantSettings.MODEL, modelId));
        }

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.ACAI_CLUSTER).coordinate(acaiAgeMap));

        // ACAI WOOD
        blockStateModelGenerator.registerLog(ModBlocks.ACAI_LOG).log(ModBlocks.ACAI_LOG).wood(ModBlocks.ACAI_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ACAI_LOG).log(ModBlocks.STRIPPED_ACAI_LOG).wood(ModBlocks.STRIPPED_ACAI_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACAI_PLANKS);
        ModelUtils.registerLeaves(blockStateModelGenerator, ModBlocks.ACAI_LEAVES);

        ModelUtils.registerStairs(blockStateModelGenerator, ModBlocks.ACAI_STAIRS, ModBlocks.ACAI_PLANKS);
        ModelUtils.registerSlab(blockStateModelGenerator, ModBlocks.ACAI_SLAB, ModBlocks.ACAI_PLANKS);
        ModelUtils.registerButton(blockStateModelGenerator, ModBlocks.ACAI_BUTTON, ModBlocks.ACAI_PLANKS);
        ModelUtils.registerPressurePlate(blockStateModelGenerator, ModBlocks.ACAI_PRESSURE_PLATE, ModBlocks.ACAI_PLANKS);
        ModelUtils.registerFence(blockStateModelGenerator, ModBlocks.ACAI_FENCE, ModBlocks.ACAI_PLANKS);
        ModelUtils.registerFenceGate(blockStateModelGenerator, ModBlocks.ACAI_FENCE_GATE, ModBlocks.ACAI_PLANKS);
        ModelUtils.registerDoor(blockStateModelGenerator, ModBlocks.ACAI_DOOR);
        ModelUtils.registerTrapdoor(blockStateModelGenerator, ModBlocks.ACAI_TRAPDOOR);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.ACAI_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


        // CASHEW WOOD
        blockStateModelGenerator.registerLog(ModBlocks.CASHEW_LOG).log(ModBlocks.CASHEW_LOG).wood(ModBlocks.CASHEW_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CASHEW_LOG).log(ModBlocks.STRIPPED_CASHEW_LOG).wood(ModBlocks.STRIPPED_CASHEW_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CASHEW_PLANKS);
        ModelUtils.registerLeaves(blockStateModelGenerator, ModBlocks.CASHEW_LEAVES);

        ModelUtils.registerStairs(blockStateModelGenerator, ModBlocks.CASHEW_STAIRS, ModBlocks.CASHEW_PLANKS);
        ModelUtils.registerSlab(blockStateModelGenerator, ModBlocks.CASHEW_SLAB, ModBlocks.CASHEW_PLANKS);
        ModelUtils.registerButton(blockStateModelGenerator, ModBlocks.CASHEW_BUTTON, ModBlocks.CASHEW_PLANKS);
        ModelUtils.registerPressurePlate(blockStateModelGenerator, ModBlocks.CASHEW_PRESSURE_PLATE, ModBlocks.CASHEW_PLANKS);
        ModelUtils.registerFence(blockStateModelGenerator, ModBlocks.CASHEW_FENCE, ModBlocks.CASHEW_PLANKS);
        ModelUtils.registerFenceGate(blockStateModelGenerator, ModBlocks.CASHEW_FENCE_GATE, ModBlocks.CASHEW_PLANKS);
        ModelUtils.registerDoor(blockStateModelGenerator, ModBlocks.CASHEW_DOOR);
        ModelUtils.registerTrapdoor(blockStateModelGenerator, ModBlocks.CASHEW_TRAPDOOR);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CASHEW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
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

        itemModelGenerator.register(ModBlocks.PASSION_FRUIT_VINE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.PASSION_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PASSION_FRUIT_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PASSION_FRUIT_CAKE.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModBlocks.ACAI_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.ACAI, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACAI_JUICE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CASHEW_NUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CASHEW_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CASHEW_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CASHEW_JUICE, Models.GENERATED);

        itemModelGenerator.register(ModBlocks.GUARANA_BUSH.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.GUARANA_JUICE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RELIC.asItem(), Models.GENERATED);
    }
}

