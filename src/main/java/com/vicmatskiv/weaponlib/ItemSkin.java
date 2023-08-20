package com.vicmatskiv.weaponlib;

import net.minecraft.client.model.*;
import java.util.*;
import com.vicmatskiv.weaponlib.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.item.*;

public class ItemSkin extends ItemAttachment<Weapon>
{
    private List<String> textureVariants;
    
    public ItemSkin(final String modId, final AttachmentCategory category, final ModelBase model, final String textureName, final String crosshair, final ApplyHandler<Weapon> apply, final ApplyHandler<Weapon> remove) {
        super(modId, category, model, textureName, crosshair, apply, remove);
    }
    
    public String getTextureName() {
        return this.textureName;
    }
    
    public int getTextureVariantIndex(final String name) {
        return this.textureVariants.indexOf(name.toLowerCase());
    }
    
    public String getTextureVariant(final int textureIndex) {
        return (textureIndex >= 0 && textureIndex < this.textureVariants.size()) ? this.textureVariants.get(textureIndex) : null;
    }
    
    static /* synthetic */ List access$002(final ItemSkin x0, final List x1) {
        return x0.textureVariants = x1;
    }
    
    public static final class Builder extends AttachmentBuilder<Weapon>
    {
        private List<String> textureVariants;
        
        public Builder() {
            super();
            this.textureVariants = new ArrayList<String>();
        }
        
        public Builder withTextureVariant(final String... textureVariantNames) {
            for (final String s : textureVariantNames) {
                this.textureVariants.add(AttachmentBuilder.stripFileExtension(s.toLowerCase(), ".png"));
            }
            return this;
        }
        
        @Override
        protected ItemAttachment<Weapon> createAttachment(final ModContext modContext) {
            final ItemSkin skin = new ItemSkin(this.getModId(), AttachmentCategory.SKIN, this.getModel(), this.getTextureName(), null, null, null);
            skin.textureVariants = this.textureVariants;
            return skin;
        }
        
        @Override
        public <V extends ItemAttachment<Weapon>> V build(final ModContext modContext, final Class<V> target) {
            this.model = new FlatModel();
            if (this.textureVariants.isEmpty()) {
                this.textureVariants.add(this.getTextureName());
            }
            else if (this.getTextureName() == null) {
                this.textureName = this.textureVariants.get(0);
            }
            if (this.inventoryPositioning == null) {
                this.withInventoryPositioning(itemStack -> {
                    GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(-0.6f, -0.6f, 0.0f);
                    GL11.glScaled(15.0, 15.0, 15.0);
                    return;
                });
            }
            return super.build(modContext, target);
        }
        
        private static /* synthetic */ void lambda$build$278(final ItemStack itemStack) {
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.6f, -0.6f, 0.0f);
            GL11.glScaled(15.0, 15.0, 15.0);
        }
    }
}
