package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class P90iron extends ModelBase
{
    ModelRenderer sight1;
    ModelRenderer sight2;
    ModelRenderer sight3;
    ModelRenderer sight4;
    ModelRenderer sight5;
    ModelRenderer sight6;
    ModelRenderer sight7;
    
    public P90iron() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.sight1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.sight1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.sight1.setTextureSize(64, 32);
        this.sight1.mirror = true;
        this.setRotation(this.sight1, 0.0f, 0.0f, 0.0f);
        (this.sight2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.sight2.setRotationPoint(0.0f, 1.0f, 0.0f);
        this.sight2.setTextureSize(64, 32);
        this.sight2.mirror = true;
        this.setRotation(this.sight2, 0.0f, 0.0f, -2.119181f);
        (this.sight3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.sight3.setRotationPoint(3.0f, 1.0f, 0.0f);
        this.sight3.setTextureSize(64, 32);
        this.sight3.mirror = true;
        this.setRotation(this.sight3, 0.0f, 0.0f, -2.67686f);
        (this.sight4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.sight4.setRotationPoint(3.9f, -0.8f, 0.0f);
        this.sight4.setTextureSize(64, 32);
        this.sight4.mirror = true;
        this.setRotation(this.sight4, 0.0f, 0.0f, 2.862753f);
        (this.sight5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.sight5.setRotationPoint(-1.0f, -0.7f, 0.0f);
        this.sight5.setTextureSize(64, 32);
        this.sight5.mirror = true;
        this.setRotation(this.sight5, 0.0f, 0.0f, -1.33843f);
        (this.sight6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.sight6.setRotationPoint(1.0f, -1.5f, 0.0f);
        this.sight6.setTextureSize(64, 32);
        this.sight6.mirror = true;
        this.setRotation(this.sight6, 0.0f, 0.0f, 0.0f);
        (this.sight7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 2);
        this.sight7.setRotationPoint(0.5f, 0.5f, 0.0f);
        this.sight7.setTextureSize(64, 32);
        this.sight7.mirror = true;
        this.setRotation(this.sight7, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.sight1.render(f5);
        this.sight2.render(f5);
        this.sight3.render(f5);
        this.sight4.render(f5);
        this.sight5.render(f5);
        this.sight6.render(f5);
        this.sight7.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
