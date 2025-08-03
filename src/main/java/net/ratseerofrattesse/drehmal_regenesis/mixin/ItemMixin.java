package net.ratseerofrattesse.drehmal_regenesis.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.component.type.DebugStickStateComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;
import net.ratseerofrattesse.drehmal_regenesis.util.ModRarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

import static net.minecraft.item.Items.register;

@Mixin(Items.class)
public class ItemMixin {

	private static boolean drehmal(){
		return FabricLoader.getInstance().isModLoaded("drehmal_regenesis");
	}

	@Shadow
	public static final Item BARRIER = register(new BlockItem(Blocks.BARRIER, (new Item.Settings()).rarity(ModRarity.DIVINE)));
	@Shadow
	public static final Item LIGHT = register(new BlockItem(Blocks.LIGHT, (new Item.Settings()).rarity(ModRarity.DIVINE)));
	@Shadow
	public static final Item REPEATING_COMMAND_BLOCK = register((BlockItem)(new OperatorOnlyBlockItem(Blocks.REPEATING_COMMAND_BLOCK, (new Item.Settings()).rarity(ModRarity.DIVINE))));
	@Shadow
	public static final Item CHAIN_COMMAND_BLOCK = register((BlockItem)(new OperatorOnlyBlockItem(Blocks.CHAIN_COMMAND_BLOCK, (new Item.Settings()).rarity(ModRarity.DIVINE))));
	@Shadow
	public static final Item COMMAND_BLOCK_MINECART = register((String)"command_block_minecart", (Item)(new MinecartItem(AbstractMinecartEntity.Type.COMMAND_BLOCK, (new Item.Settings()).maxCount(1).rarity(ModRarity.DIVINE))));
	@Shadow
	public static final Item COMMAND_BLOCK = register((BlockItem)(new OperatorOnlyBlockItem(Blocks.COMMAND_BLOCK, (new Item.Settings()).rarity(ModRarity.DIVINE))));
	@Shadow
	public static final Item JIGSAW = register((BlockItem)(new OperatorOnlyBlockItem(Blocks.JIGSAW, (new Item.Settings()).rarity(ModRarity.DIVINE))));
	@Shadow
	public static final Item STRUCTURE_VOID = register(new BlockItem(Blocks.STRUCTURE_VOID, (new Item.Settings()).rarity(ModRarity.DIVINE)));
	@Shadow
	public static final Item STRUCTURE_BLOCK = register((BlockItem)(new OperatorOnlyBlockItem(Blocks.STRUCTURE_BLOCK, (new Item.Settings()).rarity(ModRarity.DIVINE))));
	@Shadow
	public static final Item DEBUG_STICK = register((String)"debug_stick", (Item)(new DebugStickItem((new Item.Settings()).maxCount(1).rarity(ModRarity.DIVINE).component(DataComponentTypes.DEBUG_STICK_STATE, DebugStickStateComponent.DEFAULT).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true))));
	@Shadow
	public static final Item KNOWLEDGE_BOOK = register((String)"knowledge_book", (Item)(new KnowledgeBookItem((new Item.Settings()).maxCount(1).rarity(ModRarity.DIVINE).component(DataComponentTypes.RECIPES, List.of()))));

	@Shadow
	public static final Item DRAGON_EGG = register(new BlockItem(Blocks.DRAGON_EGG, (new Item.Settings()).rarity(ModRarity.MYTHIC)));

	//Drehmal Module
	@Shadow
	public static Item NETHER_STAR;
	@Shadow
	public static Item ENDER_PEARL;
	@Shadow
	public static Item ENDER_EYE;
	@Shadow
	public static Item TRIDENT;
	@Shadow
	public static Item CHORUS_FRUIT;
	@Shadow
	public static Item CHORUS_PLANT;
	@Shadow
	public static Item CHORUS_FLOWER;
	@Shadow
	public static Item POPPED_CHORUS_FRUIT;
	@Shadow
	public static Item PURPUR_SLAB;
	@Shadow
	public static Item PURPUR_BLOCK;
	@Shadow
	public static Item PURPUR_PILLAR;
	@Shadow
	public static Item PURPUR_STAIRS;
	@Shadow
	public static Item ELYTRA;
	@Shadow
	public static Item OMINOUS_TRIAL_KEY;
	@Shadow
	public static Item OMINOUS_BOTTLE;
	@Shadow
	public static Item VAULT;
	@Shadow
	public static Item TRIAL_SPAWNER;
	@Shadow
	public static Item TRIAL_KEY;
	@Shadow
	public static Item TOTEM_OF_UNDYING;
	@Shadow
	public static Item ECHO_SHARD;
	@Shadow
	public static Item DRAGON_BREATH;
	@Shadow
	public static Item HEART_OF_THE_SEA;
	@Shadow
	public static Item BEACON;
	@Shadow
	public static Item ENDER_CHEST;
	@Shadow
	public static Item END_PORTAL_FRAME;
	@Shadow
	public static Item REINFORCED_DEEPSLATE;
	@Shadow
	public static Item BEDROCK;
	@Shadow
	public static Item SPAWNER;
	@Shadow
	public static Item WITHER_SKELETON_SKULL;
	@Shadow
	public static Item WITHER_ROSE;

	static {
		if (drehmal()) {
			NETHER_STAR = register("nether_star", new Item((new Item.Settings()).rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
			ENDER_PEARL = register((String)"ender_pearl", (Item)(new EnderPearlItem((new Item.Settings()).maxCount(16).rarity(Rarity.RARE))));
			ENDER_EYE = register((String)"ender_eye", (Item)(new EnderEyeItem(new Item.Settings().rarity(Rarity.RARE))));
			TRIDENT = register((String)"trident", (Item)(new TridentItem((new Item.Settings()).rarity(Rarity.RARE).maxDamage(250).attributeModifiers(TridentItem.createAttributeModifiers()).component(DataComponentTypes.TOOL, TridentItem.createToolComponent()))));
			CHORUS_PLANT = register(new BlockItem(Blocks.CHORUS_PLANT, new Item.Settings().rarity(Rarity.UNCOMMON)));
			CHORUS_FLOWER = register(new BlockItem(Blocks.CHORUS_FLOWER, new Item.Settings().rarity(Rarity.UNCOMMON)));
			CHORUS_FRUIT = register((String)"chorus_fruit", (Item)(new ChorusFruitItem((new Item.Settings()).food(FoodComponents.CHORUS_FRUIT).rarity(Rarity.UNCOMMON))));
			POPPED_CHORUS_FRUIT = register("popped_chorus_fruit", new Item(new Item.Settings().rarity(Rarity.UNCOMMON)));
			PURPUR_SLAB = register(new BlockItem(Blocks.PURPUR_SLAB, new Item.Settings().rarity(Rarity.UNCOMMON)));
			PURPUR_BLOCK = register(new BlockItem(Blocks.PURPUR_BLOCK, new Item.Settings().rarity(Rarity.UNCOMMON)));
			PURPUR_PILLAR = register(new BlockItem(Blocks.PURPUR_PILLAR, new Item.Settings().rarity(Rarity.UNCOMMON)));
			PURPUR_STAIRS = register(new BlockItem(Blocks.PURPUR_STAIRS, new Item.Settings().rarity(Rarity.UNCOMMON)));
			ELYTRA = register((String)"elytra", (Item)(new ElytraItem((new Item.Settings()).maxDamage(432).rarity(Rarity.EPIC))));
			OMINOUS_TRIAL_KEY = register("ominous_trial_key", new Item(new Item.Settings().rarity(Rarity.EPIC)));
			OMINOUS_BOTTLE = register((String)"ominous_bottle", (Item)(new OminousBottleItem((new Item.Settings()).food(FoodComponents.OMINOUS_BOTTLE).component(DataComponentTypes.OMINOUS_BOTTLE_AMPLIFIER, 0).rarity(Rarity.EPIC))));
			VAULT = register(new BlockItem(Blocks.VAULT, new Item.Settings().rarity(Rarity.EPIC)));
			TRIAL_SPAWNER = register(new BlockItem(Blocks.TRIAL_SPAWNER, new Item.Settings().rarity(Rarity.EPIC)));
			TRIAL_KEY = register("trial_key", new Item(new Item.Settings().rarity(Rarity.EPIC)));
			TOTEM_OF_UNDYING = register("totem_of_undying", new Item((new Item.Settings()).maxCount(1).rarity(Rarity.EPIC)));
			ECHO_SHARD = register("echo_shard", new Item(new Item.Settings().rarity(Rarity.RARE)));
			DRAGON_BREATH = register("dragon_breath", new Item((new Item.Settings()).recipeRemainder(Items.GLASS_BOTTLE).rarity(Rarity.RARE)));
			HEART_OF_THE_SEA = register("heart_of_the_sea", new Item((new Item.Settings()).rarity(Rarity.RARE)));
			BEACON = register(new BlockItem(Blocks.BEACON, (new Item.Settings()).rarity(Rarity.EPIC)));
			ENDER_CHEST = register(Blocks.ENDER_CHEST, (settings) -> {
				return settings.component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT).rarity(Rarity.RARE);
			});
			END_PORTAL_FRAME = register(new BlockItem(Blocks.END_PORTAL_FRAME, new Item.Settings().rarity(Rarity.EPIC)));
			REINFORCED_DEEPSLATE = register(new BlockItem(Blocks.REINFORCED_DEEPSLATE, new Item.Settings().rarity(Rarity.EPIC)));
			BEDROCK = register(new BlockItem(Blocks.BEDROCK, new Item.Settings().rarity(Rarity.EPIC)));
			SPAWNER = register(new BlockItem(Blocks.SPAWNER, new Item.Settings().rarity(Rarity.EPIC)));
			WITHER_SKELETON_SKULL = register((BlockItem)(new VerticallyAttachableBlockItem(Blocks.WITHER_SKELETON_SKULL, Blocks.WITHER_SKELETON_WALL_SKULL, (new Item.Settings()).rarity(Rarity.EPIC), Direction.DOWN)));
			WITHER_ROSE = register(new BlockItem(Blocks.WITHER_ROSE, new Item.Settings().rarity(Rarity.EPIC)));
		}
	}
}