package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class MakarovMag extends ModelBase
{
    ModelRenderer gun1;
    ModelRenderer gun2;
    ModelRenderer gun4;
    ModelRenderer gun5;
    ModelRenderer gun7;
    ModelRenderer gun10;
    ModelRenderer gun11;
    ModelRenderer gun12;
    ModelRenderer gun13;
    ModelRenderer gun14;
    ModelRenderer gun15;
    ModelRenderer gun18;
    ModelRenderer gun19;
    ModelRenderer gun20;
    ModelRenderer gun21;
    ModelRenderer gun22;
    ModelRenderer gun23;
    
    public MakarovMag() {
        super();
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.gun1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 6);
        this.gun1.setRotationPoint(-3.5f, 5.5f, -5.2f);
        this.gun1.setTextureSize(64, 32);
        this.gun1.mirror = true;
        this.setRotation(this.gun1, 0.1487144f, 0.0f, 0.0f);
        (this.gun2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 13, 1);
        this.gun2.setRotationPoint(-3.3f, -6.0f, -7.0f);
        this.gun2.setTextureSize(64, 32);
        this.gun2.mirror = true;
        this.setRotation(this.gun2, 0.2230717f, 0.0f, 0.0f);
        (this.gun4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.gun4.setRotationPoint(-3.3f, 5.5f, -2.5f);
        this.gun4.setTextureSize(64, 32);
        this.gun4.mirror = true;
        this.setRotation(this.gun4, 0.0f, 0.0f, 0.0f);
        (this.gun5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.gun5.setRotationPoint(-0.7f, -6.0f, -7.0f);
        this.gun5.setTextureSize(64, 32);
        this.gun5.mirror = true;
        this.setRotation(this.gun5, 0.2230717f, 0.0f, 0.0f);
        (this.gun7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.gun7.setRotationPoint(-0.7f, 5.5f, -2.5f);
        this.gun7.setTextureSize(64, 32);
        this.gun7.mirror = true;
        this.setRotation(this.gun7, 0.0f, 0.0f, 0.0f);
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
        (this.gun12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 3);
        this.gun12.setRotationPoint(-0.7f, -7.6f, -5.2f);
        this.gun12.setTextureSize(64, 32);
        this.gun12.mirror = true;
        this.setRotation(this.gun12, 0.0f, 0.0f, 0.0f);
        (this.gun13 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 3);
        this.gun13.setRotationPoint(-3.3f, -7.6f, -5.2f);
        this.gun13.setTextureSize(64, 32);
        this.gun13.mirror = true;
        this.setRotation(this.gun13, 0.0f, 0.0f, 0.0f);
        (this.gun14 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 13, 3);
        this.gun14.setRotationPoint(-3.3f, -6.5f, -5.1f);
        this.gun14.setTextureSize(64, 32);
        this.gun14.mirror = true;
        this.setRotation(this.gun14, 0.2230717f, 0.0f, 0.0f);
        (this.gun15 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 13, 3);
        this.gun15.setRotationPoint(-0.7f, -6.5f, -5.1f);
        this.gun15.setTextureSize(64, 32);
        this.gun15.mirror = true;
        this.setRotation(this.gun15, 0.2230717f, 0.0f, 0.0f);
        (this.gun18 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 1, 13, 2);
        this.gun18.setRotationPoint(-3.1f, -6.0f, -6.5f);
        this.gun18.setTextureSize(64, 32);
        this.gun18.mirror = true;
        this.setRotation(this.gun18, 0.2230717f, 0.0f, 0.0f);
        (this.gun19 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 1, 13, 2);
        this.gun19.setRotationPoint(-0.9f, -6.0f, -6.5f);
        this.gun19.setTextureSize(64, 32);
        this.gun19.mirror = true;
        this.setRotation(this.gun19, 0.2230717f, 0.0f, 0.0f);
        (this.gun20 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.gun20.setRotationPoint(-3.3f, 2.5f, -4.5f);
        this.gun20.setTextureSize(64, 32);
        this.gun20.mirror = true;
        this.setRotation(this.gun20, 0.2230717f, 0.0f, 0.0f);
        (this.gun21 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.gun21.setRotationPoint(-0.7f, 2.5f, -4.5f);
        this.gun21.setTextureSize(64, 32);
        this.gun21.mirror = true;
        this.setRotation(this.gun21, 0.2230717f, 0.0f, 0.0f);
        (this.gun22 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.gun22.setRotationPoint(-0.7f, -6.1f, -6.5f);
        this.gun22.setTextureSize(64, 32);
        this.gun22.mirror = true;
        this.setRotation(this.gun22, 0.2230717f, 0.0f, 0.0f);
        (this.gun23 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.gun23.setRotationPoint(-3.3f, -6.1f, -6.5f);
        this.gun23.setTextureSize(64, 32);
        this.gun23.mirror = true;
        this.setRotation(this.gun23, 0.2230717f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun1.render(f5);
        this.gun2.render(f5);
        this.gun4.render(f5);
        this.gun5.render(f5);
        this.gun7.render(f5);
        this.gun10.render(f5);
        this.gun11.render(f5);
        this.gun12.render(f5);
        this.gun13.render(f5);
        this.gun14.render(f5);
        this.gun15.render(f5);
        this.gun18.render(f5);
        this.gun19.render(f5);
        this.gun20.render(f5);
        this.gun21.render(f5);
        this.gun22.render(f5);
        this.gun23.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
