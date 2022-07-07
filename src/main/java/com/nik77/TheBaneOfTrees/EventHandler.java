package com.nik77.TheBaneOfTrees;

import static com.nik77.TheBaneOfTrees.UsefulFunctions.TagContains;

import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
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
        PlayerEntity playerEntity = event.getPlayer();

        ItemStack heldItem = event.getPlayer().getMainHandItem();
        if (heldItem.getItem() instanceof AxeItem)
        {

            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(heldItem);

            if (enchantments.containsKey(ModEnchantments.BANE_OF_TREES.get()))
            {

                int enchLevel = enchantments.get(ModEnchantments.BANE_OF_TREES.get());

                BlockDestroyer blockDestroyer = new BlockDestroyer(enchLevel);

                if (TagContains(event.getWorld().getBlockState(event.getPos()).getBlock(), BlockTags.LOGS));
                {


                    blockDestroyer.BreakAll(event.getPos(), event.getWorld(), heldItem, playerEntity);

                }
            }

        }

    }



}
