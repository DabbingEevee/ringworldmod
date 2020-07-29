package com.wordpress.craftminemods.ringworld.world;

import org.apache.logging.log4j.Level;

import com.wordpress.craftminemods.ringworld.handlers.LoggingHandler;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class RingWorldDimensionInit {
	public static void init() {
		if (DimensionManager.isDimensionRegistered(RingWorldWorldProvider.DIMID)) {
			RingWorldWorldProvider.DIMID = DimensionManager.getNextFreeDimId();
			LoggingHandler.Log(Level.WARN, ("Dimension ID for dimension test is already registered. Falling back to ID: " + RingWorldWorldProvider.DIMID));
			LoggingHandler.Log(Level.WARN, ("If you are the owner of this pack please change \"Dimension ID\" to a unused value as this could cause problems"));
		}
		RingWorldWorldProvider.dtype = DimensionType.register("ringworld", "_ringworld", RingWorldWorldProvider.DIMID, RingWorldWorldProvider.class, true);
		DimensionManager.registerDimension(RingWorldWorldProvider.DIMID, RingWorldWorldProvider.dtype);
	}
}
