package com.minerbryan.playground.datagen.tags;

import com.minerbryan.playground.PlaygroundMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class PlaygroundTags {
    public static final class Blocks {
        public static final TagKey<Block> NEBULA_LOGS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(PlaygroundMod.MODID, "nebula_logs"));
    }

    public static final class Items {
        public static final TagKey<Item> NEBULA_LOGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(PlaygroundMod.MODID, "nebula_logs"));
    }
}
