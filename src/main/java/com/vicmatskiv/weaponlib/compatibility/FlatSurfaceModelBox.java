package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;

public class FlatSurfaceModelBox extends ModelBox
{
    private PositionTextureVertex[] vertexPositions;
    private TexturedQuad quad;
    
    public FlatSurfaceModelBox(final ModelRenderer renderer, final int par2, final int par3, float posX1, float posY1, float posZ1, final int sizeX, final int sizeY, final int sizeZ, final float p_i1171_10_) {
        super(renderer, par2, par3, posX1, posY1, posZ1, sizeX, sizeY, sizeZ, p_i1171_10_);
        this.vertexPositions = new PositionTextureVertex[8];
        float adjX2 = posX1 + sizeX;
        float adjY2 = posY1 + sizeY;
        float adjZ2 = posZ1 + sizeZ;
        posX1 -= p_i1171_10_;
        posY1 -= p_i1171_10_;
        posZ1 -= p_i1171_10_;
        adjX2 += p_i1171_10_;
        adjY2 += p_i1171_10_;
        adjZ2 += p_i1171_10_;
        if (renderer.mirror) {
            final float f7 = adjX2;
            adjX2 = posX1;
            posX1 = f7;
        }
        final PositionTextureVertex backLowerLeft = new PositionTextureVertex(posX1, posY1, adjZ2, 0.0f, 0.0f);
        final PositionTextureVertex backLowerRight = new PositionTextureVertex(adjX2, posY1, adjZ2, 0.0f, 8.0f);
        final PositionTextureVertex backUpperRight = new PositionTextureVertex(adjX2, adjY2, adjZ2, 8.0f, 8.0f);
        final PositionTextureVertex backUpperLeft = new PositionTextureVertex(posX1, adjY2, adjZ2, 8.0f, 0.0f);
        this.vertexPositions[4] = backLowerLeft;
        this.vertexPositions[5] = backLowerRight;
        this.vertexPositions[6] = backUpperRight;
        this.vertexPositions[7] = backUpperLeft;
        this.quad = new TexturedQuad(new PositionTextureVertex[] { backUpperRight, backUpperLeft, backLowerLeft, backLowerRight }, par2 + sizeZ + sizeX + sizeZ, par3 + sizeZ, par2 + sizeZ + sizeX + sizeZ + sizeX, par3 + sizeZ + sizeY, renderer.textureWidth, renderer.textureHeight);
        if (renderer.mirror) {
            this.quad.flipFace();
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void render(final Tessellator tessellator, final float scale) {
        this.quad.draw(tessellator, scale);
    }
    
    public ModelBox func_78244_a(final String p_78244_1_) {
        this.field_78247_g = p_78244_1_;
        return this;
    }
    
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
}
