package com.nik77.TheBaneOfTrees;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nik77.TheBaneOfTrees.Setup.Registration;

@Mod("thebaneoftrees")
public class TheBaneOfTrees
{

    public static final String MODID = "thebaneoftrees";
    public static final Logger LOGGER = LogManager.getLogger();

    public TheBaneOfTrees()
    {

        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

}