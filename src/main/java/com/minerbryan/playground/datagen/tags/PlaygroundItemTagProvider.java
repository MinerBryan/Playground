package com.minerbryan.playground.datagen.tags;

import com.minerbryan.playground.PlaygroundMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import com.minerbryan.playground.datagen.tags.PlaygroundTags.*;

import java.util.concurrent.CompletableFuture;

public class PlaygroundItemTagProvider extends ItemTagsProvider {
    public PlaygroundItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, CompletableFuture<TagLookup<Block>> blockLookup) {
        super(output, lookup, blockLookup, PlaygroundMod.MODID, null);
    }

    @Override
    protected  void addTags(HolderLookup.Provider provider) {
        copy(Blocks.NEBULA_LOGS, Items.NEBULA_LOGS);
        copy(BlockTags.LOGS, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.DOORS, ItemTags.DOORS);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
    }


}
