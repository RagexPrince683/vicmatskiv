package com.vicmatskiv.weaponlib.animation;

import org.lwjgl.util.vector.*;
import java.util.*;

private class PartData
{
    List<Matrix4f> matrices;
    Part attachedTo;
    final /* synthetic */ TransitionedPositioning this$1;
    
    private PartData(final TransitionedPositioning this$1) {
        this.this$1 = this$1;
        super();
        this.matrices = new ArrayList<Matrix4f>();
    }
    
    PartData(final TransitionedPositioning x0, final MultipartRenderStateManager$1 x1) {
        this(x0);
    }
}
