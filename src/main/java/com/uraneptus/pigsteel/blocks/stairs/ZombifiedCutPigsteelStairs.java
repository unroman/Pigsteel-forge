package com.uraneptus.pigsteel.blocks.stairs;

import com.uraneptus.pigsteel.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.phys.BlockHitResult;

public class ZombifiedCutPigsteelStairs extends StairBlock {

    public ZombifiedCutPigsteelStairs(BlockState state, Properties properties) {
        super(state, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).randomTicks());
    }

    public InteractionResult use(BlockState state, Level world, BlockPos blockPos, Player playerEntity, InteractionHand hand, BlockHitResult result) {
        if(playerEntity.getItemInHand(hand).getItem() == Items.HONEYCOMB) {
            Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            Boolean watered = state.getValue(BlockStateProperties.WATERLOGGED);
            StairsShape shape = state.getValue(BlockStateProperties.STAIRS_SHAPE);
            Half half = state.getValue(BlockStateProperties.HALF);

            playerEntity.swing(hand);
            world.setBlockAndUpdate(blockPos, BlockInit.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS.get().defaultBlockState()
                    .setValue(BlockStateProperties.HORIZONTAL_FACING, direction)
                    .setValue(BlockStateProperties.WATERLOGGED, watered)
                    .setValue(BlockStateProperties.STAIRS_SHAPE, shape)
                    .setValue(BlockStateProperties.HALF, half));
        }
        return InteractionResult.PASS;
    }
}
