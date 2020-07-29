package com.wordpress.craftminemods.ringworld.potion;



import com.wordpress.craftminemods.ringworld.potion.effects.PotionColdFlames;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModPotions {
	public static Potion coldflames = new PotionColdFlames("coldflames");
	
	public static void init() {
		ForgeRegistries.POTIONS.registerAll(
					coldflames
				);
		
	}
}
