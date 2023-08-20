package com.vicmatskiv.weaponlib.animation;

import org.lwjgl.util.vector.*;
import org.lwjgl.*;
import org.lwjgl.opengl.*;
import java.nio.*;

public class MatrixHelper
{
    public MatrixHelper() {
        super();
    }
    
    public static void applyMatrix(final Matrix4f m) {
        if (m == null) {
            return;
        }
        final FloatBuffer buf = BufferUtils.createFloatBuffer(16);
        m.store(buf);
        buf.rewind();
        GL11.glMatrixMode(5888);
        GL11.glMultMatrix(buf);
    }
    
    public static void loadMatrix(final Matrix4f m) {
        if (m == null) {
            return;
        }
        final FloatBuffer buf = BufferUtils.createFloatBuffer(16);
        m.store(buf);
        buf.rewind();
        GL11.glMatrixMode(5888);
        GL11.glLoadMatrix(buf);
    }
    
    public static Matrix4f captureMatrix() {
        final FloatBuffer buf = BufferUtils.createFloatBuffer(16);
        GL11.glGetFloat(2982, buf);
        buf.rewind();
        final Matrix4f matrix = new Matrix4f();
        GL11.glMatrixMode(5888);
        matrix.load(buf);
        return matrix;
    }
    
    public static Matrix4f interpolateMatrix(final Matrix4f m, final float factor) {
        final Matrix4f result = new Matrix4f();
        result.m00 = m.m00 * factor;
        result.m01 = m.m01 * factor;
        result.m02 = m.m02 * factor;
        result.m03 = m.m03 * factor;
        result.m10 = m.m10 * factor;
        result.m11 = m.m11 * factor;
        result.m12 = m.m12 * factor;
        result.m13 = m.m13 * factor;
        result.m20 = m.m20 * factor;
        result.m21 = m.m21 * factor;
        result.m22 = m.m22 * factor;
        result.m23 = m.m23 * factor;
        result.m30 = m.m30 * factor;
        result.m31 = m.m31 * factor;
        result.m32 = m.m32 * factor;
        result.m33 = m.m33 * factor;
        return result;
    }
}
