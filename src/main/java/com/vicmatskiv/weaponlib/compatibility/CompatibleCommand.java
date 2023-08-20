package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.command.*;

public abstract class CompatibleCommand extends CommandBase
{
    public CompatibleCommand() {
        super();
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) {
        this.execCommand(sender, args);
    }
    
    protected abstract void execCommand(final ICommandSender p0, final String[] p1);
    
    public String getCommandName() {
        return this.getCompatibleName();
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return this.getCompatibleUsage(sender);
    }
    
    protected abstract String getCompatibleName();
    
    protected abstract String getCompatibleUsage(final ICommandSender p0);
}
