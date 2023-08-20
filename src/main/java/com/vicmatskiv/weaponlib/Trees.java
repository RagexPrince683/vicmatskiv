package com.vicmatskiv.weaponlib;

import io.netty.buffer.*;
import java.util.function.*;
import java.util.*;

public class Trees
{
    public Trees() {
        super();
    }
    
    public static <N> void writeBuf(final ByteBuf buf, final N root, final BiConsumer<ByteBuf, N> writeContent, final Function<N, List<N>> getChildren) {
        final Deque<Entry<N>> queue = new LinkedList<Entry<N>>();
        final Entry<N> SENTINEL = new Entry<N>();
        ((Entry<Object>)SENTINEL).name = "Sentinel";
        final Entry<N> rootEntry = new Entry<N>();
        rootEntry.content = root;
        rootEntry.parentIndex = 0;
        queue.add(rootEntry);
        queue.add(SENTINEL);
        int counter = 0;
        while (!queue.isEmpty()) {
            final Entry<N> e = queue.pollFirst();
            if (e == SENTINEL) {
                counter = 0;
                buf.writeByte(-1);
            }
            else {
                buf.writeInt(e.parentIndex);
                writeContent.accept(buf, e.content);
                final List<N> children = getChildren.apply(e.content);
                if (children.isEmpty()) {
                    continue;
                }
                for (final N n : children) {
                    final Entry<N> c = new Entry<N>();
                    c.content = n;
                    c.index = counter++;
                    c.parentIndex = e.index;
                    queue.addLast(c);
                }
                queue.addLast(SENTINEL);
            }
        }
        buf.writeByte(-1);
    }
    
    public static <N> N readBuf(final ByteBuf buf, final Function<ByteBuf, N> reader, final BiConsumer<N, N> attacher) {
        List<N> currentRow = new ArrayList<N>();
        List<N> previousRow = null;
        N root = null;
        while (true) {
            buf.markReaderIndex();
            if (buf.readByte() == -1) {
                if (currentRow.isEmpty()) {
                    break;
                }
                previousRow = currentRow;
                currentRow = new ArrayList<N>();
            }
            else {
                buf.resetReaderIndex();
                final int parentIndex = buf.readInt();
                final N thisNode = reader.apply(buf);
                if (previousRow != null) {
                    final N parentNode = previousRow.get(parentIndex);
                    attacher.accept(parentNode, thisNode);
                }
                else {
                    root = thisNode;
                }
                currentRow.add(thisNode);
            }
        }
        return root;
    }
    
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
}
