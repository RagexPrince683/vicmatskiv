package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class MP40Mag extends ModelBase
{
    ModelRenderer gun102;
    ModelRenderer gun103;
    
    public MP40Mag() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.gun102 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 20, 4);
        this.gun102.setRotationPoint(1.2f, -9.0f, -19.5f);
        this.gun102.setTextureSize(64, 32);
        this.gun102.mirror = true;
        this.setRotation(this.gun102, 0.0f, 0.0f, 0.0f);
        (this.gun103 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 20, 4);
        this.gun103.setRotationPoint(1.8f, -9.0f, -19.5f);
        this.gun103.setTextureSize(64, 32);
        this.gun103.mirror = true;
        this.setRotation(this.gun103, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun102.render(f5);
        this.gun103.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
