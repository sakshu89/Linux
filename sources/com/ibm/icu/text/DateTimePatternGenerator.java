package com.ibm.icu.text;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.Region;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class DateTimePatternGenerator implements Freezable<DateTimePatternGenerator>, Cloneable {
    private static final DisplayWidth APPENDITEM_WIDTH;
    private static final int APPENDITEM_WIDTH_INT;
    private static final String[] CANONICAL_ITEMS;
    private static final Set<String> CANONICAL_SET;
    private static final String[] CLDR_FIELD_APPEND;
    private static final String[] CLDR_FIELD_NAME;
    private static final DisplayWidth[] CLDR_FIELD_WIDTH;
    private static final int DATE_MASK = 1023;
    public static final int DAY = 7;
    public static final int DAYPERIOD = 10;
    public static final int DAY_OF_WEEK_IN_MONTH = 9;
    public static final int DAY_OF_YEAR = 8;
    private static final boolean DEBUG = false;
    private static final int DELTA = 16;
    private static ICUCache<String, DateTimePatternGenerator> DTPNG_CACHE = null;
    public static final int ERA = 0;
    private static final int EXTRA_FIELD = 65536;
    private static final String[] FIELD_NAME;
    private static final int FRACTIONAL_MASK = 16384;
    public static final int FRACTIONAL_SECOND = 14;
    public static final int HOUR = 11;
    private static final String[] LAST_RESORT_ALLOWED_HOUR_FORMAT = {DateFormat.HOUR24};
    static final Map<String, String[]> LOCALE_TO_ALLOWED_HOUR;
    private static final int LONG = -260;
    public static final int MATCH_ALL_FIELDS_LENGTH = 65535;
    public static final int MATCH_HOUR_FIELD_LENGTH = 2048;

    @Deprecated
    public static final int MATCH_MINUTE_FIELD_LENGTH = 4096;
    public static final int MATCH_NO_OPTIONS = 0;

    @Deprecated
    public static final int MATCH_SECOND_FIELD_LENGTH = 8192;
    public static final int MINUTE = 12;
    private static final int MISSING_FIELD = 4096;
    public static final int MONTH = 3;
    private static final int NARROW = -257;
    private static final int NONE = 0;
    private static final int NUMERIC = 256;
    public static final int QUARTER = 2;
    public static final int SECOND = 13;
    private static final int SECOND_AND_FRACTIONAL_MASK = 24576;
    private static final int SHORT = -259;
    private static final int SHORTER = -258;
    private static final int TIME_MASK = 64512;

    @Deprecated
    public static final int TYPE_LIMIT = 16;
    public static final int WEEKDAY = 6;
    public static final int WEEK_OF_MONTH = 5;
    public static final int WEEK_OF_YEAR = 4;
    public static final int YEAR = 1;
    public static final int ZONE = 15;
    private static final int[][] types;
    private transient DistanceInfo _distanceInfo;
    private String[] allowedHourFormats;
    private transient DateTimeMatcher current;
    private TreeMap<DateTimeMatcher, PatternWithSkeletonFlag> skeleton2pattern = new TreeMap<>();
    private TreeMap<String, PatternWithSkeletonFlag> basePattern_pattern = new TreeMap<>();
    private String decimal = "?";
    private String[] dateTimeFormats = {"{1} {0}", "{1} {0}", "{1} {0}", "{1} {0}"};
    private String[] appendItemFormats = new String[16];
    private String[][] fieldDisplayNames = (String[][]) Array.newInstance((Class<?>) String.class, 16, DisplayWidth.COUNT);
    private char defaultHourFormatChar = 'H';
    private volatile boolean frozen = false;
    private transient FormatParser fp = new FormatParser();
    private Set<String> cldrAvailableFormatKeys = new HashSet(20);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class AvailableFormatsSink extends UResource.Sink {
        PatternInfo returnInfo;

        public AvailableFormatsSink(PatternInfo patternInfo) {
            this.returnInfo = patternInfo;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            String string = key.toString();
            if (DateTimePatternGenerator.this.isAvailableFormatSet(string)) {
                return;
            }
            DateTimePatternGenerator.this.setAvailableFormat(string);
            DateTimePatternGenerator.this.addPatternWithSkeleton(value.toString(), string, true, this.returnInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum DTPGflags {
        FIX_FRACTIONAL_SECONDS,
        SKELETON_USES_CAP_J
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum DisplayWidth {
        WIDE(""),
        ABBREVIATED("-short"),
        NARROW("-narrow");


        @Deprecated
        private static int COUNT = values().length;
        private final String cldrKey;

        DisplayWidth(String str) {
            this.cldrKey = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String cldrKey() {
            return this.cldrKey;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class PatternInfo {
        public static final int BASE_CONFLICT = 1;
        public static final int CONFLICT = 2;
        public static final int OK = 0;
        public String conflictingPattern;
        public int status;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class PatternWithMatcher {
        public DateTimeMatcher matcherWithSkeleton;
        public String pattern;

        public PatternWithMatcher(String str, DateTimeMatcher dateTimeMatcher) {
            this.pattern = str;
            this.matcherWithSkeleton = dateTimeMatcher;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class PatternWithSkeletonFlag {
        public String pattern;
        public boolean skeletonWasSpecified;

        public PatternWithSkeletonFlag(String str, boolean z) {
            this.pattern = str;
            this.skeletonWasSpecified = z;
        }

        public String toString() {
            return this.pattern + "," + this.skeletonWasSpecified;
        }
    }

    static {
        HashMap map = new HashMap();
        ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER)).getAllItemsWithFallback("timeData", new DayPeriodAllowedHoursSink(map, 0));
        LOCALE_TO_ALLOWED_HOUR = Collections.unmodifiableMap(map);
        DisplayWidth displayWidth = DisplayWidth.WIDE;
        APPENDITEM_WIDTH = displayWidth;
        APPENDITEM_WIDTH_INT = displayWidth.ordinal();
        CLDR_FIELD_WIDTH = DisplayWidth.values();
        DTPNG_CACHE = new SimpleCache();
        CLDR_FIELD_APPEND = new String[]{"Era", "Year", "Quarter", "Month", "Week", "*", "Day-Of-Week", "Day", "*", "*", "*", "Hour", "Minute", "Second", "*", "Timezone"};
        CLDR_FIELD_NAME = new String[]{"era", "year", "quarter", "month", "week", "weekOfMonth", "weekday", "day", "dayOfYear", "weekdayOfMonth", "dayperiod", "hour", "minute", "second", "*", "zone"};
        FIELD_NAME = new String[]{"Era", "Year", "Quarter", "Month", "Week_in_Year", "Week_in_Month", "Weekday", "Day", "Day_Of_Year", "Day_of_Week_in_Month", "Dayperiod", "Hour", "Minute", "Second", "Fractional_Second", "Zone"};
        String[] strArr = {"G", DateFormat.YEAR, "Q", DateFormat.NUM_MONTH, "w", "W", DateFormat.ABBR_WEEKDAY, DateFormat.DAY, "D", "F", "a", DateFormat.HOUR24, DateFormat.MINUTE, DateFormat.SECOND, "S", DateFormat.ABBR_GENERIC_TZ};
        CANONICAL_ITEMS = strArr;
        CANONICAL_SET = new HashSet(Arrays.asList(strArr));
        types = new int[][]{new int[]{71, 0, SHORT, 1, 3}, new int[]{71, 0, LONG, 4}, new int[]{71, 0, NARROW, 5}, new int[]{121, 1, 256, 1, 20}, new int[]{89, 1, UCharacter.UnicodeBlock.TANGUT_ID, 1, 20}, new int[]{117, 1, UCharacter.UnicodeBlock.MAYAN_NUMERALS_ID, 1, 20}, new int[]{114, 1, UCharacter.UnicodeBlock.KHITAN_SMALL_SCRIPT_ID, 1, 20}, new int[]{85, 1, SHORT, 1, 3}, new int[]{85, 1, LONG, 4}, new int[]{85, 1, NARROW, 5}, new int[]{81, 2, 256, 1, 2}, new int[]{81, 2, SHORT, 3}, new int[]{81, 2, LONG, 4}, new int[]{81, 2, NARROW, 5}, new int[]{113, 2, UCharacter.UnicodeBlock.TANGUT_ID, 1, 2}, new int[]{113, 2, -275, 3}, new int[]{113, 2, -276, 4}, new int[]{113, 2, -273, 5}, new int[]{77, 3, 256, 1, 2}, new int[]{77, 3, SHORT, 3}, new int[]{77, 3, LONG, 4}, new int[]{77, 3, NARROW, 5}, new int[]{76, 3, UCharacter.UnicodeBlock.TANGUT_ID, 1, 2}, new int[]{76, 3, -275, 3}, new int[]{76, 3, -276, 4}, new int[]{76, 3, -273, 5}, new int[]{108, 3, UCharacter.UnicodeBlock.TANGUT_ID, 1, 1}, new int[]{119, 4, 256, 1, 2}, new int[]{87, 5, 256, 1}, new int[]{69, 6, SHORT, 1, 3}, new int[]{69, 6, LONG, 4}, new int[]{69, 6, NARROW, 5}, new int[]{69, 6, SHORTER, 6}, new int[]{99, 6, UCharacter.UnicodeBlock.MAYAN_NUMERALS_ID, 1, 2}, new int[]{99, 6, -291, 3}, new int[]{99, 6, -292, 4}, new int[]{99, 6, -289, 5}, new int[]{99, 6, -290, 6}, new int[]{101, 6, UCharacter.UnicodeBlock.TANGUT_ID, 1, 2}, new int[]{101, 6, -275, 3}, new int[]{101, 6, -276, 4}, new int[]{101, 6, -273, 5}, new int[]{101, 6, -274, 6}, new int[]{100, 7, 256, 1, 2}, new int[]{100, 7, SHORT, 3}, new int[]{103, 7, UCharacter.UnicodeBlock.TANGUT_ID, 1, 20}, new int[]{68, 8, 256, 1, 3}, new int[]{70, 9, 256, 1}, new int[]{97, 10, SHORT, 1, 3}, new int[]{97, 10, LONG, 4}, new int[]{97, 10, NARROW, 5}, new int[]{98, 10, -275, 1, 3}, new int[]{98, 10, -276, 4}, new int[]{98, 10, -273, 5}, new int[]{66, 10, -307, 1, 3}, new int[]{66, 10, -308, 4}, new int[]{66, 10, -305, 5}, new int[]{72, 11, 416, 1, 2}, new int[]{107, 11, 432, 1, 2}, new int[]{104, 11, 256, 1, 2}, new int[]{75, 11, UCharacter.UnicodeBlock.TANGUT_ID, 1, 2}, new int[]{109, 12, 256, 1, 2}, new int[]{115, 13, 256, 1, 2}, new int[]{65, 13, UCharacter.UnicodeBlock.TANGUT_ID, 1, 1000}, new int[]{83, 14, 256, 1, 1000}, new int[]{118, 15, -291, 1}, new int[]{118, 15, -292, 4}, new int[]{122, 15, SHORT, 1, 3}, new int[]{122, 15, LONG, 4}, new int[]{90, 15, -273, 1, 3}, new int[]{90, 15, -276, 4}, new int[]{90, 15, -275, 5}, new int[]{79, 15, -275, 1}, new int[]{79, 15, -276, 4}, new int[]{86, 15, -275, 1}, new int[]{86, 15, -276, 2}, new int[]{86, 15, -277, 3}, new int[]{86, 15, -278, 4}, new int[]{88, 15, -273, 1}, new int[]{88, 15, -275, 2}, new int[]{88, 15, -276, 4}, new int[]{120, 15, -273, 1}, new int[]{120, 15, -275, 2}, new int[]{120, 15, -276, 4}};
    }

    public DateTimePatternGenerator() {
        int i = 0;
        this.current = new DateTimeMatcher(i);
        this._distanceInfo = new DistanceInfo(i);
    }

    private void addCLDRData(PatternInfo patternInfo, ULocale uLocale) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        String calendarTypeToUse = getCalendarTypeToUse(uLocale);
        int i = 0;
        try {
            iCUResourceBundle.getAllChildrenWithFallback("calendar/" + calendarTypeToUse + "/appendItems", new AppendItemFormatsSink(this, i));
        } catch (MissingResourceException unused) {
        }
        try {
            iCUResourceBundle.getAllChildrenWithFallback("fields", new AppendItemNamesSink(this, i));
        } catch (MissingResourceException unused2) {
        }
        try {
            iCUResourceBundle.getAllChildrenWithFallback("calendar/" + calendarTypeToUse + "/availableFormats", new AvailableFormatsSink(patternInfo));
        } catch (MissingResourceException unused3) {
        }
    }

    private void addCanonicalItems() {
        PatternInfo patternInfo = new PatternInfo();
        int i = 0;
        while (true) {
            String[] strArr = CANONICAL_ITEMS;
            if (i >= strArr.length) {
                return;
            }
            addPattern(String.valueOf(strArr[i]), false, patternInfo);
            i++;
        }
    }

    private void addICUPatterns(PatternInfo patternInfo, ULocale uLocale) {
        String string;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        String calendarTypeToUse = getCalendarTypeToUse(uLocale);
        ICUResourceBundle withFallback = iCUResourceBundle.getWithFallback("calendar/" + calendarTypeToUse + "/DateTimePatterns");
        if (withFallback.getType() != 8 || withFallback.getSize() < 8) {
            throw new MissingResourceException("Resource in wrong format", "ICUResourceBundle", cq.v("calendar/", calendarTypeToUse, "/DateTimePatterns"));
        }
        for (int i = 0; i < 8; i++) {
            UResourceBundle uResourceBundle = withFallback.get(i);
            int type = uResourceBundle.getType();
            if (type == 0) {
                string = uResourceBundle.getString();
            } else {
                if (type != 8) {
                    throw new MissingResourceException("Resource in wrong format", "ICUResourceBundle", cq.v("calendar/", calendarTypeToUse, "/DateTimePatterns"));
                }
                string = uResourceBundle.getString(0);
            }
            addPattern(string, false, patternInfo);
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:80:0x011f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0128 A[LOOP:1: B:82:0x0126->B:83:0x0128, LOOP_END] */
    private String adjustFieldTypes(PatternWithMatcher patternWithMatcher, DateTimeMatcher dateTimeMatcher, EnumSet<DTPGflags> enumSet, int i) {
        char cCharAt;
        char c;
        char c2;
        this.fp.set(patternWithMatcher.pattern);
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.fp.getItems()) {
            if (obj instanceof String) {
                sb.append(this.fp.quoteLiteral((String) obj));
            } else {
                VariableField variableField = (VariableField) obj;
                StringBuilder sb2 = new StringBuilder(variableField.toString());
                int type = variableField.getType();
                if (enumSet.contains(DTPGflags.FIX_FRACTIONAL_SECONDS) && type == 13) {
                    sb2.append(this.decimal);
                    dateTimeMatcher.original.appendFieldTo(14, sb2);
                } else {
                    if (dateTimeMatcher.type[type] != 0) {
                        char fieldChar = dateTimeMatcher.original.getFieldChar(type);
                        int fieldLength = dateTimeMatcher.original.getFieldLength(type);
                        if (fieldChar == 'E' && fieldLength < 3) {
                            fieldLength = 3;
                        }
                        DateTimeMatcher dateTimeMatcher2 = patternWithMatcher.matcherWithSkeleton;
                        if ((type == 11 && (i & 2048) == 0) || ((type == 12 && (i & 4096) == 0) || (type == 13 && (i & 8192) == 0))) {
                            fieldLength = sb2.length();
                        } else {
                            if (dateTimeMatcher2 != null && fieldChar != 'c' && fieldChar != 'e') {
                                int fieldLength2 = dateTimeMatcher2.original.getFieldLength(type);
                                boolean zIsNumeric = variableField.isNumeric();
                                boolean zFieldIsNumeric = dateTimeMatcher.fieldIsNumeric(type);
                                if (fieldLength2 == fieldLength || ((zIsNumeric && !zFieldIsNumeric) || (zFieldIsNumeric && !zIsNumeric))) {
                                    fieldLength = sb2.length();
                                }
                            }
                            if (type != 11 || type == 3 || type == 6 || (type == 1 && fieldChar != 'Y')) {
                                cCharAt = sb2.charAt(0);
                            } else {
                                cCharAt = fieldChar;
                            }
                            c = (cCharAt == 'E' || fieldLength >= 3) ? cCharAt : 'e';
                            if (type == 11) {
                                if (!enumSet.contains(DTPGflags.SKELETON_USES_CAP_J) || fieldChar == (c2 = this.defaultHourFormatChar)) {
                                    c = this.defaultHourFormatChar;
                                } else if (fieldChar == 'h' && c2 == 'K') {
                                    c = 'K';
                                } else if (fieldChar == 'H' && c2 == 'k') {
                                    c = 'k';
                                } else if (fieldChar == 'k' && c2 == 'H') {
                                    c = 'H';
                                } else if (fieldChar == 'K' && c2 == 'h') {
                                    c = 'h';
                                }
                            }
                            sb2 = new StringBuilder();
                            while (fieldLength > 0) {
                                sb2.append(c);
                                fieldLength--;
                            }
                        }
                        if (type != 11) {
                            cCharAt = sb2.charAt(0);
                        } else {
                            cCharAt = sb2.charAt(0);
                        }
                        if (cCharAt == 'E') {
                        }
                        if (type == 11) {
                            if (enumSet.contains(DTPGflags.SKELETON_USES_CAP_J)) {
                                c = this.defaultHourFormatChar;
                            } else {
                                c = this.defaultHourFormatChar;
                            }
                        }
                        sb2 = new StringBuilder();
                        while (fieldLength > 0) {
                            sb2.append(c);
                            fieldLength--;
                        }
                    }
                    sb.append((CharSequence) sb2);
                }
                sb.append((CharSequence) sb2);
            }
        }
        return sb.toString();
    }

    private void checkFrozen() {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen object");
        }
    }

    private void fillInMissing() {
        for (int i = 0; i < 16; i++) {
            if (getAppendItemFormat(i) == null) {
                setAppendItemFormat(i, "{0} ├{2}: {1}┤");
            }
            DisplayWidth displayWidth = DisplayWidth.WIDE;
            if (getFieldDisplayName(i, displayWidth) == null) {
                setFieldDisplayName(i, displayWidth, ky0.h(i, "F"));
            }
            DisplayWidth displayWidth2 = DisplayWidth.ABBREVIATED;
            if (getFieldDisplayName(i, displayWidth2) == null) {
                setFieldDisplayName(i, displayWidth2, getFieldDisplayName(i, displayWidth));
            }
            DisplayWidth displayWidth3 = DisplayWidth.NARROW;
            if (getFieldDisplayName(i, displayWidth3) == null) {
                setFieldDisplayName(i, displayWidth3, getFieldDisplayName(i, displayWidth2));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0095  */
    private void getAllowedHourFormats(ULocale uLocale) {
        Character ch;
        String language = uLocale.getLanguage();
        String regionForSupplementalData = ULocale.getRegionForSupplementalData(uLocale, false);
        if (language.isEmpty() || regionForSupplementalData.isEmpty()) {
            ULocale uLocaleAddLikelySubtags = ULocale.addLikelySubtags(uLocale);
            String language2 = uLocaleAddLikelySubtags.getLanguage();
            regionForSupplementalData = uLocaleAddLikelySubtags.getCountry();
            language = language2;
        }
        if (language.isEmpty()) {
            language = "und";
        }
        if (regionForSupplementalData.isEmpty()) {
            regionForSupplementalData = UnitsData.Constants.DEFAULT_REGION;
        }
        String[] allowedHourFormatsLangCountry = getAllowedHourFormatsLangCountry(language, regionForSupplementalData);
        String keywordValue = uLocale.getKeywordValue("hours");
        if (keywordValue != null) {
            switch (keywordValue) {
                case "h11":
                    ch = 'K';
                    break;
                case "h12":
                    ch = 'h';
                    break;
                case "h23":
                    ch = 'H';
                    break;
                case "h24":
                    ch = 'k';
                    break;
                default:
                    ch = null;
                    break;
            }
        } else {
            ch = null;
        }
        if (allowedHourFormatsLangCountry == null) {
            try {
                allowedHourFormatsLangCountry = getAllowedHourFormatsLangCountry(language, Region.getInstance(regionForSupplementalData).toString());
            } catch (IllegalArgumentException unused) {
            }
        }
        if (allowedHourFormatsLangCountry == null) {
            String[] strArr = LAST_RESORT_ALLOWED_HOUR_FORMAT;
            this.allowedHourFormats = strArr;
            this.defaultHourFormatChar = ch != null ? ch.charValue() : strArr[0].charAt(0);
        } else {
            this.defaultHourFormatChar = ch != null ? ch.charValue() : allowedHourFormatsLangCountry[0].charAt(0);
            if (allowedHourFormatsLangCountry.length > 1) {
                this.allowedHourFormats = (String[]) Arrays.copyOfRange(allowedHourFormatsLangCountry, 1, allowedHourFormatsLangCountry.length);
            } else {
                this.allowedHourFormats = LAST_RESORT_ALLOWED_HOUR_FORMAT;
            }
        }
    }

    private String[] getAllowedHourFormatsLangCountry(String str, String str2) {
        String strK = cq.k(str, BaseLocale.SEP, str2);
        Map<String, String[]> map = LOCALE_TO_ALLOWED_HOUR;
        String[] strArr = map.get(strK);
        return strArr == null ? map.get(str2) : strArr;
    }

    private String getAppendFormat(int i) {
        return this.appendItemFormats[i];
    }

    @Deprecated
    public static int getAppendFormatNumber(UResource.Key key) {
        int i = 0;
        while (true) {
            String[] strArr = CLDR_FIELD_APPEND;
            if (i >= strArr.length) {
                return -1;
            }
            if (key.contentEquals(strArr[i])) {
                return i;
            }
            i++;
        }
    }

    private String getAppendName(int i) {
        return cq.v("'", this.fieldDisplayNames[i][APPENDITEM_WIDTH_INT], "'");
    }

    private String getBestAppending(DateTimeMatcher dateTimeMatcher, int i, DistanceInfo distanceInfo, DateTimeMatcher dateTimeMatcher2, EnumSet<DTPGflags> enumSet, int i2) {
        if (i == 0) {
            return null;
        }
        PatternWithMatcher bestRaw = getBestRaw(dateTimeMatcher, i, distanceInfo, dateTimeMatcher2);
        String strAdjustFieldTypes = adjustFieldTypes(bestRaw, dateTimeMatcher, enumSet, i2);
        while (true) {
            int i3 = distanceInfo.missingFieldMask;
            if (i3 == 0) {
                return strAdjustFieldTypes;
            }
            if ((i3 & SECOND_AND_FRACTIONAL_MASK) == 16384 && (i & SECOND_AND_FRACTIONAL_MASK) == SECOND_AND_FRACTIONAL_MASK) {
                bestRaw.pattern = strAdjustFieldTypes;
                enumSet = EnumSet.copyOf((EnumSet) enumSet);
                enumSet.add(DTPGflags.FIX_FRACTIONAL_SECONDS);
                strAdjustFieldTypes = adjustFieldTypes(bestRaw, dateTimeMatcher, enumSet, i2);
                distanceInfo.missingFieldMask &= -16385;
            } else {
                String strAdjustFieldTypes2 = adjustFieldTypes(getBestRaw(dateTimeMatcher, i3, distanceInfo, dateTimeMatcher2), dateTimeMatcher, enumSet, i2);
                int topBitNumber = getTopBitNumber(i3 & (~distanceInfo.missingFieldMask));
                strAdjustFieldTypes = SimpleFormatterImpl.formatRawPattern(getAppendFormat(topBitNumber), 2, 3, strAdjustFieldTypes, strAdjustFieldTypes2, getAppendName(topBitNumber));
            }
        }
    }

    private String getBestPattern(String str, DateTimeMatcher dateTimeMatcher, int i) throws Throwable {
        Throwable th;
        int i2;
        EnumSet<DTPGflags> enumSetNoneOf = EnumSet.noneOf(DTPGflags.class);
        String strMapSkeletonMetacharacters = mapSkeletonMetacharacters(str, enumSetNoneOf);
        synchronized (this) {
            try {
                try {
                    this.current.set(strMapSkeletonMetacharacters, this.fp, false);
                    PatternWithMatcher bestRaw = getBestRaw(this.current, -1, this._distanceInfo, dateTimeMatcher);
                    DistanceInfo distanceInfo = this._distanceInfo;
                    if (distanceInfo.missingFieldMask == 0) {
                        try {
                            if (distanceInfo.extraFieldMask == 0) {
                                return adjustFieldTypes(bestRaw, this.current, enumSetNoneOf, i);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    int fieldMask = this.current.getFieldMask();
                    String bestAppending = getBestAppending(this.current, fieldMask & 1023, this._distanceInfo, dateTimeMatcher, enumSetNoneOf, i);
                    String bestAppending2 = getBestAppending(this.current, fieldMask & 64512, this._distanceInfo, dateTimeMatcher, enumSetNoneOf, i);
                    if (bestAppending == null) {
                        return bestAppending2 == null ? "" : bestAppending2;
                    }
                    if (bestAppending2 == null) {
                        return bestAppending;
                    }
                    String canonicalString = this.current.toCanonicalString();
                    int iIndexOf = canonicalString.indexOf(77);
                    int iLastIndexOf = iIndexOf >= 0 ? (canonicalString.lastIndexOf(77) + 1) - iIndexOf : 0;
                    if (iLastIndexOf == 4) {
                        i2 = canonicalString.indexOf(69) >= 0 ? 0 : 1;
                    } else {
                        i2 = 3;
                        if (iLastIndexOf == 3) {
                            i2 = 2;
                        }
                    }
                    return SimpleFormatterImpl.formatRawPattern(getDateTimeFormat(i2), 2, 2, bestAppending2, bestAppending);
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    private PatternWithMatcher getBestRaw(DateTimeMatcher dateTimeMatcher, int i, DistanceInfo distanceInfo, DateTimeMatcher dateTimeMatcher2) {
        int distance;
        PatternWithMatcher patternWithMatcher = new PatternWithMatcher("", null);
        DistanceInfo distanceInfo2 = new DistanceInfo(0);
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (DateTimeMatcher dateTimeMatcher3 : this.skeleton2pattern.keySet()) {
            if (!dateTimeMatcher3.equals(dateTimeMatcher2) && yearLengthIsCompatible(dateTimeMatcher, dateTimeMatcher3) && ((distance = dateTimeMatcher.getDistance(dateTimeMatcher3, i, distanceInfo2)) < i2 || (distance == i2 && i3 < distanceInfo2.missingFieldMask))) {
                int i4 = distanceInfo2.missingFieldMask;
                PatternWithSkeletonFlag patternWithSkeletonFlag = this.skeleton2pattern.get(dateTimeMatcher3);
                patternWithMatcher.pattern = patternWithSkeletonFlag.pattern;
                if (patternWithSkeletonFlag.skeletonWasSpecified) {
                    patternWithMatcher.matcherWithSkeleton = dateTimeMatcher3;
                } else {
                    patternWithMatcher.matcherWithSkeleton = null;
                }
                distanceInfo.setTo(distanceInfo2);
                if (distance == 0) {
                    break;
                }
                i3 = i4;
                i2 = distance;
            }
        }
        return patternWithMatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getCLDRFieldAndWidthNumber(UResource.Key key) {
        for (int i = 0; i < CLDR_FIELD_NAME.length; i++) {
            for (int i2 = 0; i2 < DisplayWidth.COUNT; i2++) {
                if (key.contentEquals(CLDR_FIELD_NAME[i].concat(CLDR_FIELD_WIDTH[i2].cldrKey()))) {
                    return (DisplayWidth.COUNT * i) + i2;
                }
            }
        }
        return -1;
    }

    private String getCalendarTypeToUse(ULocale uLocale) {
        String keywordValue = uLocale.getKeywordValue("calendar");
        if (keywordValue == null) {
            keywordValue = Calendar.getKeywordValuesForLocale("calendar", uLocale, true)[0];
        }
        return keywordValue == null ? "gregorian" : keywordValue;
    }

    private static char getCanonicalChar(int i, char c) {
        if (c == 'h' || c == 'K') {
            return 'h';
        }
        int i2 = 0;
        while (true) {
            int[][] iArr = types;
            if (i2 >= iArr.length) {
                og.i(ky0.h(i, "Could not find field "));
                return (char) 0;
            }
            int[] iArr2 = iArr[i2];
            if (iArr2[1] == i) {
                return (char) iArr2[0];
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getCanonicalIndex(String str, boolean z) {
        int length = str.length();
        if (length == 0) {
            return -1;
        }
        char cCharAt = str.charAt(0);
        for (int i = 1; i < length; i++) {
            if (str.charAt(i) != cCharAt) {
                return -1;
            }
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr = types;
            if (i3 >= iArr.length) {
                if (z) {
                    return -1;
                }
                return i2;
            }
            int[] iArr2 = iArr[i3];
            if (iArr2[0] == cCharAt) {
                if (iArr2[3] <= length && iArr2[iArr2.length - 1] >= length) {
                    return i3;
                }
                i2 = i3;
            }
            i3++;
        }
    }

    public static DateTimePatternGenerator getEmptyInstance() {
        DateTimePatternGenerator dateTimePatternGenerator = new DateTimePatternGenerator();
        dateTimePatternGenerator.addCanonicalItems();
        dateTimePatternGenerator.fillInMissing();
        return dateTimePatternGenerator;
    }

    @Deprecated
    public static DateTimePatternGenerator getFrozenInstance(ULocale uLocale) {
        String string = uLocale.toString();
        DateTimePatternGenerator dateTimePatternGenerator = DTPNG_CACHE.get(string);
        if (dateTimePatternGenerator != null) {
            return dateTimePatternGenerator;
        }
        DateTimePatternGenerator dateTimePatternGenerator2 = new DateTimePatternGenerator();
        dateTimePatternGenerator2.initData(uLocale, false);
        dateTimePatternGenerator2.freeze();
        DTPNG_CACHE.put(string, dateTimePatternGenerator2);
        return dateTimePatternGenerator2;
    }

    public static DateTimePatternGenerator getInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    @Deprecated
    public static DateTimePatternGenerator getInstanceNoStdPat(ULocale uLocale) {
        DateTimePatternGenerator dateTimePatternGenerator = new DateTimePatternGenerator();
        dateTimePatternGenerator.initData(uLocale, true);
        return dateTimePatternGenerator;
    }

    private static String getName(String str) {
        int canonicalIndex = getCanonicalIndex(str, true);
        String[] strArr = FIELD_NAME;
        int[] iArr = types[canonicalIndex];
        String str2 = strArr[iArr[1]];
        return iArr[2] < 0 ? ky0.j(str2, ":S") : ky0.j(str2, ":N");
    }

    private TreeSet<String> getSet(String str) {
        List<Object> items = this.fp.set(str).getItems();
        TreeSet<String> treeSet = new TreeSet<>();
        Iterator<Object> it = items.iterator();
        while (it.hasNext()) {
            String string = it.next().toString();
            if (!string.startsWith("G") && !string.startsWith("a")) {
                treeSet.add(string);
            }
        }
        return treeSet;
    }

    private int getTopBitNumber(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2 - 1;
    }

    public static /* bridge */ /* synthetic */ char i(char c, int i) {
        return getCanonicalChar(i, c);
    }

    private void initData(ULocale uLocale, boolean z) {
        PatternInfo patternInfo = new PatternInfo();
        addCanonicalItems();
        if (!z) {
            addICUPatterns(patternInfo, uLocale);
        }
        addCLDRData(patternInfo, uLocale);
        if (z) {
            setDateTimeFormat("{1} {0}");
        } else {
            setDateTimeFromCalendar(uLocale);
        }
        setDecimalSymbols(uLocale);
        getAllowedHourFormats(uLocale);
        fillInMissing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAvailableFormatSet(String str) {
        return this.cldrAvailableFormatKeys.contains(str);
    }

    @Deprecated
    public static boolean isSingleField(String str) {
        char cCharAt = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != cCharAt) {
                return false;
            }
        }
        return true;
    }

    private String mapSkeletonMetacharacters(String str, EnumSet<DTPGflags> enumSet) {
        char c;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z = false;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\'') {
                z = !z;
            } else if (!z) {
                if (cCharAt == 'j' || cCharAt == 'C') {
                    int i2 = 0;
                    while (true) {
                        int i3 = i + 1;
                        if (i3 >= str.length() || str.charAt(i3) != cCharAt) {
                            break;
                        }
                        i2++;
                        i = i3;
                    }
                    int i4 = (i2 & 1) + 1;
                    int i5 = i2 < 2 ? 1 : (i2 >> 1) + 3;
                    char c2 = 'a';
                    if (cCharAt == 'j') {
                        c = this.defaultHourFormatChar;
                    } else {
                        String str2 = this.allowedHourFormats[0];
                        char cCharAt2 = str2.charAt(0);
                        char cCharAt3 = str2.charAt(str2.length() - 1);
                        c2 = (cCharAt3 == 'b' || cCharAt3 == 'B') ? cCharAt3 : 'a';
                        c = cCharAt2;
                    }
                    if (c == 'H' || c == 'k') {
                        i5 = 0;
                    }
                    while (true) {
                        int i6 = i5 - 1;
                        if (i5 <= 0) {
                            break;
                        }
                        sb.append(c2);
                        i5 = i6;
                    }
                    while (true) {
                        int i7 = i4 - 1;
                        if (i4 > 0) {
                            sb.append(c);
                            i4 = i7;
                        }
                    }
                } else if (cCharAt == 'J') {
                    sb.append('H');
                    enumSet.add(DTPGflags.SKELETON_USES_CAP_J);
                } else {
                    sb.append(cCharAt);
                }
            }
            i++;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAvailableFormat(String str) {
        checkFrozen();
        this.cldrAvailableFormatKeys.add(str);
    }

    private void setDateTimeFromCalendar(ULocale uLocale) {
        Calendar calendar = Calendar.getInstance(uLocale);
        for (int i = 0; i <= 3; i++) {
            setDateTimeFormat(i, Calendar.getDateAtTimePattern(calendar, uLocale, i));
        }
    }

    private void setDecimalSymbols(ULocale uLocale) {
        setDecimal(String.valueOf(new DecimalFormatSymbols(uLocale).getDecimalSeparator()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void setFieldDisplayName(int i, DisplayWidth displayWidth, String str) {
        checkFrozen();
        if (i >= 16 || i < 0) {
            return;
        }
        this.fieldDisplayNames[i][displayWidth.ordinal()] = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String showMask(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 16; i2++) {
            if (((1 << i2) & i) != 0) {
                if (sb.length() != 0) {
                    sb.append(" | ");
                }
                sb.append(FIELD_NAME[i2]);
                sb.append(Padder.FALLBACK_PADDING_STRING);
            }
        }
        return sb.toString();
    }

    private static boolean yearLengthIsCompatible(DateTimeMatcher dateTimeMatcher, DateTimeMatcher dateTimeMatcher2) {
        return (dateTimeMatcher.fieldIsNumeric(1) && dateTimeMatcher2.fieldIsNumeric(1) && dateTimeMatcher2.original.getFieldLength(1) == 2 && dateTimeMatcher.original.getFieldLength(1) != 2) ? false : true;
    }

    public DateTimePatternGenerator addPattern(String str, boolean z, PatternInfo patternInfo) {
        return addPatternWithSkeleton(str, null, z, patternInfo);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003d  */
    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:20:0x0052  */
    /* JADX WARN: Code duplicated, block: B:25:0x0061  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        if (r3.skeletonWasSpecified == false) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ibm.icu.text.DateTimePatternGenerator addPatternWithSkeleton(java.lang.String r7, java.lang.String r8, boolean r9, com.ibm.icu.text.DateTimePatternGenerator.PatternInfo r10) {
        /*
            r6 = this;
            r6.checkFrozen()
            r0 = 0
            if (r8 != 0) goto L12
            com.ibm.icu.text.DateTimePatternGenerator$DateTimeMatcher r1 = new com.ibm.icu.text.DateTimePatternGenerator$DateTimeMatcher
            r1.<init>(r0)
            com.ibm.icu.text.DateTimePatternGenerator$FormatParser r2 = r6.fp
            com.ibm.icu.text.DateTimePatternGenerator$DateTimeMatcher r1 = r1.set(r7, r2, r0)
            goto L1d
        L12:
            com.ibm.icu.text.DateTimePatternGenerator$DateTimeMatcher r1 = new com.ibm.icu.text.DateTimePatternGenerator$DateTimeMatcher
            r1.<init>(r0)
            com.ibm.icu.text.DateTimePatternGenerator$FormatParser r2 = r6.fp
            com.ibm.icu.text.DateTimePatternGenerator$DateTimeMatcher r1 = r1.set(r8, r2, r0)
        L1d:
            java.lang.String r2 = r1.getBasePattern()
            java.util.TreeMap<java.lang.String, com.ibm.icu.text.DateTimePatternGenerator$PatternWithSkeletonFlag> r3 = r6.basePattern_pattern
            java.lang.Object r3 = r3.get(r2)
            com.ibm.icu.text.DateTimePatternGenerator$PatternWithSkeletonFlag r3 = (com.ibm.icu.text.DateTimePatternGenerator.PatternWithSkeletonFlag) r3
            r4 = 1
            if (r3 == 0) goto L3d
            boolean r5 = r3.skeletonWasSpecified
            if (r5 == 0) goto L34
            if (r8 == 0) goto L3d
            if (r9 != 0) goto L3d
        L34:
            r10.status = r4
            java.lang.String r3 = r3.pattern
            r10.conflictingPattern = r3
            if (r9 != 0) goto L3d
            goto L56
        L3d:
            java.util.TreeMap<com.ibm.icu.text.DateTimePatternGenerator$DateTimeMatcher, com.ibm.icu.text.DateTimePatternGenerator$PatternWithSkeletonFlag> r3 = r6.skeleton2pattern
            java.lang.Object r3 = r3.get(r1)
            com.ibm.icu.text.DateTimePatternGenerator$PatternWithSkeletonFlag r3 = (com.ibm.icu.text.DateTimePatternGenerator.PatternWithSkeletonFlag) r3
            if (r3 == 0) goto L57
            r5 = 2
            r10.status = r5
            java.lang.String r5 = r3.pattern
            r10.conflictingPattern = r5
            if (r9 == 0) goto L56
            if (r8 == 0) goto L57
            boolean r9 = r3.skeletonWasSpecified
            if (r9 == 0) goto L57
        L56:
            return r6
        L57:
            r10.status = r0
            java.lang.String r9 = ""
            r10.conflictingPattern = r9
            com.ibm.icu.text.DateTimePatternGenerator$PatternWithSkeletonFlag r9 = new com.ibm.icu.text.DateTimePatternGenerator$PatternWithSkeletonFlag
            if (r8 == 0) goto L62
            r0 = r4
        L62:
            r9.<init>(r7, r0)
            java.util.TreeMap<com.ibm.icu.text.DateTimePatternGenerator$DateTimeMatcher, com.ibm.icu.text.DateTimePatternGenerator$PatternWithSkeletonFlag> r7 = r6.skeleton2pattern
            r7.put(r1, r9)
            java.util.TreeMap<java.lang.String, com.ibm.icu.text.DateTimePatternGenerator$PatternWithSkeletonFlag> r7 = r6.basePattern_pattern
            r7.put(r2, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.DateTimePatternGenerator.addPatternWithSkeleton(java.lang.String, java.lang.String, boolean, com.ibm.icu.text.DateTimePatternGenerator$PatternInfo):com.ibm.icu.text.DateTimePatternGenerator");
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DateTimePatternGenerator m16clone() {
        try {
            DateTimePatternGenerator dateTimePatternGenerator = (DateTimePatternGenerator) super.clone();
            dateTimePatternGenerator.skeleton2pattern = (TreeMap) this.skeleton2pattern.clone();
            dateTimePatternGenerator.basePattern_pattern = (TreeMap) this.basePattern_pattern.clone();
            dateTimePatternGenerator.dateTimeFormats = (String[]) this.dateTimeFormats.clone();
            dateTimePatternGenerator.appendItemFormats = (String[]) this.appendItemFormats.clone();
            dateTimePatternGenerator.fieldDisplayNames = (String[][]) this.fieldDisplayNames.clone();
            int i = 0;
            dateTimePatternGenerator.current = new DateTimeMatcher(i);
            dateTimePatternGenerator.fp = new FormatParser();
            dateTimePatternGenerator._distanceInfo = new DistanceInfo(i);
            dateTimePatternGenerator.frozen = false;
            return dateTimePatternGenerator;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException("Internal Error", e);
        }
    }

    @Override // com.ibm.icu.util.Freezable
    public DateTimePatternGenerator cloneAsThawed() {
        DateTimePatternGenerator dateTimePatternGeneratorM16clone = m16clone();
        dateTimePatternGeneratorM16clone.frozen = false;
        return dateTimePatternGeneratorM16clone;
    }

    public String getAppendItemFormat(int i) {
        return this.appendItemFormats[i];
    }

    public String getAppendItemName(int i) {
        return getFieldDisplayName(i, APPENDITEM_WIDTH);
    }

    public String getBaseSkeleton(String str) {
        String basePattern;
        synchronized (this) {
            this.current.set(str, this.fp, false);
            basePattern = this.current.getBasePattern();
        }
        return basePattern;
    }

    public Set<String> getBaseSkeletons(Set<String> set) {
        if (set == null) {
            set = new HashSet<>();
        }
        set.addAll(this.basePattern_pattern.keySet());
        return set;
    }

    @Deprecated
    public String getCanonicalSkeletonAllowingDuplicates(String str) {
        String canonicalString;
        synchronized (this) {
            this.current.set(str, this.fp, true);
            canonicalString = this.current.toCanonicalString();
        }
        return canonicalString;
    }

    public String getDateTimeFormat(int i) {
        if (i >= 0 && i <= 3) {
            return this.dateTimeFormats[i];
        }
        og.i(ky0.h(i, "Illegal style here: "));
        return null;
    }

    public String getDecimal() {
        return this.decimal;
    }

    public DateFormat.HourCycle getDefaultHourCycle() {
        char defaultHourFormatChar = getDefaultHourFormatChar();
        if (defaultHourFormatChar == 'H') {
            return DateFormat.HourCycle.HOUR_CYCLE_23;
        }
        if (defaultHourFormatChar == 'K') {
            return DateFormat.HourCycle.HOUR_CYCLE_11;
        }
        if (defaultHourFormatChar == 'h') {
            return DateFormat.HourCycle.HOUR_CYCLE_12;
        }
        if (defaultHourFormatChar == 'k') {
            return DateFormat.HourCycle.HOUR_CYCLE_24;
        }
        og.m("should be unreachable");
        return null;
    }

    @Deprecated
    public char getDefaultHourFormatChar() {
        return this.defaultHourFormatChar;
    }

    public String getFieldDisplayName(int i, DisplayWidth displayWidth) {
        return (i >= 16 || i < 0) ? "" : this.fieldDisplayNames[i][displayWidth.ordinal()];
    }

    @Deprecated
    public String getFields(String str) {
        this.fp.set(str);
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.fp.getItems()) {
            if (obj instanceof String) {
                sb.append(this.fp.quoteLiteral((String) obj));
            } else {
                sb.append("{" + getName(obj.toString()) + "}");
            }
        }
        return sb.toString();
    }

    @Deprecated
    public Collection<String> getRedundants(Collection<String> collection) {
        synchronized (this) {
            if (collection == null) {
                try {
                    collection = new LinkedHashSet<>();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (DateTimeMatcher dateTimeMatcher : this.skeleton2pattern.keySet()) {
                String str = this.skeleton2pattern.get(dateTimeMatcher).pattern;
                if (!CANONICAL_SET.contains(str) && getBestPattern(dateTimeMatcher.toString(), dateTimeMatcher, 0).equals(str)) {
                    collection.add(str);
                }
            }
        }
        return collection;
    }

    public String getSkeleton(String str) {
        String string;
        synchronized (this) {
            this.current.set(str, this.fp, false);
            string = this.current.toString();
        }
        return string;
    }

    @Deprecated
    public String getSkeletonAllowingDuplicates(String str) {
        String string;
        synchronized (this) {
            this.current.set(str, this.fp, true);
            string = this.current.toString();
        }
        return string;
    }

    public Map<String, String> getSkeletons(Map<String, String> map) {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        for (DateTimeMatcher dateTimeMatcher : this.skeleton2pattern.keySet()) {
            String str = this.skeleton2pattern.get(dateTimeMatcher).pattern;
            if (!CANONICAL_SET.contains(str)) {
                map.put(dateTimeMatcher.toString(), str);
            }
        }
        return map;
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.frozen;
    }

    public String replaceFieldTypes(String str, String str2, int i) {
        String strAdjustFieldTypes;
        synchronized (this) {
            strAdjustFieldTypes = adjustFieldTypes(new PatternWithMatcher(str, null), this.current.set(str2, this.fp, false), EnumSet.noneOf(DTPGflags.class), i);
        }
        return strAdjustFieldTypes;
    }

    public void setAppendItemFormat(int i, String str) {
        checkFrozen();
        this.appendItemFormats[i] = str;
    }

    public void setAppendItemName(int i, String str) {
        setFieldDisplayName(i, APPENDITEM_WIDTH, str);
    }

    public void setDateTimeFormat(int i, String str) {
        if (i < 0 || i > 3) {
            og.i(ky0.h(i, "Illegal style here: "));
        } else {
            checkFrozen();
            this.dateTimeFormats[i] = str;
        }
    }

    public void setDecimal(String str) {
        checkFrozen();
        this.decimal = str;
    }

    @Deprecated
    public void setDefaultHourFormatChar(char c) {
        this.defaultHourFormatChar = c;
    }

    @Deprecated
    public boolean skeletonsAreSimilar(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        TreeSet<String> set = getSet(str);
        TreeSet<String> set2 = getSet(str2);
        if (set.size() != set2.size()) {
            return false;
        }
        Iterator<String> it = set2.iterator();
        Iterator<String> it2 = set.iterator();
        while (it2.hasNext()) {
            int canonicalIndex = getCanonicalIndex(it2.next(), false);
            int canonicalIndex2 = getCanonicalIndex(it.next(), false);
            int[][] iArr = types;
            if (iArr[canonicalIndex][1] != iArr[canonicalIndex2][1]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DistanceInfo {
        int extraFieldMask;
        int missingFieldMask;

        public /* synthetic */ DistanceInfo(int i) {
            this();
        }

        public void addExtra(int i) {
            this.extraFieldMask = (1 << i) | this.extraFieldMask;
        }

        public void addMissing(int i) {
            this.missingFieldMask = (1 << i) | this.missingFieldMask;
        }

        public void clear() {
            this.extraFieldMask = 0;
            this.missingFieldMask = 0;
        }

        public void setTo(DistanceInfo distanceInfo) {
            this.missingFieldMask = distanceInfo.missingFieldMask;
            this.extraFieldMask = distanceInfo.extraFieldMask;
        }

        public String toString() {
            return cq.l("missingFieldMask: ", DateTimePatternGenerator.showMask(this.missingFieldMask), ", extraFieldMask: ", DateTimePatternGenerator.showMask(this.extraFieldMask));
        }

        private DistanceInfo() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class AppendItemFormatsSink extends UResource.Sink {
        private AppendItemFormatsSink() {
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            int appendFormatNumber = DateTimePatternGenerator.getAppendFormatNumber(key);
            if (appendFormatNumber >= 0 && DateTimePatternGenerator.this.getAppendItemFormat(appendFormatNumber) == null) {
                DateTimePatternGenerator.this.setAppendItemFormat(appendFormatNumber, value.toString());
            }
        }

        public /* synthetic */ AppendItemFormatsSink(DateTimePatternGenerator dateTimePatternGenerator, int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class AppendItemNamesSink extends UResource.Sink {
        private AppendItemNamesSink() {
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            int cLDRFieldAndWidthNumber = DateTimePatternGenerator.getCLDRFieldAndWidthNumber(key);
            if (cLDRFieldAndWidthNumber == -1) {
                return;
            }
            int i = cLDRFieldAndWidthNumber / DisplayWidth.COUNT;
            DisplayWidth displayWidth = DateTimePatternGenerator.CLDR_FIELD_WIDTH[cLDRFieldAndWidthNumber % DisplayWidth.COUNT];
            if (value.getTable().findValue("dn", value) && DateTimePatternGenerator.this.getFieldDisplayName(i, displayWidth) == null) {
                DateTimePatternGenerator.this.setFieldDisplayName(i, displayWidth, value.toString());
            }
        }

        public /* synthetic */ AppendItemNamesSink(DateTimePatternGenerator dateTimePatternGenerator, int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DayPeriodAllowedHoursSink extends UResource.Sink {
        HashMap<String, String[]> tempMap;

        private DayPeriodAllowedHoursSink(HashMap<String, String[]> map) {
            this.tempMap = map;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            String[] strArr;
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                String string = key.toString();
                UResource.Table table2 = value.getTable();
                String[] stringArrayOrStringAsArray = null;
                String string2 = null;
                for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                    if (key.contentEquals("allowed")) {
                        stringArrayOrStringAsArray = value.getStringArrayOrStringAsArray();
                    } else if (key.contentEquals("preferred")) {
                        string2 = value.getString();
                    }
                }
                if (stringArrayOrStringAsArray == null || stringArrayOrStringAsArray.length <= 0) {
                    if (string2 == null) {
                        string2 = DateTimePatternGenerator.LAST_RESORT_ALLOWED_HOUR_FORMAT[0];
                    }
                    strArr = new String[]{string2, string2};
                } else {
                    strArr = new String[stringArrayOrStringAsArray.length + 1];
                    if (string2 == null) {
                        string2 = stringArrayOrStringAsArray[0];
                    }
                    strArr[0] = string2;
                    System.arraycopy(stringArrayOrStringAsArray, 0, strArr, 1, stringArrayOrStringAsArray.length);
                }
                this.tempMap.put(string, strArr);
            }
        }

        public /* synthetic */ DayPeriodAllowedHoursSink(HashMap map, int i) {
            this(map);
        }
    }

    @Override // com.ibm.icu.util.Freezable
    public DateTimePatternGenerator freeze() {
        this.frozen = true;
        return this;
    }

    public static DateTimePatternGenerator getInstance(ULocale uLocale) {
        return getFrozenInstance(uLocale).cloneAsThawed();
    }

    public static DateTimePatternGenerator getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SkeletonFields {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte DEFAULT_CHAR = 0;
        private static final byte DEFAULT_LENGTH = 0;
        private byte[] chars;
        private byte[] lengths;

        private SkeletonFields() {
            this.chars = new byte[16];
            this.lengths = new byte[16];
        }

        private StringBuilder appendFieldTo(int i, StringBuilder sb, boolean z) {
            char cI = (char) this.chars[i];
            byte b = this.lengths[i];
            if (z) {
                cI = DateTimePatternGenerator.i(cI, i);
            }
            for (int i2 = 0; i2 < b; i2++) {
                sb.append(cI);
            }
            return sb;
        }

        private StringBuilder appendTo(StringBuilder sb, boolean z, boolean z2) {
            for (int i = 0; i < 16; i++) {
                if (!z2 || i != 10) {
                    appendFieldTo(i, sb, z);
                }
            }
            return sb;
        }

        public void clear() {
            Arrays.fill(this.chars, (byte) 0);
            Arrays.fill(this.lengths, (byte) 0);
        }

        public void clearField(int i) {
            this.chars[i] = 0;
            this.lengths[i] = 0;
        }

        public int compareTo(SkeletonFields skeletonFields) {
            for (int i = 0; i < 16; i++) {
                int i2 = this.chars[i] - skeletonFields.chars[i];
                if (i2 != 0) {
                    return i2;
                }
                int i3 = this.lengths[i] - skeletonFields.lengths[i];
                if (i3 != 0) {
                    return i3;
                }
            }
            return 0;
        }

        public void copyFieldFrom(SkeletonFields skeletonFields, int i) {
            this.chars[i] = skeletonFields.chars[i];
            this.lengths[i] = skeletonFields.lengths[i];
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return obj != null && (obj instanceof SkeletonFields) && compareTo((SkeletonFields) obj) == 0;
            }
            return true;
        }

        public char getFieldChar(int i) {
            return (char) this.chars[i];
        }

        public int getFieldLength(int i) {
            return this.lengths[i];
        }

        public int hashCode() {
            return Arrays.hashCode(this.lengths) ^ Arrays.hashCode(this.chars);
        }

        public boolean isFieldEmpty(int i) {
            return this.lengths[i] == 0;
        }

        public void populate(int i, String str) {
            for (char c : str.toCharArray()) {
            }
            populate(i, str.charAt(0), str.length());
        }

        public String toCanonicalString() {
            return appendTo(new StringBuilder(), true, false).toString();
        }

        public String toString() {
            return appendTo(new StringBuilder(), false, false).toString();
        }

        public /* synthetic */ SkeletonFields(int i) {
            this();
        }

        public String toString(boolean z) {
            return appendTo(new StringBuilder(), false, z).toString();
        }

        public String toCanonicalString(boolean z) {
            return appendTo(new StringBuilder(), true, z).toString();
        }

        public StringBuilder appendTo(StringBuilder sb) {
            return appendTo(sb, false, false);
        }

        public StringBuilder appendFieldTo(int i, StringBuilder sb) {
            return appendFieldTo(i, sb, false);
        }

        public void populate(int i, char c, int i2) {
            this.chars[i] = (byte) c;
            this.lengths[i] = (byte) i2;
        }
    }

    @Deprecated
    public static int getAppendFormatNumber(String str) {
        int i = 0;
        while (true) {
            String[] strArr = CLDR_FIELD_APPEND;
            if (i >= strArr.length) {
                return -1;
            }
            if (strArr[i].equals(str)) {
                return i;
            }
            i++;
        }
    }

    public String getDateTimeFormat() {
        return getDateTimeFormat(2);
    }

    public void setDateTimeFormat(String str) {
        checkFrozen();
        for (int i = 0; i <= 3; i++) {
            setDateTimeFormat(i, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class VariableField {
        private final int canonicalIndex;
        private final String string;

        @Deprecated
        public VariableField(String str, boolean z) {
            int canonicalIndex = DateTimePatternGenerator.getCanonicalIndex(str, z);
            this.canonicalIndex = canonicalIndex;
            if (canonicalIndex >= 0) {
                this.string = str;
            } else {
                og.i(cq.j("Illegal datetime field:\t", str));
                throw null;
            }
        }

        @Deprecated
        public static String getCanonicalCode(int i) {
            try {
                return DateTimePatternGenerator.CANONICAL_ITEMS[i];
            } catch (Exception unused) {
                return String.valueOf(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getCanonicalIndex() {
            return this.canonicalIndex;
        }

        @Deprecated
        public int getType() {
            return DateTimePatternGenerator.types[this.canonicalIndex][1];
        }

        @Deprecated
        public boolean isNumeric() {
            return DateTimePatternGenerator.types[this.canonicalIndex][2] > 0;
        }

        @Deprecated
        public String toString() {
            return this.string;
        }

        @Deprecated
        public VariableField(String str) {
            this(str, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DateTimeMatcher implements Comparable<DateTimeMatcher> {
        private boolean addedDefaultDayPeriod;
        private SkeletonFields baseOriginal;
        private SkeletonFields original;
        private int[] type;

        private DateTimeMatcher() {
            this.type = new int[16];
            int i = 0;
            this.original = new SkeletonFields(i);
            this.baseOriginal = new SkeletonFields(i);
            this.addedDefaultDayPeriod = false;
        }

        @Override // java.lang.Comparable
        public int compareTo(DateTimeMatcher dateTimeMatcher) {
            int iCompareTo = this.original.compareTo(dateTimeMatcher.original);
            if (iCompareTo > 0) {
                return -1;
            }
            return iCompareTo < 0 ? 1 : 0;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return obj != null && (obj instanceof DateTimeMatcher) && this.original.equals(((DateTimeMatcher) obj).original);
            }
            return true;
        }

        public void extractFrom(DateTimeMatcher dateTimeMatcher, int i) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.type;
                if (i2 >= iArr.length) {
                    return;
                }
                if (((1 << i2) & i) != 0) {
                    iArr[i2] = dateTimeMatcher.type[i2];
                    this.original.copyFieldFrom(dateTimeMatcher.original, i2);
                } else {
                    iArr[i2] = 0;
                    this.original.clearField(i2);
                }
                i2++;
            }
        }

        public boolean fieldIsNumeric(int i) {
            return this.type[i] > 0;
        }

        public String getBasePattern() {
            return this.baseOriginal.toString(this.addedDefaultDayPeriod);
        }

        public int getDistance(DateTimeMatcher dateTimeMatcher, int i, DistanceInfo distanceInfo) {
            distanceInfo.clear();
            int iAbs = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                int i3 = ((1 << i2) & i) == 0 ? 0 : this.type[i2];
                int i4 = dateTimeMatcher.type[i2];
                if (i3 != i4) {
                    if (i3 == 0) {
                        iAbs += 65536;
                        distanceInfo.addExtra(i2);
                    } else if (i4 == 0) {
                        iAbs += 4096;
                        distanceInfo.addMissing(i2);
                    } else {
                        iAbs += Math.abs(i3 - i4);
                    }
                }
            }
            return iAbs;
        }

        public int getFieldMask() {
            int i = 0;
            int i2 = 0;
            while (true) {
                int[] iArr = this.type;
                if (i >= iArr.length) {
                    return i2;
                }
                if (iArr[i] != 0) {
                    i2 |= 1 << i;
                }
                i++;
            }
        }

        public int hashCode() {
            return this.original.hashCode();
        }

        public DateTimeMatcher set(String str, FormatParser formatParser, boolean z) {
            Arrays.fill(this.type, 0);
            this.original.clear();
            this.baseOriginal.clear();
            this.addedDefaultDayPeriod = false;
            formatParser.set(str);
            Iterator<Object> it = formatParser.getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!this.original.isFieldEmpty(12) && !this.original.isFieldEmpty(14) && this.original.isFieldEmpty(13)) {
                        for (int i = 0; i < DateTimePatternGenerator.types.length; i++) {
                            int[] iArr = DateTimePatternGenerator.types[i];
                            if (iArr[1] == 13) {
                                this.original.populate(13, (char) iArr[0], iArr[3]);
                                this.baseOriginal.populate(13, (char) iArr[0], iArr[3]);
                                int i2 = iArr[2];
                                int[] iArr2 = this.type;
                                if (i2 > 0) {
                                    i2++;
                                }
                                iArr2[13] = i2;
                                break;
                            }
                        }
                    }
                    if (!this.original.isFieldEmpty(11)) {
                        if (this.original.getFieldChar(11) == 'h' || this.original.getFieldChar(11) == 'K') {
                            if (this.original.isFieldEmpty(10)) {
                                for (int i3 = 0; i3 < DateTimePatternGenerator.types.length; i3++) {
                                    int[] iArr3 = DateTimePatternGenerator.types[i3];
                                    if (iArr3[1] == 10) {
                                        this.original.populate(10, (char) iArr3[0], iArr3[3]);
                                        this.baseOriginal.populate(10, (char) iArr3[0], iArr3[3]);
                                        this.type[10] = iArr3[2];
                                        this.addedDefaultDayPeriod = true;
                                        return this;
                                    }
                                }
                            }
                        } else if (!this.original.isFieldEmpty(10)) {
                            this.original.clearField(10);
                            this.baseOriginal.clearField(10);
                            this.type[10] = 0;
                            return this;
                        }
                    }
                    return this;
                }
                Object next = it.next();
                if (next instanceof VariableField) {
                    VariableField variableField = (VariableField) next;
                    String string = variableField.toString();
                    int[] iArr4 = DateTimePatternGenerator.types[variableField.getCanonicalIndex()];
                    int i4 = iArr4[1];
                    boolean zIsFieldEmpty = this.original.isFieldEmpty(i4);
                    SkeletonFields skeletonFields = this.original;
                    if (zIsFieldEmpty) {
                        skeletonFields.populate(i4, string);
                        char c = (char) iArr4[0];
                        this.baseOriginal.populate(i4, c, "GEzvQ".indexOf(c) < 0 ? iArr4[3] : 1);
                        int length = iArr4[2];
                        if (length > 0) {
                            length += string.length();
                        }
                        this.type[i4] = length;
                    } else {
                        char fieldChar = skeletonFields.getFieldChar(i4);
                        char cCharAt = string.charAt(0);
                        if (!z && (fieldChar != 'r' || (cCharAt != 'U' && cCharAt != 'y'))) {
                            if ((fieldChar != 'U' && fieldChar != 'y') || cCharAt != 'r') {
                                throw new IllegalArgumentException("Conflicting fields:\t" + fieldChar + ", " + string + "\t in " + str);
                            }
                        }
                    }
                }
            }
        }

        public String toCanonicalString() {
            return this.original.toCanonicalString(this.addedDefaultDayPeriod);
        }

        public String toString() {
            return this.original.toString(this.addedDefaultDayPeriod);
        }

        public /* synthetic */ DateTimeMatcher(int i) {
            this();
        }
    }

    public String replaceFieldTypes(String str, String str2) {
        return replaceFieldTypes(str, str2, 0);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class FormatParser {
        private static final UnicodeSet SYNTAX_CHARS = new UnicodeSet("[a-zA-Z]").freeze();
        private static final UnicodeSet QUOTING_CHARS = new UnicodeSet("[[[:script=Latn:][:script=Cyrl:]]&[[:L:][:M:]]]").freeze();
        private transient PatternTokenizer tokenizer = new PatternTokenizer().setSyntaxCharacters(SYNTAX_CHARS).setExtraQuotingCharacters(QUOTING_CHARS).setUsingQuote(true);
        private List<Object> items = new ArrayList();

        @Deprecated
        public FormatParser() {
        }

        private void addVariable(StringBuffer stringBuffer, boolean z) {
            if (stringBuffer.length() != 0) {
                this.items.add(new VariableField(stringBuffer.toString(), z));
                stringBuffer.setLength(0);
            }
        }

        @Deprecated
        public List<Object> getItems() {
            return this.items;
        }

        @Deprecated
        public boolean hasDateAndTimeFields() {
            int type = 0;
            for (Object obj : this.items) {
                if (obj instanceof VariableField) {
                    type |= 1 << ((VariableField) obj).getType();
                }
            }
            return ((type & 1023) != 0) && ((type & 64512) != 0);
        }

        @Deprecated
        public Object quoteLiteral(String str) {
            return this.tokenizer.quoteLiteral(str);
        }

        @Deprecated
        public FormatParser set(String str, boolean z) {
            this.items.clear();
            if (str.length() == 0) {
                return this;
            }
            this.tokenizer.setPattern(str);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            while (true) {
                stringBuffer.setLength(0);
                int next = this.tokenizer.next(stringBuffer);
                if (next == 0) {
                    addVariable(stringBuffer2, false);
                    return this;
                }
                if (next == 1) {
                    if (stringBuffer2.length() != 0 && stringBuffer.charAt(0) != stringBuffer2.charAt(0)) {
                        addVariable(stringBuffer2, false);
                    }
                    stringBuffer2.append(stringBuffer);
                } else {
                    addVariable(stringBuffer2, false);
                    this.items.add(stringBuffer.toString());
                }
            }
        }

        @Deprecated
        public String toString(int i, int i2) {
            StringBuilder sb = new StringBuilder();
            while (i < i2) {
                Object obj = this.items.get(i);
                if (obj instanceof String) {
                    sb.append(this.tokenizer.quoteLiteral((String) obj));
                } else {
                    sb.append(this.items.get(i).toString());
                }
                i++;
            }
            return sb.toString();
        }

        @Deprecated
        public String toString() {
            return toString(0, this.items.size());
        }

        @Deprecated
        public final FormatParser set(String str) {
            return set(str, false);
        }
    }

    public String getBestPattern(String str, int i) {
        return getBestPattern(str, null, i);
    }

    public String getBestPattern(String str) {
        return getBestPattern(str, null, 0);
    }
}
