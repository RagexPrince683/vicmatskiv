package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class M14Action2 extends ModelBase
{
    ModelRenderer Action1;
    ModelRenderer Action4;
    ModelRenderer Action5;
    ModelRenderer Action8;
    ModelRenderer Action9;
    ModelRenderer Action10;
    ModelRenderer Action11;
    
    public M14Action2() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Action1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 19);
        this.Action1.setRotationPoint(-2.0f, -15.7f, -37.0f);
        this.Action1.setTextureSize(64, 32);
        this.Action1.mirror = true;
        this.setRotation(this.Action1, 0.0f, 0.0f, 0.0f);
        (this.Action4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 19);
        this.Action4.setRotationPoint(-3.2f, -14.2f, -37.5f);
        this.Action4.setTextureSize(64, 32);
        this.Action4.mirror = true;
        this.setRotation(this.Action4, 0.0f, 0.0f, 0.0f);
        (this.Action5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 19);
        this.Action5.setRotationPoint(-0.8f, -14.2f, -37.5f);
        this.Action5.setTextureSize(64, 32);
        this.Action5.mirror = true;
        this.setRotation(this.Action5, 0.0f, 0.0f, 0.0f);
        (this.Action8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 19);
        this.Action8.setRotationPoint(-2.0f, -15.7f, -37.0f);
        this.Action8.setTextureSize(64, 32);
        this.Action8.mirror = true;
        this.setRotation(this.Action8, 0.0f, 0.0f, 0.9294653f);
        (this.Action9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 19);
        this.Action9.setRotationPoint(-3.2f, -14.2f, -37.5f);
        this.Action9.setTextureSize(64, 32);
        this.Action9.mirror = true;
        this.setRotation(this.Action9, 0.0f, 0.0f, -1.152537f);
        (this.Action10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 19);
        this.Action10.setRotationPoint(-1.0f, -15.7f, -37.0f);
        this.Action10.setTextureSize(64, 32);
        this.Action10.mirror = true;
        this.setRotation(this.Action10, 0.0f, 0.0f, 0.7063936f);
        (this.Action11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 19);
        this.Action11.setRotationPoint(0.2f, -14.2f, -37.5f);
        this.Action11.setTextureSize(64, 32);
        this.Action11.mirror = true;
        this.setRotation(this.Action11, 0.0f, 0.0f, 2.670354f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Action1.render(f5);
        this.Action4.render(f5);
        this.Action5.render(f5);
        this.Action8.render(f5);
        this.Action9.render(f5);
        this.Action10.render(f5);
        this.Action11.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
