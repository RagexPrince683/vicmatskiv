package com.vicmatskiv.mw.items.grenade;

import com.vicmatskiv.mw.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.grenade.*;
import net.minecraft.item.*;

public class ImpactGrenadeFactory implements GrenadeFactory
{
    public ImpactGrenadeFactory() {
        super();
    }
    
    @Override
    public ItemGrenade createGrenade(final CommonProxy commonProxy) {
        return new ItemGrenade.Builder().withModId("mw").withName("ImpactGrenade").withCreativeTab(ModernWarfareMod.GrenadesTab).withTextureNames("ImpactGrenade").withExplosionSound("grenadeexplosion").withExplosionStrength(1.0f).withBounceSoftSound("grenade-soft-bounce").withBounceHardSound("grenade-hard-bounce").withEffectiveRadius(15.0f).withFragmentCount(1500).withFragmentDamage(30.0f).withVelocity(() -> 1.3f).withGravityVelocity(() -> 0.06f).withRotationSlowdownFactor(() -> 0.99f).withExplosionOnImpact().withCraftingRecipe(" X ", "XFX", " E ", 'X', CommonProxy.SteelPlate, 'E', CompatibleItems.FLINT_AND_STEEL, 'F', CompatibleItems.GUNPOWDER).withRenderer(new GrenadeRenderer.Builder().withModId("mw").withModel(new ImpactGrenade()).withAnimationDuration(500).withThrownEntityPositioning(() -> {
            GL11.glScalef(0.2f, 0.2f, 0.2f);
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 0.0f);
        }).withEntityRotationCenterOffsets(() -> -0.025f, () -> 0.2f, () -> -0.025f).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(1.0f, 1.3f, -1.3f);
            GL11.glRotatef(230.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
            GL11.glTranslatef(-3.0f, -1.0f, 3.0f);
            GL11.glRotatef(-225.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(context -> {
            GL11.glScalef(0.4f, 0.4f, 0.4f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-3.0f, -0.6f, -2.2f);
        }).withFirstPersonHandPositioning(context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -0.525f, 0.425f);
        }, context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.2f, -0.3f, 0.1f);
        }).withFirstPersonPositioningThrowing(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glScalef(0.1f, 0.1f, 0.1f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.0f, -6.849998f, -2.4f);
        }, 260L, 120L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, -0.75f, -0.075f);
            GL11.glScalef(0.0f, 0.0f, 0.0f);
        }, 80L, 80L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(155.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, -0.75f, 0.075f);
        }, 80L, 80L)).withFirstPersonLeftHandPositioningThrowing(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -1.025f, 0.225f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -1.025f, 0.225f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.225f, -0.975f, 0.55f);
        }, 70L, 0L)).withFirstPersonRightHandPositioningThrowing(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-150.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.5f, -0.2f, -0.3f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.5f, -0.3f);
        }, 70L, 0L), new Transition(renderContext -> {}, 70L, 0L)).withFirstPersonHandPositioningThrown(context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.1f, -0.725f, 0.7f);
        }, context -> {}).build()).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGrenade$306(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createGrenade$305(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.725f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$304(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGrenade$303(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$302(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-150.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.5f, -0.2f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$301(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.975f, 0.55f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$300(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$299(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$298(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(155.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, -0.75f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$297(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, -0.75f, -0.075f);
        GL11.glScalef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$296(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glScalef(0.1f, 0.1f, 0.1f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -6.849998f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$295(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.2f, -0.3f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$294(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.525f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$293(final RenderContext context) {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.0f, -0.6f, -2.2f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$292(final RenderContext renderContext) {
        GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
        GL11.glTranslatef(-3.0f, -1.0f, 3.0f);
        GL11.glRotatef(-225.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$291(final ItemStack itemStack) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(1.0f, 1.3f, -1.3f);
        GL11.glRotatef(230.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ Float lambda$createGrenade$290() {
        return -0.025f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$289() {
        return 0.2f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$288() {
        return -0.025f;
    }
    
    private static /* synthetic */ void lambda$createGrenade$287() {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ Float lambda$createGrenade$286() {
        return 0.99f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$285() {
        return 0.06f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$284() {
        return 1.3f;
    }
}
