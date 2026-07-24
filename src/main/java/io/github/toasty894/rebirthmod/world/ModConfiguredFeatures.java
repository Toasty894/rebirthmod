package io.github.toasty894.rebirthmod.world;

import io.github.toasty894.rebirthmod.RebirthMod;
import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.world.tree.decorator.AcaiClusterTreeDecorator;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PITCHBLENDE_ORE_KEY = registerKey("pitchblende_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GALENA_ORE_KEY = registerKey("galena_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCHEELITE_ORE_KEY = registerKey("scheelite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GALENA_CLUSTER_KEY = registerKey("galena_cluster");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ACAI_KEY = registerKey("acai_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CASHEW_KEY = registerKey("cashew_tree");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldPitchblendeOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PITCHBLENDE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_PITCHBLENDE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldGalenaOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.GALENA_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_GALENA_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldScheeliteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SCHEELITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SCHEELITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> galenaClusterTargets = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.GALENA_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_GALENA_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.GALENA_BLOCK.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.GALENA_BLOCK.getDefaultState())
        );

        register(context, GALENA_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldGalenaOres, 8));
        register(context, GALENA_CLUSTER_KEY, Feature.ORE, new OreFeatureConfig(galenaClusterTargets, 32));

        register(context, PITCHBLENDE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPitchblendeOres, 6));
        register(context, SCHEELITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldScheeliteOres, 4));

        // Acai Tree
        register(context, ACAI_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ACAI_LOG),
                new StraightTrunkPlacer(12, 6, 0),
                BlockStateProvider.of(ModBlocks.ACAI_LEAVES),
                new net.minecraft.world.gen.foliage.JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 1))
                .decorators(List.of(AcaiClusterTreeDecorator.INSTANCE))
                .build());

        // Cashew Tree
        register(context, CASHEW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CASHEW_LOG),
                new net.minecraft.world.gen.trunk.ForkingTrunkPlacer(5, 2, 2), // Splits into branches
                BlockStateProvider.of(ModBlocks.CASHEW_LEAVES),
                new net.minecraft.world.gen.foliage.AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(RebirthMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register (Registerable<ConfiguredFeature<?, ?>> context,
                                                                                    RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
