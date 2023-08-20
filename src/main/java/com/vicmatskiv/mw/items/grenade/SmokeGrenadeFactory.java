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
import net.minecraft.entity.player.*;

public class SmokeGrenadeFactory implements GrenadeFactory
{
    public SmokeGrenadeFactory() {
        super();
    }
    
    @Override
    public ItemGrenade createGrenade(final CommonProxy commonProxy) {
        return new ItemGrenade.Builder().withModId("mw").withName("M18White").withCreativeTab(ModernWarfareMod.GrenadesTab).withTextureNames("M18White").withExplosionStrength(0.4f).withSmokeOnly().withExplosionTimeout(1000).withActiveDuration(20000L).withBounceSoftSound("grenade-soft-bounce").withBounceHardSound("grenade-hard-bounce").withThrowSound("grenadethrow").withSafetyPinOffSound("safetypinoff").withCompatibleAttachment(Grenades.GrenadeSafetyPin, (p, s) -> {}).withVelocity(() -> 0.8f).withFarVelocity(() -> 1.3f).withGravityVelocity(() -> 0.06f).withRotationSlowdownFactor(() -> 0.99f).withCraftingRecipe(" XG", "XFX", "EF ", 'X', CommonProxy.SteelPlate, 'E', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 15, 15), 'F', CompatibleItems.COAL, 'G', "ingotSteel").withRenderer(new GrenadeRenderer.Builder().withModId("mw").withModel(new M18()).withAnimationDuration(500).withThrownEntityPositioning(() -> {
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
        }).withFirstPersonCustomPositioning(Grenades.GrenadeSafetyPin.getRenderablePart(), null, context -> {}).withFirstPersonHandPositioning(context -> {
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
        }).withFirstPersonPositioningSafetyPinOff(new Transition(renderContext -> {
            GL11.glScalef(0.33f, 0.33f, 0.33f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
        }, 200L, 50L), new Transition(renderContext -> {
            GL11.glScalef(0.33f, 0.33f, 0.33f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
        }, 200L, 0L)).withFirstPersonLeftHandPositioningSafetyPinOff(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(105.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.2f, -0.775f, 0.1f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -1.025f, 0.225f);
        }, 70L, 0L)).withFirstPersonRightHandPositioningSafetyPinOff(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.325f, -0.375f, -0.125f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.325f, -0.375f, -0.125f);
        }, 70L, 0L)).withFirstPersonCustomPositioningSafetyPinOff(Grenades.GrenadeSafetyPin.getRenderablePart(), new Transition(renderContext -> {
            GL11.glScalef(0.2f, 0.2f, 0.2f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
        }, 70L, 0L, Part.LEFT_HAND), new Transition(renderContext -> {
            GL11.glScalef(0.2f, 0.2f, 0.2f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
        }, 70L, 0L, Part.LEFT_HAND)).withFirstPersonPositioningThrowing(new Transition(renderContext -> {
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
        }, 70L, 0L), new Transition(renderContext -> {}, 70L, 0L)).withFirstPersonCustomPositioningThrowing(Grenades.GrenadeSafetyPin.getRenderablePart(), new Transition(renderContext -> {
            GL11.glScalef(0.2f, 0.2f, 0.2f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
        }, 70L, 0L, Part.LEFT_HAND), new Transition(renderContext -> {
            GL11.glScalef(0.2f, 0.2f, 0.2f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
        }, 70L, 0L, Part.LEFT_HAND), new Transition(renderContext -> {
            GL11.glScalef(0.2f, 0.2f, 0.2f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
        }, 70L, 0L, Part.LEFT_HAND)).withFirstPersonPositioningStrikerLeverOff(renderContext -> {
            GL11.glScalef(0.33f, 0.33f, 0.33f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
        }).withFirstPersonCustomPositioningStrikerLeverOff(Grenades.GrenadeSafetyPin.getRenderablePart(), Part.LEFT_HAND, renderContext -> {
            GL11.glScalef(0.2f, 0.2f, 0.2f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
        }).withFirstPersonCustomPositioningThrown(Grenades.GrenadeSafetyPin.getRenderablePart(), Part.MAIN_ITEM, renderContext -> {
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.8f, 1.025f, -0.05f);
        }).withFirstPersonHandPositioningStrikerLevelOff(context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -1.025f, 0.225f);
        }, context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.325f, -0.375f, -0.125f);
        }).withFirstPersonHandPositioningThrown(context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.1f, -0.725f, 0.7f);
        }, context -> {}).build()).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGrenade$348(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createGrenade$347(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.725f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$346(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.325f, -0.375f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$345(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$344(final RenderContext renderContext) {
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.8f, 1.025f, -0.05f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$343(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$342(final RenderContext renderContext) {
        GL11.glScalef(0.33f, 0.33f, 0.33f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$341(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$340(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$339(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$338(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGrenade$337(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$336(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-150.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.5f, -0.2f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$335(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.975f, 0.55f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$334(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$333(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$332(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(155.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, -0.75f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$331(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, -0.75f, -0.075f);
        GL11.glScalef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$330(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glScalef(0.1f, 0.1f, 0.1f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -6.849998f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$329(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$328(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$327(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.325f, -0.375f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$326(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.325f, -0.375f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$325(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$324(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(105.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.2f, -0.775f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$323(final RenderContext renderContext) {
        GL11.glScalef(0.33f, 0.33f, 0.33f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$322(final RenderContext renderContext) {
        GL11.glScalef(0.33f, 0.33f, 0.33f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$321(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.2f, -0.3f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$320(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.525f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$319(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createGrenade$318(final RenderContext context) {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.0f, -0.6f, -2.2f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$317(final RenderContext renderContext) {
        GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
        GL11.glTranslatef(-3.0f, -1.0f, 3.0f);
        GL11.glRotatef(-225.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$316(final ItemStack itemStack) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(1.0f, 1.3f, -1.3f);
        GL11.glRotatef(230.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ Float lambda$createGrenade$315() {
        return -0.025f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$314() {
        return 0.2f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$313() {
        return -0.025f;
    }
    
    private static /* synthetic */ void lambda$createGrenade$312() {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ Float lambda$createGrenade$311() {
        return 0.99f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$310() {
        return 0.06f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$309() {
        return 1.3f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$308() {
        return 0.8f;
    }
    
    private static /* synthetic */ void lambda$createGrenade$307(final EntityPlayer p, final ItemStack s) {
    }
}
