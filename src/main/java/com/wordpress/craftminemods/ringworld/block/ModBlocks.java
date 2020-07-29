package com.wordpress.craftminemods.ringworld.block;



import com.wordpress.craftminemods.ringworld.handlers.LoggingHandler;
import com.wordpress.craftminemods.ringworld.handlers.RegisterHandler;

import akka.event.Logging;
import net.minecraft.block.Block;

public class ModBlocks {
	public static int totalBlocks;
/*---------------------------------------*/
	//public static Block blockFusionite = ((BlockBase) new BlockBase("blockFusionite", Material.IRON, 3).setHardness(10).setResistance(20).setCreativeTab(Tabs.materials)).canBeBeacon(true);

/*---------------------------------------*/
	
	
	private static void registerBlocks(Block... block) {
		for (Block i : block) {
			ModBlocks.addBlock(i);
		}
	}
	public static void init() {
		ModBlocks.registerBlocks(
/**-------------------------------------**/

/**-------------------------------------**/
				);
		LoggingHandler.Log("Loaded a total of " + totalBlocks + " different blocks.");
	}
	

	private static void addBlock(Block block) {

		RegisterHandler.registerBlock(block);
		totalBlocks++;
	}
}
