package io.github.toasty894.rebirthmod;

import io.github.toasty894.rebirthmod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class RebirthModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		ModBlockTagProvider blockTagProvider = pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider((output, registries) -> new ModItemTagProvider(output, registries, blockTagProvider));

		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

	}
}
