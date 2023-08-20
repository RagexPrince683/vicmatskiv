package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ShotgunShell extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    
    public ShotgunShell() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 3);
        this.Shape1.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.Shape2.setRotationPoint(0.0f, 1.0f, 0.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 1);
        this.Shape3.setRotationPoint(0.5f, -5.0f, -0.2f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 1);
        this.Shape4.setRotationPoint(0.5f, -5.0f, 2.2f);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 2);
        this.Shape5.setRotationPoint(-0.2f, -5.0f, 0.5f);
        this.Shape5.setTextureSize(64, 32);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 2);
        this.Shape6.setRotationPoint(2.2f, -5.0f, 0.5f);
        this.Shape6.setTextureSize(64, 32);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.Shape7.setRotationPoint(2.2f, 1.0f, 0.5f);
        this.Shape7.setTextureSize(64, 32);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 1);
        this.Shape8.setRotationPoint(0.5f, 1.0f, 2.2f);
        this.Shape8.setTextureSize(64, 32);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
        (this.Shape9 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.Shape9.setRotationPoint(-0.2f, 1.0f, 0.5f);
        this.Shape9.setTextureSize(64, 32);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, 0.0f, 0.0f, 0.0f);
        (this.Shape10 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 1);
        this.Shape10.setRotationPoint(0.5f, 1.0f, -0.2f);
        this.Shape10.setTextureSize(64, 32);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.Shape11.setRotationPoint(0.0f, 3.5f, -0.4f);
        this.Shape11.setTextureSize(64, 32);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        (this.Shape12 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.Shape12.setRotationPoint(0.0f, 3.5f, 2.4f);
        this.Shape12.setTextureSize(64, 32);
        this.Shape12.mirror = true;
        this.setRotation(this.Shape12, 0.0f, 0.0f, 0.0f);
        (this.Shape13 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape13.setRotationPoint(2.4f, 3.5f, 0.0f);
        this.Shape13.setTextureSize(64, 32);
        this.Shape13.mirror = true;
        this.setRotation(this.Shape13, 0.0f, 0.0f, 0.0f);
        (this.Shape14 = new ModelRenderer((ModelBase)this, 20, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape14.setRotationPoint(-0.4f, 3.5f, 0.0f);
        this.Shape14.setTextureSize(64, 32);
        this.Shape14.mirror = true;
        this.setRotation(this.Shape14, 0.0f, 0.0f, 0.0f);
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
        this.Shape9.render(f5);
        this.Shape10.render(f5);
        this.Shape11.render(f5);
        this.Shape12.render(f5);
        this.Shape13.render(f5);
        this.Shape14.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
