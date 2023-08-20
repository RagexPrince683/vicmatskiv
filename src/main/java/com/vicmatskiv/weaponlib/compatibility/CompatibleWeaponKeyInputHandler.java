package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.gameevent.*;
import cpw.mods.fml.common.eventhandler.*;

public abstract class CompatibleWeaponKeyInputHandler
{
    public CompatibleWeaponKeyInputHandler() {
        super();
    }
    
    @SubscribeEvent
    public final void onKeyInput(final InputEvent.KeyInputEvent event) {
        this.onCompatibleKeyInput();
    }
    
    protected abstract void onCompatibleKeyInput();
}
