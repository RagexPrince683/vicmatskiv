package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.model.*;

public class CompatibleModelBiped extends ModelBiped
{
    protected ModelBiped delegate;
    
    protected CompatibleModelBiped(final ModelBiped delegate) {
        super();
        this.delegate = delegate;
    }
    
    public void renderEars(final float p_78110_1_) {
        super.renderEars(p_78110_1_);
    }
    
    public void renderCloak(final float p_78111_1_) {
        super.renderCloak(p_78111_1_);
    }
}
