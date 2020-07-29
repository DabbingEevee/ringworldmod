package com.wordpress.craftminemods.ringworld.item;

import com.wordpress.craftminemods.ringworld.handlers.LoggingHandler;
import com.wordpress.craftminemods.ringworld.handlers.RegisterHandler;
import com.wordpress.craftminemods.ringworld.item.items.ItemBase;

import net.minecraft.item.Item;

public class ModItems {
	public static int totalItems;
/*---------------------------------------*/

/*---------------------------------------*/	
	
	private static void registerItems(Item... items) {
		for (Item i : items) {
			ModItems.addItem(i);
		}
	}
	public static void init() {
		ModItems.registerItems(
/**-------------------------------------**/

/**-------------------------------------**/
				);
		LoggingHandler.Log("Loaded a total of " + totalItems + " different items.");
	}
	

	private static void addItem(Item item) {
		RegisterHandler.registerItem(item);
		totalItems++;
	}
}
