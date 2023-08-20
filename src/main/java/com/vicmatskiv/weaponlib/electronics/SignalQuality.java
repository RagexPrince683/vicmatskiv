package com.vicmatskiv.weaponlib.electronics;

import java.util.*;

public class SignalQuality
{
    private int quality;
    private boolean interrupted;
    private static Random random;
    
    public SignalQuality(final int quality, final boolean interrupted) {
        super();
        this.quality = quality;
        this.interrupted = interrupted;
    }
    
    public int getQuality() {
        return this.quality;
    }
    
    public boolean isInterrupted() {
        return this.interrupted;
    }
    
    public static SignalQuality getQuality(final int currentDistance, final int maxDistance) {
        final double allowedRange = currentDistance / (double)maxDistance;
        double adjustedAllowedRange = 1.0 - allowedRange * allowedRange * allowedRange;
        if (adjustedAllowedRange > 0.97) {
            adjustedAllowedRange = 1.0;
        }
        final double r = SignalQuality.random.nextDouble();
        final int signalQuality = (int)(adjustedAllowedRange * 100.0);
        return new SignalQuality(signalQuality, r >= adjustedAllowedRange);
    }
    
    static {
        SignalQuality.random = new Random();
    }
}
