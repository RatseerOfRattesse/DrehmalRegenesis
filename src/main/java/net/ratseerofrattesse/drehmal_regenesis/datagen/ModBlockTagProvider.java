package net.ratseerofrattesse.drehmal_regenesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;
import net.ratseerofrattesse.drehmal_regenesis.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_MENDARUM_TOOL)
                .add(ModBlocks.RAW_REHNTITE_BLOCK)
                .add(ModBlocks.REHNTITE_BLOCK)
                .addOptionalTag(ModTags.Blocks.NEEDS_REHNTITE_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_REHNTITE_TOOL)
                .addOptionalTag(ModTags.Blocks.NEEDS_MENDARUM_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_REHNTITE_TOOL)
                .addOptionalTag(ModTags.Blocks.INCORRECT_FOR_MENDARUM_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.PURPLE_MENDARUM_SHELL)
                .add(ModBlocks.RED_MENDARUM_SHELL)
                .add(ModBlocks.BLUE_MENDARUM_SHELL)
                .add(ModBlocks.PURPLE_MENDARUM_BLOCK)
                .add(ModBlocks.RED_MENDARUM_BLOCK)
                .add(ModBlocks.BLUE_MENDARUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addOptionalTag(ModTags.Blocks.NEEDS_REHNTITE_TOOL)
                .addOptionalTag(ModTags.Blocks.NEEDS_MENDARUM_TOOL);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PURPLE_MENDARUM_BLOCK)
                .add(ModBlocks.RED_MENDARUM_BLOCK)
                .add(ModBlocks.BLUE_MENDARUM_BLOCK)
                .add(ModBlocks.PURPLE_MENDARUM_SHELL)
                .add(ModBlocks.RED_MENDARUM_SHELL)
                .add(ModBlocks.BLUE_MENDARUM_SHELL)
                .add(ModBlocks.RAW_REHNTITE_BLOCK)
                .add(ModBlocks.REHNTITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
                .add(ModBlocks.PURPLE_MENDARUM_SHELL)
                .add(ModBlocks.RED_MENDARUM_SHELL)
                .add(ModBlocks.BLUE_MENDARUM_SHELL);
    }

}
