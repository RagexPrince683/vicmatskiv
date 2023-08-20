package com.vicmatskiv.weaponlib.grenade;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.model.*;

public class EntityGrenadeRenderer extends CompatibleEntityRenderer
{
    public EntityGrenadeRenderer() {
        super();
    }
    
    public void doCompatibleRender(final Entity entity, final double x, final double y, final double z, final float yaw, final float tick) {
        final AbstractEntityGrenade entityGrenade = (AbstractEntityGrenade)entity;
        final ItemGrenade itemGrenade = entityGrenade.getItemGrenade();
        if (itemGrenade == null) {
            return;
        }
        final GrenadeRenderer renderer = itemGrenade.getRenderer();
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(renderer.getClientModContext().getModId(), "textures/models/" + itemGrenade.getTextureName()));
        final ModelBase model = renderer.getModel();
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        final float rotationOffsetX = renderer.getXRotationCenterOffset().get();
        final float rotationOffsetY = renderer.getYRotationCenterOffset().get();
        final float rotationOffsetZ = renderer.getZRotationCenterOffset().get();
        GL11.glTranslatef(rotationOffsetX, rotationOffsetY, rotationOffsetZ);
        GL11.glRotatef(entityGrenade.getXRotation(), 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(entityGrenade.getYRotation(), 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(entityGrenade.getZRotation(), 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-rotationOffsetX, -rotationOffsetY, -rotationOffsetZ);
        renderer.getThrownEntityPositioning().run();
        model.render(entity, 0.0f, 0.3f, 0.0f, 0.0f, 0.0f, 0.08f);
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return null;
    }
}
