package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import io.netty.buffer.*;

public class EntityControlMessage implements CompatibleMessage
{
    private int action;
    
    public EntityControlMessage() {
        super();
    }
    
    public EntityControlMessage(final EntityAction action) {
        super();
        this.action = action.ordinal();
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.action = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.action);
    }
    
    public EntityAction getAction() {
        return EntityAction.values()[this.action];
    }
    
    public enum EntityAction
    {
        STOP;
        
        private static final /* synthetic */ EntityAction[] $VALUES;
        
        public static EntityAction[] values() {
            return EntityAction.$VALUES.clone();
        }
        
        public static EntityAction valueOf(final String name) {
            return Enum.valueOf(EntityAction.class, name);
        }
        
        static {
            $VALUES = new EntityAction[] { EntityAction.STOP };
        }
    }
}
