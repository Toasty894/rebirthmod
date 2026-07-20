package io.github.toasty894.rebirthmod.item;

import io.github.toasty894.rebirthmod.RebirthMod;
import io.github.toasty894.rebirthmod.item.custom.GeigerCounterItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PITCHBLENDE_SWORD = registerItem("pitchblende_sword",
            new SwordItem(ModToolMaterial.PITCHBLENDE_INGOT, 4, -2.5F, new FabricItemSettings()));
    public static final Item PITCHBLENDE_SHOVEL = registerItem("pitchblende_shovel",
            new ShovelItem(ModToolMaterial.PITCHBLENDE_INGOT, 1.5F, -3.1F, new FabricItemSettings()));
    public static final Item PITCHBLENDE_PICKAXE = registerItem("pitchblende_pickaxe",
            new PickaxeItem(ModToolMaterial.PITCHBLENDE_INGOT, 1, -2.9F, new FabricItemSettings()));
    public static final Item PITCHBLENDE_AXE = registerItem("pitchblende_axe",
            new AxeItem(ModToolMaterial.PITCHBLENDE_INGOT, 6, -3.3F, new FabricItemSettings()));
    public static final Item PITCHBLENDE_HOE = registerItem("pitchblende_hoe",
            new HoeItem(ModToolMaterial.PITCHBLENDE_INGOT, -1, -1.2F, new FabricItemSettings()));

    public static final Item GEIGER_COUNTER = registerItem("geiger_counter",
            new GeigerCounterItem(new FabricItemSettings().maxCount(1)));

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
