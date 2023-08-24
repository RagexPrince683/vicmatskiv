package com.vicmatskiv.weaponlib.compatibility;

import java.util.concurrent.*;
import org.lwjgl.input.Mouse;

class CompatibleWorldRenderer$2 implements Callable<String> {
    private static final String __OBFID = "CL_00000950";
    final int val$k;
    final int val$l;
    final CompatibleWorldRenderer this$0;

    public CompatibleWorldRenderer$2(final CompatibleWorldRenderer this$0, final int val$k, final int val$l) {
        this.this$0 = this$0;
        this.val$k = val$k;
        this.val$l = val$l;
    }

    @Override
    public String call() {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", this.val$k, this.val$l, Mouse.getX(), Mouse.getY());
    }
}