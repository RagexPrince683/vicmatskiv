package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.world.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.nbt.*;
import net.minecraftforge.event.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.client.event.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.*;
import java.util.function.*;
import net.minecraft.block.*;
import cpw.mods.fml.common.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.multiplayer.*;
import java.util.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.util.*;

public interface Compatibility
{
    World world(final Entity p0);
    
    EntityPlayer clientPlayer();
    
    void setClientPlayer(final EntityPlayer p0);
    
    IAttribute getMovementSpeedAttribute();
    
    NBTTagCompound getTagCompound(final ItemStack p0);
    
    void setTagCompound(final ItemStack p0, final NBTTagCompound p1);
    
    ItemStack getItemStack(final ItemTossEvent p0);
    
    EntityPlayer getPlayer(final ItemTossEvent p0);
    
    ItemStack getHeldItemMainHand(final EntityLivingBase p0);
    
    boolean consumeInventoryItem(final EntityPlayer p0, final Item p1);
    
    int getCurrentInventoryItemIndex(final EntityPlayer p0);
    
    void ensureTagCompound(final ItemStack p0);
    
    void playSound(final EntityPlayer p0, final CompatibleSound p1, final float p2, final float p3);
    
    void playSoundToNearExcept(final EntityPlayer p0, final CompatibleSound p1, final float p2, final float p3);
    
    boolean isClientSide();
    
    CompatibleMathHelper getMathHelper();
    
    EntityPlayer getClientPlayer();
    
    FontRenderer getFontRenderer();
    
    ScaledResolution getResolution(final RenderGameOverlayEvent.Pre p0);
    
    RenderGameOverlayEvent.ElementType getEventType(final RenderGameOverlayEvent.Pre p0);
    
    ItemStack getHelmet();
    
    CompatibleVec3 getLookVec(final EntityPlayer p0);
    
    void registerKeyBinding(final KeyBinding p0);
    
    void registerWithEventBus(final Object p0);
    
    void registerWithFmlEventBus(final Object p0);
    
    void registerSound(final CompatibleSound p0);
    
    void registerItem(final Item p0, final String p1);
    
    void registerItem(final String p0, final Item p1, final String p2);
    
    void runInMainClientThread(final Runnable p0);
    
    void registerModEntity(final Class<? extends Entity> p0, final String p1, final int p2, final Object p3, final String p4, final int p5, final int p6, final boolean p7);
    
    void registerRenderingRegistry(final CompatibleRenderingRegistry p0);
    
     <T, E> T getPrivateValue(final Class<? super E> p0, final E p1, final String... p2);
    
    int getButton(final MouseEvent p0);
    
    EntityPlayer getEntity(final FOVUpdateEvent p0);
    
    EntityLivingBase getEntity(final RenderLivingEvent.Pre p0);
    
    void setNewFov(final FOVUpdateEvent p0, final float p1);
    
    RenderPlayer getRenderer(final RenderLivingEvent.Pre p0);
    
    GuiScreen getGui(final GuiOpenEvent p0);
    
    void setAimed(final RenderPlayer p0, final boolean p1);
    
    CompatibleRayTraceResult getObjectMouseOver();
    
    CompatibleBlockState getBlockAtPosition(final World p0, final CompatibleRayTraceResult p1);
    
    void destroyBlock(final World p0, final CompatibleRayTraceResult p1);
    
    boolean addItemToPlayerInventory(final EntityPlayer p0, final Item p1, final int p2);
    
    boolean consumeInventoryItem(final InventoryPlayer p0, final Item p1);
    
    ItemStack itemStackForItem(final Item p0, final Predicate<ItemStack> p1, final EntityPlayer p2);
    
    boolean isGlassBlock(final CompatibleBlockState p0);
    
    float getEffectOffsetX();
    
    float getEffectOffsetY();
    
    float getEffectScaleFactor();
    
    void spawnEntity(final EntityPlayer p0, final Entity p1);
    
    void moveParticle(final CompatibleParticle p0, final double p1, final double p2, final double p3);
    
    int getStackSize(final ItemStack p0);
    
    ItemStack consumeInventoryItem(final Item p0, final Predicate<ItemStack> p1, final EntityPlayer p2, final int p3);
    
    ItemStack getInventoryItemStack(final EntityPlayer p0, final int p1);
    
    int getInventorySlot(final EntityPlayer p0, final ItemStack p1);
    
    boolean consumeInventoryItemFromSlot(final EntityPlayer p0, final int p1);
    
    void addShapedRecipe(final ItemStack p0, final Object... p1);
    
    void addShapedOreRecipe(final ItemStack p0, final Object... p1);
    
    void disableLightMap();
    
    void enableLightMap();
    
    void registerBlock(final String p0, final Block p1, final String p2);
    
    void registerWorldGenerator(final IWorldGenerator p0, final int p1);
    
    ItemArmor.ArmorMaterial addArmorMaterial(final String p0, final String p1, final int p2, final int[] p3, final int p4, final CompatibleSound p5, final float p6);
    
    boolean inventoryHasFreeSlots(final EntityPlayer p0);
    
    void addBlockHitEffect(final int p0, final int p1, final int p2, final CompatibleEnumFacing p3);
    
    String getDisplayName(final EntityPlayer p0);
    
    String getPlayerName(final EntityPlayer p0);
    
    void clickBlock(final CompatibleBlockPos p0, final CompatibleEnumFacing p1);
    
    boolean isAirBlock(final World p0, final CompatibleBlockPos p1);
    
    void addChatMessage(final Entity p0, final String p1);
    
    RenderGlobal createCompatibleRenderGlobal();
    
    CompatibleParticleManager createCompatibleParticleManager(final WorldClient p0);
    
    Entity getRenderViewEntity();
    
    void setRenderViewEntity(final Entity p0);
    
    CompatibleParticleManager getCompatibleParticleManager();
    
    void addBreakingParticle(final ModContext p0, final double p1, final double p2, final double p3);
    
    float getAspectRatio(final ModContext p0);
    
    void setStackSize(final ItemStack p0, final int p1);
    
    ItemStack tryConsumingCompatibleItem(final List<? extends Item> p0, final int p1, final EntityPlayer p2, final Predicate<ItemStack>... p3);
    
    Item findItemByName(final String p0, final String p1);
    
    CompatibleRayTraceResult rayTraceBlocks(final Entity p0, final CompatibleVec3 p1, final CompatibleVec3 p2);
    
    CompatibleAxisAlignedBB expandEntityBoundingBox(final Entity p0, final double p1, final double p2, final double p3);
    
    CompatibleAxisAlignedBB getBoundingBox(final Entity p0);
    
    List<Entity> getEntitiesWithinAABBExcludingEntity(final World p0, final Entity p1, final CompatibleAxisAlignedBB p2);
    
    void spawnParticle(final World p0, final String p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7);
    
    CompatibleBlockState getBlockAtPosition(final World p0, final CompatibleBlockPos p1);
    
    boolean isBlockPenetratableByBullets(final Block p0);
    
    boolean canCollideCheck(final Block p0, final CompatibleBlockState p1, final boolean p2);
    
    float getCompatibleShellCasingForwardOffset();
    
    boolean madeFromHardMaterial(final CompatibleBlockState p0);
    
    void playSoundAtEntity(final Entity p0, final CompatibleSound p1, final float p2, final float p3);
    
    double getBlockDensity(final World p0, final CompatibleVec3 p1, final CompatibleAxisAlignedBB p2);
    
    boolean isImmuneToExplosions(final Entity p0);
    
    boolean isAirBlock(final CompatibleBlockState p0);
    
    boolean canDropBlockFromExplosion(final CompatibleBlockState p0, final Explosion p1);
    
    void onBlockExploded(final World p0, final CompatibleBlockState p1, final CompatibleBlockPos p2, final Explosion p3);
    
    float getExplosionResistance(final World p0, final CompatibleBlockState p1, final CompatibleBlockPos p2, final Entity p3, final Explosion p4);
    
    float getExplosionResistance(final World p0, final Entity p1, final Explosion p2, final CompatibleBlockPos p3, final CompatibleBlockState p4);
    
    boolean isSpectator(final EntityPlayer p0);
    
    boolean isCreative(final EntityPlayer p0);
    
    void setBlockToFire(final World p0, final CompatibleBlockPos p1);
    
    DamageSource getDamageSource(final Explosion p0);
    
    double getBlastDamageReduction(final EntityLivingBase p0, final double p1);
    
    boolean verifyExplosion(final World p0, final Entity p1, final Explosion p2, final CompatibleBlockPos p3, final CompatibleBlockState p4, final float p5);
    
    boolean isFullBlock(final CompatibleBlockState p0);
    
    void dropBlockAsItemWithChance(final World p0, final CompatibleBlockState p1, final CompatibleBlockPos p2, final float p3, final int p4);
    
    CompatibleBlockState getBlockBelow(final World p0, final CompatibleBlockPos p1);
    
    void playSound(final World p0, final double p1, final double p2, final double p3, final CompatibleSound p4, final float p5, final float p6);
    
    boolean isBlockPenetratableByGrenades(final Block p0);
    
    DamageSource genericDamageSource();
    
    boolean isCollided(final CompatibleParticle p0);
    
    ItemStack createItemStack(final CompatibleItems p0, final int p1, final int p2);
    
    void addSmelting(final Block p0, final ItemStack p1, final float p2);
    
    void addSmelting(final Item p0, final ItemStack p1, final float p2);
    
    boolean isFlying(final EntityPlayer p0);
    
    String getLocalizedString(final String p0, final Object... p1);
}
