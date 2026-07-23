package io.github.toasty894.rebirthmod.item;

import io.github.toasty894.rebirthmod.RebirthMod;
import io.github.toasty894.rebirthmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup REBIRTH = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "rebirth"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth"))
                    .icon(() -> new ItemStack(ModItems.PITCHBLENDE_SWORD)).entries((displayContext, entries) -> {

                        // All the magical and technological stuff will be in this tab

                        // Weapons, Armors & Tools

                            // Tools
                        entries.add(ModItems.PITCHBLENDE_SWORD);
                        entries.add(ModItems.PITCHBLENDE_SHOVEL);
                        entries.add(ModItems.PITCHBLENDE_PICKAXE);
                        entries.add(ModItems.PITCHBLENDE_AXE);
                        entries.add(ModItems.PITCHBLENDE_HOE);

                            // Armors
                        entries.add(ModItems.PITCHBLENDE_HELMET);
                        entries.add(ModItems.PITCHBLENDE_CHESTPLATE);
                        entries.add(ModItems.PITCHBLENDE_LEGGINGS);
                        entries.add(ModItems.PITCHBLENDE_BOOTS);

                            // Mod Tools
                        entries.add(ModItems.GEIGER_COUNTER);

                        // Miscellaneous and relics
                        entries.add(ModItems.RELIC);

                    }).build());

    public static final ItemGroup REBIRTH_FOUNDATIONS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "foundation"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_foundations"))
                    .icon(() -> new ItemStack(ModBlocks.PITCHBLENDE_BLOCK)).entries((displayContext, entries) -> {

                        //All blocks with cube form

                        // Wood

                        // Acai Wood
                        entries.add(ModBlocks.ACAI_LOG);
                        entries.add(ModBlocks.ACAI_WOOD);
                        entries.add(ModBlocks.STRIPPED_ACAI_LOG);
                        entries.add(ModBlocks.STRIPPED_ACAI_WOOD);
                        entries.add(ModBlocks.ACAI_PLANKS);
                        entries.add(ModBlocks.ACAI_LEAVES);
                        entries.add(ModBlocks.ACAI_STAIRS);
                        entries.add(ModBlocks.ACAI_SLAB);
                        entries.add(ModBlocks.ACAI_BUTTON);
                        entries.add(ModBlocks.ACAI_PRESSURE_PLATE);
                        entries.add(ModBlocks.ACAI_FENCE);
                        entries.add(ModBlocks.ACAI_FENCE_GATE);
                        entries.add(ModBlocks.ACAI_DOOR);
                        entries.add(ModBlocks.ACAI_TRAPDOOR);

                        // Cashew Wood
                        entries.add(ModBlocks.CASHEW_LOG);
                        entries.add(ModBlocks.CASHEW_WOOD);
                        entries.add(ModBlocks.STRIPPED_CASHEW_LOG);
                        entries.add(ModBlocks.STRIPPED_CASHEW_WOOD);
                        entries.add(ModBlocks.CASHEW_PLANKS);
                        entries.add(ModBlocks.CASHEW_LEAVES);
                        entries.add(ModBlocks.CASHEW_STAIRS);
                        entries.add(ModBlocks.CASHEW_SLAB);
                        entries.add(ModBlocks.CASHEW_BUTTON);
                        entries.add(ModBlocks.CASHEW_PRESSURE_PLATE);
                        entries.add(ModBlocks.CASHEW_FENCE);
                        entries.add(ModBlocks.CASHEW_FENCE_GATE);
                        entries.add(ModBlocks.CASHEW_DOOR);
                        entries.add(ModBlocks.CASHEW_TRAPDOOR);

                        // Ores
                        entries.add(ModBlocks.PITCHBLENDE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE);
                        entries.add(ModBlocks.RAW_PITCHBLENDE_BLOCK);
                        entries.add(ModBlocks.PITCHBLENDE_BLOCK);

                        entries.add(ModBlocks.GALENA_ORE);
                        entries.add(ModBlocks.DEEPSLATE_GALENA_ORE);
                        entries.add(ModBlocks.GALENA_BLOCK);
                        entries.add(ModBlocks.LEAD_BLOCK);

                        entries.add(ModBlocks.SCHEELITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SCHEELITE_ORE);
                        entries.add(ModBlocks.SCHEELITE_BLOCK);
                        entries.add(ModBlocks.TUNGSTEN_BLOCK);

                    }).build());

    public static final ItemGroup REBIRTH_WILDS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "wilds"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_wilds"))
                    .icon(() -> new ItemStack(ModItems.PASSION_FRUIT)).entries((displayContext, entries) -> {

                        //Natural items, food, plants and mobs
                        // Saplings & Plants
                        entries.add(ModBlocks.ACAI_SAPLING);
                        entries.add(ModBlocks.CASHEW_SAPLING);

                        // Food & Natural Items
                        entries.add(ModItems.PASSION_FRUIT);
                        entries.add(ModItems.PASSION_FRUIT_JUICE);
                        entries.add(ModBlocks.PASSION_FRUIT_CAKE);

                    }).build());


    public static final ItemGroup REBIRTH_CATALYSTS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "catalysts"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_catalysts"))
                    .icon(() -> new ItemStack(ModItems.PITCHBLENDE_INGOT)).entries((displayContext, entries) -> {

                        entries.add(ModItems.GALENA);
                        entries.add(ModItems.LEAD_INGOT);

                        entries.add(ModItems.SCHEELITE);
                        entries.add(ModItems.TUNGSTEN_INGOT);

                        entries.add(ModItems.RAW_PITCHBLENDE);
                        entries.add(ModItems.PITCHBLENDE_INGOT);
                        entries.add(ModItems.YELLOW_CAKE);
                        entries.add(ModItems.URANIUM);
                        entries.add(ModItems.URANIUM_235);

                    }).build());



    public static void registerItemGroups() {
        RebirthMod.LOGGER.info("Registering Item Groups for " + RebirthMod.MOD_ID);
    }

}
