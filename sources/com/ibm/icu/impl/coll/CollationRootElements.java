package com.ibm.icu.impl.coll;

import com.ibm.icu.text.DateTimePatternGenerator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationRootElements {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int IX_COMMON_SEC_AND_TER_CE = 3;
    static final int IX_COUNT = 5;
    static final int IX_FIRST_PRIMARY_INDEX = 2;
    static final int IX_FIRST_SECONDARY_INDEX = 1;
    public static final int IX_FIRST_TERTIARY_INDEX = 0;
    static final int IX_SEC_TER_BOUNDARIES = 4;
    public static final long PRIMARY_SENTINEL = 4294967040L;
    public static final int PRIMARY_STEP_MASK = 127;
    public static final int SEC_TER_DELTA_FLAG = 128;
    private long[] elements;

    public CollationRootElements(long[] jArr) {
        this.elements = jArr;
    }

    private int findP(long j) {
        long[] jArr = this.elements;
        int i = (int) jArr[2];
        int length = jArr.length - 1;
        while (i + 1 < length) {
            int i2 = (int) ((((long) i) + ((long) length)) / 2);
            long j2 = this.elements[i2];
            if ((j2 & 128) != 0) {
                int i3 = i2 + 1;
                while (i3 != length) {
                    long j3 = this.elements[i3];
                    if ((j3 & 128) == 0) {
                        i2 = i3;
                        j2 = j3;
                        break;
                    }
                    i3++;
                    j2 = j3;
                }
                if ((j2 & 128) != 0) {
                    int i4 = i2 - 1;
                    while (i4 != i) {
                        long j4 = this.elements[i4];
                        if ((j4 & 128) == 0) {
                            i2 = i4;
                            j2 = j4;
                            break;
                        }
                        i4--;
                        j2 = j4;
                    }
                    if ((128 & j2) != 0) {
                        break;
                    }
                }
            }
            if (j < (j2 & PRIMARY_SENTINEL)) {
                length = i2;
            } else {
                i = i2;
            }
        }
        return i;
    }

    private long getFirstSecTerForPrimary(int i) {
        long j = this.elements[i];
        if ((128 & j) == 0) {
            return 83887360L;
        }
        long j2 = (-129) & j;
        if (j2 > 83887360) {
            return 83887360L;
        }
        return j2;
    }

    private static boolean isEndOfPrimaryRange(long j) {
        return (128 & j) == 0 && (j & 127) != 0;
    }

    public int findPrimary(long j) {
        return findP(j);
    }

    public long firstCEWithPrimaryAtLeast(long j) {
        long j2;
        if (j == 0) {
            return 0L;
        }
        int iFindP = findP(j);
        if (j != (this.elements[iFindP] & PRIMARY_SENTINEL)) {
            do {
                iFindP++;
                j2 = this.elements[iFindP];
            } while ((128 & j2) != 0);
            j = j2;
        }
        return (j << 32) | 83887360;
    }

    public long getFirstPrimary() {
        long[] jArr = this.elements;
        return jArr[(int) jArr[2]];
    }

    public long getFirstPrimaryCE() {
        return Collation.makeCE(getFirstPrimary());
    }

    public long getFirstSecondaryCE() {
        long[] jArr = this.elements;
        return jArr[(int) jArr[1]] & (-129);
    }

    public long getFirstTertiaryCE() {
        long[] jArr = this.elements;
        return jArr[(int) jArr[0]] & (-129);
    }

    public int getLastCommonSecondary() {
        return (((int) this.elements[4]) >> 16) & 65280;
    }

    public long getLastSecondaryCE() {
        long[] jArr = this.elements;
        return jArr[((int) jArr[2]) - 1] & (-129);
    }

    public long getLastTertiaryCE() {
        long[] jArr = this.elements;
        return jArr[((int) jArr[1]) - 1] & (-129);
    }

    public long getPrimaryAfter(long j, int i, boolean z) {
        int i2;
        int i3 = i + 1;
        long j2 = this.elements[i3];
        if ((j2 & 128) == 0 && (i2 = ((int) j2) & 127) != 0) {
            return (65535 & j) == 0 ? Collation.incTwoBytePrimaryByOffset(j, z, i2) : Collation.incThreeBytePrimaryByOffset(j, z, i2);
        }
        while ((j2 & 128) != 0) {
            i3++;
            j2 = this.elements[i3];
        }
        return j2;
    }

    public long getPrimaryBefore(long j, boolean z) {
        int i;
        long j2;
        int iFindPrimary = findPrimary(j);
        long[] jArr = this.elements;
        long j3 = jArr[iFindPrimary];
        if (j == (j3 & PRIMARY_SENTINEL)) {
            i = ((int) j3) & 127;
            if (i == 0) {
                do {
                    iFindPrimary--;
                    j2 = this.elements[iFindPrimary];
                } while ((128 & j2) != 0);
                return j2 & PRIMARY_SENTINEL;
            }
        } else {
            i = ((int) jArr[iFindPrimary + 1]) & 127;
        }
        return (65535 & j) == 0 ? Collation.decTwoBytePrimaryByOneStep(j, z, i) : Collation.decThreeBytePrimaryByOneStep(j, z, i);
    }

    public int getSecondaryAfter(int i, int i2) {
        long firstSecTerForPrimary;
        int secondaryBoundary;
        if (i == 0) {
            long[] jArr = this.elements;
            int i3 = (int) jArr[1];
            firstSecTerForPrimary = jArr[i3];
            secondaryBoundary = 65536;
            i = i3;
        } else {
            firstSecTerForPrimary = getFirstSecTerForPrimary(i + 1);
            secondaryBoundary = getSecondaryBoundary();
        }
        while (true) {
            int i4 = (int) (firstSecTerForPrimary >> 16);
            if (i4 > i2) {
                return i4;
            }
            i++;
            long j = this.elements[i];
            if ((128 & j) == 0) {
                return secondaryBoundary;
            }
            firstSecTerForPrimary = j;
        }
    }

    public int getSecondaryBefore(long j, int i) {
        int iFindPrimary;
        int firstSecTerForPrimary;
        int i2;
        if (j == 0) {
            long[] jArr = this.elements;
            iFindPrimary = (int) jArr[1];
            firstSecTerForPrimary = (int) (jArr[iFindPrimary] >> 16);
            i2 = 0;
        } else {
            iFindPrimary = findPrimary(j) + 1;
            firstSecTerForPrimary = ((int) getFirstSecTerForPrimary(iFindPrimary)) >>> 16;
            i2 = 256;
        }
        while (i > firstSecTerForPrimary) {
            int i3 = iFindPrimary + 1;
            i2 = firstSecTerForPrimary;
            firstSecTerForPrimary = (int) (this.elements[iFindPrimary] >> 16);
            iFindPrimary = i3;
        }
        return i2;
    }

    public int getSecondaryBoundary() {
        return (((int) this.elements[4]) >> 8) & 65280;
    }

    public int getTertiaryAfter(int i, int i2, int i3) {
        long firstSecTerForPrimary;
        int tertiaryBoundary;
        int i4;
        if (i == 0) {
            long[] jArr = this.elements;
            if (i2 == 0) {
                i4 = (int) jArr[0];
                tertiaryBoundary = 16384;
            } else {
                i4 = (int) jArr[1];
                tertiaryBoundary = getTertiaryBoundary();
            }
            firstSecTerForPrimary = this.elements[i4] & (-129);
        } else {
            firstSecTerForPrimary = getFirstSecTerForPrimary(i + 1);
            tertiaryBoundary = getTertiaryBoundary();
            i4 = i;
        }
        long j = i2;
        long j2 = ((4294967295L & j) << 16) | ((long) i3);
        while (firstSecTerForPrimary <= j2) {
            i4++;
            long j3 = this.elements[i4];
            if ((128 & j3) == 0 || (j3 >> 16) > j) {
                return tertiaryBoundary;
            }
            firstSecTerForPrimary = j3 & (-129);
        }
        return ((int) firstSecTerForPrimary) & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
    }

    public int getTertiaryBefore(long j, int i, int i2) {
        int iFindPrimary;
        long firstSecTerForPrimary;
        long j2;
        int i3 = 256;
        if (j == 0) {
            long[] jArr = this.elements;
            if (i == 0) {
                i3 = 0;
                j2 = jArr[0];
            } else {
                j2 = jArr[1];
            }
            iFindPrimary = (int) j2;
            firstSecTerForPrimary = this.elements[iFindPrimary] & (-129);
        } else {
            iFindPrimary = findPrimary(j) + 1;
            firstSecTerForPrimary = getFirstSecTerForPrimary(iFindPrimary);
        }
        long j3 = (((long) i) << 16) | ((long) i2);
        while (j3 > firstSecTerForPrimary) {
            if (((int) (firstSecTerForPrimary >> 16)) == i) {
                i3 = (int) firstSecTerForPrimary;
            }
            firstSecTerForPrimary = this.elements[iFindPrimary] & (-129);
            iFindPrimary++;
        }
        return 65535 & i3;
    }

    public int getTertiaryBoundary() {
        return (((int) this.elements[4]) << 8) & 65280;
    }

    public long lastCEWithPrimaryBefore(long j) {
        long j2;
        if (j == 0) {
            return 0L;
        }
        int iFindP = findP(j);
        long[] jArr = this.elements;
        long j3 = jArr[iFindP] & PRIMARY_SENTINEL;
        long j4 = 83887360;
        if (j == j3) {
            long j5 = jArr[iFindP - 1];
            if ((j5 & 128) == 0) {
                j3 = j5 & PRIMARY_SENTINEL;
            } else {
                int i = iFindP - 2;
                while (true) {
                    j2 = this.elements[i];
                    if ((j2 & 128) == 0) {
                        break;
                    }
                    i--;
                }
                j3 = j2 & PRIMARY_SENTINEL;
                j4 = j5;
            }
        } else {
            while (true) {
                iFindP++;
                long j6 = this.elements[iFindP];
                if ((j6 & 128) == 0) {
                    break;
                }
                j4 = j6;
            }
        }
        return (j3 << 32) | ((-129) & j4);
    }
}
