package io.github.toasty894.rebirthmod.item.custom;

import io.github.toasty894.rebirthmod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.world.World;

public class CashewFruitItem extends Item {
    public CashewFruitItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack resultStack = super.finishUsing(stack, world, user);

        if (user instanceof PlayerEntity player) {
            return ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.CASHEW_NUT));
        }

        return resultStack;
    }
}