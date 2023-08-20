package com.vicmatskiv.mw.items.melee;

import com.vicmatskiv.mw.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.melee.*;
import net.minecraft.item.*;

public class TestMeleeFactory implements MeleeFactory
{
    public TestMeleeFactory() {
        super();
    }
    
    @Override
    public Item createMelee(final CommonProxy commonProxy) {
        return new ItemMelee.Builder().withModId("mw").withName("TacKnifeStandard").withCreativeTab(ModernWarfareMod.gunsTab).withTextureNames("TacKnifeStandard").withAttackDamage(8.5f).withHeavyAttackDamage(17.0f).withPrepareStubTimeout(() -> 100).withPrepareHeavyStubTimeout(() -> 530).withAttackCooldownTimeout(() -> 500).withHeavyAttackCooldownTimeout(() -> 1500).withAttackSound("swoosh").withHeavyAttackSound("swoosh").withCompatibleSkin(MeleeSkins.CrimsonBlood, "TacKnifeCrimsonBlood").withCompatibleSkin(MeleeSkins.Chrome, "TacKnifeChrome").withCompatibleSkin(MeleeSkins.GodWillsIt, "TacKnifeGodWillsIt").withCompatibleSkin(MeleeSkins.Murasaki, "TacKnifeMurasaki").withCompatibleSkin(MeleeSkins.Evangelion, "TacKnifeEvangelion").withCraftingRecipe(" X ", " X ", " F ", 'X', CommonProxy.SteelPlate, 'F', CompatibleItems.STICK).withRenderer(new MeleeRenderer.Builder().withModId("mw").withModel(new TacKnifeStandard()).withAnimationDuration(200).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(1.0f, 1.3f, -1.3f);
            GL11.glRotatef(230.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glTranslatef(-1.2f, -0.45f, 1.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(context -> {
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.0f, -0.5f, -1.0f);
        }).withFirstPersonHandPositioning(context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -0.525f, 0.425f);
        }, context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.225f, -0.4f, -0.05f);
        }).withFirstPersonPositioningAttacking(new Transition(renderContext -> {
            GL11.glTranslatef(-0.7f, -0.3f, -1.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-110.0f, 0.0f, 0.0f, 1.0f);
        }, 80L, 0L), new Transition(renderContext -> {
            GL11.glTranslatef(-0.7f, -0.3f, -1.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.7f, 0.4f, -1.0f);
        }, 40L, 50L)).withFirstPersonLeftHandPositioningAttacking(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.1f, -0.95f, 0.425f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.1f, -0.95f, 0.425f);
        }, 70L, 0L)).withFirstPersonRightHandPositioningAttacking(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.375f, -0.2f, 0.0f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, 0.05f, 0.025f);
        }, 70L, 0L)).withFirstPersonPositioningHeavyAttacking(new Transition(renderContext -> {
            GL11.glTranslatef(-0.7f, -0.3f, -1.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-110.0f, 0.0f, 0.0f, 1.0f);
        }, 180L, 0L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-100.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.675f, 0.075f, -1.574999f);
        }, 200L, 150L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-100.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.65f, -2.0f, -1.649999f);
        }, 70L, 70L)).withFirstPersonLeftHandPositioningHeavyAttacking(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.1f, -0.95f, 0.425f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-140.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.05f, -0.9f, -0.2f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.05f, -0.75f, 0.15f);
        }, 70L, 0L)).withFirstPersonRightHandPositioningHeavyAttacking(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.375f, -0.2f, 0.0f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.525f, -0.025f, 0.075f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.3f, 0.0f, 0.075f);
        }, 70L, 0L)).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.5f, -0.5f, -1.5f);
        }).withFirstPersonHandPositioningModifying(context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.0f, -1.0f, 1.0f);
        }, context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.275f, -0.125f, -0.05f);
        }).build()).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createMelee$9153(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.275f, -0.125f, -0.05f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9152(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.0f, -1.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9151(final RenderContext renderContext) {
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -1.5f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9150(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.3f, 0.0f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9149(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.525f, -0.025f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9148(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.2f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9147(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(85.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.05f, -0.75f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9146(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-140.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.05f, -0.9f, -0.2f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9145(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.95f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9144(final RenderContext renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-100.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.65f, -2.0f, -1.649999f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9143(final RenderContext renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-100.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.675f, 0.075f, -1.574999f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9142(final RenderContext renderContext) {
        GL11.glTranslatef(-0.7f, -0.3f, -1.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-110.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9141(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, 0.05f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9140(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.2f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9139(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.95f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9138(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.95f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9137(final RenderContext renderContext) {
        GL11.glTranslatef(-0.7f, -0.3f, -1.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.7f, 0.4f, -1.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9136(final RenderContext renderContext) {
        GL11.glTranslatef(-0.7f, -0.3f, -1.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-110.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9135(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.4f, -0.05f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9134(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.525f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9133(final RenderContext context) {
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.0f, -0.5f, -1.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9132(final RenderContext renderContext) {
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glTranslatef(-1.2f, -0.45f, 1.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9131(final ItemStack itemStack) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(1.0f, 1.3f, -1.3f);
        GL11.glRotatef(230.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ Integer lambda$createMelee$9130() {
        return 1500;
    }
    
    private static /* synthetic */ Integer lambda$createMelee$9129() {
        return 500;
    }
    
    private static /* synthetic */ Integer lambda$createMelee$9128() {
        return 530;
    }
    
    private static /* synthetic */ Integer lambda$createMelee$9127() {
        return 100;
    }
}
