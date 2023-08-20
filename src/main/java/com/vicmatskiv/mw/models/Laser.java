package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Laser extends ModelBase
{
    ModelRenderer laser1;
    ModelRenderer laser2;
    ModelRenderer laser3;
    ModelRenderer laser4;
    ModelRenderer laser5;
    ModelRenderer laser6;
    ModelRenderer laser7;
    ModelRenderer laser8;
    ModelRenderer laser9;
    ModelRenderer laser11;
    
    public Laser() {
        super();
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.laser1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 10);
        this.laser1.setRotationPoint(2.0f, 0.0f, 0.0f);
        this.laser1.setTextureSize(64, 32);
        this.laser1.mirror = true;
        this.setRotation(this.laser1, 0.0f, 0.0f, 0.0f);
        (this.laser2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 10);
        this.laser2.setRotationPoint(2.5f, -0.3f, 0.0f);
        this.laser2.setTextureSize(64, 32);
        this.laser2.mirror = true;
        this.setRotation(this.laser2, 0.0f, 0.0f, 0.0f);
        (this.laser3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 10);
        this.laser3.setRotationPoint(4.3f, 0.5f, 0.0f);
        this.laser3.setTextureSize(64, 32);
        this.laser3.mirror = true;
        this.setRotation(this.laser3, 0.0f, 0.0f, 0.0f);
        (this.laser4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 10);
        this.laser4.setRotationPoint(2.5f, 2.3f, 0.0f);
        this.laser4.setTextureSize(64, 32);
        this.laser4.mirror = true;
        this.setRotation(this.laser4, 0.0f, 0.0f, 0.0f);
        (this.laser5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 4);
        this.laser5.setRotationPoint(5.3f, 0.5f, 4.0f);
        this.laser5.setTextureSize(64, 32);
        this.laser5.mirror = true;
        this.setRotation(this.laser5, 0.0f, 0.0f, 0.0f);
        (this.laser6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 4);
        this.laser6.setRotationPoint(2.5f, -1.3f, 4.0f);
        this.laser6.setTextureSize(64, 32);
        this.laser6.mirror = true;
        this.setRotation(this.laser6, 0.0f, 0.0f, 0.0f);
        (this.laser7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 4);
        this.laser7.setRotationPoint(2.5f, 3.3f, 4.0f);
        this.laser7.setTextureSize(64, 32);
        this.laser7.mirror = true;
        this.setRotation(this.laser7, 0.0f, 0.0f, 0.0f);
        (this.laser8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 4);
        this.laser8.setRotationPoint(5.8f, 0.5f, 4.0f);
        this.laser8.setTextureSize(64, 32);
        this.laser8.mirror = true;
        this.setRotation(this.laser8, 0.0f, 0.0f, 2.379431f);
        (this.laser9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 4);
        this.laser9.setRotationPoint(5.8f, 2.5f, 4.0f);
        this.laser9.setTextureSize(64, 32);
        this.laser9.mirror = true;
        this.setRotation(this.laser9, 0.0f, 0.0f, 2.379431f);
        (this.laser11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 4);
        this.laser11.setRotationPoint(0.0f, -0.5f, 4.0f);
        this.laser11.setTextureSize(64, 32);
        this.laser11.mirror = true;
        this.setRotation(this.laser11, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.laser1.render(f5);
        this.laser2.render(f5);
        this.laser3.render(f5);
        this.laser4.render(f5);
        this.laser5.render(f5);
        this.laser6.render(f5);
        this.laser7.render(f5);
        this.laser8.render(f5);
        this.laser9.render(f5);
        this.laser11.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
