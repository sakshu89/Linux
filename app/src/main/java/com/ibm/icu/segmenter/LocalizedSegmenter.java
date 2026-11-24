package com.ibm.icu.segmenter;

import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.util.ULocale;
import defpackage.og;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocalizedSegmenter implements Segmenter {
    private BreakIterator breakIterPrototype;

    /* JADX INFO: renamed from: com.ibm.icu.segmenter.LocalizedSegmenter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$segmenter$LocalizedSegmenter$SegmentationType;

        static {
            int[] iArr = new int[SegmentationType.values().length];
            $SwitchMap$com$ibm$icu$segmenter$LocalizedSegmenter$SegmentationType = iArr;
            try {
                iArr[SegmentationType.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$segmenter$LocalizedSegmenter$SegmentationType[SegmentationType.SENTENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$segmenter$LocalizedSegmenter$SegmentationType[SegmentationType.WORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$segmenter$LocalizedSegmenter$SegmentationType[SegmentationType.GRAPHEME_CLUSTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum SegmentationType {
        GRAPHEME_CLUSTER,
        WORD,
        LINE,
        SENTENCE
    }

    private LocalizedSegmenter(ULocale uLocale, SegmentationType segmentationType) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$segmenter$LocalizedSegmenter$SegmentationType[segmentationType.ordinal()];
        if (i == 1) {
            this.breakIterPrototype = BreakIterator.getLineInstance(uLocale);
            return;
        }
        if (i == 2) {
            this.breakIterPrototype = BreakIterator.getSentenceInstance(uLocale);
        } else if (i == 3) {
            this.breakIterPrototype = BreakIterator.getWordInstance(uLocale);
        } else {
            if (i != 4) {
                return;
            }
            this.breakIterPrototype = BreakIterator.getCharacterInstance(uLocale);
        }
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
        private ULocale locale;
        private SegmentationType segmentationType;

        private Builder() {
            this.locale = ULocale.ROOT;
            this.segmentationType = null;
        }

        public Segmenter build() {
            SegmentationType segmentationType = this.segmentationType;
            if (segmentationType != null) {
                return new LocalizedSegmenter(this.locale, segmentationType, 0);
            }
            og.i("segmentationType is null and must be set to a specific value.");
            return null;
        }

        public Builder setLocale(Locale locale) {
            if (locale != null) {
                this.locale = ULocale.forLocale(locale);
                return this;
            }
            og.i("locale cannot be set to null.");
            return null;
        }

        public Builder setSegmentationType(SegmentationType segmentationType) {
            if (segmentationType != null) {
                this.segmentationType = segmentationType;
                return this;
            }
            og.i("segmentationType cannot be set to null.");
            return null;
        }

        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder setLocale(ULocale uLocale) {
            if (uLocale != null) {
                this.locale = uLocale;
                return this;
            }
            og.i("locale cannot be set to null.");
            return null;
        }
    }

    public /* synthetic */ LocalizedSegmenter(ULocale uLocale, SegmentationType segmentationType, int i) {
        this(uLocale, segmentationType);
    }
}
