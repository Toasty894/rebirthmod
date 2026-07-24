package io.github.toasty894.rebirthmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CASHEW_APPLE = new FoodComponent.Builder()
            .hunger(5)
            .saturationModifier(0.4f)
            .build();

    public static final FoodComponent ACAI = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.6f)
            .build();

    public static final FoodComponent PASSION_FRUIT = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 120, 1), 0.3f)
            .build();

    public static final FoodComponent PASSION_FRUIT_JUICE = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.4f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0f)
            .build();

    public static final FoodComponent ACAI_JUICE = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.6f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 0), 1.0f)
            .build();

    public static final FoodComponent GUARANA_JUICE = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.6f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 180, 0), 1.0f)
            .build();

    public static final FoodComponent CASHEW_JUICE = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .build();
}
