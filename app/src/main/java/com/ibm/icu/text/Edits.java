package com.ibm.icu.text;

import defpackage.cq;
import defpackage.og;
import java.nio.BufferOverflowException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Edits {
    private static final int LENGTH_IN_1TRAIL = 61;
    private static final int LENGTH_IN_2TRAIL = 62;
    private static final int MAX_SHORT_CHANGE = 28671;
    private static final int MAX_SHORT_CHANGE_NEW_LENGTH = 7;
    private static final int MAX_SHORT_CHANGE_OLD_LENGTH = 6;
    private static final int MAX_UNCHANGED = 4095;
    private static final int MAX_UNCHANGED_LENGTH = 4096;
    private static final int SHORT_CHANGE_NUM_MASK = 511;
    private static final int STACK_CAPACITY = 100;
    private char[] array = new char[100];
    private int delta;
    private int length;
    private int numChanges;

    private void append(int i) {
        if (this.length < this.array.length || growArray()) {
            char[] cArr = this.array;
            int i2 = this.length;
            this.length = i2 + 1;
            cArr[i2] = (char) i;
        }
    }

    private boolean growArray() {
        int length;
        char[] cArr = this.array;
        if (cArr.length == 100) {
            length = 2000;
        } else {
            if (cArr.length == Integer.MAX_VALUE) {
                throw new BufferOverflowException();
            }
            length = cArr.length >= 1073741823 ? Integer.MAX_VALUE : cArr.length * 2;
        }
        if (length - cArr.length < 5) {
            throw new BufferOverflowException();
        }
        this.array = Arrays.copyOf(cArr, length);
        return true;
    }

    private int lastUnit() {
        int i = this.length;
        return i > 0 ? this.array[i - 1] : DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
    }

    private void setLastUnit(int i) {
        this.array[this.length - 1] = (char) i;
    }

    public void addReplace(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i < 0 || i2 < 0) {
            og.i(cq.i("addReplace(", i, ", ", i2, "): both lengths must be non-negative"));
            return;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        this.numChanges++;
        int i7 = i2 - i;
        if (i7 != 0) {
            if ((i7 > 0 && (i6 = this.delta) >= 0 && i7 > Integer.MAX_VALUE - i6) || (i7 < 0 && (i5 = this.delta) < 0 && i7 < Integer.MIN_VALUE - i5)) {
                throw new IndexOutOfBoundsException();
            }
            this.delta += i7;
        }
        if (i > 0 && i <= 6 && i2 <= 7) {
            int i8 = (i << 12) | (i2 << 9);
            int iLastUnit = lastUnit();
            if (4095 >= iLastUnit || iLastUnit >= MAX_SHORT_CHANGE || (iLastUnit & (-512)) != i8 || (iLastUnit & SHORT_CHANGE_NUM_MASK) >= SHORT_CHANGE_NUM_MASK) {
                append(i8);
                return;
            } else {
                setLastUnit(iLastUnit + 1);
                return;
            }
        }
        if (i < 61 && i2 < 61) {
            append((i << 6) | 28672 | i2);
            return;
        }
        if (this.array.length - this.length >= 5 || growArray()) {
            int i9 = this.length;
            int i10 = i9 + 1;
            if (i < 61) {
                i3 = (i << 6) | 28672;
            } else {
                char[] cArr = this.array;
                if (i <= 32767) {
                    cArr[i10] = (char) (i | 32768);
                    i3 = 32576;
                    i10 = i9 + 2;
                } else {
                    cArr[i10] = (char) ((i >> 15) | 32768);
                    i10 = i9 + 3;
                    cArr[i9 + 2] = (char) (i | 32768);
                    i3 = (((i >> 30) + 62) << 6) | 28672;
                }
            }
            if (i2 < 61) {
                i4 = i3 | i2;
            } else {
                char[] cArr2 = this.array;
                if (i2 <= 32767) {
                    i4 = i3 | 61;
                    cArr2[i10] = (char) (i2 | 32768);
                    i10++;
                } else {
                    i4 = i3 | ((i2 >> 30) + 62);
                    int i11 = i10 + 1;
                    cArr2[i10] = (char) ((i2 >> 15) | 32768);
                    i10 += 2;
                    cArr2[i11] = (char) (i2 | 32768);
                }
            }
            this.array[i9] = (char) i4;
            this.length = i10;
        }
    }

    public void addUnchanged(int i) {
        if (i < 0) {
            og.i(cq.h("addUnchanged(", i, "): length must not be negative"));
            return;
        }
        int iLastUnit = lastUnit();
        if (iLastUnit < 4095) {
            int i2 = 4095 - iLastUnit;
            if (i2 >= i) {
                setLastUnit(iLastUnit + i);
                return;
            } else {
                setLastUnit(4095);
                i -= i2;
            }
        }
        while (i >= 4096) {
            append(4095);
            i -= 4096;
        }
        if (i > 0) {
            append(i - 1);
        }
    }

    public Iterator getCoarseChangesIterator() {
        return new Iterator(this.array, this.length, true, true, 0);
    }

    public Iterator getCoarseIterator() {
        return new Iterator(this.array, this.length, false, true, 0);
    }

    public Iterator getFineChangesIterator() {
        return new Iterator(this.array, this.length, true, false, 0);
    }

    public Iterator getFineIterator() {
        return new Iterator(this.array, this.length, false, false, 0);
    }

    public boolean hasChanges() {
        return this.numChanges != 0;
    }

    public int lengthDelta() {
        return this.delta;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x00db A[SYNTHETIC] */
    public Edits mergeAndAppend(Edits edits, Edits edits2) {
        Iterator fineIterator = edits.getFineIterator();
        Iterator fineIterator2 = edits2.getFineIterator();
        boolean next = true;
        boolean next2 = true;
        int iOldLength = 0;
        int iNewLength = 0;
        int i = 0;
        int i2 = 0;
        int iOldLength2 = 0;
        int iNewLength2 = 0;
        while (true) {
            if (iOldLength == 0 && next) {
                next = fineIterator2.next();
                if (next) {
                    iOldLength = fineIterator2.oldLength();
                    iNewLength2 = fineIterator2.newLength();
                    if (iOldLength == 0) {
                        if (iNewLength == 0 || !fineIterator.hasChange()) {
                            addReplace(i, i2 + iNewLength2);
                            i = 0;
                            i2 = i;
                        } else {
                            i2 += iNewLength2;
                        }
                    }
                }
            }
            if (iNewLength == 0) {
                if (!next2 || !(next2 = fineIterator.next())) {
                    break;
                }
                iOldLength2 = fineIterator.oldLength();
                iNewLength = fineIterator.newLength();
                if (iNewLength == 0) {
                    if (iOldLength == fineIterator2.oldLength() || !fineIterator2.hasChange()) {
                        addReplace(i + iOldLength2, i2);
                        i = 0;
                        i2 = i;
                    } else {
                        i += iOldLength2;
                    }
                }
            }
            if (iOldLength == 0) {
                og.i("The bc input string is shorter than the ab output string.");
                return null;
            }
            if (!fineIterator.hasChange() && !fineIterator2.hasChange()) {
                if (i != 0 || i2 != 0) {
                    addReplace(i, i2);
                    i = 0;
                    i2 = 0;
                }
                int i3 = iOldLength2 <= iNewLength2 ? iOldLength2 : iNewLength2;
                addUnchanged(i3);
                iOldLength2 -= i3;
                iNewLength2 -= i3;
                iNewLength = iOldLength2;
            } else if (fineIterator.hasChange() || !fineIterator2.hasChange()) {
                if (!fineIterator.hasChange() || fineIterator2.hasChange()) {
                    if (iNewLength == iOldLength) {
                        addReplace(i + iOldLength2, i2 + iNewLength2);
                        iOldLength = 0;
                        iNewLength = 0;
                        i = 0;
                        i2 = i;
                    }
                } else if (iNewLength <= iOldLength) {
                    addReplace(i + iOldLength2, i2 + iNewLength);
                    iNewLength2 = iOldLength - iNewLength;
                    iNewLength = 0;
                    i = 0;
                    i2 = 0;
                }
                i += iOldLength2;
                i2 += iNewLength2;
                if (iNewLength < iOldLength) {
                    iOldLength -= iNewLength;
                    iNewLength = 0;
                    iNewLength2 = 0;
                } else {
                    iNewLength -= iOldLength;
                    iOldLength = 0;
                    iOldLength2 = 0;
                }
            } else if (iNewLength >= iOldLength) {
                addReplace(i + iOldLength, i2 + iNewLength2);
                iOldLength2 = iNewLength - iOldLength;
                iOldLength = 0;
                i = 0;
                i2 = 0;
                iNewLength = iOldLength2;
            } else {
                i += iOldLength2;
                i2 += iNewLength2;
                if (iNewLength < iOldLength) {
                    iOldLength -= iNewLength;
                    iNewLength = 0;
                    iNewLength2 = 0;
                } else {
                    iNewLength -= iOldLength;
                    iOldLength = 0;
                    iOldLength2 = 0;
                }
            }
            iOldLength = iNewLength2;
        }
        if (iOldLength != 0) {
            og.i("The ab output string is shorter than the bc input string.");
            return null;
        }
        if (i == 0 && i2 == 0) {
            return this;
        }
        addReplace(i, i2);
        return this;
    }

    public int numberOfChanges() {
        return this.numChanges;
    }

    public void reset() {
        this.numChanges = 0;
        this.delta = 0;
        this.length = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Iterator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final char[] array;
        private boolean changed;
        private final boolean coarse;
        private int destIndex;
        private int dir;
        private int index;
        private final int length;
        private int newLength_;
        private int oldLength_;
        private final boolean onlyChanges_;
        private int remaining;
        private int replIndex;
        private int srcIndex;

        private Iterator(char[] cArr, int i, boolean z, boolean z2) {
            this.array = cArr;
            this.length = i;
            this.onlyChanges_ = z;
            this.coarse = z2;
        }

        private int findIndex(int i, boolean z) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (i < 0) {
                return -1;
            }
            if (z) {
                i2 = this.srcIndex;
                i3 = this.oldLength_;
            } else {
                i2 = this.destIndex;
                i3 = this.newLength_;
            }
            if (i < i2) {
                if (i >= i2 / 2) {
                    while (true) {
                        previous();
                        int i6 = z ? this.srcIndex : this.destIndex;
                        if (i >= i6) {
                            return 0;
                        }
                        int i7 = this.remaining;
                        if (i7 > 0) {
                            int i8 = z ? this.oldLength_ : this.newLength_;
                            int i9 = ((this.array[this.index] & 511) + 1) - i7;
                            if (i >= i6 - (i9 * i8)) {
                                int i10 = (((i6 - i) - 1) / i8) + 1;
                                this.srcIndex -= this.oldLength_ * i10;
                                int i11 = this.replIndex;
                                int i12 = this.newLength_;
                                this.replIndex = i11 - (i10 * i12);
                                this.destIndex -= i12 * i10;
                                this.remaining = i7 + i10;
                                return 0;
                            }
                            this.srcIndex -= this.oldLength_ * i9;
                            int i13 = this.replIndex;
                            int i14 = this.newLength_;
                            this.replIndex = i13 - (i9 * i14);
                            this.destIndex -= i9 * i14;
                            this.remaining = 0;
                        }
                    }
                } else {
                    this.dir = 0;
                    this.destIndex = 0;
                    this.replIndex = 0;
                    this.srcIndex = 0;
                    this.newLength_ = 0;
                    this.oldLength_ = 0;
                    this.remaining = 0;
                    this.index = 0;
                }
            } else if (i < i2 + i3) {
                return 0;
            }
            while (next(false)) {
                if (z) {
                    i4 = this.srcIndex;
                    i5 = this.oldLength_;
                } else {
                    i4 = this.destIndex;
                    i5 = this.newLength_;
                }
                if (i < i4 + i5) {
                    return 0;
                }
                int i15 = this.remaining;
                if (i15 > 1) {
                    if (i < (i15 * i5) + i4) {
                        int i16 = (i - i4) / i5;
                        this.srcIndex = (this.oldLength_ * i16) + this.srcIndex;
                        int i17 = this.replIndex;
                        int i18 = this.newLength_;
                        this.replIndex = (i16 * i18) + i17;
                        this.destIndex = (i18 * i16) + this.destIndex;
                        this.remaining = i15 - i16;
                        return 0;
                    }
                    this.oldLength_ *= i15;
                    this.newLength_ *= i15;
                    this.remaining = 0;
                }
            }
            return 1;
        }

        private boolean next(boolean z) {
            char c;
            int i = this.dir;
            if (i > 0) {
                updateNextIndexes();
            } else {
                if (i < 0 && this.remaining > 0) {
                    this.index++;
                    this.dir = 1;
                    return true;
                }
                this.dir = 1;
            }
            int i2 = this.remaining;
            if (i2 >= 1) {
                if (i2 > 1) {
                    this.remaining = i2 - 1;
                    return true;
                }
                this.remaining = 0;
            }
            int i3 = this.index;
            if (i3 >= this.length) {
                return noNext();
            }
            char[] cArr = this.array;
            this.index = i3 + 1;
            char c2 = cArr[i3];
            if (c2 <= 4095) {
                this.changed = false;
                this.oldLength_ = c2 + 1;
                while (true) {
                    int i4 = this.index;
                    if (i4 >= this.length || (c2 = this.array[i4]) > 4095) {
                        break;
                    }
                    this.index = i4 + 1;
                    this.oldLength_ = c2 + 1 + this.oldLength_;
                }
                this.newLength_ = this.oldLength_;
                if (!z) {
                    return true;
                }
                updateNextIndexes();
                int i5 = this.index;
                if (i5 >= this.length) {
                    return noNext();
                }
                this.index = i5 + 1;
            }
            this.changed = true;
            if (c2 <= Edits.MAX_SHORT_CHANGE) {
                int i6 = c2 >> '\f';
                int i7 = (c2 >> '\t') & 7;
                int i8 = (c2 & 511) + 1;
                if (!this.coarse) {
                    this.oldLength_ = i6;
                    this.newLength_ = i7;
                    if (i8 > 1) {
                        this.remaining = i8;
                    }
                    return true;
                }
                this.oldLength_ = i6 * i8;
                this.newLength_ = i8 * i7;
            } else {
                this.oldLength_ = readLength((c2 >> 6) & 63);
                this.newLength_ = readLength(c2 & '?');
                if (!this.coarse) {
                    return true;
                }
            }
            while (true) {
                int i9 = this.index;
                if (i9 >= this.length || (c = this.array[i9]) <= 4095) {
                    break;
                }
                this.index = i9 + 1;
                int i10 = this.oldLength_;
                if (c <= Edits.MAX_SHORT_CHANGE) {
                    int i11 = (c & 511) + 1;
                    this.oldLength_ = ((c >> '\f') * i11) + i10;
                    this.newLength_ = (((c >> '\t') & 7) * i11) + this.newLength_;
                } else {
                    this.oldLength_ = i10 + readLength((c >> 6) & 63);
                    this.newLength_ += readLength(c & '?');
                }
            }
            return true;
        }

        private boolean noNext() {
            this.dir = 0;
            this.changed = false;
            this.newLength_ = 0;
            this.oldLength_ = 0;
            return false;
        }

        private boolean previous() {
            int i;
            int i2;
            char c;
            char c2;
            char c3;
            int i3 = this.dir;
            if (i3 >= 0) {
                if (i3 > 0) {
                    if (this.remaining > 0) {
                        this.index--;
                        this.dir = -1;
                        return true;
                    }
                    updateNextIndexes();
                }
                this.dir = -1;
            }
            int i4 = this.remaining;
            if (i4 > 0) {
                if (i4 <= (this.array[this.index] & 511)) {
                    this.remaining = i4 + 1;
                    updatePreviousIndexes();
                    return true;
                }
                this.remaining = 0;
            }
            int i5 = this.index;
            if (i5 <= 0) {
                return noNext();
            }
            char[] cArr = this.array;
            int i6 = i5 - 1;
            this.index = i6;
            char c4 = cArr[i6];
            if (c4 <= 4095) {
                this.changed = false;
                this.oldLength_ = c4 + 1;
                while (true) {
                    int i7 = this.index;
                    if (i7 <= 0 || (c3 = this.array[i7 - 1]) > 4095) {
                        break;
                    }
                    this.index = i7 - 1;
                    this.oldLength_ = c3 + 1 + this.oldLength_;
                }
                this.newLength_ = this.oldLength_;
                updatePreviousIndexes();
                return true;
            }
            this.changed = true;
            if (c4 <= Edits.MAX_SHORT_CHANGE) {
                int i8 = c4 >> '\f';
                int i9 = (c4 >> '\t') & 7;
                int i10 = (c4 & 511) + 1;
                if (!this.coarse) {
                    this.oldLength_ = i8;
                    this.newLength_ = i9;
                    if (i10 > 1) {
                        this.remaining = 1;
                    }
                    updatePreviousIndexes();
                    return true;
                }
                this.oldLength_ = i8 * i10;
                this.newLength_ = i10 * i9;
            } else {
                if (c4 <= 32767) {
                    this.oldLength_ = readLength((c4 >> 6) & 63);
                    this.newLength_ = readLength(c4 & '?');
                } else {
                    do {
                        char[] cArr2 = this.array;
                        i = this.index;
                        i2 = i - 1;
                        this.index = i2;
                        c = cArr2[i2];
                    } while (c > 32767);
                    this.index = i;
                    this.oldLength_ = readLength((c >> 6) & 63);
                    this.newLength_ = readLength(c & '?');
                    this.index = i2;
                }
                if (!this.coarse) {
                    updatePreviousIndexes();
                    return true;
                }
            }
            while (true) {
                int i11 = this.index;
                if (i11 <= 0 || (c2 = this.array[i11 - 1]) <= 4095) {
                    break;
                }
                int i12 = i11 - 1;
                this.index = i12;
                if (c2 <= Edits.MAX_SHORT_CHANGE) {
                    int i13 = (c2 & 511) + 1;
                    this.oldLength_ = ((c2 >> '\f') * i13) + this.oldLength_;
                    this.newLength_ = (((c2 >> '\t') & 7) * i13) + this.newLength_;
                } else if (c2 <= 32767) {
                    this.index = i11;
                    this.oldLength_ += readLength((c2 >> 6) & 63);
                    this.newLength_ += readLength(c2 & '?');
                    this.index = i12;
                }
            }
            updatePreviousIndexes();
            return true;
        }

        private int readLength(int i) {
            if (i < 61) {
                return i;
            }
            char[] cArr = this.array;
            if (i < 62) {
                int i2 = this.index;
                this.index = i2 + 1;
                return cArr[i2] & 32767;
            }
            int i3 = this.index;
            int i4 = ((i & 1) << 30) | ((cArr[i3] & 32767) << 15) | (cArr[i3 + 1] & 32767);
            this.index = i3 + 2;
            return i4;
        }

        private void updateNextIndexes() {
            this.srcIndex += this.oldLength_;
            if (this.changed) {
                this.replIndex += this.newLength_;
            }
            this.destIndex += this.newLength_;
        }

        private void updatePreviousIndexes() {
            this.srcIndex -= this.oldLength_;
            if (this.changed) {
                this.replIndex -= this.newLength_;
            }
            this.destIndex -= this.newLength_;
        }

        public int destinationIndex() {
            return this.destIndex;
        }

        public int destinationIndexFromSourceIndex(int i) {
            int i2;
            int iFindIndex = findIndex(i, true);
            if (iFindIndex < 0) {
                return 0;
            }
            if (iFindIndex > 0 || i == (i2 = this.srcIndex)) {
                return this.destIndex;
            }
            boolean z = this.changed;
            int i3 = this.destIndex;
            return z ? i3 + this.newLength_ : (i - i2) + i3;
        }

        public boolean findDestinationIndex(int i) {
            return findIndex(i, false) == 0;
        }

        public boolean findSourceIndex(int i) {
            return findIndex(i, true) == 0;
        }

        public boolean hasChange() {
            return this.changed;
        }

        public int newLength() {
            return this.newLength_;
        }

        public int oldLength() {
            return this.oldLength_;
        }

        public int replacementIndex() {
            return this.replIndex;
        }

        public int sourceIndex() {
            return this.srcIndex;
        }

        public int sourceIndexFromDestinationIndex(int i) {
            int i2;
            int iFindIndex = findIndex(i, false);
            if (iFindIndex < 0) {
                return 0;
            }
            if (iFindIndex > 0 || i == (i2 = this.destIndex)) {
                return this.srcIndex;
            }
            boolean z = this.changed;
            int i3 = this.srcIndex;
            return z ? i3 + this.oldLength_ : (i - i2) + i3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{ src[");
            sb.append(this.srcIndex);
            sb.append("..");
            sb.append(this.srcIndex + this.oldLength_);
            if (this.changed) {
                sb.append("] ⇝ dest[");
            } else {
                sb.append("] ≡ dest[");
            }
            sb.append(this.destIndex);
            sb.append("..");
            sb.append(this.destIndex + this.newLength_);
            if (this.changed) {
                sb.append("], repl[");
                sb.append(this.replIndex);
                sb.append("..");
                sb.append(this.replIndex + this.newLength_);
                sb.append("] }");
            } else {
                sb.append("] (no-change) }");
            }
            return sb.toString();
        }

        public /* synthetic */ Iterator(char[] cArr, int i, boolean z, boolean z2, int i2) {
            this(cArr, i, z, z2);
        }

        public boolean next() {
            return next(this.onlyChanges_);
        }
    }
}
