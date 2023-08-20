package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class LPscope extends ModelBase
{
    ModelRenderer gun1;
    ModelRenderer gun4;
    ModelRenderer gun7;
    ModelRenderer gun9;
    ModelRenderer gun10;
    ModelRenderer gun11;
    ModelRenderer gun12;
    
    public LPscope() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.gun1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 0);
        this.gun1.setRotationPoint(-5.5f, -10.0f, 0.0f);
        this.gun1.setTextureSize(64, 32);
        this.gun1.mirror = true;
        this.setRotation(this.gun1, 0.0f, 0.0f, 0.0f);
        (this.gun4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 12, 0);
        this.gun4.setRotationPoint(0.0f, -15.5f, 0.0f);
        this.gun4.setTextureSize(64, 32);
        this.gun4.mirror = true;
        this.setRotation(this.gun4, 0.0f, 0.0f, 0.0f);
        (this.gun7 = new ModelRenderer((ModelBase)this, 0, 20)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 0);
        this.gun7.setRotationPoint(0.0f, -3.5f, 0.0f);
        this.gun7.setTextureSize(64, 32);
        this.gun7.mirror = true;
        this.setRotation(this.gun7, 0.0f, 0.0f, 0.0f);
        (this.gun9 = new ModelRenderer((ModelBase)this, 0, 20)).addBox(0.0f, 0.0f, 0.0f, 1, 20, 0);
        this.gun9.setRotationPoint(0.0f, -35.5f, 0.0f);
        this.gun9.setTextureSize(64, 32);
        this.gun9.mirror = true;
        this.setRotation(this.gun9, 0.0f, 0.0f, 0.0f);
        (this.gun10 = new ModelRenderer((ModelBase)this, 0, 20)).addBox(0.0f, 0.0f, 0.0f, 22, 1, 0);
        this.gun10.setRotationPoint(6.5f, -10.0f, 0.0f);
        this.gun10.setTextureSize(64, 32);
        this.gun10.mirror = true;
        this.setRotation(this.gun10, 0.0f, 0.0f, 0.0f);
        (this.gun11 = new ModelRenderer((ModelBase)this, 0, 20)).addBox(0.0f, 0.0f, 0.0f, 22, 1, 0);
        this.gun11.setRotationPoint(-27.5f, -10.0f, 0.0f);
        this.gun11.setTextureSize(64, 32);
        this.gun11.mirror = true;
        this.setRotation(this.gun11, 0.0f, 0.0f, 0.0f);
        (this.gun12 = new ModelRenderer((ModelBase)this, 0, 20)).addBox(0.0f, 0.0f, 0.0f, 1, 15, 0);
        this.gun12.setRotationPoint(0.0f, 1.5f, 0.0f);
        this.gun12.setTextureSize(64, 32);
        this.gun12.mirror = true;
        this.setRotation(this.gun12, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun1.render(f5);
        this.gun4.render(f5);
        this.gun7.render(f5);
        this.gun9.render(f5);
        this.gun10.render(f5);
        this.gun11.render(f5);
        this.gun12.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
