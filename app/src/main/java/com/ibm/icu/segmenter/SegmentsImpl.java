package com.ibm.icu.segmenter;

import com.ibm.icu.text.BreakIterator;
import defpackage.c3;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class SegmentsImpl implements Segments {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private BreakIterator breakIterPrototype;
    private CharSequence source;

    public SegmentsImpl(BreakIterator breakIterator, CharSequence charSequence) {
        this.source = charSequence;
        BreakIterator breakIteratorMo5clone = breakIterator.mo5clone();
        this.breakIterPrototype = breakIteratorMo5clone;
        breakIteratorMo5clone.setText(charSequence);
    }

    @Override // com.ibm.icu.segmenter.Segments
    public IntStream boundariesAfter(int i) {
        return StreamSupport.intStream(new BoundarySpliterator(this.breakIterPrototype.mo5clone(), this.source, Segments.IterationDirection.FORWARDS, i), false);
    }

    @Override // com.ibm.icu.segmenter.Segments
    public IntStream boundariesBackFrom(int i) {
        return StreamSupport.intStream(new BoundarySpliterator(this.breakIterPrototype.mo5clone(), this.source, Segments.IterationDirection.BACKWARDS, i), false);
    }

    @Override // com.ibm.icu.segmenter.Segments
    public boolean isBoundary(int i) {
        return this.breakIterPrototype.mo5clone().isBoundary(i);
    }

    @Override // com.ibm.icu.segmenter.Segments
    public Segment segmentAt(int i) {
        int iCurrent;
        int ruleStatus;
        BreakIterator breakIteratorMo5clone = this.breakIterPrototype.mo5clone();
        if (i < 0 || i >= this.source.length()) {
            throw c3.o(i);
        }
        if (breakIteratorMo5clone.isBoundary(i)) {
            iCurrent = breakIteratorMo5clone.next();
            ruleStatus = breakIteratorMo5clone.getRuleStatus();
        } else {
            iCurrent = breakIteratorMo5clone.current();
            int ruleStatus2 = breakIteratorMo5clone.getRuleStatus();
            int iPrevious = breakIteratorMo5clone.previous();
            ruleStatus = ruleStatus2;
            i = iPrevious;
        }
        return new Segment(i, iCurrent, ruleStatus, this.source);
    }

    @Override // com.ibm.icu.segmenter.Segments
    public Stream<Segment> segmentsBefore(int i) {
        return StreamSupport.stream(new SegmentIterable(this.breakIterPrototype.mo5clone(), Segments.IterationDirection.BACKWARDS, i, this.source).spliterator(), false);
    }

    @Override // com.ibm.icu.segmenter.Segments
    public Stream<Segment> segmentsFrom(int i) {
        return StreamSupport.stream(new SegmentIterable(this.breakIterPrototype.mo5clone(), Segments.IterationDirection.FORWARDS, i, this.source).spliterator(), false);
    }
}
