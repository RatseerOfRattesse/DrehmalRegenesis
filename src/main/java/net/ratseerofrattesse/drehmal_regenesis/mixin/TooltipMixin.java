package net.ratseerofrattesse.drehmal_regenesis.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.ratseerofrattesse.drehmal_regenesis.util.ModRarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Objects;

@Environment(EnvType.CLIENT)
@Mixin(Item.class)
public abstract class TooltipMixin {

    @Inject(at = @At("HEAD"), method = "appendTooltip")
    public void getTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType tooltipType, CallbackInfo ci) {
        Rarity rarity = stack.get(DataComponentTypes.RARITY);
        if (Objects.equals(rarity, Rarity.COMMON)) {
            tooltip.add(Text.translatable("athenaeum.rarity.common").formatted(Formatting.WHITE).formatted(Formatting.ITALIC));
        } else if (Objects.equals(rarity, Rarity.UNCOMMON)) {
            tooltip.add(Text.translatable("athenaeum.rarity.uncommon").formatted(Formatting.YELLOW).formatted(Formatting.ITALIC));
        } else if (Objects.equals(rarity, Rarity.RARE)) {
            tooltip.add(Text.translatable("athenaeum.rarity.rare").formatted(Formatting.AQUA).formatted(Formatting.ITALIC));
        } else if (Objects.equals(rarity, Rarity.EPIC)) {
            tooltip.add(Text.translatable("athenaeum.rarity.epic").formatted(Formatting.LIGHT_PURPLE).formatted(Formatting.ITALIC));
        } else if (Objects.equals(rarity, ModRarity.LEGENDARY)) {
            tooltip.add(Text.translatable("athenaeum.rarity.legendary").formatted(Formatting.GOLD).formatted(Formatting.ITALIC));
        } else if (Objects.equals(rarity, ModRarity.MYTHIC)) {
            tooltip.add(Text.translatable("athenaeum.rarity.mythic").formatted(Formatting.RED).formatted(Formatting.ITALIC));
        } else if (Objects.equals(rarity, ModRarity.DIVINE)) {
            tooltip.add(Text.translatable("athenaeum.rarity.divine").formatted(Formatting.DARK_RED).formatted(Formatting.ITALIC));
        }
    }
}

