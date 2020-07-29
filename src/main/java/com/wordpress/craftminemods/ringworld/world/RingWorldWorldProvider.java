package com.wordpress.craftminemods.ringworld.world;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RingWorldWorldProvider extends WorldProvider {
	
	public static int DIMID = 3;
	public static final boolean NETHER_TYPE = false;
	public static DimensionType dtype;
	
	@Override
	public void init() {
		this.biomeProvider = new RingWorldBiomeProvider(this.world.getSeed());
		this.nether = NETHER_TYPE;
		this.hasSkyLight = true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public net.minecraft.client.audio.MusicTicker.MusicType getMusicType() {
		return EnumHelperClient.addMusicType("block.anvil.fall",
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(("block.anvil.fall"))),
				6000, 24000);
	}

	@Override
	public DimensionType getDimensionType() {
		return dtype;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float par1, float par2) {
		return new Vec3d(1.0000000000f, 0.8f, 0.8f);
	}
	@Override
	@SideOnly(Side.CLIENT)
    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        int i = (int)(6000 % 24000L);
        float f = ((float)i + 0) / 24000.0F - 0.25F;

        if (f < 0.0F)
        {
            ++f;
        }

        if (f > 1.0F)
        {
            --f;
        }

        float f1 = 1.0F - (float)((Math.cos((double)f * Math.PI) + 1.0D) / 2.0D);
        f = f + (f1 - f) / 3.0F;
        return f;
    }
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new RingWorldChunkProvider(this.world, this.world.getSeed() - DIMID);
	}

	@Override
	public Vec3d getSkyColor(net.minecraft.entity.Entity cameraEntity, float partialTicks)
    {
        return this.getFogColor(0,0);
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public net.minecraftforge.client.IRenderHandler getSkyRenderer()
    {
        return new RingWorldSkyProvider();
    }	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean doesXZShowFog(int par1, int par2) {
		return false;
	}

	@Override
	public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
		return WorldSleepResult.ALLOW;
	}

	@Override
	public boolean doesWaterVaporize() {
		return true;
	}

	@Override
	public void onPlayerAdded(EntityPlayerMP entity) {

	}

	@Override
	public void onPlayerRemoved(EntityPlayerMP entity) {

	}
}
