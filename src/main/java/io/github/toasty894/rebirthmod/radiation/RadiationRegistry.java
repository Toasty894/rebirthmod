package io.github.toasty894.rebirthmod.radiation;

import io.github.toasty894.rebirthmod.RebirthMod;
import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class RadiationRegistry {


    public record RadiationData(int maxRange, float intensity, boolean isHarmful) {}

    private static final Map<Block, RadiationData> REGISTRY = new HashMap<>();
    private static final Map<Item, RadiationData> ITEM_REGISTRY = new HashMap<>();
    private static final Map<EntityType<?>, RadiationData> ENTITY_REGISTRY = new HashMap<>();

    public static RadiationData getRadiationData(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return null;

        Item item = stack.getItem();

        if (isRadioactive(item)) {
            return get(item);
        }

        Block block = Block.getBlockFromItem(item);
        if (block != net.minecraft.block.Blocks.AIR && isRadioactive(block)) {
            RadiationData blockData = get(block);
            return new RadiationData((int) (blockData.maxRange() * 0.8f),
                    blockData.intensity() * 0.8f, blockData.isHarmful());
        }
        return null;
    }

    public static void register(Block block, int maxRange, float intensity, boolean isHarmful) {
        REGISTRY.put(block, new RadiationData(maxRange, intensity, isHarmful));
    }
    public static void register(Item item, int maxRange, float intensity, boolean isHarmful) {
        ITEM_REGISTRY.put(item, new RadiationData(maxRange, intensity, isHarmful));
    }
    public static void register(EntityType<?> entityType, int maxRange, float intensity, boolean isHarmful) {
        ENTITY_REGISTRY.put(entityType, new RadiationData(maxRange, intensity, isHarmful));
    }

    public static RadiationData get(Block block){
        return REGISTRY.get(block);
    }
    public static RadiationData get(Item item){
        return ITEM_REGISTRY.get(item);
    }
    public static RadiationData get(EntityType<?> entityType){
        return ENTITY_REGISTRY.get(entityType);
    }

    public static boolean isRadioactive(Block block){
        return REGISTRY.containsKey(block);
    }
    public static boolean isRadioactive(Item item){
        return ITEM_REGISTRY.containsKey(item);
    }
    public static boolean isRadioactive(EntityType<?> entityType){
        return ENTITY_REGISTRY.containsKey(entityType);
    }

    public static void registerRadiationLevels() {
        RebirthMod.LOGGER.info("Registering Radioactive Levels for " + RebirthMod.MOD_ID);

        // Blocks
        register(ModBlocks.PITCHBLENDE_ORE, 12, 1.2f, false);
        register(ModBlocks.DEEPSLATE_PITCHBLENDE_ORE, 12, 1.2f, false);
        register(ModBlocks.RAW_PITCHBLENDE_BLOCK, 16, 1.8f, false);
        register(ModBlocks.PITCHBLENDE_BLOCK, 16, 1.8f, false);

        // Dropped Items
            // Misc
        register(ModItems.RAW_PITCHBLENDE, 8, 0.8f, false);
        register(ModItems.PITCHBLENDE_INGOT, 8, 0.8f, false);
        register(ModItems.YELLOW_CAKE, 10, 1.2f, false);
        register(ModItems.URANIUM, 12, 1.5f, false);
        register(ModItems.URANIUM_235, 16, 2.5f, true);

            // Tools
        register(ModItems.PITCHBLENDE_SWORD, 8, 0.7f, false);
        register(ModItems.PITCHBLENDE_SHOVEL, 8, 0.7f, false);
        register(ModItems.PITCHBLENDE_PICKAXE, 8, 0.7f, false);
        register(ModItems.PITCHBLENDE_AXE, 8, 0.7f, false);
        register(ModItems.PITCHBLENDE_HOE, 8, 0.7f, false);
        register(ModItems.GEIGER_COUNTER, 2, 0.5f, false);

        // Mobs (Add in future)
    }
}
