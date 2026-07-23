package io.github.toasty894.rebirthmod.datagen;

import io.github.toasty894.rebirthmod.block.ModBlocks;
import io.github.toasty894.rebirthmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> PITCHBLENDE_SMELTABLES = List.of(
            ModItems.RAW_PITCHBLENDE,
            ModBlocks.PITCHBLENDE_ORE,
            ModBlocks.DEEPSLATE_PITCHBLENDE_ORE);

    private static final List<ItemConvertible> URANIUM_SMELTABLES = List.of(
            ModBlocks.RAW_PITCHBLENDE_BLOCK);

    private static final List<ItemConvertible> LEAD_SMELTABLES = List.of(
            ModItems.GALENA,
            ModBlocks.GALENA_ORE,
            ModBlocks.DEEPSLATE_GALENA_ORE);

    private static final List<ItemConvertible> SCHEELITE_SMELTABLES = List.of(
            ModItems.SCHEELITE,
            ModBlocks.SCHEELITE_ORE,
            ModBlocks.DEEPSLATE_SCHEELITE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // Pitchblende recipes
        offerSmelting(exporter, PITCHBLENDE_SMELTABLES, RecipeCategory.MISC, ModItems.PITCHBLENDE_INGOT,
                0.7f, 200, "pitchblende_ingot");
        offerBlasting(exporter, PITCHBLENDE_SMELTABLES, RecipeCategory.MISC, ModItems.PITCHBLENDE_INGOT,
                0.7f, 100, "pitchblende_ingot");

        offerSmelting(exporter, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM,
                1.0f, 200, "uranium");
        offerBlasting(exporter, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM,
                1.0f, 100, "uranium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PITCHBLENDE_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.PITCHBLENDE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_PITCHBLENDE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PITCHBLENDE_BLOCK);

        // Lead main recipes
        offerSmelting(exporter, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT,
                0.4f, 200, "lead_ingot");
        offerBlasting(exporter, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT,
                0.4f, 100, "lead_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.LEAD_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GALENA,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.GALENA_BLOCK);

        // Scheelite main recipes
        offerSmelting(exporter, SCHEELITE_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT,
                0.9f, 200, "tungsten_ingot");
        offerBlasting(exporter, SCHEELITE_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT,
                0.9f, 100, "tungsten_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUNGSTEN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SCHEELITE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCHEELITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.GEIGER_COUNTER, 1)
                .pattern("IPI")
                .pattern("IRI")
                .pattern("WWW")
                .input('I', Items.IRON_INGOT)
                .input('W', ItemTags.PLANKS)
                .input('R', Items.REDSTONE)
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEIGER_COUNTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.PASSION_FRUIT_CAKE, 1)
                .pattern("MPM")
                .pattern("SES")
                .pattern("WWW")
                .input('M', Items.MILK_BUCKET)
                .input('W', Items.WHEAT)
                .input('S', Items.SUGAR)
                .input('E', Items.EGG)
                .input('P', ModItems.PASSION_FRUIT)
                .criterion(hasItem(ModItems.PASSION_FRUIT), conditionsFromItem(ModItems.PASSION_FRUIT))
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PASSION_FRUIT_CAKE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PASSION_FRUIT_JUICE, 1)
                .pattern("F")
                .pattern("P")
                .input('F', ModItems.PASSION_FRUIT)
                .input('P', Items.POTION)
                .criterion(hasItem(ModItems.PASSION_FRUIT), conditionsFromItem(ModItems.PASSION_FRUIT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PASSION_FRUIT_JUICE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PITCHBLENDE_SWORD, 1)
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PITCHBLENDE_SHOVEL, 1)
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PITCHBLENDE_PICKAXE, 1)
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PITCHBLENDE_AXE, 1)
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PITCHBLENDE_HOE, 1)
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PITCHBLENDE_HELMET, 1)
                .pattern("PPP")
                .pattern("P P")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PITCHBLENDE_CHESTPLATE, 1)
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PITCHBLENDE_LEGGINGS, 1)
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PITCHBLENDE_BOOTS, 1)
                .pattern("P P")
                .pattern("P P")
                .input('P', ModItems.PITCHBLENDE_INGOT)
                .criterion(hasItem(ModItems.PITCHBLENDE_INGOT), conditionsFromItem(ModItems.PITCHBLENDE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PITCHBLENDE_BOOTS)));
    }
}
