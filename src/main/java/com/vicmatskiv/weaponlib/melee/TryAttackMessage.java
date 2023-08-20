package com.vicmatskiv.weaponlib.melee;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;
import net.minecraft.world.*;

public class TryAttackMessage implements CompatibleMessage
{
    private int entityId;
    private boolean isHeavyAttack;
    private PlayerMeleeInstance instance;
    
    public TryAttackMessage() {
        super();
    }
    
    public TryAttackMessage(final PlayerMeleeInstance instance, final Entity entity, final boolean isHeavyAttack) {
        super();
        this.instance = instance;
        this.entityId = entity.getEntityId();
        this.isHeavyAttack = isHeavyAttack;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.instance = TypeRegistry.getInstance().fromBytes(buf);
        this.entityId = buf.readInt();
        this.isHeavyAttack = buf.readBoolean();
    }
    
    public void toBytes(final ByteBuf buf) {
        TypeRegistry.getInstance().toBytes(this.instance, buf);
        buf.writeInt(this.entityId);
        buf.writeBoolean(this.isHeavyAttack);
    }
    
    public Entity getEntity(final World world) {
        return world.getEntityByID(this.entityId);
    }
    
    public boolean isHeavyAttack() {
        return this.isHeavyAttack;
    }
    
    public PlayerMeleeInstance getInstance() {
        return this.instance;
    }
}
