package com.vicmatskiv.weaponlib;

import java.util.*;

public final class StatusMessageCenter
{
    protected Deque<Message> messageQueue;
    
    public StatusMessageCenter() {
        super();
        this.messageQueue = new LinkedList<Message>();
    }
    
    public void addMessage(final String message) {
        this.addMessage(message, -1L);
    }
    
    public void addMessage(final String message, final long duration) {
        final long expiresAt = (duration < 0L) ? Long.MAX_VALUE : (System.currentTimeMillis() + duration);
        while (!this.messageQueue.isEmpty()) {
            final Message m = this.messageQueue.removeFirst();
            if (m.expiresAt > expiresAt) {
                this.messageQueue.addFirst(m);
                break;
            }
        }
        this.messageQueue.addFirst(new Message(message, expiresAt));
    }
    
    public void addAlertMessage(final String message, final int count, final long duration, final long pause) {
        long expiresAt = System.currentTimeMillis();
        this.messageQueue.clear();
        for (int i = 0; i < count; ++i) {
            expiresAt += duration;
            this.messageQueue.addLast(new Message(message, expiresAt, true));
            expiresAt += pause;
            this.messageQueue.addLast(new Message("", expiresAt));
        }
    }
    
    public Message nextMessage() {
        Message result = null;
        while (!this.messageQueue.isEmpty()) {
            final Message m = this.messageQueue.removeFirst();
            if (m.expiresAt > System.currentTimeMillis()) {
                result = m;
                this.messageQueue.addFirst(m);
                break;
            }
        }
        return result;
    }
    
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
}
