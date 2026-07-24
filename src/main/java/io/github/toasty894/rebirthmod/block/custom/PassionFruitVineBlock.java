package io.github.toasty894.rebirthmod.block.custom;

import io.github.toasty894.rebirthmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PassionFruitVineBlock extends VineBlock implements Fertilizable {

    public static final IntProperty AGE = IntProperty.of("age", 0, 15);

    private static final VoxelShape UP_SHAPE = Block.createCuboidShape(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
    private static final VoxelShape EAST_SHAPE = Block.createCuboidShape(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);

    public PassionFruitVineBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(AGE, 0)
                .with(UP, false)
                .with(NORTH, false)
                .with(SOUTH, false)
                .with(EAST, false)
                .with(WEST, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, UP, NORTH, SOUTH, EAST, WEST);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        // Must have valid physical support AND be connected to a ground root
        return hasSupport(world, pos, state) && isConnectedToRoot(world, pos);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return updateConnections(state, world, pos);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            if (!isConnectedToRoot(world, pos)) {
                world.breakBlock(pos, true);
                return;
            }

            int age = state.get(AGE);
            if (age < 15) {
                world.setBlockState(pos, state.with(AGE, age + 1), Block.NOTIFY_LISTENERS);
            } else {
                if (countNearbyVines(world, pos) <= 18) {
                    float growthChance = random.nextFloat();
                    if (growthChance < 0.45F) {
                        tryGrowHorizontal(world, pos, random);
                    } else if (growthChance < 0.80F) {
                        tryGrowUp(world, pos, random);
                    } else {
                        tryGrowDown(world, pos, random);
                    }
                }
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);
        if (age >= 14) {
            if (world instanceof ServerWorld serverWorld) {
                dropFruit(serverWorld, pos, state);
            }
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, 0), Block.NOTIFY_LISTENERS);
            return ActionResult.success(world.isClient());
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && state.get(AGE) >= 14 && !player.isCreative()) {
            dropFruit((ServerWorld) world, pos, state);
        }
        super.onBreak(world, pos, state, player);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(0.98D, 0.98D, 0.98D));

        if (entity instanceof LivingEntity) {
            entity.fallDistance = 0.0f;
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();
        if (state.get(UP)) {
            shape = VoxelShapes.union(shape, UP_SHAPE);
        }
        if (state.get(NORTH)) {
            shape = VoxelShapes.union(shape, NORTH_SHAPE);
        }
        if (state.get(SOUTH)) {
            shape = VoxelShapes.union(shape, SOUTH_SHAPE);
        }
        if (state.get(EAST)) {
            shape = VoxelShapes.union(shape, EAST_SHAPE);
        }
        if (state.get(WEST)) {
            shape = VoxelShapes.union(shape, WEST_SHAPE);
        }
        return shape.isEmpty() ? VoxelShapes.fullCube() : shape;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 15;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int newAge = Math.min(15, state.get(AGE) + 2);
        world.setBlockState(pos, state.with(AGE, newAge), Block.NOTIFY_LISTENERS);

        if (newAge >= 12) {
            if (countNearbyVines(world, pos) <= 18) {
                float growthChance = random.nextFloat();
                if (growthChance < 0.45F) {
                    tryGrowHorizontal(world, pos, random);
                } else if (growthChance < 0.80F) {
                    tryGrowUp(world, pos, random);
                } else {
                    tryGrowDown(world, pos, random);
                }
            }
        }
    }

    public boolean hasSupport(BlockView world, BlockPos pos, BlockState state) {
        BlockPos downPos = pos.down();
        BlockState downState = world.getBlockState(downPos);
        if (downState.isOf(Blocks.GRASS_BLOCK) || downState.isOf(Blocks.DIRT)) {
            return true;
        }

        for (Direction direction : Direction.values()) {
            if (direction == Direction.DOWN) continue;
            BlockPos neighborPos = pos.offset(direction);
            BlockState neighborState = world.getBlockState(neighborPos);
            // Must attach to a solid block or another valid vine
            if (neighborState.isOpaqueFullCube(world, neighborPos) || neighborState.getBlock() instanceof PassionFruitVineBlock) {
                return true;
            }
        }
        return false;
    }

    public boolean tryGrowUp(ServerWorld world, BlockPos pos, Random random) {
        BlockPos upPos = pos.up();
        if (world.getBlockState(upPos).isAir()) {
            BlockState newState = this.getDefaultState().with(AGE, 0);
            newState = updateConnections(newState, world, upPos);
            if (canPlaceAt(newState, world, upPos)) {
                world.setBlockState(upPos, newState, Block.NOTIFY_LISTENERS);
                return true;
            }
        }
        return false;
    }

    public boolean tryGrowHorizontal(ServerWorld world, BlockPos pos, Random random) {
        Direction[] horizontals = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
        Direction dir = horizontals[random.nextInt(horizontals.length)];
        BlockPos targetPos = pos.offset(dir);

        if (world.getBlockState(targetPos).isAir()) {
            BlockState newState = this.getDefaultState().with(AGE, 0);
            newState = updateConnections(newState, world, targetPos);
            if (canPlaceAt(newState, world, targetPos)) {
                world.setBlockState(targetPos, newState, Block.NOTIFY_LISTENERS);
                return true;
            }
        }
        return false;
    }

    public boolean tryGrowDown(ServerWorld world, BlockPos pos, Random random) {
        BlockPos downPos = pos.down();
        if (world.getBlockState(downPos).isAir()) {
            BlockState newState = this.getDefaultState().with(AGE, 0);
            newState = updateConnections(newState, world, downPos);
            if (canPlaceAt(newState, world, downPos)) {
                world.setBlockState(downPos, newState, Block.NOTIFY_LISTENERS);
                return true;
            }
        }
        return false;
    }

    public BlockState updateConnections(BlockState state, WorldView world, BlockPos pos) {
        boolean up = world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos.up(), Direction.DOWN);
        boolean north = canConnectTo(world, pos.north(), Direction.SOUTH);
        boolean south = canConnectTo(world, pos.south(), Direction.NORTH);
        boolean east  = canConnectTo(world, pos.east(), Direction.WEST);
        boolean west  = canConnectTo(world, pos.west(), Direction.EAST);

        return state.with(UP, up)
                .with(NORTH, north)
                .with(SOUTH, south)
                .with(EAST, east)
                .with(WEST, west);
    }

    private boolean canConnectTo(WorldView world, BlockPos pos, Direction faceToCheck) {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() instanceof PassionFruitVineBlock
                || state.isSideSolidFullSquare(world, pos, faceToCheck);
    }

    public void dropFruit(ServerWorld world, BlockPos pos, BlockState state) {
        int count = 1 + world.random.nextInt(2);
        net.minecraft.util.ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PASSION_FRUIT, count));
    }

    /**
     * Fast Breadth-First Search (BFS) to verify if this vine is connected to Dirt or Grass.
     */
    public boolean isConnectedToRoot(BlockView world, BlockPos pos) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();

        queue.add(pos);
        visited.add(pos);

        int checkedCount = 0;
        while (!queue.isEmpty() && checkedCount < 100) {
            BlockPos current = queue.poll();
            checkedCount++;

            // Check if there is dirt or grass directly beneath the current vine block
            BlockState downState = world.getBlockState(current.down());
            if (downState.isOf(Blocks.GRASS_BLOCK) || downState.isOf(Blocks.DIRT)) {
                return true;
            }

            // Traverse adjacent connected vine blocks
            for (Direction dir : Direction.values()) {
                BlockPos neighbor = current.offset(dir);
                if (!visited.contains(neighbor)) {
                    BlockState neighborState = world.getBlockState(neighbor);
                    if (neighborState.getBlock() instanceof PassionFruitVineBlock) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return false;
    }

    private int countNearbyVines(ServerWorld world, BlockPos pos) {
        int count = 0;
        for (BlockPos nearbyPos : BlockPos.iterate(pos.add(-3, -3, -3), pos.add(3, 3, 3))) {
            if (world.getBlockState(nearbyPos).getBlock() instanceof PassionFruitVineBlock) {
                count++;
                if (count > 18) {
                    return count;
                }
            }
        }
        return count;
    }
}