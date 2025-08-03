package net.ratseerofrattesse.drehmal_regenesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.ratseerofrattesse.drehmal_regenesis.DrehmalRegenesis;
import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;
import net.ratseerofrattesse.drehmal_regenesis.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        //REHNTITE
        List<ItemConvertible> REHNTITE_SMELTABLES = List.of(ModItems.RAW_REHNTITE);

        offerSmelting(exporter, REHNTITE_SMELTABLES, RecipeCategory.MISC, ModItems.REHNTITE_INGOT, 2.0f, 200, "pink_garnet");
        offerBlasting(exporter, REHNTITE_SMELTABLES, RecipeCategory.MISC, ModItems.REHNTITE_INGOT, 2.0f, 100, "pink_garnet");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.REHNTITE_INGOT, RecipeCategory.DECORATIONS, ModItems.REHNTITE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_REHNTITE, RecipeCategory.DECORATIONS, ModItems.RAW_REHNTITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.REHNTITE_INGOT, 1)
                .input('#', ModItems.REHNTITE_NUGGET)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(ModItems.REHNTITE_NUGGET), conditionsFromItem(ModItems.REHNTITE_NUGGET))
                .offerTo(exporter, "rehntite_ingot_from_nugget");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_REHNTITE, 9)
                .input(ModItems.RAW_REHNTITE_BLOCK)
                .criterion(hasItem(ModItems.RAW_REHNTITE_BLOCK), conditionsFromItem(ModItems.RAW_REHNTITE_BLOCK))
                .offerTo(exporter, "raw_rehntite_from_block");

        CookingRecipeJsonBuilder.createBlasting(
                        Ingredient.ofItems(
                                ModItems.REHNTITE_PICKAXE,
                                ModItems.REHNTITE_SHOVEL,
                                ModItems.REHNTITE_AXE,
                                ModItems.REHNTITE_HOE,
                                ModItems.REHNTITE_SWORD//,
                                /*
                                Items.REHNTITE_HELMET,
                                Items.REHNTITE_CHESTPLATE,
                                Items.REHNTITE_LEGGINGS,
                                Items.REHNTITE_BOOTS,
                                Items.REHNTITE_HORSE_ARMOR
                                 */
                        ),
                        RecipeCategory.MISC,
                        ModItems.REHNTITE_NUGGET,
                        0.2F,
                        100
                )
                .criterion("has_rehntite_pickaxe", conditionsFromItem(ModItems.REHNTITE_PICKAXE))
                .criterion("has_rehntite_shovel", conditionsFromItem(ModItems.REHNTITE_SHOVEL))
                .criterion("has_rehntite_axe", conditionsFromItem(ModItems.REHNTITE_AXE))
                .criterion("has_rehntite_hoe", conditionsFromItem(ModItems.REHNTITE_HOE))
                .criterion("has_rehntite_sword", conditionsFromItem(ModItems.REHNTITE_SWORD))
                /*
                .criterion("has_rehntite_helmet", conditionsFromItem(Items.REHNTITE_HELMET))
                .criterion("has_rehntite_chestplate", conditionsFromItem(Items.REHNTITE_CHESTPLATE))
                .criterion("has_rehntite_leggings", conditionsFromItem(Items.REHNTITE_LEGGINGS))
                .criterion("has_rehntite_boots", conditionsFromItem(Items.REHNTITE_BOOTS))
                .criterion("has_rehntite_horse_armor", conditionsFromItem(Items.REHNTITE_HORSE_ARMOR))
                 */
                .offerTo(exporter, getBlastingItemPath(ModItems.REHNTITE_NUGGET));

        CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItems(
                                ModItems.REHNTITE_PICKAXE,
                                ModItems.REHNTITE_SHOVEL,
                                ModItems.REHNTITE_AXE,
                                ModItems.REHNTITE_HOE,
                                ModItems.REHNTITE_SWORD//,
                                /*
                                Items.REHNTITE_HELMET,
                                Items.REHNTITE_CHESTPLATE,
                                Items.REHNTITE_LEGGINGS,
                                Items.REHNTITE_BOOTS,
                                Items.REHNTITE_HORSE_ARMOR
                                 */
                        ),
                        RecipeCategory.MISC,
                        ModItems.REHNTITE_NUGGET,
                        0.2F,
                        100
                )
                .criterion("has_rehntite_pickaxe", conditionsFromItem(ModItems.REHNTITE_PICKAXE))
                .criterion("has_rehntite_shovel", conditionsFromItem(ModItems.REHNTITE_SHOVEL))
                .criterion("has_rehntite_axe", conditionsFromItem(ModItems.REHNTITE_AXE))
                .criterion("has_rehntite_hoe", conditionsFromItem(ModItems.REHNTITE_HOE))
                .criterion("has_rehntite_sword", conditionsFromItem(ModItems.REHNTITE_SWORD))
                /*
                .criterion("has_rehntite_helmet", conditionsFromItem(Items.REHNTITE_HELMET))
                .criterion("has_rehntite_chestplate", conditionsFromItem(Items.REHNTITE_CHESTPLATE))
                .criterion("has_rehntite_leggings", conditionsFromItem(Items.REHNTITE_LEGGINGS))
                .criterion("has_rehntite_boots", conditionsFromItem(Items.REHNTITE_BOOTS))
                .criterion("has_rehntite_horse_armor", conditionsFromItem(Items.REHNTITE_HORSE_ARMOR))
                 */
                .offerTo(exporter, getSmeltingItemPath(ModItems.REHNTITE_NUGGET));

        offerSwordRecipe(exporter, ModItems.REHNTITE_SWORD, ModItems.REHNTITE_INGOT, Items.STICK);
        offerPickaxeRecipe(exporter, ModItems.REHNTITE_PICKAXE, ModItems.REHNTITE_INGOT, Items.STICK);
        offerAxeRecipe(exporter, ModItems.REHNTITE_AXE, ModItems.REHNTITE_INGOT, Items.STICK);
        offerShovelRecipe(exporter, ModItems.REHNTITE_SHOVEL, ModItems.REHNTITE_INGOT, Items.STICK);
        offerHoeRecipe(exporter, ModItems.REHNTITE_HOE, ModItems.REHNTITE_INGOT, Items.STICK);

        //PURPLE MENDARUM

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_MENDARUM_CRYSTAL, RecipeCategory.DECORATIONS, ModItems.PURPLE_MENDARUM_BLOCK);

        offerSwordRecipe(exporter, ModItems.PURPLE_MENDARUM_SWORD, ModItems.PURPLE_MENDARUM_CRYSTAL, Items.STICK);
        offerPickaxeRecipe(exporter, ModItems.PURPLE_MENDARUM_PICKAXE, ModItems.PURPLE_MENDARUM_CRYSTAL, Items.STICK);
        offerAxeRecipe(exporter, ModItems.PURPLE_MENDARUM_AXE, ModItems.PURPLE_MENDARUM_CRYSTAL, Items.STICK);
        offerShovelRecipe(exporter, ModItems.PURPLE_MENDARUM_SHOVEL, ModItems.PURPLE_MENDARUM_CRYSTAL, Items.STICK);
        offerHoeRecipe(exporter, ModItems.PURPLE_MENDARUM_HOE, ModItems.PURPLE_MENDARUM_CRYSTAL, Items.STICK);

        //RED MENDARUM

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RED_MENDARUM_CRYSTAL, RecipeCategory.DECORATIONS, ModItems.RED_MENDARUM_BLOCK);

        offerSwordRecipe(exporter, ModItems.RED_MENDARUM_SWORD, ModItems.RED_MENDARUM_CRYSTAL, Items.STICK);
        offerPickaxeRecipe(exporter, ModItems.RED_MENDARUM_PICKAXE, ModItems.RED_MENDARUM_CRYSTAL, Items.STICK);
        offerAxeRecipe(exporter, ModItems.RED_MENDARUM_AXE, ModItems.RED_MENDARUM_CRYSTAL, Items.STICK);
        offerShovelRecipe(exporter, ModItems.RED_MENDARUM_SHOVEL, ModItems.RED_MENDARUM_CRYSTAL, Items.STICK);
        offerHoeRecipe(exporter, ModItems.RED_MENDARUM_HOE, ModItems.RED_MENDARUM_CRYSTAL, Items.STICK);

        //BLUE MENDARUM

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_MENDARUM_CRYSTAL, RecipeCategory.DECORATIONS, ModItems.BLUE_MENDARUM_BLOCK);

        offerSwordRecipe(exporter, ModItems.BLUE_MENDARUM_SWORD, ModItems.BLUE_MENDARUM_CRYSTAL, Items.STICK);
        offerPickaxeRecipe(exporter, ModItems.BLUE_MENDARUM_PICKAXE, ModItems.BLUE_MENDARUM_CRYSTAL, Items.STICK);
        offerAxeRecipe(exporter, ModItems.BLUE_MENDARUM_AXE, ModItems.BLUE_MENDARUM_CRYSTAL, Items.STICK);
        offerShovelRecipe(exporter, ModItems.BLUE_MENDARUM_SHOVEL, ModItems.BLUE_MENDARUM_CRYSTAL, Items.STICK);
        offerHoeRecipe(exporter, ModItems.BLUE_MENDARUM_HOE, ModItems.BLUE_MENDARUM_CRYSTAL, Items.STICK);

    }

    public static void offerSwordRecipe(RecipeExporter exporter, ItemConvertible sword, ItemConvertible material, ItemConvertible handle) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, sword, 1)
                .input('H', handle)
                .input('M', material)
                .pattern("M")
                .pattern("M")
                .pattern("H")
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(handle), conditionsFromItem(handle))
                .offerTo(exporter);
    }

    public static void offerPickaxeRecipe(RecipeExporter exporter, ItemConvertible pickaxe, ItemConvertible material, ItemConvertible handle) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, pickaxe, 1)
                .input('H', handle)
                .input('M', material)
                .pattern("MMM")
                .pattern(" H ")
                .pattern(" H ")
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(handle), conditionsFromItem(handle))
                .offerTo(exporter);
    }

    public static void offerAxeRecipe(RecipeExporter exporter, ItemConvertible axe, ItemConvertible material, ItemConvertible handle) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, axe, 1)
                .input('H', handle)
                .input('M', material)
                .pattern("MM")
                .pattern("MH")
                .pattern(" H")
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(handle), conditionsFromItem(handle))
                .offerTo(exporter);
    }

    public static void offerShovelRecipe(RecipeExporter exporter, ItemConvertible shovel, ItemConvertible material, ItemConvertible handle) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, shovel, 1)
                .input('H', handle)
                .input('M', material)
                .pattern("M")
                .pattern("H")
                .pattern("H")
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(handle), conditionsFromItem(handle))
                .offerTo(exporter);
    }

    public static void offerHoeRecipe(RecipeExporter exporter, ItemConvertible hoe, ItemConvertible material, ItemConvertible handle) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, hoe, 1)
                .input('H', handle)
                .input('M', material)
                .pattern("MM")
                .pattern(" H")
                .pattern(" H")
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(handle), conditionsFromItem(handle))
                .offerTo(exporter);
    }
}
