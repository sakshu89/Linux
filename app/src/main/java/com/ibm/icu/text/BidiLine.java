package com.ibm.icu.text;

import defpackage.og;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class BidiLine {
    public static byte getLevelAt(Bidi bidi, int i) {
        return (bidi.direction != 2 || i >= bidi.trailingWSStart) ? bidi.GetParaLevelAt(i) : bidi.levels[i];
    }

    public static byte[] getLevels(Bidi bidi) {
        int i = bidi.trailingWSStart;
        int i2 = bidi.length;
        if (i != i2) {
            Arrays.fill(bidi.levels, i, i2, bidi.paraLevel);
            bidi.trailingWSStart = i2;
        }
        byte[] bArr = bidi.levels;
        if (i2 >= bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    public static int getLogicalIndex(Bidi bidi, int i) {
        BidiRun bidiRun;
        int i2;
        int i3;
        int i4;
        BidiRun[] bidiRunArr = bidi.runs;
        int i5 = bidi.runCount;
        int i6 = 0;
        if (bidi.insertPoints.size > 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                BidiRun bidiRun2 = bidiRunArr[i7];
                int i10 = bidiRun2.limit;
                int i11 = i10 - i8;
                int i12 = bidiRun2.insertRemove;
                if ((i12 & 5) > 0) {
                    if (i <= i8 + i9) {
                        return -1;
                    }
                    i9++;
                }
                if (i < i10 + i9) {
                    i -= i9;
                    break;
                }
                if ((i12 & 10) > 0) {
                    if (i == i8 + i11 + i9) {
                        return -1;
                    }
                    i9++;
                }
                i7++;
                i8 += i11;
            }
        } else if (bidi.controlCount > 0) {
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                bidiRun = bidiRunArr[i13];
                int i16 = bidiRun.limit;
                i2 = i16 - i14;
                i3 = bidiRun.insertRemove;
                if (i < (i16 - i15) + i3) {
                    break;
                }
                i15 -= i3;
                i13++;
                i14 += i2;
            }
            if (i3 != 0) {
                int i17 = bidiRun.start;
                boolean zIsEvenRun = bidiRun.isEvenRun();
                int i18 = (i17 + i2) - 1;
                for (int i19 = 0; i19 < i2; i19++) {
                    if (Bidi.IsBidiControlChar(bidi.text[zIsEvenRun ? i17 + i19 : i18 - i19])) {
                        i15++;
                    }
                    if (i + i15 == i14 + i19) {
                        break;
                    }
                }
            }
            i += i15;
        }
        if (i5 <= 10) {
            while (i >= bidiRunArr[i6].limit) {
                i6++;
            }
        } else {
            while (true) {
                i4 = (i6 + i5) >>> 1;
                if (i >= bidiRunArr[i4].limit) {
                    i6 = i4 + 1;
                } else {
                    if (i4 == 0 || i >= bidiRunArr[i4 - 1].limit) {
                        break;
                    }
                    i5 = i4;
                }
            }
            i6 = i4;
        }
        BidiRun bidiRun3 = bidiRunArr[i6];
        int i20 = bidiRun3.start;
        if (!bidiRun3.isEvenRun()) {
            return ((i20 + bidiRunArr[i6].limit) - i) - 1;
        }
        if (i6 > 0) {
            i -= bidiRunArr[i6 - 1].limit;
        }
        return i20 + i;
    }

    public static int[] getLogicalMap(Bidi bidi) {
        int i;
        int i2;
        int i3;
        BidiRun[] bidiRunArr = bidi.runs;
        int i4 = bidi.length;
        int[] iArr = new int[i4];
        if (i4 > bidi.resultLength) {
            Arrays.fill(iArr, -1);
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i = bidi.runCount;
            if (i6 >= i) {
                break;
            }
            BidiRun bidiRun = bidiRunArr[i6];
            int i8 = bidiRun.start;
            int i9 = bidiRun.limit;
            if (bidiRun.isEvenRun()) {
                while (true) {
                    int i10 = i8 + 1;
                    i3 = i7 + 1;
                    iArr[i8] = i7;
                    if (i3 >= i9) {
                        break;
                    }
                    i8 = i10;
                    i7 = i3;
                }
                i7 = i3;
            } else {
                int i11 = (i9 - i7) + i8;
                do {
                    i11--;
                    i2 = i7 + 1;
                    iArr[i11] = i7;
                    i7 = i2;
                } while (i2 < i9);
            }
            i6++;
        }
        if (bidi.insertPoints.size > 0) {
            BidiRun[] bidiRunArr2 = bidi.runs;
            int i12 = 0;
            int i13 = 0;
            while (i5 < i) {
                BidiRun bidiRun2 = bidiRunArr2[i5];
                int i14 = bidiRun2.limit - i12;
                int i15 = bidiRun2.insertRemove;
                if ((i15 & 5) > 0) {
                    i13++;
                }
                if (i13 > 0) {
                    int i16 = bidiRun2.start;
                    int i17 = i16 + i14;
                    while (i16 < i17) {
                        iArr[i16] = iArr[i16] + i13;
                        i16++;
                    }
                }
                if ((i15 & 10) > 0) {
                    i13++;
                }
                i5++;
                i12 += i14;
            }
        } else if (bidi.controlCount > 0) {
            BidiRun[] bidiRunArr3 = bidi.runs;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            while (i18 < i) {
                BidiRun bidiRun3 = bidiRunArr3[i18];
                int i21 = bidiRun3.limit - i19;
                int i22 = bidiRun3.insertRemove;
                if (i20 - i22 != 0) {
                    int i23 = bidiRun3.start;
                    boolean zIsEvenRun = bidiRun3.isEvenRun();
                    int i24 = i23 + i21;
                    if (i22 == 0) {
                        while (i23 < i24) {
                            iArr[i23] = iArr[i23] - i20;
                            i23++;
                        }
                    } else {
                        for (int i25 = 0; i25 < i21; i25++) {
                            int i26 = zIsEvenRun ? i23 + i25 : (i24 - i25) - 1;
                            if (Bidi.IsBidiControlChar(bidi.text[i26])) {
                                i20++;
                                iArr[i26] = -1;
                            } else {
                                iArr[i26] = iArr[i26] - i20;
                            }
                        }
                    }
                }
                i18++;
                i19 += i21;
            }
        }
        return iArr;
    }

    public static BidiRun getLogicalRun(Bidi bidi, int i) {
        BidiRun bidiRun = new BidiRun();
        getRuns(bidi);
        int i2 = bidi.runCount;
        int i3 = 0;
        BidiRun bidiRun2 = bidi.runs[0];
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            bidiRun2 = bidi.runs[i3];
            int i6 = bidiRun2.start;
            int i7 = bidiRun2.limit;
            int i8 = (i6 + i7) - i4;
            if (i >= i6 && i < i8) {
                i5 = i8;
                break;
            }
            i3++;
            i5 = i8;
            i4 = i7;
        }
        bidiRun.start = bidiRun2.start;
        bidiRun.limit = i5;
        bidiRun.level = bidiRun2.level;
        return bidiRun;
    }

    public static int getRunFromLogicalIndex(Bidi bidi, int i) {
        BidiRun[] bidiRunArr = bidi.runs;
        int i2 = bidi.runCount;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            BidiRun bidiRun = bidiRunArr[i4];
            int i5 = bidiRun.limit - i3;
            int i6 = bidiRun.start;
            if (i >= i6 && i < i6 + i5) {
                return i4;
            }
            i3 += i5;
        }
        og.n("Internal ICU error in getRunFromLogicalIndex");
        return 0;
    }

    public static void getRuns(Bidi bidi) {
        if (bidi.runCount >= 0) {
            return;
        }
        if (bidi.direction != 2) {
            getSingleRun(bidi, bidi.paraLevel);
        } else {
            int i = bidi.length;
            byte[] bArr = bidi.levels;
            int i2 = bidi.trailingWSStart;
            byte b = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                byte b2 = bArr[i4];
                if (b2 != b) {
                    i3++;
                    b = b2;
                }
            }
            if (i3 == 1 && i2 == i) {
                getSingleRun(bidi, bArr[0]);
            } else {
                if (i2 < i) {
                    i3++;
                }
                bidi.getRunsMemory(i3);
                BidiRun[] bidiRunArr = bidi.runsMemory;
                byte b3 = Bidi.LEVEL_DEFAULT_LTR;
                int i5 = 0;
                byte b4 = 0;
                int i6 = 0;
                while (true) {
                    byte b5 = bArr[i5];
                    if (b5 < b3) {
                        b3 = b5;
                    }
                    int i7 = i5;
                    if (b5 > b4) {
                        b4 = b5;
                    }
                    do {
                        i7++;
                        if (i7 >= i2) {
                            break;
                        }
                    } while (bArr[i7] == b5);
                    bidiRunArr[i6] = new BidiRun(i5, i7 - i5, b5);
                    i6++;
                    if (i7 >= i2) {
                        break;
                    } else {
                        i5 = i7;
                    }
                }
                if (i2 < i) {
                    bidiRunArr[i6] = new BidiRun(i2, i - i2, bidi.paraLevel);
                    byte b6 = bidi.paraLevel;
                    if (b6 < b3) {
                        b3 = b6;
                    }
                }
                bidi.runs = bidiRunArr;
                bidi.runCount = i3;
                reorderLine(bidi, b3, b4);
                int i8 = 0;
                for (int i9 = 0; i9 < i3; i9++) {
                    BidiRun bidiRun = bidiRunArr[i9];
                    bidiRun.level = bArr[bidiRun.start];
                    i8 += bidiRun.limit;
                    bidiRun.limit = i8;
                }
                if (i6 < i3) {
                    byte b7 = bidi.paraLevel;
                    if ((b7 & 1) != 0) {
                        i6 = 0;
                    }
                    bidiRunArr[i6].level = b7;
                }
            }
        }
        if (bidi.insertPoints.size > 0) {
            int i10 = 0;
            while (true) {
                Bidi.InsertPoints insertPoints = bidi.insertPoints;
                if (i10 >= insertPoints.size) {
                    break;
                }
                Bidi.Point point = insertPoints.points[i10];
                BidiRun bidiRun2 = bidi.runs[getRunFromLogicalIndex(bidi, point.pos)];
                bidiRun2.insertRemove = point.flag | bidiRun2.insertRemove;
                i10++;
            }
        }
        if (bidi.controlCount > 0) {
            for (int i11 = 0; i11 < bidi.length; i11++) {
                if (Bidi.IsBidiControlChar(bidi.text[i11])) {
                    bidi.runs[getRunFromLogicalIndex(bidi, i11)].insertRemove--;
                }
            }
        }
    }

    public static void getSingleRun(Bidi bidi, byte b) {
        BidiRun[] bidiRunArr = bidi.simpleRuns;
        bidi.runs = bidiRunArr;
        bidi.runCount = 1;
        bidiRunArr[0] = new BidiRun(0, bidi.length, b);
    }

    public static int getVisualIndex(Bidi bidi, int i) {
        int i2;
        BidiRun bidiRun;
        int i3;
        int i4;
        int i5;
        byte b = bidi.direction;
        int i6 = 0;
        if (b == 0) {
            i2 = i;
        } else if (b != 1) {
            getRuns(bidi);
            BidiRun[] bidiRunArr = bidi.runs;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (i7 >= bidi.runCount) {
                    i2 = -1;
                    break;
                }
                BidiRun bidiRun2 = bidiRunArr[i7];
                int i9 = bidiRun2.limit - i8;
                int i10 = i - bidiRun2.start;
                if (i10 >= 0 && i10 < i9) {
                    if (!bidiRun2.isEvenRun()) {
                        i2 = ((i8 + i9) - i10) - 1;
                        break;
                    }
                    i2 = i8 + i10;
                    break;
                }
                i8 += i9;
                i7++;
            }
            if (i7 >= bidi.runCount) {
                return -1;
            }
        } else {
            i2 = (bidi.length - i) - 1;
        }
        if (bidi.insertPoints.size <= 0) {
            if (bidi.controlCount <= 0) {
                return i2;
            }
            BidiRun[] bidiRunArr2 = bidi.runs;
            if (Bidi.IsBidiControlChar(bidi.text[i])) {
                return -1;
            }
            int i11 = 0;
            int i12 = 0;
            while (true) {
                bidiRun = bidiRunArr2[i6];
                int i13 = bidiRun.limit;
                i3 = i13 - i11;
                i4 = bidiRun.insertRemove;
                if (i2 < i13) {
                    break;
                }
                i12 -= i4;
                i6++;
                i11 += i3;
            }
            if (i4 == 0) {
                return i2 - i12;
            }
            if (bidiRun.isEvenRun()) {
                i5 = bidiRunArr2[i6].start;
            } else {
                int i14 = bidiRunArr2[i6].start + i3;
                i5 = i + 1;
                i = i14;
            }
            while (i5 < i) {
                if (Bidi.IsBidiControlChar(bidi.text[i5])) {
                    i12++;
                }
                i5++;
            }
            return i2 - i12;
        }
        BidiRun[] bidiRunArr3 = bidi.runs;
        int i15 = 0;
        while (true) {
            BidiRun bidiRun3 = bidiRunArr3[i6];
            int i16 = bidiRun3.limit;
            int i17 = bidiRun3.insertRemove;
            if ((i17 & 5) > 0) {
                i15++;
            }
            if (i2 < i16) {
                return i2 + i15;
            }
            if ((i17 & 10) > 0) {
                i15++;
            }
            i6++;
        }
    }

    public static int[] getVisualMap(Bidi bidi) {
        int i;
        BidiRun[] bidiRunArr = bidi.runs;
        int i2 = bidi.length;
        int i3 = bidi.resultLength;
        if (i2 <= i3) {
            i2 = i3;
        }
        int[] iArr = new int[i2];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = bidi.runCount;
            if (i4 >= i) {
                break;
            }
            BidiRun bidiRun = bidiRunArr[i4];
            int i7 = bidiRun.start;
            int i8 = bidiRun.limit;
            if (bidiRun.isEvenRun()) {
                while (true) {
                    int i9 = i7 + 1;
                    iArr[i6] = i7;
                    i5++;
                    i6++;
                    if (i5 >= i8) {
                        break;
                    }
                    i7 = i9;
                }
            } else {
                int i10 = (i8 - i5) + i7;
                do {
                    i10--;
                    iArr[i6] = i10;
                    i5++;
                    i6++;
                } while (i5 < i8);
            }
            i4++;
        }
        if (bidi.insertPoints.size > 0) {
            BidiRun[] bidiRunArr2 = bidi.runs;
            int i11 = 0;
            for (int i12 = 0; i12 < i; i12++) {
                int i13 = bidiRunArr2[i12].insertRemove;
                if ((i13 & 5) > 0) {
                    i11++;
                }
                if ((i13 & 10) > 0) {
                    i11++;
                }
            }
            int i14 = bidi.resultLength;
            int i15 = i - 1;
            while (i15 >= 0 && i11 > 0) {
                BidiRun bidiRun2 = bidiRunArr2[i15];
                int i16 = bidiRun2.insertRemove;
                if ((i16 & 10) > 0) {
                    i14--;
                    iArr[i14] = -1;
                    i11--;
                }
                int i17 = i15 > 0 ? bidiRunArr2[i15 - 1].limit : 0;
                for (int i18 = bidiRun2.limit - 1; i18 >= i17 && i11 > 0; i18--) {
                    i14--;
                    iArr[i14] = iArr[i18];
                }
                if ((i16 & 5) > 0) {
                    i14--;
                    iArr[i14] = -1;
                    i11--;
                }
                i15--;
            }
        } else if (bidi.controlCount > 0) {
            BidiRun[] bidiRunArr3 = bidi.runs;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            while (i19 < i) {
                BidiRun bidiRun3 = bidiRunArr3[i19];
                int i22 = bidiRun3.limit;
                int i23 = i22 - i20;
                int i24 = bidiRun3.insertRemove;
                if (i24 == 0 && i21 == i20) {
                    i21 += i23;
                } else if (i24 == 0) {
                    int i25 = i20;
                    while (i25 < i22) {
                        iArr[i21] = iArr[i25];
                        i25++;
                        i21++;
                    }
                } else {
                    int i26 = bidiRun3.start;
                    boolean zIsEvenRun = bidiRun3.isEvenRun();
                    int i27 = (i26 + i23) - 1;
                    for (int i28 = 0; i28 < i23; i28++) {
                        int i29 = zIsEvenRun ? i26 + i28 : i27 - i28;
                        if (!Bidi.IsBidiControlChar(bidi.text[i29])) {
                            iArr[i21] = i29;
                            i21++;
                        }
                    }
                }
                i19++;
                i20 += i23;
            }
        }
        int i30 = bidi.resultLength;
        if (i2 == i30) {
            return iArr;
        }
        int[] iArr2 = new int[i30];
        System.arraycopy(iArr, 0, iArr2, 0, i30);
        return iArr2;
    }

    public static BidiRun getVisualRun(Bidi bidi, int i) {
        BidiRun[] bidiRunArr = bidi.runs;
        BidiRun bidiRun = bidiRunArr[i];
        int i2 = bidiRun.start;
        return new BidiRun(i2, i > 0 ? (bidiRun.limit + i2) - bidiRunArr[i - 1].limit : i2 + bidiRunArr[0].limit, bidiRun.level);
    }

    public static int[] invertMap(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 > i) {
                i = i3;
            }
            if (i3 >= 0) {
                i2++;
            }
        }
        int i4 = i + 1;
        int[] iArr2 = new int[i4];
        if (i2 < i4) {
            Arrays.fill(iArr2, -1);
        }
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            if (i6 >= 0) {
                iArr2[i6] = i5;
            }
        }
        return iArr2;
    }

    public static int[] prepareReorder(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = bArr.length;
        byte b = 126;
        byte b2 = 0;
        while (length > 0) {
            length--;
            byte b3 = bArr[length];
            if (b3 < 0 || b3 > 126) {
                return null;
            }
            if (b3 < b) {
                b = b3;
            }
            if (b3 > b2) {
                b2 = b3;
            }
        }
        bArr2[0] = b;
        bArr3[0] = b2;
        int[] iArr = new int[bArr.length];
        int length2 = bArr.length;
        while (length2 > 0) {
            length2--;
            iArr[length2] = length2;
        }
        return iArr;
    }

    private static void reorderLine(Bidi bidi, byte b, byte b2) {
        int i;
        int i2;
        if (b2 <= (b | 1)) {
            return;
        }
        byte b3 = (byte) (b + 1);
        BidiRun[] bidiRunArr = bidi.runs;
        byte[] bArr = bidi.levels;
        int i3 = bidi.runCount;
        if (bidi.trailingWSStart < bidi.length) {
            i3--;
        }
        while (true) {
            b2 = (byte) (b2 - 1);
            i = 0;
            if (b2 < b3) {
                break;
            }
            while (true) {
                if (i < i3 && bArr[bidiRunArr[i].start] < b2) {
                    i++;
                } else {
                    if (i >= i3) {
                        break;
                    }
                    int i4 = i;
                    while (true) {
                        i2 = i4 + 1;
                        if (i2 >= i3 || bArr[bidiRunArr[i2].start] < b2) {
                            break;
                        } else {
                            i4 = i2;
                        }
                    }
                    for (int i5 = i4; i < i5; i5--) {
                        BidiRun bidiRun = bidiRunArr[i];
                        bidiRunArr[i] = bidiRunArr[i5];
                        bidiRunArr[i5] = bidiRun;
                        i++;
                    }
                    if (i2 == i3) {
                        break;
                    } else {
                        i = i4 + 2;
                    }
                }
            }
        }
        if ((b3 & 1) == 0) {
            if (bidi.trailingWSStart == bidi.length) {
                i3--;
            }
            while (i < i3) {
                BidiRun bidiRun2 = bidiRunArr[i];
                bidiRunArr[i] = bidiRunArr[i3];
                bidiRunArr[i3] = bidiRun2;
                i++;
                i3--;
            }
        }
    }

    public static int[] reorderLogical(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[1];
        byte[] bArr3 = new byte[1];
        int[] iArrPrepareReorder = prepareReorder(bArr, bArr2, bArr3);
        if (iArrPrepareReorder == null) {
            return null;
        }
        byte b = bArr2[0];
        byte b2 = bArr3[0];
        if (b != b2 || (b & 1) != 0) {
            byte b3 = (byte) (b | 1);
            do {
                int i2 = 0;
                while (true) {
                    if (i2 < bArr.length && bArr[i2] < b2) {
                        i2++;
                    } else {
                        if (i2 >= bArr.length) {
                            break;
                        }
                        int i3 = i2;
                        while (true) {
                            i = i3 + 1;
                            if (i >= bArr.length || bArr[i] < b2) {
                                break;
                            }
                            i3 = i;
                        }
                        int i4 = (i2 + i) - 1;
                        do {
                            iArrPrepareReorder[i2] = i4 - iArrPrepareReorder[i2];
                            i2++;
                        } while (i2 < i);
                        if (i == bArr.length) {
                            break;
                        }
                        i2 = i3 + 2;
                    }
                }
                b2 = (byte) (b2 - 1);
            } while (b2 >= b3);
        }
        return iArrPrepareReorder;
    }

    public static int[] reorderVisual(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[1];
        byte[] bArr3 = new byte[1];
        int[] iArrPrepareReorder = prepareReorder(bArr, bArr2, bArr3);
        if (iArrPrepareReorder == null) {
            return null;
        }
        byte b = bArr2[0];
        byte b2 = bArr3[0];
        if (b != b2 || (b & 1) != 0) {
            byte b3 = (byte) (1 | b);
            do {
                int i2 = 0;
                while (true) {
                    if (i2 < bArr.length && bArr[i2] < b2) {
                        i2++;
                    } else {
                        if (i2 >= bArr.length) {
                            break;
                        }
                        int i3 = i2;
                        while (true) {
                            i = i3 + 1;
                            if (i >= bArr.length || bArr[i] < b2) {
                                break;
                            }
                            i3 = i;
                        }
                        for (int i4 = i3; i2 < i4; i4--) {
                            int i5 = iArrPrepareReorder[i2];
                            iArrPrepareReorder[i2] = iArrPrepareReorder[i4];
                            iArrPrepareReorder[i4] = i5;
                            i2++;
                        }
                        if (i == bArr.length) {
                            break;
                        }
                        i2 = i3 + 2;
                    }
                }
                b2 = (byte) (b2 - 1);
            } while (b2 >= b3);
        }
        return iArrPrepareReorder;
    }

    public static Bidi setLine(Bidi bidi, int i, int i2) {
        Bidi bidi2 = new Bidi();
        int i3 = i2 - i;
        bidi2.resultLength = i3;
        bidi2.originalLength = i3;
        bidi2.length = i3;
        char[] cArr = new char[i3];
        bidi2.text = cArr;
        System.arraycopy(bidi.text, i, cArr, 0, i3);
        bidi2.paraLevel = bidi.GetParaLevelAt(i);
        bidi2.paraCount = bidi.paraCount;
        bidi2.runs = new BidiRun[0];
        bidi2.reorderingMode = bidi.reorderingMode;
        bidi2.reorderingOptions = bidi.reorderingOptions;
        if (bidi.controlCount > 0) {
            for (int i4 = i; i4 < i2; i4++) {
                if (Bidi.IsBidiControlChar(bidi.text[i4])) {
                    bidi2.controlCount++;
                }
            }
            bidi2.resultLength -= bidi2.controlCount;
        }
        bidi2.getDirPropsMemory(i3);
        byte[] bArr = bidi2.dirPropsMemory;
        bidi2.dirProps = bArr;
        System.arraycopy(bidi.dirProps, i, bArr, 0, i3);
        bidi2.getLevelsMemory(i3);
        byte[] bArr2 = bidi2.levelsMemory;
        bidi2.levels = bArr2;
        System.arraycopy(bidi.levels, i, bArr2, 0, i3);
        bidi2.runCount = -1;
        byte b = bidi.direction;
        if (b != 2) {
            bidi2.direction = b;
            int i5 = bidi.trailingWSStart;
            if (i5 <= i) {
                bidi2.trailingWSStart = 0;
            } else if (i5 < i2) {
                bidi2.trailingWSStart = i5 - i;
            } else {
                bidi2.trailingWSStart = i3;
            }
        } else {
            byte[] bArr3 = bidi2.levels;
            setTrailingWSStart(bidi2);
            int i6 = bidi2.trailingWSStart;
            if (i6 == 0) {
                bidi2.direction = (byte) (bidi2.paraLevel & 1);
            } else {
                byte b2 = (byte) (bArr3[0] & 1);
                if (i6 >= i3 || (bidi2.paraLevel & 1) == b2) {
                    int i7 = 1;
                    while (true) {
                        if (i7 == i6) {
                            bidi2.direction = b2;
                            break;
                        }
                        if ((bArr3[i7] & 1) != b2) {
                            bidi2.direction = (byte) 2;
                            break;
                        }
                        i7++;
                    }
                } else {
                    bidi2.direction = (byte) 2;
                }
            }
            byte b3 = bidi2.direction;
            if (b3 == 0) {
                bidi2.paraLevel = (byte) ((bidi2.paraLevel + 1) & (-2));
                bidi2.trailingWSStart = 0;
            } else if (b3 == 1) {
                bidi2.paraLevel = (byte) (bidi2.paraLevel | 1);
                bidi2.trailingWSStart = 0;
            }
        }
        bidi2.paraBidi = bidi;
        return bidi2;
    }

    public static void setTrailingWSStart(Bidi bidi) {
        byte[] bArr = bidi.dirProps;
        byte[] bArr2 = bidi.levels;
        int i = bidi.length;
        byte b = bidi.paraLevel;
        if (bArr[i - 1] == 7) {
            bidi.trailingWSStart = i;
            return;
        }
        while (i > 0 && (Bidi.DirPropFlag(bArr[i - 1]) & Bidi.MASK_WS) != 0) {
            i--;
        }
        while (i > 0 && bArr2[i - 1] == b) {
            i--;
        }
        bidi.trailingWSStart = i;
    }
}
