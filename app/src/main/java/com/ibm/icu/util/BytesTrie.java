package com.ibm.icu.util;

import com.ibm.icu.lang.UCharacterEnums;
import defpackage.dk0;
import defpackage.kf2;
import defpackage.og;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class BytesTrie implements Cloneable, Iterable<Entry> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int kFiveByteDeltaLead = 255;
    static final int kFiveByteValueLead = 127;
    static final int kFourByteDeltaLead = 254;
    static final int kFourByteValueLead = 126;
    static final int kMaxBranchLinearSubNodeLength = 5;
    static final int kMaxLinearMatchLength = 16;
    static final int kMaxOneByteDelta = 191;
    static final int kMaxOneByteValue = 64;
    static final int kMaxThreeByteDelta = 917503;
    static final int kMaxThreeByteValue = 1179647;
    static final int kMaxTwoByteDelta = 12287;
    static final int kMaxTwoByteValue = 6911;
    static final int kMinLinearMatch = 16;
    static final int kMinOneByteValueLead = 16;
    static final int kMinThreeByteDeltaLead = 240;
    static final int kMinThreeByteValueLead = 108;
    static final int kMinTwoByteDeltaLead = 192;
    static final int kMinTwoByteValueLead = 81;
    static final int kMinValueLead = 32;
    private static final int kValueIsFinal = 1;
    private static Result[] valueResults_ = {Result.INTERMEDIATE_VALUE, Result.FINAL_VALUE};
    private byte[] bytes_;
    private int pos_;
    private int remainingMatchLength_;
    private int root_;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Result {
        NO_MATCH,
        NO_VALUE,
        FINAL_VALUE,
        INTERMEDIATE_VALUE;

        public boolean hasNext() {
            return (ordinal() & 1) != 0;
        }

        public boolean hasValue() {
            return ordinal() >= 2;
        }

        public boolean matches() {
            return this != NO_MATCH;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class State {
        private byte[] bytes;
        private int pos;
        private int remainingMatchLength;
        private int root;
    }

    public BytesTrie(BytesTrie bytesTrie) {
        this.bytes_ = bytesTrie.bytes_;
        this.root_ = bytesTrie.root_;
        this.pos_ = bytesTrie.pos_;
        this.remainingMatchLength_ = bytesTrie.remainingMatchLength_;
    }

    public static /* bridge */ /* synthetic */ int a(int i, byte[] bArr, int i2) {
        return readValue(bArr, i, i2);
    }

    private static void append(Appendable appendable, int i) {
        try {
            appendable.append((char) i);
        } catch (IOException e) {
            kf2.h(e);
        }
    }

    private Result branchNext(int i, int i2, int i3) {
        int i4;
        Result result;
        if (i2 == 0) {
            i2 = this.bytes_[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            i++;
        }
        int i5 = i2 + 1;
        while (i5 > 5) {
            byte[] bArr = this.bytes_;
            int i6 = i + 1;
            if (i3 < (bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED)) {
                i5 >>= 1;
                i = jumpByDelta(bArr, i6);
            } else {
                i5 -= i5 >> 1;
                i = skipDelta(bArr, i6);
            }
        }
        do {
            byte[] bArr2 = this.bytes_;
            int i7 = i + 1;
            if (i3 == (bArr2[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED)) {
                byte b = bArr2[i7];
                int i8 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                if ((b & 1) != 0) {
                    result = Result.FINAL_VALUE;
                } else {
                    int i9 = i + 2;
                    int i10 = i8 >> 1;
                    if (i10 < 81) {
                        i4 = i10 - 16;
                    } else if (i10 < 108) {
                        i4 = ((i10 - 81) << 8) | (bArr2[i9] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
                        i9 = i + 3;
                    } else if (i10 < 126) {
                        i4 = (bArr2[i + 3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | ((bArr2[i9] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8) | ((i10 - 108) << 16);
                        i9 = i + 4;
                    } else if (i10 == 126) {
                        i4 = (bArr2[i + 4] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | ((bArr2[i9] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 16) | ((bArr2[i + 3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8);
                        i9 = i + 5;
                    } else {
                        i4 = (bArr2[i + 5] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | (bArr2[i9] << UCharacterEnums.ECharacterCategory.MATH_SYMBOL) | ((bArr2[i + 3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 16) | ((bArr2[i + 4] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8);
                        i9 = i + 6;
                    }
                    i7 = i9 + i4;
                    byte b2 = bArr2[i7];
                    result = (b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) >= 32 ? valueResults_[b2 & 1] : Result.NO_VALUE;
                }
                this.pos_ = i7;
                return result;
            }
            i5--;
            i = skipValue(bArr2, i7);
        } while (i5 > 1);
        byte[] bArr3 = this.bytes_;
        int i11 = i + 1;
        if (i3 != (bArr3[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED)) {
            stop();
            return Result.NO_MATCH;
        }
        this.pos_ = i11;
        byte b3 = bArr3[i11];
        return (b3 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) >= 32 ? valueResults_[b3 & 1] : Result.NO_VALUE;
    }

    private static long findUniqueValue(byte[] bArr, int i, long j) {
        while (true) {
            int i2 = i + 1;
            int i3 = bArr[i];
            int i4 = i3 & 255;
            if (i4 < 16) {
                if (i4 == 0) {
                    i4 = bArr[i2] & 255;
                    i2 = i + 2;
                }
                long jFindUniqueValueFromBranch = findUniqueValueFromBranch(bArr, i2, i4 + 1, j);
                if (jFindUniqueValueFromBranch == 0) {
                    return 0L;
                }
                i = (int) (jFindUniqueValueFromBranch >>> 33);
                j = jFindUniqueValueFromBranch;
            } else if (i4 < 32) {
                i = (i4 - 15) + i2;
            } else {
                boolean z = (i3 & 1) != 0;
                int value = readValue(bArr, i2, i4 >> 1);
                if (j == 0) {
                    j = (((long) value) << 1) | 1;
                } else if (value != ((int) (j >> 1))) {
                    return 0L;
                }
                if (z) {
                    return j;
                }
                i = skipValue(i2, i4);
            }
        }
    }

    private static long findUniqueValueFromBranch(byte[] bArr, int i, int i2, long j) {
        while (i2 > 5) {
            int i3 = i + 1;
            int i4 = i2 >> 1;
            j = findUniqueValueFromBranch(bArr, jumpByDelta(bArr, i3), i4, j);
            if (j == 0) {
                return 0L;
            }
            i2 -= i4;
            i = skipDelta(bArr, i3);
        }
        do {
            int i5 = i + 1;
            int i6 = i + 2;
            byte b = bArr[i5];
            int i7 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            boolean z = (b & 1) != 0;
            int value = readValue(bArr, i6, i7 >> 1);
            i = skipValue(i6, i7);
            if (!z) {
                j = findUniqueValue(bArr, value + i, j);
                if (j == 0) {
                    return 0L;
                }
            } else if (j == 0) {
                j = (((long) value) << 1) | 1;
            } else if (value != ((int) (j >> 1))) {
                return 0L;
            }
            i2--;
        } while (i2 > 1);
        return (((long) (i + 1)) << 33) | (j & 8589934591L);
    }

    private static void getNextBranchBytes(byte[] bArr, int i, int i2, Appendable appendable) {
        while (i2 > 5) {
            int i3 = i + 1;
            int i4 = i2 >> 1;
            getNextBranchBytes(bArr, jumpByDelta(bArr, i3), i4, appendable);
            i2 -= i4;
            i = skipDelta(bArr, i3);
        }
        do {
            append(appendable, bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
            i = skipValue(bArr, i + 1);
            i2--;
        } while (i2 > 1);
        append(appendable, bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
    }

    @Deprecated
    public static int jumpByDelta(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        if (i3 >= 192) {
            if (i3 < 240) {
                i3 = ((i3 - 192) << 8) | (bArr[i2] & 255);
                i2 = i + 2;
            } else if (i3 < 254) {
                i3 = ((bArr[i2] & 255) << 8) | ((i3 - 240) << 16) | (bArr[i + 2] & 255);
                i2 = i + 3;
            } else if (i3 == 254) {
                i3 = ((bArr[i2] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
                i2 = i + 4;
            } else {
                i3 = (bArr[i2] << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 8) | (bArr[i + 4] & 255);
                i2 = i + 5;
            }
        }
        return i2 + i3;
    }

    private Result nextImpl(int i, int i2) {
        while (true) {
            byte[] bArr = this.bytes_;
            int i3 = i + 1;
            byte b = bArr[i];
            int i4 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            if (i4 < 16) {
                return branchNext(i3, i4, i2);
            }
            if (i4 < 32) {
                int i5 = i + 2;
                if (i2 != (bArr[i3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED)) {
                    break;
                }
                int i6 = i4 - 17;
                this.remainingMatchLength_ = i6;
                this.pos_ = i5;
                if (i6 < 0) {
                    byte b2 = bArr[i5];
                    if ((b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) >= 32) {
                        return valueResults_[b2 & 1];
                    }
                }
                return Result.NO_VALUE;
            }
            if ((b & 1) != 0) {
                break;
            }
            i = skipValue(i3, i4);
        }
        stop();
        return Result.NO_MATCH;
    }

    private static int readValue(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        if (i2 < 81) {
            return i2 - 16;
        }
        if (i2 < 108) {
            i3 = (i2 - 81) << 8;
            i4 = bArr[i];
        } else if (i2 < 126) {
            i3 = ((i2 - 108) << 16) | ((bArr[i] & 255) << 8);
            i4 = bArr[i + 1];
        } else if (i2 == 126) {
            i3 = ((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
            i4 = bArr[i + 2];
        } else {
            i3 = (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            i4 = bArr[i + 3];
        }
        return (i4 & 255) | i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int skipDelta(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = bArr[i];
        int i4 = i3 & 255;
        if (i4 < 192) {
            return i2;
        }
        if (i4 < 240) {
            return i + 2;
        }
        return i4 < 254 ? i + 3 : (i3 & 1) + 3 + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int skipValue(int i, int i2) {
        if (i2 < 162) {
            return i;
        }
        if (i2 < 216) {
            return i + 1;
        }
        return i2 < 252 ? i + 2 : ((i2 >> 1) & 1) + 3 + i;
    }

    private void stop() {
        this.pos_ = -1;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BytesTrie m21clone() {
        return (BytesTrie) super.clone();
    }

    public Result current() {
        int i = this.pos_;
        if (i < 0) {
            return Result.NO_MATCH;
        }
        if (this.remainingMatchLength_ < 0) {
            byte b = this.bytes_[i];
            if ((b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) >= 32) {
                return valueResults_[b & 1];
            }
        }
        return Result.NO_VALUE;
    }

    public Result first(int i) {
        this.remainingMatchLength_ = -1;
        if (i < 0) {
            i += 256;
        }
        return nextImpl(this.root_, i);
    }

    public int getNextBytes(Appendable appendable) {
        int i = this.pos_;
        if (i < 0) {
            return 0;
        }
        int i2 = this.remainingMatchLength_;
        byte[] bArr = this.bytes_;
        if (i2 >= 0) {
            append(appendable, bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
            return 1;
        }
        int i3 = i + 1;
        byte b = bArr[i];
        int i4 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        if (i4 >= 32) {
            if ((b & 1) != 0) {
                return 0;
            }
            int iSkipValue = skipValue(i3, i4);
            i3 = iSkipValue + 1;
            i4 = this.bytes_[iSkipValue] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        }
        if (i4 >= 16) {
            append(appendable, this.bytes_[i3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
            return 1;
        }
        if (i4 == 0) {
            i4 = this.bytes_[i3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            i3++;
        }
        int i5 = i4 + 1;
        getNextBranchBytes(this.bytes_, i3, i5, appendable);
        return i5;
    }

    public long getState64() {
        return (((long) this.remainingMatchLength_) << 32) | ((long) this.pos_);
    }

    public long getUniqueValue() {
        int i = this.pos_;
        if (i < 0) {
            return 0L;
        }
        return (findUniqueValue(this.bytes_, (i + this.remainingMatchLength_) + 1, 0L) << 31) >> 31;
    }

    public int getValue() {
        int i = this.pos_;
        byte[] bArr = this.bytes_;
        return readValue(bArr, i + 1, (bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) >> 1);
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public java.util.Iterator<Entry> iterator2() {
        return new Iterator(this.bytes_, this.pos_, this.remainingMatchLength_, 0, 0);
    }

    public Result next(byte[] bArr, int i, int i2) {
        if (i >= i2) {
            return current();
        }
        int iSkipValue = this.pos_;
        if (iSkipValue < 0) {
            return Result.NO_MATCH;
        }
        int i3 = this.remainingMatchLength_;
        while (i != i2) {
            int i4 = i + 1;
            byte b = bArr[i];
            if (i3 < 0) {
                this.remainingMatchLength_ = i3;
                while (true) {
                    byte[] bArr2 = this.bytes_;
                    int i5 = iSkipValue + 1;
                    byte b2 = bArr2[iSkipValue];
                    int i6 = b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                    if (i6 < 16) {
                        Result resultBranchNext = branchNext(i5, i6, b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
                        Result result = Result.NO_MATCH;
                        if (resultBranchNext == result) {
                            return result;
                        }
                        if (i4 == i2) {
                            return resultBranchNext;
                        }
                        if (resultBranchNext == Result.FINAL_VALUE) {
                            stop();
                            return result;
                        }
                        byte b3 = bArr[i4];
                        i4++;
                        b = b3;
                        iSkipValue = this.pos_;
                    } else {
                        if (i6 < 32) {
                            if (b == bArr2[i5]) {
                                iSkipValue += 2;
                                i3 = i6 - 17;
                                break;
                            }
                            stop();
                            return Result.NO_MATCH;
                        }
                        if ((b2 & 1) != 0) {
                            stop();
                            return Result.NO_MATCH;
                        }
                        iSkipValue = skipValue(i5, i6);
                    }
                }
            } else {
                if (b != this.bytes_[iSkipValue]) {
                    stop();
                    return Result.NO_MATCH;
                }
                iSkipValue++;
                i3--;
            }
            i = i4;
        }
        this.remainingMatchLength_ = i3;
        this.pos_ = iSkipValue;
        if (i3 < 0) {
            byte b4 = this.bytes_[iSkipValue];
            if ((b4 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) >= 32) {
                return valueResults_[b4 & 1];
            }
        }
        return Result.NO_VALUE;
    }

    public BytesTrie reset() {
        this.pos_ = this.root_;
        this.remainingMatchLength_ = -1;
        return this;
    }

    public BytesTrie resetToState(State state) {
        if (this.bytes_ != state.bytes || this.bytes_ == null || this.root_ != state.root) {
            og.i("incompatible trie state");
            return null;
        }
        this.pos_ = state.pos;
        this.remainingMatchLength_ = state.remainingMatchLength;
        return this;
    }

    public BytesTrie resetToState64(long j) {
        this.remainingMatchLength_ = (int) (j >> 32);
        this.pos_ = (int) j;
        return this;
    }

    public BytesTrie saveState(State state) {
        state.bytes = this.bytes_;
        state.root = this.root_;
        state.pos = this.pos_;
        state.remainingMatchLength = this.remainingMatchLength_;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Entry {
        private byte[] bytes;
        private int length;
        public int value;

        private Entry(int i) {
            this.bytes = new byte[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void append(byte[] bArr, int i, int i2) {
            ensureCapacity(this.length + i2);
            System.arraycopy(bArr, i, this.bytes, this.length, i2);
            this.length += i2;
        }

        private void ensureCapacity(int i) {
            byte[] bArr = this.bytes;
            if (bArr.length < i) {
                byte[] bArr2 = new byte[Math.min(bArr.length * 2, i * 2)];
                System.arraycopy(this.bytes, 0, bArr2, 0, this.length);
                this.bytes = bArr2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void truncateString(int i) {
            this.length = i;
        }

        public byte byteAt(int i) {
            return this.bytes[i];
        }

        public ByteBuffer bytesAsByteBuffer() {
            return ByteBuffer.wrap(this.bytes, 0, this.length).asReadOnlyBuffer();
        }

        public int bytesLength() {
            return this.length;
        }

        public void copyBytesTo(byte[] bArr, int i) {
            System.arraycopy(this.bytes, 0, bArr, i, this.length);
        }

        public /* synthetic */ Entry(int i, int i2) {
            this(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void append(byte b) {
            ensureCapacity(this.length + 1);
            byte[] bArr = this.bytes;
            int i = this.length;
            this.length = i + 1;
            bArr[i] = b;
        }
    }

    public Iterator iterator(int i) {
        return new Iterator(this.bytes_, this.pos_, this.remainingMatchLength_, i, 0);
    }

    public static Iterator iterator(byte[] bArr, int i, int i2) {
        return new Iterator(bArr, i, -1, i2, 0);
    }

    public BytesTrie(byte[] bArr, int i) {
        this.bytes_ = bArr;
        this.root_ = i;
        this.pos_ = i;
        this.remainingMatchLength_ = -1;
    }

    private static int skipValue(byte[] bArr, int i) {
        return skipValue(i + 1, bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Iterator implements java.util.Iterator<Entry> {
        private byte[] bytes_;
        private Entry entry_;
        private int initialPos_;
        private int initialRemainingMatchLength_;
        private int maxLength_;
        private int pos_;
        private int remainingMatchLength_;
        private ArrayList<Long> stack_;

        private Iterator(byte[] bArr, int i, int i2, int i3) {
            this.stack_ = new ArrayList<>();
            this.bytes_ = bArr;
            this.initialPos_ = i;
            this.pos_ = i;
            this.initialRemainingMatchLength_ = i2;
            this.remainingMatchLength_ = i2;
            this.maxLength_ = i3;
            Entry entry = new Entry(i3 == 0 ? 32 : i3, 0);
            this.entry_ = entry;
            int i4 = this.remainingMatchLength_;
            if (i4 >= 0) {
                int i5 = i4 + 1;
                int i6 = this.maxLength_;
                if (i6 > 0 && i5 > i6) {
                    i5 = i6;
                }
                entry.append(this.bytes_, this.pos_, i5);
                this.pos_ += i5;
                this.remainingMatchLength_ -= i5;
            }
        }

        private int branchNext(int i, int i2) {
            while (i2 > 5) {
                int i3 = i + 1;
                int i4 = i2 >> 1;
                this.stack_.add(Long.valueOf((((long) BytesTrie.skipDelta(this.bytes_, i3)) << 32) | ((long) ((i2 - i4) << 16)) | ((long) this.entry_.length)));
                i = BytesTrie.jumpByDelta(this.bytes_, i3);
                i2 = i4;
            }
            byte[] bArr = this.bytes_;
            int i5 = i + 1;
            byte b = bArr[i];
            int i6 = i + 2;
            byte b2 = bArr[i5];
            int i7 = b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            boolean z = (b2 & 1) != 0;
            int iA = BytesTrie.a(i6, bArr, i7 >> 1);
            int iSkipValue = BytesTrie.skipValue(i6, i7);
            this.stack_.add(Long.valueOf((((long) iSkipValue) << 32) | ((long) ((i2 - 1) << 16)) | ((long) this.entry_.length)));
            this.entry_.append(b);
            if (!z) {
                return iSkipValue + iA;
            }
            this.pos_ = -1;
            this.entry_.value = iA;
            return -1;
        }

        private Entry truncateAndStop() {
            this.pos_ = -1;
            Entry entry = this.entry_;
            entry.value = -1;
            return entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos_ >= 0 || !this.stack_.isEmpty();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Entry next() {
            int iBranchNext = this.pos_;
            if (iBranchNext < 0) {
                if (this.stack_.isEmpty()) {
                    dk0.d();
                    return null;
                }
                ArrayList<Long> arrayList = this.stack_;
                long jLongValue = arrayList.remove(arrayList.size() - 1).longValue();
                int i = (int) jLongValue;
                int i2 = (int) (jLongValue >> 32);
                this.entry_.truncateString(65535 & i);
                int i3 = i >>> 16;
                if (i3 > 1) {
                    iBranchNext = branchNext(i2, i3);
                    if (iBranchNext < 0) {
                        return this.entry_;
                    }
                } else {
                    this.entry_.append(this.bytes_[i2]);
                    iBranchNext = i2 + 1;
                }
            }
            if (this.remainingMatchLength_ >= 0) {
                return truncateAndStop();
            }
            while (true) {
                byte[] bArr = this.bytes_;
                int i4 = iBranchNext + 1;
                byte b = bArr[iBranchNext];
                int i5 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                if (i5 >= 32) {
                    boolean z = (b & 1) != 0;
                    this.entry_.value = BytesTrie.a(i4, bArr, i5 >> 1);
                    if (z || (this.maxLength_ > 0 && this.entry_.length == this.maxLength_)) {
                        this.pos_ = -1;
                    } else {
                        this.pos_ = BytesTrie.skipValue(i4, i5);
                    }
                    return this.entry_;
                }
                if (this.maxLength_ > 0 && this.entry_.length == this.maxLength_) {
                    return truncateAndStop();
                }
                if (i5 < 16) {
                    if (i5 == 0) {
                        i5 = this.bytes_[i4] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                        i4 = iBranchNext + 2;
                    }
                    iBranchNext = branchNext(i4, i5 + 1);
                    if (iBranchNext < 0) {
                        return this.entry_;
                    }
                } else {
                    int i6 = i5 - 15;
                    if (this.maxLength_ > 0) {
                        int i7 = this.entry_.length + i6;
                        int i8 = this.maxLength_;
                        if (i7 > i8) {
                            Entry entry = this.entry_;
                            entry.append(this.bytes_, i4, i8 - entry.length);
                            return truncateAndStop();
                        }
                    }
                    this.entry_.append(this.bytes_, i4, i6);
                    iBranchNext = i4 + i6;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Iterator reset() {
            this.pos_ = this.initialPos_;
            int i = this.initialRemainingMatchLength_;
            this.remainingMatchLength_ = i;
            int i2 = i + 1;
            int i3 = this.maxLength_;
            if (i3 > 0 && i2 > i3) {
                i2 = i3;
            }
            this.entry_.truncateString(i2);
            this.pos_ += i2;
            this.remainingMatchLength_ -= i2;
            this.stack_.clear();
            return this;
        }

        public /* synthetic */ Iterator(byte[] bArr, int i, int i2, int i3, int i4) {
            this(bArr, i, i2, i3);
        }
    }

    public Result next(int i) {
        int i2 = this.pos_;
        if (i2 < 0) {
            return Result.NO_MATCH;
        }
        if (i < 0) {
            i += 256;
        }
        int i3 = this.remainingMatchLength_;
        if (i3 >= 0) {
            byte[] bArr = this.bytes_;
            int i4 = i2 + 1;
            if (i == (bArr[i2] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED)) {
                int i5 = i3 - 1;
                this.remainingMatchLength_ = i5;
                this.pos_ = i4;
                if (i5 < 0) {
                    byte b = bArr[i4];
                    if ((b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) >= 32) {
                        return valueResults_[b & 1];
                    }
                }
                return Result.NO_VALUE;
            }
            stop();
            return Result.NO_MATCH;
        }
        return nextImpl(i2, i);
    }
}
