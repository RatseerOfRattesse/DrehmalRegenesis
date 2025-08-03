package net.ratseerofrattesse.drehmal_regenesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.client.Models;
import net.minecraft.registry.RegistryWrapper;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;
import net.ratseerofrattesse.drehmal_regenesis.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModEnglishCALanguageProvider extends FabricLanguageProvider {
    public ModEnglishCALanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_ca",registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add(ModItems.PLACEHOLDER, "Placeholder");




        translationBuilder.add("itemgroup.drehmal_regenesis.drehmal_regenesis", "Drehmal Regenesis");




        translationBuilder.add(ModBlocks.REHNTITE_BLOCK, "Block of Rehntite");
        translationBuilder.add(ModBlocks.RAW_REHNTITE_BLOCK, "Block of Raw Rehntite");
        translationBuilder.add(ModItems.RAW_REHNTITE, "Raw Rehntite");
        translationBuilder.add(ModItems.REHNTITE_INGOT, "Rehntite Ingot");
        translationBuilder.add(ModItems.REHNTITE_NUGGET, "Rehntite Nugget");
        translationBuilder.add(ModItems.REHNTITE_SWORD, "Rehntite Sword");
        translationBuilder.add(ModItems.REHNTITE_PICKAXE, "Rehntite Pickaxe");
        translationBuilder.add(ModItems.REHNTITE_AXE, "Rehntite Axe");
        translationBuilder.add(ModItems.REHNTITE_SHOVEL, "Rehntite Shovel");
        translationBuilder.add(ModItems.REHNTITE_HOE, "Rehntite Hoe");




        translationBuilder.add(ModBlocks.PURPLE_MENDARUM_BLOCK, "Block of Mendarum");
        translationBuilder.add(ModBlocks.PURPLE_MENDARUM_SHELL, "Block of Mendarum");
        translationBuilder.add(ModItems.PURPLE_MENDARUM_CRYSTAL, "Purple Mendarum Crystal");
        translationBuilder.add(ModItems.PURPLE_MENDARUM_SWORD, "Purple Mendarum Sword");
        translationBuilder.add(ModItems.PURPLE_MENDARUM_PICKAXE, "Purple Mendarum Pickaxe");
        translationBuilder.add(ModItems.PURPLE_MENDARUM_AXE, "Purple Mendarum Axe");
        translationBuilder.add(ModItems.PURPLE_MENDARUM_SHOVEL, "Purple Mendarum Shovel");
        translationBuilder.add(ModItems.PURPLE_MENDARUM_HOE, "Purple Mendarum Hoe");




        translationBuilder.add(ModBlocks.RED_MENDARUM_BLOCK, "Block of Mendarum");
        translationBuilder.add(ModBlocks.RED_MENDARUM_SHELL, "Block of Mendarum");
        translationBuilder.add(ModItems.RED_MENDARUM_CRYSTAL, "Red Mendarum Crystal");
        translationBuilder.add(ModItems.RED_MENDARUM_SWORD, "Red Mendarum Sword");
        translationBuilder.add(ModItems.RED_MENDARUM_PICKAXE, "Red Mendarum Pickaxe");
        translationBuilder.add(ModItems.RED_MENDARUM_AXE, "Red Mendarum Axe");
        translationBuilder.add(ModItems.RED_MENDARUM_SHOVEL, "Red Mendarum Shovel");
        translationBuilder.add(ModItems.RED_MENDARUM_HOE, "Red Mendarum Hoe");




        translationBuilder.add(ModBlocks.BLUE_MENDARUM_BLOCK, "Block of Mendarum");
        translationBuilder.add(ModBlocks.BLUE_MENDARUM_SHELL, "Block of Mendarum");
        translationBuilder.add(ModItems.BLUE_MENDARUM_CRYSTAL, "Blue Mendarum Crystal");
        translationBuilder.add(ModItems.BLUE_MENDARUM_SWORD, "Blue Mendarum Sword");
        translationBuilder.add(ModItems.BLUE_MENDARUM_PICKAXE, "Blue Mendarum Pickaxe");
        translationBuilder.add(ModItems.BLUE_MENDARUM_AXE, "Blue Mendarum Axe");
        translationBuilder.add(ModItems.BLUE_MENDARUM_SHOVEL, "Blue Mendarum Shovel");
        translationBuilder.add(ModItems.BLUE_MENDARUM_HOE, "Blue Mendarum Hoe");




        translationBuilder.add("tooltip.drehmal_regenesis.mendarum.blue", "Blue");
        translationBuilder.add("tooltip.drehmal_regenesis.mendarum.red", "Red");
        translationBuilder.add("tooltip.drehmal_regenesis.mendarum.purple", "Purple");




        translationBuilder.add("athenaeum.rarity.common",  "Common");
        translationBuilder.add("athenaeum.rarity.uncommon",  "Uncommon");
        translationBuilder.add("athenaeum.rarity.rare",  "Rare");
        translationBuilder.add("athenaeum.rarity.epic",  "Epic");
        translationBuilder.add("athenaeum.rarity.legendary",  "Legendary");
        translationBuilder.add("athenaeum.rarity.mythic",  "Mythic");
        translationBuilder.add("athenaeum.rarity.divine",  "Divine");
    }
}
