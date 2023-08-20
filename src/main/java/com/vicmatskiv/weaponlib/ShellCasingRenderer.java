package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.model.*;

public class ShellCasingRenderer extends CompatibleEntityRenderer
{
    public ShellCasingRenderer() {
        super();
    }
    
    public void doCompatibleRender(final Entity entity, final double x, final double y, final double z, final float yaw, final float tick) {
        final EntityShellCasing entityShellCasing = (EntityShellCasing)entity;
        final Weapon weapon = entityShellCasing.getWeapon();
        if (weapon == null) {
            return;
        }
        final ModelBase model = weapon.getShellCasingModel();
        if (model != null) {
            final String shellCasingTextureName = weapon.getShellCasingTextureName();
            final ResourceLocation textureLocation = (shellCasingTextureName != null) ? new ResourceLocation(shellCasingTextureName) : null;
            if (model != null) {
                GL11.glPushMatrix();
                if (textureLocation != null) {
                    this.bindTexture(textureLocation);
                }
                GL11.glTranslated(x, y, z);
                final float fov = Minecraft.getMinecraft().gameSettings.fovSetting;
                final float scale = (fov * 0.001f - 0.02f) * 0.6f;
                GL11.glScalef(scale, scale, scale);
                GL11.glRotatef(entityShellCasing.getXRotation(), 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(entityShellCasing.getYRotation(), 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(entityShellCasing.getZRotation(), 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
            }
        }
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        final WeaponSpawnEntity weaponSpawnEntity = (WeaponSpawnEntity)entity;
        return new ResourceLocation(weaponSpawnEntity.getWeapon().getAmmoModelTextureName());
    }
}
