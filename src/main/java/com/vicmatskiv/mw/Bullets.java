package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.config.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.crafting.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class Bullets
{
    public static ItemBullet ShotgunShell;
    public static ItemBullet Magnum44Ammo;
    public static ItemBullet Bullet762x39;
    public static ItemBullet Bullet556x39;
    public static ItemBullet Bullet556x45;
    public static ItemBullet Bullet762x54;
    public static ItemBullet Bullet762x51;
    public static ItemBullet Bullet45ACP;
    public static ItemBullet Bullet9mm;
    public static ItemBullet Bullet357;
    public static ItemBullet BMG50;
    public static ItemBullet Bullet57x28;
    public static ItemBullet Bullet46x30;
    public static ItemBullet Carbine30;
    public static ItemBullet Bullet65x39;
    public static ItemBullet Bullet10x24;
    public static ItemBullet Bullet10mm;
    public static ItemBullet Bullet300Blackout;
    public static ItemBullet SMAWRocket;
    public static ItemBullet Bullet50;
    public static ItemBullet Bullet9x39mm;
    public static ItemBullet BulletSpringfield3006;
    public static ItemBullet Bullet545x39;
    
    public Bullets() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        Bullets.ShotgunShell = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("ShotgunShell").withModel(new ShotgunShell(), "ShotgunShell.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.2f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.9f, -0.29f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet9x39mm = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet9x39mm").withModel(new BulletBig(), "Gold.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.2f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.9f, -0.29f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.SMAWRocket = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("SMAWRocket").withMaxStackSize(1).withModel(new SMAWRocket(), "SMAW.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.2f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.9f, -0.29f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, 0.8f, -2.1f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            return;
        }).withTextureName("Dummy.png").withCraftingRecipe("AXX", 'X', CommonProxy.SteelPlate, 'A', CompatibleBlocks.TNT).build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet10x24 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.FunGunsTab).withName("Bullet10x24").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.2f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.9f, -0.29f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Magnum44Ammo = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Magnum44Ammo").withModel(new Bullet44(), "Bullet44.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Carbine30 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Carbine30").withModel(new Bullet44(), "Bullet44.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.6000000238418579, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.5, 0.30000001192092896);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.7999999523162842, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.BulletSpringfield3006 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("BulletSpringfield3006").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.6000000238418579, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.5, 0.30000001192092896);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.7999999523162842, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet357 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet357").withModel(new Bullet44(), "Bullet44.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.6000000238418579, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.5, 0.30000001192092896);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.7999999523162842, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet50 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet50AE").withModel(new Bullet44(), "Bullet44.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.6000000238418579, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.5, 0.30000001192092896);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.7999999523162842, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet9mm = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet9mm").withModel(new Bullet44(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet10mm = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet10mm").withModel(new Bullet44(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet45ACP = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet45ACP").withModel(new Bullet44(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet762x39 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet762x39").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.6000000238418579, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.399999976158142, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet46x30 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet46x30").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.6000000238418579, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.399999976158142, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet57x28 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet57x28").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.6000000238418579, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.399999976158142, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet556x39 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet556x39").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.30000001192092896, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.44999998807907104, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.2999999523162842, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet545x39 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet545x39").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.30000001192092896, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.44999998807907104, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.2999999523162842, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet556x45 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet556x45").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.399999976158142, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet762x54 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet762x54").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.5, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.6000000238418579, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.5, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet762x51 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet762x51").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.44999998807907104, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.550000011920929, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.4500000476837158, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet300Blackout = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet300Blackout").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.44999998807907104, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.550000011920929, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.4500000476837158, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.BMG50 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("BMG50").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.MEDIUM, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.699999988079071, 0.4000000059604645);
            return;
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.699999988079071, 0.5);
            return;
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.399999976158142, 1.7999999523162842, 1.399999976158142);
            return;
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
        Bullets.Bullet65x39 = new ItemBullet.Builder().withModId("mw").withCreativeTab(ModernWarfareMod.AmmoTab).withName("Bullet65x39").withModel(new BulletBig(), "Bullet.png").withCrafting(8, CraftingComplexity.LOW, "ingotCopper", CompatibleItems.GUNPOWDER).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(0.1f, -1.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        }).withThirdPersonPositioning((player, itemStack) -> {
            GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }).withInventoryPositioning(itemStack -> {
            GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.4500000476837158, 1.4500000476837158, 1.4500000476837158);
        }).withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT, ItemBullet.class);
    }
    
    private static /* synthetic */ void lambda$init$228(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.4500000476837158, 1.4500000476837158, 1.4500000476837158);
    }
    
    private static /* synthetic */ void lambda$init$227(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
    }
    
    private static /* synthetic */ void lambda$init$226(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
    }
    
    private static /* synthetic */ void lambda$init$225(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.7999999523162842, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$224(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.699999988079071, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$223(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.699999988079071, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$222(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.4500000476837158, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$221(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.550000011920929, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$220(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.44999998807907104, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$219(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.4500000476837158, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$218(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.550000011920929, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$217(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.44999998807907104, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$216(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.5, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$215(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.6000000238418579, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$214(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.5, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$213(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.399999976158142, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$212(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.5, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$211(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$210(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.2999999523162842, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$209(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.44999998807907104, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$208(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.30000001192092896, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$207(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.2999999523162842, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$206(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.44999998807907104, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$205(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.30000001192092896, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$204(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.399999976158142, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$203(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.6000000238418579, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$202(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$201(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.399999976158142, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$200(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.6000000238418579, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$199(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$198(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.399999976158142, 1.399999976158142, 1.399999976158142);
    }
    
    private static /* synthetic */ void lambda$init$197(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.6000000238418579, 0.5);
    }
    
    private static /* synthetic */ void lambda$init$196(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$195(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$194(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
    }
    
    private static /* synthetic */ void lambda$init$193(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$192(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$191(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
    }
    
    private static /* synthetic */ void lambda$init$190(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$189(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$188(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
    }
    
    private static /* synthetic */ void lambda$init$187(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$186(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.7999999523162842, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$185(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.30000001192092896, 0.5, 0.30000001192092896);
    }
    
    private static /* synthetic */ void lambda$init$184(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.6000000238418579, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$183(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.7999999523162842, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$182(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.30000001192092896, 0.5, 0.30000001192092896);
    }
    
    private static /* synthetic */ void lambda$init$181(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.6000000238418579, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$180(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.7999999523162842, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$179(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.30000001192092896, 0.5, 0.30000001192092896);
    }
    
    private static /* synthetic */ void lambda$init$178(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.6000000238418579, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$177(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.7999999523162842, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$176(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.30000001192092896, 0.5, 0.30000001192092896);
    }
    
    private static /* synthetic */ void lambda$init$175(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.6000000238418579, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$174(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$173(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.7f, -0.29f, 0.7f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
    }
    
    private static /* synthetic */ void lambda$init$172(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.0f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$init$171(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$170(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -0.29f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$169(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.2f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$init$168(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, 0.8f, -2.1f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    }
    
    private static /* synthetic */ void lambda$init$167(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -0.29f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.0, 0.0, 0.0);
    }
    
    private static /* synthetic */ void lambda$init$166(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.2f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.0, 0.0, 0.0);
    }
    
    private static /* synthetic */ void lambda$init$165(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$164(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -0.29f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$163(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.2f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$init$162(final ItemStack itemStack) {
        GL11.glTranslatef(-0.8f, -0.45f, 0.4f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
    }
    
    private static /* synthetic */ void lambda$init$161(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(-0.9f, -0.29f, 0.8f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$init$160(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glTranslatef(0.1f, -1.2f, 0.4f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
}
