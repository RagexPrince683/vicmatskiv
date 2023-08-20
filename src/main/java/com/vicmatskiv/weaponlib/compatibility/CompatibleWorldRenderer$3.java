package com.vicmatskiv.weaponlib.compatibility;

import java.util.concurrent.*;
import net.minecraft.client.gui.*;

class CompatibleWorldRenderer$3 implements Callable {
    private static final String __OBFID = "CL_00000951";
    final /* synthetic */ ScaledResolution val$scaledresolution;
    final /* synthetic */ CompatibleWorldRenderer this$0;
    
    CompatibleWorldRenderer$3(final CompatibleWorldRenderer this$0, final ScaledResolution val$scaledresolution) {
        this.this$0 = this$0;
        this.val$scaledresolution = val$scaledresolution;
        super();
    }
    
    @Override
    public String call() {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", this.val$scaledresolution.getScaledWidth(), this.val$scaledresolution.getScaledHeight(), CompatibleWorldRenderer.access$000(this.this$0).displayWidth, CompatibleWorldRenderer.access$000(this.this$0).displayHeight, this.val$scaledresolution.getScaleFactor());
    }
    
    @Override
    public /* bridge */ Object call() throws Exception {
        return this.call();
    }
}