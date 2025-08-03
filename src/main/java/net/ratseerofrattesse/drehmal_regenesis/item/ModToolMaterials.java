package net.ratseerofrattesse.drehmal_regenesis.item;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import net.ratseerofrattesse.drehmal_regenesis.util.ModTags;

public enum ModToolMaterials implements ToolMaterial{


    REHNTITE(ModTags.Blocks.INCORRECT_FOR_REHNTITE_TOOL,
            3264, 12.0F, 4.0F, 36, () -> Ingredient.ofItems(ModItems.REHNTITE_INGOT)),
    BLUE_MENDARUM(ModTags.Blocks.INCORRECT_FOR_MENDARUM_TOOL,
            40, 14.0F, 2.0F, 30, () -> Ingredient.ofItems(ModItems.BLUE_MENDARUM_CRYSTAL)),
    RED_MENDARUM(ModTags.Blocks.INCORRECT_FOR_MENDARUM_TOOL,
            40, 14.0F, 2.0F, 30, () -> Ingredient.ofItems(ModItems.RED_MENDARUM_CRYSTAL)),
    PURPLE_MENDARUM(ModTags.Blocks.INCORRECT_FOR_MENDARUM_TOOL,
            40, 14.0F, 2.0F, 30, () -> Ingredient.ofItems(ModItems.PURPLE_MENDARUM_CRYSTAL));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability,final float miningSpeed,
                     final float attackDamage, final int enchantability,final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
