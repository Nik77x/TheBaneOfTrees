package com.nik77.LumberStroyer.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class BaneOfTreesEnchant extends Enchantment
{
    public BaneOfTreesEnchant()
    {
        super(Rarity.RARE, EnchantmentType.BREAKABLE, new EquipmentSlotType[] { EquipmentSlotType.MAINHAND });
    }

    @Override
    public int getMinLevel()
    {
        return 1;
    }

    @Override
    public int getMaxLevel()
    {
        return 10;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack)
    {
        return stack.getItem() instanceof AxeItem;
    }

}
