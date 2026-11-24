package com.ibm.icu.text;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.ICUException;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class DateIntervalInfo implements Cloneable, Freezable<DateIntervalInfo>, Serializable {
    private static final int MINIMUM_SUPPORTED_CALENDAR_FIELD = 14;
    static final int currentSerialVersion = 1;
    private static final long serialVersionUID = 1;
    private String fFallbackIntervalPattern;
    private boolean fFirstDateInPtnIsLaterDate;
    private Map<String, Map<String, PatternInfo>> fIntervalPatterns;
    private transient boolean fIntervalPatternsReadOnly;
    private volatile transient boolean frozen;
    static final String[] CALENDAR_FIELD_TO_PATTERN_LETTER = {"G", DateFormat.YEAR, DateFormat.NUM_MONTH, "w", "W", DateFormat.DAY, "D", DateFormat.ABBR_WEEKDAY, "F", "a", "h", DateFormat.HOUR24, DateFormat.MINUTE, DateFormat.SECOND, "S", DateFormat.ABBR_SPECIFIC_TZ, Padder.FALLBACK_PADDING_STRING, "Y", "e", "u", "g", "A", Padder.FALLBACK_PADDING_STRING, Padder.FALLBACK_PADDING_STRING};
    private static String CALENDAR_KEY = "calendar";
    private static String INTERVAL_FORMATS_KEY = "intervalFormats";
    private static String FALLBACK_STRING = "fallback";
    private static String LATEST_FIRST_PREFIX = "latestFirst:";
    private static String EARLIEST_FIRST_PREFIX = "earliestFirst:";
    private static final ICUCache<String, DateIntervalInfo> DIICACHE = new SimpleCache();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DateIntervalSink extends UResource.Sink {
        private static final String ACCEPTED_PATTERN_LETTERS = "GyMdahHmsS";
        private static final String DATE_INTERVAL_PATH_PREFIX = cq.v("/LOCALE/", DateIntervalInfo.CALENDAR_KEY, "/");
        private static final String DATE_INTERVAL_PATH_SUFFIX = cq.j("/", DateIntervalInfo.INTERVAL_FORMATS_KEY);
        DateIntervalInfo dateIntervalInfo;
        String nextCalendarType;

        public DateIntervalSink(DateIntervalInfo dateIntervalInfo) {
            this.dateIntervalInfo = dateIntervalInfo;
        }

        private String getCalendarTypeFromPath(String str) {
            String str2 = DATE_INTERVAL_PATH_PREFIX;
            if (str.startsWith(str2)) {
                String str3 = DATE_INTERVAL_PATH_SUFFIX;
                if (str.endsWith(str3)) {
                    return str.substring(str2.length(), str.length() - str3.length());
                }
            }
            og.q("Malformed 'intervalFormat' alias path: ".concat(str));
            return null;
        }

        private void setIntervalPatternIfAbsent(String str, String str2, UResource.Value value) {
            Map map = (Map) this.dateIntervalInfo.fIntervalPatterns.get(str);
            if (map == null || !map.containsKey(str2)) {
                this.dateIntervalInfo.setIntervalPatternInternally(str, str2, value.toString());
            }
        }

        private CharSequence validateAndProcessPatternLetter(CharSequence charSequence) {
            if (charSequence.length() != 1) {
                return null;
            }
            char cCharAt = charSequence.charAt(0);
            if (ACCEPTED_PATTERN_LETTERS.indexOf(cCharAt) < 0 && cCharAt != 'B') {
                return null;
            }
            String[] strArr = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER;
            CharSequence charSequence2 = charSequence;
            if (cCharAt == strArr[11].charAt(0)) {
                charSequence2 = strArr[10];
            }
            return cCharAt == 'B' ? strArr[9] : charSequence2;
        }

        public String getAndResetNextCalendarType() {
            String str = this.nextCalendarType;
            this.nextCalendarType = null;
            return str;
        }

        public void processSkeletonTable(UResource.Key key, UResource.Value value) {
            CharSequence charSequenceValidateAndProcessPatternLetter;
            String string = key.toString();
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (value.getType() == 0 && (charSequenceValidateAndProcessPatternLetter = validateAndProcessPatternLetter(key)) != null) {
                    setIntervalPatternIfAbsent(string, charSequenceValidateAndProcessPatternLetter.toString(), value);
                }
            }
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (key.contentEquals(DateIntervalInfo.INTERVAL_FORMATS_KEY)) {
                    if (value.getType() == 3) {
                        this.nextCalendarType = getCalendarTypeFromPath(value.getAliasString());
                        return;
                    } else if (value.getType() == 2) {
                        UResource.Table table2 = value.getTable();
                        for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                            if (value.getType() == 2) {
                                processSkeletonTable(key, value);
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class PatternInfo implements Cloneable, Serializable {
        static final int currentSerialVersion = 1;
        private static final long serialVersionUID = 1;
        private final boolean fFirstDateInPtnIsLaterDate;
        private final String fIntervalPatternFirstPart;
        private final String fIntervalPatternSecondPart;

        public PatternInfo(String str, String str2, boolean z) {
            this.fIntervalPatternFirstPart = str;
            this.fIntervalPatternSecondPart = str2;
            this.fFirstDateInPtnIsLaterDate = z;
        }

        public boolean equals(Object obj) {
            if (obj instanceof PatternInfo) {
                PatternInfo patternInfo = (PatternInfo) obj;
                if (Objects.equals(this.fIntervalPatternFirstPart, patternInfo.fIntervalPatternFirstPart) && Objects.equals(this.fIntervalPatternSecondPart, patternInfo.fIntervalPatternSecondPart) && this.fFirstDateInPtnIsLaterDate == patternInfo.fFirstDateInPtnIsLaterDate) {
                    return true;
                }
            }
            return false;
        }

        public boolean firstDateInPtnIsLaterDate() {
            return this.fFirstDateInPtnIsLaterDate;
        }

        public String getFirstPart() {
            return this.fIntervalPatternFirstPart;
        }

        public String getSecondPart() {
            return this.fIntervalPatternSecondPart;
        }

        public int hashCode() {
            String str = this.fIntervalPatternFirstPart;
            int iHashCode = str != null ? str.hashCode() : 0;
            String str2 = this.fIntervalPatternSecondPart;
            if (str2 != null) {
                iHashCode ^= str2.hashCode();
            }
            return this.fFirstDateInPtnIsLaterDate ? ~iHashCode : iHashCode;
        }

        public String toString() {
            String str = this.fIntervalPatternFirstPart;
            String str2 = this.fIntervalPatternSecondPart;
            return ky0.o(cq.q("{first=«", str, "», second=«", str2, "», reversed:"), this.fFirstDateInPtnIsLaterDate, "}");
        }
    }

    @Deprecated
    public DateIntervalInfo() {
        this.fFirstDateInPtnIsLaterDate = false;
        this.fIntervalPatterns = null;
        this.frozen = false;
        this.fIntervalPatternsReadOnly = false;
        this.fIntervalPatterns = new HashMap();
        this.fFallbackIntervalPattern = "{0} – {1}";
    }

    private static Map<String, Map<String, PatternInfo>> cloneIntervalPatterns(Map<String, Map<String, PatternInfo>> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Map<String, PatternInfo>> entry : map.entrySet()) {
            String key = entry.getKey();
            Map<String, PatternInfo> value = entry.getValue();
            HashMap map3 = new HashMap();
            for (Map.Entry<String, PatternInfo> entry2 : value.entrySet()) {
                map3.put(entry2.getKey(), entry2.getValue());
            }
            map2.put(key, map3);
        }
        return map2;
    }

    private DateIntervalInfo cloneUnfrozenDII() {
        try {
            DateIntervalInfo dateIntervalInfo = (DateIntervalInfo) super.clone();
            dateIntervalInfo.fFallbackIntervalPattern = this.fFallbackIntervalPattern;
            dateIntervalInfo.fFirstDateInPtnIsLaterDate = this.fFirstDateInPtnIsLaterDate;
            boolean z = this.fIntervalPatternsReadOnly;
            Map<String, Map<String, PatternInfo>> map = this.fIntervalPatterns;
            if (z) {
                dateIntervalInfo.fIntervalPatterns = map;
                dateIntervalInfo.fIntervalPatternsReadOnly = true;
            } else {
                dateIntervalInfo.fIntervalPatterns = cloneIntervalPatterns(map);
                dateIntervalInfo.fIntervalPatternsReadOnly = false;
            }
            dateIntervalInfo.frozen = false;
            return dateIntervalInfo;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException("clone is not supported", e);
        }
    }

    @Deprecated
    public static PatternInfo genPatternInfo(String str, boolean z) {
        int iSplitPatternInto2Part = splitPatternInto2Part(str);
        return new PatternInfo(str.substring(0, iSplitPatternInto2Part), iSplitPatternInto2Part < str.length() ? str.substring(iSplitPatternInto2Part, str.length()) : null, z);
    }

    private void initializeData(ULocale uLocale) {
        String string = uLocale.toString();
        ICUCache<String, DateIntervalInfo> iCUCache = DIICACHE;
        DateIntervalInfo dateIntervalInfo = iCUCache.get(string);
        if (dateIntervalInfo != null) {
            initializeFromReadOnlyPatterns(dateIntervalInfo);
            return;
        }
        setup(uLocale);
        this.fIntervalPatternsReadOnly = true;
        iCUCache.put(string, m15clone().freeze());
    }

    private void initializeFromReadOnlyPatterns(DateIntervalInfo dateIntervalInfo) {
        this.fFallbackIntervalPattern = dateIntervalInfo.fFallbackIntervalPattern;
        this.fFirstDateInPtnIsLaterDate = dateIntervalInfo.fFirstDateInPtnIsLaterDate;
        this.fIntervalPatterns = dateIntervalInfo.fIntervalPatterns;
        this.fIntervalPatternsReadOnly = true;
    }

    public static void parseSkeleton(String str, int[] iArr) {
        for (int i = 0; i < str.length(); i++) {
            int iCharAt = str.charAt(i) - 'A';
            iArr[iCharAt] = iArr[iCharAt] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PatternInfo setIntervalPatternInternally(String str, String str2, String str3) {
        boolean z;
        Map<String, PatternInfo> map = this.fIntervalPatterns.get(str);
        boolean z2 = false;
        if (map == null) {
            map = new HashMap<>();
            z = true;
        } else {
            z = false;
        }
        boolean z3 = this.fFirstDateInPtnIsLaterDate;
        if (str3.startsWith(LATEST_FIRST_PREFIX)) {
            str3 = str3.substring(LATEST_FIRST_PREFIX.length(), str3.length());
            z2 = true;
        } else if (str3.startsWith(EARLIEST_FIRST_PREFIX)) {
            str3 = str3.substring(EARLIEST_FIRST_PREFIX.length(), str3.length());
        } else {
            z2 = z3;
        }
        PatternInfo patternInfoGenPatternInfo = genPatternInfo(str3, z2);
        map.put(str2, patternInfoGenPatternInfo);
        if (z) {
            this.fIntervalPatterns.put(str, map);
        }
        return patternInfoGenPatternInfo;
    }

    private void setup(ULocale uLocale) {
        this.fIntervalPatterns = new HashMap(19);
        this.fFallbackIntervalPattern = "{0} – {1}";
        try {
            String keywordValue = uLocale.getKeywordValue("calendar");
            if (keywordValue == null) {
                keywordValue = Calendar.getKeywordValuesForLocale("calendar", uLocale, true)[0];
            }
            if (keywordValue == null) {
                keywordValue = "gregorian";
            }
            DateIntervalSink dateIntervalSink = new DateIntervalSink(this);
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
            setFallbackIntervalPattern(iCUResourceBundle.getStringWithFallback(CALENDAR_KEY + "/" + keywordValue + "/" + INTERVAL_FORMATS_KEY + "/" + FALLBACK_STRING));
            HashSet hashSet = new HashSet();
            while (keywordValue != null) {
                if (hashSet.contains(keywordValue)) {
                    throw new ICUException("Loop in calendar type fallback: " + keywordValue);
                }
                hashSet.add(keywordValue);
                iCUResourceBundle.getAllItemsWithFallback(CALENDAR_KEY + "/" + keywordValue, dateIntervalSink);
                keywordValue = dateIntervalSink.getAndResetNextCalendarType();
            }
        } catch (MissingResourceException unused) {
        }
    }

    private static int splitPatternInto2Part(String str) {
        boolean z;
        int[] iArr = new int[58];
        int i = 0;
        char c = 0;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i >= str.length()) {
                z = false;
                break;
            }
            char cCharAt = str.charAt(i);
            z = true;
            if (cCharAt != c && i2 > 0) {
                int i3 = c - 'A';
                if (iArr[i3] != 0) {
                    break;
                }
                iArr[i3] = 1;
                i2 = 0;
            }
            if (cCharAt == '\'') {
                int i4 = i + 1;
                if (i4 >= str.length() || str.charAt(i4) != '\'') {
                    z2 = !z2;
                } else {
                    i = i4;
                }
            } else if (!z2 && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                i2++;
                c = cCharAt;
            }
            i++;
        }
        return i - ((i2 <= 0 || z || iArr[c - 'A'] != 0) ? i2 : 0);
    }

    private static boolean stringNumeric(int i, int i2, char c) {
        if (c != 'M') {
            return false;
        }
        if (i > 2 || i2 <= 2) {
            return i > 2 && i2 <= 2;
        }
        return true;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DateIntervalInfo m15clone() {
        return this.frozen ? this : cloneUnfrozenDII();
    }

    public boolean equals(Object obj) {
        if (obj instanceof DateIntervalInfo) {
            return this.fIntervalPatterns.equals(((DateIntervalInfo) obj).fIntervalPatterns);
        }
        return false;
    }

    @Override // com.ibm.icu.util.Freezable
    public DateIntervalInfo freeze() {
        this.fIntervalPatternsReadOnly = true;
        this.frozen = true;
        return this;
    }

    public DateIntervalFormat.BestMatchInfo getBestSkeleton(String str) {
        String strReplace;
        boolean z;
        String str2 = str;
        int i = 58;
        int[] iArr = new int[58];
        int[] iArr2 = new int[58];
        int i2 = 0;
        if (str2.indexOf(122) == -1 && str2.indexOf(107) == -1 && str2.indexOf(75) == -1 && str2.indexOf(97) == -1 && str2.indexOf(98) == -1) {
            strReplace = str2;
            z = false;
        } else {
            strReplace = str2.replace('z', 'v').replace('k', 'H').replace('K', 'h').replace("a", "").replace("b", "");
            z = true;
        }
        parseSkeleton(strReplace, iArr);
        Iterator<String> it = this.fIntervalPatterns.keySet().iterator();
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = i4;
                break;
            }
            String next = it.next();
            for (int i5 = 0; i5 < i; i5++) {
                iArr2[i5] = 0;
            }
            parseSkeleton(next, iArr2);
            int i6 = 0;
            int iAbs = 0;
            int i7 = 1;
            while (i6 < i) {
                int i8 = iArr[i6];
                int i9 = iArr2[i6];
                if (i8 != i9) {
                    if (i8 == 0 || i9 == 0) {
                        iAbs += 4096;
                        i7 = -1;
                    } else {
                        iAbs = stringNumeric(i8, i9, (char) (i6 + 65)) ? iAbs + 256 : iAbs + Math.abs(i8 - i9);
                    }
                }
                i6++;
                i = 58;
            }
            if (iAbs < i3) {
                str2 = next;
                i3 = iAbs;
                i4 = i7;
            }
            if (iAbs == 0) {
                break;
            }
            i = 58;
        }
        if (z && i2 != -1) {
            i2 = 2;
        }
        return new DateIntervalFormat.BestMatchInfo(str2, i2);
    }

    public boolean getDefaultOrder() {
        return this.fFirstDateInPtnIsLaterDate;
    }

    public String getFallbackIntervalPattern() {
        return this.fFallbackIntervalPattern;
    }

    public PatternInfo getIntervalPattern(String str, int i) {
        PatternInfo patternInfo;
        if (i > 14) {
            og.i("no support for field less than MILLISECOND");
            return null;
        }
        Map<String, PatternInfo> map = this.fIntervalPatterns.get(str);
        if (map == null || (patternInfo = map.get(CALENDAR_FIELD_TO_PATTERN_LETTER[i])) == null) {
            return null;
        }
        return patternInfo;
    }

    @Deprecated
    public Map<String, Set<String>> getPatterns() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Map<String, PatternInfo>> entry : this.fIntervalPatterns.entrySet()) {
            linkedHashMap.put(entry.getKey(), new LinkedHashSet(entry.getValue().keySet()));
        }
        return linkedHashMap;
    }

    @Deprecated
    public Map<String, Map<String, PatternInfo>> getRawPatterns() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Map<String, PatternInfo>> entry : this.fIntervalPatterns.entrySet()) {
            linkedHashMap.put(entry.getKey(), new LinkedHashMap(entry.getValue()));
        }
        return linkedHashMap;
    }

    public int hashCode() {
        return this.fIntervalPatterns.hashCode();
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.frozen;
    }

    public void setFallbackIntervalPattern(String str) {
        if (this.frozen) {
            dk0.r("no modification is allowed after DII is frozen");
            return;
        }
        int iIndexOf = str.indexOf("{0}");
        int iIndexOf2 = str.indexOf("{1}");
        if (iIndexOf == -1 || iIndexOf2 == -1) {
            og.i("no pattern {0} or pattern {1} in fallbackPattern");
            return;
        }
        if (iIndexOf > iIndexOf2) {
            this.fFirstDateInPtnIsLaterDate = true;
        }
        this.fFallbackIntervalPattern = str;
    }

    public void setIntervalPattern(String str, int i, String str2) {
        if (this.frozen) {
            dk0.r("no modification is allowed after DII is frozen");
            return;
        }
        if (i > 14) {
            og.i("calendar field is larger than MINIMUM_SUPPORTED_CALENDAR_FIELD");
            return;
        }
        if (this.fIntervalPatternsReadOnly) {
            this.fIntervalPatterns = cloneIntervalPatterns(this.fIntervalPatterns);
            this.fIntervalPatternsReadOnly = false;
        }
        String[] strArr = CALENDAR_FIELD_TO_PATTERN_LETTER;
        PatternInfo intervalPatternInternally = setIntervalPatternInternally(str, strArr[i], str2);
        if (i == 11) {
            setIntervalPattern(str, strArr[9], intervalPatternInternally);
            setIntervalPattern(str, strArr[10], intervalPatternInternally);
        } else if (i == 5 || i == 7) {
            setIntervalPattern(str, strArr[5], intervalPatternInternally);
        }
    }

    @Override // com.ibm.icu.util.Freezable
    public DateIntervalInfo cloneAsThawed() {
        return cloneUnfrozenDII();
    }

    public DateIntervalInfo(ULocale uLocale) {
        this.fFirstDateInPtnIsLaterDate = false;
        this.fIntervalPatterns = null;
        this.frozen = false;
        this.fIntervalPatternsReadOnly = false;
        initializeData(uLocale);
    }

    public DateIntervalInfo(Locale locale) {
        this(ULocale.forLocale(locale));
    }

    private void setIntervalPattern(String str, String str2, PatternInfo patternInfo) {
        this.fIntervalPatterns.get(str).put(str2, patternInfo);
    }
}
