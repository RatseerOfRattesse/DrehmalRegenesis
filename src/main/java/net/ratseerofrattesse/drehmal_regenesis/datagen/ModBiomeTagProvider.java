package net.ratseerofrattesse.drehmal_regenesis.datagen;

import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import net.ratseerofrattesse.drehmal_regenesis.world.biome.ModBiomes;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends TagProvider<Biome> {

    public ModBiomeTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.BIOME, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        this.getOrCreateTagBuilder(BiomeTags.IS_MOUNTAIN)
                .add(ModBiomes.DAWNLANDS)
                .add(ModBiomes.DUSKLANDS);
        this.getOrCreateTagBuilder(BiomeTags.MINESHAFT_HAS_STRUCTURE)
                .add(ModBiomes.DAWNLANDS)
                .add(ModBiomes.DUSKLANDS);
        this.getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_MOUNTAIN_HAS_STRUCTURE)
                .add(ModBiomes.DAWNLANDS)
                .add(ModBiomes.DUSKLANDS);

    }
}
