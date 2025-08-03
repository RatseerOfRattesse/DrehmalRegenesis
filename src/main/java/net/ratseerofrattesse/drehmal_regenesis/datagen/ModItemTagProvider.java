package net.ratseerofrattesse.drehmal_regenesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.ratseerofrattesse.drehmal_regenesis.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.REHNTITE_SWORD)
                .add(ModItems.BLUE_MENDARUM_SWORD)
                .add(ModItems.RED_MENDARUM_SWORD)
                .add(ModItems.PURPLE_MENDARUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.REHNTITE_PICKAXE)
                .add(ModItems.BLUE_MENDARUM_PICKAXE)
                .add(ModItems.RED_MENDARUM_PICKAXE)
                .add(ModItems.PURPLE_MENDARUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.REHNTITE_AXE)
                .add(ModItems.BLUE_MENDARUM_AXE)
                .add(ModItems.RED_MENDARUM_AXE)
                .add(ModItems.PURPLE_MENDARUM_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.REHNTITE_SHOVEL)
                .add(ModItems.BLUE_MENDARUM_SHOVEL)
                .add(ModItems.RED_MENDARUM_SHOVEL)
                .add(ModItems.PURPLE_MENDARUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.REHNTITE_HOE)
                .add(ModItems.BLUE_MENDARUM_HOE)
                .add(ModItems.RED_MENDARUM_HOE)
                .add(ModItems.PURPLE_MENDARUM_HOE);

    }
}
