package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.item.*;
import java.util.function.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;

public class StaticModelSourceRenderer extends CompatibleStaticModelSourceRenderer
{
    private StaticModelSourceRenderer(final Builder builder) {
        super(builder);
    }
    
    @Override
    protected ModContext getModContext() {
        return this.builder.modContext;
    }
    
    StaticModelSourceRenderer(final Builder x0, final StaticModelSourceRenderer$1 x1) {
        this(x0);
    }
    
    public static class Builder
    {
        private Consumer<ItemStack> entityPositioning;
        private Consumer<ItemStack> inventoryPositioning;
        private BiConsumer<EntityPlayer, ItemStack> thirdPersonPositioning;
        private BiConsumer<EntityPlayer, ItemStack> firstPersonPositioning;
        private BiConsumer<ModelBase, ItemStack> firstPersonModelPositioning;
        private BiConsumer<ModelBase, ItemStack> thirdPersonModelPositioning;
        private BiConsumer<ModelBase, ItemStack> inventoryModelPositioning;
        private BiConsumer<ModelBase, ItemStack> entityModelPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioning;
        private String modId;
        private ModContext modContext;
        
        public Builder() {
            super();
        }
        
        public Builder withModId(final String modId) {
            this.modId = modId;
            return this;
        }
        
        public Builder withModContext(final ModContext modContext) {
            this.modContext = modContext;
            return this;
        }
        
        public Builder withFirstPersonPositioning(final BiConsumer<EntityPlayer, ItemStack> firstPersonPositioning) {
            this.firstPersonPositioning = firstPersonPositioning;
            return this;
        }
        
        public Builder withFirstPersonHandPositioning(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioning = leftHand;
            this.firstPersonRightHandPositioning = rightHand;
            return this;
        }
        
        public Builder withEntityPositioning(final Consumer<ItemStack> entityPositioning) {
            this.entityPositioning = entityPositioning;
            return this;
        }
        
        public Builder withInventoryPositioning(final Consumer<ItemStack> inventoryPositioning) {
            this.inventoryPositioning = inventoryPositioning;
            return this;
        }
        
        public Builder withThirdPersonPositioning(final BiConsumer<EntityPlayer, ItemStack> thirdPersonPositioning) {
            this.thirdPersonPositioning = thirdPersonPositioning;
            return this;
        }
        
        public Builder withFirstPersonModelPositioning(final BiConsumer<ModelBase, ItemStack> firstPersonModelPositioning) {
            this.firstPersonModelPositioning = firstPersonModelPositioning;
            return this;
        }
        
        public Builder withEntityModelPositioning(final BiConsumer<ModelBase, ItemStack> entityModelPositioning) {
            this.entityModelPositioning = entityModelPositioning;
            return this;
        }
        
        public Builder withInventoryModelPositioning(final BiConsumer<ModelBase, ItemStack> inventoryModelPositioning) {
            this.inventoryModelPositioning = inventoryModelPositioning;
            return this;
        }
        
        public Builder withThirdPersonModelPositioning(final BiConsumer<ModelBase, ItemStack> thirdPersonModelPositioning) {
            this.thirdPersonModelPositioning = thirdPersonModelPositioning;
            return this;
        }
        
        public StaticModelSourceRenderer build() {
            if (this.modId == null) {
                throw new IllegalStateException("ModId is not set");
            }
            if (this.inventoryPositioning == null) {
                this.inventoryPositioning = (itemStack -> GL11.glTranslatef(0.0f, 0.12f, 0.0f));
            }
            if (this.entityPositioning == null) {
                this.entityPositioning = (itemStack -> {});
            }
            if (this.firstPersonPositioning == null) {
                this.firstPersonPositioning = ((player, itemStack) -> {});
            }
            if (this.thirdPersonPositioning == null) {
                this.thirdPersonPositioning = ((player, itemStack) -> {});
            }
            if (this.inventoryModelPositioning == null) {
                this.inventoryModelPositioning = ((m, i) -> {});
            }
            if (this.entityModelPositioning == null) {
                this.entityModelPositioning = ((m, i) -> {});
            }
            if (this.firstPersonModelPositioning == null) {
                this.firstPersonModelPositioning = ((m, i) -> {});
            }
            if (this.thirdPersonModelPositioning == null) {
                this.thirdPersonModelPositioning = ((m, i) -> {});
            }
            if (this.firstPersonLeftHandPositioning == null) {
                this.firstPersonLeftHandPositioning = (c -> GL11.glScalef(0.0f, 0.0f, 0.0f));
            }
            if (this.firstPersonRightHandPositioning == null) {
                this.firstPersonRightHandPositioning = (c -> GL11.glScalef(0.0f, 0.0f, 0.0f));
            }
            return new StaticModelSourceRenderer(this, null);
        }
        
        public Consumer<ItemStack> getEntityPositioning() {
            return this.entityPositioning;
        }
        
        public Consumer<ItemStack> getInventoryPositioning() {
            return this.inventoryPositioning;
        }
        
        public BiConsumer<EntityPlayer, ItemStack> getThirdPersonPositioning() {
            return this.thirdPersonPositioning;
        }
        
        public BiConsumer<EntityPlayer, ItemStack> getFirstPersonPositioning() {
            return this.firstPersonPositioning;
        }
        
        public BiConsumer<ModelBase, ItemStack> getFirstPersonModelPositioning() {
            return this.firstPersonModelPositioning;
        }
        
        public BiConsumer<ModelBase, ItemStack> getThirdPersonModelPositioning() {
            return this.thirdPersonModelPositioning;
        }
        
        public BiConsumer<ModelBase, ItemStack> getInventoryModelPositioning() {
            return this.inventoryModelPositioning;
        }
        
        public BiConsumer<ModelBase, ItemStack> getEntityModelPositioning() {
            return this.entityModelPositioning;
        }
        
        public Consumer<RenderContext<RenderableState>> getFirstPersonLeftHandPositioning() {
            return this.firstPersonLeftHandPositioning;
        }
        
        public Consumer<RenderContext<RenderableState>> getFirstPersonRightHandPositioning() {
            return this.firstPersonRightHandPositioning;
        }
        
        public String getModId() {
            return this.modId;
        }
        
        private static /* synthetic */ void lambda$build$260(final RenderContext c) {
            GL11.glScalef(0.0f, 0.0f, 0.0f);
        }
        
        private static /* synthetic */ void lambda$build$259(final RenderContext c) {
            GL11.glScalef(0.0f, 0.0f, 0.0f);
        }
        
        private static /* synthetic */ void lambda$build$258(final ModelBase m, final ItemStack i) {
        }
        
        private static /* synthetic */ void lambda$build$257(final ModelBase m, final ItemStack i) {
        }
        
        private static /* synthetic */ void lambda$build$256(final ModelBase m, final ItemStack i) {
        }
        
        private static /* synthetic */ void lambda$build$255(final ModelBase m, final ItemStack i) {
        }
        
        private static /* synthetic */ void lambda$build$254(final EntityPlayer player, final ItemStack itemStack) {
        }
        
        private static /* synthetic */ void lambda$build$253(final EntityPlayer player, final ItemStack itemStack) {
        }
        
        private static /* synthetic */ void lambda$build$252(final ItemStack itemStack) {
        }
        
        private static /* synthetic */ void lambda$build$251(final ItemStack itemStack) {
            GL11.glTranslatef(0.0f, 0.12f, 0.0f);
        }
        
        static /* synthetic */ ModContext access$100(final Builder x0) {
            return x0.modContext;
        }
    }
}
