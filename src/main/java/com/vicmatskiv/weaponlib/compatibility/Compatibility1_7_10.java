package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.world.*;
import net.minecraft.client.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.nbt.*;
import net.minecraftforge.event.entity.item.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import cpw.mods.fml.client.*;
import net.minecraft.client.settings.*;
import cpw.mods.fml.client.registry.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.client.event.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.*;
import java.util.function.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraftforge.oredict.*;
import net.minecraft.item.crafting.*;
import cpw.mods.fml.common.*;
import net.minecraft.item.*;
import net.minecraftforge.common.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.client.particle.*;
import java.util.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;

public class Compatibility1_7_10 implements Compatibility
{
    private static final float DEFAULT_SHELL_CASING_FORWARD_OFFSET = 0.0f;
    private static CompatibleMathHelper mathHelper;
    
    public Compatibility1_7_10() {
        super();
    }
    
    @Override
    public World world(final Entity entity) {
        return entity.worldObj;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EntityPlayer clientPlayer() {
        return (EntityPlayer)Minecraft.getMinecraft().thePlayer;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void setClientPlayer(final EntityPlayer player) {
        Minecraft.getMinecraft().thePlayer = (EntityClientPlayerMP)player;
    }
    
    @Override
    public void spawnEntity(final EntityPlayer player, final Entity entity) {
        player.worldObj.spawnEntityInWorld(entity);
    }
    
    @Override
    public void moveParticle(final CompatibleParticle particle, final double motionX, final double motionY, final double motionZ) {
        particle.moveEntity(motionX, motionY, motionZ);
    }
    
    @Override
    public int getStackSize(final ItemStack consumedStack) {
        return consumedStack.stackSize;
    }
    
    @Override
    public NBTTagCompound getTagCompound(final ItemStack itemStack) {
        return itemStack.stackTagCompound;
    }
    
    @Override
    public ItemStack getItemStack(final ItemTossEvent event) {
        return event.entityItem.getEntityItem();
    }
    
    @Override
    public EntityPlayer getPlayer(final ItemTossEvent event) {
        return event.player;
    }
    
    @Override
    public ItemStack getHeldItemMainHand(final EntityLivingBase player) {
        return player.getHeldItem();
    }
    
    @Override
    public boolean consumeInventoryItem(final EntityPlayer player, final Item item) {
        return player.inventory.consumeInventoryItem(item);
    }
    
    @Override
    public void ensureTagCompound(final ItemStack itemStack) {
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
        }
    }
    
    @Override
    public void playSound(final EntityPlayer player, final CompatibleSound sound, final float volume, final float pitch) {
        if (sound != null) {
            player.playSound(sound.getSound(), volume, pitch);
        }
    }
    
    @Override
    public IAttribute getMovementSpeedAttribute() {
        return SharedMonsterAttributes.movementSpeed;
    }
    
    @Override
    public void setTagCompound(final ItemStack itemStack, final NBTTagCompound tagCompound) {
        itemStack.stackTagCompound = tagCompound;
    }
    
    @Override
    public boolean isClientSide() {
        return FMLCommonHandler.instance().getSide() == Side.CLIENT;
    }
    
    @Override
    public CompatibleMathHelper getMathHelper() {
        return Compatibility1_7_10.mathHelper;
    }
    
    @Override
    public void playSoundToNearExcept(final EntityPlayer player, final CompatibleSound sound, final float volume, final float pitch) {
        player.worldObj.playSoundToNearExcept(player, sound.getSound(), volume, pitch);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EntityPlayer getClientPlayer() {
        return (EntityPlayer)FMLClientHandler.instance().getClientPlayerEntity();
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public FontRenderer getFontRenderer() {
        return Minecraft.getMinecraft().fontRenderer;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public ScaledResolution getResolution(final RenderGameOverlayEvent.Pre event) {
        return event.resolution;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public RenderGameOverlayEvent.ElementType getEventType(final RenderGameOverlayEvent.Pre event) {
        return event.type;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getHelmet() {
        return Minecraft.getMinecraft().thePlayer.getEquipmentInSlot(4);
    }
    
    @Override
    public CompatibleVec3 getLookVec(final EntityPlayer player) {
        return new CompatibleVec3(player.getLookVec());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerKeyBinding(final KeyBinding key) {
        ClientRegistry.registerKeyBinding(key);
    }
    
    @Override
    public void registerWithFmlEventBus(final Object object) {
        FMLCommonHandler.instance().bus().register(object);
    }
    
    @Override
    public void registerWithEventBus(final Object object) {
        MinecraftForge.EVENT_BUS.register(object);
    }
    
    @Override
    public void registerSound(final CompatibleSound sound) {
    }
    
    @Override
    public void registerItem(final Item item, final String name) {
        GameRegistry.registerItem(item, name);
    }
    
    @Override
    public void registerItem(final String modId, final Item item, final String name) {
        GameRegistry.registerItem(item, name);
    }
    
    @Override
    public void runInMainClientThread(final Runnable runnable) {
        runnable.run();
    }
    
    @Override
    public void registerModEntity(final Class<? extends Entity> entityClass, final String entityName, final int id, final Object mod, final String modId, final int trackingRange, final int updateFrequency, final boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity((Class)entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
    }
    
    @Override
    public void registerRenderingRegistry(final CompatibleRenderingRegistry rendererRegistry) {
    }
    
    @Override
    public <T, E> T getPrivateValue(final Class<? super E> classToAccess, final E instance, final String... fieldNames) {
        return (T)ObfuscationReflectionHelper.getPrivateValue((Class)classToAccess, (Object)instance, fieldNames);
    }
    
    @Override
    public int getButton(final MouseEvent event) {
        return event.button;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EntityPlayer getEntity(final FOVUpdateEvent event) {
        return (EntityPlayer)event.entity;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EntityLivingBase getEntity(final RenderLivingEvent.Pre event) {
        return event.entity;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void setNewFov(final FOVUpdateEvent event, final float fov) {
        event.newfov = fov;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public RenderPlayer getRenderer(final RenderLivingEvent.Pre event) {
        return (RenderPlayer)event.renderer;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getGui(final GuiOpenEvent event) {
        return event.gui;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void setAimed(final RenderPlayer rp, final boolean aimed) {
        rp.modelBipedMain.aimedBow = aimed;
    }
    
    @Override
    public CompatibleRayTraceResult getObjectMouseOver() {
        return CompatibleRayTraceResult.fromMovingObjectPosition(Minecraft.getMinecraft().objectMouseOver);
    }
    
    @Override
    public boolean consumeInventoryItem(final InventoryPlayer inventoryPlayer, final Item item) {
        return inventoryPlayer.consumeInventoryItem(item);
    }
    
    @Override
    public CompatibleBlockState getBlockAtPosition(final World world, final CompatibleRayTraceResult position) {
        return CompatibleBlockState.fromBlock(world.getBlock(position.getBlockPosX(), position.getBlockPosY(), position.getBlockPosZ()));
    }
    
    @Override
    public void destroyBlock(final World world, final CompatibleRayTraceResult position) {
        world.func_147480_a(position.getBlockPosX(), position.getBlockPosY(), position.getBlockPosZ(), true);
    }
    
    @Override
    public ItemStack itemStackForItem(final Item item, final Predicate<ItemStack> condition, final EntityPlayer player) {
        ItemStack result = null;
        for (int i = 0; i < player.inventory.mainInventory.length; ++i) {
            if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item && condition.test(player.inventory.mainInventory[i])) {
                result = player.inventory.mainInventory[i];
                break;
            }
        }
        return result;
    }
    
    @Override
    public boolean isGlassBlock(final CompatibleBlockState blockState) {
        final Block block = blockState.getBlock();
        return block == Blocks.glass || block == Blocks.glass_pane || block == Blocks.stained_glass || block == Blocks.stained_glass_pane;
    }
    
    @Override
    public float getEffectOffsetX() {
        return 0.0f;
    }
    
    @Override
    public float getEffectOffsetY() {
        return 0.0f;
    }
    
    @Override
    public float getEffectScaleFactor() {
        return 2.3f;
    }
    
    @Override
    public int getCurrentInventoryItemIndex(final EntityPlayer player) {
        return player.inventory.currentItem;
    }
    
    @Override
    public ItemStack getInventoryItemStack(final EntityPlayer player, final int inventoryItemIndex) {
        return player.inventory.getStackInSlot(inventoryItemIndex);
    }
    
    @Override
    public int getInventorySlot(final EntityPlayer player, final ItemStack itemStack) {
        int slot = -1;
        for (int i = 0; i < player.inventory.mainInventory.length; ++i) {
            if (player.inventory.mainInventory[i] == itemStack) {
                slot = i;
                break;
            }
        }
        return slot;
    }
    
    @Override
    public boolean addItemToPlayerInventory(final EntityPlayer player, final Item item, final int slot) {
        final boolean result = false;
        if (slot == -1) {
            player.inventory.addItemStackToInventory(new ItemStack(item));
        }
        else if (player.inventory.mainInventory[slot] == null) {
            player.inventory.mainInventory[slot] = new ItemStack(item);
        }
        return result;
    }
    
    @Override
    public boolean consumeInventoryItemFromSlot(final EntityPlayer player, final int slot) {
        if (player.inventory.mainInventory[slot] == null) {
            return false;
        }
        final ItemStack itemStack = player.inventory.mainInventory[slot];
        if (--itemStack.stackSize <= 0) {
            player.inventory.mainInventory[slot] = null;
        }
        return true;
    }
    
    @Override
    public void addShapedRecipe(final ItemStack itemStack, final Object... materials) {
        GameRegistry.addShapedRecipe(itemStack, materials);
    }
    
    @Override
    public void addShapedOreRecipe(final ItemStack itemStack, final Object... materials) {
        GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(itemStack, materials).setMirrored(false));
    }
    
    @Override
    public void disableLightMap() {
        Minecraft.getMinecraft().entityRenderer.disableLightmap(0.0);
    }
    
    @Override
    public void enableLightMap() {
        Minecraft.getMinecraft().entityRenderer.enableLightmap(0.0);
    }
    
    @Override
    public void registerBlock(final String modId, final Block block, final String name) {
        GameRegistry.registerBlock(block, name);
    }
    
    @Override
    public void registerWorldGenerator(final IWorldGenerator generator, final int modGenerationWeight) {
        GameRegistry.registerWorldGenerator(generator, modGenerationWeight);
    }
    
    @Override
    public ItemArmor.ArmorMaterial addArmorMaterial(final String name, final String textureName, final int durability, final int[] reductionAmounts, final int enchantability, final CompatibleSound soundOnEquip, final float toughness) {
        return EnumHelper.addArmorMaterial(name, durability, reductionAmounts, enchantability);
    }
    
    @Override
    public boolean inventoryHasFreeSlots(final EntityPlayer player) {
        boolean result = false;
        for (int i = 0; i < player.inventory.mainInventory.length; ++i) {
            if (player.inventory.mainInventory[i] == null) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    @Override
    public void addBlockHitEffect(final int x, final int y, final int z, final CompatibleEnumFacing enumFacing) {
        for (int i = 0; i < 6; ++i) {
            Minecraft.getMinecraft().effectRenderer.addBlockHitEffects(x, y, z, enumFacing.ordinal());
        }
    }
    
    @Override
    public String getDisplayName(final EntityPlayer entity) {
        return entity.getDisplayName();
    }
    
    @Override
    public String getPlayerName(final EntityPlayer player) {
        return player.getCommandSenderName();
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public RenderGlobal createCompatibleRenderGlobal() {
        return Minecraft.getMinecraft().renderGlobal;
    }
    
    @Override
    public CompatibleParticleManager createCompatibleParticleManager(final WorldClient world) {
        return new CompatibleParticleManager(world);
    }
    
    @Override
    public void setRenderViewEntity(final Entity entity) {
        if (entity instanceof EntityLivingBase) {
            Minecraft.getMinecraft().renderViewEntity = (EntityLivingBase)entity;
        }
    }
    
    @Override
    public Entity getRenderViewEntity() {
        return (Entity)Minecraft.getMinecraft().renderViewEntity;
    }
    
    @Override
    public CompatibleParticleManager getCompatibleParticleManager() {
        return new CompatibleParticleManager(Minecraft.getMinecraft().effectRenderer);
    }
    
    @Override
    public void addChatMessage(final Entity clientPlayer, final String message) {
        if (clientPlayer instanceof EntityPlayer) {
            ((EntityPlayerSP)clientPlayer).addChatMessage((IChatComponent)new ChatComponentText(message));
        }
    }
    
    @Override
    public boolean isAirBlock(final World world, final CompatibleBlockPos blockPos) {
        final Block blockHit = world.getBlock(blockPos.getBlockPosX(), blockPos.getBlockPosY(), blockPos.getBlockPosZ());
        return blockHit.getMaterial() == Material.air;
    }
    
    @Override
    public void clickBlock(final CompatibleBlockPos blockPos, final CompatibleEnumFacing sideHit) {
        Minecraft.getMinecraft().playerController.clickBlock(blockPos.getBlockPosX(), blockPos.getBlockPosY(), blockPos.getBlockPosZ(), sideHit.ordinal());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addBreakingParticle(final ModContext modContext, final double x, final double y, final double z) {
        final double yOffset = 1.0;
        final CompatibleParticle.CompatibleParticleBreaking particle = CompatibleParticle.createParticleBreaking(modContext, this.world((Entity)this.clientPlayer()), x, y + yOffset, z);
        Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)particle);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public float getAspectRatio(final ModContext modContext) {
        return modContext.getAspectRatio();
    }
    
    private static int itemSlotIndex(final Item item, final Predicate<ItemStack> condition, final EntityPlayer player) {
        for (int i = 0; i < player.inventory.mainInventory.length; ++i) {
            if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item && condition.test(player.inventory.mainInventory[i])) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public ItemStack consumeInventoryItem(final Item item, final Predicate<ItemStack> condition, final EntityPlayer player, final int maxSize) {
        if (maxSize <= 0) {
            return null;
        }
        final int i = itemSlotIndex(item, condition, player);
        if (i < 0) {
            return null;
        }
        final ItemStack stackInSlot = player.inventory.mainInventory[i];
        final int consumedStackSize = (maxSize >= stackInSlot.stackSize) ? stackInSlot.stackSize : maxSize;
        final ItemStack result = stackInSlot.splitStack(consumedStackSize);
        if (stackInSlot.stackSize <= 0) {
            player.inventory.mainInventory[i] = null;
        }
        return result;
    }
    
    @Override
    public ItemStack tryConsumingCompatibleItem(final List<? extends Item> compatibleParts, final int maxSize, final EntityPlayer player, final Predicate<ItemStack>... conditions) {
        ItemStack resultStack = null;
        for (final Predicate<ItemStack> condition : conditions) {
            for (final Item item : compatibleParts) {
                if ((resultStack = this.consumeInventoryItem(item, condition, player, maxSize)) != null) {
                    break;
                }
            }
            if (resultStack != null) {
                break;
            }
        }
        return resultStack;
    }
    
    @Override
    public void setStackSize(final ItemStack itemStack, final int size) {
        itemStack.stackSize = size;
    }
    
    @Override
    public Item findItemByName(final String modId, final String itemName) {
        return GameRegistry.findItem(modId, itemName);
    }
    
    @Override
    public CompatibleRayTraceResult rayTraceBlocks(final Entity entity, final CompatibleVec3 vec3, final CompatibleVec3 vec31) {
        return CompatibleRayTraceResult.fromMovingObjectPosition(entity.worldObj.rayTraceBlocks(vec3.getVec(), vec31.getVec()));
    }
    
    @Override
    public CompatibleAxisAlignedBB expandEntityBoundingBox(final Entity entity1, final double f1, final double f2, final double f3) {
        return new CompatibleAxisAlignedBB(entity1.boundingBox.expand(f1, f2, f3));
    }
    
    @Override
    public CompatibleAxisAlignedBB getBoundingBox(final Entity entity) {
        return new CompatibleAxisAlignedBB(entity.boundingBox);
    }
    
    @Override
    public List<Entity> getEntitiesWithinAABBExcludingEntity(final World world, final Entity entity, final CompatibleAxisAlignedBB boundingBox) {
        return world.getEntitiesWithinAABBExcludingEntity(entity, boundingBox.getBoundingBox());
    }
    
    @Override
    public void spawnParticle(final World world, final String particleName, final double xCoord, final double yCoord, final double zCoord, final double xSpeed, final double ySpeed, final double zSpeed) {
        world.spawnParticle(particleName, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
    }
    
    @Override
    public CompatibleBlockState getBlockAtPosition(final World world, final CompatibleBlockPos blockPos) {
        return CompatibleBlockState.fromBlock(world.getBlock(blockPos.getBlockPosX(), blockPos.getBlockPosY(), blockPos.getBlockPosZ()));
    }
    
    @Override
    public boolean isBlockPenetratableByBullets(final Block block) {
        return block == Blocks.air || block == Blocks.tallgrass || block == Blocks.leaves || block == Blocks.leaves2 || block == Blocks.fire || block == Blocks.hay_block || block == Blocks.double_plant || block == Blocks.web || block == Blocks.wheat;
    }
    
    @Override
    public boolean canCollideCheck(final Block block, final CompatibleBlockState metadata, final boolean hitIfLiquid) {
        return block.canCollideCheck(metadata.getBlockMetadata(), hitIfLiquid);
    }
    
    @Override
    public float getCompatibleShellCasingForwardOffset() {
        return 0.0f;
    }
    
    @Override
    public boolean madeFromHardMaterial(final CompatibleBlockState blockState) {
        final Block block = blockState.getBlock();
        final Material material = block.getMaterial();
        return material == Material.rock || material == Material.iron || material == Material.ice || material == Material.wood;
    }
    
    @Override
    public void playSoundAtEntity(final Entity entity, final CompatibleSound explosionSound, final float volume, final float pitch) {
        entity.worldObj.playSoundAtEntity(entity, explosionSound.getSound(), volume, pitch);
    }
    
    @Override
    public double getBlockDensity(final World world, final CompatibleVec3 vec3, final CompatibleAxisAlignedBB boundingBox) {
        return world.getBlockDensity(vec3.getVec(), boundingBox.getBoundingBox());
    }
    
    @Override
    public boolean isImmuneToExplosions(final Entity entity) {
        return false;
    }
    
    @Override
    public boolean isAirBlock(final CompatibleBlockState blockState) {
        return blockState.getBlock().getMaterial() == Material.air;
    }
    
    private net.minecraft.world.Explosion getCompatibleExplosion(final Explosion e) {
        final net.minecraft.world.Explosion ce = new net.minecraft.world.Explosion(e.getWorld(), e.getExploder(), e.getExplosionX(), e.getExplosionX(), e.getExplosionZ(), e.getExplosionSize());
        return ce;
    }
    
    @Override
    public boolean canDropBlockFromExplosion(final CompatibleBlockState blockState, final Explosion explosion) {
        return blockState.getBlock().canDropFromExplosion(this.getCompatibleExplosion(explosion));
    }
    
    @Override
    public void onBlockExploded(final World world, final CompatibleBlockState blockState, final CompatibleBlockPos blockpos, final Explosion explosion) {
        blockState.getBlock().onBlockExploded(world, blockpos.getBlockPosX(), blockpos.getBlockPosY(), blockpos.getBlockPosZ(), this.getCompatibleExplosion(explosion));
    }
    
    @Override
    public float getExplosionResistance(final World world, final CompatibleBlockState blockState, final CompatibleBlockPos blockpos, final Entity entity, final Explosion explosion) {
        return blockState.getBlock().getExplosionResistance(entity);
    }
    
    @Override
    public float getExplosionResistance(final World world, final Entity exploder, final Explosion explosion, final CompatibleBlockPos blockpos, final CompatibleBlockState blockState) {
        return exploder.func_145772_a(this.getCompatibleExplosion(explosion), world, blockpos.getBlockPosX(), blockpos.getBlockPosY(), blockpos.getBlockPosZ(), blockState.getBlock());
    }
    
    @Override
    public boolean isSpectator(final EntityPlayer entityplayer) {
        return false;
    }
    
    @Override
    public boolean isCreative(final EntityPlayer entityplayer) {
        return entityplayer.capabilities.isCreativeMode;
    }
    
    @Override
    public boolean isFlying(final EntityPlayer entityplayer) {
        return entityplayer.capabilities.isFlying;
    }
    
    @Override
    public void setBlockToFire(final World world, final CompatibleBlockPos blockpos1) {
        world.setBlock(blockpos1.getBlockPosX(), blockpos1.getBlockPosY(), blockpos1.getBlockPosZ(), (Block)Blocks.fire);
    }
    
    @Override
    public DamageSource getDamageSource(final Explosion explosion) {
        return DamageSource.setExplosionSource(this.getCompatibleExplosion(explosion));
    }
    
    @Override
    public double getBlastDamageReduction(final EntityLivingBase entity, final double d10) {
        return EnchantmentProtection.func_92092_a((Entity)entity, d10);
    }
    
    @Override
    public boolean verifyExplosion(final World world, final Entity exploder, final Explosion explosion, final CompatibleBlockPos blockpos, final CompatibleBlockState blockState, final float f) {
        return exploder.func_145774_a(this.getCompatibleExplosion(explosion), world, blockpos.getBlockPosX(), blockpos.getBlockPosY(), blockpos.getBlockPosZ(), blockState.getBlock(), f);
    }
    
    @Override
    public CompatibleBlockState getBlockBelow(final World world, final CompatibleBlockPos blockpos1) {
        return CompatibleBlockState.fromBlock(world.getBlock(blockpos1.getBlockPosX(), blockpos1.getBlockPosY() - 1, blockpos1.getBlockPosZ()));
    }
    
    @Override
    public boolean isFullBlock(final CompatibleBlockState blockState) {
        return blockState.getBlock().func_149730_j();
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World world, final CompatibleBlockState blockState, final CompatibleBlockPos blockpos, final float f, final int i) {
        final int blockMetadata = world.getBlockMetadata(blockpos.getBlockPosX(), blockpos.getBlockPosY(), blockpos.getBlockPosZ());
        blockState.getBlock().dropBlockAsItemWithChance(world, blockpos.getBlockPosX(), blockpos.getBlockPosY(), blockpos.getBlockPosZ(), blockMetadata, f, i);
    }
    
    @Override
    public void playSound(final World world, final double posX, final double posY, final double posZ, final CompatibleSound sound, final float volume, final float pitch) {
        if (sound != null) {
            world.playSoundEffect(posX, posY, posZ, sound.getSound(), volume, pitch);
        }
    }
    
    @Override
    public boolean isBlockPenetratableByGrenades(final Block block) {
        return block == Blocks.air || block == Blocks.tallgrass || block == Blocks.leaves || block == Blocks.leaves2 || block == Blocks.fire || block == Blocks.hay_block || block == Blocks.double_plant || block == Blocks.web || block == Blocks.wheat;
    }
    
    @Override
    public DamageSource genericDamageSource() {
        return DamageSource.generic;
    }
    
    @Override
    public boolean isCollided(final CompatibleParticle particle) {
        return particle.isCollided;
    }
    
    @Override
    public ItemStack createItemStack(final CompatibleItems compatibleItem, final int stackSize, final int damage) {
        return new ItemStack(compatibleItem.getItem(), stackSize, damage);
    }
    
    @Override
    public void addSmelting(final Block block, final ItemStack output, final float f) {
        GameRegistry.addSmelting(block, output, f);
    }
    
    @Override
    public void addSmelting(final Item item, final ItemStack output, final float f) {
        GameRegistry.addSmelting(item, output, f);
    }
    
    @Override
    public String getLocalizedString(final String format, final Object... args) {
        return StatCollector.translateToLocalFormatted(format, args);
    }
    
    static {
        Compatibility1_7_10.mathHelper = new CompatibleMathHelper();
    }
}
