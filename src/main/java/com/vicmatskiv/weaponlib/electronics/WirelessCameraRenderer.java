package com.vicmatskiv.weaponlib.electronics;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.model.*;

public class WirelessCameraRenderer extends CompatibleEntityRenderer
{
    private String modId;
    
    public WirelessCameraRenderer(final String modId) {
        super();
        this.modId = modId;
    }
    
    public void doCompatibleRender(final Entity entity, final double x, final double y, final double z, final float yaw, final float tick) {
        final EntityWirelessCamera weaponSpawnEntity = (EntityWirelessCamera)entity;
        final ItemWirelessCamera camera = weaponSpawnEntity.getItem();
        if (camera == null) {
            return;
        }
        final ModelBase model = camera.getModel();
        if (model != null) {
            final String textureName = camera.getTextureName();
            final ResourceLocation textureLocation = (textureName != null) ? new ResourceLocation(this.modId + ":textures/models/" + textureName) : null;
            if (model != null) {
                GL11.glPushMatrix();
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                if (textureLocation != null) {
                    this.bindTexture(textureLocation);
                }
                GL11.glTranslated(x, y, z);
                model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
            }
        }
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        final EntityWirelessCamera camera = (EntityWirelessCamera)entity;
        final ItemWirelessCamera item = camera.getItem();
        if (item != null) {
            return new ResourceLocation(this.modId + ":textures/models/" + item.getTextureName());
        }
        return null;
    }
}
