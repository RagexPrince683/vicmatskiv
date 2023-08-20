package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class AUGAction extends ModelBase
{
    ModelRenderer AUG103;
    ModelRenderer AUG137;
    ModelRenderer AUG138;
    ModelRenderer AUG139;
    
    public AUGAction() {
        super();
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.AUG103 = new ModelRenderer((ModelBase)this, 0, 100)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 9);
        this.AUG103.setRotationPoint(-4.5f, -9.5f, 10.3f);
        this.AUG103.setTextureSize(64, 32);
        this.AUG103.mirror = true;
        this.setRotation(this.AUG103, 0.0f, 0.0f, -1.021018f);
        (this.AUG137 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.AUG137.setRotationPoint(1.1f, -9.3f, -20.5f);
        this.AUG137.setTextureSize(64, 32);
        this.AUG137.mirror = true;
        this.setRotation(this.AUG137, 0.0f, 0.0f, -0.8870379f);
        (this.AUG138 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.AUG138.setRotationPoint(1.55f, -9.83f, -19.5f);
        this.AUG138.setTextureSize(64, 32);
        this.AUG138.mirror = true;
        this.setRotation(this.AUG138, 0.0f, 0.0f, -0.8870379f);
        (this.AUG139 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.AUG139.setRotationPoint(1.27f, -9.5f, -20.0f);
        this.AUG139.setTextureSize(64, 32);
        this.AUG139.mirror = true;
        this.setRotation(this.AUG139, 0.0f, 0.0f, -0.8870379f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.AUG103.render(f5);
        this.AUG137.render(f5);
        this.AUG138.render(f5);
        this.AUG139.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
