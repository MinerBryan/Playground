package com.minerbryan.playground.datagen.recipes;

import com.minerbryan.playground.registries.BlockRegistry;
import com.minerbryan.playground.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ItemRecipeProvider extends RecipeProvider {
    protected RecipeOutput output;

    public ItemRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public void buildRecipes(@NotNull RecipeOutput output) {
        this.output = output;
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemRegistry.STELLARIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, BlockRegistry.STELLARIUM_BLOCK, "stellarium_ingot_from_block","stellarium_ingot");
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemRegistry.STELLARIUM_NUGGET, RecipeCategory.MISC, ItemRegistry.STELLARIUM_INGOT, "stellarium_ingot_from_nuggets", "stellarium_ingot");
    }
}
