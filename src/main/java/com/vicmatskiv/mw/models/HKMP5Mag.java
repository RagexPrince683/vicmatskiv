package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class HKMP5Mag extends ModelBase
{
    ModelRenderer Magazine1;
    ModelRenderer Magazine2;
    ModelRenderer Magazine3;
    ModelRenderer Magazine4;
    ModelRenderer Magazine5;
    ModelRenderer Magazine6;
    ModelRenderer Magazine7;
    
    public HKMP5Mag() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Magazine1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 12);
        this.Magazine1.setRotationPoint(-3.5f, 1.0f, -24.2f);
        this.Magazine1.setTextureSize(128, 128);
        this.Magazine1.mirror = true;
        this.setRotation(this.Magazine1, 1.375609f, 0.0f, 0.0f);
        (this.Magazine2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 3, 12);
        this.Magazine2.setRotationPoint(-3.5f, 2.0f, -19.3f);
        this.Magazine2.setTextureSize(128, 128);
        this.Magazine2.mirror = true;
        this.setRotation(this.Magazine2, -2.044824f, 0.0f, 0.0f);
        (this.Magazine3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 12);
        this.Magazine3.setRotationPoint(-3.5f, 0.3f, -22.8f);
        this.Magazine3.setTextureSize(128, 128);
        this.Magazine3.mirror = true;
        this.setRotation(this.Magazine3, -2.044824f, 0.0f, 0.0f);
        (this.Magazine4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 3, 12);
        this.Magazine4.setRotationPoint(-3.5f, 1.4f, -22.2f);
        this.Magazine4.setTextureSize(128, 128);
        this.Magazine4.mirror = true;
        this.setRotation(this.Magazine4, 1.375609f, 0.0f, 0.0f);
        (this.Magazine5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 1);
        this.Magazine5.setRotationPoint(-3.5f, 10.75f, -26.4f);
        this.Magazine5.setTextureSize(128, 128);
        this.Magazine5.mirror = true;
        this.setRotation(this.Magazine5, -2.044824f, 0.0f, 0.0f);
        (this.Magazine6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 12);
        this.Magazine6.setRotationPoint(-3.0f, 0.3f, -21.8f);
        this.Magazine6.setTextureSize(128, 128);
        this.Magazine6.mirror = true;
        this.setRotation(this.Magazine6, -2.044824f, 0.0f, 0.0f);
        (this.Magazine7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 12);
        this.Magazine7.setRotationPoint(-3.0f, 1.2f, -23.5f);
        this.Magazine7.setTextureSize(128, 128);
        this.Magazine7.mirror = true;
        this.setRotation(this.Magazine7, 1.375609f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Magazine1.render(f5);
        this.Magazine2.render(f5);
        this.Magazine3.render(f5);
        this.Magazine4.render(f5);
        this.Magazine5.render(f5);
        this.Magazine6.render(f5);
        this.Magazine7.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
