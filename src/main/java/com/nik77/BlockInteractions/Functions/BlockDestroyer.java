package com.nik77.BlockInteractions.Functions;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import org.apache.logging.log4j.Logger;

import com.nik77.BlockInteractions.BlockInteractions;

public class BlockDestroyer
{
    public static int  RecursionLimit = 4200;
    public static int RecursionLevel = 0;

    public ArrayList<BlockPos> blockPositions = new ArrayList<>();

    Logger LOGGER = BlockInteractions.LOGGER;

    public void BreakAll(BlockPos startPosition, IWorld world)
    {
        if(blockPositions.contains(startPosition)){
            return;
        }
        blockPositions.add(startPosition);
        SearchForBlocks(startPosition, world);
        BreakBlocks(world);

    }


     /*
     region wewd destroyng
     Search recursively for wewd, if wewd is found add it to the list of blocks to break
    */

    public void SearchForBlocks(BlockPos blockPos, IWorld world)
    {
       /* if(RecursionLevel >= RecursionLimit){
            RecursionLevel = 0;
            return;
        }else
        RecursionLevel++;*/

        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++)
                for (int z = -1; z <= 1; z++)
                {

                    BlockPos newPos = blockPos.offset(x, y, z);

                    if (BlockTags.LOGS.contains(world.getBlockState(newPos).getBlock()))
                    {
                        if (!blockPositions.contains(newPos))
                        {
                            //LOGGER.info("found log at " + blockPos.getX() + " " + blockPos.getY() + " " + blockPos.getZ());

                            blockPositions.add(newPos);
                            //LOGGER.info("searching blocks");
                            SearchForBlocks(newPos, world);

                        }

                    }
                }

    }

    public void BreakBlocks(IWorld world)
    {

        //LOGGER.info("breaking blocks");
        //LOGGER.info("blockPositions = " + blockPositions.toString());

        Timer timer = new Timer();
        Random rand = new Random();

        TimerTask breakBlockTask = new TimerTask()
        {

            @Override
            public void run()
            {
                try{

                    if (!blockPositions.isEmpty())
                    {

                        // get and remove block from list
                        int index = 0;//rand.nextInt( blockPositions.size());

                        BlockPos block = blockPositions.get(index);
                        blockPositions.remove(index);

                        // Destroy the block only if it's still wood
                        //LOGGER.info("breaking block");
                        if (BlockTags.LOGS.contains(world.getBlockState(block).getBlock()))
                        {
                            world.destroyBlock(block, true);
                        }



                    }
                    else
                    {
                        timer.cancel();
                    }
                }catch (IndexOutOfBoundsException e){LOGGER.error("index out of bounds " + e.getCause());}
                catch (IllegalStateException e){LOGGER.error("timer rai into an illegal state what th fuck " + e.getCause() + e.getMessage());}

            }

        };
        //long delay = Math.round(Math.abs(250 / (blockPositions.size() * 0.2)) + 40);
        LOGGER.info("scheduling timer");
        timer.scheduleAtFixedRate(breakBlockTask, 40, 40);

    }

}
