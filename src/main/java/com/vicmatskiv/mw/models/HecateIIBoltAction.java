package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class HecateIIBoltAction extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape22;
    ModelRenderer Shape2;
    ModelRenderer Shape33;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    
    public HecateIIBoltAction() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Shape1.setRotationPoint(2.0f, -16.5f, 2.2f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Shape11.setRotationPoint(2.0f, -15.5f, 2.2f);
        this.Shape11.setTextureSize(64, 32);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        (this.Shape12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 8);
        this.Shape12.setRotationPoint(1.5f, -16.0f, 2.2f);
        this.Shape12.setTextureSize(64, 32);
        this.Shape12.mirror = true;
        this.setRotation(this.Shape12, 0.0f, 0.0f, 0.0f);
        (this.Shape22 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Shape22.setRotationPoint(1.7f, -16.3f, 2.2f);
        this.Shape22.setTextureSize(64, 32);
        this.Shape22.mirror = true;
        this.setRotation(this.Shape22, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Shape2.setRotationPoint(2.3f, -16.3f, 2.2f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape33 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Shape33.setRotationPoint(2.3f, -15.7f, 2.2f);
        this.Shape33.setTextureSize(64, 32);
        this.Shape33.mirror = true;
        this.setRotation(this.Shape33, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Shape3.setRotationPoint(1.7f, -15.7f, 2.2f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Shape4.setRotationPoint(1.5f, -16.0f, 5.0f);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 1.003822f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape11.render(f5);
        this.Shape12.render(f5);
        this.Shape22.render(f5);
        this.Shape2.render(f5);
        this.Shape33.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
