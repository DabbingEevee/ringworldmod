package com.wordpress.craftminemods.ringworld.potion.effects;

import java.util.ArrayList;
import java.util.List;

import com.wordpress.craftminemods.ringworld.Info;
import com.wordpress.craftminemods.ringworld.other.DamageSouces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionColdFlames extends Potion {
		private final ResourceLocation potionIcon;

		public PotionColdFlames(String name) {
			super(false, -1);
			setBeneficial();
			setRegistryName(name);
			setPotionName(name);
			potionIcon = new ResourceLocation(Info.MODID + ":textures/other/" + name + ".png");
		}

		@Override
		public boolean isInstant() {
			return false;
		}


		@Override
		public boolean shouldRenderInvText(PotionEffect effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(PotionEffect effect) {
			return true;
		}

		@Override
		public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn, int amplifier) {
		}

		@Override
		public void performEffect(EntityLivingBase entity, int amplifier) {
			if(amplifier > 0) {
				if(entity.isInWater()) {
					entity.attackEntityFrom(DamageSouces.frostFlames, amplifier + 1);
				}
				entity.attackEntityFrom(DamageSouces.frostFlames, amplifier);

			}  
			entity.setInWeb();
			entity.setFire(1);
		}

		@Override
		public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn, int amplifier) {
			super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
			if (mc.currentScreen != null) {
				mc.getTextureManager().bindTexture(potionIcon);
				Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
			mc.getTextureManager().bindTexture(potionIcon);
			Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
