package com.ibm.icu.impl;

import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.text.LocaleDisplayNames;
import com.ibm.icu.text.TimeZoneFormat;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.BasicTimeZone;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.TimeZoneTransition;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.dk0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.MissingResourceException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TimeZoneGenericNames implements Serializable, Freezable<TimeZoneGenericNames> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long DST_CHECK_RANGE = 15897600000L;
    private static Cache GENERIC_NAMES_CACHE = new Cache(0);
    private static final TimeZoneNames.NameType[] GENERIC_NON_LOCATION_TYPES = {TimeZoneNames.NameType.LONG_GENERIC, TimeZoneNames.NameType.SHORT_GENERIC};
    private static final long serialVersionUID = 2729910342063468417L;
    private volatile transient boolean _frozen;
    private transient ConcurrentHashMap<String, String> _genericLocationNamesMap;
    private transient ConcurrentHashMap<String, String> _genericPartialLocationNamesMap;
    private transient TextTrieMap<NameInfo> _gnamesTrie;
    private transient boolean _gnamesTrieFullyLoaded;
    private final ULocale _locale;
    private transient WeakReference<LocaleDisplayNames> _localeDisplayNamesRef;
    private transient MessageFormat[] _patternFormatters;
    private transient String _region;
    private TimeZoneNames _tznames;

    /* JADX INFO: renamed from: com.ibm.icu.impl.TimeZoneGenericNames$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$TimeZoneGenericNames$GenericNameType;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType;

        static {
            int[] iArr = new int[TimeZoneNames.NameType.values().length];
            $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType = iArr;
            try {
                iArr[TimeZoneNames.NameType.LONG_STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.LONG_GENERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_STANDARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_GENERIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[GenericNameType.values().length];
            $SwitchMap$com$ibm$icu$impl$TimeZoneGenericNames$GenericNameType = iArr2;
            try {
                iArr2[GenericNameType.LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$TimeZoneGenericNames$GenericNameType[GenericNameType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$TimeZoneGenericNames$GenericNameType[GenericNameType.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class GenericNameSearchHandler implements TextTrieMap.ResultHandler<NameInfo> {
        private Collection<GenericMatchInfo> _matches;
        private int _maxMatchLen;
        private EnumSet<GenericNameType> _types;

        public GenericNameSearchHandler(EnumSet<GenericNameType> enumSet) {
            this._types = enumSet;
        }

        public Collection<GenericMatchInfo> getMatches() {
            return this._matches;
        }

        public int getMaxMatchLen() {
            return this._maxMatchLen;
        }

        @Override // com.ibm.icu.impl.TextTrieMap.ResultHandler
        public boolean handlePrefixMatch(int i, Iterator<NameInfo> it) {
            while (it.hasNext()) {
                NameInfo next = it.next();
                EnumSet<GenericNameType> enumSet = this._types;
                if (enumSet == null || enumSet.contains(next.type)) {
                    GenericMatchInfo genericMatchInfo = new GenericMatchInfo(next.type, next.tzID, i, 0);
                    if (this._matches == null) {
                        this._matches = new LinkedList();
                    }
                    this._matches.add(genericMatchInfo);
                    if (i > this._maxMatchLen) {
                        this._maxMatchLen = i;
                    }
                }
            }
            return true;
        }

        public void resetResults() {
            this._matches = null;
            this._maxMatchLen = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum GenericNameType {
        LOCATION("LONG", "SHORT"),
        LONG(new String[0]),
        SHORT(new String[0]);

        String[] _fallbackTypeOf;

        GenericNameType(String... strArr) {
            this._fallbackTypeOf = strArr;
        }

        public boolean isFallbackTypeOf(GenericNameType genericNameType) {
            String string = genericNameType.toString();
            for (String str : this._fallbackTypeOf) {
                if (str.equals(string)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NameInfo {
        final GenericNameType type;
        final String tzID;

        public NameInfo(String str, GenericNameType genericNameType) {
            this.tzID = str;
            this.type = genericNameType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Pattern {
        REGION_FORMAT("regionFormat", "({0})"),
        FALLBACK_FORMAT("fallbackFormat", "{1} ({0})");

        String _defaultVal;
        String _key;

        Pattern(String str, String str2) {
            this._key = str;
            this._defaultVal = str2;
        }

        public String defaultValue() {
            return this._defaultVal;
        }

        public String key() {
            return this._key;
        }
    }

    public TimeZoneGenericNames(ULocale uLocale, TimeZoneNames timeZoneNames) {
        this._locale = uLocale;
        this._tznames = timeZoneNames;
        init();
    }

    private GenericMatchInfo createGenericMatchInfo(TimeZoneNames.MatchInfo matchInfo) {
        GenericNameType genericNameType;
        TimeZoneFormat.TimeType timeType = TimeZoneFormat.TimeType.UNKNOWN;
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[matchInfo.nameType().ordinal()];
        if (i == 1) {
            genericNameType = GenericNameType.LONG;
            timeType = TimeZoneFormat.TimeType.STANDARD;
        } else if (i == 2) {
            genericNameType = GenericNameType.LONG;
        } else if (i == 3) {
            genericNameType = GenericNameType.SHORT;
            timeType = TimeZoneFormat.TimeType.STANDARD;
        } else {
            if (i != 4) {
                og.i("Unexpected MatchInfo name type - ".concat(String.valueOf(matchInfo.nameType())));
                return null;
            }
            genericNameType = GenericNameType.SHORT;
        }
        TimeZoneFormat.TimeType timeType2 = timeType;
        GenericNameType genericNameType2 = genericNameType;
        String strTzID = matchInfo.tzID();
        if (strTzID == null) {
            strTzID = this._tznames.getReferenceZoneID(matchInfo.mzID(), getTargetRegion());
        }
        return new GenericMatchInfo(genericNameType2, strTzID, matchInfo.matchLength(), timeType2, 0);
    }

    private synchronized Collection<GenericMatchInfo> findLocal(String str, int i, EnumSet<GenericNameType> enumSet) {
        try {
            GenericNameSearchHandler genericNameSearchHandler = new GenericNameSearchHandler(enumSet);
            this._gnamesTrie.find(str, i, genericNameSearchHandler);
            if (genericNameSearchHandler.getMaxMatchLen() != str.length() - i && !this._gnamesTrieFullyLoaded) {
                Iterator<String> it = TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL, null, null).iterator();
                while (it.hasNext()) {
                    loadStrings(it.next());
                }
                this._gnamesTrieFullyLoaded = true;
                genericNameSearchHandler.resetResults();
                this._gnamesTrie.find(str, i, genericNameSearchHandler);
                return genericNameSearchHandler.getMatches();
            }
            return genericNameSearchHandler.getMatches();
        } catch (Throwable th) {
            throw th;
        }
    }

    private Collection<TimeZoneNames.MatchInfo> findTimeZoneNames(String str, int i, EnumSet<GenericNameType> enumSet) {
        EnumSet<TimeZoneNames.NameType> enumSetNoneOf = EnumSet.noneOf(TimeZoneNames.NameType.class);
        if (enumSet.contains(GenericNameType.LONG)) {
            enumSetNoneOf.add(TimeZoneNames.NameType.LONG_GENERIC);
            enumSetNoneOf.add(TimeZoneNames.NameType.LONG_STANDARD);
        }
        if (enumSet.contains(GenericNameType.SHORT)) {
            enumSetNoneOf.add(TimeZoneNames.NameType.SHORT_GENERIC);
            enumSetNoneOf.add(TimeZoneNames.NameType.SHORT_STANDARD);
        }
        if (enumSetNoneOf.isEmpty()) {
            return null;
        }
        return this._tznames.find(str, i, enumSetNoneOf);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0093  */
    /* JADX WARN: Code duplicated, block: B:41:0x0096  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ad  */
    private String formatGenericNonLocationName(TimeZone timeZone, GenericNameType genericNameType, long j) {
        String metaZoneID;
        String metaZoneDisplayName;
        TimeZoneNames.NameType nameType;
        String displayName;
        TimeZoneTransition nextTransition;
        String canonicalCLDRID = ZoneMeta.getCanonicalCLDRID(timeZone);
        String str = null;
        if (canonicalCLDRID == null) {
            return null;
        }
        TimeZoneNames.NameType nameType2 = genericNameType == GenericNameType.LONG ? TimeZoneNames.NameType.LONG_GENERIC : TimeZoneNames.NameType.SHORT_GENERIC;
        String timeZoneDisplayName = this._tznames.getTimeZoneDisplayName(canonicalCLDRID, nameType2);
        if (timeZoneDisplayName != null || (metaZoneID = this._tznames.getMetaZoneID(canonicalCLDRID, j)) == null) {
            return timeZoneDisplayName;
        }
        int[] iArr = {0, 0};
        timeZone.getOffset(j, false, iArr);
        if (iArr[1] != 0) {
            str = timeZoneDisplayName;
        } else {
            if (timeZone instanceof BasicTimeZone) {
                BasicTimeZone basicTimeZone = (BasicTimeZone) timeZone;
                TimeZoneTransition previousTransition = basicTimeZone.getPreviousTransition(j, true);
                if ((previousTransition == null || j - previousTransition.getTime() >= DST_CHECK_RANGE || previousTransition.getFrom().getDSTSavings() == 0) && ((nextTransition = basicTimeZone.getNextTransition(j, false)) == null || nextTransition.getTime() - j >= DST_CHECK_RANGE || nextTransition.getTo().getDSTSavings() == 0)) {
                    if (nameType2 == TimeZoneNames.NameType.LONG_GENERIC) {
                        nameType = TimeZoneNames.NameType.LONG_STANDARD;
                    } else {
                        nameType = TimeZoneNames.NameType.SHORT_STANDARD;
                    }
                    displayName = this._tznames.getDisplayName(canonicalCLDRID, nameType, j);
                    if (displayName != null) {
                        if (!displayName.equalsIgnoreCase(this._tznames.getMetaZoneDisplayName(metaZoneID, nameType2))) {
                            str = displayName;
                        }
                    }
                }
            } else {
                int[] iArr2 = new int[2];
                timeZone.getOffset(j - DST_CHECK_RANGE, false, iArr2);
                if (iArr2[1] == 0) {
                    timeZone.getOffset(j + DST_CHECK_RANGE, false, iArr2);
                    if (iArr2[1] == 0) {
                        if (nameType2 == TimeZoneNames.NameType.LONG_GENERIC) {
                            nameType = TimeZoneNames.NameType.LONG_STANDARD;
                        } else {
                            nameType = TimeZoneNames.NameType.SHORT_STANDARD;
                        }
                        displayName = this._tznames.getDisplayName(canonicalCLDRID, nameType, j);
                        if (displayName != null) {
                            if (!displayName.equalsIgnoreCase(this._tznames.getMetaZoneDisplayName(metaZoneID, nameType2))) {
                                str = displayName;
                            }
                        }
                    }
                }
            }
            str = timeZoneDisplayName;
        }
        if (str != null || (metaZoneDisplayName = this._tznames.getMetaZoneDisplayName(metaZoneID, nameType2)) == null) {
            return str;
        }
        String referenceZoneID = this._tznames.getReferenceZoneID(metaZoneID, getTargetRegion());
        if (referenceZoneID != null && !referenceZoneID.equals(canonicalCLDRID)) {
            int[] iArr3 = {0, 0};
            TimeZone.getFrozenTimeZone(referenceZoneID).getOffset(j + ((long) iArr[0]) + ((long) iArr[1]), true, iArr3);
            if (iArr[0] != iArr3[0] || iArr[1] != iArr3[1]) {
                return getPartialLocationName(canonicalCLDRID, metaZoneID, nameType2 == TimeZoneNames.NameType.LONG_GENERIC, metaZoneDisplayName);
            }
        }
        return metaZoneDisplayName;
    }

    private synchronized String formatPattern(Pattern pattern, String... strArr) {
        int iOrdinal;
        String strDefaultValue;
        try {
            if (this._patternFormatters == null) {
                this._patternFormatters = new MessageFormat[Pattern.values().length];
            }
            iOrdinal = pattern.ordinal();
            if (this._patternFormatters[iOrdinal] == null) {
                try {
                    strDefaultValue = ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_ZONE_BASE_NAME, this._locale)).getStringWithFallback("zoneStrings/" + pattern.key());
                } catch (MissingResourceException unused) {
                    strDefaultValue = pattern.defaultValue();
                }
                this._patternFormatters[iOrdinal] = new MessageFormat(strDefaultValue);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this._patternFormatters[iOrdinal].format(strArr);
    }

    public static TimeZoneGenericNames getInstance(ULocale uLocale) {
        return GENERIC_NAMES_CACHE.getInstance(uLocale.getBaseName(), uLocale);
    }

    private synchronized LocaleDisplayNames getLocaleDisplayNames() {
        LocaleDisplayNames localeDisplayNames;
        try {
            WeakReference<LocaleDisplayNames> weakReference = this._localeDisplayNamesRef;
            localeDisplayNames = weakReference != null ? weakReference.get() : null;
            if (localeDisplayNames == null) {
                localeDisplayNames = LocaleDisplayNames.getInstance(this._locale);
                this._localeDisplayNamesRef = new WeakReference<>(localeDisplayNames);
            }
        } catch (Throwable th) {
            throw th;
        }
        return localeDisplayNames;
    }

    private String getPartialLocationName(String str, String str2, boolean z, String str3) {
        String exemplarLocationName;
        String str4 = str + "&" + str2 + "#" + (z ? "L" : "S");
        String str5 = this._genericPartialLocationNamesMap.get(str4);
        if (str5 != null) {
            return str5;
        }
        String canonicalCountry = ZoneMeta.getCanonicalCountry(str);
        TimeZoneNames timeZoneNames = this._tznames;
        if (canonicalCountry != null) {
            exemplarLocationName = str.equals(timeZoneNames.getReferenceZoneID(str2, canonicalCountry)) ? getLocaleDisplayNames().regionDisplayName(canonicalCountry) : this._tznames.getExemplarLocationName(str);
        } else {
            exemplarLocationName = timeZoneNames.getExemplarLocationName(str);
            if (exemplarLocationName == null) {
                exemplarLocationName = str;
            }
        }
        String pattern = formatPattern(Pattern.FALLBACK_FORMAT, exemplarLocationName, str3);
        synchronized (this) {
            try {
                String strPutIfAbsent = this._genericPartialLocationNamesMap.putIfAbsent(str4.intern(), pattern.intern());
                if (strPutIfAbsent == null) {
                    this._gnamesTrie.put(pattern, new NameInfo(str.intern(), z ? GenericNameType.LONG : GenericNameType.SHORT));
                } else {
                    pattern = strPutIfAbsent;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pattern;
    }

    private synchronized String getTargetRegion() {
        try {
            if (this._region == null) {
                String country = this._locale.getCountry();
                this._region = country;
                if (country.length() == 0) {
                    String country2 = ULocale.addLikelySubtags(this._locale).getCountry();
                    this._region = country2;
                    if (country2.length() == 0) {
                        this._region = UnitsData.Constants.DEFAULT_REGION;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this._region;
    }

    private void init() {
        if (this._tznames == null) {
            this._tznames = TimeZoneNames.getInstance(this._locale);
        }
        this._genericLocationNamesMap = new ConcurrentHashMap<>();
        this._genericPartialLocationNamesMap = new ConcurrentHashMap<>();
        this._gnamesTrie = new TextTrieMap<>(true);
        this._gnamesTrieFullyLoaded = false;
        String canonicalCLDRID = ZoneMeta.getCanonicalCLDRID(TimeZone.getDefault());
        if (canonicalCLDRID != null) {
            loadStrings(canonicalCLDRID);
        }
    }

    private synchronized void loadStrings(String str) {
        if (str != null) {
            if (str.length() != 0) {
                getGenericLocationName(str);
                for (String str2 : this._tznames.getAvailableMetaZoneIDs(str)) {
                    if (!str.equals(this._tznames.getReferenceZoneID(str2, getTargetRegion()))) {
                        TimeZoneNames.NameType[] nameTypeArr = GENERIC_NON_LOCATION_TYPES;
                        int length = nameTypeArr.length;
                        for (int i = 0; i < length; i++) {
                            TimeZoneNames.NameType nameType = nameTypeArr[i];
                            String metaZoneDisplayName = this._tznames.getMetaZoneDisplayName(str2, nameType);
                            if (metaZoneDisplayName != null) {
                                getPartialLocationName(str, str2, nameType == TimeZoneNames.NameType.LONG_GENERIC, metaZoneDisplayName);
                            }
                        }
                    }
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init();
    }

    @Override // com.ibm.icu.util.Freezable
    public TimeZoneGenericNames cloneAsThawed() {
        try {
            TimeZoneGenericNames timeZoneGenericNames = (TimeZoneGenericNames) super.clone();
            try {
                timeZoneGenericNames._frozen = false;
                return timeZoneGenericNames;
            } catch (Throwable unused) {
                return timeZoneGenericNames;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public Collection<GenericMatchInfo> find(String str, int i, EnumSet<GenericNameType> enumSet) {
        if (str == null || str.length() == 0 || i < 0 || i >= str.length()) {
            og.i("bad input text or range");
            return null;
        }
        Collection<GenericMatchInfo> collectionFindLocal = findLocal(str, i, enumSet);
        Collection<TimeZoneNames.MatchInfo> collectionFindTimeZoneNames = findTimeZoneNames(str, i, enumSet);
        if (collectionFindTimeZoneNames != null) {
            for (TimeZoneNames.MatchInfo matchInfo : collectionFindTimeZoneNames) {
                if (collectionFindLocal == null) {
                    collectionFindLocal = new LinkedList();
                }
                collectionFindLocal.add(createGenericMatchInfo(matchInfo));
            }
        }
        return collectionFindLocal;
    }

    public GenericMatchInfo findBestMatch(String str, int i, EnumSet<GenericNameType> enumSet) {
        GenericMatchInfo genericMatchInfoCreateGenericMatchInfo = null;
        if (str == null || str.length() == 0 || i < 0 || i >= str.length()) {
            og.i("bad input text or range");
            return null;
        }
        Collection<TimeZoneNames.MatchInfo> collectionFindTimeZoneNames = findTimeZoneNames(str, i, enumSet);
        if (collectionFindTimeZoneNames != null) {
            TimeZoneNames.MatchInfo matchInfo = null;
            for (TimeZoneNames.MatchInfo matchInfo2 : collectionFindTimeZoneNames) {
                if (matchInfo == null || matchInfo2.matchLength() > matchInfo.matchLength()) {
                    matchInfo = matchInfo2;
                }
            }
            if (matchInfo != null) {
                genericMatchInfoCreateGenericMatchInfo = createGenericMatchInfo(matchInfo);
                if (genericMatchInfoCreateGenericMatchInfo.matchLength() == str.length() - i && genericMatchInfoCreateGenericMatchInfo.timeType != TimeZoneFormat.TimeType.STANDARD) {
                    return genericMatchInfoCreateGenericMatchInfo;
                }
            }
        }
        Collection<GenericMatchInfo> collectionFindLocal = findLocal(str, i, enumSet);
        if (collectionFindLocal != null) {
            for (GenericMatchInfo genericMatchInfo : collectionFindLocal) {
                if (genericMatchInfoCreateGenericMatchInfo == null || genericMatchInfo.matchLength() >= genericMatchInfoCreateGenericMatchInfo.matchLength()) {
                    genericMatchInfoCreateGenericMatchInfo = genericMatchInfo;
                }
            }
        }
        return genericMatchInfoCreateGenericMatchInfo;
    }

    public String getDisplayName(TimeZone timeZone, GenericNameType genericNameType, long j) {
        String canonicalCLDRID;
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$TimeZoneGenericNames$GenericNameType[genericNameType.ordinal()];
        if (i == 1) {
            String canonicalCLDRID2 = ZoneMeta.getCanonicalCLDRID(timeZone);
            if (canonicalCLDRID2 != null) {
                return getGenericLocationName(canonicalCLDRID2);
            }
            return null;
        }
        if (i != 2 && i != 3) {
            return null;
        }
        String genericNonLocationName = formatGenericNonLocationName(timeZone, genericNameType, j);
        return (genericNonLocationName != null || (canonicalCLDRID = ZoneMeta.getCanonicalCLDRID(timeZone)) == null) ? genericNonLocationName : getGenericLocationName(canonicalCLDRID);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getGenericLocationName(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String pattern = this._genericLocationNamesMap.get(str);
        if (pattern != null) {
            if (pattern.length() == 0) {
                return null;
            }
            return pattern;
        }
        Output output = new Output();
        String canonicalCountry = ZoneMeta.getCanonicalCountry(str, output);
        if (canonicalCountry != null) {
            if (((Boolean) output.value).booleanValue()) {
                pattern = formatPattern(Pattern.REGION_FORMAT, getLocaleDisplayNames().regionDisplayName(canonicalCountry));
            } else {
                pattern = formatPattern(Pattern.REGION_FORMAT, this._tznames.getExemplarLocationName(str));
            }
        }
        if (pattern == null) {
            this._genericLocationNamesMap.putIfAbsent(str.intern(), "");
            return pattern;
        }
        synchronized (this) {
            try {
                String strIntern = str.intern();
                String strPutIfAbsent = this._genericLocationNamesMap.putIfAbsent(strIntern, pattern.intern());
                if (strPutIfAbsent == null) {
                    this._gnamesTrie.put(pattern, new NameInfo(strIntern, GenericNameType.LOCATION));
                } else {
                    pattern = strPutIfAbsent;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pattern;
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this._frozen;
    }

    public TimeZoneGenericNames setFormatPattern(Pattern pattern, String str) {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen object");
            return null;
        }
        if (!this._genericLocationNamesMap.isEmpty()) {
            this._genericLocationNamesMap = new ConcurrentHashMap<>();
        }
        if (!this._genericPartialLocationNamesMap.isEmpty()) {
            this._genericPartialLocationNamesMap = new ConcurrentHashMap<>();
        }
        this._gnamesTrie = null;
        this._gnamesTrieFullyLoaded = false;
        if (this._patternFormatters == null) {
            this._patternFormatters = new MessageFormat[Pattern.values().length];
        }
        this._patternFormatters[pattern.ordinal()] = new MessageFormat(str);
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Cache extends SoftCache<String, TimeZoneGenericNames, ULocale> {
        public /* synthetic */ Cache(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.CacheBase
        public TimeZoneGenericNames createInstance(String str, ULocale uLocale) {
            return new TimeZoneGenericNames(uLocale, 0).freeze();
        }

        private Cache() {
        }
    }

    @Override // com.ibm.icu.util.Freezable
    public TimeZoneGenericNames freeze() {
        this._frozen = true;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class GenericMatchInfo {
        final int matchLength;
        final GenericNameType nameType;
        final TimeZoneFormat.TimeType timeType;
        final String tzID;

        private GenericMatchInfo(GenericNameType genericNameType, String str, int i, TimeZoneFormat.TimeType timeType) {
            this.nameType = genericNameType;
            this.tzID = str;
            this.matchLength = i;
            this.timeType = timeType;
        }

        public int matchLength() {
            return this.matchLength;
        }

        public GenericNameType nameType() {
            return this.nameType;
        }

        public TimeZoneFormat.TimeType timeType() {
            return this.timeType;
        }

        public String tzID() {
            return this.tzID;
        }

        public /* synthetic */ GenericMatchInfo(GenericNameType genericNameType, String str, int i, TimeZoneFormat.TimeType timeType, int i2) {
            this(genericNameType, str, i, timeType);
        }

        private GenericMatchInfo(GenericNameType genericNameType, String str, int i) {
            this(genericNameType, str, i, TimeZoneFormat.TimeType.UNKNOWN);
        }

        public /* synthetic */ GenericMatchInfo(GenericNameType genericNameType, String str, int i, int i2) {
            this(genericNameType, str, i);
        }
    }

    public /* synthetic */ TimeZoneGenericNames(ULocale uLocale, int i) {
        this(uLocale);
    }

    private TimeZoneGenericNames(ULocale uLocale) {
        this(uLocale, (TimeZoneNames) null);
    }
}
