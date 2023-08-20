package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class AK12Magazine extends ModelBase
{
    ModelRenderer Mag1;
    ModelRenderer Mag2;
    ModelRenderer Mag3;
    ModelRenderer Mag4;
    ModelRenderer Mag5;
    ModelRenderer Mag6;
    
    public AK12Magazine() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Mag1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 7, 6);
        this.Mag1.setRotationPoint(-3.5f, -8.5f, -19.3f);
        this.Mag1.setTextureSize(64, 32);
        this.Mag1.mirror = true;
        this.setRotation(this.Mag1, -0.1115358f, 0.0f, 0.0f);
        (this.Mag2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 6, 6);
        this.Mag2.setRotationPoint(-3.5f, -0.9f, -14.1f);
        this.Mag2.setTextureSize(64, 32);
        this.Mag2.mirror = true;
        this.setRotation(this.Mag2, -1.821752f, 0.0f, 0.0f);
        (this.Mag3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 6, 7);
        this.Mag3.setRotationPoint(-3.5f, 4.9f, -15.55f);
        this.Mag3.setTextureSize(64, 32);
        this.Mag3.mirror = true;
        this.setRotation(this.Mag3, -1.970466f, 0.0f, 0.0f);
        (this.Mag4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 7, 2);
        this.Mag4.setRotationPoint(-3.0f, -8.65f, -20.6f);
        this.Mag4.setTextureSize(64, 32);
        this.Mag4.mirror = true;
        this.setRotation(this.Mag4, -0.1115358f, 0.0f, 0.0f);
        (this.Mag5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 6);
        this.Mag5.setRotationPoint(-3.0f, -2.2f, -19.2f);
        this.Mag5.setTextureSize(64, 32);
        this.Mag5.mirror = true;
        this.setRotation(this.Mag5, -1.821752f, 0.0f, 0.0f);
        (this.Mag6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 7);
        this.Mag6.setRotationPoint(-3.0f, 2.9f, -20.4f);
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
