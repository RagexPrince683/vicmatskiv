package com.vicmatskiv.mw.models;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ACRAction2 extends ModelWithAttachments
{
    ModelRenderer ACR96;
    ModelRenderer ACR97;
    ModelRenderer ACR139;
    ModelRenderer ACR140;
    
    public ACRAction2() {
        super();
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.ACR96 = new ModelRenderer((ModelBase)this, 100, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 10);
        this.ACR96.setRotationPoint(-3.6f, -14.5f, -22.0f);
        this.ACR96.setTextureSize(64, 32);
        this.ACR96.mirror = true;
        this.setRotation(this.ACR96, 0.0f, 0.0f, 0.0f);
        (this.ACR97 = new ModelRenderer((ModelBase)this, 100, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 10);
        this.ACR97.setRotationPoint(-3.5f, -15.5f, -22.0f);
        this.ACR97.setTextureSize(64, 32);
        this.ACR97.mirror = true;
        this.setRotation(this.ACR97, 0.0f, 0.0f, 0.0f);
        (this.ACR139 = new ModelRenderer((ModelBase)this, 100, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 14);
        this.ACR139.setRotationPoint(-3.1f, -16.7f, -36.0f);
        this.ACR139.setTextureSize(64, 32);
        this.ACR139.mirror = true;
        this.setRotation(this.ACR139, 0.0f, 0.0f, -0.9294653f);
        (this.ACR140 = new ModelRenderer((ModelBase)this, 100, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 14);
        this.ACR140.setRotationPoint(0.2f, -16.6f, -36.0f);
        this.ACR140.setTextureSize(64, 32);
        this.ACR140.mirror = true;
        this.setRotation(this.ACR140, 0.0f, 0.0f, 2.513274f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.ACR96.render(f5);
        this.ACR97.render(f5);
        this.ACR139.render(f5);
        this.ACR140.render(f5);
    }
}
