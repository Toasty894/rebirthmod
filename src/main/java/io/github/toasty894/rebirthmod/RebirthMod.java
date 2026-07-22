package io.github.toasty894.rebirthmod;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.item.ModItemGroups;
import io.github.toasty894.rebirthmod.item.ModItems;
import io.github.toasty894.rebirthmod.radiation.RadiationRegistry;
import io.github.toasty894.rebirthmod.sound.ModSounds;
import io.github.toasty894.rebirthmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RebirthMod implements ModInitializer {
	public static final String MOD_ID = "rebirthmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");

		ModSounds.registerModSounds();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();

		RadiationRegistry.registerRadiationLevels();
		ModWorldGeneration.generateModWorldGen();
	}
	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
