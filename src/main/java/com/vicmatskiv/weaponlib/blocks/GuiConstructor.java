package com.vicmatskiv.weaponlib.blocks;

import net.minecraft.client.gui.inventory.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;

@SideOnly(Side.CLIENT)
public class GuiConstructor extends GuiContainer
{
    public ContainerConstructor container;
    private final String blockName;
    
    public GuiConstructor(final InventoryPlayer playerInventory, final World parWorld, final String parBlockName, final int parX, final int parY, final int parZ) {
        super((Container)new ContainerConstructor(playerInventory, parWorld, parX, parY, parZ));
        this.container = (ContainerConstructor)this.inventorySlots;
        this.blockName = parBlockName;
    }
    
    public void actionPerformed(final GuiButton button) {
    }
    
    public void drawScreen(final int par1, final int par2, final float par3) {
        super.drawScreen(par1, par2, par3);
    }
    
    protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
        GL11.glDisable(2896);
        this.fontRendererObj.drawString(this.blockName, this.xSize / 2 - this.fontRendererObj.getStringWidth(this.blockName) / 2 + 1, 5, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 6, this.ySize - 96 + 2, 4210752);
        final String string = this.container.resultString;
        if (string != null) {
            final ContainerConstructor.State msgType = this.container.deconstructingState;
            EnumChatFormatting format = EnumChatFormatting.GREEN;
            EnumChatFormatting shadowFormat = EnumChatFormatting.DARK_GRAY;
            if (msgType == ContainerConstructor.State.ERROR) {
                format = EnumChatFormatting.WHITE;
                shadowFormat = EnumChatFormatting.DARK_RED;
            }
            this.fontRendererObj.drawString(shadowFormat + string + EnumChatFormatting.RESET, 7, this.ySize - 95 + 2 - this.fontRendererObj.FONT_HEIGHT, 0);
            this.fontRendererObj.drawString(format + string + EnumChatFormatting.RESET, 6, this.ySize - 96 + 2 - this.fontRendererObj.FONT_HEIGHT, 0);
        }
        GL11.glEnable(2896);
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
        GL11.glPushMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(new ResourceLocation("blocksmith:textures/gui/container/deconstructor.png"));
        final int k = this.width / 2 - this.xSize / 2;
        final int l = this.height / 2 - this.ySize / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        GL11.glPopMatrix();
    }
}
