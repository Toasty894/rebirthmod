package io.github.toasty894.rebirthmod.datagen;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider{
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RAW_PITCHBLENDE_BLOCK);
        addDrop(ModBlocks.PITCHBLENDE_BLOCK);
        addDrop(ModBlocks.GALENA_BLOCK);
        addDrop(ModBlocks.LEAD_BLOCK);
        addDrop(ModBlocks.SCHEELITE_BLOCK);
        addDrop(ModBlocks.TUNGSTEN_BLOCK);

        addDrop(ModBlocks.PITCHBLENDE_ORE,
                oreDrops(ModBlocks.PITCHBLENDE_ORE, ModItems.RAW_PITCHBLENDE));
        addDrop(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE,
                clusterOreDrops(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE, ModItems.RAW_PITCHBLENDE));

        addDrop(ModBlocks.GALENA_ORE,
                clusterOreDrops(ModBlocks.GALENA_ORE, ModItems.GALENA));
        addDrop(ModBlocks.DEEPSLATE_GALENA_ORE,
                clusterOreDrops(ModBlocks.DEEPSLATE_GALENA_ORE, ModItems.GALENA));

        addDrop(ModBlocks.SCHEELITE_ORE,
                oreDrops(ModBlocks.SCHEELITE_ORE, ModItems.SCHEELITE));
        addDrop(ModBlocks.DEEPSLATE_SCHEELITE_ORE,
                oreDrops(ModBlocks.DEEPSLATE_SCHEELITE_ORE, ModItems.SCHEELITE));

        addDrop(ModBlocks.ACAI_LOG);
        addDrop(ModBlocks.ACAI_WOOD);
        addDrop(ModBlocks.STRIPPED_ACAI_LOG);
        addDrop(ModBlocks.STRIPPED_ACAI_WOOD);
        addDrop(ModBlocks.ACAI_PLANKS);

        addDrop(ModBlocks.ACAI_LEAVES, leavesDrops(ModBlocks.ACAI_LEAVES, Blocks.OAK_SAPLING, SAPLING_DROP_CHANCE)); // RETURN HERE

        addDrop(ModBlocks.ACAI_STAIRS);
        addDrop(ModBlocks.ACAI_FENCE);
        addDrop(ModBlocks.ACAI_FENCE_GATE);
        addDrop(ModBlocks.ACAI_TRAPDOOR);
        addDrop(ModBlocks.ACAI_BUTTON);
        addDrop(ModBlocks.ACAI_PRESSURE_PLATE);
        addDrop(ModBlocks.ACAI_SAPLING);

        addDrop(ModBlocks.ACAI_SLAB, slabDrops(ModBlocks.ACAI_SLAB));
        addDrop(ModBlocks.ACAI_DOOR, doorDrops(ModBlocks.ACAI_DOOR));

        addDrop(ModBlocks.CASHEW_LOG);
        addDrop(ModBlocks.CASHEW_WOOD);
        addDrop(ModBlocks.STRIPPED_CASHEW_LOG);
        addDrop(ModBlocks.STRIPPED_CASHEW_WOOD);

        addDrop(ModBlocks.CASHEW_PLANKS);
        addDrop(ModBlocks.CASHEW_LEAVES, leavesDrops(ModBlocks.CASHEW_LEAVES, Blocks.OAK_SAPLING, SAPLING_DROP_CHANCE)); // RETURN HERE

        addDrop(ModBlocks.CASHEW_STAIRS);
        addDrop(ModBlocks.CASHEW_FENCE);
        addDrop(ModBlocks.CASHEW_FENCE_GATE);
        addDrop(ModBlocks.CASHEW_TRAPDOOR);
        addDrop(ModBlocks.CASHEW_BUTTON);
        addDrop(ModBlocks.CASHEW_PRESSURE_PLATE);
        addDrop(ModBlocks.CASHEW_SAPLING);

        addDrop(ModBlocks.CASHEW_SLAB, slabDrops(ModBlocks.CASHEW_SLAB));
        addDrop(ModBlocks.CASHEW_DOOR, doorDrops(ModBlocks.CASHEW_DOOR));
    }

    public LootTable.Builder clusterOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
