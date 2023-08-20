package com.vicmatskiv.weaponlib;

import java.util.function.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import java.util.*;

public class LaserBeamRenderer implements CustomRenderer
{
    private float xOffset;
    private float yOffset;
    private float zOffset;
    private BiConsumer<EntityPlayer, ItemStack> positioning;
    
    public LaserBeamRenderer(final BiConsumer<EntityPlayer, ItemStack> positioning) {
        super();
        this.xOffset = 0.5f;
        this.yOffset = -1.3f;
        this.zOffset = -1.7f;
        this.positioning = positioning;
    }
    
    @Override
    public void render(final RenderContext renderContext) {
        final PlayerItemInstance<?> instance = renderContext.getPlayerItemInstance();
        final CompatibleTransformType type = renderContext.getCompatibleTransformType();
        if (instance instanceof PlayerWeaponInstance && ((PlayerWeaponInstance)instance).isLaserOn() && (type == CompatibleTransformType.THIRD_PERSON_LEFT_HAND || type == CompatibleTransformType.THIRD_PERSON_RIGHT_HAND || type == CompatibleTransformType.FIRST_PERSON_LEFT_HAND || type == CompatibleTransformType.FIRST_PERSON_RIGHT_HAND || type == CompatibleTransformType.GROUND)) {
            GL11.glPushMatrix();
            GL11.glPushAttrib(1048575);
            GL11.glDisable(2884);
            GL11.glDisable(2896);
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.5f);
            GL11.glLineWidth(1.5f);
            GL11.glDepthMask(false);
            if (this.positioning != null) {
                this.positioning.accept(renderContext.getPlayer(), renderContext.getWeapon());
            }
            final CompatibleTessellator tessellator = CompatibleTessellator.getInstance();
            tessellator.startDrawingLines();
            final long time = System.currentTimeMillis();
            final Random random = new Random(time - time % 300L);
            float start = this.zOffset;
            final float length = 100.0f;
            float end = 0.0f;
            for (int i = 0; i < 100 && start < length && end < length; start = end + random.nextFloat() * 0.5f, ++i) {
                tessellator.addVertex(this.xOffset, this.yOffset, start);
                tessellator.endVertex();
                final int ii = 15728880;
                final int j = ii >> 16 & 0xFFFF;
                final int k = ii & 0xFFFF;
                tessellator.setLightMap(j, k);
                end = start - (1.0f + random.nextFloat() * 2.0f);
                if (end > length) {
                    end = length;
                }
                tessellator.addVertex(this.xOffset, this.yOffset, end);
                tessellator.endVertex();
            }
            tessellator.draw();
            GL11.glDepthMask(true);
            GL11.glPopAttrib();
            GL11.glPopMatrix();
        }
    }
}
