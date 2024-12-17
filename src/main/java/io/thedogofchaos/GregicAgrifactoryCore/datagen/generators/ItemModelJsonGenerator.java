package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemModelJsonGenerator extends ItemModelProvider {
    // Note to self: This will need to be built to handle ItemModel generation of seeds/harvestedItems/rawEssences at runtime.
    public ItemModelJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.MAGNETITE_SEEDS, "crops/seeds/");
        simpleItem(ModItems.MAGNETITE_HARVESTED, "crops/harvested/");
    }

    /**
     * Creates an item model.
     * @param item The {@link RegistryObject} containing the {@link Item} to generate a model for.
     * @param path A {@link String} representing the path (after {@code <modNamespace>/textures/item/}) to the item texture's location
     * @return The created model object
     */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String path) {
        return withExistingParent(
                item.getId().getPath(),
                new ResourceLocation("item/generated") // The item model will be generated here.
        ).texture("layer0",
                // The location of the texture that the item model file will point to.
                new ResourceLocation(GregicAgrifactoryCore.MOD_ID,"item/" + path + item.getId().getPath())
        );
    }
}
