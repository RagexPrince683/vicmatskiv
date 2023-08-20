package com.vicmatskiv.weaponlib.crafting;

import java.util.*;

final class RecipeGenerator
{
    private static final int SLOT_COUNT = 9;
    private SequenceGenerator sequenceGenerator;
    
    RecipeGenerator() {
        super();
        this.sequenceGenerator = new SequenceGenerator(9);
    }
    
    public List<Object> createShapedRecipe(final String name, final OptionsMetadata metadata) {
        final List<Object> sequence = this.sequenceGenerator.generate(name, this.createSeed(name, metadata), metadata);
        final LinkedHashMap<Object, Character> encodingMap = new LinkedHashMap<Object, Character>();
        char startFrom = 'A';
        for (final OptionsMetadata.OptionMetadata optionMetadata : metadata.getMetadata()) {
            char code;
            if (optionMetadata.getOption() == OptionsMetadata.EMPTY_OPTION) {
                code = ' ';
            }
            else {
                final char c = startFrom;
                ++startFrom;
                code = c;
            }
            encodingMap.put(optionMetadata.getOption(), code);
        }
        final List<Object> output = new ArrayList<Object>();
        final StringBuilder builder = new StringBuilder();
        int i = 0;
        for (final Object t : sequence) {
            builder.append(encodingMap.get(t));
            if (++i % 3 == 0) {
                output.add(builder.toString());
                builder.setLength(0);
            }
        }
        encodingMap.entrySet().stream().filter(e -> e.getKey() != OptionsMetadata.EMPTY_OPTION).forEach(e -> {
            list.add(e.getValue());
            list.add(e.getKey());
            return;
        });
        return output;
    }
    
    private byte[] createSeed(final String name, final OptionsMetadata metadata) {
        return (name + metadata.getMetadata().length).getBytes();
    }
    
    private static /* synthetic */ void lambda$createShapedRecipe$233(final List list, final Map.Entry e) {
        list.add(e.getValue());
        list.add(e.getKey());
    }
    
    private static /* synthetic */ boolean lambda$createShapedRecipe$232(final Map.Entry e) {
        return e.getKey() != OptionsMetadata.EMPTY_OPTION;
    }
}
