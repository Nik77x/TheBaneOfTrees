package com.nik77.BlockInteractions.Setup;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;

import com.nik77.BlockInteractions.Enchantments.BaneOfTreesEnchant;

public class ModEnchantments
{
    public static final RegistryObject<Enchantment> BANE_OF_TREES = Registration.ENCHANTS.register("bane_of_trees", BaneOfTreesEnchant::new);

    static void register()
    {
    }
}
