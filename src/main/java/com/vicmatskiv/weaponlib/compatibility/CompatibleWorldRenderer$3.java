package com.vicmatskiv.weaponlib.compatibility;

import java.util.concurrent.*;
import net.minecraft.client.gui.ScaledResolution;

class CompatibleWorldRenderer$3 implements Callable<String> {
    private static final String __OBFID = "CL_00000951";
    final ScaledResolution val$scaledresolution;
    final CompatibleWorldRenderer this$0;

    public CompatibleWorldRenderer$3(final CompatibleWorldRenderer this$0, final ScaledResolution val$scaledresolution) {
        this.this$0 = this$0;
        this.val$scaledresolution = val$scaledresolution;
    }

    @Override
    public String call() {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", this.val$scaledresolution.getScaledWidth(), this.val$scaledresolution.getScaledHeight(), this.this$0.mc.displayWidth, this.this$0.mc.displayHeight, this.val$scaledresolution.getScaleFactor());
    }
}
}