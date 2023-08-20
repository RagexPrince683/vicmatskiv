package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class AR15Action extends ModelBase
{
    ModelRenderer Action1;
    ModelRenderer Action2;
    ModelRenderer Action3;
    ModelRenderer Action4;
    ModelRenderer Action5;
    ModelRenderer Action6;
    ModelRenderer Action7;
    
    public AR15Action() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Action1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 15);
        this.Action1.setRotationPoint(-0.3f, 0.0f, 0.0f);
        this.Action1.setTextureSize(128, 64);
        this.Action1.mirror = true;
        this.setRotation(this.Action1, 0.0f, 0.0f, 0.0f);
        (this.Action2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 2, 1);
        this.Action2.setRotationPoint(-2.0f, -0.5f, 14.5f);
        this.Action2.setTextureSize(128, 64);
        this.Action2.mirror = true;
        this.setRotation(this.Action2, 0.0f, 0.0f, 0.0f);
        (this.Action3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.Action3.setRotationPoint(-2.0f, -0.5f, 14.5f);
        this.Action3.setTextureSize(128, 64);
        this.Action3.mirror = true;
        this.setRotation(this.Action3, 0.0f, 0.5576792f, 0.0f);
        (this.Action4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.Action4.setRotationPoint(4.0f, -0.5f, 14.5f);
        this.Action4.setTextureSize(128, 64);
        this.Action4.mirror = true;
        this.setRotation(this.Action4, 0.0f, -2.119181f, 0.0f);
        (this.Action5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 1);
        this.Action5.setRotationPoint(-1.0f, -0.5f, 14.0f);
        this.Action5.setTextureSize(128, 64);
        this.Action5.mirror = true;
        this.setRotation(this.Action5, 0.0f, 0.0f, 0.0f);
        (this.Action6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.Action6.setRotationPoint(1.5f, 0.0f, 13.7f);
        this.Action6.setTextureSize(128, 64);
        this.Action6.mirror = true;
        this.setRotation(this.Action6, 0.0f, 0.0743572f, 0.0f);
        (this.Action7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 15);
        this.Action7.setRotationPoint(1.3f, 0.0f, 0.0f);
        this.Action7.setTextureSize(128, 64);
        this.Action7.mirror = true;
        this.setRotation(this.Action7, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Action1.render(f5);
        this.Action2.render(f5);
        this.Action3.render(f5);
        this.Action4.render(f5);
        this.Action5.render(f5);
        this.Action6.render(f5);
        this.Action7.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
