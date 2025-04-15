package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import com.minerbryan.playground.blocks.ExampleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;


//rawr
public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PlaygroundMod.MODID);

    // Creates a new Block with the id "playground:example_block", combining the namespace and path
    public static final DeferredBlock<Block> BISMUTH_BLOCK = BLOCKS.registerSimpleBlock("bismuth_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredBlock<Block> EXAMPLE_BLOCK_ENTITY = BLOCKS.register("example_block_entity", () -> new ExampleBlockEntity(BlockBehaviour.Properties.of().noOcclusion()));

    //Ore
    public static final DeferredBlock<Block> STELLARIUM_ORE = BLOCKS.register("stellarium_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));

    //Raw Blocks
    //public static final DeferredBlock<Block> RAW_STELLARIUM_BLOCK = BLOCKS.register("raw_stellarium_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));

    //Metal Block
    public static final DeferredBlock<Block> STELLARIUM_BLOCK = BLOCKS.registerSimpleBlock("stellarium_block", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

    //Planks
    public static final DeferredBlock<Block> NEBULA_PLANKS = BLOCKS.registerSimpleBlock("nebula_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));

    //Sapling
    public static final DeferredBlock<Block> NEBULA_SAPLING = BLOCKS.register("nebula_sapling",
            () -> new SaplingBlock(
                    new TreeGrower(
                            PlaygroundMod.MODID+":nebula",
                            0.1F,
                            Optional.empty(),
                            Optional.empty(),
                            Optional.of(ConfigFeatureRegistry.NEBULA_KEY),
                            Optional.empty(),
                            Optional.empty(),
                            Optional.empty()
                    ),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)
            )
    );

    //Log
    public static final DeferredBlock<Block> NEBULA_LOG = BLOCKS.register("nebula_log", () -> new RotatedPillarBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0f)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
            )
    );

    //Wood
    public static final DeferredBlock<Block> NEBULA_WOOD = BLOCKS.register("nebula_wood", () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_PURPLE)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0f)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            )
    );

    //Leaves
    public static final DeferredBlock<Block> NEBULA_LEAVES = BLOCKS.register("nebula_leaves", () -> new LeavesBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .forceSolidOn()
                    .strength(2.0f)
                    .randomTicks()
                    .sound(SoundType.AZALEA_LEAVES)
                    .noOcclusion()
                    .isValidSpawn(Blocks::ocelotOrParrot)
                    .isSuffocating(BlockRegistry::never)
                    .isViewBlocking(BlockRegistry::never)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isRedstoneConductor(BlockRegistry::never)
        )
    );

    //Fences
    public static final DeferredBlock<Block> NEBULA_FENCE = BLOCKS.register(
            "nebula_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(NEBULA_PLANKS.get().defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            )
    );

    //Fence Gates
    public static final DeferredBlock<Block> NEBULA_FENCE_GATE = BLOCKS.register(
            "nebula_fence_gate",
            () -> new FenceGateBlock(
                    WoodType.OAK,
                    BlockBehaviour.Properties.of()
                            .mapColor(NEBULA_PLANKS.get().defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F,3.0F)
                            .ignitedByLava()
            )
    );

    //Doors
    public static final DeferredBlock<Block> NEBULA_DOOR = BLOCKS.register(
            "nebula_door",
            () -> new DoorBlock(
                    BlockSetType.CHERRY,
                    BlockBehaviour.Properties.of()
                            .mapColor(NEBULA_PLANKS.get().defaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .noOcclusion()
                            .ignitedByLava()
                            .pushReaction(PushReaction.DESTROY)
            )
    );
    public static final DeferredBlock<Block> STELLARIUM_DOOR = BLOCKS.register(
            "stellarium_door",
            () -> new DoorBlock(
                    BlockSetType.IRON,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)
            )
    );

    //Trapdoors
    public static final DeferredBlock<Block> NEBULA_TRAPDOOR = BLOCKS.register(
            "nebula_trapdoor",
            () -> new TrapDoorBlock(
                    BlockSetType.CHERRY,
                    BlockBehaviour.Properties.of()
                            .mapColor(NEBULA_PLANKS.get().defaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .noOcclusion()
                            .ignitedByLava()
                            .isValidSpawn(BlockRegistry::never)
            )
    );
    public static final DeferredBlock<Block> STELLARIUM_TRAPDOOR = BLOCKS.register(
            "stellarium_trapdoor",
            () -> new TrapDoorBlock(
                    BlockSetType.IRON,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR)
            )
    );
    // Directly Copied over from MC's Blocks.java file
    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) { return false; }
    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }



    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
