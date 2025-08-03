package net.ratseerofrattesse.drehmal_regenesis.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PURPLE_MENDARUM_PLACED_KEY = registerKey("purple_mendarum_placed");
    public static final RegistryKey<PlacedFeature> RED_MENDARUM_PLACED_KEY = registerKey("red_mendarum_placed");
    public static final RegistryKey<PlacedFeature> BLUE_MENDARUM_PLACED_KEY = registerKey("blue_mendarum_placed");

    public static final RegistryKey<PlacedFeature> REHNTITE_GEODE_PLACED_KEY = registerKey("rehntite_geode_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        PlacedFeatures.register(
                context,
                PURPLE_MENDARUM_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.PURPLE_MENDARUM_KEY),
                CountPlacementModifier.of(1),
                RarityFilterPlacementModifier.of(24),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        PlacedFeatures.register(
                context,
                RED_MENDARUM_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_MENDARUM_KEY),
                CountPlacementModifier.of(1),
                RarityFilterPlacementModifier.of(24),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        PlacedFeatures.register(
                context,
                BLUE_MENDARUM_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUE_MENDARUM_KEY),
                CountPlacementModifier.of(1),
                RarityFilterPlacementModifier.of(24),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        PlacedFeatures.register(
                context,
                REHNTITE_GEODE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.REHNTITE_GEODE_KEY),
                RarityFilterPlacementModifier.of(24),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.fixed(30)),
                BiomePlacementModifier.of()
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(DrehmalRegenesis.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
