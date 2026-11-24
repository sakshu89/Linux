package com.ibm.icu.text;

import com.ibm.icu.impl.Normalizer2Impl;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UnicodeCompressor implements SCSU {
    private static boolean[] sSingleTagTable = {false, true, true, true, true, true, true, true, true, false, false, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    private static boolean[] sUnicodeTagTable = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false};
    private int fCurrentWindow = 0;
    private int[] fOffsets = new int[8];
    private int fMode = 0;
    private int[] fIndexCount = new int[256];
    private int[] fTimeStamps = new int[8];
    private int fTimeStamp = 0;

    public UnicodeCompressor() {
        reset();
    }

    private int findDynamicWindow(int i) {
        for (int i2 = 7; i2 >= 0; i2--) {
            if (inDynamicWindow(i, i2)) {
                int[] iArr = this.fTimeStamps;
                iArr[i2] = iArr[i2] + 1;
                return i2;
            }
        }
        return -1;
    }

    private static int findStaticWindow(int i) {
        for (int i2 = 7; i2 >= 0; i2--) {
            if (inStaticWindow(i, i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLRDefinedWindow() {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 7; i3 >= 0; i3--) {
            int i4 = this.fTimeStamps[i3];
            if (i4 < i) {
                i2 = i3;
                i = i4;
            }
        }
        return i2;
    }

    private boolean inDynamicWindow(int i, int i2) {
        int i3 = this.fOffsets[i2];
        return i >= i3 && i < i3 + 128;
    }

    private static boolean inStaticWindow(int i, int i2) {
        int i3 = SCSU.sOffsets[i2];
        return i >= i3 && i < i3 + 128;
    }

    private static boolean isCompressible(int i) {
        return i < 13312 || i >= 57344;
    }

    private static int makeIndex(int i) {
        int i2;
        if (i >= 192 && i < 320) {
            return 249;
        }
        if (i >= 592 && i < 720) {
            return 250;
        }
        if (i >= 880 && i < 1008) {
            return 251;
        }
        if (i >= 1328 && i < 1424) {
            return 252;
        }
        if (i >= 12352 && i < 12448) {
            return 253;
        }
        if (i >= 12448 && i < 12576) {
            return 254;
        }
        if (i >= 65376 && i < 65439) {
            return 255;
        }
        if (i >= 128 && i < 13312) {
            i2 = i / 128;
        } else {
            if (i < 57344 || i > 65535) {
                return 0;
            }
            i2 = (i - Normalizer2Impl.Hangul.HANGUL_BASE) / 128;
        }
        return i2 & 255;
    }

    public int compress(char[] cArr, int i, int i2, int[] iArr, byte[] bArr, int i3, int i4) {
        byte b;
        int i5;
        byte b2;
        byte b3 = 0;
        if (bArr.length < 4 || i4 - i3 < 4) {
            og.i("byteBuffer.length < 4");
            return 0;
        }
        int i6 = i;
        int i7 = i3;
        loop0: while (true) {
            if (i6 < i2 && i7 < i4) {
                int i8 = this.fMode;
                byte b4 = -16;
                if (i8 != 0) {
                    if (i8 == 1) {
                        while (true) {
                            if (i6 < i2 && i7 < i4) {
                                i6++;
                                char c = cArr[i6];
                                int i9 = i6 < i2 ? cArr[i6] : -1;
                                if (!isCompressible(c) || (i9 != -1 && !isCompressible(i9))) {
                                    b2 = b4;
                                    if (i7 + 2 < i4) {
                                        int i10 = c >>> '\b';
                                        int i11 = c & 255;
                                        if (sUnicodeTagTable[i10]) {
                                            bArr[i7] = b2;
                                            i7++;
                                        }
                                        int i12 = i7 + 1;
                                        bArr[i7] = (byte) i10;
                                        i7 += 2;
                                        bArr[i12] = (byte) i11;
                                        b4 = b2;
                                    }
                                } else if (c < 128) {
                                    int i13 = c & 255;
                                    if (i9 == -1 || i9 >= 128 || sSingleTagTable[i13]) {
                                        int i14 = i7 + 1;
                                        if (i14 < i4) {
                                            bArr[i7] = b3;
                                            i7 += 2;
                                            bArr[i14] = (byte) i13;
                                        }
                                    } else {
                                        int i15 = i7 + 1;
                                        if (i15 < i4) {
                                            int i16 = this.fCurrentWindow;
                                            bArr[i7] = (byte) (i16 + 224);
                                            i7 += 2;
                                            bArr[i15] = (byte) i13;
                                            int[] iArr2 = this.fTimeStamps;
                                            int i17 = this.fTimeStamp + 1;
                                            this.fTimeStamp = i17;
                                            iArr2[i16] = i17;
                                            this.fMode = b3;
                                            b = b3;
                                            i6 = i6;
                                        }
                                    }
                                } else {
                                    int iFindDynamicWindow = findDynamicWindow(c);
                                    if (iFindDynamicWindow == -1) {
                                        int iMakeIndex = makeIndex(c);
                                        int[] iArr3 = this.fIndexCount;
                                        b2 = b4;
                                        int i18 = iArr3[iMakeIndex] + 1;
                                        iArr3[iMakeIndex] = i18;
                                        int i19 = i6 + 2;
                                        int i20 = i19 < i2 ? cArr[i19] : -1;
                                        if (i18 > 1 || (iMakeIndex == makeIndex(i9) && iMakeIndex == makeIndex(i20))) {
                                            if (i7 + 2 < i4) {
                                                int lRDefinedWindow = getLRDefinedWindow();
                                                bArr[i7] = (byte) (lRDefinedWindow + 232);
                                                int i21 = i7 + 2;
                                                bArr[i7 + 1] = (byte) iMakeIndex;
                                                i7 += 3;
                                                int i22 = SCSU.sOffsetTable[iMakeIndex];
                                                bArr[i21] = (byte) ((c - i22) + 128);
                                                this.fOffsets[lRDefinedWindow] = i22;
                                                this.fCurrentWindow = lRDefinedWindow;
                                                int[] iArr4 = this.fTimeStamps;
                                                int i23 = this.fTimeStamp + 1;
                                                this.fTimeStamp = i23;
                                                iArr4[lRDefinedWindow] = i23;
                                                this.fMode = b3;
                                                b = b3;
                                                i6 = i6;
                                            }
                                        } else if (i7 + 2 < i4) {
                                            int i24 = c >>> '\b';
                                            int i25 = c & 255;
                                            if (sUnicodeTagTable[i24]) {
                                                bArr[i7] = b2;
                                                i7++;
                                            }
                                            int i26 = i7 + 1;
                                            bArr[i7] = (byte) i24;
                                            i7 += 2;
                                            bArr[i26] = (byte) i25;
                                            b4 = b2;
                                        }
                                    } else if (inDynamicWindow(i9, iFindDynamicWindow)) {
                                        int i27 = i7 + 1;
                                        if (i27 < i4) {
                                            bArr[i7] = (byte) (iFindDynamicWindow + 224);
                                            i7 += 2;
                                            bArr[i27] = (byte) ((c - this.fOffsets[iFindDynamicWindow]) + 128);
                                            int[] iArr5 = this.fTimeStamps;
                                            int i28 = this.fTimeStamp + 1;
                                            this.fTimeStamp = i28;
                                            iArr5[iFindDynamicWindow] = i28;
                                            this.fCurrentWindow = iFindDynamicWindow;
                                            this.fMode = b3;
                                            b = b3;
                                            i6 = i6;
                                        }
                                    } else if (i7 + 2 < i4) {
                                        int i29 = c >>> '\b';
                                        int i30 = c & 255;
                                        if (sUnicodeTagTable[i29]) {
                                            bArr[i7] = b4;
                                            i7++;
                                        }
                                        int i31 = i7 + 1;
                                        bArr[i7] = (byte) i29;
                                        i7 += 2;
                                        bArr[i31] = (byte) i30;
                                    }
                                }
                            }
                        }
                    }
                    b = b3;
                } else {
                    while (true) {
                        if (i6 >= i2 || i7 >= i4) {
                            b = b3;
                        } else {
                            i6++;
                            char c2 = cArr[i6];
                            int i32 = i6 < i2 ? cArr[i6] : -1;
                            if (c2 < 128) {
                                int i33 = c2 & 255;
                                if (sSingleTagTable[i33]) {
                                    int i34 = i7 + 1;
                                    if (i34 < i4) {
                                        bArr[i7] = 1;
                                        i7 = i34;
                                    }
                                }
                                i5 = i7 + 1;
                                bArr[i7] = (byte) i33;
                                i7 = i5;
                            } else if (inDynamicWindow(c2, this.fCurrentWindow)) {
                                i5 = i7 + 1;
                                bArr[i7] = (byte) ((c2 - this.fOffsets[this.fCurrentWindow]) + 128);
                                i7 = i5;
                            } else if (isCompressible(c2)) {
                                int iFindDynamicWindow2 = findDynamicWindow(c2);
                                if (iFindDynamicWindow2 != -1) {
                                    int i35 = i6 + 2;
                                    int i36 = i35 < i2 ? cArr[i35] : -1;
                                    if (inDynamicWindow(i32, iFindDynamicWindow2) && inDynamicWindow(i36, iFindDynamicWindow2)) {
                                        int i37 = i7 + 1;
                                        if (i37 < i4) {
                                            bArr[i7] = (byte) (iFindDynamicWindow2 + 16);
                                            i7 += 2;
                                            bArr[i37] = (byte) ((c2 - this.fOffsets[iFindDynamicWindow2]) + 128);
                                            int[] iArr6 = this.fTimeStamps;
                                            int i38 = this.fTimeStamp + 1;
                                            this.fTimeStamp = i38;
                                            iArr6[iFindDynamicWindow2] = i38;
                                            this.fCurrentWindow = iFindDynamicWindow2;
                                        }
                                    } else {
                                        int i39 = i7 + 1;
                                        if (i39 < i4) {
                                            bArr[i7] = (byte) (iFindDynamicWindow2 + 1);
                                            i7 += 2;
                                            bArr[i39] = (byte) ((c2 - this.fOffsets[iFindDynamicWindow2]) + 128);
                                        }
                                    }
                                } else {
                                    int iFindStaticWindow = findStaticWindow(c2);
                                    if (iFindStaticWindow == -1 || inStaticWindow(i32, iFindStaticWindow)) {
                                        int iMakeIndex2 = makeIndex(c2);
                                        int[] iArr7 = this.fIndexCount;
                                        b = b3;
                                        int i40 = iArr7[iMakeIndex2] + 1;
                                        iArr7[iMakeIndex2] = i40;
                                        int i41 = i6 + 2;
                                        int i42 = i41 < i2 ? cArr[i41] : -1;
                                        if (i40 > 1 || (iMakeIndex2 == makeIndex(i32) && iMakeIndex2 == makeIndex(i42))) {
                                            if (i7 + 2 >= i4) {
                                                break loop0;
                                            }
                                            int lRDefinedWindow2 = getLRDefinedWindow();
                                            bArr[i7] = (byte) (lRDefinedWindow2 + 24);
                                            int i43 = i7 + 2;
                                            bArr[i7 + 1] = (byte) iMakeIndex2;
                                            i7 += 3;
                                            int i44 = SCSU.sOffsetTable[iMakeIndex2];
                                            bArr[i43] = (byte) ((c2 - i44) + 128);
                                            this.fOffsets[lRDefinedWindow2] = i44;
                                            this.fCurrentWindow = lRDefinedWindow2;
                                            int[] iArr8 = this.fTimeStamps;
                                            int i45 = this.fTimeStamp + 1;
                                            this.fTimeStamp = i45;
                                            iArr8[lRDefinedWindow2] = i45;
                                            b3 = b;
                                        } else {
                                            if (i7 + 3 >= i4) {
                                                break;
                                            }
                                            int i46 = i7 + 1;
                                            bArr[i7] = 15;
                                            int i47 = c2 >>> '\b';
                                            int i48 = c2 & 255;
                                            if (sUnicodeTagTable[i47]) {
                                                bArr[i46] = -16;
                                                i46 = i7 + 2;
                                            }
                                            bArr[i46] = (byte) i47;
                                            bArr[i46 + 1] = (byte) i48;
                                            this.fMode = 1;
                                            i7 = i46 + 2;
                                            i6 = i6;
                                        }
                                    } else {
                                        int i49 = i7 + 1;
                                        if (i49 < i4) {
                                            bArr[i7] = (byte) (iFindStaticWindow + 1);
                                            i7 += 2;
                                            bArr[i49] = (byte) (c2 - SCSU.sOffsets[iFindStaticWindow]);
                                        }
                                    }
                                }
                            } else if (i32 == -1 || !isCompressible(i32)) {
                                if (i7 + 3 < i4) {
                                    int i50 = i7 + 1;
                                    bArr[i7] = 15;
                                    int i51 = c2 >>> '\b';
                                    int i52 = c2 & 255;
                                    if (sUnicodeTagTable[i51]) {
                                        bArr[i50] = -16;
                                        i50 = i7 + 2;
                                    }
                                    bArr[i50] = (byte) i51;
                                    bArr[i50 + 1] = (byte) i52;
                                    this.fMode = 1;
                                    i7 = i50 + 2;
                                    b = b3;
                                    i6 = i6;
                                }
                            } else if (i7 + 2 < i4) {
                                bArr[i7] = 14;
                                int i53 = i7 + 2;
                                bArr[i7 + 1] = (byte) (c2 >>> '\b');
                                i7 += 3;
                                bArr[i53] = (byte) (c2 & 255);
                            }
                        }
                    }
                }
                b3 = b;
            }
            b = b3;
            break;
        }
        if (iArr != null) {
            iArr[b] = i6 - i;
        }
        return i7 - i3;
    }

    public void reset() {
        int[] iArr = this.fOffsets;
        iArr[0] = 128;
        iArr[1] = 192;
        iArr[2] = 1024;
        iArr[3] = 1536;
        iArr[4] = 2304;
        iArr[5] = 12352;
        iArr[6] = 12448;
        iArr[7] = 65280;
        for (int i = 0; i < 8; i++) {
            this.fTimeStamps[i] = 0;
        }
        for (int i2 = 0; i2 <= 255; i2++) {
            this.fIndexCount[i2] = 0;
        }
        this.fTimeStamp = 0;
        this.fCurrentWindow = 0;
        this.fMode = 0;
    }

    public static byte[] compress(char[] cArr, int i, int i2) {
        UnicodeCompressor unicodeCompressor = new UnicodeCompressor();
        int iMax = Math.max(4, ((i2 - i) * 3) + 1);
        byte[] bArr = new byte[iMax];
        int iCompress = unicodeCompressor.compress(cArr, i, i2, null, bArr, 0, iMax);
        byte[] bArr2 = new byte[iCompress];
        System.arraycopy(bArr, 0, bArr2, 0, iCompress);
        return bArr2;
    }

    public static byte[] compress(String str) {
        return compress(str.toCharArray(), 0, str.length());
    }
}
