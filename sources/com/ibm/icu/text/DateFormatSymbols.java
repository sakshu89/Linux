package com.ibm.icu.text;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.CalendarUtil;
import com.ibm.icu.impl.EraRules;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class DateFormatSymbols implements Serializable, Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ABBREVIATED = 0;
    static final String ALTERNATE_TIME_SEPARATOR = ".";
    private static final String[][] CALENDAR_CLASSES = {new String[]{"GregorianCalendar", "gregorian"}, new String[]{"JapaneseCalendar", "japanese"}, new String[]{"BuddhistCalendar", "buddhist"}, new String[]{"TaiwanCalendar", "roc"}, new String[]{"PersianCalendar", "persian"}, new String[]{"IslamicCalendar", "islamic"}, new String[]{"HebrewCalendar", "hebrew"}, new String[]{"ChineseCalendar", "chinese"}, new String[]{"IndianCalendar", "indian"}, new String[]{"CopticCalendar", "coptic"}, new String[]{"EthiopicCalendar", "ethiopic"}};
    private static final String[] DAY_PERIOD_KEYS;
    static final String DEFAULT_TIME_SEPARATOR = ":";
    private static CacheBase<String, DateFormatSymbols, ULocale> DFSCACHE = null;

    @Deprecated
    public static final int DT_CONTEXT_COUNT = 3;
    static final int DT_LEAP_MONTH_PATTERN_FORMAT_ABBREV = 1;
    static final int DT_LEAP_MONTH_PATTERN_FORMAT_NARROW = 2;
    static final int DT_LEAP_MONTH_PATTERN_FORMAT_WIDE = 0;
    static final int DT_LEAP_MONTH_PATTERN_NUMERIC = 6;
    static final int DT_LEAP_MONTH_PATTERN_STANDALONE_ABBREV = 4;
    static final int DT_LEAP_MONTH_PATTERN_STANDALONE_NARROW = 5;
    static final int DT_LEAP_MONTH_PATTERN_STANDALONE_WIDE = 3;
    static final int DT_MONTH_PATTERN_COUNT = 7;

    @Deprecated
    public static final int DT_WIDTH_COUNT = 4;
    public static final int FORMAT = 0;
    private static final String[] LEAP_MONTH_PATTERNS_PATHS;
    public static final int NARROW = 2;

    @Deprecated
    public static final int NUMERIC = 2;
    public static final int SHORT = 3;
    public static final int STANDALONE = 1;
    public static final int WIDE = 1;
    private static final Map<String, CapitalizationContextUsage> contextUsageTypeMap;
    static final int millisPerHour = 3600000;
    static final String patternChars = "GyMdkHmsSEDFwWahKzYeugAZvcLQqVUOXxrbB";
    private static final long serialVersionUID = -5987973545549424702L;
    String[] abbreviatedDayPeriods;
    private ULocale actualLocale;
    String[] ampms;
    String[] ampmsNarrow;
    String[] ampmsWide;
    Map<CapitalizationContextUsage, boolean[]> capitalization;
    String[] dayOfMonthCardinalNames;
    String[] dayOfMonthOrdinalNames;
    String[] eraNames;
    String[] eras;
    String[] leapMonthPatterns;
    String localPatternChars;
    String[] months;
    String[] narrowDayPeriods;
    String[] narrowEras;
    String[] narrowMonths;
    String[] narrowQuarters;
    String[] narrowWeekdays;
    String[] quarters;
    private ULocale requestedLocale;
    String[] shortMonths;
    String[] shortQuarters;
    String[] shortWeekdays;
    String[] shortYearNames;
    String[] shortZodiacNames;
    String[] shorterWeekdays;
    String[] standaloneAbbreviatedDayPeriods;
    String[] standaloneMonths;
    String[] standaloneNarrowDayPeriods;
    String[] standaloneNarrowMonths;
    String[] standaloneNarrowQuarters;
    String[] standaloneNarrowWeekdays;
    String[] standaloneQuarters;
    String[] standaloneShortMonths;
    String[] standaloneShortQuarters;
    String[] standaloneShortWeekdays;
    String[] standaloneShorterWeekdays;
    String[] standaloneWeekdays;
    String[] standaloneWideDayPeriods;
    private String timeSeparator;
    private ULocale validLocale;
    String[] weekdays;
    String[] wideDayPeriods;
    private String[][] zoneStrings;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CalendarDataSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String CALENDAR_ALIAS_PREFIX = "/LOCALE/calendar/";
        private String aliasRelativePath;
        private Set<String> resourcesToVisit;
        Map<String, String[]> arrays = new TreeMap();
        Map<String, Map<String, String>> maps = new TreeMap();
        List<String> aliasPathPairs = new ArrayList();
        String currentCalendarType = null;
        String nextCalendarType = null;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum AliasType {
            SAME_CALENDAR,
            DIFFERENT_CALENDAR,
            GREGORIAN,
            NONE
        }

        private AliasType processAliasFromValue(String str, UResource.Value value) {
            int iIndexOf;
            if (value.getType() != 3) {
                return AliasType.NONE;
            }
            String aliasString = value.getAliasString();
            if (aliasString.startsWith(CALENDAR_ALIAS_PREFIX) && aliasString.length() > 17 && (iIndexOf = aliasString.indexOf(47, 17)) > 17) {
                String strSubstring = aliasString.substring(17, iIndexOf);
                this.aliasRelativePath = aliasString.substring(iIndexOf + 1);
                if (this.currentCalendarType.equals(strSubstring) && !str.equals(this.aliasRelativePath)) {
                    return AliasType.SAME_CALENDAR;
                }
                if (!this.currentCalendarType.equals(strSubstring) && str.equals(this.aliasRelativePath)) {
                    if (strSubstring.equals("gregorian")) {
                        return AliasType.GREGORIAN;
                    }
                    String str2 = this.nextCalendarType;
                    if (str2 == null || str2.equals(strSubstring)) {
                        this.nextCalendarType = strSubstring;
                        return AliasType.DIFFERENT_CALENDAR;
                    }
                }
            }
            og.q("Malformed 'calendar' alias. Path: ".concat(aliasString));
            return null;
        }

        public void preEnumerate(String str) {
            this.currentCalendarType = str;
            this.nextCalendarType = null;
            this.aliasPathPairs.clear();
        }

        public void processResource(String str, UResource.Key key, UResource.Value value) {
            UResource.Table table = value.getTable();
            HashMap map = null;
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (!key.endsWith("%variant")) {
                    String string = key.toString();
                    if (value.getType() == 0) {
                        if (i == 0) {
                            map = new HashMap();
                            this.maps.put(str, map);
                        }
                        map.put(string, value.getString());
                    } else {
                        String strK = cq.k(str, "/", string);
                        if ((!strK.startsWith("cyclicNameSets") || "cyclicNameSets/years/format/abbreviated".startsWith(strK) || "cyclicNameSets/zodiacs/format/abbreviated".startsWith(strK) || "cyclicNameSets/dayParts/format/abbreviated".startsWith(strK)) && !this.arrays.containsKey(strK) && !this.maps.containsKey(strK)) {
                            if (processAliasFromValue(strK, value) == AliasType.SAME_CALENDAR) {
                                this.aliasPathPairs.add(this.aliasRelativePath);
                                this.aliasPathPairs.add(strK);
                            } else if (value.getType() == 8) {
                                this.arrays.put(strK, value.getStringArray());
                            } else if (value.getType() == 2) {
                                processResource(strK, key, value);
                            }
                        }
                    }
                }
            }
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            HashSet hashSet = null;
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                String string = key.toString();
                AliasType aliasTypeProcessAliasFromValue = processAliasFromValue(string, value);
                if (aliasTypeProcessAliasFromValue != AliasType.GREGORIAN) {
                    if (aliasTypeProcessAliasFromValue == AliasType.DIFFERENT_CALENDAR) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(this.aliasRelativePath);
                    } else if (aliasTypeProcessAliasFromValue != AliasType.SAME_CALENDAR) {
                        Set<String> set = this.resourcesToVisit;
                        if (set == null || set.isEmpty() || this.resourcesToVisit.contains(string) || string.equals("AmPmMarkersAbbr")) {
                            if (string.startsWith("AmPmMarkers")) {
                                if (!string.endsWith("%variant") && !this.arrays.containsKey(string)) {
                                    this.arrays.put(string, value.getStringArray());
                                }
                            } else if (string.equals("eras") || string.equals("dayNames") || string.equals("monthNames") || string.equals("quarters") || string.equals("dayPeriod") || string.equals("monthPatterns") || string.equals("cyclicNameSets") || string.equals("dayOfMonthNames")) {
                                processResource(string, key, value);
                            }
                        }
                    } else if (!this.arrays.containsKey(string) && !this.maps.containsKey(string)) {
                        this.aliasPathPairs.add(this.aliasRelativePath);
                        this.aliasPathPairs.add(string);
                    }
                }
            }
            do {
                int i2 = 0;
                boolean z2 = false;
                while (i2 < this.aliasPathPairs.size()) {
                    String str = this.aliasPathPairs.get(i2);
                    if (this.arrays.containsKey(str)) {
                        this.arrays.put(this.aliasPathPairs.get(i2 + 1), this.arrays.get(str));
                    } else if (this.maps.containsKey(str)) {
                        this.maps.put(this.aliasPathPairs.get(i2 + 1), this.maps.get(str));
                    } else {
                        i2 += 2;
                    }
                    this.aliasPathPairs.remove(i2 + 1);
                    this.aliasPathPairs.remove(i2);
                    z2 = true;
                }
                if (!z2) {
                    break;
                }
            } while (!this.aliasPathPairs.isEmpty());
            if (hashSet != null) {
                this.resourcesToVisit = hashSet;
            }
        }

        public void visitAllResources() {
            this.resourcesToVisit = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum CapitalizationContextUsage {
        OTHER,
        MONTH_FORMAT,
        MONTH_STANDALONE,
        MONTH_NARROW,
        DAY_FORMAT,
        DAY_STANDALONE,
        DAY_NARROW,
        ERA_WIDE,
        ERA_ABBREV,
        ERA_NARROW,
        ZONE_LONG,
        ZONE_SHORT,
        METAZONE_LONG,
        METAZONE_SHORT
    }

    static {
        HashMap map = new HashMap();
        contextUsageTypeMap = map;
        map.put("month-format-except-narrow", CapitalizationContextUsage.MONTH_FORMAT);
        map.put("month-standalone-except-narrow", CapitalizationContextUsage.MONTH_STANDALONE);
        map.put("month-narrow", CapitalizationContextUsage.MONTH_NARROW);
        map.put("day-format-except-narrow", CapitalizationContextUsage.DAY_FORMAT);
        map.put("day-standalone-except-narrow", CapitalizationContextUsage.DAY_STANDALONE);
        map.put("day-narrow", CapitalizationContextUsage.DAY_NARROW);
        map.put("era-name", CapitalizationContextUsage.ERA_WIDE);
        map.put("era-abbr", CapitalizationContextUsage.ERA_ABBREV);
        map.put("era-narrow", CapitalizationContextUsage.ERA_NARROW);
        map.put("zone-long", CapitalizationContextUsage.ZONE_LONG);
        map.put("zone-short", CapitalizationContextUsage.ZONE_SHORT);
        map.put("metazone-long", CapitalizationContextUsage.METAZONE_LONG);
        map.put("metazone-short", CapitalizationContextUsage.METAZONE_SHORT);
        DFSCACHE = new SoftCache<String, DateFormatSymbols, ULocale>() { // from class: com.ibm.icu.text.DateFormatSymbols.1
            @Override // com.ibm.icu.impl.CacheBase
            public DateFormatSymbols createInstance(String str, ULocale uLocale) {
                int iIndexOf = str.indexOf(43) + 1;
                int iIndexOf2 = str.indexOf(43, iIndexOf);
                if (iIndexOf2 < 0) {
                    iIndexOf2 = str.length();
                }
                return new DateFormatSymbols(uLocale, str.substring(iIndexOf, iIndexOf2));
            }
        };
        LEAP_MONTH_PATTERNS_PATHS = new String[]{"monthPatterns/format/wide", "monthPatterns/format/abbreviated", "monthPatterns/format/narrow", "monthPatterns/stand-alone/wide", "monthPatterns/stand-alone/abbreviated", "monthPatterns/stand-alone/narrow", "monthPatterns/numeric/all"};
        DAY_PERIOD_KEYS = new String[]{"midnight", "noon", "morning1", "afternoon1", "evening1", "night1", "morning2", "afternoon2", "evening2", "night2"};
    }

    public DateFormatSymbols(Class<? extends Calendar> cls, ULocale uLocale) {
        String str = null;
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsWide = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.narrowQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneNarrowQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.dayOfMonthOrdinalNames = null;
        this.dayOfMonthCardinalNames = null;
        this.capitalization = null;
        String name = cls.getName();
        String strSubstring = name.substring(name.lastIndexOf(46) + 1);
        for (String[] strArr : CALENDAR_CLASSES) {
            if (strArr[0].equals(strSubstring)) {
                str = strArr[1];
                break;
            }
        }
        initializeData(uLocale, str == null ? strSubstring.replace("Calendar", "").toLowerCase(Locale.ENGLISH) : str);
    }

    private static final boolean arrayOfArrayEquals(Object[][] objArr, Object[][] objArr2) {
        boolean zArrayEquals = true;
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            zArrayEquals = Utility.arrayEquals(objArr[i], (Object) objArr2[i]);
            if (!zArrayEquals) {
                return zArrayEquals;
            }
        }
        return zArrayEquals;
    }

    private final String[][] duplicate(String[][] strArr) {
        String[][] strArr2 = new String[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = duplicate(strArr[i]);
        }
        return strArr2;
    }

    public static Locale[] getAvailableLocales() {
        return ICUResourceBundle.getAvailableLocales();
    }

    public static ULocale[] getAvailableULocales() {
        return ICUResourceBundle.getAvailableULocales();
    }

    @Deprecated
    public static ResourceBundle getDateFormatBundle(Calendar calendar, ULocale uLocale) {
        return null;
    }

    public static DateFormatSymbols getInstance() {
        return new DateFormatSymbols();
    }

    private void loadDayOfMonthNames(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String[] strArr = new String[StandardPlural.COUNT];
        String[] strArr2 = new String[33];
        boolean z = false;
        boolean z2 = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null && !key.isEmpty()) {
                char cCharAt = key.charAt(0);
                if (cCharAt < '0' || cCharAt > '9') {
                    strArr[StandardPlural.orOtherFromString(key).ordinal()] = value;
                    z = true;
                } else {
                    try {
                        int i = Integer.parseInt(key);
                        if (i >= 1 && i < 33) {
                            strArr2[i] = value;
                            z2 = true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        if (z) {
            this.dayOfMonthOrdinalNames = strArr;
        }
        if (z2) {
            this.dayOfMonthCardinalNames = strArr2;
        }
    }

    private String[] loadDayPeriodStrings(Map<String, String> map, String[] strArr) {
        if (map == null && strArr != null) {
            return strArr;
        }
        String[] strArr2 = new String[DAY_PERIOD_KEYS.length];
        if (map != null) {
            int i = 0;
            while (true) {
                String[] strArr3 = DAY_PERIOD_KEYS;
                if (i >= strArr3.length) {
                    break;
                }
                String str = map.get(strArr3[i]);
                strArr2[i] = str;
                if (str == null && strArr != null) {
                    strArr2[i] = strArr[i];
                }
                i++;
            }
        }
        return strArr2;
    }

    private void loadEraNames(String[] strArr, Map<String, String> map, ICUResourceBundle iCUResourceBundle, String str, EraRules eraRules) {
        ICUResourceBundle iCUResourceBundleFindWithFallback;
        String string;
        int maxEraCode = eraRules.getMaxEraCode();
        ICUResourceBundle iCUResourceBundleFindWithFallback2 = iCUResourceBundle.findWithFallback(eraRules.getCalendarTypeId()).findWithFallback(str);
        for (int i = 0; i <= maxEraCode; i++) {
            String str2 = strArr[i];
            if (str2 == null || str2.isEmpty()) {
                String string2 = Integer.toString(i);
                String str3 = map.get(string2);
                if (str3 != null) {
                    strArr[i] = str3;
                } else {
                    strArr[i] = "";
                    if (iCUResourceBundleFindWithFallback2 != null && (iCUResourceBundleFindWithFallback = iCUResourceBundleFindWithFallback2.findWithFallback(string2)) != null && (string = iCUResourceBundleFindWithFallback.getString()) != null) {
                        strArr[i] = string;
                    }
                }
            }
        }
        EraRules inheritEraRules = eraRules.getInheritEraRules();
        if (inheritEraRules != null) {
            loadEraNames(strArr, map, iCUResourceBundle, str, inheritEraRules);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DateFormatSymbols m14clone() {
        try {
            return (DateFormatSymbols) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DateFormatSymbols dateFormatSymbols = (DateFormatSymbols) obj;
            if (Utility.arrayEquals((Object[]) this.eras, (Object) dateFormatSymbols.eras) && Utility.arrayEquals((Object[]) this.eraNames, (Object) dateFormatSymbols.eraNames) && Utility.arrayEquals((Object[]) this.narrowEras, (Object) dateFormatSymbols.narrowEras) && Utility.arrayEquals((Object[]) this.months, (Object) dateFormatSymbols.months) && Utility.arrayEquals((Object[]) this.shortMonths, (Object) dateFormatSymbols.shortMonths) && Utility.arrayEquals((Object[]) this.narrowMonths, (Object) dateFormatSymbols.narrowMonths) && Utility.arrayEquals((Object[]) this.standaloneMonths, (Object) dateFormatSymbols.standaloneMonths) && Utility.arrayEquals((Object[]) this.standaloneShortMonths, (Object) dateFormatSymbols.standaloneShortMonths) && Utility.arrayEquals((Object[]) this.standaloneNarrowMonths, (Object) dateFormatSymbols.standaloneNarrowMonths) && Utility.arrayEquals((Object[]) this.weekdays, (Object) dateFormatSymbols.weekdays) && Utility.arrayEquals((Object[]) this.shortWeekdays, (Object) dateFormatSymbols.shortWeekdays) && Utility.arrayEquals((Object[]) this.shorterWeekdays, (Object) dateFormatSymbols.shorterWeekdays) && Utility.arrayEquals((Object[]) this.narrowWeekdays, (Object) dateFormatSymbols.narrowWeekdays) && Utility.arrayEquals((Object[]) this.standaloneWeekdays, (Object) dateFormatSymbols.standaloneWeekdays) && Utility.arrayEquals((Object[]) this.standaloneShortWeekdays, (Object) dateFormatSymbols.standaloneShortWeekdays) && Utility.arrayEquals((Object[]) this.standaloneShorterWeekdays, (Object) dateFormatSymbols.standaloneShorterWeekdays) && Utility.arrayEquals((Object[]) this.standaloneNarrowWeekdays, (Object) dateFormatSymbols.standaloneNarrowWeekdays) && Utility.arrayEquals((Object[]) this.ampms, (Object) dateFormatSymbols.ampms) && Utility.arrayEquals((Object[]) this.ampmsWide, (Object) dateFormatSymbols.ampmsWide) && Utility.arrayEquals((Object[]) this.ampmsNarrow, (Object) dateFormatSymbols.ampmsNarrow) && Utility.arrayEquals((Object[]) this.abbreviatedDayPeriods, (Object) dateFormatSymbols.abbreviatedDayPeriods) && Utility.arrayEquals((Object[]) this.wideDayPeriods, (Object) dateFormatSymbols.wideDayPeriods) && Utility.arrayEquals((Object[]) this.narrowDayPeriods, (Object) dateFormatSymbols.narrowDayPeriods) && Utility.arrayEquals((Object[]) this.standaloneAbbreviatedDayPeriods, (Object) dateFormatSymbols.standaloneAbbreviatedDayPeriods) && Utility.arrayEquals((Object[]) this.standaloneWideDayPeriods, (Object) dateFormatSymbols.standaloneWideDayPeriods) && Utility.arrayEquals((Object[]) this.standaloneNarrowDayPeriods, (Object) dateFormatSymbols.standaloneNarrowDayPeriods) && Utility.arrayEquals((Object[]) this.dayOfMonthOrdinalNames, (Object) dateFormatSymbols.dayOfMonthOrdinalNames) && Utility.arrayEquals((Object[]) this.dayOfMonthCardinalNames, (Object) dateFormatSymbols.dayOfMonthCardinalNames) && Utility.arrayEquals(this.timeSeparator, dateFormatSymbols.timeSeparator) && arrayOfArrayEquals(this.zoneStrings, dateFormatSymbols.zoneStrings) && this.requestedLocale.getDisplayName().equals(dateFormatSymbols.requestedLocale.getDisplayName()) && Utility.arrayEquals(this.localPatternChars, dateFormatSymbols.localPatternChars)) {
                return true;
            }
        }
        return false;
    }

    public String[] getAmPmStrings(int i, int i2) {
        if (i2 != 1) {
            return i2 != 2 ? duplicate(this.ampms) : duplicate(this.ampmsNarrow);
        }
        return duplicate(this.ampmsWide);
    }

    public String[] getDayOfMonthCardinalNames(int i, int i2) {
        String[] strArr = this.dayOfMonthCardinalNames;
        if (strArr == null) {
            return null;
        }
        return duplicate(strArr);
    }

    public String[] getDayOfMonthOrdinalNames(int i, int i2) {
        String[] strArr = this.dayOfMonthOrdinalNames;
        if (strArr == null) {
            return null;
        }
        return duplicate(strArr);
    }

    public String[] getEraNames() {
        return duplicate(this.eraNames);
    }

    public String[] getEras() {
        return duplicate(this.eras);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001d  */
    /* JADX WARN: Code duplicated, block: B:24:0x002c  */
    @Deprecated
    public String getLeapMonthPattern(int i, int i2) {
        String[] strArr = this.leapMonthPatterns;
        if (strArr == null) {
            return null;
        }
        byte b = 3;
        byte b2 = 2;
        byte b3 = -1;
        if (i == 0) {
            if (i2 == 0) {
                b2 = 1;
            } else if (i2 == 1) {
                b2 = 0;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    b2 = -1;
                } else {
                    b2 = 1;
                }
            }
            b3 = b2;
        } else if (i == 1) {
            if (i2 == 0) {
                b = 1;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    b = 5;
                } else if (i2 != 3) {
                    b = -1;
                } else {
                    b = 1;
                }
            }
            b3 = b;
        } else if (i == 2) {
            b3 = 6;
        }
        if (b3 >= 0) {
            return strArr[b3];
        }
        og.i("Bad context or width argument");
        return null;
    }

    public String getLocalPatternChars() {
        return this.localPatternChars;
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0011  */
    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    /* JADX WARN: Code duplicated, block: B:21:0x002b  */
    public String[] getMonths(int i, int i2) {
        String[] strArr;
        if (i != 0) {
            if (i != 1) {
                strArr = null;
            } else if (i2 == 0) {
                strArr = this.standaloneShortMonths;
            } else if (i2 == 1) {
                strArr = this.standaloneMonths;
            } else if (i2 == 2) {
                strArr = this.standaloneNarrowMonths;
            } else if (i2 != 3) {
                strArr = null;
            } else {
                strArr = this.standaloneShortMonths;
            }
        } else if (i2 == 0) {
            strArr = this.shortMonths;
        } else if (i2 == 1) {
            strArr = this.months;
        } else if (i2 == 2) {
            strArr = this.narrowMonths;
        } else if (i2 != 3) {
            strArr = null;
        } else {
            strArr = this.shortMonths;
        }
        if (strArr != null) {
            return duplicate(strArr);
        }
        og.i("Bad context or width argument");
        return null;
    }

    public String[] getNarrowEras() {
        return duplicate(this.narrowEras);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0011  */
    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    /* JADX WARN: Code duplicated, block: B:21:0x002b  */
    public String[] getQuarters(int i, int i2) {
        String[] strArr;
        if (i != 0) {
            if (i != 1) {
                strArr = null;
            } else if (i2 == 0) {
                strArr = this.standaloneShortQuarters;
            } else if (i2 == 1) {
                strArr = this.standaloneQuarters;
            } else if (i2 == 2) {
                strArr = this.standaloneNarrowQuarters;
            } else if (i2 != 3) {
                strArr = null;
            } else {
                strArr = this.standaloneShortQuarters;
            }
        } else if (i2 == 0) {
            strArr = this.shortQuarters;
        } else if (i2 == 1) {
            strArr = this.quarters;
        } else if (i2 == 2) {
            strArr = this.narrowQuarters;
        } else if (i2 != 3) {
            strArr = null;
        } else {
            strArr = this.shortQuarters;
        }
        if (strArr != null) {
            return duplicate(strArr);
        }
        og.i("Bad context or width argument");
        return null;
    }

    public String[] getShortMonths() {
        return duplicate(this.shortMonths);
    }

    public String[] getShortWeekdays() {
        return duplicate(this.shortWeekdays);
    }

    @Deprecated
    public String getTimeSeparatorString() {
        return this.timeSeparator;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0011  */
    public String[] getWeekdays(int i, int i2) {
        String[] strArr;
        if (i != 0) {
            if (i != 1) {
                strArr = null;
            } else if (i2 == 0) {
                strArr = this.standaloneShortWeekdays;
            } else if (i2 == 1) {
                strArr = this.standaloneWeekdays;
            } else if (i2 == 2) {
                strArr = this.standaloneNarrowWeekdays;
            } else if (i2 != 3) {
                strArr = null;
            } else {
                strArr = this.standaloneShorterWeekdays;
                if (strArr == null) {
                    strArr = this.standaloneShortWeekdays;
                }
            }
        } else if (i2 == 0) {
            strArr = this.shortWeekdays;
        } else if (i2 == 1) {
            strArr = this.weekdays;
        } else if (i2 == 2) {
            strArr = this.narrowWeekdays;
        } else if (i2 != 3) {
            strArr = null;
        } else {
            strArr = this.shorterWeekdays;
            if (strArr == null) {
                strArr = this.shortWeekdays;
            }
        }
        if (strArr != null) {
            return duplicate(strArr);
        }
        og.i("Bad context or width argument");
        return null;
    }

    public String[] getYearNames(int i, int i2) {
        String[] strArr = this.shortYearNames;
        if (strArr != null) {
            return duplicate(strArr);
        }
        return null;
    }

    public String[] getZodiacNames(int i, int i2) {
        String[] strArr = this.shortZodiacNames;
        if (strArr != null) {
            return duplicate(strArr);
        }
        return null;
    }

    public String[][] getZoneStrings() {
        String[][] strArr = this.zoneStrings;
        if (strArr != null) {
            return duplicate(strArr);
        }
        String[] availableIDs = TimeZone.getAvailableIDs();
        TimeZoneNames timeZoneNames = TimeZoneNames.getInstance(this.validLocale);
        timeZoneNames.loadAllDisplayNames();
        TimeZoneNames.NameType[] nameTypeArr = {TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, TimeZoneNames.NameType.SHORT_DAYLIGHT};
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[][] strArr2 = (String[][]) Array.newInstance((Class<?>) String.class, availableIDs.length, 5);
        for (int i = 0; i < availableIDs.length; i++) {
            String canonicalID = TimeZone.getCanonicalID(availableIDs[i]);
            if (canonicalID == null) {
                canonicalID = availableIDs[i];
            }
            strArr2[i][0] = availableIDs[i];
            timeZoneNames.getDisplayNames(canonicalID, nameTypeArr, jCurrentTimeMillis, strArr2[i], 1);
        }
        this.zoneStrings = strArr2;
        return strArr2;
    }

    public int hashCode() {
        return this.requestedLocale.toString().hashCode();
    }

    @Deprecated
    public String[] initEras(String str, Map<String, Map<String, String>> map, ICUResourceBundle iCUResourceBundle, EraRules eraRules) {
        Map<String, String> map2 = map.get(str);
        if (map2 == null) {
            return null;
        }
        String[] strArr = new String[eraRules.getMaxEraCode() + 1];
        loadEraNames(strArr, map2, iCUResourceBundle, str, eraRules);
        return strArr;
    }

    @Deprecated
    public void initializeData(ULocale uLocale, ICUResourceBundle iCUResourceBundle, String str) {
        EraRules eraRules;
        CapitalizationContextUsage capitalizationContextUsage;
        Map<String, String> map;
        String str2;
        CalendarDataSink calendarDataSink = new CalendarDataSink();
        if (iCUResourceBundle == null) {
            iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        }
        String str3 = str != null ? str : "gregorian";
        while (str != null) {
            ICUResourceBundle iCUResourceBundleFindWithFallback = iCUResourceBundle.findWithFallback("calendar/".concat(str));
            if (iCUResourceBundleFindWithFallback != null) {
                calendarDataSink.preEnumerate(str);
                iCUResourceBundleFindWithFallback.getAllItemsWithFallback("", calendarDataSink);
                if (str.equals("gregorian")) {
                    break;
                }
                str = calendarDataSink.nextCalendarType;
                if (str == null) {
                    calendarDataSink.visitAllResources();
                }
            } else {
                if ("gregorian".equals(str)) {
                    throw new MissingResourceException(cq.j("The 'gregorian' calendar type wasn't found for the locale: ", uLocale.getBaseName()), getClass().getName(), "gregorian");
                }
                calendarDataSink.visitAllResources();
            }
            str = "gregorian";
        }
        Map<String, String[]> map2 = calendarDataSink.arrays;
        Map<String, Map<String, String>> map3 = calendarDataSink.maps;
        try {
            eraRules = EraRules.getInstance(str3, false);
        } catch (MissingResourceException unused) {
            eraRules = EraRules.getInstance("gregorian", false);
        }
        ICUResourceBundle iCUResourceBundleFindWithFallback2 = iCUResourceBundle.findWithFallback("calendar");
        this.eras = initEras("eras/abbreviated", map3, iCUResourceBundleFindWithFallback2, eraRules);
        this.eraNames = initEras("eras/wide", map3, iCUResourceBundleFindWithFallback2, eraRules);
        this.narrowEras = initEras("eras/narrow", map3, iCUResourceBundleFindWithFallback2, eraRules);
        this.months = map2.get("monthNames/format/wide");
        this.shortMonths = map2.get("monthNames/format/abbreviated");
        this.narrowMonths = map2.get("monthNames/format/narrow");
        this.standaloneMonths = map2.get("monthNames/stand-alone/wide");
        this.standaloneShortMonths = map2.get("monthNames/stand-alone/abbreviated");
        this.standaloneNarrowMonths = map2.get("monthNames/stand-alone/narrow");
        String[] strArr = map2.get("dayNames/format/wide");
        String[] strArr2 = new String[8];
        this.weekdays = strArr2;
        strArr2[0] = "";
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        String[] strArr3 = map2.get("dayNames/format/abbreviated");
        String[] strArr4 = new String[8];
        this.shortWeekdays = strArr4;
        strArr4[0] = "";
        System.arraycopy(strArr3, 0, strArr4, 1, strArr3.length);
        String[] strArr5 = map2.get("dayNames/format/short");
        String[] strArr6 = new String[8];
        this.shorterWeekdays = strArr6;
        strArr6[0] = "";
        System.arraycopy(strArr5, 0, strArr6, 1, strArr5.length);
        String[] strArr7 = map2.get("dayNames/format/narrow");
        if (strArr7 == null && (strArr7 = map2.get("dayNames/stand-alone/narrow")) == null && (strArr7 = map2.get("dayNames/format/abbreviated")) == null) {
            throw new MissingResourceException("Resource not found", getClass().getName(), "dayNames/format/abbreviated");
        }
        String[] strArr8 = new String[8];
        this.narrowWeekdays = strArr8;
        strArr8[0] = "";
        System.arraycopy(strArr7, 0, strArr8, 1, strArr7.length);
        String[] strArr9 = map2.get("dayNames/stand-alone/wide");
        String[] strArr10 = new String[8];
        this.standaloneWeekdays = strArr10;
        strArr10[0] = "";
        System.arraycopy(strArr9, 0, strArr10, 1, strArr9.length);
        String[] strArr11 = map2.get("dayNames/stand-alone/abbreviated");
        String[] strArr12 = new String[8];
        this.standaloneShortWeekdays = strArr12;
        strArr12[0] = "";
        System.arraycopy(strArr11, 0, strArr12, 1, strArr11.length);
        String[] strArr13 = map2.get("dayNames/stand-alone/short");
        String[] strArr14 = new String[8];
        this.standaloneShorterWeekdays = strArr14;
        strArr14[0] = "";
        System.arraycopy(strArr13, 0, strArr14, 1, strArr13.length);
        String[] strArr15 = map2.get("dayNames/stand-alone/narrow");
        String[] strArr16 = new String[8];
        this.standaloneNarrowWeekdays = strArr16;
        strArr16[0] = "";
        System.arraycopy(strArr15, 0, strArr16, 1, strArr15.length);
        this.ampms = map2.get("AmPmMarkersAbbr");
        this.ampmsWide = map2.get("AmPmMarkers");
        this.ampmsNarrow = map2.get("AmPmMarkersNarrow");
        this.quarters = map2.get("quarters/format/wide");
        this.shortQuarters = map2.get("quarters/format/abbreviated");
        this.narrowQuarters = map2.get("quarters/format/narrow");
        this.standaloneQuarters = map2.get("quarters/stand-alone/wide");
        this.standaloneShortQuarters = map2.get("quarters/stand-alone/abbreviated");
        this.standaloneNarrowQuarters = map2.get("quarters/stand-alone/narrow");
        ICUResourceBundle withFallback = null;
        this.abbreviatedDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/format/abbreviated"), null);
        this.wideDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/format/wide"), this.abbreviatedDayPeriods);
        this.narrowDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/format/narrow"), this.abbreviatedDayPeriods);
        this.standaloneAbbreviatedDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/stand-alone/abbreviated"), this.abbreviatedDayPeriods);
        this.standaloneWideDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/stand-alone/wide"), this.standaloneAbbreviatedDayPeriods);
        this.standaloneNarrowDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/stand-alone/narrow"), this.standaloneAbbreviatedDayPeriods);
        loadDayOfMonthNames(map3.get("dayOfMonthNames/format/abbreviated"));
        for (int i = 0; i < 7; i++) {
            String str4 = LEAP_MONTH_PATTERNS_PATHS[i];
            if (str4 != null && (map = map3.get(str4)) != null && (str2 = map.get("leap")) != null) {
                if (this.leapMonthPatterns == null) {
                    this.leapMonthPatterns = new String[7];
                }
                this.leapMonthPatterns[i] = str2;
            }
        }
        this.shortYearNames = map2.get("cyclicNameSets/years/format/abbreviated");
        this.shortZodiacNames = map2.get("cyclicNameSets/zodiacs/format/abbreviated");
        this.requestedLocale = uLocale;
        ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        this.localPatternChars = patternChars;
        ULocale uLocale2 = iCUResourceBundle2.getULocale();
        setLocale(uLocale2, uLocale2);
        this.capitalization = new HashMap();
        boolean[] zArr = {false, false};
        for (CapitalizationContextUsage capitalizationContextUsage2 : CapitalizationContextUsage.values()) {
            this.capitalization.put(capitalizationContextUsage2, zArr);
        }
        try {
            withFallback = iCUResourceBundle2.getWithFallback("contextTransforms");
        } catch (MissingResourceException unused2) {
        }
        if (withFallback != null) {
            UResourceBundleIterator iterator = withFallback.getIterator();
            while (iterator.hasNext()) {
                UResourceBundle next = iterator.next();
                int[] intVector = next.getIntVector();
                if (intVector.length >= 2 && (capitalizationContextUsage = contextUsageTypeMap.get(next.getKey())) != null) {
                    this.capitalization.put(capitalizationContextUsage, new boolean[]{intVector[0] != 0, intVector[1] != 0});
                }
            }
        }
        NumberingSystem numberingSystem = NumberingSystem.getInstance(uLocale);
        try {
            setTimeSeparatorString(iCUResourceBundle2.getStringWithFallback(cq.v("NumberElements/", numberingSystem == null ? "latn" : numberingSystem.getName(), "/symbols/timeSeparator")));
        } catch (MissingResourceException unused3) {
            setTimeSeparatorString(DEFAULT_TIME_SEPARATOR);
        }
    }

    public void setAmPmStrings(String[] strArr, int i, int i2) {
        if (i2 == 1) {
            this.ampmsWide = duplicate(strArr);
        } else if (i2 != 2) {
            this.ampms = duplicate(strArr);
        } else {
            this.ampmsNarrow = duplicate(strArr);
        }
    }

    public void setEraNames(String[] strArr) {
        this.eraNames = duplicate(strArr);
    }

    public void setEras(String[] strArr) {
        this.eras = duplicate(strArr);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0022  */
    @Deprecated
    public void setLeapMonthPattern(String str, int i, int i2) {
        String[] strArr = this.leapMonthPatterns;
        if (strArr != null) {
            byte b = 2;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                } else if (i2 == 0) {
                    b = 1;
                } else if (i2 == 1) {
                    b = 3;
                } else if (i2 != 2) {
                    b = -1;
                } else {
                    b = 5;
                }
            } else if (i2 == 0) {
                b = 1;
            } else if (i2 == 1) {
                b = 0;
            } else if (i2 != 2) {
                b = -1;
            }
            if (b >= 0) {
                strArr[b] = str;
            }
        }
    }

    public void setLocalPatternChars(String str) {
        this.localPatternChars = str;
    }

    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            dk0.v();
        } else {
            this.validLocale = uLocale;
            this.actualLocale = uLocale2;
        }
    }

    public void setMonths(String[] strArr, int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                this.shortMonths = duplicate(strArr);
                return;
            } else if (i2 == 1) {
                this.months = duplicate(strArr);
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                this.narrowMonths = duplicate(strArr);
                return;
            }
        }
        if (i != 1) {
            return;
        }
        if (i2 == 0) {
            this.standaloneShortMonths = duplicate(strArr);
        } else if (i2 == 1) {
            this.standaloneMonths = duplicate(strArr);
        } else {
            if (i2 != 2) {
                return;
            }
            this.standaloneNarrowMonths = duplicate(strArr);
        }
    }

    public void setNarrowEras(String[] strArr) {
        this.narrowEras = duplicate(strArr);
    }

    public void setQuarters(String[] strArr, int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                this.shortQuarters = duplicate(strArr);
                return;
            } else if (i2 == 1) {
                this.quarters = duplicate(strArr);
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                this.narrowQuarters = duplicate(strArr);
                return;
            }
        }
        if (i != 1) {
            return;
        }
        if (i2 == 0) {
            this.standaloneShortQuarters = duplicate(strArr);
        } else if (i2 == 1) {
            this.standaloneQuarters = duplicate(strArr);
        } else {
            if (i2 != 2) {
                return;
            }
            this.standaloneNarrowQuarters = duplicate(strArr);
        }
    }

    public void setShortMonths(String[] strArr) {
        this.shortMonths = duplicate(strArr);
    }

    public void setShortWeekdays(String[] strArr) {
        this.shortWeekdays = duplicate(strArr);
    }

    @Deprecated
    public void setTimeSeparatorString(String str) {
        this.timeSeparator = str;
    }

    public void setWeekdays(String[] strArr, int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                this.shortWeekdays = duplicate(strArr);
                return;
            }
            if (i2 == 1) {
                this.weekdays = duplicate(strArr);
                return;
            } else if (i2 == 2) {
                this.narrowWeekdays = duplicate(strArr);
                return;
            } else {
                if (i2 != 3) {
                    return;
                }
                this.shorterWeekdays = duplicate(strArr);
                return;
            }
        }
        if (i != 1) {
            return;
        }
        if (i2 == 0) {
            this.standaloneShortWeekdays = duplicate(strArr);
            return;
        }
        if (i2 == 1) {
            this.standaloneWeekdays = duplicate(strArr);
        } else if (i2 == 2) {
            this.standaloneNarrowWeekdays = duplicate(strArr);
        } else {
            if (i2 != 3) {
                return;
            }
            this.standaloneShorterWeekdays = duplicate(strArr);
        }
    }

    public void setYearNames(String[] strArr, int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.shortYearNames = duplicate(strArr);
        }
    }

    public void setZodiacNames(String[] strArr, int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.shortZodiacNames = duplicate(strArr);
        }
    }

    public void setZoneStrings(String[][] strArr) {
        this.zoneStrings = duplicate(strArr);
    }

    @Deprecated
    public static ResourceBundle getDateFormatBundle(Calendar calendar, Locale locale) {
        return null;
    }

    @Deprecated
    public static ResourceBundle getDateFormatBundle(Class<? extends Calendar> cls, ULocale uLocale) {
        return null;
    }

    @Deprecated
    public static ResourceBundle getDateFormatBundle(Class<? extends Calendar> cls, Locale locale) {
        return null;
    }

    public static DateFormatSymbols getInstance(Locale locale) {
        return new DateFormatSymbols(locale);
    }

    public static DateFormatSymbols getInstance(ULocale uLocale) {
        return new DateFormatSymbols(uLocale);
    }

    private final String[] duplicate(String[] strArr) {
        return (String[]) strArr.clone();
    }

    public String[] getAmPmStrings() {
        return getAmPmStrings(0, 0);
    }

    public void setAmPmStrings(String[] strArr) {
        setAmPmStrings(strArr, 0, 0);
    }

    public String[] getMonths() {
        return duplicate(this.months);
    }

    public void setMonths(String[] strArr) {
        this.months = duplicate(strArr);
    }

    public String[] getWeekdays() {
        return duplicate(this.weekdays);
    }

    public void setWeekdays(String[] strArr) {
        this.weekdays = duplicate(strArr);
    }

    public DateFormatSymbols() {
        this(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public DateFormatSymbols(Locale locale) {
        this(ULocale.forLocale(locale));
    }

    public DateFormatSymbols(ULocale uLocale) {
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsWide = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.narrowQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneNarrowQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.dayOfMonthOrdinalNames = null;
        this.dayOfMonthCardinalNames = null;
        this.capitalization = null;
        initializeData(uLocale, CalendarUtil.getCalendarType(uLocale));
    }

    private DateFormatSymbols(ULocale uLocale, ICUResourceBundle iCUResourceBundle, String str) {
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsWide = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.narrowQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneNarrowQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.dayOfMonthOrdinalNames = null;
        this.dayOfMonthCardinalNames = null;
        this.capitalization = null;
        initializeData(uLocale, iCUResourceBundle, str);
    }

    public DateFormatSymbols(Calendar calendar, Locale locale) {
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsWide = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.narrowQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneNarrowQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.dayOfMonthOrdinalNames = null;
        this.dayOfMonthCardinalNames = null;
        this.capitalization = null;
        initializeData(ULocale.forLocale(locale), calendar.getType());
    }

    public DateFormatSymbols(Calendar calendar, ULocale uLocale) {
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsWide = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.narrowQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneNarrowQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.dayOfMonthOrdinalNames = null;
        this.dayOfMonthCardinalNames = null;
        this.capitalization = null;
        initializeData(uLocale, calendar.getType());
    }

    public DateFormatSymbols(Class<? extends Calendar> cls, Locale locale) {
        this(cls, ULocale.forLocale(locale));
    }

    public /* synthetic */ DateFormatSymbols(ULocale uLocale, String str) {
        this(uLocale, null, str);
    }

    public DateFormatSymbols(ResourceBundle resourceBundle, Locale locale) {
        this(resourceBundle, ULocale.forLocale(locale));
    }

    public DateFormatSymbols(ResourceBundle resourceBundle, ULocale uLocale) {
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsWide = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.narrowQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneNarrowQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.dayOfMonthOrdinalNames = null;
        this.dayOfMonthCardinalNames = null;
        this.capitalization = null;
        initializeData(uLocale, (ICUResourceBundle) resourceBundle, CalendarUtil.getCalendarType(uLocale));
    }

    public void initializeData(DateFormatSymbols dateFormatSymbols) {
        this.eras = dateFormatSymbols.eras;
        this.eraNames = dateFormatSymbols.eraNames;
        this.narrowEras = dateFormatSymbols.narrowEras;
        this.months = dateFormatSymbols.months;
        this.shortMonths = dateFormatSymbols.shortMonths;
        this.narrowMonths = dateFormatSymbols.narrowMonths;
        this.standaloneMonths = dateFormatSymbols.standaloneMonths;
        this.standaloneShortMonths = dateFormatSymbols.standaloneShortMonths;
        this.standaloneNarrowMonths = dateFormatSymbols.standaloneNarrowMonths;
        this.weekdays = dateFormatSymbols.weekdays;
        this.shortWeekdays = dateFormatSymbols.shortWeekdays;
        this.shorterWeekdays = dateFormatSymbols.shorterWeekdays;
        this.narrowWeekdays = dateFormatSymbols.narrowWeekdays;
        this.standaloneWeekdays = dateFormatSymbols.standaloneWeekdays;
        this.standaloneShortWeekdays = dateFormatSymbols.standaloneShortWeekdays;
        this.standaloneShorterWeekdays = dateFormatSymbols.standaloneShorterWeekdays;
        this.standaloneNarrowWeekdays = dateFormatSymbols.standaloneNarrowWeekdays;
        this.ampms = dateFormatSymbols.ampms;
        this.ampmsWide = dateFormatSymbols.ampmsWide;
        this.ampmsNarrow = dateFormatSymbols.ampmsNarrow;
        this.timeSeparator = dateFormatSymbols.timeSeparator;
        this.shortQuarters = dateFormatSymbols.shortQuarters;
        this.narrowQuarters = dateFormatSymbols.narrowQuarters;
        this.quarters = dateFormatSymbols.quarters;
        this.standaloneShortQuarters = dateFormatSymbols.standaloneShortQuarters;
        this.standaloneNarrowQuarters = dateFormatSymbols.standaloneNarrowQuarters;
        this.standaloneQuarters = dateFormatSymbols.standaloneQuarters;
        this.leapMonthPatterns = dateFormatSymbols.leapMonthPatterns;
        this.shortYearNames = dateFormatSymbols.shortYearNames;
        this.shortZodiacNames = dateFormatSymbols.shortZodiacNames;
        this.abbreviatedDayPeriods = dateFormatSymbols.abbreviatedDayPeriods;
        this.wideDayPeriods = dateFormatSymbols.wideDayPeriods;
        this.narrowDayPeriods = dateFormatSymbols.narrowDayPeriods;
        this.standaloneAbbreviatedDayPeriods = dateFormatSymbols.standaloneAbbreviatedDayPeriods;
        this.standaloneWideDayPeriods = dateFormatSymbols.standaloneWideDayPeriods;
        this.standaloneNarrowDayPeriods = dateFormatSymbols.standaloneNarrowDayPeriods;
        this.dayOfMonthOrdinalNames = dateFormatSymbols.dayOfMonthOrdinalNames;
        this.dayOfMonthCardinalNames = dateFormatSymbols.dayOfMonthCardinalNames;
        this.zoneStrings = dateFormatSymbols.zoneStrings;
        this.localPatternChars = dateFormatSymbols.localPatternChars;
        this.capitalization = dateFormatSymbols.capitalization;
        this.actualLocale = dateFormatSymbols.actualLocale;
        this.validLocale = dateFormatSymbols.validLocale;
        this.requestedLocale = dateFormatSymbols.requestedLocale;
    }

    public void initializeData(ULocale uLocale, String str) {
        String strK = cq.k(uLocale.getBaseName(), "+", str);
        String keywordValue = uLocale.getKeywordValue("numbers");
        if (keywordValue != null && keywordValue.length() > 0) {
            strK = cq.k(strK, "+", keywordValue);
        }
        initializeData(DFSCACHE.getInstance(strK, uLocale));
    }
}
