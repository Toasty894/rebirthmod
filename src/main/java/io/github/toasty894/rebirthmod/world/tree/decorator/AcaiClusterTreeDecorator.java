package io.github.toasty894.rebirthmod.world.tree.decorator;

import com.mojang.serialization.Codec;
import io.github.toasty894.rebirthmod.RebirthMod;
import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.block.custom.AcaiClusterBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class AcaiClusterTreeDecorator extends TreeDecorator {
    public static final Codec<AcaiClusterTreeDecorator> CODEC = Codec.unit(AcaiClusterTreeDecorator::new);
    public static final TreeDecoratorType<AcaiClusterTreeDecorator> TYPE =
            Registry.register(Registries.TREE_DECORATOR_TYPE, new Identifier(RebirthMod.MOD_ID, "acai_cluster"), new TreeDecoratorType<>(CODEC));

    public static final AcaiClusterTreeDecorator INSTANCE = new AcaiClusterTreeDecorator();

    @Override
    protected TreeDecoratorType<?> getType() {
        return TYPE;
    }

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        for (BlockPos pos : generator.getLogPositions()) {
            if (random.nextFloat() < 0.30f) {
                BlockPos posBelow = pos.down();
                if (generator.isAir(posBelow)) {
                    int stage = random.nextInt(4);
                    generator.replace(posBelow, ModBlocks.ACAI_CLUSTER.getDefaultState().with(AcaiClusterBlock.AGE, stage));
                }
            }
        }
    }
    public static void register() {
        RebirthMod.LOGGER.info("Registering Tree Decorators for " + RebirthMod.MOD_ID);
    }
}