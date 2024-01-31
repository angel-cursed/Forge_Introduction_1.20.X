package net.angel_cursed.mc_mod.datagen;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.block.ModBlocks;
import net.angel_cursed.mc_mod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private List<ItemLike> AURELITE_SMELTABLES = List.of(ModItems.RAW_AURELITE.get(),
            ModBlocks.AURELITE_ORE.get(), ModBlocks.DEEPSLATE_AURELITE_ORE.get(), ModBlocks.NETHER_AURELITE_ORE.get(),
            ModBlocks.END_STONE_AURELITE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AURELITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AURELITE.get())
                .unlockedBy("has_aurelite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AURELITE.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AURELITE.get(), 9)
                .requires(ModBlocks.AURELITE_BLOCK.get())
                .unlockedBy("has_aurelite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.AURELITE_BLOCK.get()).build()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PANCAKES.get(), 1)
                .requires(Items.EGG)
                .requires(Items.WHEAT)
                .unlockedBy("has_wheat_and_egg", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.EGG,Items.EGG).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_AURELITE.get(), RecipeCategory.MISC, ModBlocks.RAW_AURELITE_BLOCK.get(),
                "mc_mod:raw_aurelite","aurelite","mc_mod:raw_aurelite_block","aurelite");
        oreSmelting(pWriter, AURELITE_SMELTABLES, RecipeCategory.MISC, ModItems.AURELITE.get(), 5f, 100, "aurelite");
        oreBlasting(pWriter, AURELITE_SMELTABLES, RecipeCategory.MISC, ModItems.AURELITE.get(), 5f, 75, "aurelite");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, MCMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
