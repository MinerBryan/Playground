package com.minerbryan.playground.datagen.recipes;

import com.minerbryan.playground.registries.BlockRegistry;
import com.minerbryan.playground.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BlockRecipeProvider extends RecipeProvider {
    protected RecipeOutput output;

    public BlockRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public void buildRecipes(@NotNull RecipeOutput output) {
        this.output = output;
        doorBuilder(BlockRegistry.STELLARIUM_DOOR, Ingredient.of(ItemRegistry.STELLARIUM_INGOT));
        trapdoorBuilder(BlockRegistry.STELLARIUM_TRAPDOOR, Ingredient.of(ItemRegistry.STELLARIUM_INGOT));

//        planksFromLogs(BlockRegistry.NEBULA_PLANKS, );
        woodFromLogs(output, BlockRegistry.NEBULA_WOOD, BlockRegistry.NEBULA_LOG);
        stairBuilder(BlockRegistry.NEBULA_STAIRS, Ingredient.of(BlockRegistry.NEBULA_PLANKS)).save(output);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.NEBULA_SLABS, Ingredient.of(BlockRegistry.NEBULA_PLANKS));
        doorBuilder(BlockRegistry.NEBULA_DOOR, Ingredient.of(BlockRegistry.NEBULA_PLANKS));
        trapdoorBuilder(BlockRegistry.NEBULA_TRAPDOOR, Ingredient.of(BlockRegistry.NEBULA_PLANKS));
        fenceBuilder(BlockRegistry.NEBULA_FENCE, Ingredient.of(BlockRegistry.NEBULA_PLANKS));
        fenceGateBuilder(BlockRegistry.NEBULA_FENCE_GATE, Ingredient.of(BlockRegistry.NEBULA_PLANKS));
        pressurePlateBuilder(RecipeCategory.REDSTONE, BlockRegistry.NEBULA_PRESSURE_PLATE, Ingredient.of(BlockRegistry.NEBULA_PLANKS));
        buttonBuilder(BlockRegistry.NEBULA_BUTTON, Ingredient.of(BlockRegistry.NEBULA_PLANKS));
    }

//    protected void plankFromLog(ItemLike planks, ItemLike log){
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4)
//                .requires(log)
//                .group("planks")
//                .unlockedBy("has_log", has(log))
//                .save(output);
//    }
}
