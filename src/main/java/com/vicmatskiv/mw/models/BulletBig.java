package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class BulletBig extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    
    public BulletBig() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 8, 3);
        this.Shape1.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 8, 1);
        this.Shape3.setRotationPoint(0.5f, -2.0f, -0.2f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 8, 1);
        this.Shape4.setRotationPoint(0.5f, -2.0f, 2.2f);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 2);
        this.Shape5.setRotationPoint(-0.2f, -2.0f, 0.5f);
        this.Shape5.setTextureSize(64, 32);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 2);
        this.Shape6.setRotationPoint(2.2f, -2.0f, 0.5f);
        this.Shape6.setTextureSize(64, 32);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 3);
        this.Shape11.setRotationPoint(0.0f, 5.5f, -0.4f);
        this.Shape11.setTextureSize(64, 32);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        (this.Shape12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.Shape12.setRotationPoint(0.0f, 5.5f, 2.4f);
        this.Shape12.setTextureSize(64, 32);
        this.Shape12.mirror = true;
        this.setRotation(this.Shape12, 0.0f, 0.0f, 0.0f);
        (this.Shape13 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape13.setRotationPoint(2.4f, 5.5f, 0.0f);
        this.Shape13.setTextureSize(64, 32);
        this.Shape13.mirror = true;
        this.setRotation(this.Shape13, 0.0f, 0.0f, 0.0f);
        (this.Shape14 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape14.setRotationPoint(-0.4f, 5.5f, 0.0f);
        this.Shape14.setTextureSize(64, 32);
        this.Shape14.mirror = true;
        this.setRotation(this.Shape14, 0.0f, 0.0f, 0.0f);
        (this.Shape15 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Shape15.setRotationPoint(1.0f, -8.0f, 1.0f);
        this.Shape15.setTextureSize(64, 32);
        this.Shape15.mirror = true;
        this.setRotation(this.Shape15, 0.0f, 0.0f, 0.0f);
        (this.Shape16 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape16.setRotationPoint(2.0f, -8.0f, 1.0f);
        this.Shape16.setTextureSize(64, 32);
        this.Shape16.mirror = true;
        this.setRotation(this.Shape16, 0.0f, 0.0f, 1.301251f);
        (this.Shape17 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Shape17.setRotationPoint(1.0f, -8.0f, 1.0f);
        this.Shape17.setTextureSize(64, 32);
        this.Shape17.mirror = true;
        this.setRotation(this.Shape17, -0.2602503f, 0.0f, 0.0f);
        (this.Shape18 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Shape18.setRotationPoint(1.0f, -8.0f, 1.0f);
        this.Shape18.setTextureSize(64, 32);
        this.Shape18.mirror = true;
        this.setRotation(this.Shape18, 0.0f, 0.0f, 0.2602503f);
        (this.Shape19 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 4);
        this.Shape19.setRotationPoint(1.0f, -8.0f, 2.0f);
        this.Shape19.setTextureSize(64, 32);
        this.Shape19.mirror = true;
        this.setRotation(this.Shape19, -1.301251f, 0.0f, 0.0f);
        (this.Shape20 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 1);
        this.Shape20.setRotationPoint(0.0f, -4.2f, 1.0f);
        this.Shape20.setTextureSize(64, 32);
        this.Shape20.mirror = true;
        this.setRotation(this.Shape20, 0.0f, 0.0f, 0.0f);
        (this.Shape21 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 3);
        this.Shape21.setRotationPoint(1.0f, -4.2f, 0.0f);
        this.Shape21.setTextureSize(64, 32);
        this.Shape21.mirror = true;
        this.setRotation(this.Shape21, 0.0f, 0.0f, 0.0f);
        (this.Shape22 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 2);
        this.Shape22.setRotationPoint(0.5f, -4.2f, 0.5f);
        this.Shape22.setTextureSize(64, 32);
        this.Shape22.mirror = true;
        this.setRotation(this.Shape22, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape11.render(f5);
        this.Shape12.render(f5);
        this.Shape13.render(f5);
        this.Shape14.render(f5);
        this.Shape15.render(f5);
        this.Shape16.render(f5);
        this.Shape17.render(f5);
        this.Shape18.render(f5);
        this.Shape19.render(f5);
        this.Shape20.render(f5);
        this.Shape21.render(f5);
        this.Shape22.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
