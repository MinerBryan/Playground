package com.minerbryan.playground.datagen.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public abstract class PlaygroundRecipeProvider extends RecipeProvider {
    protected RecipeOutput output;

    public PlaygroundRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public void buildRecipes(@NotNull RecipeOutput output) {
        this.output = output;
    }

    protected void stairs(RecipeOutput routput, ItemLike result, ItemLike material) {
        stairBuilder(result, Ingredient.of(material))
                .unlockedBy(getUnlockedName(material), has(material))
                .save(routput);
    }

    protected void slab(ItemLike result, ItemLike material) {
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, result, Ingredient.of(material))
                .unlockedBy(getUnlockedName(material), has(material))
                .save(output);
    }

    protected void trapdoor(ItemLike result, ItemLike material) {
        trapdoorBuilder(result, Ingredient.of(material))
                .unlockedBy(getUnlockedName(material), has(material))
                .save(output);
    }

    protected void door(ItemLike result, ItemLike material) {
        doorBuilder(result, Ingredient.of(material))
                .unlockedBy(getUnlockedName(material), has(material))
                .save(output);
    }

    protected void pressurePlate(ItemLike result, ItemLike material) {
        pressurePlateBuilder(RecipeCategory.REDSTONE, result, Ingredient.of(material))
                .unlockedBy(getUnlockedName(material), has(material))
                .save(output);
    }

    protected void button(ItemLike result, ItemLike material) {
        buttonBuilder(result, Ingredient.of(material))
                .unlockedBy(getUnlockedName(material), has(material))
                .save(output);
    }

    protected void fence(ItemLike result, ItemLike material) {
        fenceBuilder(result, Ingredient.of(material))
                .unlockedBy(getUnlockedName(material), has(material))
                .save(output);
    }

    protected void fenceGate(ItemLike result, ItemLike material) {
        fenceGateBuilder(result, Ingredient.of(material))
                .unlockedBy(getUnlockedName(material), has(material))
                .save(output);
    }

    private String getUnlockedName(ItemLike material) {
        return "has_%s".formatted(material.asItem().getDescriptionId().toLowerCase(Locale.ROOT));
    }
}
