package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class M4Iron2 extends ModelBase
{
    ModelRenderer sight4;
    ModelRenderer sight5;
    ModelRenderer sight7;
    ModelRenderer sight9;
    ModelRenderer sight10;
    ModelRenderer sight11;
    ModelRenderer sight12;
    
    public M4Iron2() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.sight4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 1);
        this.sight4.setRotationPoint(-2.0f, -3.0f, 0.0f);
        this.sight4.setTextureSize(64, 32);
        this.sight4.mirror = true;
        this.setRotation(this.sight4, 0.0f, 0.0f, 0.0f);
        (this.sight5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.sight5.setRotationPoint(-2.0f, -3.0f, 1.0f);
        this.sight5.setTextureSize(64, 32);
        this.sight5.mirror = true;
        this.setRotation(this.sight5, 0.0f, 0.0f, 0.0f);
        (this.sight7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 5);
        this.sight7.setRotationPoint(-2.0f, -3.0f, 2.0f);
        this.sight7.setTextureSize(64, 32);
        this.sight7.mirror = true;
        this.setRotation(this.sight7, -1.189716f, 0.0f, 0.0f);
        (this.sight9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 4);
        this.sight9.setRotationPoint(-2.0f, 3.0f, 0.0f);
        this.sight9.setTextureSize(64, 32);
        this.sight9.mirror = true;
        this.setRotation(this.sight9, 0.0f, 0.0f, 0.0f);
        (this.sight10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.sight10.setRotationPoint(-2.0f, 1.6f, 2.9f);
        this.sight10.setTextureSize(64, 32);
        this.sight10.mirror = true;
        this.setRotation(this.sight10, 0.0f, 0.0f, 0.0f);
        (this.sight11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.sight11.setRotationPoint(-1.5f, -1.0f, 0.5f);
        this.sight11.setTextureSize(64, 32);
        this.sight11.mirror = true;
        this.setRotation(this.sight11, 0.0f, 0.0f, 0.0f);
        (this.sight12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.sight12.setRotationPoint(-1.5f, 2.5f, 0.5f);
        this.sight12.setTextureSize(64, 32);
        this.sight12.mirror = true;
        this.setRotation(this.sight12, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.sight4.render(f5);
        this.sight5.render(f5);
        this.sight7.render(f5);
        this.sight9.render(f5);
        this.sight10.render(f5);
        this.sight11.render(f5);
        this.sight12.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
