package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class VSSVintorezAction extends ModelBase
{
    ModelRenderer Action1;
    ModelRenderer Action2;
    ModelRenderer Action3;
    ModelRenderer Action4;
    ModelRenderer Action5;
    ModelRenderer Action6;
    ModelRenderer Action7;
    
    public VSSVintorezAction() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Action1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 12);
        this.Action1.setRotationPoint(-3.68f, -11.2f, -26.5f);
        this.Action1.setTextureSize(128, 64);
        this.Action1.mirror = true;
        this.setRotation(this.Action1, 0.0f, 0.0f, -1.375609f);
        (this.Action2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.Action2.setRotationPoint(-4.5f, -12.2f, -26.5f);
        this.Action2.setTextureSize(128, 64);
        this.Action2.mirror = true;
        this.setRotation(this.Action2, 0.0f, 0.0f, 0.0f);
        (this.Action3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.Action3.setRotationPoint(-6.0f, -12.2f, -26.3f);
        this.Action3.setTextureSize(128, 64);
        this.Action3.mirror = true;
        this.setRotation(this.Action3, 0.0f, 0.0f, 0.0f);
        (this.Action4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action4.setRotationPoint(-4.5f, -12.2f, -26.5f);
        this.Action4.setTextureSize(128, 64);
        this.Action4.mirror = true;
        this.setRotation(this.Action4, 0.0f, -1.375609f, 0.0f);
        (this.Action5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action5.setRotationPoint(-6.0f, -12.2f, -25.3f);
        this.Action5.setTextureSize(128, 64);
        this.Action5.mirror = true;
        this.setRotation(this.Action5, 0.0f, 1.98792f, 0.0f);
        (this.Action6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action6.setRotationPoint(-3.8f, -12.2f, -25.9f);
        this.Action6.setTextureSize(128, 64);
        this.Action6.mirror = true;
        this.setRotation(this.Action6, 0.0f, 0.0f, 0.0f);
        (this.Action7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Action7.setRotationPoint(-3.8f, -12.2f, -24.9f);
        this.Action7.setTextureSize(128, 64);
        this.Action7.mirror = true;
        this.setRotation(this.Action7, 0.0f, 2.41661f, 0.0f);
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
