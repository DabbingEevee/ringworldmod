package com.wordpress.craftminemods.ringworld.gui;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tabs {
	public static CreativeTabs ringWorld;
	
	public static void init() {
		ringWorld = (new CreativeTabs("ringworld") {
			@Override 
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem() {
				return new ItemStack(Blocks.DIRT, (int)(65));
			}
			
		});
	}

	
}
