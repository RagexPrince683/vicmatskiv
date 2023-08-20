package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.client.model.*;
import java.util.function.*;

public class CustomArmor extends CompatibleCustomArmor
{
    private static final String ACTIVE_ATTACHMENT_TAG = "ActiveAttachments";
    private Map<ItemAttachment<CustomArmor>, CompatibleAttachment<CustomArmor>> compatibleAttachments;
    
    private CustomArmor(final String modId, final ItemArmor.ArmorMaterial material, final int renderIndex, final CompatibleEntityEquipmentSlot armorType, final String iconName, final String textureName, final ModelBiped model, final String hudTextureName) {
        super(modId, material, renderIndex, armorType, iconName.toLowerCase(), textureName, model, hudTextureName);
        this.compatibleAttachments = new HashMap<ItemAttachment<CustomArmor>, CompatibleAttachment<CustomArmor>>();
    }
    
    public String getHudTexture() {
        return this.modId + ":" + "textures/hud/" + this.hudTextureName + ".png";
    }
    
    public void changeAttachment(final AttachmentCategory attachmentCategory, final ItemStack itemStack, final EntityPlayer player) {
        CompatibilityProvider.compatibility.ensureTagCompound(itemStack);
        final int[] activeAttachmentsIds = this.ensureActiveAttachments(itemStack);
        final int activeAttachmentIdForThisCategory = activeAttachmentsIds[attachmentCategory.ordinal()];
        ItemAttachment<CustomArmor> item = null;
        if (activeAttachmentIdForThisCategory > 0) {
            item = (ItemAttachment)Item.getItemById(activeAttachmentIdForThisCategory);
            if (item != null && item.getRemove() != null) {
                item.getRemove().apply(item, this, player);
            }
        }
        final ItemAttachment<CustomArmor> nextAttachment = this.nextCompatibleAttachment(attachmentCategory, item, player);
        if (nextAttachment != null && nextAttachment.getApply() != null) {
            nextAttachment.getApply().apply(nextAttachment, this, player);
        }
        activeAttachmentsIds[attachmentCategory.ordinal()] = Item.getIdFromItem((Item)nextAttachment);
        CompatibilityProvider.compatibility.getTagCompound(itemStack).setIntArray("ActiveAttachments", activeAttachmentsIds);
    }
    
    private ItemAttachment<CustomArmor> nextCompatibleAttachment(final AttachmentCategory category, final Item currentAttachment, final EntityPlayer player) {
        ItemAttachment<CustomArmor> nextAttachment = null;
        boolean foundCurrent = false;
        for (int i = 0; i < 36; ++i) {
            final ItemStack itemStack = player.inventory.getStackInSlot(i);
            if (itemStack != null && itemStack.getItem() instanceof ItemAttachment) {
                final ItemAttachment<CustomArmor> compatibleAttachment = (ItemAttachment<CustomArmor>)itemStack.getItem();
                if (compatibleAttachment.getCategory() == category) {
                    if (foundCurrent || currentAttachment == null) {
                        nextAttachment = compatibleAttachment;
                        break;
                    }
                    if (currentAttachment == compatibleAttachment) {
                        foundCurrent = true;
                    }
                }
            }
        }
        return nextAttachment;
    }
    
    public ItemAttachment<CustomArmor> getActiveAttachment(final ItemStack itemStack, final AttachmentCategory category) {
        CompatibilityProvider.compatibility.ensureTagCompound(itemStack);
        ItemAttachment<CustomArmor> itemAttachment = null;
        final int[] ensureActiveAttachments;
        final int[] activeAttachmentsIds = ensureActiveAttachments = this.ensureActiveAttachments(itemStack);
        for (final int activeIndex : ensureActiveAttachments) {
            if (activeIndex != 0) {
                final Item item = Item.getItemById(activeIndex);
                if (item instanceof ItemAttachment) {
                    final CompatibleAttachment<CustomArmor> compatibleAttachment = this.compatibleAttachments.get(item);
                    if (compatibleAttachment != null && category == compatibleAttachment.getAttachment().getCategory()) {
                        itemAttachment = compatibleAttachment.getAttachment();
                        break;
                    }
                }
            }
        }
        return itemAttachment;
    }
    
    public List<CompatibleAttachment<CustomArmor>> getActiveAttachments(final ItemStack itemStack) {
        CompatibilityProvider.compatibility.ensureTagCompound(itemStack);
        final List<CompatibleAttachment<CustomArmor>> activeAttachments = new ArrayList<CompatibleAttachment<CustomArmor>>();
        final int[] ensureActiveAttachments;
        final int[] activeAttachmentsIds = ensureActiveAttachments = this.ensureActiveAttachments(itemStack);
        for (final int activeIndex : ensureActiveAttachments) {
            if (activeIndex != 0) {
                final Item item = Item.getItemById(activeIndex);
                if (item instanceof ItemAttachment) {
                    final CompatibleAttachment<CustomArmor> compatibleAttachment = this.compatibleAttachments.get(item);
                    if (compatibleAttachment != null) {
                        activeAttachments.add(compatibleAttachment);
                    }
                }
            }
        }
        return activeAttachments;
    }
    
    private int[] ensureActiveAttachments(final ItemStack itemStack) {
        int[] activeAttachmentsIds = CompatibilityProvider.compatibility.getTagCompound(itemStack).getIntArray("ActiveAttachments");
        if (activeAttachmentsIds == null || activeAttachmentsIds.length != AttachmentCategory.values.length) {
            activeAttachmentsIds = new int[AttachmentCategory.values.length];
            CompatibilityProvider.compatibility.getTagCompound(itemStack).setIntArray("ActiveAttachments", activeAttachmentsIds);
            for (final CompatibleAttachment<CustomArmor> attachment : this.compatibleAttachments.values()) {
                if (attachment.isDefault()) {
                    activeAttachmentsIds[attachment.getAttachment().getCategory().ordinal()] = Item.getIdFromItem((Item)attachment.getAttachment());
                }
            }
        }
        return activeAttachmentsIds;
    }
    
    public static boolean isActiveAttachment(final ItemStack itemStack, final ItemAttachment<CustomArmor> attachment) {
        final CustomArmor armor = (CustomArmor)itemStack.getItem();
        final int[] activeAttachmentsIds = armor.ensureActiveAttachments(itemStack);
        return Arrays.stream(activeAttachmentsIds).anyMatch(attachmentId -> itemAttachment == Item.getItemById(attachmentId));
    }
    
    private static /* synthetic */ boolean lambda$isActiveAttachment$264(final ItemAttachment itemAttachment, final int attachmentId) {
        return itemAttachment == Item.getItemById(attachmentId);
    }
    
    CustomArmor(final String x0, final ItemArmor.ArmorMaterial x1, final int x2, final CompatibleEntityEquipmentSlot x3, final String x4, final String x5, final ModelBiped x6, final String x7, final CustomArmor$1 x8) {
        this(x0, x1, x2, x3, x4, x5, x6, x7);
    }
    
    public static class Builder
    {
        private String modId;
        private String textureName;
        private String iconName;
        private ItemArmor.ArmorMaterial material;
        private String unlocalizedName;
        private ModelBiped bootsModel;
        private ModelBiped chestModel;
        private String modelClass;
        private String hudTextureName;
        private Map<ItemAttachment<CustomArmor>, CompatibleAttachment<CustomArmor>> compatibleAttachments;
        private CreativeTabs creativeTab;
        
        public Builder() {
            super();
            this.compatibleAttachments = new HashMap<ItemAttachment<CustomArmor>, CompatibleAttachment<CustomArmor>>();
        }
        
        public Builder withModId(final String modId) {
            this.modId = modId;
            return this;
        }
        
        public Builder withCreativeTab(final CreativeTabs creativeTab) {
            this.creativeTab = creativeTab;
            return this;
        }
        
        public Builder withTextureName(final String textureName) {
            this.textureName = textureName.toLowerCase();
            return this;
        }
        
        public Builder withMaterial(final ItemArmor.ArmorMaterial material) {
            this.material = material;
            return this;
        }
        
        public Builder withUnlocalizedName(final String unlocalizedName) {
            this.unlocalizedName = unlocalizedName;
            return this;
        }
        
        public Builder withModelClass(final String modelClass) {
            this.modelClass = modelClass;
            return this;
        }
        
        public Builder withHudTextureName(final String hudTextureName) {
            this.hudTextureName = hudTextureName.toLowerCase();
            return this;
        }
        
        public Builder withCompatibleAttachment(final AttachmentCategory category, final ModelBase attachmentModel, final String textureName, final Consumer<ModelBase> positioner) {
            final ItemAttachment<CustomArmor> item = new ItemAttachment<CustomArmor>(this.modId, category, attachmentModel, textureName, null);
            this.compatibleAttachments.put(item, new CompatibleAttachment<CustomArmor>(item, positioner));
            return this;
        }
        
        public void build(final boolean isClient) {
            if (isClient) {
                try {
                    this.chestModel = (ModelBiped)Class.forName(this.modelClass).newInstance();
                }
                catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    throw new IllegalStateException("Missing chest model", e);
                }
                try {
                    this.bootsModel = (ModelBiped)Class.forName(this.modelClass).newInstance();
                }
                catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    throw new IllegalStateException("Missing boots model", e);
                }
            }
            if (this.modId == null) {
                throw new IllegalStateException("ModId is not set");
            }
            final String unlocalizedHelmetName = this.unlocalizedName + "_helmet";
            final CustomArmor armorHelmet = new CustomArmor(this.modId, this.material, 4, CompatibleEntityEquipmentSlot.HEAD, unlocalizedHelmetName, this.textureName, this.chestModel, this.hudTextureName, null);
            if (this.creativeTab != null) {
                armorHelmet.setCreativeTab(this.creativeTab);
            }
            armorHelmet.setUnlocalizedName(unlocalizedHelmetName);
            CompatibilityProvider.compatibility.registerItem((Item)armorHelmet, unlocalizedHelmetName.toLowerCase());
            final String unlocalizedChestName = this.unlocalizedName + "_chest";
            final CustomArmor armorChest = new CustomArmor(this.modId, this.material, 4, CompatibleEntityEquipmentSlot.CHEST, unlocalizedChestName, this.textureName, this.chestModel, this.hudTextureName, null);
            if (this.creativeTab != null) {
                armorChest.setCreativeTab(this.creativeTab);
            }
            armorChest.setUnlocalizedName(unlocalizedChestName);
            CompatibilityProvider.compatibility.registerItem((Item)armorChest, unlocalizedChestName.toLowerCase());
            final String unlocalizedBootsName = this.unlocalizedName + "_boots";
            final CustomArmor armorBoots = new CustomArmor(this.modId, this.material, 4, CompatibleEntityEquipmentSlot.FEET, unlocalizedBootsName, this.textureName, this.bootsModel, this.hudTextureName, null);
            if (armorBoots != null) {
                armorBoots.setCreativeTab(this.creativeTab);
            }
            armorBoots.setUnlocalizedName(unlocalizedBootsName);
            CompatibilityProvider.compatibility.registerItem((Item)armorBoots, unlocalizedBootsName.toLowerCase());
        }
        
        public CustomArmor buildHelmet(final boolean isClient) {
            if (isClient) {
                if (this.chestModel == null) {
                    try {
                        this.chestModel = (ModelBiped)Class.forName(this.modelClass).newInstance();
                    }
                    catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                        throw new IllegalStateException("Missing chest model", e);
                    }
                }
                if (this.bootsModel == null) {
                    try {
                        this.bootsModel = (ModelBiped)Class.forName(this.modelClass).newInstance();
                    }
                    catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                        throw new IllegalStateException("Missing boots model", e);
                    }
                }
            }
            if (this.modId == null) {
                throw new IllegalStateException("ModId is not set");
            }
            final String unlocalizedHelmetName = this.unlocalizedName + "_helmet";
            final CustomArmor armorHelmet = new CustomArmor(this.modId, this.material, 4, CompatibleEntityEquipmentSlot.HEAD, unlocalizedHelmetName, this.textureName, this.chestModel, this.hudTextureName, null);
            armorHelmet.setUnlocalizedName(unlocalizedHelmetName);
            CompatibilityProvider.compatibility.registerItem((Item)armorHelmet, unlocalizedHelmetName.toLowerCase());
            if (this.creativeTab != null) {
                armorHelmet.setCreativeTab(this.creativeTab);
            }
            return armorHelmet;
        }
        
        public CustomArmor buildChest(final boolean isClient) {
            if (isClient && this.chestModel == null) {
                try {
                    this.chestModel = (ModelBiped)Class.forName(this.modelClass).newInstance();
                }
                catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    throw new IllegalStateException("Missing chest model", e);
                }
            }
            if (this.modId == null) {
                throw new IllegalStateException("ModId is not set");
            }
            final String unlocalizedChestName = this.unlocalizedName + "_chest";
            final CustomArmor armorChest = new CustomArmor(this.modId, this.material, 4, CompatibleEntityEquipmentSlot.CHEST, unlocalizedChestName, this.textureName, this.chestModel, this.hudTextureName, null);
            if (this.creativeTab != null) {
                armorChest.setCreativeTab(this.creativeTab);
            }
            armorChest.setUnlocalizedName(unlocalizedChestName);
            CompatibilityProvider.compatibility.registerItem((Item)armorChest, unlocalizedChestName.toLowerCase());
            return armorChest;
        }
        
        public CustomArmor buildBoots(final boolean isClient) {
            if (isClient && this.bootsModel == null) {
                try {
                    this.bootsModel = (ModelBiped)Class.forName(this.modelClass).newInstance();
                }
                catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    throw new IllegalStateException("Missing boots model", e);
                }
            }
            if (this.modId == null) {
                throw new IllegalStateException("ModId is not set");
            }
            final String unlocalizedBootsName = this.unlocalizedName + "_boots";
            final CustomArmor armorBoots = new CustomArmor(this.modId, this.material, 4, CompatibleEntityEquipmentSlot.FEET, unlocalizedBootsName, this.textureName, this.bootsModel, this.hudTextureName, null);
            if (this.creativeTab != null) {
                armorBoots.setCreativeTab(this.creativeTab);
            }
            armorBoots.setUnlocalizedName(unlocalizedBootsName);
            CompatibilityProvider.compatibility.registerItem((Item)armorBoots, unlocalizedBootsName.toLowerCase());
            return armorBoots;
        }
    }
}
