package io.github.toasty894.rebirthmod;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.item.ModItemGroups;
import io.github.toasty894.rebirthmod.item.ModItems;
import io.github.toasty894.rebirthmod.radiation.RadiationRegistry;
import io.github.toasty894.rebirthmod.sound.ModSounds;
import io.github.toasty894.rebirthmod.util.ModLootTableModifiers;
import io.github.toasty894.rebirthmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
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

		ModLootTableModifiers.modifyLootTables();

		StrippableBlockRegistry.register(ModBlocks.ACAI_LOG, ModBlocks.STRIPPED_ACAI_LOG);
		StrippableBlockRegistry.register(ModBlocks.ACAI_WOOD, ModBlocks.STRIPPED_ACAI_WOOD);
		StrippableBlockRegistry.register(ModBlocks.CASHEW_LOG, ModBlocks.STRIPPED_CASHEW_LOG);
		StrippableBlockRegistry.register(ModBlocks.CASHEW_WOOD, ModBlocks.STRIPPED_CASHEW_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACAI_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACAI_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ACAI_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ACAI_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACAI_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACAI_LEAVES, 30, 60);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CASHEW_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CASHEW_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CASHEW_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CASHEW_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CASHEW_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CASHEW_LEAVES, 30, 60);
	}
	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
