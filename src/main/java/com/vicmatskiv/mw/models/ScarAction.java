package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ScarAction extends ModelBase
{
    ModelRenderer gun149;
    ModelRenderer gun150;
    ModelRenderer gun151;
    ModelRenderer gun152;
    ModelRenderer gun116;
    
    public ScarAction() {
        super();
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.gun149 = new ModelRenderer((ModelBase)this, 100, 50)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.gun149.setRotationPoint(-5.0f, -19.1f, -32.0f);
        this.gun149.setTextureSize(64, 32);
        this.gun149.mirror = true;
        this.setRotation(this.gun149, 0.0f, 0.0f, 0.0f);
        (this.gun150 = new ModelRenderer((ModelBase)this, 100, 50)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.gun150.setRotationPoint(-5.0f, -18.9f, -32.0f);
        this.gun150.setTextureSize(64, 32);
        this.gun150.mirror = true;
        this.setRotation(this.gun150, 0.0f, 0.0f, 0.0f);
        (this.gun151 = new ModelRenderer((ModelBase)this, 100, 50)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.gun151.setRotationPoint(-5.0f, -19.0f, -32.1f);
        this.gun151.setTextureSize(64, 32);
        this.gun151.mirror = true;
        this.setRotation(this.gun151, 0.0f, 0.0f, 0.0f);
        (this.gun152 = new ModelRenderer((ModelBase)this, 100, 50)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.gun152.setRotationPoint(-5.0f, -19.0f, -31.9f);
        this.gun152.setTextureSize(64, 32);
        this.gun152.mirror = true;
        this.setRotation(this.gun152, 0.0f, 0.0f, 0.0f);
        (this.gun116 = new ModelRenderer((ModelBase)this, 100, 50)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 18);
        this.gun116.setRotationPoint(-3.0f, -19.0f, -32.0f);
        this.gun116.setTextureSize(64, 32);
        this.gun116.mirror = true;
        this.setRotation(this.gun116, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun149.render(f5);
        this.gun150.render(f5);
        this.gun151.render(f5);
        this.gun152.render(f5);
        this.gun116.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
