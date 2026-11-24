package com.ibm.icu.text;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.nio.CharBuffer;
import java.text.CharacterIterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Normalizer implements Cloneable {
    public static final int COMPARE_CODE_POINT_ORDER = 32768;
    private static final int COMPARE_EQUIV = 524288;
    public static final int COMPARE_IGNORE_CASE = 65536;

    @Deprecated
    public static final int COMPARE_NORM_OPTIONS_SHIFT = 20;

    @Deprecated
    public static final Mode COMPOSE;

    @Deprecated
    public static final Mode COMPOSE_COMPAT;

    @Deprecated
    public static final Mode DECOMP;

    @Deprecated
    public static final Mode DECOMP_COMPAT;

    @Deprecated
    public static final Mode DEFAULT;

    @Deprecated
    public static final int DONE = -1;

    @Deprecated
    public static final Mode FCD;
    public static final int FOLD_CASE_DEFAULT = 0;
    public static final int FOLD_CASE_EXCLUDE_SPECIAL_I = 1;

    @Deprecated
    public static final int IGNORE_HANGUL = 1;
    public static final int INPUT_IS_FCD = 131072;
    public static final QuickCheckResult MAYBE;

    @Deprecated
    public static final Mode NFC;

    @Deprecated
    public static final Mode NFD;

    @Deprecated
    public static final Mode NFKC;

    @Deprecated
    public static final Mode NFKD;
    public static final QuickCheckResult NO;

    @Deprecated
    public static final Mode NONE;

    @Deprecated
    public static final Mode NO_OP;

    @Deprecated
    public static final int UNICODE_3_2 = 32;
    public static final QuickCheckResult YES;
    private StringBuilder buffer;
    private int bufferPos;
    private int currentIndex;
    private Mode mode;
    private int nextIndex;
    private Normalizer2 norm2;
    private int options;
    private UCharacterIterator text;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class FCD32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Norm2AllModes.getFCDNormalizer2(), Unicode32.INSTANCE), 0);

        private FCD32ModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class FCDModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Norm2AllModes.getFCDNormalizer2(), 0);

        private FCDModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static abstract class Mode {
        @Deprecated
        public Mode() {
        }

        @Deprecated
        public abstract Normalizer2 getNormalizer2(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFC32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Normalizer2.getNFCInstance(), Unicode32.INSTANCE), 0);

        private NFC32ModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFCModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Normalizer2.getNFCInstance(), 0);

        private NFCModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFD32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Normalizer2.getNFDInstance(), Unicode32.INSTANCE), 0);

        private NFD32ModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFDModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Normalizer2.getNFDInstance(), 0);

        private NFDModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFKC32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Normalizer2.getNFKCInstance(), Unicode32.INSTANCE), 0);

        private NFKC32ModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFKCModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Normalizer2.getNFKCInstance(), 0);

        private NFKCModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFKD32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Normalizer2.getNFKDInstance(), Unicode32.INSTANCE), 0);

        private NFKD32ModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFKDModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Normalizer2.getNFKDInstance(), 0);

        private NFKDModeImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Unicode32 {
        private static final UnicodeSet INSTANCE = new UnicodeSet("[:age=3.2:]").freeze();

        private Unicode32() {
        }
    }

    static {
        int i = 0;
        NONEMode nONEMode = new NONEMode(i);
        NONE = nONEMode;
        NFDMode nFDMode = new NFDMode(i);
        NFD = nFDMode;
        NFKDMode nFKDMode = new NFKDMode(i);
        NFKD = nFKDMode;
        NFCMode nFCMode = new NFCMode(i);
        NFC = nFCMode;
        DEFAULT = nFCMode;
        NFKCMode nFKCMode = new NFKCMode(i);
        NFKC = nFKCMode;
        FCD = new FCDMode(i);
        NO_OP = nONEMode;
        COMPOSE = nFCMode;
        COMPOSE_COMPAT = nFKCMode;
        DECOMP = nFDMode;
        DECOMP_COMPAT = nFKDMode;
        NO = new QuickCheckResult(i, i);
        YES = new QuickCheckResult(1, i);
        MAYBE = new QuickCheckResult(2, i);
    }

    @Deprecated
    public Normalizer(UCharacterIterator uCharacterIterator, Mode mode, int i) {
        try {
            this.text = uCharacterIterator.mo2clone();
            this.mode = mode;
            this.options = i;
            this.norm2 = mode.getNormalizer2(i);
            this.buffer = new StringBuilder();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    private void clearBuffer() {
        this.buffer.setLength(0);
        this.bufferPos = 0;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00de  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f9 A[PHI: r20 r23
      0x00f9: PHI (r20v7 int) = (r20v8 int), (r20v16 int), (r20v16 int) binds: [B:49:0x00db, B:52:0x00e7, B:54:0x00f1] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r23v0 int) = (r23v1 int), (r23v3 int), (r23v3 int) binds: [B:49:0x00db, B:52:0x00e7, B:54:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x0133 A[PHI: r24
      0x0133: PHI (r24v1 int) = (r24v0 int), (r24v7 int), (r24v7 int) binds: [B:65:0x011a, B:67:0x0121, B:69:0x012b] A[DONT_GENERATE, DONT_INLINE]] */
    public static int cmpEquivFold(CharSequence charSequence, CharSequence charSequence2, int i) {
        UCaseProps uCaseProps;
        StringBuilder sb;
        StringBuilder sb2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int codePoint;
        int i7;
        int codePoint2;
        StringBuilder sb3;
        int i8;
        String decomposition;
        int i9;
        String decomposition2;
        int i10;
        int fullFolding;
        CmpEquivLevel cmpEquivLevel;
        CharSequence charSequence3;
        CmpEquivLevel cmpEquivLevel2;
        CharSequence charSequence4;
        int i11 = 524288 & i;
        Normalizer2Impl normalizer2Impl = i11 != 0 ? Norm2AllModes.getNFCInstance().impl : null;
        int i12 = 65536 & i;
        if (i12 != 0) {
            uCaseProps = UCaseProps.INSTANCE;
            sb = new StringBuilder();
            sb2 = new StringBuilder();
        } else {
            uCaseProps = null;
            sb = null;
            sb2 = null;
        }
        int i13 = -1;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int iCharAt = -1;
        int iCharAt2 = -1;
        int i14 = 0;
        int i15 = 0;
        CmpEquivLevel[] cmpEquivLevelArrCreateCmpEquivLevelStack = null;
        int i16 = 0;
        int i17 = 0;
        CmpEquivLevel[] cmpEquivLevelArrCreateCmpEquivLevelStack2 = null;
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        while (true) {
            if (iCharAt >= 0) {
                int i18 = i14;
                i2 = i13;
                i14 = i18;
                i3 = i15;
                break;
            }
            int i19 = i15;
            while (true) {
                if (i19 != length) {
                    i15 = i19 + 1;
                    iCharAt = charSequence5.charAt(i19);
                    int i110 = i14;
                    i2 = i13;
                    i14 = i110;
                    i3 = i15;
                    break;
                }
                if (i14 == 0) {
                    i3 = i19;
                    iCharAt = i13;
                    i14 = i14;
                    i2 = iCharAt;
                    break;
                }
                do {
                    i14--;
                    cmpEquivLevel2 = cmpEquivLevelArrCreateCmpEquivLevelStack[i14];
                    charSequence4 = cmpEquivLevel2.cs;
                } while (charSequence4 == null);
                i19 = cmpEquivLevel2.s;
                length = charSequence4.length();
                charSequence5 = charSequence4;
            }
            if (iCharAt2 >= 0) {
                i4 = i16;
                i5 = i17;
                break;
            }
            int i20 = i17;
            while (true) {
                if (i20 != length2) {
                    i17 = i20 + 1;
                    iCharAt2 = charSequence6.charAt(i20);
                    i4 = i16;
                    i5 = i17;
                    break;
                }
                if (i16 == 0) {
                    i5 = i20;
                    iCharAt2 = i2;
                    i4 = i16;
                    break;
                }
                do {
                    i16--;
                    cmpEquivLevel = cmpEquivLevelArrCreateCmpEquivLevelStack2[i16];
                    charSequence3 = cmpEquivLevel.cs;
                } while (charSequence3 == null);
                i20 = cmpEquivLevel.s;
                length2 = charSequence3.length();
                charSequence6 = charSequence3;
            }
            if (iCharAt == iCharAt2) {
                if (iCharAt < 0) {
                    return 0;
                }
                i15 = i3;
                i17 = i5;
                iCharAt = i2;
                iCharAt2 = iCharAt;
                i16 = i4;
                i14 = i14;
                i13 = iCharAt2;
            } else {
                if (iCharAt < 0) {
                    return i2;
                }
                if (iCharAt2 < 0) {
                    return 1;
                }
                if (!UTF16.isSurrogate(iCharAt)) {
                    i11 = i11;
                    i6 = i12;
                    codePoint = iCharAt;
                } else if (Normalizer2Impl.UTF16Plus.isSurrogateLead(iCharAt)) {
                    if (i3 != length) {
                        i11 = i11;
                        char cCharAt = charSequence5.charAt(i3);
                        if (Character.isLowSurrogate(cCharAt)) {
                            i6 = i12;
                            codePoint = Character.toCodePoint((char) iCharAt, cCharAt);
                        }
                    } else {
                        i11 = i11;
                    }
                    i6 = i12;
                    codePoint = iCharAt;
                } else {
                    i11 = i11;
                    i6 = i12;
                    int i21 = i3 - 2;
                    if (i21 >= 0) {
                        char cCharAt2 = charSequence5.charAt(i21);
                        if (Character.isHighSurrogate(cCharAt2)) {
                            codePoint = Character.toCodePoint(cCharAt2, (char) iCharAt);
                        } else {
                            codePoint = iCharAt;
                        }
                    } else {
                        codePoint = iCharAt;
                    }
                }
                if (!UTF16.isSurrogate(iCharAt2)) {
                    i7 = i5;
                    codePoint2 = iCharAt2;
                } else if (Normalizer2Impl.UTF16Plus.isSurrogateLead(iCharAt2)) {
                    if (i5 != length2) {
                        char cCharAt3 = charSequence6.charAt(i5);
                        if (Character.isLowSurrogate(cCharAt3)) {
                            i7 = i5;
                            codePoint2 = Character.toCodePoint((char) iCharAt2, cCharAt3);
                        }
                    }
                    i7 = i5;
                    codePoint2 = iCharAt2;
                } else {
                    i7 = i5;
                    int i22 = i7 - 2;
                    if (i22 >= 0) {
                        char cCharAt4 = charSequence6.charAt(i22);
                        if (Character.isHighSurrogate(cCharAt4)) {
                            codePoint2 = Character.toCodePoint(cCharAt4, (char) iCharAt2);
                        } else {
                            codePoint2 = iCharAt2;
                        }
                    } else {
                        codePoint2 = iCharAt2;
                    }
                }
                if (i14 != 0 || i6 == 0 || (fullFolding = uCaseProps.toFullFolding(codePoint, sb, i)) < 0) {
                    int i23 = i4;
                    if (i23 != 0 || i6 == 0) {
                        sb3 = sb;
                    } else {
                        sb3 = sb;
                        int fullFolding2 = uCaseProps.toFullFolding(codePoint2, sb2, i);
                        if (fullFolding2 >= 0) {
                            if (!UTF16.isSurrogate(iCharAt2)) {
                                i10 = i7;
                            } else if (Normalizer2Impl.UTF16Plus.isSurrogateLead(iCharAt2)) {
                                i10 = i7 + 1;
                            } else {
                                iCharAt = charSequence5.charAt(i3 - 2);
                                i3--;
                                i10 = i7;
                            }
                            if (cmpEquivLevelArrCreateCmpEquivLevelStack2 == null) {
                                cmpEquivLevelArrCreateCmpEquivLevelStack2 = createCmpEquivLevelStack();
                            }
                            CmpEquivLevel cmpEquivLevel3 = cmpEquivLevelArrCreateCmpEquivLevelStack2[0];
                            cmpEquivLevel3.cs = charSequence6;
                            cmpEquivLevel3.s = i10;
                            i16 = i23 + 1;
                            if (fullFolding2 <= 31) {
                                sb2.delete(0, sb2.length() - fullFolding2);
                            } else {
                                sb2.setLength(0);
                                sb2.appendCodePoint(fullFolding2);
                            }
                            length2 = sb2.length();
                            i15 = i3;
                            charSequence6 = sb2;
                            iCharAt2 = i2;
                            sb = sb3;
                            i17 = 0;
                            i13 = iCharAt2;
                        }
                        i12 = i6;
                    }
                    if (i14 < 2 && i11 != 0 && (decomposition2 = normalizer2Impl.getDecomposition(codePoint)) != null) {
                        if (UTF16.isSurrogate(iCharAt)) {
                            if (Normalizer2Impl.UTF16Plus.isSurrogateLead(iCharAt)) {
                                i3++;
                            } else {
                                char cCharAt5 = charSequence6.charAt(i7 - 2);
                                i7--;
                                iCharAt2 = cCharAt5;
                            }
                        }
                        if (cmpEquivLevelArrCreateCmpEquivLevelStack == null) {
                            cmpEquivLevelArrCreateCmpEquivLevelStack = createCmpEquivLevelStack();
                        }
                        CmpEquivLevel cmpEquivLevel4 = cmpEquivLevelArrCreateCmpEquivLevelStack[i14];
                        cmpEquivLevel4.cs = charSequence5;
                        cmpEquivLevel4.s = i3;
                        int i24 = i14 + 1;
                        if (i24 < 2) {
                            cmpEquivLevelArrCreateCmpEquivLevelStack[i24].cs = null;
                            i24 = i14 + 2;
                        }
                        length = decomposition2.length();
                        charSequence5 = decomposition2;
                        i13 = i2;
                        iCharAt = i13;
                        i15 = 0;
                        i11 = i11;
                        sb = sb3;
                        i12 = i6;
                        i17 = i7;
                        i14 = i24;
                        i16 = i23;
                    } else {
                        if (i23 >= 2 || i11 == 0 || (decomposition = normalizer2Impl.getDecomposition(codePoint2)) == null) {
                            if (iCharAt >= 55296 && iCharAt2 >= 55296 && (i & 32768) != 0) {
                                if ((iCharAt > 56319 || i3 == length || !Character.isLowSurrogate(charSequence5.charAt(i3))) && (!Character.isLowSurrogate((char) iCharAt) || i3 - 1 == 0 || !Character.isHighSurrogate(charSequence5.charAt(i3 - 2)))) {
                                    iCharAt -= 10240;
                                }
                                if (iCharAt2 <= 56319) {
                                    i8 = i7;
                                    if (i8 == length2 || !Character.isLowSurrogate(charSequence6.charAt(i8))) {
                                    }
                                } else {
                                    i8 = i7;
                                }
                                if (!Character.isLowSurrogate((char) iCharAt2) || i8 - 1 == 0 || !Character.isHighSurrogate(charSequence6.charAt(i8 - 2))) {
                                    iCharAt2 -= 10240;
                                }
                            }
                            return iCharAt - iCharAt2;
                        }
                        if (!UTF16.isSurrogate(iCharAt2)) {
                            i9 = i7;
                        } else if (Normalizer2Impl.UTF16Plus.isSurrogateLead(iCharAt2)) {
                            i9 = i7 + 1;
                        } else {
                            iCharAt = charSequence5.charAt(i3 - 2);
                            i3--;
                            i9 = i7;
                        }
                        if (cmpEquivLevelArrCreateCmpEquivLevelStack2 == null) {
                            cmpEquivLevelArrCreateCmpEquivLevelStack2 = createCmpEquivLevelStack();
                        }
                        CmpEquivLevel cmpEquivLevel5 = cmpEquivLevelArrCreateCmpEquivLevelStack2[i23];
                        cmpEquivLevel5.cs = charSequence6;
                        cmpEquivLevel5.s = i9;
                        int i25 = i23 + 1;
                        if (i25 < 2) {
                            cmpEquivLevelArrCreateCmpEquivLevelStack2[i25].cs = null;
                            i25 = i23 + 2;
                        }
                        length2 = decomposition.length();
                        charSequence6 = decomposition;
                        i15 = i3;
                        iCharAt2 = i2;
                        sb = sb3;
                        i13 = iCharAt2;
                        i17 = 0;
                        i16 = i25;
                        i12 = i6;
                    }
                } else {
                    if (UTF16.isSurrogate(iCharAt)) {
                        if (Normalizer2Impl.UTF16Plus.isSurrogateLead(iCharAt)) {
                            i3++;
                        } else {
                            char cCharAt6 = charSequence6.charAt(i7 - 2);
                            i7--;
                            iCharAt2 = cCharAt6;
                        }
                    }
                    if (cmpEquivLevelArrCreateCmpEquivLevelStack == null) {
                        cmpEquivLevelArrCreateCmpEquivLevelStack = createCmpEquivLevelStack();
                    }
                    CmpEquivLevel cmpEquivLevel6 = cmpEquivLevelArrCreateCmpEquivLevelStack[0];
                    cmpEquivLevel6.cs = charSequence5;
                    cmpEquivLevel6.s = i3;
                    int i26 = i14 + 1;
                    if (fullFolding <= 31) {
                        sb.delete(0, sb.length() - fullFolding);
                    } else {
                        sb.setLength(0);
                        sb.appendCodePoint(fullFolding);
                    }
                    length = sb.length();
                    charSequence5 = sb;
                    i13 = i2;
                    iCharAt = i13;
                    i16 = i4;
                    i12 = i6;
                    i15 = 0;
                    i14 = i26;
                    i11 = i11;
                    i17 = i7;
                }
            }
        }
    }

    public static int compare(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, int i5) {
        if (cArr != null && i >= 0 && i2 >= 0 && cArr2 != null && i3 >= 0 && i4 >= 0 && i2 >= i && i4 >= i3) {
            return internalCompare(CharBuffer.wrap(cArr, i, i2 - i), CharBuffer.wrap(cArr2, i3, i4 - i3), i5);
        }
        dk0.v();
        return 0;
    }

    @Deprecated
    public static int compose(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, boolean z, int i5) {
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr, i, i2 - i);
        CharsAppendable charsAppendable = new CharsAppendable(cArr2, i3, i4);
        getComposeNormalizer2(z, i5).normalize(charBufferWrap, charsAppendable);
        return charsAppendable.length();
    }

    @Deprecated
    public static int concatenate(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6, Mode mode, int i7) {
        if (cArr3 == null) {
            dk0.v();
            return 0;
        }
        if (cArr2 == cArr3 && i3 < i6 && i5 < i4) {
            og.i("overlapping right and dst ranges");
            return 0;
        }
        int i8 = i2 - i;
        StringBuilder sb = new StringBuilder(((i8 + i4) - i3) + 16);
        sb.append(cArr, i, i8);
        mode.getNormalizer2(i7).append(sb, CharBuffer.wrap(cArr2, i3, i4 - i3));
        int length = sb.length();
        if (length <= i6 - i5) {
            sb.getChars(0, length, cArr3, i5);
            return length;
        }
        og.o(Integer.toString(length));
        return 0;
    }

    private static final CmpEquivLevel[] createCmpEquivLevelStack() {
        int i = 0;
        return new CmpEquivLevel[]{new CmpEquivLevel(i), new CmpEquivLevel(i)};
    }

    @Deprecated
    public static int decompose(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, boolean z, int i5) {
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr, i, i2 - i);
        CharsAppendable charsAppendable = new CharsAppendable(cArr2, i3, i4);
        getDecomposeNormalizer2(z, i5).normalize(charBufferWrap, charsAppendable);
        return charsAppendable.length();
    }

    private static final Normalizer2 getComposeNormalizer2(boolean z, int i) {
        return (z ? NFKC : NFC).getNormalizer2(i);
    }

    private static final Normalizer2 getDecomposeNormalizer2(boolean z, int i) {
        return (z ? NFKD : NFD).getNormalizer2(i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Deprecated
    public static String getFC_NFKC_Closure(int i) {
        Normalizer2 normalizer2 = NFKCModeImpl.INSTANCE.normalizer2;
        UCaseProps uCaseProps = UCaseProps.INSTANCE;
        StringBuilder sb = new StringBuilder();
        int fullFolding = uCaseProps.toFullFolding(i, sb, 0);
        if (fullFolding < 0) {
            Normalizer2Impl normalizer2Impl = ((Norm2AllModes.Normalizer2WithImpl) normalizer2).impl;
            if (normalizer2Impl.getCompQuickCheck(normalizer2Impl.getNorm16(i)) != 0) {
                return "";
            }
            sb.appendCodePoint(i);
        } else if (fullFolding > 31) {
            sb.appendCodePoint(fullFolding);
        }
        String strNormalize = normalizer2.normalize(sb);
        String strNormalize2 = normalizer2.normalize(UCharacter.foldCase(strNormalize, 0));
        return strNormalize.equals(strNormalize2) ? "" : strNormalize2;
    }

    private static int internalCompare(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2 = i >>> 20;
        int i3 = i | 524288;
        if ((131072 & i3) == 0 || (i3 & 1) != 0) {
            Normalizer2 normalizer2 = (i3 & 1) != 0 ? NFD.getNormalizer2(i2) : FCD.getNormalizer2(i2);
            int iSpanQuickCheckYes = normalizer2.spanQuickCheckYes(charSequence);
            int iSpanQuickCheckYes2 = normalizer2.spanQuickCheckYes(charSequence2);
            if (iSpanQuickCheckYes < charSequence.length()) {
                StringBuilder sb = new StringBuilder(charSequence.length() + 16);
                sb.append(charSequence, 0, iSpanQuickCheckYes);
                charSequence = normalizer2.normalizeSecondAndAppend(sb, charSequence.subSequence(iSpanQuickCheckYes, charSequence.length()));
            }
            if (iSpanQuickCheckYes2 < charSequence2.length()) {
                StringBuilder sb2 = new StringBuilder(charSequence2.length() + 16);
                sb2.append(charSequence2, 0, iSpanQuickCheckYes2);
                charSequence2 = normalizer2.normalizeSecondAndAppend(sb2, charSequence2.subSequence(iSpanQuickCheckYes2, charSequence2.length()));
            }
        }
        return cmpEquivFold(charSequence, charSequence2, i3);
    }

    @Deprecated
    public static boolean isNormalized(char[] cArr, int i, int i2, Mode mode, int i3) {
        return mode.getNormalizer2(i3).isNormalized(CharBuffer.wrap(cArr, i, i2 - i));
    }

    private boolean nextNormalize() {
        clearBuffer();
        int i = this.nextIndex;
        this.currentIndex = i;
        this.text.setIndex(i);
        int iNextCodePoint = this.text.nextCodePoint();
        if (iNextCodePoint < 0) {
            return false;
        }
        StringBuilder sbAppendCodePoint = new StringBuilder().appendCodePoint(iNextCodePoint);
        while (true) {
            int iNextCodePoint2 = this.text.nextCodePoint();
            if (iNextCodePoint2 < 0) {
                break;
            }
            if (this.norm2.hasBoundaryBefore(iNextCodePoint2)) {
                this.text.moveCodePointIndex(-1);
                break;
            }
            sbAppendCodePoint.appendCodePoint(iNextCodePoint2);
        }
        this.nextIndex = this.text.getIndex();
        this.norm2.normalize((CharSequence) sbAppendCodePoint, this.buffer);
        return this.buffer.length() != 0;
    }

    @Deprecated
    public static String normalize(int i, Mode mode, int i2) {
        if (mode != NFD || i2 != 0) {
            return normalize(UTF16.valueOf(i), mode, i2);
        }
        String decomposition = Normalizer2.getNFCInstance().getDecomposition(i);
        return decomposition == null ? UTF16.valueOf(i) : decomposition;
    }

    private boolean previousNormalize() {
        int iPreviousCodePoint;
        clearBuffer();
        int i = this.currentIndex;
        this.nextIndex = i;
        this.text.setIndex(i);
        StringBuilder sb = new StringBuilder();
        do {
            iPreviousCodePoint = this.text.previousCodePoint();
            if (iPreviousCodePoint < 0) {
                break;
            }
            if (iPreviousCodePoint <= 65535) {
                sb.insert(0, (char) iPreviousCodePoint);
            } else {
                sb.insert(0, Character.toChars(iPreviousCodePoint));
            }
        } while (!this.norm2.hasBoundaryBefore(iPreviousCodePoint));
        this.currentIndex = this.text.getIndex();
        this.norm2.normalize((CharSequence) sb, this.buffer);
        this.bufferPos = this.buffer.length();
        return this.buffer.length() != 0;
    }

    @Deprecated
    public static QuickCheckResult quickCheck(char[] cArr, int i, int i2, Mode mode, int i3) {
        return mode.getNormalizer2(i3).quickCheck(CharBuffer.wrap(cArr, i, i2 - i));
    }

    @Deprecated
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Normalizer m19clone() {
        try {
            Normalizer normalizer = (Normalizer) super.clone();
            normalizer.text = this.text.mo2clone();
            normalizer.mode = this.mode;
            normalizer.options = this.options;
            normalizer.norm2 = this.norm2;
            normalizer.buffer = new StringBuilder(this.buffer);
            normalizer.bufferPos = this.bufferPos;
            normalizer.currentIndex = this.currentIndex;
            normalizer.nextIndex = this.nextIndex;
            return normalizer;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Deprecated
    public int current() {
        if (this.bufferPos < this.buffer.length() || nextNormalize()) {
            return this.buffer.codePointAt(this.bufferPos);
        }
        return -1;
    }

    @Deprecated
    public int endIndex() {
        return this.text.getLength();
    }

    @Deprecated
    public int first() {
        reset();
        return next();
    }

    @Deprecated
    public int getBeginIndex() {
        return 0;
    }

    @Deprecated
    public int getEndIndex() {
        return endIndex();
    }

    @Deprecated
    public int getIndex() {
        return this.bufferPos < this.buffer.length() ? this.currentIndex : this.nextIndex;
    }

    @Deprecated
    public int getLength() {
        return this.text.getLength();
    }

    @Deprecated
    public Mode getMode() {
        return this.mode;
    }

    @Deprecated
    public int getOption(int i) {
        return (this.options & i) != 0 ? 1 : 0;
    }

    @Deprecated
    public int getText(char[] cArr) {
        return this.text.getText(cArr);
    }

    @Deprecated
    public int last() {
        this.text.setToLimit();
        int index = this.text.getIndex();
        this.nextIndex = index;
        this.currentIndex = index;
        clearBuffer();
        return previous();
    }

    @Deprecated
    public int next() {
        if (this.bufferPos >= this.buffer.length() && !nextNormalize()) {
            return -1;
        }
        int iCodePointAt = this.buffer.codePointAt(this.bufferPos);
        this.bufferPos = Character.charCount(iCodePointAt) + this.bufferPos;
        return iCodePointAt;
    }

    @Deprecated
    public int previous() {
        if (this.bufferPos <= 0 && !previousNormalize()) {
            return -1;
        }
        int iCodePointBefore = this.buffer.codePointBefore(this.bufferPos);
        this.bufferPos -= Character.charCount(iCodePointBefore);
        return iCodePointBefore;
    }

    @Deprecated
    public void reset() {
        this.text.setToStart();
        this.nextIndex = 0;
        this.currentIndex = 0;
        clearBuffer();
    }

    @Deprecated
    public int setIndex(int i) {
        setIndexOnly(i);
        return current();
    }

    @Deprecated
    public void setIndexOnly(int i) {
        this.text.setIndex(i);
        this.nextIndex = i;
        this.currentIndex = i;
        clearBuffer();
    }

    @Deprecated
    public void setMode(Mode mode) {
        this.mode = mode;
        this.norm2 = mode.getNormalizer2(this.options);
    }

    @Deprecated
    public void setOption(int i, boolean z) {
        int i2 = this.options;
        if (z) {
            this.options = i | i2;
        } else {
            this.options = (~i) & i2;
        }
        this.norm2 = this.mode.getNormalizer2(this.options);
    }

    @Deprecated
    public void setText(UCharacterIterator uCharacterIterator) {
        try {
            UCharacterIterator uCharacterIteratorClone = uCharacterIterator.mo2clone();
            if (uCharacterIteratorClone == null) {
                throw new IllegalStateException("Could not create a new UCharacterIterator");
            }
            this.text = uCharacterIteratorClone;
            reset();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException("Could not clone the UCharacterIterator", e);
        }
    }

    @Deprecated
    public int startIndex() {
        return 0;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CmpEquivLevel {
        CharSequence cs;
        int s;

        public /* synthetic */ CmpEquivLevel(int i) {
            this();
        }

        private CmpEquivLevel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class FCDMode extends Mode {
        public /* synthetic */ FCDMode(int i) {
            this();
        }

        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? FCD32ModeImpl.INSTANCE.normalizer2 : FCDModeImpl.INSTANCE.normalizer2;
        }

        private FCDMode() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFCMode extends Mode {
        public /* synthetic */ NFCMode(int i) {
            this();
        }

        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? NFC32ModeImpl.INSTANCE.normalizer2 : NFCModeImpl.INSTANCE.normalizer2;
        }

        private NFCMode() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFDMode extends Mode {
        public /* synthetic */ NFDMode(int i) {
            this();
        }

        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? NFD32ModeImpl.INSTANCE.normalizer2 : NFDModeImpl.INSTANCE.normalizer2;
        }

        private NFDMode() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFKCMode extends Mode {
        public /* synthetic */ NFKCMode(int i) {
            this();
        }

        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? NFKC32ModeImpl.INSTANCE.normalizer2 : NFKCModeImpl.INSTANCE.normalizer2;
        }

        private NFKCMode() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFKDMode extends Mode {
        public /* synthetic */ NFKDMode(int i) {
            this();
        }

        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? NFKD32ModeImpl.INSTANCE.normalizer2 : NFKDModeImpl.INSTANCE.normalizer2;
        }

        private NFKDMode() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NONEMode extends Mode {
        public /* synthetic */ NONEMode(int i) {
            this();
        }

        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return Norm2AllModes.NOOP_NORMALIZER2;
        }

        private NONEMode() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class QuickCheckResult {
        public /* synthetic */ QuickCheckResult(int i, int i2) {
            this(i);
        }

        public String toString() {
            if (this == Normalizer.NO) {
                return "NO";
            }
            if (this == Normalizer.YES) {
                return "YES";
            }
            return this == Normalizer.MAYBE ? "MAYBE" : cq.j("Unknown QuickCheckResult: ", Objects.toString(this));
        }

        private QuickCheckResult(int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ModeImpl {
        private final Normalizer2 normalizer2;

        private ModeImpl(Normalizer2 normalizer2) {
            this.normalizer2 = normalizer2;
        }

        public /* synthetic */ ModeImpl(Normalizer2 normalizer2, int i) {
            this(normalizer2);
        }
    }

    @Deprecated
    public String getText() {
        return this.text.getText();
    }

    @Deprecated
    public static boolean isNormalized(String str, Mode mode, int i) {
        return mode.getNormalizer2(i).isNormalized(str);
    }

    @Deprecated
    public static QuickCheckResult quickCheck(String str, Mode mode, int i) {
        return mode.getNormalizer2(i).quickCheck(str);
    }

    @Deprecated
    public static boolean isNormalized(int i, Mode mode, int i2) {
        return isNormalized(UTF16.valueOf(i), mode, i2);
    }

    @Deprecated
    public static QuickCheckResult quickCheck(char[] cArr, Mode mode, int i) {
        return quickCheck(cArr, 0, cArr.length, mode, i);
    }

    @Deprecated
    public static QuickCheckResult quickCheck(String str, Mode mode) {
        return quickCheck(str, mode, 0);
    }

    @Deprecated
    public static String compose(String str, boolean z, int i) {
        return getComposeNormalizer2(z, i).normalize(str);
    }

    @Deprecated
    public static String decompose(String str, boolean z, int i) {
        return getDecomposeNormalizer2(z, i).normalize(str);
    }

    @Deprecated
    public static int compose(char[] cArr, char[] cArr2, boolean z, int i) {
        return compose(cArr, 0, cArr.length, cArr2, 0, cArr2.length, z, i);
    }

    @Deprecated
    public static int decompose(char[] cArr, char[] cArr2, boolean z, int i) {
        return decompose(cArr, 0, cArr.length, cArr2, 0, cArr2.length, z, i);
    }

    @Deprecated
    public static String compose(String str, boolean z) {
        return compose(str, z, 0);
    }

    @Deprecated
    public static String decompose(String str, boolean z) {
        return decompose(str, z, 0);
    }

    @Deprecated
    public void setText(char[] cArr) {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(cArr);
        if (uCharacterIterator != null) {
            this.text = uCharacterIterator;
            reset();
        } else {
            og.n("Could not create a new UCharacterIterator");
        }
    }

    @Deprecated
    public static String normalize(String str, Mode mode) {
        return normalize(str, mode, 0);
    }

    @Deprecated
    public static int normalize(char[] cArr, char[] cArr2, Mode mode, int i) {
        return normalize(cArr, 0, cArr.length, cArr2, 0, cArr2.length, mode, i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CharsAppendable implements Appendable {
        private final char[] chars;
        private final int limit;
        private int offset;
        private final int start;

        public CharsAppendable(char[] cArr, int i, int i2) {
            this.chars = cArr;
            this.offset = i;
            this.start = i;
            this.limit = i2;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            int i3 = i2 - i;
            int i4 = this.limit;
            int i5 = this.offset;
            if (i3 > i4 - i5) {
                this.offset = i5 + i3;
                return this;
            }
            while (i < i2) {
                char[] cArr = this.chars;
                int i6 = this.offset;
                this.offset = i6 + 1;
                cArr[i6] = charSequence.charAt(i);
                i++;
            }
            return this;
        }

        public int length() {
            int i = this.offset;
            int i2 = i - this.start;
            if (i <= this.limit) {
                return i2;
            }
            og.o(Integer.toString(i2));
            return 0;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            return append(charSequence, 0, charSequence.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) {
            int i = this.offset;
            if (i < this.limit) {
                this.chars[i] = c;
            }
            this.offset = i + 1;
            return this;
        }
    }

    @Deprecated
    public static int normalize(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, Mode mode, int i5) {
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr, i, i2 - i);
        CharsAppendable charsAppendable = new CharsAppendable(cArr2, i3, i4);
        mode.getNormalizer2(i5).normalize(charBufferWrap, charsAppendable);
        return charsAppendable.length();
    }

    @Deprecated
    public void setText(String str) {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(str);
        if (uCharacterIterator != null) {
            this.text = uCharacterIterator;
            reset();
        } else {
            og.n("Could not create a new UCharacterIterator");
        }
    }

    @Deprecated
    public Normalizer(CharacterIterator characterIterator, Mode mode, int i) {
        this.text = UCharacterIterator.getInstance((CharacterIterator) characterIterator.clone());
        this.mode = mode;
        this.options = i;
        this.norm2 = mode.getNormalizer2(i);
        this.buffer = new StringBuilder();
    }

    public static int compare(String str, String str2, int i) {
        return internalCompare(str, str2, i);
    }

    public static int compare(char[] cArr, char[] cArr2, int i) {
        return internalCompare(CharBuffer.wrap(cArr), CharBuffer.wrap(cArr2), i);
    }

    @Deprecated
    public static String normalize(String str, Mode mode, int i) {
        return mode.getNormalizer2(i).normalize(str);
    }

    @Deprecated
    public void setText(CharacterIterator characterIterator) {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(characterIterator);
        if (uCharacterIterator != null) {
            this.text = uCharacterIterator;
            reset();
        } else {
            og.n("Could not create a new UCharacterIterator");
        }
    }

    public static int compare(int i, int i2, int i3) {
        return internalCompare(UTF16.valueOf(i), UTF16.valueOf(i2), i3 | INPUT_IS_FCD);
    }

    @Deprecated
    public static String normalize(int i, Mode mode) {
        return normalize(i, mode, 0);
    }

    @Deprecated
    public Normalizer(String str, Mode mode, int i) {
        this.text = UCharacterIterator.getInstance(str);
        this.mode = mode;
        this.options = i;
        this.norm2 = mode.getNormalizer2(i);
        this.buffer = new StringBuilder();
    }

    public static int compare(int i, String str, int i2) {
        return internalCompare(UTF16.valueOf(i), str, i2);
    }

    @Deprecated
    public void setText(StringBuffer stringBuffer) {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(stringBuffer);
        if (uCharacterIterator != null) {
            this.text = uCharacterIterator;
            reset();
        } else {
            og.n("Could not create a new UCharacterIterator");
        }
    }

    @Deprecated
    public static String concatenate(char[] cArr, char[] cArr2, Mode mode, int i) {
        StringBuilder sb = new StringBuilder(cArr.length + cArr2.length + 16);
        sb.append(cArr);
        return mode.getNormalizer2(i).append(sb, CharBuffer.wrap(cArr2)).toString();
    }

    @Deprecated
    public static String concatenate(String str, String str2, Mode mode, int i) {
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + 16);
        sb.append(str);
        return mode.getNormalizer2(i).append(sb, str2).toString();
    }

    @Deprecated
    public static int getFC_NFKC_Closure(int i, char[] cArr) {
        String fC_NFKC_Closure = getFC_NFKC_Closure(i);
        int length = fC_NFKC_Closure.length();
        if (length != 0 && cArr != null && length <= cArr.length) {
            fC_NFKC_Closure.getChars(0, length, cArr, 0);
        }
        return length;
    }
}
