package com.vicmatskiv.weaponlib.crafting;

import com.vicmatskiv.weaponlib.compatibility.*;
import java.util.*;

public static class OptionMetadataBuilder
{
    LinkedHashMap<Object, OptionMetadata> optionMetadata;
    private int slotCount;
    
    public OptionMetadataBuilder() {
        super();
        this.optionMetadata = new LinkedHashMap<Object, OptionMetadata>();
    }
    
    public OptionMetadataBuilder withSlotCount(final int slotCount) {
        this.slotCount = slotCount;
        return this;
    }
    
    public OptionMetadataBuilder withOption(final int minOccurs, final int maxOccurs) {
        final OptionMetadata metadata = new OptionMetadata(OptionsMetadata.EMPTY_OPTION, minOccurs, maxOccurs);
        metadata.minOccurs = minOccurs;
        metadata.maxOccurs = maxOccurs;
        this.optionMetadata.put(OptionsMetadata.EMPTY_OPTION, metadata);
        return this;
    }
    
    public OptionMetadataBuilder withOption(Object option, final int minOccurs, final int maxOccurs) {
        if (minOccurs > maxOccurs) {
            throw new IllegalArgumentException("Min occurs must be less or equals maxOccurs");
        }
        if (option instanceof CompatibleBlocks) {
            option = ((CompatibleBlocks)option).getBlock();
        }
        else if (option instanceof CompatibleItems) {
            option = ((CompatibleItems)option).getItem();
        }
        else if (option instanceof String) {
            final String stringOption = ((String)option).toLowerCase();
            if ((!stringOption.contains("ore") && !stringOption.contains("ingot") && !stringOption.contains("dust")) || !stringOption.startsWith(":")) {}
        }
        final OptionMetadata metadata = new OptionMetadata(option, minOccurs, maxOccurs);
        metadata.minOccurs = minOccurs;
        metadata.maxOccurs = maxOccurs;
        this.optionMetadata.put(option, metadata);
        return this;
    }
    
    public OptionsMetadata build(final CraftingComplexity complexity, final Object... options) {
        final int complexityIndex = complexity.ordinal() + 1;
        if (options.length * complexityIndex > this.slotCount) {
            throw new IllegalArgumentException("Too many options for complexity level " + complexity);
        }
        for (final Object option : options) {
            if (option == null) {
                throw new IllegalArgumentException("Option cannot be null, make sure to initialize it before generating receipe");
            }
            this.withOption(option, complexityIndex, complexityIndex);
        }
        this.withOption(OptionsMetadata.EMPTY_OPTION, 0, this.slotCount - options.length * complexityIndex);
        return this.build();
    }
    
    public OptionsMetadata build() {
        if (this.slotCount == 0) {
            throw new IllegalStateException("Slot count not set");
        }
        int totalMaxOccurs = 0;
        int totalMinOccurs = 0;
        boolean hasOres = false;
        for (final OptionMetadata m : this.optionMetadata.values()) {
            totalMaxOccurs += m.maxOccurs;
            totalMinOccurs += m.minOccurs;
            if (m.getOption() instanceof String) {
                hasOres = true;
            }
        }
        if (totalMaxOccurs < this.slotCount) {
            throw new IllegalStateException("Total slot count is less than total max occurs");
        }
        if (totalMinOccurs > this.slotCount) {
            throw new IllegalStateException("Total max occurs exceeds the number of slots");
        }
        final OptionMetadata[] metadata = this.optionMetadata.entrySet().stream().map(e -> new OptionMetadata(e.getKey(), e.getValue().minOccurs, e.getValue().maxOccurs)).toArray(OptionMetadata[]::new);
        return new OptionsMetadata(metadata, hasOres, null);
    }
    
    private static /* synthetic */ OptionMetadata[] lambda$build$231(final int size) {
        return new OptionMetadata[size];
    }
    
    private static /* synthetic */ OptionMetadata lambda$build$230(final Map.Entry e) {
        return new OptionMetadata(e.getKey(), e.getValue().minOccurs, e.getValue().maxOccurs);
    }
}
