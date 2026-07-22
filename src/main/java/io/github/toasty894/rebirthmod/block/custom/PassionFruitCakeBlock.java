package io.github.toasty894.rebirthmod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class PassionFruitCakeBlock extends CakeBlock {

    public PassionFruitCakeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }
            if (player.getStackInHand(hand).isEmpty()) {
                return ActionResult.CONSUME;
            }
        }
        return tryEat(world, pos, state, player);
    }

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(4, 0.6f);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80, 0));
            player.removeStatusEffect(StatusEffects.NAUSEA);
            int bites = state.get(BITES);
            world.emitGameEvent(player, GameEvent.EAT, pos);
            if (bites < 6) {
                world.setBlockState(pos, state.with(BITES, bites +1), PassionFruitCakeBlock.NOTIFY_ALL);
                } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return ActionResult.SUCCESS;
        }
    }
    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext options) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.rebirthmod.passion_fruit_cake").formatted(Formatting.GOLD));
        } else {
            tooltip.add(Text.translatable("tooltip.rebirthmod.hold_shift").formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, world, tooltip, options);
    }
}

