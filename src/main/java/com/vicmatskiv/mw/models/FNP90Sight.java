package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class FNP90Sight extends ModelBase
{
    ModelRenderer Sight1;
    ModelRenderer Sight2;
    ModelRenderer Sight3;
    ModelRenderer Sight4;
    ModelRenderer Sight5;
    ModelRenderer Sight6;
    ModelRenderer Sight7;
    ModelRenderer Sight8;
    ModelRenderer Sight9;
    ModelRenderer Sight10;
    ModelRenderer Sight11;
    
    public FNP90Sight() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 32;
        (this.Sight1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 1, 14);
        this.Sight1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Sight1.setTextureSize(128, 32);
        this.Sight1.mirror = true;
        this.setRotation(this.Sight1, 0.0f, 0.0f, 0.0f);
        (this.Sight2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 14);
        this.Sight2.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.Sight2.setTextureSize(128, 32);
        this.Sight2.mirror = true;
        this.setRotation(this.Sight2, 0.0f, 0.0f, 0.0f);
        (this.Sight3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 14);
        this.Sight3.setRotationPoint(4.0f, -2.0f, 0.0f);
        this.Sight3.setTextureSize(128, 32);
        this.Sight3.mirror = true;
        this.setRotation(this.Sight3, 0.0f, 0.0f, 0.0f);
        (this.Sight4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 8);
        this.Sight4.setRotationPoint(4.0f, -4.5f, 3.0f);
        this.Sight4.setTextureSize(128, 32);
        this.Sight4.mirror = true;
        this.setRotation(this.Sight4, 0.0f, 0.0f, 0.0f);
        (this.Sight5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 8);
        this.Sight5.setRotationPoint(0.0f, -4.5f, 3.0f);
        this.Sight5.setTextureSize(128, 32);
        this.Sight5.mirror = true;
        this.setRotation(this.Sight5, 0.0f, 0.0f, 0.0f);
        (this.Sight6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 8);
        this.Sight6.setRotationPoint(0.5f, -5.0f, 3.0f);
        this.Sight6.setTextureSize(128, 32);
        this.Sight6.mirror = true;
        this.setRotation(this.Sight6, 0.0f, 0.0f, 0.0f);
        (this.Sight7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.Sight7.setRotationPoint(0.0f, -4.5f, 3.0f);
        this.Sight7.setTextureSize(128, 32);
        this.Sight7.mirror = true;
        this.setRotation(this.Sight7, -0.4089647f, 0.0f, 0.0f);
        (this.Sight8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.Sight8.setRotationPoint(4.0f, -4.5f, 3.0f);
        this.Sight8.setTextureSize(128, 32);
        this.Sight8.mirror = true;
        this.setRotation(this.Sight8, -0.4089647f, 0.0f, 0.0f);
        (this.Sight9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.Sight9.setRotationPoint(4.0f, -3.0f, 11.0f);
        this.Sight9.setTextureSize(128, 32);
        this.Sight9.mirror = true;
        this.setRotation(this.Sight9, -0.669215f, 0.0f, 0.0f);
        (this.Sight10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.Sight10.setRotationPoint(0.0f, -3.0f, 11.0f);
        this.Sight10.setTextureSize(128, 32);
        this.Sight10.mirror = true;
        this.setRotation(this.Sight10, -0.669215f, 0.0f, 0.0f);
        (this.Sight11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 11);
        this.Sight11.setRotationPoint(1.0f, -1.8f, 2.0f);
        this.Sight11.setTextureSize(128, 32);
        this.Sight11.mirror = true;
        this.setRotation(this.Sight11, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Sight1.render(f5);
        this.Sight2.render(f5);
        this.Sight3.render(f5);
        this.Sight4.render(f5);
        this.Sight5.render(f5);
        this.Sight6.render(f5);
        this.Sight7.render(f5);
        this.Sight8.render(f5);
        this.Sight9.render(f5);
        this.Sight10.render(f5);
        this.Sight11.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
