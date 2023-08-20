package com.vicmatskiv.weaponlib.network;

import java.util.function.*;
import java.util.*;
import com.vicmatskiv.weaponlib.state.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.apache.logging.log4j.*;

public class NetworkPermitManager implements PermitManager, CompatibleMessageHandler<PermitMessage, CompatibleMessage>
{
    private static final Logger logger;
    private ModContext modContext;
    private Map<UUID, Object> permitCallbacks;
    private Map<Class<?>, BiConsumer<Permit<?>, ?>> evaluators;
    
    public NetworkPermitManager(final ModContext modContext) {
        super();
        this.permitCallbacks = new HashMap<UUID, Object>();
        this.evaluators = new HashMap<Class<?>, BiConsumer<Permit<?>, ?>>();
        this.modContext = modContext;
    }
    
    @Override
    public <S extends ManagedState<S>, P extends Permit<S>, E extends ExtendedState<S>> void request(final P permit, final E extendedState, final BiConsumer<P, E> callback) {
        this.permitCallbacks.put(permit.getUuid(), callback);
        this.modContext.getChannel().getChannel().sendToServer((IMessage)new PermitMessage(permit, extendedState));
    }
    
    @Override
    public <S extends ManagedState<S>, P extends Permit<S>, E extends ExtendedState<S>> void registerEvaluator(final Class<? extends P> permitClass, final Class<? extends E> esClass, final BiConsumer<P, E> evaluator) {
        this.evaluators.put(permitClass, (p, c) -> {
            NetworkPermitManager.logger.debug("Processing permit {} for instance {}", new Object[] { p, c });
            biConsumer.accept(clazz.cast(p), clazz2.cast(c));
        });
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final PermitMessage permitMessage, final CompatibleMessageContext ctx) {
        final Permit<?> permit = permitMessage.getPermit();
        final Object extendedState = permitMessage.getContext();
        if (ctx.isServerSide()) {
            if (extendedState instanceof PlayerContext) {
                ((PlayerContext)extendedState).setPlayer(ctx.getPlayer());
            }
            ctx.runInMainThread(() -> {
                final BiConsumer<Permit<?>, Object> evaluator = this.evaluators.get(permit2.getClass());
                if (evaluator != null) {
                    evaluator.accept(permit2, context);
                }
                final PermitMessage message = new PermitMessage(permit2, context);
                this.modContext.getChannel().getChannel().sendTo((IMessage)message, (EntityPlayerMP)compatibleMessageContext.getPlayer());
                return;
            });
        }
        else {
            CompatibilityProvider.compatibility.runInMainClientThread(() -> {
                if (o instanceof PlayerContext) {
                    ((PlayerContext)o).setPlayer(CompatibilityProvider.compatibility.clientPlayer());
                }
                final BiConsumer<Permit<?>, Object> callback = this.permitCallbacks.remove(permit3.getUuid());
                if (callback != null) {
                    callback.accept(permit3, o);
                }
                return;
            });
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((PermitMessage)compatibleMessage, ctx);
    }
    
    private /* synthetic */ void lambda$onCompatibleMessage$240(final Object o, final Permit permit) {
        if (o instanceof PlayerContext) {
            ((PlayerContext)o).setPlayer(CompatibilityProvider.compatibility.clientPlayer());
        }
        final BiConsumer<Permit<?>, Object> callback = this.permitCallbacks.remove(permit.getUuid());
        if (callback != null) {
            callback.accept(permit, o);
        }
    }
    
    private /* synthetic */ void lambda$onCompatibleMessage$239(final Permit permit, final Object context, final CompatibleMessageContext compatibleMessageContext) {
        final BiConsumer<Permit<?>, Object> evaluator = this.evaluators.get(permit.getClass());
        if (evaluator != null) {
            evaluator.accept(permit, context);
        }
        final PermitMessage message = new PermitMessage(permit, context);
        this.modContext.getChannel().getChannel().sendTo((IMessage)message, (EntityPlayerMP)compatibleMessageContext.getPlayer());
    }
    
    private static /* synthetic */ void lambda$registerEvaluator$238(final BiConsumer biConsumer, final Class clazz, final Class clazz2, final Permit p, final Object c) {
        NetworkPermitManager.logger.debug("Processing permit {} for instance {}", new Object[] { p, c });
        biConsumer.accept(clazz.cast(p), clazz2.cast(c));
    }
    
    static {
        logger = LogManager.getLogger((Class)NetworkPermitManager.class);
    }
}
