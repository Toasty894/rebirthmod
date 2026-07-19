package io.github.toasty894.rebirthmod.block;

import io.github.toasty894.rebirthmod.RebirthMod;
import io.github.toasty894.rebirthmod.block.custom.PassionFruitCakeBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PITCHBLENDE_ORE = registerBlock("pitchblende_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).strength(4.0F), UniformIntProvider.create(0, 2)));
    public static final Block DEEPSLATE_PITCHBLENDE_ORE = registerBlock("deepslate_pitchblende_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE).strength(5.0F), UniformIntProvider.create(1, 2)));
    public static final Block RAW_PITCHBLENDE_BLOCK = registerBlock("raw_pitchblende_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK)));
    public static final Block PITCHBLENDE_BLOCK = registerBlock("pitchblende_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.NETHERITE).strength(5.5F)));
    public static final Block PASSION_FRUIT_CAKE = registerBlock("passion_fruit_cake",
            new PassionFruitCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RebirthMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(RebirthMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        RebirthMod.LOGGER.info("Registering ModBlocks for " + RebirthMod.MOD_ID);
    }

}
