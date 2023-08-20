package com.vicmatskiv.weaponlib;

import java.util.concurrent.atomic.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class SafeGlobals
{
    public final AtomicBoolean guiOpen;
    public final AtomicInteger currentItemIndex;
    public final AtomicReference<CompatibleRayTraceResult> objectMouseOver;
    public final AtomicReference<RenderingPhase> renderingPhase;
    
    public SafeGlobals() {
        super();
        this.guiOpen = new AtomicBoolean();
        this.currentItemIndex = new AtomicInteger(-1);
        this.objectMouseOver = new AtomicReference<CompatibleRayTraceResult>();
        this.renderingPhase = new AtomicReference<RenderingPhase>();
    }
}
