package net.ratseerofrattesse.drehmal_regenesis.world.gen.feature;

import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;
import net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.mendarum.MendarumSpikeFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_MENDARUM_KEY = registerKey("purple_mendarum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MENDARUM_KEY = registerKey("red_mendarum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MENDARUM_KEY = registerKey("blue_mendarum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> REHNTITE_GEODE_KEY = registerKey("rehntite_geode");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, PURPLE_MENDARUM_KEY, ModFeatures.MENDARUM_SPIKE_FEATURE,
                new MendarumSpikeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.PURPLE_MENDARUM_BLOCK),
                        BlockStateProvider.of(ModBlocks.PURPLE_MENDARUM_SHELL),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).build());
        register(context, RED_MENDARUM_KEY, ModFeatures.MENDARUM_SPIKE_FEATURE,
                new MendarumSpikeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.RED_MENDARUM_BLOCK),
                        BlockStateProvider.of(ModBlocks.RED_MENDARUM_SHELL),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).build());
        register(context, BLUE_MENDARUM_KEY, ModFeatures.MENDARUM_SPIKE_FEATURE,
                new MendarumSpikeFeatureConfig.Builder(
                        BlockStateProvider.of(ModBlocks.BLUE_MENDARUM_BLOCK),
                        BlockStateProvider.of(ModBlocks.BLUE_MENDARUM_SHELL),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).build());
        register(context, REHNTITE_GEODE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(
                        new GeodeLayerConfig(
                                BlockStateProvider.of(Blocks.AIR),
                                BlockStateProvider.of(ModBlocks.RAW_REHNTITE_BLOCK),
                                BlockStateProvider.of(ModBlocks.RAW_REHNTITE_BLOCK),
                                BlockStateProvider.of(Blocks.PRISMARINE),
                                BlockStateProvider.of(Blocks.SMOOTH_BASALT),
                                List.of(
                                        Blocks.AIR.getDefaultState()
                                ),
                                BlockTags.FEATURES_CANNOT_REPLACE,
                                BlockTags.GEODE_INVALID_BLOCKS
                        ),
                        new GeodeLayerThicknessConfig(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackConfig(0.95, 2.0, 2),
                        0.35,
                        0.083,
                        true,
                        UniformIntProvider.create(4, 6),
                        UniformIntProvider.create(3, 4),
                        UniformIntProvider.create(1, 2),
                        -16,
                        16,
                        0.05,
                        1
                )
        );
    }



    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(DrehmalRegenesis.MOD_ID, name));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }




}
