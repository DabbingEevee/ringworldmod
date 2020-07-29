package com.wordpress.craftminemods.ringworld.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRadiation extends BlockBase{
	
	public BlockRadiation(String itemName, Material material, int harvestLevel) {
		
		super(itemName, material, harvestLevel);
	}
	
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
    }
    
/*	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn){
		if(entityIn instanceof EntityLivingBase) {
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 30, 4, false, true));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.GLOWING, 30, 0, false, true));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 30, 0, false, true));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 30, 2, false, true));
		}
    }*/
	@Override 
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if(entityIn instanceof EntityLivingBase) {
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 30, 4, false, true));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.GLOWING, 30, 0, false, true));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 30, 0, false, true));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 30, 2, false, true));
		}
	}
	
	class ItemBlockBase extends ItemBlock {
		
		public ItemBlockBase(Block block) {
			super(block);
		}
		
		@Override
		public String getUnlocalizedName(ItemStack itemStack) {
			return super.getUnlocalizedName();
		}
	}
	
}

