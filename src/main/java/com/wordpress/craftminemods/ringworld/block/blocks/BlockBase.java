package com.wordpress.craftminemods.ringworld.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBase extends Block{
	
	private boolean canBeBeacon = false;
	
	public BlockBase(String itemName, Material material, int harvestLevel) {
		
		super(material);
		setUnlocalizedName(itemName.toLowerCase());
		setHarvestLevel("pickaxe", harvestLevel);
		
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return canBeBeacon;
	}
	
	public Block canBeBeacon(boolean bool) {
		this.canBeBeacon = bool;
		return this;
	}
	
	class ItemBlockBase extends ItemBlock {
		
		public ItemBlockBase(Block block) {
			super(block);
		}
		
		@Override
		public String getUnlocalizedName(ItemStack itemStack) {
			return super.getUnlocalizedName();
		}
		@Override
	    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
			
	    }
	}
	
	
	
}

