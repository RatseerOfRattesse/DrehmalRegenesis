package net.ratseerofrattesse.drehmal_regenesis.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;
import net.ratseerofrattesse.drehmal_regenesis.util.ModRarity;

import java.util.List;

import static net.minecraft.item.Items.register;

public class ModItems {

    public static final Item PLACEHOLDER = registerItem("placeholder", new Item(new Item.Settings().rarity(ModRarity.DIVINE)));




    public static final Item REHNTITE_BLOCK = registerBlockItem(new BlockItem(ModBlocks.REHNTITE_BLOCK, new Item.Settings()
            .rarity(Rarity.EPIC)));
    public static final Item RAW_REHNTITE_BLOCK = registerBlockItem(new BlockItem(ModBlocks.RAW_REHNTITE_BLOCK, new Item.Settings()
            .rarity(Rarity.EPIC)));
    public static final Item RAW_REHNTITE = registerItem("raw_rehntite", new Item(new Item.Settings()
            .rarity(Rarity.EPIC)));
    public static final Item REHNTITE_INGOT = registerItem("rehntite_ingot", new Item(new Item.Settings()
            .rarity(Rarity.EPIC)));
    public static final Item REHNTITE_NUGGET = registerItem("rehntite_nugget", new Item(new Item.Settings()
            .rarity(Rarity.EPIC)));
    public static final Item REHNTITE_SWORD = registerItem("rehntite_sword",
            new SwordItem(ModToolMaterials.REHNTITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.REHNTITE, 3, -2.4f))
                    .rarity(Rarity.EPIC)));
    public static final Item REHNTITE_PICKAXE = registerItem("rehntite_pickaxe",
            new PickaxeItem(ModToolMaterials.REHNTITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.REHNTITE, 1.5f, -3.0f))
                    .rarity(Rarity.EPIC)));
    public static final Item REHNTITE_SHOVEL = registerItem("rehntite_shovel",
            new ShovelItem(ModToolMaterials.REHNTITE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.REHNTITE, 1.0f, -2.8f))
                    .rarity(Rarity.EPIC)));
    public static final Item REHNTITE_AXE = registerItem("rehntite_axe",
            new AxeItem(ModToolMaterials.REHNTITE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.REHNTITE, 5.0f, -3.0f))
                    .rarity(Rarity.EPIC)));
    public static final Item REHNTITE_HOE = registerItem("rehntite_hoe",
            new HoeItem(ModToolMaterials.REHNTITE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.REHNTITE, -4.0f, 0.0f))
                    .rarity(Rarity.EPIC)));




    public static final Item PURPLE_MENDARUM_BLOCK = registerBlockItem(new BlockItem(ModBlocks.PURPLE_MENDARUM_BLOCK, new Item.Settings()
            .rarity(Rarity.EPIC))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.purple").formatted(Formatting.DARK_PURPLE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item PURPLE_MENDARUM_SHELL = registerBlockItem(new BlockItem(ModBlocks.PURPLE_MENDARUM_SHELL, new Item.Settings()
            .rarity(Rarity.EPIC))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.purple").formatted(Formatting.DARK_PURPLE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item PURPLE_MENDARUM_CRYSTAL = registerItem("purple_mendarum_crystal", new Item(new Item.Settings()
            .rarity(Rarity.EPIC))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.purple").formatted(Formatting.DARK_PURPLE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item PURPLE_MENDARUM_SWORD = registerItem("purple_mendarum_sword",
            new SwordItem(ModToolMaterials.PURPLE_MENDARUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PURPLE_MENDARUM, 3, -2.4f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.purple").formatted(Formatting.DARK_PURPLE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item PURPLE_MENDARUM_PICKAXE = registerItem("purple_mendarum_pickaxe",
            new PickaxeItem(ModToolMaterials.PURPLE_MENDARUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PURPLE_MENDARUM, 1.5f, -3.0f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.purple").formatted(Formatting.DARK_PURPLE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item PURPLE_MENDARUM_SHOVEL = registerItem("purple_mendarum_shovel",
            new ShovelItem(ModToolMaterials.PURPLE_MENDARUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PURPLE_MENDARUM, 1.0f, -2.8f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.purple").formatted(Formatting.DARK_PURPLE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item PURPLE_MENDARUM_AXE = registerItem("purple_mendarum_axe",
            new AxeItem(ModToolMaterials.PURPLE_MENDARUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PURPLE_MENDARUM, 5.0f, -3.0f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.purple").formatted(Formatting.DARK_PURPLE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item PURPLE_MENDARUM_HOE = registerItem("purple_mendarum_hoe",
            new HoeItem(ModToolMaterials.PURPLE_MENDARUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.PURPLE_MENDARUM, -4.0f, 0.0f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.purple").formatted(Formatting.DARK_PURPLE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });




    public static final Item RED_MENDARUM_BLOCK = registerBlockItem(new BlockItem(ModBlocks.RED_MENDARUM_BLOCK, new Item.Settings()
            .rarity(Rarity.EPIC))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.red").formatted(Formatting.DARK_RED));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RED_MENDARUM_SHELL = registerBlockItem(new BlockItem(ModBlocks.RED_MENDARUM_SHELL, new Item.Settings()
            .rarity(Rarity.EPIC))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.red").formatted(Formatting.DARK_RED));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
        public static final Item RED_MENDARUM_CRYSTAL = registerItem("red_mendarum_crystal", new Item(new Item.Settings()
                .rarity(Rarity.EPIC))
        {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.red").formatted(Formatting.DARK_RED));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item RED_MENDARUM_SWORD = registerItem("red_mendarum_sword",
            new SwordItem(ModToolMaterials.RED_MENDARUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RED_MENDARUM, 3, -2.4f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.red").formatted(Formatting.DARK_RED));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item RED_MENDARUM_PICKAXE = registerItem("red_mendarum_pickaxe",
            new PickaxeItem(ModToolMaterials.RED_MENDARUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RED_MENDARUM, 1.5f, -3.0f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.red").formatted(Formatting.DARK_RED));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item RED_MENDARUM_SHOVEL = registerItem("red_mendarum_shovel",
            new ShovelItem(ModToolMaterials.RED_MENDARUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RED_MENDARUM, 1.0f, -2.8f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.red").formatted(Formatting.DARK_RED));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item RED_MENDARUM_AXE = registerItem("red_mendarum_axe",
            new AxeItem(ModToolMaterials.RED_MENDARUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RED_MENDARUM, 5.0f, -3.0f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.red").formatted(Formatting.DARK_RED));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item RED_MENDARUM_HOE = registerItem("red_mendarum_hoe",
            new HoeItem(ModToolMaterials.RED_MENDARUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RED_MENDARUM, -4.0f, 0.0f))
                    .rarity(Rarity.EPIC))
    {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.red").formatted(Formatting.DARK_RED));
                super.appendTooltip(stack, context, tooltip, type);
            }
    });




    public static final Item BLUE_MENDARUM_BLOCK = registerBlockItem(new BlockItem(ModBlocks.BLUE_MENDARUM_BLOCK, new Item.Settings()
            .rarity(Rarity.EPIC))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.blue").formatted(Formatting.DARK_BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BLUE_MENDARUM_SHELL = registerBlockItem(new BlockItem(ModBlocks.BLUE_MENDARUM_SHELL, new Item.Settings()
            .rarity(Rarity.EPIC))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.blue").formatted(Formatting.DARK_BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BLUE_MENDARUM_CRYSTAL = registerItem("blue_mendarum_crystal", new Item(new Item.Settings()
            .rarity(Rarity.EPIC))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.blue").formatted(Formatting.DARK_BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BLUE_MENDARUM_SWORD = registerItem("blue_mendarum_sword",
            new SwordItem(ModToolMaterials.BLUE_MENDARUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BLUE_MENDARUM, 3, -2.4f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.blue").formatted(Formatting.DARK_BLUE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item BLUE_MENDARUM_PICKAXE = registerItem("blue_mendarum_pickaxe",
            new PickaxeItem(ModToolMaterials.BLUE_MENDARUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BLUE_MENDARUM, 1.5f, -3.0f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.blue").formatted(Formatting.DARK_BLUE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item BLUE_MENDARUM_SHOVEL = registerItem("blue_mendarum_shovel",
            new ShovelItem(ModToolMaterials.BLUE_MENDARUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BLUE_MENDARUM, 1.0f, -2.8f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.blue").formatted(Formatting.DARK_BLUE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item BLUE_MENDARUM_AXE = registerItem("blue_mendarum_axe",
            new AxeItem(ModToolMaterials.BLUE_MENDARUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BLUE_MENDARUM, 5.0f, -3.0f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.blue").formatted(Formatting.DARK_BLUE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item BLUE_MENDARUM_HOE = registerItem("blue_mendarum_hoe",
            new HoeItem(ModToolMaterials.BLUE_MENDARUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BLUE_MENDARUM, -4.0f, 0.0f))
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.drehmal_regenesis.mendarum.blue").formatted(Formatting.DARK_BLUE));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });






    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DrehmalRegenesis.MOD_ID, name), item);
    }

    public static Item registerBlockItem(BlockItem item) {
        return register(item.getBlock(), item);
    }

    public static void registerModItems() {
        DrehmalRegenesis.LOGGER.info("Registering items for Drehmal Regenesis");

        /*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.).register(entries -> {
            entries.add();
        });
         */
    }
}
