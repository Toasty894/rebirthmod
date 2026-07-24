package io.github.toasty894.rebirthmod.block;

import io.github.toasty894.rebirthmod.RebirthMod;
import io.github.toasty894.rebirthmod.block.custom.AcaiClusterBlock;
import io.github.toasty894.rebirthmod.block.custom.GuaranaBushBlock;
import io.github.toasty894.rebirthmod.block.custom.PassionFruitCakeBlock;
import io.github.toasty894.rebirthmod.block.custom.PassionFruitVineBlock;
import io.github.toasty894.rebirthmod.world.tree.AcaiSaplingGenerator;
import io.github.toasty894.rebirthmod.world.tree.CashewSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
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
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK).sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(5.0F)));
    public static final Block PITCHBLENDE_BLOCK = registerBlock("pitchblende_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.NETHERITE).strength(5.5F)));

    public static final Block GALENA_ORE = registerBlock("galena_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).strength(4.0F), UniformIntProvider.create(0, 2)));
    public static final Block DEEPSLATE_GALENA_ORE = registerBlock("deepslate_galena_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE).strength(5.0F), UniformIntProvider.create(1, 2)));
    public static final Block GALENA_BLOCK = registerBlock("galena_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK).sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(5.0F)));
    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL).strength(6.5F).resistance(5.0f)));

    public static final Block SCHEELITE_ORE = registerBlock("scheelite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).strength(4.0F), UniformIntProvider.create(0, 2)));
    public static final Block DEEPSLATE_SCHEELITE_ORE = registerBlock("deepslate_scheelite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE).strength(5.0F), UniformIntProvider.create(1, 2)));
    public static final Block SCHEELITE_BLOCK = registerBlock("scheelite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK).sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(5.0F)));
    public static final Block TUNGSTEN_BLOCK = registerBlock("tungsten_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.METAL).resistance(800.0f)));

    public static final Block PASSION_FRUIT_CAKE = registerBlock("passion_fruit_cake",
            new PassionFruitCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE)));

    public static final Block PASSION_FRUIT_VINE = registerBlock("passion_fruit_vine",
            new PassionFruitVineBlock(FabricBlockSettings.create()
                    .noCollision()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.CAVE_VINES)));

    public static final Block ACAI_LOG = registerBlock("acai_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ACAI_WOOD = registerBlock("acai_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ACAI_LOG = registerBlock("stripped_acai_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_ACAI_WOOD = registerBlock("stripped_acai_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block ACAI_PLANKS = registerBlock("acai_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ACAI_LEAVES = registerBlock("acai_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    public static final Block ACAI_STAIRS = registerBlock("acai_stairs",
            new StairsBlock(ModBlocks.ACAI_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block ACAI_SLAB = registerBlock("acai_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));

    public static final Block ACAI_BUTTON = registerBlock("acai_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
    public static final Block ACAI_PRESSURE_PLATE = registerBlock("acai_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final Block ACAI_FENCE = registerBlock("acai_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block ACAI_FENCE_GATE = registerBlock("acai_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));

    public static final Block ACAI_DOOR = registerBlock("acai_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block ACAI_TRAPDOOR = registerBlock("acai_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final Block ACAI_SAPLING = registerBlock("acai_sapling",
            new SaplingBlock(new AcaiSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block ACAI_CLUSTER = Registry.register(Registries.BLOCK,
            new Identifier(RebirthMod.MOD_ID, "acai_cluster"),
            new AcaiClusterBlock(FabricBlockSettings.create()
                    .noCollision()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.CAVE_VINES)));

    public static final Block CASHEW_LOG = registerBlock("cashew_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block CASHEW_WOOD = registerBlock("cashew_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CASHEW_LOG = registerBlock("stripped_cashew_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CASHEW_WOOD = registerBlock("stripped_cashew_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CASHEW_PLANKS = registerBlock("cashew_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block CASHEW_LEAVES = registerBlock("cashew_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    public static final Block CASHEW_STAIRS = registerBlock("cashew_stairs",
            new StairsBlock(ModBlocks.CASHEW_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block CASHEW_SLAB = registerBlock("cashew_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));

    public static final Block CASHEW_BUTTON = registerBlock("cashew_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
    public static final Block CASHEW_PRESSURE_PLATE = registerBlock("cashew_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final Block CASHEW_FENCE = registerBlock("cashew_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block CASHEW_FENCE_GATE = registerBlock("cashew_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));

    public static final Block CASHEW_DOOR = registerBlock("cashew_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block CASHEW_TRAPDOOR = registerBlock("cashew_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final Block CASHEW_SAPLING = Registry.register(Registries.BLOCK,
            new Identifier(RebirthMod.MOD_ID, "cashew_sapling"),
            new SaplingBlock(new CashewSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).noCollision().breakInstantly()));

    public static final Block GUARANA_BUSH = Registry.register(Registries.BLOCK,
            new Identifier(RebirthMod.MOD_ID, "guarana_bush"),
            new GuaranaBushBlock(FabricBlockSettings.create()
                    .noCollision()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

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
