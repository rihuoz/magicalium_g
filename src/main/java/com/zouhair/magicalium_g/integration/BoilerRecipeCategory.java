package com.zouhair.magicalium_g.integration;

import com.zouhair.magicalium_g.Magicalium_g;
import com.zouhair.magicalium_g.blocks.InitBlocks;
import com.zouhair.magicalium_g.recipes.BoilerRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class BoilerRecipeCategory implements IRecipeCategory<BoilerRecipe> {
    public final ResourceLocation UID = new ResourceLocation(Magicalium_g.MOD_ID, "boiling");
    public final ResourceLocation TEXTURE =
            new ResourceLocation(Magicalium_g.MOD_ID, "textures/gui/boiler_block_gui.png");
    private final IDrawable background;
    private final IDrawable icon;

    BoilerRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(InitBlocks.BRONZE_BOILER.get()));
    }
    @Override
    public Component getTitle() {
        return new TextComponent("Boiler");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return null;
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends BoilerRecipe> getRecipeClass() {
        return BoilerRecipe.class;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BoilerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 30, 20).addIngredient(recipe.getIngredients().get(0));

    }
}
