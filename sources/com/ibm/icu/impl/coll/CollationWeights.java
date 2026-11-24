package com.ibm.icu.impl.coll;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationWeights {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int middleLength;
    private int rangeCount;
    private int rangeIndex;
    private int[] minBytes = new int[5];
    private int[] maxBytes = new int[5];
    private WeightRange[] ranges = new WeightRange[7];

    private boolean allocWeightsInMinLengthRanges(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.rangeCount) {
            WeightRange weightRange = this.ranges[i4];
            if (weightRange.length != i2) {
                break;
            }
            i5 += weightRange.count;
            i4++;
        }
        int iCountBytes = countBytes(i2 + 1);
        if (i > i5 * iCountBytes) {
            return false;
        }
        WeightRange weightRange2 = this.ranges[0];
        long j = weightRange2.start;
        long j2 = weightRange2.end;
        for (int i6 = 1; i6 < i4; i6++) {
            WeightRange weightRange3 = this.ranges[i6];
            long j3 = weightRange3.start;
            if (j3 < j) {
                j = j3;
            }
            long j4 = weightRange3.end;
            if (j4 > j2) {
                j2 = j4;
            }
        }
        int i7 = (i - i5) / (iCountBytes - 1);
        int i8 = i5 - i7;
        if (i7 == 0 || (iCountBytes * i7) + i8 < i) {
            i7++;
            i8--;
        }
        WeightRange weightRange4 = this.ranges[0];
        weightRange4.start = j;
        if (i8 == 0) {
            weightRange4.end = j2;
            weightRange4.count = i5;
            lengthenRange(weightRange4);
            this.rangeCount = 1;
            return true;
        }
        weightRange4.end = incWeightByOffset(j, i2, i8 - 1);
        WeightRange[] weightRangeArr = this.ranges;
        weightRangeArr[0].count = i8;
        if (weightRangeArr[1] == null) {
            weightRangeArr[1] = new WeightRange(i3);
        }
        WeightRange[] weightRangeArr2 = this.ranges;
        weightRangeArr2[1].start = incWeight(weightRangeArr2[0].end, i2);
        WeightRange weightRange5 = this.ranges[1];
        weightRange5.end = j2;
        weightRange5.length = i2;
        weightRange5.count = i7;
        lengthenRange(weightRange5);
        this.rangeCount = 2;
        return true;
    }

    private boolean allocWeightsInShortRanges(int i, int i2) {
        WeightRange[] weightRangeArr;
        WeightRange weightRange;
        int i3;
        for (int i4 = 0; i4 < this.rangeCount && (i3 = (weightRange = (weightRangeArr = this.ranges)[i4]).length) <= i2 + 1; i4++) {
            int i5 = weightRange.count;
            if (i <= i5) {
                if (i3 > i2) {
                    weightRange.count = i;
                }
                int i6 = i4 + 1;
                this.rangeCount = i6;
                if (i6 > 1) {
                    Arrays.sort(weightRangeArr, 0, i6);
                }
                return true;
            }
            i -= i5;
        }
        return false;
    }

    private int countBytes(int i) {
        return (this.maxBytes[i] - this.minBytes[i]) + 1;
    }

    private static long decWeightTrail(long j, int i) {
        return j - (1 << ((4 - i) * 8));
    }

    private static int getWeightByte(long j, int i) {
        return getWeightTrail(j, i);
    }

    private boolean getWeightRanges(long j, long j2) {
        int i;
        int i2;
        WeightRange weightRange;
        int iLengthOfWeight = lengthOfWeight(j);
        int iLengthOfWeight2 = lengthOfWeight(j2);
        int i3 = 0;
        if (j < j2 && (iLengthOfWeight >= iLengthOfWeight2 || j != truncateWeight(j2, iLengthOfWeight))) {
            WeightRange[] weightRangeArr = new WeightRange[5];
            WeightRange weightRange2 = new WeightRange(i3);
            WeightRange[] weightRangeArr2 = new WeightRange[5];
            while (true) {
                i = this.middleLength;
                if (iLengthOfWeight <= i) {
                    break;
                }
                int weightTrail = getWeightTrail(j, iLengthOfWeight);
                if (weightTrail < this.maxBytes[iLengthOfWeight]) {
                    WeightRange weightRange3 = new WeightRange(i3);
                    weightRangeArr[iLengthOfWeight] = weightRange3;
                    weightRange3.start = incWeightTrail(j, iLengthOfWeight);
                    weightRangeArr[iLengthOfWeight].end = setWeightTrail(j, iLengthOfWeight, this.maxBytes[iLengthOfWeight]);
                    WeightRange weightRange4 = weightRangeArr[iLengthOfWeight];
                    weightRange4.length = iLengthOfWeight;
                    weightRange4.count = this.maxBytes[iLengthOfWeight] - weightTrail;
                }
                j = truncateWeight(j, iLengthOfWeight - 1);
                iLengthOfWeight--;
            }
            if (j < 4278190080L) {
                weightRange2.start = incWeightTrail(j, i);
            } else {
                weightRange2.start = 4294967295L;
            }
            while (true) {
                i2 = this.middleLength;
                if (iLengthOfWeight2 <= i2) {
                    break;
                }
                int weightTrail2 = getWeightTrail(j2, iLengthOfWeight2);
                if (weightTrail2 > this.minBytes[iLengthOfWeight2]) {
                    WeightRange weightRange5 = new WeightRange(i3);
                    weightRangeArr2[iLengthOfWeight2] = weightRange5;
                    weightRange5.start = setWeightTrail(j2, iLengthOfWeight2, this.minBytes[iLengthOfWeight2]);
                    weightRangeArr2[iLengthOfWeight2].end = decWeightTrail(j2, iLengthOfWeight2);
                    WeightRange weightRange6 = weightRangeArr2[iLengthOfWeight2];
                    weightRange6.length = iLengthOfWeight2;
                    weightRange6.count = weightTrail2 - this.minBytes[iLengthOfWeight2];
                }
                j2 = truncateWeight(j2, iLengthOfWeight2 - 1);
                iLengthOfWeight2--;
            }
            long jDecWeightTrail = decWeightTrail(j2, i2);
            weightRange2.end = jDecWeightTrail;
            int i4 = this.middleLength;
            weightRange2.length = i4;
            long j3 = weightRange2.start;
            if (jDecWeightTrail >= j3) {
                weightRange2.count = ((int) ((jDecWeightTrail - j3) >> ((4 - i4) * 8))) + 1;
            } else {
                int i5 = 4;
                while (true) {
                    if (i5 > this.middleLength) {
                        WeightRange weightRange7 = weightRangeArr[i5];
                        if (weightRange7 != null && (weightRange = weightRangeArr2[i5]) != null && weightRange7.count > 0 && weightRange.count > 0) {
                            long j4 = weightRange7.end;
                            long j5 = weightRange.start;
                            if (j4 > j5) {
                                long j6 = weightRange.end;
                                weightRange7.end = j6;
                                weightRange7.count = (getWeightTrail(j6, i5) - getWeightTrail(weightRangeArr[i5].start, i5)) + 1;
                            } else if (j4 != j5 && incWeight(j4, i5) == j5) {
                                WeightRange weightRange8 = weightRangeArr[i5];
                                WeightRange weightRange9 = weightRangeArr2[i5];
                                weightRange8.end = weightRange9.end;
                                weightRange8.count += weightRange9.count;
                            }
                            weightRangeArr2[i5].count = 0;
                            while (true) {
                                i5--;
                                if (i5 <= this.middleLength) {
                                    break;
                                }
                                weightRangeArr2[i5] = null;
                                weightRangeArr[i5] = null;
                            }
                        }
                        i5--;
                    }
                }
            }
            this.rangeCount = 0;
            if (weightRange2.count > 0) {
                this.ranges[0] = weightRange2;
                this.rangeCount = 1;
            }
            for (int i6 = this.middleLength + 1; i6 <= 4; i6++) {
                WeightRange weightRange10 = weightRangeArr2[i6];
                if (weightRange10 != null && weightRange10.count > 0) {
                    WeightRange[] weightRangeArr3 = this.ranges;
                    int i7 = this.rangeCount;
                    this.rangeCount = i7 + 1;
                    weightRangeArr3[i7] = weightRange10;
                }
                WeightRange weightRange11 = weightRangeArr[i6];
                if (weightRange11 != null && weightRange11.count > 0) {
                    WeightRange[] weightRangeArr4 = this.ranges;
                    int i8 = this.rangeCount;
                    this.rangeCount = i8 + 1;
                    weightRangeArr4[i8] = weightRange11;
                }
            }
            if (this.rangeCount > 0) {
                return true;
            }
        }
        return false;
    }

    private static int getWeightTrail(long j, int i) {
        return ((int) (j >> ((4 - i) * 8))) & 255;
    }

    private long incWeight(long j, int i) {
        while (true) {
            int weightByte = getWeightByte(j, i);
            if (weightByte < this.maxBytes[i]) {
                return setWeightByte(j, i, weightByte + 1);
            }
            j = setWeightByte(j, i, this.minBytes[i]);
            i--;
        }
    }

    private long incWeightByOffset(long j, int i, int i2) {
        while (true) {
            int weightByte = i2 + getWeightByte(j, i);
            if (weightByte <= this.maxBytes[i]) {
                return setWeightByte(j, i, weightByte);
            }
            int i3 = this.minBytes[i];
            int i4 = weightByte - i3;
            j = setWeightByte(j, i, (i4 % countBytes(i)) + i3);
            i2 = i4 / countBytes(i);
            i--;
        }
    }

    private static long incWeightTrail(long j, int i) {
        return j + (1 << ((4 - i) * 8));
    }

    public static int lengthOfWeight(long j) {
        if ((16777215 & j) == 0) {
            return 1;
        }
        if ((65535 & j) == 0) {
            return 2;
        }
        return (j & 255) == 0 ? 3 : 4;
    }

    private void lengthenRange(WeightRange weightRange) {
        int i = weightRange.length + 1;
        weightRange.start = setWeightTrail(weightRange.start, i, this.minBytes[i]);
        weightRange.end = setWeightTrail(weightRange.end, i, this.maxBytes[i]);
        weightRange.count *= countBytes(i);
        weightRange.length = i;
    }

    private static long setWeightByte(long j, int i, int i2) {
        int i3 = i * 8;
        int i4 = 32 - i3;
        return (j & ((i3 < 32 ? 4294967295 >> i3 : 0L) | (CollationRootElements.PRIMARY_SENTINEL << i4))) | (((long) i2) << i4);
    }

    private static long setWeightTrail(long j, int i, int i2) {
        int i3 = (4 - i) * 8;
        return (j & (CollationRootElements.PRIMARY_SENTINEL << i3)) | (((long) i2) << i3);
    }

    private static long truncateWeight(long j, int i) {
        return j & (4294967295 << ((4 - i) * 8));
    }

    public boolean allocWeights(long j, long j2, int i) {
        if (!getWeightRanges(j, j2)) {
            return false;
        }
        while (true) {
            int i2 = this.ranges[0].length;
            if (allocWeightsInShortRanges(i, i2)) {
                break;
            }
            if (i2 == 4) {
                return false;
            }
            if (allocWeightsInMinLengthRanges(i, i2)) {
                break;
            }
            for (int i3 = 0; i3 < this.rangeCount; i3++) {
                WeightRange weightRange = this.ranges[i3];
                if (weightRange.length != i2) {
                    break;
                }
                lengthenRange(weightRange);
            }
        }
        this.rangeIndex = 0;
        int i4 = this.rangeCount;
        WeightRange[] weightRangeArr = this.ranges;
        if (i4 >= weightRangeArr.length) {
            return true;
        }
        weightRangeArr[i4] = null;
        return true;
    }

    public void initForPrimary(boolean z) {
        this.middleLength = 1;
        int[] iArr = this.minBytes;
        iArr[1] = 3;
        int[] iArr2 = this.maxBytes;
        iArr2[1] = 255;
        if (z) {
            iArr[2] = 4;
            iArr2[2] = 254;
        } else {
            iArr[2] = 2;
            iArr2[2] = 255;
        }
        iArr[3] = 2;
        iArr2[3] = 255;
        iArr[4] = 2;
        iArr2[4] = 255;
    }

    public void initForSecondary() {
        this.middleLength = 3;
        int[] iArr = this.minBytes;
        iArr[1] = 0;
        int[] iArr2 = this.maxBytes;
        iArr2[1] = 0;
        iArr[2] = 0;
        iArr2[2] = 0;
        iArr[3] = 2;
        iArr2[3] = 255;
        iArr[4] = 2;
        iArr2[4] = 255;
    }

    public void initForTertiary() {
        this.middleLength = 3;
        int[] iArr = this.minBytes;
        iArr[1] = 0;
        int[] iArr2 = this.maxBytes;
        iArr2[1] = 0;
        iArr[2] = 0;
        iArr2[2] = 0;
        iArr[3] = 2;
        iArr2[3] = 63;
        iArr[4] = 2;
        iArr2[4] = 63;
    }

    public long nextWeight() {
        int i = this.rangeIndex;
        if (i >= this.rangeCount) {
            return 4294967295L;
        }
        WeightRange weightRange = this.ranges[i];
        long j = weightRange.start;
        int i2 = weightRange.count - 1;
        weightRange.count = i2;
        if (i2 == 0) {
            this.rangeIndex = i + 1;
            return j;
        }
        weightRange.start = incWeight(j, weightRange.length);
        return j;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class WeightRange implements Comparable<WeightRange> {
        int count;
        long end;
        int length;
        long start;

        public /* synthetic */ WeightRange(int i) {
            this();
        }

        @Override // java.lang.Comparable
        public int compareTo(WeightRange weightRange) {
            long j = this.start;
            long j2 = weightRange.start;
            if (j < j2) {
                return -1;
            }
            return j > j2 ? 1 : 0;
        }

        private WeightRange() {
        }
    }
}
