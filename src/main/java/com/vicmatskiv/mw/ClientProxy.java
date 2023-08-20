package com.vicmatskiv.mw;

public class ClientProxy extends CommonProxy
{
    public ClientProxy() {
        super();
    }
    
    @Override
    protected boolean isClient() {
        return true;
    }
}
