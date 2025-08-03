package net.ratseerofrattesse.drehmal_regenesis.world.gen.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.ratseerofrattesse.drehmal_regenesis.world.biome.ModBiomes;

public class ModSurfaceFeatureGeneration {
    public static void generateMendarum() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DAWNLANDS, ModBiomes.DUSKLANDS),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.PURPLE_MENDARUM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DAWNLANDS, ModBiomes.DUSKLANDS),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.RED_MENDARUM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DAWNLANDS, ModBiomes.DUSKLANDS),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.BLUE_MENDARUM_PLACED_KEY);
    }
}
