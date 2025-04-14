package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import com.minerbryan.playground.blocks.ExampleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final DeferredBlock<Block> STELLARIUM_BLOCK = BLOCKS.registerSimpleBlock("stellarium_block", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    //Ore
    public static final DeferredBlock<Block> STELLARIUM_ORE = BLOCKS.register("stellarium_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));

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

//    public static final BlockSetType NEBULA_BLOCKSET = BlockSetType.register(
//            new BlockSetType(
//                    "nebula",
//                    true,
//                    true,
//                    true,
//                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
//                    SoundType.CHERRY_WOOD,
//                    SoundEvents.CHERRY_WOOD_DOOR_CLOSE,
//                    SoundEvents.CHERRY_WOOD_DOOR_OPEN,
//                    SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE,
//                    SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN,
//                    SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF,
//                    SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON,
//                    SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF,
//                    SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON
//            )
//    );

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
//                    new WoodType("nebula", NEBULA_BLOCKSET),
                    WoodType.CHERRY,
                    BlockBehaviour.Properties.of()
                            .mapColor(NEBULA_PLANKS.get().defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F,3.0F)
                            .ignitedByLava()
            )
    );



    // Directly Copied over from MC's Blocks.java file
    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
