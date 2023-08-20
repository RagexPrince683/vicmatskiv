package com.vicmatskiv.weaponlib;

import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.client.model.*;
import java.util.function.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.item.*;

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
