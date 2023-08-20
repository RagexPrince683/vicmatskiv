package com.vicmatskiv.weaponlib.animation;

import java.util.*;
import org.lwjgl.util.vector.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import java.nio.*;

final class Randomizer
{
    private Random random;
    private Matrix4f beforeMatrix;
    private Matrix4f afterMatrix;
    private Matrix4f currentMatrix;
    private long startTime;
    private float rate;
    private float amplitude;
    private float xbias;
    private float ybias;
    private float zbias;
    
    public Randomizer() {
        super();
        this.random = new Random();
        this.rate = 0.25f;
        this.amplitude = 0.04f;
        this.xbias = 0.0f;
        this.ybias = 0.0f;
        this.zbias = 0.0f;
        this.currentMatrix = this.getMatrixForPositioning(() -> {});
        this.next();
    }
    
    private boolean reconfigure(final float rate, final float amplitude) {
        if (rate == this.rate && amplitude == this.amplitude) {
            return false;
        }
        boolean reconfigured = false;
        if (rate != this.rate || amplitude != this.amplitude) {
            if (rate == 0.0f && amplitude == 0.0f) {
                final Matrix4f matrixForPositioning = this.getMatrixForPositioning(() -> {});
                this.currentMatrix = matrixForPositioning;
                this.beforeMatrix = matrixForPositioning;
                this.afterMatrix = matrixForPositioning;
            }
            else {
                reconfigured = true;
            }
        }
        this.rate = rate;
        this.amplitude = amplitude;
        if (reconfigured) {
            this.next();
        }
        return reconfigured;
    }
    
    private void next() {
        this.beforeMatrix = this.currentMatrix;
        this.afterMatrix = this.createRandomMatrix();
        this.startTime = System.currentTimeMillis();
    }
    
    private Matrix4f createRandomMatrix() {
        final Runnable c = () -> {
            final float maxAngle = 5.0f;
            final float xRotation = maxAngle * this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.xbias);
            final float yRotation = maxAngle * this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.ybias);
            final float zRotation = maxAngle * this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.zbias) * 3.0f;
            GL11.glRotatef(xRotation, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(yRotation, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(zRotation, 0.0f, 0.0f, 1.0f);
            final float xRandomOffset = this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.xbias);
            final float yRandomOffset = this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.ybias);
            final float zRandomOffset = this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.zbias) / 3.0f;
            GL11.glTranslatef(xRandomOffset, yRandomOffset, zRandomOffset);
            return;
        };
        return this.getMatrixForPositioning(c);
    }
    
    private Matrix4f getMatrixForPositioning(final Runnable position) {
        GL11.glPushMatrix();
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        final FloatBuffer buf = BufferUtils.createFloatBuffer(16);
        position.run();
        GL11.glGetFloat(2982, buf);
        buf.rewind();
        final Matrix4f matrix = new Matrix4f();
        matrix.load(buf);
        GL11.glPopMatrix();
        return matrix;
    }
    
    public void update(final float rate, final float amplitude) {
        this.reconfigure(rate, amplitude);
        if (rate == 0.0f || amplitude == 0.0f) {
            return;
        }
        final long currentTime = System.currentTimeMillis();
        float progress = (currentTime - this.startTime) * rate / 1000.0f;
        if (progress >= 1.0f) {
            this.next();
            progress = 0.0f;
        }
        final Matrix4f currentTransformMatrix = MatrixHelper.captureMatrix();
        final Matrix4f m1 = MatrixHelper.interpolateMatrix(this.beforeMatrix, 1.0f - progress);
        final Matrix4f m2 = MatrixHelper.interpolateMatrix(this.afterMatrix, progress);
        this.currentMatrix = Matrix4f.add(m1, m2, (Matrix4f)null);
        final Matrix4f composite = Matrix4f.mul(currentTransformMatrix, this.currentMatrix, (Matrix4f)null);
        MatrixHelper.loadMatrix(composite);
    }
    
    private /* synthetic */ void lambda$createRandomMatrix$237() {
        final float maxAngle = 5.0f;
        final float xRotation = maxAngle * this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.xbias);
        final float yRotation = maxAngle * this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.ybias);
        final float zRotation = maxAngle * this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.zbias) * 3.0f;
        GL11.glRotatef(xRotation, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(yRotation, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(zRotation, 0.0f, 0.0f, 1.0f);
        final float xRandomOffset = this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.xbias);
        final float yRandomOffset = this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.ybias);
        final float zRandomOffset = this.amplitude * ((this.random.nextFloat() - 0.5f) * 2.0f + this.zbias) / 3.0f;
        GL11.glTranslatef(xRandomOffset, yRandomOffset, zRandomOffset);
    }
    
    private static /* synthetic */ void lambda$reconfigure$236() {
    }
    
    private static /* synthetic */ void lambda$new$235() {
    }
}
