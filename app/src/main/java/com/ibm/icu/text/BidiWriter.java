package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class BidiWriter {
    static final char LRM_CHAR = 8206;
    static final int MASK_R_AL = 8194;
    static final char RLM_CHAR = 8207;

    private static boolean IsCombining(int i) {
        return ((1 << i) & 448) != 0;
    }

    private static String doWriteForward(String str, int i) {
        int i2 = i & 10;
        if (i2 == 0) {
            return str;
        }
        int charCount = 0;
        if (i2 == 2) {
            StringBuffer stringBuffer = new StringBuffer(str.length());
            do {
                int iCharAt = UTF16.charAt(str, charCount);
                charCount += UTF16.getCharCount(iCharAt);
                UTF16.append(stringBuffer, UCharacter.getMirror(iCharAt));
            } while (charCount < str.length());
            return stringBuffer.toString();
        }
        if (i2 != 8) {
            StringBuffer stringBuffer2 = new StringBuffer(str.length());
            do {
                int iCharAt2 = UTF16.charAt(str, charCount);
                charCount += UTF16.getCharCount(iCharAt2);
                if (!Bidi.IsBidiControlChar(iCharAt2)) {
                    UTF16.append(stringBuffer2, UCharacter.getMirror(iCharAt2));
                }
            } while (charCount < str.length());
            return stringBuffer2.toString();
        }
        StringBuilder sb = new StringBuilder(str.length());
        while (true) {
            int i3 = charCount + 1;
            char cCharAt = str.charAt(charCount);
            if (!Bidi.IsBidiControlChar(cCharAt)) {
                sb.append(cCharAt);
            }
            if (i3 >= str.length()) {
                return sb.toString();
            }
            charCount = i3;
        }
    }

    public static String doWriteReverse(char[] cArr, int i, int i2, int i3) {
        return writeReverse(new String(cArr, i, i2 - i), i3);
    }

    public static String writeReordered(Bidi bidi, int i) {
        char[] cArr = bidi.text;
        int iCountRuns = bidi.countRuns();
        int i2 = bidi.reorderingOptions;
        if ((i2 & 1) != 0) {
            i = (i | 4) & (-9);
        }
        if ((i2 & 2) != 0) {
            i = (i | 8) & (-5);
        }
        int i3 = bidi.reorderingMode;
        if (i3 != 4 && i3 != 5 && i3 != 6 && i3 != 3) {
            i &= -5;
        }
        int i4 = i & 4;
        int i5 = bidi.length;
        if (i4 != 0) {
            i5 *= 2;
        }
        StringBuilder sb = new StringBuilder(i5);
        if ((i & 16) == 0) {
            if (i4 == 0) {
                for (int i6 = 0; i6 < iCountRuns; i6++) {
                    BidiRun visualRun = bidi.getVisualRun(i6);
                    boolean zIsEvenRun = visualRun.isEvenRun();
                    int i7 = visualRun.start;
                    if (zIsEvenRun) {
                        sb.append(doWriteForward(cArr, i7, visualRun.limit, i & (-3)));
                    } else {
                        sb.append(doWriteReverse(cArr, i7, visualRun.limit, i));
                    }
                }
            } else {
                byte[] bArr = bidi.dirProps;
                for (int i8 = 0; i8 < iCountRuns; i8++) {
                    BidiRun visualRun2 = bidi.getVisualRun(i8);
                    int i9 = bidi.runs[i8].insertRemove;
                    if (i9 < 0) {
                        i9 = 0;
                    }
                    if (visualRun2.isEvenRun()) {
                        if (bidi.isInverse() && bArr[visualRun2.start] != 0) {
                            i9 |= 1;
                        }
                        char c = (i9 & 1) != 0 ? (char) 8206 : (i9 & 4) != 0 ? (char) 8207 : (char) 0;
                        if (c != 0) {
                            sb.append(c);
                        }
                        sb.append(doWriteForward(cArr, visualRun2.start, visualRun2.limit, i & (-3)));
                        if (bidi.isInverse() && bArr[visualRun2.limit - 1] != 0) {
                            i9 |= 2;
                        }
                        char c2 = (i9 & 2) != 0 ? (char) 8206 : (i9 & 8) != 0 ? (char) 8207 : (char) 0;
                        if (c2 != 0) {
                            sb.append(c2);
                        }
                    } else {
                        if (bidi.isInverse() && !bidi.testDirPropFlagAt(MASK_R_AL, visualRun2.limit - 1)) {
                            i9 |= 4;
                        }
                        char c3 = (i9 & 1) != 0 ? (char) 8206 : (i9 & 4) != 0 ? (char) 8207 : (char) 0;
                        if (c3 != 0) {
                            sb.append(c3);
                        }
                        sb.append(doWriteReverse(cArr, visualRun2.start, visualRun2.limit, i));
                        if (bidi.isInverse() && (Bidi.DirPropFlag(bArr[visualRun2.start]) & MASK_R_AL) == 0) {
                            i9 |= 8;
                        }
                        char c4 = (i9 & 2) != 0 ? (char) 8206 : (i9 & 8) != 0 ? (char) 8207 : (char) 0;
                        if (c4 != 0) {
                            sb.append(c4);
                        }
                    }
                }
            }
        } else if (i4 != 0) {
            byte[] bArr2 = bidi.dirProps;
            while (true) {
                iCountRuns--;
                if (iCountRuns < 0) {
                    break;
                }
                BidiRun visualRun3 = bidi.getVisualRun(iCountRuns);
                if (visualRun3.isEvenRun()) {
                    if (bArr2[visualRun3.limit - 1] != 0) {
                        sb.append(LRM_CHAR);
                    }
                    sb.append(doWriteReverse(cArr, visualRun3.start, visualRun3.limit, i & (-3)));
                    if (bArr2[visualRun3.start] != 0) {
                        sb.append(LRM_CHAR);
                    }
                } else {
                    if ((Bidi.DirPropFlag(bArr2[visualRun3.start]) & MASK_R_AL) == 0) {
                        sb.append(RLM_CHAR);
                    }
                    sb.append(doWriteForward(cArr, visualRun3.start, visualRun3.limit, i));
                    if ((Bidi.DirPropFlag(bArr2[visualRun3.limit - 1]) & MASK_R_AL) == 0) {
                        sb.append(RLM_CHAR);
                    }
                }
            }
        } else {
            while (true) {
                iCountRuns--;
                if (iCountRuns < 0) {
                    break;
                }
                BidiRun visualRun4 = bidi.getVisualRun(iCountRuns);
                boolean zIsEvenRun2 = visualRun4.isEvenRun();
                int i10 = visualRun4.start;
                if (zIsEvenRun2) {
                    sb.append(doWriteReverse(cArr, i10, visualRun4.limit, i & (-3)));
                } else {
                    sb.append(doWriteForward(cArr, i10, visualRun4.limit, i));
                }
            }
        }
        return sb.toString();
    }

    public static String writeReverse(String str, int i) {
        int iCharAt;
        int i2;
        StringBuffer stringBuffer = new StringBuffer(str.length());
        int i3 = i & 11;
        if (i3 == 0) {
            int length = str.length();
            while (true) {
                int charCount = length - UTF16.getCharCount(UTF16.charAt(str, length - 1));
                stringBuffer.append(str.substring(charCount, length));
                if (charCount <= 0) {
                    break;
                }
                length = charCount;
            }
        } else if (i3 != 1) {
            int length2 = str.length();
            while (true) {
                int iCharAt2 = UTF16.charAt(str, length2 - 1);
                int charCount2 = length2 - UTF16.getCharCount(iCharAt2);
                if ((i & 1) != 0) {
                    while (charCount2 > 0 && IsCombining(UCharacter.getType(iCharAt2))) {
                        iCharAt2 = UTF16.charAt(str, charCount2 - 1);
                        charCount2 -= UTF16.getCharCount(iCharAt2);
                    }
                }
                if ((i & 8) == 0 || !Bidi.IsBidiControlChar(iCharAt2)) {
                    int charCount3 = UTF16.getCharCount(iCharAt2);
                    if ((i & 2) != 0) {
                        int mirror = UCharacter.getMirror(iCharAt2);
                        UTF16.append(stringBuffer, mirror);
                        if ((i & 64) != 0) {
                            charCount3 = UTF16.getCharCount(mirror);
                        }
                        i2 = charCount3 + charCount2;
                    } else {
                        i2 = charCount2;
                    }
                    stringBuffer.append(str.substring(i2, length2));
                }
                if (charCount2 <= 0) {
                    break;
                }
                length2 = charCount2;
            }
        } else {
            int length3 = str.length();
            while (true) {
                int charCount4 = length3;
                do {
                    iCharAt = UTF16.charAt(str, charCount4 - 1);
                    charCount4 -= UTF16.getCharCount(iCharAt);
                    if (charCount4 <= 0) {
                        break;
                    }
                } while (IsCombining(UCharacter.getType(iCharAt)));
                stringBuffer.append(str.substring(charCount4, length3));
                if (charCount4 <= 0) {
                    break;
                }
                length3 = charCount4;
            }
        }
        return stringBuffer.toString();
    }

    private static String doWriteForward(char[] cArr, int i, int i2, int i3) {
        return doWriteForward(new String(cArr, i, i2 - i), i3);
    }
}
