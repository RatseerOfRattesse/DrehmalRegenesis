package net.ratseerofrattesse.drehmal_regenesis.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.biome.OverworldBiomeCreator.getSkyColor;

public class ModOverworldBiomeCreator {
    protected static final int DEFAULT_WATER_COLOR = 4159204;
    protected static final int DEFAULT_WATER_FOG_COLOR = 329011;
    private static final int DEFAULT_FOG_COLOR = 12638463;
    @Nullable
    private static final MusicSound DEFAULT_MUSIC = null;

    public static Biome createDawnlands(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addBatsAndMonsters(builder);
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.MOOSHROOM, 6, 1, 2));
        builder.creatureSpawnProbability(0.04F);


        GenerationSettings.LookupBackedBuilder lookupBackedBuilder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);
        addBasicFeatures(lookupBackedBuilder);
        DefaultBiomeFeatures.addDefaultOres(lookupBackedBuilder);
        DefaultBiomeFeatures.addDefaultDisks(lookupBackedBuilder);
        DefaultBiomeFeatures.addBadlandsPlateauTrees(lookupBackedBuilder);


        DefaultBiomeFeatures.addBadlandsGrass(lookupBackedBuilder);
        DefaultBiomeFeatures.addDefaultMushrooms(lookupBackedBuilder);
        DefaultBiomeFeatures.addMushroomFieldsFeatures(lookupBackedBuilder);
        DefaultBiomeFeatures.addBadlandsVegetation(lookupBackedBuilder);
        return new Biome.Builder()
                .precipitation(true)
                .temperature(1.0F)
                .downfall(1.0F)
                .effects(
                        new BiomeEffects.Builder()
                                .waterColor(4159204)
                                .waterFogColor(329011)
                                .fogColor(12638463)
                                .skyColor(getSkyColor(1.0F))
                                .foliageColor(7214976)
                                .grassColor(6361451)
                                .moodSound(BiomeMoodSound.CAVE)
                                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_LUSH_CAVES))
                                .build()
                )
                .spawnSettings(builder.build())
                .generationSettings(lookupBackedBuilder.build())
                .build();
    }



    public static Biome createDusklands(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addBatsAndMonsters(builder);
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.MOOSHROOM, 6, 1, 2));
        builder.creatureSpawnProbability(0.04F);


        GenerationSettings.LookupBackedBuilder lookupBackedBuilder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);
        addBasicFeatures(lookupBackedBuilder);
        DefaultBiomeFeatures.addDefaultOres(lookupBackedBuilder);
        DefaultBiomeFeatures.addDefaultDisks(lookupBackedBuilder);
        DefaultBiomeFeatures.addBadlandsPlateauTrees(lookupBackedBuilder);


        DefaultBiomeFeatures.addBadlandsGrass(lookupBackedBuilder);
        DefaultBiomeFeatures.addDefaultMushrooms(lookupBackedBuilder);
        DefaultBiomeFeatures.addMushroomFieldsFeatures(lookupBackedBuilder);
        DefaultBiomeFeatures.addBadlandsVegetation(lookupBackedBuilder);
        return new Biome.Builder()
                .precipitation(true)
                .temperature(1.0F)
                .downfall(1.0F)
                .effects(
                        new BiomeEffects.Builder()
                                .waterColor(4159204)
                                .waterFogColor(329011)
                                .fogColor(12638463)
                                .skyColor(getSkyColor(2.0F))
                                .foliageColor(7214976)
                                .grassColor(6361451)
                                .moodSound(BiomeMoodSound.CAVE)
                                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_LUSH_CAVES))
                                .build()
                )
                .spawnSettings(builder.build())
                .generationSettings(lookupBackedBuilder.build())
                .build();
    }

    private static Biome createBiome(
            boolean precipitation,
            float temperature,
            float downfall,
            SpawnSettings.Builder spawnSettings,
            GenerationSettings.LookupBackedBuilder generationSettings,
            @Nullable MusicSound music
    ) {
        return createBiome(precipitation, temperature, downfall, 4159204, 329011, null, null, spawnSettings, generationSettings, music);
    }

    private static Biome createBiome(
            boolean precipitation,
            float temperature,
            float downfall,
            int waterColor,
            int waterFogColor,
            @Nullable Integer grassColor,
            @Nullable Integer foliageColor,
            SpawnSettings.Builder spawnSettings,
            GenerationSettings.LookupBackedBuilder generationSettings,
            @Nullable MusicSound music
    ) {
        BiomeEffects.Builder builder = new BiomeEffects.Builder()
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .fogColor(12638463)
                .skyColor(getSkyColor(temperature))
                .moodSound(BiomeMoodSound.CAVE)
                .music(music);
        if (grassColor != null) {
            builder.grassColor(grassColor);
        }

        if (foliageColor != null) {
            builder.foliageColor(foliageColor);
        }

        return new Biome.Builder()
                .precipitation(precipitation)
                .temperature(temperature)
                .downfall(downfall)
                .effects(builder.build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static void addBasicFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }
}
