package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class M14Action extends ModelBase
{
    ModelRenderer Action2;
    ModelRenderer Action3;
    ModelRenderer Action6;
    ModelRenderer Action7;
    ModelRenderer Action12;
    ModelRenderer Action13;
    ModelRenderer Action14;
    ModelRenderer Action15;
    ModelRenderer Action16;
    ModelRenderer Action17;
    
    public M14Action() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Action2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Action2.setRotationPoint(-4.2f, -14.6f, -37.0f);
        this.Action2.setTextureSize(64, 32);
        this.Action2.mirror = true;
        this.setRotation(this.Action2, 0.0f, 0.0f, 0.0f);
        (this.Action3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.Action3.setRotationPoint(-4.2f, -15.6f, -39.0f);
        this.Action3.setTextureSize(64, 32);
        this.Action3.mirror = true;
        this.setRotation(this.Action3, 0.0f, 0.0f, 0.0f);
        (this.Action6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 18);
        this.Action6.setRotationPoint(-3.3f, -14.9f, -57.0f);
        this.Action6.setTextureSize(64, 32);
        this.Action6.mirror = true;
        this.setRotation(this.Action6, 0.0f, 0.0f, 0.0f);
        (this.Action7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 1);
        this.Action7.setRotationPoint(-3.3f, -14.9f, -57.0f);
        this.Action7.setTextureSize(64, 32);
        this.Action7.mirror = true;
        this.setRotation(this.Action7, 0.0f, 1.487144f, 0.0f);
        (this.Action12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Action12.setRotationPoint(-4.2f, -15.6f, -37.0f);
        this.Action12.setTextureSize(64, 32);
        this.Action12.mirror = true;
        this.setRotation(this.Action12, -0.6320364f, 0.0f, 0.0f);
        (this.Action13 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.Action13.setRotationPoint(-4.2f, -14.6f, -34.0f);
        this.Action13.setTextureSize(64, 32);
        this.Action13.mirror = true;
        this.setRotation(this.Action13, -1.710216f, 0.0f, 0.0f);
        (this.Action14 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.Action14.setRotationPoint(-6.0f, -14.6f, -34.0f);
        this.Action14.setTextureSize(64, 32);
        this.Action14.mirror = true;
        this.setRotation(this.Action14, 0.0f, 0.0f, 0.0f);
        (this.Action15 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action15.setRotationPoint(-6.0f, -14.2f, -34.0f);
        this.Action15.setTextureSize(64, 32);
        this.Action15.mirror = true;
        this.setRotation(this.Action15, 0.0f, 0.0f, 0.0f);
        (this.Action16 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action16.setRotationPoint(-5.7f, -14.2f, -34.0f);
        this.Action16.setTextureSize(64, 32);
        this.Action16.mirror = true;
        this.setRotation(this.Action16, 0.0f, 0.0f, 0.0f);
        (this.Action17 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Action17.setRotationPoint(-4.7f, -13.2f, -34.0f);
        this.Action17.setTextureSize(64, 32);
        this.Action17.mirror = true;
        this.setRotation(this.Action17, 0.0f, 0.0f, -1.821752f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Action2.render(f5);
        this.Action3.render(f5);
        this.Action6.render(f5);
        this.Action7.render(f5);
        this.Action12.render(f5);
        this.Action13.render(f5);
        this.Action14.render(f5);
        this.Action15.render(f5);
        this.Action16.render(f5);
        this.Action17.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
