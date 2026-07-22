package io.github.toasty894.rebirthmod.world;

import io.github.toasty894.rebirthmod.RebirthMod;
import io.github.toasty894.rebirthmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PITCHBLENDE_ORE_KEY = registerKey("pitchblende_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GALENA_ORE_KEY = registerKey("galena_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCHEELITE_ORE_KEY = registerKey("scheelite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GALENA_CLUSTER_KEY = registerKey("galena_cluster");


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
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RAW_GALENA_BLOCK.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.RAW_GALENA_BLOCK.getDefaultState())
        );

        register(context, GALENA_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldGalenaOres, 16));
        register(context, GALENA_CLUSTER_KEY, Feature.ORE, new OreFeatureConfig(galenaClusterTargets, 45));

        register(context, PITCHBLENDE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPitchblendeOres, 10));
        register(context, SCHEELITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldScheeliteOres, 6));

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(RebirthMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register (Registerable<ConfiguredFeature<?, ?>> context,
                                                                                    RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
