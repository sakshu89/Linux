package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import com.ibm.icu.impl.number.Grouper;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.UnicodeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class DecimalMatcher implements NumberParseMatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String decimalSeparator;
    private final UnicodeSet decimalUniSet;
    private final String[] digitStrings;
    private final int grouping1;
    private final int grouping2;
    private final boolean groupingDisabled;
    private final String groupingSeparator;
    private final UnicodeSet groupingUniSet;
    private final boolean integerOnly;
    private final UnicodeSet leadSet;
    private final boolean requireGroupingMatch;
    private final UnicodeSet separatorSet;

    private DecimalMatcher(DecimalFormatSymbols decimalFormatSymbols, Grouper grouper, int i) {
        if ((i & 2) != 0) {
            this.groupingSeparator = decimalFormatSymbols.getMonetaryGroupingSeparatorString();
            this.decimalSeparator = decimalFormatSymbols.getMonetaryDecimalSeparatorString();
        } else {
            this.groupingSeparator = decimalFormatSymbols.getGroupingSeparatorString();
            this.decimalSeparator = decimalFormatSymbols.getDecimalSeparatorString();
        }
        boolean z = (i & 4) != 0;
        StaticUnicodeSets.Key keyChooseFrom = StaticUnicodeSets.chooseFrom(this.groupingSeparator, z ? StaticUnicodeSets.Key.STRICT_COMMA : StaticUnicodeSets.Key.ALL_SEPARATORS, z ? StaticUnicodeSets.Key.STRICT_PERIOD : StaticUnicodeSets.Key.ALL_SEPARATORS);
        keyChooseFrom = keyChooseFrom == null ? StaticUnicodeSets.chooseFrom(this.groupingSeparator, StaticUnicodeSets.Key.OTHER_GROUPING_SEPARATORS) : keyChooseFrom;
        if (keyChooseFrom != null) {
            this.groupingUniSet = StaticUnicodeSets.get(keyChooseFrom);
        } else if (this.groupingSeparator.isEmpty()) {
            this.groupingUniSet = UnicodeSet.EMPTY;
        } else {
            this.groupingUniSet = new UnicodeSet().add(this.groupingSeparator.codePointAt(0)).freeze();
        }
        StaticUnicodeSets.Key keyChooseFrom2 = StaticUnicodeSets.chooseFrom(this.decimalSeparator, z ? StaticUnicodeSets.Key.STRICT_COMMA : StaticUnicodeSets.Key.COMMA, z ? StaticUnicodeSets.Key.STRICT_PERIOD : StaticUnicodeSets.Key.PERIOD);
        if (keyChooseFrom2 != null) {
            this.decimalUniSet = StaticUnicodeSets.get(keyChooseFrom2);
        } else if (this.decimalSeparator.isEmpty()) {
            this.decimalUniSet = UnicodeSet.EMPTY;
        } else {
            this.decimalUniSet = new UnicodeSet().add(this.decimalSeparator.codePointAt(0)).freeze();
        }
        if (keyChooseFrom == null || keyChooseFrom2 == null) {
            this.separatorSet = new UnicodeSet().addAll(this.groupingUniSet).addAll(this.decimalUniSet).freeze();
            this.leadSet = null;
        } else {
            this.separatorSet = this.groupingUniSet;
            this.leadSet = StaticUnicodeSets.get(z ? StaticUnicodeSets.Key.DIGITS_OR_ALL_SEPARATORS : StaticUnicodeSets.Key.DIGITS_OR_STRICT_ALL_SEPARATORS);
        }
        int codePointZero = decimalFormatSymbols.getCodePointZero();
        if (codePointZero != -1 && UCharacter.isDigit(codePointZero) && UCharacter.digit(codePointZero) == 0) {
            this.digitStrings = null;
        } else {
            this.digitStrings = decimalFormatSymbols.getDigitStringsLocal();
        }
        this.requireGroupingMatch = (i & 8) != 0;
        this.groupingDisabled = (i & 32) != 0;
        this.integerOnly = (i & 16) != 0;
        this.grouping1 = grouper.getPrimary();
        this.grouping2 = grouper.getSecondary();
    }

    public static DecimalMatcher getInstance(DecimalFormatSymbols decimalFormatSymbols, Grouper grouper, int i) {
        return new DecimalMatcher(decimalFormatSymbols, grouper, i);
    }

    private boolean validateGroup(int i, int i2, boolean z) {
        if (!this.requireGroupingMatch) {
            return (i == 1 && i2 == 1) ? false : true;
        }
        if (i == -1) {
            return true;
        }
        if (i == 0) {
            if (z) {
                return true;
            }
            return i2 != 0 && i2 <= this.grouping2;
        }
        if (i != 1) {
            return true;
        }
        if (z) {
            return i2 == this.grouping1;
        }
        return i2 == this.grouping2;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x017c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:138:0x01b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:140:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:147:0x01cd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:150:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:155:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:156:0x01f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:159:0x0202  */
    /* JADX WARN: Code duplicated, block: B:161:0x0205  */
    /* JADX WARN: Code duplicated, block: B:165:0x0212 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:169:0x0219  */
    /* JADX WARN: Code duplicated, block: B:170:0x021b  */
    /* JADX WARN: Code duplicated, block: B:174:0x0224  */
    /* JADX WARN: Code duplicated, block: B:177:0x0229  */
    /* JADX WARN: Code duplicated, block: B:179:0x022f  */
    /* JADX WARN: Code duplicated, block: B:191:0x0255  */
    /* JADX WARN: Code duplicated, block: B:192:0x025b  */
    /* JADX WARN: Code duplicated, block: B:193:0x0265  */
    /* JADX WARN: Code duplicated, block: B:195:0x026a  */
    /* JADX WARN: Code duplicated, block: B:198:0x0279 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:208:0x01b6 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0130  */
    public boolean match(StringSegment stringSegment, ParsedNumber parsedNumber, int i) {
        int i2;
        int i3;
        boolean zValidateGroup;
        boolean zValidateGroup2;
        boolean z;
        boolean z2;
        int i4;
        byte bDigit;
        String str;
        byte b;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean zValidateGroup3;
        if (parsedNumber.seenNumber() && i == 0) {
            return false;
        }
        int offset = stringSegment.getOffset();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        boolean z7 = false;
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = null;
        String string = null;
        String string2 = null;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        while (true) {
            if (stringSegment.length() > 0) {
                int codePoint = stringSegment.getCodePoint();
                if (UCharacter.isDigit(codePoint)) {
                    stringSegment.adjustOffset(Character.charCount(codePoint));
                    bDigit = (byte) UCharacter.digit(codePoint);
                } else {
                    bDigit = -1;
                }
                DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD2 = decimalQuantity_DualStorageBCD;
                if (bDigit == -1 && this.digitStrings != null) {
                    byte b2 = bDigit;
                    int i12 = 0;
                    z7 = false;
                    while (true) {
                        String[] strArr = this.digitStrings;
                        str = string;
                        if (i12 >= strArr.length) {
                            b = b2;
                            break;
                        }
                        String str2 = strArr[i12];
                        if (!str2.isEmpty()) {
                            int commonPrefixLength = stringSegment.getCommonPrefixLength(str2);
                            if (commonPrefixLength == str2.length()) {
                                stringSegment.adjustOffset(commonPrefixLength);
                                b = (byte) i12;
                                break;
                            }
                            z7 = z7 || commonPrefixLength == stringSegment.length();
                        }
                        i12++;
                        string = str;
                    }
                } else {
                    str = string;
                    b = bDigit;
                    z7 = false;
                }
                if (b < 0) {
                    if (str != null || this.decimalSeparator.isEmpty()) {
                        string = str;
                        z3 = false;
                    } else {
                        int commonPrefixLength2 = stringSegment.getCommonPrefixLength(this.decimalSeparator);
                        boolean z8 = z7 || commonPrefixLength2 == stringSegment.length();
                        if (commonPrefixLength2 == this.decimalSeparator.length()) {
                            string = this.decimalSeparator;
                            z7 = z8;
                            z3 = true;
                        } else {
                            z7 = z8;
                            string = str;
                            z3 = false;
                        }
                    }
                    if (string2 != null) {
                        int commonPrefixLength3 = stringSegment.getCommonPrefixLength(string2);
                        z4 = z3;
                        z7 = z7 || commonPrefixLength3 == stringSegment.length();
                        z5 = commonPrefixLength3 == string2.length();
                        if (this.groupingDisabled && string2 == null && string == null && !this.groupingSeparator.isEmpty()) {
                            int commonPrefixLength4 = stringSegment.getCommonPrefixLength(this.groupingSeparator);
                            z6 = z5;
                            z7 = z7 || commonPrefixLength4 == stringSegment.length();
                            if (commonPrefixLength4 == this.groupingSeparator.length()) {
                                string2 = this.groupingSeparator;
                                z6 = true;
                            }
                        } else {
                            z6 = z5;
                        }
                        if (!z6 && string == null && this.decimalUniSet.contains(codePoint)) {
                            string = UCharacter.toString(codePoint);
                            z4 = true;
                        }
                        if (!this.groupingDisabled && string2 == null && string == null && this.groupingUniSet.contains(codePoint)) {
                            string2 = UCharacter.toString(codePoint);
                            z6 = true;
                        }
                        if ((z4 || z6) && ((!z4 || !this.integerOnly) && (i8 != 2 || !z6))) {
                            zValidateGroup3 = validateGroup(i9, i10, false);
                            boolean zValidateGroup4 = validateGroup(i8, i7, true);
                            if (zValidateGroup3 || (z4 && !zValidateGroup4)) {
                                if ((z6 || i7 != 0) && this.requireGroupingMatch) {
                                    i2 = 2;
                                    decimalQuantity_DualStorageBCD = null;
                                }
                                if (i8 == i2 && i7 == 0) {
                                    stringSegment.setOffset(i5);
                                    i8 = i9;
                                    i7 = i10;
                                    i5 = i11;
                                    i3 = -1;
                                    i9 = 0;
                                    i10 = 1;
                                    z7 = true;
                                } else {
                                    i3 = i11;
                                }
                                zValidateGroup = validateGroup(i9, i10, false);
                                zValidateGroup2 = validateGroup(i8, i7, true);
                                if (!this.requireGroupingMatch) {
                                    if (!zValidateGroup) {
                                        stringSegment.setOffset(i3);
                                        i4 = i10 + i7;
                                    } else if (!zValidateGroup2 || (i9 == 0 && i10 == 0)) {
                                        i4 = 0;
                                    } else {
                                        stringSegment.setOffset(i5);
                                        z7 = true;
                                        i4 = i7;
                                    }
                                    if (i4 != 0) {
                                        decimalQuantity_DualStorageBCD.adjustMagnitude(-i4);
                                        decimalQuantity_DualStorageBCD.truncate();
                                    }
                                    zValidateGroup = true;
                                    zValidateGroup2 = true;
                                }
                                if (i8 != 2 && (!zValidateGroup || !zValidateGroup2)) {
                                    decimalQuantity_DualStorageBCD = null;
                                }
                                if (decimalQuantity_DualStorageBCD == null) {
                                    if (!z7 || stringSegment.length() == 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    stringSegment.setOffset(offset);
                                    return z2;
                                }
                                decimalQuantity_DualStorageBCD.adjustMagnitude(-i6);
                                if (i != 0 || stringSegment.getOffset() == offset) {
                                    z = false;
                                    parsedNumber.quantity = decimalQuantity_DualStorageBCD;
                                } else {
                                    if (decimalQuantity_DualStorageBCD.fitsInLong()) {
                                        z = false;
                                        long j = decimalQuantity_DualStorageBCD.toLong(false);
                                        if (j <= 2147483647L) {
                                            try {
                                                parsedNumber.quantity.adjustMagnitude(((int) j) * i);
                                            } catch (ArithmeticException unused) {
                                                if (i == -1) {
                                                    parsedNumber.quantity.clear();
                                                } else {
                                                    parsedNumber.quantity = null;
                                                    parsedNumber.flags |= 128;
                                                }
                                            }
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (i == -1) {
                                        parsedNumber.quantity.clear();
                                    } else {
                                        parsedNumber.quantity = null;
                                        parsedNumber.flags |= 128;
                                    }
                                }
                                if (string != null) {
                                    parsedNumber.flags |= 32;
                                }
                                parsedNumber.setCharsConsumed(stringSegment);
                                if (stringSegment.length() != 0 || z7) {
                                    return true;
                                }
                                return z;
                            }
                            if (!this.requireGroupingMatch || i7 != 0 || i8 != 1) {
                                i9 = z4 ? -1 : i8;
                                int offset2 = i7 != 0 ? stringSegment.getOffset() : i5;
                                i8 = z6 ? 1 : 2;
                                if (z6) {
                                    stringSegment.adjustOffset(string2.length());
                                } else {
                                    stringSegment.adjustOffset(string.length());
                                }
                                i11 = i5;
                                i10 = i7;
                                decimalQuantity_DualStorageBCD = decimalQuantity_DualStorageBCD2;
                                i7 = 0;
                                i5 = offset2;
                            }
                        }
                        decimalQuantity_DualStorageBCD = decimalQuantity_DualStorageBCD2;
                    } else {
                        z4 = z3;
                    }
                    if (this.groupingDisabled) {
                        z6 = z5;
                    } else {
                        z6 = z5;
                    }
                    if (!z6) {
                        string = UCharacter.toString(codePoint);
                        z4 = true;
                    }
                    if (!this.groupingDisabled) {
                        string2 = UCharacter.toString(codePoint);
                        z6 = true;
                    }
                    if (z4) {
                        zValidateGroup3 = validateGroup(i9, i10, false);
                        boolean zValidateGroup5 = validateGroup(i8, i7, true);
                        if (zValidateGroup3) {
                        }
                        if (z6) {
                            i2 = 2;
                            decimalQuantity_DualStorageBCD = null;
                        } else {
                            i2 = 2;
                            decimalQuantity_DualStorageBCD = null;
                        }
                    } else {
                        zValidateGroup3 = validateGroup(i9, i10, false);
                        boolean zValidateGroup6 = validateGroup(i8, i7, true);
                        if (zValidateGroup3) {
                        }
                        if (z6) {
                            i2 = 2;
                            decimalQuantity_DualStorageBCD = null;
                        } else {
                            i2 = 2;
                            decimalQuantity_DualStorageBCD = null;
                        }
                    }
                    if (i8 == i2) {
                        i3 = i11;
                    } else {
                        i3 = i11;
                    }
                    zValidateGroup = validateGroup(i9, i10, false);
                    zValidateGroup2 = validateGroup(i8, i7, true);
                    if (!this.requireGroupingMatch) {
                        if (!zValidateGroup) {
                            stringSegment.setOffset(i3);
                            i4 = i10 + i7;
                        } else if (zValidateGroup2) {
                            i4 = 0;
                        } else {
                            i4 = 0;
                        }
                        if (i4 != 0) {
                            decimalQuantity_DualStorageBCD.adjustMagnitude(-i4);
                            decimalQuantity_DualStorageBCD.truncate();
                        }
                        zValidateGroup = true;
                        zValidateGroup2 = true;
                    }
                    if (i8 != 2) {
                        decimalQuantity_DualStorageBCD = null;
                    }
                    if (decimalQuantity_DualStorageBCD == null) {
                        if (z7) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        stringSegment.setOffset(offset);
                        return z2;
                    }
                    decimalQuantity_DualStorageBCD.adjustMagnitude(-i6);
                    if (i != 0) {
                        z = false;
                        parsedNumber.quantity = decimalQuantity_DualStorageBCD;
                    } else {
                        z = false;
                        parsedNumber.quantity = decimalQuantity_DualStorageBCD;
                    }
                    if (string != null) {
                        parsedNumber.flags |= 32;
                    }
                    parsedNumber.setCharsConsumed(stringSegment);
                    if (stringSegment.length() != 0) {
                    }
                    return true;
                }
                decimalQuantity_DualStorageBCD = decimalQuantity_DualStorageBCD2 == null ? new DecimalQuantity_DualStorageBCD() : decimalQuantity_DualStorageBCD2;
                decimalQuantity_DualStorageBCD.appendDigit(b, 0, true);
                i7++;
                if (str != null) {
                    i6++;
                }
                string = str;
            }
            i2 = 2;
            if (i8 == i2) {
                i3 = i11;
            } else {
                i3 = i11;
            }
            zValidateGroup = validateGroup(i9, i10, false);
            zValidateGroup2 = validateGroup(i8, i7, true);
            if (!this.requireGroupingMatch) {
                if (!zValidateGroup) {
                    stringSegment.setOffset(i3);
                    i4 = i10 + i7;
                } else if (zValidateGroup2) {
                    i4 = 0;
                } else {
                    i4 = 0;
                }
                if (i4 != 0) {
                    decimalQuantity_DualStorageBCD.adjustMagnitude(-i4);
                    decimalQuantity_DualStorageBCD.truncate();
                }
                zValidateGroup = true;
                zValidateGroup2 = true;
            }
            if (i8 != 2) {
                decimalQuantity_DualStorageBCD = null;
            }
            if (decimalQuantity_DualStorageBCD == null) {
                if (z7) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                stringSegment.setOffset(offset);
                return z2;
            }
            decimalQuantity_DualStorageBCD.adjustMagnitude(-i6);
            if (i != 0) {
                z = false;
                parsedNumber.quantity = decimalQuantity_DualStorageBCD;
            } else {
                z = false;
                parsedNumber.quantity = decimalQuantity_DualStorageBCD;
            }
            if (string != null) {
                parsedNumber.flags |= 32;
            }
            parsedNumber.setCharsConsumed(stringSegment);
            if (stringSegment.length() != 0) {
            }
            return true;
        }
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean smokeTest(StringSegment stringSegment) {
        UnicodeSet unicodeSet;
        if (this.digitStrings == null && (unicodeSet = this.leadSet) != null) {
            return stringSegment.startsWith(unicodeSet);
        }
        if (stringSegment.startsWith(this.separatorSet) || UCharacter.isDigit(stringSegment.getCodePoint())) {
            return true;
        }
        if (this.digitStrings == null) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.digitStrings;
            if (i >= strArr.length) {
                return false;
            }
            if (stringSegment.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public String toString() {
        return "<DecimalMatcher>";
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean match(StringSegment stringSegment, ParsedNumber parsedNumber) {
        return match(stringSegment, parsedNumber, 0);
    }
}
