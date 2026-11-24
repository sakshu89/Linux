package com.ibm.icu.text;

import com.ibm.icu.impl.FormattedValueFieldPositionIteratorImpl;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.JavaTimeConverters;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.DateInterval;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.kf2;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class DateIntervalFormat extends UFormat implements Cloneable {
    private static ICUCache<String, Map<String, DateIntervalInfo.PatternInfo>> LOCAL_PATTERN_CACHE = new SimpleCache();
    private static final long serialVersionUID = 1;
    private DisplayContext fCapitalizationSetting;
    private SimpleDateFormat fDateFormat;
    private String fDatePattern;
    private String fDateTimeFormat;
    private Calendar fFromCalendar;
    private DateIntervalInfo fInfo;
    private transient Map<String, DateIntervalInfo.PatternInfo> fIntervalPatterns;
    private String fSkeleton;
    private String fTimePattern;
    private Calendar fToCalendar;
    private boolean isDateIntervalInfoDefault;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class BestMatchInfo {
        final int bestMatchDistanceInfo;
        final String bestMatchSkeleton;

        public BestMatchInfo(String str, int i) {
            this.bestMatchSkeleton = str;
            this.bestMatchDistanceInfo = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class FormattedDateInterval implements FormattedValue {
        private final List<FieldPosition> attributes;
        private final String string;

        public FormattedDateInterval(CharSequence charSequence, List<FieldPosition> list) {
            this.string = charSequence.toString();
            this.attributes = Collections.unmodifiableList(list);
        }

        @Override // com.ibm.icu.text.FormattedValue
        public <A extends Appendable> A appendTo(A a) {
            return (A) Utility.appendTo(this.string, a);
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return this.string.charAt(i);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.string.length();
        }

        @Override // com.ibm.icu.text.FormattedValue
        public boolean nextPosition(ConstrainedFieldPosition constrainedFieldPosition) {
            return FormattedValueFieldPositionIteratorImpl.nextPosition(this.attributes, constrainedFieldPosition);
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return this.string.subSequence(i, i2);
        }

        @Override // com.ibm.icu.text.FormattedValue
        public AttributedCharacterIterator toCharacterIterator() {
            return FormattedValueFieldPositionIteratorImpl.toCharacterIterator(this.string, this.attributes);
        }

        @Override // com.ibm.icu.text.FormattedValue, java.lang.CharSequence
        public String toString() {
            return this.string;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SkeletonAndItsBestMatch {
        final String bestMatchSkeleton;
        final String skeleton;

        public SkeletonAndItsBestMatch(String str, String str2) {
            this.skeleton = str;
            this.bestMatchSkeleton = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SpanField extends UFormat.SpanField {
        public static final SpanField DATE_INTERVAL_SPAN = new SpanField("date-interval-span");
        private static final long serialVersionUID = -6330879259553618133L;

        private SpanField(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        @Deprecated
        public Object readResolve() throws InvalidObjectException {
            String name = getName();
            SpanField spanField = DATE_INTERVAL_SPAN;
            if (name.equals(spanField.getName())) {
                return spanField;
            }
            kf2.i("An invalid object.");
            return null;
        }
    }

    private DateIntervalFormat(String str, ULocale uLocale, SimpleDateFormat simpleDateFormat) {
        this.fSkeleton = null;
        this.fIntervalPatterns = null;
        this.fDatePattern = null;
        this.fTimePattern = null;
        this.fDateTimeFormat = null;
        this.fCapitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
        this.fDateFormat = simpleDateFormat;
        this.fSkeleton = str;
        this.fInfo = new DateIntervalInfo(uLocale).freeze();
        this.isDateIntervalInfoDefault = true;
        this.fFromCalendar = this.fDateFormat.getCalendar().mo22clone();
        this.fToCalendar = this.fDateFormat.getCalendar().mo22clone();
        initializePattern(LOCAL_PATTERN_CACHE);
    }

    private static String adjustFieldWidth(String str, String str2, String str3, int i, boolean z) {
        if (str3 == null) {
            return null;
        }
        int[] iArr = new int[58];
        int[] iArr2 = new int[58];
        DateIntervalInfo.parseSkeleton(str, iArr);
        DateIntervalInfo.parseSkeleton(str2, iArr2);
        if (z) {
            if (str3.indexOf(" a") != -1) {
                str3 = findReplaceInPattern(str3, " a", "");
            } else if (str3.indexOf(" a") != -1) {
                str3 = findReplaceInPattern(str3, " a", "");
            } else if (str3.indexOf(" a") != -1) {
                str3 = findReplaceInPattern(str3, " a", "");
            } else if (str3.indexOf("a ") != -1) {
                str3 = findReplaceInPattern(str3, "a ", "");
            } else if (str3.indexOf("a ") != -1) {
                str3 = findReplaceInPattern(str3, "a ", "");
            } else if (str3.indexOf("a ") != -1) {
                str3 = findReplaceInPattern(str3, "a ", "");
            }
            str3 = findReplaceInPattern(str3, "a", "");
        }
        if (i == 2) {
            if (str.indexOf(122) != -1) {
                str3 = findReplaceInPattern(str3, DateFormat.ABBR_GENERIC_TZ, DateFormat.ABBR_SPECIFIC_TZ);
            }
            if (str.indexOf(75) != -1) {
                str3 = findReplaceInPattern(str3, "h", "K");
            }
            if (str.indexOf(107) != -1) {
                str3 = findReplaceInPattern(str3, DateFormat.HOUR24, "k");
            }
            if (str.indexOf(98) != -1) {
                str3 = findReplaceInPattern(str3, "a", "b");
            }
        }
        if (str3.indexOf(97) != -1 && iArr2[32] == 0) {
            iArr2[32] = 1;
        }
        if (str3.indexOf(98) != -1 && iArr2[33] == 0) {
            iArr2[33] = 1;
        }
        StringBuilder sb = new StringBuilder(str3);
        int length = sb.length();
        int i2 = 0;
        int i3 = 0;
        char c = 0;
        boolean z2 = false;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char cCharAt = sb.charAt(i2);
            if (cCharAt != c && i3 > 0) {
                int i4 = (c != 'L' ? c : 'M') - 'A';
                int i5 = iArr2[i4];
                int i6 = iArr[i4];
                if (i5 == i3 && i6 > i5) {
                    int i7 = i6 - i5;
                    for (int i8 = 0; i8 < i7; i8++) {
                        sb.insert(i2, c);
                    }
                    i2 += i7;
                    length += i7;
                }
                i3 = 0;
            }
            if (cCharAt == '\'') {
                int i9 = i2 + 1;
                if (i9 >= sb.length() || sb.charAt(i9) != '\'') {
                    z2 = !z2;
                } else {
                    i2 = i9;
                }
            } else if (!z2 && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                i3++;
                c = cCharAt;
            }
            i2++;
        }
        if (i3 > 0) {
            int i10 = (c != 'L' ? c : 'M') - 'A';
            int i11 = iArr2[i10];
            int i12 = iArr[i10];
            if (i11 == i3 && i12 > i11) {
                int i13 = i12 - i11;
                for (int i14 = 0; i14 < i13; i14++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    private void concatSingleDate2TimeInterval(String str, String str2, int i, Map<String, DateIntervalInfo.PatternInfo> map) {
        String[] strArr = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER;
        DateIntervalInfo.PatternInfo patternInfo = map.get(strArr[i]);
        if (patternInfo != null) {
            map.put(strArr[i], DateIntervalInfo.genPatternInfo(SimpleFormatterImpl.formatRawPattern(str, 2, 2, ky0.j(patternInfo.getFirstPart(), patternInfo.getSecondPart()), str2), patternInfo.firstDateInPtnIsLaterDate()));
        }
    }

    private final StringBuffer fallbackFormat(Calendar calendar, Calendar calendar2, boolean z, StringBuffer stringBuffer, FieldPosition fieldPosition, FormatOutput formatOutput, List<FieldPosition> list) {
        StringBuilder sb = new StringBuilder();
        if (!z || this.fDatePattern == null || this.fTimePattern == null) {
            fallbackFormatRange(calendar, calendar2, stringBuffer, sb, fieldPosition, formatOutput, list);
            return stringBuffer;
        }
        String strCompileToStringMinMaxArguments = SimpleFormatterImpl.compileToStringMinMaxArguments(this.fDateTimeFormat, sb, 2, 2);
        String pattern = this.fDateFormat.toPattern();
        long jStep = 0;
        while (true) {
            jStep = SimpleFormatterImpl.IterInternal.step(jStep, strCompileToStringMinMaxArguments, stringBuffer);
            if (jStep == -1) {
                this.fDateFormat.applyPattern(pattern);
                return stringBuffer;
            }
            int argIndex = SimpleFormatterImpl.IterInternal.getArgIndex(jStep);
            SimpleDateFormat simpleDateFormat = this.fDateFormat;
            if (argIndex == 0) {
                simpleDateFormat.applyPattern(this.fTimePattern);
                fallbackFormatRange(calendar, calendar2, stringBuffer, sb, fieldPosition, formatOutput, list);
            } else {
                simpleDateFormat.applyPattern(this.fDatePattern);
                this.fDateFormat.format(calendar, stringBuffer, fieldPosition, list);
            }
            if (fieldPosition.getEndIndex() > 0) {
                fieldPosition = new FieldPosition(0);
            }
            this.fDateFormat.setContext(DisplayContext.CAPITALIZATION_NONE);
        }
    }

    private final void fallbackFormatRange(Calendar calendar, Calendar calendar2, StringBuffer stringBuffer, StringBuilder sb, FieldPosition fieldPosition, FormatOutput formatOutput, List<FieldPosition> list) {
        String strCompileToStringMinMaxArguments = SimpleFormatterImpl.compileToStringMinMaxArguments(this.fInfo.getFallbackIntervalPattern(), sb, 2, 2);
        long jStep = 0;
        while (true) {
            jStep = SimpleFormatterImpl.IterInternal.step(jStep, strCompileToStringMinMaxArguments, stringBuffer);
            if (jStep == -1) {
                return;
            }
            if (SimpleFormatterImpl.IterInternal.getArgIndex(jStep) == 0) {
                if (formatOutput != null) {
                    formatOutput.register(0);
                }
                this.fDateFormat.format(calendar, stringBuffer, fieldPosition, list);
            } else {
                if (formatOutput != null) {
                    formatOutput.register(1);
                }
                this.fDateFormat.format(calendar2, stringBuffer, fieldPosition, list);
            }
            if (fieldPosition.getEndIndex() > 0) {
                fieldPosition = new FieldPosition(0);
            }
            this.fDateFormat.setContext(DisplayContext.CAPITALIZATION_NONE);
        }
    }

    private static boolean fieldExistsInSkeleton(int i, String str) {
        String str2 = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[i];
        boolean zContains = str.contains(str2);
        if (!zContains) {
            if (str2.equals(DateFormat.NUM_MONTH)) {
                return str.contains("L");
            }
            if (str2.equals(DateFormat.YEAR)) {
                return str.contains("U") || str.contains("Y") || str.contains("u") || str.contains("r");
            }
        }
        return zContains;
    }

    private static String findReplaceInPattern(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("'");
        if (iIndexOf < 0) {
            return str.replace(str2, str3);
        }
        StringBuilder sb = new StringBuilder();
        while (iIndexOf >= 0) {
            int iIndexOf2 = str.indexOf("'", iIndexOf + 1);
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.length() - 1;
            }
            String strSubstring = str.substring(0, iIndexOf);
            int i = iIndexOf2 + 1;
            String strSubstring2 = str.substring(iIndexOf, i);
            sb.append(strSubstring.replace(str2, str3));
            sb.append(strSubstring2);
            str = str.substring(i);
            iIndexOf = str.indexOf("'");
        }
        sb.append(str.replace(str2, str3));
        return sb.toString();
    }

    private synchronized StringBuffer formatImpl(Calendar calendar, Calendar calendar2, StringBuffer stringBuffer, FieldPosition fieldPosition, FormatOutput formatOutput, List<FieldPosition> list) throws Throwable {
        int i;
        Calendar calendar3;
        try {
            if (!calendar.isEquivalentTo(calendar2)) {
                throw new IllegalArgumentException("can not format on two different calendars");
            }
            this.fDateFormat.setContext(this.fCapitalizationSetting);
            if (calendar.get(0) != calendar2.get(0)) {
                i = 0;
            } else if (calendar.get(1) != calendar2.get(1)) {
                i = 1;
            } else {
                i = 2;
                if (calendar.get(2) == calendar2.get(2)) {
                    i = 5;
                    if (calendar.get(5) == calendar2.get(5)) {
                        if (calendar.get(9) != calendar2.get(9)) {
                            i = 9;
                        } else if (calendar.get(10) != calendar2.get(10)) {
                            i = 10;
                        } else if (calendar.get(12) != calendar2.get(12)) {
                            i = 12;
                        } else if (calendar.get(13) != calendar2.get(13)) {
                            i = 13;
                        } else {
                            if (calendar.get(14) == calendar2.get(14)) {
                                return this.fDateFormat.format(calendar, stringBuffer, fieldPosition, list);
                            }
                            i = 14;
                        }
                    }
                }
            }
            boolean z = i == 9 || i == 10 || i == 12 || i == 13 || i == 14;
            DateIntervalInfo.PatternInfo patternInfo = this.fIntervalPatterns.get(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[i]);
            try {
                if (patternInfo == null) {
                    if (this.fDateFormat.isFieldUnitIgnored(i)) {
                        return this.fDateFormat.format(calendar, stringBuffer, fieldPosition, list);
                    }
                    return fallbackFormat(calendar, calendar2, z, stringBuffer, fieldPosition, formatOutput, list);
                }
                boolean z2 = z;
                if (patternInfo.getFirstPart() == null) {
                    return fallbackFormat(calendar, calendar2, z2, stringBuffer, fieldPosition, formatOutput, list, patternInfo.getSecondPart());
                }
                Calendar calendar4 = calendar;
                if (patternInfo.firstDateInPtnIsLaterDate()) {
                    if (formatOutput != null) {
                        formatOutput.register(1);
                    }
                    calendar3 = calendar4;
                    calendar4 = calendar2;
                } else {
                    if (formatOutput != null) {
                        formatOutput.register(0);
                    }
                    calendar3 = calendar2;
                }
                String pattern = this.fDateFormat.toPattern();
                this.fDateFormat.applyPattern(patternInfo.getFirstPart());
                this.fDateFormat.format(calendar4, stringBuffer, fieldPosition, list);
                FieldPosition fieldPosition2 = fieldPosition.getEndIndex() > 0 ? new FieldPosition(0) : fieldPosition;
                if (patternInfo.getSecondPart() != null) {
                    this.fDateFormat.applyPattern(patternInfo.getSecondPart());
                    this.fDateFormat.setContext(DisplayContext.CAPITALIZATION_NONE);
                    this.fDateFormat.format(calendar3, stringBuffer, fieldPosition2, list);
                }
                this.fDateFormat.applyPattern(pattern);
                return stringBuffer;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private synchronized StringBuffer formatIntervalImpl(DateInterval dateInterval, StringBuffer stringBuffer, FieldPosition fieldPosition, FormatOutput formatOutput, List<FieldPosition> list) throws Throwable {
        try {
            try {
                this.fFromCalendar.setTimeInMillis(dateInterval.getFromDate());
                this.fToCalendar.setTimeInMillis(dateInterval.getToDate());
                return formatImpl(this.fFromCalendar, this.fToCalendar, stringBuffer, fieldPosition, formatOutput, list);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private void genFallbackPattern(int i, String str, Map<String, DateIntervalInfo.PatternInfo> map, DateTimePatternGenerator dateTimePatternGenerator) {
        map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[i], new DateIntervalInfo.PatternInfo(null, dateTimePatternGenerator.getBestPattern(str), this.fInfo.getDefaultOrder()));
    }

    private SkeletonAndItsBestMatch genIntervalPattern(int i, String str, String str2, int i2, Map<String, DateIntervalInfo.PatternInfo> map) {
        boolean z;
        DateIntervalInfo.PatternInfo intervalPattern = this.fInfo.getIntervalPattern(str2, i);
        SkeletonAndItsBestMatch skeletonAndItsBestMatch = null;
        if (intervalPattern == null) {
            if (SimpleDateFormat.isFieldUnitIgnored(str2, i)) {
                map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[i], new DateIntervalInfo.PatternInfo(this.fDateFormat.toPattern(), null, this.fInfo.getDefaultOrder()));
                return null;
            }
            if (i == 9) {
                DateIntervalInfo.PatternInfo intervalPattern2 = this.fInfo.getIntervalPattern(str2, 10);
                if (intervalPattern2 != null) {
                    z = this.fSkeleton.indexOf(74) != -1;
                    map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[i], new DateIntervalInfo.PatternInfo(adjustFieldWidth(str, str2, intervalPattern2.getFirstPart(), i2, z), adjustFieldWidth(str, str2, intervalPattern2.getSecondPart(), i2, z), intervalPattern2.firstDateInPtnIsLaterDate()));
                }
                return null;
            }
            String str3 = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[i];
            str2 = ky0.j(str3, str2);
            str = ky0.j(str3, str);
            intervalPattern = this.fInfo.getIntervalPattern(str2, i);
            if (intervalPattern == null && i2 == 0) {
                BestMatchInfo bestSkeleton = this.fInfo.getBestSkeleton(str);
                String str4 = bestSkeleton.bestMatchSkeleton;
                i2 = bestSkeleton.bestMatchDistanceInfo;
                if (str4.length() != 0 && i2 != -1) {
                    intervalPattern = this.fInfo.getIntervalPattern(str4, i);
                    str2 = str4;
                }
            }
            if (intervalPattern != null) {
                skeletonAndItsBestMatch = new SkeletonAndItsBestMatch(str, str2);
            }
        }
        if (intervalPattern != null) {
            if (i2 != 0) {
                z = this.fSkeleton.indexOf(74) != -1;
                intervalPattern = new DateIntervalInfo.PatternInfo(adjustFieldWidth(str, str2, intervalPattern.getFirstPart(), i2, z), adjustFieldWidth(str, str2, intervalPattern.getSecondPart(), i2, z), intervalPattern.firstDateInPtnIsLaterDate());
            }
            map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[i], intervalPattern);
        }
        return skeletonAndItsBestMatch;
    }

    private boolean genSeparateDateTimePtn(String str, String str2, Map<String, DateIntervalInfo.PatternInfo> map, DateTimePatternGenerator dateTimePatternGenerator) {
        String str3 = str2.length() != 0 ? str2 : str;
        BestMatchInfo bestSkeleton = this.fInfo.getBestSkeleton(str3);
        String str4 = bestSkeleton.bestMatchSkeleton;
        int i = bestSkeleton.bestMatchDistanceInfo;
        if (str.length() != 0) {
            this.fDatePattern = dateTimePatternGenerator.getBestPattern(str);
        }
        if (str2.length() != 0) {
            this.fTimePattern = dateTimePatternGenerator.getBestPattern(str2);
        }
        if (i == -1) {
            return false;
        }
        if (str2.length() != 0) {
            genIntervalPattern(12, str3, str4, i, map);
            genIntervalPattern(10, str3, str4, i, map);
            genIntervalPattern(9, str3, str4, i, map);
            return true;
        }
        genIntervalPattern(5, str3, str4, i, map);
        SkeletonAndItsBestMatch skeletonAndItsBestMatchGenIntervalPattern = genIntervalPattern(2, str3, str4, i, map);
        if (skeletonAndItsBestMatchGenIntervalPattern != null) {
            str4 = skeletonAndItsBestMatchGenIntervalPattern.skeleton;
            str3 = skeletonAndItsBestMatchGenIntervalPattern.bestMatchSkeleton;
        }
        String str5 = str3;
        String str6 = str4;
        genIntervalPattern(1, str5, str6, i, map);
        genIntervalPattern(0, str5, str6, i, map);
        return true;
    }

    private String getConcatenationPattern(ULocale uLocale) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale)).getWithFallback("calendar/gregorian/DateTimePatterns").get(8);
        return iCUResourceBundle.getType() == 0 ? iCUResourceBundle.getString() : iCUResourceBundle.getString(0);
    }

    private static void getDateTimeSkeleton(String str, StringBuilder sb, StringBuilder sb2, StringBuilder sb3, StringBuilder sb4) {
        int i = 0;
        int i2 = 0;
        char c = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            switch (cCharAt) {
                case 'A':
                case 'B':
                case 'S':
                case 'V':
                case 'Z':
                case 'a':
                case 'b':
                case 'j':
                case 's':
                    sb3.append(cCharAt);
                    sb4.append(cCharAt);
                    break;
                case 'D':
                case 'F':
                case 'G':
                case 'L':
                case 'Q':
                case 'U':
                case 'W':
                case 'Y':
                case 'c':
                case 'e':
                case 'g':
                case 'l':
                case 'q':
                case 'r':
                case 'u':
                case 'w':
                    sb2.append(cCharAt);
                    sb.append(cCharAt);
                    break;
                case 'E':
                    sb.append(cCharAt);
                    i2++;
                    break;
                case 'H':
                case 'K':
                case 'h':
                case 'k':
                    sb3.append(cCharAt);
                    if (c == 0) {
                        c = cCharAt;
                    }
                    break;
                case 'M':
                    sb.append(cCharAt);
                    i3++;
                    break;
                case 'd':
                    sb.append(cCharAt);
                    i4++;
                    break;
                case 'm':
                    sb3.append(cCharAt);
                    i5++;
                    break;
                case 'v':
                    i6++;
                    sb3.append(cCharAt);
                    break;
                case 'y':
                    sb.append(cCharAt);
                    i++;
                    break;
                case 'z':
                    i7++;
                    sb3.append(cCharAt);
                    break;
            }
        }
        if (i != 0) {
            for (int i9 = 0; i9 < i; i9++) {
                sb2.append('y');
            }
        }
        if (i3 != 0) {
            if (i3 < 3) {
                sb2.append('M');
            } else {
                for (int i10 = 0; i10 < i3 && i10 < 5; i10++) {
                    sb2.append('M');
                }
            }
        }
        if (i2 != 0) {
            if (i2 <= 3) {
                sb2.append('E');
            } else {
                for (int i11 = 0; i11 < i2 && i11 < 5; i11++) {
                    sb2.append('E');
                }
            }
        }
        if (i4 != 0) {
            sb2.append('d');
        }
        if (c != 0) {
            sb4.append(c);
        }
        if (i5 != 0) {
            sb4.append('m');
        }
        if (i7 != 0) {
            sb4.append('z');
        }
        if (i6 != 0) {
            sb4.append('v');
        }
    }

    public static final DateIntervalFormat getInstance(String str, ULocale uLocale, DateIntervalInfo dateIntervalInfo) {
        return new DateIntervalFormat(str, dateIntervalInfo.m15clone(), new SimpleDateFormat(DateTimePatternGenerator.getInstance(uLocale).getBestPattern(str), uLocale));
    }

    private Map<String, DateIntervalInfo.PatternInfo> initializeIntervalPattern(String str, ULocale uLocale) {
        DateTimePatternGenerator dateTimePatternGenerator = DateTimePatternGenerator.getInstance(uLocale);
        if (this.fSkeleton == null) {
            this.fSkeleton = dateTimePatternGenerator.getSkeleton(str);
        }
        String strNormalizeHourMetacharacters = normalizeHourMetacharacters(this.fSkeleton, uLocale);
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder(strNormalizeHourMetacharacters.length());
        StringBuilder sb2 = new StringBuilder(strNormalizeHourMetacharacters.length());
        StringBuilder sb3 = new StringBuilder(strNormalizeHourMetacharacters.length());
        StringBuilder sb4 = new StringBuilder(strNormalizeHourMetacharacters.length());
        getDateTimeSkeleton(strNormalizeHourMetacharacters, sb, sb2, sb3, sb4);
        String string = sb.toString();
        String string2 = sb3.toString();
        String string3 = sb2.toString();
        String string4 = sb4.toString();
        if (sb3.length() != 0 && sb.length() != 0) {
            this.fDateTimeFormat = getConcatenationPattern(uLocale);
        }
        if (genSeparateDateTimePtn(string3, string4, map, dateTimePatternGenerator)) {
            if (sb3.length() != 0) {
                if (sb.length() == 0) {
                    String strConcat = DateFormat.YEAR_NUM_MONTH_DAY.concat(string2);
                    DateIntervalInfo.PatternInfo patternInfo = new DateIntervalInfo.PatternInfo(null, dateTimePatternGenerator.getBestPattern(strConcat), this.fInfo.getDefaultOrder());
                    String[] strArr = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER;
                    map.put(strArr[5], patternInfo);
                    map.put(strArr[2], patternInfo);
                    map.put(strArr[1], patternInfo);
                    map.put(strArr[0], new DateIntervalInfo.PatternInfo(null, dateTimePatternGenerator.getBestPattern(strConcat.concat("G")), this.fInfo.getDefaultOrder()));
                    return map;
                }
                if (!fieldExistsInSkeleton(5, string)) {
                    strNormalizeHourMetacharacters = ky0.j(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[5], strNormalizeHourMetacharacters);
                    genFallbackPattern(5, strNormalizeHourMetacharacters, map, dateTimePatternGenerator);
                }
                if (!fieldExistsInSkeleton(2, string)) {
                    strNormalizeHourMetacharacters = ky0.j(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[2], strNormalizeHourMetacharacters);
                    genFallbackPattern(2, strNormalizeHourMetacharacters, map, dateTimePatternGenerator);
                }
                if (!fieldExistsInSkeleton(1, string)) {
                    strNormalizeHourMetacharacters = ky0.j(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[1], strNormalizeHourMetacharacters);
                    genFallbackPattern(1, strNormalizeHourMetacharacters, map, dateTimePatternGenerator);
                }
                if (!fieldExistsInSkeleton(0, string)) {
                    genFallbackPattern(0, ky0.j(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[0], strNormalizeHourMetacharacters), map, dateTimePatternGenerator);
                }
                if (this.fDateTimeFormat == null) {
                    this.fDateTimeFormat = "{1} {0}";
                }
                String bestPattern = dateTimePatternGenerator.getBestPattern(string);
                concatSingleDate2TimeInterval(this.fDateTimeFormat, bestPattern, 9, map);
                concatSingleDate2TimeInterval(this.fDateTimeFormat, bestPattern, 10, map);
                concatSingleDate2TimeInterval(this.fDateTimeFormat, bestPattern, 12, map);
                return map;
            }
        } else if (sb3.length() != 0 && sb.length() == 0) {
            String strConcat2 = DateFormat.YEAR_NUM_MONTH_DAY.concat(string2);
            DateIntervalInfo.PatternInfo patternInfo2 = new DateIntervalInfo.PatternInfo(null, dateTimePatternGenerator.getBestPattern(strConcat2), this.fInfo.getDefaultOrder());
            String[] strArr2 = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER;
            map.put(strArr2[5], patternInfo2);
            map.put(strArr2[2], patternInfo2);
            map.put(strArr2[1], patternInfo2);
            map.put(strArr2[0], new DateIntervalInfo.PatternInfo(null, dateTimePatternGenerator.getBestPattern(strConcat2.concat("G")), this.fInfo.getDefaultOrder()));
            return map;
        }
        return map;
    }

    private void initializePattern(ICUCache<String, Map<String, DateIntervalInfo.PatternInfo>> iCUCache) {
        String strK;
        Map<String, DateIntervalInfo.PatternInfo> mapUnmodifiableMap;
        String pattern = this.fDateFormat.toPattern();
        ULocale locale = this.fDateFormat.getLocale();
        if (iCUCache != null) {
            if (this.fSkeleton != null) {
                strK = locale.toString() + "+" + pattern + "+" + this.fSkeleton;
            } else {
                strK = cq.k(locale.toString(), "+", pattern);
            }
            mapUnmodifiableMap = iCUCache.get(strK);
        } else {
            strK = null;
            mapUnmodifiableMap = null;
        }
        if (mapUnmodifiableMap == null) {
            mapUnmodifiableMap = Collections.unmodifiableMap(initializeIntervalPattern(pattern, locale));
            if (iCUCache != null) {
                iCUCache.put(strK, mapUnmodifiableMap);
            }
        }
        this.fIntervalPatterns = mapUnmodifiableMap;
    }

    private String normalizeHourMetacharacters(String str, ULocale uLocale) {
        char c;
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        char c2 = 0;
        int i2 = 0;
        char c3 = 0;
        int i3 = 0;
        int i4 = 0;
        int length = 0;
        while (true) {
            c = 'K';
            if (i >= sb.length()) {
                break;
            }
            char cCharAt = sb.charAt(i);
            if (cCharAt == 'j' || cCharAt == 'J' || cCharAt == 'C' || cCharAt == 'h' || cCharAt == 'H' || cCharAt == 'k' || cCharAt == 'K') {
                if (c2 == 0) {
                    i4 = i;
                    c2 = cCharAt;
                }
                i2++;
            } else if (cCharAt != 'a' && cCharAt != 'b' && cCharAt != 'B') {
                if (c2 != 0 && c3 != 0) {
                    break;
                }
            } else {
                if (c3 == 0) {
                    length = i;
                    c3 = cCharAt;
                }
                i3++;
            }
            i++;
        }
        if (c2 != 0) {
            String bestPattern = DateTimePatternGenerator.getInstance(uLocale).getBestPattern(String.valueOf(c2));
            while (true) {
                int iIndexOf = bestPattern.indexOf(39);
                if (iIndexOf == -1) {
                    break;
                }
                int iIndexOf2 = bestPattern.indexOf(39, iIndexOf + 1);
                if (iIndexOf2 == -1) {
                    iIndexOf2 = iIndexOf;
                }
                bestPattern = bestPattern.substring(0, iIndexOf).concat(bestPattern.substring(iIndexOf2 + 1));
            }
            if (bestPattern.indexOf(104) != -1) {
                c = 'h';
            } else if (bestPattern.indexOf(75) == -1) {
                c = bestPattern.indexOf(107) != -1 ? 'k' : 'H';
            }
            if (bestPattern.indexOf(98) != -1) {
                c3 = 'b';
            } else if (bestPattern.indexOf(66) != -1) {
                c3 = 'B';
            } else if (c3 == 0) {
                c3 = 'a';
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c);
            if (c != 'H' && c != 'k') {
                int i5 = 5;
                if (i3 < 5 && i2 < 5) {
                    i5 = 3;
                    if (i3 < 3 && i2 < 3) {
                        i5 = 1;
                    }
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    sb2.append(c3);
                }
            }
            sb.replace(i4, i4 + i2, sb2.toString());
            if (length > i4) {
                length += sb2.length() - i2;
            }
            sb.delete(length, i3 + length);
        }
        return sb.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        initializePattern(this.isDateIntervalInfoDefault ? LOCAL_PATTERN_CACHE : null);
        if (this.fCapitalizationSetting == null) {
            this.fCapitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
        }
    }

    @Override // java.text.Format
    public synchronized DateIntervalFormat clone() {
        DateIntervalFormat dateIntervalFormat;
        dateIntervalFormat = (DateIntervalFormat) super.clone();
        dateIntervalFormat.fDateFormat = this.fDateFormat.clone();
        dateIntervalFormat.fInfo = this.fInfo.m15clone();
        dateIntervalFormat.fFromCalendar = this.fFromCalendar.mo22clone();
        dateIntervalFormat.fToCalendar = this.fToCalendar.mo22clone();
        dateIntervalFormat.fDatePattern = this.fDatePattern;
        dateIntervalFormat.fTimePattern = this.fTimePattern;
        dateIntervalFormat.fDateTimeFormat = this.fDateTimeFormat;
        dateIntervalFormat.fCapitalizationSetting = this.fCapitalizationSetting;
        return dateIntervalFormat;
    }

    @Override // java.text.Format
    public final StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof DateInterval) {
            return format((DateInterval) obj, stringBuffer, fieldPosition);
        }
        og.i(cq.v("Cannot format given Object (", obj.getClass().getName(), ") as a DateInterval"));
        return null;
    }

    public FormattedDateInterval formatToValue(Calendar calendar, Calendar calendar2) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(0);
        FormatOutput formatOutput = new FormatOutput(0);
        ArrayList arrayList = new ArrayList();
        formatImpl(calendar, calendar2, stringBuffer, fieldPosition, formatOutput, arrayList);
        int i = formatOutput.firstIndex;
        if (i != -1) {
            FormattedValueFieldPositionIteratorImpl.addOverlapSpans(arrayList, SpanField.DATE_INTERVAL_SPAN, i);
            FormattedValueFieldPositionIteratorImpl.sort(arrayList);
        }
        return new FormattedDateInterval(stringBuffer, arrayList);
    }

    public DisplayContext getContext(DisplayContext.Type type) {
        DisplayContext displayContext;
        return (type != DisplayContext.Type.CAPITALIZATION || (displayContext = this.fCapitalizationSetting) == null) ? DisplayContext.CAPITALIZATION_NONE : displayContext;
    }

    public synchronized DateFormat getDateFormat() {
        return this.fDateFormat.clone();
    }

    public DateIntervalInfo getDateIntervalInfo() {
        return this.fInfo.m15clone();
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
    @Deprecated
    public String getPatterns(Calendar calendar, Calendar calendar2, Output<String> output) {
        char c = 0;
        if (calendar.get(0) == calendar2.get(0)) {
            c = 1;
            if (calendar.get(1) == calendar2.get(1)) {
                c = 2;
                if (calendar.get(2) == calendar2.get(2)) {
                    c = 5;
                    if (calendar.get(5) == calendar2.get(5)) {
                        c = '\t';
                        if (calendar.get(9) == calendar2.get(9)) {
                            c = '\n';
                            if (calendar.get(10) == calendar2.get(10)) {
                                c = '\f';
                                if (calendar.get(12) == calendar2.get(12)) {
                                    c = '\r';
                                    if (calendar.get(13) == calendar2.get(13)) {
                                        c = 14;
                                        if (calendar.get(14) == calendar2.get(14)) {
                                            return null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        DateIntervalInfo.PatternInfo patternInfo = this.fIntervalPatterns.get(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[c]);
        output.value = patternInfo.getSecondPart();
        return patternInfo.getFirstPart();
    }

    @Deprecated
    public Map<String, DateIntervalInfo.PatternInfo> getRawPatterns() {
        return this.fIntervalPatterns;
    }

    public TimeZone getTimeZone() {
        SimpleDateFormat simpleDateFormat = this.fDateFormat;
        return simpleDateFormat != null ? simpleDateFormat.getTimeZone().mo3clone() : TimeZone.getDefault();
    }

    @Override // java.text.Format
    @Deprecated
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException("parsing is not supported");
    }

    public void setContext(DisplayContext displayContext) {
        if (displayContext.type() == DisplayContext.Type.CAPITALIZATION) {
            this.fCapitalizationSetting = displayContext;
        }
    }

    public void setDateIntervalInfo(DateIntervalInfo dateIntervalInfo) {
        DateIntervalInfo dateIntervalInfoM15clone = dateIntervalInfo.m15clone();
        this.fInfo = dateIntervalInfoM15clone;
        this.isDateIntervalInfoDefault = false;
        dateIntervalInfoM15clone.freeze();
        if (this.fDateFormat != null) {
            initializePattern(null);
        }
    }

    public void setTimeZone(TimeZone timeZone) {
        TimeZone timeZoneMo3clone = timeZone.mo3clone();
        SimpleDateFormat simpleDateFormat = this.fDateFormat;
        if (simpleDateFormat != null) {
            simpleDateFormat.setTimeZone(timeZoneMo3clone);
        }
        Calendar calendar = this.fFromCalendar;
        if (calendar != null) {
            calendar.setTimeZone(timeZoneMo3clone);
        }
        Calendar calendar2 = this.fToCalendar;
        if (calendar2 != null) {
            calendar2.setTimeZone(timeZoneMo3clone);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class FormatOutput {
        int firstIndex;

        private FormatOutput() {
            this.firstIndex = -1;
        }

        public void register(int i) {
            if (this.firstIndex == -1) {
                this.firstIndex = i;
            }
        }

        public /* synthetic */ FormatOutput(int i) {
            this();
        }
    }

    public static final DateIntervalFormat getInstance(String str, Locale locale) {
        return getInstance(str, ULocale.forLocale(locale));
    }

    public static final DateIntervalFormat getInstance(String str, ULocale uLocale) {
        return new DateIntervalFormat(str, uLocale, new SimpleDateFormat(DateTimePatternGenerator.getInstance(uLocale).getBestPattern(str), uLocale));
    }

    public static final DateIntervalFormat getInstance(String str, DateIntervalInfo dateIntervalInfo) {
        return getInstance(str, ULocale.getDefault(ULocale.Category.FORMAT), dateIntervalInfo);
    }

    public static final DateIntervalFormat getInstance(String str, Locale locale, DateIntervalInfo dateIntervalInfo) {
        return getInstance(str, ULocale.forLocale(locale), dateIntervalInfo);
    }

    public static final DateIntervalFormat getInstance(String str) {
        return getInstance(str, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public final StringBuffer format(DateInterval dateInterval, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return formatIntervalImpl(dateInterval, stringBuffer, fieldPosition, null, null);
    }

    public final StringBuffer format(Calendar calendar, Calendar calendar2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return formatImpl(calendar, calendar2, stringBuffer, fieldPosition, null, null);
    }

    public final StringBuffer format(Temporal temporal, Temporal temporal2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return formatImpl(JavaTimeConverters.temporalToCalendar(temporal), JavaTimeConverters.temporalToCalendar(temporal2), stringBuffer, fieldPosition, null, null);
    }

    public FormattedDateInterval formatToValue(DateInterval dateInterval) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(0);
        FormatOutput formatOutput = new FormatOutput(0);
        ArrayList arrayList = new ArrayList();
        formatIntervalImpl(dateInterval, stringBuffer, fieldPosition, formatOutput, arrayList);
        int i = formatOutput.firstIndex;
        if (i != -1) {
            FormattedValueFieldPositionIteratorImpl.addOverlapSpans(arrayList, SpanField.DATE_INTERVAL_SPAN, i);
            FormattedValueFieldPositionIteratorImpl.sort(arrayList);
        }
        return new FormattedDateInterval(stringBuffer, arrayList);
    }

    public FormattedDateInterval formatToValue(Temporal temporal, Temporal temporal2) {
        return formatToValue(JavaTimeConverters.temporalToCalendar(temporal), JavaTimeConverters.temporalToCalendar(temporal2));
    }

    @Deprecated
    public DateIntervalFormat(String str, DateIntervalInfo dateIntervalInfo, SimpleDateFormat simpleDateFormat) {
        this.fSkeleton = null;
        this.fIntervalPatterns = null;
        this.fDatePattern = null;
        this.fTimePattern = null;
        this.fDateTimeFormat = null;
        this.fCapitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
        this.fDateFormat = simpleDateFormat;
        dateIntervalInfo.freeze();
        this.fSkeleton = str;
        this.fInfo = dateIntervalInfo;
        this.isDateIntervalInfoDefault = false;
        this.fFromCalendar = this.fDateFormat.getCalendar().mo22clone();
        this.fToCalendar = this.fDateFormat.getCalendar().mo22clone();
        initializePattern(null);
    }

    private DateIntervalFormat() {
        this.fSkeleton = null;
        this.fIntervalPatterns = null;
        this.fDatePattern = null;
        this.fTimePattern = null;
        this.fDateTimeFormat = null;
        this.fCapitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
    }

    private final StringBuffer fallbackFormat(Calendar calendar, Calendar calendar2, boolean z, StringBuffer stringBuffer, FieldPosition fieldPosition, FormatOutput formatOutput, List<FieldPosition> list, String str) {
        String pattern = this.fDateFormat.toPattern();
        this.fDateFormat.applyPattern(str);
        fallbackFormat(calendar, calendar2, z, stringBuffer, fieldPosition, formatOutput, list);
        this.fDateFormat.applyPattern(pattern);
        return stringBuffer;
    }
}
