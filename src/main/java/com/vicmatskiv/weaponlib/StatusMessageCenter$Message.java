package com.vicmatskiv.weaponlib;

public static class Message
{
    long expiresAt;
    String message;
    boolean isAlert;
    
    public Message(final String message, final long expiresAt) {
        this(message, expiresAt, false);
    }
    
    public Message(final String message, final long expiresAt, final boolean isAlert) {
        super();
        this.message = message;
        this.expiresAt = expiresAt;
        this.isAlert = isAlert;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public boolean isAlert() {
        return this.isAlert;
    }
}
