package com.ibm.icu.impl;

import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TimeZoneNamesImpl extends TimeZoneNames {
    private static volatile Set<String> METAZONE_IDS = null;
    private static final String MZ_PREFIX = "meta:";
    private static final MZ2TZsCache MZ_TO_TZS_CACHE;
    private static final TZ2MZsCache TZ_TO_MZS_CACHE;
    private static final String ZONE_STRINGS_BUNDLE = "zoneStrings";
    private static final long serialVersionUID = -2179814848495897472L;
    private transient ConcurrentHashMap<String, ZNames> _mzNamesMap;
    private transient boolean _namesFullyLoaded;
    private transient TextTrieMap<NameInfo> _namesTrie;
    private transient boolean _namesTrieFullyLoaded;
    private transient ConcurrentHashMap<String, ZNames> _tzNamesMap;
    private transient ICUResourceBundle _zoneStrings;

    /* JADX INFO: renamed from: com.ibm.icu.impl.TimeZoneNamesImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType;

        static {
            int[] iArr = new int[ZNames.NameTypeIndex.values().length];
            $SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex = iArr;
            try {
                iArr[ZNames.NameTypeIndex.EXEMPLAR_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex[ZNames.NameTypeIndex.LONG_GENERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex[ZNames.NameTypeIndex.LONG_STANDARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex[ZNames.NameTypeIndex.LONG_DAYLIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex[ZNames.NameTypeIndex.SHORT_GENERIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex[ZNames.NameTypeIndex.SHORT_STANDARD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex[ZNames.NameTypeIndex.SHORT_DAYLIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[TimeZoneNames.NameType.values().length];
            $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType = iArr2;
            try {
                iArr2[TimeZoneNames.NameType.EXEMPLAR_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.LONG_GENERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.LONG_STANDARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.LONG_DAYLIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_GENERIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_STANDARD.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_DAYLIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MZMapEntry {
        private long _from;
        private String _mzID;
        private long _to;

        public MZMapEntry(String str, long j, long j2) {
            this._mzID = str;
            this._from = j;
            this._to = j2;
        }

        public long from() {
            return this._from;
        }

        public String mzID() {
            return this._mzID;
        }

        public long to() {
            return this._to;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NameSearchHandler implements TextTrieMap.ResultHandler<NameInfo> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Collection<TimeZoneNames.MatchInfo> _matches;
        private int _maxMatchLen;
        private EnumSet<TimeZoneNames.NameType> _nameTypes;

        public NameSearchHandler(EnumSet<TimeZoneNames.NameType> enumSet) {
            this._nameTypes = enumSet;
        }

        public Collection<TimeZoneNames.MatchInfo> getMatches() {
            Collection<TimeZoneNames.MatchInfo> collection = this._matches;
            return collection == null ? Collections.EMPTY_LIST : collection;
        }

        public int getMaxMatchLen() {
            return this._maxMatchLen;
        }

        @Override // com.ibm.icu.impl.TextTrieMap.ResultHandler
        public boolean handlePrefixMatch(int i, Iterator<NameInfo> it) {
            while (it.hasNext()) {
                NameInfo next = it.next();
                EnumSet<TimeZoneNames.NameType> enumSet = this._nameTypes;
                if (enumSet == null || enumSet.contains(next.type)) {
                    String str = next.tzID;
                    TimeZoneNames.NameType nameType = next.type;
                    TimeZoneNames.MatchInfo matchInfo = str != null ? new TimeZoneNames.MatchInfo(nameType, str, null, i) : new TimeZoneNames.MatchInfo(nameType, null, next.mzID, i);
                    if (this._matches == null) {
                        this._matches = new LinkedList();
                    }
                    this._matches.add(matchInfo);
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
    public static class ZNames {
        static final ZNames EMPTY_ZNAMES = new ZNames(null);
        private static final int EX_LOC_INDEX = NameTypeIndex.EXEMPLAR_LOCATION.ordinal();
        public static final int NUM_NAME_TYPES = 7;
        private String[] _names;
        private boolean didAddIntoTrie;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum NameTypeIndex {
            EXEMPLAR_LOCATION,
            LONG_GENERIC,
            LONG_STANDARD,
            LONG_DAYLIGHT,
            SHORT_GENERIC,
            SHORT_STANDARD,
            SHORT_DAYLIGHT;

            static final NameTypeIndex[] values = values();
        }

        public ZNames(String[] strArr) {
            this._names = strArr;
            this.didAddIntoTrie = strArr == null;
        }

        private void addNamesIntoTrie(String str, String str2, TextTrieMap<NameInfo> textTrieMap) {
            if (this._names == null || this.didAddIntoTrie) {
                return;
            }
            this.didAddIntoTrie = true;
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = this._names;
                if (i2 >= strArr.length) {
                    return;
                }
                String str3 = strArr[i2];
                if (str3 != null) {
                    NameInfo nameInfo = new NameInfo(i);
                    nameInfo.mzID = str;
                    nameInfo.tzID = str2;
                    nameInfo.type = getNameType(i2);
                    textTrieMap.put(str3, nameInfo);
                }
                i2++;
            }
        }

        public static ZNames createMetaZoneAndPutInCache(Map<String, ZNames> map, String[] strArr, String str) {
            String strIntern = str.intern();
            ZNames zNames = strArr == null ? EMPTY_ZNAMES : new ZNames(strArr);
            map.put(strIntern, zNames);
            return zNames;
        }

        public static ZNames createTimeZoneAndPutInCache(Map<String, ZNames> map, String[] strArr, String str) {
            if (strArr == null) {
                strArr = new String[EX_LOC_INDEX + 1];
            }
            int i = EX_LOC_INDEX;
            if (strArr[i] == null) {
                strArr[i] = TimeZoneNamesImpl.getDefaultExemplarLocationName(str);
            }
            String strIntern = str.intern();
            ZNames zNames = new ZNames(strArr);
            map.put(strIntern, zNames);
            return zNames;
        }

        private static TimeZoneNames.NameType getNameType(int i) {
            switch (AnonymousClass1.$SwitchMap$com$ibm$icu$impl$TimeZoneNamesImpl$ZNames$NameTypeIndex[NameTypeIndex.values[i].ordinal()]) {
                case 1:
                    return TimeZoneNames.NameType.EXEMPLAR_LOCATION;
                case 2:
                    return TimeZoneNames.NameType.LONG_GENERIC;
                case 3:
                    return TimeZoneNames.NameType.LONG_STANDARD;
                case 4:
                    return TimeZoneNames.NameType.LONG_DAYLIGHT;
                case 5:
                    return TimeZoneNames.NameType.SHORT_GENERIC;
                case 6:
                    return TimeZoneNames.NameType.SHORT_STANDARD;
                case 7:
                    return TimeZoneNames.NameType.SHORT_DAYLIGHT;
                default:
                    og.m(ky0.h(i, "No NameType match for "));
                    return null;
            }
        }

        private static int getNameTypeIndex(TimeZoneNames.NameType nameType) {
            switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[nameType.ordinal()]) {
                case 1:
                    return NameTypeIndex.EXEMPLAR_LOCATION.ordinal();
                case 2:
                    return NameTypeIndex.LONG_GENERIC.ordinal();
                case 3:
                    return NameTypeIndex.LONG_STANDARD.ordinal();
                case 4:
                    return NameTypeIndex.LONG_DAYLIGHT.ordinal();
                case 5:
                    return NameTypeIndex.SHORT_GENERIC.ordinal();
                case 6:
                    return NameTypeIndex.SHORT_STANDARD.ordinal();
                case 7:
                    return NameTypeIndex.SHORT_DAYLIGHT.ordinal();
                default:
                    og.m("No NameTypeIndex match for ".concat(String.valueOf(nameType)));
                    return 0;
            }
        }

        public void addAsMetaZoneIntoTrie(String str, TextTrieMap<NameInfo> textTrieMap) {
            addNamesIntoTrie(str, null, textTrieMap);
        }

        public void addAsTimeZoneIntoTrie(String str, TextTrieMap<NameInfo> textTrieMap) {
            addNamesIntoTrie(null, str, textTrieMap);
        }

        public String getName(TimeZoneNames.NameType nameType) {
            int nameTypeIndex = getNameTypeIndex(nameType);
            String[] strArr = this._names;
            if (strArr == null || nameTypeIndex >= strArr.length) {
                return null;
            }
            return strArr[nameTypeIndex];
        }
    }

    static {
        int i = 0;
        TZ_TO_MZS_CACHE = new TZ2MZsCache(i);
        MZ_TO_TZS_CACHE = new MZ2TZsCache(i);
    }

    public TimeZoneNamesImpl(ULocale uLocale) {
        initialize(uLocale);
    }

    public static Set<String> _getAvailableMetaZoneIDs(String str) {
        if (str == null || str.length() == 0) {
            return Collections.EMPTY_SET;
        }
        List<MZMapEntry> softCache = TZ_TO_MZS_CACHE.getInstance(str, str);
        if (softCache.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(softCache.size());
        Iterator<MZMapEntry> it = softCache.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().mzID());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static String _getMetaZoneID(String str, long j) {
        if (str != null && str.length() != 0) {
            for (MZMapEntry mZMapEntry : TZ_TO_MZS_CACHE.getInstance(str, str)) {
                if (j >= mZMapEntry.from() && j < mZMapEntry.to()) {
                    return mZMapEntry.mzID();
                }
            }
        }
        return null;
    }

    public static String _getReferenceZoneID(String str, String str2) {
        if (str != null && str.length() != 0) {
            Map<String, String> softCache = MZ_TO_TZS_CACHE.getInstance(str, str);
            if (!softCache.isEmpty()) {
                String str3 = softCache.get(str2);
                return str3 == null ? softCache.get(UnitsData.Constants.DEFAULT_REGION) : str3;
            }
        }
        return null;
    }

    private void addAllNamesIntoTrie() {
        for (Map.Entry<String, ZNames> entry : this._tzNamesMap.entrySet()) {
            entry.getValue().addAsTimeZoneIntoTrie(entry.getKey(), this._namesTrie);
        }
        for (Map.Entry<String, ZNames> entry2 : this._mzNamesMap.entrySet()) {
            entry2.getValue().addAsMetaZoneIntoTrie(entry2.getKey(), this._namesTrie);
        }
    }

    private Collection<TimeZoneNames.MatchInfo> doFind(NameSearchHandler nameSearchHandler, CharSequence charSequence, int i) {
        nameSearchHandler.resetResults();
        this._namesTrie.find(charSequence, i, nameSearchHandler);
        if (nameSearchHandler.getMaxMatchLen() == charSequence.length() - i || this._namesTrieFullyLoaded) {
            return nameSearchHandler.getMatches();
        }
        return null;
    }

    public static String getDefaultExemplarLocationName(String str) {
        int iLastIndexOf;
        int i;
        if (str == null || str.length() == 0 || ZoneMeta.getCanonicalCountry(str) == null || (iLastIndexOf = str.lastIndexOf(47)) <= 0 || (i = iLastIndexOf + 1) >= str.length()) {
            return null;
        }
        return str.substring(i).replace('_', ' ');
    }

    private void initialize(ULocale uLocale) {
        this._zoneStrings = (ICUResourceBundle) ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_ZONE_BASE_NAME, uLocale)).get(ZONE_STRINGS_BUNDLE);
        this._tzNamesMap = new ConcurrentHashMap<>();
        this._mzNamesMap = new ConcurrentHashMap<>();
        this._namesFullyLoaded = false;
        this._namesTrie = new TextTrieMap<>(true);
        this._namesTrieFullyLoaded = false;
        String canonicalCLDRID = ZoneMeta.getCanonicalCLDRID(TimeZone.getDefault());
        if (canonicalCLDRID != null) {
            loadStrings(canonicalCLDRID);
        }
    }

    private void internalLoadAllDisplayNames() {
        if (this._namesFullyLoaded) {
            return;
        }
        this._namesFullyLoaded = true;
        new ZoneStringsLoader(this, 0).load();
    }

    private synchronized ZNames loadMetaZoneNames(String str) {
        ZNames zNamesCreateMetaZoneAndPutInCache;
        zNamesCreateMetaZoneAndPutInCache = this._mzNamesMap.get(str);
        if (zNamesCreateMetaZoneAndPutInCache == null) {
            ZNamesLoader zNamesLoader = new ZNamesLoader(0);
            zNamesLoader.loadMetaZone(this._zoneStrings, str);
            zNamesCreateMetaZoneAndPutInCache = ZNames.createMetaZoneAndPutInCache(this._mzNamesMap, zNamesLoader.getNames(), str);
        }
        return zNamesCreateMetaZoneAndPutInCache;
    }

    private synchronized void loadStrings(String str) {
        if (str != null) {
            if (str.length() != 0) {
                loadTimeZoneNames(str);
                Iterator<String> it = getAvailableMetaZoneIDs(str).iterator();
                while (it.hasNext()) {
                    loadMetaZoneNames(it.next());
                }
            }
        }
    }

    private synchronized ZNames loadTimeZoneNames(String str) {
        ZNames zNamesCreateTimeZoneAndPutInCache;
        zNamesCreateTimeZoneAndPutInCache = this._tzNamesMap.get(str);
        if (zNamesCreateTimeZoneAndPutInCache == null) {
            ZNamesLoader zNamesLoader = new ZNamesLoader(0);
            zNamesLoader.loadTimeZone(this._zoneStrings, str);
            zNamesCreateTimeZoneAndPutInCache = ZNames.createTimeZoneAndPutInCache(this._tzNamesMap, zNamesLoader.getNames(), str);
        }
        return zNamesCreateTimeZoneAndPutInCache;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        initialize((ULocale) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this._zoneStrings.getULocale());
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public synchronized Collection<TimeZoneNames.MatchInfo> find(CharSequence charSequence, int i, EnumSet<TimeZoneNames.NameType> enumSet) {
        if (charSequence != null) {
            try {
                if (charSequence.length() != 0 && i >= 0 && i < charSequence.length()) {
                    NameSearchHandler nameSearchHandler = new NameSearchHandler(enumSet);
                    Collection<TimeZoneNames.MatchInfo> collectionDoFind = doFind(nameSearchHandler, charSequence, i);
                    if (collectionDoFind != null) {
                        return collectionDoFind;
                    }
                    addAllNamesIntoTrie();
                    Collection<TimeZoneNames.MatchInfo> collectionDoFind2 = doFind(nameSearchHandler, charSequence, i);
                    if (collectionDoFind2 != null) {
                        return collectionDoFind2;
                    }
                    internalLoadAllDisplayNames();
                    for (String str : TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL, null, null)) {
                        if (!this._tzNamesMap.containsKey(str)) {
                            ZNames.createTimeZoneAndPutInCache(this._tzNamesMap, null, str);
                        }
                    }
                    addAllNamesIntoTrie();
                    this._namesTrieFullyLoaded = true;
                    return doFind(nameSearchHandler, charSequence, i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        throw new IllegalArgumentException("bad input text or range");
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public Set<String> getAvailableMetaZoneIDs() {
        return _getAvailableMetaZoneIDs();
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public void getDisplayNames(String str, TimeZoneNames.NameType[] nameTypeArr, long j, String[] strArr, int i) {
        if (str == null || str.length() == 0) {
            return;
        }
        ZNames zNamesLoadTimeZoneNames = loadTimeZoneNames(str);
        ZNames zNamesLoadMetaZoneNames = null;
        for (int i2 = 0; i2 < nameTypeArr.length; i2++) {
            TimeZoneNames.NameType nameType = nameTypeArr[i2];
            String name = zNamesLoadTimeZoneNames.getName(nameType);
            if (name == null) {
                if (zNamesLoadMetaZoneNames == null) {
                    String metaZoneID = getMetaZoneID(str, j);
                    zNamesLoadMetaZoneNames = (metaZoneID == null || metaZoneID.length() == 0) ? ZNames.EMPTY_ZNAMES : loadMetaZoneNames(metaZoneID);
                }
                name = zNamesLoadMetaZoneNames.getName(nameType);
            }
            strArr[i + i2] = name;
        }
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getExemplarLocationName(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return loadTimeZoneNames(str).getName(TimeZoneNames.NameType.EXEMPLAR_LOCATION);
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getMetaZoneDisplayName(String str, TimeZoneNames.NameType nameType) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return loadMetaZoneNames(str).getName(nameType);
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getMetaZoneID(String str, long j) {
        return _getMetaZoneID(str, j);
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getReferenceZoneID(String str, String str2) {
        return _getReferenceZoneID(str, str2);
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getTimeZoneDisplayName(String str, TimeZoneNames.NameType nameType) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return loadTimeZoneNames(str).getName(nameType);
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public synchronized void loadAllDisplayNames() {
        internalLoadAllDisplayNames();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MZ2TZsCache extends SoftCache<String, Map<String, String>, String> {
        public /* synthetic */ MZ2TZsCache(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.CacheBase
        public Map<String, String> createInstance(String str, String str2) {
            try {
                UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "metaZones").get("mapTimezones").get(str);
                Set<String> setKeySet = uResourceBundle.keySet();
                HashMap map = new HashMap(setKeySet.size());
                for (String str3 : setKeySet) {
                    map.put(str3.intern(), uResourceBundle.getString(str3).intern());
                }
                return map;
            } catch (MissingResourceException unused) {
                return Collections.EMPTY_MAP;
            }
        }

        private MZ2TZsCache() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NameInfo {
        String mzID;
        TimeZoneNames.NameType type;
        String tzID;

        public /* synthetic */ NameInfo(int i) {
            this();
        }

        private NameInfo() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class TZ2MZsCache extends SoftCache<String, List<MZMapEntry>, String> {
        public /* synthetic */ TZ2MZsCache(int i) {
            this();
        }

        private static long parseDate(String str) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 <= 3; i3++) {
                int iCharAt = str.charAt(i3) - '0';
                if (iCharAt < 0 || iCharAt >= 10) {
                    og.i("Bad year");
                    return 0L;
                }
                i2 = (i2 * 10) + iCharAt;
            }
            int i4 = 0;
            for (int i5 = 5; i5 <= 6; i5++) {
                int iCharAt2 = str.charAt(i5) - '0';
                if (iCharAt2 < 0 || iCharAt2 >= 10) {
                    og.i("Bad month");
                    return 0L;
                }
                i4 = (i4 * 10) + iCharAt2;
            }
            int i6 = 0;
            for (int i7 = 8; i7 <= 9; i7++) {
                int iCharAt3 = str.charAt(i7) - '0';
                if (iCharAt3 < 0 || iCharAt3 >= 10) {
                    og.i("Bad day");
                    return 0L;
                }
                i6 = (i6 * 10) + iCharAt3;
            }
            int i8 = 0;
            for (int i9 = 11; i9 <= 12; i9++) {
                int iCharAt4 = str.charAt(i9) - '0';
                if (iCharAt4 < 0 || iCharAt4 >= 10) {
                    og.i("Bad hour");
                    return 0L;
                }
                i8 = (i8 * 10) + iCharAt4;
            }
            for (int i10 = 14; i10 <= 15; i10++) {
                int iCharAt5 = str.charAt(i10) - '0';
                if (iCharAt5 < 0 || iCharAt5 >= 10) {
                    og.i("Bad minute");
                    return 0L;
                }
                i = (i * 10) + iCharAt5;
            }
            return (((long) i) * 60000) + (((long) i8) * 3600000) + (Grego.fieldsToDay(i2, i4 - 1, i6) * CalendarAstronomer.DAY_MS);
        }

        @Override // com.ibm.icu.impl.CacheBase
        public List<MZMapEntry> createInstance(String str, String str2) {
            try {
                UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "metaZones").get("metazoneInfo").get(str2.replace('/', ':'));
                ArrayList arrayList = new ArrayList(uResourceBundle.getSize());
                for (int i = 0; i < uResourceBundle.getSize(); i++) {
                    UResourceBundle uResourceBundle2 = uResourceBundle.get(i);
                    String string = uResourceBundle2.getString(0);
                    String string2 = "1970-01-01 00:00";
                    String string3 = "9999-12-31 23:59";
                    if (uResourceBundle2.getSize() >= 3) {
                        string2 = uResourceBundle2.getString(1);
                        string3 = uResourceBundle2.getString(2);
                    }
                    arrayList.add(new MZMapEntry(string, parseDate(string2), parseDate(string3)));
                }
                return arrayList;
            } catch (MissingResourceException unused) {
                return Collections.EMPTY_LIST;
            }
        }

        private TZ2MZsCache() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ZNamesLoader extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static ZNamesLoader DUMMY_LOADER = new ZNamesLoader();
        private String[] names;

        public /* synthetic */ ZNamesLoader(int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String[] getNames() {
            if (Utility.sameObjects(this.names, null)) {
                return null;
            }
            int i = 0;
            for (int i2 = 0; i2 < 7; i2++) {
                String str = this.names[i2];
                if (str != null) {
                    if (str.equals(ICUResourceBundle.NO_INHERITANCE_MARKER)) {
                        this.names[i2] = null;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
            if (i == 7) {
                return this.names;
            }
            if (i == 0) {
                return null;
            }
            return (String[]) Arrays.copyOfRange(this.names, 0, i);
        }

        private static ZNames.NameTypeIndex nameTypeIndexFromKey(UResource.Key key) {
            if (key.length() != 2) {
                return null;
            }
            char cCharAt = key.charAt(0);
            char cCharAt2 = key.charAt(1);
            if (cCharAt == 'l') {
                if (cCharAt2 == 'g') {
                    return ZNames.NameTypeIndex.LONG_GENERIC;
                }
                if (cCharAt2 == 's') {
                    return ZNames.NameTypeIndex.LONG_STANDARD;
                }
                if (cCharAt2 == 'd') {
                    return ZNames.NameTypeIndex.LONG_DAYLIGHT;
                }
                return null;
            }
            if (cCharAt != 's') {
                if (cCharAt == 'e' && cCharAt2 == 'c') {
                    return ZNames.NameTypeIndex.EXEMPLAR_LOCATION;
                }
                return null;
            }
            if (cCharAt2 == 'g') {
                return ZNames.NameTypeIndex.SHORT_GENERIC;
            }
            if (cCharAt2 == 's') {
                return ZNames.NameTypeIndex.SHORT_STANDARD;
            }
            if (cCharAt2 == 'd') {
                return ZNames.NameTypeIndex.SHORT_DAYLIGHT;
            }
            return null;
        }

        private void setNameIfEmpty(UResource.Key key, UResource.Value value) {
            if (this.names == null) {
                this.names = new String[7];
            }
            ZNames.NameTypeIndex nameTypeIndexNameTypeIndexFromKey = nameTypeIndexFromKey(key);
            if (nameTypeIndexNameTypeIndexFromKey != null && this.names[nameTypeIndexNameTypeIndexFromKey.ordinal()] == null) {
                this.names[nameTypeIndexNameTypeIndexFromKey.ordinal()] = value.getString();
            }
        }

        public void loadMetaZone(ICUResourceBundle iCUResourceBundle, String str) {
            loadNames(iCUResourceBundle, cq.j(TimeZoneNamesImpl.MZ_PREFIX, str));
        }

        public void loadNames(ICUResourceBundle iCUResourceBundle, String str) {
            this.names = null;
            try {
                iCUResourceBundle.getAllItemsWithFallback(str, this);
            } catch (MissingResourceException unused) {
            }
        }

        public void loadTimeZone(ICUResourceBundle iCUResourceBundle, String str) {
            loadNames(iCUResourceBundle, str.replace('/', ':'));
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                setNameIfEmpty(key, value);
            }
        }

        private ZNamesLoader() {
        }
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public Set<String> getAvailableMetaZoneIDs(String str) {
        return _getAvailableMetaZoneIDs(str);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public final class ZoneStringsLoader extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int INITIAL_NUM_ZONES = 300;
        private HashMap<UResource.Key, ZNamesLoader> keyToLoader;
        private StringBuilder sb;

        private ZoneStringsLoader() {
            this.keyToLoader = new HashMap<>(300);
            this.sb = new StringBuilder(32);
        }

        private void consumeNamesTable(UResource.Key key, UResource.Value value, boolean z) {
            ZNamesLoader zNamesLoader = this.keyToLoader.get(key);
            if (zNamesLoader == null) {
                int i = 0;
                if (isMetaZone(key)) {
                    zNamesLoader = TimeZoneNamesImpl.this._mzNamesMap.containsKey(mzIDFromKey(key)) ? ZNamesLoader.DUMMY_LOADER : new ZNamesLoader(i);
                } else {
                    zNamesLoader = TimeZoneNamesImpl.this._tzNamesMap.containsKey(tzIDFromKey(key)) ? ZNamesLoader.DUMMY_LOADER : new ZNamesLoader(i);
                }
                this.keyToLoader.put(createKey(key), zNamesLoader);
            }
            if (zNamesLoader != ZNamesLoader.DUMMY_LOADER) {
                zNamesLoader.put(key, value, z);
            }
        }

        private String mzIDFromKey(UResource.Key key) {
            this.sb.setLength(0);
            int i = 5;
            while (true) {
                int length = key.length();
                StringBuilder sb = this.sb;
                if (i >= length) {
                    return sb.toString();
                }
                sb.append(key.charAt(i));
                i++;
            }
        }

        private String tzIDFromKey(UResource.Key key) {
            this.sb.setLength(0);
            for (int i = 0; i < key.length(); i++) {
                char cCharAt = key.charAt(i);
                if (cCharAt == ':') {
                    cCharAt = '/';
                }
                this.sb.append(cCharAt);
            }
            return this.sb.toString();
        }

        public UResource.Key createKey(UResource.Key key) {
            return key.m6clone();
        }

        public boolean isMetaZone(UResource.Key key) {
            return key.startsWith(TimeZoneNamesImpl.MZ_PREFIX);
        }

        public void load() {
            TimeZoneNamesImpl.this._zoneStrings.getAllItemsWithFallback("", this);
            for (Map.Entry<UResource.Key, ZNamesLoader> entry : this.keyToLoader.entrySet()) {
                ZNamesLoader value = entry.getValue();
                if (value != ZNamesLoader.DUMMY_LOADER) {
                    UResource.Key key = entry.getKey();
                    if (isMetaZone(key)) {
                        ZNames.createMetaZoneAndPutInCache(TimeZoneNamesImpl.this._mzNamesMap, value.getNames(), mzIDFromKey(key));
                    } else {
                        ZNames.createTimeZoneAndPutInCache(TimeZoneNamesImpl.this._tzNamesMap, value.getNames(), tzIDFromKey(key));
                    }
                }
            }
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (value.getType() == 2) {
                    consumeNamesTable(key, value, z);
                }
            }
        }

        public /* synthetic */ ZoneStringsLoader(TimeZoneNamesImpl timeZoneNamesImpl, int i) {
            this();
        }
    }

    public static Set<String> _getAvailableMetaZoneIDs() {
        if (METAZONE_IDS == null) {
            synchronized (TimeZoneNamesImpl.class) {
                try {
                    if (METAZONE_IDS == null) {
                        METAZONE_IDS = Collections.unmodifiableSet(UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "metaZones").get("mapTimezones").keySet());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return METAZONE_IDS;
    }
}
