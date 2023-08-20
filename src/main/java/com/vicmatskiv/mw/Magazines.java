package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.config.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class Magazines
{
    public static ItemMagazine Magazine762x39;
    public static ItemMagazine PMAG762x39;
    public static ItemMagazine Mag75rnd762x39;
    public static ItemMagazine AK12Mag;
    public static ItemMagazine RPK74MMag;
    public static ItemMagazine AK74MMag;
    public static ItemMagazine AKS74UMag;
    public static ItemMagazine NATOMag1;
    public static ItemMagazine NATO20rnd;
    public static ItemMagazine NATO40rnd;
    public static ItemMagazine NATOMag2;
    public static ItemMagazine NATOFamasMag;
    public static ItemMagazine NATOG36Mag;
    public static ItemMagazine DragunovMag;
    public static ItemMagazine FALMag;
    public static ItemMagazine M110Mag;
    public static ItemMagazine M14DMRMag;
    public static ItemMagazine Glock21Mag;
    public static ItemMagazine Glock18Mag;
    public static ItemMagazine G18Mag;
    public static ItemMagazine NATODrum100;
    public static ItemMagazine M9BerettaMag;
    public static ItemMagazine MP40Mag;
    public static ItemMagazine MP5KMag;
    public static ItemMagazine DeagleMag;
    public static ItemMagazine AS50Mag;
    public static ItemMagazine FNP90Mag;
    public static ItemMagazine M107BMag;
    public static ItemMagazine HKMP7Mag;
    public static ItemMagazine M1CarbineMag;
    public static ItemMagazine M240Mag;
    public static ItemMagazine L115Mag;
    public static ItemMagazine SV98Mag;
    public static ItemMagazine ColtM1911Mag;
    public static ItemMagazine M249Mag;
    public static ItemMagazine MXMag;
    public static ItemMagazine M41AMag;
    public static ItemMagazine HK33Mag;
    public static ItemMagazine Mag10mm;
    public static ItemMagazine Magazine9mm;
    public static ItemMagazine ScarHMag;
    public static ItemMagazine AK101Mag;
    public static ItemMagazine VectorMag;
    public static ItemMagazine G3Mag;
    public static ItemMagazine PP19Mag;
    public static ItemMagazine Glock32Mag;
    public static ItemMagazine HecateIIMag;
    public static ItemMagazine Deagle50Mag;
    public static ItemMagazine VSSVintorezMag;
    public static ItemMagazine ASValMag;
    public static ItemMagazine M8A7Mag;
    
    public Magazines() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        Magazines.Magazine762x39 = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet762x39).withName("Magazine762x39").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new Magazine762x39(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, 0.5f, -1.4f);
            GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withTextureName("Dummy.png").withCraftingRecipe("  X", "X X", "XX ", 'X', "ingotSteel").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.Mag75rnd762x39 = new ItemMagazine.Builder().withAmmo(75).withCompatibleBullet(Bullets.Bullet762x39).withName("Mag75rnd762x39").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new Mag75rnd(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, 0.2f, -0.6f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withTextureName("Dummy.png").withCraftingRecipe("  X", "XXX", "XX ", 'X', "ingotSteel").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.G3Mag = new ItemMagazine.Builder().withAmmo(21).withCompatibleBullet(Bullets.Bullet762x51).withName("G3Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new G3Mag(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.3f, -0.6f, 1.2f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.9f, -1.5f, 1.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 1.0f, -1.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            return;
        }).withTextureName("Dummy.png").withCraftingRecipe(" F", " A", "FF", 'A', "ingotSteel", 'F', CommonProxy.MiniSteelPlate).build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.AK101Mag = new ItemMagazine.Builder().withAmmo(32).withCompatibleBullet(Bullets.Bullet556x45).withName("AK101Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new Magazine545x39(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, 0.3f, -1.0f);
            GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withTextureName("Dummy.png").withCraftingRecipe("  A", "A R", "AR ", 'A', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M8A7Mag = new ItemMagazine.Builder().withAmmo(32).withCompatibleBullet(Bullets.Bullet300Blackout).withName("M8A7Mag").withModId("mw").withCreativeTab(ModernWarfareMod.FunGunsTab).withModel(new M8A7Mag(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.8f, -1.0f, 0.9f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, 0.4f, -0.8f);
            GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withTextureName("Dummy.png").withCraftingRecipe("  A", "ARA", "AR ", 'A', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.PMAG762x39 = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet762x39).withName("PMAG762x39").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new PMAG762x39(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, 0.5f, -1.4f);
            GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withTextureName("Dummy.png").withCraftingRecipe("  R", "R X", "XR ", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.AK12Mag = new ItemMagazine.Builder().withAmmo(31).withCompatibleBullet(Bullets.Bullet556x39).withName("AK12Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new AK12Magazine(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.3f, -0.6f, 1.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.9f, -1.3f, 1.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.6f, 0.55f, -1.2f);
            GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withCraftingRecipe("  R", "X R", "XR ", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.RPK74MMag = new ItemMagazine.Builder().withAmmo(40).withCompatibleBullet(Bullets.Bullet762x39).withName("RPK74MMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new RPK74MMag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.85f, -0.35f, 0.4f);
            GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            return;
        }).withCraftingRecipe("  X", "X X", "RR ", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.AK74MMag = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet545x39).withName("AK74MMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new Magazine545x39(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, 0.3f, -1.0f);
            GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withCraftingRecipe("  R", "R X", "RX ", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.AKS74UMag = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet545x39).withName("AKS74UMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new Magazine545x39(), "AKS74UMag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, 0.3f, -1.0f);
            GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withCraftingRecipe("  X", "X R", "XR ", 'X', CompatibleItems.IRON_INGOT, 'R', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.NATOMag1 = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet556x45).withName("NATOMag1").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new NATOMag1(), "NATOMag1.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 0.0f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("  X", "X X", "XX ", 'X', "ingotAluminium").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.NATO20rnd = new ItemMagazine.Builder().withAmmo(20).withCompatibleBullet(Bullets.Bullet556x45).withName("NATO20rnd").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new NATO20rnd(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 0.0f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe(" XX", "XX ", 'X', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.NATO40rnd = new ItemMagazine.Builder().withAmmo(40).withCompatibleBullet(Bullets.Bullet556x45).withName("NATO40rnd").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new NATO40rnd(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, -0.1f, 0.2f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withCraftingRecipe(" XX", "XXX", "XX ", 'X', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.NATOMag2 = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet556x45).withName("NATOMag2").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new NATOMag2(), "NATOMag2.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 0.0f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("  X", "X R", "XR ", 'X', "ingotAluminium", 'R', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.NATOFamasMag = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet556x45).withName("NATOFamasMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new NATOFamasMag(), "NATOMag1.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.3f, 0.1f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("X X", "  X", " XX", 'X', "ingotAluminium", 'R', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.NATOG36Mag = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet556x45).withName("NATOG36Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new NATOG36Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.2f, 0.2f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("  X", "X X", "RR ", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.DragunovMag = new ItemMagazine.Builder().withAmmo(11).withCompatibleBullet(Bullets.Bullet762x54).withName("DragunovMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new DragunovMag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.3f, 2.1f, -2.8f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("X X", " RR", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.FALMag = new ItemMagazine.Builder().withAmmo(20).withCompatibleBullet(Bullets.Bullet762x51).withName("FALMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new FNFALMag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.2f, 0.2f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("X R", "  R", " RR", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M110Mag = new ItemMagazine.Builder().withAmmo(10).withCompatibleBullet(Bullets.Bullet762x51).withName("M110Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new M110Mag(), "NATOMag1.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.25f, 0.1f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("X R", "  R", " XR", 'X', CompatibleItems.IRON_INGOT, 'R', "ingotAluminium").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M14DMRMag = new ItemMagazine.Builder().withAmmo(21).withCompatibleBullet(Bullets.Bullet762x51).withName("M14DMRMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new M14Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 0.3f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe(" R", " R", "XX", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.Glock21Mag = new ItemMagazine.Builder().withAmmo(13).withCompatibleBullet(Bullets.Bullet45ACP).withName("Glock21Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new GlockMagazine(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.6f, -0.3f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("X", "X", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.Glock18Mag = new ItemMagazine.Builder().withAmmo(17).withCompatibleBullet(Bullets.Bullet9mm).withName("Glock18Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new GlockMagazine(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.6f, -0.3f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("R", "X", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.G18Mag = new ItemMagazine.Builder().withAmmo(20).withCompatibleBullet(Bullets.Bullet9mm).withName("G18Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new G18Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.6f, -0.65f, 0.45f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withCraftingRecipe("R", "X", "X", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.Glock32Mag = new ItemMagazine.Builder().withAmmo(14).withCompatibleBullet(Bullets.Bullet357).withName("Glock32Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new GlockMagazine(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.6f, -0.3f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe(" A", " A", "AF", 'A', "ingotSteel", 'F', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M9BerettaMag = new ItemMagazine.Builder().withAmmo(15).withCompatibleBullet(Bullets.Bullet9mm).withName("M9BerettaMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new M9Mag(), "M9Mag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("X", "R", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.Mag10mm = new ItemMagazine.Builder().withAmmo(10).withCompatibleBullet(Bullets.Bullet10mm).withName("Mag10mm").withModId("mw").withCreativeTab(ModernWarfareMod.FunGunsTab).withModel(new M9Mag(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe(" A", " R", 'A', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.Magazine9mm = new ItemMagazine.Builder().withAmmo(10).withCompatibleBullet(Bullets.Bullet9mm).withName("Magazine9mm").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new MakarovMag(), "MakarovMag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe(" A", " A", "RR", 'A', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.NATODrum100 = new ItemMagazine.Builder().withAmmo(100).withCompatibleBullet(Bullets.Bullet556x45).withName("NATODrum100").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new NATODrum100(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.5f, 0.4f, 0.4f);
            GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withCraftingRecipe(" X ", "R R", "R R", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.MP40Mag = new ItemMagazine.Builder().withAmmo(32).withCompatibleBullet(Bullets.Bullet9mm).withName("MP40Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new MP40Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -1.3f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.2f, 0.0f, -1.3f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withCraftingRecipe("X", "X", "X", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.VectorMag = new ItemMagazine.Builder().withAmmo(26).withCompatibleBullet(Bullets.Bullet45ACP).withName("VectorMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new MP40Mag(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -1.3f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.2f, 0.0f, -1.3f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withCraftingRecipe(" A", " A", "AA", 'A', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.MP5KMag = new ItemMagazine.Builder().withAmmo(25).withCompatibleBullet(Bullets.Bullet9mm).withName("MP5KMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new HKMP5Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 1.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.9f, -1.6f, 1.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 0.95f, -1.6f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            return;
        }).withCraftingRecipe(" R", " X", "X ", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.DeagleMag = new ItemMagazine.Builder().withAmmo(9).withCompatibleBullet(Bullets.Bullet357).withName("DeagleMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new DeagleMag(), "Deagle.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("X", "X", 'X', "ingotAluminium").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.Deagle50Mag = new ItemMagazine.Builder().withAmmo(7).withCompatibleBullet(Bullets.Bullet50).withName("Deagle50Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new DeagleMag(), "Deagle44.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("X", "R", 'X', "ingotAluminium", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.VSSVintorezMag = new ItemMagazine.Builder().withAmmo(10).withCompatibleBullet(Bullets.Bullet9x39mm).withName("VSSVintorezMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new VSSVintorezMag(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.3f, 0.2f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("R X", " XR", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.ASValMag = new ItemMagazine.Builder().withAmmo(20).withCompatibleBullet(Bullets.Bullet9x39mm).withName("ASValMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new ASValMag(), "ASValMag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.3f, 0.2f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("R X", "XXR", " XX", 'X', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.AS50Mag = new ItemMagazine.Builder().withAmmo(10).withCompatibleBullet(Bullets.BMG50).withName("AS50Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new AS50Mag(), "NATOMag1.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.9f, 0.2f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("RXR", "  X", 'R', "ingotAluminium", 'X', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.HecateIIMag = new ItemMagazine.Builder().withAmmo(7).withCompatibleBullet(Bullets.BMG50).withName("HecateIIMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new AS50Mag(), "NATOMag1.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.6000000238418579, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.6000000238418579, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.9f, 0.2f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 0.8999999761581421, 1.0);
            return;
        }).withCraftingRecipe(" FF", "A A", 'A', "ingotSteel", 'F', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.FNP90Mag = new ItemMagazine.Builder().withAmmo(50).withCompatibleBullet(Bullets.Bullet57x28).withName("FNP90Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new P90Mag(), "P90Mag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.3f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.3f, 0.5f, 0.1f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(0.3f, 1.2f, 0.4f);
            GL11.glRotatef(-170.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withCraftingRecipe("XXX", 'X', "ingotCopper").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M107BMag = new ItemMagazine.Builder().withAmmo(10).withCompatibleBullet(Bullets.BMG50).withName("M107BMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new M107Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.9f, -0.1f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("RAR", "  A", 'R', CommonProxy.MiniSteelPlate, 'A', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.HKMP7Mag = new ItemMagazine.Builder().withAmmo(20).withCompatibleBullet(Bullets.Bullet46x30).withName("HKMP7Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new MP7Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(1.0f, -0.0f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withCraftingRecipe("RA", " A", "A ", 'A', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M1CarbineMag = new ItemMagazine.Builder().withAmmo(15).withCompatibleBullet(Bullets.Carbine30).withName("M1CarbineMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new M14Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 0.3f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe(" A", " R", "A ", 'A', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M240Mag = new ItemMagazine.Builder().withAmmo(200).withCompatibleBullet(Bullets.Bullet762x51).withName("M240Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new M240Mag(), "M240Mag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.2f, 0.3f, 0.4f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            return;
        }).withCraftingRecipe("  A", "A A", "AAA", 'A', CompatibleItems.IRON_INGOT).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.L115Mag = new ItemMagazine.Builder().withAmmo(8).withCompatibleBullet(Bullets.Bullet762x51).withName("LP115Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new L115Mag(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.3f, -0.5f, 0.6f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.2f, -0.5f, 0.9f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-1.0f, 0.3f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            return;
        }).withCraftingRecipe("AA", " A", 'A', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.SV98Mag = new ItemMagazine.Builder().withAmmo(10).withCompatibleBullet(Bullets.Bullet762x54).withName("SV98Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new SV98Mag(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.3f, -0.5f, 0.6f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.2f, -0.5f, 0.9f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-1.0f, 0.3f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            return;
        }).withCraftingRecipe("XA", " A", 'A', CommonProxy.MiniSteelPlate, 'X', CommonProxy.SteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.ColtM1911Mag = new ItemMagazine.Builder().withAmmo(10).withCompatibleBullet(Bullets.Bullet45ACP).withName("ColtM1911Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new GlockMagazine(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.6f, -0.3f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe("A", "R", 'A', CommonProxy.MiniSteelPlate, 'R', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M249Mag = new ItemMagazine.Builder().withAmmo(200).withCompatibleBullet(Bullets.Bullet556x45).withName("M249Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new M240Mag(), "M240Mag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.2f, 0.3f, 0.4f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            return;
        }).withCraftingRecipe("  R", "A A", "AAA", 'A', CompatibleItems.IRON_INGOT, 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.MXMag = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet65x39).withName("MXMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new MXMag(), "MXMag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 0.0f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withCraftingRecipe(" R", " A", "AR", 'A', CompatibleItems.IRON_INGOT, 'R', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.M41AMag = new ItemMagazine.Builder().withAmmo(99).withCompatibleBullet(Bullets.Bullet65x39).withName("M41AMag").withModId("mw").withCreativeTab(ModernWarfareMod.FunGunsTab).withModel(new M41AMag(), "M41AMag.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.1f, -1.0f, 0.2f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.8f, -0.2f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, -0.6f, 0.8f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2999999523162842, 1.2999999523162842, 1.2999999523162842);
            return;
        }).withCraftingRecipe(" A", " R", "AA", 'A', CommonProxy.MiniSteelPlate, 'A', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.HK33Mag = new ItemMagazine.Builder().withAmmo(31).withCompatibleBullet(Bullets.Bullet556x45).withName("HK33Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new HK33Mag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.3f, -0.6f, 1.2f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.9f, -1.5f, 1.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 1.0f, -1.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            return;
        }).withCraftingRecipe("  R", "R A", "AR ", 'R', CommonProxy.MiniSteelPlate, 'A', "ingotSteel").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.ScarHMag = new ItemMagazine.Builder().withAmmo(30).withCompatibleBullet(Bullets.Bullet300Blackout).withName("ScarHMag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new ScarHMag(), "GunmetalTexture.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.7f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.4f, 0.2f, 0.4f);
            GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.100000023841858, 1.100000023841858, 1.100000023841858);
            return;
        }).withCraftingRecipe("RR", " A", " A", 'A', "ingotSteel", 'R', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
        Magazines.PP19Mag = new ItemMagazine.Builder().withAmmo(65).withCompatibleBullet(Bullets.Bullet9mm).withName("PP19Mag").withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withModel(new PPBizonMag(), "AK12.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -0.3f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.3f, 0.5f, 0.1f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(0.3f, 0.7f, -1.2f);
            GL11.glRotatef(-170.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        }).withCraftingRecipe("AAF", "   ", "AAF", 'A', "ingotSteel", 'F', CommonProxy.MiniSteelPlate).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemMagazine.class);
    }
    
    private static /* synthetic */ void lambda$init$9306(final ItemStack itemStack) {
        GL11.glTranslatef(0.3f, 0.7f, -1.2f);
        GL11.glRotatef(-170.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9305(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.3f, 0.5f, 0.1f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9304(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.3f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9303(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 0.2f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.100000023841858, 1.100000023841858, 1.100000023841858);
    }
    
    private static /* synthetic */ void lambda$init$9302(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9301(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9300(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 1.0f, -1.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$init$9299(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -1.5f, 1.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9298(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.3f, -0.6f, 1.2f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9297(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, -0.6f, 0.8f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.2999999523162842, 1.2999999523162842, 1.2999999523162842);
    }
    
    private static /* synthetic */ void lambda$init$9296(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.2f, 0.6f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9295(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.1f, -1.0f, 0.2f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9294(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 0.0f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9293(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9292(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9291(final ItemStack itemStack) {
        GL11.glTranslatef(-0.2f, 0.3f, 0.4f);
        GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$init$9290(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9289(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9288(final ItemStack itemStack) {
        GL11.glTranslatef(-0.6f, -0.3f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9287(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9286(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9285(final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, 0.3f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$init$9284(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.2f, -0.5f, 0.9f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9283(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.3f, -0.5f, 0.6f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9282(final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, 0.3f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$init$9281(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.2f, -0.5f, 0.9f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9280(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.3f, -0.5f, 0.6f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9279(final ItemStack itemStack) {
        GL11.glTranslatef(-0.2f, 0.3f, 0.4f);
        GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$init$9278(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9277(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9276(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 0.3f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9275(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9274(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9273(final ItemStack itemStack) {
        GL11.glTranslatef(1.0f, -0.0f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9272(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9271(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9270(final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -0.1f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9269(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9268(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9267(final ItemStack itemStack) {
        GL11.glTranslatef(0.3f, 1.2f, 0.4f);
        GL11.glRotatef(-170.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9266(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.3f, 0.5f, 0.1f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9265(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.3f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9264(final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, 0.2f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 0.8999999761581421, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9263(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.6000000238418579, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9262(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.6000000238418579, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9261(final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, 0.2f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9260(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9259(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9258(final ItemStack itemStack) {
        GL11.glTranslatef(-0.3f, 0.2f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9257(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9256(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9255(final ItemStack itemStack) {
        GL11.glTranslatef(-0.3f, 0.2f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9254(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9253(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9252(final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9251(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9250(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9249(final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9248(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9247(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9246(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 0.95f, -1.6f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$init$9245(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -1.6f, 1.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9244(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 1.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9243(final ItemStack itemStack) {
        GL11.glTranslatef(-0.2f, 0.0f, -1.3f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9242(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -1.3f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9241(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9240(final ItemStack itemStack) {
        GL11.glTranslatef(-0.2f, 0.0f, -1.3f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9239(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -1.3f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9238(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9237(final ItemStack itemStack) {
        GL11.glTranslatef(-0.5f, 0.4f, 0.4f);
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9236(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9235(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9234(final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9233(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9232(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9231(final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9230(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9229(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9228(final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.5f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9227(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9226(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9225(final ItemStack itemStack) {
        GL11.glTranslatef(-0.6f, -0.3f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9224(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9223(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9222(final ItemStack itemStack) {
        GL11.glTranslatef(-0.6f, -0.65f, 0.45f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9221(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9220(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9219(final ItemStack itemStack) {
        GL11.glTranslatef(-0.6f, -0.3f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9218(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9217(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9216(final ItemStack itemStack) {
        GL11.glTranslatef(-0.6f, -0.3f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9215(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9214(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9213(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 0.3f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9212(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9211(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9210(final ItemStack itemStack) {
        GL11.glTranslatef(-0.25f, 0.1f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9209(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9208(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9207(final ItemStack itemStack) {
        GL11.glTranslatef(-0.2f, 0.2f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9206(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9205(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9204(final ItemStack itemStack) {
        GL11.glTranslatef(-0.3f, 2.1f, -2.8f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9203(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9202(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9201(final ItemStack itemStack) {
        GL11.glTranslatef(-0.2f, 0.2f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9200(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9199(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9198(final ItemStack itemStack) {
        GL11.glTranslatef(-0.3f, 0.1f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9197(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9196(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9195(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 0.0f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9194(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9193(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9192(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, -0.1f, 0.2f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9191(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9190(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9189(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 0.0f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9188(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9187(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9186(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 0.0f, 0.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$9185(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.5f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9184(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9183(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, 0.3f, -1.0f);
        GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9182(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9181(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9180(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, 0.3f, -1.0f);
        GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9179(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9178(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9177(final ItemStack itemStack) {
        GL11.glTranslatef(-0.85f, -0.35f, 0.4f);
        GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$init$9176(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9175(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9174(final ItemStack itemStack) {
        GL11.glTranslatef(-0.6f, 0.55f, -1.2f);
        GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9173(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -1.3f, 1.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9172(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.3f, -0.6f, 1.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$init$9171(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, 0.5f, -1.4f);
        GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9170(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9169(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9168(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, 0.4f, -0.8f);
        GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9167(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -1.0f, 0.9f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.5, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$9166(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9165(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, 0.3f, -1.0f);
        GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9164(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9163(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9162(final ItemStack itemStack) {
        GL11.glTranslatef(-0.4f, 1.0f, -1.4f);
        GL11.glRotatef(-130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$init$9161(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -1.5f, 1.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9160(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.3f, -0.6f, 1.2f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9159(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, 0.2f, -0.6f);
        GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$init$9158(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9157(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9156(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, 0.5f, -1.4f);
        GL11.glRotatef(-120.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9155(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-1.0f, -0.7f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$9154(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -0.7f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
}
