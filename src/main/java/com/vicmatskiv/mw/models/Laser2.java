package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Laser2 extends ModelBase
{
    ModelRenderer laser1;
    ModelRenderer laser2;
    ModelRenderer laser3;
    ModelRenderer laser5;
    ModelRenderer laser6;
    ModelRenderer laser7;
    ModelRenderer laser8;
    ModelRenderer laser9;
    ModelRenderer laser10;
    ModelRenderer laser11;
    ModelRenderer laser12;
    ModelRenderer laser13;
    
    public Laser2() {
        super();
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.laser1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 5, 10);
        this.laser1.setRotationPoint(2.0f, -1.0f, 0.0f);
        this.laser1.setTextureSize(64, 32);
        this.laser1.mirror = true;
        this.setRotation(this.laser1, 0.0f, 0.0f, 0.0f);
        (this.laser2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 4);
        this.laser2.setRotationPoint(0.0f, -0.5f, 4.0f);
        this.laser2.setTextureSize(64, 32);
        this.laser2.mirror = true;
        this.setRotation(this.laser2, 0.0f, 0.0f, 0.0f);
        (this.laser3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 10);
        this.laser3.setRotationPoint(2.5f, -1.5f, 0.0f);
        this.laser3.setTextureSize(64, 32);
        this.laser3.mirror = true;
        this.setRotation(this.laser3, 0.0f, 0.0f, 0.0f);
        (this.laser5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.laser5.setRotationPoint(4.0f, -1.5f, 3.0f);
        this.laser5.setTextureSize(64, 32);
        this.laser5.mirror = true;
        this.setRotation(this.laser5, 0.0f, 0.0f, 0.0f);
        (this.laser6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.laser6.setRotationPoint(4.3f, 1.0f, 7.0f);
        this.laser6.setTextureSize(64, 32);
        this.laser6.mirror = true;
        this.setRotation(this.laser6, 0.0f, 0.0f, 0.0f);
        (this.laser7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.laser7.setRotationPoint(4.3f, -0.5f, 4.0f);
        this.laser7.setTextureSize(64, 32);
        this.laser7.mirror = true;
        this.setRotation(this.laser7, 0.0f, 0.0f, 0.0f);
        (this.laser8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 12);
        this.laser8.setRotationPoint(2.5f, -1.0f, -1.5f);
        this.laser8.setTextureSize(64, 32);
        this.laser8.mirror = true;
        this.setRotation(this.laser8, 0.0f, 0.0f, 0.0f);
        (this.laser9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 12);
        this.laser9.setRotationPoint(3.0f, 0.3f, -1.5f);
        this.laser9.setTextureSize(64, 32);
        this.laser9.mirror = true;
        this.setRotation(this.laser9, 0.0f, 0.0f, 0.0f);
        (this.laser10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 12);
        this.laser10.setRotationPoint(3.0f, -1.3f, -1.5f);
        this.laser10.setTextureSize(64, 32);
        this.laser10.mirror = true;
        this.setRotation(this.laser10, 0.0f, 0.0f, 0.0f);
        (this.laser11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 12);
        this.laser11.setRotationPoint(2.2f, -0.5f, -1.5f);
        this.laser11.setTextureSize(64, 32);
        this.laser11.mirror = true;
        this.setRotation(this.laser11, 0.0f, 0.0f, 0.0f);
        (this.laser12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 12);
        this.laser12.setRotationPoint(3.8f, -0.5f, -1.5f);
        this.laser12.setTextureSize(64, 32);
        this.laser12.mirror = true;
        this.setRotation(this.laser12, 0.0f, 0.0f, 0.0f);
        (this.laser13 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.laser13.setRotationPoint(4.5f, 2.5f, -1.0f);
        this.laser13.setTextureSize(64, 32);
        this.laser13.mirror = true;
        this.setRotation(this.laser13, 0.0f, 0.0f, 2.528146f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.laser1.render(f5);
        this.laser2.render(f5);
        this.laser3.render(f5);
        this.laser5.render(f5);
        this.laser6.render(f5);
        this.laser7.render(f5);
        this.laser8.render(f5);
        this.laser9.render(f5);
        this.laser10.render(f5);
        this.laser11.render(f5);
        this.laser12.render(f5);
        this.laser13.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
