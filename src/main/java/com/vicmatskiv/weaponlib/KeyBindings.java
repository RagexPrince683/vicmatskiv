package com.vicmatskiv.weaponlib;

import net.minecraft.client.settings.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.animation.*;

public class KeyBindings
{
    public static KeyBinding reloadKey;
    public static KeyBinding attachmentKey;
    public static KeyBinding upArrowKey;
    public static KeyBinding downArrowKey;
    public static KeyBinding leftArrowKey;
    public static KeyBinding rightArrowKey;
    public static KeyBinding laserSwitchKey;
    public static KeyBinding addKey;
    public static KeyBinding subtractKey;
    public static KeyBinding fireModeKey;
    public static KeyBinding jDebugKey;
    public static KeyBinding kDebugKey;
    public static KeyBinding minusDebugKey;
    public static KeyBinding equalsDebugKey;
    public static KeyBinding lBracketDebugKey;
    public static KeyBinding rBracketDebugKey;
    public static KeyBinding semicolonDebugKey;
    public static KeyBinding apostropheDebugKey;
    public static KeyBinding deleteDebugKey;
    
    public KeyBindings() {
        super();
    }
    
    public static void init() {
        KeyBindings.reloadKey = new KeyBinding("key.reload", 19, "key.categories.weaponlib");
        KeyBindings.laserSwitchKey = new KeyBinding("key.laser", 38, "key.categories.weaponlib");
        KeyBindings.attachmentKey = new KeyBinding("key.attachment", 50, "key.categories.weaponlib");
        KeyBindings.upArrowKey = new KeyBinding("key.scope", 200, "key.categories.weaponlib");
        KeyBindings.downArrowKey = new KeyBinding("key.recoil_fitter", 208, "key.categories.weaponlib");
        KeyBindings.leftArrowKey = new KeyBinding("key.silencer", 203, "key.categories.weaponlib");
        KeyBindings.rightArrowKey = new KeyBinding("key.texture_change", 205, "key.categories.weaponlib");
        KeyBindings.addKey = new KeyBinding("key.add", 23, "key.categories.weaponlib");
        KeyBindings.subtractKey = new KeyBinding("key.subtract", 24, "key.categories.weaponlib");
        KeyBindings.fireModeKey = new KeyBinding("key.fire_mode", 54, "key.categories.weaponlib");
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.reloadKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.attachmentKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.upArrowKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.downArrowKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.leftArrowKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.rightArrowKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.laserSwitchKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.addKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.subtractKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.fireModeKey);
        if (DebugPositioner.isDebugModeEnabled()) {
            bindDebugKeys();
        }
    }
    
    public static void bindDebugKeys() {
        KeyBindings.jDebugKey = new KeyBinding("key.jDebugKey", 36, "key.categories.weaponlib");
        KeyBindings.kDebugKey = new KeyBinding("key.klDebugKey", 37, "key.categories.weaponlib");
        KeyBindings.minusDebugKey = new KeyBinding("key.minusDebugKey", 12, "key.categories.weaponlib");
        KeyBindings.equalsDebugKey = new KeyBinding("key.equalsDebugKey", 13, "key.categories.weaponlib");
        KeyBindings.lBracketDebugKey = new KeyBinding("key.lBracketDebugKey", 26, "key.categories.weaponlib");
        KeyBindings.rBracketDebugKey = new KeyBinding("key.rBracketDebugKey", 27, "key.categories.weaponlib");
        KeyBindings.semicolonDebugKey = new KeyBinding("key.semicolonDebugKey", 39, "key.categories.weaponlib");
        KeyBindings.apostropheDebugKey = new KeyBinding("key.apostropheDebugKey", 40, "key.categories.weaponlib");
        KeyBindings.deleteDebugKey = new KeyBinding("key.deleteDebugKey", 14, "key.categories.weaponlib");
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.jDebugKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.kDebugKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.lBracketDebugKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.rBracketDebugKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.semicolonDebugKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.apostropheDebugKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.minusDebugKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.equalsDebugKey);
        CompatibilityProvider.compatibility.registerKeyBinding(KeyBindings.deleteDebugKey);
    }
}
