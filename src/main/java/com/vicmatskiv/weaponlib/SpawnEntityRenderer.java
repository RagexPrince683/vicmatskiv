package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.model.*;

public class SpawnEntityRenderer extends CompatibleEntityRenderer
{
    public SpawnEntityRenderer() {
        super();
    }
    
    public void doCompatibleRender(final Entity entity, final double x, final double y, final double z, final float yaw, final float tick) {
        final WeaponSpawnEntity weaponSpawnEntity = (WeaponSpawnEntity)entity;
        final Weapon weapon = weaponSpawnEntity.getWeapon();
        if (weapon == null) {
            return;
        }
        final ModelBase model = null;
        if (model != null) {
            final String ammoModelTextureName = weapon.getAmmoModelTextureName();
            final ResourceLocation textureLocation = (ammoModelTextureName != null) ? new ResourceLocation(ammoModelTextureName) : null;
            if (model != null) {
                GL11.glPushMatrix();
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
        final WeaponSpawnEntity weaponSpawnEntity = (WeaponSpawnEntity)entity;
        return new ResourceLocation(weaponSpawnEntity.getWeapon().getAmmoModelTextureName());
    }
}
