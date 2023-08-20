package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import java.util.*;

public class ModelBipedWithAttachments extends CompatibleModelBiped
{
    public ModelBipedWithAttachments(final ModelBiped delegate) {
        super(delegate);
    }
    
    public int hashCode() {
        return this.delegate.hashCode();
    }
    
    public void setLivingAnimations(final EntityLivingBase p_78086_1_, final float p_78086_2_, final float p_78086_3_, final float p_78086_4_) {
        this.delegate.setLivingAnimations(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
    }
    
    public ModelRenderer getRandomModelBox(final Random p_85181_1_) {
        return this.delegate.getRandomModelBox(p_85181_1_);
    }
    
    public TextureOffset getTextureOffset(final String p_78084_1_) {
        return this.delegate.getTextureOffset(p_78084_1_);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.delegate.render(entity, f, f1, f2, f3, f4, f5);
    }
    
    public boolean equals(final Object obj) {
        return this.delegate.equals(obj);
    }
    
    public void setRotationAngles(final float p_78087_1_, final float p_78087_2_, final float p_78087_3_, final float p_78087_4_, final float p_78087_5_, final float p_78087_6_, final Entity p_78087_7_) {
        this.delegate.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
    }
    
    public String toString() {
        return this.delegate.toString();
    }
    
    public void renderAttachments(final String modId, final List<CompatibleAttachment<?>> attachments, final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        for (final CompatibleAttachment<?> compatibleAttachment : attachments) {
            if (compatibleAttachment != null) {
                for (final Tuple<ModelBase, String> texturedModel : compatibleAttachment.getAttachment().getTexturedModels()) {
                    Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(modId + ":textures/models/" + texturedModel.getV()));
                    GL11.glPushMatrix();
                    if (compatibleAttachment.getModelPositioning() != null) {
                        compatibleAttachment.getModelPositioning().accept(texturedModel.getU());
                    }
                    texturedModel.getU().render(entity, f, f1, f2, f3, f4, f5);
                    GL11.glPopMatrix();
                }
            }
        }
    }
}
