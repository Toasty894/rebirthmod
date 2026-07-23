package io.github.toasty894.rebirthmod.datagen.util;

import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.util.Identifier;

public class ModelUtils {

    public static void registerLeaves(BlockStateModelGenerator generator, Block leavesBlock) {
        generator.registerSingleton(leavesBlock, TexturedModel.LEAVES);
    }

    public static void registerDoor(BlockStateModelGenerator generator, Block doorBlock) {
        generator.registerDoor(doorBlock);
        // Door are 2D sprites -> ItemModelProvider using generator.register(item, Models.GENERATED)
    }

    public static void registerTrapdoor(BlockStateModelGenerator generator, Block trapdoorBlock) {
        generator.registerTrapdoor(trapdoorBlock);
    }

    public static void registerFence(BlockStateModelGenerator generator, Block fenceBlock, Block baseBlock) {
        TextureMap textureMap = TextureMap.all(TextureMap.getId(baseBlock));
        Identifier post = Models.FENCE_POST.upload(fenceBlock, textureMap, generator.modelCollector);
        Identifier side = Models.FENCE_SIDE.upload(fenceBlock, textureMap, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fenceBlock, post, side));

        Identifier inventory = Models.FENCE_INVENTORY.upload(fenceBlock, textureMap, generator.modelCollector);
        generator.registerParentedItemModel(fenceBlock, inventory);
    }

    public static void registerFenceGate(BlockStateModelGenerator generator, Block fenceGateBlock, Block baseBlock) {
        TextureMap textureMap = TextureMap.all(TextureMap.getId(baseBlock));
        Identifier open = Models.TEMPLATE_FENCE_GATE_OPEN.upload(fenceGateBlock, textureMap, generator.modelCollector);
        Identifier closed = Models.TEMPLATE_FENCE_GATE.upload(fenceGateBlock, textureMap, generator.modelCollector);
        Identifier openWall = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(fenceGateBlock, textureMap, generator.modelCollector);
        Identifier closedWall = Models.TEMPLATE_FENCE_GATE_WALL.upload(fenceGateBlock, textureMap, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createFenceGateBlockState(fenceGateBlock, open, closed, openWall, closedWall, true));

        generator.registerParentedItemModel(fenceGateBlock, closed);
    }

    public static void registerPressurePlate(BlockStateModelGenerator generator, Block pressurePlateBlock, Block baseBlock) {
        TextureMap textureMap = TextureMap.all(TextureMap.getId(baseBlock));
        Identifier up = Models.PRESSURE_PLATE_UP.upload(pressurePlateBlock, textureMap, generator.modelCollector);
        Identifier down = Models.PRESSURE_PLATE_DOWN.upload(pressurePlateBlock, textureMap, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(pressurePlateBlock, up, down));

        generator.registerParentedItemModel(pressurePlateBlock, up);
    }

    public static void registerButton(BlockStateModelGenerator generator, Block buttonBlock, Block baseBlock) {
        TextureMap textureMap = TextureMap.all(TextureMap.getId(baseBlock));
        Identifier unpressed = Models.BUTTON.upload(buttonBlock, textureMap, generator.modelCollector);
        Identifier pressed = Models.BUTTON_PRESSED.upload(buttonBlock, textureMap, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(buttonBlock, unpressed, pressed));

        Identifier inventory = Models.BUTTON_INVENTORY.upload(buttonBlock, textureMap, generator.modelCollector);
        generator.registerParentedItemModel(buttonBlock, inventory);
    }

    public static void registerStairs(BlockStateModelGenerator generator, Block stairsBlock, Block baseBlock) {
        TextureMap textureMap = TextureMap.all(TextureMap.getId(baseBlock));
        Identifier inner = Models.INNER_STAIRS.upload(stairsBlock, textureMap, generator.modelCollector);
        Identifier straight = Models.STAIRS.upload(stairsBlock, textureMap, generator.modelCollector);
        Identifier outer = Models.OUTER_STAIRS.upload(stairsBlock, textureMap, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairsBlock, inner, straight, outer));

        generator.registerParentedItemModel(stairsBlock, straight);
    }

    public static void registerSlab(BlockStateModelGenerator generator, Block slabBlock, Block baseBlock) {
        TextureMap textureMap = TextureMap.all(TextureMap.getId(baseBlock));
        Identifier bottom = Models.SLAB.upload(slabBlock, textureMap, generator.modelCollector);
        Identifier top = Models.SLAB_TOP.upload(slabBlock, textureMap, generator.modelCollector);
        Identifier full = ModelIds.getBlockModelId(baseBlock); // The double-slab uses the base block's model
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slabBlock, bottom, top, full));

        generator.registerParentedItemModel(slabBlock, bottom);
    }
}
