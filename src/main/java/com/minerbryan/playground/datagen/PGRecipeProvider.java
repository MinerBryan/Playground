package com.minerbryan.playground.datagen;

import com.minerbryan.playground.datagen.recipes.BlockRecipeProvider;
import com.minerbryan.playground.datagen.recipes.ItemRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class PGRecipeProvider extends RecipeProvider {

    private final PackOutput packOutput;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public PGRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
        this.packOutput = output;
        this.registries = registries;
    }

//    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        //Add Recipes
        BlockRecipeProvider blockRecipes = new BlockRecipeProvider(packOutput, registries);
        ItemRecipeProvider itemRecipes = new ItemRecipeProvider(packOutput, registries);

        blockRecipes.buildRecipes(output);
        itemRecipes.buildRecipes(output);
    }
}
