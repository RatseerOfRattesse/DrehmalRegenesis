package net.ratseerofrattesse.drehmal_regenesis.world.gen;

import net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.ModSurfaceFeatureGeneration;
import net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.ModLocalModificationsFeatureGeneration;

public class ModWorldGen {

    public static void generateModWorldGen() {
        ModLocalModificationsFeatureGeneration.generateGeodes();
        ModSurfaceFeatureGeneration.generateMendarum();
    }

}
