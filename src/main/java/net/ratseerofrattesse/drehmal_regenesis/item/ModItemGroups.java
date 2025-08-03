package net.ratseerofrattesse.drehmal_regenesis.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;

public class ModItemGroups {
    public static final ItemGroup DREHMAL_REGENESIS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DrehmalRegenesis.MOD_ID, "drehmal_regenesis"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PLACEHOLDER))
                    .displayName(Text.translatable("itemgroup.drehmal_regenesis.drehmal_regenesis"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.REHNTITE_BLOCK);
                        entries.add(ModItems.RAW_REHNTITE_BLOCK);
                        entries.add(ModItems.RAW_REHNTITE);
                        entries.add(ModItems.REHNTITE_INGOT);
                        entries.add(ModItems.REHNTITE_NUGGET);
                        entries.add(ModItems.REHNTITE_SWORD);
                        entries.add(ModItems.REHNTITE_PICKAXE);
                        entries.add(ModItems.REHNTITE_AXE);
                        entries.add(ModItems.REHNTITE_SHOVEL);
                        entries.add(ModItems.REHNTITE_HOE);

                        entries.add(ModItems.PURPLE_MENDARUM_BLOCK);
                        entries.add(ModItems.PURPLE_MENDARUM_SHELL);
                        entries.add(ModItems.PURPLE_MENDARUM_CRYSTAL);
                        entries.add(ModItems.PURPLE_MENDARUM_SWORD);
                        entries.add(ModItems.PURPLE_MENDARUM_PICKAXE);
                        entries.add(ModItems.PURPLE_MENDARUM_AXE);
                        entries.add(ModItems.PURPLE_MENDARUM_SHOVEL);
                        entries.add(ModItems.PURPLE_MENDARUM_HOE);

                        entries.add(ModItems.RED_MENDARUM_BLOCK);
                        entries.add(ModItems.RED_MENDARUM_SHELL);
                        entries.add(ModItems.RED_MENDARUM_CRYSTAL);
                        entries.add(ModItems.RED_MENDARUM_SWORD);
                        entries.add(ModItems.RED_MENDARUM_PICKAXE);
                        entries.add(ModItems.RED_MENDARUM_AXE);
                        entries.add(ModItems.RED_MENDARUM_SHOVEL);
                        entries.add(ModItems.RED_MENDARUM_HOE);

                        entries.add(ModItems.BLUE_MENDARUM_BLOCK);
                        entries.add(ModItems.BLUE_MENDARUM_SHELL);
                        entries.add(ModItems.BLUE_MENDARUM_CRYSTAL);
                        entries.add(ModItems.BLUE_MENDARUM_SWORD);
                        entries.add(ModItems.BLUE_MENDARUM_PICKAXE);
                        entries.add(ModItems.BLUE_MENDARUM_AXE);
                        entries.add(ModItems.BLUE_MENDARUM_SHOVEL);
                        entries.add(ModItems.BLUE_MENDARUM_HOE);

                    }).build());

    public static void registerItemGroups() {
        DrehmalRegenesis.LOGGER.info("Registering item groups for Drehmal Regenesis");
    }
}
