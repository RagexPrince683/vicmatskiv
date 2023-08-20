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

public class FuseGrenadeFactory implements GrenadeFactory
{
    public FuseGrenadeFactory() {
        super();
    }
    
    @Override
    public ItemGrenade createGrenade(final CommonProxy commonProxy) {
        return new ItemGrenade.Builder().withModId("mw").withName("M67Frag").withCreativeTab(ModernWarfareMod.GrenadesTab).withTextureNames("M67Frag").withExplosionStrength(1.0f).withExplosionTimeout(5000).withExplosionSound("grenadeexplosion").withBounceSoftSound("grenade-soft-bounce").withBounceHardSound("grenade-hard-bounce").withThrowSound("grenadethrow").withSafetyPinOffSound("safetypinoff").withEffectiveRadius(15.0f).withFragmentCount(1500).withFragmentDamage(30.0f).withCompatibleAttachment(Grenades.GrenadeSafetyPin, (p, s) -> {}).withVelocity(() -> 0.8f).withFarVelocity(() -> 1.3f).withGravityVelocity(() -> 0.06f).withRotationSlowdownFactor(() -> 0.99f).withCraftingRecipe(" XG", "XFX", " E ", 'X', CommonProxy.SteelPlate, 'E', CompatibleItems.FLINT_AND_STEEL, 'F', CompatibleItems.GUNPOWDER, 'G', "ingotSteel").withRenderer(new GrenadeRenderer.Builder().withModId("mw").withModel(new M67Frag()).withAnimationDuration(500).withThrownEntityPositioning(() -> {
            GL11.glScalef(0.2f, 0.2f, 0.2f);
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 0.0f);
        }).withEntityRotationCenterOffsets(() -> -0.025f, () -> 0.2f, () -> -0.025f).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(1.0f, 1.8f, -1.6f);
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
    
    private static /* synthetic */ void lambda$createGrenade$283(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createGrenade$282(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.725f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$281(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.325f, -0.375f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$280(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$279(final RenderContext renderContext) {
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.8f, 1.025f, -0.05f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$278(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$277(final RenderContext renderContext) {
        GL11.glScalef(0.33f, 0.33f, 0.33f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$276(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$275(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$274(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$273(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGrenade$272(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$271(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-150.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.5f, -0.2f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$270(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.975f, 0.55f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$269(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$268(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$267(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(155.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, -0.75f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$266(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, -0.75f, -0.075f);
        GL11.glScalef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$265(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glScalef(0.1f, 0.1f, 0.1f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -6.849998f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$264(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$263(final RenderContext renderContext) {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.899998f, 1.400002f, -2.4f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$262(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.325f, -0.375f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$261(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.325f, -0.375f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$260(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -1.025f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$259(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(105.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.2f, -0.775f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$258(final RenderContext renderContext) {
        GL11.glScalef(0.33f, 0.33f, 0.33f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$257(final RenderContext renderContext) {
        GL11.glScalef(0.33f, 0.33f, 0.33f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.5f, -2.15f, -2.3f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$256(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.2f, -0.3f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$255(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.525f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$254(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createGrenade$253(final RenderContext context) {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-3.0f, -0.6f, -2.2f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$252(final RenderContext renderContext) {
        GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
        GL11.glTranslatef(-3.0f, -1.0f, 3.0f);
        GL11.glRotatef(-225.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGrenade$251(final ItemStack itemStack) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(1.0f, 1.8f, -1.6f);
        GL11.glRotatef(230.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ Float lambda$createGrenade$250() {
        return -0.025f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$249() {
        return 0.2f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$248() {
        return -0.025f;
    }
    
    private static /* synthetic */ void lambda$createGrenade$247() {
        GL11.glScalef(0.2f, 0.2f, 0.2f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ Float lambda$createGrenade$246() {
        return 0.99f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$245() {
        return 0.06f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$244() {
        return 1.3f;
    }
    
    private static /* synthetic */ Float lambda$createGrenade$243() {
        return 0.8f;
    }
    
    private static /* synthetic */ void lambda$createGrenade$242(final EntityPlayer p, final ItemStack s) {
    }
}
