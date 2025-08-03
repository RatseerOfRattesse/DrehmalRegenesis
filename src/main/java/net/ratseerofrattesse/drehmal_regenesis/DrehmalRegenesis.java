package net.ratseerofrattesse.drehmal_regenesis;

import net.fabricmc.api.ModInitializer;

import net.ratseerofrattesse.drehmal_regenesis.block.ModBlocks;
import net.ratseerofrattesse.drehmal_regenesis.item.ModItemGroups;
import net.ratseerofrattesse.drehmal_regenesis.item.ModItems;
import net.ratseerofrattesse.drehmal_regenesis.world.biome.ModBiomes;
import net.ratseerofrattesse.drehmal_regenesis.world.gen.feature.ModFeatures;
import net.ratseerofrattesse.drehmal_regenesis.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrehmalRegenesis implements ModInitializer {
	public static final String MOD_ID = "drehmal_regenesis";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("big snake");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModWorldGen.generateModWorldGen();
		ModFeatures.registerModFeatures();
		ModBiomes.registerModBiomes();
	}
}