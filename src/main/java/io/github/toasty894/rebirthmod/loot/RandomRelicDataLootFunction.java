package io.github.toasty894.rebirthmod.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import io.github.toasty894.rebirthmod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.nbt.NbtCompound;

public class RandomRelicDataLootFunction extends ConditionalLootFunction {
    protected RandomRelicDataLootFunction(LootCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected ItemStack process(ItemStack stack, LootContext context) {
        if (stack.isOf(ModItems.RELIC)) {
            NbtCompound nbt = stack.getOrCreateNbt();
            if (!nbt.contains("KnowledgeValue")) {
                nbt.putInt("KnowledgeValue", context.getRandom().nextInt(100) + 1);
            }
        }
        return stack;
    }

    @Override
    public LootFunctionType getType() {
        return ModLootFunctions.RANDOM_RELIC_DATA;
    }

    public static ConditionalLootFunction.Builder<?> builder() {
        return builder(RandomRelicDataLootFunction::new);
    }

    public static class Serializer extends ConditionalLootFunction.Serializer<RandomRelicDataLootFunction> {
        @Override
        public RandomRelicDataLootFunction fromJson(JsonObject json, JsonDeserializationContext context, LootCondition[] conditions) {
            return new RandomRelicDataLootFunction(conditions);
        }
    }
}
