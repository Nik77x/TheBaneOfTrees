package com.nik77.BlockInteractions;

import net.minecraft.tags.BlockTags;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import org.apache.logging.log4j.Logger;

import com.nik77.BlockInteractions.Functions.BlockDestroyer;

@EventBusSubscriber(modid = BlockInteractions.MODID)
public class EventHandler
{
    public static Logger LOGGER = BlockInteractions.LOGGER;

    public static BlockDestroyer blockDestroyer = new BlockDestroyer();

    @SubscribeEvent
    public static void onBlockBroken(BlockEvent.BreakEvent event)
    {


        if (BlockTags.LOGS.getValues().contains(event.getWorld().getBlockState(event.getPos()).getBlock()))
        {
            blockDestroyer.BreakAll(event.getPos(), event.getWorld());
        }

    }
}
