package net.ratseerofrattesse.drehmal_regenesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;
import net.ratseerofrattesse.drehmal_regenesis.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {


    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.REHNTITE_BLOCK);
        addDrop(ModBlocks.RAW_REHNTITE_BLOCK);




        addDrop(ModBlocks.PURPLE_MENDARUM_BLOCK);
        addDrop(ModBlocks.RED_MENDARUM_BLOCK);
        addDrop(ModBlocks.BLUE_MENDARUM_BLOCK);
        addDropWithSilkTouch(ModBlocks.PURPLE_MENDARUM_SHELL);
        addDropWithSilkTouch(ModBlocks.RED_MENDARUM_SHELL);
        addDropWithSilkTouch(ModBlocks.BLUE_MENDARUM_SHELL);

        //addDrop(ModBlocks., oreDrops(ModBlocks., ModItems.);
        //addDrop(ModBlocks., multipleOreDrops(ModBlocks., ModItems., #, #));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
