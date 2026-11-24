package com.ibm.icu.segmenter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Segment {
    public final int limit;
    public final int ruleStatus;
    private final CharSequence source;
    public final int start;

    public Segment(int i, int i2, int i3, CharSequence charSequence) {
        this.start = i;
        this.limit = i2;
        this.ruleStatus = i3;
        this.source = charSequence;
    }

    public CharSequence getSubSequence() {
        return this.source.subSequence(this.start, this.limit);
    }
}
