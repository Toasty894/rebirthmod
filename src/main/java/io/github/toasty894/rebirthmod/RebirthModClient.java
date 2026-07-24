package io.github.toasty894.rebirthmod;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;

public class RebirthModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACAI_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CASHEW_LEAVES, RenderLayer.getCutoutMipped());

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                return BiomeColors.getFoliageColor(world, pos);
            }
            return FoliageColors.getDefaultColor();
        }, ModBlocks.ACAI_LEAVES, ModBlocks.CASHEW_LEAVES);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return FoliageColors.getDefaultColor();
        }, ModBlocks.ACAI_LEAVES, ModBlocks.CASHEW_LEAVES);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACAI_CLUSTER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GUARANA_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PASSION_FRUIT_VINE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.ACAI_DOOR,
                ModBlocks.ACAI_TRAPDOOR,
                ModBlocks.ACAI_SAPLING,
                ModBlocks.CASHEW_DOOR,
                ModBlocks.CASHEW_TRAPDOOR,
                ModBlocks.CASHEW_SAPLING
        );
    }
}
