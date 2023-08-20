package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class NATO40rnd extends ModelBase
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
    ModelRenderer gun12;
    ModelRenderer gun13;
    ModelRenderer gun14;
    ModelRenderer gun15;
    ModelRenderer gun16;
    
    public NATO40rnd() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.gun1 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 7, 6);
        this.gun1.setRotationPoint(1.0f, -12.0f, -4.5f);
        this.gun1.setTextureSize(64, 32);
        this.gun1.mirror = true;
        this.setRotation(this.gun1, 0.0f, 0.0f, 0.0f);
        (this.gun2 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 15);
        this.gun2.setRotationPoint(1.0f, -5.0f, 1.5f);
        this.gun2.setTextureSize(64, 32);
        this.gun2.mirror = true;
        this.setRotation(this.gun2, -1.784573f, 0.0f, 0.0f);
        (this.gun3 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 2);
        this.gun3.setRotationPoint(0.8f, -12.0f, -0.5f);
        this.gun3.setTextureSize(64, 32);
        this.gun3.mirror = true;
        this.setRotation(this.gun3, 0.0f, 0.0f, 0.0f);
        (this.gun4 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 2);
        this.gun4.setRotationPoint(3.2f, -12.0f, -0.5f);
        this.gun4.setTextureSize(64, 32);
        this.gun4.mirror = true;
        this.setRotation(this.gun4, 0.0f, 0.0f, 0.0f);
        (this.gun5 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 15);
        this.gun5.setRotationPoint(0.8f, -5.0f, 1.5f);
        this.gun5.setTextureSize(64, 32);
        this.gun5.mirror = true;
        this.setRotation(this.gun5, -1.784573f, 0.0f, 0.0f);
        (this.gun6 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 15);
        this.gun6.setRotationPoint(3.2f, -5.0f, 1.5f);
        this.gun6.setTextureSize(64, 32);
        this.gun6.mirror = true;
        this.setRotation(this.gun6, -1.784573f, 0.0f, 0.0f);
        (this.gun7 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 14);
        this.gun7.setRotationPoint(3.2f, -5.0f, -1.0f);
        this.gun7.setTextureSize(64, 32);
        this.gun7.mirror = true;
        this.setRotation(this.gun7, -1.784573f, 0.0f, 0.0f);
        (this.gun8 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 2);
        this.gun8.setRotationPoint(3.2f, -12.0f, -3.0f);
        this.gun8.setTextureSize(64, 32);
        this.gun8.mirror = true;
        this.setRotation(this.gun8, 0.0f, 0.0f, 0.0f);
        (this.gun9 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.gun9.setRotationPoint(3.2f, -12.0f, -4.5f);
        this.gun9.setTextureSize(64, 32);
        this.gun9.mirror = true;
        this.setRotation(this.gun9, 0.0f, 0.0f, 0.0f);
        (this.gun10 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 14);
        this.gun10.setRotationPoint(3.2f, -5.0f, -3.5f);
        this.gun10.setTextureSize(64, 32);
        this.gun10.mirror = true;
        this.setRotation(this.gun10, -1.784573f, 0.0f, 0.0f);
        (this.gun11 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.gun11.setRotationPoint(0.8f, -12.0f, -4.5f);
        this.gun11.setTextureSize(64, 32);
        this.gun11.mirror = true;
        this.setRotation(this.gun11, 0.0f, 0.0f, 0.0f);
        (this.gun12 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 14);
        this.gun12.setRotationPoint(0.8f, -5.0f, -1.0f);
        this.gun12.setTextureSize(64, 32);
        this.gun12.mirror = true;
        this.setRotation(this.gun12, -1.784573f, 0.0f, 0.0f);
        (this.gun13 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 2);
        this.gun13.setRotationPoint(0.8f, -12.0f, -3.0f);
        this.gun13.setTextureSize(64, 32);
        this.gun13.mirror = true;
        this.setRotation(this.gun13, 0.0f, 0.0f, 0.0f);
        (this.gun14 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 14);
        this.gun14.setRotationPoint(0.8f, -5.0f, -3.5f);
        this.gun14.setTextureSize(64, 32);
        this.gun14.mirror = true;
        this.setRotation(this.gun14, -1.784573f, 0.0f, 0.0f);
        (this.gun15 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.gun15.setRotationPoint(3.2f, 8.2f, -3.7f);
        this.gun15.setTextureSize(64, 32);
        this.gun15.mirror = true;
        this.setRotation(this.gun15, -1.784573f, 0.0f, 0.0f);
        (this.gun16 = new ModelRenderer((ModelBase)this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.gun16.setRotationPoint(0.8f, 8.2f, -3.7f);
        this.gun16.setTextureSize(64, 32);
        this.gun16.mirror = true;
        this.setRotation(this.gun16, -1.784573f, 0.0f, 0.0f);
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
        this.gun12.render(f5);
        this.gun13.render(f5);
        this.gun14.render(f5);
        this.gun15.render(f5);
        this.gun16.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
