package com.vicmatskiv.mw.models;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class AK12action extends ModelWithAttachments
{
    ModelRenderer gun74;
    ModelRenderer gun75;
    ModelRenderer gun76;
    ModelRenderer gun77;
    ModelRenderer gun87;
    ModelRenderer gun90;
    
    public AK12action() {
        super();
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.gun74 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 11);
        this.gun74.setRotationPoint(-0.6f, -11.5f, -27.0f);
        this.gun74.setTextureSize(64, 32);
        this.gun74.mirror = true;
        this.setRotation(this.gun74, 0.0f, 0.0f, 0.0f);
        (this.gun75 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 11);
        this.gun75.setRotationPoint(-3.4f, -11.5f, -27.0f);
        this.gun75.setTextureSize(64, 32);
        this.gun75.mirror = true;
        this.setRotation(this.gun75, 0.0f, 0.0f, 0.0f);
        (this.gun76 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 11);
        this.gun76.setRotationPoint(-3.4f, -11.5f, -27.0f);
        this.gun76.setTextureSize(64, 32);
        this.gun76.mirror = true;
        this.setRotation(this.gun76, 0.0f, 0.0f, -1.33843f);
        (this.gun77 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 11);
        this.gun77.setRotationPoint(0.4f, -11.5f, -27.0f);
        this.gun77.setTextureSize(64, 32);
        this.gun77.mirror = true;
        this.setRotation(this.gun77, 0.0f, 0.0f, 2.899932f);
        (this.gun87 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 8);
        this.gun87.setRotationPoint(-3.0f, -13.8f, -35.0f);
        this.gun87.setTextureSize(64, 32);
        this.gun87.mirror = true;
        this.setRotation(this.gun87, 0.0f, 0.0f, 0.0f);
        (this.gun90 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.gun90.setRotationPoint(-0.3f, -13.9f, -34.8f);
        this.gun90.setTextureSize(64, 32);
        this.gun90.mirror = true;
        this.setRotation(this.gun90, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun74.render(f5);
        this.gun75.render(f5);
        this.gun76.render(f5);
        this.gun77.render(f5);
        this.gun87.render(f5);
        this.gun90.render(f5);
    }
}
