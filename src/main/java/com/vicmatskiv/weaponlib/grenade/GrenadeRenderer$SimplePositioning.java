package com.vicmatskiv.weaponlib.grenade;

import java.util.function.*;
import com.vicmatskiv.weaponlib.*;

private static class SimplePositioning
{
    Part attachedTo;
    Consumer<RenderContext<RenderableState>> positioning;
    
    SimplePositioning(final Part attachedTo, final Consumer<RenderContext<RenderableState>> positioning) {
        super();
        this.attachedTo = attachedTo;
        this.positioning = positioning;
    }
}
