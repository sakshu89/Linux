package com.ibm.icu.segmenter;

import com.ibm.icu.text.BreakIterator;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class SegmentIterator implements Iterator<Segment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private BreakIterator breakIter;
    private final Segments.IterationDirection direction;
    private int limit;
    private int limitRuleStatus;
    private final CharSequence source;
    private int start;

    public SegmentIterator(BreakIterator breakIterator, Segments.IterationDirection iterationDirection, int i, CharSequence charSequence) {
        this.breakIter = breakIterator;
        this.direction = iterationDirection;
        this.source = charSequence;
        boolean zIsBoundary = breakIterator.isBoundary(i);
        if (iterationDirection != Segments.IterationDirection.FORWARDS) {
            if (zIsBoundary) {
                this.limit = breakIterator.current();
                this.limitRuleStatus = breakIterator.getRuleStatus();
            } else {
                this.limit = breakIterator.previous();
                this.limitRuleStatus = breakIterator.getRuleStatus();
            }
            this.start = breakIterator.previous();
            return;
        }
        if (zIsBoundary) {
            this.start = i;
            this.limit = breakIterator.next();
            this.limitRuleStatus = breakIterator.getRuleStatus();
        } else {
            this.limit = breakIterator.current();
            this.limitRuleStatus = breakIterator.getRuleStatus();
            this.start = breakIterator.previous();
            breakIterator.isBoundary(this.limit);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.direction == Segments.IterationDirection.FORWARDS) {
            return this.limit != -1;
        }
        return this.start != -1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Segment next() {
        Segment segment = new Segment(this.start, this.limit, this.limitRuleStatus, this.source);
        if (this.direction == Segments.IterationDirection.FORWARDS) {
            this.start = this.limit;
            this.limit = this.breakIter.next();
            this.limitRuleStatus = this.breakIter.getRuleStatus();
            return segment;
        }
        this.limit = this.start;
        this.limitRuleStatus = this.breakIter.getRuleStatus();
        this.start = this.breakIter.previous();
        return segment;
    }
}
