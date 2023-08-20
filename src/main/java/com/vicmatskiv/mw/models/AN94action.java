package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class AN94action extends ModelBase
{
    ModelRenderer action1;
    ModelRenderer action2;
    ModelRenderer action3;
    ModelRenderer action4;
    ModelRenderer action5;
    ModelRenderer action6;
    
    public AN94action() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.action1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 16);
        this.action1.setRotationPoint(-3.6f, -13.1f, -33.5f);
        this.action1.setTextureSize(128, 64);
        this.action1.mirror = true;
        this.setRotation(this.action1, 0.0f, 0.0f, -0.7807508f);
        (this.action2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 16);
        this.action2.setRotationPoint(-3.6f, -13.1f, -33.5f);
        this.action2.setTextureSize(128, 64);
        this.action2.mirror = true;
        this.setRotation(this.action2, 0.0f, 0.0f, 0.0f);
        (this.action3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.action3.setRotationPoint(-6.0f, -13.3f, -33.5f);
        this.action3.setTextureSize(128, 64);
        this.action3.mirror = true;
        this.setRotation(this.action3, 0.0f, 0.0f, 0.0f);
        (this.action4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.action4.setRotationPoint(-6.0f, -13.7f, -33.5f);
        this.action4.setTextureSize(128, 64);
        this.action4.mirror = true;
        this.setRotation(this.action4, 0.0f, 0.0f, 0.0f);
        (this.action5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.action5.setRotationPoint(-6.5f, -13.7f, -33.2f);
        this.action5.setTextureSize(128, 64);
        this.action5.mirror = true;
        this.setRotation(this.action5, 0.0f, 0.0f, 0.0f);
        (this.action6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.action6.setRotationPoint(-6.5f, -13.3f, -33.2f);
        this.action6.setTextureSize(128, 64);
        this.action6.mirror = true;
        this.setRotation(this.action6, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.action1.render(f5);
        this.action2.render(f5);
        this.action3.render(f5);
        this.action4.render(f5);
        this.action5.render(f5);
        this.action6.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
