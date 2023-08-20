package com.vicmatskiv.weaponlib.crafting;

import com.vicmatskiv.weaponlib.compatibility.*;
import java.util.*;

public class OptionsMetadata
{
    public static final Object EMPTY_OPTION;
    private OptionMetadata[] metadata;
    private boolean hasOres;
    
    private OptionsMetadata(final OptionMetadata[] metadata, final boolean hasOres) {
        super();
        this.metadata = metadata;
        this.hasOres = hasOres;
    }
    
    public OptionMetadata[] getMetadata() {
        return this.metadata;
    }
    
    public boolean hasOres() {
        return this.hasOres;
    }
    
    OptionsMetadata(final OptionMetadata[] x0, final boolean x1, final OptionsMetadata$1 x2) {
        this(x0, x1);
    }
    
    static {
        EMPTY_OPTION = new Object();
    }
    
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
}
