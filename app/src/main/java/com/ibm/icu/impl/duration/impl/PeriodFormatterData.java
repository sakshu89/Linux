package com.ibm.icu.impl.duration.impl;

import com.ibm.icu.impl.duration.TimeUnit;
import com.ibm.icu.text.BreakIterator;
import defpackage.dk0;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PeriodFormatterData {
    private static final int FORM_DUAL = 2;
    private static final int FORM_HALF_SPELLED = 6;
    private static final int FORM_PAUCAL = 3;
    private static final int FORM_PLURAL = 0;
    private static final int FORM_SINGULAR = 1;
    private static final int FORM_SINGULAR_NO_OMIT = 5;
    private static final int FORM_SINGULAR_SPELLED = 4;
    public static boolean trace = false;
    final DataRecord dr;
    String localeName;

    public PeriodFormatterData(String str, DataRecord dataRecord) {
        this.dr = dataRecord;
        this.localeName = str;
        if (str == null) {
            dk0.n("localename is null");
            throw null;
        }
        if (dataRecord != null) {
            return;
        }
        dk0.n("data record is null");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x009a, code lost:
    
        if (r13 != 2) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int computeForm(com.ibm.icu.impl.duration.TimeUnit r11, int r12, int r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.duration.impl.PeriodFormatterData.computeForm(com.ibm.icu.impl.duration.TimeUnit, int, int, boolean):int");
    }

    public boolean allowZero() {
        return this.dr.allowZero;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0142 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:126:0x0143 A[RETURN] */
    public int appendCount(TimeUnit timeUnit, boolean z, boolean z2, int i, int i2, boolean z3, String str, boolean z4, StringBuffer stringBuffer) {
        String str2;
        String[] strArr;
        String str3;
        DataRecord dataRecord;
        String str4;
        String[] strArr2;
        String str5;
        int i3 = 2;
        int i4 = i2;
        if (i4 == 2 && this.dr.halves == null) {
            i4 = 0;
        }
        if (!z && z2 && (str5 = this.dr.digitPrefix) != null) {
            stringBuffer.append(str5);
        }
        int iOrdinal = timeUnit.ordinal();
        if (i4 != 0) {
            if (i4 == 1) {
                int i5 = i / 1000;
                if (timeUnit == TimeUnit.MINUTE && (((str4 = (dataRecord = this.dr).fiveMinutes) != null || dataRecord.fifteenMinutes != null) && i5 != 0 && i5 % 5 == 0)) {
                    if (dataRecord.fifteenMinutes != null && (i5 == 15 || i5 == 45)) {
                        int i6 = i5 == 15 ? 1 : 3;
                        if (!z) {
                            appendInteger(i6, 1, 10, stringBuffer);
                        }
                        str2 = this.dr.fifteenMinutes;
                        iOrdinal = 8;
                    } else if (str4 != null) {
                        int i7 = i5 / 5;
                        if (!z) {
                            appendInteger(i7, 1, 10, stringBuffer);
                        }
                        str2 = this.dr.fiveMinutes;
                        iOrdinal = 9;
                    }
                    if (!z && z3) {
                        stringBuffer.append(this.dr.countSep);
                    }
                    if (!z && (strArr = this.dr.measures) != null && iOrdinal < strArr.length && (str3 = strArr[iOrdinal]) != null) {
                        stringBuffer.append(str3);
                    }
                    stringBuffer.append(str2);
                    if (z4) {
                        return iOrdinal;
                    }
                    return -1;
                }
                if (!z) {
                    appendInteger(i5, 1, 10, stringBuffer);
                }
            } else if (i4 != 2) {
                if (i4 != 4) {
                    i3 = i4 != 5 ? 1 : 3;
                }
                if (!z) {
                    appendCountValue(i, 1, i3, stringBuffer);
                }
            } else {
                int i8 = i / BreakIterator.WORD_IDEO_LIMIT;
                if (i8 != 1 && !z) {
                    appendCountValue(i, 1, 0, stringBuffer);
                }
                if ((i8 & 1) == 1) {
                    if (i8 != 1 || (strArr2 = this.dr.halfNames) == null || strArr2[iOrdinal] == null) {
                        int i9 = i8 == 1 ? 0 : 1;
                        DataRecord dataRecord2 = this.dr;
                        byte[] bArr = dataRecord2.genders;
                        if (bArr != null && dataRecord2.halves.length > 2 && bArr[iOrdinal] == 1) {
                            i9 += 2;
                        }
                        byte[] bArr2 = dataRecord2.halfPlacements;
                        byte b = bArr2 != null ? bArr2[i9 & 1] : (byte) 0;
                        String str6 = dataRecord2.halves[i9];
                        String[] strArr3 = dataRecord2.measures;
                        String str7 = strArr3 == null ? null : strArr3[iOrdinal];
                        if (b == 0) {
                            stringBuffer.append(str6);
                        } else if (b != 1) {
                            if (b == 2) {
                                if (str7 != null) {
                                    stringBuffer.append(str7);
                                }
                                if (z3 && !z) {
                                    stringBuffer.append(this.dr.countSep);
                                }
                                stringBuffer.append(str);
                                stringBuffer.append(str6);
                                if (!z4) {
                                    return -1;
                                }
                            }
                        } else {
                            if (str7 != null) {
                                stringBuffer.append(str7);
                                stringBuffer.append(str6);
                                if (z3 && !z) {
                                    stringBuffer.append(this.dr.countSep);
                                }
                                stringBuffer.append(str);
                                return -1;
                            }
                            stringBuffer.append(str);
                            stringBuffer.append(str6);
                            if (!z4) {
                                return -1;
                            }
                        }
                    } else {
                        stringBuffer.append(str);
                        if (!z4) {
                            return -1;
                        }
                    }
                    return iOrdinal;
                }
            }
        } else if (!z) {
            appendInteger(i / 1000, 1, 10, stringBuffer);
        }
        str2 = str;
        if (!z) {
            stringBuffer.append(this.dr.countSep);
        }
        if (!z) {
            stringBuffer.append(str3);
        }
        stringBuffer.append(str2);
        if (z4) {
            return iOrdinal;
        }
        return -1;
    }

    public void appendCountValue(int i, int i2, int i3, StringBuffer stringBuffer) {
        int i4 = i / 1000;
        if (i3 == 0) {
            appendInteger(i4, i2, 10, stringBuffer);
            return;
        }
        if (this.dr.requiresDigitSeparator && stringBuffer.length() > 0) {
            stringBuffer.append(' ');
        }
        appendDigits(i4, i2, 10, stringBuffer);
        int i5 = i % 1000;
        if (i3 == 1) {
            i5 /= 100;
        } else if (i3 == 2) {
            i5 /= 10;
        }
        stringBuffer.append(this.dr.decimalSep);
        appendDigits(i5, i3, i3, stringBuffer);
        if (this.dr.requiresDigitSeparator) {
            stringBuffer.append(' ');
        }
    }

    public void appendDigits(long j, int i, int i2, StringBuffer stringBuffer) {
        char[] cArr = new char[i2];
        int i3 = i2;
        while (i3 > 0 && j > 0) {
            i3--;
            cArr[i3] = (char) ((j % 10) + ((long) this.dr.zero));
            j /= 10;
        }
        int i4 = i2 - i;
        while (i3 > i4) {
            i3--;
            cArr[i3] = this.dr.zero;
        }
        stringBuffer.append(cArr, i3, i2 - i3);
    }

    public void appendInteger(int i, int i2, int i3, StringBuffer stringBuffer) {
        PeriodFormatterData periodFormatterData;
        StringBuffer stringBuffer2;
        String str;
        DataRecord dataRecord = this.dr;
        String[] strArr = dataRecord.numberNames;
        if (strArr != null && i < strArr.length && (str = strArr[i]) != null) {
            stringBuffer.append(str);
            return;
        }
        if (dataRecord.requiresDigitSeparator && stringBuffer.length() > 0) {
            stringBuffer.append(' ');
        }
        byte b = this.dr.numberSystem;
        if (b != 0) {
            if (b == 1) {
                stringBuffer.append(Utils.chineseNumber(i, Utils.ChineseDigits.TRADITIONAL));
            } else if (b == 2) {
                stringBuffer.append(Utils.chineseNumber(i, Utils.ChineseDigits.SIMPLIFIED));
            } else if (b == 3) {
                stringBuffer.append(Utils.chineseNumber(i, Utils.ChineseDigits.KOREAN));
            }
            periodFormatterData = this;
            stringBuffer2 = stringBuffer;
        } else {
            periodFormatterData = this;
            stringBuffer2 = stringBuffer;
            periodFormatterData.appendDigits(i, i2, i3, stringBuffer2);
        }
        if (periodFormatterData.dr.requiresDigitSeparator) {
            stringBuffer2.append(' ');
        }
    }

    public boolean appendPrefix(int i, int i2, StringBuffer stringBuffer) {
        DataRecord.ScopeData scopeData;
        String str;
        DataRecord.ScopeData[] scopeDataArr = this.dr.scopeData;
        if (scopeDataArr == null || (scopeData = scopeDataArr[(i * 3) + i2]) == null || (str = scopeData.prefix) == null) {
            return false;
        }
        stringBuffer.append(str);
        return scopeData.requiresDigitPrefix;
    }

    public void appendSkippedUnit(StringBuffer stringBuffer) {
        String str = this.dr.skippedUnitMarker;
        if (str != null) {
            stringBuffer.append(str);
        }
    }

    public void appendSuffix(int i, int i2, StringBuffer stringBuffer) {
        DataRecord.ScopeData scopeData;
        String str;
        DataRecord.ScopeData[] scopeDataArr = this.dr.scopeData;
        if (scopeDataArr == null || (scopeData = scopeDataArr[(i * 3) + i2]) == null || (str = scopeData.suffix) == null) {
            return;
        }
        if (trace) {
            System.out.println("appendSuffix '" + str + "'");
        }
        stringBuffer.append(str);
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x0108  */
    /* JADX WARN: Code duplicated, block: B:95:0x0116  */
    public boolean appendUnit(TimeUnit timeUnit, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, StringBuffer stringBuffer) {
        boolean z6;
        String str;
        int i4;
        String str2;
        boolean z7;
        int iAppendCount;
        String[] strArr;
        String str3;
        String[] strArr2;
        byte[] bArr;
        byte b;
        String str4;
        String str5;
        int iOrdinal = timeUnit.ordinal();
        DataRecord dataRecord = this.dr;
        boolean[] zArr = dataRecord.requiresSkipMarker;
        if (zArr == null || !zArr[iOrdinal] || (str5 = dataRecord.skippedUnitMarker) == null) {
            z6 = false;
        } else {
            if (!z5 && z4) {
                stringBuffer.append(str5);
            }
            z6 = true;
        }
        if (i3 != 0) {
            boolean z8 = i3 == 1;
            DataRecord dataRecord2 = this.dr;
            String[] strArr3 = z8 ? dataRecord2.mediumNames : dataRecord2.shortNames;
            if (strArr3 == null || strArr3[iOrdinal] == null) {
                DataRecord dataRecord3 = this.dr;
                strArr3 = z8 ? dataRecord3.shortNames : dataRecord3.mediumNames;
            }
            if (strArr3 != null && (str4 = strArr3[iOrdinal]) != null) {
                appendCount(timeUnit, false, false, i, i2, z, str4, z4, stringBuffer);
                return false;
            }
        }
        int i5 = i;
        int i6 = i2;
        if (i6 == 2 && (bArr = this.dr.halfSupport) != null && ((b = bArr[iOrdinal]) == 1 || (b == 2 && i5 <= 1000))) {
            i6 = 3;
            i5 = (i5 / BreakIterator.WORD_IDEO_LIMIT) * BreakIterator.WORD_IDEO_LIMIT;
        }
        int iComputeForm = computeForm(timeUnit, i5, i6, z3 && z4);
        if (iComputeForm == 4) {
            DataRecord dataRecord4 = this.dr;
            String[] strArr4 = dataRecord4.singularNames;
            if (strArr4 == null) {
                str2 = dataRecord4.pluralNames[iOrdinal][1];
                i4 = 1;
            } else {
                str = strArr4[iOrdinal];
            }
            if (str2 == null) {
                str2 = this.dr.pluralNames[iOrdinal][0];
                i4 = 0;
            }
            if (i4 != 4 || i4 == 6) {
                z7 = true;
            } else {
                DataRecord dataRecord5 = this.dr;
                if ((dataRecord5.omitSingularCount && i4 == 1) || (dataRecord5.omitDualCount && i4 == 2)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            iAppendCount = appendCount(timeUnit, z7, z2, i5, i6, z, str2, z4, stringBuffer);
            if (z4 && iAppendCount >= 0) {
                DataRecord dataRecord6 = this.dr;
                strArr = dataRecord6.rqdSuffixes;
                if (strArr != null || iAppendCount >= strArr.length) {
                    str3 = null;
                } else {
                    str3 = strArr[iAppendCount];
                }
                if (str3 == null && (strArr2 = dataRecord6.optSuffixes) != null && iAppendCount < strArr2.length) {
                    str3 = strArr2[iAppendCount];
                }
                if (str3 != null) {
                    stringBuffer.append(str3);
                }
            }
            return z6;
        }
        if (iComputeForm == 5) {
            str = this.dr.pluralNames[iOrdinal][1];
        } else {
            DataRecord dataRecord7 = this.dr;
            if (iComputeForm == 6) {
                str = dataRecord7.halfNames[iOrdinal];
            } else {
                try {
                    str = dataRecord7.pluralNames[iOrdinal][iComputeForm];
                } catch (NullPointerException e) {
                    System.out.println("Null Pointer in PeriodFormatterData[" + this.localeName + "].au px: " + iOrdinal + " form: " + iComputeForm + " pn: " + Arrays.toString(this.dr.pluralNames));
                    throw e;
                }
            }
        }
        String str6 = str;
        i4 = iComputeForm;
        str2 = str6;
        if (str2 == null) {
            str2 = this.dr.pluralNames[iOrdinal][0];
            i4 = 0;
        }
        if (i4 != 4) {
            z7 = true;
        } else {
            z7 = true;
        }
        iAppendCount = appendCount(timeUnit, z7, z2, i5, i6, z, str2, z4, stringBuffer);
        if (z4) {
            DataRecord dataRecord8 = this.dr;
            strArr = dataRecord8.rqdSuffixes;
            if (strArr != null) {
                str3 = null;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = strArr2[iAppendCount];
            }
            if (str3 != null) {
                stringBuffer.append(str3);
            }
        }
        return z6;
    }

    public boolean appendUnitSeparator(TimeUnit timeUnit, boolean z, boolean z2, boolean z3, StringBuffer stringBuffer) {
        String[] strArr;
        if ((z && this.dr.unitSep != null) || this.dr.shortUnitSep != null) {
            if (z && (strArr = this.dr.unitSep) != null) {
                int i = (z2 ? 2 : 0) + (z3 ? 1 : 0);
                stringBuffer.append(strArr[i]);
                boolean[] zArr = this.dr.unitSepRequiresDP;
                return zArr != null && zArr[i];
            }
            stringBuffer.append(this.dr.shortUnitSep);
        }
        return false;
    }

    public int pluralization() {
        return this.dr.pl;
    }

    public int useMilliseconds() {
        return this.dr.useMilliseconds;
    }

    public boolean weeksAloneOnly() {
        return this.dr.weeksAloneOnly;
    }
}
