package net.ratseerofrattesse.drehmal_regenesis.world.gen.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModLocalModificationsFeatureGeneration {
    public static void generateGeodes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.BADLANDS,
                        BiomeKeys.ERODED_BADLANDS,
                        BiomeKeys.FROZEN_PEAKS,
                        BiomeKeys.ICE_SPIKES,
                        BiomeKeys.JAGGED_PEAKS,
                        BiomeKeys.STONY_PEAKS,
                        BiomeKeys.LUSH_CAVES,
                        BiomeKeys.DRIPSTONE_CAVES),
                GenerationStep.Feature.LOCAL_MODIFICATIONS, ModPlacedFeatures.REHNTITE_GEODE_PLACED_KEY);
    }
}
