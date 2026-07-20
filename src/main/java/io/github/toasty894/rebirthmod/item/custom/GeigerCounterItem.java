package io.github.toasty894.rebirthmod.item.custom;

import io.github.toasty894.rebirthmod.radiation.RadiationRegistry;
import io.github.toasty894.rebirthmod.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GeigerCounterItem extends Item {

    // NO NBT HERE
    private static final Map<UUID, Integer> LAST_PLAY_TICK = new HashMap<>();
    private static final int MAX_SEARCH_DISTANCE = 64;

    public GeigerCounterItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // Only runs the code if the player is holding the item in his hand
        if (!world.isClient && entity instanceof PlayerEntity player) {

            if (!selected) {
                LAST_PLAY_TICK.remove(player.getUuid());
                return;
            }

            Vec3d eyePos = player.getEyePos();
            Vec3d lookVec = player.getRotationVec(1.0F);

            double highestSignal = 0.0;
            BlockPos.Mutable mutablePos = new BlockPos.Mutable();
            for (double d = 1.0; d <= MAX_SEARCH_DISTANCE; d += 0.5) {
                Vec3d checkVec = eyePos.add(lookVec.multiply(d));

                int coneRadius = Math.min(3, (int) (d / 12.0));

                for (int x = -coneRadius; x <= coneRadius; x++) {
                    for (int y = -coneRadius; y <= coneRadius; y++) {
                        for (int z = -coneRadius; z <= coneRadius; z++) {

                            mutablePos.set(checkVec.x + x, checkVec.y + y, checkVec.z + z);
                            BlockState state = world.getBlockState(mutablePos);

                            // Block
                            if (RadiationRegistry.isRadioactive(state.getBlock())) {
                                RadiationRegistry.RadiationData data = RadiationRegistry.get(state.getBlock());
                                    if (d <= data.maxRange()){
                                        double signal = (1.0 - (d / data.maxRange())) * data.intensity();
                                        if (signal > highestSignal) highestSignal = signal;
                                    }
                            }

                            // Containers
                            if (state.hasBlockEntity() && world.getBlockEntity(mutablePos) instanceof Inventory inventory) {
                                for (int i = 0; i < inventory.size(); i++) {
                                    ItemStack itemStack = inventory.getStack(i);
                                    if (!itemStack.isEmpty() && RadiationRegistry.isRadioactive(itemStack.getItem())) {
                                        RadiationRegistry.RadiationData data = RadiationRegistry.getRadiationData(itemStack);
                                        if (d < data.maxRange()) {
                                            float quantityMultiplier = 1.0f + (itemStack.getCount() * 0.005f);
                                            double signal = (1.0 - (d / data.maxRange())) * (data.intensity() * quantityMultiplier);
                                            if (signal > highestSignal) highestSignal = signal;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

                // Dropped Items and Item Frames

                BlockPos centerPos = BlockPos.ofFloored(checkVec);
                Box searchBox = new Box(centerPos).expand(coneRadius);

                // Dropped Items
                List<ItemEntity> droppedItems = world.getEntitiesByClass(ItemEntity.class, searchBox, e -> true);
                for (ItemEntity itemEntity : droppedItems) {
                    RadiationRegistry.RadiationData data = RadiationRegistry.getRadiationData(itemEntity.getStack());
                    if (data != null && d <= data.maxRange()) {
                        double signal = (1.0 - (d / data.maxRange())) * data.intensity();
                        if (signal > highestSignal) highestSignal = signal;
                    }
                }

                // Item Frames
                List<ItemFrameEntity> itemFrames = world.getEntitiesByClass(ItemFrameEntity.class, searchBox, e -> true);
                for (ItemFrameEntity frame : itemFrames) {
                    RadiationRegistry.RadiationData data = RadiationRegistry.getRadiationData(frame.getHeldItemStack());
                    if (data != null && d <= data.maxRange()) {
                        double signal = (1.0 - (d / data.maxRange())) * data.intensity();
                        if (signal > highestSignal) highestSignal = signal;
                    }
                }

                if (highestSignal >= 1.5) break;
            }

            if (highestSignal > 0.0) {
                int currentTick = player.age;
                int lastTick = LAST_PLAY_TICK.getOrDefault(player.getUuid(), 0);
                int baseInterval = Math.max(1, (int) (15.0 * (1.0 - Math.min(1.0, highestSignal / 1.5))));
                if (currentTick - lastTick >= baseInterval) {
                    world.playSound(null, player.getX(), player.getY(), player.getZ(),
                            ModSounds.GEIGER_CLICK, SoundCategory.PLAYERS,
                            0.8f, (float) (0.9f + (world.random.nextFloat() * 0.3)));

                    int radiationRandomness = world.random.nextInt(Math.max(1, baseInterval / 2));
                    LAST_PLAY_TICK.put(player.getUuid(), currentTick + radiationRandomness);
                }
            }

        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
