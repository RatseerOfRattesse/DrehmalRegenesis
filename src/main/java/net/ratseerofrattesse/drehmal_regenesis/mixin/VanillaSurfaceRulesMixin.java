package net.ratseerofrattesse.drehmal_regenesis.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import net.ratseerofrattesse.drehmal_regenesis.world.biome.ModBiomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(VanillaSurfaceRules.class)
public class VanillaSurfaceRulesMixin{
    private static final MaterialRules.MaterialRule BLUE_TERRACOTTA = block(Blocks.BLUE_TERRACOTTA);
    private static final MaterialRules.MaterialRule MAGENTA_TERRACOTTA = block(Blocks.MAGENTA_TERRACOTTA);
    private static final MaterialRules.MaterialRule PURPLE_TERRACOTTA = block(Blocks.PURPLE_TERRACOTTA);
    private static final MaterialRules.MaterialRule RED_TERRACOTTA = block(Blocks.RED_TERRACOTTA);
    private static final MaterialRules.MaterialRule PINK_TERRACOTTA = block(Blocks.PINK_TERRACOTTA);
    private static final MaterialRules.MaterialRule CALCITE = block(Blocks.CALCITE);
    @Shadow
    private static final MaterialRules.MaterialRule STONE = block(Blocks.STONE);
    @Shadow
    private static final MaterialRules.MaterialRule DIRT = block(Blocks.DIRT);
    private static final MaterialRules.MaterialRule MYCELIUM = block(Blocks.MYCELIUM);
    @Shadow
    private static final MaterialRules.MaterialRule GRAVEL = block(Blocks.GRAVEL);
    @Shadow
    private static final MaterialRules.MaterialRule AIR = block(Blocks.AIR);
    @Shadow
    private static final MaterialRules.MaterialRule BEDROCK = block(Blocks.BEDROCK);
    @Shadow
    private static final MaterialRules.MaterialRule WHITE_TERRACOTTA = block(Blocks.WHITE_TERRACOTTA);
    @Shadow
    private static final MaterialRules.MaterialRule ORANGE_TERRACOTTA = block(Blocks.ORANGE_TERRACOTTA);
    @Shadow
    private static final MaterialRules.MaterialRule TERRACOTTA = block(Blocks.TERRACOTTA);
    @Shadow
    private static final MaterialRules.MaterialRule RED_SAND = block(Blocks.RED_SAND);
    @Shadow
    private static final MaterialRules.MaterialRule RED_SANDSTONE = block(Blocks.RED_SANDSTONE);
    @Shadow
    private static final MaterialRules.MaterialRule DEEPSLATE = block(Blocks.DEEPSLATE);
    @Shadow
    private static final MaterialRules.MaterialRule PODZOL = block(Blocks.PODZOL);
    @Shadow
    private static final MaterialRules.MaterialRule COARSE_DIRT = block(Blocks.COARSE_DIRT);
    @Shadow
    private static final MaterialRules.MaterialRule GRASS_BLOCK = block(Blocks.GRASS_BLOCK);
    @Shadow
    private static final MaterialRules.MaterialRule SAND = block(Blocks.SAND);
    @Shadow
    private static final MaterialRules.MaterialRule SANDSTONE = block(Blocks.SANDSTONE);
    @Shadow
    private static final MaterialRules.MaterialRule PACKED_ICE = block(Blocks.PACKED_ICE);
    @Shadow
    private static final MaterialRules.MaterialRule SNOW_BLOCK = block(Blocks.SNOW_BLOCK);
    @Shadow
    private static final MaterialRules.MaterialRule MUD = block(Blocks.MUD);
    @Shadow
    private static final MaterialRules.MaterialRule POWDER_SNOW = block(Blocks.POWDER_SNOW);
    @Shadow
    private static final MaterialRules.MaterialRule ICE = block(Blocks.ICE);
    @Shadow
    private static final MaterialRules.MaterialRule WATER = block(Blocks.WATER);

    @Overwrite
    private static MaterialRules.MaterialRule block(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

    @Overwrite
    private static MaterialRules.MaterialCondition surfaceNoiseThreshold(double min) {
        return MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, min / 8.25, Double.MAX_VALUE);
    }

    private static MaterialRules.MaterialCondition materialCondition2 = MaterialRules.aboveY(YOffset.fixed(256), 0);
    private static MaterialRules.MaterialCondition materialCondition3 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(63), -1);
    private static MaterialRules.MaterialCondition materialCondition4 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(74), 1);
    private static MaterialRules.MaterialCondition materialCondition7 = MaterialRules.aboveY(YOffset.fixed(63), 0);
    private static MaterialRules.MaterialCondition materialCondition8 = MaterialRules.water(-1, 0);
    private static MaterialRules.MaterialCondition materialCondition10 = MaterialRules.waterWithStoneDepth(-6, -1);
    private static MaterialRules.MaterialCondition materialCondition11 = MaterialRules.hole();
    private static MaterialRules.MaterialCondition materialCondition16 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.909, -0.5454);
    private static MaterialRules.MaterialCondition materialCondition17 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.1818, 0.1818);
    private static MaterialRules.MaterialCondition materialCondition18 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.5454, 0.909);
    private static MaterialRules.MaterialRule materialRule3 = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE), GRAVEL);

    @Overwrite
    public static MaterialRules.MaterialRule createDefaultRule(boolean surface, boolean bedrockRoof, boolean bedrockFloor) {
        MaterialRules.MaterialCondition materialCondition = MaterialRules.aboveY(YOffset.fixed(97), 2);
        MaterialRules.MaterialCondition materialCondition2 = MaterialRules.aboveY(YOffset.fixed(256), 0);
        MaterialRules.MaterialCondition materialCondition3 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(63), -1);
        MaterialRules.MaterialCondition materialCondition4 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(74), 1);
        MaterialRules.MaterialCondition materialCondition5 = MaterialRules.aboveY(YOffset.fixed(60), 0);
        MaterialRules.MaterialCondition materialCondition6 = MaterialRules.aboveY(YOffset.fixed(62), 0);
        MaterialRules.MaterialCondition materialCondition7 = MaterialRules.aboveY(YOffset.fixed(63), 0);
        MaterialRules.MaterialCondition materialCondition8 = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition materialCondition9 = MaterialRules.water(0, 0);
        MaterialRules.MaterialCondition materialCondition10 = MaterialRules.waterWithStoneDepth(-6, -1);
        MaterialRules.MaterialCondition materialCondition11 = MaterialRules.hole();
        MaterialRules.MaterialCondition materialCondition12 = MaterialRules.biome(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN);
        MaterialRules.MaterialCondition materialCondition13 = MaterialRules.steepSlope();
        MaterialRules.MaterialRule materialRule = MaterialRules.sequence(MaterialRules.condition(materialCondition9, GRASS_BLOCK), DIRT);
        MaterialRules.MaterialRule materialRule2 = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, SANDSTONE), SAND);
        MaterialRules.MaterialRule materialRule3 = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE), GRAVEL);
        MaterialRules.MaterialCondition materialCondition14 = MaterialRules.biome(BiomeKeys.WARM_OCEAN, BiomeKeys.BEACH, BiomeKeys.SNOWY_BEACH);
        MaterialRules.MaterialCondition materialCondition15 = MaterialRules.biome(BiomeKeys.DESERT);
        MaterialRules.MaterialRule materialRule4 = MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.STONY_PEAKS),
                        MaterialRules.sequence(MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.CALCITE, -0.0125, 0.0125), CALCITE), STONE)
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.STONY_SHORE),
                        MaterialRules.sequence(MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.GRAVEL, -0.05, 0.05), materialRule3), STONE)
                ),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_HILLS), MaterialRules.condition(surfaceNoiseThreshold(1.0), STONE)),
                MaterialRules.condition(materialCondition14, materialRule2),
                MaterialRules.condition(materialCondition15, materialRule2),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.DRIPSTONE_CAVES), STONE)
        );
        MaterialRules.MaterialRule materialRule5 = MaterialRules.condition(
                MaterialRules.noiseThreshold(NoiseParametersKeys.POWDER_SNOW, 0.45, 0.58), MaterialRules.condition(materialCondition9, POWDER_SNOW)
        );
        MaterialRules.MaterialRule materialRule6 = MaterialRules.condition(
                MaterialRules.noiseThreshold(NoiseParametersKeys.POWDER_SNOW, 0.35, 0.6), MaterialRules.condition(materialCondition9, POWDER_SNOW)
        );
        MaterialRules.MaterialRule materialRule7 = MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.FROZEN_PEAKS),
                        MaterialRules.sequence(
                                MaterialRules.condition(materialCondition13, PACKED_ICE),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PACKED_ICE, -0.5, 0.2), PACKED_ICE),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.ICE, -0.0625, 0.025), ICE),
                                MaterialRules.condition(materialCondition9, SNOW_BLOCK)
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.SNOWY_SLOPES),
                        MaterialRules.sequence(MaterialRules.condition(materialCondition13, STONE), materialRule5, MaterialRules.condition(materialCondition9, SNOW_BLOCK))
                ),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.JAGGED_PEAKS), STONE),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.GROVE), MaterialRules.sequence(materialRule5, DIRT)),
                materialRule4,
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_SAVANNA), MaterialRules.condition(surfaceNoiseThreshold(1.75), STONE)),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS),
                        MaterialRules.sequence(
                                MaterialRules.condition(surfaceNoiseThreshold(2.0), materialRule3),
                                MaterialRules.condition(surfaceNoiseThreshold(1.0), STONE),
                                MaterialRules.condition(surfaceNoiseThreshold(-1.0), DIRT),
                                materialRule3
                        )
                ),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.MANGROVE_SWAMP), MUD),
                DIRT
        );
        MaterialRules.MaterialRule materialRule8 = MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.FROZEN_PEAKS),
                        MaterialRules.sequence(
                                MaterialRules.condition(materialCondition13, PACKED_ICE),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PACKED_ICE, 0.0, 0.2), PACKED_ICE),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.ICE, 0.0, 0.025), ICE),
                                MaterialRules.condition(materialCondition9, SNOW_BLOCK)
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.SNOWY_SLOPES),
                        MaterialRules.sequence(MaterialRules.condition(materialCondition13, STONE), materialRule6, MaterialRules.condition(materialCondition9, SNOW_BLOCK))
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.JAGGED_PEAKS),
                        MaterialRules.sequence(MaterialRules.condition(materialCondition13, STONE), MaterialRules.condition(materialCondition9, SNOW_BLOCK))
                ),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.GROVE), MaterialRules.sequence(materialRule6, MaterialRules.condition(materialCondition9, SNOW_BLOCK))),
                materialRule4,
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.WINDSWEPT_SAVANNA),
                        MaterialRules.sequence(MaterialRules.condition(surfaceNoiseThreshold(1.75), STONE), MaterialRules.condition(surfaceNoiseThreshold(-0.5), COARSE_DIRT))
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS),
                        MaterialRules.sequence(
                                MaterialRules.condition(surfaceNoiseThreshold(2.0), materialRule3),
                                MaterialRules.condition(surfaceNoiseThreshold(1.0), STONE),
                                MaterialRules.condition(surfaceNoiseThreshold(-1.0), materialRule),
                                materialRule3
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA),
                        MaterialRules.sequence(MaterialRules.condition(surfaceNoiseThreshold(1.75), COARSE_DIRT), MaterialRules.condition(surfaceNoiseThreshold(-0.95), PODZOL))
                ),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.ICE_SPIKES), MaterialRules.condition(materialCondition9, SNOW_BLOCK)),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.MANGROVE_SWAMP), MUD),
                MaterialRules.condition(MaterialRules.biome(BiomeKeys.MUSHROOM_FIELDS), MYCELIUM),
                materialRule
        );
        MaterialRules.MaterialCondition materialCondition16 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.909, -0.5454);
        MaterialRules.MaterialCondition materialCondition17 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.1818, 0.1818);
        MaterialRules.MaterialCondition materialCondition18 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.5454, 0.909);
        MaterialRules.MaterialRule materialRule9 = MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.biome(BiomeKeys.WOODED_BADLANDS),
                                        MaterialRules.condition(
                                                materialCondition,
                                                MaterialRules.sequence(
                                                        MaterialRules.condition(materialCondition16, COARSE_DIRT),
                                                        MaterialRules.condition(materialCondition17, COARSE_DIRT),
                                                        MaterialRules.condition(materialCondition18, COARSE_DIRT),
                                                        materialRule
                                                )
                                        )
                                ),
                                MaterialRules.condition(
                                        MaterialRules.biome(BiomeKeys.SWAMP),
                                        MaterialRules.condition(
                                                materialCondition6,
                                                MaterialRules.condition(
                                                        MaterialRules.not(materialCondition7), MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, 0.0), WATER)
                                                )
                                        )
                                ),
                                MaterialRules.condition(
                                        MaterialRules.biome(BiomeKeys.MANGROVE_SWAMP),
                                        MaterialRules.condition(
                                                materialCondition5,
                                                MaterialRules.condition(
                                                        MaterialRules.not(materialCondition7), MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, 0.0), WATER)
                                                )
                                        )
                                )
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS),
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition2, ORANGE_TERRACOTTA),
                                                MaterialRules.condition(
                                                        materialCondition4,
                                                        MaterialRules.sequence(
                                                                MaterialRules.condition(materialCondition16, TERRACOTTA),
                                                                MaterialRules.condition(materialCondition17, TERRACOTTA),
                                                                MaterialRules.condition(materialCondition18, TERRACOTTA),
                                                                MaterialRules.terracottaBands()
                                                        )
                                                ),
                                                MaterialRules.condition(materialCondition8, MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, RED_SANDSTONE), RED_SAND)),
                                                MaterialRules.condition(MaterialRules.not(materialCondition11), ORANGE_TERRACOTTA),
                                                MaterialRules.condition(materialCondition10, WHITE_TERRACOTTA),
                                                materialRule3
                                        )
                                ),
                                MaterialRules.condition(
                                        materialCondition3,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition7, MaterialRules.condition(MaterialRules.not(materialCondition4), ORANGE_TERRACOTTA)),
                                                MaterialRules.terracottaBands()
                                        )
                                ),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRules.condition(materialCondition10, WHITE_TERRACOTTA))
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.condition(
                                materialCondition8,
                                MaterialRules.sequence(
                                        MaterialRules.condition(
                                                materialCondition12,
                                                MaterialRules.condition(
                                                        materialCondition11,
                                                        MaterialRules.sequence(MaterialRules.condition(materialCondition9, AIR), MaterialRules.condition(MaterialRules.temperature(), ICE), WATER)
                                                )
                                        ),
                                        materialRule8
                                )
                        )
                ),
                MaterialRules.condition(
                        materialCondition10,
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, MaterialRules.condition(materialCondition12, MaterialRules.condition(materialCondition11, WATER))),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, materialRule7),
                                MaterialRules.condition(materialCondition14, MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, SANDSTONE)),
                                MaterialRules.condition(materialCondition15, MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_30, SANDSTONE))
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.biome(BiomeKeys.FROZEN_PEAKS, BiomeKeys.JAGGED_PEAKS), STONE),
                                MaterialRules.condition(MaterialRules.biome(BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), materialRule2),
                                materialRule3
                        )
                )
        );
        ImmutableList.Builder<MaterialRules.MaterialRule> builder = ImmutableList.builder();
        if (bedrockRoof) {
            builder.add(MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(5), YOffset.getTop())), BEDROCK));
        }

        if (bedrockFloor) {
            builder.add(MaterialRules.condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), BEDROCK));
        }

        MaterialRules.MaterialRule materialRule11 = MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomes.DAWNLANDS),
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition2, MAGENTA_TERRACOTTA),
                                                MaterialRules.condition(
                                                        materialCondition4,
                                                        MaterialRules.sequence(
                                                                MaterialRules.condition(materialCondition16, PURPLE_TERRACOTTA),
                                                                MaterialRules.condition(materialCondition17, RED_TERRACOTTA),
                                                                MaterialRules.condition(materialCondition18, PINK_TERRACOTTA),
                                                                MaterialRules.terracottaBands()
                                                        )
                                                ),
                                                MaterialRules.condition(materialCondition8, MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, DIRT), MYCELIUM)),
                                                MaterialRules.condition(MaterialRules.not(materialCondition11), MAGENTA_TERRACOTTA),
                                                MaterialRules.condition(materialCondition10, BLUE_TERRACOTTA),
                                                materialRule3
                                        )
                                ),
                                MaterialRules.condition(
                                        materialCondition3,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition7, MaterialRules.condition(MaterialRules.not(materialCondition4), MAGENTA_TERRACOTTA)),
                                                MaterialRules.terracottaBands()
                                        )
                                ),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRules.condition(materialCondition10, BLUE_TERRACOTTA))
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomes.DUSKLANDS),
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition2, MAGENTA_TERRACOTTA),
                                                MaterialRules.condition(
                                                        materialCondition4,
                                                        MaterialRules.sequence(
                                                                MaterialRules.condition(materialCondition16, PURPLE_TERRACOTTA),
                                                                MaterialRules.condition(materialCondition17, PURPLE_TERRACOTTA),
                                                                MaterialRules.condition(materialCondition18, PURPLE_TERRACOTTA),
                                                                MaterialRules.terracottaBands()
                                                        )
                                                ),
                                                MaterialRules.condition(materialCondition8, MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, DIRT), MYCELIUM)),
                                                MaterialRules.condition(MaterialRules.not(materialCondition11), MAGENTA_TERRACOTTA),
                                                MaterialRules.condition(materialCondition10, CALCITE),
                                                materialRule3
                                        )
                                ),
                                MaterialRules.condition(
                                        materialCondition3,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition7, MaterialRules.condition(MaterialRules.not(materialCondition4), MAGENTA_TERRACOTTA)),
                                                MaterialRules.terracottaBands()
                                        )
                                ),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRules.condition(materialCondition10, CALCITE))
                        )
                )
        );

        MaterialRules.MaterialRule materialRule10 = MaterialRules.condition(MaterialRules.surface(), materialRule9);
        builder.add(surface ? materialRule10 : materialRule9);
        builder.add(MaterialRules.condition(MaterialRules.verticalGradient("deepslate", YOffset.fixed(0), YOffset.fixed(8)), DEEPSLATE));
        return MaterialRules.sequence((MaterialRules.MaterialRule[])builder.build().toArray(MaterialRules.MaterialRule[]::new));
    }

    /*
    @Inject(at = @At("TAIL"), method = "createDefaultRule")
    private void createDefaultRule(CallbackInfo info, boolean surface) {


        ImmutableList.Builder<MaterialRules.MaterialRule> builder = ImmutableList.builder();
        MaterialRules.MaterialRule materialRule10 = MaterialRules.condition(MaterialRules.surface(), materialRule11);
        builder.add(surface ? materialRule10 : materialRule11);
    }
    private static MaterialRules.MaterialRule createDefaultRule(boolean surface, boolean bedrockRoof, boolean bedrockFloor) {
        MaterialRules.MaterialRule materialRule11 = MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomeKeys.DAWNLANDS),
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition2, MAGENTA_TERRACOTTA),
                                                MaterialRules.condition(
                                                        materialCondition4,
                                                        MaterialRules.sequence(
                                                                MaterialRules.condition(materialCondition16, PURPLE_TERRACOTTA),
                                                                MaterialRules.condition(materialCondition17, RED_TERRACOTTA),
                                                                MaterialRules.condition(materialCondition18, PINK_TERRACOTTA),
                                                                MaterialRules.terracottaBands()
                                                        )
                                                ),
                                                MaterialRules.condition(materialCondition8, MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, DIRT), MYCELIUM)),
                                                MaterialRules.condition(MaterialRules.not(materialCondition11), MAGENTA_TERRACOTTA),
                                                MaterialRules.condition(materialCondition10, BLUE_TERRACOTTA),
                                                materialRule3
                                        )
                                ),
                                MaterialRules.condition(
                                        materialCondition3,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition7, MaterialRules.condition(MaterialRules.not(materialCondition4), MAGENTA_TERRACOTTA)),
                                                MaterialRules.terracottaBands()
                                        )
                                ),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRules.condition(materialCondition10, BLUE_TERRACOTTA))
                        )
                ),
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomeKeys.DUSKLANDS),
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition2, MAGENTA_TERRACOTTA),
                                                MaterialRules.condition(
                                                        materialCondition4,
                                                        MaterialRules.sequence(
                                                                MaterialRules.condition(materialCondition16, PURPLE_TERRACOTTA),
                                                                MaterialRules.condition(materialCondition17, PURPLE_TERRACOTTA),
                                                                MaterialRules.condition(materialCondition18, PURPLE_TERRACOTTA),
                                                                MaterialRules.terracottaBands()
                                                        )
                                                ),
                                                MaterialRules.condition(materialCondition8, MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, DIRT), MYCELIUM)),
                                                MaterialRules.condition(MaterialRules.not(materialCondition11), MAGENTA_TERRACOTTA),
                                                MaterialRules.condition(materialCondition10, CALCITE),
                                                materialRule3
                                        )
                                ),
                                MaterialRules.condition(
                                        materialCondition3,
                                        MaterialRules.sequence(
                                                MaterialRules.condition(materialCondition7, MaterialRules.condition(MaterialRules.not(materialCondition4), MAGENTA_TERRACOTTA)),
                                                MaterialRules.terracottaBands()
                                        )
                                ),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRules.condition(materialCondition10, CALCITE))
                        )
                )
        );

        ImmutableList.Builder<MaterialRules.MaterialRule> builder = ImmutableList.builder();
        MaterialRules.MaterialRule materialRule10 = MaterialRules.condition(MaterialRules.surface(), materialRule11);
        builder.add(surface ? materialRule10 : materialRule11);
        return MaterialRules.sequence((MaterialRules.MaterialRule[])builder.build().toArray(MaterialRules.MaterialRule[]::new));
    }
    */
}
