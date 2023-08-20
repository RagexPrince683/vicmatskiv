package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class PSO12 extends ModelBase
{
    ModelRenderer Scope1;
    ModelRenderer Scope2;
    ModelRenderer Scope3;
    ModelRenderer Scope4;
    ModelRenderer Scope5;
    ModelRenderer Scope6;
    ModelRenderer Scope7;
    ModelRenderer Scope8;
    ModelRenderer Scope9;
    ModelRenderer Scope10;
    ModelRenderer Scope11;
    ModelRenderer Scope12;
    
    public PSO12() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Scope1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Scope1.setRotationPoint(0.5f, -2.0f, 0.0f);
        this.Scope1.setTextureSize(64, 32);
        this.Scope1.mirror = true;
        this.setRotation(this.Scope1, 0.0f, 0.0f, 0.0f);
        (this.Scope2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Scope2.setRotationPoint(0.5f, 3.0f, 0.0f);
        this.Scope2.setTextureSize(64, 32);
        this.Scope2.mirror = true;
        this.setRotation(this.Scope2, 0.0f, 0.0f, 0.0f);
        (this.Scope3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Scope3.setRotationPoint(3.0f, 0.5f, 0.0f);
        this.Scope3.setTextureSize(64, 32);
        this.Scope3.mirror = true;
        this.setRotation(this.Scope3, 0.0f, 0.0f, 0.0f);
        (this.Scope4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Scope4.setRotationPoint(-2.0f, 0.5f, 0.0f);
        this.Scope4.setTextureSize(64, 32);
        this.Scope4.mirror = true;
        this.setRotation(this.Scope4, 0.0f, 0.0f, 0.0f);
        (this.Scope5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.Scope5.setRotationPoint(1.5f, -2.0f, 0.0f);
        this.Scope5.setTextureSize(64, 32);
        this.Scope5.mirror = true;
        this.setRotation(this.Scope5, 0.0f, 0.0f, 0.5205006f);
        (this.Scope6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Scope6.setRotationPoint(4.0f, 0.5f, 0.0f);
        this.Scope6.setTextureSize(64, 32);
        this.Scope6.mirror = true;
        this.setRotation(this.Scope6, 0.0f, 0.0f, 2.639681f);
        (this.Scope7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Scope7.setRotationPoint(0.5f, -2.0f, 0.0f);
        this.Scope7.setTextureSize(64, 32);
        this.Scope7.mirror = true;
        this.setRotation(this.Scope7, 0.0f, 0.0f, 1.041001f);
        (this.Scope8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.Scope8.setRotationPoint(-2.0f, 0.5f, 0.0f);
        this.Scope8.setTextureSize(64, 32);
        this.Scope8.mirror = true;
        this.setRotation(this.Scope8, 0.0f, 0.0f, -1.041001f);
        (this.Scope9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Scope9.setRotationPoint(1.5f, 4.0f, 0.0f);
        this.Scope9.setTextureSize(64, 32);
        this.Scope9.mirror = true;
        this.setRotation(this.Scope9, 0.0f, 0.0f, -2.156359f);
        (this.Scope10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.Scope10.setRotationPoint(4.0f, 1.5f, 0.0f);
        this.Scope10.setTextureSize(64, 32);
        this.Scope10.mirror = true;
        this.setRotation(this.Scope10, 0.0f, 0.0f, 2.156359f);
        (this.Scope11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Scope11.setRotationPoint(-2.0f, 1.5f, 0.0f);
        this.Scope11.setTextureSize(64, 32);
        this.Scope11.mirror = true;
        this.setRotation(this.Scope11, 0.0f, 0.0f, -0.5948578f);
        (this.Scope12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.Scope12.setRotationPoint(0.5f, 4.0f, 0.0f);
        this.Scope12.setTextureSize(64, 32);
        this.Scope12.mirror = true;
        this.setRotation(this.Scope12, 0.0f, 0.0f, -2.565324f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Scope1.render(f5);
        this.Scope2.render(f5);
        this.Scope3.render(f5);
        this.Scope4.render(f5);
        this.Scope5.render(f5);
        this.Scope6.render(f5);
        this.Scope7.render(f5);
        this.Scope8.render(f5);
        this.Scope9.render(f5);
        this.Scope10.render(f5);
        this.Scope11.render(f5);
        this.Scope12.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
