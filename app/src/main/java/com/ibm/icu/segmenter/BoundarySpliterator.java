package com.ibm.icu.segmenter;

import com.ibm.icu.text.BreakIterator;
import java.util.Spliterator;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class BoundarySpliterator implements Spliterator.OfInt {
    private final BoundaryIteratorOfInts iter;

    public BoundarySpliterator(BreakIterator breakIterator, CharSequence charSequence, Segments.IterationDirection iterationDirection, int i) {
        this.iter = new BoundaryIteratorOfInts(breakIterator, charSequence, iterationDirection, i);
    }

    @Override // java.util.Spliterator
    public int characteristics() {
        return 1297;
    }

    @Override // java.util.Spliterator
    public long estimateSize() {
        return Long.MAX_VALUE;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        if (!this.iter.hasNext()) {
            return false;
        }
        intConsumer.accept(this.iter.next().intValue());
        return true;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public Spliterator.OfInt trySplit() {
        return null;
    }
}
