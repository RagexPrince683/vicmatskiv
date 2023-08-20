package com.vicmatskiv.weaponlib.compatibility;

import java.util.concurrent.*;
import net.minecraft.crash.*;

class CompatibleRenderGlobal$1 implements Callable {
    private static final String __OBFID = "CL_00000955";
    final /* synthetic */ double val$p_72708_2_;
    final /* synthetic */ double val$p_72708_4_;
    final /* synthetic */ double val$p_72708_6_;
    final /* synthetic */ CompatibleRenderGlobal this$0;
    
    CompatibleRenderGlobal$1(final CompatibleRenderGlobal this$0, final double val$p_72708_2_, final double val$p_72708_4_, final double val$p_72708_6_) {
        this.this$0 = this$0;
        this.val$p_72708_2_ = val$p_72708_2_;
        this.val$p_72708_4_ = val$p_72708_4_;
        this.val$p_72708_6_ = val$p_72708_6_;
        super();
    }
    
    @Override
    public String call() {
        return CrashReportCategory.func_85074_a(this.val$p_72708_2_, this.val$p_72708_4_, this.val$p_72708_6_);
    }
    
    @Override
    public /* bridge */ Object call() throws Exception {
        return this.call();
    }
}