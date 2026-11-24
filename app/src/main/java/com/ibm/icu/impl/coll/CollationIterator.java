package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Trie2_32;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.ICUException;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class CollationIterator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final long NO_CP_AND_CE32 = -4294967104L;
    private CEBuffer ceBuffer;
    private int cesIndex;
    protected final CollationData data;
    private boolean isNumeric;
    private int numCpFwd;
    private SkippedState skipped;
    protected final Trie2_32 trie;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CEBuffer {
        private static final int INITIAL_CAPACITY = 40;
        int length = 0;
        private long[] buffer = new long[40];

        public void append(long j) {
            if (this.length >= 40) {
                ensureAppendCapacity(1);
            }
            long[] jArr = this.buffer;
            int i = this.length;
            this.length = i + 1;
            jArr[i] = j;
        }

        public void appendUnsafe(long j) {
            long[] jArr = this.buffer;
            int i = this.length;
            this.length = i + 1;
            jArr[i] = j;
        }

        public void ensureAppendCapacity(int i) {
            int i2;
            int length = this.buffer.length;
            if (this.length + i <= length) {
                return;
            }
            do {
                length = length < 1000 ? length * 4 : length * 2;
                i2 = this.length;
            } while (length < i2 + i);
            long[] jArr = new long[length];
            System.arraycopy(this.buffer, 0, jArr, 0, i2);
            this.buffer = jArr;
        }

        public long get(int i) {
            return this.buffer[i];
        }

        public long[] getCEs() {
            return this.buffer;
        }

        public void incLength() {
            if (this.length >= 40) {
                ensureAppendCapacity(1);
            }
            this.length++;
        }

        public long set(int i, long j) {
            this.buffer[i] = j;
            return j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SkippedState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int pos;
        private int skipLengthAtMatch;
        private final StringBuilder oldBuffer = new StringBuilder();
        private final StringBuilder newBuffer = new StringBuilder();
        private CharsTrie.State state = new CharsTrie.State();

        public int backwardNumCodePoints(int i) {
            int length = this.oldBuffer.length();
            int i2 = this.pos;
            int i3 = i2 - length;
            if (i3 <= 0) {
                this.pos = this.oldBuffer.offsetByCodePoints(i2, -i);
                return 0;
            }
            if (i3 >= i) {
                this.pos = i2 - i;
                return i;
            }
            this.pos = this.oldBuffer.offsetByCodePoints(length, i3 - i);
            return i3;
        }

        public void clear() {
            this.oldBuffer.setLength(0);
            this.pos = 0;
        }

        public boolean hasNext() {
            return this.pos < this.oldBuffer.length();
        }

        public void incBeyond() {
            this.pos++;
        }

        public boolean isEmpty() {
            return this.oldBuffer.length() == 0;
        }

        public int next() {
            int iCodePointAt = this.oldBuffer.codePointAt(this.pos);
            this.pos = Character.charCount(iCodePointAt) + this.pos;
            return iCodePointAt;
        }

        public void recordMatch() {
            this.skipLengthAtMatch = this.newBuffer.length();
        }

        public void replaceMatch() {
            int length = this.oldBuffer.length();
            if (this.pos > length) {
                this.pos = length;
            }
            this.oldBuffer.delete(0, this.pos).insert(0, this.newBuffer, 0, this.skipLengthAtMatch);
            this.pos = 0;
        }

        public void resetToTrieState(CharsTrie charsTrie) {
            charsTrie.resetToState(this.state);
        }

        public void saveTrieState(CharsTrie charsTrie) {
            charsTrie.saveState(this.state);
        }

        public void setFirstSkipped(int i) {
            this.skipLengthAtMatch = 0;
            this.newBuffer.setLength(0);
            this.newBuffer.appendCodePoint(i);
        }

        public void skip(int i) {
            this.newBuffer.appendCodePoint(i);
        }
    }

    public CollationIterator(CollationData collationData, boolean z) {
        this.trie = collationData.trie;
        this.data = collationData;
        this.numCpFwd = -1;
        this.isNumeric = z;
        this.ceBuffer = new CEBuffer();
    }

    private final void appendNumericCEs(int i, boolean z) {
        int iNextCodePoint;
        StringBuilder sb = new StringBuilder();
        if (z) {
            while (true) {
                sb.append(Collation.digitFromCE32(i));
                if (this.numCpFwd == 0 || (iNextCodePoint = nextCodePoint()) < 0) {
                    break;
                }
                int ce32 = this.data.getCE32(iNextCodePoint);
                i = ce32 == 192 ? this.data.base.getCE32(iNextCodePoint) : ce32;
                if (!Collation.hasCE32Tag(i, 10)) {
                    backwardNumCodePoints(1);
                    break;
                } else {
                    int i2 = this.numCpFwd;
                    if (i2 > 0) {
                        this.numCpFwd = i2 - 1;
                    }
                }
            }
        } else {
            while (true) {
                sb.append(Collation.digitFromCE32(i));
                int iPreviousCodePoint = previousCodePoint();
                if (iPreviousCodePoint < 0) {
                    break;
                }
                int ce33 = this.data.getCE32(iPreviousCodePoint);
                i = ce33 == 192 ? this.data.base.getCE32(iPreviousCodePoint) : ce33;
                if (!Collation.hasCE32Tag(i, 10)) {
                    forwardNumCodePoints(1);
                    break;
                }
            }
            sb.reverse();
        }
        int i3 = 0;
        while (true) {
            if (i3 >= sb.length() - 1 || sb.charAt(i3) != 0) {
                int length = sb.length() - i3;
                if (length > 254) {
                    length = 254;
                }
                int i4 = length + i3;
                appendNumericSegmentCEs(sb.subSequence(i3, i4));
                if (i4 >= sb.length()) {
                    return;
                } else {
                    i3 = i4;
                }
            } else {
                i3++;
            }
        }
    }

    private final void appendNumericSegmentCEs(CharSequence charSequence) {
        int iCharAt;
        int i;
        int length = charSequence.length();
        long j = this.data.numericPrimary;
        int i2 = 8;
        if (length <= 7) {
            int iCharAt2 = charSequence.charAt(0);
            for (int i3 = 1; i3 < length; i3++) {
                iCharAt2 = (iCharAt2 * 10) + charSequence.charAt(i3);
            }
            if (iCharAt2 < 74) {
                this.ceBuffer.append(Collation.makeCE(j | ((long) ((iCharAt2 + 2) << 16))));
                return;
            }
            int i4 = iCharAt2 - 74;
            if (i4 < 10160) {
                this.ceBuffer.append(Collation.makeCE(j | ((long) (((i4 / 254) + 76) << 16)) | ((long) (((i4 % 254) + 2) << 8))));
                return;
            }
            int i5 = iCharAt2 - 10234;
            if (i5 < 1032256) {
                long j2 = j | ((long) ((i5 % 254) + 2));
                int i6 = i5 / 254;
                this.ceBuffer.append(Collation.makeCE(j2 | ((long) (((i6 % 254) + 2) << 8)) | ((long) ((((i6 / 254) % 254) + 116) << 16))));
                return;
            }
        }
        long j3 = ((long) ((((length + 1) / 2) + 128) << 16)) | j;
        while (charSequence.charAt(length - 1) == 0 && charSequence.charAt(length - 2) == 0) {
            length -= 2;
        }
        if ((length & 1) != 0) {
            iCharAt = charSequence.charAt(0);
            i = 1;
        } else {
            iCharAt = (charSequence.charAt(0) * '\n') + charSequence.charAt(1);
            i = 2;
        }
        int iCharAt3 = (iCharAt * 2) + 11;
        while (i < length) {
            if (i2 == 0) {
                this.ceBuffer.append(Collation.makeCE(((long) iCharAt3) | j3));
                j3 = j;
                i2 = 16;
            } else {
                j3 |= (long) (iCharAt3 << i2);
                i2 -= 8;
            }
            iCharAt3 = ((charSequence.charAt(i + 1) + (charSequence.charAt(i) * '\n')) * 2) + 11;
            i += 2;
        }
        this.ceBuffer.append(Collation.makeCE(((long) ((iCharAt3 - 1) << i2)) | j3));
    }

    private final void backwardNumSkipped(int i) {
        SkippedState skippedState = this.skipped;
        if (skippedState != null && !skippedState.isEmpty()) {
            i = this.skipped.backwardNumCodePoints(i);
        }
        backwardNumCodePoints(i);
        int i2 = this.numCpFwd;
        if (i2 >= 0) {
            this.numCpFwd = i2 + i;
        }
    }

    private final int getCE32FromPrefix(CollationData collationData, int i) {
        BytesTrie.Result resultNextForCodePoint;
        int iIndexFromCE32 = Collation.indexFromCE32(i);
        int cE32FromContexts = collationData.getCE32FromContexts(iIndexFromCE32);
        CharsTrie charsTrie = new CharsTrie(collationData.contexts, iIndexFromCE32 + 2);
        int i2 = 0;
        do {
            int iPreviousCodePoint = previousCodePoint();
            if (iPreviousCodePoint < 0) {
                break;
            }
            i2++;
            resultNextForCodePoint = charsTrie.nextForCodePoint(iPreviousCodePoint);
            if (resultNextForCodePoint.hasValue()) {
                cE32FromContexts = charsTrie.getValue();
            }
        } while (resultNextForCodePoint.hasNext());
        forwardNumCodePoints(i2);
        return cE32FromContexts;
    }

    public static final boolean isLeadSurrogate(int i) {
        return (i & (-1024)) == 55296;
    }

    private static final boolean isSurrogate(int i) {
        return (i & (-2048)) == 55296;
    }

    public static final boolean isTrailSurrogate(int i) {
        return (i & (-1024)) == 56320;
    }

    private final int nextCE32FromContraction(CollationData collationData, int i, CharSequence charSequence, int i2, int i3, int i4) {
        int iNextSkippedCodePoint;
        CharsTrie charsTrie = new CharsTrie(charSequence, i2);
        SkippedState skippedState = this.skipped;
        if (skippedState != null && !skippedState.isEmpty()) {
            this.skipped.saveTrieState(charsTrie);
        }
        BytesTrie.Result resultFirstForCodePoint = charsTrie.firstForCodePoint(i4);
        int i5 = 1;
        int i6 = 1;
        while (true) {
            if (resultFirstForCodePoint.hasValue()) {
                i3 = charsTrie.getValue();
                if (!resultFirstForCodePoint.hasNext() || (iNextSkippedCodePoint = nextSkippedCodePoint()) < 0) {
                    break;
                }
                SkippedState skippedState2 = this.skipped;
                if (skippedState2 != null && !skippedState2.isEmpty()) {
                    this.skipped.saveTrieState(charsTrie);
                }
                i5 = 1;
            } else {
                if (resultFirstForCodePoint == BytesTrie.Result.NO_MATCH || (iNextSkippedCodePoint = nextSkippedCodePoint()) < 0) {
                    if ((i & 1024) != 0 && ((i & 256) == 0 || i5 < i6)) {
                        if (i5 > 1) {
                            backwardNumSkipped(i5);
                            i4 = nextSkippedCodePoint();
                            i6 -= i5 - 1;
                            i5 = 1;
                        }
                        int i7 = i6;
                        if (collationData.getFCD16(i4) > 255) {
                            return nextCE32FromDiscontiguousContraction(collationData, charsTrie, i3, i7, i4);
                        }
                    }
                    int i8 = i3;
                    backwardNumSkipped(i5);
                    return i8;
                }
                i5++;
            }
            i4 = iNextSkippedCodePoint;
            i6++;
            resultFirstForCodePoint = charsTrie.nextForCodePoint(i4);
        }
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    /* JADX WARN: Code duplicated, block: B:39:0x009c  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a4 A[EDGE_INSN: B:55:0x00a4->B:41:0x00a4 BREAK  A[LOOP:0: B:27:0x0063->B:57:?], SYNTHETIC] */
    private final int nextCE32FromDiscontiguousContraction(CollationData collationData, CharsTrie charsTrie, int i, int i2, int i3) {
        int fcd16 = collationData.getFCD16(i3);
        int iNextSkippedCodePoint = nextSkippedCodePoint();
        if (iNextSkippedCodePoint < 0) {
            backwardNumSkipped(1);
            return i;
        }
        int i4 = i2 + 1;
        int i5 = fcd16 & 255;
        int fcd17 = collationData.getFCD16(iNextSkippedCodePoint);
        int i6 = 2;
        if (fcd17 <= 255) {
            backwardNumSkipped(2);
            return i;
        }
        SkippedState skippedState = this.skipped;
        if (skippedState == null || skippedState.isEmpty()) {
            if (this.skipped == null) {
                this.skipped = new SkippedState();
            }
            charsTrie.reset();
            if (i4 > 2) {
                backwardNumCodePoints(i4);
                charsTrie.firstForCodePoint(nextCodePoint());
                for (int i7 = 3; i7 < i4; i7++) {
                    charsTrie.nextForCodePoint(nextCodePoint());
                }
                forwardNumCodePoints(2);
            }
            this.skipped.saveTrieState(charsTrie);
        } else {
            this.skipped.resetToTrieState(charsTrie);
        }
        this.skipped.setFirstSkipped(i3);
        do {
            if (i5 < (fcd17 >> 8)) {
                BytesTrie.Result resultNextForCodePoint = charsTrie.nextForCodePoint(iNextSkippedCodePoint);
                if (resultNextForCodePoint.hasValue()) {
                    i = charsTrie.getValue();
                    this.skipped.recordMatch();
                    i6 = 0;
                    if (!resultNextForCodePoint.hasNext()) {
                        break;
                    }
                    this.skipped.saveTrieState(charsTrie);
                } else {
                    this.skipped.skip(iNextSkippedCodePoint);
                    this.skipped.resetToTrieState(charsTrie);
                    i5 = fcd17 & 255;
                }
                iNextSkippedCodePoint = nextSkippedCodePoint();
                if (iNextSkippedCodePoint < 0) {
                    break;
                }
                i6++;
                fcd17 = collationData.getFCD16(iNextSkippedCodePoint);
            } else {
                this.skipped.skip(iNextSkippedCodePoint);
                this.skipped.resetToTrieState(charsTrie);
                i5 = fcd17 & 255;
                iNextSkippedCodePoint = nextSkippedCodePoint();
                if (iNextSkippedCodePoint < 0) {
                    break;
                    break;
                }
                i6++;
                fcd17 = collationData.getFCD16(iNextSkippedCodePoint);
            }
        } while (fcd17 > 255);
        backwardNumSkipped(i6);
        boolean zIsEmpty = this.skipped.isEmpty();
        this.skipped.replaceMatch();
        if (!zIsEmpty || this.skipped.isEmpty()) {
            return i;
        }
        int next = -1;
        while (true) {
            appendCEsFromCE32(collationData, next, i, true);
            boolean zHasNext = this.skipped.hasNext();
            SkippedState skippedState2 = this.skipped;
            if (!zHasNext) {
                skippedState2.clear();
                return 1;
            }
            next = skippedState2.next();
            i = getDataCE32(next);
            collationData = this.data;
            if (i == 192) {
                collationData = collationData.base;
                i = collationData.getCE32(next);
            }
        }
    }

    private final long nextCEFromCE32(CollationData collationData, int i, int i2) {
        this.ceBuffer.length--;
        appendCEsFromCE32(collationData, i, i2, true);
        CEBuffer cEBuffer = this.ceBuffer;
        int i3 = this.cesIndex;
        this.cesIndex = i3 + 1;
        return cEBuffer.get(i3);
    }

    private final int nextSkippedCodePoint() {
        SkippedState skippedState = this.skipped;
        if (skippedState != null && skippedState.hasNext()) {
            return this.skipped.next();
        }
        if (this.numCpFwd == 0) {
            return -1;
        }
        int iNextCodePoint = nextCodePoint();
        SkippedState skippedState2 = this.skipped;
        if (skippedState2 != null && !skippedState2.isEmpty() && iNextCodePoint >= 0) {
            this.skipped.incBeyond();
        }
        int i = this.numCpFwd;
        if (i > 0 && iNextCodePoint >= 0) {
            this.numCpFwd = i - 1;
        }
        return iNextCodePoint;
    }

    private final long previousCEUnsafe(int i, UVector32 uVector32) {
        int iPreviousCodePoint;
        int i2 = 1;
        do {
            iPreviousCodePoint = previousCodePoint();
            if (iPreviousCodePoint < 0) {
                break;
            }
            i2++;
        } while (this.data.isUnsafeBackward(iPreviousCodePoint, this.isNumeric));
        this.numCpFwd = i2;
        this.cesIndex = 0;
        int offset = getOffset();
        while (true) {
            int i3 = this.numCpFwd;
            if (i3 <= 0) {
                uVector32.addElement(offset);
                this.numCpFwd = -1;
                backwardNumCodePoints(i2);
                this.cesIndex = 0;
                CEBuffer cEBuffer = this.ceBuffer;
                int i4 = cEBuffer.length - 1;
                cEBuffer.length = i4;
                return cEBuffer.get(i4);
            }
            this.numCpFwd = i3 - 1;
            nextCE();
            this.cesIndex = this.ceBuffer.length;
            uVector32.addElement(offset);
            offset = getOffset();
            while (uVector32.size() < this.ceBuffer.length) {
                uVector32.addElement(offset);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:124:0x01a0 A[SYNTHETIC] */
    public final void appendCEsFromCE32(CollationData collationData, int i, int i2, boolean z) {
        CollationIterator collationIterator;
        int cE32FromBuilderData;
        int iNextSkippedCodePoint;
        int i3;
        int cE32FromSupplementary;
        CollationData collationData2 = collationData;
        int ce32 = i2;
        while (Collation.isSpecialCE32(ce32)) {
            switch (Collation.tagFromCE32(ce32)) {
                case 0:
                case 3:
                    og.q("internal program error: should be unreachable");
                    break;
                case 1:
                    this.ceBuffer.append(Collation.ceFromLongPrimaryCE32(ce32));
                    break;
                case 2:
                    this.ceBuffer.append(Collation.ceFromLongSecondaryCE32(ce32));
                    break;
                case 4:
                    CollationIterator collationIterator2 = this;
                    collationIterator2.ceBuffer.ensureAppendCapacity(2);
                    CEBuffer cEBuffer = collationIterator2.ceBuffer;
                    cEBuffer.set(cEBuffer.length, Collation.latinCE0FromCE32(ce32));
                    CEBuffer cEBuffer2 = collationIterator2.ceBuffer;
                    cEBuffer2.set(cEBuffer2.length + 1, Collation.latinCE1FromCE32(ce32));
                    collationIterator2.ceBuffer.length += 2;
                    break;
                case 5:
                    CollationIterator collationIterator3 = this;
                    int iIndexFromCE32 = Collation.indexFromCE32(ce32);
                    int iLengthFromCE32 = Collation.lengthFromCE32(ce32);
                    collationIterator3.ceBuffer.ensureAppendCapacity(iLengthFromCE32);
                    while (true) {
                        int i4 = iIndexFromCE32 + 1;
                        collationIterator3.ceBuffer.appendUnsafe(Collation.ceFromCE32(collationData2.ce32s[iIndexFromCE32]));
                        iLengthFromCE32--;
                        if (iLengthFromCE32 > 0) {
                            iIndexFromCE32 = i4;
                        }
                        break;
                    }
                    break;
                case 6:
                    CollationIterator collationIterator4 = this;
                    int iIndexFromCE33 = Collation.indexFromCE32(ce32);
                    int iLengthFromCE33 = Collation.lengthFromCE32(ce32);
                    collationIterator4.ceBuffer.ensureAppendCapacity(iLengthFromCE33);
                    while (true) {
                        int i5 = iIndexFromCE33 + 1;
                        collationIterator4.ceBuffer.appendUnsafe(collationData2.ces[iIndexFromCE33]);
                        iLengthFromCE33--;
                        if (iLengthFromCE33 > 0) {
                            iIndexFromCE33 = i5;
                        }
                        break;
                    }
                    break;
                case 7:
                    collationIterator = this;
                    cE32FromBuilderData = collationIterator.getCE32FromBuilderData(ce32);
                    if (cE32FromBuilderData == 192) {
                        CollationData collationData3 = collationIterator.data.base;
                        collationData2 = collationData3;
                        ce32 = collationData3.getCE32(i);
                    } else {
                        ce32 = cE32FromBuilderData;
                    }
                    this = collationIterator;
                    break;
                case 8:
                    collationIterator = this;
                    if (z) {
                        collationIterator.backwardNumCodePoints(1);
                    }
                    cE32FromBuilderData = collationIterator.getCE32FromPrefix(collationData2, ce32);
                    if (z) {
                        collationIterator.forwardNumCodePoints(1);
                    }
                    ce32 = cE32FromBuilderData;
                    this = collationIterator;
                    break;
                case 9:
                    int iIndexFromCE34 = Collation.indexFromCE32(ce32);
                    int cE32FromContexts = collationData2.getCE32FromContexts(iIndexFromCE34);
                    if (z) {
                        if (this.skipped != null || this.numCpFwd >= 0) {
                            iNextSkippedCodePoint = this.nextSkippedCodePoint();
                            if (iNextSkippedCodePoint >= 0) {
                                if ((ce32 & 512) != 0 && !CollationFCD.mayHaveLccc(iNextSkippedCodePoint)) {
                                    this.backwardNumSkipped(1);
                                }
                                CollationIterator collationIterator5 = this;
                                cE32FromBuilderData = collationIterator5.nextCE32FromContraction(collationData2, ce32, collationData2.contexts, iIndexFromCE34 + 2, cE32FromContexts, iNextSkippedCodePoint);
                                collationIterator = collationIterator5;
                                if (cE32FromBuilderData == 1) {
                                }
                                ce32 = cE32FromBuilderData;
                            }
                        } else {
                            iNextSkippedCodePoint = this.nextCodePoint();
                            if (iNextSkippedCodePoint >= 0) {
                                if ((ce32 & 512) != 0 && !CollationFCD.mayHaveLccc(iNextSkippedCodePoint)) {
                                    this.backwardNumCodePoints(1);
                                }
                                CollationIterator collationIterator6 = this;
                                cE32FromBuilderData = collationIterator6.nextCE32FromContraction(collationData2, ce32, collationData2.contexts, iIndexFromCE34 + 2, cE32FromContexts, iNextSkippedCodePoint);
                                collationIterator = collationIterator6;
                                if (cE32FromBuilderData == 1) {
                                }
                                ce32 = cE32FromBuilderData;
                            }
                        }
                        this = collationIterator;
                    }
                    collationIterator = this;
                    ce32 = cE32FromContexts;
                    this = collationIterator;
                    break;
                case 10:
                    if (!this.isNumeric) {
                        i3 = collationData2.ce32s[Collation.indexFromCE32(ce32)];
                        ce32 = i3;
                        collationIterator = this;
                        this = collationIterator;
                    } else {
                        this.appendNumericCEs(ce32, z);
                    }
                    break;
                case 11:
                    i3 = collationData2.ce32s[0];
                    ce32 = i3;
                    collationIterator = this;
                    this = collationIterator;
                    break;
                case 12:
                    int[] iArr = collationData2.jamoCE32s;
                    int i6 = i - Normalizer2Impl.Hangul.HANGUL_BASE;
                    int i7 = i6 % 28;
                    int i8 = i6 / 28;
                    int i9 = i8 % 21;
                    int i10 = i8 / 21;
                    if ((ce32 & 256) == 0) {
                        this.appendCEsFromCE32(collationData2, -1, iArr[i10], z);
                        this.appendCEsFromCE32(collationData2, -1, iArr[i9 + 19], z);
                        if (i7 != 0) {
                            ce32 = iArr[i7 + 39];
                            i = -1;
                            collationIterator = this;
                            this = collationIterator;
                        }
                    } else {
                        this.ceBuffer.ensureAppendCapacity(i7 == 0 ? 2 : 3);
                        CEBuffer cEBuffer3 = this.ceBuffer;
                        cEBuffer3.set(cEBuffer3.length, Collation.ceFromCE32(iArr[i10]));
                        CEBuffer cEBuffer4 = this.ceBuffer;
                        cEBuffer4.set(cEBuffer4.length + 1, Collation.ceFromCE32(iArr[i9 + 19]));
                        CEBuffer cEBuffer5 = this.ceBuffer;
                        cEBuffer5.length += 2;
                        if (i7 != 0) {
                            cEBuffer5.appendUnsafe(Collation.ceFromCE32(iArr[i7 + 39]));
                        }
                    }
                    break;
                case 13:
                    char cHandleGetTrailSurrogate = this.handleGetTrailSurrogate();
                    if (Character.isLowSurrogate(cHandleGetTrailSurrogate)) {
                        int codePoint = Character.toCodePoint((char) i, cHandleGetTrailSurrogate);
                        int i11 = ce32 & 768;
                        if (i11 == 0) {
                            i = codePoint;
                            ce32 = -1;
                        } else {
                            if (i11 == 256 || (cE32FromSupplementary = collationData2.getCE32FromSupplementary(codePoint)) == 192) {
                                CollationData collationData4 = collationData2.base;
                                collationData2 = collationData4;
                                ce32 = collationData4.getCE32FromSupplementary(codePoint);
                            } else {
                                ce32 = cE32FromSupplementary;
                            }
                            i = codePoint;
                        }
                        collationIterator = this;
                    } else {
                        collationIterator = this;
                        ce32 = -1;
                    }
                    this = collationIterator;
                    break;
                case 14:
                    this.ceBuffer.append(collationData2.getCEFromOffsetCE32(i, ce32));
                    break;
                case 15:
                    if (isSurrogate(i) && this.forbidSurrogateCodePoints()) {
                        i3 = -195323;
                        ce32 = i3;
                        collationIterator = this;
                        this = collationIterator;
                    } else {
                        this.ceBuffer.append(Collation.unassignedCEFromCodePoint(i));
                    }
                    break;
                default:
                    collationIterator = this;
                    this = collationIterator;
                    break;
            }
            return;
        }
        this.ceBuffer.append(Collation.ceFromSimpleCE32(ce32));
    }

    public abstract void backwardNumCodePoints(int i);

    public final void clearCEs() {
        this.ceBuffer.length = 0;
        this.cesIndex = 0;
    }

    public final void clearCEsIfNoneRemaining() {
        if (this.cesIndex == this.ceBuffer.length) {
            clearCEs();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        CollationIterator collationIterator = (CollationIterator) obj;
        if (this.ceBuffer.length != collationIterator.ceBuffer.length || this.cesIndex != collationIterator.cesIndex || this.numCpFwd != collationIterator.numCpFwd || this.isNumeric != collationIterator.isNumeric) {
            return false;
        }
        int i = 0;
        while (true) {
            CEBuffer cEBuffer = this.ceBuffer;
            if (i >= cEBuffer.length) {
                return true;
            }
            if (cEBuffer.get(i) != collationIterator.ceBuffer.get(i)) {
                return false;
            }
            i++;
        }
    }

    public final int fetchCEs() {
        while (true) {
            long jNextCE = nextCE();
            CEBuffer cEBuffer = this.ceBuffer;
            if (jNextCE == Collation.NO_CE) {
                return cEBuffer.length;
            }
            this.cesIndex = cEBuffer.length;
        }
    }

    public boolean forbidSurrogateCodePoints() {
        return false;
    }

    public abstract void forwardNumCodePoints(int i);

    public final long getCE(int i) {
        return this.ceBuffer.get(i);
    }

    public int getCE32FromBuilderData(int i) {
        throw new ICUException("internal program error: should be unreachable");
    }

    public final long[] getCEs() {
        return this.ceBuffer.getCEs();
    }

    public final int getCEsLength() {
        return this.ceBuffer.length;
    }

    public int getDataCE32(int i) {
        return this.data.getCE32(i);
    }

    public abstract int getOffset();

    public char handleGetTrailSurrogate() {
        return (char) 0;
    }

    public long handleNextCE32() {
        int iNextCodePoint = nextCodePoint();
        return iNextCodePoint < 0 ? NO_CP_AND_CE32 : makeCodePointAndCE32Pair(iNextCodePoint, this.data.getCE32(iNextCodePoint));
    }

    public int hashCode() {
        return 0;
    }

    public long makeCodePointAndCE32Pair(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }

    public final long nextCE() {
        int i;
        int ce32;
        CollationData collationData;
        int i2 = this.cesIndex;
        CEBuffer cEBuffer = this.ceBuffer;
        if (i2 < cEBuffer.length) {
            this.cesIndex = i2 + 1;
            return cEBuffer.get(i2);
        }
        cEBuffer.incLength();
        long jHandleNextCE32 = handleNextCE32();
        int i3 = (int) (jHandleNextCE32 >> 32);
        int i4 = (int) jHandleNextCE32;
        int i5 = i4 & 255;
        if (i5 < 192) {
            CEBuffer cEBuffer2 = this.ceBuffer;
            int i6 = this.cesIndex;
            this.cesIndex = i6 + 1;
            return cEBuffer2.set(i6, ((long) (i5 << 8)) | (((long) (i4 & 65280)) << 16) | (((long) (i4 & (-65536))) << 32));
        }
        if (i5 != 192) {
            i = i5;
            ce32 = i4;
            collationData = this.data;
        } else {
            if (i3 < 0) {
                CEBuffer cEBuffer3 = this.ceBuffer;
                int i7 = this.cesIndex;
                this.cesIndex = i7 + 1;
                return cEBuffer3.set(i7, Collation.NO_CE);
            }
            collationData = this.data.base;
            ce32 = collationData.getCE32(i3);
            i = ce32 & 255;
            if (i < 192) {
                CEBuffer cEBuffer4 = this.ceBuffer;
                int i8 = this.cesIndex;
                this.cesIndex = i8 + 1;
                return cEBuffer4.set(i8, (((long) (ce32 & 65280)) << 16) | (((long) (ce32 & (-65536))) << 32) | ((long) (i << 8)));
            }
        }
        if (i != 193) {
            return nextCEFromCE32(collationData, i3, ce32);
        }
        CEBuffer cEBuffer5 = this.ceBuffer;
        int i9 = this.cesIndex;
        this.cesIndex = i9 + 1;
        return cEBuffer5.set(i9, (((long) (ce32 - i)) << 32) | 83887360);
    }

    public abstract int nextCodePoint();

    public final long previousCE(UVector32 uVector32) {
        CEBuffer cEBuffer = this.ceBuffer;
        int i = cEBuffer.length;
        if (i > 0) {
            int i2 = i - 1;
            cEBuffer.length = i2;
            return cEBuffer.get(i2);
        }
        uVector32.removeAllElements();
        int offset = getOffset();
        int iPreviousCodePoint = previousCodePoint();
        if (iPreviousCodePoint < 0) {
            return Collation.NO_CE;
        }
        if (this.data.isUnsafeBackward(iPreviousCodePoint, this.isNumeric)) {
            return previousCEUnsafe(iPreviousCodePoint, uVector32);
        }
        int ce32 = this.data.getCE32(iPreviousCodePoint);
        CollationData collationData = this.data;
        if (ce32 == 192) {
            collationData = collationData.base;
            ce32 = collationData.getCE32(iPreviousCodePoint);
        }
        if (Collation.isSimpleOrLongCE32(ce32)) {
            return Collation.ceFromCE32(ce32);
        }
        appendCEsFromCE32(collationData, iPreviousCodePoint, ce32, false);
        if (this.ceBuffer.length > 1) {
            uVector32.addElement(getOffset());
            while (uVector32.size() <= this.ceBuffer.length) {
                uVector32.addElement(offset);
            }
        }
        CEBuffer cEBuffer2 = this.ceBuffer;
        int i3 = cEBuffer2.length - 1;
        cEBuffer2.length = i3;
        return cEBuffer2.get(i3);
    }

    public abstract int previousCodePoint();

    public final void reset(boolean z) {
        if (this.ceBuffer == null) {
            this.ceBuffer = new CEBuffer();
        }
        reset();
        this.isNumeric = z;
    }

    public abstract void resetToOffset(int i);

    public final void setCurrentCE(long j) {
        this.ceBuffer.set(this.cesIndex - 1, j);
    }

    public final void reset() {
        this.ceBuffer.length = 0;
        this.cesIndex = 0;
        SkippedState skippedState = this.skipped;
        if (skippedState != null) {
            skippedState.clear();
        }
    }

    public CollationIterator(CollationData collationData) {
        this.trie = collationData.trie;
        this.data = collationData;
        this.numCpFwd = -1;
        this.isNumeric = false;
        this.ceBuffer = null;
    }
}
