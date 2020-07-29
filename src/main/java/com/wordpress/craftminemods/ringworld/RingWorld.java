package com.wordpress.craftminemods.ringworld;

import org.apache.logging.log4j.Logger;

import com.wordpress.craftminemods.ringworld.block.ModBlocks;
import com.wordpress.craftminemods.ringworld.fluid.ModFluids;
import com.wordpress.craftminemods.ringworld.gui.Tabs;
import com.wordpress.craftminemods.ringworld.item.ModItems;
import com.wordpress.craftminemods.ringworld.other.OreDict;
import com.wordpress.craftminemods.ringworld.potion.ModPotions;
import com.wordpress.craftminemods.ringworld.world.RingWorldDimensionInit;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Info.MODID, name = Info.NAME, version = Info.VERSION, dependencies = Info.DEPENDENCIES)
public class RingWorld
{

    private static Logger logger;
    
    static {FluidRegistry.enableUniversalBucket();}
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Tabs.init();
    	ModFluids.init();
    	ModBlocks.init();
    	ModItems.init();
    	ModPotions.init();
    	OreDict.init();
    	RingWorldDimensionInit.init();
    	
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
