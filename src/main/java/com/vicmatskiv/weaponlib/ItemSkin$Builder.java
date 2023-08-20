package com.vicmatskiv.weaponlib;

import java.util.*;
import com.vicmatskiv.weaponlib.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.item.*;

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
        ItemSkin.access$002(skin, this.textureVariants);
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
