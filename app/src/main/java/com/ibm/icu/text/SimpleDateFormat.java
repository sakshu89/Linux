package com.ibm.icu.text;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.DateNumberFormat;
import com.ibm.icu.impl.DayPeriodRules;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.JavaTimeConverters;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.BasicTimeZone;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.HebrewCalendar;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.TimeZoneTransition;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.kf2;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SimpleDateFormat extends DateFormat implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final UnicodeSet DATE_PATTERN_TYPE;
    private static final int DECIMAL_BUF_SIZE = 10;
    static boolean DelayedHebrewMonthCheck = false;
    private static final String FALLBACKPATTERN = "yy/MM/dd HH:mm";
    private static final int HEBREW_CAL_CUR_MILLENIUM_END_YEAR = 6000;
    private static final int HEBREW_CAL_CUR_MILLENIUM_START_YEAR = 5000;
    private static final int ISOSpecialEra = -32000;
    private static final long MAX_DAYLIGHT_DETECTION_RANGE = 946080000000L;
    private static final String NUMERIC_FORMAT_CHARS = "ADdFgHhKkmrSsuWwYy";
    private static final String NUMERIC_FORMAT_CHARS2 = "ceLMQq";
    private static ICUCache<String, Object[]> PARSED_PATTERN_CACHE = null;
    private static final DateFormat.Field[] PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE;
    private static final String SUPPRESS_NEGATIVE_PREFIX = "\uab00";
    static final int currentSerialVersion = 2;
    private static final int millisPerHour = 3600000;
    private static final long serialVersionUID = 4774881970558875024L;
    private transient BreakIterator capitalizationBrkIter;
    private transient char[] decDigits;
    private transient char[] decimalBuf;
    private transient long defaultCenturyBase;
    private Date defaultCenturyStart;
    private transient int defaultCenturyStartYear;
    private DateFormatSymbols formatData;
    private transient boolean hasHanYearChar;
    private transient boolean hasMinute;
    private transient boolean hasSecond;
    private transient ULocale locale;
    private HashMap<String, NumberFormat> numberFormatters;
    private transient PluralRules ordinalPluralRules;
    private String override;
    private HashMap<Character, String> overrideMap;
    private String pattern;
    private transient Object[] patternItems;
    private int serialVersionOnStream;
    private volatile TimeZoneFormat tzFormat;
    private transient boolean useFastFormat;
    private transient boolean useLocalZeroPaddingNumberFormat;
    private static final int[] CALENDAR_FIELD_TO_LEVEL = {0, 10, 20, 20, 30, 30, 20, 30, 30, 40, 50, 50, 60, 70, 80, 0, 0, 10, 30, 10, 0, 40, 0, 0};
    private static final int[] PATTERN_CHAR_TO_LEVEL = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, 20, 30, 30, 0, 50, -1, -1, 50, 20, 20, -1, 0, -1, 20, -1, 80, -1, 10, 0, 30, 0, 10, 0, -1, -1, -1, -1, -1, -1, 40, -1, 30, 30, 30, -1, 0, 50, -1, -1, 50, -1, 60, -1, -1, -1, 20, 10, 70, -1, 10, 0, 20, 0, 10, 0, -1, -1, -1, -1, -1};
    private static final boolean[] PATTERN_CHAR_IS_SYNTAX = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false};
    private static volatile DefaultPatternEntry cachedDefault = null;
    private static final int[] PATTERN_CHAR_TO_INDEX = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, 36, -1, 10, 9, 11, 0, 5, -1, -1, 16, 26, 2, -1, 31, -1, 27, -1, 8, -1, 30, 29, 13, 32, 18, 23, -1, -1, -1, -1, -1, -1, 14, 35, 25, 3, 19, -1, 21, 15, -1, -1, 4, -1, 6, -1, -1, -1, 28, 34, 7, -1, 20, 24, 12, 33, 1, 17, -1, -1, -1, -1, -1};
    private static final int[] PATTERN_INDEX_TO_CALENDAR_FIELD = {0, 1, 2, 5, 11, 11, 12, 13, 14, 7, 6, 8, 3, 4, 9, 10, 10, 15, 17, 18, 19, 20, 21, 15, 15, 18, 2, 2, 2, 15, 1, 15, 15, 15, 19, -1, -2};
    private static final int[] PATTERN_INDEX_TO_DATE_FORMAT_FIELD = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37};

    /* JADX INFO: renamed from: com.ibm.icu.text.SimpleDateFormat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$DisplayContext;

        static {
            int[] iArr = new int[DisplayContext.values().length];
            $SwitchMap$com$ibm$icu$text$DisplayContext = iArr;
            try {
                iArr[DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$DisplayContext[DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$DisplayContext[DisplayContext.CAPITALIZATION_FOR_STANDALONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ContextValue {
        UNKNOWN,
        CAPITALIZATION_FOR_MIDDLE_OF_SENTENCE,
        CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE,
        CAPITALIZATION_FOR_UI_LIST_OR_MENU,
        CAPITALIZATION_FOR_STANDALONE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DefaultPatternEntry {
        final ULocale locale;
        final String pattern;

        public DefaultPatternEntry(ULocale uLocale, String str) {
            this.locale = uLocale;
            this.pattern = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class PatternItem {
        final boolean isNumeric;
        final int length;
        final char type;

        public PatternItem(char c, int i) {
            this.type = c;
            this.length = i;
            this.isNumeric = SimpleDateFormat.isNumeric(c, i);
        }
    }

    static {
        DateFormat.Field field = DateFormat.Field.ERA;
        DateFormat.Field field2 = DateFormat.Field.YEAR;
        DateFormat.Field field3 = DateFormat.Field.MONTH;
        DateFormat.Field field4 = DateFormat.Field.DAY_OF_MONTH;
        DateFormat.Field field5 = DateFormat.Field.HOUR_OF_DAY1;
        DateFormat.Field field6 = DateFormat.Field.HOUR_OF_DAY0;
        DateFormat.Field field7 = DateFormat.Field.MINUTE;
        DateFormat.Field field8 = DateFormat.Field.SECOND;
        DateFormat.Field field9 = DateFormat.Field.MILLISECOND;
        DateFormat.Field field10 = DateFormat.Field.DAY_OF_WEEK;
        DateFormat.Field field11 = DateFormat.Field.DAY_OF_YEAR;
        DateFormat.Field field12 = DateFormat.Field.DAY_OF_WEEK_IN_MONTH;
        DateFormat.Field field13 = DateFormat.Field.WEEK_OF_YEAR;
        DateFormat.Field field14 = DateFormat.Field.WEEK_OF_MONTH;
        DateFormat.Field field15 = DateFormat.Field.AM_PM;
        DateFormat.Field field16 = DateFormat.Field.HOUR1;
        DateFormat.Field field17 = DateFormat.Field.HOUR0;
        DateFormat.Field field18 = DateFormat.Field.TIME_ZONE;
        DateFormat.Field field19 = DateFormat.Field.YEAR_WOY;
        DateFormat.Field field20 = DateFormat.Field.DOW_LOCAL;
        DateFormat.Field field21 = DateFormat.Field.EXTENDED_YEAR;
        DateFormat.Field field22 = DateFormat.Field.JULIAN_DAY;
        DateFormat.Field field23 = DateFormat.Field.MILLISECONDS_IN_DAY;
        DateFormat.Field field24 = DateFormat.Field.QUARTER;
        PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE = new DateFormat.Field[]{field, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19, field20, field21, field22, field23, field18, field18, field10, field3, field24, field24, field18, field2, field18, field18, field18, DateFormat.Field.RELATED_YEAR, DateFormat.Field.AM_PM_MIDNIGHT_NOON, DateFormat.Field.FLEXIBLE_DAY_PERIOD, DateFormat.Field.TIME_SEPARATOR};
        PARSED_PATTERN_CACHE = new SimpleCache();
        DATE_PATTERN_TYPE = new UnicodeSet("[GyYuUQqMLlwWd]").freeze();
    }

    private SimpleDateFormat(String str, DateFormatSymbols dateFormatSymbols, Calendar calendar, NumberFormat numberFormat, ULocale uLocale, boolean z, String str2) {
        this.serialVersionOnStream = 2;
        this.capitalizationBrkIter = null;
        this.pattern = str;
        this.formatData = dateFormatSymbols;
        this.calendar = calendar;
        this.numberFormat = numberFormat;
        this.locale = uLocale;
        this.useFastFormat = z;
        this.override = str2;
        initialize();
    }

    private boolean allowNumericFallback(int i) {
        return i == 26 || i == 19 || i == 25 || i == 30 || i == 27 || i == 28;
    }

    private static int countDigits(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (UCharacter.isDigit(iCodePointAt)) {
                i3++;
            }
            i += UCharacter.charCount(iCodePointAt);
        }
        return i3;
    }

    private boolean diffCalFieldValue(Calendar calendar, Calendar calendar2, Object[] objArr, int i) {
        Object obj = objArr[i];
        if (obj instanceof String) {
            return false;
        }
        char c = ((PatternItem) obj).type;
        int indexFromChar = getIndexFromChar(c);
        if (indexFromChar != -1) {
            int i2 = PATTERN_INDEX_TO_CALENDAR_FIELD[indexFromChar];
            return i2 >= 0 && calendar.get(i2) != calendar2.get(i2);
        }
        kf2.c(c, this.pattern);
        return false;
    }

    private void fastZeroPaddingNumber(StringBuffer stringBuffer, int i, int i2, int i3) {
        char[] cArr = this.decimalBuf;
        if (cArr.length < i3) {
            i3 = cArr.length;
        }
        int i4 = i3 - 1;
        while (true) {
            this.decimalBuf[i4] = this.decDigits[i % 10];
            i /= 10;
            if (i4 == 0 || i == 0) {
                break;
            } else {
                i4--;
            }
        }
        int i5 = i2 - (i3 - i4);
        while (i5 > 0 && i4 > 0) {
            i4--;
            this.decimalBuf[i4] = this.decDigits[0];
            i5--;
        }
        while (i5 > 0) {
            stringBuffer.append(this.decDigits[0]);
            i5--;
        }
        stringBuffer.append(this.decimalBuf, i4, i3 - i4);
    }

    private StringBuffer format(Calendar calendar, DisplayContext displayContext, StringBuffer stringBuffer, FieldPosition fieldPosition, List<FieldPosition> list) {
        StringBuffer stringBuffer2;
        int i;
        StringBuffer stringBuffer3 = stringBuffer;
        FieldPosition fieldPosition2 = fieldPosition;
        fieldPosition2.setBeginIndex(0);
        fieldPosition2.setEndIndex(0);
        Object[] patternItems = getPatternItems();
        int i2 = 0;
        while (i2 < patternItems.length) {
            Object obj = patternItems[i2];
            if (obj instanceof String) {
                stringBuffer3.append((String) obj);
                stringBuffer2 = stringBuffer3;
                i = i2;
            } else {
                PatternItem patternItem = (PatternItem) obj;
                int length = list != null ? stringBuffer3.length() : 0;
                if (this.useFastFormat) {
                    i = i2;
                    subFormat(stringBuffer3, patternItem.type, patternItem.length, stringBuffer3.length(), i, displayContext, fieldPosition2, patternItem.type, calendar);
                    stringBuffer2 = stringBuffer3;
                } else {
                    stringBuffer2 = stringBuffer3;
                    i = i2;
                    stringBuffer2.append(subFormat(patternItem.type, patternItem.length, stringBuffer2.length(), i2, displayContext, fieldPosition, patternItem.type, calendar));
                }
                if (list != null) {
                    int length2 = stringBuffer2.length();
                    if (length2 - length > 0) {
                        FieldPosition fieldPosition3 = new FieldPosition(patternCharToDateFormatField(patternItem.type));
                        fieldPosition3.setBeginIndex(length);
                        fieldPosition3.setEndIndex(length2);
                        list.add(fieldPosition3);
                    }
                }
            }
            i2 = i + 1;
            fieldPosition2 = fieldPosition;
            stringBuffer3 = stringBuffer2;
        }
        return stringBuffer3;
    }

    private String formatDayOfMonthName(int i, NumberFormat numberFormat, int i2, int i3) {
        PluralRules pluralRules;
        String str;
        String[] dayOfMonthCardinalNames = this.formatData.getDayOfMonthCardinalNames(0, 0);
        if (dayOfMonthCardinalNames != null && i >= 1 && i < dayOfMonthCardinalNames.length && (str = dayOfMonthCardinalNames[i]) != null && !str.isEmpty()) {
            return dayOfMonthCardinalNames[i];
        }
        String[] dayOfMonthOrdinalNames = this.formatData.getDayOfMonthOrdinalNames(0, 0);
        if (dayOfMonthOrdinalNames != null && (pluralRules = this.ordinalPluralRules) != null) {
            String str2 = dayOfMonthOrdinalNames[StandardPlural.orOtherFromString(pluralRules.select(i)).ordinal()];
            if (str2 == null || str2.isEmpty()) {
                str2 = dayOfMonthOrdinalNames[StandardPlural.OTHER.ordinal()];
            }
            if (str2 != null && !str2.isEmpty()) {
                StringBuffer stringBuffer = new StringBuffer();
                zeroPaddingNumber(numberFormat, stringBuffer, i, 1, i3);
                return SimpleFormatter.compile(str2).format(stringBuffer.toString());
            }
        }
        return null;
    }

    private Date getDefaultCenturyStart() {
        if (this.defaultCenturyStart == null) {
            initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        return this.defaultCenturyStart;
    }

    private int getDefaultCenturyStartYear() {
        if (this.defaultCenturyStart == null) {
            initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        return this.defaultCenturyStartYear;
    }

    private static String getDefaultPattern() {
        String rawPattern;
        ULocale uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        DefaultPatternEntry defaultPatternEntry = cachedDefault;
        if (defaultPatternEntry != null && uLocale.equals(defaultPatternEntry.locale)) {
            return defaultPatternEntry.pattern;
        }
        synchronized (SimpleDateFormat.class) {
            try {
                DefaultPatternEntry defaultPatternEntry2 = cachedDefault;
                if (defaultPatternEntry2 != null && uLocale.equals(defaultPatternEntry2.locale)) {
                    return defaultPatternEntry2.pattern;
                }
                Calendar calendar = Calendar.getInstance(uLocale);
                try {
                    ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
                    ICUResourceBundle iCUResourceBundleFindWithFallback = iCUResourceBundle.findWithFallback("calendar/" + calendar.getType() + "/DateTimePatterns");
                    if (iCUResourceBundleFindWithFallback == null) {
                        iCUResourceBundleFindWithFallback = iCUResourceBundle.findWithFallback("calendar/gregorian/DateTimePatterns");
                    }
                    rawPattern = (iCUResourceBundleFindWithFallback == null || iCUResourceBundleFindWithFallback.getSize() < 9) ? FALLBACKPATTERN : SimpleFormatterImpl.formatRawPattern(Calendar.getDateAtTimePattern(calendar, uLocale, 3), 2, 2, iCUResourceBundleFindWithFallback.getString(3), iCUResourceBundleFindWithFallback.getString(7));
                } catch (MissingResourceException unused) {
                    rawPattern = FALLBACKPATTERN;
                }
                cachedDefault = new DefaultPatternEntry(uLocale, rawPattern);
                return rawPattern;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static int getIndexFromChar(char c) {
        int[] iArr = PATTERN_CHAR_TO_INDEX;
        if (c < iArr.length) {
            return iArr[c & 255];
        }
        return -1;
    }

    @Deprecated
    public static SimpleDateFormat getInstance(Calendar.FormatConfiguration formatConfiguration) {
        String overrideString = formatConfiguration.getOverrideString();
        return new SimpleDateFormat(formatConfiguration.getPatternString(), formatConfiguration.getDateFormatSymbols(), formatConfiguration.getCalendar(), null, formatConfiguration.getLocale(), overrideString != null && overrideString.length() > 0, formatConfiguration.getOverrideString());
    }

    private static int getLevelFromChar(char c) {
        int[] iArr = PATTERN_CHAR_TO_LEVEL;
        if (c < iArr.length) {
            return iArr[c & 255];
        }
        return -1;
    }

    private Object[] getPatternItems() {
        Object[] objArr = this.patternItems;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = PARSED_PATTERN_CACHE.get(this.pattern);
        this.patternItems = objArr2;
        if (objArr2 != null) {
            return objArr2;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int i = 1;
        char c = 0;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.pattern.length(); i2++) {
            char cCharAt = this.pattern.charAt(i2);
            if (cCharAt == '\'') {
                if (z2) {
                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                    z2 = false;
                } else if (c != 0) {
                    arrayList.add(new PatternItem(c, i));
                    z2 = true;
                    c = 0;
                } else {
                    z2 = true;
                }
                z = !z;
            } else {
                if (z) {
                    sb.append(cCharAt);
                } else if (!isSyntaxChar(cCharAt)) {
                    if (c != 0) {
                        arrayList.add(new PatternItem(c, i));
                        c = 0;
                    }
                    sb.append(cCharAt);
                } else if (cCharAt == c) {
                    i++;
                } else {
                    if (c != 0) {
                        arrayList.add(new PatternItem(c, i));
                    } else if (sb.length() > 0) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    i = 1;
                    z2 = false;
                    c = cCharAt;
                }
                z2 = false;
            }
        }
        if (c != 0) {
            arrayList.add(new PatternItem(c, i));
        } else if (sb.length() > 0) {
            arrayList.add(sb.toString());
            sb.setLength(0);
        }
        Object[] array = arrayList.toArray(new Object[arrayList.size()]);
        this.patternItems = array;
        PARSED_PATTERN_CACHE.put(this.pattern, array);
        return this.patternItems;
    }

    private void initLocalZeroPaddingNumberFormat() {
        NumberFormat numberFormat = this.numberFormat;
        if (numberFormat instanceof DecimalFormat) {
            String[] digitStringsLocal = ((DecimalFormat) numberFormat).getDecimalFormatSymbols().getDigitStringsLocal();
            this.useLocalZeroPaddingNumberFormat = true;
            this.decDigits = new char[10];
            for (int i = 0; i < 10; i++) {
                if (digitStringsLocal[i].length() > 1) {
                    this.useLocalZeroPaddingNumberFormat = false;
                    break;
                }
                this.decDigits[i] = digitStringsLocal[i].charAt(0);
            }
        } else if (numberFormat instanceof DateNumberFormat) {
            this.decDigits = ((DateNumberFormat) numberFormat).getDigits();
            this.useLocalZeroPaddingNumberFormat = true;
        } else {
            this.useLocalZeroPaddingNumberFormat = false;
        }
        if (this.useLocalZeroPaddingNumberFormat) {
            this.decimalBuf = new char[10];
        }
    }

    private void initNumberFormatters(ULocale uLocale) {
        this.numberFormatters = new HashMap<>();
        this.overrideMap = new HashMap<>();
        processOverrideString(uLocale, this.override);
    }

    private void initialize() {
        Calendar calendar;
        ULocale uLocale;
        if (this.locale == null) {
            this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        if (this.formatData == null) {
            this.formatData = new DateFormatSymbols(this.locale);
        }
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance(this.locale);
        }
        if (this.numberFormat == null) {
            NumberingSystem numberingSystem = NumberingSystem.getInstance(this.locale);
            String description = numberingSystem.getDescription();
            if (numberingSystem.isAlgorithmic() || description.length() != 10) {
                this.numberFormat = NumberFormat.getInstance(this.locale);
            } else {
                this.numberFormat = new DateNumberFormat(this.locale, description, numberingSystem.getName());
            }
        }
        NumberFormat numberFormat = this.numberFormat;
        if (numberFormat instanceof DecimalFormat) {
            DateFormat.fixNumberFormatForDates(numberFormat);
        }
        this.defaultCenturyBase = System.currentTimeMillis();
        setLocale(this.calendar.getLocale(ULocale.VALID_LOCALE), this.calendar.getLocale(ULocale.ACTUAL_LOCALE));
        initLocalZeroPaddingNumberFormat();
        parsePattern();
        if (this.override == null && this.hasHanYearChar && (calendar = this.calendar) != null && calendar.getType().equals("japanese") && (uLocale = this.locale) != null && uLocale.getLanguage().equals("ja")) {
            this.override = "y=jpanyear";
        }
        if (this.override != null) {
            initNumberFormatters(this.locale);
        }
    }

    private void initializeDefaultCenturyStart(long j) {
        this.defaultCenturyBase = j;
        Calendar calendarMo22clone = this.calendar.mo22clone();
        calendarMo22clone.setTimeInMillis(j);
        calendarMo22clone.add(1, -80);
        this.defaultCenturyStart = calendarMo22clone.getTime();
        this.defaultCenturyStartYear = calendarMo22clone.get(1);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018 A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:4:0x0003, B:9:0x000a, B:11:0x0018, B:13:0x002b, B:14:0x0033, B:20:0x004c, B:22:0x0058, B:24:0x0060, B:25:0x0068, B:15:0x0038, B:17:0x003c), top: B:30:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x002b A[Catch: all -> 0x0008, LOOP:0: B:12:0x0029->B:13:0x002b, LOOP_END, TryCatch #0 {all -> 0x0008, blocks: (B:4:0x0003, B:9:0x000a, B:11:0x0018, B:13:0x002b, B:14:0x0033, B:20:0x004c, B:22:0x0058, B:24:0x0060, B:25:0x0068, B:15:0x0038, B:17:0x003c), top: B:30:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0038 A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:4:0x0003, B:9:0x000a, B:11:0x0018, B:13:0x002b, B:14:0x0033, B:20:0x004c, B:22:0x0058, B:24:0x0060, B:25:0x0068, B:15:0x0038, B:17:0x003c), top: B:30:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x003c A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:4:0x0003, B:9:0x000a, B:11:0x0018, B:13:0x002b, B:14:0x0033, B:20:0x004c, B:22:0x0058, B:24:0x0060, B:25:0x0068, B:15:0x0038, B:17:0x003c), top: B:30:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:24:0x0060 A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:4:0x0003, B:9:0x000a, B:11:0x0018, B:13:0x002b, B:14:0x0033, B:20:0x004c, B:22:0x0058, B:24:0x0060, B:25:0x0068, B:15:0x0038, B:17:0x003c), top: B:30:0x0003 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:11:0x0018, please report this as an issue */
    private synchronized void initializeTimeZoneFormat(boolean z) {
        NumberFormat numberFormat;
        String str;
        StringBuilder sb;
        int i;
        if (z) {
            this.tzFormat = TimeZoneFormat.getInstance(this.locale);
            numberFormat = this.numberFormat;
            if (numberFormat instanceof DecimalFormat) {
                String[] digitStringsLocal = ((DecimalFormat) numberFormat).getDecimalFormatSymbols().getDigitStringsLocal();
                sb = new StringBuilder();
                for (String str2 : digitStringsLocal) {
                    sb.append(str2);
                }
                str = sb.toString();
            } else if (numberFormat instanceof DateNumberFormat) {
                str = new String(((DateNumberFormat) numberFormat).getDigits());
            } else {
                str = null;
            }
            if (str != null) {
                if (this.tzFormat.isFrozen()) {
                    this.tzFormat = this.tzFormat.cloneAsThawed();
                }
                this.tzFormat.setGMTOffsetDigits(str);
            }
        } else {
            try {
                if (this.tzFormat == null) {
                    this.tzFormat = TimeZoneFormat.getInstance(this.locale);
                    numberFormat = this.numberFormat;
                    if (numberFormat instanceof DecimalFormat) {
                        String[] digitStringsLocal2 = ((DecimalFormat) numberFormat).getDecimalFormatSymbols().getDigitStringsLocal();
                        sb = new StringBuilder();
                        while (i < r1) {
                            sb.append(str2);
                        }
                        str = sb.toString();
                    } else if (numberFormat instanceof DateNumberFormat) {
                        str = new String(((DateNumberFormat) numberFormat).getDigits());
                    } else {
                        str = null;
                    }
                    if (str != null && !this.tzFormat.getGMTOffsetDigits().equals(str)) {
                        if (this.tzFormat.isFrozen()) {
                            this.tzFormat = this.tzFormat.cloneAsThawed();
                        }
                        this.tzFormat.setGMTOffsetDigits(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isFieldUnitIgnored(String str, int i) {
        int i2 = CALENDAR_FIELD_TO_LEVEL[i];
        int i3 = 0;
        int i4 = 0;
        char c = 0;
        boolean z = false;
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != c && i4 > 0) {
                if (i2 <= getLevelFromChar(c)) {
                    return false;
                }
                i4 = 0;
            }
            if (cCharAt == '\'') {
                int i5 = i3 + 1;
                if (i5 >= str.length() || str.charAt(i5) != '\'') {
                    z = !z;
                } else {
                    i3 = i5;
                }
            } else if (!z && isSyntaxChar(cCharAt)) {
                i4++;
                c = cCharAt;
            }
            i3++;
        }
        return i4 <= 0 || i2 > getLevelFromChar(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isNumeric(char c, int i) {
        if (NUMERIC_FORMAT_CHARS.indexOf(c) < 0) {
            return i <= 2 && NUMERIC_FORMAT_CHARS2.indexOf(c) >= 0;
        }
        return true;
    }

    private static boolean isSyntaxChar(char c) {
        boolean[] zArr = PATTERN_CHAR_IS_SYNTAX;
        if (c < zArr.length) {
            return zArr[c & 255];
        }
        return false;
    }

    private boolean lowerLevel(Object[] objArr, int i, int i2) {
        Object obj = objArr[i];
        if (obj instanceof String) {
            return false;
        }
        char c = ((PatternItem) obj).type;
        int levelFromChar = getLevelFromChar(c);
        if (levelFromChar != -1) {
            return levelFromChar >= i2;
        }
        kf2.c(c, this.pattern);
        return false;
    }

    @Deprecated
    private int matchAlphaMonthStrings(String str, int i, String[] strArr, String[] strArr2, Calendar calendar) {
        int iRegionMatchesWithOptionalDot;
        int iRegionMatchesWithOptionalDot2;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < strArr.length; i4++) {
            int length = strArr[i4].length();
            if (length > i3 && (iRegionMatchesWithOptionalDot2 = regionMatchesWithOptionalDot(str, i, strArr[i4], length)) >= 0) {
                i2 = i4;
                i3 = iRegionMatchesWithOptionalDot2;
            }
        }
        for (int i5 = 0; i5 < strArr2.length; i5++) {
            int length2 = strArr2[i5].length();
            if (length2 > i3 && (iRegionMatchesWithOptionalDot = regionMatchesWithOptionalDot(str, i, strArr2[i5], length2)) >= 0) {
                i3 = iRegionMatchesWithOptionalDot;
                i2 = i5;
            }
        }
        if (i2 < 0) {
            return ~i;
        }
        calendar.set(2, i2);
        return i + i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int matchDayPeriodString(String str, int i, String[] strArr, int i2, Output<DayPeriodRules.DayPeriod> output) {
        int length;
        int iRegionMatchesWithOptionalDot;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            String str2 = strArr[i5];
            if (str2 != null && (length = str2.length()) > i4 && (iRegionMatchesWithOptionalDot = regionMatchesWithOptionalDot(str, i, strArr[i5], length)) >= 0) {
                i3 = i5;
                i4 = iRegionMatchesWithOptionalDot;
            }
        }
        if (i3 < 0) {
            return -i;
        }
        output.value = DayPeriodRules.DayPeriod.VALUES[i3];
        return i + i4;
    }

    private int matchLiteral(String str, int i, Object[] objArr, int i2, boolean[] zArr) {
        String str2 = (String) objArr[i2];
        int length = str2.length();
        int length2 = str.length();
        int i3 = i;
        int i4 = 0;
        while (true) {
            if (i4 >= length || i3 >= length2) {
                break;
            }
            char cCharAt = str2.charAt(i4);
            char cCharAt2 = str.charAt(i3);
            if ((PatternProps.isWhiteSpace(cCharAt) || UCharacter.isUWhiteSpace(cCharAt)) && (PatternProps.isWhiteSpace(cCharAt2) || UCharacter.isUWhiteSpace(cCharAt2))) {
                while (true) {
                    int i5 = i4 + 1;
                    if (i5 >= length || !(PatternProps.isWhiteSpace(str2.charAt(i5)) || UCharacter.isUWhiteSpace(str2.charAt(i5)))) {
                        break;
                    }
                    i4 = i5;
                }
                while (true) {
                    int i6 = i3 + 1;
                    if (i6 >= length2 || !(PatternProps.isWhiteSpace(str.charAt(i6)) || UCharacter.isUWhiteSpace(str.charAt(i6)))) {
                        break;
                    }
                    i3 = i6;
                }
                i4++;
                i3++;
            } else if (cCharAt == cCharAt2) {
                i4++;
                i3++;
            } else if (cCharAt2 != '.' || i3 != i || i2 <= 0 || !getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_WHITESPACE)) {
                if (((cCharAt != ' ' && cCharAt != '.') || !getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_WHITESPACE)) && (i3 == i || !getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_PARTIAL_LITERAL_MATCH))) {
                    break;
                }
                i4++;
            } else {
                Object obj = objArr[i2 - 1];
                if (!(obj instanceof PatternItem) || ((PatternItem) obj).isNumeric) {
                    break;
                }
                i3++;
            }
        }
        boolean z = i4 == length;
        zArr[0] = z;
        if (!z && getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_WHITESPACE) && i2 > 0 && i2 < objArr.length - 1 && i < length2) {
            Object obj2 = objArr[i2 - 1];
            Object obj3 = objArr[i2 + 1];
            if ((obj2 instanceof PatternItem) && (obj3 instanceof PatternItem)) {
                char c = ((PatternItem) obj2).type;
                char c2 = ((PatternItem) obj3).type;
                UnicodeSet unicodeSet = DATE_PATTERN_TYPE;
                if (unicodeSet.contains(c) != unicodeSet.contains(c2)) {
                    int i7 = i;
                    while (i7 < length2 && PatternProps.isWhiteSpace(str.charAt(i7))) {
                        i7++;
                    }
                    zArr[0] = i7 > i;
                    return i7;
                }
            }
        }
        return i3;
    }

    @Deprecated
    private int matchString(String str, int i, int i2, String[] strArr, String str2, Calendar calendar) {
        String rawPattern;
        int length;
        int iRegionMatchesWithOptionalDot;
        int iRegionMatchesWithOptionalDot2;
        int length2 = strArr.length;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = i2 == 7 ? 1 : 0; i6 < length2; i6++) {
            int length3 = strArr[i6].length();
            if (length3 > i4 && (iRegionMatchesWithOptionalDot2 = regionMatchesWithOptionalDot(str, i, strArr[i6], length3)) >= 0) {
                i3 = i6;
                i5 = 0;
                i4 = iRegionMatchesWithOptionalDot2;
            }
            if (str2 != null && (length = (rawPattern = SimpleFormatterImpl.formatRawPattern(str2, 1, 1, strArr[i6])).length()) > i4 && (iRegionMatchesWithOptionalDot = regionMatchesWithOptionalDot(str, i, rawPattern, length)) >= 0) {
                i3 = i6;
                i5 = 1;
                i4 = iRegionMatchesWithOptionalDot;
            }
        }
        if (i3 < 0) {
            return ~i;
        }
        if (i2 >= 0) {
            if (i2 == 1) {
                i3++;
            }
            calendar.set(i2, i3);
            if (str2 != null) {
                calendar.set(22, i5);
            }
        }
        return i + i4;
    }

    private void parseAmbiguousDatesAsAfter(Date date) {
        this.defaultCenturyStart = date;
        this.calendar.setTime(date);
        this.defaultCenturyStartYear = this.calendar.get(1);
    }

    private int parseDayOfMonthName(String str, int i, Calendar calendar) {
        int iIndexOf;
        String[] dayOfMonthCardinalNames = this.formatData.getDayOfMonthCardinalNames(0, 0);
        if (dayOfMonthCardinalNames != null) {
            int length = 0;
            int i2 = -1;
            for (int i3 = 1; i3 < dayOfMonthCardinalNames.length; i3++) {
                String str2 = dayOfMonthCardinalNames[i3];
                if (str2 != null && !str2.isEmpty() && str2.length() > length && regionMatchesWithOptionalDot(str, 0, str2, str2.length()) >= 0) {
                    length = str2.length();
                    i2 = i3;
                }
            }
            if (i2 > 0) {
                calendar.set(5, i2);
                return i + length;
            }
        }
        String[] dayOfMonthOrdinalNames = this.formatData.getDayOfMonthOrdinalNames(0, 0);
        if (dayOfMonthOrdinalNames == null) {
            return -1;
        }
        for (String str3 : dayOfMonthOrdinalNames) {
            if (str3 != null && !str3.isEmpty() && (iIndexOf = str3.indexOf("{0}")) >= 0) {
                String strSubstring = str3.substring(0, iIndexOf);
                String strSubstring2 = str3.substring(iIndexOf + 3);
                if (regionMatchesWithOptionalDot(str, i, strSubstring, strSubstring.length()) < 0) {
                    continue;
                } else {
                    int length2 = strSubstring.length() + i;
                    ParsePosition parsePosition = new ParsePosition(length2);
                    Number number = parseInt(str, parsePosition, false, getNumberFormat('d'));
                    if (number != null && parsePosition.getIndex() > length2) {
                        int index = parsePosition.getIndex();
                        if (regionMatchesWithOptionalDot(str, index, strSubstring2, strSubstring2.length()) >= 0) {
                            calendar.set(5, number.intValue());
                            return strSubstring2.length() + index;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private Number parseInt(String str, int i, ParsePosition parsePosition, boolean z, NumberFormat numberFormat) {
        Number number;
        int index;
        int index2 = parsePosition.getIndex();
        if (z) {
            number = numberFormat.parse(str, parsePosition);
        } else if (numberFormat instanceof DecimalFormat) {
            DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
            String negativePrefix = decimalFormat.getNegativePrefix();
            decimalFormat.setNegativePrefix(SUPPRESS_NEGATIVE_PREFIX);
            number = numberFormat.parse(str, parsePosition);
            decimalFormat.setNegativePrefix(negativePrefix);
        } else {
            boolean z2 = numberFormat instanceof DateNumberFormat;
            if (z2) {
                ((DateNumberFormat) numberFormat).setParsePositiveOnly(true);
            }
            number = numberFormat.parse(str, parsePosition);
            if (z2) {
                ((DateNumberFormat) numberFormat).setParsePositiveOnly(false);
            }
        }
        if (i <= 0 || (index = parsePosition.getIndex() - index2) <= i) {
            return number;
        }
        double dDoubleValue = number.doubleValue();
        for (int i2 = index - i; i2 > 0; i2--) {
            dDoubleValue /= 10.0d;
        }
        parsePosition.setIndex(index2 + i);
        return Integer.valueOf((int) dDoubleValue);
    }

    private void parsePattern() {
        this.hasMinute = false;
        this.hasSecond = false;
        this.hasHanYearChar = false;
        this.ordinalPluralRules = null;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < this.pattern.length(); i2++) {
            char cCharAt = this.pattern.charAt(i2);
            if (cCharAt == '\'') {
                z = !z;
            }
            if (cCharAt == 24180) {
                this.hasHanYearChar = true;
            }
            if (!z) {
                if (cCharAt == 'm') {
                    this.hasMinute = true;
                }
                if (cCharAt == 's') {
                    this.hasSecond = true;
                }
                if (cCharAt == 'd') {
                    i++;
                    if (i >= 3 && this.ordinalPluralRules == null) {
                        this.ordinalPluralRules = PluralRules.forLocale(this.locale, PluralRules.PluralType.ORDINAL);
                    }
                } else {
                    i = 0;
                }
            }
        }
    }

    private void processOverrideString(ULocale uLocale, String str) {
        boolean z;
        int length;
        boolean z2;
        if (str == null || str.length() == 0) {
            return;
        }
        boolean z3 = true;
        int i = 0;
        while (z3) {
            int iIndexOf = str.indexOf(";", i);
            if (iIndexOf == -1) {
                length = str.length();
                z = false;
            } else {
                z = z3;
                length = iIndexOf;
            }
            String strSubstring = str.substring(i, length);
            int iIndexOf2 = strSubstring.indexOf("=");
            if (iIndexOf2 == -1) {
                z2 = true;
            } else {
                String strSubstring2 = strSubstring.substring(iIndexOf2 + 1);
                this.overrideMap.put(Character.valueOf(strSubstring.charAt(0)), strSubstring2);
                strSubstring = strSubstring2;
                z2 = false;
            }
            NumberFormat numberFormatCreateInstance = NumberFormat.createInstance(new ULocale(cq.k(uLocale.getBaseName(), "@numbers=", strSubstring)), 0);
            numberFormatCreateInstance.setGroupingUsed(false);
            if (z2) {
                setNumberFormat(numberFormatCreateInstance);
            } else {
                this.useLocalZeroPaddingNumberFormat = false;
            }
            if (!z2 && !this.numberFormatters.containsKey(strSubstring)) {
                this.numberFormatters.put(strSubstring, numberFormatCreateInstance);
            }
            i = iIndexOf + 1;
            z3 = z;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = this.serialVersionOnStream > 1 ? objectInputStream.readInt() : -1;
        if (this.serialVersionOnStream < 1) {
            this.defaultCenturyBase = System.currentTimeMillis();
        } else {
            parseAmbiguousDatesAsAfter(this.defaultCenturyStart);
        }
        this.serialVersionOnStream = 2;
        ULocale locale = getLocale(ULocale.VALID_LOCALE);
        this.locale = locale;
        if (locale == null) {
            this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        initLocalZeroPaddingNumberFormat();
        setContext(DisplayContext.CAPITALIZATION_NONE);
        if (i >= 0) {
            for (DisplayContext displayContext : DisplayContext.values()) {
                if (displayContext.value() == i) {
                    setContext(displayContext);
                    break;
                }
            }
        }
        if (!getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_PARTIAL_MATCH)) {
            setBooleanAttribute(DateFormat.BooleanAttribute.PARSE_PARTIAL_LITERAL_MATCH, false);
        }
        parsePattern();
    }

    private int regionMatchesWithOptionalDot(String str, int i, String str2, int i2) {
        if (str.regionMatches(true, i, str2, 0, i2)) {
            return i2;
        }
        if (str2.length() <= 0 || str2.charAt(str2.length() - 1) != '.') {
            return -1;
        }
        int i3 = i2 - 1;
        if (str.regionMatches(true, i, str2, 0, i3)) {
            return i3;
        }
        return -1;
    }

    private static void safeAppend(String[] strArr, int i, StringBuffer stringBuffer) {
        if (strArr == null || i < 0 || i >= strArr.length) {
            return;
        }
        stringBuffer.append(strArr[i]);
    }

    private static void safeAppendWithMonthPattern(String[] strArr, int i, StringBuffer stringBuffer, String str) {
        if (strArr == null || i < 0 || i >= strArr.length) {
            return;
        }
        if (str == null) {
            stringBuffer.append(strArr[i]);
        } else {
            stringBuffer.append(SimpleFormatterImpl.formatRawPattern(str, 1, 1, strArr[i]));
        }
    }

    /* JADX WARN: Code duplicated, block: B:431:0x0658  */
    /* JADX WARN: Code duplicated, block: B:433:0x0660  */
    /* JADX WARN: Code duplicated, block: B:435:0x0662  */
    /* JADX WARN: Code duplicated, block: B:436:0x066b  */
    /* JADX WARN: Code duplicated, block: B:445:0x0687  */
    /* JADX WARN: Code duplicated, block: B:447:0x068b  */
    /* JADX WARN: Code duplicated, block: B:448:0x0693  */
    /* JADX WARN: Code duplicated, block: B:451:0x069f  */
    @Deprecated
    private int subParse(String str, int i, char c, int i2, boolean z, boolean z2, boolean[] zArr, Calendar calendar, MessageFormat messageFormat, Output<TimeZoneFormat.TimeType> output, Output<DayPeriodRules.DayPeriod> output2) {
        boolean z3;
        Number number;
        boolean z4;
        ParsePosition parsePosition;
        Number number2;
        int iIntValue;
        int iMatchString;
        int i3;
        int iMatchString2;
        Calendar calendar2;
        int i4;
        int i5;
        int dayOfMonthName;
        int i6;
        int i7;
        int i8;
        int i9;
        int iMatchString3;
        DateFormat.BooleanAttribute booleanAttribute;
        String[] strArr;
        String[] strArr2;
        TimeZoneFormat.Style style;
        int i10;
        String[] strArr3;
        Calendar calendar3;
        int i11;
        int i12;
        Calendar calendar4;
        TimeZoneFormat.Style style2;
        int i13;
        String[] strArr4;
        TimeZoneFormat.Style style3;
        TimeZoneFormat.Style style4;
        ParsePosition parsePosition2;
        Number number3;
        SimpleDateFormat simpleDateFormat = this;
        int i14 = i2;
        Calendar calendar5 = calendar;
        MessageFormat messageFormat2 = messageFormat;
        int iMatchString4 = 0;
        ParsePosition parsePosition3 = new ParsePosition(0);
        int indexFromChar = getIndexFromChar(c);
        if (indexFromChar == -1) {
            return ~i;
        }
        NumberFormat numberFormat = simpleDateFormat.getNumberFormat(c);
        int i15 = PATTERN_INDEX_TO_CALENDAR_FIELD[indexFromChar];
        if (messageFormat2 != null) {
            messageFormat2.setFormatByArgumentIndex(0, numberFormat);
        }
        int i16 = 1;
        boolean z5 = calendar5.getType().equals("chinese") || calendar5.getType().equals("dangi");
        int charCount = i;
        while (charCount < str.length()) {
            int iCharAt = UTF16.charAt(str, charCount);
            if (!UCharacter.isUWhiteSpace(iCharAt) && !PatternProps.isWhiteSpace(iCharAt)) {
                parsePosition3.setIndex(charCount);
                if (indexFromChar == 4 || indexFromChar == 15 || ((indexFromChar == 2 && i14 <= 2) || indexFromChar == 26 || indexFromChar == 19 || indexFromChar == 25 || indexFromChar == 1 || indexFromChar == 18 || indexFromChar == 30 || ((indexFromChar == 0 && z5) || indexFromChar == 27 || indexFromChar == 28 || indexFromChar == 8))) {
                    if (messageFormat2 == null || !(indexFromChar == 2 || indexFromChar == 26)) {
                        z3 = false;
                        number = null;
                    } else {
                        Object[] objArr = messageFormat2.parse(str, parsePosition3);
                        if (objArr != null && parsePosition3.getIndex() > charCount) {
                            Object obj = objArr[0];
                            if (obj instanceof Number) {
                                number = (Number) obj;
                                calendar5.set(22, 1);
                                z3 = true;
                            }
                        }
                        parsePosition3.setIndex(charCount);
                        calendar5.set(22, 0);
                        z3 = false;
                        number = null;
                    }
                    if (z3) {
                        z4 = z2;
                        parsePosition = parsePosition3;
                    } else {
                        if (!z) {
                            z4 = z2;
                            parsePosition = parsePosition3;
                            number = simpleDateFormat.parseInt(str, parsePosition, z4, numberFormat);
                        } else {
                            if (charCount + i14 > str.length()) {
                                return ~charCount;
                            }
                            parsePosition = parsePosition3;
                            z4 = z2;
                            number = simpleDateFormat.parseInt(str, i14, parsePosition3, z2, numberFormat);
                        }
                        if (number == null && !simpleDateFormat.allowNumericFallback(indexFromChar)) {
                            return ~charCount;
                        }
                    }
                    if (number != null) {
                        iIntValue = number.intValue();
                        number2 = number;
                    } else {
                        number2 = number;
                        iIntValue = 0;
                    }
                } else {
                    z4 = z2;
                    parsePosition = parsePosition3;
                    iIntValue = 0;
                    number2 = null;
                }
                switch (indexFromChar) {
                    case 0:
                        int i17 = i14;
                        int i18 = charCount;
                        ParsePosition parsePosition4 = parsePosition;
                        if (z5) {
                            calendar.set(0, iIntValue);
                            return parsePosition4.getIndex();
                        }
                        if (i17 == 5) {
                            iMatchString = simpleDateFormat.matchString(str, i18, 0, simpleDateFormat.formatData.narrowEras, null, calendar);
                        } else {
                            DateFormatSymbols dateFormatSymbols = simpleDateFormat.formatData;
                            iMatchString = i17 == 4 ? simpleDateFormat.matchString(str, i18, 0, dateFormatSymbols.eraNames, null, calendar) : matchString(str, i18, 0, dateFormatSymbols.eras, null, calendar);
                        }
                        return iMatchString == (~i18) ? ISOSpecialEra : iMatchString;
                    case 1:
                    case 18:
                        int i19 = i14;
                        int i20 = charCount;
                        ParsePosition parsePosition5 = parsePosition;
                        String str2 = simpleDateFormat.override;
                        if (str2 != null && ((str2.compareTo("hebr") == 0 || simpleDateFormat.override.indexOf("y=hebr") >= 0) && iIntValue < 1000)) {
                            iIntValue += HEBREW_CAL_CUR_MILLENIUM_START_YEAR;
                        } else if (i19 == 2 && countDigits(str, i20, parsePosition5.getIndex()) == 2 && calendar.haveDefaultCentury()) {
                            int defaultCenturyStartYear = simpleDateFormat.getDefaultCenturyStartYear() % 100;
                            zArr[0] = iIntValue == defaultCenturyStartYear;
                            iIntValue += ((simpleDateFormat.getDefaultCenturyStartYear() / 100) * 100) + (iIntValue >= defaultCenturyStartYear ? 0 : 100);
                        }
                        calendar.set(i15, iIntValue);
                        if (DelayedHebrewMonthCheck) {
                            if (!HebrewCalendar.isLeapYear(iIntValue)) {
                                calendar.add(2, 1);
                            }
                            DelayedHebrewMonthCheck = false;
                        }
                        return parsePosition5.getIndex();
                    case 2:
                    case 26:
                        int i21 = i14;
                        int i22 = charCount;
                        ParsePosition parsePosition6 = parsePosition;
                        if (i21 <= 2 || (number2 != null && simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC))) {
                            calendar.set(2, iIntValue - 1);
                            if (calendar.getType().equals("hebrew") && iIntValue >= 6) {
                                if (!calendar.isSet(1)) {
                                    DelayedHebrewMonthCheck = true;
                                } else if (!HebrewCalendar.isLeapYear(calendar.get(1))) {
                                    calendar.set(2, iIntValue);
                                }
                            }
                            return parsePosition6.getIndex();
                        }
                        String[] strArr5 = simpleDateFormat.formatData.leapMonthPatterns;
                        boolean z6 = strArr5 != null && strArr5.length >= 7;
                        DateFormat.BooleanAttribute booleanAttribute2 = DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH;
                        if (!simpleDateFormat.getBooleanAttribute(booleanAttribute2) || i21 < 3 || i21 > 4 || z6) {
                            i3 = i22;
                            iMatchString2 = 0;
                        } else {
                            DateFormatSymbols dateFormatSymbols2 = simpleDateFormat.formatData;
                            if (indexFromChar == 2) {
                                String[] strArr6 = dateFormatSymbols2.months;
                                String[] strArr7 = dateFormatSymbols2.shortMonths;
                                i3 = i22;
                                iMatchString2 = simpleDateFormat.matchAlphaMonthStrings(str, i3, strArr6, strArr7, calendar);
                                simpleDateFormat = this;
                            } else {
                                String[] strArr8 = dateFormatSymbols2.standaloneMonths;
                                String[] strArr9 = dateFormatSymbols2.standaloneShortMonths;
                                i3 = i22;
                                simpleDateFormat = this;
                                iMatchString2 = simpleDateFormat.matchAlphaMonthStrings(str, i3, strArr8, strArr9, calendar);
                            }
                            if (iMatchString2 > 0) {
                                return iMatchString2;
                            }
                        }
                        if (simpleDateFormat.getBooleanAttribute(booleanAttribute2) || i21 == 4) {
                            DateFormatSymbols dateFormatSymbols3 = simpleDateFormat.formatData;
                            if (indexFromChar == 2) {
                                iMatchString2 = simpleDateFormat.matchString(str, i3, 2, dateFormatSymbols3.months, z6 ? dateFormatSymbols3.leapMonthPatterns[0] : null, calendar);
                                simpleDateFormat = this;
                            } else {
                                simpleDateFormat = this;
                                iMatchString2 = simpleDateFormat.matchString(str, i3, 2, dateFormatSymbols3.standaloneMonths, z6 ? dateFormatSymbols3.leapMonthPatterns[3] : null, calendar);
                            }
                            if (iMatchString2 > 0) {
                                return iMatchString2;
                            }
                        }
                        if (!simpleDateFormat.getBooleanAttribute(booleanAttribute2) && i21 != 3) {
                            return iMatchString2;
                        }
                        DateFormatSymbols dateFormatSymbols4 = simpleDateFormat.formatData;
                        if (indexFromChar == 2) {
                            return simpleDateFormat.matchString(str, i3, 2, dateFormatSymbols4.shortMonths, z6 ? dateFormatSymbols4.leapMonthPatterns[1] : null, calendar);
                        }
                        return matchString(str, i3, 2, dateFormatSymbols4.standaloneShortMonths, z6 ? dateFormatSymbols4.leapMonthPatterns[4] : null, calendar);
                    case 3:
                        calendar2 = calendar;
                        i4 = i14;
                        i5 = charCount;
                        if (i4 >= 3 && (dayOfMonthName = simpleDateFormat.parseDayOfMonthName(str, i5, calendar2)) > 0) {
                            return dayOfMonthName;
                        }
                        if (z) {
                            parsePosition2 = parsePosition;
                            number3 = simpleDateFormat.parseInt(str, parsePosition2, z2, numberFormat);
                        } else {
                            if (i5 + i4 > str.length()) {
                                return -i5;
                            }
                            parsePosition2 = parsePosition;
                            number3 = simpleDateFormat.parseInt(str, i4, parsePosition2, z2, numberFormat);
                        }
                        if (!z && !simpleDateFormat.isLenient() && parsePosition2.getIndex() < i5 + i4) {
                            return -i5;
                        }
                        if (number3 != null) {
                            return ~i5;
                        }
                        if (indexFromChar != 34) {
                            calendar2.set(i15, number3.intValue());
                        } else {
                            calendar2.setRelatedYear(number3.intValue());
                        }
                        return parsePosition2.getIndex();
                    case 4:
                        calendar.set(11, iIntValue != calendar.getMaximum(11) + 1 ? iIntValue : 0);
                        return parsePosition.getIndex();
                    case 5:
                    case 6:
                    case 7:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 16:
                    case 20:
                    case 21:
                    case 22:
                    case 34:
                    default:
                        calendar2 = calendar;
                        i4 = i14;
                        i5 = charCount;
                        if (z) {
                            parsePosition2 = parsePosition;
                            number3 = simpleDateFormat.parseInt(str, parsePosition2, z2, numberFormat);
                        } else {
                            if (i5 + i4 > str.length()) {
                                return -i5;
                            }
                            parsePosition2 = parsePosition;
                            number3 = simpleDateFormat.parseInt(str, i4, parsePosition2, z2, numberFormat);
                        }
                        if (!z) {
                            break;
                        }
                        if (number3 != null) {
                            return ~i5;
                        }
                        if (indexFromChar != 34) {
                            calendar2.set(i15, number3.intValue());
                        } else {
                            calendar2.setRelatedYear(number3.intValue());
                        }
                        return parsePosition2.getIndex();
                    case 8:
                        int iCountDigits = countDigits(str, charCount, parsePosition.getIndex());
                        if (iCountDigits < 3) {
                            while (iCountDigits < 3) {
                                iIntValue *= 10;
                                iCountDigits++;
                            }
                        } else {
                            while (iCountDigits > 3) {
                                i16 *= 10;
                                iCountDigits--;
                            }
                            iIntValue /= i16;
                        }
                        calendar.set(14, iIntValue);
                        return parsePosition.getIndex();
                    case 9:
                        i6 = i14;
                        i7 = charCount;
                        i8 = 6;
                        booleanAttribute = DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH;
                        if ((simpleDateFormat.getBooleanAttribute(booleanAttribute) && i6 != 4) || (iMatchString4 = simpleDateFormat.matchString(str, i7, 7, simpleDateFormat.formatData.weekdays, null, calendar)) <= 0) {
                            if ((simpleDateFormat.getBooleanAttribute(booleanAttribute) && i6 != 3) || (iMatchString4 = simpleDateFormat.matchString(str, i7, 7, simpleDateFormat.formatData.shortWeekdays, null, calendar)) <= 0) {
                                if ((simpleDateFormat.getBooleanAttribute(booleanAttribute) && i6 != i8) || (strArr = simpleDateFormat.formatData.shorterWeekdays) == null || (iMatchString4 = simpleDateFormat.matchString(str, i7, 7, strArr, null, calendar)) <= 0) {
                                    return ((!simpleDateFormat.getBooleanAttribute(booleanAttribute) || i6 == 5) && (strArr2 = simpleDateFormat.formatData.narrowWeekdays) != null) ? simpleDateFormat.matchString(str, i7, 7, strArr2, null, calendar) : iMatchString4;
                                }
                            }
                        }
                    case 14:
                        int i23 = i14;
                        int i24 = charCount;
                        if (simpleDateFormat.formatData.ampmsNarrow == null || i23 < 5 || simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH)) {
                            i9 = i24;
                            int iMatchString5 = simpleDateFormat.matchString(str, i9, 9, simpleDateFormat.formatData.ampms, null, calendar);
                            if (iMatchString5 > 0) {
                                return iMatchString5;
                            }
                        } else {
                            i9 = i24;
                        }
                        return (simpleDateFormat.formatData.ampmsNarrow == null || (i23 < 5 && !simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH)) || (iMatchString3 = simpleDateFormat.matchString(str, i9, 9, simpleDateFormat.formatData.ampmsNarrow, null, calendar)) <= 0) ? ~i9 : iMatchString3;
                    case 15:
                        calendar.set(10, iIntValue != calendar.getLeastMaximum(10) + 1 ? iIntValue : 0);
                        return parsePosition.getIndex();
                    case 17:
                        int i25 = charCount;
                        TimeZone timeZone = simpleDateFormat.tzFormat().parse(i14 < 4 ? TimeZoneFormat.Style.SPECIFIC_SHORT : TimeZoneFormat.Style.SPECIFIC_LONG, str, parsePosition, output);
                        if (timeZone == null) {
                            return ~i25;
                        }
                        calendar.setTimeZone(timeZone);
                        return parsePosition.getIndex();
                    case 19:
                        i6 = i14;
                        int i26 = charCount;
                        i8 = 6;
                        if (i6 <= 2 || (number2 != null && simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC))) {
                            calendar.set(i15, iIntValue);
                            return parsePosition.getIndex();
                        }
                        i7 = i26;
                        booleanAttribute = DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH;
                        return simpleDateFormat.getBooleanAttribute(booleanAttribute) ? iMatchString4 : iMatchString4;
                        return simpleDateFormat.getBooleanAttribute(booleanAttribute) ? iMatchString4 : iMatchString4;
                        return simpleDateFormat.getBooleanAttribute(booleanAttribute) ? iMatchString4 : iMatchString4;
                        if (simpleDateFormat.getBooleanAttribute(booleanAttribute)) {
                        }
                    case 23:
                        int i27 = i14;
                        int i28 = charCount;
                        if (i27 < 4) {
                            style = TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL;
                        } else {
                            style = i27 == 5 ? TimeZoneFormat.Style.ISO_EXTENDED_FULL : TimeZoneFormat.Style.LOCALIZED_GMT;
                        }
                        TimeZone timeZone2 = simpleDateFormat.tzFormat().parse(style, str, parsePosition, output);
                        if (timeZone2 == null) {
                            return ~i28;
                        }
                        calendar.setTimeZone(timeZone2);
                        return parsePosition.getIndex();
                    case 24:
                        int i29 = charCount;
                        TimeZone timeZone3 = simpleDateFormat.tzFormat().parse(i14 < 4 ? TimeZoneFormat.Style.GENERIC_SHORT : TimeZoneFormat.Style.GENERIC_LONG, str, parsePosition, output);
                        if (timeZone3 == null) {
                            return ~i29;
                        }
                        calendar.setTimeZone(timeZone3);
                        return parsePosition.getIndex();
                    case 25:
                        int i30 = i14;
                        int i31 = charCount;
                        if (i30 == 1 || (number2 != null && simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC))) {
                            calendar.set(i15, iIntValue);
                            return parsePosition.getIndex();
                        }
                        DateFormat.BooleanAttribute booleanAttribute3 = DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH;
                        if (simpleDateFormat.getBooleanAttribute(booleanAttribute3) || i30 == 4) {
                            i10 = 6;
                            iMatchString4 = simpleDateFormat.matchString(str, i31, 7, simpleDateFormat.formatData.standaloneWeekdays, null, calendar);
                            if (iMatchString4 > 0) {
                                return iMatchString4;
                            }
                        } else {
                            i10 = 6;
                        }
                        if ((simpleDateFormat.getBooleanAttribute(booleanAttribute3) || i30 == 3) && (iMatchString4 = simpleDateFormat.matchString(str, i31, 7, simpleDateFormat.formatData.standaloneShortWeekdays, null, calendar)) > 0) {
                            return iMatchString4;
                        }
                        return ((simpleDateFormat.getBooleanAttribute(booleanAttribute3) || i30 == i10) && (strArr3 = simpleDateFormat.formatData.standaloneShorterWeekdays) != null) ? simpleDateFormat.matchString(str, i31, 7, strArr3, null, calendar) : iMatchString4;
                    case 27:
                        int i32 = i14;
                        int i33 = charCount;
                        if (i32 <= 2 && number2 != null) {
                            calendar.set(2, (iIntValue - 1) * 3);
                            return parsePosition.getIndex();
                        }
                        DateFormat.BooleanAttribute booleanAttribute4 = DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH;
                        if ((simpleDateFormat.getBooleanAttribute(booleanAttribute4) || i32 == 4) && (iMatchString4 = simpleDateFormat.matchQuarterString(str, i33, 2, simpleDateFormat.formatData.quarters, calendar)) > 0) {
                            return iMatchString4;
                        }
                        if ((simpleDateFormat.getBooleanAttribute(booleanAttribute4) || i32 == 3) && (iMatchString4 = simpleDateFormat.matchQuarterString(str, i33, 2, simpleDateFormat.formatData.shortQuarters, calendar)) > 0) {
                            return iMatchString4;
                        }
                        if (simpleDateFormat.getBooleanAttribute(booleanAttribute4) || i32 == 5) {
                            iMatchString4 = simpleDateFormat.matchQuarterString(str, i33, 2, simpleDateFormat.formatData.narrowQuarters, calendar);
                            calendar3 = calendar;
                            if (iMatchString4 > 0) {
                                return iMatchString4;
                            }
                        } else {
                            calendar3 = calendar;
                        }
                        if (!simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC) || number2 == null) {
                            return iMatchString4;
                        }
                        calendar3.set(2, (iIntValue - 1) * 3);
                        return parsePosition.getIndex();
                    case 28:
                        int i34 = charCount;
                        int i35 = i14;
                        if (i35 <= 2 && number2 != null) {
                            calendar.set(2, (iIntValue - 1) * 3);
                            return parsePosition.getIndex();
                        }
                        DateFormat.BooleanAttribute booleanAttribute5 = DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH;
                        if (simpleDateFormat.getBooleanAttribute(booleanAttribute5) || i35 == 4) {
                            i11 = i34;
                            i12 = 5;
                            iMatchString4 = simpleDateFormat.matchQuarterString(str, i11, 2, simpleDateFormat.formatData.standaloneQuarters, calendar);
                            if (iMatchString4 > 0) {
                                return iMatchString4;
                            }
                        } else {
                            i11 = i34;
                            i12 = 5;
                        }
                        if ((simpleDateFormat.getBooleanAttribute(booleanAttribute5) || i35 == 3) && (iMatchString4 = simpleDateFormat.matchQuarterString(str, i11, 2, simpleDateFormat.formatData.standaloneShortQuarters, calendar)) > 0) {
                            return iMatchString4;
                        }
                        if (simpleDateFormat.getBooleanAttribute(booleanAttribute5) || i35 == i12) {
                            iMatchString4 = simpleDateFormat.matchQuarterString(str, i11, 2, simpleDateFormat.formatData.standaloneNarrowQuarters, calendar);
                            calendar4 = calendar;
                            if (iMatchString4 > 0) {
                                return iMatchString4;
                            }
                        } else {
                            calendar4 = calendar;
                        }
                        if (!simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC) || number2 == null) {
                            return iMatchString4;
                        }
                        calendar4.set(2, (iIntValue - 1) * 3);
                        return parsePosition.getIndex();
                    case 29:
                        int i36 = charCount;
                        int i37 = i14;
                        if (i37 == 1) {
                            style2 = TimeZoneFormat.Style.ZONE_ID_SHORT;
                        } else if (i37 != 2) {
                            style2 = i37 != 3 ? TimeZoneFormat.Style.GENERIC_LOCATION : TimeZoneFormat.Style.EXEMPLAR_LOCATION;
                        } else {
                            style2 = TimeZoneFormat.Style.ZONE_ID;
                        }
                        TimeZone timeZone4 = simpleDateFormat.tzFormat().parse(style2, str, parsePosition, output);
                        if (timeZone4 == null) {
                            return ~i36;
                        }
                        calendar.setTimeZone(timeZone4);
                        return parsePosition.getIndex();
                    case 30:
                        int i38 = charCount;
                        String[] strArr10 = simpleDateFormat.formatData.shortYearNames;
                        if (strArr10 != null) {
                            int iMatchString6 = simpleDateFormat.matchString(str, i38, 1, strArr10, null, calendar);
                            i13 = i38;
                            if (iMatchString6 > 0) {
                                return iMatchString6;
                            }
                        } else {
                            i13 = i38;
                        }
                        if (number2 == null || !(simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC) || (strArr4 = simpleDateFormat.formatData.shortYearNames) == null || iIntValue > strArr4.length)) {
                            return ~i13;
                        }
                        calendar.set(1, iIntValue);
                        return parsePosition.getIndex();
                    case 31:
                        int i39 = charCount;
                        TimeZone timeZone5 = simpleDateFormat.tzFormat().parse(i14 < 4 ? TimeZoneFormat.Style.LOCALIZED_GMT_SHORT : TimeZoneFormat.Style.LOCALIZED_GMT, str, parsePosition, output);
                        if (timeZone5 == null) {
                            return ~i39;
                        }
                        calendar.setTimeZone(timeZone5);
                        return parsePosition.getIndex();
                    case 32:
                        int i40 = i14;
                        int i41 = charCount;
                        if (i40 == 1) {
                            style3 = TimeZoneFormat.Style.ISO_BASIC_SHORT;
                        } else if (i40 == 2) {
                            style3 = TimeZoneFormat.Style.ISO_BASIC_FIXED;
                        } else if (i40 != 3) {
                            style3 = i40 != 4 ? TimeZoneFormat.Style.ISO_EXTENDED_FULL : TimeZoneFormat.Style.ISO_BASIC_FULL;
                        } else {
                            style3 = TimeZoneFormat.Style.ISO_EXTENDED_FIXED;
                        }
                        TimeZone timeZone6 = simpleDateFormat.tzFormat().parse(style3, str, parsePosition, output);
                        if (timeZone6 == null) {
                            return ~i41;
                        }
                        calendar.setTimeZone(timeZone6);
                        return parsePosition.getIndex();
                    case 33:
                        int i42 = i14;
                        int i43 = charCount;
                        if (i42 == 1) {
                            style4 = TimeZoneFormat.Style.ISO_BASIC_LOCAL_SHORT;
                        } else if (i42 == 2) {
                            style4 = TimeZoneFormat.Style.ISO_BASIC_LOCAL_FIXED;
                        } else if (i42 != 3) {
                            style4 = i42 != 4 ? TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FULL : TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL;
                        } else {
                            style4 = TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FIXED;
                        }
                        TimeZone timeZone7 = simpleDateFormat.tzFormat().parse(style4, str, parsePosition, output);
                        if (timeZone7 == null) {
                            return ~i43;
                        }
                        calendar.setTimeZone(timeZone7);
                        return parsePosition.getIndex();
                    case 35:
                        int i44 = charCount;
                        int i45 = i14;
                        int iSubParse = subParse(str, i44, 'a', i45, z, z4, zArr, calendar, messageFormat2, output, output2);
                        if (iSubParse > 0) {
                            return iSubParse;
                        }
                        DateFormat.BooleanAttribute booleanAttribute6 = DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH;
                        if ((getBooleanAttribute(booleanAttribute6) || i45 == 3) && (iMatchString4 = matchDayPeriodString(str, i44, this.formatData.abbreviatedDayPeriods, 2, output2)) > 0) {
                            return iMatchString4;
                        }
                        if ((getBooleanAttribute(booleanAttribute6) || i45 == 4) && (iMatchString4 = matchDayPeriodString(str, i44, this.formatData.wideDayPeriods, 2, output2)) > 0) {
                            return iMatchString4;
                        }
                        return (getBooleanAttribute(booleanAttribute6) || i45 == 4) ? matchDayPeriodString(str, i44, this.formatData.narrowDayPeriods, 2, output2) : iMatchString4;
                    case 36:
                        int i46 = charCount;
                        DateFormat.BooleanAttribute booleanAttribute7 = DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH;
                        if (simpleDateFormat.getBooleanAttribute(booleanAttribute7) || i14 == 3) {
                            String[] strArr11 = simpleDateFormat.formatData.abbreviatedDayPeriods;
                            iMatchString4 = simpleDateFormat.matchDayPeriodString(str, i46, strArr11, strArr11.length, output2);
                            if (iMatchString4 > 0) {
                                return iMatchString4;
                            }
                        }
                        if (simpleDateFormat.getBooleanAttribute(booleanAttribute7) || i14 == 4) {
                            String[] strArr12 = simpleDateFormat.formatData.wideDayPeriods;
                            iMatchString4 = simpleDateFormat.matchDayPeriodString(str, i46, strArr12, strArr12.length, output2);
                            if (iMatchString4 > 0) {
                                return iMatchString4;
                            }
                        }
                        if (!simpleDateFormat.getBooleanAttribute(booleanAttribute7) && i14 != 4) {
                            return iMatchString4;
                        }
                        String[] strArr13 = simpleDateFormat.formatData.narrowDayPeriods;
                        return simpleDateFormat.matchDayPeriodString(str, i46, strArr13, strArr13.length, output2);
                    case 37:
                        ArrayList arrayList = new ArrayList(3);
                        arrayList.add(simpleDateFormat.formatData.getTimeSeparatorString());
                        if (!simpleDateFormat.formatData.getTimeSeparatorString().equals(":")) {
                            arrayList.add(":");
                        }
                        if (simpleDateFormat.getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_PARTIAL_LITERAL_MATCH) && !simpleDateFormat.formatData.getTimeSeparatorString().equals(".")) {
                            arrayList.add(".");
                        }
                        return simpleDateFormat.matchString(str, charCount, -1, (String[]) arrayList.toArray(new String[0]), calendar);
                }
            }
            calendar5 = calendar;
            i14 = i14;
            numberFormat = numberFormat;
            messageFormat2 = messageFormat;
            charCount = UTF16.getCharCount(iCharAt) + charCount;
            simpleDateFormat = this;
        }
        return ~charCount;
    }

    private String translatePattern(String str, String str2, String str3) {
        int iIndexOf;
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (z) {
                if (cCharAt == '\'') {
                    z = false;
                }
            } else if (cCharAt == '\'') {
                z = true;
            } else if (isSyntaxChar(cCharAt) && (iIndexOf = str2.indexOf(cCharAt)) != -1) {
                cCharAt = str3.charAt(iIndexOf);
            }
            sb.append(cCharAt);
        }
        if (!z) {
            return sb.toString();
        }
        og.i("Unfinished quote in pattern");
        return null;
    }

    private TimeZoneFormat tzFormat() {
        if (this.tzFormat == null) {
            initializeTimeZoneFormat(false);
        }
        return this.tzFormat;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.defaultCenturyStart == null) {
            initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        initializeTimeZoneFormat(false);
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(getContext(DisplayContext.Type.CAPITALIZATION).value());
    }

    public void applyLocalizedPattern(String str) {
        this.pattern = translatePattern(str, this.formatData.localPatternChars, "GyMdkHmsSEDFwWahKzYeugAZvcLQqVUOXxrbB");
        setLocale(null, null);
    }

    public void applyPattern(String str) {
        ULocale uLocale;
        this.pattern = str;
        parsePattern();
        setLocale(null, null);
        this.patternItems = null;
        Calendar calendar = this.calendar;
        if (calendar == null || !calendar.getType().equals("japanese") || (uLocale = this.locale) == null || !uLocale.getLanguage().equals("ja")) {
            return;
        }
        String str2 = this.override;
        if (str2 != null && str2.equals("y=jpanyear") && !this.hasHanYearChar) {
            this.numberFormatters = null;
            this.overrideMap = null;
            this.override = null;
        } else if (this.override == null && this.hasHanYearChar) {
            this.numberFormatters = new HashMap<>();
            HashMap<Character, String> map = new HashMap<>();
            this.overrideMap = map;
            map.put('y', "jpanyear");
            NumberFormat numberFormatCreateInstance = NumberFormat.createInstance(new ULocale(ky0.j(this.locale.getBaseName(), "@numbers=jpanyear")), 0);
            numberFormatCreateInstance.setGroupingUsed(false);
            this.useLocalZeroPaddingNumberFormat = false;
            this.numberFormatters.put("jpanyear", numberFormatCreateInstance);
            this.override = "y=jpanyear";
        }
    }

    @Override // com.ibm.icu.text.DateFormat, java.text.Format
    public SimpleDateFormat clone() {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) super.clone();
        simpleDateFormat.formatData = this.formatData.m14clone();
        if (this.decimalBuf != null) {
            simpleDateFormat.decimalBuf = new char[10];
        }
        return simpleDateFormat;
    }

    @Override // com.ibm.icu.text.DateFormat
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) obj;
        return this.pattern.equals(simpleDateFormat.pattern) && this.formatData.equals(simpleDateFormat.formatData);
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        Calendar calendarMonthToCalendar = this.calendar;
        if (obj instanceof Calendar) {
            calendarMonthToCalendar = (Calendar) obj;
        } else if (obj instanceof java.util.Calendar) {
            this.calendar = JavaTimeConverters.convertCalendar((java.util.Calendar) obj);
        } else if (obj instanceof Date) {
            calendarMonthToCalendar.setTime((Date) obj);
        } else if (obj instanceof Number) {
            calendarMonthToCalendar.setTimeInMillis(((Number) obj).longValue());
        } else if (obj instanceof Temporal) {
            calendarMonthToCalendar = JavaTimeConverters.temporalToCalendar((Temporal) obj);
        } else if (obj instanceof DayOfWeek) {
            calendarMonthToCalendar = JavaTimeConverters.dayOfWeekToCalendar((DayOfWeek) obj);
        } else {
            if (!(obj instanceof Month)) {
                og.i("Cannot format given Object as a Date");
                return null;
            }
            calendarMonthToCalendar = JavaTimeConverters.monthToCalendar((Month) obj);
        }
        Calendar calendar = calendarMonthToCalendar;
        StringBuffer stringBuffer = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(0);
        ArrayList arrayList = new ArrayList();
        format(calendar, getContext(DisplayContext.Type.CAPITALIZATION), stringBuffer, fieldPosition, arrayList);
        AttributedString attributedString = new AttributedString(stringBuffer.toString());
        for (int i = 0; i < arrayList.size(); i++) {
            FieldPosition fieldPosition2 = (FieldPosition) arrayList.get(i);
            Format.Field fieldAttribute = fieldPosition2.getFieldAttribute();
            attributedString.addAttribute(fieldAttribute, fieldAttribute, fieldPosition2.getBeginIndex(), fieldPosition2.getEndIndex());
        }
        return attributedString.getIterator();
    }

    public Date get2DigitYearStart() {
        return getDefaultCenturyStart();
    }

    public DateFormatSymbols getDateFormatSymbols() {
        return this.formatData.m14clone();
    }

    public ULocale getLocale() {
        return this.locale;
    }

    public NumberFormat getNumberFormat(char c) {
        Character chValueOf = Character.valueOf(c);
        HashMap<Character, String> map = this.overrideMap;
        if (map == null || !map.containsKey(chValueOf)) {
            return this.numberFormat;
        }
        return this.numberFormatters.get(this.overrideMap.get(chValueOf).toString());
    }

    public DateFormatSymbols getSymbols() {
        return this.formatData;
    }

    public TimeZoneFormat getTimeZoneFormat() {
        return tzFormat().freeze();
    }

    @Override // com.ibm.icu.text.DateFormat
    public int hashCode() {
        return this.pattern.hashCode();
    }

    @Deprecated
    public final StringBuffer intervalFormatByAlgorithm(Calendar calendar, Calendar calendar2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int i;
        int i2;
        int i3;
        StringBuffer stringBuffer2;
        DisplayContext displayContext;
        int i4;
        SimpleDateFormat simpleDateFormat = this;
        Calendar calendar3 = calendar2;
        StringBuffer stringBuffer3 = stringBuffer;
        if (!calendar.isEquivalentTo(calendar2)) {
            og.i("can not format on two different calendars");
            return null;
        }
        Object[] patternItems = simpleDateFormat.getPatternItems();
        int i5 = 0;
        while (true) {
            try {
                if (i5 >= patternItems.length) {
                    i5 = -1;
                    break;
                }
                if (simpleDateFormat.diffCalFieldValue(calendar, calendar3, patternItems, i5)) {
                    break;
                }
                i5++;
            } catch (IllegalArgumentException e) {
                og.g(e);
                return null;
            }
        }
        if (i5 == -1) {
            return simpleDateFormat.format(calendar, stringBuffer3, fieldPosition);
        }
        int length = patternItems.length - 1;
        while (true) {
            if (length < i5) {
                length = -1;
                break;
            }
            if (simpleDateFormat.diffCalFieldValue(calendar, calendar3, patternItems, length)) {
                break;
            }
            length--;
        }
        if (i5 == 0 && length == patternItems.length - 1) {
            simpleDateFormat.format(calendar, stringBuffer3, fieldPosition);
            stringBuffer3.append(" – ");
            simpleDateFormat.format(calendar3, stringBuffer3, fieldPosition);
            return stringBuffer3;
        }
        int i6 = 1000;
        for (int i7 = i5; i7 <= length; i7++) {
            Object obj = patternItems[i7];
            if (!(obj instanceof String)) {
                char c = ((PatternItem) obj).type;
                int indexFromChar = getIndexFromChar(c);
                if (indexFromChar == -1) {
                    kf2.c(c, simpleDateFormat.pattern);
                    return null;
                }
                if (indexFromChar < i6) {
                    i6 = indexFromChar;
                }
            }
        }
        int i8 = 0;
        while (true) {
            if (i8 >= i5) {
                i = i5;
                break;
            }
            try {
                if (simpleDateFormat.lowerLevel(patternItems, i8, i6)) {
                    i = i8;
                    break;
                }
                i8++;
            } catch (IllegalArgumentException e2) {
                og.g(e2);
                return null;
            }
        }
        int length2 = patternItems.length - 1;
        while (true) {
            if (length2 <= length) {
                i2 = length;
                break;
            }
            if (simpleDateFormat.lowerLevel(patternItems, length2, i6)) {
                i2 = length2;
                break;
            }
            length2--;
        }
        if (i == 0 && i2 == patternItems.length - 1) {
            simpleDateFormat.format(calendar, stringBuffer3, fieldPosition);
            stringBuffer3.append(" – ");
            simpleDateFormat.format(calendar3, stringBuffer3, fieldPosition);
            return stringBuffer3;
        }
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        DisplayContext context = simpleDateFormat.getContext(DisplayContext.Type.CAPITALIZATION);
        int i9 = 0;
        while (i9 <= i2) {
            Object obj2 = patternItems[i9];
            if (obj2 instanceof String) {
                stringBuffer3.append((String) obj2);
                stringBuffer2 = stringBuffer3;
                displayContext = context;
                i4 = i9;
            } else {
                PatternItem patternItem = (PatternItem) obj2;
                if (simpleDateFormat.useFastFormat) {
                    displayContext = context;
                    i4 = i9;
                    simpleDateFormat.subFormat(stringBuffer3, patternItem.type, patternItem.length, stringBuffer3.length(), i4, displayContext, fieldPosition, patternItem.type, calendar);
                    stringBuffer2 = stringBuffer3;
                    simpleDateFormat = this;
                } else {
                    stringBuffer2 = stringBuffer3;
                    DisplayContext displayContext2 = context;
                    simpleDateFormat = this;
                    String strSubFormat = simpleDateFormat.subFormat(patternItem.type, patternItem.length, stringBuffer2.length(), i9, displayContext2, fieldPosition, patternItem.type, calendar);
                    displayContext = displayContext2;
                    i4 = i9;
                    stringBuffer2.append(strSubFormat);
                }
            }
            i9 = i4 + 1;
            context = displayContext;
            stringBuffer3 = stringBuffer2;
        }
        StringBuffer stringBuffer4 = stringBuffer3;
        DisplayContext displayContext3 = context;
        stringBuffer4.append(" – ");
        int i10 = i;
        while (i10 < patternItems.length) {
            Object obj3 = patternItems[i10];
            if (obj3 instanceof String) {
                stringBuffer4.append((String) obj3);
                i3 = i10;
            } else {
                PatternItem patternItem2 = (PatternItem) obj3;
                if (simpleDateFormat.useFastFormat) {
                    char c2 = patternItem2.type;
                    int i11 = patternItem2.length;
                    i3 = i10;
                    int length3 = stringBuffer4.length();
                    char c3 = patternItem2.type;
                    StringBuffer stringBuffer5 = stringBuffer4;
                    simpleDateFormat.subFormat(stringBuffer5, c2, i11, length3, i3, displayContext3, fieldPosition, c3, calendar3);
                    stringBuffer4 = stringBuffer5;
                } else {
                    DisplayContext displayContext4 = displayContext3;
                    String strSubFormat2 = subFormat(patternItem2.type, patternItem2.length, stringBuffer4.length(), i10, displayContext4, fieldPosition, patternItem2.type, calendar2);
                    displayContext3 = displayContext4;
                    i3 = i10;
                    stringBuffer4.append(strSubFormat2);
                }
            }
            i10 = i3 + 1;
            simpleDateFormat = this;
            calendar3 = calendar2;
        }
        return stringBuffer4;
    }

    public int matchQuarterString(String str, int i, int i2, String[] strArr, Calendar calendar) {
        int iRegionMatchesWithOptionalDot;
        int length = strArr.length;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int length2 = strArr[i5].length();
            if (length2 > i4 && (iRegionMatchesWithOptionalDot = regionMatchesWithOptionalDot(str, i, strArr[i5], length2)) >= 0) {
                i3 = i5;
                i4 = iRegionMatchesWithOptionalDot;
            }
        }
        if (i3 < 0) {
            return -i;
        }
        calendar.set(i2, i3 * 3);
        return i + i4;
    }

    /* JADX WARN: Code duplicated, block: B:204:0x0398  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac  */
    @Override // com.ibm.icu.text.DateFormat
    public void parse(String str, Calendar calendar, ParsePosition parsePosition) {
        Calendar calendar2;
        Calendar calendar3;
        TimeZone timeZone;
        char c;
        int dSTSavings;
        TimeZoneTransition previousTransition;
        TimeZoneTransition nextTransition;
        int i;
        Object[] objArr;
        int i2;
        Calendar calendar4;
        int i3;
        Output<DayPeriodRules.DayPeriod> output;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (calendar == this.calendar || calendar.getType().equals(this.calendar.getType())) {
            calendar2 = calendar;
            calendar3 = null;
            timeZone = null;
        } else {
            this.calendar.setTimeInMillis(calendar.getTimeInMillis());
            TimeZone timeZone2 = this.calendar.getTimeZone();
            this.calendar.setTimeZone(calendar.getTimeZone());
            timeZone = timeZone2;
            calendar3 = calendar;
            calendar2 = this.calendar;
        }
        int index = parsePosition.getIndex();
        if (index < 0) {
            parsePosition.setErrorIndex(0);
            return;
        }
        Output<DayPeriodRules.DayPeriod> output2 = new Output<>(null);
        Output<TimeZoneFormat.TimeType> output3 = new Output<>(TimeZoneFormat.TimeType.UNKNOWN);
        boolean[] zArr = {false};
        String[] strArr = this.formatData.leapMonthPatterns;
        MessageFormat messageFormat = (strArr == null || strArr.length < 7) ? null : new MessageFormat(this.formatData.leapMonthPatterns[6], this.locale);
        Object[] patternItems = getPatternItems();
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        Output<DayPeriodRules.DayPeriod> output4 = output2;
        int i14 = -1;
        int iMatchLiteral = index;
        while (i11 < patternItems.length) {
            Object obj = patternItems[i11];
            if (obj instanceof PatternItem) {
                PatternItem patternItem = (PatternItem) obj;
                if (patternItem.isNumeric && i14 == i10 && (i9 = i11 + 1) < patternItems.length) {
                    Object obj2 = patternItems[i9];
                    if ((obj2 instanceof PatternItem) && ((PatternItem) obj2).isNumeric) {
                        i12 = patternItem.length;
                        i13 = iMatchLiteral;
                        i5 = i11;
                    } else {
                        i5 = i14;
                    }
                } else {
                    i5 = i14;
                }
                if (i5 != -1) {
                    int i15 = patternItem.length;
                    if (i5 == i11) {
                        i15 = i12;
                    }
                    i6 = i11;
                    i7 = i5;
                    calendar4 = calendar3;
                    objArr = patternItems;
                    i2 = -1;
                    iMatchLiteral = subParse(str, iMatchLiteral, patternItem.type, i15, true, false, zArr, calendar2, messageFormat, output3);
                    if (iMatchLiteral < 0) {
                        i12--;
                        if (i12 == 0) {
                            parsePosition.setIndex(index);
                            parsePosition.setErrorIndex(iMatchLiteral);
                            if (timeZone != null) {
                                this.calendar.setTimeZone(timeZone);
                                return;
                            }
                            return;
                        }
                        patternItems = objArr;
                        iMatchLiteral = i13;
                        calendar3 = calendar4;
                        i10 = -1;
                        i14 = i7;
                        i11 = i14;
                    }
                } else {
                    i2 = -1;
                    i6 = i11;
                    i7 = i5;
                    calendar4 = calendar3;
                    objArr = patternItems;
                    char c2 = patternItem.type;
                    if (c2 != 'l') {
                        i3 = index;
                        output = output4;
                        int iSubParse = subParse(str, iMatchLiteral, c2, patternItem.length, false, true, zArr, calendar2, messageFormat, output3, output);
                        if (iSubParse >= 0) {
                            iMatchLiteral = iSubParse;
                        } else {
                            if (iSubParse != ISOSpecialEra) {
                                parsePosition.setIndex(i3);
                                parsePosition.setErrorIndex(iMatchLiteral);
                                if (timeZone != null) {
                                    this.calendar.setTimeZone(timeZone);
                                    return;
                                }
                                return;
                            }
                            i4 = i6 + 1;
                            if (i4 < objArr.length) {
                                try {
                                    Object obj3 = objArr[i4];
                                    String str2 = (String) obj3;
                                    if (str2 == null) {
                                        str2 = (String) obj3;
                                    }
                                    int length = str2.length();
                                    int i16 = 0;
                                    while (i16 < length) {
                                        char cCharAt = str2.charAt(i16);
                                        if (!PatternProps.isWhiteSpace(cCharAt) && !UCharacter.isUWhiteSpace(cCharAt)) {
                                            break;
                                        } else {
                                            i16++;
                                        }
                                    }
                                    if (i16 != length) {
                                        i4 = i6;
                                    }
                                    i8 = -1;
                                } catch (ClassCastException unused) {
                                    parsePosition.setIndex(i3);
                                    parsePosition.setErrorIndex(iMatchLiteral);
                                    if (timeZone != null) {
                                        this.calendar.setTimeZone(timeZone);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        i8 = -1;
                        i4 = i6;
                    }
                    i14 = i8;
                }
                i3 = index;
                output = output4;
                i4 = i6;
                i8 = i7;
                i14 = i8;
            } else {
                objArr = patternItems;
                i2 = i10;
                int i17 = i11;
                calendar4 = calendar3;
                i3 = index;
                output = output4;
                boolean[] zArr2 = new boolean[1];
                iMatchLiteral = matchLiteral(str, iMatchLiteral, objArr, i17, zArr2);
                if (!zArr2[0]) {
                    parsePosition.setIndex(i3);
                    parsePosition.setErrorIndex(iMatchLiteral);
                    if (timeZone != null) {
                        this.calendar.setTimeZone(timeZone);
                        return;
                    }
                    return;
                }
                i14 = i2;
                i4 = i17;
            }
            i11 = i4 + 1;
            output4 = output;
            patternItems = objArr;
            index = i3;
            calendar3 = calendar4;
            i10 = i2;
        }
        Object[] objArr2 = patternItems;
        Calendar calendar5 = calendar3;
        int i18 = index;
        Output<DayPeriodRules.DayPeriod> output5 = output4;
        if (iMatchLiteral < str.length() && str.charAt(iMatchLiteral) == '.' && getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_WHITESPACE) && objArr2.length != 0) {
            Object obj4 = objArr2[objArr2.length - 1];
            if ((obj4 instanceof PatternItem) && !((PatternItem) obj4).isNumeric) {
                iMatchLiteral++;
            }
        }
        if (output5.value != null) {
            DayPeriodRules dayPeriodRules = DayPeriodRules.getInstance(getLocale());
            if (calendar2.isSet(10) || calendar2.isSet(11)) {
                if (calendar2.isSet(11)) {
                    i = calendar2.get(11);
                } else {
                    i = calendar2.get(10);
                    if (i == 0) {
                        i = 12;
                    }
                }
                if (i == 0 || (13 <= i && i <= 23)) {
                    calendar2.set(11, i);
                } else {
                    if (i == 12) {
                        i = 0;
                    }
                    double midPointForDayPeriod = ((((double) calendar2.get(12)) / 60.0d) + ((double) i)) - dayPeriodRules.getMidPointForDayPeriod(output5.value);
                    if (-6.0d > midPointForDayPeriod || midPointForDayPeriod >= 6.0d) {
                        calendar2.set(9, 1);
                    } else {
                        calendar2.set(9, 0);
                    }
                }
            } else {
                double midPointForDayPeriod2 = dayPeriodRules.getMidPointForDayPeriod(output5.value);
                int i19 = (int) midPointForDayPeriod2;
                int i20 = midPointForDayPeriod2 - ((double) i19) > 0.0d ? 30 : 0;
                calendar2.set(11, i19);
                calendar2.set(12, i20);
            }
        }
        parsePosition.setIndex(iMatchLiteral);
        try {
            TimeZoneFormat.TimeType timeType = output3.value;
            boolean z = zArr[0];
            if (z || timeType != TimeZoneFormat.TimeType.UNKNOWN) {
                if (z && calendar2.mo22clone().getTime().before(getDefaultCenturyStart())) {
                    calendar2.set(1, getDefaultCenturyStartYear() + 100);
                }
                if (timeType != TimeZoneFormat.TimeType.UNKNOWN) {
                    Calendar calendarMo22clone = calendar2.mo22clone();
                    TimeZone timeZone3 = calendarMo22clone.getTimeZone();
                    BasicTimeZone basicTimeZone = timeZone3 instanceof BasicTimeZone ? (BasicTimeZone) timeZone3 : null;
                    calendarMo22clone.set(15, 0);
                    calendarMo22clone.set(16, 0);
                    long timeInMillis = calendarMo22clone.getTimeInMillis();
                    int[] iArr = new int[2];
                    if (basicTimeZone != null) {
                        if (timeType == TimeZoneFormat.TimeType.STANDARD) {
                            basicTimeZone.getOffsetFromLocal(timeInMillis, BasicTimeZone.LocalOption.STANDARD_FORMER, BasicTimeZone.LocalOption.STANDARD_LATTER, iArr);
                            iArr = iArr;
                        } else {
                            basicTimeZone.getOffsetFromLocal(timeInMillis, BasicTimeZone.LocalOption.DAYLIGHT_FORMER, BasicTimeZone.LocalOption.DAYLIGHT_LATTER, iArr);
                            iArr = iArr;
                        }
                        c = 1;
                    } else {
                        basicTimeZone = basicTimeZone;
                        timeInMillis = timeInMillis;
                        c = 1;
                        timeZone3.getOffset(timeInMillis, true, iArr);
                        if ((timeType != TimeZoneFormat.TimeType.STANDARD || iArr[1] == 0) && !(timeType == TimeZoneFormat.TimeType.DAYLIGHT && iArr[1] == 0)) {
                            calendar2 = calendar2;
                        } else {
                            calendar2 = calendar2;
                            timeZone3.getOffset(timeInMillis - CalendarAstronomer.DAY_MS, true, iArr);
                        }
                    }
                    int dSTSavings2 = iArr[c];
                    if (timeType == TimeZoneFormat.TimeType.STANDARD) {
                        if (dSTSavings2 != 0) {
                            dSTSavings = 0;
                        } else {
                            dSTSavings = dSTSavings2;
                        }
                    } else if (dSTSavings2 == 0) {
                        if (basicTimeZone != null) {
                            long j = timeInMillis + ((long) iArr[0]);
                            long j2 = j + MAX_DAYLIGHT_DETECTION_RANGE;
                            long time = j;
                            for (boolean z2 = false; time < j2 && (nextTransition = basicTimeZone.getNextTransition(time, z2)) != null && (dSTSavings2 = nextTransition.getTo().getDSTSavings()) == 0; z2 = false) {
                                time = nextTransition.getTime();
                            }
                            if (dSTSavings2 == 0) {
                                long j3 = j - MAX_DAYLIGHT_DETECTION_RANGE;
                                long time2 = j;
                                while (time2 > j3 && (previousTransition = basicTimeZone.getPreviousTransition(time2, true)) != null && (dSTSavings2 = previousTransition.getFrom().getDSTSavings()) == 0) {
                                    time2 = previousTransition.getTime() - 1;
                                }
                                if (dSTSavings2 == 0) {
                                    dSTSavings2 = basicTimeZone.getDSTSavings();
                                }
                            }
                            dSTSavings = dSTSavings2;
                        } else {
                            dSTSavings = timeZone3.getDSTSavings();
                        }
                        if (dSTSavings == 0) {
                            dSTSavings = 3600000;
                        }
                    } else {
                        dSTSavings = dSTSavings2;
                    }
                    calendar2 = calendar2;
                    calendar2.set(15, iArr[0]);
                    calendar2.set(16, dSTSavings);
                }
            }
            if (calendar5 != null) {
                calendar5.setTimeZone(calendar2.getTimeZone());
                calendar5.setTimeInMillis(calendar2.getTimeInMillis());
            }
            if (timeZone != null) {
                this.calendar.setTimeZone(timeZone);
            }
        } catch (IllegalArgumentException unused2) {
            parsePosition.setErrorIndex(iMatchLiteral);
            parsePosition.setIndex(i18);
            if (timeZone != null) {
                this.calendar.setTimeZone(timeZone);
            }
        }
    }

    public DateFormat.Field patternCharToDateFormatField(char c) {
        int indexFromChar = getIndexFromChar(c);
        if (indexFromChar != -1) {
            return PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar];
        }
        return null;
    }

    public void set2DigitYearStart(Date date) {
        parseAmbiguousDatesAsAfter(date);
    }

    @Override // com.ibm.icu.text.DateFormat
    public void setContext(DisplayContext displayContext) {
        super.setContext(displayContext);
        if (this.capitalizationBrkIter == null) {
            if (displayContext == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE || displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU || displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE) {
                this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.locale);
            }
        }
    }

    public void setDateFormatSymbols(DateFormatSymbols dateFormatSymbols) {
        this.formatData = dateFormatSymbols.m14clone();
    }

    public void setNumberFormat(String str, NumberFormat numberFormat) {
        numberFormat.setGroupingUsed(false);
        String strJ = cq.j("$", UUID.randomUUID().toString());
        if (this.numberFormatters == null) {
            this.numberFormatters = new HashMap<>();
        }
        if (this.overrideMap == null) {
            this.overrideMap = new HashMap<>();
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ("GyMdkHmsSEDFwWahKzYeugAZvcLQqVUOXxrbB".indexOf(cCharAt) == -1) {
                throw new IllegalArgumentException("Illegal field character '" + cCharAt + "' in setNumberFormat.");
            }
            this.overrideMap.put(Character.valueOf(cCharAt), strJ);
            this.numberFormatters.put(strJ, numberFormat);
        }
        this.useLocalZeroPaddingNumberFormat = false;
    }

    public void setTimeZoneFormat(TimeZoneFormat timeZoneFormat) {
        if (timeZoneFormat.isFrozen()) {
            this.tzFormat = timeZoneFormat;
        } else {
            this.tzFormat = timeZoneFormat.cloneAsThawed().freeze();
        }
    }

    /* JADX WARN: Code duplicated, block: B:228:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:230:0x04f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:231:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:232:0x0501  */
    /* JADX WARN: Code duplicated, block: B:237:0x0510  */
    /* JADX WARN: Code duplicated, block: B:331:0x06d5  */
    /* JADX WARN: Code duplicated, block: B:332:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:346:0x073c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:353:0x0759  */
    /* JADX WARN: Code duplicated, block: B:355:0x075c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:357:0x0761  */
    /* JADX WARN: Code duplicated, block: B:361:0x0771  */
    /* JADX WARN: Code duplicated, block: B:362:0x0776  */
    /* JADX WARN: Code duplicated, block: B:364:0x077d  */
    /* JADX WARN: Code duplicated, block: B:366:0x0783  */
    /* JADX WARN: Code duplicated, block: B:368:0x0787  */
    /* JADX WARN: Code duplicated, block: B:372:0x07b6  */
    /* JADX WARN: Code duplicated, block: B:374:0x07c0  */
    /* JADX WARN: Code duplicated, block: B:376:0x07cd  */
    /* JADX WARN: Code duplicated, block: B:378:0x07d7  */
    @Deprecated
    public void subFormat(StringBuffer stringBuffer, char c, int i, int i2, int i3, DisplayContext displayContext, FieldPosition fieldPosition, char c2, Calendar calendar) {
        StringBuffer stringBuffer2;
        FieldPosition fieldPosition2;
        SimpleDateFormat simpleDateFormat;
        int i4;
        DisplayContext displayContext2;
        StringBuffer stringBuffer3;
        int i5;
        int i6;
        String dayOfMonthName;
        int i7;
        int i8;
        String[] strArr;
        String[] strArr2;
        StringBuffer stringBuffer4;
        String str;
        DateFormatSymbols.CapitalizationContextUsage capitalizationContextUsage;
        String[] strArr3;
        StringBuffer stringBuffer5;
        SimpleDateFormat simpleDateFormat2;
        String[] strArr4;
        StringBuffer stringBuffer6;
        String str2;
        int indexFromChar;
        int i9;
        boolean z;
        Map<DateFormatSymbols.CapitalizationContextUsage, boolean[]> map;
        boolean[] zArr;
        boolean z2;
        SimpleDateFormat simpleDateFormat3 = this;
        int length = stringBuffer.length();
        TimeZone timeZone = calendar.getTimeZone();
        long timeInMillis = calendar.getTimeInMillis();
        int indexFromChar2 = getIndexFromChar(c);
        if (indexFromChar2 == -1) {
            if (c == 'l') {
                return;
            }
            kf2.c(c, simpleDateFormat3.pattern);
        }
        int i10 = PATTERN_INDEX_TO_CALENDAR_FIELD[indexFromChar2];
        int relatedYear = i10 >= 0 ? indexFromChar2 != 34 ? calendar.get(i10) : calendar.getRelatedYear() : 0;
        NumberFormat numberFormat = simpleDateFormat3.getNumberFormat(c);
        DateFormatSymbols.CapitalizationContextUsage capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.OTHER;
        String str3 = null;
        switch (indexFromChar2) {
            case 0:
                stringBuffer2 = stringBuffer;
                fieldPosition2 = fieldPosition;
                simpleDateFormat = simpleDateFormat3;
                int i11 = relatedYear;
                i4 = i2;
                displayContext2 = displayContext;
                if (calendar.getType().equals("chinese") || calendar.getType().equals("dangi")) {
                    simpleDateFormat3 = this;
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, i11, 1, 9);
                } else {
                    if (i == 5) {
                        safeAppend(simpleDateFormat.formatData.narrowEras, i11, stringBuffer2);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.ERA_NARROW;
                    } else {
                        DateFormatSymbols dateFormatSymbols = simpleDateFormat.formatData;
                        if (i == 4) {
                            safeAppend(dateFormatSymbols.eraNames, i11, stringBuffer2);
                            capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.ERA_WIDE;
                        } else {
                            safeAppend(dateFormatSymbols.eras, i11, stringBuffer2);
                            capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.ERA_ABBREV;
                        }
                    }
                    simpleDateFormat3 = simpleDateFormat;
                }
                if (i3 == 0 && displayContext2 != null && stringBuffer2.length() > length && UCharacter.isLowerCase(stringBuffer2.codePointAt(length))) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if ((i9 != 2 || i9 == 3) && (map = simpleDateFormat3.formatData.capitalization) != null) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 1:
            case 18:
                stringBuffer3 = stringBuffer;
                i5 = i;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                i6 = relatedYear;
                i4 = i2;
                str2 = simpleDateFormat3.override;
                if (str2 != null && ((str2.compareTo("hebr") == 0 || simpleDateFormat3.override.indexOf("y=hebr") >= 0) && i6 > HEBREW_CAL_CUR_MILLENIUM_START_YEAR && i6 < HEBREW_CAL_CUR_MILLENIUM_END_YEAR)) {
                    i6 -= 5000;
                }
                if (i5 == 2) {
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer3, i6, 2, 2);
                    simpleDateFormat3 = this;
                    stringBuffer2 = stringBuffer;
                } else {
                    simpleDateFormat3 = this;
                    stringBuffer2 = stringBuffer;
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, i6, i5, Integer.MAX_VALUE);
                }
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 2:
            case 26:
                fieldPosition2 = fieldPosition;
                int i12 = relatedYear;
                i4 = i2;
                displayContext2 = displayContext;
                if (calendar.getType().equals("hebrew")) {
                    boolean zIsLeapYear = HebrewCalendar.isLeapYear(calendar.get(1));
                    if (zIsLeapYear && i12 == 6 && i >= 3) {
                        i12 = 13;
                    }
                    if (!zIsLeapYear && i12 >= 6 && i < 3) {
                        i12--;
                    }
                }
                String[] strArr5 = simpleDateFormat3.formatData.leapMonthPatterns;
                int i13 = (strArr5 == null || strArr5.length < 7) ? 0 : calendar.get(22);
                if (i == 5) {
                    DateFormatSymbols dateFormatSymbols2 = simpleDateFormat3.formatData;
                    if (indexFromChar2 == 2) {
                        safeAppendWithMonthPattern(dateFormatSymbols2.narrowMonths, i12, stringBuffer, i13 != 0 ? dateFormatSymbols2.leapMonthPatterns[2] : null);
                    } else {
                        safeAppendWithMonthPattern(dateFormatSymbols2.standaloneNarrowMonths, i12, stringBuffer, i13 != 0 ? dateFormatSymbols2.leapMonthPatterns[5] : null);
                    }
                    capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.MONTH_NARROW;
                } else if (i != 4) {
                    if (i == 3) {
                        DateFormatSymbols dateFormatSymbols3 = simpleDateFormat3.formatData;
                        if (indexFromChar2 == 2) {
                            safeAppendWithMonthPattern(dateFormatSymbols3.shortMonths, i12, stringBuffer, i13 != 0 ? dateFormatSymbols3.leapMonthPatterns[1] : null);
                            capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.MONTH_FORMAT;
                        } else {
                            safeAppendWithMonthPattern(dateFormatSymbols3.standaloneShortMonths, i12, stringBuffer, i13 != 0 ? dateFormatSymbols3.leapMonthPatterns[4] : null);
                            capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.MONTH_STANDALONE;
                        }
                    } else {
                        StringBuffer stringBuffer7 = new StringBuffer();
                        simpleDateFormat3 = this;
                        simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer7, i12 + 1, i, Integer.MAX_VALUE);
                        safeAppendWithMonthPattern(new String[]{stringBuffer7.toString()}, 0, stringBuffer, i13 != 0 ? simpleDateFormat3.formatData.leapMonthPatterns[6] : null);
                    }
                    stringBuffer2 = stringBuffer;
                    if (i3 == 0) {
                        i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                        if (i9 == 1) {
                            z = true;
                        } else if (i9 != 2) {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        } else {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        }
                        if (z) {
                            if (simpleDateFormat3.capitalizationBrkIter == null) {
                                simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                            }
                            stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                        }
                    }
                    indexFromChar = getIndexFromChar(c2);
                    if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                        if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        }
                    }
                    break;
                } else {
                    DateFormatSymbols dateFormatSymbols4 = simpleDateFormat3.formatData;
                    if (indexFromChar2 == 2) {
                        safeAppendWithMonthPattern(dateFormatSymbols4.months, i12, stringBuffer, i13 != 0 ? dateFormatSymbols4.leapMonthPatterns[0] : null);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.MONTH_FORMAT;
                    } else {
                        safeAppendWithMonthPattern(dateFormatSymbols4.standaloneMonths, i12, stringBuffer, i13 != 0 ? dateFormatSymbols4.leapMonthPatterns[3] : null);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.MONTH_STANDALONE;
                    }
                }
                simpleDateFormat3 = simpleDateFormat3;
                stringBuffer2 = stringBuffer;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 3:
                stringBuffer2 = stringBuffer;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                int i14 = relatedYear;
                i4 = i2;
                if (i < 3 || i14 < 1 || (dayOfMonthName = simpleDateFormat3.formatDayOfMonthName(i14, numberFormat, i, Integer.MAX_VALUE)) == null) {
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, i14, i, Integer.MAX_VALUE);
                } else {
                    stringBuffer2.append(dayOfMonthName);
                }
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 4:
                fieldPosition2 = fieldPosition;
                int i15 = relatedYear;
                i4 = i2;
                displayContext2 = displayContext;
                if (i15 == 0) {
                    simpleDateFormat3 = this;
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer, calendar.getMaximum(11) + 1, i, Integer.MAX_VALUE);
                    stringBuffer2 = stringBuffer;
                } else {
                    simpleDateFormat3 = this;
                    stringBuffer2 = stringBuffer;
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, i15, i, Integer.MAX_VALUE);
                }
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 5:
            case 6:
            case 7:
            case 10:
            case 11:
            case 12:
            case 13:
            case 16:
            case 20:
            case 21:
            case 22:
            case 34:
            default:
                stringBuffer2 = stringBuffer;
                simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, relatedYear, i, Integer.MAX_VALUE);
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 8:
                stringBuffer2 = stringBuffer;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                simpleDateFormat = simpleDateFormat3;
                int i16 = relatedYear;
                i4 = i2;
                simpleDateFormat.numberFormat.setMinimumIntegerDigits(Math.min(3, i));
                simpleDateFormat.numberFormat.setMaximumIntegerDigits(Integer.MAX_VALUE);
                int i17 = i == 1 ? i16 / 100 : i == 2 ? i16 / 10 : i16;
                FieldPosition fieldPosition3 = new FieldPosition(-1);
                simpleDateFormat.numberFormat.format(i17, stringBuffer2, fieldPosition3);
                if (i > 3) {
                    simpleDateFormat.numberFormat.setMinimumIntegerDigits(i - 3);
                    simpleDateFormat.numberFormat.format(0L, stringBuffer2, fieldPosition3);
                }
                simpleDateFormat3 = simpleDateFormat;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 9:
                stringBuffer2 = stringBuffer;
                i7 = i;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                simpleDateFormat = simpleDateFormat3;
                int i18 = relatedYear;
                i4 = i2;
                i8 = i18;
                if (i7 == 5) {
                    safeAppend(simpleDateFormat.formatData.narrowWeekdays, i8, stringBuffer2);
                    capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_NARROW;
                } else if (i7 == 4) {
                    safeAppend(simpleDateFormat.formatData.weekdays, i8, stringBuffer2);
                    capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                } else if (i7 == 6 || (strArr3 = simpleDateFormat.formatData.shorterWeekdays) == null) {
                    safeAppend(simpleDateFormat.formatData.shortWeekdays, i8, stringBuffer2);
                    capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                } else {
                    safeAppend(strArr3, i8, stringBuffer2);
                    capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                }
                simpleDateFormat3 = simpleDateFormat;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 14:
                stringBuffer2 = stringBuffer;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                simpleDateFormat = simpleDateFormat3;
                int i19 = relatedYear;
                i4 = i2;
                if (i == 4 && (strArr2 = simpleDateFormat.formatData.ampmsWide) != null) {
                    safeAppend(strArr2, i19, stringBuffer2);
                } else if (i != 5 || (strArr = simpleDateFormat.formatData.ampmsNarrow) == null) {
                    safeAppend(simpleDateFormat.formatData.ampms, i19, stringBuffer2);
                } else {
                    safeAppend(strArr, i19, stringBuffer2);
                }
                simpleDateFormat3 = simpleDateFormat;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 15:
                fieldPosition2 = fieldPosition;
                int i20 = relatedYear;
                i4 = i2;
                displayContext2 = displayContext;
                if (i20 == 0) {
                    simpleDateFormat3 = this;
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer, calendar.getLeastMaximum(10) + 1, i, Integer.MAX_VALUE);
                    stringBuffer2 = stringBuffer;
                } else {
                    simpleDateFormat3 = this;
                    stringBuffer2 = stringBuffer;
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, i20, i, Integer.MAX_VALUE);
                }
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 17:
                stringBuffer4 = stringBuffer;
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                if (i < 4) {
                    str = tzFormat().format(TimeZoneFormat.Style.SPECIFIC_SHORT, timeZone, timeInMillis);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.METAZONE_SHORT;
                } else {
                    str = tzFormat().format(TimeZoneFormat.Style.SPECIFIC_LONG, timeZone, timeInMillis);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.METAZONE_LONG;
                }
                capitalizationContextUsage2 = capitalizationContextUsage;
                stringBuffer4.append(str);
                simpleDateFormat3 = this;
                stringBuffer2 = stringBuffer4;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 19:
                fieldPosition2 = fieldPosition;
                int i21 = relatedYear;
                i4 = i2;
                displayContext2 = displayContext;
                if (i < 3) {
                    stringBuffer2 = stringBuffer;
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, i21, i, Integer.MAX_VALUE);
                    simpleDateFormat3 = this;
                } else {
                    i8 = calendar.get(7);
                    stringBuffer2 = stringBuffer;
                    i7 = i;
                    simpleDateFormat = this;
                    if (i7 == 5) {
                        safeAppend(simpleDateFormat.formatData.narrowWeekdays, i8, stringBuffer2);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_NARROW;
                    } else if (i7 == 4) {
                        safeAppend(simpleDateFormat.formatData.weekdays, i8, stringBuffer2);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                    } else if (i7 == 6) {
                        safeAppend(simpleDateFormat.formatData.shortWeekdays, i8, stringBuffer2);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                    } else {
                        safeAppend(simpleDateFormat.formatData.shortWeekdays, i8, stringBuffer2);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                    }
                    simpleDateFormat3 = simpleDateFormat;
                }
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 23:
                stringBuffer5 = stringBuffer;
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                simpleDateFormat2 = simpleDateFormat3;
                stringBuffer5.append(i < 4 ? simpleDateFormat2.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL, timeZone, timeInMillis) : i == 5 ? simpleDateFormat2.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_FULL, timeZone, timeInMillis) : simpleDateFormat2.tzFormat().format(TimeZoneFormat.Style.LOCALIZED_GMT, timeZone, timeInMillis));
                simpleDateFormat3 = simpleDateFormat2;
                stringBuffer2 = stringBuffer5;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 24:
                stringBuffer5 = stringBuffer;
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                simpleDateFormat2 = simpleDateFormat3;
                if (i == 1) {
                    str3 = simpleDateFormat2.tzFormat().format(TimeZoneFormat.Style.GENERIC_SHORT, timeZone, timeInMillis);
                    capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.METAZONE_SHORT;
                } else if (i == 4) {
                    str3 = simpleDateFormat2.tzFormat().format(TimeZoneFormat.Style.GENERIC_LONG, timeZone, timeInMillis);
                    capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.METAZONE_LONG;
                }
                stringBuffer5.append(str3);
                simpleDateFormat3 = simpleDateFormat2;
                stringBuffer2 = stringBuffer5;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 25:
                fieldPosition2 = fieldPosition;
                int i22 = relatedYear;
                i4 = i2;
                displayContext2 = displayContext;
                if (i < 3) {
                    simpleDateFormat3 = this;
                    stringBuffer2 = stringBuffer;
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, i22, 1, Integer.MAX_VALUE);
                } else {
                    simpleDateFormat2 = this;
                    stringBuffer5 = stringBuffer;
                    int i23 = calendar.get(7);
                    if (i == 5) {
                        safeAppend(simpleDateFormat2.formatData.standaloneNarrowWeekdays, i23, stringBuffer5);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_NARROW;
                    } else if (i == 4) {
                        safeAppend(simpleDateFormat2.formatData.standaloneWeekdays, i23, stringBuffer5);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_STANDALONE;
                    } else if (i != 6 || (strArr4 = simpleDateFormat2.formatData.standaloneShorterWeekdays) == null) {
                        safeAppend(simpleDateFormat2.formatData.standaloneShortWeekdays, i23, stringBuffer5);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_STANDALONE;
                    } else {
                        safeAppend(strArr4, i23, stringBuffer5);
                        capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.DAY_STANDALONE;
                    }
                    simpleDateFormat3 = simpleDateFormat2;
                    stringBuffer2 = stringBuffer5;
                }
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 27:
                stringBuffer2 = stringBuffer;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                int i24 = relatedYear;
                i4 = i2;
                if (i >= 5) {
                    safeAppend(simpleDateFormat3.formatData.narrowQuarters, i24 / 3, stringBuffer2);
                } else if (i == 4) {
                    safeAppend(simpleDateFormat3.formatData.quarters, i24 / 3, stringBuffer2);
                } else if (i == 3) {
                    safeAppend(simpleDateFormat3.formatData.shortQuarters, i24 / 3, stringBuffer2);
                } else {
                    simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, (i24 / 3) + 1, i, Integer.MAX_VALUE);
                    simpleDateFormat3 = this;
                    stringBuffer2 = stringBuffer;
                }
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 28:
                stringBuffer6 = stringBuffer;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                int i25 = relatedYear;
                i4 = i2;
                if (i >= 5) {
                    safeAppend(simpleDateFormat3.formatData.standaloneNarrowQuarters, i25 / 3, stringBuffer6);
                } else if (i != 4) {
                    if (i == 3) {
                        safeAppend(simpleDateFormat3.formatData.standaloneShortQuarters, i25 / 3, stringBuffer6);
                    } else {
                        stringBuffer2 = stringBuffer;
                        simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, (i25 / 3) + 1, i, Integer.MAX_VALUE);
                    }
                    if (i3 == 0) {
                        i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                        if (i9 == 1) {
                            z = true;
                        } else if (i9 != 2) {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        } else {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        }
                        if (z) {
                            if (simpleDateFormat3.capitalizationBrkIter == null) {
                                simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                            }
                            stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                        }
                    }
                    indexFromChar = getIndexFromChar(c2);
                    if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                        if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        }
                    }
                } else {
                    safeAppend(simpleDateFormat3.formatData.standaloneQuarters, i25 / 3, stringBuffer6);
                }
                stringBuffer2 = stringBuffer6;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 29:
                stringBuffer6 = stringBuffer;
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                if (i == 1) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ZONE_ID_SHORT, timeZone, timeInMillis);
                } else if (i == 2) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ZONE_ID, timeZone, timeInMillis);
                } else if (i == 3) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.EXEMPLAR_LOCATION, timeZone, timeInMillis);
                } else if (i == 4) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.GENERIC_LOCATION, timeZone, timeInMillis);
                    capitalizationContextUsage2 = DateFormatSymbols.CapitalizationContextUsage.ZONE_LONG;
                }
                stringBuffer6.append(str3);
                stringBuffer2 = stringBuffer6;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 30:
                stringBuffer6 = stringBuffer;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                int i26 = relatedYear;
                i4 = i2;
                String[] strArr6 = simpleDateFormat3.formatData.shortYearNames;
                if (strArr6 != null && i26 <= strArr6.length) {
                    safeAppend(strArr6, i26 - 1, stringBuffer6);
                    stringBuffer2 = stringBuffer6;
                    if (i3 == 0) {
                        i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                        if (i9 == 1) {
                            z = true;
                        } else if (i9 != 2) {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        } else {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        }
                        if (z) {
                            if (simpleDateFormat3.capitalizationBrkIter == null) {
                                simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                            }
                            stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                        }
                    }
                    indexFromChar = getIndexFromChar(c2);
                    if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                        if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        }
                    }
                } else {
                    i5 = i;
                    i6 = i26;
                    numberFormat = numberFormat;
                    stringBuffer3 = stringBuffer6;
                    str2 = simpleDateFormat3.override;
                    if (str2 != null) {
                        i6 -= 5000;
                    }
                    if (i5 == 2) {
                        simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer3, i6, 2, 2);
                        simpleDateFormat3 = this;
                        stringBuffer2 = stringBuffer;
                    } else {
                        simpleDateFormat3 = this;
                        stringBuffer2 = stringBuffer;
                        simpleDateFormat3.zeroPaddingNumber(numberFormat, stringBuffer2, i6, i5, Integer.MAX_VALUE);
                    }
                    if (i3 == 0) {
                        i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                        if (i9 == 1) {
                            z = true;
                        } else if (i9 != 2) {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        } else {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        }
                        if (z) {
                            if (simpleDateFormat3.capitalizationBrkIter == null) {
                                simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                            }
                            stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                        }
                    }
                    indexFromChar = getIndexFromChar(c2);
                    if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                        if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        }
                    }
                }
                break;
            case 31:
                stringBuffer6 = stringBuffer;
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                if (i == 1) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.LOCALIZED_GMT_SHORT, timeZone, timeInMillis);
                } else if (i == 4) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.LOCALIZED_GMT, timeZone, timeInMillis);
                }
                stringBuffer6.append(str3);
                stringBuffer2 = stringBuffer6;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 32:
                stringBuffer6 = stringBuffer;
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                if (i == 1) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_SHORT, timeZone, timeInMillis);
                } else if (i == 2) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_FIXED, timeZone, timeInMillis);
                } else if (i == 3) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_FIXED, timeZone, timeInMillis);
                } else if (i == 4) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_FULL, timeZone, timeInMillis);
                } else if (i == 5) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_FULL, timeZone, timeInMillis);
                }
                stringBuffer6.append(str3);
                stringBuffer2 = stringBuffer6;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 33:
                stringBuffer6 = stringBuffer;
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                if (i == 1) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_LOCAL_SHORT, timeZone, timeInMillis);
                } else if (i == 2) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_LOCAL_FIXED, timeZone, timeInMillis);
                } else if (i == 3) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FIXED, timeZone, timeInMillis);
                } else if (i == 4) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL, timeZone, timeInMillis);
                } else if (i == 5) {
                    str3 = simpleDateFormat3.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FULL, timeZone, timeInMillis);
                }
                stringBuffer6.append(str3);
                stringBuffer2 = stringBuffer6;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
            case 35:
                if (calendar.get(11) == 12 && ((!simpleDateFormat3.hasMinute || calendar.get(12) == 0) && (!simpleDateFormat3.hasSecond || calendar.get(13) == 0))) {
                    int i27 = calendar.get(9);
                    str3 = i <= 3 ? simpleDateFormat3.formatData.abbreviatedDayPeriods[i27] : (i == 4 || i > 5) ? simpleDateFormat3.formatData.wideDayPeriods[i27] : simpleDateFormat3.formatData.narrowDayPeriods[i27];
                }
                String str4 = str3;
                if (str4 != null) {
                    stringBuffer6 = stringBuffer;
                    i4 = i2;
                    displayContext2 = displayContext;
                    fieldPosition2 = fieldPosition;
                    stringBuffer6.append(str4);
                    stringBuffer2 = stringBuffer6;
                    if (i3 == 0) {
                        i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                        if (i9 == 1) {
                            z = true;
                        } else if (i9 != 2) {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        } else {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        }
                        if (z) {
                            if (simpleDateFormat3.capitalizationBrkIter == null) {
                                simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                            }
                            stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                        }
                    }
                    indexFromChar = getIndexFromChar(c2);
                    if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                        if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        }
                    }
                } else {
                    stringBuffer4 = stringBuffer;
                    simpleDateFormat3.subFormat(stringBuffer4, 'a', i, i2, i3, displayContext, fieldPosition, 'b', calendar);
                    displayContext2 = displayContext;
                    fieldPosition2 = fieldPosition;
                    i4 = i2;
                    stringBuffer2 = stringBuffer4;
                    if (i3 == 0) {
                        i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                        if (i9 == 1) {
                            z = true;
                        } else if (i9 != 2) {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        } else {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        }
                        if (z) {
                            if (simpleDateFormat3.capitalizationBrkIter == null) {
                                simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                            }
                            stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                        }
                    }
                    indexFromChar = getIndexFromChar(c2);
                    if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                        if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        }
                    }
                }
                break;
            case 36:
                stringBuffer2 = stringBuffer;
                DayPeriodRules dayPeriodRules = DayPeriodRules.getInstance(simpleDateFormat3.getLocale());
                int i28 = calendar.get(11);
                int i29 = simpleDateFormat3.hasMinute ? calendar.get(12) : 0;
                int i30 = simpleDateFormat3.hasSecond ? calendar.get(13) : 0;
                DayPeriodRules.DayPeriod dayPeriodForHour = (i28 == 0 && i29 == 0 && i30 == 0 && dayPeriodRules.hasMidnight()) ? DayPeriodRules.DayPeriod.MIDNIGHT : (i28 == 12 && i29 == 0 && i30 == 0 && dayPeriodRules.hasNoon()) ? DayPeriodRules.DayPeriod.NOON : dayPeriodRules.getDayPeriodForHour(i28);
                DayPeriodRules.DayPeriod dayPeriod = DayPeriodRules.DayPeriod.AM;
                if (dayPeriodForHour != dayPeriod && dayPeriodForHour != DayPeriodRules.DayPeriod.PM && dayPeriodForHour != DayPeriodRules.DayPeriod.MIDNIGHT) {
                    int iOrdinal = dayPeriodForHour.ordinal();
                    str3 = i <= 3 ? simpleDateFormat3.formatData.abbreviatedDayPeriods[iOrdinal] : (i == 4 || i > 5) ? simpleDateFormat3.formatData.wideDayPeriods[iOrdinal] : simpleDateFormat3.formatData.narrowDayPeriods[iOrdinal];
                }
                if (str3 == null && (dayPeriodForHour == DayPeriodRules.DayPeriod.MIDNIGHT || dayPeriodForHour == DayPeriodRules.DayPeriod.NOON)) {
                    dayPeriodForHour = dayPeriodRules.getDayPeriodForHour(i28);
                    int iOrdinal2 = dayPeriodForHour.ordinal();
                    str3 = i <= 3 ? simpleDateFormat3.formatData.abbreviatedDayPeriods[iOrdinal2] : (i == 4 || i > 5) ? simpleDateFormat3.formatData.wideDayPeriods[iOrdinal2] : simpleDateFormat3.formatData.narrowDayPeriods[iOrdinal2];
                }
                String str5 = str3;
                if (dayPeriodForHour == dayPeriod || dayPeriodForHour == DayPeriodRules.DayPeriod.PM || str5 == null) {
                    simpleDateFormat3.subFormat(stringBuffer, 'a', i, i2, i3, displayContext, fieldPosition, 'B', calendar);
                } else {
                    stringBuffer2.append(str5);
                    i4 = i2;
                    displayContext2 = displayContext;
                    fieldPosition2 = fieldPosition;
                    if (i3 == 0) {
                        i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                        if (i9 == 1) {
                            z = true;
                        } else if (i9 != 2) {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        } else {
                            zArr = map.get(capitalizationContextUsage2);
                            if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                                z2 = zArr[0];
                            } else {
                                z2 = zArr[1];
                            }
                            z = z2;
                        }
                        if (z) {
                            if (simpleDateFormat3.capitalizationBrkIter == null) {
                                simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                            }
                            stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                        }
                    }
                    indexFromChar = getIndexFromChar(c2);
                    if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                        if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                            fieldPosition2.setBeginIndex(i4);
                            fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                        }
                    }
                }
                break;
            case 37:
                stringBuffer2 = stringBuffer;
                stringBuffer2.append(simpleDateFormat3.formatData.getTimeSeparatorString());
                i4 = i2;
                displayContext2 = displayContext;
                fieldPosition2 = fieldPosition;
                if (i3 == 0) {
                    i9 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext[displayContext2.ordinal()];
                    if (i9 == 1) {
                        z = true;
                    } else if (i9 != 2) {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    } else {
                        zArr = map.get(capitalizationContextUsage2);
                        if (displayContext2 == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) {
                            z2 = zArr[0];
                        } else {
                            z2 = zArr[1];
                        }
                        z = z2;
                    }
                    if (z) {
                        if (simpleDateFormat3.capitalizationBrkIter == null) {
                            simpleDateFormat3.capitalizationBrkIter = BreakIterator.getSentenceInstance(simpleDateFormat3.locale);
                        }
                        stringBuffer2.replace(length, stringBuffer2.length(), UCharacter.toTitleCase(simpleDateFormat3.locale, stringBuffer2.substring(length), simpleDateFormat3.capitalizationBrkIter.mo5clone(), 768));
                    }
                }
                indexFromChar = getIndexFromChar(c2);
                if (fieldPosition2.getBeginIndex() == fieldPosition2.getEndIndex()) {
                    if (fieldPosition2.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    } else if (fieldPosition2.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar]) {
                        fieldPosition2.setBeginIndex(i4);
                        fieldPosition2.setEndIndex((stringBuffer2.length() + i4) - length);
                    }
                }
                break;
        }
    }

    public String toLocalizedPattern() {
        return translatePattern(this.pattern, "GyMdkHmsSEDFwWahKzYeugAZvcLQqVUOXxrbB", this.formatData.localPatternChars);
    }

    public String toPattern() {
        return this.pattern;
    }

    @Deprecated
    public void zeroPaddingNumber(NumberFormat numberFormat, StringBuffer stringBuffer, int i, int i2, int i3) {
        if (this.useLocalZeroPaddingNumberFormat && i >= 0) {
            fastZeroPaddingNumber(stringBuffer, i, i2, i3);
            return;
        }
        numberFormat.setMinimumIntegerDigits(i2);
        numberFormat.setMaximumIntegerDigits(i3);
        numberFormat.format(i, stringBuffer, new FieldPosition(-1));
    }

    public SimpleDateFormat(String str) {
        this(str, null, null, null, null, true, null);
    }

    public String zeroPaddingNumber(long j, int i, int i2) {
        this.numberFormat.setMinimumIntegerDigits(i);
        this.numberFormat.setMaximumIntegerDigits(i2);
        return this.numberFormat.format(j);
    }

    public SimpleDateFormat(String str, Locale locale) {
        this(str, null, null, null, ULocale.forLocale(locale), true, null);
    }

    public SimpleDateFormat(String str, ULocale uLocale) {
        this(str, null, null, null, uLocale, true, null);
    }

    public SimpleDateFormat(String str, String str2, ULocale uLocale) {
        this(str, null, null, null, uLocale, false, str2);
    }

    public SimpleDateFormat(String str, DateFormatSymbols dateFormatSymbols) {
        this(str, dateFormatSymbols.m14clone(), null, null, null, true, null);
    }

    @Deprecated
    public SimpleDateFormat(String str, DateFormatSymbols dateFormatSymbols, ULocale uLocale) {
        this(str, dateFormatSymbols.m14clone(), null, null, uLocale, true, null);
    }

    public SimpleDateFormat(String str, DateFormatSymbols dateFormatSymbols, Calendar calendar, ULocale uLocale, boolean z, String str2) {
        this(str, dateFormatSymbols.m14clone(), calendar.mo22clone(), null, uLocale, z, str2);
    }

    public SimpleDateFormat() {
        this(getDefaultPattern(), null, null, null, null, true, null);
    }

    public boolean isFieldUnitIgnored(int i) {
        return isFieldUnitIgnored(this.pattern, i);
    }

    public int matchString(String str, int i, int i2, String[] strArr, Calendar calendar) {
        return matchString(str, i, i2, strArr, null, calendar);
    }

    private Number parseInt(String str, ParsePosition parsePosition, boolean z, NumberFormat numberFormat) {
        return parseInt(str, -1, parsePosition, z, numberFormat);
    }

    @Override // com.ibm.icu.text.DateFormat
    public void setNumberFormat(NumberFormat numberFormat) {
        super.setNumberFormat(numberFormat);
        initLocalZeroPaddingNumberFormat();
        initializeTimeZoneFormat(true);
        if (this.numberFormatters != null) {
            this.numberFormatters = null;
        }
        if (this.overrideMap != null) {
            this.overrideMap = null;
        }
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer, FieldPosition fieldPosition, List<FieldPosition> list) {
        TimeZone timeZone;
        if (calendar == this.calendar || calendar.getType().equals(this.calendar.getType())) {
            timeZone = null;
        } else {
            this.calendar.setTimeInMillis(calendar.getTimeInMillis());
            timeZone = this.calendar.getTimeZone();
            this.calendar.setTimeZone(calendar.getTimeZone());
            calendar = this.calendar;
        }
        StringBuffer stringBuffer2 = format(calendar, getContext(DisplayContext.Type.CAPITALIZATION), stringBuffer, fieldPosition, list);
        if (timeZone != null) {
            this.calendar.setTimeZone(timeZone);
        }
        return stringBuffer2;
    }

    @Override // com.ibm.icu.text.DateFormat
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format(calendar, stringBuffer, fieldPosition, null);
    }

    private int subParse(String str, int i, char c, int i2, boolean z, boolean z2, boolean[] zArr, Calendar calendar, MessageFormat messageFormat, Output<TimeZoneFormat.TimeType> output) {
        return subParse(str, i, c, i2, z, z2, zArr, calendar, null, null, null);
    }

    public int subParse(String str, int i, char c, int i2, boolean z, boolean z2, boolean[] zArr, Calendar calendar) {
        return subParse(str, i, c, i2, z, z2, zArr, calendar, null, null);
    }

    @Deprecated
    public String subFormat(char c, int i, int i2, int i3, DisplayContext displayContext, FieldPosition fieldPosition, char c2, Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        subFormat(stringBuffer, c, i, i2, i3, displayContext, fieldPosition, c2, calendar);
        return stringBuffer.toString();
    }

    public String subFormat(char c, int i, int i2, FieldPosition fieldPosition, DateFormatSymbols dateFormatSymbols, Calendar calendar) {
        return subFormat(c, i, i2, 0, DisplayContext.CAPITALIZATION_NONE, fieldPosition, c, calendar);
    }
}
