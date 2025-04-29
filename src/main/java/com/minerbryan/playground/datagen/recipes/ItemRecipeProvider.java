package com.minerbryan.playground.datagen.recipes;

import com.google.common.collect.ImmutableList;
import com.minerbryan.playground.registries.BlockRegistry;
import com.minerbryan.playground.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ItemRecipeProvider extends RecipeProvider {
    public static final ImmutableList<ItemLike> STELLARIUM_SMELTABLES = ImmutableList.of(ItemRegistry.RAW_STELLARIUM, BlockRegistry.STELLARIUM_ORE);

    protected RecipeOutput output;

    public ItemRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public void buildRecipes(@NotNull RecipeOutput output) {
        this.output = output;
        //Stellarium Ingot <-> Stellarium Block
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemRegistry.STELLARIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, BlockRegistry.STELLARIUM_BLOCK, "stellarium_ingot_from_block","stellarium_ingot");
        //Stellarium Nugget <-> Stellarium Ingot
        nineBlockStorageRecipesWithCustomPacking(output, RecipeCategory.MISC, ItemRegistry.STELLARIUM_NUGGET, RecipeCategory.MISC, ItemRegistry.STELLARIUM_INGOT, "stellarium_ingot_from_nuggets", "stellarium_ingot");
        //Raw Stellarium <-> Raw Stellarium Block
        nineBlockStorageRecipesRecipesWithCustomUnpacking(output, RecipeCategory.MISC, ItemRegistry.RAW_STELLARIUM, RecipeCategory.BUILDING_BLOCKS, BlockRegistry.RAW_STELLARIUM_BLOCK, "raw_stellarium","raw_stellarium_block");

        //Smelting & Blasting Stellarium
        oreSmelting(output, STELLARIUM_SMELTABLES, RecipeCategory.MISC, ItemRegistry.STELLARIUM_INGOT, 0.7F, 200, "stellarium_ingot");
        oreBlasting(output, STELLARIUM_SMELTABLES, RecipeCategory.MISC, ItemRegistry.STELLARIUM_INGOT, 0.7F, 100, "stellarium_ingot");

    }
}
