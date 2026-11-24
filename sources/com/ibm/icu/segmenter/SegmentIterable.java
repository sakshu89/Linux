package com.ibm.icu.segmenter;

import com.ibm.icu.text.BreakIterator;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class SegmentIterable implements Iterable<Segment> {
    private BreakIterator breakIter;
    private final Segments.IterationDirection direction;
    private final CharSequence source;
    private int startIdx;

    public SegmentIterable(BreakIterator breakIterator, Segments.IterationDirection iterationDirection, int i, CharSequence charSequence) {
        this.breakIter = breakIterator;
        this.direction = iterationDirection;
        this.startIdx = i;
        this.source = charSequence;
    }

    @Override // java.lang.Iterable
    public Iterator<Segment> iterator() {
        return new SegmentIterator(this.breakIter, this.direction, this.startIdx, this.source);
    }
}
