package com.nik77.TheBaneOfTrees;

import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class UsefulFunctions
{


    public static boolean TagContains(Block block, TagKey<Block> tag){

        // This is so stupid .contains() was soo good why did they remove it!? *angry noises*
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK
                        .getResourceKey(block).get())
                .is(BlockTags.LOGS);

    }

}
