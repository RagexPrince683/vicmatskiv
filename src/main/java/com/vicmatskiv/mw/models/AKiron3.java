package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class AKiron3 extends ModelBase
{
    ModelRenderer Iron1;
    ModelRenderer Iron2;
    ModelRenderer Iron3;
    ModelRenderer Iron4;
    ModelRenderer Iron5;
    ModelRenderer Iron6;
    ModelRenderer Iron7;
    
    public AKiron3() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Iron1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 8, 1);
        this.Iron1.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.Iron1.setTextureSize(64, 32);
        this.Iron1.mirror = true;
        this.setRotation(this.Iron1, 0.0f, 0.0f, 0.0f);
        (this.Iron2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.Iron2.setRotationPoint(0.0f, -5.0f, 1.0f);
        this.Iron2.setTextureSize(64, 32);
        this.Iron2.mirror = true;
        this.setRotation(this.Iron2, 0.0f, 0.0f, 0.0f);
        (this.Iron3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 8);
        this.Iron3.setRotationPoint(0.0f, -5.0f, 3.0f);
        this.Iron3.setTextureSize(64, 32);
        this.Iron3.mirror = true;
        this.setRotation(this.Iron3, -1.189716f, 0.0f, 0.0f);
        (this.Iron4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.Iron4.setRotationPoint(0.0f, -3.0f, 2.8f);
        this.Iron4.setTextureSize(64, 32);
        this.Iron4.mirror = true;
        this.setRotation(this.Iron4, 0.0f, 0.0f, 0.0f);
        (this.Iron5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 5);
        this.Iron5.setRotationPoint(0.0f, 2.0f, 1.0f);
        this.Iron5.setTextureSize(64, 32);
        this.Iron5.mirror = true;
        this.setRotation(this.Iron5, 0.0f, 0.0f, 0.0f);
        (this.Iron6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.Iron6.setRotationPoint(0.0f, 0.0f, 4.0f);
        this.Iron6.setTextureSize(64, 32);
        this.Iron6.mirror = true;
        this.setRotation(this.Iron6, 0.0f, 0.0f, 0.0f);
        (this.Iron7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 3);
        this.Iron7.setRotationPoint(0.0f, -1.5f, 1.0f);
        this.Iron7.setTextureSize(64, 32);
        this.Iron7.mirror = true;
        this.setRotation(this.Iron7, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Iron1.render(f5);
        this.Iron2.render(f5);
        this.Iron3.render(f5);
        this.Iron4.render(f5);
        this.Iron5.render(f5);
        this.Iron6.render(f5);
        this.Iron7.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
