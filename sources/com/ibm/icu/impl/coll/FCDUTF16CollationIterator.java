package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class FCDUTF16CollationIterator extends UTF16CollationIterator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int rawStart = 0;
    private int checkDir;
    private final Normalizer2Impl nfcImpl;
    private StringBuilder normalized;
    private int rawLimit;
    private CharSequence rawSeq;
    private int segmentLimit;
    private int segmentStart;

    public FCDUTF16CollationIterator(CollationData collationData, boolean z, CharSequence charSequence, int i) {
        super(collationData, z, charSequence, i);
        this.rawSeq = charSequence;
        this.segmentStart = i;
        this.rawLimit = charSequence.length();
        this.nfcImpl = collationData.nfcImpl;
        this.checkDir = 1;
    }

    private void nextSegment() {
        int iCharCount;
        int i = this.pos;
        int i2 = 0;
        while (true) {
            int iCodePointAt = Character.codePointAt(this.seq, i);
            iCharCount = Character.charCount(iCodePointAt) + i;
            int fcd16 = this.nfcImpl.getFCD16(iCodePointAt);
            int i3 = fcd16 >> 8;
            if (i3 == 0 && i != this.pos) {
                this.segmentLimit = i;
                this.limit = i;
            } else if (i3 == 0 || (i2 <= i3 && !CollationFCD.isFCD16OfTibetanCompositeVowel(fcd16))) {
                i2 = fcd16 & 255;
                if (iCharCount == this.rawLimit || i2 == 0) {
                    break;
                } else {
                    i = iCharCount;
                }
            } else {
                while (iCharCount != this.rawLimit) {
                    int iCodePointAt2 = Character.codePointAt(this.seq, iCharCount);
                    int iCharCount2 = Character.charCount(iCodePointAt2) + iCharCount;
                    if (this.nfcImpl.getFCD16(iCodePointAt2) <= 255) {
                        break;
                    } else {
                        iCharCount = iCharCount2;
                    }
                }
                normalize(this.pos, iCharCount);
                this.pos = this.start;
            }
            this.checkDir = 0;
        }
        this.segmentLimit = iCharCount;
        this.limit = iCharCount;
        this.checkDir = 0;
    }

    private void normalize(int i, int i2) {
        if (this.normalized == null) {
            this.normalized = new StringBuilder();
        }
        this.nfcImpl.decompose(this.rawSeq, i, i2, this.normalized, i2 - i);
        this.segmentStart = i;
        this.segmentLimit = i2;
        StringBuilder sb = this.normalized;
        this.seq = sb;
        this.start = 0;
        this.limit = sb.length();
    }

    private void previousSegment() {
        int iCharCount;
        int fcd16;
        int i = this.pos;
        int i2 = 0;
        while (true) {
            int iCodePointBefore = Character.codePointBefore(this.seq, i);
            iCharCount = i - Character.charCount(iCodePointBefore);
            fcd16 = this.nfcImpl.getFCD16(iCodePointBefore);
            int i3 = fcd16 & 255;
            if (i3 == 0 && i != this.pos) {
                this.segmentStart = i;
                this.start = i;
            } else {
                if (i3 != 0 && ((i2 != 0 && i3 > i2) || CollationFCD.isFCD16OfTibetanCompositeVowel(fcd16))) {
                    break;
                }
                i2 = fcd16 >> 8;
                if (iCharCount == 0 || i2 == 0) {
                    this.segmentStart = iCharCount;
                    this.start = iCharCount;
                } else {
                    i = iCharCount;
                }
            }
            this.checkDir = 0;
        }
        while (fcd16 > 255 && iCharCount != 0) {
            int iCodePointBefore2 = Character.codePointBefore(this.seq, iCharCount);
            int iCharCount2 = iCharCount - Character.charCount(iCodePointBefore2);
            fcd16 = this.nfcImpl.getFCD16(iCodePointBefore2);
            if (fcd16 == 0) {
                break;
            } else {
                iCharCount = iCharCount2;
            }
        }
        normalize(iCharCount, this.pos);
        this.pos = this.limit;
        this.checkDir = 0;
    }

    private void switchToBackward() {
        if (this.checkDir > 0) {
            int i = this.pos;
            this.segmentLimit = i;
            this.limit = i;
            if (i != this.segmentStart) {
                this.checkDir = 0;
                return;
            } else {
                this.start = 0;
                this.checkDir = -1;
                return;
            }
        }
        CharSequence charSequence = this.seq;
        CharSequence charSequence2 = this.rawSeq;
        if (charSequence != charSequence2) {
            this.seq = charSequence2;
            int i2 = this.segmentStart;
            this.segmentLimit = i2;
            this.limit = i2;
            this.pos = i2;
        }
        this.start = 0;
        this.checkDir = -1;
    }

    private void switchToForward() {
        if (this.checkDir < 0) {
            int i = this.pos;
            this.segmentStart = i;
            this.start = i;
            if (i != this.segmentLimit) {
                this.checkDir = 0;
                return;
            } else {
                this.limit = this.rawLimit;
                this.checkDir = 1;
                return;
            }
        }
        CharSequence charSequence = this.seq;
        CharSequence charSequence2 = this.rawSeq;
        if (charSequence != charSequence2) {
            this.seq = charSequence2;
            int i2 = this.segmentLimit;
            this.segmentStart = i2;
            this.start = i2;
            this.pos = i2;
        }
        this.limit = this.rawLimit;
        this.checkDir = 1;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public void backwardNumCodePoints(int i) {
        while (i > 0 && previousCodePoint() >= 0) {
            i--;
        }
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public boolean equals(Object obj) {
        if ((obj instanceof CollationIterator) && equals(obj) && (obj instanceof FCDUTF16CollationIterator)) {
            FCDUTF16CollationIterator fCDUTF16CollationIterator = (FCDUTF16CollationIterator) obj;
            int i = this.checkDir;
            if (i != fCDUTF16CollationIterator.checkDir) {
                return false;
            }
            if (i == 0) {
                if ((this.seq == this.rawSeq) != (fCDUTF16CollationIterator.seq == fCDUTF16CollationIterator.rawSeq)) {
                    return false;
                }
            }
            if (i == 0 && this.seq != this.rawSeq) {
                return this.segmentStart == fCDUTF16CollationIterator.segmentStart && this.pos - this.start == fCDUTF16CollationIterator.pos - fCDUTF16CollationIterator.start;
            }
            if (this.pos == fCDUTF16CollationIterator.pos) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public void forwardNumCodePoints(int i) {
        while (i > 0 && nextCodePoint() >= 0) {
            i--;
        }
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int getOffset() {
        if (this.checkDir != 0 || this.seq == this.rawSeq) {
            return this.pos;
        }
        return this.pos == this.start ? this.segmentStart : this.segmentLimit;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public long handleNextCE32() {
        char cCharAt;
        int i;
        int i2;
        while (true) {
            int i3 = this.checkDir;
            if (i3 <= 0) {
                if (i3 == 0 && (i2 = this.pos) != this.limit) {
                    CharSequence charSequence = this.seq;
                    this.pos = i2 + 1;
                    cCharAt = charSequence.charAt(i2);
                    break;
                }
                switchToForward();
            } else {
                int i4 = this.pos;
                if (i4 != this.limit) {
                    CharSequence charSequence2 = this.seq;
                    this.pos = i4 + 1;
                    cCharAt = charSequence2.charAt(i4);
                    if (!CollationFCD.hasTccc(cCharAt) || (!CollationFCD.maybeTibetanCompositeVowel(cCharAt) && ((i = this.pos) == this.limit || !CollationFCD.hasLccc(this.seq.charAt(i))))) {
                        break;
                        break;
                        break;
                    }
                    this.pos--;
                    nextSegment();
                    CharSequence charSequence3 = this.seq;
                    int i5 = this.pos;
                    this.pos = i5 + 1;
                    cCharAt = charSequence3.charAt(i5);
                    break;
                }
                return -4294967104L;
            }
        }
        return makeCodePointAndCE32Pair(cCharAt, this.trie.getFromU16SingleLead(cCharAt));
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int hashCode() {
        return 42;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int nextCodePoint() {
        char cCharAt;
        int i;
        int i2;
        int i3;
        while (true) {
            int i4 = this.checkDir;
            if (i4 <= 0) {
                if (i4 == 0 && (i3 = this.pos) != this.limit) {
                    CharSequence charSequence = this.seq;
                    this.pos = i3 + 1;
                    cCharAt = charSequence.charAt(i3);
                    break;
                }
                switchToForward();
            } else {
                int i5 = this.pos;
                if (i5 != this.limit) {
                    CharSequence charSequence2 = this.seq;
                    this.pos = i5 + 1;
                    cCharAt = charSequence2.charAt(i5);
                    if (!CollationFCD.hasTccc(cCharAt) || (!CollationFCD.maybeTibetanCompositeVowel(cCharAt) && ((i = this.pos) == this.limit || !CollationFCD.hasLccc(this.seq.charAt(i))))) {
                        break;
                        break;
                        break;
                    }
                    this.pos--;
                    nextSegment();
                    CharSequence charSequence3 = this.seq;
                    int i6 = this.pos;
                    this.pos = i6 + 1;
                    cCharAt = charSequence3.charAt(i6);
                    break;
                }
                return -1;
            }
        }
        if (Character.isHighSurrogate(cCharAt) && (i2 = this.pos) != this.limit) {
            char cCharAt2 = this.seq.charAt(i2);
            if (Character.isLowSurrogate(cCharAt2)) {
                this.pos++;
                return Character.toCodePoint(cCharAt, cCharAt2);
            }
        }
        return cCharAt;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int previousCodePoint() {
        char cCharAt;
        int i;
        int i2;
        while (true) {
            int i3 = this.checkDir;
            if (i3 >= 0) {
                if (i3 == 0 && (i2 = this.pos) != this.start) {
                    CharSequence charSequence = this.seq;
                    int i4 = i2 - 1;
                    this.pos = i4;
                    cCharAt = charSequence.charAt(i4);
                    break;
                }
                switchToBackward();
            } else {
                int i5 = this.pos;
                if (i5 != this.start) {
                    CharSequence charSequence2 = this.seq;
                    int i6 = i5 - 1;
                    this.pos = i6;
                    cCharAt = charSequence2.charAt(i6);
                    if (!CollationFCD.hasLccc(cCharAt) || (!CollationFCD.maybeTibetanCompositeVowel(cCharAt) && !CollationFCD.hasTcccBefore(this.seq, this.start, this.pos))) {
                        break;
                        break;
                    }
                    this.pos++;
                    previousSegment();
                    CharSequence charSequence3 = this.seq;
                    int i7 = this.pos - 1;
                    this.pos = i7;
                    cCharAt = charSequence3.charAt(i7);
                    break;
                }
                return -1;
            }
        }
        if (Character.isLowSurrogate(cCharAt) && (i = this.pos) != this.start) {
            char cCharAt2 = this.seq.charAt(i - 1);
            if (Character.isHighSurrogate(cCharAt2)) {
                this.pos--;
                return Character.toCodePoint(cCharAt2, cCharAt);
            }
        }
        return cCharAt;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public void resetToOffset(int i) {
        reset();
        this.seq = this.rawSeq;
        this.pos = i;
        this.segmentStart = i;
        this.start = i;
        this.limit = this.rawLimit;
        this.checkDir = 1;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator
    public void setText(boolean z, CharSequence charSequence, int i) {
        super.setText(z, charSequence, i);
        this.rawSeq = charSequence;
        this.segmentStart = i;
        int length = charSequence.length();
        this.limit = length;
        this.rawLimit = length;
        this.checkDir = 1;
    }

    public FCDUTF16CollationIterator(CollationData collationData) {
        super(collationData);
        this.nfcImpl = collationData.nfcImpl;
    }
}
