package com.vicmatskiv.weaponlib;

import java.util.function.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.perspective.*;

public static final class Builder extends AttachmentBuilder<Weapon>
{
    private float minZoom;
    private float maxZoom;
    private boolean isOpticalZoom;
    private BiConsumer<EntityPlayer, ItemStack> viewfinderPositioning;
    
    public Builder() {
        super();
    }
    
    public Builder withZoomRange(final float minZoom, final float maxZoom) {
        this.minZoom = minZoom;
        this.maxZoom = maxZoom;
        return this;
    }
    
    public Builder withOpticalZoom() {
        this.isOpticalZoom = true;
        return this;
    }
    
    public Builder withViewfinderPositioning(final BiConsumer<EntityPlayer, ItemStack> viewfinderPositioning) {
        this.viewfinderPositioning = viewfinderPositioning;
        return this;
    }
    
    @Override
    protected ItemAttachment<Weapon> createAttachment(final ModContext modContext) {
        if (this.isOpticalZoom) {
            if (this.viewfinderPositioning == null) {
                this.viewfinderPositioning = ((p, s) -> {
                    GL11.glScalef(1.1f, 1.1f, 1.1f);
                    GL11.glTranslatef(0.1f, 0.4f, 0.6f);
                    return;
                });
            }
            this.withPostRender(new PerspectiveRenderer(this.viewfinderPositioning));
        }
        final ItemScope itemScope = new ItemScope(this, null);
        ItemScope.access$102(itemScope, modContext);
        return itemScope;
    }
    
    @Override
    public ItemAttachment<Weapon> build(final ModContext modContext) {
        this.apply2 = ((a, instance) -> {
            final float zoom = this.minZoom + (this.maxZoom - this.minZoom) / 2.0f;
            instance.setZoom(zoom);
            return;
        });
        this.remove2 = ((a, instance) -> instance.setZoom(1.0f));
        return super.build(modContext);
    }
    
    private static /* synthetic */ void lambda$build$277(final ItemAttachment a, final PlayerWeaponInstance instance) {
        instance.setZoom(1.0f);
    }
    
    private /* synthetic */ void lambda$build$276(final ItemAttachment a, final PlayerWeaponInstance instance) {
        final float zoom = this.minZoom + (this.maxZoom - this.minZoom) / 2.0f;
        instance.setZoom(zoom);
    }
    
    private static /* synthetic */ void lambda$createAttachment$275(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(1.1f, 1.1f, 1.1f);
        GL11.glTranslatef(0.1f, 0.4f, 0.6f);
    }
    
    static /* synthetic */ float access$200(final Builder x0) {
        return x0.minZoom;
    }
    
    static /* synthetic */ float access$300(final Builder x0) {
        return x0.maxZoom;
    }
    
    static /* synthetic */ boolean access$400(final Builder x0) {
        return x0.isOpticalZoom;
    }
}
