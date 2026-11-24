package com.ibm.icu.impl;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.OutputInt;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class BMPSet {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static int U16_SURROGATE_OFFSET = 56613888;
    private int[] bmpBlockBits;
    private boolean[] latin1Contains;
    private final int[] list;
    private int[] list4kStarts;
    private final int listLength;
    private int[] table7FF;

    public BMPSet(int[] iArr, int i) {
        this.list = iArr;
        this.listLength = i;
        this.latin1Contains = new boolean[256];
        this.table7FF = new int[64];
        this.bmpBlockBits = new int[64];
        int[] iArr2 = new int[18];
        this.list4kStarts = iArr2;
        iArr2[0] = findCodePoint(2048, 0, i - 1);
        int i2 = 1;
        while (true) {
            int[] iArr3 = this.list4kStarts;
            if (i2 > 16) {
                iArr3[17] = this.listLength - 1;
                initBits();
                return;
            } else {
                iArr3[i2] = findCodePoint(i2 << 12, iArr3[i2 - 1], this.listLength - 1);
                i2++;
            }
        }
    }

    private final boolean containsSlow(int i, int i2, int i3) {
        return (findCodePoint(i, i2, i3) & 1) != 0;
    }

    private int findCodePoint(int i, int i2, int i3) {
        int[] iArr = this.list;
        if (i < iArr[i2]) {
            return i2;
        }
        if (i2 >= i3 || i >= iArr[i3 - 1]) {
            return i3;
        }
        while (true) {
            int i4 = (i2 + i3) >>> 1;
            if (i4 == i2) {
                return i3;
            }
            if (i < this.list[i4]) {
                i3 = i4;
            } else {
                i2 = i4;
            }
        }
    }

    private void initBits() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            int[] iArr = this.list;
            int i6 = i5 + 1;
            i = iArr[i5];
            if (i6 < this.listLength) {
                i5 += 2;
                i2 = iArr[i6];
            } else {
                i5 = i6;
                i2 = 1114112;
            }
            if (i >= 256) {
                break;
            }
            while (true) {
                i4 = i + 1;
                this.latin1Contains[i] = true;
                if (i4 >= i2 || i4 >= 256) {
                    break;
                } else {
                    i = i4;
                }
            }
            if (i2 > 256) {
                i = i4;
                break;
            }
        }
        while (true) {
            i3 = 2048;
            if (i >= 2048) {
                break;
            }
            set32x64Bits(this.table7FF, i, i2 <= 2048 ? i2 : 2048);
            if (i2 > 2048) {
                i = 2048;
                break;
            }
            int[] iArr2 = this.list;
            int i7 = i5 + 1;
            i = iArr2[i5];
            if (i7 < this.listLength) {
                i5 += 2;
                i2 = iArr2[i7];
            } else {
                i5 = i7;
                i2 = 1114112;
            }
        }
        while (i < 65536) {
            if (i2 > 65536) {
                i2 = 65536;
            }
            if (i < i3) {
                i = i3;
            }
            if (i < i2) {
                if ((i & 63) != 0) {
                    int i8 = i >> 6;
                    int[] iArr3 = this.bmpBlockBits;
                    int i9 = i8 & 63;
                    iArr3[i9] = (65537 << (i >> 12)) | iArr3[i9];
                    i3 = (i8 + 1) << 6;
                    i = i3;
                }
                if (i < i2) {
                    if (i < (i2 & (-64))) {
                        set32x64Bits(this.bmpBlockBits, i >> 6, i2 >> 6);
                    }
                    if ((i2 & 63) != 0) {
                        int i10 = i2 >> 6;
                        int[] iArr4 = this.bmpBlockBits;
                        int i11 = i10 & 63;
                        iArr4[i11] = (65537 << (i2 >> 12)) | iArr4[i11];
                        i2 = (i10 + 1) << 6;
                        i3 = i2;
                    }
                }
            }
            if (i2 == 65536) {
                return;
            }
            int[] iArr5 = this.list;
            int i12 = i5 + 1;
            int i13 = iArr5[i5];
            if (i12 < this.listLength) {
                i5 += 2;
                i2 = iArr5[i12];
            } else {
                i5 = i12;
                i2 = 1114112;
            }
            i = i13;
        }
    }

    private static void set32x64Bits(int[] iArr, int i, int i2) {
        int i3 = i >> 6;
        int i4 = i & 63;
        int i5 = 1 << i3;
        if (i + 1 == i2) {
            iArr[i4] = iArr[i4] | i5;
            return;
        }
        int i6 = i2 >> 6;
        int i7 = i2 & 63;
        if (i3 == i6) {
            while (i4 < i7) {
                iArr[i4] = iArr[i4] | i5;
                i4++;
            }
            return;
        }
        if (i4 > 0) {
            while (true) {
                int i8 = i4 + 1;
                iArr[i4] = iArr[i4] | i5;
                if (i8 >= 64) {
                    break;
                } else {
                    i4 = i8;
                }
            }
            i3++;
        }
        if (i3 < i6) {
            int i9 = ~((1 << i3) - 1);
            if (i6 < 32) {
                i9 &= (1 << i6) - 1;
            }
            for (int i10 = 0; i10 < 64; i10++) {
                iArr[i10] = iArr[i10] | i9;
            }
        }
        int i11 = 1 << i6;
        for (int i12 = 0; i12 < i7; i12++) {
            iArr[i12] = iArr[i12] | i11;
        }
    }

    public boolean contains(int i) {
        if (i <= 255) {
            return this.latin1Contains[i];
        }
        if (i <= 2047) {
            return (this.table7FF[i & 63] & (1 << (i >> 6))) != 0;
        }
        if (i >= 55296 && (i < 57344 || i > 65535)) {
            if (i > 1114111) {
                return false;
            }
            int[] iArr = this.list4kStarts;
            return containsSlow(i, iArr[13], iArr[17]);
        }
        int i2 = i >> 12;
        int i3 = (this.bmpBlockBits[(i >> 6) & 63] >> i2) & 65537;
        if (i3 <= 1) {
            return i3 != 0;
        }
        int[] iArr2 = this.list4kStarts;
        return containsSlow(i, iArr2[i2], iArr2[i2 + 1]);
    }

    public final int span(CharSequence charSequence, int i, UnicodeSet.SpanCondition spanCondition, OutputInt outputInt) {
        int i2;
        int i3;
        char cCharAt;
        int i4;
        int length = charSequence.length();
        int i5 = 0;
        if (UnicodeSet.SpanCondition.NOT_CONTAINED != spanCondition) {
            i2 = i;
            while (i2 < length) {
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt2 <= 255) {
                    if (!this.latin1Contains[cCharAt2]) {
                        break;
                    }
                } else if (cCharAt2 > 2047) {
                    if (cCharAt2 >= 55296 && cCharAt2 < 56320 && (i4 = i2 + 1) != length) {
                        char cCharAt3 = charSequence.charAt(i4);
                        if (cCharAt3 >= 56320 && cCharAt3 < 57344) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            int[] iArr = this.list4kStarts;
                            if (!containsSlow(codePoint, iArr[16], iArr[17])) {
                                break;
                            }
                            i5++;
                            i2 = i4;
                        }
                    }
                    int i6 = cCharAt2 >> '\f';
                    int i7 = (this.bmpBlockBits[(cCharAt2 >> 6) & 63] >> i6) & 65537;
                    if (i7 > 1) {
                        int[] iArr2 = this.list4kStarts;
                        if (!containsSlow(cCharAt2, iArr2[i6], iArr2[i6 + 1])) {
                            break;
                        }
                    } else if (i7 == 0) {
                        break;
                    }
                } else if ((this.table7FF[cCharAt2 & '?'] & (1 << (cCharAt2 >> 6))) == 0) {
                    break;
                }
                i2++;
            }
        } else {
            i2 = i;
            while (i2 < length) {
                char cCharAt4 = charSequence.charAt(i2);
                if (cCharAt4 <= 255) {
                    if (this.latin1Contains[cCharAt4]) {
                        break;
                    }
                    i2++;
                } else if (cCharAt4 <= 2047) {
                    if (((1 << (cCharAt4 >> 6)) & this.table7FF[cCharAt4 & '?']) != 0) {
                        break;
                    }
                    i2++;
                } else if (cCharAt4 < 55296 || cCharAt4 >= 56320 || (i3 = i2 + 1) == length || (cCharAt = charSequence.charAt(i3)) < 56320 || cCharAt >= 57344) {
                    int i8 = cCharAt4 >> '\f';
                    int i9 = (this.bmpBlockBits[(cCharAt4 >> 6) & 63] >> i8) & 65537;
                    if (i9 > 1) {
                        int[] iArr3 = this.list4kStarts;
                        if (containsSlow(cCharAt4, iArr3[i8], iArr3[i8 + 1])) {
                            break;
                        }
                        i2++;
                    } else {
                        if (i9 != 0) {
                            break;
                        }
                        i2++;
                    }
                } else {
                    int codePoint2 = Character.toCodePoint(cCharAt4, cCharAt);
                    int[] iArr4 = this.list4kStarts;
                    if (containsSlow(codePoint2, iArr4[16], iArr4[17])) {
                        break;
                    }
                    i5++;
                    i2 = i3;
                    i2++;
                }
            }
        }
        if (outputInt != null) {
            outputInt.value = (i2 - i) - i5;
        }
        return i2;
    }

    public final int spanBack(CharSequence charSequence, int i, UnicodeSet.SpanCondition spanCondition) {
        int i2;
        char cCharAt;
        char cCharAt2;
        if (UnicodeSet.SpanCondition.NOT_CONTAINED != spanCondition) {
            do {
                i2 = i - 1;
                char cCharAt3 = charSequence.charAt(i2);
                if (cCharAt3 <= 255) {
                    if (!this.latin1Contains[cCharAt3]) {
                    }
                    i = i2;
                } else if (cCharAt3 <= 2047) {
                    if ((this.table7FF[cCharAt3 & '?'] & (1 << (cCharAt3 >> 6))) == 0) {
                    }
                    i = i2;
                } else if (cCharAt3 < 55296 || cCharAt3 < 56320 || i2 == 0 || (cCharAt2 = charSequence.charAt(i - 2)) < 55296 || cCharAt2 >= 56320) {
                    int i3 = cCharAt3 >> '\f';
                    int i4 = (this.bmpBlockBits[(cCharAt3 >> 6) & 63] >> i3) & 65537;
                    if (i4 <= 1) {
                        if (i4 == 0) {
                        }
                        i = i2;
                    } else {
                        int[] iArr = this.list4kStarts;
                        if (!containsSlow(cCharAt3, iArr[i3], iArr[i3 + 1])) {
                        }
                        i = i2;
                    }
                } else {
                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                    int[] iArr2 = this.list4kStarts;
                    if (containsSlow(codePoint, iArr2[16], iArr2[17])) {
                        i -= 2;
                    }
                }
            } while (i != 0);
            return 0;
        }
        do {
            i2 = i - 1;
            char cCharAt4 = charSequence.charAt(i2);
            if (cCharAt4 <= 255) {
                if (this.latin1Contains[cCharAt4]) {
                }
                i = i2;
            } else if (cCharAt4 <= 2047) {
                if ((this.table7FF[cCharAt4 & '?'] & (1 << (cCharAt4 >> 6))) != 0) {
                }
                i = i2;
            } else if (cCharAt4 < 55296 || cCharAt4 < 56320 || i2 == 0 || (cCharAt = charSequence.charAt(i - 2)) < 55296 || cCharAt >= 56320) {
                int i5 = cCharAt4 >> '\f';
                int i6 = (this.bmpBlockBits[(cCharAt4 >> 6) & 63] >> i5) & 65537;
                if (i6 <= 1) {
                    if (i6 != 0) {
                    }
                    i = i2;
                } else {
                    int[] iArr3 = this.list4kStarts;
                    if (containsSlow(cCharAt4, iArr3[i5], iArr3[i5 + 1])) {
                    }
                    i = i2;
                }
            } else {
                int codePoint2 = Character.toCodePoint(cCharAt, cCharAt4);
                int[] iArr4 = this.list4kStarts;
                if (!containsSlow(codePoint2, iArr4[16], iArr4[17])) {
                    i -= 2;
                }
            }
        } while (i != 0);
        return 0;
        return i2 + 1;
    }

    public BMPSet(BMPSet bMPSet, int[] iArr, int i) {
        this.list = iArr;
        this.listLength = i;
        this.latin1Contains = (boolean[]) bMPSet.latin1Contains.clone();
        this.table7FF = (int[]) bMPSet.table7FF.clone();
        this.bmpBlockBits = (int[]) bMPSet.bmpBlockBits.clone();
        this.list4kStarts = (int[]) bMPSet.list4kStarts.clone();
    }
}
