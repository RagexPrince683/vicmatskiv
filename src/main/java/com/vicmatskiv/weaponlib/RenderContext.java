package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.util.vector.*;
import java.util.*;
import com.vicmatskiv.weaponlib.animation.*;

public class RenderContext<RS> implements PartPositionProvider
{
    private EntityPlayer player;
    private ItemStack itemStack;
    private float limbSwing;
    private float flimbSwingAmount;
    private float ageInTicks;
    private float netHeadYaw;
    private float headPitch;
    private float scale;
    private float transitionProgress;
    private CompatibleTransformType compatibleTransformType;
    private RS fromState;
    private RS toState;
    private ModContext modContext;
    private PlayerItemInstance<?> playerItemInstance;
    private Map<Part, Matrix4f> attachablePartPositions;
    
    public RenderContext(final ModContext modContext, final EntityPlayer player, final ItemStack itemStack) {
        super();
        this.modContext = modContext;
        this.player = player;
        this.itemStack = itemStack;
        this.attachablePartPositions = new HashMap<Part, Matrix4f>();
    }
    
    public ModContext getModContext() {
        return this.modContext;
    }
    
    public float getLimbSwing() {
        return this.limbSwing;
    }
    
    public void setLimbSwing(final float limbSwing) {
        this.limbSwing = limbSwing;
    }
    
    public float getFlimbSwingAmount() {
        return this.flimbSwingAmount;
    }
    
    public void setFlimbSwingAmount(final float flimbSwingAmount) {
        this.flimbSwingAmount = flimbSwingAmount;
    }
    
    public float getAgeInTicks() {
        return this.ageInTicks;
    }
    
    public void setAgeInTicks(final float ageInTicks) {
        this.ageInTicks = ageInTicks;
    }
    
    public float getNetHeadYaw() {
        return this.netHeadYaw;
    }
    
    public void setNetHeadYaw(final float netHeadYaw) {
        this.netHeadYaw = netHeadYaw;
    }
    
    public float getHeadPitch() {
        return this.headPitch;
    }
    
    public void setHeadPitch(final float headPitch) {
        this.headPitch = headPitch;
    }
    
    public float getScale() {
        return this.scale;
    }
    
    public void setScale(final float scale) {
        this.scale = scale;
    }
    
    public void setPlayer(final EntityPlayer player) {
        this.player = player;
    }
    
    public void setWeapon(final ItemStack weapon) {
        this.itemStack = weapon;
    }
    
    public EntityPlayer getPlayer() {
        return this.player;
    }
    
    public ItemStack getWeapon() {
        return this.itemStack;
    }
    
    public CompatibleTransformType getCompatibleTransformType() {
        return this.compatibleTransformType;
    }
    
    public void setCompatibleTransformType(final CompatibleTransformType compatibleTransformType) {
        this.compatibleTransformType = compatibleTransformType;
    }
    
    public RS getFromState() {
        return this.fromState;
    }
    
    public void setFromState(final RS fromState) {
        this.fromState = fromState;
    }
    
    public RS getToState() {
        return this.toState;
    }
    
    public void setToState(final RS toState) {
        this.toState = toState;
    }
    
    public float getTransitionProgress() {
        return this.transitionProgress;
    }
    
    public void setTransitionProgress(final float transitionProgress) {
        this.transitionProgress = transitionProgress;
    }
    
    public PlayerItemInstance<?> getPlayerItemInstance() {
        return this.playerItemInstance;
    }
    
    public void setPlayerItemInstance(final PlayerItemInstance<?> playerItemInstance) {
        this.playerItemInstance = playerItemInstance;
    }
    
    public PlayerWeaponInstance getWeaponInstance() {
        if (this.playerItemInstance instanceof PlayerWeaponInstance) {
            return (PlayerWeaponInstance)this.playerItemInstance;
        }
        final PlayerWeaponInstance itemInstance = (PlayerWeaponInstance)this.modContext.getPlayerItemInstanceRegistry().getItemInstance(this.player, this.itemStack);
        if (itemInstance instanceof PlayerWeaponInstance) {
            return itemInstance;
        }
        return null;
    }
    
    public void capturePartPosition(final Part part) {
        this.attachablePartPositions.put(part, MatrixHelper.captureMatrix());
    }
    
    @Override
    public Matrix4f getPartPosition(Object part) {
        if (part == null) {
            part = Part.MAIN_ITEM;
        }
        return this.attachablePartPositions.get(part);
    }
}
