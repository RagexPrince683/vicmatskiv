package com.vicmatskiv.weaponlib;

import java.util.*;
import net.minecraft.client.model.*;

public interface ModelSource
{
    List<Tuple<ModelBase, String>> getTexturedModels();
    
    CustomRenderer<?> getPostRenderer();
}
