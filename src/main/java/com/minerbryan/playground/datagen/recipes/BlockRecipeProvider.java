package com.minerbryan.playground.datagen.recipes;

import com.minerbryan.playground.registries.BlockRegistry;
import com.minerbryan.playground.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BlockRecipeProvider extends PlaygroundRecipeProvider {

    public BlockRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public void buildRecipes(@NotNull RecipeOutput output) {
        this.output = output;
        doorBuilder(BlockRegistry.STELLARIUM_DOOR, Ingredient.of(ItemRegistry.STELLARIUM_INGOT));
        trapdoorBuilder(BlockRegistry.STELLARIUM_TRAPDOOR, Ingredient.of(ItemRegistry.STELLARIUM_INGOT));

//        planksFromLogs(BlockRegistry.NEBULA_PLANKS, );
        woodFromLogs(output, BlockRegistry.NEBULA_WOOD, BlockRegistry.NEBULA_LOG);
        stairs(output, BlockRegistry.NEBULA_STAIRS, BlockRegistry.NEBULA_PLANKS);
        slab(BlockRegistry.NEBULA_SLABS, BlockRegistry.NEBULA_PLANKS);
        door(BlockRegistry.NEBULA_DOOR, BlockRegistry.NEBULA_PLANKS);
        trapdoor(BlockRegistry.NEBULA_TRAPDOOR, BlockRegistry.NEBULA_PLANKS);
        fence(BlockRegistry.NEBULA_FENCE, BlockRegistry.NEBULA_PLANKS);
        fenceGate(BlockRegistry.NEBULA_FENCE_GATE, BlockRegistry.NEBULA_PLANKS);
        pressurePlate(BlockRegistry.NEBULA_PRESSURE_PLATE, BlockRegistry.NEBULA_PLANKS);
        button(BlockRegistry.NEBULA_BUTTON, BlockRegistry.NEBULA_PLANKS);
    }
}
