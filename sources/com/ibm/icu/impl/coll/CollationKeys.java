package com.ibm.icu.impl.coll;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationKeys {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CASE_LOWER_FIRST_COMMON_HIGH = 13;
    private static final int CASE_LOWER_FIRST_COMMON_LOW = 1;
    private static final int CASE_LOWER_FIRST_COMMON_MAX_COUNT = 7;
    private static final int CASE_LOWER_FIRST_COMMON_MIDDLE = 7;
    private static final int CASE_UPPER_FIRST_COMMON_HIGH = 15;
    private static final int CASE_UPPER_FIRST_COMMON_LOW = 3;
    private static final int CASE_UPPER_FIRST_COMMON_MAX_COUNT = 13;
    private static final int QUAT_COMMON_HIGH = 252;
    private static final int QUAT_COMMON_LOW = 28;
    private static final int QUAT_COMMON_MAX_COUNT = 113;
    private static final int QUAT_COMMON_MIDDLE = 140;
    private static final int QUAT_SHIFTED_LIMIT_BYTE = 27;
    static final int SEC_COMMON_HIGH = 69;
    private static final int SEC_COMMON_LOW = 5;
    private static final int SEC_COMMON_MAX_COUNT = 33;
    private static final int SEC_COMMON_MIDDLE = 37;
    private static final int TER_LOWER_FIRST_COMMON_HIGH = 69;
    private static final int TER_LOWER_FIRST_COMMON_LOW = 5;
    private static final int TER_LOWER_FIRST_COMMON_MAX_COUNT = 33;
    private static final int TER_LOWER_FIRST_COMMON_MIDDLE = 37;
    private static final int TER_ONLY_COMMON_HIGH = 197;
    private static final int TER_ONLY_COMMON_LOW = 5;
    private static final int TER_ONLY_COMMON_MAX_COUNT = 97;
    private static final int TER_ONLY_COMMON_MIDDLE = 101;
    private static final int TER_UPPER_FIRST_COMMON_HIGH = 197;
    private static final int TER_UPPER_FIRST_COMMON_LOW = 133;
    private static final int TER_UPPER_FIRST_COMMON_MAX_COUNT = 33;
    private static final int TER_UPPER_FIRST_COMMON_MIDDLE = 165;
    public static final LevelCallback SIMPLE_LEVEL_FALLBACK = new LevelCallback();
    private static final int[] levelMasks = {2, 6, 22, 54, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 54};

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LevelCallback {
        public boolean needToWrite(int i) {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SortKeyLevel {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int INITIAL_CAPACITY = 40;
        byte[] buffer = new byte[40];
        int len = 0;

        private boolean ensureCapacity(int i) {
            byte[] bArr = this.buffer;
            int length = bArr.length * 2;
            int i2 = this.len;
            int i3 = (i * 2) + i2;
            if (length < i3) {
                length = i3;
            }
            if (length < 200) {
                length = 200;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.buffer = bArr2;
            return true;
        }

        public void appendByte(int i) {
            if (this.len < this.buffer.length || ensureCapacity(1)) {
                byte[] bArr = this.buffer;
                int i2 = this.len;
                this.len = i2 + 1;
                bArr[i2] = (byte) i;
            }
        }

        public void appendReverseWeight16(int i) {
            byte b = (byte) (i >>> 8);
            byte b2 = (byte) i;
            int i2 = b2 == 0 ? 1 : 2;
            if (this.len + i2 <= this.buffer.length || ensureCapacity(i2)) {
                byte[] bArr = this.buffer;
                if (b2 == 0) {
                    int i3 = this.len;
                    this.len = i3 + 1;
                    bArr[i3] = b;
                } else {
                    int i4 = this.len;
                    bArr[i4] = b2;
                    bArr[i4 + 1] = b;
                    this.len = i4 + 2;
                }
            }
        }

        public void appendTo(SortKeyByteSink sortKeyByteSink) {
            sortKeyByteSink.Append(this.buffer, this.len - 1);
        }

        public void appendWeight16(int i) {
            byte b = (byte) (i >>> 8);
            byte b2 = (byte) i;
            int i2 = b2 == 0 ? 1 : 2;
            if (this.len + i2 <= this.buffer.length || ensureCapacity(i2)) {
                byte[] bArr = this.buffer;
                int i3 = this.len;
                int i4 = i3 + 1;
                this.len = i4;
                bArr[i3] = b;
                if (b2 != 0) {
                    this.len = i3 + 2;
                    bArr[i4] = b2;
                }
            }
        }

        public void appendWeight32(long j) {
            int i;
            byte[] bArr = {(byte) (j >>> 24), (byte) (j >>> 16), (byte) (j >>> 8), (byte) j};
            if (bArr[1] == 0) {
                i = 1;
            } else if (bArr[2] == 0) {
                i = 2;
            } else {
                i = bArr[3] == 0 ? 3 : 4;
            }
            if (this.len + i <= this.buffer.length || ensureCapacity(i)) {
                byte[] bArr2 = this.buffer;
                int i2 = this.len;
                int i3 = i2 + 1;
                this.len = i3;
                bArr2[i2] = bArr[0];
                byte b = bArr[1];
                if (b != 0) {
                    int i4 = i2 + 2;
                    this.len = i4;
                    bArr2[i3] = b;
                    byte b2 = bArr[2];
                    if (b2 != 0) {
                        int i5 = i2 + 3;
                        this.len = i5;
                        bArr2[i4] = b2;
                        byte b3 = bArr[3];
                        if (b3 != 0) {
                            this.len = i2 + 4;
                            bArr2[i5] = b3;
                        }
                    }
                }
            }
        }

        public byte[] data() {
            return this.buffer;
        }

        public byte getAt(int i) {
            return this.buffer[i];
        }

        public boolean isEmpty() {
            return this.len == 0;
        }

        public int length() {
            return this.len;
        }
    }

    private CollationKeys() {
    }

    private static SortKeyLevel getSortKeyLevel(int i, int i2) {
        if ((i & i2) != 0) {
            return new SortKeyLevel();
        }
        return null;
    }

    public static void writeSortKeyUpToQuaternary(CollationIterator collationIterator, boolean[] zArr, CollationSettings collationSettings, SortKeyByteSink sortKeyByteSink, int i, LevelCallback levelCallback, boolean z) {
        long jReorder;
        int i2;
        SortKeyLevel sortKeyLevel;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        collationSettings = collationSettings;
        int i10 = collationSettings.options;
        int i11 = levelMasks[CollationSettings.getStrength(i10)];
        if ((i10 & 1024) != 0) {
            i11 |= 8;
        }
        int i12 = 1;
        int i13 = i11 & (~((1 << i) - 1));
        if (i13 == 0) {
            return;
        }
        int i14 = i10 & 12;
        long j = i14 == 0 ? 0L : collationSettings.variableTop + 1;
        int tertiaryMask = CollationSettings.getTertiaryMask(i10);
        SortKeyLevel sortKeyLevel2 = getSortKeyLevel(i13, 8);
        SortKeyLevel sortKeyLevel3 = getSortKeyLevel(i13, 4);
        SortKeyLevel sortKeyLevel4 = getSortKeyLevel(i13, 16);
        SortKeyLevel sortKeyLevel5 = getSortKeyLevel(i13, 32);
        SortKeyLevel sortKeyLevel6 = sortKeyLevel4;
        long j2 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int length = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            collationIterator.clearCEsIfNoneRemaining();
            long jNextCE = collationIterator.nextCE();
            long j3 = jNextCE >>> 32;
            int i20 = i12;
            if (j3 >= j || j3 <= Collation.MERGE_SEPARATOR_PRIMARY) {
                i13 = i13;
                i14 = i14;
                j = j;
                jReorder = j3;
            } else {
                if (i16 != 0) {
                    int i21 = i16 - 1;
                    for (int i22 = 113; i21 >= i22; i22 = 113) {
                        sortKeyLevel5.appendByte(140);
                        i21 -= 113;
                    }
                    sortKeyLevel5.appendByte(i21 + 28);
                    i9 = 0;
                } else {
                    i9 = i16;
                }
                long jReorder2 = j3;
                while (true) {
                    if ((i13 & 32) != 0) {
                        if (collationSettings.hasReordering()) {
                            jReorder2 = collationSettings.reorder(jReorder2);
                        }
                        if ((((int) jReorder2) >>> 24) >= 27) {
                            sortKeyLevel5.appendByte(27);
                        }
                        sortKeyLevel5.appendWeight32(jReorder2);
                    }
                    do {
                        jNextCE = collationIterator.nextCE();
                        jReorder2 = jNextCE >>> 32;
                    } while (jReorder2 == 0);
                    if (jReorder2 >= j || jReorder2 <= Collation.MERGE_SEPARATOR_PRIMARY) {
                        break;
                    }
                    i14 = i14;
                    j = j;
                }
                jReorder = jReorder2;
                i16 = i9;
            }
            long j4 = jNextCE;
            if (jReorder > 1 && (i13 & 2) != 0) {
                boolean z2 = zArr[((int) jReorder) >>> 24];
                if (collationSettings.hasReordering()) {
                    jReorder = collationSettings.reorder(jReorder);
                }
                int i23 = (int) jReorder;
                int i24 = i23 >>> 24;
                long j5 = jReorder;
                if (!z2 || i24 != (((int) j2) >>> 24)) {
                    if (j2 != 0) {
                        if (j5 >= j2) {
                            sortKeyByteSink.Append(255);
                        } else if (i24 > 2) {
                            sortKeyByteSink.Append(3);
                        }
                    }
                    sortKeyByteSink.Append(i24);
                    j2 = z2 ? j5 : 0L;
                }
                byte b = (byte) (j5 >>> 16);
                if (b != 0) {
                    byte b2 = (byte) i23;
                    byte[] bArr = new byte[3];
                    bArr[0] = b;
                    bArr[i20] = (byte) (j5 >>> 8);
                    bArr[2] = b2;
                    sortKeyByteSink.Append(bArr, bArr[i20] == 0 ? i20 : bArr[2] == 0 ? 2 : 3);
                }
                if (!z && sortKeyByteSink.Overflowed()) {
                    return;
                } else {
                    jReorder = j5;
                }
            }
            int i25 = (int) j4;
            if (i25 == 0) {
                i12 = i20;
            } else {
                int i26 = i13 & 4;
                if (i26 == 0 || (i8 = i25 >>> 16) == 0) {
                    i26 = i26;
                } else if (i8 == 1280 && ((i10 & 2048) == 0 || jReorder != Collation.MERGE_SEPARATOR_PRIMARY)) {
                    i17++;
                    i26 = i26;
                } else if ((i10 & 2048) == 0) {
                    if (i17 != 0) {
                        int i27 = i17 - 1;
                        while (i27 >= 33) {
                            sortKeyLevel3.appendByte(37);
                            i27 -= 33;
                        }
                        sortKeyLevel3.appendByte(i8 < 1280 ? i27 + 5 : 69 - i27);
                        i17 = 0;
                    }
                    sortKeyLevel3.appendWeight16(i8);
                } else {
                    i26 = i26;
                    if (i17 != 0) {
                        int i28 = i17 - 1;
                        int i29 = i28 % 33;
                        sortKeyLevel3.appendByte(i15 < 1280 ? i29 + 5 : 69 - i29);
                        i17 = i28 - i29;
                        while (i17 > 0) {
                            sortKeyLevel3.appendByte(37);
                            i17 -= 33;
                        }
                    }
                    if (0 >= jReorder || jReorder > Collation.MERGE_SEPARATOR_PRIMARY) {
                        sortKeyLevel3.appendReverseWeight16(i8);
                        i15 = i8;
                    } else {
                        byte[] bArrData = sortKeyLevel3.data();
                        int length2 = sortKeyLevel3.length() - 1;
                        while (true) {
                            int i30 = length;
                            if (i30 >= length2) {
                                break;
                            }
                            byte b3 = bArrData[i30];
                            length = i30 + 1;
                            bArrData[i30] = bArrData[length2];
                            bArrData[length2] = b3;
                            length2--;
                        }
                        sortKeyLevel3.appendByte(jReorder == 1 ? i20 : 2);
                        length = sortKeyLevel3.length();
                        i15 = 0;
                    }
                }
                int i31 = i13 & 8;
                if (i31 != 0 && (CollationSettings.getStrength(i10) != 0 ? (i25 >>> 16) != 0 : jReorder != 0)) {
                    int i32 = i25 >>> 8;
                    int i33 = i32 & 255;
                    if ((i32 & 192) == 0) {
                        i7 = i20;
                        if (i33 > i7) {
                            i18++;
                        }
                    } else {
                        i7 = i20;
                    }
                    if ((i10 & 256) == 0) {
                        if (i18 != 0 && (i33 > i7 || !sortKeyLevel2.isEmpty())) {
                            int i34 = i18 - 1;
                            while (i34 >= 7) {
                                sortKeyLevel2.appendByte(112);
                                i34 -= 7;
                            }
                            sortKeyLevel2.appendByte((i33 <= 1 ? i34 + 1 : 13 - i34) << 4);
                            i18 = 0;
                        }
                        if (i33 > 1) {
                            i33 = ((i33 >>> 6) + 13) << 4;
                        }
                    } else {
                        if (i18 != 0) {
                            int i35 = i18 - 1;
                            while (i35 >= 13) {
                                sortKeyLevel2.appendByte(48);
                                i35 -= 13;
                            }
                            sortKeyLevel2.appendByte((i35 + 3) << 4);
                            i18 = 0;
                        }
                        if (i33 > 1) {
                            i33 = (3 - (i33 >>> 6)) << 4;
                        }
                    }
                    sortKeyLevel2.appendByte(i33);
                }
                int i36 = i13 & 16;
                if (i36 == 0) {
                    i2 = i31;
                    sortKeyLevel = sortKeyLevel6;
                } else {
                    int i37 = i25 & tertiaryMask;
                    if (i37 == 1280) {
                        i19++;
                        i2 = i31;
                        sortKeyLevel = sortKeyLevel6;
                    } else if ((32768 & tertiaryMask) == 0) {
                        if (i19 != 0) {
                            int i38 = i19 - 1;
                            while (i38 >= 97) {
                                sortKeyLevel6.appendByte(101);
                                i38 -= 97;
                                i31 = i31;
                            }
                            i2 = i31;
                            sortKeyLevel = sortKeyLevel6;
                            i6 = Collation.COMMON_WEIGHT16;
                            sortKeyLevel.appendByte(i37 < 1280 ? i38 + 5 : 197 - i38);
                            i19 = 0;
                        } else {
                            i2 = i31;
                            sortKeyLevel = sortKeyLevel6;
                            i6 = Collation.COMMON_WEIGHT16;
                        }
                        if (i37 > i6) {
                            i37 += Collation.CASE_MASK;
                        }
                        sortKeyLevel.appendWeight16(i37);
                    } else {
                        i2 = i31;
                        sortKeyLevel = sortKeyLevel6;
                        if ((i10 & 256) == 0) {
                            if (i19 != 0) {
                                int i39 = i19 - 1;
                                while (i39 >= 33) {
                                    sortKeyLevel.appendByte(37);
                                    i39 -= 33;
                                }
                                i5 = Collation.COMMON_WEIGHT16;
                                sortKeyLevel.appendByte(i37 < 1280 ? i39 + 5 : 69 - i39);
                                i19 = 0;
                            } else {
                                i5 = Collation.COMMON_WEIGHT16;
                            }
                            if (i37 > i5) {
                                i37 += 16384;
                            }
                            sortKeyLevel.appendWeight16(i37);
                        } else {
                            if (i37 > 256) {
                                if ((i25 >>> 16) != 0) {
                                    i37 ^= Collation.CASE_MASK;
                                    if (i37 < 50432) {
                                        i37 -= 16384;
                                    }
                                } else {
                                    i37 += 16384;
                                }
                            }
                            if (i19 != 0) {
                                int i40 = i19 - 1;
                                while (i40 >= 33) {
                                    sortKeyLevel.appendByte(165);
                                    i40 -= 33;
                                }
                                sortKeyLevel.appendByte(i37 < 34048 ? i40 + 133 : 197 - i40);
                                i19 = 0;
                            }
                            sortKeyLevel.appendWeight16(i37);
                        }
                    }
                }
                int i41 = i13 & 32;
                if (i41 != 0) {
                    int i42 = 65535 & i25;
                    if ((i25 & 192) == 0) {
                        i4 = 256;
                        if (i42 > 256) {
                            i16++;
                        }
                        i25 = i25;
                    } else {
                        i4 = 256;
                    }
                    if (i42 == i4 && i14 == 0 && sortKeyLevel5.isEmpty()) {
                        sortKeyLevel5.appendByte(1);
                        i25 = i25;
                    } else {
                        int i43 = i42 == i4 ? 1 : ((i42 >>> 6) & 3) + 252;
                        if (i16 != 0) {
                            int i44 = i16 - 1;
                            while (i44 >= 113) {
                                sortKeyLevel5.appendByte(140);
                                i44 -= 113;
                            }
                            sortKeyLevel5.appendByte(i43 < 28 ? i44 + 28 : 252 - i44);
                            i16 = 0;
                        }
                        sortKeyLevel5.appendByte(i43);
                    }
                } else {
                    i25 = i25;
                }
                if ((i25 >>> 24) == 1) {
                    if (i26 != 0) {
                        if (!levelCallback.needToWrite(2)) {
                            return;
                        }
                        sortKeyByteSink.Append(1);
                        sortKeyLevel3.appendTo(sortKeyByteSink);
                    }
                    if (i2 != 0) {
                        if (!levelCallback.needToWrite(3)) {
                            return;
                        }
                        sortKeyByteSink.Append(1);
                        int length3 = sortKeyLevel2.length() - 1;
                        byte b4 = 0;
                        for (int i45 = 0; i45 < length3; i45++) {
                            byte at = sortKeyLevel2.getAt(i45);
                            if (b4 == 0) {
                                b4 = at;
                            } else {
                                sortKeyByteSink.Append(b4 | ((at >> 4) & 15));
                                b4 = 0;
                            }
                        }
                        if (b4 != 0) {
                            sortKeyByteSink.Append(b4);
                        }
                    }
                    if (i36 == 0) {
                        i3 = 1;
                    } else {
                        if (!levelCallback.needToWrite(4)) {
                            return;
                        }
                        i3 = 1;
                        sortKeyByteSink.Append(1);
                        sortKeyLevel.appendTo(sortKeyByteSink);
                    }
                    if (i41 == 0 || !levelCallback.needToWrite(5)) {
                        return;
                    }
                    sortKeyByteSink.Append(i3);
                    sortKeyLevel5.appendTo(sortKeyByteSink);
                    return;
                }
                sortKeyLevel6 = sortKeyLevel;
                i12 = 1;
            }
            i14 = i14;
            j = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class SortKeyByteSink {
        private int appended_ = 0;
        protected byte[] buffer_;

        public SortKeyByteSink(byte[] bArr) {
            this.buffer_ = bArr;
        }

        public void Append(int i) {
            int i2 = this.appended_;
            if (i2 < this.buffer_.length || Resize(1, i2)) {
                this.buffer_[this.appended_] = (byte) i;
            }
            this.appended_++;
        }

        public abstract void AppendBeyondCapacity(byte[] bArr, int i, int i2, int i3);

        public int GetRemainingCapacity() {
            return this.buffer_.length - this.appended_;
        }

        public int NumberOfBytesAppended() {
            return this.appended_;
        }

        public boolean Overflowed() {
            return this.appended_ > this.buffer_.length;
        }

        public abstract boolean Resize(int i, int i2);

        public void setBufferAndAppended(byte[] bArr, int i) {
            this.buffer_ = bArr;
            this.appended_ = i;
        }

        public void Append(byte[] bArr, int i) {
            if (i <= 0 || bArr == null) {
                return;
            }
            int i2 = this.appended_;
            this.appended_ = i2 + i;
            byte[] bArr2 = this.buffer_;
            if (i <= bArr2.length - i2) {
                System.arraycopy(bArr, 0, bArr2, i2, i);
            } else {
                AppendBeyondCapacity(bArr, 0, i, i2);
            }
        }
    }
}
