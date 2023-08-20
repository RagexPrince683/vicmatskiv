package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

private static class TexturedQuad
{
    private PositionTextureVertex[] vertexPositions;
    private boolean invertNormal;
    
    public TexturedQuad(final PositionTextureVertex[] vertices) {
        super();
        this.vertexPositions = vertices;
    }
    
    public TexturedQuad(final PositionTextureVertex[] vertices, final int texcoordU1, final int texcoordV1, final int texcoordU2, final int texcoordV2, final float textureWidth, final float textureHeight) {
        this(vertices);
        vertices[0] = vertices[0].setTexturePosition(0.0f, 0.0f);
        vertices[1] = vertices[1].setTexturePosition(1.0f, 0.0f);
        vertices[2] = vertices[2].setTexturePosition(1.0f, 1.0f);
        vertices[3] = vertices[3].setTexturePosition(0.0f, 1.0f);
    }
    
    public void flipFace() {
        final PositionTextureVertex[] apositiontexturevertex = new PositionTextureVertex[this.vertexPositions.length];
        for (int i = 0; i < this.vertexPositions.length; ++i) {
            apositiontexturevertex[i] = this.vertexPositions[this.vertexPositions.length - i - 1];
        }
        this.vertexPositions = apositiontexturevertex;
    }
    
    public void draw(final Tessellator tessellator, final float scale) {
        final Vec3 vec3 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[0].vector3D);
        final Vec3 vec4 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[2].vector3D);
        final Vec3 vec5 = vec4.crossProduct(vec3).normalize();
        tessellator.startDrawingQuads();
        if (this.invertNormal) {
            tessellator.setNormal(-(float)vec5.xCoord, -(float)vec5.yCoord, -(float)vec5.zCoord);
        }
        else {
            tessellator.setNormal((float)vec5.xCoord, (float)vec5.yCoord, (float)vec5.zCoord);
        }
        for (int i = 0; i < 4; ++i) {
            final PositionTextureVertex positiontexturevertex = this.vertexPositions[i];
            tessellator.addVertexWithUV((double)((float)positiontexturevertex.vector3D.xCoord * scale), (double)((float)positiontexturevertex.vector3D.yCoord * scale), (double)((float)positiontexturevertex.vector3D.zCoord * scale), (double)positiontexturevertex.texturePositionX, (double)positiontexturevertex.texturePositionY);
        }
        tessellator.draw();
    }
}
