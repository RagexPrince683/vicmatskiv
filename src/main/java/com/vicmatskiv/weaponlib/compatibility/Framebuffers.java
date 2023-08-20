package com.vicmatskiv.weaponlib.compatibility;

import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class Framebuffers
{
    public Framebuffers() {
        super();
    }
    
    public static int getCurrentFramebuffer() {
        return GL11.glGetInteger(36006);
    }
    
    public static void unbindFramebuffer() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, 0);
        }
    }
    
    public static void bindFramebuffer(final int framebufferId, final boolean depthEnabled, final int width, final int height) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, framebufferId);
            if (depthEnabled) {
                GL11.glViewport(0, 0, width, height);
            }
        }
    }
}
