package com.ibm.icu.util;

import com.ibm.icu.impl.CalType;
import com.ibm.icu.impl.CalendarUtil;
import com.ibm.icu.impl.Grego;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.impl.number.RoundingUtils;
import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.Bidi;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DateFormatSymbols;
import com.ibm.icu.text.DateTimePatternGenerator;
import com.ibm.icu.text.SimpleDateFormat;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int AM = 0;
    public static final int AM_PM = 9;
    public static final int APRIL = 3;
    public static final int AUGUST = 7;

    @Deprecated
    protected static final int BASE_FIELD_COUNT = 24;
    public static final int DATE = 5;
    public static final int DAY_OF_MONTH = 5;
    public static final int DAY_OF_WEEK = 7;
    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    public static final int DAY_OF_YEAR = 6;
    public static final int DECEMBER = 11;
    public static final int DOW_LOCAL = 18;
    public static final int DST_OFFSET = 16;
    protected static final int EPOCH_JULIAN_DAY = 2440588;
    public static final int ERA = 0;
    public static final int EXTENDED_YEAR = 19;
    public static final int FEBRUARY = 1;
    private static final int FIELD_DIFF_MAX_INT = Integer.MAX_VALUE;
    public static final int FRIDAY = 6;
    protected static final int GREATEST_MINIMUM = 1;
    public static final int HOUR = 10;
    public static final int HOUR_OF_DAY = 11;
    protected static final int INTERNALLY_SET = 1;
    public static final int IS_LEAP_MONTH = 22;
    public static final int JANUARY = 0;
    protected static final int JAN_1_1_JULIAN_DAY = 1721426;
    public static final int JULIAN_DAY = 20;
    public static final int JULY = 6;
    public static final int JUNE = 5;
    protected static final int LEAST_MAXIMUM = 2;
    public static final int MARCH = 2;
    protected static final int MAXIMUM = 3;

    @Deprecated
    protected static final int MAX_FIELD_COUNT = 32;
    private static final int MAX_HOURS = 548;
    protected static final int MAX_JULIAN = 2130706432;
    protected static final long MAX_MILLIS = 183882168921600000L;
    public static final int MAY = 4;
    public static final int MILLISECOND = 14;
    public static final int MILLISECONDS_IN_DAY = 21;
    protected static final int MINIMUM = 0;
    protected static final int MINIMUM_USER_STAMP = 2;
    public static final int MINUTE = 12;
    protected static final long MIN_MILLIS = -184303902528000000L;
    public static final int MONDAY = 2;
    public static final int MONTH = 2;
    public static final int NOVEMBER = 10;
    public static final int OCTOBER = 9;
    protected static final long ONE_DAY = 86400000;
    protected static final int ONE_HOUR = 3600000;
    protected static final int ONE_MINUTE = 60000;
    protected static final int ONE_SECOND = 1000;
    protected static final long ONE_WEEK = 604800000;
    public static final int ORDINAL_MONTH = 23;
    public static final int PM = 1;
    private static final char QUOTE = '\'';
    protected static final int RESOLVE_REMAP = 32;
    public static final int SATURDAY = 7;
    public static final int SECOND = 13;
    public static final int SEPTEMBER = 8;
    public static final int SUNDAY = 1;
    public static final int THURSDAY = 5;
    public static final int TUESDAY = 3;
    public static final int UNDECIMBER = 12;
    protected static final int UNSET = 0;
    public static final int WALLTIME_FIRST = 1;
    public static final int WALLTIME_LAST = 0;
    public static final int WALLTIME_NEXT_VALID = 2;
    public static final int WEDNESDAY = 4;

    @Deprecated
    public static final int WEEKDAY = 0;

    @Deprecated
    public static final int WEEKEND = 1;

    @Deprecated
    public static final int WEEKEND_CEASE = 3;

    @Deprecated
    public static final int WEEKEND_ONSET = 2;
    public static final int WEEK_OF_MONTH = 4;
    public static final int WEEK_OF_YEAR = 3;
    public static final int YEAR = 1;
    public static final int YEAR_WOY = 17;
    public static final int ZONE_OFFSET = 15;
    private static final long serialVersionUID = 6222646104888790989L;
    private ULocale actualLocale;
    private transient boolean areAllFieldsSet;
    private transient boolean areFieldsSet;
    private transient boolean areFieldsVirtuallySet;
    private transient int[] fields;
    private int firstDayOfWeek;
    private transient int gregorianDayOfMonth;
    private transient int gregorianDayOfYear;
    private transient int gregorianMonth;
    private transient int gregorianYear;
    private transient int internalSetMask;
    private transient boolean isTimeSet;
    private boolean lenient;
    private int minimalDaysInFirstWeek;
    private transient byte nextStamp;
    private int repeatedWallTime;
    private int skippedWallTime;
    private transient byte[] stamp;
    private long time;
    private ULocale validLocale;
    private int weekendCease;
    private int weekendCeaseMillis;
    private int weekendOnset;
    private int weekendOnsetMillis;
    private TimeZone zone;
    protected static final Date MIN_DATE = new Date(-184303902528000000L);
    protected static final Date MAX_DATE = new Date(183882168921600000L);
    private static byte STAMP_MAX = Bidi.LEVEL_DEFAULT_RTL;
    private static String[] gTemporalMonthCodes = {"M01", "M02", "M03", "M04", "M05", "M06", "M07", "M08", "M09", "M10", "M11", "M12"};
    private static final ICUCache<String, PatternData> PATTERN_CACHE = new SimpleCache();
    private static final String[] DEFAULT_PATTERNS = {"HH:mm:ss z", "HH:mm:ss z", "HH:mm:ss", "HH:mm", "y MMMM d, EEEE", "y MMMM d", "y MMM d", "y-MM-dd", "{1} {0}", "{1} {0}", "{1} {0}", "{1} {0}", "{1} {0}"};
    private static final String[] DEFAULT_ATTIME_PATTERNS = {"{1} {0}", "{1} {0}", "{1} {0}", "{1} {0}"};
    private static final String[] TIME_SKELETONS = {"jmmsszzzz", "jmmssz", "jmmss", "jmm"};
    protected static final int MIN_JULIAN = -2130706432;
    private static final int[][] LIMITS = {new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{1, 1, 7, 7}, new int[0], new int[]{0, 0, 1, 1}, new int[]{0, 0, 11, 11}, new int[]{0, 0, 23, 23}, new int[]{0, 0, 59, 59}, new int[]{0, 0, 59, 59}, new int[]{0, 0, RoundingUtils.MAX_INT_FRAC_SIG, RoundingUtils.MAX_INT_FRAC_SIG}, new int[]{-86400000, -57600000, 43200000, 108000000}, new int[]{0, 0, 7200000, 7200000}, new int[0], new int[]{1, 1, 7, 7}, new int[0], new int[]{MIN_JULIAN, MIN_JULIAN, 2130706432, 2130706432}, new int[]{0, 0, 86399999, 86399999}, new int[]{0, 0, 1, 1}, new int[]{0, 0, 12, 12}};
    private static final WeekDataCache WEEK_DATA_CACHE = new WeekDataCache(0);
    static final int[][][] DATE_PRECEDENCE = {new int[][]{new int[]{5}, new int[]{3, 7}, new int[]{4, 7}, new int[]{8, 7}, new int[]{3, 18}, new int[]{4, 18}, new int[]{8, 18}, new int[]{6}, new int[]{37, 1}, new int[]{35, 17}}, new int[][]{new int[]{3}, new int[]{4}, new int[]{8}, new int[]{40, 7}, new int[]{40, 18}}};
    static final int[][][] DOW_PRECEDENCE = {new int[][]{new int[]{7}, new int[]{18}}};
    static final int[][][] MONTH_PRECEDENCE = {new int[][]{new int[]{2}, new int[]{23}}};
    private static final int[] FIND_ZONE_TRANSITION_TIME_UNITS = {3600000, 1800000, 60000, 1000};
    private static final int[][] GREGORIAN_MONTH_COUNT = {new int[]{31, 31, 0, 0}, new int[]{28, 29, 31, 31}, new int[]{31, 31, 59, 60}, new int[]{30, 30, 90, 91}, new int[]{31, 31, 120, 121}, new int[]{30, 30, 151, 152}, new int[]{31, 31, 181, 182}, new int[]{31, 31, 212, 213}, new int[]{30, 30, UCharacter.UnicodeBlock.PAHAWH_HMONG_ID, UCharacter.UnicodeBlock.PALMYRENE_ID}, new int[]{31, 31, UCharacter.UnicodeBlock.TANGUT_COMPONENTS_ID, UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F_ID}, new int[]{30, 30, UCharacter.UnicodeBlock.KHITAN_SMALL_SCRIPT_ID, UCharacter.UnicodeBlock.LISU_SUPPLEMENT_ID}, new int[]{31, 31, UCharacter.UnicodeBlock.OL_ONAL_ID, UCharacter.UnicodeBlock.SUNUWAR_ID}};
    private static final String[] FIELD_NAME = {"ERA", "YEAR", "MONTH", "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR", "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR", "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET", "YEAR_WOY", "DOW_LOCAL", "EXTENDED_YEAR", "JULIAN_DAY", "MILLISECONDS_IN_DAY", "IS_LEAP_MONTH", "ORDINAL_MONTH"};

    /* JADX INFO: renamed from: com.ibm.icu.util.Calendar$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$CalType;

        static {
            int[] iArr = new int[CalType.values().length];
            $SwitchMap$com$ibm$icu$impl$CalType = iArr;
            try {
                iArr[CalType.GREGORIAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ISO8601.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.BUDDHIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.CHINESE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.COPTIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.DANGI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ETHIOPIC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ETHIOPIC_AMETE_ALEM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.HEBREW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.INDIAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ISLAMIC_CIVIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ISLAMIC_UMALQURA.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ISLAMIC_TBLA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ISLAMIC_RGSA.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ISLAMIC.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.JAPANESE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.PERSIAN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$CalType[CalType.ROC.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class PatternData {
        private String[] atTimePatterns;
        private String[] overrides;
        private String[] patterns;

        public PatternData(String[] strArr, String[] strArr2, String[] strArr3) {
            this.patterns = strArr;
            this.overrides = strArr2;
            this.atTimePatterns = strArr3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getDateAtTimePattern(int i) {
            String[] strArr = this.atTimePatterns;
            return (strArr == null || strArr.length < 4) ? getDateTimePattern(i) : strArr[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getDateTimePattern(int i) {
            String[] strArr = this.patterns;
            return strArr[strArr.length >= 13 ? i + 9 : 8];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static PatternData make(Calendar calendar, ULocale uLocale) {
            PatternData patternData;
            String type = calendar.getType();
            String strK = cq.k(uLocale.getBaseName(), "+", type);
            boolean z = (uLocale.getKeywordValue("rg") == null && uLocale.getKeywordValue("hours") == null) ? false : true;
            PatternData patternData2 = !z ? (PatternData) Calendar.PATTERN_CACHE.get(strK) : null;
            if (patternData2 != null) {
                return patternData2;
            }
            try {
                patternData = Calendar.getPatternData(uLocale, type);
            } catch (MissingResourceException unused) {
                patternData = new PatternData(Calendar.DEFAULT_PATTERNS, null, Calendar.DEFAULT_ATTIME_PATTERNS);
            }
            if (!z) {
                Calendar.PATTERN_CACHE.put(strK, patternData);
            }
            return patternData;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class WeekData {
        public final int firstDayOfWeek;
        public final int minimalDaysInFirstWeek;
        public final int weekendCease;
        public final int weekendCeaseMillis;
        public final int weekendOnset;
        public final int weekendOnsetMillis;

        public WeekData(int i, int i2, int i3, int i4, int i5, int i6) {
            this.firstDayOfWeek = i;
            this.minimalDaysInFirstWeek = i2;
            this.weekendOnset = i3;
            this.weekendOnsetMillis = i4;
            this.weekendCease = i5;
            this.weekendCeaseMillis = i6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WeekData)) {
                return false;
            }
            WeekData weekData = (WeekData) obj;
            return this.firstDayOfWeek == weekData.firstDayOfWeek && this.minimalDaysInFirstWeek == weekData.minimalDaysInFirstWeek && this.weekendOnset == weekData.weekendOnset && this.weekendOnsetMillis == weekData.weekendOnsetMillis && this.weekendCease == weekData.weekendCease && this.weekendCeaseMillis == weekData.weekendCeaseMillis;
        }

        public int hashCode() {
            return (((((((((this.firstDayOfWeek * 37) + this.minimalDaysInFirstWeek) * 37) + this.weekendOnset) * 37) + this.weekendOnsetMillis) * 37) + this.weekendCease) * 37) + this.weekendCeaseMillis;
        }

        public String toString() {
            int i = this.firstDayOfWeek;
            int i2 = this.minimalDaysInFirstWeek;
            int i3 = this.weekendOnset;
            int i4 = this.weekendOnsetMillis;
            int i5 = this.weekendCease;
            int i6 = this.weekendCeaseMillis;
            StringBuilder sbP = cq.p("{", i, ", ", i2, ", ");
            sbP.append(i3);
            sbP.append(", ");
            sbP.append(i4);
            sbP.append(", ");
            sbP.append(i5);
            sbP.append(", ");
            sbP.append(i6);
            sbP.append("}");
            return sbP.toString();
        }
    }

    public Calendar(TimeZone timeZone, ULocale uLocale) {
        int i = 1;
        this.lenient = true;
        byte b = 0;
        this.repeatedWallTime = 0;
        this.skippedWallTime = 0;
        this.nextStamp = (byte) 2;
        this.zone = timeZone;
        setWeekData(getRegionForCalendar(uLocale));
        String keywordValue = uLocale.getKeywordValue("fw");
        if (keywordValue != null) {
            switch (keywordValue.hashCode()) {
                case 101661:
                    if (!keywordValue.equals("fri")) {
                        b = -1;
                    }
                    break;
                case 108300:
                    b = !keywordValue.equals("mon") ? (byte) -1 : (byte) 1;
                    break;
                case 113638:
                    b = !keywordValue.equals("sat") ? (byte) -1 : (byte) 2;
                    break;
                case 114252:
                    b = !keywordValue.equals("sun") ? (byte) -1 : (byte) 3;
                    break;
                case 114817:
                    b = !keywordValue.equals("thu") ? (byte) -1 : (byte) 4;
                    break;
                case 115204:
                    b = !keywordValue.equals("tue") ? (byte) -1 : (byte) 5;
                    break;
                case 117590:
                    b = !keywordValue.equals("wed") ? (byte) -1 : (byte) 6;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    i = 6;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 7;
                    break;
                case 3:
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 3;
                    break;
                case 6:
                    i = 4;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (i != -1) {
                setFirstDayOfWeek(i);
            }
        }
        setCalendarLocale(uLocale);
        initInternal();
    }

    private long compare(Object obj) {
        long time;
        if (obj instanceof Calendar) {
            time = ((Calendar) obj).getTimeInMillis();
        } else {
            if (!(obj instanceof Date)) {
                og.i(String.valueOf(obj).concat("is not a Calendar or Date"));
                return 0L;
            }
            time = ((Date) obj).getTime();
        }
        return getTimeInMillis() - time;
    }

    private final void computeGregorianAndDOWFields(int i) {
        computeGregorianFields(i);
        int[] iArr = this.fields;
        int iJulianDayToDayOfWeek = julianDayToDayOfWeek(i);
        iArr[7] = iJulianDayToDayOfWeek;
        int firstDayOfWeek = iJulianDayToDayOfWeek - getFirstDayOfWeek();
        int i2 = firstDayOfWeek + 1;
        if (i2 < 1) {
            i2 = firstDayOfWeek + 8;
        }
        this.fields[18] = i2;
    }

    private final void computeWeekFields() {
        int[] iArr = this.fields;
        int i = iArr[19];
        int i2 = iArr[7];
        int i3 = iArr[6];
        int firstDayOfWeek = ((i2 + 7) - getFirstDayOfWeek()) % 7;
        int firstDayOfWeek2 = (((i2 - i3) + 7001) - getFirstDayOfWeek()) % 7;
        int iWeekNumber = ((i3 - 1) + firstDayOfWeek2) / 7;
        if (7 - firstDayOfWeek2 >= getMinimalDaysInFirstWeek()) {
            iWeekNumber++;
        }
        if (iWeekNumber == 0) {
            iWeekNumber = weekNumber(handleGetYearLength(i - 1) + i3, i2);
            i--;
        } else {
            int iHandleGetYearLength = handleGetYearLength(i);
            if (i3 >= iHandleGetYearLength - 5) {
                int i4 = ((firstDayOfWeek + iHandleGetYearLength) - i3) % 7;
                if (i4 < 0) {
                    i4 += 7;
                }
                if (6 - i4 >= getMinimalDaysInFirstWeek() && (i3 + 7) - firstDayOfWeek > iHandleGetYearLength) {
                    i++;
                    iWeekNumber = 1;
                }
            }
        }
        int[] iArr2 = this.fields;
        iArr2[3] = iWeekNumber;
        iArr2[17] = i;
        int i5 = iArr2[5];
        iArr2[4] = weekNumber(i5, i2);
        this.fields[8] = ((i5 - 1) / 7) + 1;
    }

    private static Calendar createInstance(ULocale uLocale) {
        TimeZone timeZoneForULocaleOrDefault = TimeZone.forULocaleOrDefault(uLocale);
        CalType calendarTypeForLocale = getCalendarTypeForLocale(uLocale);
        if (calendarTypeForLocale == null) {
            calendarTypeForLocale = CalType.GREGORIAN;
        }
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$impl$CalType[calendarTypeForLocale.ordinal()]) {
            case 1:
                return new GregorianCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 2:
                GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZoneForULocaleOrDefault, uLocale);
                if (uLocale.getUnicodeLocaleType("fw") == null && uLocale.getUnicodeLocaleType("rg") == null) {
                    gregorianCalendar.setFirstDayOfWeek(2);
                }
                gregorianCalendar.setMinimalDaysInFirstWeek(4);
                return gregorianCalendar;
            case 3:
                return new BuddhistCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 4:
                return new ChineseCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 5:
                return new CopticCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 6:
                return new DangiCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 7:
                return new EthiopicCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 8:
                EthiopicCalendar ethiopicCalendar = new EthiopicCalendar(timeZoneForULocaleOrDefault, uLocale);
                ethiopicCalendar.setAmeteAlemEra(true);
                return ethiopicCalendar;
            case 9:
                return new HebrewCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 10:
                return new IndianCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return new IslamicCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 16:
                return new JapaneseCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 17:
                return new PersianCalendar(timeZoneForULocaleOrDefault, uLocale);
            case 18:
                return new TaiwanCalendar(timeZoneForULocaleOrDefault, uLocale);
            default:
                og.i("Unknown calendar type");
                return null;
        }
    }

    private static String expandOverride(String str, String str2) {
        if (str2.indexOf(61) >= 0) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        boolean z = false;
        char c = ' ';
        for (char cFirst = stringCharacterIterator.first(); cFirst != 65535; cFirst = stringCharacterIterator.next()) {
            if (cFirst == '\'') {
                z = !z;
            } else if (!z && cFirst != c) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(cFirst);
                sb.append("=");
                sb.append(str2);
            }
            c = cFirst;
        }
        return sb.toString();
    }

    private static Long findPreviousZoneTransitionTime(TimeZone timeZone, int i, long j, long j2) {
        long j3;
        boolean z;
        long j4;
        long j5;
        int[] iArr = FIND_ZONE_TRANSITION_TIME_UNITS;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                j3 = 0;
                z = false;
                break;
            }
            long j6 = iArr[i2];
            long j7 = j2 / j6;
            long j8 = j / j6;
            if (j8 > j7) {
                j3 = (((j7 + j8) + 1) >>> 1) * j6;
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            j3 = (j + j2) >>> 1;
        }
        long j9 = j3;
        if (z) {
            if (j9 == j) {
                j5 = j;
            } else {
                if (timeZone.getOffset(j9) != i) {
                    return findPreviousZoneTransitionTime(timeZone, i, j, j9);
                }
                j5 = j9;
            }
            j4 = j9 - 1;
        } else {
            j4 = (j + j2) >>> 1;
            j5 = j;
        }
        if (j4 == j2) {
            return Long.valueOf(j5);
        }
        if (timeZone.getOffset(j4) != i) {
            return z ? Long.valueOf(j5) : findPreviousZoneTransitionTime(timeZone, i, j5, j4);
        }
        return findPreviousZoneTransitionTime(timeZone, i, j4, j2);
    }

    public static final int floorDivide(long j, int i, int[] iArr) {
        if (j >= 0) {
            long j2 = i;
            iArr[0] = (int) (j % j2);
            return (int) (j / j2);
        }
        long j3 = i;
        int i2 = (int) (((j + 1) / j3) - 1);
        iArr[0] = (int) (j - (((long) i2) * j3));
        return i2;
    }

    private static DateFormat formatHelper(Calendar calendar, ULocale uLocale, int i, int i2) {
        String rawPattern;
        String strMergeOverrideStrings = null;
        if (i2 < -1 || i2 > 3) {
            og.i(ky0.h(i2, "Illegal time style "));
            return null;
        }
        if (i < -1 || i > 3) {
            og.i(ky0.h(i, "Illegal date style "));
            return null;
        }
        PatternData patternDataMake = PatternData.make(calendar, uLocale);
        if (i2 >= 0 && i >= 0) {
            String dateAtTimePattern = patternDataMake.getDateAtTimePattern(i);
            int i3 = i + 4;
            rawPattern = SimpleFormatterImpl.formatRawPattern(dateAtTimePattern, 2, 2, patternDataMake.patterns[i2], patternDataMake.patterns[i3]);
            if (patternDataMake.overrides != null) {
                strMergeOverrideStrings = mergeOverrideStrings(patternDataMake.patterns[i3], patternDataMake.patterns[i2], patternDataMake.overrides[i3], patternDataMake.overrides[i2]);
            }
        } else if (i2 >= 0) {
            rawPattern = patternDataMake.patterns[i2];
            if (patternDataMake.overrides != null) {
                strMergeOverrideStrings = patternDataMake.overrides[i2];
            }
        } else {
            if (i < 0) {
                og.i("No date or time style specified");
                return null;
            }
            int i4 = i + 4;
            rawPattern = patternDataMake.patterns[i4];
            if (patternDataMake.overrides != null) {
                strMergeOverrideStrings = patternDataMake.overrides[i4];
            }
        }
        DateFormat dateFormatHandleGetDateFormat = calendar.handleGetDateFormat(rawPattern, strMergeOverrideStrings, uLocale);
        dateFormatHandleGetDateFormat.setCalendar(calendar);
        return dateFormatHandleGetDateFormat;
    }

    private int getActualHelper(int i, int i2, int i3) {
        if (i2 != i3) {
            int i4 = i3 > i2 ? 1 : -1;
            Calendar calendarMo22clone = mo22clone();
            calendarMo22clone.complete();
            calendarMo22clone.setLenient(true);
            calendarMo22clone.prepareGetActual(i, i4 < 0);
            calendarMo22clone.set(i, i2);
            if (calendarMo22clone.get(i) == i2 || i == 4 || i4 <= 0) {
                while (true) {
                    int i5 = i2 + i4;
                    calendarMo22clone.add(i, i4);
                    if (calendarMo22clone.get(i) != i5) {
                        return i2;
                    }
                    if (i5 == i3) {
                        return i5;
                    }
                    i2 = i5;
                }
            }
        }
        return i2;
    }

    public static Locale[] getAvailableLocales() {
        return ICUResourceBundle.getAvailableLocales();
    }

    public static ULocale[] getAvailableULocales() {
        return ICUResourceBundle.getAvailableULocales();
    }

    private static CalType getCalendarTypeForLocale(ULocale uLocale) {
        String calendarType = CalendarUtil.getCalendarType(uLocale);
        if (calendarType == null) {
            return null;
        }
        String lowerCase = calendarType.toLowerCase(Locale.ENGLISH);
        for (CalType calType : CalType.values()) {
            if (lowerCase.equals(calType.getId())) {
                return calType;
            }
        }
        return null;
    }

    @Deprecated
    public static String getDateAtTimePattern(Calendar calendar, ULocale uLocale, int i) {
        return PatternData.make(calendar, uLocale).getDateAtTimePattern(i);
    }

    @Deprecated
    public static String getDateTimePattern(Calendar calendar, ULocale uLocale, int i) {
        return PatternData.make(calendar, uLocale).getDateTimePattern(i);
    }

    private Long getImmediatePreviousZoneTransition(long j) {
        TimeZone timeZone = this.zone;
        if (!(timeZone instanceof BasicTimeZone)) {
            Long previousZoneTransitionTime = getPreviousZoneTransitionTime(timeZone, j, 7200000L);
            return previousZoneTransitionTime == null ? getPreviousZoneTransitionTime(this.zone, j, 108000000L) : previousZoneTransitionTime;
        }
        TimeZoneTransition previousTransition = ((BasicTimeZone) timeZone).getPreviousTransition(j, true);
        if (previousTransition != null) {
            return Long.valueOf(previousTransition.getTime());
        }
        return null;
    }

    public static Calendar getInstance(Locale locale) {
        return getInstanceInternal(null, ULocale.forLocale(locale));
    }

    private static Calendar getInstanceInternal(TimeZone timeZone, ULocale uLocale) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        if (timeZone == null) {
            timeZone = TimeZone.forULocaleOrDefault(uLocale);
        }
        Calendar calendarCreateInstance = createInstance(uLocale);
        calendarCreateInstance.setTimeZone(timeZone);
        calendarCreateInstance.setTimeInMillis(System.currentTimeMillis());
        return calendarCreateInstance;
    }

    public static final String[] getKeywordValuesForLocale(String str, ULocale uLocale, boolean z) {
        UResourceBundle uResourceBundle;
        String regionForSupplementalData = ULocale.getRegionForSupplementalData(uLocale, true);
        ArrayList arrayList = new ArrayList();
        UResourceBundle uResourceBundle2 = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("calendarPreferenceData");
        try {
            uResourceBundle = uResourceBundle2.get(regionForSupplementalData);
        } catch (MissingResourceException unused) {
            uResourceBundle = uResourceBundle2.get(UnitsData.Constants.DEFAULT_REGION);
        }
        String[] stringArray = uResourceBundle.getStringArray();
        if (z) {
            return stringArray;
        }
        for (String str2 : stringArray) {
            arrayList.add(str2);
        }
        for (CalType calType : CalType.values()) {
            if (!arrayList.contains(calType.getId())) {
                arrayList.add(calType.getId());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x0091 A[LOOP:2: B:25:0x008c->B:27:0x0091, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x009e  */
    /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:34:0x00af  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ee A[ADDED_TO_REGION, LOOP:1: B:43:0x00ee->B:47:0x0102, LOOP_START, PHI: r7
      0x00ee: PHI (r7v1 int) = (r7v0 int), (r7v2 int) binds: [B:42:0x00ec, B:47:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:48:0x0105  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0102 A[SYNTHETIC] */
    public static PatternData getPatternData(ULocale uLocale, String str) {
        DateTimePatternGenerator instanceNoStdPat;
        int i;
        String[] strArr;
        ICUResourceBundle iCUResourceBundleFindWithFallback;
        String[] strArr2;
        int size;
        ICUResourceBundle iCUResourceBundle;
        ICUResourceBundle iCUResourceBundle2;
        int type;
        ULocale uLocale2;
        ULocale uLocaleAddLikelySubtags;
        ICUResourceBundle iCUResourceBundle3 = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        ICUResourceBundle iCUResourceBundleFindWithFallback2 = iCUResourceBundle3.findWithFallback("calendar/" + str + "/DateTimePatterns");
        if (iCUResourceBundleFindWithFallback2 == null) {
            iCUResourceBundleFindWithFallback2 = iCUResourceBundle3.getWithFallback("calendar/gregorian/DateTimePatterns");
        }
        int size2 = iCUResourceBundleFindWithFallback2.getSize();
        String[] strArr3 = new String[size2];
        String[] strArr4 = new String[size2];
        if (uLocale.getKeywordValue("rg") != null || uLocale.getKeywordValue("hours") != null) {
            instanceNoStdPat = DateTimePatternGenerator.getInstanceNoStdPat(uLocale);
            i = 0;
            while (true) {
                strArr = TIME_SKELETONS;
                if (i < strArr.length) {
                    break;
                }
                strArr3[i] = instanceNoStdPat.getBestPattern(strArr[i]);
                i++;
            }
            while (i < size2) {
                iCUResourceBundle2 = (ICUResourceBundle) iCUResourceBundleFindWithFallback2.get(i);
                type = iCUResourceBundle2.getType();
                if (type == 0) {
                    strArr3[i] = iCUResourceBundle2.getString();
                } else if (type == 8) {
                    strArr3[i] = iCUResourceBundle2.getString(0);
                    strArr4[i] = iCUResourceBundle2.getString(1);
                }
                i++;
            }
            iCUResourceBundleFindWithFallback = iCUResourceBundle3.findWithFallback("calendar/" + str + "/DateTimePatterns%atTime");
            if (iCUResourceBundleFindWithFallback == null) {
                iCUResourceBundleFindWithFallback = iCUResourceBundle3.findWithFallback("calendar/gregorian/DateTimePatterns%atTime");
            }
            if (iCUResourceBundleFindWithFallback != null) {
                size = iCUResourceBundleFindWithFallback.getSize();
                strArr2 = new String[size];
                if (size >= 4) {
                    for (int i2 = 0; i2 < 4; i2++) {
                        iCUResourceBundle = (ICUResourceBundle) iCUResourceBundleFindWithFallback.get(i2);
                        if (iCUResourceBundle.getType() == 0) {
                            strArr2[i2] = iCUResourceBundle.getString();
                        }
                    }
                }
            } else {
                strArr2 = null;
            }
            return new PatternData(strArr3, strArr4, strArr2);
        }
        String baseName = uLocale.getBaseName();
        if (!baseName.isEmpty() && !baseName.equals("und") && (uLocaleAddLikelySubtags = ULocale.addLikelySubtags(iCUResourceBundleFindWithFallback2.getULocale())) != (uLocale2 = new ULocale(baseName))) {
            String country = uLocale2.getCountry();
            if ((!country.isEmpty() && !country.equals(uLocaleAddLikelySubtags.getCountry())) || !uLocale2.getLanguage().equals(uLocaleAddLikelySubtags.getLanguage())) {
                instanceNoStdPat = DateTimePatternGenerator.getInstanceNoStdPat(uLocale);
                i = 0;
                while (true) {
                    strArr = TIME_SKELETONS;
                    if (i < strArr.length) {
                        break;
                    }
                    strArr3[i] = instanceNoStdPat.getBestPattern(strArr[i]);
                    i++;
                }
                while (i < size2) {
                    iCUResourceBundle2 = (ICUResourceBundle) iCUResourceBundleFindWithFallback2.get(i);
                    type = iCUResourceBundle2.getType();
                    if (type == 0) {
                        strArr3[i] = iCUResourceBundle2.getString();
                    } else if (type == 8) {
                        strArr3[i] = iCUResourceBundle2.getString(0);
                        strArr4[i] = iCUResourceBundle2.getString(1);
                    }
                    i++;
                }
                iCUResourceBundleFindWithFallback = iCUResourceBundle3.findWithFallback("calendar/" + str + "/DateTimePatterns%atTime");
                if (iCUResourceBundleFindWithFallback == null) {
                    iCUResourceBundleFindWithFallback = iCUResourceBundle3.findWithFallback("calendar/gregorian/DateTimePatterns%atTime");
                }
                if (iCUResourceBundleFindWithFallback != null) {
                    size = iCUResourceBundleFindWithFallback.getSize();
                    strArr2 = new String[size];
                    if (size >= 4) {
                        while (i2 < 4) {
                            iCUResourceBundle = (ICUResourceBundle) iCUResourceBundleFindWithFallback.get(i2);
                            if (iCUResourceBundle.getType() == 0) {
                                strArr2[i2] = iCUResourceBundle.getString();
                            }
                        }
                    }
                } else {
                    strArr2 = null;
                }
                return new PatternData(strArr3, strArr4, strArr2);
            }
        }
        i = 0;
        while (i < size2) {
            iCUResourceBundle2 = (ICUResourceBundle) iCUResourceBundleFindWithFallback2.get(i);
            type = iCUResourceBundle2.getType();
            if (type == 0) {
                strArr3[i] = iCUResourceBundle2.getString();
            } else if (type == 8) {
                strArr3[i] = iCUResourceBundle2.getString(0);
                strArr4[i] = iCUResourceBundle2.getString(1);
            }
            i++;
        }
        iCUResourceBundleFindWithFallback = iCUResourceBundle3.findWithFallback("calendar/" + str + "/DateTimePatterns%atTime");
        if (iCUResourceBundleFindWithFallback == null) {
            iCUResourceBundleFindWithFallback = iCUResourceBundle3.findWithFallback("calendar/gregorian/DateTimePatterns%atTime");
        }
        if (iCUResourceBundleFindWithFallback != null) {
            size = iCUResourceBundleFindWithFallback.getSize();
            strArr2 = new String[size];
            if (size >= 4) {
                while (i2 < 4) {
                    iCUResourceBundle = (ICUResourceBundle) iCUResourceBundleFindWithFallback.get(i2);
                    if (iCUResourceBundle.getType() == 0) {
                        strArr2[i2] = iCUResourceBundle.getString();
                    }
                }
            }
        } else {
            strArr2 = null;
        }
        return new PatternData(strArr3, strArr4, strArr2);
    }

    private static Long getPreviousZoneTransitionTime(TimeZone timeZone, long j, long j2) {
        long j3 = (j - j2) - 1;
        int offset = timeZone.getOffset(j);
        if (offset == timeZone.getOffset(j3)) {
            return null;
        }
        return findPreviousZoneTransitionTime(timeZone, offset, j, j3);
    }

    private static String getRegionForCalendar(ULocale uLocale) {
        String regionForSupplementalData = ULocale.getRegionForSupplementalData(uLocale, true);
        return regionForSupplementalData.length() == 0 ? UnitsData.Constants.DEFAULT_REGION : regionForSupplementalData;
    }

    public static WeekData getWeekDataForRegion(String str) {
        return WEEK_DATA_CACHE.createInstance(str, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WeekData getWeekDataForRegionInternal(String str) {
        UResourceBundle uResourceBundle;
        if (str == null) {
            str = UnitsData.Constants.DEFAULT_REGION;
        }
        UResourceBundle uResourceBundle2 = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("weekData");
        try {
            uResourceBundle = uResourceBundle2.get(str);
        } catch (MissingResourceException e) {
            if (str.equals(UnitsData.Constants.DEFAULT_REGION)) {
                throw e;
            }
            uResourceBundle = uResourceBundle2.get(UnitsData.Constants.DEFAULT_REGION);
        }
        int[] intVector = uResourceBundle.getIntVector();
        return new WeekData(intVector[0], intVector[1], intVector[2], intVector[3], intVector[4], intVector[5]);
    }

    public static final int gregorianMonthLength(int i, int i2) {
        return GREGORIAN_MONTH_COUNT[i2][isGregorianLeapYear(i) ? 1 : 0];
    }

    public static final int gregorianPreviousMonthLength(int i, int i2) {
        if (i2 > 0) {
            return gregorianMonthLength(i, i2 - 1);
        }
        return 31;
    }

    private void initInternal() {
        int[] iArrHandleCreateFields = handleCreateFields();
        this.fields = iArrHandleCreateFields;
        if (iArrHandleCreateFields != null) {
            if (iArrHandleCreateFields.length >= 24 && iArrHandleCreateFields.length <= 32) {
                this.stamp = new byte[iArrHandleCreateFields.length];
                int i = 13107303;
                for (int i2 = 24; i2 < this.fields.length; i2++) {
                    i |= 1 << i2;
                }
                this.internalSetMask = i;
                return;
            }
        }
        og.n("Invalid fields[]");
    }

    public static final boolean isGregorianLeapYear(int i) {
        if (i % 4 == 0) {
            return i % 100 != 0 || i % 400 == 0;
        }
        return false;
    }

    public static final int julianDayToDayOfWeek(int i) {
        int i2 = (i + 2) % 7;
        return i2 < 1 ? i2 + 7 : i2;
    }

    public static final long julianDayToMillis(int i) {
        return ((long) (i - EPOCH_JULIAN_DAY)) * 86400000;
    }

    private static String mergeOverrideStrings(String str, String str2, String str3, String str4) {
        if (str3 == null && str4 == null) {
            return null;
        }
        if (str3 == null) {
            return expandOverride(str2, str4);
        }
        if (str4 == null) {
            return expandOverride(str, str3);
        }
        return str3.equals(str4) ? str3 : cq.k(expandOverride(str, str3), ";", expandOverride(str2, str4));
    }

    public static final int millisToJulianDay(long j) {
        return (int) (floorDivide(j, 86400000L) + 2440588);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        initInternal();
        this.isTimeSet = true;
        this.areAllFieldsSet = false;
        this.areFieldsSet = false;
        this.areFieldsVirtuallySet = true;
        this.nextStamp = (byte) 2;
    }

    private void recalculateStamp() {
        byte[] bArr;
        this.nextStamp = (byte) 1;
        for (int i = 0; i < this.stamp.length; i++) {
            byte b = STAMP_MAX;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                bArr = this.stamp;
                if (i3 >= bArr.length) {
                    break;
                }
                byte b2 = bArr[i3];
                if (b2 > this.nextStamp && b2 < b) {
                    i2 = i3;
                    b = b2;
                }
                i3++;
            }
            if (i2 < 0) {
                break;
            }
            byte b3 = (byte) (this.nextStamp + 1);
            this.nextStamp = b3;
            bArr[i2] = b3;
        }
        this.nextStamp = (byte) (this.nextStamp + 1);
    }

    private void setCalendarLocale(ULocale uLocale) {
        if (uLocale.getVariant().length() != 0 || uLocale.getKeywords() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(uLocale.getLanguage());
            String script = uLocale.getScript();
            if (script.length() > 0) {
                sb.append(BaseLocale.SEP);
                sb.append(script);
            }
            String country = uLocale.getCountry();
            if (country.length() > 0) {
                sb.append(BaseLocale.SEP);
                sb.append(country);
            }
            String keywordValue = uLocale.getKeywordValue("calendar");
            if (keywordValue != null) {
                sb.append("@calendar=");
                sb.append(keywordValue);
            }
            uLocale = new ULocale(sb.toString());
        }
        setLocale(uLocale, uLocale);
    }

    private void updateTime() {
        computeTime();
        if (isLenient() || !this.areAllFieldsSet) {
            this.areFieldsSet = false;
        }
        this.isTimeSet = true;
        this.areFieldsVirtuallySet = false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (!this.isTimeSet) {
            try {
                updateTime();
            } catch (IllegalArgumentException unused) {
            }
        }
        objectOutputStream.defaultWriteObject();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:63:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void add(int i, int i2) {
        long j;
        boolean z;
        long j2;
        int i3;
        int i4;
        if (i2 == 0) {
            return;
        }
        long j3 = i2;
        int i5 = 0;
        switch (i) {
            case 0:
                set(i, get(i) + i2);
                pinField(0);
                return;
            case 1:
            case 17:
                if (get(0) == 0 && isEra0CountingBackward()) {
                    i2 = -i2;
                    break;
                }
            case 2:
            case 19:
            case 23:
                boolean zIsLenient = isLenient();
                setLenient(true);
                set(i, get(i) + i2);
                pinField(5);
                if (zIsLenient) {
                    return;
                }
                complete();
                setLenient(zIsLenient);
                return;
            case 3:
            case 4:
            case 8:
                j = ONE_WEEK;
                j3 *= j;
                z = true;
                if (z) {
                    i3 = get(16) + get(15);
                    i5 = get(21);
                } else {
                    i3 = 0;
                }
                setTimeInMillis(getTimeInMillis() + j3);
                if (z || (i4 = get(21)) == i5) {
                    return;
                }
                long jInternalGetTimeInMillis = internalGetTimeInMillis();
                int i6 = get(15) + get(16);
                if (i6 != i3) {
                    long j4 = ((long) (i3 - i6)) % 86400000;
                    if (j4 != 0) {
                        setTimeInMillis(j4 + jInternalGetTimeInMillis);
                        i4 = get(21);
                    }
                    if (i4 != i5) {
                        int i7 = this.skippedWallTime;
                        if (i7 == 0) {
                            if (j4 < 0) {
                                setTimeInMillis(jInternalGetTimeInMillis);
                                return;
                            }
                            return;
                        }
                        if (i7 == 1) {
                            if (j4 > 0) {
                                setTimeInMillis(jInternalGetTimeInMillis);
                                return;
                            }
                            return;
                        } else {
                            if (i7 != 2) {
                                return;
                            }
                            if (j4 > 0) {
                                jInternalGetTimeInMillis = internalGetTimeInMillis();
                            }
                            Long immediatePreviousZoneTransition = getImmediatePreviousZoneTransition(jInternalGetTimeInMillis);
                            if (immediatePreviousZoneTransition != null) {
                                setTimeInMillis(immediatePreviousZoneTransition.longValue());
                                return;
                            } else {
                                throw new RuntimeException("Could not locate a time zone transition before " + jInternalGetTimeInMillis);
                            }
                        }
                    }
                    return;
                }
                return;
            case 5:
            case 6:
            case 7:
            case 18:
            case 20:
                j3 *= 86400000;
                z = true;
                if (z) {
                    i3 = get(16) + get(15);
                    i5 = get(21);
                } else {
                    i3 = 0;
                }
                setTimeInMillis(getTimeInMillis() + j3);
                if (z) {
                    return;
                } else {
                    return;
                }
            case 9:
                j = 43200000;
                j3 *= j;
                z = true;
                if (z) {
                    i3 = get(16) + get(15);
                    i5 = get(21);
                } else {
                    i3 = 0;
                }
                setTimeInMillis(getTimeInMillis() + j3);
                if (z) {
                    return;
                } else {
                    return;
                }
            case 10:
            case 11:
                j2 = 3600000;
                j3 *= j2;
                z = false;
                if (z) {
                    i3 = get(16) + get(15);
                    i5 = get(21);
                } else {
                    i3 = 0;
                }
                setTimeInMillis(getTimeInMillis() + j3);
                if (z) {
                    return;
                } else {
                    return;
                }
            case 12:
                j2 = 60000;
                j3 *= j2;
                z = false;
                if (z) {
                    i3 = get(16) + get(15);
                    i5 = get(21);
                } else {
                    i3 = 0;
                }
                setTimeInMillis(getTimeInMillis() + j3);
                if (z) {
                    return;
                } else {
                    return;
                }
            case 13:
                j2 = 1000;
                j3 *= j2;
                z = false;
                if (z) {
                    i3 = get(16) + get(15);
                    i5 = get(21);
                } else {
                    i3 = 0;
                }
                setTimeInMillis(getTimeInMillis() + j3);
                if (z) {
                    return;
                } else {
                    return;
                }
            case 14:
            case 21:
                z = false;
                if (z) {
                    i3 = get(16) + get(15);
                    i5 = get(21);
                } else {
                    i3 = 0;
                }
                setTimeInMillis(getTimeInMillis() + j3);
                if (z) {
                    return;
                } else {
                    return;
                }
            case 15:
            case 16:
            case 22:
            default:
                og.i(cq.v("Calendar.add(", fieldName(i), ") not supported"));
                return;
        }
    }

    public boolean after(Object obj) {
        return compare(obj) > 0;
    }

    public boolean before(Object obj) {
        return compare(obj) < 0;
    }

    public final void clear(int i) {
        if (this.areFieldsVirtuallySet) {
            computeFields();
        }
        int[] iArr = this.fields;
        iArr[i] = 0;
        byte[] bArr = this.stamp;
        bArr[i] = 0;
        if (i == 2) {
            iArr[23] = 0;
            bArr[23] = 0;
        }
        if (i == 23) {
            iArr[2] = 0;
            bArr[2] = 0;
        }
        this.areFieldsVirtuallySet = false;
        this.areAllFieldsSet = false;
        this.areFieldsSet = false;
        this.isTimeSet = false;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Calendar mo22clone() {
        try {
            Calendar calendar = (Calendar) super.clone();
            int[] iArr = new int[this.fields.length];
            calendar.fields = iArr;
            int[] iArr2 = this.fields;
            calendar.stamp = new byte[iArr2.length];
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            System.arraycopy(this.stamp, 0, calendar.stamp, 0, this.fields.length);
            calendar.zone = this.zone.mo3clone();
            return calendar;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Calendar calendar) {
        long timeInMillis = getTimeInMillis() - calendar.getTimeInMillis();
        if (timeInMillis < 0) {
            return -1;
        }
        return timeInMillis > 0 ? 1 : 0;
    }

    public void complete() {
        if (!this.isTimeSet) {
            updateTime();
        }
        if (this.areFieldsSet) {
            return;
        }
        computeFields();
        this.areFieldsSet = true;
        this.areAllFieldsSet = true;
    }

    public void computeFields() {
        int[] iArr = new int[2];
        getTimeZone().getOffset(this.time, false, iArr);
        long j = this.time + ((long) iArr[0]) + ((long) iArr[1]);
        int i = this.internalSetMask;
        for (int i2 = 0; i2 < this.fields.length; i2++) {
            int i3 = i & 1;
            byte[] bArr = this.stamp;
            if (i3 == 0) {
                bArr[i2] = 1;
            } else {
                bArr[i2] = 0;
            }
            i >>= 1;
        }
        long jFloorDivide = floorDivide(j, 86400000L);
        int[] iArr2 = this.fields;
        int i4 = ((int) jFloorDivide) + EPOCH_JULIAN_DAY;
        iArr2[20] = i4;
        computeGregorianAndDOWFields(i4);
        handleComputeFields(this.fields[20]);
        computeWeekFields();
        int i5 = (int) (j - (jFloorDivide * 86400000));
        int[] iArr3 = this.fields;
        iArr3[21] = i5;
        iArr3[14] = i5 % 1000;
        int i6 = i5 / 1000;
        iArr3[13] = i6 % 60;
        int i7 = i6 / 60;
        iArr3[12] = i7 % 60;
        int i8 = i7 / 60;
        iArr3[11] = i8;
        iArr3[9] = i8 / 12;
        iArr3[10] = i8 % 12;
        iArr3[15] = iArr[0];
        iArr3[16] = iArr[1];
    }

    public final void computeGregorianFields(int i) {
        int[] iArrDayToFields = Grego.dayToFields(i - EPOCH_JULIAN_DAY, null);
        this.gregorianYear = iArrDayToFields[0];
        this.gregorianMonth = iArrDayToFields[1];
        this.gregorianDayOfMonth = iArrDayToFields[2];
        this.gregorianDayOfYear = iArrDayToFields[4];
    }

    public int computeGregorianMonthStart(int i, int i2) {
        boolean z = false;
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
            z = true;
        }
        int i3 = i - 1;
        int iFloorDivide = floorDivide(i3, 400) + ((floorDivide(i3, 4) + (i3 * 365)) - floorDivide(i3, 100)) + 1721425;
        if (i2 != 0) {
            return iFloorDivide + GREGORIAN_MONTH_COUNT[i2][z ? (char) 3 : (char) 2];
        }
        return iFloorDivide;
    }

    public int computeJulianDay() {
        if (this.stamp[20] >= 2 && newestStamp(23, 23, newestStamp(17, 19, newestStamp(0, 8, 0))) <= this.stamp[20]) {
            return internalGet(20);
        }
        int iResolveFields = resolveFields(getFieldResolutionTable());
        if (iResolveFields < 0) {
            iResolveFields = 5;
        }
        return handleComputeJulianDay(iResolveFields);
    }

    @Deprecated
    public int computeMillisInDay() {
        int iInternalGet;
        byte[] bArr = this.stamp;
        byte b = bArr[11];
        int iMax = Math.max((int) bArr[10], (int) bArr[9]);
        if (iMax <= b) {
            iMax = b;
        }
        if (iMax != 0) {
            iInternalGet = iMax == b ? internalGet(11) : internalGet(10) + (internalGet(9) * 12);
        } else {
            iInternalGet = 0;
        }
        return internalGet(14) + ((internalGet(13) + ((internalGet(12) + (iInternalGet * 60)) * 60)) * 1000);
    }

    @Deprecated
    public long computeMillisInDayLong() {
        long jInternalGet;
        byte[] bArr = this.stamp;
        byte b = bArr[11];
        int iMax = Math.max((int) bArr[10], (int) bArr[9]);
        if (iMax <= b) {
            iMax = b;
        }
        if (iMax != 0) {
            jInternalGet = iMax == b ? internalGet(11) : ((long) internalGet(10)) + ((long) (internalGet(9) * 12));
        } else {
            jInternalGet = 0;
        }
        return (((((jInternalGet * 60) + ((long) internalGet(12))) * 60) + ((long) internalGet(13))) * 1000) + ((long) internalGet(14));
    }

    public void computeTime() {
        int iComputeMillisInDay;
        long jComputeMillisInDayLong;
        byte[] bArr;
        if (!isLenient()) {
            validateFields();
        }
        long jJulianDayToMillis = julianDayToMillis(computeJulianDay());
        if (this.stamp[21] < 2 || newestStamp(9, 14, 0) > this.stamp[21]) {
            if (Math.max(Math.abs(internalGet(11)), Math.abs(internalGet(10))) > MAX_HOURS) {
                jComputeMillisInDayLong = computeMillisInDayLong();
            } else {
                iComputeMillisInDay = computeMillisInDay();
            }
            bArr = this.stamp;
            if (bArr[15] < 2 || bArr[16] >= 2) {
                this.time = (jJulianDayToMillis + jComputeMillisInDayLong) - ((long) (internalGet(16) + internalGet(15)));
            }
            if (this.lenient && this.skippedWallTime != 2) {
                this.time = (jJulianDayToMillis + jComputeMillisInDayLong) - ((long) computeZoneOffset(jJulianDayToMillis, jComputeMillisInDayLong));
                return;
            }
            int iComputeZoneOffset = computeZoneOffset(jJulianDayToMillis, jComputeMillisInDayLong);
            long j = (jJulianDayToMillis + jComputeMillisInDayLong) - ((long) iComputeZoneOffset);
            if (iComputeZoneOffset == this.zone.getOffset(j)) {
                this.time = j;
                return;
            }
            if (!this.lenient) {
                og.i("The specified wall time does not exist due to time zone offset transition.");
                return;
            }
            Long immediatePreviousZoneTransition = getImmediatePreviousZoneTransition(j);
            if (immediatePreviousZoneTransition != null) {
                this.time = immediatePreviousZoneTransition.longValue();
                return;
            } else {
                throw new RuntimeException("Could not locate a time zone transition before " + j);
            }
        }
        iComputeMillisInDay = internalGet(21);
        jComputeMillisInDayLong = iComputeMillisInDay;
        bArr = this.stamp;
        if (bArr[15] < 2) {
        }
        this.time = (jJulianDayToMillis + jComputeMillisInDayLong) - ((long) (internalGet(16) + internalGet(15)));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    @Deprecated
    public int computeZoneOffset(long j, int i) {
        int[] iArr = new int[2];
        long j2 = j + ((long) i);
        TimeZone timeZone = this.zone;
        if (timeZone instanceof BasicTimeZone) {
            ((BasicTimeZone) timeZone).getOffsetFromLocal(j2, this.skippedWallTime == 1 ? BasicTimeZone.LocalOption.LATTER : BasicTimeZone.LocalOption.FORMER, this.repeatedWallTime == 1 ? BasicTimeZone.LocalOption.FORMER : BasicTimeZone.LocalOption.LATTER, iArr);
        } else {
            timeZone.getOffset(j2, true, iArr);
            if (this.repeatedWallTime == 1) {
                int offset = (iArr[0] + iArr[1]) - this.zone.getOffset((j2 - ((long) (iArr[0] + iArr[1]))) - 21600000);
                if (offset < 0) {
                    this.zone.getOffset(j2 + ((long) offset), true, iArr);
                } else if (this.skippedWallTime == 1) {
                    this.zone.getOffset(j2 - ((long) (iArr[0] + iArr[1])), false, iArr);
                }
            } else if (this.skippedWallTime == 1) {
                this.zone.getOffset(j2 - ((long) (iArr[0] + iArr[1])), false, iArr);
            }
        }
        return iArr[0] + iArr[1];
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Calendar calendar = (Calendar) obj;
        return isEquivalentTo(calendar) && getTimeInMillis() == calendar.getTime().getTime();
    }

    public int fieldDifference(Date date, int i) {
        long timeInMillis = getTimeInMillis();
        long time = date.getTime();
        int i2 = 0;
        if (timeInMillis < time) {
            int i3 = 0;
            int i4 = 1;
            while (true) {
                setTimeInMillis(timeInMillis);
                add(i, i4);
                long timeInMillis2 = getTimeInMillis();
                if (timeInMillis2 == time) {
                    return i4;
                }
                if (timeInMillis2 > time) {
                    while (true) {
                        int i5 = i4 - i3;
                        if (i5 <= 1) {
                            i2 = i3;
                            break;
                        }
                        int i6 = (i5 / 2) + i3;
                        setTimeInMillis(timeInMillis);
                        add(i, i6);
                        long timeInMillis3 = getTimeInMillis();
                        if (timeInMillis3 == time) {
                            return i6;
                        }
                        if (timeInMillis3 > time) {
                            i4 = i6;
                        } else {
                            i3 = i6;
                        }
                    }
                } else {
                    int i7 = Integer.MAX_VALUE;
                    if (i4 >= Integer.MAX_VALUE) {
                        throw new RuntimeException();
                    }
                    int i8 = i4 << 1;
                    if (i8 >= 0) {
                        i7 = i8;
                    }
                    int i9 = i4;
                    i4 = i7;
                    i3 = i9;
                }
            }
        } else if (timeInMillis > time) {
            int i10 = -1;
            do {
                int i11 = i2;
                i2 = i10;
                setTimeInMillis(timeInMillis);
                add(i, i2);
                long timeInMillis4 = getTimeInMillis();
                if (timeInMillis4 == time) {
                    return i2;
                }
                if (timeInMillis4 < time) {
                    i2 = i11;
                    int i12 = i2;
                    while (i2 - i12 > 1) {
                        int i13 = ((i12 - i2) / 2) + i2;
                        setTimeInMillis(timeInMillis);
                        add(i, i13);
                        long timeInMillis5 = getTimeInMillis();
                        if (timeInMillis5 == time) {
                            return i13;
                        }
                        if (timeInMillis5 < time) {
                            i12 = i13;
                        } else {
                            i2 = i13;
                        }
                    }
                } else {
                    i10 = i2 << 1;
                }
            } while (i10 != 0);
            throw new RuntimeException();
        }
        setTimeInMillis(timeInMillis);
        add(i, i2);
        return i2;
    }

    public String fieldName(int i) {
        try {
            return FIELD_NAME[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            return ky0.h(i, "Field ");
        }
    }

    public final int get(int i) {
        complete();
        return this.fields[i];
    }

    public int getActualMaximum(int i) {
        if (i != 0 && i != 18) {
            if (i == 23) {
                return inTemporalLeapYear() ? getMaximum(23) : getLeastMaximum(23);
            }
            if (i == 5) {
                Calendar calendarMo22clone = mo22clone();
                calendarMo22clone.setLenient(true);
                calendarMo22clone.prepareGetActual(i, false);
                return handleGetMonthLength(calendarMo22clone.get(19), calendarMo22clone.get(2));
            }
            if (i == 6) {
                Calendar calendarMo22clone2 = mo22clone();
                calendarMo22clone2.setLenient(true);
                calendarMo22clone2.prepareGetActual(i, false);
                return handleGetYearLength(calendarMo22clone2.get(19));
            }
            if (i != 7 && i != 20 && i != 21) {
                switch (i) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        break;
                    default:
                        return getActualHelper(i, getLeastMaximum(i), getMaximum(i));
                }
            }
        }
        return getMaximum(i);
    }

    public int getActualMinimum(int i) {
        switch (i) {
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 20:
            case 21:
                return getMinimum(i);
            case 8:
            case 17:
            case 19:
            default:
                return getActualHelper(i, getGreatestMinimum(i), getMinimum(i));
        }
    }

    public DateFormat getDateTimeFormat(int i, int i2, Locale locale) {
        return formatHelper(this, ULocale.forLocale(locale), i, i2);
    }

    @Deprecated
    public int getDayOfWeekType(int i) {
        if (i < 1 || i > 7) {
            og.i("Invalid day of week");
            return 0;
        }
        int i2 = this.weekendOnset;
        int i3 = this.weekendCease;
        if (i2 == i3) {
            if (i != i2) {
                return 0;
            }
            return this.weekendOnsetMillis == 0 ? 1 : 2;
        }
        if (i2 < i3) {
            if (i < i2 || i > i3) {
                return 0;
            }
        } else if (i > i3 && i < i2) {
            return 0;
        }
        if (i == i2) {
            return this.weekendOnsetMillis == 0 ? 1 : 2;
        }
        return (i != i3 || this.weekendCeaseMillis >= 86400000) ? 1 : 3;
    }

    public int getDefaultDayInMonth(int i, int i2) {
        return 1;
    }

    public int getDefaultMonthInYear(int i) {
        return 0;
    }

    public String getDisplayName(Locale locale) {
        return getClass().getName();
    }

    public final int getFieldCount() {
        return this.fields.length;
    }

    public int[][][] getFieldResolutionTable() {
        return DATE_PRECEDENCE;
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public final int getGreatestMinimum(int i) {
        return getLimit(i, 1);
    }

    public final int getGregorianDayOfMonth() {
        return this.gregorianDayOfMonth;
    }

    public final int getGregorianDayOfYear() {
        return this.gregorianDayOfYear;
    }

    public final int getGregorianMonth() {
        return this.gregorianMonth;
    }

    public final int getGregorianYear() {
        return this.gregorianYear;
    }

    public final int getLeastMaximum(int i) {
        return getLimit(i, 2);
    }

    public int getLimit(int i, int i2) {
        switch (i) {
            case 4:
                if (i2 == 0) {
                    return getMinimalDaysInFirstWeek() == 1 ? 1 : 0;
                }
                if (i2 == 1) {
                    return 1;
                }
                int minimalDaysInFirstWeek = getMinimalDaysInFirstWeek();
                int iHandleGetLimit = handleGetLimit(5, i2);
                if (i2 == 2) {
                    return ((7 - minimalDaysInFirstWeek) + iHandleGetLimit) / 7;
                }
                return ((7 - minimalDaysInFirstWeek) + (iHandleGetLimit + 6)) / 7;
            case 5:
            case 6:
            case 8:
            case 17:
            case 19:
            default:
                return handleGetLimit(i, i2);
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 20:
            case 21:
            case 22:
                return LIMITS[i][i2];
        }
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    public final int getMaximum(int i) {
        return getLimit(i, 3);
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDaysInFirstWeek;
    }

    public final int getMinimum(int i) {
        return getLimit(i, 0);
    }

    @Deprecated
    public int getRelatedYear() {
        return getRelatedYearDifference() + get(19);
    }

    @Deprecated
    public int getRelatedYearDifference() {
        return 0;
    }

    public int getRepeatedWallTimeOption() {
        return this.repeatedWallTime;
    }

    public int getSkippedWallTimeOption() {
        return this.skippedWallTime;
    }

    public final int getStamp(int i) {
        return this.stamp[i];
    }

    public String getTemporalMonthCode() {
        return gTemporalMonthCodes[get(2)];
    }

    public final Date getTime() {
        return new Date(getTimeInMillis());
    }

    public long getTimeInMillis() {
        if (!this.isTimeSet) {
            updateTime();
        }
        return this.time;
    }

    public TimeZone getTimeZone() {
        return this.zone;
    }

    public String getType() {
        return "unknown";
    }

    public WeekData getWeekData() {
        return new WeekData(this.firstDayOfWeek, this.minimalDaysInFirstWeek, this.weekendOnset, this.weekendOnsetMillis, this.weekendCease, this.weekendCeaseMillis);
    }

    @Deprecated
    public int getWeekendTransition(int i) {
        if (i == this.weekendOnset) {
            return this.weekendOnsetMillis;
        }
        if (i == this.weekendCease) {
            return this.weekendCeaseMillis;
        }
        og.i("Not weekend transition day");
        return 0;
    }

    public void handleComputeFields(int i) {
        int i2;
        int gregorianMonth = getGregorianMonth();
        internalSet(2, gregorianMonth);
        internalSet(23, gregorianMonth);
        internalSet(5, getGregorianDayOfMonth());
        internalSet(6, getGregorianDayOfYear());
        int gregorianYear = getGregorianYear();
        internalSet(19, gregorianYear);
        if (gregorianYear < 1) {
            gregorianYear = 1 - gregorianYear;
            i2 = 0;
        } else {
            i2 = 1;
        }
        internalSet(0, i2);
        internalSet(1, gregorianYear);
    }

    public int handleComputeJulianDay(int i) {
        int iInternalGet;
        int iInternalGet2;
        int i2;
        int iInternalGet3;
        boolean z = i == 5 || i == 4 || i == 8;
        int iInternalGet4 = (i == 3 && newerField(17, 1) == 17) ? internalGet(17) : handleGetExtendedYear();
        internalSet(19, iInternalGet4);
        int iInternalGetMonth = z ? internalGetMonth(getDefaultMonthInYear(iInternalGet4)) : 0;
        int iHandleComputeMonthStart = handleComputeMonthStart(iInternalGet4, iInternalGetMonth, z);
        if (i == 5) {
            iInternalGet3 = isSet(5) ? internalGet(5, getDefaultDayInMonth(iInternalGet4, iInternalGetMonth)) : getDefaultDayInMonth(iInternalGet4, iInternalGetMonth);
        } else {
            if (i != 6) {
                int firstDayOfWeek = getFirstDayOfWeek();
                int iJulianDayToDayOfWeek = julianDayToDayOfWeek(iHandleComputeMonthStart + 1) - firstDayOfWeek;
                if (iJulianDayToDayOfWeek < 0) {
                    iJulianDayToDayOfWeek += 7;
                }
                int iResolveFields = resolveFields(DOW_PRECEDENCE);
                if (iResolveFields != 7) {
                    iInternalGet = iResolveFields != 18 ? 0 : internalGet(18) - 1;
                } else {
                    iInternalGet = internalGet(7) - firstDayOfWeek;
                }
                int i3 = iInternalGet % 7;
                if (i3 < 0) {
                    i3 += 7;
                }
                int i4 = (1 - iJulianDayToDayOfWeek) + i3;
                if (i == 8) {
                    if (i4 < 1) {
                        i4 += 7;
                    }
                    int iInternalGet5 = internalGet(8, 1);
                    if (iInternalGet5 >= 0) {
                        i2 = ((iInternalGet5 - 1) * 7) + i4;
                    } else {
                        iInternalGet2 = ((handleGetMonthLength(iInternalGet4, internalGetMonth(0)) - i4) / 7) + iInternalGet5 + 1;
                    }
                    return iHandleComputeMonthStart + i2;
                }
                if (7 - iJulianDayToDayOfWeek < getMinimalDaysInFirstWeek()) {
                    i4 += 7;
                }
                iInternalGet2 = internalGet(i) - 1;
                i2 = (iInternalGet2 * 7) + i4;
                return iHandleComputeMonthStart + i2;
            }
            iInternalGet3 = internalGet(6);
        }
        return iInternalGet3 + iHandleComputeMonthStart;
    }

    public abstract int handleComputeMonthStart(int i, int i2, boolean z);

    public int[] handleCreateFields() {
        return new int[24];
    }

    public DateFormat handleGetDateFormat(String str, String str2, ULocale uLocale) {
        FormatConfiguration formatConfiguration = new FormatConfiguration(0);
        formatConfiguration.pattern = str;
        formatConfiguration.override = str2;
        formatConfiguration.formatData = new DateFormatSymbols(this, uLocale);
        formatConfiguration.loc = uLocale;
        formatConfiguration.cal = this;
        return SimpleDateFormat.getInstance(formatConfiguration);
    }

    public abstract int handleGetExtendedYear();

    public abstract int handleGetLimit(int i, int i2);

    public int handleGetMonthLength(int i, int i2) {
        System.out.printf("handleGetMonthLength(ey=%d, m=%d)", Integer.valueOf(i), Integer.valueOf(i2));
        return handleComputeMonthStart(i, i2 + 1, true) - handleComputeMonthStart(i, i2, true);
    }

    public int handleGetYearLength(int i) {
        return handleComputeMonthStart(i + 1, 0, false) - handleComputeMonthStart(i, 0, false);
    }

    public int hashCode() {
        boolean z = this.lenient;
        return (this.zone.hashCode() << 11) | (z ? 1 : 0) | (this.firstDayOfWeek << 1) | (this.minimalDaysInFirstWeek << 4) | (this.repeatedWallTime << 7) | (this.skippedWallTime << 9);
    }

    @Deprecated
    public boolean haveDefaultCentury() {
        return true;
    }

    public boolean inTemporalLeapYear() {
        return getActualMaximum(6) == 366;
    }

    public final int internalGet(int i, int i2) {
        return this.stamp[i] > 0 ? this.fields[i] : i2;
    }

    @Deprecated
    public int internalGetMonth() {
        return resolveFields(MONTH_PRECEDENCE) == 2 ? internalGet(2) : internalGet(23);
    }

    public final long internalGetTimeInMillis() {
        return this.time;
    }

    public final void internalSet(int i, int i2) {
        if (((1 << i) & this.internalSetMask) == 0) {
            og.n(cq.j("Subclass cannot set ", fieldName(i)));
        } else {
            this.fields[i] = i2;
            this.stamp[i] = 1;
        }
    }

    public boolean isEquivalentTo(Calendar calendar) {
        return getClass() == calendar.getClass() && isLenient() == calendar.isLenient() && getFirstDayOfWeek() == calendar.getFirstDayOfWeek() && getMinimalDaysInFirstWeek() == calendar.getMinimalDaysInFirstWeek() && getTimeZone().equals(calendar.getTimeZone()) && getRepeatedWallTimeOption() == calendar.getRepeatedWallTimeOption() && getSkippedWallTimeOption() == calendar.getSkippedWallTimeOption();
    }

    @Deprecated
    public boolean isEra0CountingBackward() {
        return false;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public final boolean isSet(int i) {
        return this.areFieldsVirtuallySet || this.stamp[i] != 0;
    }

    public boolean isWeekend() {
        int i = get(7);
        int dayOfWeekType = getDayOfWeekType(i);
        if (dayOfWeekType == 0) {
            return false;
        }
        if (dayOfWeekType == 1) {
            return true;
        }
        int iInternalGet = (((((internalGet(11) * 60) + internalGet(12)) * 60) + internalGet(13)) * 1000) + internalGet(14);
        int weekendTransition = getWeekendTransition(i);
        if (dayOfWeekType == 2) {
            return iInternalGet >= weekendTransition;
        }
        return iInternalGet < weekendTransition;
    }

    public int newerField(int i, int i2) {
        byte[] bArr = this.stamp;
        return bArr[i2] > bArr[i] ? i2 : i;
    }

    public int newestStamp(int i, int i2, int i3) {
        while (i <= i2) {
            byte b = this.stamp[i];
            if (b > i3) {
                i3 = b;
            }
            i++;
        }
        return i3;
    }

    public void pinField(int i) {
        int actualMaximum = getActualMaximum(i);
        int actualMinimum = getActualMinimum(i);
        int i2 = this.fields[i];
        if (i2 > actualMaximum) {
            set(i, actualMaximum);
        } else if (i2 < actualMinimum) {
            set(i, actualMinimum);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    public void prepareGetActual(int i, boolean z) {
        set(21, 0);
        if (i == 1) {
            set(6, getGreatestMinimum(6));
        } else if (i == 2) {
            set(5, getGreatestMinimum(5));
        } else if (i == 3 || i == 4) {
            int i2 = this.firstDayOfWeek;
            if (z && (i2 = (i2 + 6) % 7) < 1) {
                i2 += 7;
            }
            set(7, i2);
        } else if (i == 8) {
            set(5, 1);
            set(7, get(7));
        } else if (i == 17) {
            set(3, getGreatestMinimum(3));
        } else if (i == 19) {
            set(6, getGreatestMinimum(6));
        }
        set(i, getGreatestMinimum(i));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0042 A[PHI: r7
      0x0042: PHI (r7v3 int) = (r7v2 int), (r7v5 int), (r7v5 int) binds: [B:22:0x0032, B:24:0x0037, B:26:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    public int resolveFields(int[][][] iArr) {
        int i = -1;
        for (int i2 = 0; i2 < iArr.length && i < 0; i2++) {
            int i3 = 0;
            for (int[] iArr2 : iArr[i2]) {
                int i4 = iArr2[0] >= 32 ? 1 : 0;
                int iMax = 0;
                while (true) {
                    if (i4 >= iArr2.length) {
                        if (iMax > i3) {
                            int i5 = iArr2[0];
                            if (i5 < 32 || (i5 = i5 & 31) != 5) {
                                i = i5;
                            } else {
                                byte[] bArr = this.stamp;
                                if (bArr[4] < bArr[i5]) {
                                    i = i5;
                                }
                            }
                            if (i != i5) {
                                break;
                            }
                            i3 = iMax;
                            break;
                        }
                        break;
                    }
                    byte b = this.stamp[iArr2[i4]];
                    if (b == 0) {
                        break;
                    }
                    iMax = Math.max(iMax, (int) b);
                    i4++;
                }
            }
        }
        return i >= 32 ? i & 31 : i;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b6  */
    public void roll(int i, int i2) {
        if (i2 == 0) {
        }
        complete();
        int i3 = 1;
        switch (i) {
            case 0:
            case 5:
            case 9:
            case 12:
            case 13:
            case 14:
            case 21:
                int actualMinimum = getActualMinimum(i);
                int actualMaximum = (getActualMaximum(i) - actualMinimum) + 1;
                int iInternalGet = ((internalGet(i) + i2) - actualMinimum) % actualMaximum;
                if (iInternalGet < 0) {
                    iInternalGet += actualMaximum;
                }
                set(i, iInternalGet + actualMinimum);
                break;
            case 1:
            case 17:
                int i4 = get(0);
                if (i4 == 0 && isEra0CountingBackward()) {
                    i2 = -i2;
                }
                int iInternalGet2 = internalGet(i) + i2;
                if (i4 > 0 || iInternalGet2 >= 1) {
                    int actualMaximum2 = getActualMaximum(i);
                    if (actualMaximum2 < 32768) {
                        if (iInternalGet2 < 1) {
                            i3 = actualMaximum2 - ((-iInternalGet2) % actualMaximum2);
                        } else if (iInternalGet2 > actualMaximum2) {
                            i3 = 1 + ((iInternalGet2 - 1) % actualMaximum2);
                        } else {
                            i3 = iInternalGet2;
                        }
                    } else if (iInternalGet2 >= 1) {
                        i3 = iInternalGet2;
                    }
                } else if (i4 != 0 || !isEra0CountingBackward()) {
                    i3 = iInternalGet2;
                }
                set(i, i3);
                pinField(2);
                pinField(5);
                break;
            case 2:
            case 23:
                int actualMaximum3 = getActualMaximum(2) + 1;
                int iInternalGetMonth = (internalGetMonth() + i2) % actualMaximum3;
                if (iInternalGetMonth < 0) {
                    iInternalGetMonth += actualMaximum3;
                }
                set(2, iInternalGetMonth);
                pinField(5);
                break;
            case 3:
                int iInternalGet3 = internalGet(7) - getFirstDayOfWeek();
                if (iInternalGet3 < 0) {
                    iInternalGet3 += 7;
                }
                int iInternalGet4 = ((iInternalGet3 - internalGet(6)) + 1) % 7;
                if (iInternalGet4 < 0) {
                    iInternalGet4 += 7;
                }
                int i5 = 7 - iInternalGet4 < getMinimalDaysInFirstWeek() ? 8 - iInternalGet4 : 1 - iInternalGet4;
                int actualMaximum4 = getActualMaximum(6);
                int iInternalGet5 = ((actualMaximum4 + 7) - (((actualMaximum4 - internalGet(6)) + iInternalGet3) % 7)) - i5;
                int iInternalGet6 = (((i2 * 7) + internalGet(6)) - i5) % iInternalGet5;
                if (iInternalGet6 < 0) {
                    iInternalGet6 += iInternalGet5;
                }
                int i6 = iInternalGet6 + i5;
                i3 = i6 >= 1 ? i6 : 1;
                if (i3 <= actualMaximum4) {
                    actualMaximum4 = i3;
                }
                set(6, actualMaximum4);
                clear(2);
                clear(23);
                break;
            case 4:
                int iInternalGet7 = internalGet(7) - getFirstDayOfWeek();
                if (iInternalGet7 < 0) {
                    iInternalGet7 += 7;
                }
                int iInternalGet8 = ((iInternalGet7 - internalGet(5)) + 1) % 7;
                if (iInternalGet8 < 0) {
                    iInternalGet8 += 7;
                }
                int i7 = 7 - iInternalGet8 < getMinimalDaysInFirstWeek() ? 8 - iInternalGet8 : 1 - iInternalGet8;
                int actualMaximum5 = getActualMaximum(5);
                int iInternalGet9 = ((actualMaximum5 + 7) - (((actualMaximum5 - internalGet(5)) + iInternalGet7) % 7)) - i7;
                int iInternalGet10 = (((i2 * 7) + internalGet(5)) - i7) % iInternalGet9;
                if (iInternalGet10 < 0) {
                    iInternalGet10 += iInternalGet9;
                }
                int i8 = iInternalGet10 + i7;
                i3 = i8 >= 1 ? i8 : 1;
                if (i3 <= actualMaximum5) {
                    actualMaximum5 = i3;
                }
                set(5, actualMaximum5);
                break;
            case 6:
                long jInternalGet = this.time - (((long) (internalGet(6) - 1)) * 86400000);
                long actualMaximum6 = ((long) getActualMaximum(6)) * 86400000;
                long j = ((this.time + (((long) i2) * 86400000)) - jInternalGet) % actualMaximum6;
                this.time = j;
                if (j < 0) {
                    this.time = j + actualMaximum6;
                }
                setTimeInMillis(this.time + jInternalGet);
                break;
            case 7:
            case 18:
                long j2 = ((long) i2) * 86400000;
                int iInternalGet11 = internalGet(i) - (i == 7 ? getFirstDayOfWeek() : 1);
                if (iInternalGet11 < 0) {
                    iInternalGet11 += 7;
                }
                long j3 = this.time;
                long j4 = j3 - (((long) iInternalGet11) * 86400000);
                long j5 = ((j3 + j2) - j4) % ONE_WEEK;
                this.time = j5;
                if (j5 < 0) {
                    this.time = j5 + ONE_WEEK;
                }
                setTimeInMillis(this.time + j4);
                break;
            case 8:
                long j6 = ((long) i2) * ONE_WEEK;
                int iInternalGet12 = (internalGet(5) - 1) / 7;
                int actualMaximum7 = (getActualMaximum(5) - internalGet(5)) / 7;
                long j7 = this.time;
                long j8 = j7 - (((long) iInternalGet12) * ONE_WEEK);
                long j9 = ((long) (iInternalGet12 + actualMaximum7 + 1)) * ONE_WEEK;
                long j10 = ((j7 + j6) - j8) % j9;
                this.time = j10;
                if (j10 < 0) {
                    this.time = j10 + j9;
                }
                setTimeInMillis(this.time + j8);
                break;
            case 10:
            case 11:
                long timeInMillis = getTimeInMillis();
                int iInternalGet13 = internalGet(i);
                int maximum = getMaximum(i) + 1;
                int i9 = (i2 + iInternalGet13) % maximum;
                if (i9 < 0) {
                    i9 += maximum;
                }
                setTimeInMillis(((((long) i9) - ((long) iInternalGet13)) * 3600000) + timeInMillis);
                break;
            case 15:
            case 16:
            case 22:
            default:
                og.i(cq.v("Calendar.roll(", fieldName(i), ") not supported"));
                break;
            case 19:
                set(i, internalGet(i) + i2);
                pinField(2);
                pinField(5);
                break;
            case 20:
                set(i, internalGet(i) + i2);
                break;
        }
    }

    public final void set(int i, int i2) {
        if (this.areFieldsVirtuallySet) {
            computeFields();
        }
        this.fields[i] = i2;
        if (this.nextStamp == STAMP_MAX) {
            recalculateStamp();
        }
        byte[] bArr = this.stamp;
        byte b = this.nextStamp;
        this.nextStamp = (byte) (b + 1);
        bArr[i] = b;
        this.areFieldsVirtuallySet = false;
        this.areFieldsSet = false;
        this.isTimeSet = false;
    }

    public void setFirstDayOfWeek(int i) {
        if (this.firstDayOfWeek != i) {
            if (i < 1 || i > 7) {
                og.i("Invalid day of week");
            } else {
                this.firstDayOfWeek = i;
                this.areFieldsSet = false;
            }
        }
    }

    public void setLenient(boolean z) {
        this.lenient = z;
    }

    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            dk0.v();
        } else {
            this.validLocale = uLocale;
            this.actualLocale = uLocale2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003 A[PHI: r0
      0x0003: PHI (r0v3 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0001, B:6:0x0006] A[DONT_GENERATE, DONT_INLINE]] */
    public void setMinimalDaysInFirstWeek(int i) {
        int i2 = 1;
        if (i < 1) {
            i = i2;
        } else {
            i2 = 7;
            if (i > 7) {
                i = i2;
            }
        }
        if (this.minimalDaysInFirstWeek != i) {
            this.minimalDaysInFirstWeek = i;
            this.areFieldsSet = false;
        }
    }

    @Deprecated
    public void setRelatedYear(int i) {
        set(19, i - getRelatedYearDifference());
    }

    public void setRepeatedWallTimeOption(int i) {
        if (i == 0 || i == 1) {
            this.repeatedWallTime = i;
        } else {
            og.i(ky0.h(i, "Illegal repeated wall time option - "));
        }
    }

    public void setSkippedWallTimeOption(int i) {
        if (i == 0 || i == 1 || i == 2) {
            this.skippedWallTime = i;
        } else {
            og.i(ky0.h(i, "Illegal skipped wall time option - "));
        }
    }

    public void setTemporalMonthCode(String str) {
        if (str.length() == 3 && str.charAt(0) == 'M') {
            int i = 0;
            while (true) {
                String[] strArr = gTemporalMonthCodes;
                if (i >= strArr.length) {
                    break;
                }
                if (str.equals(strArr[i])) {
                    set(2, i);
                    set(22, 0);
                    return;
                }
                i++;
            }
        }
        og.i("Incorrect temporal Month code: ".concat(str));
    }

    public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }

    public void setTimeInMillis(long j) {
        long j2 = 183882168921600000L;
        if (j <= 183882168921600000L) {
            j2 = -184303902528000000L;
            if (j < -184303902528000000L) {
                if (!isLenient()) {
                    og.l(j, "millis value less than lower bounds for a Calendar : ");
                    return;
                }
            }
            this.time = j;
            this.areAllFieldsSet = false;
            this.areFieldsSet = false;
            this.areFieldsVirtuallySet = true;
            this.isTimeSet = true;
            Arrays.fill(this.fields, 0);
            Arrays.fill(this.stamp, (byte) 0);
            this.nextStamp = (byte) 2;
        }
        if (!isLenient()) {
            og.l(j, "millis value greater than upper bounds for a Calendar : ");
            return;
        }
        j = j2;
        this.time = j;
        this.areAllFieldsSet = false;
        this.areFieldsSet = false;
        this.areFieldsVirtuallySet = true;
        this.isTimeSet = true;
        Arrays.fill(this.fields, 0);
        Arrays.fill(this.stamp, (byte) 0);
        this.nextStamp = (byte) 2;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.zone = timeZone;
        this.areFieldsSet = false;
    }

    public Calendar setWeekData(WeekData weekData) {
        setFirstDayOfWeek(weekData.firstDayOfWeek);
        setMinimalDaysInFirstWeek(weekData.minimalDaysInFirstWeek);
        this.weekendOnset = weekData.weekendOnset;
        this.weekendOnsetMillis = weekData.weekendOnsetMillis;
        this.weekendCease = weekData.weekendCease;
        this.weekendCeaseMillis = weekData.weekendCeaseMillis;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[time=");
        sb.append(this.isTimeSet ? String.valueOf(this.time) : "?");
        sb.append(",areFieldsSet=");
        sb.append(this.areFieldsSet);
        sb.append(",areAllFieldsSet=");
        sb.append(this.areAllFieldsSet);
        sb.append(",lenient=");
        sb.append(this.lenient);
        sb.append(",zone=");
        sb.append(this.zone);
        sb.append(",firstDayOfWeek=");
        sb.append(this.firstDayOfWeek);
        sb.append(",minimalDaysInFirstWeek=");
        sb.append(this.minimalDaysInFirstWeek);
        sb.append(",repeatedWallTime=");
        sb.append(this.repeatedWallTime);
        sb.append(",skippedWallTime=");
        sb.append(this.skippedWallTime);
        for (int i = 0; i < this.fields.length; i++) {
            sb.append(',');
            sb.append(fieldName(i));
            sb.append('=');
            sb.append(isSet(i) ? String.valueOf(this.fields[i]) : "?");
        }
        sb.append(']');
        return sb.toString();
    }

    public void validateField(int i) {
        if (i == 5) {
            validateField(i, 1, handleGetMonthLength(handleGetExtendedYear(), internalGetMonth()));
            return;
        }
        if (i == 6) {
            validateField(i, 1, handleGetYearLength(handleGetExtendedYear()));
            return;
        }
        if (i != 8) {
            validateField(i, getMinimum(i), getMaximum(i));
        } else if (internalGet(i) != 0) {
            validateField(i, getMinimum(i), getMaximum(i));
        } else {
            og.i("DAY_OF_WEEK_IN_MONTH cannot be zero");
        }
    }

    public void validateFields() {
        for (int i = 0; i < this.fields.length; i++) {
            if (this.stamp[i] >= 2) {
                validateField(i);
            }
        }
    }

    public int weekNumber(int i, int i2, int i3) {
        int firstDayOfWeek = (((i3 - getFirstDayOfWeek()) - i2) + 1) % 7;
        if (firstDayOfWeek < 0) {
            firstDayOfWeek += 7;
        }
        int i4 = ((i + firstDayOfWeek) - 1) / 7;
        return 7 - firstDayOfWeek >= getMinimalDaysInFirstWeek() ? i4 + 1 : i4;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class FormatConfiguration {
        private Calendar cal;
        private DateFormatSymbols formatData;
        private ULocale loc;
        private String override;
        private String pattern;

        public /* synthetic */ FormatConfiguration(int i) {
            this();
        }

        @Deprecated
        public Calendar getCalendar() {
            return this.cal;
        }

        @Deprecated
        public DateFormatSymbols getDateFormatSymbols() {
            return this.formatData;
        }

        @Deprecated
        public ULocale getLocale() {
            return this.loc;
        }

        @Deprecated
        public String getOverrideString() {
            return this.override;
        }

        @Deprecated
        public String getPatternString() {
            return this.pattern;
        }

        private FormatConfiguration() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class WeekDataCache extends SoftCache<String, WeekData, String> {
        public /* synthetic */ WeekDataCache(int i) {
            this();
        }

        private WeekDataCache() {
        }

        @Override // com.ibm.icu.impl.CacheBase
        public WeekData createInstance(String str, String str2) {
            return Calendar.getWeekDataForRegionInternal(str);
        }
    }

    public DateFormat getDateTimeFormat(int i, int i2, ULocale uLocale) {
        return formatHelper(this, uLocale, i, i2);
    }

    public String getDisplayName(ULocale uLocale) {
        return getClass().getName();
    }

    public static Calendar getInstance(TimeZone timeZone) {
        return getInstanceInternal(timeZone, null);
    }

    public static Calendar getInstance() {
        return getInstanceInternal(null, null);
    }

    public static Calendar getInstance(ULocale uLocale) {
        return getInstanceInternal(null, uLocale);
    }

    public final int internalGet(int i) {
        return this.fields[i];
    }

    public static Calendar getInstance(TimeZone timeZone, Locale locale) {
        return getInstanceInternal(timeZone, ULocale.forLocale(locale));
    }

    public static Calendar getInstance(TimeZone timeZone, ULocale uLocale) {
        return getInstanceInternal(timeZone, uLocale);
    }

    @Deprecated
    public int internalGetMonth(int i) {
        if (resolveFields(MONTH_PRECEDENCE) == 2) {
            return internalGet(2, i);
        }
        return internalGet(23, i);
    }

    private void setWeekData(String str) {
        if (str == null) {
            str = UnitsData.Constants.DEFAULT_REGION;
        }
        setWeekData(WEEK_DATA_CACHE.getInstance(str, str));
    }

    public final int weekNumber(int i, int i2) {
        return weekNumber(i, i, i2);
    }

    public static final int floorDivide(int i, int i2) {
        return i >= 0 ? i / i2 : ((i + 1) / i2) - 1;
    }

    public DateFormat handleGetDateFormat(String str, String str2, Locale locale) {
        return handleGetDateFormat(str, str2, ULocale.forLocale(locale));
    }

    public static final int floorDivide(int i, int i2, int[] iArr) {
        if (i >= 0) {
            iArr[0] = i % i2;
            return i / i2;
        }
        int i3 = ((i + 1) / i2) - 1;
        iArr[0] = i - (i2 * i3);
        return i3;
    }

    public DateFormat handleGetDateFormat(String str, ULocale uLocale) {
        return handleGetDateFormat(str, (String) null, uLocale);
    }

    public DateFormat handleGetDateFormat(String str, Locale locale) {
        return handleGetDateFormat(str, (String) null, ULocale.forLocale(locale));
    }

    public static final long floorDivide(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
    }

    public final void set(int i, int i2, int i3) {
        set(1, i);
        set(2, i2);
        set(5, i3);
    }

    public final void clear() {
        Arrays.fill(this.fields, 0);
        Arrays.fill(this.stamp, (byte) 0);
        this.nextStamp = (byte) 2;
        this.areFieldsVirtuallySet = false;
        this.areAllFieldsSet = false;
        this.areFieldsSet = false;
        this.isTimeSet = false;
    }

    public final void set(int i, int i2, int i3, int i4, int i5) {
        set(1, i);
        set(2, i2);
        set(5, i3);
        set(11, i4);
        set(12, i5);
    }

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        set(1, i);
        set(2, i2);
        set(5, i3);
        set(11, i4);
        set(12, i5);
        set(13, i6);
    }

    public boolean isWeekend(Date date) {
        setTime(date);
        return isWeekend();
    }

    public final void validateField(int i, int i2, int i3) {
        int i4 = this.fields[i];
        if (i4 < i2 || i4 > i3) {
            throw new IllegalArgumentException(fieldName(i) + "=" + i4 + ", valid range=" + i2 + ".." + i3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    @Deprecated
    public int computeZoneOffset(long j, long j2) {
        int[] iArr = new int[2];
        long j3 = j + j2;
        TimeZone timeZone = this.zone;
        if (timeZone instanceof BasicTimeZone) {
            ((BasicTimeZone) timeZone).getOffsetFromLocal(j3, this.skippedWallTime == 1 ? BasicTimeZone.LocalOption.LATTER : BasicTimeZone.LocalOption.FORMER, this.repeatedWallTime == 1 ? BasicTimeZone.LocalOption.FORMER : BasicTimeZone.LocalOption.LATTER, iArr);
        } else {
            timeZone.getOffset(j3, true, iArr);
            if (this.repeatedWallTime == 1) {
                int offset = (iArr[0] + iArr[1]) - this.zone.getOffset((j3 - ((long) (iArr[0] + iArr[1]))) - 21600000);
                if (offset < 0) {
                    this.zone.getOffset(j3 + ((long) offset), true, iArr);
                } else if (this.skippedWallTime == 1) {
                    this.zone.getOffset(j3 - ((long) (iArr[0] + iArr[1])), false, iArr);
                }
            } else if (this.skippedWallTime == 1) {
                this.zone.getOffset(j3 - ((long) (iArr[0] + iArr[1])), false, iArr);
            }
        }
        return iArr[0] + iArr[1];
    }

    public Calendar(TimeZone timeZone, Locale locale) {
        this(timeZone, ULocale.forLocale(locale));
    }

    public Calendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public final void roll(int i, boolean z) {
        roll(i, z ? 1 : -1);
    }
}
