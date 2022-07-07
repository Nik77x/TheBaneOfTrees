package com.nik77.TheBaneOfTrees.Setup;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.RegistryObject;

import com.nik77.TheBaneOfTrees.Enchantments.BaneOfTreesEnchant;

public class ModEnchantments
{
   // public static final RegistryObject<Enchantment> BANE_OF_TREES = Registration.ENCHANTS.register("bane_of_trees", BaneOfTreesEnchant::new);
    public static final RegistryObject<Enchantment> BANE_OF_TREES = Registration.ENCHANTS.register("bane_of_trees", BaneOfTreesEnchant::new);
    public static void register()
    {
    }
}
