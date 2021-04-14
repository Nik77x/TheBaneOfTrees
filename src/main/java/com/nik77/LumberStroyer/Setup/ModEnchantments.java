package com.nik77.LumberStroyer.Setup;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;

import com.nik77.LumberStroyer.Enchantments.BaneOfTreesEnchant;

public class ModEnchantments
{
    public static final RegistryObject<Enchantment> BANE_OF_TREES = Registration.ENCHANTS.register("bane_of_trees", BaneOfTreesEnchant::new);

    static void register()
    {
    }
}