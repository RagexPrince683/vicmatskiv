package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.model.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;

public class CompatibleCustomArmor extends ItemArmor
{
    protected ModelBiped model;
    protected String iconName;
    protected String textureName;
    protected String hudTextureName;
    protected String modId;
    
    public CompatibleCustomArmor(final String modId, final ItemArmor.ArmorMaterial material, final int renderIndex, final CompatibleEntityEquipmentSlot compatibleEntityEquipmentSlot, final String iconName, final String textureName, final ModelBiped model, final String hudTextureName) {
        super(material, renderIndex, compatibleEntityEquipmentSlot.getSlot());
        this.modId = modId;
        this.model = model;
        this.iconName = iconName;
        this.textureName = textureName;
        this.hudTextureName = hudTextureName;
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        ModelBiped armorModel = null;
        if (itemStack != null) {
            if (itemStack.getItem() instanceof CustomArmor) {
                armorModel = this.model;
            }
            if (armorModel != null) {
                armorModel.bipedHead.showModel = (armorSlot == 0);
                armorModel.bipedHeadwear.showModel = (armorSlot == 0);
                armorModel.bipedBody.showModel = (armorSlot == 1 || armorSlot == 2);
                armorModel.bipedRightArm.showModel = (armorSlot == 1);
                armorModel.bipedLeftArm.showModel = (armorSlot == 1);
                armorModel.bipedRightLeg.showModel = false;
                armorModel.bipedLeftLeg.showModel = false;
                armorModel.bipedRightLeg.showModel = (armorSlot == 2 || armorSlot == 3);
                armorModel.bipedLeftLeg.showModel = (armorSlot == 2 || armorSlot == 3);
                armorModel.isSneak = entityLiving.isSneaking();
                armorModel.isRiding = entityLiving.isRiding();
                armorModel.isChild = entityLiving.isChild();
                armorModel.heldItemRight = ((entityLiving.getEquipmentInSlot(0) != null) ? 1 : 0);
                if (entityLiving instanceof EntityPlayer) {
                    final RenderPlayer renderPlayer = (RenderPlayer)RenderManager.instance.getEntityRenderObject((Entity)entityLiving);
                    armorModel.aimedBow = (((EntityPlayer)entityLiving).getItemInUseDuration() > 0 || renderPlayer.modelBipedMain.aimedBow);
                }
                return armorModel;
            }
        }
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(this.modId + ":" + this.iconName);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        return this.modId + ":textures/models/" + this.textureName + ".png";
    }
}
