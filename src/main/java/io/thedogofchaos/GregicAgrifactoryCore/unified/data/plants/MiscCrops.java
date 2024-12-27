package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;
import net.minecraft.resources.ResourceLocation;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.*;
import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;

public class MiscCrops {
    public static void init() {
        Becquerellium = new Crop.Builder(id("becquerellium"))
                .setFlowerColor(0xc0ffc0)
                .setPistilColor(0x00ff00)
                .setTextures(CropTextures.NULLZONE)
                .setRequiredBiomes(id("nullzone"))
                .buildButDontRegister();
    }
}
