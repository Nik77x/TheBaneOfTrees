package com.nik77.TheBaneOfTrees.Functions;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class BlockDestroyer
{

    public ArrayList<BlockPos> blockPositions = new ArrayList<>();


    public long Delay;

    private final int BlockLimit;

    public int TimesToBreak = 1;

    public BlockDestroyer(int enchantmentLevel){

        this.BlockLimit = 50 * enchantmentLevel;

        this.Delay = 501 - 50L * enchantmentLevel;


    }



    public void BreakAll(BlockPos startPosition, IWorld world)
    {
        if (blockPositions.contains(startPosition))
        {
            return;
        }
        blockPositions.add(startPosition);
        SearchForBlocks(startPosition, world, BlockLimit);
        BreakBlocks(world, Delay, TimesToBreak);

    }


     /*
     region wewd destroyng
     Search recursively for wewd, if wewd is found add it to the list of blocks to break
    */

    public void SearchForBlocks(BlockPos blockPos, IWorld world, int blockLimit)
    {

        if (blockPositions.size() >= blockLimit)
        {
            return;
        }

        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++)
                for (int z = -1; z <= 1; z++)
                {

                    BlockPos newPos = blockPos.offset(x, y, z);

                    if (BlockTags.LOGS.contains(world.getBlockState(newPos).getBlock()))
                    {
                        if (!blockPositions.contains(newPos))
                        {

                            if (blockPositions.size() <= blockLimit)
                            {

                                blockPositions.add(newPos);
                                SearchForBlocks(newPos, world, blockLimit);
                            }

                            else
                                return;
                        }

                    }
                }

    }

    public void BreakBlocks(IWorld world, long delay, int TimesToBreak)
    {

        Timer timer = new Timer();

        //Random rand = new Random();

        TimerTask breakBlockTask = new TimerTask()
        {

            @Override
            public void run()
            {
                for (int i = 0; i < TimesToBreak; i++)
                {

                    if (!blockPositions.isEmpty())
                    {

                        int index = 0;  //rand.nextInt( blockPositions.size());

                        // get and remove block from list
                        BlockPos block = blockPositions.get(index);
                        blockPositions.remove(index);

                        // Destroy the block only if it's still wood
                        if (BlockTags.LOGS.contains(world.getBlockState(block).getBlock()))
                        {
                            world.destroyBlock(block, true);
                        }
                    }
                    else
                    {
                        timer.cancel();
                        return;
                    }

                }

            }

        };

        timer.scheduleAtFixedRate(breakBlockTask, delay, delay);

    }

}
