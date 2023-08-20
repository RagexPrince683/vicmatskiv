package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class M14Mag extends ModelBase
{
    ModelRenderer gun1;
    ModelRenderer gun11;
    ModelRenderer gun13;
    
    public M14Mag() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.gun1 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 11, 2);
        this.gun1.setRotationPoint(1.5f, -12.9f, -6.0f);
        this.gun1.setTextureSize(64, 32);
        this.gun1.mirror = true;
        this.setRotation(this.gun1, -0.0743572f, 0.0f, 0.0f);
        (this.gun11 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 11, 2);
        this.gun11.setRotationPoint(1.0f, -13.0f, -7.0f);
        this.gun11.setTextureSize(64, 32);
        this.gun11.mirror = true;
        this.setRotation(this.gun11, -0.0743572f, 0.0f, 0.0f);
        (this.gun13 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 11, 4);
        this.gun13.setRotationPoint(1.0f, -12.8f, -4.5f);
        this.gun13.setTextureSize(64, 32);
        this.gun13.mirror = true;
        this.setRotation(this.gun13, -0.0743572f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun1.render(f5);
        this.gun11.render(f5);
        this.gun13.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
