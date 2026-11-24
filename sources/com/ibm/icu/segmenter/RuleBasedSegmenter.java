package com.ibm.icu.segmenter;

import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.RuleBasedBreakIterator;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RuleBasedSegmenter implements Segmenter {
    private final BreakIterator breakIterPrototype;

    private RuleBasedSegmenter(BreakIterator breakIterator) {
        this.breakIterPrototype = breakIterator;
    }

    public static Builder builder() {
        return new Builder(0);
    }

    @Override // com.ibm.icu.segmenter.Segmenter
    public Segments segment(CharSequence charSequence) {
        return new SegmentsImpl(this.breakIterPrototype, charSequence);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Builder {
        private BreakIterator breakIter;

        private Builder() {
            this.breakIter = null;
        }

        public Segmenter build() {
            BreakIterator breakIterator = this.breakIter;
            if (breakIterator != null) {
                return new RuleBasedSegmenter(0, breakIterator);
            }
            og.i("A rule string must be set.");
            return null;
        }

        public Builder setRules(String str) {
            if (str == null) {
                og.i("rules cannot be set to null.");
                return null;
            }
            try {
                this.breakIter = new RuleBasedBreakIterator(str);
                return this;
            } catch (RuntimeException e) {
                throw new IllegalArgumentException("The provided rule string is invalid or there was an error in creating the RuleBasedSegmenter.", e);
            }
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public /* synthetic */ RuleBasedSegmenter(int i, BreakIterator breakIterator) {
        this(breakIterator);
    }
}
