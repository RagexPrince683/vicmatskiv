package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.renderer.*;

public class CompatibleTessellator
{
    private static Tessellator tessellator;
    private static CompatibleTessellator compatibleTesselator;
    
    public CompatibleTessellator() {
        super();
    }
    
    public static CompatibleTessellator getInstance() {
        return CompatibleTessellator.compatibleTesselator;
    }
    
    public void startDrawingQuads() {
        CompatibleTessellator.tessellator.startDrawingQuads();
    }
    
    public void startDrawingParticles() {
        CompatibleTessellator.tessellator.startDrawing(7);
    }
    
    public void startDrawingLines() {
        CompatibleTessellator.tessellator.startDrawing(1);
    }
    
    public void addVertexWithUV(final double d, final double e, final double zLevel, final float i, final float j) {
        CompatibleTessellator.tessellator.addVertexWithUV(d, e, zLevel, (double)i, (double)j);
    }
    
    public void draw() {
        CompatibleTessellator.tessellator.draw();
    }
    
    public void setLightMap(final int j, final int k) {
        CompatibleTessellator.tessellator.setBrightness(200);
    }
    
    public void setColorRgba(final float red, final float green, final float blue, final float alpha) {
        CompatibleTessellator.tessellator.setColorRGBA_F(red, green, blue, alpha);
    }
    
    public void addVertex(final float x, final float y, final float z) {
        CompatibleTessellator.tessellator.addVertex((double)x, (double)y, (double)z);
    }
    
    public void endVertex() {
    }
    
    static {
        CompatibleTessellator.tessellator = Tessellator.instance;
        CompatibleTessellator.compatibleTesselator = new CompatibleTessellator();
    }
}
