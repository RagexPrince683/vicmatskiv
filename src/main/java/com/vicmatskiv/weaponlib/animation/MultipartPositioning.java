package com.vicmatskiv.weaponlib.animation;

import java.util.*;

public interface MultipartPositioning<Part, Context>
{
     <T> T getFromState(final Class<T> p0);
    
     <T> T getToState(final Class<T> p0);
    
    boolean isExpired(final Queue<MultipartPositioning<Part, Context>> p0);
    
    Positioner<Part, Context> getPositioner();
    
    float getProgress();
    
    public interface Positioner<Part, Context>
    {
        void position(final Part p0, final Context p1);
        
        default void randomize(final float rate, final float amplitude) {
        }
    }
}
