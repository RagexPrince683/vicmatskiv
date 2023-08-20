package com.vicmatskiv.mw;

import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;

public class CustomBlockRenderer extends TileEntitySpecialRenderer
{
    private final ModelBase model;
    private String textureName;
    
    public CustomBlockRenderer(final ModelBase model, final String textureName) {
        super();
        this.model = model;
        this.textureName = textureName;
    }
    
    public void renderTileEntityAt(final TileEntity te, final double x, final double y, final double z, final float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
        final ResourceLocation textures = new ResourceLocation("mw:textures/blocks/" + this.textureName + ".png");
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        this.model.render((Entity)null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
