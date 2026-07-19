package io.github.toasty894.rebirthmod.item;

import io.github.toasty894.rebirthmod.RebirthMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_PITCHBLENDE = registerItem("raw_pitchblende", new Item(new FabricItemSettings()));
    public static final Item PITCHBLENDE_INGOT = registerItem("pitchblende_ingot", new Item(new FabricItemSettings()));
    public static final Item YELLOW_CAKE = registerItem("yellow_cake", new Item(new FabricItemSettings()));
    public static final Item URANIUM = registerItem("uranium", new Item(new FabricItemSettings()));
    public static final Item URANIUM_235 = registerItem("uranium_235", new Item(new FabricItemSettings()));
    public static final Item PASSION_FRUIT = registerItem("passion_fruit", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RebirthMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RebirthMod.LOGGER.info("Registering Mod Items for " + RebirthMod.MOD_ID);
    }
}
