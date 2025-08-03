package net.ratseerofrattesse.drehmal_regenesis;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;

public class DrehmalRegenesisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURPLE_MENDARUM_SHELL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MENDARUM_SHELL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_MENDARUM_SHELL, RenderLayer.getTranslucent());
    }
}
