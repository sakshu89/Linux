package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacterEnums;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UCharacterUtility {
    private static final int NON_CHARACTER_MAX_3_1_ = 65007;
    private static final int NON_CHARACTER_MIN_3_1_ = 64976;
    private static final int NON_CHARACTER_SUFFIX_MIN_3_0_ = 65534;

    private UCharacterUtility() {
    }

    public static int compareNullTermByteSubString(String str, byte[] bArr, int i, int i2) {
        int length = str.length();
        byte b = 1;
        while (b != 0) {
            b = bArr[i2];
            i2++;
            if (b == 0) {
                break;
            }
            if (i == length || str.charAt(i) != ((char) (b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED))) {
                return -1;
            }
            i++;
        }
        return i;
    }

    public static int getNullTermByteSubString(StringBuilder sb, byte[] bArr, int i) {
        byte b = 1;
        while (b != 0) {
            b = bArr[i];
            if (b != 0) {
                sb.append((char) (b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED));
            }
            i++;
        }
        return i;
    }

    public static boolean isNonCharacter(int i) {
        if ((i & NON_CHARACTER_SUFFIX_MIN_3_0_) == NON_CHARACTER_SUFFIX_MIN_3_0_) {
            return true;
        }
        return i >= NON_CHARACTER_MIN_3_1_ && i <= NON_CHARACTER_MAX_3_1_;
    }

    public static int skipByteSubString(byte[] bArr, int i, int i2, byte b) {
        int i3 = 0;
        while (i3 < i2) {
            if (bArr[i + i3] == b) {
                return i3 + 1;
            }
            i3++;
        }
        return i3;
    }

    public static int skipNullTermByteSubString(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = 1;
            while (b != 0) {
                b = bArr[i];
                i++;
            }
        }
        return i;
    }

    public static int toInt(char c, char c2) {
        return (c << 16) | c2;
    }
}
