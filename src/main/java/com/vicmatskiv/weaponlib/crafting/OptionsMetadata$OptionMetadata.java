package com.vicmatskiv.weaponlib.crafting;

static class OptionMetadata
{
    private int minOccurs;
    private int maxOccurs;
    private Object option;
    
    private OptionMetadata(final Object option, final int minOccurs, final int maxOccurs) {
        super();
        this.option = option;
        this.minOccurs = minOccurs;
        this.maxOccurs = maxOccurs;
    }
    
    protected int getMinOccurs() {
        return this.minOccurs;
    }
    
    protected int getMaxOccurs() {
        return this.maxOccurs;
    }
    
    protected Object getOption() {
        return this.option;
    }
    
    OptionMetadata(final Object x0, final int x1, final int x2, final OptionsMetadata$1 x3) {
        this(x0, x1, x2);
    }
    
    static /* synthetic */ int access$102(final OptionMetadata x0, final int x1) {
        return x0.minOccurs = x1;
    }
    
    static /* synthetic */ int access$202(final OptionMetadata x0, final int x1) {
        return x0.maxOccurs = x1;
    }
    
    static /* synthetic */ int access$200(final OptionMetadata x0) {
        return x0.maxOccurs;
    }
    
    static /* synthetic */ int access$100(final OptionMetadata x0) {
        return x0.minOccurs;
    }
}
