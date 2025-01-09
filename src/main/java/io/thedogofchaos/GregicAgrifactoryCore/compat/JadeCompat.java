package io.thedogofchaos.GregicAgrifactoryCore.compat;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.ICropProvider;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;

import java.util.Set;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;

/**
 * Primary Jade Compat for the coremod.
 */
@WailaPlugin
public class JadeCompat implements IWailaPlugin {
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(new CropComponentProvider(), OreCropBlock.class);
    }

    @Override
    public void register(IWailaCommonRegistration registration) {

    }

    private static class CropComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {

        @Override
        public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
            Block block = blockAccessor.getBlock();
            Crop crop = ((ICropProvider) block).getCrop();
            Set<ResourceLocation> biomes = crop.getCropInfo().getRequiredBiomes();
            Level level = blockAccessor.getLevel();
            BlockPos pos = blockAccessor.getPosition();
            if (!biomes.isEmpty()) {
                var biome = level.getBiome(pos);
                if (biomes.stream().noneMatch(biome::is)) {
                    iTooltip.remove(Identifiers.MC_CROP_PROGRESS);
                    iTooltip.add(Component.translatable("tooltip." + GregicAgrifactoryCore.MOD_ID + ".invalid_biome").withStyle(ChatFormatting.RED));
                }
            }
        }

        @Override
        public ResourceLocation getUid() {
            return id("crop");
        }

        @Override
        public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {

        }
    }
}