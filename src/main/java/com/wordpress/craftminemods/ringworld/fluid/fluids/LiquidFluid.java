package com.wordpress.craftminemods.ringworld.fluid.fluids;

import java.awt.Color;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class LiquidFluid extends Fluid 
{
	public LiquidFluid(String name, ResourceLocation still, ResourceLocation flow, Color color) 
	{
		super(name, still, flow);
		this.setUnlocalizedName(name);
		this.setColor(color);
	}	
	
	public LiquidFluid(String name, ResourceLocation still, ResourceLocation flow, int color) 
	{
		super(name, still, flow);
		this.setUnlocalizedName(name);
		this.setColor(color);
	}
	
}