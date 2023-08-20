package com.vicmatskiv.weaponlib.compatibility;

import java.util.function.*;

private static class Container<T, I>
{
    Function<I, T> initializer;
    T resolved;
    
    Container() {
        super();
    }
    
    Container(final Function<I, T> initializer) {
        super();
        this.initializer = initializer;
    }
    
    public T get(final I i) {
        if (this.initializer == null) {
            return null;
        }
        if (this.resolved == null) {
            this.resolved = this.initializer.apply(i);
        }
        return this.resolved;
    }
}
