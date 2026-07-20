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

                        // _Tools and Weapons_

                            // Weapons
                        entries.add(ModItems.PITCHBLENDE_SWORD);
                        entries.add(ModItems.PITCHBLENDE_SHOVEL);
                        entries.add(ModItems.PITCHBLENDE_PICKAXE);
                        entries.add(ModItems.PITCHBLENDE_AXE);
                        entries.add(ModItems.PITCHBLENDE_HOE);

                            // Tools
                        entries.add(ModItems.GEIGER_COUNTER);

                        // Armors

                        // Miscellaneous and relics

                    }).build());

    public static final ItemGroup REBIRTH_FOUNDATIONS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "foundation"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_foundations"))
                    .icon(() -> new ItemStack(ModBlocks.PITCHBLENDE_BLOCK)).entries((displayContext, entries) -> {

                        //All blocks with cube form
                        entries.add(ModBlocks.PITCHBLENDE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE);
                        entries.add(ModBlocks.RAW_PITCHBLENDE_BLOCK);
                        entries.add(ModBlocks.PITCHBLENDE_BLOCK);

                    }).build());

    public static final ItemGroup REBIRTH_WILDS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "wilds"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_wilds"))
                    .icon(() -> new ItemStack(ModItems.PASSION_FRUIT)).entries((displayContext, entries) -> {

                        //Natural items, food, plants and mobs
                        entries.add(ModItems.PASSION_FRUIT);
                        entries.add(ModBlocks.PASSION_FRUIT_CAKE);

                    }).build());


    public static final ItemGroup REBIRTH_CATALYSTS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "catalysts"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_catalysts"))
                    .icon(() -> new ItemStack(ModItems.PITCHBLENDE_INGOT)).entries((displayContext, entries) -> {

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
