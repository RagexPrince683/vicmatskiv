package com.vicmatskiv.weaponlib;

import java.util.function.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.perspective.*;

public class ItemScope extends ItemAttachment<Weapon>
{
    private final int DEFAULT_MAX_STACK_SIZE = 1;
    private ModContext modContext;
    private Builder builder;
    
    private ItemScope(final Builder builder) {
        super(builder.getModId(), AttachmentCategory.SCOPE, builder.getModel(), builder.getTextureName(), null, null, null);
        this.builder = builder;
        this.setMaxStackSize(1);
    }
    
    public float getMinZoom() {
        return this.builder.minZoom;
    }
    
    public float getMaxZoom() {
        return this.builder.maxZoom;
    }
    
    public boolean isOptical() {
        return this.builder.isOpticalZoom;
    }
    
    ItemScope(final Builder x0, final ItemScope$1 x1) {
        this(x0);
    }
    
    static /* synthetic */ ModContext access$102(final ItemScope x0, final ModContext x1) {
        return x0.modContext = x1;
    }
    
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
            itemScope.modContext = modContext;
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
}
