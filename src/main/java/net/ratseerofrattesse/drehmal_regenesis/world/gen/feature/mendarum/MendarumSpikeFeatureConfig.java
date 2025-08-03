package net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.mendarum;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class MendarumSpikeFeatureConfig implements FeatureConfig {
    public static final Codec<MendarumSpikeFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            BlockStateProvider.TYPE_CODEC.fieldOf("core_provider").forGetter(config -> config.coreProvider),
                            BlockStateProvider.TYPE_CODEC.fieldOf("shell_provider").forGetter(config -> config.shellProvider),
                            FeatureSize.TYPE_CODEC.fieldOf("minimum_size").forGetter(config -> config.minimumSize)
                    )
                    .apply(instance, MendarumSpikeFeatureConfig::new)
    );
    public final BlockStateProvider coreProvider;
    public final BlockStateProvider shellProvider;
    public final FeatureSize minimumSize;

    protected MendarumSpikeFeatureConfig(
            BlockStateProvider trunkProvider,
            BlockStateProvider shellProvider,
            FeatureSize minimumSize
    ) {
        this.coreProvider = trunkProvider;
        this.shellProvider = shellProvider;
        this.minimumSize = minimumSize;
    }

    public static class Builder {
        public final BlockStateProvider coreProvider;
        public final BlockStateProvider shellProvider;
        private final FeatureSize minimumSize;

        public Builder(
                BlockStateProvider trunkProvider,
                BlockStateProvider shellProvider,
                FeatureSize minimumSize
        ) {
            this.coreProvider = trunkProvider;
            this.shellProvider = shellProvider;
            this.minimumSize = minimumSize;
        }

        public MendarumSpikeFeatureConfig build() {
            return new MendarumSpikeFeatureConfig(
                    this.coreProvider,
                    this.shellProvider,
                    this.minimumSize
            );
        }
    }
}
