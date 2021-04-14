package com.nik77.LumberStroyer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nik77.LumberStroyer.Setup.Registration;

@Mod("lumberstroyer")
public class LumberStroyer
{

    public static final String MODID = "lumberstroyer";
    public static final Logger LOGGER = LogManager.getLogger();

    public LumberStroyer()
    {

        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

}