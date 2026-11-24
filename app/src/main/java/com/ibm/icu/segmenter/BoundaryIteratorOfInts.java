package com.ibm.icu.segmenter;

import com.ibm.icu.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class BoundaryIteratorOfInts {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private BreakIterator breakIter;
    private int currIdx;
    private Segments.IterationDirection direction;

    public BoundaryIteratorOfInts(BreakIterator breakIterator, CharSequence charSequence, Segments.IterationDirection iterationDirection, int i) {
        this.breakIter = breakIterator;
        this.direction = iterationDirection;
        if (iterationDirection == Segments.IterationDirection.FORWARDS) {
            this.currIdx = breakIterator.following(i);
            return;
        }
        int length = charSequence.length();
        if (i == 0) {
            this.currIdx = breakIterator.first();
        } else if (i == length) {
            this.currIdx = breakIterator.last();
        } else {
            this.currIdx = (i < 0 || i > length || !breakIterator.isBoundary(i)) ? breakIterator.preceding(i) : i;
        }
    }

    public boolean hasNext() {
        return this.currIdx != -1;
    }

    public Integer next() {
        int i = this.currIdx;
        Segments.IterationDirection iterationDirection = this.direction;
        Segments.IterationDirection iterationDirection2 = Segments.IterationDirection.FORWARDS;
        BreakIterator breakIterator = this.breakIter;
        if (iterationDirection == iterationDirection2) {
            this.currIdx = breakIterator.next();
        } else {
            this.currIdx = breakIterator.previous();
        }
        return Integer.valueOf(i);
    }
}
