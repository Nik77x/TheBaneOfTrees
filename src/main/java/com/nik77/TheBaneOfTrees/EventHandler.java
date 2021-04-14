package com.nik77.TheBaneOfTrees;

import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import com.nik77.TheBaneOfTrees.Functions.BlockDestroyer;
import com.nik77.TheBaneOfTrees.Setup.ModEnchantments;

@EventBusSubscriber(modid = TheBaneOfTrees.MODID)
public class EventHandler
{

    @SubscribeEvent
    public static void onBlockBroken(BlockEvent.BreakEvent event)
    {

        ItemStack heldItem = event.getPlayer().getMainHandItem();
        if (heldItem.getItem() instanceof AxeItem)
        {

            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(heldItem);

            if (enchantments.containsKey(ModEnchantments.BANE_OF_TREES.get()))
            {

                int enchLevel = enchantments.get(ModEnchantments.BANE_OF_TREES.get());

                BlockDestroyer blockDestroyer = new BlockDestroyer(enchLevel);

                if (BlockTags.LOGS.getValues().contains(event.getWorld().getBlockState(event.getPos()).getBlock()))
                {
                    blockDestroyer.BreakAll(event.getPos(), event.getWorld());

                }
            }

        }

    }

}
