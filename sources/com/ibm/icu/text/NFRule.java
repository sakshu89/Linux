package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.og;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class NFRule {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int DEFAULT_RULE = -4;
    static final int IMPROPER_FRACTION_RULE = -2;
    static final int INFINITY_RULE = -5;
    static final int NAN_RULE = -6;
    static final int NEGATIVE_NUMBER_RULE = -1;
    static final int PROPER_FRACTION_RULE = -3;
    private long baseValue;
    final RuleBasedNumberFormat formatter;
    private String ruleText;
    static final Long ZERO = 0L;
    private static final String[] RULE_PREFIXES = {"<<", "<%", "<#", "<0", ">>", ">%", ">#", ">0", "=%", "=#", "=0"};
    private int radix = 10;
    private short exponent = 0;
    private char decimalPoint = 0;
    private PluralFormat rulePatternFormat = null;
    private NFSubstitution sub1 = null;
    private NFSubstitution sub2 = null;

    public NFRule(RuleBasedNumberFormat ruleBasedNumberFormat, String str) {
        this.ruleText = null;
        this.formatter = ruleBasedNumberFormat;
        this.ruleText = str != null ? parseRuleDescriptor(str) : null;
    }

    private boolean allIgnorable(String str) {
        return str == null || str.isEmpty();
    }

    private short expectedExponent() {
        if (this.radix == 0) {
            return (short) 0;
        }
        long j = this.baseValue;
        if (j < 1) {
            return (short) 0;
        }
        short sLog = (short) (Math.log(j) / Math.log(this.radix));
        short s = (short) (sLog + 1);
        return power((long) this.radix, s) <= this.baseValue ? s : sLog;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    private NFSubstitution extractSubstitution(NFRuleSet nFRuleSet, NFRule nFRule) {
        int i;
        int iIndexOfAnyRulePrefix = indexOfAnyRulePrefix(this.ruleText);
        if (iIndexOfAnyRulePrefix == -1) {
            return null;
        }
        if (this.ruleText.startsWith(">>>", iIndexOfAnyRulePrefix)) {
            i = iIndexOfAnyRulePrefix + 2;
        } else {
            char cCharAt = this.ruleText.charAt(iIndexOfAnyRulePrefix);
            int iIndexOf = this.ruleText.indexOf(cCharAt, iIndexOfAnyRulePrefix + 1);
            if (cCharAt != '<' || iIndexOf == -1 || iIndexOf >= this.ruleText.length() - 1) {
                i = iIndexOf;
            } else {
                int i2 = iIndexOf + 1;
                if (this.ruleText.charAt(i2) == cCharAt) {
                    i = i2;
                } else {
                    i = iIndexOf;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        int i3 = i + 1;
        NFSubstitution nFSubstitutionMakeSubstitution = NFSubstitution.makeSubstitution(iIndexOfAnyRulePrefix, this, nFRule, nFRuleSet, this.formatter, this.ruleText.substring(iIndexOfAnyRulePrefix, i3));
        this.ruleText = this.ruleText.substring(0, iIndexOfAnyRulePrefix).concat(this.ruleText.substring(i3));
        return nFSubstitutionMakeSubstitution;
    }

    private void extractSubstitutions(NFRuleSet nFRuleSet, String str, NFRule nFRule) {
        PluralRules.PluralType pluralType;
        this.ruleText = str;
        NFSubstitution nFSubstitutionExtractSubstitution = extractSubstitution(nFRuleSet, nFRule);
        this.sub1 = nFSubstitutionExtractSubstitution;
        if (nFSubstitutionExtractSubstitution == null) {
            this.sub2 = null;
        } else {
            this.sub2 = extractSubstitution(nFRuleSet, nFRule);
        }
        NFSubstitution nFSubstitution = this.sub1;
        if (nFSubstitution != null && this.sub2 != null && nFSubstitution.getClass().equals(this.sub2.getClass())) {
            nFRuleSet.owner.unparseable = true;
        }
        int iIndexOf = this.ruleText.indexOf("$(");
        int iIndexOf2 = iIndexOf >= 0 ? this.ruleText.indexOf(")$", iIndexOf) : -1;
        if (iIndexOf2 >= 0) {
            int iIndexOf3 = this.ruleText.indexOf(44, iIndexOf);
            String str2 = this.ruleText;
            if (iIndexOf3 < 0) {
                og.i(cq.v("Rule \"", str2, "\" does not have a defined type"));
                return;
            }
            String strSubstring = str2.substring(iIndexOf + 2, iIndexOf3);
            if ("cardinal".equals(strSubstring)) {
                pluralType = PluralRules.PluralType.CARDINAL;
            } else {
                if (!"ordinal".equals(strSubstring)) {
                    og.i(strSubstring.concat(" is an unknown type"));
                    return;
                }
                pluralType = PluralRules.PluralType.ORDINAL;
            }
            this.rulePatternFormat = this.formatter.createPluralFormat(pluralType, this.ruleText.substring(iIndexOf3 + 1, iIndexOf2));
        }
    }

    private int[] findText(String str, String str2, PluralFormat pluralFormat, int i) {
        if (pluralFormat == null) {
            if (!this.formatter.lenientParseEnabled()) {
                return new int[]{str.indexOf(str2, i), str2.length()};
            }
            int iIndexOf = str.indexOf(str2, i);
            if (iIndexOf >= 0) {
                return new int[]{iIndexOf, str2.length()};
            }
            while (i < str.length()) {
                int iPrefixLength = prefixLength(str.substring(i), str2);
                if (iPrefixLength != 0) {
                    return new int[]{i, iPrefixLength};
                }
                i++;
            }
            return new int[]{-1, 0};
        }
        FieldPosition fieldPosition = new FieldPosition(0);
        fieldPosition.setBeginIndex(i);
        pluralFormat.parseType(str, fieldPosition);
        int beginIndex = fieldPosition.getBeginIndex();
        if (beginIndex >= 0) {
            int iIndexOf2 = this.ruleText.indexOf("$(");
            int iIndexOf3 = this.ruleText.indexOf(")$", iIndexOf2) + 2;
            int endIndex = fieldPosition.getEndIndex() - beginIndex;
            String strSubstring = this.ruleText.substring(0, iIndexOf2);
            String strSubstring2 = this.ruleText.substring(iIndexOf3);
            if (str.regionMatches(beginIndex - strSubstring.length(), strSubstring, 0, strSubstring.length()) && str.regionMatches(beginIndex + endIndex, strSubstring2, 0, strSubstring2.length())) {
                return new int[]{beginIndex - strSubstring.length(), strSubstring2.length() + strSubstring.length() + endIndex};
            }
        }
        return new int[]{-1, 0};
    }

    private static int indexOfAnyRulePrefix(String str) {
        if (str.isEmpty()) {
            return -1;
        }
        int i = -1;
        for (String str2 : RULE_PREFIXES) {
            int iIndexOf = str.indexOf(str2);
            if (iIndexOf != -1 && (i == -1 || iIndexOf < i)) {
                i = iIndexOf;
            }
        }
        return i;
    }

    private static boolean isLenientSeparator(char c) {
        int type = UCharacter.getType(c);
        return type == 12 || type == 19 || type == 16 || c == ',' || c == '.';
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    public static void makeRules(String str, NFRuleSet nFRuleSet, NFRule nFRule, RuleBasedNumberFormat ruleBasedNumberFormat, List<NFRule> list) {
        List<NFRule> list2;
        long j;
        NFRule nFRule2 = new NFRule(ruleBasedNumberFormat, str);
        String str2 = nFRule2.ruleText;
        int iIndexOf = str2.indexOf(91);
        int iIndexOf2 = iIndexOf < 0 ? -1 : str2.indexOf(93);
        if (iIndexOf2 < 0 || iIndexOf > iIndexOf2) {
            list2 = list;
            j = 0;
            nFRule2.extractSubstitutions(nFRuleSet, str2, nFRule);
        } else {
            long j2 = nFRule2.baseValue;
            if (j2 == -3 || j2 == -1 || j2 == -5 || j2 == -6) {
                list2 = list;
                j = 0;
                nFRule2.extractSubstitutions(nFRuleSet, str2, nFRule);
            } else {
                StringBuilder sb = new StringBuilder();
                int iIndexOf3 = str2.indexOf(124);
                j = 0;
                long jPower = power(nFRule2.radix, nFRule2.exponent);
                long j3 = nFRule2.baseValue;
                if (j3 > 0 && jPower == 0) {
                    og.i("value out of range");
                    return;
                }
                NFRule nFRule3 = null;
                if ((j3 > 0 && j3 % jPower == 0) || j3 == -2 || j3 == -4) {
                    NFRule nFRule4 = new NFRule(ruleBasedNumberFormat, null);
                    long j4 = nFRule2.baseValue;
                    if (j4 >= 0) {
                        nFRule4.baseValue = j4;
                        if (!nFRuleSet.isFractionSet()) {
                            nFRule2.baseValue++;
                        }
                    } else if (j4 == -2) {
                        nFRule4.baseValue = -3L;
                    } else if (j4 == -4) {
                        nFRule4.baseValue = j4;
                        nFRule2.baseValue = -2L;
                    }
                    nFRule4.radix = nFRule2.radix;
                    nFRule4.exponent = nFRule2.exponent;
                    sb.append((CharSequence) str2, 0, iIndexOf);
                    if (iIndexOf3 >= 0) {
                        sb.append((CharSequence) str2, iIndexOf3 + 1, iIndexOf2);
                    }
                    int i = iIndexOf2 + 1;
                    if (i < str2.length()) {
                        sb.append((CharSequence) str2, i, str2.length());
                    }
                    nFRule4.extractSubstitutions(nFRuleSet, sb.toString(), nFRule);
                    nFRule3 = nFRule4;
                }
                sb.setLength(0);
                sb.append((CharSequence) str2, 0, iIndexOf);
                if (iIndexOf3 >= 0) {
                    sb.append((CharSequence) str2, iIndexOf + 1, iIndexOf3);
                } else {
                    sb.append((CharSequence) str2, iIndexOf + 1, iIndexOf2);
                }
                int i2 = iIndexOf2 + 1;
                if (i2 < str2.length()) {
                    sb.append(str2.substring(i2));
                }
                nFRule2.extractSubstitutions(nFRuleSet, sb.toString(), nFRule);
                if (nFRule3 == null) {
                    list2 = list;
                } else if (nFRule3.baseValue >= 0) {
                    list2 = list;
                    list2.add(nFRule3);
                } else {
                    list2 = list;
                    nFRuleSet.setNonNumericalRule(nFRule3);
                }
            }
        }
        if (nFRule2.baseValue >= j) {
            list2.add(nFRule2);
        } else {
            nFRuleSet.setNonNumericalRule(nFRule2);
        }
    }

    private Number matchToDelimiter(String str, int i, double d, String str2, PluralFormat pluralFormat, ParsePosition parsePosition, NFSubstitution nFSubstitution, double d2, int i2, int i3) {
        if (allIgnorable(str2)) {
            if (nFSubstitution == null) {
                return Double.valueOf(d);
            }
            ParsePosition parsePosition2 = new ParsePosition(0);
            Long l = ZERO;
            Number numberDoParse = nFSubstitution.doParse(str, parsePosition2, d, d2, this.formatter.lenientParseEnabled(), i2, i3);
            if (parsePosition2.getIndex() != 0) {
                parsePosition.setIndex(parsePosition2.getIndex());
                return numberDoParse != null ? numberDoParse : l;
            }
            parsePosition.setErrorIndex(parsePosition2.getErrorIndex());
            return l;
        }
        ParsePosition parsePosition3 = new ParsePosition(0);
        Number number = null;
        int i4 = i;
        while (true) {
            parsePosition3.setIndex(0);
            int[] iArrFindText = findText(str, str2, pluralFormat, i4);
            int i5 = iArrFindText[0];
            int i6 = iArrFindText[1];
            if (i5 < 0) {
                if (number != null) {
                    return number;
                }
                parsePosition.setIndex(0);
                return ZERO;
            }
            String strSubstring = str.substring(0, i5);
            if (!strSubstring.isEmpty()) {
                Number numberDoParse2 = nFSubstitution.doParse(strSubstring, parsePosition3, d, d2, this.formatter.lenientParseEnabled(), i2, i3);
                if (parsePosition3.getIndex() == i5) {
                    parsePosition.setIndex(i5 + i6);
                    number = numberDoParse2;
                } else {
                    if (number != null) {
                        return number;
                    }
                    if (parsePosition3.getErrorIndex() > 0) {
                        parsePosition.setErrorIndex(parsePosition3.getErrorIndex());
                    } else {
                        parsePosition.setErrorIndex(parsePosition3.getIndex());
                    }
                }
            }
            i4 = i6 + i5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x010f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0117  */
    /* JADX WARN: Code duplicated, block: B:71:0x011d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0120  */
    /* JADX WARN: Code duplicated, block: B:76:0x0131  */
    /* JADX WARN: Code duplicated, block: B:78:0x0134 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:80:0x0142 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0144 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:83:0x0152  */
    /* JADX WARN: Code duplicated, block: B:85:0x015a  */
    /* JADX WARN: Code duplicated, block: B:86:0x0160  */
    /* JADX WARN: Code duplicated, block: B:88:0x0168  */
    private String parseRuleDescriptor(String str) {
        String str2;
        short s;
        String strSubstring = str;
        int iIndexOf = strSubstring.indexOf(58);
        if (iIndexOf != -1) {
            String strSubstring2 = strSubstring.substring(0, iIndexOf);
            int i = iIndexOf + 1;
            while (i < strSubstring.length() && PatternProps.isWhiteSpace(strSubstring.charAt(i))) {
                i++;
            }
            strSubstring = strSubstring.substring(i);
            int length = strSubstring2.length();
            char cCharAt = strSubstring2.charAt(0);
            char cCharAt2 = strSubstring2.charAt(length - 1);
            if (cCharAt >= '0') {
                char c = '9';
                if (cCharAt <= '9' && cCharAt2 != 'x') {
                    int i2 = 0;
                    char cCharAt3 = 0;
                    long j = 0;
                    while (i2 < length) {
                        cCharAt3 = strSubstring2.charAt(i2);
                        if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                            j = (j * 10) + ((long) (cCharAt3 - '0'));
                        } else {
                            if (cCharAt3 == '/' || cCharAt3 == '>') {
                                break;
                            }
                            if (!PatternProps.isWhiteSpace(cCharAt3) && cCharAt3 != ',' && cCharAt3 != '.') {
                                throw new IllegalArgumentException("Illegal character " + cCharAt3 + " in rule descriptor");
                            }
                        }
                        i2++;
                    }
                    setBaseValue(j);
                    if (cCharAt3 == '/') {
                        i2++;
                        char cCharAt4 = cCharAt3;
                        long j2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                str2 = null;
                                break;
                            }
                            cCharAt4 = strSubstring2.charAt(i2);
                            if (cCharAt4 < '0' || cCharAt4 > c) {
                                str2 = null;
                                if (cCharAt4 == '>') {
                                    break;
                                }
                                if (!PatternProps.isWhiteSpace(cCharAt4) && cCharAt4 != ',' && cCharAt4 != '.') {
                                    throw new IllegalArgumentException("Illegal character " + cCharAt4 + " in rule descriptor");
                                }
                            } else {
                                j2 = (j2 * 10) + ((long) (cCharAt4 - '0'));
                            }
                            i2++;
                            c = '9';
                        }
                        int i3 = (int) j2;
                        this.radix = i3;
                        if (i3 == 0) {
                            og.i("Rule can't have radix of 0");
                            return str2;
                        }
                        this.exponent = expectedExponent();
                        cCharAt3 = cCharAt4;
                    } else {
                        str2 = null;
                    }
                    if (cCharAt3 == '>') {
                        while (i2 < length) {
                            if (strSubstring2.charAt(i2) != '>' || (s = this.exponent) <= 0) {
                                og.i("Illegal character in rule descriptor");
                                return str2;
                            }
                            this.exponent = (short) (s - 1);
                            i2++;
                        }
                    }
                } else if (strSubstring2.equals("-x")) {
                    setBaseValue(-1L);
                } else if (length == 3) {
                    if (cCharAt != '0' && cCharAt2 == 'x') {
                        setBaseValue(-3L);
                        this.decimalPoint = strSubstring2.charAt(1);
                    } else if (cCharAt != 'x' && cCharAt2 == 'x') {
                        setBaseValue(-2L);
                        this.decimalPoint = strSubstring2.charAt(1);
                    } else if (cCharAt != 'x' && cCharAt2 == '0') {
                        setBaseValue(-4L);
                        this.decimalPoint = strSubstring2.charAt(1);
                    } else if (strSubstring2.equals("NaN")) {
                        setBaseValue(-6L);
                    } else if (strSubstring2.equals("Inf")) {
                        setBaseValue(-5L);
                    }
                }
            } else if (strSubstring2.equals("-x")) {
                setBaseValue(-1L);
            } else if (length == 3) {
                if (cCharAt != '0') {
                    if (cCharAt != 'x') {
                        if (cCharAt != 'x') {
                            if (strSubstring2.equals("NaN")) {
                                setBaseValue(-6L);
                            } else if (strSubstring2.equals("Inf")) {
                                setBaseValue(-5L);
                            }
                        } else if (strSubstring2.equals("NaN")) {
                            setBaseValue(-6L);
                        } else if (strSubstring2.equals("Inf")) {
                            setBaseValue(-5L);
                        }
                    } else if (cCharAt != 'x') {
                        if (strSubstring2.equals("NaN")) {
                            setBaseValue(-6L);
                        } else if (strSubstring2.equals("Inf")) {
                            setBaseValue(-5L);
                        }
                    } else if (strSubstring2.equals("NaN")) {
                        setBaseValue(-6L);
                    } else if (strSubstring2.equals("Inf")) {
                        setBaseValue(-5L);
                    }
                } else if (cCharAt != 'x') {
                    if (cCharAt != 'x') {
                        if (strSubstring2.equals("NaN")) {
                            setBaseValue(-6L);
                        } else if (strSubstring2.equals("Inf")) {
                            setBaseValue(-5L);
                        }
                    } else if (strSubstring2.equals("NaN")) {
                        setBaseValue(-6L);
                    } else if (strSubstring2.equals("Inf")) {
                        setBaseValue(-5L);
                    }
                } else if (cCharAt != 'x') {
                    if (strSubstring2.equals("NaN")) {
                        setBaseValue(-6L);
                    } else if (strSubstring2.equals("Inf")) {
                        setBaseValue(-5L);
                    }
                } else if (strSubstring2.equals("NaN")) {
                    setBaseValue(-6L);
                } else if (strSubstring2.equals("Inf")) {
                    setBaseValue(-5L);
                }
            }
        }
        return (strSubstring.isEmpty() || strSubstring.charAt(0) != '\'') ? strSubstring : strSubstring.substring(1);
    }

    public static long power(long j, short s) {
        if (s < 0) {
            og.i("Exponent can not be negative");
            return 0L;
        }
        if (j < 0) {
            og.i("Base can not be negative");
            return 0L;
        }
        long j2 = 1;
        while (s > 0) {
            if ((s & 1) == 1) {
                j2 *= j;
            }
            j *= j;
            s = (short) (s >> 1);
        }
        return j2;
    }

    private int prefixLength(String str, String str2) {
        String strNormalize;
        int i;
        int iCharCount;
        int i2;
        int length;
        boolean z;
        int i3;
        int i4;
        int i5 = 0;
        if (str2.isEmpty()) {
            return 0;
        }
        if (str.startsWith(str2)) {
            return str2.length();
        }
        if (!this.formatter.lenientParseEnabled()) {
            return 0;
        }
        Normalizer2 nFCInstance = Normalizer2.getNFCInstance();
        String strNormalize2 = nFCInstance.normalize(str2);
        int length2 = str.length();
        int length3 = strNormalize2.length();
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        while (true) {
            strNormalize = "";
            if (i6 >= length3) {
                i = 0;
                iCharCount = 0;
                i2 = 0;
                length = 0;
                z = true;
                break;
            }
            if (!isLenientSeparator(strNormalize2.charAt(i6))) {
                i = 0;
                iCharCount = 0;
                i2 = 0;
                length = 0;
                z = false;
                break;
            }
            i6++;
        }
        while (true) {
            if (i < length3) {
                int i7 = i5;
                while (i2 >= length && iCharCount < length2 && isLenientSeparator(str.charAt(iCharCount))) {
                    iCharCount++;
                    i7++;
                }
                while (i < length3 && isLenientSeparator(strNormalize2.charAt(i))) {
                    i++;
                }
                if (!z || i < length3 || i7 != 0) {
                    if (i < length3) {
                        if (i2 >= length) {
                            if (iCharCount < length2) {
                                sb.setLength(i5);
                                do {
                                    int iCodePointAt = Character.codePointAt(str, iCharCount);
                                    sb.appendCodePoint(iCodePointAt);
                                    iCharCount += Character.charCount(iCodePointAt);
                                    if (iCharCount >= length2) {
                                        break;
                                    }
                                } while (!nFCInstance.hasBoundaryBefore(Character.codePointAt(str, iCharCount)));
                                strNormalize = nFCInstance.normalize(sb);
                                length = strNormalize.length();
                                i2 = i5;
                            }
                        }
                        int i8 = i2 + 1;
                        i3 = i5;
                        if (UCharacter.foldCase(strNormalize.charAt(i2), this.formatter.caseFoldOption) != UCharacter.foldCase(strNormalize2.charAt(i), this.formatter.caseFoldOption)) {
                            i4 = i3;
                            break;
                        }
                        i++;
                        i2 = i8;
                        i5 = i3;
                    }
                }
                i4 = i5;
                i3 = i4;
                break;
            }
            i3 = i5;
            i4 = 1;
            break;
        }
        if (i4 != 0) {
            return iCharCount;
        }
        RbnfLenientScanner lenientScanner = this.formatter.getLenientScanner();
        return lenientScanner != null ? lenientScanner.prefixLength(str, str2) : i3;
    }

    private String stripPrefix(String str, String str2, ParsePosition parsePosition) {
        int iPrefixLength;
        if (str2.isEmpty() || (iPrefixLength = prefixLength(str, str2)) == 0) {
            return str;
        }
        parsePosition.setIndex(parsePosition.getIndex() + iPrefixLength);
        return str.substring(iPrefixLength);
    }

    public void doFormat(double d, StringBuilder sb, int i, int i2) {
        int length;
        int length2 = this.ruleText.length();
        PluralFormat pluralFormat = this.rulePatternFormat;
        String str = this.ruleText;
        if (pluralFormat == null) {
            sb.insert(i, str);
            length = 0;
        } else {
            length2 = str.indexOf("$(");
            int iIndexOf = this.ruleText.indexOf(")$", length2);
            int length3 = sb.length();
            if (iIndexOf < this.ruleText.length() - 1) {
                sb.insert(i, this.ruleText.substring(iIndexOf + 2));
            }
            sb.insert(i, this.rulePatternFormat.format((long) ((0.0d > d || d >= 1.0d) ? d / power(this.radix, this.exponent) : Math.round(power(this.radix, this.exponent) * d))));
            if (length2 > 0) {
                sb.insert(i, this.ruleText.substring(0, length2));
            }
            length = this.ruleText.length() - (sb.length() - length3);
        }
        NFSubstitution nFSubstitution = this.sub2;
        if (nFSubstitution != null) {
            nFSubstitution.doSubstitution(d, sb, i - (nFSubstitution.getPos() > length2 ? length : 0), i2);
        }
        NFSubstitution nFSubstitution2 = this.sub1;
        if (nFSubstitution2 != null) {
            nFSubstitution2.doSubstitution(d, sb, i - (nFSubstitution2.getPos() > length2 ? length : 0), i2);
        }
    }

    public Number doParse(String str, ParsePosition parsePosition, boolean z, double d, int i, int i2) {
        String str2;
        int i3;
        int i4;
        NFSubstitution nFSubstitution;
        int i5 = 0;
        ParsePosition parsePosition2 = new ParsePosition(0);
        NFSubstitution nFSubstitution2 = this.sub1;
        int pos = nFSubstitution2 != null ? nFSubstitution2.getPos() : this.ruleText.length();
        NFSubstitution nFSubstitution3 = this.sub2;
        int pos2 = nFSubstitution3 != null ? nFSubstitution3.getPos() : this.ruleText.length();
        String strStripPrefix = stripPrefix(str, this.ruleText.substring(0, pos), parsePosition2);
        int length = str.length() - strStripPrefix.length();
        if (parsePosition2.getIndex() == 0 && pos != 0) {
            parsePosition.setErrorIndex(parsePosition2.getErrorIndex());
            return ZERO;
        }
        long j = this.baseValue;
        if (j == -5) {
            parsePosition.setIndex(parsePosition2.getIndex());
            return Double.valueOf(Double.POSITIVE_INFINITY);
        }
        if (j == -6) {
            parsePosition.setIndex(parsePosition2.getIndex());
            return Double.valueOf(Double.NaN);
        }
        double dMax = Math.max(0L, j);
        double d2 = 0.0d;
        int index = 0;
        String str3 = strStripPrefix;
        int i6 = 0;
        while (true) {
            parsePosition2.setIndex(i5);
            int i7 = index;
            int i8 = pos2;
            String str4 = str3;
            double d3 = dMax;
            ParsePosition parsePosition3 = parsePosition2;
            double dDoubleValue = matchToDelimiter(str4, i6, dMax, this.ruleText.substring(pos, pos2), this.rulePatternFormat, parsePosition2, this.sub1, d, i, i2).doubleValue();
            if (parsePosition3.getIndex() != 0 || (nFSubstitution = this.sub1) == null) {
                int index2 = parsePosition3.getIndex();
                String strSubstring = str4.substring(parsePosition3.getIndex());
                ParsePosition parsePosition4 = new ParsePosition(i5);
                str2 = str4;
                i3 = i8;
                double dDoubleValue2 = matchToDelimiter(strSubstring, 0, dDoubleValue, this.ruleText.substring(i8), this.rulePatternFormat, parsePosition4, this.sub2, d, i, i2).doubleValue();
                if (parsePosition4.getIndex() != 0 || this.sub2 == null) {
                    i4 = i7;
                    if (parsePosition4.getIndex() + parsePosition3.getIndex() + length > i4) {
                        index = parsePosition4.getIndex() + parsePosition3.getIndex() + length;
                        d2 = dDoubleValue2;
                    }
                    i6 = index2;
                } else {
                    int index3 = parsePosition3.getIndex() + parsePosition4.getErrorIndex() + this.sub1.getPos();
                    if (index3 > parsePosition.getErrorIndex()) {
                        parsePosition.setErrorIndex(index3);
                    }
                    i4 = i7;
                }
                index = i4;
                i6 = index2;
            } else {
                int errorIndex = parsePosition3.getErrorIndex() + nFSubstitution.getPos();
                if (errorIndex > parsePosition.getErrorIndex()) {
                    parsePosition.setErrorIndex(errorIndex);
                }
                str2 = str4;
                index = i7;
                i3 = i8;
            }
            if (pos == i3 || parsePosition3.getIndex() <= 0 || parsePosition3.getIndex() >= str2.length() || parsePosition3.getIndex() == i6) {
                break;
            }
            pos2 = i3;
            parsePosition2 = parsePosition3;
            dMax = d3;
            str3 = str2;
            i5 = 0;
        }
        parsePosition.setIndex(index);
        if (index > 0) {
            parsePosition.setErrorIndex(0);
        }
        if (z && index > 0 && this.sub1 == null) {
            d2 = 1.0d / d2;
        }
        double d4 = d2;
        long j2 = (long) d4;
        return d4 == ((double) j2) ? Long.valueOf(j2) : Double.valueOf(d4);
    }

    public boolean equals(Object obj) {
        if (obj instanceof NFRule) {
            NFRule nFRule = (NFRule) obj;
            if (this.baseValue == nFRule.baseValue && this.radix == nFRule.radix && this.exponent == nFRule.exponent && this.ruleText.equals(nFRule.ruleText) && Objects.equals(this.sub1, nFRule.sub1) && Objects.equals(this.sub2, nFRule.sub2)) {
                return true;
            }
        }
        return false;
    }

    public long getBaseValue() {
        return this.baseValue;
    }

    public char getDecimalPoint() {
        return this.decimalPoint;
    }

    public long getDivisor() {
        return power(this.radix, this.exponent);
    }

    public boolean hasModulusSubstitution() {
        return (this.sub1 instanceof ModulusSubstitution) || (this.sub2 instanceof ModulusSubstitution);
    }

    public int hashCode() {
        return 42;
    }

    public void setBaseValue(long j) {
        this.baseValue = j;
        this.radix = 10;
        if (j < 1) {
            this.exponent = (short) 0;
            return;
        }
        short sExpectedExponent = expectedExponent();
        this.exponent = sExpectedExponent;
        NFSubstitution nFSubstitution = this.sub1;
        if (nFSubstitution != null) {
            nFSubstitution.setDivisor(this.radix, sExpectedExponent);
        }
        NFSubstitution nFSubstitution2 = this.sub2;
        if (nFSubstitution2 != null) {
            nFSubstitution2.setDivisor(this.radix, this.exponent);
        }
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        NFSubstitution nFSubstitution = this.sub1;
        if (nFSubstitution != null) {
            nFSubstitution.setDecimalFormatSymbols(decimalFormatSymbols);
        }
        NFSubstitution nFSubstitution2 = this.sub2;
        if (nFSubstitution2 != null) {
            nFSubstitution2.setDecimalFormatSymbols(decimalFormatSymbols);
        }
    }

    public boolean shouldRollBack(long j) {
        NFSubstitution nFSubstitution;
        NFSubstitution nFSubstitution2 = this.sub1;
        if ((nFSubstitution2 != null && nFSubstitution2.isModulusSubstitution()) || ((nFSubstitution = this.sub2) != null && nFSubstitution.isModulusSubstitution())) {
            long jPower = power(this.radix, this.exponent);
            if (j % jPower == 0 && this.baseValue % jPower != 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        NFSubstitution nFSubstitution;
        StringBuilder sb = new StringBuilder();
        long j = this.baseValue;
        if (j == -1) {
            sb.append("-x");
        } else if (j == -2) {
            sb.append(ULocale.PRIVATE_USE_EXTENSION);
            char c = this.decimalPoint;
            sb.append(c != 0 ? c : '.');
            sb.append(ULocale.PRIVATE_USE_EXTENSION);
        } else if (j == -3) {
            sb.append('0');
            char c2 = this.decimalPoint;
            sb.append(c2 != 0 ? c2 : '.');
            sb.append(ULocale.PRIVATE_USE_EXTENSION);
        } else if (j == -4) {
            sb.append(ULocale.PRIVATE_USE_EXTENSION);
            char c3 = this.decimalPoint;
            sb.append(c3 != 0 ? c3 : '.');
            sb.append('0');
        } else if (j == -5) {
            sb.append("Inf");
        } else if (j == -6) {
            sb.append("NaN");
        } else {
            sb.append(j);
            if (this.radix != 10) {
                sb.append('/');
                sb.append(this.radix);
            }
            int iExpectedExponent = expectedExponent() - this.exponent;
            for (int i = 0; i < iExpectedExponent; i++) {
                sb.append('>');
            }
        }
        sb.append(": ");
        if (this.ruleText.startsWith(Padder.FALLBACK_PADDING_STRING) && ((nFSubstitution = this.sub1) == null || nFSubstitution.getPos() != 0)) {
            sb.append(PatternTokenizer.SINGLE_QUOTE);
        }
        StringBuilder sb2 = new StringBuilder(this.ruleText);
        NFSubstitution nFSubstitution2 = this.sub2;
        if (nFSubstitution2 != null) {
            sb2.insert(nFSubstitution2.getPos(), this.sub2);
        }
        NFSubstitution nFSubstitution3 = this.sub1;
        if (nFSubstitution3 != null) {
            sb2.insert(nFSubstitution3.getPos(), this.sub1);
        }
        sb.append((CharSequence) sb2);
        sb.append(';');
        return sb.toString();
    }

    public void doFormat(long j, StringBuilder sb, int i, int i2) {
        int length;
        int length2 = this.ruleText.length();
        PluralFormat pluralFormat = this.rulePatternFormat;
        String str = this.ruleText;
        if (pluralFormat == null) {
            sb.insert(i, str);
            length = 0;
        } else {
            length2 = str.indexOf("$(");
            int iIndexOf = this.ruleText.indexOf(")$", length2);
            int length3 = sb.length();
            if (iIndexOf < this.ruleText.length() - 1) {
                sb.insert(i, this.ruleText.substring(iIndexOf + 2));
            }
            sb.insert(i, this.rulePatternFormat.format(j / power(this.radix, this.exponent)));
            if (length2 > 0) {
                sb.insert(i, this.ruleText.substring(0, length2));
            }
            length = this.ruleText.length() - (sb.length() - length3);
        }
        NFSubstitution nFSubstitution = this.sub2;
        if (nFSubstitution != null) {
            nFSubstitution.doSubstitution(j, sb, i - (nFSubstitution.getPos() > length2 ? length : 0), i2);
        }
        NFSubstitution nFSubstitution2 = this.sub1;
        if (nFSubstitution2 != null) {
            nFSubstitution2.doSubstitution(j, sb, i - (nFSubstitution2.getPos() > length2 ? length : 0), i2);
        }
    }
}
