package com.ibm.icu.segmenter;

import defpackage.mc1;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface Segments {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum IterationDirection {
        FORWARDS,
        BACKWARDS
    }

    default IntStream boundaries() {
        return boundariesAfter(-1);
    }

    IntStream boundariesAfter(int i);

    IntStream boundariesBackFrom(int i);

    boolean isBoundary(int i);

    Segment segmentAt(int i);

    default Stream<Segment> segments() {
        return segmentsFrom(0);
    }

    Stream<Segment> segmentsBefore(int i);

    Stream<Segment> segmentsFrom(int i);

    default Stream<CharSequence> subSequences() {
        return segments().map(new mc1(4));
    }
}
