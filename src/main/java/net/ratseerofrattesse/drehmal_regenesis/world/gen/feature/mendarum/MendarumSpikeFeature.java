package net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.mendarum;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;

public class MendarumSpikeFeature extends Feature<MendarumSpikeFeatureConfig> {

    public MendarumSpikeFeature(Codec<MendarumSpikeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<MendarumSpikeFeatureConfig> context) {
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        MendarumSpikeFeatureConfig config = context.getConfig();
        StructureWorldAccess structureWorldAccess = context.getWorld();


        while (structureWorldAccess.isAir(blockPos) && blockPos.getY() > structureWorldAccess.getBottomY() + 2) {
            blockPos = blockPos.down();
        }
        if (!structureWorldAccess.getBlockState(blockPos).isOf(Blocks.GRASS_BLOCK)) {
            return false;
        } else {
            blockPos = blockPos.up(random.nextInt(4));
            BlockPos origin = blockPos;
            int i = random.nextInt(4) + 7;
            int j = i / 4 + random.nextInt(2);

            for (int k = 0; k < i; k++) {
                float f = (1.0F - (float)k / i) * j;
                int l = MathHelper.ceil(f);

                for (int m = -l; m <= l; m++) {
                    float g = MathHelper.abs(m) - 0.25F;
                    for (int n = -l; n <= l; n++) {
                        float h = MathHelper.abs(n) - 0.25F;
                        if ((m == 0 && n == 0 || !(g * g + h * h > f * f)) && (m != -l && m != l && n != -l && n != l || !(random.nextFloat() > 0.75F))) {
                            BlockState blockState = structureWorldAccess.getBlockState(blockPos.add(m, k, n));
                            if (blockState.isAir() || isSoil(blockState)) {
                                this.setBlockState(structureWorldAccess, blockPos.add(m, k, n), config.coreProvider.get(random, blockPos));
                            }

                            if (k != 0 && l > 1) {
                                blockState = structureWorldAccess.getBlockState(blockPos.add(m, -k, n));
                                if (blockState.isAir() || isSoil(blockState)) {
                                    this.setBlockState(structureWorldAccess, blockPos.add(m, -k, n), config.coreProvider.get(random, blockPos));
                                }
                            }
                        }
                    }
                }
            }

            i = random.nextBetween(4,6) + 7;
            j = i / 4 + random.nextBetween(3,4);

            for (int k = 0; k < i; k++) {
                float f = (1.0F - (float)k / i) * j;
                int l = MathHelper.ceil(f);

                for (int m = -l; m <= l; m++) {
                    float g = MathHelper.abs(m) - 0.25F;
                    for (int n = -l; n <= l; n++) {
                        float h = MathHelper.abs(n) - 0.25F;
                        if ((m == 0 && n == 0 || !(g * g + h * h > f * f)) && (m != -l && m != l && n != -l && n != l || !(random.nextFloat() > 0.75F))) {
                            BlockState blockState = structureWorldAccess.getBlockState(origin.add(m, k, n));
                            if (blockState.isAir() || isSoil(blockState)) {
                                this.setBlockState(structureWorldAccess, origin.add(m, k, n), config.shellProvider.get(random, blockPos));
                            }

                            if (k != 0 && l > 1) {
                                blockState = structureWorldAccess.getBlockState(origin.add(m, -k, n));
                                if (blockState.isAir() || isSoil(blockState)) {
                                    this.setBlockState(structureWorldAccess, origin.add(m, -k, n), config.shellProvider.get(random, blockPos));
                                }
                            }
                        }
                    }
                }
            }
        }
            return true;

    }
}
