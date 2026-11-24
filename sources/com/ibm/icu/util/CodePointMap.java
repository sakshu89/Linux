package com.ibm.icu.util;

import com.ibm.icu.text.UTF16;
import defpackage.dk0;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class CodePointMap implements Iterable<Range> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Range {
        private int end = -1;
        private int start = -1;
        private int value = 0;

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public int getValue() {
            return this.value;
        }

        public void set(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.value = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RangeOption {
        NORMAL,
        FIXED_LEAD_SURROGATES,
        FIXED_ALL_SURROGATES
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class StringIterator {

        @Deprecated
        protected CharSequence s;

        @Deprecated
        protected int sIndex;

        @Deprecated
        protected int c = -1;

        @Deprecated
        protected int value = 0;

        @Deprecated
        public StringIterator(CharSequence charSequence, int i) {
            this.s = charSequence;
            this.sIndex = i;
        }

        public final int getCodePoint() {
            return this.c;
        }

        public final int getIndex() {
            return this.sIndex;
        }

        public final int getValue() {
            return this.value;
        }

        public boolean next() {
            if (this.sIndex >= this.s.length()) {
                return false;
            }
            int iCodePointAt = Character.codePointAt(this.s, this.sIndex);
            this.c = iCodePointAt;
            this.sIndex = Character.charCount(iCodePointAt) + this.sIndex;
            this.value = CodePointMap.this.get(this.c);
            return true;
        }

        public boolean previous() {
            int i = this.sIndex;
            if (i <= 0) {
                return false;
            }
            int iCodePointBefore = Character.codePointBefore(this.s, i);
            this.c = iCodePointBefore;
            this.sIndex -= Character.charCount(iCodePointBefore);
            this.value = CodePointMap.this.get(this.c);
            return true;
        }

        public void reset(CharSequence charSequence, int i) {
            this.s = charSequence;
            this.sIndex = i;
            this.c = -1;
            this.value = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface ValueFilter {
        int apply(int i);
    }

    public abstract int get(int i);

    public boolean getRange(int i, RangeOption rangeOption, int i2, ValueFilter valueFilter, Range range) {
        if (!getRange(i, valueFilter, range)) {
            return false;
        }
        if (rangeOption != RangeOption.NORMAL) {
            int i3 = rangeOption == RangeOption.FIXED_ALL_SURROGATES ? 57343 : UTF16.LEAD_SURROGATE_MAX_VALUE;
            int i4 = range.end;
            if (i4 >= 55295 && i <= i3) {
                if (range.value == i2) {
                    if (i4 < i3) {
                    }
                } else {
                    if (i <= 55295) {
                        range.end = 55295;
                        return true;
                    }
                    range.value = i2;
                    if (i4 > i3) {
                        range.end = i3;
                        return true;
                    }
                }
                if (getRange(i3 + 1, valueFilter, range) && range.value == i2) {
                    range.start = i;
                    return true;
                }
                range.start = i;
                range.end = i3;
                range.value = i2;
            }
        }
        return true;
    }

    public abstract boolean getRange(int i, ValueFilter valueFilter, Range range);

    @Override // java.lang.Iterable
    public Iterator<Range> iterator() {
        return new RangeIterator(this, 0);
    }

    public StringIterator stringIterator(CharSequence charSequence, int i) {
        return new StringIterator(charSequence, i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public final class RangeIterator implements Iterator<Range> {
        private Range range;

        private RangeIterator() {
            this.range = new Range();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return -1 <= this.range.end && this.range.end < 1114111;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Range next() {
            if (CodePointMap.this.getRange(this.range.end + 1, null, this.range)) {
                return this.range;
            }
            dk0.d();
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ RangeIterator(CodePointMap codePointMap, int i) {
            this();
        }
    }
}
