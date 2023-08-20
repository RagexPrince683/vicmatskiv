package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Magazine545x39 extends ModelBase
{
    ModelRenderer Magazine1;
    ModelRenderer Magazine4;
    ModelRenderer Magazine5;
    ModelRenderer Magazine7;
    
    public Magazine545x39() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.Magazine1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 11, 7);
        this.Magazine1.setRotationPoint(-3.5f, -8.0f, -25.0f);
        this.Magazine1.setTextureSize(64, 32);
        this.Magazine1.mirror = true;
        this.setRotation(this.Magazine1, -0.1858931f, 0.0f, 0.0f);
        (this.Magazine4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 7, 12);
        this.Magazine4.setRotationPoint(-3.5f, 4.0f, -20.1f);
        this.Magazine4.setTextureSize(64, 32);
        this.Magazine4.mirror = true;
        this.setRotation(this.Magazine4, -2.082002f, 0.0f, 0.0f);
        (this.Magazine5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 11, 2);
        this.Magazine5.setRotationPoint(-3.0f, -8.3f, -26.6f);
        this.Magazine5.setTextureSize(64, 32);
        this.Magazine5.mirror = true;
        this.setRotation(this.Magazine5, -0.1858931f, 0.0f, 0.0f);
        (this.Magazine7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 11);
        this.Magazine7.setRotationPoint(-3.0f, 1.6f, -26.5f);
        this.Magazine7.setTextureSize(64, 32);
        this.Magazine7.mirror = true;
        this.setRotation(this.Magazine7, -2.082002f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Magazine1.render(f5);
        this.Magazine4.render(f5);
        this.Magazine5.render(f5);
        this.Magazine7.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
