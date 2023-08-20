package com.vicmatskiv.mw.models;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class FamasAction extends ModelWithAttachments
{
    ModelRenderer Famas280;
    ModelRenderer Famas281;
    ModelRenderer Famas282;
    ModelRenderer Famas283;
    ModelRenderer Famas284;
    ModelRenderer Famas285;
    ModelRenderer Famas286;
    ModelRenderer Famas287;
    
    public FamasAction() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.Famas280 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.Famas280.setRotationPoint(-2.0f, -15.7f, -19.0f);
        this.Famas280.setTextureSize(64, 32);
        this.Famas280.mirror = true;
        this.setRotation(this.Famas280, 0.0f, 0.0f, 0.0f);
        (this.Famas281 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 1);
        this.Famas281.setRotationPoint(-2.5f, -17.6f, -19.0f);
        this.Famas281.setTextureSize(64, 32);
        this.Famas281.mirror = true;
        this.setRotation(this.Famas281, -0.2230717f, 0.0f, 0.0f);
        (this.Famas282 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.Famas282.setRotationPoint(-2.5f, -17.6f, -19.0f);
        this.Famas282.setTextureSize(64, 32);
        this.Famas282.mirror = true;
        this.setRotation(this.Famas282, 1.003822f, 0.0f, 0.0f);
        (this.Famas283 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.Famas283.setRotationPoint(-2.5f, -19.3f, -17.9f);
        this.Famas283.setTextureSize(64, 32);
        this.Famas283.mirror = true;
        this.setRotation(this.Famas283, 0.3717861f, 0.0f, 0.0f);
        (this.Famas284 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 1);
        this.Famas284.setRotationPoint(-2.5f, -17.6f, -19.0f);
        this.Famas284.setTextureSize(64, 32);
        this.Famas284.mirror = true;
        this.setRotation(this.Famas284, 0.1487144f, 0.0f, 0.0f);
        (this.Famas285 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.Famas285.setRotationPoint(-2.0f, -15.7f, -13.0f);
        this.Famas285.setTextureSize(64, 32);
        this.Famas285.mirror = true;
        this.setRotation(this.Famas285, -1.747395f, 0.0f, 0.0f);
        (this.Famas286 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.Famas286.setRotationPoint(-2.5f, -15.6f, -18.5f);
        this.Famas286.setTextureSize(64, 32);
        this.Famas286.mirror = true;
        this.setRotation(this.Famas286, 0.0f, 0.0f, 0.0f);
        (this.Famas287 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.Famas287.setRotationPoint(-2.5f, -15.6f, -16.5f);
        this.Famas287.setTextureSize(64, 32);
        this.Famas287.mirror = true;
        this.setRotation(this.Famas287, -2.156359f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Famas280.render(f5);
        this.Famas281.render(f5);
        this.Famas282.render(f5);
        this.Famas283.render(f5);
        this.Famas284.render(f5);
        this.Famas285.render(f5);
        this.Famas286.render(f5);
        this.Famas287.render(f5);
    }
}
