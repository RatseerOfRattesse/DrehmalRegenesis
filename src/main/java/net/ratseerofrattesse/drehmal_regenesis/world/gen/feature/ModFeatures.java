package net.ratseerofrattesse.drehmal_regenesis.world.gen.feature;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;
import net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.mendarum.MendarumSpikeFeature;
import net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.mendarum.MendarumSpikeFeatureConfig;

public class ModFeatures<FC extends FeatureConfig> {

    public static final Feature<MendarumSpikeFeatureConfig> MENDARUM_SPIKE_FEATURE = register("mendarum_spike", new MendarumSpikeFeature(MendarumSpikeFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registries.FEATURE, name, feature);
    }

    public static void registerModFeatures() {
        DrehmalRegenesis.LOGGER.info("Registering features for Drehmal Regenesis");
    }
}
