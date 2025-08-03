package net.ratseerofrattesse.drehmal_regenesis.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.annotation.Debug;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import net.ratseerofrattesse.drehmal_regenesis.world.biome.ModBiomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Consumer;

@Mixin(VanillaBiomeParameters.class)
public class VanillaBiomeParametersMixin {
	private final MultiNoiseUtil.ParameterRange frozenTemperature = this.temperatureParameters[0];
	private final MultiNoiseUtil.ParameterRange nonFrozenTemperatureParameters = MultiNoiseUtil.ParameterRange.combine(
			this.temperatureParameters[1], this.temperatureParameters[4]
	);
	private final MultiNoiseUtil.ParameterRange defaultParameter = MultiNoiseUtil.ParameterRange.of(-1.0F, 1.0F);
	private final MultiNoiseUtil.ParameterRange dawndusklandsContinentalness = MultiNoiseUtil.ParameterRange.of(-1.2F, -1.05F);
	private final MultiNoiseUtil.ParameterRange mushroomFieldsContinentalness = MultiNoiseUtil.ParameterRange.of(-1.2F, -1.05F);
	private final MultiNoiseUtil.ParameterRange deepOceanContinentalness = MultiNoiseUtil.ParameterRange.of(-1.05F, -0.455F);
	private final MultiNoiseUtil.ParameterRange oceanContinentalness = MultiNoiseUtil.ParameterRange.of(-0.455F, -0.19F);
	private final MultiNoiseUtil.ParameterRange riverContinentalness = MultiNoiseUtil.ParameterRange.of(-0.11F, 0.55F);
	private final MultiNoiseUtil.ParameterRange coastContinentalness = MultiNoiseUtil.ParameterRange.of(-0.19F, -0.11F);
	private final MultiNoiseUtil.ParameterRange nearInlandContinentalness = MultiNoiseUtil.ParameterRange.of(-0.11F, 0.03F);
	private final MultiNoiseUtil.ParameterRange midInlandContinentalness = MultiNoiseUtil.ParameterRange.of(0.03F, 0.3F);
	private final MultiNoiseUtil.ParameterRange farInlandContinentalness = MultiNoiseUtil.ParameterRange.of(0.3F, 1.0F);

	private final MultiNoiseUtil.ParameterRange[] temperatureParameters = new MultiNoiseUtil.ParameterRange[]{
			MultiNoiseUtil.ParameterRange.of(-1.0F, -0.45F),
			MultiNoiseUtil.ParameterRange.of(-0.45F, -0.15F),
			MultiNoiseUtil.ParameterRange.of(-0.15F, 0.2F),
			MultiNoiseUtil.ParameterRange.of(0.2F, 0.55F),
			MultiNoiseUtil.ParameterRange.of(0.55F, 1.0F)
	};
	private final MultiNoiseUtil.ParameterRange[] humidityParameters = new MultiNoiseUtil.ParameterRange[]{
			MultiNoiseUtil.ParameterRange.of(-1.0F, -0.35F),
			MultiNoiseUtil.ParameterRange.of(-0.35F, -0.1F),
			MultiNoiseUtil.ParameterRange.of(-0.1F, 0.1F),
			MultiNoiseUtil.ParameterRange.of(0.1F, 0.3F),
			MultiNoiseUtil.ParameterRange.of(0.3F, 1.0F)
	};
	private final MultiNoiseUtil.ParameterRange[] erosionParameters = new MultiNoiseUtil.ParameterRange[]{
			MultiNoiseUtil.ParameterRange.of(-1.0F, -0.78F),
			MultiNoiseUtil.ParameterRange.of(-0.78F, -0.375F),
			MultiNoiseUtil.ParameterRange.of(-0.375F, -0.2225F),
			MultiNoiseUtil.ParameterRange.of(-0.2225F, 0.05F),
			MultiNoiseUtil.ParameterRange.of(0.05F, 0.45F),
			MultiNoiseUtil.ParameterRange.of(0.45F, 0.55F),
			MultiNoiseUtil.ParameterRange.of(0.55F, 1.0F)
	};

	@Overwrite
	private RegistryKey<Biome> getRegularBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		if (weirdness.max() < 0L) {
			return this.commonBiomes[temperature][humidity];
		} else {
			RegistryKey<Biome> registryKey = this.uncommonBiomes[temperature][humidity];
			return registryKey == null ? this.commonBiomes[temperature][humidity] : registryKey;
		}
	}

	@Overwrite
	private RegistryKey<Biome> getBadlandsOrRegularBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		return temperature == 4 ? this.getBadlandsBiome(humidity, weirdness) : this.getRegularBiome(temperature, humidity, weirdness);
	}

	private RegistryKey<Biome> getDawnDuskOrRegularBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		return temperature == 1 ? this.getDawnDuskBiome(weirdness) : this.getRegularBiome(temperature, humidity, weirdness);
	}

	@Overwrite
	private RegistryKey<Biome> getMountainStartBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		return temperature == 0 ? this.getMountainSlopeBiome(temperature, humidity, weirdness) : this.getBadlandsOrRegularBiome(temperature, humidity, weirdness);
	}

	@Overwrite
	private RegistryKey<Biome> getBiomeOrWindsweptSavanna(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness, RegistryKey<Biome> biomeKey) {
		return temperature > 1 && humidity < 4 && weirdness.max() >= 0L ? BiomeKeys.WINDSWEPT_SAVANNA : biomeKey;
	}

	@Overwrite
	private RegistryKey<Biome> getBadlandsBiome(int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		if (humidity < 2) {
			return weirdness.max() < 0L ? BiomeKeys.BADLANDS : BiomeKeys.ERODED_BADLANDS;
		} else {
			return humidity < 3 ? BiomeKeys.BADLANDS : BiomeKeys.WOODED_BADLANDS;
		}
	}

	private RegistryKey<Biome> getDawnDuskBiome(MultiNoiseUtil.ParameterRange weirdness) {
		return weirdness.max() < 0L ? ModBiomes.DAWNLANDS : ModBiomes.DUSKLANDS;
	}

	@Overwrite
	private RegistryKey<Biome> getNearMountainBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		if (weirdness.max() >= 0L) {
			RegistryKey<Biome> registryKey = this.specialNearMountainBiomes[temperature][humidity];
			if (registryKey != null) {
				return registryKey;
			}
		}

		return this.nearMountainBiomes[temperature][humidity];
	}

	@Overwrite
	private RegistryKey<Biome> getPeakBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		if (temperature <= 2) {
			return weirdness.max() < 0L ? BiomeKeys.JAGGED_PEAKS : BiomeKeys.FROZEN_PEAKS;
		} else {
			return temperature == 3 ? BiomeKeys.STONY_PEAKS : this.getBadlandsBiome(humidity, weirdness);
		}
	}

	@Overwrite
	private RegistryKey<Biome> getMountainSlopeBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		if (temperature >= 3) {
			return this.getNearMountainBiome(temperature, humidity, weirdness);
		} else {
			return humidity <= 1 ? BiomeKeys.SNOWY_SLOPES : BiomeKeys.GROVE;
		}
	}

	@Overwrite
	private RegistryKey<Biome> getWindsweptOrRegularBiome(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness) {
		RegistryKey<Biome> registryKey = this.windsweptBiomes[temperature][humidity];
		return registryKey == null ? this.getRegularBiome(temperature, humidity, weirdness) : registryKey;
	}

	@Overwrite
	private void writeBiomeParameters(
			Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters,
			MultiNoiseUtil.ParameterRange temperature,
			MultiNoiseUtil.ParameterRange humidity,
			MultiNoiseUtil.ParameterRange continentalness,
			MultiNoiseUtil.ParameterRange erosion,
			MultiNoiseUtil.ParameterRange weirdness,
			float offset,
			RegistryKey<Biome> biome
	) {
		parameters.accept(
				Pair.of(
						MultiNoiseUtil.createNoiseHypercube(temperature, humidity, continentalness, erosion, MultiNoiseUtil.ParameterRange.of(0.0F), weirdness, offset), biome
				)
		);
		parameters.accept(
				Pair.of(
						MultiNoiseUtil.createNoiseHypercube(temperature, humidity, continentalness, erosion, MultiNoiseUtil.ParameterRange.of(1.0F), weirdness, offset), biome
				)
		);
	}

	@Shadow
	private final RegistryKey<Biome>[][] commonBiomes = new RegistryKey[][]{
			{BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.TAIGA},
			{BiomeKeys.PLAINS, BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
			{BiomeKeys.FLOWER_FOREST, BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.DARK_FOREST},
			{BiomeKeys.SAVANNA, BiomeKeys.SAVANNA, BiomeKeys.FOREST, BiomeKeys.JUNGLE, BiomeKeys.JUNGLE},
			{BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT, BiomeKeys.DESERT}
	};

	@Shadow
	private final RegistryKey<Biome>[][] uncommonBiomes = new RegistryKey[][]{
			{BiomeKeys.ICE_SPIKES, null, BiomeKeys.SNOWY_TAIGA, null, null},
			{null, null, null, null, BiomeKeys.OLD_GROWTH_PINE_TAIGA},
			{BiomeKeys.SUNFLOWER_PLAINS, null, null, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, null},
			{null, null, BiomeKeys.PLAINS, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.BAMBOO_JUNGLE},
			{null, null, null, null, null}
	};
	@Shadow
	private final RegistryKey<Biome>[][] nearMountainBiomes = new RegistryKey[][]{
			{BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA},
			{BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA},
			{BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.DARK_FOREST},
			{BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.JUNGLE},
			{BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.WOODED_BADLANDS}
	};
	@Shadow
	private final RegistryKey<Biome>[][] specialNearMountainBiomes = new RegistryKey[][]{
			{BiomeKeys.ICE_SPIKES, null, null, null, null},
			{BiomeKeys.CHERRY_GROVE, null, BiomeKeys.MEADOW, BiomeKeys.MEADOW, BiomeKeys.OLD_GROWTH_PINE_TAIGA},
			{BiomeKeys.CHERRY_GROVE, BiomeKeys.CHERRY_GROVE, BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, null},
			{null, null, null, null, null},
			{BiomeKeys.ERODED_BADLANDS, BiomeKeys.ERODED_BADLANDS, null, null, null}
	};
	@Shadow
	private final RegistryKey<Biome>[][] windsweptBiomes = new RegistryKey[][]{
			{BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
			{BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
			{BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_FOREST},
			{null, null, null, null, null},
			{null, null, null, null, null}
	};
	@Shadow
	private final RegistryKey<Biome>[][] oceanBiomes = new RegistryKey[][]{
			{BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN},
			{BiomeKeys.FROZEN_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN}
	};

	@Overwrite
	public String getContinentalnessDescription(double continentalness) {
		double d = MultiNoiseUtil.toLong((float)continentalness);
		if (d < this.mushroomFieldsContinentalness.max()) {
			return "Mushroom fields";
		} else if (d < this.dawndusklandsContinentalness.max()) {
			return "Dawn/Dusk lands";
		} else if (d < this.deepOceanContinentalness.max()) {
			return "Deep ocean";
		} else if (d < this.oceanContinentalness.max()) {
			return "Ocean";
		} else if (d < this.coastContinentalness.max()) {
			return "Coast";
		} else if (d < this.nearInlandContinentalness.max()) {
			return "Near inland";
		} else {
			return d < this.midInlandContinentalness.max() ? "Mid inland" : "Far inland";
		}
	}

	@Overwrite
	@Debug
	public MultiNoiseUtil.ParameterRange[] getContinentalnessParameters() {
		return new MultiNoiseUtil.ParameterRange[]{
				this.dawndusklandsContinentalness,
				this.mushroomFieldsContinentalness,
				this.deepOceanContinentalness,
				this.oceanContinentalness,
				this.coastContinentalness,
				this.nearInlandContinentalness,
				this.midInlandContinentalness,
				this.farInlandContinentalness
		};
	}

	@Overwrite
	private void writeOceanBiomes(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters) {
		this.writeBiomeParameters(
				parameters,
				this.defaultParameter,
				this.defaultParameter,
				this.dawndusklandsContinentalness,
				this.defaultParameter,
				this.defaultParameter,
				0.0F,
				ModBiomes.DAWNLANDS
		);
		this.writeBiomeParameters(
				parameters,
				this.defaultParameter,
				this.defaultParameter,
				this.dawndusklandsContinentalness,
				this.defaultParameter,
				this.defaultParameter,
				0.0F,
				ModBiomes.DUSKLANDS
		);
		this.writeBiomeParameters(
				parameters,
				this.defaultParameter,
				this.defaultParameter,
				this.mushroomFieldsContinentalness,
				this.defaultParameter,
				this.defaultParameter,
				0.0F,
				BiomeKeys.MUSHROOM_FIELDS
		);

		for (int i = 0; i < this.temperatureParameters.length; i++) {
			MultiNoiseUtil.ParameterRange parameterRange = this.temperatureParameters[i];
			this.writeBiomeParameters(
					parameters,
					parameterRange,
					this.defaultParameter,
					this.deepOceanContinentalness,
					this.defaultParameter,
					this.defaultParameter,
					0.0F,
					this.oceanBiomes[0][i]
			);
			this.writeBiomeParameters(
					parameters, parameterRange, this.defaultParameter, this.oceanContinentalness, this.defaultParameter, this.defaultParameter, 0.0F, this.oceanBiomes[1][i]
			);
		}
	}

	@Overwrite
	private void writeHighBiomes(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, MultiNoiseUtil.ParameterRange weirdness) {
		for (int i = 0; i < this.temperatureParameters.length; i++) {
			MultiNoiseUtil.ParameterRange parameterRange = this.temperatureParameters[i];

			for (int j = 0; j < this.humidityParameters.length; j++) {
				MultiNoiseUtil.ParameterRange parameterRange2 = this.humidityParameters[j];
				RegistryKey<Biome> registryKey = this.getRegularBiome(i, j, weirdness);
				RegistryKey<Biome> registryKey2 = this.getBadlandsOrRegularBiome(i, j, weirdness);
				RegistryKey<Biome> registryKey3 = this.getMountainStartBiome(i, j, weirdness);
				RegistryKey<Biome> registryKey4 = this.getNearMountainBiome(i, j, weirdness);
				RegistryKey<Biome> registryKey5 = this.getWindsweptOrRegularBiome(i, j, weirdness);
				RegistryKey<Biome> registryKey6 = this.getBiomeOrWindsweptSavanna(i, j, weirdness, registryKey);
				RegistryKey<Biome> registryKey7 = this.getMountainSlopeBiome(i, j, weirdness);
				RegistryKey<Biome> registryKey8 = this.getPeakBiome(i, j, weirdness);
				RegistryKey<Biome> registryKey9 = this.getDawnDuskOrRegularBiome(i, j, weirdness);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						this.coastContinentalness,
						MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[0], this.erosionParameters[1]),
						weirdness,
						0.0F,
						registryKey
				);
				this.writeBiomeParameters(
						parameters, parameterRange, parameterRange2, this.nearInlandContinentalness, this.erosionParameters[0], weirdness, 0.0F, registryKey7
				);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.midInlandContinentalness, this.farInlandContinentalness),
						this.erosionParameters[0],
						weirdness,
						0.0F,
						registryKey8
				);
				this.writeBiomeParameters(
						parameters, parameterRange, parameterRange2, this.nearInlandContinentalness, this.erosionParameters[1], weirdness, 0.0F, registryKey3
				);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.midInlandContinentalness, this.farInlandContinentalness),
						this.erosionParameters[1],
						weirdness,
						0.0F,
						registryKey7
				);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness, this.nearInlandContinentalness),
						MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[2], this.erosionParameters[3]),
						weirdness,
						0.0F,
						registryKey
				);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.midInlandContinentalness, this.farInlandContinentalness),
						this.erosionParameters[2],
						weirdness,
						0.0F,
						registryKey4
				);
				this.writeBiomeParameters(
						parameters, parameterRange, parameterRange2, this.midInlandContinentalness, this.erosionParameters[3], weirdness, 0.0F, registryKey2
				);
				this.writeBiomeParameters(
						parameters, parameterRange, parameterRange2, this.dawndusklandsContinentalness, this.erosionParameters[3], weirdness, 0.0F, registryKey9
				);
				this.writeBiomeParameters(
						parameters, parameterRange, parameterRange2, this.farInlandContinentalness, this.erosionParameters[3], weirdness, 0.0F, registryKey4
				);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness, this.farInlandContinentalness),
						this.erosionParameters[4],
						weirdness,
						0.0F,
						registryKey
				);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness, this.nearInlandContinentalness),
						this.erosionParameters[5],
						weirdness,
						0.0F,
						registryKey6
				);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.midInlandContinentalness, this.farInlandContinentalness),
						this.erosionParameters[5],
						weirdness,
						0.0F,
						registryKey5
				);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness, this.farInlandContinentalness),
						this.erosionParameters[6],
						weirdness,
						0.0F,
						registryKey
				);
			}
		}
	}

	@Overwrite
	private void writeValleyBiomes(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, MultiNoiseUtil.ParameterRange weirdness) {
		this.writeBiomeParameters(
				parameters,
				this.frozenTemperature,
				this.defaultParameter,
				this.coastContinentalness,
				MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[0], this.erosionParameters[1]),
				weirdness,
				0.0F,
				weirdness.max() < 0L ? BiomeKeys.STONY_SHORE : BiomeKeys.FROZEN_RIVER
		);
		this.writeBiomeParameters(
				parameters,
				this.nonFrozenTemperatureParameters,
				this.defaultParameter,
				this.coastContinentalness,
				MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[0], this.erosionParameters[1]),
				weirdness,
				0.0F,
				weirdness.max() < 0L ? BiomeKeys.STONY_SHORE : BiomeKeys.RIVER
		);
		this.writeBiomeParameters(
				parameters,
				this.frozenTemperature,
				this.defaultParameter,
				this.nearInlandContinentalness,
				MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[0], this.erosionParameters[1]),
				weirdness,
				0.0F,
				BiomeKeys.FROZEN_RIVER
		);
		this.writeBiomeParameters(
				parameters,
				this.nonFrozenTemperatureParameters,
				this.defaultParameter,
				this.nearInlandContinentalness,
				MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[0], this.erosionParameters[1]),
				weirdness,
				0.0F,
				BiomeKeys.RIVER
		);
		this.writeBiomeParameters(
				parameters,
				this.frozenTemperature,
				this.defaultParameter,
				MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness, this.farInlandContinentalness),
				MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[2], this.erosionParameters[5]),
				weirdness,
				0.0F,
				BiomeKeys.FROZEN_RIVER
		);
		this.writeBiomeParameters(
				parameters,
				this.nonFrozenTemperatureParameters,
				this.defaultParameter,
				MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness, this.farInlandContinentalness),
				MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[2], this.erosionParameters[5]),
				weirdness,
				0.0F,
				BiomeKeys.RIVER
		);
		this.writeBiomeParameters(
				parameters, this.frozenTemperature, this.defaultParameter, this.coastContinentalness, this.erosionParameters[6], weirdness, 0.0F, BiomeKeys.FROZEN_RIVER
		);
		this.writeBiomeParameters(
				parameters,
				this.nonFrozenTemperatureParameters,
				this.defaultParameter,
				this.coastContinentalness,
				this.erosionParameters[6],
				weirdness,
				0.0F,
				BiomeKeys.RIVER
		);
		this.writeBiomeParameters(
				parameters,
				MultiNoiseUtil.ParameterRange.combine(this.temperatureParameters[1], this.temperatureParameters[2]),
				this.defaultParameter,
				MultiNoiseUtil.ParameterRange.combine(this.riverContinentalness, this.farInlandContinentalness),
				this.erosionParameters[6],
				weirdness,
				0.0F,
				BiomeKeys.SWAMP
		);
		this.writeBiomeParameters(
				parameters,
				MultiNoiseUtil.ParameterRange.combine(this.temperatureParameters[3], this.temperatureParameters[4]),
				this.defaultParameter,
				MultiNoiseUtil.ParameterRange.combine(this.riverContinentalness, this.farInlandContinentalness),
				this.erosionParameters[6],
				weirdness,
				0.0F,
				BiomeKeys.MANGROVE_SWAMP
		);
		this.writeBiomeParameters(
				parameters,
				this.frozenTemperature,
				this.defaultParameter,
				MultiNoiseUtil.ParameterRange.combine(this.riverContinentalness, this.farInlandContinentalness),
				this.erosionParameters[6],
				weirdness,
				0.0F,
				BiomeKeys.FROZEN_RIVER
		);

		for (int i = 0; i < this.temperatureParameters.length; i++) {
			MultiNoiseUtil.ParameterRange parameterRange = this.temperatureParameters[i];

			for (int j = 0; j < this.humidityParameters.length; j++) {
				MultiNoiseUtil.ParameterRange parameterRange2 = this.humidityParameters[j];
				RegistryKey<Biome> registryKey = this.getBadlandsOrRegularBiome(i, j, weirdness);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.midInlandContinentalness, this.farInlandContinentalness),
						MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[0], this.erosionParameters[1]),
						weirdness,
						0.0F,
						registryKey
				);
			}
		}

		for (int i = 0; i < this.temperatureParameters.length; i++) {
			MultiNoiseUtil.ParameterRange parameterRange = this.temperatureParameters[i];

			for (int j = 0; j < this.humidityParameters.length; j++) {
				MultiNoiseUtil.ParameterRange parameterRange2 = this.humidityParameters[j];
				RegistryKey<Biome> registryKey = this.getDawnDuskOrRegularBiome(i, j, weirdness);
				this.writeBiomeParameters(
						parameters,
						parameterRange,
						parameterRange2,
						MultiNoiseUtil.ParameterRange.combine(this.dawndusklandsContinentalness, this.dawndusklandsContinentalness),
						MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[0], this.erosionParameters[1]),
						weirdness,
						0.0F,
						registryKey
				);
			}
		}
	}
}