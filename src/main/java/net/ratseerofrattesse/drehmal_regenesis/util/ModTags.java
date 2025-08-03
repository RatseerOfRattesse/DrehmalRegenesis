package net.ratseerofrattesse.drehmal_regenesis.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_REHNTITE_TOOL = createTag("needs_rehntite_tool");
        public static final TagKey<Block> INCORRECT_FOR_REHNTITE_TOOL = createTag("incorrect_for_rehntite_tool");
        public static final TagKey<Block> NEEDS_MENDARUM_TOOL = createTag("needs_mendarum_tool");
        public static final TagKey<Block> INCORRECT_FOR_MENDARUM_TOOL = createTag("incorrect_for_mendarum_tool");
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = createTag("needs_netherite_tool");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(DrehmalRegenesis.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(DrehmalRegenesis.MOD_ID, name));
        }
    }
}
