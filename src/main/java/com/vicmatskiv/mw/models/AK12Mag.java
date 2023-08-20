package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class AK12Mag extends ModelBase
{
    ModelRenderer Mag1;
    ModelRenderer Mag2;
    ModelRenderer Mag3;
    ModelRenderer Mag4;
    ModelRenderer Mag5;
    ModelRenderer Mag6;
    
    public AK12Mag() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.Mag1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 7);
        this.Mag1.setRotationPoint(1.5f, 0.1f, -4.2f);
        this.Mag1.setTextureSize(64, 32);
        this.Mag1.mirror = true;
        this.setRotation(this.Mag1, -1.970466f, 0.0f, 0.0f);
        (this.Mag2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 7, 2);
        this.Mag2.setRotationPoint(1.5f, -12.7f, -3.3f);
        this.Mag2.setTextureSize(64, 32);
        this.Mag2.mirror = true;
        this.setRotation(this.Mag2, -0.1858931f, 0.0f, 0.0f);
        (this.Mag3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 5, 7);
        this.Mag3.setRotationPoint(1.0f, -5.0f, 1.4f);
        this.Mag3.setTextureSize(64, 32);
        this.Mag3.mirror = true;
        this.setRotation(this.Mag3, -1.858931f, 0.0f, 0.0f);
        (this.Mag4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 7);
        this.Mag4.setRotationPoint(1.5f, -6.0f, -2.5f);
        this.Mag4.setTextureSize(64, 32);
        this.Mag4.mirror = true;
        this.setRotation(this.Mag4, -1.858931f, 0.0f, 0.0f);
        (this.Mag5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 7, 5);
        this.Mag5.setRotationPoint(1.0f, -12.7f, -2.2f);
        this.Mag5.setTextureSize(64, 32);
        this.Mag5.mirror = true;
        this.setRotation(this.Mag5, -0.1858931f, 0.0f, 0.0f);
        (this.Mag6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 5, 7);
        this.Mag6.setRotationPoint(1.0f, 1.6f, -0.5f);
        this.Mag6.setTextureSize(64, 32);
        this.Mag6.mirror = true;
        this.setRotation(this.Mag6, -1.970466f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Mag1.render(f5);
        this.Mag2.render(f5);
        this.Mag3.render(f5);
        this.Mag4.render(f5);
        this.Mag5.render(f5);
        this.Mag6.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
