package io.github.toasty894.rebirthmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent PASSION_FRUIT = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 0), 0.3f)
            .build();

    public static final FoodComponent PASSION_FRUIT_JUICE = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.8f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0f)
            .build();
}
