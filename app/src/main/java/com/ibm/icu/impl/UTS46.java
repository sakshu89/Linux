package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.IDNA;
import com.ibm.icu.text.Normalizer2;
import com.ibm.icu.text.StringPrepParseException;
import com.ibm.icu.util.ICUException;
import defpackage.dk0;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UTS46 extends IDNA {
    private static final int EN_AN_MASK;
    private static final int ES_CS_ET_ON_BN_NSM_MASK;
    private static final int L_EN_ES_CS_ET_ON_BN_NSM_MASK;
    private static final int L_EN_MASK;
    private static final int L_MASK;
    private static final int L_R_AL_MASK;
    private static final int R_AL_AN_EN_ES_CS_ET_ON_BN_NSM_MASK;
    private static final int R_AL_AN_MASK;
    private static final int R_AL_EN_AN_MASK;
    private static final int R_AL_MASK;
    private static int U_GC_M_MASK;
    final int options;
    private static final Normalizer2 uts46Norm2 = Normalizer2.getInstance(null, "uts46", Normalizer2.Mode.COMPOSE);
    private static final EnumSet<IDNA.Error> severeErrors = EnumSet.of(IDNA.Error.LEADING_COMBINING_MARK, IDNA.Error.DISALLOWED, IDNA.Error.PUNYCODE, IDNA.Error.LABEL_HAS_DOT, IDNA.Error.INVALID_ACE_LABEL);
    private static final byte[] asciiData = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1};

    static {
        int iU_MASK = U_MASK(0);
        L_MASK = iU_MASK;
        int iU_MASK2 = U_MASK(1) | U_MASK(13);
        R_AL_MASK = iU_MASK2;
        L_R_AL_MASK = iU_MASK | iU_MASK2;
        R_AL_AN_MASK = U_MASK(5) | iU_MASK2;
        int iU_MASK3 = U_MASK(5) | U_MASK(2);
        EN_AN_MASK = iU_MASK3;
        R_AL_EN_AN_MASK = iU_MASK2 | iU_MASK3;
        int iU_MASK4 = iU_MASK | U_MASK(2);
        L_EN_MASK = iU_MASK4;
        int iU_MASK5 = U_MASK(3) | U_MASK(6) | U_MASK(4) | U_MASK(10) | U_MASK(18) | U_MASK(17);
        ES_CS_ET_ON_BN_NSM_MASK = iU_MASK5;
        L_EN_ES_CS_ET_ON_BN_NSM_MASK = iU_MASK4 | iU_MASK5;
        R_AL_AN_EN_ES_CS_ET_ON_BN_NSM_MASK = iU_MASK2 | iU_MASK3 | iU_MASK5;
        U_GC_M_MASK = U_MASK(6) | U_MASK(7) | U_MASK(8);
    }

    public UTS46(int i) {
        this.options = i;
    }

    private static int U_GET_GC_MASK(int i) {
        return 1 << UCharacter.getType(i);
    }

    private static int U_MASK(int i) {
        return 1 << i;
    }

    private void checkLabelBiDi(CharSequence charSequence, int i, int i2, IDNA.Info info) {
        int iU_MASK;
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        int iU_MASK2 = U_MASK(UBiDiProps.INSTANCE.getClass(iCodePointAt));
        if (((~L_R_AL_MASK) & iU_MASK2) != 0) {
            IDNA.setNotOkBiDi(info);
        }
        int iCharCount2 = i + i2;
        while (true) {
            if (iCharCount >= iCharCount2) {
                iU_MASK = iU_MASK2;
                break;
            }
            int iCodePointBefore = Character.codePointBefore(charSequence, iCharCount2);
            iCharCount2 -= Character.charCount(iCodePointBefore);
            int i3 = UBiDiProps.INSTANCE.getClass(iCodePointBefore);
            if (i3 != 17) {
                iU_MASK = U_MASK(i3);
                break;
            }
        }
        if ((L_MASK & iU_MASK2) == 0 ? ((~R_AL_EN_AN_MASK) & iU_MASK) != 0 : ((~L_EN_MASK) & iU_MASK) != 0) {
            IDNA.setNotOkBiDi(info);
        }
        int iU_MASK3 = iU_MASK | iU_MASK2;
        while (iCharCount < iCharCount2) {
            int iCodePointAt2 = Character.codePointAt(charSequence, iCharCount);
            iCharCount += Character.charCount(iCodePointAt2);
            iU_MASK3 |= U_MASK(UBiDiProps.INSTANCE.getClass(iCodePointAt2));
        }
        if ((iU_MASK2 & L_MASK) == 0) {
            if (((~R_AL_AN_EN_ES_CS_ET_ON_BN_NSM_MASK) & iU_MASK3) != 0) {
                IDNA.setNotOkBiDi(info);
            }
            int i4 = EN_AN_MASK;
            if ((iU_MASK3 & i4) == i4) {
                IDNA.setNotOkBiDi(info);
            }
        } else if (((~L_EN_ES_CS_ET_ON_BN_NSM_MASK) & iU_MASK3) != 0) {
            IDNA.setNotOkBiDi(info);
        }
        if ((R_AL_AN_MASK & iU_MASK3) != 0) {
            IDNA.setBiDi(info);
        }
    }

    private void checkLabelContextO(CharSequence charSequence, int i, int i2, IDNA.Info info) {
        int i3 = (i2 + i) - 1;
        byte b = 0;
        for (int i4 = i; i4 <= i3; i4++) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt >= 183) {
                if (cCharAt <= 1785) {
                    if (cCharAt == 183) {
                        if (i >= i4 || charSequence.charAt(i4 - 1) != 'l' || i4 >= i3 || charSequence.charAt(i4 + 1) != 'l') {
                            IDNA.addLabelError(info, IDNA.Error.CONTEXTO_PUNCTUATION);
                        }
                    } else if (cCharAt == 885) {
                        if (i4 >= i3 || 14 != UScript.getScript(Character.codePointAt(charSequence, i4 + 1))) {
                            IDNA.addLabelError(info, IDNA.Error.CONTEXTO_PUNCTUATION);
                        }
                    } else if (cCharAt == 1523 || cCharAt == 1524) {
                        if (i >= i4 || 19 != UScript.getScript(Character.codePointBefore(charSequence, i4))) {
                            IDNA.addLabelError(info, IDNA.Error.CONTEXTO_PUNCTUATION);
                        }
                    } else if (1632 <= cCharAt) {
                        if (cCharAt <= 1641) {
                            if (b > 0) {
                                IDNA.addLabelError(info, IDNA.Error.CONTEXTO_DIGITS);
                            }
                            b = -1;
                        } else if (1776 <= cCharAt) {
                            if (b < 0) {
                                IDNA.addLabelError(info, IDNA.Error.CONTEXTO_DIGITS);
                            }
                            b = 1;
                        }
                    }
                } else if (cCharAt == 12539) {
                    int iCharCount = i;
                    while (true) {
                        if (iCharCount > i3) {
                            IDNA.addLabelError(info, IDNA.Error.CONTEXTO_PUNCTUATION);
                            break;
                        }
                        int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        int script = UScript.getScript(iCodePointAt);
                        if (script == 20 || script == 22 || script == 17) {
                            break;
                        } else {
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean isASCIIOkBiDi(CharSequence charSequence, int i) {
        char cCharAt;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            char cCharAt2 = charSequence.charAt(i3);
            if (cCharAt2 == '.') {
                if (i3 > i2 && (('a' > (cCharAt = charSequence.charAt(i3 - 1)) || cCharAt > 'z') && ('0' > cCharAt || cCharAt > '9'))) {
                    return false;
                }
                i2 = i3 + 1;
            } else if (i3 == i2) {
                if ('a' > cCharAt2 || cCharAt2 > 'z') {
                    return false;
                }
            } else if (cCharAt2 <= ' ' && (cCharAt2 >= 28 || ('\t' <= cCharAt2 && cCharAt2 <= '\r'))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isASCIIString(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    private boolean isLabelOkContextJ(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        for (int i4 = i; i4 < i3; i4++) {
            if (charSequence.charAt(i4) == 8204) {
                if (i4 == i) {
                    return false;
                }
                int iCodePointBefore = Character.codePointBefore(charSequence, i4);
                int iCharCount = i4 - Character.charCount(iCodePointBefore);
                if (uts46Norm2.getCombiningClass(iCodePointBefore) == 9) {
                    continue;
                } else {
                    while (true) {
                        int joiningType = UBiDiProps.INSTANCE.getJoiningType(iCodePointBefore);
                        if (joiningType != 5) {
                            if (joiningType != 3 && joiningType != 2) {
                                return false;
                            }
                            int iCharCount2 = i4 + 1;
                            while (iCharCount2 != i3) {
                                int iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                                iCharCount2 += Character.charCount(iCodePointAt);
                                int joiningType2 = UBiDiProps.INSTANCE.getJoiningType(iCodePointAt);
                                if (joiningType2 != 5) {
                                    if (joiningType2 == 4 || joiningType2 == 2) {
                                        break;
                                    }
                                    return false;
                                }
                            }
                            return false;
                        }
                        if (iCharCount == 0) {
                            return false;
                        }
                        iCodePointBefore = Character.codePointBefore(charSequence, iCharCount);
                        iCharCount -= Character.charCount(iCodePointBefore);
                    }
                }
            } else if (charSequence.charAt(i4) != 8205) {
                continue;
            } else {
                if (i4 == i) {
                    return false;
                }
                if (uts46Norm2.getCombiningClass(Character.codePointBefore(charSequence, i4)) != 9) {
                    return false;
                }
            }
        }
        return true;
    }

    private int mapDevChars(StringBuilder sb, int i, int i2) {
        int length = sb.length();
        boolean z = false;
        while (i2 < length) {
            char cCharAt = sb.charAt(i2);
            if (cCharAt == 223) {
                int i3 = i2 + 1;
                sb.setCharAt(i2, 's');
                i2 += 2;
                sb.insert(i3, 's');
                length++;
            } else if (cCharAt == 962) {
                sb.setCharAt(i2, (char) 963);
                i2++;
            } else if (cCharAt == 8204 || cCharAt == 8205) {
                sb.delete(i2, i2 + 1);
                length--;
            } else {
                i2++;
            }
            z = true;
        }
        if (!z) {
            return length;
        }
        sb.replace(i, Integer.MAX_VALUE, uts46Norm2.normalize(sb.subSequence(i, sb.length())));
        return sb.length();
    }

    private int markBadACELabel(StringBuilder sb, int i, int i2, boolean z, IDNA.Info info) {
        boolean z2 = (this.options & 2) != 0;
        int i3 = i + i2;
        boolean z3 = true;
        boolean z4 = true;
        for (int i4 = i + 4; i4 < i3; i4++) {
            char cCharAt = sb.charAt(i4);
            if (cCharAt > 127) {
                z3 = false;
                z4 = false;
            } else {
                if (cCharAt == '.') {
                    IDNA.addLabelError(info, IDNA.Error.LABEL_HAS_DOT);
                    sb.setCharAt(i4, (char) 65533);
                } else if (asciiData[cCharAt] < 0) {
                    if (z2) {
                        sb.setCharAt(i4, (char) 65533);
                    } else {
                        z3 = false;
                    }
                }
                z3 = false;
                z4 = false;
            }
        }
        if (z3) {
            sb.insert(i3, (char) 65533);
            return i2 + 1;
        }
        if (z && z4 && i2 > 63) {
            IDNA.addLabelError(info, IDNA.Error.LABEL_TOO_LONG);
        }
        return i2;
    }

    private StringBuilder process(CharSequence charSequence, boolean z, boolean z2, StringBuilder sb, IDNA.Info info) {
        if (sb == charSequence) {
            dk0.v();
            return null;
        }
        int i = 0;
        sb.delete(0, Integer.MAX_VALUE);
        IDNA.resetInfo(info);
        int length = charSequence.length();
        if (length == 0) {
            IDNA.addError(info, IDNA.Error.EMPTY_LABEL);
            return sb;
        }
        boolean z3 = (this.options & 2) != 0;
        int i2 = 0;
        while (true) {
            if (i != length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt > 127) {
                    break;
                }
                byte b = asciiData[cCharAt];
                if (b <= 0) {
                    if (b < 0 && z3) {
                        break;
                    }
                    sb.append(cCharAt);
                    if (cCharAt == '-') {
                        if (i == i2 + 3 && charSequence.charAt(i - 1) == '-') {
                            i++;
                            break;
                        }
                        if (i == i2) {
                            IDNA.addLabelError(info, IDNA.Error.LEADING_HYPHEN);
                        }
                        int i3 = i + 1;
                        if (i3 == length || charSequence.charAt(i3) == '.') {
                            IDNA.addLabelError(info, IDNA.Error.TRAILING_HYPHEN);
                        }
                    } else if (cCharAt != '.') {
                        continue;
                    } else {
                        if (z) {
                            i++;
                            break;
                        }
                        if (i == i2) {
                            IDNA.addLabelError(info, IDNA.Error.EMPTY_LABEL);
                        }
                        if (z2 && i - i2 > 63) {
                            IDNA.addLabelError(info, IDNA.Error.LABEL_TOO_LONG);
                        }
                        IDNA.promoteAndResetLabelErrors(info);
                        i2 = i + 1;
                    }
                } else {
                    sb.append((char) (cCharAt + ' '));
                }
                i++;
            } else {
                if (z2) {
                    if (i - i2 > 63) {
                        IDNA.addLabelError(info, IDNA.Error.LABEL_TOO_LONG);
                    }
                    if (!z && i >= 254 && (i > 254 || i2 < i)) {
                        IDNA.addError(info, IDNA.Error.DOMAIN_NAME_TOO_LONG);
                    }
                }
                IDNA.promoteAndResetLabelErrors(info);
                return sb;
            }
        }
        int i4 = i;
        IDNA.promoteAndResetLabelErrors(info);
        processUnicode(charSequence, i2, i4, z, z2, sb, info);
        if (IDNA.isBiDi(info) && !IDNA.hasCertainErrors(info, severeErrors) && (!IDNA.isOkBiDi(info) || (i2 > 0 && !isASCIIOkBiDi(sb, i2)))) {
            IDNA.addError(info, IDNA.Error.BIDI);
        }
        return sb;
    }

    private int processLabel(StringBuilder sb, int i, int i2, boolean z, IDNA.Info info) {
        StringBuilder sbDecode;
        int i3;
        int length;
        boolean z2;
        UTS46 uts46 = this;
        int i4 = i2;
        IDNA.Info info2 = info;
        if (i4 < 4 || sb.charAt(i) != 'x' || sb.charAt(i + 1) != 'n' || sb.charAt(i + 2) != '-' || sb.charAt(i + 3) != '-') {
            sbDecode = sb;
            i3 = i;
            length = i4;
            z2 = false;
        } else {
            if (i4 == 4 || (i4 > 5 && sb.charAt((i + i4) - 1) == '-')) {
                IDNA.addLabelError(info2, IDNA.Error.INVALID_ACE_LABEL);
                return markBadACELabel(sb, i, i2, z, info);
            }
            try {
                sbDecode = Punycode.decode(sb.subSequence(i + 4, i + i4), null);
                if (!uts46Norm2.isNormalized(sbDecode) || startsWithXNDashDash(sbDecode)) {
                    IDNA.addLabelError(info2, IDNA.Error.INVALID_ACE_LABEL);
                    return markBadACELabel(sb, i, i2, z, info);
                }
                length = sbDecode.length();
                z2 = true;
                i3 = 0;
            } catch (StringPrepParseException unused) {
                IDNA.addLabelError(info2, IDNA.Error.PUNYCODE);
                return markBadACELabel(sb, i, i2, z, info);
            }
        }
        if (length == 0) {
            IDNA.addLabelError(info2, IDNA.Error.EMPTY_LABEL);
            return replaceLabel(sb, i, i4, sbDecode, length);
        }
        if (length >= 4 && sbDecode.charAt(i3 + 2) == '-' && sbDecode.charAt(i3 + 3) == '-') {
            IDNA.addLabelError(info2, IDNA.Error.HYPHEN_3_4);
        }
        if (sbDecode.charAt(i3) == '-') {
            IDNA.addLabelError(info2, IDNA.Error.LEADING_HYPHEN);
        }
        int i5 = i3 + length;
        if (sbDecode.charAt(i5 - 1) == '-') {
            IDNA.addLabelError(info2, IDNA.Error.TRAILING_HYPHEN);
        }
        boolean z3 = (uts46.options & 2) != 0;
        int i6 = i3;
        char c = 0;
        while (true) {
            char cCharAt = sbDecode.charAt(i6);
            if (cCharAt > 127) {
                c = (char) (c | cCharAt);
                if (cCharAt == 65533) {
                    IDNA.addLabelError(info2, IDNA.Error.DISALLOWED);
                }
            } else if (cCharAt == '.') {
                IDNA.addLabelError(info2, IDNA.Error.LABEL_HAS_DOT);
                sbDecode.setCharAt(i6, (char) 65533);
            } else if (z3 && asciiData[cCharAt] < 0) {
                IDNA.addLabelError(info2, IDNA.Error.DISALLOWED);
                sbDecode.setCharAt(i6, (char) 65533);
            }
            i6++;
            if (i6 >= i5) {
                break;
            }
            uts46 = this;
            info2 = info;
        }
        int iCodePointAt = sbDecode.codePointAt(i3);
        if ((U_GET_GC_MASK(iCodePointAt) & U_GC_M_MASK) != 0) {
            IDNA.addLabelError(info2, IDNA.Error.LEADING_COMBINING_MARK);
            sbDecode.setCharAt(i3, (char) 65533);
            if (iCodePointAt > 65535) {
                sbDecode.deleteCharAt(i3 + 1);
                length--;
                if (sbDecode == sb) {
                    i4--;
                }
            }
        }
        if (!IDNA.hasCertainLabelErrors(info2, severeErrors)) {
            if ((uts46.options & 4) != 0 && (!IDNA.isBiDi(info2) || IDNA.isOkBiDi(info2))) {
                uts46.checkLabelBiDi(sbDecode, i3, length, info2);
            }
            if ((uts46.options & 8) != 0 && (c & 8204) == 8204 && !uts46.isLabelOkContextJ(sbDecode, i3, length)) {
                IDNA.addLabelError(info2, IDNA.Error.CONTEXTJ);
            }
            if ((uts46.options & 64) != 0 && c >= 183) {
                uts46.checkLabelContextO(sbDecode, i3, length, info2);
            }
            if (z) {
                if (z2) {
                    if (i4 > 63) {
                        IDNA.addLabelError(info2, IDNA.Error.LABEL_TOO_LONG);
                    }
                    return i4;
                }
                if (c >= 128) {
                    try {
                        StringBuilder sbEncode = Punycode.encode(sbDecode.subSequence(i3, length + i3), null);
                        sbEncode.insert(0, "xn--");
                        if (sbEncode.length() > 63) {
                            IDNA.addLabelError(info2, IDNA.Error.LABEL_TOO_LONG);
                        }
                        return replaceLabel(sb, i, i4, sbEncode, sbEncode.length());
                    } catch (StringPrepParseException e) {
                        throw new ICUException(e);
                    }
                }
                if (length > 63) {
                    IDNA.addLabelError(info2, IDNA.Error.LABEL_TOO_LONG);
                }
            }
        } else if (z2) {
            IDNA.addLabelError(info2, IDNA.Error.INVALID_ACE_LABEL);
            return uts46.markBadACELabel(sb, i, i4, z, info2);
        }
        return replaceLabel(sb, i, i4, sbDecode, length);
    }

    private StringBuilder processUnicode(CharSequence charSequence, int i, int i2, boolean z, boolean z2, StringBuilder sb, IDNA.Info info) {
        int i3;
        if (i2 == 0) {
            uts46Norm2.normalize(charSequence, sb);
        } else {
            uts46Norm2.normalizeSecondAndAppend(sb, charSequence.subSequence(i2, charSequence.length()));
        }
        int i4 = this.options;
        boolean z3 = !z2 ? (i4 & 32) != 0 : (i4 & 16) != 0;
        int i5 = i;
        int length = sb.length();
        while (i < length) {
            char cCharAt = sb.charAt(i);
            if (cCharAt != '.' || z) {
                boolean z4 = z2;
                StringBuilder sb2 = sb;
                IDNA.Info info2 = info;
                UTS46 uts46 = this;
                if (cCharAt >= 223) {
                    if (cCharAt <= 8205 && (cCharAt == 223 || cCharAt == 962 || cCharAt >= 8204)) {
                        IDNA.setTransitionalDifferent(info2);
                        if (z3) {
                            length = uts46.mapDevChars(sb2, i5, i);
                            z3 = false;
                        }
                    } else if (Character.isSurrogate(cCharAt) && (!Normalizer2Impl.UTF16Plus.isSurrogateLead(cCharAt) ? i == i5 || !Character.isHighSurrogate(sb2.charAt(i - 1)) : (i3 = i + 1) == length || !Character.isLowSurrogate(sb2.charAt(i3)))) {
                        IDNA.addLabelError(info2, IDNA.Error.DISALLOWED);
                        sb2.setCharAt(i, (char) 65533);
                    }
                    i++;
                } else {
                    i++;
                }
                this = uts46;
                sb = sb2;
                z2 = z4;
                info = info2;
            } else {
                int i6 = i - i5;
                UTS46 uts47 = this;
                boolean z5 = z2;
                IDNA.Info info3 = info;
                int iProcessLabel = uts47.processLabel(sb, i5, i6, z5, info3);
                IDNA.promoteAndResetLabelErrors(info3);
                length += iProcessLabel - i6;
                i5 += iProcessLabel + 1;
                this = uts47;
                i = i5;
                z2 = z5;
            }
        }
        boolean z6 = z2;
        StringBuilder sb3 = sb;
        IDNA.Info info4 = info;
        UTS46 uts48 = this;
        if (i5 != 0 && i5 >= i) {
            return sb3;
        }
        uts48.processLabel(sb3, i5, i - i5, z6, info4);
        IDNA.promoteAndResetLabelErrors(info4);
        return sb3;
    }

    private static int replaceLabel(StringBuilder sb, int i, int i2, CharSequence charSequence, int i3) {
        if (charSequence != sb) {
            sb.delete(i, i2 + i).insert(i, charSequence);
        }
        return i3;
    }

    private static boolean startsWithXNDashDash(CharSequence charSequence) {
        return charSequence.length() >= 4 && charSequence.charAt(0) == 'x' && charSequence.charAt(1) == 'n' && charSequence.charAt(2) == '-' && charSequence.charAt(3) == '-';
    }

    @Override // com.ibm.icu.text.IDNA
    public StringBuilder labelToASCII(CharSequence charSequence, StringBuilder sb, IDNA.Info info) {
        return process(charSequence, true, true, sb, info);
    }

    @Override // com.ibm.icu.text.IDNA
    public StringBuilder labelToUnicode(CharSequence charSequence, StringBuilder sb, IDNA.Info info) {
        return process(charSequence, true, false, sb, info);
    }

    @Override // com.ibm.icu.text.IDNA
    public StringBuilder nameToASCII(CharSequence charSequence, StringBuilder sb, IDNA.Info info) {
        process(charSequence, false, true, sb, info);
        if (sb.length() >= 254) {
            Set<IDNA.Error> errors = info.getErrors();
            IDNA.Error error = IDNA.Error.DOMAIN_NAME_TOO_LONG;
            if (!errors.contains(error) && isASCIIString(sb) && (sb.length() > 254 || sb.charAt(253) != '.')) {
                IDNA.addError(info, error);
            }
        }
        return sb;
    }

    @Override // com.ibm.icu.text.IDNA
    public StringBuilder nameToUnicode(CharSequence charSequence, StringBuilder sb, IDNA.Info info) {
        return process(charSequence, false, false, sb, info);
    }
}
