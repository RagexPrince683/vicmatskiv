package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Grenade extends ModelBase
{
    ModelRenderer Grenade1;
    ModelRenderer Grenade2;
    
    public Grenade() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Grenade1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 5);
        this.Grenade1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Grenade1.setTextureSize(64, 32);
        this.Grenade1.mirror = true;
        this.setRotation(this.Grenade1, 0.0f, 0.0f, 0.0f);
        (this.Grenade2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.Grenade2.setRotationPoint(0.5f, 0.5f, -1.0f);
        this.Grenade2.setTextureSize(64, 32);
        this.Grenade2.mirror = true;
        this.setRotation(this.Grenade2, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Grenade1.render(f5);
        this.Grenade2.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
