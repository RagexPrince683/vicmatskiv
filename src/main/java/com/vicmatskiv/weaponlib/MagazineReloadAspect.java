package com.vicmatskiv.weaponlib;

import java.util.function.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.state.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.network.*;
import java.util.*;

public class MagazineReloadAspect implements Aspect<MagazineState, PlayerMagazineInstance>
{
    private static final Set<MagazineState> allowedUpdateFromStates;
    private static long reloadAnimationDuration;
    private static Predicate<PlayerMagazineInstance> reloadAnimationCompleted;
    private ModContext modContext;
    private PermitManager permitManager;
    private StateManager<MagazineState, ? super PlayerMagazineInstance> stateManager;
    private Predicate<PlayerMagazineInstance> notFull;
    
    public MagazineReloadAspect(final ModContext modContext) {
        super();
        this.notFull = (instance -> {
            final boolean result = Tags.getAmmo(instance.getItemStack()) < instance.getMagazine().getAmmo();
            return result;
        });
        this.modContext = modContext;
    }
    
    @Override
    public void setStateManager(final StateManager<MagazineState, ? super PlayerMagazineInstance> stateManager) {
        if (this.permitManager == null) {
            throw new IllegalStateException("Permit manager not initialized");
        }
        this.stateManager = stateManager.in((Aspect<MagazineState, PlayerMagazineInstance>)this).change(MagazineState.READY).to(MagazineState.LOAD).when(this.notFull).withPermit((s, es) -> new LoadPermit(s), this.modContext.getPlayerItemInstanceRegistry()::update, this.permitManager).withAction((c, f, t, p) -> this.doPermittedLoad(c, (LoadPermit)p)).manual().in((Aspect<S, PlayerMagazineInstance>)this).change(MagazineState.LOAD).to(MagazineState.READY).when(MagazineReloadAspect.reloadAnimationCompleted).automatic();
    }
    
    @Override
    public void setPermitManager(final PermitManager permitManager) {
        (this.permitManager = permitManager).registerEvaluator(LoadPermit.class, PlayerMagazineInstance.class, (p, c) -> this.evaluateLoad(p, c));
    }
    
    public void reloadMainHeldItem(final EntityPlayer player) {
        final PlayerMagazineInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerMagazineInstance.class);
        this.stateManager.changeState(this, instance, MagazineState.LOAD);
    }
    
    void updateMainHeldItem(final EntityPlayer player) {
        final PlayerMagazineInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerMagazineInstance.class);
        if (instance != null) {
            this.stateManager.changeStateFromAnyOf(this, instance, MagazineReloadAspect.allowedUpdateFromStates, new MagazineState[0]);
        }
    }
    
    private void evaluateLoad(final LoadPermit p, final PlayerMagazineInstance magazineInstance) {
        final ItemStack magazineStack = magazineInstance.getItemStack();
        Permit.Status status = Permit.Status.DENIED;
        if (magazineStack.getItem() instanceof ItemMagazine) {
            final ItemStack magazineItemStack = magazineStack;
            final ItemMagazine magazine = (ItemMagazine)magazineItemStack.getItem();
            final List<ItemBullet> compatibleBullets = magazine.getCompatibleBullets();
            final int currentAmmo = Tags.getAmmo(magazineStack);
            final ItemStack consumedStack;
            if ((consumedStack = CompatibilityProvider.compatibility.tryConsumingCompatibleItem(compatibleBullets, magazine.getAmmo() - currentAmmo, magazineInstance.getPlayer(), i -> true)) != null) {
                Tags.setAmmo(magazineStack, Tags.getAmmo(magazineStack) + CompatibilityProvider.compatibility.getStackSize(consumedStack));
                if (magazine.getReloadSound() != null) {
                    CompatibilityProvider.compatibility.playSound(magazineInstance.getPlayer(), magazine.getReloadSound(), 1.0f, 1.0f);
                }
                status = Permit.Status.GRANTED;
            }
        }
        p.setStatus(status);
    }
    
    private void doPermittedLoad(final PlayerMagazineInstance weaponInstance, final LoadPermit permit) {
        if (permit == null) {
            System.err.println("Permit is null, something went wrong");
        }
    }
    
    private static /* synthetic */ boolean lambda$evaluateLoad$93(final ItemStack i) {
        return true;
    }
    
    private /* synthetic */ void lambda$setPermitManager$92(final LoadPermit p, final PlayerMagazineInstance c) {
        this.evaluateLoad(p, c);
    }
    
    private /* synthetic */ void lambda$setStateManager$91(final PlayerMagazineInstance c, final MagazineState f, final MagazineState t, final Permit p) {
        this.doPermittedLoad(c, (LoadPermit)p);
    }
    
    private static /* synthetic */ Permit lambda$setStateManager$90(final MagazineState s, final PlayerMagazineInstance es) {
        return new LoadPermit(s);
    }
    
    private static /* synthetic */ boolean lambda$new$89(final PlayerMagazineInstance instance) {
        final boolean result = Tags.getAmmo(instance.getItemStack()) < instance.getMagazine().getAmmo();
        return result;
    }
    
    private static /* synthetic */ boolean lambda$static$88(final PlayerMagazineInstance es) {
        return System.currentTimeMillis() >= es.getStateUpdateTimestamp() + MagazineReloadAspect.reloadAnimationDuration;
    }
    
    static {
        TypeRegistry.getInstance().register(LoadPermit.class);
        allowedUpdateFromStates = new HashSet<MagazineState>(Arrays.asList(MagazineState.LOAD_REQUESTED, MagazineState.LOAD));
        MagazineReloadAspect.reloadAnimationDuration = 1000L;
        MagazineReloadAspect.reloadAnimationCompleted = (es -> System.currentTimeMillis() >= es.getStateUpdateTimestamp() + MagazineReloadAspect.reloadAnimationDuration);
    }
    
    public static class LoadPermit extends Permit<MagazineState>
    {
        public LoadPermit() {
            super();
        }
        
        public LoadPermit(final MagazineState state) {
            super(state);
        }
    }
}
