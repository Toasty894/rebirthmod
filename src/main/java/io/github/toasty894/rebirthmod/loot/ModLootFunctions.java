package io.github.toasty894.rebirthmod.loot;

import io.github.toasty894.rebirthmod.RebirthMod;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModLootFunctions {

    public static final LootFunctionType RANDOM_RELIC_DATA = Registry.register(
            Registries.LOOT_FUNCTION_TYPE,
            new Identifier(RebirthMod.MOD_ID, "random_relic_data"),
            new LootFunctionType(new RandomRelicDataLootFunction.Serializer())
    );

    public static void register() {
        RebirthMod.LOGGER.info("Registering Loot Function for " + RebirthMod.MOD_ID);
    }
}
