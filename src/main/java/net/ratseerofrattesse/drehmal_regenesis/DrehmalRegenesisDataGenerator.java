package net.ratseerofrattesse.drehmal_regenesis;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.ratseerofrattesse.drehmal_regenesis.datagen.*;
import net.ratseerofrattesse.drehmal_regenesis.world.biome.ModBiomes;
import net.ratseerofrattesse.drehmal_regenesis.world.biome.ModOverworldBiomeCreator;
import net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.ModConfiguredFeatures;
import net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.ModPlacedFeatures;

public class DrehmalRegenesisDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
		pack.addProvider(ModEnglishUSLanguageProvider::new);
		pack.addProvider(ModEnglishCALanguageProvider::new);
		pack.addProvider(ModBiomeTagProvider::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		//registryBuilder.addRegistry(RegistryKeys.TRIM_PATTERN, ModTrimPatterns::bootstrap);
	}
}
