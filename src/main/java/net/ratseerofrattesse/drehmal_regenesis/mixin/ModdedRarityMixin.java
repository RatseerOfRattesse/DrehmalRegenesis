package net.ratseerofrattesse.drehmal_regenesis.mixin;

import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.ratseerofrattesse.drehmal_regenesis.util.ModRarity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(Rarity.class)
public class ModdedRarityMixin {

    //Code from https://github.com/Gauraaaaaaaa/RankingOfThings
    //Thank you Gauraaaaaaaa!

    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static Rarity newRarity(String internalName, int internalId, int id, String name, Formatting formatting) {

        throw new AssertionError();
    }

    @SuppressWarnings("ShadowTarget")
    @Shadow
    @Final
    @Mutable
    private static Rarity[] field_8905;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/util/Rarity;field_8905:[Lnet/minecraft/util/Rarity;", shift = At.Shift.AFTER))
    private static void addCustomRarity(CallbackInfo ci) {

        var rarities = new ArrayList<>(Arrays.asList(field_8905));

        ModRarity.LEGENDARY = newRarity("LEGENDARY", 4, 4, "legendary",Formatting.GOLD);
        ModRarity.MYTHIC = newRarity("MYTHIC", 5, 5, "mythic",Formatting.RED);
        ModRarity.DIVINE = newRarity("DIVINE", 6, 6, "divine",Formatting.DARK_RED);


        rarities.add(ModRarity.LEGENDARY);
        rarities.add(ModRarity.MYTHIC);
        rarities.add(ModRarity.DIVINE);


        field_8905 = rarities.toArray(new Rarity[0]);
    }

}
