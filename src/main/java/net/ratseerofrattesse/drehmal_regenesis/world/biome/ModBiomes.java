package net.ratseerofrattesse.drehmal_regenesis.world.biome;

import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;

public class ModBiomes {

    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> registryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> registryEntryLookup2 = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        context.register(ModBiomes.DAWNLANDS, ModOverworldBiomeCreator.createDawnlands(registryEntryLookup, registryEntryLookup2));
        context.register(ModBiomes.DUSKLANDS, ModOverworldBiomeCreator.createDusklands(registryEntryLookup, registryEntryLookup2));
    }

    public static final RegistryKey<Biome> DAWNLANDS = registerKey("dawnlands");
    public static final RegistryKey<Biome> DUSKLANDS = registerKey("dusklands");

    private static RegistryKey<Biome> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(DrehmalRegenesis.MOD_ID, name));
    }

    public static void registerModBiomes() {
        DrehmalRegenesis.LOGGER.info("Registering biomes for Drehmal Regenesis");
    }
}
