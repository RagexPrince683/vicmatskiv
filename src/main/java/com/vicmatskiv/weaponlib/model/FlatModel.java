package com.vicmatskiv.weaponlib.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class FlatModel extends ModelBase
{
    private ModelRenderer gun1;
    
    public FlatModel() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.gun1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 0);
        this.gun1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.gun1.setTextureSize(64, 64);
        this.gun1.mirror = true;
        this.setRotation(this.gun1, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.gun1.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
