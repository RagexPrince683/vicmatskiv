package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ScarHMag extends ModelBase
{
    ModelRenderer gun1;
    ModelRenderer gun3;
    ModelRenderer gun4;
    ModelRenderer gun8;
    ModelRenderer gun9;
    ModelRenderer gun11;
    ModelRenderer gun13;
    ModelRenderer gun14;
    ModelRenderer gun15;
    ModelRenderer gun16;
    
    public ScarHMag() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.gun1 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 11, 6);
        this.gun1.setRotationPoint(1.0f, -12.0f, -4.5f);
        this.gun1.setTextureSize(64, 32);
        this.gun1.mirror = true;
        this.setRotation(this.gun1, 0.0f, 0.0f, 0.0f);
        (this.gun3 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 12, 2);
        this.gun3.setRotationPoint(0.8f, -12.0f, -0.5f);
        this.gun3.setTextureSize(64, 32);
        this.gun3.mirror = true;
        this.setRotation(this.gun3, 0.0f, 0.0f, 0.0f);
        (this.gun4 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 12, 2);
        this.gun4.setRotationPoint(3.2f, -12.0f, -0.5f);
        this.gun4.setTextureSize(64, 32);
        this.gun4.mirror = true;
        this.setRotation(this.gun4, 0.0f, 0.0f, 0.0f);
        (this.gun8 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 11, 2);
        this.gun8.setRotationPoint(3.2f, -12.0f, -3.0f);
        this.gun8.setTextureSize(64, 32);
        this.gun8.mirror = true;
        this.setRotation(this.gun8, 0.0f, 0.0f, 0.0f);
        (this.gun9 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 11, 1);
        this.gun9.setRotationPoint(3.2f, -12.0f, -4.5f);
        this.gun9.setTextureSize(64, 32);
        this.gun9.mirror = true;
        this.setRotation(this.gun9, 0.0f, 0.0f, 0.0f);
        (this.gun11 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 11, 1);
        this.gun11.setRotationPoint(0.8f, -12.0f, -4.5f);
        this.gun11.setTextureSize(64, 32);
        this.gun11.mirror = true;
        this.setRotation(this.gun11, 0.0f, 0.0f, 0.0f);
        (this.gun13 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 11, 2);
        this.gun13.setRotationPoint(0.8f, -12.0f, -3.0f);
        this.gun13.setTextureSize(64, 32);
        this.gun13.mirror = true;
        this.setRotation(this.gun13, 0.0f, 0.0f, 0.0f);
        (this.gun14 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 1);
        this.gun14.setRotationPoint(1.0f, -1.0f, -4.5f);
        this.gun14.setTextureSize(64, 32);
        this.gun14.mirror = true;
        this.setRotation(this.gun14, 1.412787f, 0.0f, 0.0f);
        (this.gun15 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 6);
        this.gun15.setRotationPoint(1.5f, -1.0f, -4.5f);
        this.gun15.setTextureSize(64, 32);
        this.gun15.mirror = true;
        this.setRotation(this.gun15, 0.0f, 0.0f, 0.0f);
        (this.gun16 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 6);
        this.gun16.setRotationPoint(1.0f, 0.0f, -4.5f);
        this.gun16.setTextureSize(64, 32);
        this.gun16.mirror = true;
        this.setRotation(this.gun16, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun1.render(f5);
        this.gun3.render(f5);
        this.gun4.render(f5);
        this.gun8.render(f5);
        this.gun9.render(f5);
        this.gun11.render(f5);
        this.gun13.render(f5);
        this.gun14.render(f5);
        this.gun15.render(f5);
        this.gun16.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
