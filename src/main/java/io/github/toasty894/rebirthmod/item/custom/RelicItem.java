package io.github.toasty894.rebirthmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class RelicItem extends Item {

    public RelicItem(Settings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.rebirthmod.relic").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.translatable("tooltip.rebirthmod.hold_shift").formatted(Formatting.GRAY));
        }
    }
}
