package com.vicmatskiv.weaponlib;

private static class Entry<N>
{
    N content;
    int index;
    int parentIndex;
    private String name;
    
    private Entry() {
        super();
    }
    
    @Override
    public String toString() {
        return (this.name != null) ? this.name : this.content.toString();
    }
    
    Entry(final Trees$1 x0) {
        this();
    }
    
    static /* synthetic */ String access$102(final Entry x0, final String x1) {
        return x0.name = x1;
    }
}
