package com.vicmatskiv.weaponlib.command;

import net.minecraft.command.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.item.*;

public class DebugCommand extends CompatibleCommand
{
    private static final String SHOW_OPTION_CODE = "code";
    private static final String COMMAND_DEBUG = "wdb";
    private static final String DEBUG_ARG_ON = "on";
    private static final String DEBUG_ARG_OFF = "off";
    private static final String DEBUG_ARG_PAUSE = "pause";
    private static final String DEBUG_ARG_PART = "part";
    private static final String DEBUG_ARG_SCALE = "scale";
    private static final String DEBUG_ARG_SHOW = "show";
    private static final String DEBUG_ARG_WATCH = "watch";
    private static final String DEBUG_ARG_STEP = "step";
    private String modId;
    
    public DebugCommand(final String modId) {
        super();
        this.modId = modId;
    }
    
    public String getCompatibleName() {
        return "wdb";
    }
    
    public String getCompatibleUsage(final ICommandSender sender) {
        return "/wdb<options>";
    }
    
    private String getSubCommandDebugUsage() {
        return "/wdb <on|off>";
    }
    
    private String getSubCommandPauseUsage() {
        return String.format("/%s %s <transition-number> <pause-duration>", "wdb", "pause");
    }
    
    private String getSubCommandPartUsage() {
        return String.format("/%s %s main|lhand|rhand", "wdb", "part");
    }
    
    private String getSubCommandShowUsage() {
        return String.format("/%s %s code", "wdb", "show");
    }
    
    private String getSubCommandScaleUsage() {
        return String.format("/%s %s <scale>", "wdb", "scale");
    }
    
    private String getSubCommandStepUsage() {
        return String.format("/%s %s <scale>", "wdb", "step");
    }
    
    private String getSubCommandWatchUsage() {
        return String.format("/%s %s [entity-id]", "wdb", "watch");
    }
    
    public void execCommand(final ICommandSender sender, final String[] args) {
        if (args.length > 0) {
            final String lowerCase = args[0].toLowerCase();
            switch (lowerCase) {
                case "on": {
                    this.processDebugModeSubCommand(args);
                    break;
                }
                case "off": {
                    this.processDebugModeSubCommand(args);
                    break;
                }
                case "pause": {
                    this.processPauseSubCommand(args);
                    break;
                }
                case "part": {
                    this.processPartSubCommand(args);
                    break;
                }
                case "show": {
                    this.processShowSubCommand(args);
                    break;
                }
                case "scale": {
                    this.processScaleSubCommand(args);
                    break;
                }
                case "step": {
                    this.processStepSubCommand(args);
                    break;
                }
                case "watch": {
                    this.processWatchSubCommand(args);
                    break;
                }
                default: {
                    CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getCompatibleUsage(sender));
                    break;
                }
            }
        }
        else {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getCompatibleUsage(sender));
        }
    }
    
    private void processDebugModeSubCommand(final String[] args) {
        Boolean debugMode = null;
        final String lowerCase = args[0].toLowerCase();
        switch (lowerCase) {
            case "on": {
                debugMode = true;
                break;
            }
            case "off": {
                debugMode = false;
                break;
            }
        }
        if (debugMode != null) {
            DebugPositioner.setDebugMode(debugMode);
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug mode " + args[0].toLowerCase());
        }
        else {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandDebugUsage());
        }
    }
    
    private void processPauseSubCommand(final String[] args) {
        if (args.length != 3) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandPauseUsage());
            return;
        }
        try {
            final int transitionNumber = Integer.parseInt(args[1]);
            final long pauseDuration = Long.parseLong(args[2]);
            DebugPositioner.configureTransitionPause(transitionNumber, pauseDuration);
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Set transition " + transitionNumber + " pause to " + pauseDuration + "ms");
        }
        catch (final NumberFormatException e) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandPauseUsage());
        }
    }
    
    private void processWatchSubCommand(final String[] args) {
        if (args.length < 1) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandWatchUsage());
            return;
        }
        DebugPositioner.watch();
    }
    
    private void processScaleSubCommand(final String[] args) {
        if (args.length != 2) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandScaleUsage());
            return;
        }
        if (DebugPositioner.getDebugPart() == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        try {
            final float scale = Float.parseFloat(args[1]);
            DebugPositioner.setScale(scale);
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Set scale to " + scale);
        }
        catch (final NumberFormatException e) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandScaleUsage());
        }
    }
    
    private void processStepSubCommand(final String[] args) {
        if (args.length != 2) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandStepUsage());
            return;
        }
        if (DebugPositioner.getDebugPart() == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        try {
            final float step = Float.parseFloat(args[1]);
            DebugPositioner.setStep(step);
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Set step to " + step);
        }
        catch (final NumberFormatException e) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandStepUsage());
        }
    }
    
    private void processShowSubCommand(final String[] args) {
        if (args.length != 2) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandShowUsage());
            return;
        }
        if (DebugPositioner.getDebugPart() == null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debug part not selected");
            return;
        }
        final String lowerCase = args[1].toLowerCase();
        switch (lowerCase) {
            case "code": {
                DebugPositioner.showCode();
                CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Code is copied to the console");
                break;
            }
            default: {
                CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandShowUsage());
                break;
            }
        }
    }
    
    private void processPartSubCommand(final String[] args) {
        if (args.length != 2) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandPartUsage());
            return;
        }
        try {
            final String lowerCase = args[1].toLowerCase();
            switch (lowerCase) {
                case "main": {
                    DebugPositioner.setDebugPart(Part.MAIN_ITEM);
                    break;
                }
                case "lhand": {
                    DebugPositioner.setDebugPart(Part.LEFT_HAND);
                    break;
                }
                case "rhand": {
                    DebugPositioner.setDebugPart(Part.RIGHT_HAND);
                    break;
                }
                case "inventory": {
                    DebugPositioner.setDebugPart(Part.INVENTORY);
                    break;
                }
                default: {
                    final String partName = args[1];
                    final Item item = CompatibilityProvider.compatibility.findItemByName(this.modId, partName);
                    Part part = null;
                    if (item instanceof Part) {
                        part = (Part)item;
                    }
                    else if (item instanceof ItemAttachment) {
                        part = ((ItemAttachment)item).getRenderablePart();
                    }
                    if (part != null) {
                        DebugPositioner.setDebugPart(part);
                        break;
                    }
                    break;
                }
            }
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Debugging part " + args[1]);
        }
        catch (final NumberFormatException e) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandPartUsage());
        }
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
