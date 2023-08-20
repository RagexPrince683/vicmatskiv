package com.vicmatskiv.weaponlib.crafting;

import java.security.*;
import java.util.*;

class SequenceGenerator
{
    private static final String ALG_NAME = "SHA1PRNG";
    private Map<List<Object>, Object> uniqueSequenceMap;
    private SecureRandom random;
    private int slotCount;
    
    SequenceGenerator(final int slotCount) {
        super();
        this.slotCount = slotCount;
        this.uniqueSequenceMap = new HashMap<List<Object>, Object>();
        try {
            this.random = SecureRandom.getInstance("SHA1PRNG");
        }
        catch (final NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to initialize sequence generator: " + e, e);
        }
    }
    
    public List<Object> generate(final Object obj, final byte[] seed, final OptionsMetadata optionMetadata) {
        this.random.setSeed(seed);
        return this.generateUniqueSequence(obj, optionMetadata);
    }
    
    private List<Object> generateUniqueSequence(final Object obj, final OptionsMetadata optionMetadata) {
        List<Object> result;
        do {
            result = this.generateSequence(optionMetadata.getMetadata());
        } while (this.uniqueSequenceMap.putIfAbsent(result, obj) != null);
        return result;
    }
    
    private List<Object> generateSequence(final OptionsMetadata.OptionMetadata[] optionMetadata) {
        final Object[] slotValues = new Object[this.slotCount];
        final int[] optionDistribution = new int[optionMetadata.length];
        do {
            Arrays.fill(optionDistribution, 0);
            Arrays.fill(slotValues, 0);
            for (int slot = 0; slot < this.slotCount; ++slot) {
                final int selectedOption = this.random.nextInt(optionMetadata.length);
                final int[] array = optionDistribution;
                final int n = selectedOption;
                ++array[n];
                slotValues[slot] = optionMetadata[selectedOption].getOption();
            }
        } while (!this.hasSufficientDistribution(optionDistribution, optionMetadata));
        return Arrays.asList(slotValues);
    }
    
    private boolean hasSufficientDistribution(final int[] slotDistribution, final OptionsMetadata.OptionMetadata[] optionMetadata) {
        boolean result = true;
        for (int i = 0; i < slotDistribution.length; ++i) {
            if (slotDistribution[i] < optionMetadata[i].getMinOccurs() || slotDistribution[i] > optionMetadata[i].getMaxOccurs()) {
                result = false;
                break;
            }
        }
        return result;
    }
}
