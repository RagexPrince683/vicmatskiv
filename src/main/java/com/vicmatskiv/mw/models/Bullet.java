package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Bullet extends ModelBase
{
    ModelRenderer bullet;
    
    public Bullet() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.bullet = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.bullet.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bullet.setTextureSize(64, 32);
        this.bullet.mirror = true;
        this.setRotation(this.bullet, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.bullet.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
