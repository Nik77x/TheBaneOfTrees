package com.nik77.TheBaneOfTrees.Setup;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;

import com.nik77.TheBaneOfTrees.Enchantments.BaneOfTreesEnchant;
import com.nik77.TheBaneOfTrees.Setup.Registration;

public class ModEnchantments
{
    public static final RegistryObject<Enchantment> BANE_OF_TREES = Registration.ENCHANTS.register("bane_of_trees", BaneOfTreesEnchant::new);

    public static void register()
    {
    }
}
