package io.github.toasty894.rebirthmod.util;

import io.github.toasty894.rebirthmod.item.ModItems;
import io.github.toasty894.rebirthmod.loot.RandomRelicDataLootFunction;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {

        private static final List<Identifier> INDUSTRIAL_CHESTS = List.of(
                new Identifier("minecraft", "chests/abandoned_mineshaft"),
                new Identifier("minecraft", "chests/simple_dungeon")
        );

        private static final List<Identifier> ARCHAEOLOGY_LOCATIONS = List.of(
                new Identifier("minecraft", "archaeology/desert_pyramid"),
                new Identifier("minecraft", "archaeology/desert_well"),
                new Identifier("minecraft", "archaeology/ocean_ruin_cold"),
                new Identifier("minecraft", "archaeology/ocean_ruin_warm"),
                new Identifier("minecraft", "archaeology/trail_ruins_common"),
                new Identifier("minecraft", "archaeology/trail_ruins_rare")
        );

        private static final List<Identifier> FOOD_CHESTS = List.of(
                new Identifier("minecraft", "chests/village/village_plains_house"),
                new Identifier("minecraft", "chests/village/village_savanna_house"),
                new Identifier("minecraft", "chests/shipwreck_supply")
        );

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (INDUSTRIAL_CHESTS.contains(id)) {
                tableBuilder.pool(LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1.0f, 2.0f))
                        .conditionally(RandomChanceLootCondition.builder(0.40f))
                        .with(ItemEntry.builder(ModItems.RAW_PITCHBLENDE).weight(3))
                        .with(ItemEntry.builder(ModItems.GALENA).weight(7))
                        .with(ItemEntry.builder(ModItems.URANIUM).weight(1)));
            }

            if (FOOD_CHESTS.contains(id)) {
                tableBuilder.pool(LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(2.0f, 5.0f))
                        .conditionally(RandomChanceLootCondition.builder(0.60f))
                        .with(ItemEntry.builder(ModItems.PASSION_FRUIT)));
            }
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (ARCHAEOLOGY_LOCATIONS.contains(id)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.RELIC)
                        .weight(2)
                        .apply(RandomRelicDataLootFunction.builder())
                        .build());
                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;
        });
        }
}
