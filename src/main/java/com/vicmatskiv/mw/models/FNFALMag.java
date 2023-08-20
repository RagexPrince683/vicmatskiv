package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class FNFALMag extends ModelBase
{
    ModelRenderer gun16;
    ModelRenderer gun17;
    ModelRenderer gun18;
    ModelRenderer gun19;
    ModelRenderer gun20;
    ModelRenderer gun21;
    ModelRenderer gun22;
    ModelRenderer gun23;
    
    public FNFALMag() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.gun16 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 14, 7);
        this.gun16.setRotationPoint(1.0f, -13.0f, -3.8f);
        this.gun16.setTextureSize(64, 32);
        this.gun16.mirror = true;
        this.setRotation(this.gun16, 0.0f, 0.0f, 0.0f);
        (this.gun17 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 1);
        this.gun17.setRotationPoint(1.0f, 1.0f, -2.8f);
        this.gun17.setTextureSize(64, 32);
        this.gun17.mirror = true;
        this.setRotation(this.gun17, 1.449966f, 0.0f, 0.0f);
        (this.gun18 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 14, 2);
        this.gun18.setRotationPoint(0.9f, -13.0f, 1.2f);
        this.gun18.setTextureSize(64, 32);
        this.gun18.mirror = true;
        this.setRotation(this.gun18, 0.0f, 0.0f, 0.0f);
        (this.gun19 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 14, 2);
        this.gun19.setRotationPoint(0.9f, -13.0f, -1.0f);
        this.gun19.setTextureSize(64, 32);
        this.gun19.mirror = true;
        this.setRotation(this.gun19, 0.0f, 0.0f, 0.0f);
        (this.gun20 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 14, 2);
        this.gun20.setRotationPoint(0.9f, -13.0f, -3.3f);
        this.gun20.setTextureSize(64, 32);
        this.gun20.mirror = true;
        this.setRotation(this.gun20, 0.0f, 0.0f, 0.0f);
        (this.gun21 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 14, 2);
        this.gun21.setRotationPoint(3.1f, -13.0f, -3.3f);
        this.gun21.setTextureSize(64, 32);
        this.gun21.mirror = true;
        this.setRotation(this.gun21, 0.0f, 0.0f, 0.0f);
        (this.gun22 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 14, 2);
        this.gun22.setRotationPoint(3.1f, -13.0f, -1.0f);
        this.gun22.setTextureSize(64, 32);
        this.gun22.mirror = true;
        this.setRotation(this.gun22, 0.0f, 0.0f, 0.0f);
        (this.gun23 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 14, 2);
        this.gun23.setRotationPoint(3.1f, -13.0f, 1.2f);
        this.gun23.setTextureSize(64, 32);
        this.gun23.mirror = true;
        this.setRotation(this.gun23, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun16.render(f5);
        this.gun17.render(f5);
        this.gun18.render(f5);
        this.gun19.render(f5);
        this.gun20.render(f5);
        this.gun21.render(f5);
        this.gun22.render(f5);
        this.gun23.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
