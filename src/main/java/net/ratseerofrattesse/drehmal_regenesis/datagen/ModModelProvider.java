package net.ratseerofrattesse.drehmal_regenesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;
import net.ratseerofrattesse.drehmal_regenesis.item.ModItems;

public class ModModelProvider extends FabricModelProvider {


    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REHNTITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_REHNTITE_BLOCK);




        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_MENDARUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_MENDARUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_MENDARUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_MENDARUM_SHELL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_MENDARUM_SHELL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_MENDARUM_SHELL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PLACEHOLDER, Models.GENERATED);




        itemModelGenerator.register(ModItems.RAW_REHNTITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REHNTITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.REHNTITE_NUGGET, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REHNTITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REHNTITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REHNTITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REHNTITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REHNTITE_HOE, Models.HANDHELD);




        itemModelGenerator.register(ModItems.PURPLE_MENDARUM_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURPLE_MENDARUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PURPLE_MENDARUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PURPLE_MENDARUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PURPLE_MENDARUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PURPLE_MENDARUM_HOE, Models.HANDHELD);




        itemModelGenerator.register(ModItems.RED_MENDARUM_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_MENDARUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RED_MENDARUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RED_MENDARUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RED_MENDARUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RED_MENDARUM_HOE, Models.HANDHELD);




        itemModelGenerator.register(ModItems.BLUE_MENDARUM_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_MENDARUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLUE_MENDARUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLUE_MENDARUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLUE_MENDARUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLUE_MENDARUM_HOE, Models.HANDHELD);
    }
}
