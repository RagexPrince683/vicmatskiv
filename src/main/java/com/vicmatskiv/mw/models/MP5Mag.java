package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class MP5Mag extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    
    public MP5Mag() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 7);
        this.Shape1.setRotationPoint(1.0f, -11.0f, 1.5f);
        this.Shape1.setTextureSize(128, 64);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, -1.747395f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 7);
        this.Shape2.setRotationPoint(1.0f, -11.1f, 1.1f);
        this.Shape2.setTextureSize(128, 64);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, -1.747395f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 7);
        this.Shape3.setRotationPoint(1.5f, -11.3f, 0.3f);
        this.Shape3.setTextureSize(128, 64);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, -1.747395f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 7);
        this.Shape4.setRotationPoint(1.0f, -11.5f, -0.5f);
        this.Shape4.setTextureSize(128, 64);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, -1.747395f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 8);
        this.Shape5.setRotationPoint(1.0f, -4.5f, 0.5f);
        this.Shape5.setTextureSize(128, 64);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, -2.082002f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 8);
        this.Shape6.setRotationPoint(1.0f, -4.7f, 0.0f);
        this.Shape6.setTextureSize(128, 64);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, -2.082002f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 8);
        this.Shape7.setRotationPoint(1.5f, -5.0f, -0.7f);
        this.Shape7.setTextureSize(128, 64);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, -2.082002f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 8);
        this.Shape8.setRotationPoint(1.0f, -5.3f, -1.5f);
        this.Shape8.setTextureSize(128, 64);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, -2.082002f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
        this.Shape8.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
