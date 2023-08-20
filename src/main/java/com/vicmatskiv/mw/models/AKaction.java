package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class AKaction extends ModelBase
{
    ModelRenderer Action1;
    ModelRenderer Action2;
    ModelRenderer Action3;
    ModelRenderer Action4;
    ModelRenderer Action5;
    ModelRenderer Action6;
    ModelRenderer Action7;
    ModelRenderer Action8;
    ModelRenderer Action9;
    ModelRenderer Action10;
    ModelRenderer Action11;
    ModelRenderer Action12;
    
    public AKaction() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Action1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 13);
        this.Action1.setRotationPoint(-2.5f, -15.0f, -33.5f);
        this.Action1.setTextureSize(128, 64);
        this.Action1.mirror = true;
        this.setRotation(this.Action1, 0.0f, 0.0f, 0.1858931f);
        (this.Action2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 7);
        this.Action2.setRotationPoint(-3.5f, -13.0f, -33.5f);
        this.Action2.setTextureSize(128, 64);
        this.Action2.mirror = true;
        this.setRotation(this.Action2, 0.0f, 0.0f, 0.0f);
        (this.Action3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 6);
        this.Action3.setRotationPoint(-3.2f, -13.0f, -26.5f);
        this.Action3.setTextureSize(128, 64);
        this.Action3.mirror = true;
        this.setRotation(this.Action3, 0.0f, 0.0f, 0.0f);
        (this.Action4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 11);
        this.Action4.setRotationPoint(-3.0f, -13.0f, -20.5f);
        this.Action4.setTextureSize(128, 64);
        this.Action4.mirror = true;
        this.setRotation(this.Action4, 0.0f, 0.0f, 0.0f);
        (this.Action5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.Action5.setRotationPoint(-3.5f, -13.0f, -26.5f);
        this.Action5.setTextureSize(128, 64);
        this.Action5.mirror = true;
        this.setRotation(this.Action5, 0.0f, 0.1858931f, 0.0f);
        (this.Action6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Action6.setRotationPoint(-7.0f, -12.2f, -33.5f);
        this.Action6.setTextureSize(128, 64);
        this.Action6.mirror = true;
        this.setRotation(this.Action6, 0.0f, 0.0f, 0.0f);
        (this.Action7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 7);
        this.Action7.setRotationPoint(-3.5f, -13.0f, -33.5f);
        this.Action7.setTextureSize(128, 64);
        this.Action7.mirror = true;
        this.setRotation(this.Action7, 0.0f, 0.0f, -0.5205006f);
        (this.Action8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.Action8.setRotationPoint(-3.2f, -13.0f, -26.5f);
        this.Action8.setTextureSize(128, 64);
        this.Action8.mirror = true;
        this.setRotation(this.Action8, 0.0f, 0.0f, -0.8551081f);
        (this.Action9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 13);
        this.Action9.setRotationPoint(-2.9f, -13.6f, -33.5f);
        this.Action9.setTextureSize(128, 64);
        this.Action9.mirror = true;
        this.setRotation(this.Action9, 0.0f, 0.0f, -0.5576792f);
        (this.Action10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action10.setRotationPoint(-7.0f, -12.8f, -33.5f);
        this.Action10.setTextureSize(128, 64);
        this.Action10.mirror = true;
        this.setRotation(this.Action10, 0.0f, 0.0f, 0.0f);
        (this.Action11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action11.setRotationPoint(-6.0f, -12.8f, -33.5f);
        this.Action11.setTextureSize(128, 64);
        this.Action11.mirror = true;
        this.setRotation(this.Action11, 0.0f, 0.0f, 0.0f);
        (this.Action12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action12.setRotationPoint(-5.0f, -12.8f, -33.5f);
        this.Action12.setTextureSize(128, 64);
        this.Action12.mirror = true;
        this.setRotation(this.Action12, 0.0f, 0.0f, 0.7435722f);
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
        this.Action8.render(f5);
        this.Action9.render(f5);
        this.Action10.render(f5);
        this.Action11.render(f5);
        this.Action12.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
