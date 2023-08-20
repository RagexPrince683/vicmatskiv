package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ACRAction extends ModelBase
{
    ModelRenderer ACRAction1;
    ModelRenderer ACRAction2;
    ModelRenderer ACRAction3;
    ModelRenderer ACRAction4;
    
    public ACRAction() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.ACRAction1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 1, 1);
        this.ACRAction1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.ACRAction1.setTextureSize(128, 64);
        this.ACRAction1.mirror = true;
        this.setRotation(this.ACRAction1, 0.0f, 0.0f, 0.0f);
        (this.ACRAction2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.ACRAction2.setRotationPoint(0.0f, 0.0f, 0.5f);
        this.ACRAction2.setTextureSize(128, 64);
        this.ACRAction2.mirror = true;
        this.setRotation(this.ACRAction2, 0.0f, 0.0f, 0.0f);
        (this.ACRAction3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.ACRAction3.setRotationPoint(2.6f, 0.0f, 0.5f);
        this.ACRAction3.setTextureSize(128, 64);
        this.ACRAction3.mirror = true;
        this.setRotation(this.ACRAction3, 0.0f, 0.0f, 0.0f);
        (this.ACRAction4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.ACRAction4.setRotationPoint(5.0f, 0.0f, 1.0f);
        this.ACRAction4.setTextureSize(128, 64);
        this.ACRAction4.mirror = true;
        this.setRotation(this.ACRAction4, 0.0f, -2.342252f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.ACRAction1.render(f5);
        this.ACRAction2.render(f5);
        this.ACRAction3.render(f5);
        this.ACRAction4.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
