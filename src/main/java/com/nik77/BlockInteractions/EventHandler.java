package com.nik77.BlockInteractions;

import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import com.nik77.BlockInteractions.Functions.BlockDestroyer;
import com.nik77.BlockInteractions.Setup.ModEnchantments;

@EventBusSubscriber(modid = BlockInteractions.MODID)
public class EventHandler
{
    //public static Logger LOGGER = BlockInteractions.LOGGER;

    public static BlockDestroyer blockDestroyer = new BlockDestroyer();

    @SubscribeEvent
    public static void onBlockBroken(BlockEvent.BreakEvent event)
    {
        long delay;
        int enchLevel;
        int blockLimit;
        int timesToBreak;


        ItemStack heldItem = event.getPlayer().getMainHandItem();
        if (heldItem.getItem() instanceof AxeItem)
        {

            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(heldItem);

            if (enchantments.get(ModEnchantments.BANE_OF_TREES.get()) != null)
            {

                enchLevel = enchantments.get(ModEnchantments.BANE_OF_TREES.get());

                timesToBreak = 1;

                blockLimit = 50 * enchLevel;

                delay = (long) 501 - 50L * enchLevel;
                if (BlockTags.LOGS.getValues().contains(event.getWorld().getBlockState(event.getPos()).getBlock()))
                {
                    blockDestroyer.BreakAll(event.getPos(), event.getWorld(), delay, timesToBreak, blockLimit);

                }
            }

        }



    }

}
