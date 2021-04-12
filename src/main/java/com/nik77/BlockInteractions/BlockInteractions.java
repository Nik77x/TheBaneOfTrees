package com.nik77.BlockInteractions;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nik77.BlockInteractions.Setup.Registration;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("blockinteractions")
public class BlockInteractions
{
    public static final String MODID = "blockinteractions";

    public static final Logger LOGGER = LogManager.getLogger();

    public BlockInteractions()
    {

        Registration.register();

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

}