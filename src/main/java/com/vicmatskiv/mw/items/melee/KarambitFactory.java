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

public class KarambitFactory implements MeleeFactory
{
    public KarambitFactory() {
        super();
    }
    
    @Override
    public Item createMelee(final CommonProxy commonProxy) {
        return new ItemMelee.Builder().withModId("mw").withName("Karambit").withCreativeTab(ModernWarfareMod.gunsTab).withTextureNames("TacKnifeStandard").withAttackDamage(6.0f).withHeavyAttackDamage(13.0f).withPrepareStubTimeout(() -> 100).withPrepareHeavyStubTimeout(() -> 530).withAttackCooldownTimeout(() -> 300).withHeavyAttackCooldownTimeout(() -> 1000).withAttackSound("swoosh").withHeavyAttackSound("swoosh").withCompatibleSkin(MeleeSkins.CrimsonBlood, "TacKnifeCrimsonBlood").withCompatibleSkin(MeleeSkins.Chrome, "TacKnifeChrome").withCompatibleSkin(MeleeSkins.GodWillsIt, "TacKnifeGodWillsIt").withCompatibleSkin(MeleeSkins.Murasaki, "TacKnifeMurasaki").withCompatibleSkin(MeleeSkins.Evangelion, "TacKnifeEvangelion").withCraftingRecipe("X  ", " X ", " F ", 'X', CommonProxy.SteelPlate, 'F', CompatibleItems.STICK).withRenderer(new MeleeRenderer.Builder().withModId("mw").withModel(new Karambit()).withAnimationDuration(200).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(1.0f, 1.3f, -1.3f);
            GL11.glRotatef(230.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            GL11.glTranslatef(-1.0f, -0.4f, 1.1f);
            GL11.glRotatef(-225.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-260.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(context -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.075f, -0.775f, -1.125f);
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
        }).withFirstPersonPositioningAttacking(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-95.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.025f, -0.05f, -1.949999f);
        }, 100L, 50L)).withFirstPersonLeftHandPositioningAttacking(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.1f, -0.95f, 0.425f);
        }, 70L, 0L)).withFirstPersonRightHandPositioningAttacking(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, 0.05f, 0.025f);
        }, 70L, 0L)).withFirstPersonPositioningHeavyAttacking(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.475f, -0.575f, -1.349999f);
        }, 260L, 120L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.475f, -1.2f, -1.349999f);
        }, 80L, 80L)).withFirstPersonLeftHandPositioningHeavyAttacking(new Transition(renderContext -> {
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
        }, 70L, 0L)).withFirstPersonRightHandPositioningHeavyAttacking(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-125.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-40.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.15f, -0.025f);
        }, 70L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-130.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -0.05f, 0.05f);
        }, 70L, 0L)).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(170.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.0f, 1.074999f, -1.174999f);
        }).withFirstPersonHandPositioningModifying(context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.0f, -1.0f, 1.0f);
        }, context -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.325f, -0.2f, -0.2f);
        }).build()).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createMelee$9126(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.325f, -0.2f, -0.2f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9125(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.0f, -1.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9124(final RenderContext renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(170.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.0f, 1.074999f, -1.174999f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9123(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-130.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.05f, 0.05f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9122(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-125.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-40.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.15f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9121(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-140.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.05f, -0.9f, -0.2f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9120(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.95f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9119(final RenderContext renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.475f, -1.2f, -1.349999f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9118(final RenderContext renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.475f, -0.575f, -1.349999f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9117(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, 0.05f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9116(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.95f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9115(final RenderContext renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-95.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.025f, -0.05f, -1.949999f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9114(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.2f, -0.3f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9113(final RenderContext context) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.525f, 0.425f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9112(final RenderContext context) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.075f, -0.775f, -1.125f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9111(final RenderContext renderContext) {
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        GL11.glTranslatef(-1.0f, -0.4f, 1.1f);
        GL11.glRotatef(-225.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-260.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createMelee$9110(final ItemStack itemStack) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(1.0f, 1.3f, -1.3f);
        GL11.glRotatef(230.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ Integer lambda$createMelee$9109() {
        return 1000;
    }
    
    private static /* synthetic */ Integer lambda$createMelee$9108() {
        return 300;
    }
    
    private static /* synthetic */ Integer lambda$createMelee$9107() {
        return 530;
    }
    
    private static /* synthetic */ Integer lambda$createMelee$9106() {
        return 100;
    }
}
