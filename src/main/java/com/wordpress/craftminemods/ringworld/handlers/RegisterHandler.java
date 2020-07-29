package com.wordpress.craftminemods.ringworld.handlers;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.wordpress.craftminemods.ringworld.Info;
import com.wordpress.craftminemods.ringworld.gui.Tabs;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class RegisterHandler {

	public static void registerBlock(Block block) {
		RegisterHandler.registerBlock(block, ItemBlock::new);
	}

	public static void registerBlock(Block block, @Nullable Function<Block, ItemBlock> itemBlock) {
		String name = block.getUnlocalizedName().substring(5);
		ForgeRegistries.BLOCKS.register(block.setRegistryName(name));

		if (itemBlock != null) {
			ForgeRegistries.ITEMS.register(itemBlock.apply(block).setRegistryName(block.getRegistryName()));
			try {
				registerBlockModel(block);
			} catch (NoSuchMethodError e) {
				return;
			}
			if(block instanceof BlockFluidClassic) {
				RenderHandler.registerCustomMeshesAndStates(block);
			}
		}

	}

	public static void registerItem(Item item) {
		String name = item.getUnlocalizedName().substring(5);
		item.setCreativeTab(Tabs.ringWorld);
		item.setRegistryName(name);
		ForgeRegistries.ITEMS.register(item);
		try {
			registerItemModel(item);
		} catch (NoSuchMethodError e) {
			return;
		}
	}

	public static void registerBiome(Biome biome) {
		ForgeRegistries.BIOMES.register(biome);
	}

	@SideOnly(Side.CLIENT)
	public static void registerItemModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(
				Info.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

	@SideOnly(Side.CLIENT)
	public static void registerBlockModel(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(
				Info.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}

	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

}
