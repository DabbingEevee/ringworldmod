package com.wordpress.craftminemods.ringworld.fluid;


import com.wordpress.craftminemods.ringworld.handlers.RegisterHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Loader;

public class ModFluids {

	public static int totalFluids;
	/** ------------------------------------- **/
//	public static Fluid liquidFusionite = new LiquidFluid("liquidfusionite",
//			new ResourceLocation("tconmaterial:blocks/fluids/liquidfusionite_still"),
//			new ResourceLocation("tconmaterial:blocks/fluids/liquidfusionite_flowing")).setLuminosity(15)
//					.setDensity(1000).setViscosity(1000).setTemperature(1000);
	/** ------------------------------------- **/

	private static void registerFluids(Fluid... fluid) {
		for (Fluid i : fluid) {
			ModFluids.addFluid(i);
		}
	}

	public static void init() {
		ModFluids.registerFluids(
		/** ------------------------------------- **/

		/** ------------------------------------- **/
		);				
		
		
		//Description	Resource	Path	Location	Type
		//Project 'MDKExample' is missing required library: '/Users/koala/Documents/moretcon/libs/TConstruct-1.12.2-2.13.0.183.jar'	MDKExample		Build path	Build Path Problem


	}

	private static void addFluid(Fluid fluid) {

		RegisterHandler.registerFluid(fluid);
	}

}
