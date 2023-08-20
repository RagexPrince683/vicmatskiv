package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RPK74MMag extends ModelBase
{
    ModelRenderer mag1;
    ModelRenderer mag2;
    ModelRenderer mag3;
    ModelRenderer mag4;
    ModelRenderer mag5;
    ModelRenderer mag6;
    ModelRenderer mag7;
    
    public RPK74MMag() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.mag1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 6, 7);
        this.mag1.setRotationPoint(0.5f, -11.0f, 2.0f);
        this.mag1.setTextureSize(64, 32);
        this.mag1.mirror = true;
        this.setRotation(this.mag1, -1.784573f, 0.0f, 0.0f);
        (this.mag2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 6, 6);
        this.mag2.setRotationPoint(0.5f, -4.2f, 0.6f);
        this.mag2.setTextureSize(64, 32);
        this.mag2.mirror = true;
        this.setRotation(this.mag2, -1.933288f, 0.0f, 0.0f);
        (this.mag3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 6, 12);
        this.mag3.setRotationPoint(0.5f, 1.4f, -1.5f);
        this.mag3.setTextureSize(64, 32);
        this.mag3.mirror = true;
        this.setRotation(this.mag3, -2.193538f, 0.0f, 0.0f);
        (this.mag4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 2);
        this.mag4.setRotationPoint(0.5f, 6.5f, -11.6f);
        this.mag4.setTextureSize(64, 32);
        this.mag4.mirror = true;
        this.setRotation(this.mag4, -2.193538f, 0.0f, 0.0f);
        (this.mag5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 7, 7);
        this.mag5.setRotationPoint(1.0f, -11.0f, 2.0f);
        this.mag5.setTextureSize(64, 32);
        this.mag5.mirror = true;
        this.setRotation(this.mag5, -1.784573f, 0.0f, 0.0f);
        (this.mag6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 6);
        this.mag6.setRotationPoint(1.0f, -4.0f, -0.5f);
        this.mag6.setTextureSize(64, 32);
        this.mag6.mirror = true;
        this.setRotation(this.mag6, -1.933288f, 0.0f, 0.0f);
        (this.mag7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 11);
        this.mag7.setRotationPoint(1.0f, -1.5f, -6.7f);
        this.mag7.setTextureSize(64, 32);
        this.mag7.mirror = true;
        this.setRotation(this.mag7, -2.193538f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.mag1.render(f5);
        this.mag2.render(f5);
        this.mag3.render(f5);
        this.mag4.render(f5);
        this.mag5.render(f5);
        this.mag6.render(f5);
        this.mag7.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
