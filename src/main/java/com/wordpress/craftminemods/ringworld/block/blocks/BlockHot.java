package com.wordpress.craftminemods.ringworld.block.blocks;

import java.awt.Color;


import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHot extends BlockBase{
	
	public BlockHot(String itemName, Material material, int harvestLevel) {
		
		super(itemName, material, harvestLevel);
        
		this.setTickRandomly(true);
	}
	@Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
        {
            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 4.0F);
        } else if ((!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))) {
            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
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

