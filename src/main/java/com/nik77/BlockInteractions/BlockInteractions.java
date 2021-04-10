package com.nik77.BlockInteractions;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("blockinteractions")
public class BlockInteractions {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public BlockInteractions() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    ArrayList<BlockPos> blockPositions = new ArrayList<BlockPos>();

    @SubscribeEvent
    public void onBlockBroken(BlockEvent.BreakEvent event) {
        

        if (BlockTags.LOGS.getValues().contains(event.getWorld().getBlockState(event.getPos()).getBlock())) {
            blockPositions.add(event.getPos());
            HandleBreaking(event.getPos(), event.getWorld());
            BreakBlocks(event.getWorld());
        }

    }

    /*
     * @SubscribeEvent public void Tick(TickEvent event){
     * 
     * if(blockPositions.size() > 0){
     * 
     * 
     * 
     * } }
     */

    void HandleBreaking(BlockPos blockPos, IWorld world) {

       /*  Timer timer = new Timer();

        TimerTask breakTask = new TimerTask() {

            @Override
            public void run() { */

               
               
                for (int x = -1; x <= 1; x++)
                    for (int y = -1; y <= 1; y++)
                        for (int z = -1; z <= 1; z++) {

                            BlockPos newPos = blockPos.offset(x, y, z);

                            if (BlockTags.LOGS.contains(world.getBlockState(newPos).getBlock())) {
                                if (!blockPositions.contains(newPos)) {
                                    LOGGER.info("found log at " + blockPos.getX() + " " + blockPos.getY() + " "  + blockPos.getZ());

                                    blockPositions.add(newPos);

                                    HandleBreaking(newPos, world);

                                }

                               /*  timer.cancel(); */

                            }
                        }

            }

      /*   }; */

       /*  LOGGER.info("scheduling task");
        timer.schedule(breakTask, 250);
 */
   //}

    boolean Done = false;

    void BreakBlocks(IWorld world) {

        LOGGER.info("breaking blocks");
        LOGGER.info("blockPositions = " + blockPositions.toString());
     

       // while (blockPositions.isEmpty() == false) {

           // if (Done = true) {
            Timer timer = new Timer();

            TimerTask breakBlockTask = new TimerTask() {
    
                @Override
                public void run() {
    
                    Done = false;
    
                    if (!blockPositions.isEmpty()){
    
                        // get and remove block from list
                        BlockPos block = blockPositions.get(0);
                        blockPositions.remove(0);
    
                        // Destroy the block
                        LOGGER.info("breaking block");
                        world.destroyBlock(block, true);
    
                    }
                    if(blockPositions.isEmpty()){

                        timer.cancel();
        
                    }
                    Done = true;
                }
    
            };
            long delay = Math.round(Math.abs(250 / (blockPositions.size() * 0.2 )) + 25);
            LOGGER.info("delay set to " + delay);
            timer.scheduleAtFixedRate(breakBlockTask, delay, delay);


          //  }

      //  }

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    class RegistryEvents {
        @SubscribeEvent
        public void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            // LOGGER.info("HELLO from Register Block");
        }
    }
}

/*
 * @SubscribeEvent public void This(EntityItemPickupEvent event){ Vector3d
 * EntityPos = event.getEntity().getPosition(1);
 * event.getEntity().moveTo(EntityPos.x, EntityPos.y + 20, EntityPos.z) ;
 * LOGGER.info("Entity " + event.getEntity().getName().getString() +
 * "picked up " + event.getItem().getName().getString()); }
 */

// You can use EventBusSubscriber to automatically subscribe events on the
// contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
