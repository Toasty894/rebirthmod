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
    public static final ItemGroup REBIRTH_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.PITCHBLENDE_BLOCK)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.PITCHBLENDE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE);
                        entries.add(ModBlocks.RAW_PITCHBLENDE_BLOCK);
                        entries.add(ModBlocks.PITCHBLENDE_BLOCK);

                    }).build());

    public static final ItemGroup REBIRTH_INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "ingredients"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_ingredients"))
                    .icon(() -> new ItemStack(ModItems.PITCHBLENDE_INGOT)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RAW_PITCHBLENDE);
                        entries.add(ModItems.PITCHBLENDE_INGOT);
                        entries.add(ModItems.YELLOW_CAKE);
                        entries.add(ModItems.URANIUM);
                        entries.add(ModItems.URANIUM_235);

                    }).build());

    public static final ItemGroup REBIRTH_FOOD = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RebirthMod.MOD_ID, "food"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebirth_food"))
                    .icon(() -> new ItemStack(ModItems.PASSION_FRUIT)).entries((displayContext, entries) -> {

                        entries.add(ModItems.PASSION_FRUIT);
                        entries.add(ModBlocks.PASSION_FRUIT_CAKE);

                    }).build());



    public static void registerItemGroups() {
        RebirthMod.LOGGER.info("Registering Item Groups for " + RebirthMod.MOD_ID);
    }

}
