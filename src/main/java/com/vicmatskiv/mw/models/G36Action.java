package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class G36Action extends ModelBase
{
    ModelRenderer gun93;
    ModelRenderer gun376;
    ModelRenderer gun377;
    ModelRenderer gun378;
    ModelRenderer gun379;
    ModelRenderer gun380;
    ModelRenderer gun381;
    
    public G36Action() {
        super();
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.gun93 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 13);
        this.gun93.setRotationPoint(-3.3f, -15.7f, -28.0f);
        this.gun93.setTextureSize(64, 32);
        this.gun93.mirror = true;
        this.setRotation(this.gun93, 0.0f, 0.0f, 0.0f);
        (this.gun376 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 12);
        this.gun376.setRotationPoint(-2.5f, -20.0f, -27.0f);
        this.gun376.setTextureSize(64, 32);
        this.gun376.mirror = true;
        this.setRotation(this.gun376, 0.0f, 0.0f, 0.0f);
        (this.gun377 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 5);
        this.gun377.setRotationPoint(-2.5f, -19.7f, -32.0f);
        this.gun377.setTextureSize(64, 32);
        this.gun377.mirror = true;
        this.setRotation(this.gun377, 0.0f, 0.0f, 0.0f);
        (this.gun378 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.gun378.setRotationPoint(-2.5f, -20.0f, -27.0f);
        this.gun378.setTextureSize(64, 32);
        this.gun378.mirror = true;
        this.setRotation(this.gun378, -0.8551081f, 0.0f, 0.0f);
        (this.gun379 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 7);
        this.gun379.setRotationPoint(-2.3f, -19.8f, -38.8f);
        this.gun379.setTextureSize(64, 32);
        this.gun379.mirror = true;
        this.setRotation(this.gun379, -0.0261799f, 0.0f, 0.0f);
        (this.gun380 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 7);
        this.gun380.setRotationPoint(-1.7f, -19.8f, -38.8f);
        this.gun380.setTextureSize(64, 32);
        this.gun380.mirror = true;
        this.setRotation(this.gun380, -0.0261799f, 0.0f, 0.0f);
        (this.gun381 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.gun381.setRotationPoint(-2.5f, -19.1f, -34.0f);
        this.gun381.setTextureSize(64, 32);
        this.gun381.mirror = true;
        this.setRotation(this.gun381, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun93.render(f5);
        this.gun376.render(f5);
        this.gun377.render(f5);
        this.gun378.render(f5);
        this.gun379.render(f5);
        this.gun380.render(f5);
        this.gun381.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
