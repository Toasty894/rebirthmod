package io.github.toasty894.rebirthmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class GuaranaJuiceItem extends Item {
    public GuaranaJuiceItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack resultStack = super.finishUsing(stack, world, user);

        if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
            ItemStack glassBottle = new ItemStack(Items.GLASS_BOTTLE);

            if (resultStack.isEmpty()) {
                return glassBottle;
            }

            if (!player.getInventory().insertStack(glassBottle)) {
                player.dropItem(glassBottle, false);
            }
        }
        return resultStack;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.rebirthmod.guarana_juice").formatted(Formatting.GOLD));
        } else {
            tooltip.add(Text.translatable("tooltip.rebirthmod.hold_shift").formatted(Formatting.GRAY));
        }
    }
}
