package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class GlockMagazine extends ModelBase
{
    ModelRenderer gun1;
    ModelRenderer gun2;
    ModelRenderer gun3;
    ModelRenderer gun4;
    ModelRenderer gun5;
    ModelRenderer gun6;
    ModelRenderer gun7;
    ModelRenderer gun8;
    ModelRenderer gun9;
    ModelRenderer gun10;
    ModelRenderer gun11;
    
    public GlockMagazine() {
        super();
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.gun1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 6);
        this.gun1.setRotationPoint(-3.5f, 4.0f, -4.5f);
        this.gun1.setTextureSize(64, 32);
        this.gun1.mirror = true;
        this.setRotation(this.gun1, 0.0f, 0.0f, 0.0f);
        (this.gun2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 11, 5);
        this.gun2.setRotationPoint(-3.3f, -6.0f, -7.0f);
        this.gun2.setTextureSize(64, 32);
        this.gun2.mirror = true;
        this.setRotation(this.gun2, 0.2974289f, 0.0f, 0.0f);
        (this.gun3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 3);
        this.gun3.setRotationPoint(-3.3f, 3.9f, -1.9f);
        this.gun3.setTextureSize(64, 32);
        this.gun3.mirror = true;
        this.setRotation(this.gun3, 0.2974289f, 0.0f, 0.0f);
        (this.gun4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.gun4.setRotationPoint(-3.3f, 3.5f, -2.5f);
        this.gun4.setTextureSize(64, 32);
        this.gun4.mirror = true;
        this.setRotation(this.gun4, 0.0f, 0.0f, 0.0f);
        (this.gun5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 11, 5);
        this.gun5.setRotationPoint(-0.7f, -6.0f, -7.0f);
        this.gun5.setTextureSize(64, 32);
        this.gun5.mirror = true;
        this.setRotation(this.gun5, 0.2974289f, 0.0f, 0.0f);
        (this.gun6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.gun6.setRotationPoint(-0.7f, 3.9f, -1.9f);
        this.gun6.setTextureSize(64, 32);
        this.gun6.mirror = true;
        this.setRotation(this.gun6, 0.2974289f, 0.0f, 0.0f);
        (this.gun7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.gun7.setRotationPoint(-0.7f, 3.5f, -2.5f);
        this.gun7.setTextureSize(64, 32);
        this.gun7.mirror = true;
        this.setRotation(this.gun7, 0.0f, 0.0f, 0.0f);
        (this.gun8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.gun8.setRotationPoint(-3.3f, 4.0f, -4.5f);
        this.gun8.setTextureSize(64, 32);
        this.gun8.mirror = true;
        this.setRotation(this.gun8, 0.8551081f, 0.0f, 0.0f);
        (this.gun9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.gun9.setRotationPoint(-0.7f, 4.0f, -4.5f);
        this.gun9.setTextureSize(64, 32);
        this.gun9.mirror = true;
        this.setRotation(this.gun9, 0.8551081f, 0.0f, 0.0f);
        (this.gun10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.gun10.setRotationPoint(-3.0f, -6.5f, -7.0f);
        this.gun10.setTextureSize(64, 32);
        this.gun10.mirror = true;
        this.setRotation(this.gun10, 0.2974289f, 0.0f, 0.0f);
        (this.gun11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 4);
        this.gun11.setRotationPoint(-3.0f, -7.5f, -7.0f);
        this.gun11.setTextureSize(64, 32);
        this.gun11.mirror = true;
        this.setRotation(this.gun11, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun1.render(f5);
        this.gun2.render(f5);
        this.gun3.render(f5);
        this.gun4.render(f5);
        this.gun5.render(f5);
        this.gun6.render(f5);
        this.gun7.render(f5);
        this.gun8.render(f5);
        this.gun9.render(f5);
        this.gun10.render(f5);
        this.gun11.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
