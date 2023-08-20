package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Pin extends ModelBase
{
    ModelRenderer Pin1;
    ModelRenderer Pin2;
    ModelRenderer Pin3;
    ModelRenderer Pin4;
    ModelRenderer Pin5;
    ModelRenderer Pin6;
    ModelRenderer Pin7;
    ModelRenderer Pin8;
    ModelRenderer Pin9;
    ModelRenderer Pin10;
    ModelRenderer Pin11;
    ModelRenderer Pin12;
    ModelRenderer Pin13;
    
    public Pin() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.Pin1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Pin1.setRotationPoint(-2.5f, -20.0f, 5.8f);
        this.Pin1.setTextureSize(64, 32);
        this.Pin1.mirror = true;
        this.setRotation(this.Pin1, 0.0f, 0.0f, 0.0f);
        (this.Pin2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Pin2.setRotationPoint(1.2f, -20.3f, 5.3f);
        this.Pin2.setTextureSize(64, 32);
        this.Pin2.mirror = true;
        this.setRotation(this.Pin2, 0.0f, 0.0f, 0.0f);
        (this.Pin3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Pin3.setRotationPoint(1.2f, -17.8f, 8.8f);
        this.Pin3.setTextureSize(64, 32);
        this.Pin3.mirror = true;
        this.setRotation(this.Pin3, 0.0f, 0.0f, 0.0f);
        (this.Pin4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Pin4.setRotationPoint(1.2f, -17.8f, 2.8f);
        this.Pin4.setTextureSize(64, 32);
        this.Pin4.mirror = true;
        this.setRotation(this.Pin4, 0.0f, 0.0f, 0.0f);
        (this.Pin5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Pin5.setRotationPoint(1.2f, -14.3f, 5.3f);
        this.Pin5.setTextureSize(64, 32);
        this.Pin5.mirror = true;
        this.setRotation(this.Pin5, 0.0f, 0.0f, 0.0f);
        (this.Pin6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Pin6.setRotationPoint(1.2f, -17.8f, 9.8f);
        this.Pin6.setTextureSize(64, 32);
        this.Pin6.mirror = true;
        this.setRotation(this.Pin6, -2.528146f, 0.0f, 0.0f);
        (this.Pin7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Pin7.setRotationPoint(1.2f, -20.3f, 7.3f);
        this.Pin7.setTextureSize(64, 32);
        this.Pin7.mirror = true;
        this.setRotation(this.Pin7, -0.6320364f, 0.0f, 0.0f);
        (this.Pin8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Pin8.setRotationPoint(1.2f, -20.3f, 5.3f);
        this.Pin8.setTextureSize(64, 32);
        this.Pin8.mirror = true;
        this.setRotation(this.Pin8, -1.021276f, 0.0f, 0.0f);
        (this.Pin9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Pin9.setRotationPoint(1.2f, -17.8f, 2.8f);
        this.Pin9.setTextureSize(64, 32);
        this.Pin9.mirror = true;
        this.setRotation(this.Pin9, 1.041001f, 0.0f, 0.0f);
        (this.Pin10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Pin10.setRotationPoint(1.2f, -15.8f, 2.8f);
        this.Pin10.setTextureSize(64, 32);
        this.Pin10.mirror = true;
        this.setRotation(this.Pin10, 0.5205006f, 0.0f, 0.0f);
        (this.Pin11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Pin11.setRotationPoint(1.2f, -13.3f, 5.3f);
        this.Pin11.setTextureSize(64, 32);
        this.Pin11.mirror = true;
        this.setRotation(this.Pin11, 2.639681f, 0.0f, 0.0f);
        (this.Pin12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Pin12.setRotationPoint(1.2f, -13.3f, 7.3f);
        this.Pin12.setTextureSize(64, 32);
        this.Pin12.mirror = true;
        this.setRotation(this.Pin12, 2.082002f, 0.0f, 0.0f);
        (this.Pin13 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Pin13.setRotationPoint(1.2f, -15.8f, 9.8f);
        this.Pin13.setTextureSize(64, 32);
        this.Pin13.mirror = true;
        this.setRotation(this.Pin13, -2.082002f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Pin1.render(f5);
        this.Pin2.render(f5);
        this.Pin3.render(f5);
        this.Pin4.render(f5);
        this.Pin5.render(f5);
        this.Pin6.render(f5);
        this.Pin7.render(f5);
        this.Pin8.render(f5);
        this.Pin9.render(f5);
        this.Pin10.render(f5);
        this.Pin11.render(f5);
        this.Pin12.render(f5);
        this.Pin13.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
