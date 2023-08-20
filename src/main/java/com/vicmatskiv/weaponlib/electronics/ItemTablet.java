package com.vicmatskiv.weaponlib.electronics;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import java.util.function.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.perspective.*;
import com.vicmatskiv.weaponlib.*;

public class ItemTablet<T> extends ItemAttachment<T> implements PlayerItemInstanceFactory<PlayerTabletInstance, TabletState>, Updatable
{
    private final int DEFAULT_MAX_STACK_SIZE = 1;
    private ModContext modContext;
    private Builder<T> builder;
    
    private ItemTablet(final Builder<T> builder) {
        super(builder.getModId(), AttachmentCategory.SCOPE, builder.getModel(), builder.getTextureName(), null, null, null);
        this.builder = builder;
        this.setMaxStackSize(1);
    }
    
    public float getMinZoom() {
        return ((Builder<Object>)this.builder).minZoom;
    }
    
    public float getMaxZoom() {
        return ((Builder<Object>)this.builder).maxZoom;
    }
    
    public boolean isOptical() {
        return ((Builder<Object>)this.builder).isOpticalZoom;
    }
    
    @Override
    public void update(final EntityPlayer player) {
    }
    
    @Override
    public PlayerTabletInstance createItemInstance(final EntityPlayer player, final ItemStack stack, final int slot) {
        final PlayerTabletInstance instance = new PlayerTabletInstance(slot, player, stack);
        instance.setState(TabletState.READY);
        return instance;
    }
    
    @Override
    public /* bridge */ PlayerItemInstance createItemInstance(final EntityPlayer player, final ItemStack stack, final int slot) {
        return this.createItemInstance(player, stack, slot);
    }
    
    ItemTablet(final Builder x0, final ItemTablet$1 x1) {
        this(x0);
    }
    
    static /* synthetic */ ModContext access$102(final ItemTablet x0, final ModContext x1) {
        return x0.modContext = x1;
    }
    
    public static final class Builder<T> extends AttachmentBuilder<T>
    {
        private float minZoom;
        private float maxZoom;
        private boolean isOpticalZoom;
        private BiConsumer<EntityPlayer, ItemStack> viewfinderPositioning;
        
        public Builder() {
            super();
        }
        
        public Builder<T> withZoomRange(final float minZoom, final float maxZoom) {
            this.minZoom = minZoom;
            this.maxZoom = maxZoom;
            return this;
        }
        
        public Builder<T> withOpticalZoom() {
            this.isOpticalZoom = true;
            return this;
        }
        
        public Builder<T> withViewfinderPositioning(final BiConsumer<EntityPlayer, ItemStack> viewfinderPositioning) {
            this.viewfinderPositioning = viewfinderPositioning;
            return this;
        }
        
        @Override
        protected ItemAttachment<T> createAttachment(final ModContext modContext) {
            if (this.isOpticalZoom) {
                if (this.viewfinderPositioning == null) {
                    this.viewfinderPositioning = ((p, s) -> {
                        GL11.glScalef(3.0f, 3.0f, 3.0f);
                        GL11.glTranslatef(0.1f, 0.5f, 0.1f);
                        return;
                    });
                }
                this.withPostRender(new PerspectiveRenderer(this.viewfinderPositioning));
            }
            final ItemTablet<T> itemTablet = new ItemTablet<T>(this, null);
            ((ItemTablet<Object>)itemTablet).modContext = modContext;
            return itemTablet;
        }
        
        @Override
        public ItemAttachment<T> build(final ModContext modContext) {
            this.apply2 = (ApplyHandler2<T>)((a, instance) -> {
                final float zoom = this.minZoom + (this.maxZoom - this.minZoom) / 2.0f;
                instance.setZoom(zoom);
                return;
            });
            this.remove2 = (ApplyHandler2<T>)((a, instance) -> instance.setZoom(1.0f));
            return super.build(modContext);
        }
        
        private static /* synthetic */ void lambda$build$268(final ItemAttachment a, final PlayerWeaponInstance instance) {
            instance.setZoom(1.0f);
        }
        
        private /* synthetic */ void lambda$build$267(final ItemAttachment a, final PlayerWeaponInstance instance) {
            final float zoom = this.minZoom + (this.maxZoom - this.minZoom) / 2.0f;
            instance.setZoom(zoom);
        }
        
        private static /* synthetic */ void lambda$createAttachment$266(final EntityPlayer p, final ItemStack s) {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.1f, 0.5f, 0.1f);
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
