package com.vicmatskiv.weaponlib.animation;

import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.tracking.*;
import org.lwjgl.util.vector.*;
import org.apache.logging.log4j.*;
import java.util.*;

public class DebugPositioner
{
    private static final Logger logger;
    private static final String WEAPONLIB_DEBUG_PROPERTY = "weaponlib.debug";
    private static Boolean debugModeEnabled;
    private static Part currentPart;
    private static Entity watchableEntity;
    private static Map<Part, Position> partPositions;
    private static Map<Integer, TransitionConfiguration> transitionConfigurations;
    
    public DebugPositioner() {
        super();
    }
    
    private static Position getCurrentPartPosition() {
        return DebugPositioner.partPositions.get(DebugPositioner.currentPart);
    }
    
    public static void incrementXRotation(final float increment) {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        final Position position = partPosition;
        position.xRotation += increment;
        DebugPositioner.logger.debug("Debug rotations: ({}, {}, {}) ", new Object[] { partPosition.xRotation, partPosition.yRotation, partPosition.zRotation });
    }
    
    public static void incrementYRotation(final float increment) {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        final Position position = partPosition;
        position.yRotation += increment;
        DebugPositioner.logger.debug("Debug rotations: ({}, {}, {}) ", new Object[] { partPosition.xRotation, partPosition.yRotation, partPosition.zRotation });
    }
    
    public static void incrementZRotation(final float increment) {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        final Position position = partPosition;
        position.zRotation += increment;
        DebugPositioner.logger.debug("Debug rotations: ({}, {}, {}) ", new Object[] { partPosition.xRotation, partPosition.yRotation, partPosition.zRotation });
    }
    
    public static void incrementXPosition(final float increment) {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        final Position position = partPosition;
        position.x += partPosition.step * increment;
        DebugPositioner.logger.debug("Debug position: ({}, {}, {}) ", new Object[] { partPosition.x, partPosition.y, partPosition.z });
    }
    
    public static void incrementYPosition(final float increment) {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        final Position position = partPosition;
        position.y += partPosition.step * increment;
        DebugPositioner.logger.debug("Debug position: ({}, {}, {}) ", new Object[] { partPosition.x, partPosition.y, partPosition.z });
    }
    
    public static void incrementZPosition(final float increment) {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        final Position position = partPosition;
        position.z += partPosition.step * increment;
        DebugPositioner.logger.debug("Debug position: ({}, {}, {}) ", new Object[] { partPosition.x, partPosition.y, partPosition.z });
    }
    
    public static void setScale(final float scale) {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        partPosition.scale = scale;
        DebugPositioner.logger.debug("Scale set to {}", new Object[] { scale });
    }
    
    public static void setStep(final float step) {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        partPosition.step = step;
        DebugPositioner.logger.debug("Step set to {}", new Object[] { step });
    }
    
    public static void setDebugMode(final boolean enabled) {
        DebugPositioner.debugModeEnabled = enabled;
        if (DebugPositioner.debugModeEnabled) {
            KeyBindings.bindDebugKeys();
        }
    }
    
    public static boolean isDebugModeEnabled() {
        if (DebugPositioner.debugModeEnabled == null) {
            DebugPositioner.debugModeEnabled = Boolean.getBoolean("weaponlib.debug");
        }
        return DebugPositioner.debugModeEnabled;
    }
    
    public static void reset() {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        DebugPositioner.transitionConfigurations.clear();
        partPosition.x = (partPosition.y = (partPosition.z = (partPosition.xRotation = (partPosition.yRotation = (partPosition.zRotation = 0.0f)))));
        partPosition.scale = 1.0f;
        partPosition.step = 0.025f;
    }
    
    public static void setDebugPart(final Part part) {
        DebugPositioner.currentPart = part;
        DebugPositioner.partPositions.computeIfAbsent(part, p -> new Position());
    }
    
    public static Part getDebugPart() {
        return DebugPositioner.currentPart;
    }
    
    public static void configureTransitionPause(final int transitionNumber, final long pause) {
        final TransitionConfiguration transitionConfiguration = getTransitionConfiguration(transitionNumber, true);
        transitionConfiguration.pause = pause;
    }
    
    public static TransitionConfiguration getTransitionConfiguration(final int transitionNumber, final boolean init) {
        return DebugPositioner.transitionConfigurations.computeIfAbsent(Integer.valueOf(transitionNumber), k -> {
            Object o2 = null;
            if (init) {
                new DebugPositioner.TransitionConfiguration();
                new TransitionConfiguration();
            }
            else {
                o2 = null;
            }
            return (TransitionConfiguration) o2;
        });
    }
    
    public static void position(final Part part, final RenderContext<?> renderContext) {
        if (part != DebugPositioner.currentPart) {
            return;
        }
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            return;
        }
        GL11.glScalef(partPosition.scale, partPosition.scale, partPosition.scale);
        GL11.glRotatef(partPosition.xRotation, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(partPosition.yRotation, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(partPosition.zRotation, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(partPosition.x, partPosition.y, partPosition.z);
    }
    
    public static void showCode() {
        final Position partPosition = getCurrentPartPosition();
        if (partPosition == null) {
            return;
        }
        final StringBuilder result = new StringBuilder();
        result.append(String.format("GL11.glScalef(%ff, %ff, %ff);\n", partPosition.scale, partPosition.scale, partPosition.scale));
        result.append(String.format("GL11.glRotatef(%ff, 1f, 0f, 0f);\n", partPosition.xRotation));
        result.append(String.format("GL11.glRotatef(%ff, 0f, 1f, 0f);\n", partPosition.yRotation));
        result.append(String.format("GL11.glRotatef(%ff, 0f, 0f, 1f);\n", partPosition.zRotation));
        result.append(String.format("GL11.glTranslatef(%ff, %ff, %ff);", partPosition.x, partPosition.y, partPosition.z));
        DebugPositioner.logger.debug("Generated positioning code: \n" + (Object)result);
        System.out.println("\n" + (Object)result);
    }
    
    public static void watch() {
        final PlayerEntityTracker tracker = PlayerEntityTracker.getTracker(CompatibilityProvider.compatibility.clientPlayer());
        System.out.println("Trackable entities: " + tracker.getTrackableEntitites());
    }
    
    public static Entity getWatchableEntity() {
        return DebugPositioner.watchableEntity;
    }
    
    public static void showCurrentMatrix(final String message) {
        showCurrentMatrix(null, message);
    }
    
    public static void showCurrentMatrix(final Object part, final String message) {
        if (part != null && part != DebugPositioner.currentPart) {
            return;
        }
        final Matrix4f preparedPositionMatrix = MatrixHelper.captureMatrix();
        DebugPositioner.logger.trace("Current matrix: {} {}", new Object[] { message, formatMatrix(preparedPositionMatrix) });
    }
    
    public static String formatMatrix(final Matrix4f m) {
        final StringBuilder buf = new StringBuilder();
        buf.append("\n");
        buf.append(String.format("%4.2f %4.2f %4.2f %4.2f\n", m.m00, m.m10, m.m20, m.m30));
        buf.append(String.format("%4.2f %4.2f %4.2f %4.2f\n", m.m01, m.m11, m.m21, m.m31));
        buf.append(String.format("%4.2f %4.2f %4.2f %4.2f\n", m.m02, m.m12, m.m22, m.m32));
        buf.append(String.format("%4.2f %4.2f %4.2f %4.2f\n", m.m03, m.m13, m.m23, m.m33));
        return buf.toString();
    }
    
    private static /* synthetic */ TransitionConfiguration lambda$getTransitionConfiguration$1(final boolean b, final Integer k) {
        return b ? new TransitionConfiguration() : null;
    }
    
    private static /* synthetic */ Position lambda$setDebugPart$0(final Part p) {
        return new Position();
    }
    
    static {
        logger = LogManager.getLogger((Class)DebugPositioner.class);
        DebugPositioner.partPositions = new HashMap<Part, Position>();
        DebugPositioner.transitionConfigurations = new HashMap<Integer, TransitionConfiguration>();
    }
    
    public static final class TransitionConfiguration
    {
        private long pause;
        
        public TransitionConfiguration() {
            super();
        }
        
        public long getPause() {
            return this.pause;
        }
        
        public void setPause(final long pause) {
            this.pause = pause;
        }
        
        static /* synthetic */ long access$802(final TransitionConfiguration x0, final long x1) {
            return x0.pause = x1;
        }
    }
    
    private static class Position
    {
        private float xRotation;
        private float yRotation;
        private float zRotation;
        private float x;
        private float y;
        private float z;
        private float scale;
        private float step;
        
        private Position() {
            super();
            this.scale = 1.0f;
            this.step = 0.025f;
        }
        
        static /* synthetic */ float access$000(final Position x0) {
            return x0.xRotation;
        }
        
        static /* synthetic */ float access$002(final Position x0, final float x1) {
            return x0.xRotation = x1;
        }
        
        static /* synthetic */ float access$100(final Position x0) {
            return x0.yRotation;
        }
        
        static /* synthetic */ float access$200(final Position x0) {
            return x0.zRotation;
        }
        
        static /* synthetic */ float access$102(final Position x0, final float x1) {
            return x0.yRotation = x1;
        }
        
        static /* synthetic */ float access$202(final Position x0, final float x1) {
            return x0.zRotation = x1;
        }
        
        static /* synthetic */ float access$300(final Position x0) {
            return x0.x;
        }
        
        static /* synthetic */ float access$302(final Position x0, final float x1) {
            return x0.x = x1;
        }
        
        static /* synthetic */ float access$400(final Position x0) {
            return x0.step;
        }
        
        static /* synthetic */ float access$500(final Position x0) {
            return x0.y;
        }
        
        static /* synthetic */ float access$600(final Position x0) {
            return x0.z;
        }
        
        static /* synthetic */ float access$502(final Position x0, final float x1) {
            return x0.y = x1;
        }
        
        static /* synthetic */ float access$602(final Position x0, final float x1) {
            return x0.z = x1;
        }
        
        static /* synthetic */ float access$702(final Position x0, final float x1) {
            return x0.scale = x1;
        }
        
        static /* synthetic */ float access$402(final Position x0, final float x1) {
            return x0.step = x1;
        }
        
        static /* synthetic */ float access$700(final Position x0) {
            return x0.scale;
        }
        
        Position(final DebugPositioner$1 x0) {
            this();
        }
    }
}
