package com.vicmatskiv.weaponlib.compatibility;

import java.util.concurrent.*;

class CompatibleWorldRenderer$1 implements Callable<String> {    private static final String __OBFID = "CL_00000948";
    final CompatibleWorldRenderer this$0;

    public CompatibleWorldRenderer$1(final CompatibleWorldRenderer this$0) {        this.this$0 = this$0;

    }

    @Override
    public String call() {
        return CompatibleWorldRenderer.access$000(this.this$0).currentScreen.getClass().getCanonicalName();
    }
}