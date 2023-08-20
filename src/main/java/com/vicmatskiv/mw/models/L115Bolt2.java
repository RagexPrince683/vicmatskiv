package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class L115Bolt2 extends ModelBase
{
    ModelRenderer gun1;
    ModelRenderer gun2;
    ModelRenderer gun3;
    
    public L115Bolt2() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.gun1 = new ModelRenderer((ModelBase)this, 150, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.gun1.setRotationPoint(1.9f, -16.6f, 6.0f);
        this.gun1.setTextureSize(64, 32);
        this.gun1.mirror = true;
        this.setRotation(this.gun1, 0.0f, 0.0f, 1.226894f);
        (this.gun2 = new ModelRenderer((ModelBase)this, 150, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.gun2.setRotationPoint(-1.0f, -15.5f, 6.0f);
        this.gun2.setTextureSize(64, 32);
        this.gun2.mirror = true;
        this.setRotation(this.gun2, 0.4461411f, 0.2230705f, 1.041002f);
        (this.gun3 = new ModelRenderer((ModelBase)this, 150, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.gun3.setRotationPoint(-2.4f, -14.8f, 7.0f);
        this.gun3.setTextureSize(64, 32);
        this.gun3.mirror = true;
        this.setRotation(this.gun3, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun1.render(f5);
        this.gun2.render(f5);
        this.gun3.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
