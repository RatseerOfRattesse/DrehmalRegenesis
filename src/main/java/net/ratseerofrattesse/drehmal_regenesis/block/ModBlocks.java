package net.ratseerofrattesse.drehmal_regenesis.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TransparentBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;

public class ModBlocks {
    public static final Block REHNTITE_BLOCK = registerBlockIndependent("rehntite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(50.0f, 1200.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));

    public static final Block RAW_REHNTITE_BLOCK = registerBlockIndependent("raw_rehntite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(50.0f, 1200.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));




    public static final Block PURPLE_MENDARUM_BLOCK = registerBlockIndependent("purple_mendarum_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f)
                    .requiresTool()
                    .luminance(state -> 15)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PURPLE_MENDARUM_SHELL = registerBlockIndependent("purple_mendarum_shell",
            new TransparentBlock(AbstractBlock.Settings.create()
                    .strength(6.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GLASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .solidBlock(Blocks::never)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
            ));
    public static final Block RED_MENDARUM_BLOCK = registerBlockIndependent("red_mendarum_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f)
                    .requiresTool()
                    .luminance(state -> 15)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RED_MENDARUM_SHELL = registerBlockIndependent("red_mendarum_shell",
            new TransparentBlock(AbstractBlock.Settings.create()
                    .strength(6.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GLASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .solidBlock(Blocks::never)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
            ));
    public static final Block BLUE_MENDARUM_BLOCK = registerBlockIndependent("blue_mendarum_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f)
                    .requiresTool()
                    .luminance(state -> 15)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            ));
    public static final Block BLUE_MENDARUM_SHELL = registerBlockIndependent("blue_mendarum_shell",
            new TransparentBlock(AbstractBlock.Settings.create()
                    .strength(6.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.GLASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .solidBlock(Blocks::never)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
            ));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DrehmalRegenesis.MOD_ID, name), block);
    }

    private static Block registerBlockIndependent(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(DrehmalRegenesis.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DrehmalRegenesis.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DrehmalRegenesis.LOGGER.info("Registering blocks for Drehmal Regenesis");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.REHNTITE_BLOCK);
            entries.add(ModBlocks.RAW_REHNTITE_BLOCK);
        });
    }
}
