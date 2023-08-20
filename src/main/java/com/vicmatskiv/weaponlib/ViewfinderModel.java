package com.vicmatskiv.weaponlib;

import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;

public class ViewfinderModel extends ModelBase
{
    private ModelRenderer surfaceRenderer;
    private FlatSurfaceModelBox box;
    
    public ViewfinderModel() {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.surfaceRenderer = new ModelRenderer((ModelBase)this, 0, 0);
        this.box = new FlatSurfaceModelBox(this.surfaceRenderer, 0, 0, 0.0f, 0.0f, 0.0f, 3, 3, 0, 0.0f);
        this.surfaceRenderer.cubeList.add(this.box);
        this.surfaceRenderer.mirror = true;
        this.surfaceRenderer.setRotationPoint(0.0f, -10.0f, 0.0f);
        this.surfaceRenderer.setTextureSize(100, 100);
        this.setRotation(this.surfaceRenderer, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.surfaceRenderer.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
