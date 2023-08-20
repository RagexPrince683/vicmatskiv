package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class VSSVintorezMag extends ModelBase
{
    ModelRenderer Mag1;
    ModelRenderer Mag2;
    ModelRenderer Mag3;
    ModelRenderer Mag4;
    
    public VSSVintorezMag() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Mag1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 9, 5);
        this.Mag1.setRotationPoint(0.5f, -0.5f, 0.5f);
        this.Mag1.setTextureSize(128, 64);
        this.Mag1.mirror = true;
        this.setRotation(this.Mag1, 2.862753f, 0.0f, 0.0f);
        (this.Mag2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 9, 2);
        this.Mag2.setRotationPoint(1.0f, -1.85f, -4.0f);
        this.Mag2.setTextureSize(128, 64);
        this.Mag2.mirror = true;
        this.setRotation(this.Mag2, 2.862753f, 0.0f, 0.0f);
        (this.Mag3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 2);
        this.Mag3.setRotationPoint(0.5f, -1.85f, -4.1f);
        this.Mag3.setTextureSize(128, 64);
        this.Mag3.mirror = true;
        this.setRotation(this.Mag3, 2.862753f, 0.0f, 0.0f);
        (this.Mag4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 2, 5);
        this.Mag4.setRotationPoint(0.0f, -0.45f, 0.5f);
        this.Mag4.setTextureSize(128, 64);
        this.Mag4.mirror = true;
        this.setRotation(this.Mag4, 2.862753f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Mag1.render(f5);
        this.Mag2.render(f5);
        this.Mag3.render(f5);
        this.Mag4.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
