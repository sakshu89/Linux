package com.ibm.icu.impl.number;

import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import defpackage.og;
import java.lang.reflect.Array;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PatternStringUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: com.ibm.icu.impl.number.PatternStringUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay;

        static {
            int[] iArr = new int[NumberFormatter.SignDisplay.values().length];
            $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay = iArr;
            try {
                iArr[NumberFormatter.SignDisplay.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ACCOUNTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ALWAYS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ACCOUNTING_ALWAYS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.EXCEPT_ZERO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ACCOUNTING_EXCEPT_ZERO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.NEGATIVE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ACCOUNTING_NEGATIVE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.NEVER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[Modifier.Signum.values().length];
            $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum = iArr2;
            try {
                iArr2[Modifier.Signum.NEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[Modifier.Signum.NEG_ZERO.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[Modifier.Signum.POS_ZERO.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[Modifier.Signum.POS.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr3 = new int[Padder.PadPosition.values().length];
            $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition = iArr3;
            try {
                iArr3[Padder.PadPosition.BEFORE_PREFIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[Padder.PadPosition.AFTER_PREFIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[Padder.PadPosition.BEFORE_SUFFIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[Padder.PadPosition.AFTER_SUFFIX.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum PatternSignType {
        POS,
        POS_SIGN,
        NEG;

        public static final PatternSignType[] VALUES = values();
    }

    public static String convertLocalized(String str, DecimalFormatSymbols decimalFormatSymbols, boolean z) {
        String str2;
        String str3 = null;
        if (str == null) {
            return null;
        }
        char c = 2;
        char c2 = 0;
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, 21, 2);
        int i = !z ? 1 : 0;
        strArr[0][i] = "%";
        strArr[0][z ? 1 : 0] = decimalFormatSymbols.getPercentString();
        strArr[1][i] = "‰";
        strArr[1][z ? 1 : 0] = decimalFormatSymbols.getPerMillString();
        strArr[2][i] = ".";
        strArr[2][z ? 1 : 0] = decimalFormatSymbols.getDecimalSeparatorString();
        strArr[3][i] = ",";
        strArr[3][z ? 1 : 0] = decimalFormatSymbols.getGroupingSeparatorString();
        strArr[4][i] = LanguageTag.SEP;
        strArr[4][z ? 1 : 0] = decimalFormatSymbols.getMinusSignString();
        strArr[5][i] = "+";
        strArr[5][z ? 1 : 0] = decimalFormatSymbols.getPlusSignString();
        strArr[6][i] = ";";
        strArr[6][z ? 1 : 0] = Character.toString(decimalFormatSymbols.getPatternSeparator());
        strArr[7][i] = "@";
        strArr[7][z ? 1 : 0] = Character.toString(decimalFormatSymbols.getSignificantDigit());
        strArr[8][i] = DateFormat.ABBR_WEEKDAY;
        strArr[8][z ? 1 : 0] = decimalFormatSymbols.getExponentSeparator();
        strArr[9][i] = "*";
        strArr[9][z ? 1 : 0] = Character.toString(decimalFormatSymbols.getPadEscape());
        strArr[10][i] = "#";
        strArr[10][z ? 1 : 0] = Character.toString(decimalFormatSymbols.getDigit());
        for (int i2 = 0; i2 < 10; i2++) {
            int i3 = i2 + 11;
            strArr[i3][i] = Character.toString((char) (i2 + 48));
            strArr[i3][z ? 1 : 0] = decimalFormatSymbols.getDigitStringsLocal()[i2];
        }
        for (String[] strArr2 : strArr) {
            strArr2[z ? 1 : 0] = strArr2[z ? 1 : 0].replace(PatternTokenizer.SINGLE_QUOTE, (char) 8217);
        }
        StringBuilder sb = new StringBuilder();
        int length = 0;
        char c3 = 0;
        while (length < str.length()) {
            char cCharAt = str.charAt(length);
            if (cCharAt == '\'') {
                if (c3 == 0) {
                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                } else if (c3 == 1) {
                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                    str2 = str3;
                    c3 = 0;
                } else if (c3 == c) {
                    str2 = str3;
                    c3 = 3;
                } else if (c3 == 3) {
                    sb.append("''");
                } else if (c3 == 4) {
                    str2 = str3;
                    c3 = 5;
                } else {
                    sb.append("''");
                    str2 = str3;
                    c3 = 4;
                }
                str2 = str3;
                c3 = 1;
            } else if (c3 == 0 || c3 == 3 || c3 == 4) {
                int length2 = strArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        str2 = str3;
                        int length3 = strArr.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length3) {
                                if (c3 == 3 || c3 == 4) {
                                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                                    c3 = 0;
                                }
                                sb.append(cCharAt);
                                break;
                            }
                            String str4 = strArr[i5][1];
                            if (str.regionMatches(length, str4, 0, str4.length())) {
                                if (c3 == 0) {
                                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                                    c3 = 4;
                                }
                                sb.append(cCharAt);
                                break;
                            }
                            i5++;
                        }
                    } else {
                        String[] strArr3 = strArr[i4];
                        str2 = str3;
                        String str5 = strArr3[0];
                        if (str.regionMatches(length, str5, 0, str5.length())) {
                            length += strArr3[0].length() - 1;
                            if (c3 == 3 || c3 == 4) {
                                sb.append(PatternTokenizer.SINGLE_QUOTE);
                                c3 = 0;
                            }
                            sb.append(strArr3[1]);
                            break;
                        }
                        i4++;
                        str3 = str2;
                    }
                }
            } else {
                sb.append(cCharAt);
                str2 = str3;
                c3 = c;
            }
            length++;
            str3 = str2;
            c = 2;
        }
        String str6 = str3;
        if (c3 == 3 || c3 == 4) {
            sb.append(PatternTokenizer.SINGLE_QUOTE);
        } else {
            c2 = c3;
        }
        if (c2 == 0) {
            return sb.toString();
        }
        og.i("Malformed localized pattern: unterminated quote");
        return str6;
    }

    private static int escapePaddingString(CharSequence charSequence, StringBuilder sb, int i) {
        if (charSequence == null || charSequence.length() == 0) {
            charSequence = Padder.FALLBACK_PADDING_STRING;
        }
        int length = sb.length();
        int i2 = 1;
        if (charSequence.length() != 1) {
            sb.insert(i, PatternTokenizer.SINGLE_QUOTE);
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                char cCharAt = charSequence.charAt(i3);
                if (cCharAt == '\'') {
                    sb.insert(i + i2, "''");
                    i2 += 2;
                } else {
                    sb.insert(i + i2, cCharAt);
                    i2++;
                }
            }
            sb.insert(i + i2, PatternTokenizer.SINGLE_QUOTE);
        } else if (charSequence.equals("'")) {
            sb.insert(i, "''");
        } else {
            sb.insert(i, charSequence);
        }
        return sb.length() - length;
    }

    public static boolean ignoreRoundingIncrement(BigDecimal bigDecimal, int i) {
        double dDoubleValue = bigDecimal.doubleValue();
        if (dDoubleValue == 0.0d) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        int i2 = 0;
        for (double d = dDoubleValue * 2.0d; i2 <= i && d <= 1.0d; d *= 10.0d) {
            i2++;
        }
        return i2 > i;
    }

    public static void patternInfoToStringBuilder(AffixPatternProvider affixPatternProvider, boolean z, PatternSignType patternSignType, boolean z2, StandardPlural standardPlural, boolean z3, StringBuilder sb) {
        String str;
        boolean z4 = patternSignType == PatternSignType.POS_SIGN && !affixPatternProvider.positiveHasPlusSign();
        boolean z5 = affixPatternProvider.hasNegativeSubpattern() && (patternSignType == PatternSignType.NEG || (affixPatternProvider.negativeHasMinusSign() && (z4 || z2)));
        int iOrdinal = z5 ? 512 : 0;
        if (z) {
            iOrdinal |= 256;
        }
        if (standardPlural != null) {
            iOrdinal |= standardPlural.ordinal();
        }
        int i = (z && !z5 && (patternSignType == PatternSignType.NEG || z4 || z2)) ? 1 : 0;
        if (!z2) {
            str = z4 ? "+" : LanguageTag.SEP;
        } else if (z4) {
            str = "~+";
        } else {
            str = patternSignType == PatternSignType.NEG ? "~-" : "~";
        }
        int length = affixPatternProvider.length(iOrdinal) + i;
        sb.setLength(0);
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = (i == 0 || i2 != 0) ? i != 0 ? affixPatternProvider.charAt(iOrdinal, i2 - 1) : affixPatternProvider.charAt(iOrdinal, i2) : '-';
            if (cCharAt == '-') {
                if (str.length() == 1) {
                    cCharAt = str.charAt(0);
                } else {
                    sb.append(str.charAt(0));
                    cCharAt = str.charAt(1);
                }
            }
            if (z3 && cCharAt == '%') {
                cCharAt = 8240;
            }
            sb.append(cCharAt);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0111 A[LOOP:2: B:23:0x0108->B:25:0x0111, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0119 A[LOOP:3: B:26:0x0116->B:28:0x0119, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x012c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0136  */
    /* JADX WARN: Code duplicated, block: B:35:0x013c  */
    /* JADX WARN: Code duplicated, block: B:37:0x013f  */
    /* JADX WARN: Code duplicated, block: B:43:0x015a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0165  */
    /* JADX WARN: Code duplicated, block: B:49:0x016b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0173  */
    /* JADX WARN: Code duplicated, block: B:64:0x0194  */
    /* JADX WARN: Code duplicated, block: B:66:0x019b  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a3 A[LOOP:5: B:68:0x01a1->B:69:0x01a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x01b7 A[LOOP:6: B:72:0x01b7->B:74:0x01bf, LOOP_START, PHI: r1
      0x01b7: PHI (r1v11 int) = (r1v6 int), (r1v13 int) binds: [B:71:0x01b5, B:74:0x01bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x01bf A[LOOP:6: B:72:0x01b7->B:74:0x01bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x0208  */
    /* JADX WARN: Code duplicated, block: B:90:0x0215  */
    /* JADX WARN: Code duplicated, block: B:93:0x021e  */
    public static String propertiesToPatternString(DecimalFormatProperties decimalFormatProperties) {
        int i;
        int iMax;
        int i2;
        int iMin;
        int length;
        int i3;
        int i4;
        int i5;
        int iEscapePaddingString;
        int i6;
        int length2;
        StringBuilder sb = new StringBuilder();
        int iMax2 = Math.max(0, Math.min(decimalFormatProperties.getGroupingSize(), 100));
        int iMax3 = Math.max(0, Math.min(decimalFormatProperties.getSecondaryGroupingSize(), 100));
        boolean groupingUsed = decimalFormatProperties.getGroupingUsed();
        int iMin2 = Math.min(decimalFormatProperties.getFormatWidth(), 100);
        Padder.PadPosition padPosition = decimalFormatProperties.getPadPosition();
        String padString = decimalFormatProperties.getPadString();
        int iMax4 = Math.max(0, Math.min(decimalFormatProperties.getMinimumIntegerDigits(), 100));
        int iMin3 = Math.min(decimalFormatProperties.getMaximumIntegerDigits(), 100);
        int iMax5 = Math.max(0, Math.min(decimalFormatProperties.getMinimumFractionDigits(), 100));
        int iMin4 = Math.min(decimalFormatProperties.getMaximumFractionDigits(), 100);
        int iMin5 = Math.min(decimalFormatProperties.getMinimumSignificantDigits(), 100);
        int iMin6 = Math.min(decimalFormatProperties.getMaximumSignificantDigits(), 100);
        boolean decimalSeparatorAlwaysShown = decimalFormatProperties.getDecimalSeparatorAlwaysShown();
        boolean currencyAsDecimal = decimalFormatProperties.getCurrencyAsDecimal();
        int iMin7 = Math.min(decimalFormatProperties.getMinimumExponentDigits(), 100);
        boolean exponentSignAlwaysShown = decimalFormatProperties.getExponentSignAlwaysShown();
        AffixPatternProvider affixPatternProviderForProperties = PropertiesAffixPatternProvider.forProperties(decimalFormatProperties);
        sb.append(affixPatternProviderForProperties.getString(256));
        int length3 = sb.length();
        if (!groupingUsed) {
            iMax2 = 0;
            iMax3 = 0;
        } else if (iMax2 == iMax3) {
            iMax2 = 0;
        }
        int i7 = iMax3;
        int i8 = iMax2 + iMax3 + 1;
        BigDecimal roundingIncrement = decimalFormatProperties.getRoundingIncrement();
        StringBuilder sb2 = new StringBuilder();
        if (iMin6 == Math.min(100, -1)) {
            if (roundingIncrement != null && !ignoreRoundingIncrement(roundingIncrement, iMin4)) {
                i = -roundingIncrement.scale();
                String plainString = roundingIncrement.scaleByPowerOfTen(roundingIncrement.scale()).toPlainString();
                if (plainString.charAt(0) == '-') {
                    sb2.append((CharSequence) plainString, 1, plainString.length());
                } else {
                    sb2.append(plainString);
                }
            }
            while (sb2.length() + i < iMax4) {
                sb2.insert(0, '0');
            }
            while ((-i) < iMax5) {
                sb2.append('0');
                i--;
            }
            iMax = Math.max(i8, sb2.length() + i);
            if (iMin3 != 100) {
                iMax = Math.max(iMin3, iMax);
            }
            if (iMin4 != 100) {
                iMin = Math.min(-iMin4, i);
            } else {
                iMin = i;
            }
            for (i2 = iMax - 1; i2 >= iMin; i2--) {
                length2 = ((sb2.length() + i) - i2) - 1;
                if (length2 >= 0 || length2 >= sb2.length()) {
                    sb.append('#');
                } else {
                    sb.append(sb2.charAt(length2));
                }
                if (i2 == 0 && (decimalSeparatorAlwaysShown || iMin < 0)) {
                    if (currencyAsDecimal) {
                        sb.append((char) 164);
                    } else {
                        sb.append('.');
                    }
                }
                if (groupingUsed) {
                    if (i2 > 0 && i2 == iMax2) {
                        sb.append(',');
                    }
                    if (i2 <= iMax2 && i7 > 0 && (i2 - iMax2) % i7 == 0) {
                        sb.append(',');
                    }
                }
            }
            if (iMin7 != Math.min(100, -1)) {
                sb.append('E');
                if (exponentSignAlwaysShown) {
                    sb.append('+');
                }
                for (i6 = 0; i6 < iMin7; i6++) {
                    sb.append('0');
                }
            }
            length = sb.length();
            sb.append(affixPatternProviderForProperties.getString(0));
            if (iMin2 > 0) {
                while (iMin2 - sb.length() > 0) {
                    sb.insert(length3, '#');
                    length++;
                }
                i3 = length3;
                i5 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[padPosition.ordinal()];
                if (i5 != 1) {
                    iEscapePaddingString = escapePaddingString(padString, sb, 0);
                    sb.insert(0, '*');
                } else if (i5 != 2) {
                    iEscapePaddingString = escapePaddingString(padString, sb, i3);
                    sb.insert(i3, '*');
                } else if (i5 != 3) {
                    escapePaddingString(padString, sb, length);
                    sb.insert(length, '*');
                } else if (i5 == 4) {
                    sb.append('*');
                    escapePaddingString(padString, sb, sb.length());
                }
                int i9 = iEscapePaddingString + 1;
                i4 = i3 + i9;
                length += i9;
                if (affixPatternProviderForProperties.hasNegativeSubpattern()) {
                    sb.append(';');
                    sb.append(affixPatternProviderForProperties.getString(768));
                    sb.append((CharSequence) sb, i4, length);
                    sb.append(affixPatternProviderForProperties.getString(512));
                }
                return sb.toString();
            }
            i3 = length3;
            i4 = i3;
            if (affixPatternProviderForProperties.hasNegativeSubpattern()) {
                sb.append(';');
                sb.append(affixPatternProviderForProperties.getString(768));
                sb.append((CharSequence) sb, i4, length);
                sb.append(affixPatternProviderForProperties.getString(512));
            }
            return sb.toString();
        }
        while (sb2.length() < iMin5) {
            sb2.append('@');
        }
        while (sb2.length() < iMin6) {
            sb2.append('#');
        }
        i = 0;
        while (sb2.length() + i < iMax4) {
            sb2.insert(0, '0');
        }
        while ((-i) < iMax5) {
            sb2.append('0');
            i--;
        }
        iMax = Math.max(i8, sb2.length() + i);
        if (iMin3 != 100) {
            iMax = Math.max(iMin3, iMax);
        }
        if (iMin4 != 100) {
            iMin = Math.min(-iMin4, i);
        } else {
            iMin = i;
        }
        while (i2 >= iMin) {
            length2 = ((sb2.length() + i) - i2) - 1;
            if (length2 >= 0) {
                sb.append('#');
            } else {
                sb.append('#');
            }
            if (i2 == 0) {
                if (currencyAsDecimal) {
                    sb.append((char) 164);
                } else {
                    sb.append('.');
                }
            }
            if (groupingUsed) {
                if (i2 > 0) {
                    sb.append(',');
                }
                if (i2 <= iMax2) {
                }
            }
        }
        if (iMin7 != Math.min(100, -1)) {
            sb.append('E');
            if (exponentSignAlwaysShown) {
                sb.append('+');
            }
            while (i6 < iMin7) {
                sb.append('0');
            }
        }
        length = sb.length();
        sb.append(affixPatternProviderForProperties.getString(0));
        if (iMin2 > 0) {
            while (iMin2 - sb.length() > 0) {
                sb.insert(length3, '#');
                length++;
            }
            i3 = length3;
            i5 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[padPosition.ordinal()];
            if (i5 != 1) {
                iEscapePaddingString = escapePaddingString(padString, sb, 0);
                sb.insert(0, '*');
            } else if (i5 != 2) {
                iEscapePaddingString = escapePaddingString(padString, sb, i3);
                sb.insert(i3, '*');
            } else if (i5 != 3) {
                escapePaddingString(padString, sb, length);
                sb.insert(length, '*');
            } else if (i5 == 4) {
                sb.append('*');
                escapePaddingString(padString, sb, sb.length());
            }
            int i10 = iEscapePaddingString + 1;
            i4 = i3 + i10;
            length += i10;
            if (affixPatternProviderForProperties.hasNegativeSubpattern()) {
                sb.append(';');
                sb.append(affixPatternProviderForProperties.getString(768));
                sb.append((CharSequence) sb, i4, length);
                sb.append(affixPatternProviderForProperties.getString(512));
            }
            return sb.toString();
        }
        i3 = length3;
        i4 = i3;
        if (affixPatternProviderForProperties.hasNegativeSubpattern()) {
            sb.append(';');
            sb.append(affixPatternProviderForProperties.getString(768));
            sb.append((CharSequence) sb, i4, length);
            sb.append(affixPatternProviderForProperties.getString(512));
        }
        return sb.toString();
    }

    public static PatternSignType resolveSignDisplay(NumberFormatter.SignDisplay signDisplay, Modifier.Signum signum) {
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[signDisplay.ordinal()]) {
            case 1:
            case 2:
                int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[signum.ordinal()];
                if (i == 1 || i == 2) {
                    return PatternSignType.NEG;
                }
                if (i == 3 || i == 4) {
                    return PatternSignType.POS;
                }
                break;
            case 3:
            case 4:
                int i2 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[signum.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return PatternSignType.NEG;
                }
                if (i2 == 3 || i2 == 4) {
                    return PatternSignType.POS_SIGN;
                }
                break;
            case 5:
            case 6:
                int i3 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[signum.ordinal()];
                if (i3 == 1) {
                    return PatternSignType.NEG;
                }
                if (i3 == 2 || i3 == 3) {
                    return PatternSignType.POS;
                }
                if (i3 == 4) {
                    return PatternSignType.POS_SIGN;
                }
                break;
            case 7:
            case 8:
                int i4 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[signum.ordinal()];
                if (i4 == 1) {
                    return PatternSignType.NEG;
                }
                if (i4 == 2 || i4 == 3 || i4 == 4) {
                    return PatternSignType.POS;
                }
                break;
            case 9:
                return PatternSignType.POS;
        }
        og.m("Unreachable");
        return null;
    }
}
