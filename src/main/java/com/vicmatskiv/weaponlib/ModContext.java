package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.config.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.weaponlib.melee.*;
import net.minecraft.util.*;
import com.vicmatskiv.weaponlib.grenade.*;

public interface ModContext
{
    void init(final Object p0, final String p1, final ConfigurationManager p2, final CompatibleChannel p3);
    
    void registerWeapon(final String p0, final Weapon p1, final WeaponRenderer p2);
    
    CompatibleChannel getChannel();
    
    void runSyncTick(final Runnable p0);
    
    void registerRenderableItem(final String p0, final Item p1, final Object p2);
    
    CompatibleSound registerSound(final String p0);
    
    void runInMainThread(final Runnable p0);
    
    PlayerItemInstanceRegistry getPlayerItemInstanceRegistry();
    
    WeaponReloadAspect getWeaponReloadAspect();
    
    WeaponFireAspect getWeaponFireAspect();
    
    WeaponAttachmentAspect getAttachmentAspect();
    
    MagazineReloadAspect getMagazineReloadAspect();
    
    PlayerWeaponInstance getMainHeldWeapon();
    
    StatusMessageCenter getStatusMessageCenter();
    
    RecipeManager getRecipeManager();
    
    CompatibleSound getZoomSound();
    
    void setChangeZoomSound(final String p0);
    
    CompatibleSound getChangeFireModeSound();
    
    void setChangeFireModeSound(final String p0);
    
    CompatibleSound getNoAmmoSound();
    
    void setNoAmmoSound(final String p0);
    
    CompatibleSound getExplosionSound();
    
    void setExplosionSound(final String p0);
    
    void registerMeleeWeapon(final String p0, final ItemMelee p1, final MeleeRenderer p2);
    
    void registerGrenadeWeapon(final String p0, final ItemGrenade p1, final GrenadeRenderer p2);
    
    MeleeAttackAspect getMeleeAttackAspect();
    
    MeleeAttachmentAspect getMeleeAttachmentAspect();
    
    AttachmentContainer getGrenadeAttachmentAspect();
    
    ResourceLocation getNamedResource(final String p0);
    
    float getAspectRatio();
    
    GrenadeAttackAspect getGrenadeAttackAspect();
    
    String getModId();
    
    EffectManager getEffectManager();
    
    ConfigurationManager getConfigurationManager();
}
