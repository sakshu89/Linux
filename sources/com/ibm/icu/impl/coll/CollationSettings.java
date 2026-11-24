package com.ibm.icu.impl.coll;

import com.ibm.icu.text.DateTimePatternGenerator;
import defpackage.ky0;
import defpackage.og;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationSettings extends SharedObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ALTERNATE_MASK = 12;
    public static final int BACKWARD_SECONDARY = 2048;
    public static final int CASE_FIRST = 512;
    public static final int CASE_FIRST_AND_UPPER_MASK = 768;
    public static final int CASE_LEVEL = 1024;
    public static final int CHECK_FCD = 1;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    static final int MAX_VARIABLE_MASK = 112;
    static final int MAX_VARIABLE_SHIFT = 4;
    static final int MAX_VAR_CURRENCY = 3;
    static final int MAX_VAR_PUNCT = 1;
    static final int MAX_VAR_SPACE = 0;
    static final int MAX_VAR_SYMBOL = 2;
    public static final int NUMERIC = 2;
    static final int SHIFTED = 4;
    static final int STRENGTH_MASK = 61440;
    static final int STRENGTH_SHIFT = 12;
    static final int UPPER_FIRST = 256;
    long minHighNoReorder;
    long[] reorderRanges;
    public byte[] reorderTable;
    public long variableTop;
    public int options = 8208;
    public int[] reorderCodes = EMPTY_INT_ARRAY;
    public int fastLatinOptions = -1;
    public char[] fastLatinPrimaries = new char[CollationFastLatin.LATIN_LIMIT];

    public static int getTertiaryMask(int i) {
        if (isTertiaryWithCaseBits(i)) {
            return 65343;
        }
        return Collation.ONLY_TERTIARY_MASK;
    }

    public static boolean isTertiaryWithCaseBits(int i) {
        return (i & 1536) == 512;
    }

    private long reorderEx(long j) {
        if (j >= this.minHighNoReorder) {
            return j;
        }
        long j2 = 65535 | j;
        int i = 0;
        while (true) {
            long j3 = this.reorderRanges[i];
            if (j2 < j3) {
                return j + (((long) ((short) j3)) << 24);
            }
            i++;
        }
    }

    private static boolean reorderTableHasSplitBytes(byte[] bArr) {
        for (int i = 1; i < 256; i++) {
            if (bArr[i] == 0) {
                return true;
            }
        }
        return false;
    }

    private void setReorderArrays(int[] iArr, int[] iArr2, int i, int i2, byte[] bArr) {
        if (iArr == null) {
            iArr = EMPTY_INT_ARRAY;
        }
        this.reorderTable = bArr;
        this.reorderCodes = iArr;
        setReorderRanges(iArr2, i, i2);
    }

    private void setReorderRanges(int[] iArr, int i, int i2) {
        if (i2 == 0) {
            this.reorderRanges = null;
            return;
        }
        this.reorderRanges = new long[i2];
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            int i5 = i + 1;
            this.reorderRanges[i3] = ((long) iArr[i]) & 4294967295L;
            if (i4 >= i2) {
                return;
            }
            i3 = i4;
            i = i5;
        }
    }

    public static boolean sortsTertiaryUpperCaseFirst(int i) {
        return (i & 1792) == 768;
    }

    public void aliasReordering(CollationData collationData, int[] iArr, int i, byte[] bArr) {
        int[] iArrCopyOf = i == iArr.length ? iArr : Arrays.copyOf(iArr, i);
        int length = iArr.length;
        int i2 = length - i;
        if (bArr == null || (i2 != 0 ? i2 < 2 || (iArr[i] & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH) != 0 || (iArr[length - 1] & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH) == 0 : reorderTableHasSplitBytes(bArr))) {
            setReordering(collationData, iArrCopyOf);
            return;
        }
        this.reorderTable = bArr;
        this.reorderCodes = iArrCopyOf;
        while (i < length && (iArr[i] & 16711680) == 0) {
            i++;
        }
        if (i == length) {
            this.minHighNoReorder = 0L;
            this.reorderRanges = null;
        } else {
            this.minHighNoReorder = ((long) iArr[length - 1]) & Collation.MAX_PRIMARY;
            setReorderRanges(iArr, i, length - i);
        }
    }

    @Override // com.ibm.icu.impl.coll.SharedObject
    /* JADX INFO: renamed from: clone */
    public CollationSettings mo8clone() {
        CollationSettings collationSettings = (CollationSettings) super.mo8clone();
        collationSettings.fastLatinPrimaries = (char[]) this.fastLatinPrimaries.clone();
        return collationSettings;
    }

    public void copyReorderingFrom(CollationSettings collationSettings) {
        if (!collationSettings.hasReordering()) {
            resetReordering();
            return;
        }
        this.minHighNoReorder = collationSettings.minHighNoReorder;
        this.reorderTable = collationSettings.reorderTable;
        this.reorderRanges = collationSettings.reorderRanges;
        this.reorderCodes = collationSettings.reorderCodes;
    }

    public boolean dontCheckFCD() {
        return (this.options & 1) == 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !CollationSettings.class.equals(obj.getClass())) {
            return false;
        }
        CollationSettings collationSettings = (CollationSettings) obj;
        int i = this.options;
        if (i != collationSettings.options) {
            return false;
        }
        return ((i & 12) == 0 || this.variableTop == collationSettings.variableTop) && Arrays.equals(this.reorderCodes, collationSettings.reorderCodes);
    }

    public boolean getAlternateHandling() {
        return (this.options & 12) != 0;
    }

    public int getCaseFirst() {
        return this.options & 768;
    }

    public boolean getFlag(int i) {
        return (this.options & i) != 0;
    }

    public int getMaxVariable() {
        return (this.options & 112) >> 4;
    }

    public int getStrength() {
        return getStrength(this.options);
    }

    public boolean hasBackwardSecondary() {
        return (this.options & 2048) != 0;
    }

    public boolean hasReordering() {
        return this.reorderTable != null;
    }

    public int hashCode() {
        int i = this.options;
        int i2 = i << 8;
        if ((i & 12) != 0) {
            i2 = (int) (((long) i2) ^ this.variableTop);
        }
        int length = this.reorderCodes.length ^ i2;
        int i3 = 0;
        while (true) {
            int[] iArr = this.reorderCodes;
            if (i3 >= iArr.length) {
                return length;
            }
            length ^= iArr[i3] << i3;
            i3++;
        }
    }

    public boolean isNumeric() {
        return (this.options & 2) != 0;
    }

    public long reorder(long j) {
        byte b = this.reorderTable[((int) j) >>> 24];
        if (b == 0 && j > 1) {
            return reorderEx(j);
        }
        return (j & 16777215) | ((((long) b) & 255) << 24);
    }

    public void resetReordering() {
        this.reorderTable = null;
        this.minHighNoReorder = 0L;
        this.reorderRanges = null;
        this.reorderCodes = EMPTY_INT_ARRAY;
    }

    public void setAlternateHandlingDefault(int i) {
        this.options = (i & 12) | (this.options & (-13));
    }

    public void setAlternateHandlingShifted(boolean z) {
        int i = this.options & (-13);
        if (z) {
            this.options = i | 4;
        } else {
            this.options = i;
        }
    }

    public void setCaseFirst(int i) {
        this.options = i | (this.options & (-769));
    }

    public void setCaseFirstDefault(int i) {
        this.options = (i & 768) | (this.options & (-769));
    }

    public void setFlag(int i, boolean z) {
        int i2 = this.options;
        if (z) {
            this.options = i | i2;
        } else {
            this.options = (~i) & i2;
        }
    }

    public void setFlagDefault(int i, int i2) {
        this.options = (i & i2) | (this.options & (~i));
    }

    public void setMaxVariable(int i, int i2) {
        int i3 = this.options & (-113);
        if (i == -1) {
            this.options = (i2 & 112) | i3;
            return;
        }
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            this.options = (i << 4) | i3;
        } else {
            og.i(ky0.h(i, "illegal maxVariable value "));
        }
    }

    public void setReordering(CollationData collationData, int[] iArr) {
        int i;
        int i2;
        if (iArr.length == 0 || (iArr.length == 1 && iArr[0] == 103)) {
            resetReordering();
            return;
        }
        UVector32 uVector32 = new UVector32();
        collationData.makeReorderRanges(iArr, uVector32);
        int size = uVector32.size();
        if (size == 0) {
            resetReordering();
            return;
        }
        int[] buffer = uVector32.getBuffer();
        this.minHighNoReorder = ((long) buffer[size - 1]) & Collation.MAX_PRIMARY;
        byte[] bArr = new byte[256];
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = buffer[i5];
            int i7 = i6 >>> 24;
            while (i4 < i7) {
                bArr[i4] = (byte) (i4 + i6);
                i4++;
            }
            if ((i6 & 16711680) != 0) {
                bArr[i7] = 0;
                int i8 = i7 + 1;
                if (i3 < 0) {
                    i3 = i5;
                }
                i4 = i8;
            }
        }
        while (i4 <= 255) {
            bArr[i4] = (byte) i4;
            i4++;
        }
        if (i3 < 0) {
            i = 0;
            i2 = 0;
        } else {
            i = i3;
            i2 = size - i3;
        }
        setReorderArrays(iArr, buffer, i, i2, bArr);
    }

    public void setStrength(int i) {
        int i2 = this.options & (-61441);
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 15) {
            this.options = (i << 12) | i2;
        } else {
            og.i(ky0.h(i, "illegal strength value "));
        }
    }

    public void setStrengthDefault(int i) {
        this.options = (i & STRENGTH_MASK) | (this.options & (-61441));
    }

    public static int getStrength(int i) {
        return i >> 12;
    }
}
