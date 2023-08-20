package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class NATOG36Mag extends ModelBase
{
    ModelRenderer gun133;
    ModelRenderer gun134;
    ModelRenderer gun135;
    ModelRenderer gun136;
    ModelRenderer gun137;
    ModelRenderer gun138;
    ModelRenderer gun139;
    ModelRenderer gun140;
    ModelRenderer gun141;
    ModelRenderer gun142;
    
    public NATOG36Mag() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.gun133 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 2);
        this.gun133.setRotationPoint(0.8f, -12.4f, -2.8f);
        this.gun133.setTextureSize(64, 32);
        this.gun133.mirror = true;
        this.setRotation(this.gun133, -0.1487144f, 0.0f, 0.0f);
        (this.gun134 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 3, 8, 2);
        this.gun134.setRotationPoint(1.2f, -12.4f, -2.8f);
        this.gun134.setTextureSize(64, 32);
        this.gun134.mirror = true;
        this.setRotation(this.gun134, -0.1487144f, 0.0f, 0.0f);
        (this.gun135 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 3, 8, 3);
        this.gun135.setRotationPoint(1.2f, -11.9f, 0.1f);
        this.gun135.setTextureSize(64, 32);
        this.gun135.mirror = true;
        this.setRotation(this.gun135, -0.1487144f, 0.0f, 0.0f);
        (this.gun136 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 3);
        this.gun136.setRotationPoint(0.8f, -11.9f, 0.1f);
        this.gun136.setTextureSize(64, 32);
        this.gun136.mirror = true;
        this.setRotation(this.gun136, -0.1487144f, 0.0f, 0.0f);
        (this.gun137 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 5);
        this.gun137.setRotationPoint(0.8f, -3.6f, 1.9f);
        this.gun137.setTextureSize(64, 32);
        this.gun137.mirror = true;
        this.setRotation(this.gun137, -1.896109f, 0.0f, 0.0f);
        (this.gun138 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 5);
        this.gun138.setRotationPoint(1.2f, -3.6f, 1.9f);
        this.gun138.setTextureSize(64, 32);
        this.gun138.mirror = true;
        this.setRotation(this.gun138, -1.896109f, 0.0f, 0.0f);
        (this.gun139 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 4);
        this.gun139.setRotationPoint(1.2f, -4.2f, -2.05f);
        this.gun139.setTextureSize(64, 32);
        this.gun139.mirror = true;
        this.setRotation(this.gun139, -1.896109f, 0.0f, 0.0f);
        (this.gun140 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 4);
        this.gun140.setRotationPoint(0.8f, -4.2f, -2.05f);
        this.gun140.setTextureSize(64, 32);
        this.gun140.mirror = true;
        this.setRotation(this.gun140, -1.896109f, 0.0f, 0.0f);
        (this.gun141 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 6);
        this.gun141.setRotationPoint(0.5f, -1.2f, -5.2f);
        this.gun141.setTextureSize(64, 32);
        this.gun141.mirror = true;
        this.setRotation(this.gun141, -0.2974289f, 0.0f, 0.0f);
        (this.gun142 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 3, 12, 3);
        this.gun142.setRotationPoint(1.0f, -12.4f, -2.5f);
        this.gun142.setTextureSize(64, 32);
        this.gun142.mirror = true;
        this.setRotation(this.gun142, -0.1858931f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun133.render(f5);
        this.gun134.render(f5);
        this.gun135.render(f5);
        this.gun136.render(f5);
        this.gun137.render(f5);
        this.gun138.render(f5);
        this.gun139.render(f5);
        this.gun140.render(f5);
        this.gun141.render(f5);
        this.gun142.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
