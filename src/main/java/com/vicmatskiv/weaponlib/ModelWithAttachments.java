package com.vicmatskiv.weaponlib;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelWithAttachments extends ModelBase
{
    public ModelWithAttachments() {
        super();
    }
    
    public void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
