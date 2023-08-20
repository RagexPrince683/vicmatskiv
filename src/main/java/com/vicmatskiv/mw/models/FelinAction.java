package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class FelinAction extends ModelBase
{
    ModelRenderer CarryHandle146;
    ModelRenderer CarryHandle147;
    ModelRenderer CarryHandle148;
    ModelRenderer CarryHandle149;
    ModelRenderer CarryHandle150;
    
    public FelinAction() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.CarryHandle146 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 4, 2);
        this.CarryHandle146.setRotationPoint(-4.0f, -9.0f, -26.0f);
        this.CarryHandle146.setTextureSize(64, 32);
        this.CarryHandle146.mirror = true;
        this.setRotation(this.CarryHandle146, 0.0f, 0.0f, 0.0f);
        (this.CarryHandle147 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 4);
        this.CarryHandle147.setRotationPoint(-4.0f, -9.0f, -24.0f);
        this.CarryHandle147.setTextureSize(64, 32);
        this.CarryHandle147.mirror = true;
        this.setRotation(this.CarryHandle147, -1.115358f, 0.0f, 0.0f);
        (this.CarryHandle148 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 1);
        this.CarryHandle148.setRotationPoint(-0.2f, -9.5f, -26.0f);
        this.CarryHandle148.setTextureSize(64, 32);
        this.CarryHandle148.mirror = true;
        this.setRotation(this.CarryHandle148, 0.0f, 0.0f, 0.0f);
        (this.CarryHandle149 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.CarryHandle149.setRotationPoint(0.0f, -9.5f, -25.0f);
        this.CarryHandle149.setTextureSize(64, 32);
        this.CarryHandle149.mirror = true;
        this.setRotation(this.CarryHandle149, 0.0f, 0.0f, 0.0f);
        (this.CarryHandle150 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 3);
        this.CarryHandle150.setRotationPoint(1.0f, -9.5f, -24.0f);
        this.CarryHandle150.setTextureSize(64, 32);
        this.CarryHandle150.mirror = true;
        this.setRotation(this.CarryHandle150, 0.0f, 1.933288f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.CarryHandle146.render(f5);
        this.CarryHandle147.render(f5);
        this.CarryHandle148.render(f5);
        this.CarryHandle149.render(f5);
        this.CarryHandle150.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
