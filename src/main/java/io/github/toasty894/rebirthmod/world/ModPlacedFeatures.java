package io.github.toasty894.rebirthmod.world;

import io.github.toasty894.rebirthmod.RebirthMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> GALENA_ORE_PLACED_KEY = registerKey("galena_ore_placed");
    public static final RegistryKey<PlacedFeature> GALENA_CLUSTER_PLACED_KEY = registerKey("galena_cluster_placed");

    public static final RegistryKey<PlacedFeature> PITCHBLENDE_ORE_PLACED_KEY = registerKey("pitchblende_ore_placed");
    public static final RegistryKey<PlacedFeature> SCHEELITE_ORE_PLACED_KEY = registerKey("scheelite_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PITCHBLENDE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PITCHBLENDE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(6,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(30))));

        register(context, GALENA_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GALENA_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(80))));

        register(context, SCHEELITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SCHEELITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(0))));

        register(context, GALENA_CLUSTER_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GALENA_CLUSTER_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(64), // 1 in 64 chance to spawn per chunk
                        SquarePlacementModifier.of(), // Spreads it horizontally
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(40)),
                        BiomePlacementModifier.of()
                ));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(RebirthMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
