package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;

public abstract class CompatibleEntityRenderer extends Render
{
    public CompatibleEntityRenderer() {
        super();
    }
    
    public final void doRender(final Entity entity, final double x, final double y, final double z, final float entityYaw, final float partialTicks) {
        this.doCompatibleRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    protected abstract void doCompatibleRender(final Entity p0, final double p1, final double p2, final double p3, final float p4, final float p5);
}
