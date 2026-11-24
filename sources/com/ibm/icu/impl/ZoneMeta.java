package com.ibm.icu.impl;

import com.ibm.icu.util.Output;
import com.ibm.icu.util.SimpleTimeZone;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.UResourceBundle;
import defpackage.og;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ZoneMeta {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean ASSERT = false;
    private static final CustomTimeZoneCache CUSTOM_ZONE_CACHE;
    private static volatile SoftReference<Set<String>> REF_CANONICAL_SYSTEM_LOCATION_ZONES = null;
    private static volatile SoftReference<Set<String>> REF_CANONICAL_SYSTEM_ZONES = null;
    private static volatile SoftReference<Set<String>> REF_SYSTEM_ZONES = null;
    private static final SystemTimeZoneCache SYSTEM_ZONE_CACHE;
    private static volatile String[] ZONEIDS = null;
    private static final String ZONEINFORESNAME = "zoneinfo64";
    private static final String kCUSTOM_TZ_PREFIX = "GMT";
    private static final String kGMT_ID = "GMT";
    private static final int kMAX_CUSTOM_HOUR = 23;
    private static final int kMAX_CUSTOM_MIN = 59;
    private static final int kMAX_CUSTOM_SEC = 59;
    private static final String kNAMES = "Names";
    private static final String kREGIONS = "Regions";
    private static final String kWorld = "001";
    private static final String kZONES = "Zones";
    private static ICUCache<String, String> CANONICAL_ID_CACHE = new SimpleCache();
    private static ICUCache<String, String> REGION_CACHE = new SimpleCache();
    private static ICUCache<String, Boolean> SINGLE_COUNTRY_CACHE = new SimpleCache();

    /* JADX INFO: renamed from: com.ibm.icu.impl.ZoneMeta$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$TimeZone$SystemTimeZoneType;

        static {
            int[] iArr = new int[TimeZone.SystemTimeZoneType.values().length];
            $SwitchMap$com$ibm$icu$util$TimeZone$SystemTimeZoneType = iArr;
            try {
                iArr[TimeZone.SystemTimeZoneType.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$TimeZone$SystemTimeZoneType[TimeZone.SystemTimeZoneType.CANONICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$TimeZone$SystemTimeZoneType[TimeZone.SystemTimeZoneType.CANONICAL_LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        int i = 0;
        SYSTEM_ZONE_CACHE = new SystemTimeZoneCache(i);
        CUSTOM_ZONE_CACHE = new CustomTimeZoneCache(i);
    }

    public static int countEquivalentIDs(String str) {
        UResourceBundle uResourceBundleOpenOlsonResource = openOlsonResource(null, str);
        if (uResourceBundleOpenOlsonResource == null) {
            return 0;
        }
        try {
            return uResourceBundleOpenOlsonResource.get("links").getIntVector().length;
        } catch (MissingResourceException unused) {
            return 0;
        }
    }

    private static String findCLDRCanonicalID(String str) {
        String strReplace = str.replace('/', ':');
        String str2 = null;
        try {
            UResourceBundle bundleInstance = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
            try {
                bundleInstance.get("typeMap").get("timezone").get(strReplace);
            } catch (MissingResourceException unused) {
                str = null;
            }
            if (str != null) {
                return str;
            }
            try {
                return bundleInstance.get("typeAlias").get("timezone").getString(strReplace);
            } catch (MissingResourceException unused2) {
                str2 = str;
                return str2;
            }
        } catch (MissingResourceException unused3) {
        }
    }

    public static String formatCustomID(int i, int i2, int i3, boolean z) {
        StringBuilder sb = new StringBuilder("GMT");
        if (i != 0 || i2 != 0) {
            if (z) {
                sb.append('-');
            } else {
                sb.append('+');
            }
            if (i < 10) {
                sb.append('0');
            }
            sb.append(i);
            sb.append(':');
            if (i2 < 10) {
                sb.append('0');
            }
            sb.append(i2);
            if (i3 != 0) {
                sb.append(':');
                if (i3 < 10) {
                    sb.append('0');
                }
                sb.append(i3);
            }
        }
        return sb.toString();
    }

    public static Set<String> getAvailableIDs(TimeZone.SystemTimeZoneType systemTimeZoneType, String str, Integer num) {
        Set<String> systemZIDs;
        OlsonTimeZone systemTimeZone;
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$util$TimeZone$SystemTimeZoneType[systemTimeZoneType.ordinal()];
        if (i == 1) {
            systemZIDs = getSystemZIDs();
        } else if (i == 2) {
            systemZIDs = getCanonicalSystemZIDs();
        } else {
            if (i != 3) {
                og.i("Unknown SystemTimeZoneType");
                return null;
            }
            systemZIDs = getCanonicalSystemLocationZIDs();
        }
        if (str == null && num == null) {
            return systemZIDs;
        }
        if (str != null) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        TreeSet treeSet = new TreeSet();
        for (String str2 : systemZIDs) {
            if (str == null || str.equals(getRegion(str2))) {
                if (num == null || ((systemTimeZone = getSystemTimeZone(str2)) != null && num.equals(Integer.valueOf(systemTimeZone.getRawOffset())))) {
                    treeSet.add(str2);
                }
            }
        }
        return treeSet.isEmpty() ? Collections.EMPTY_SET : Collections.unmodifiableSet(treeSet);
    }

    public static String getCanonicalCLDRID(String str) {
        String strFindCLDRCanonicalID = CANONICAL_ID_CACHE.get(str);
        if (strFindCLDRCanonicalID == null) {
            strFindCLDRCanonicalID = findCLDRCanonicalID(str);
            if (strFindCLDRCanonicalID == null) {
                try {
                    int zoneIndex = getZoneIndex(str);
                    if (zoneIndex >= 0) {
                        UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ZONEINFORESNAME, ICUResourceBundle.ICU_DATA_CLASS_LOADER).get(kZONES).get(zoneIndex);
                        if (uResourceBundle.getType() == 7) {
                            str = getZoneID(uResourceBundle.getInt());
                            strFindCLDRCanonicalID = findCLDRCanonicalID(str);
                        }
                        if (strFindCLDRCanonicalID == null) {
                            strFindCLDRCanonicalID = str;
                        }
                    }
                } catch (MissingResourceException unused) {
                }
            }
            if (strFindCLDRCanonicalID != null) {
                CANONICAL_ID_CACHE.put(str, strFindCLDRCanonicalID);
            }
        }
        return strFindCLDRCanonicalID;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.Boolean] */
    public static String getCanonicalCountry(String str, Output<Boolean> output) {
        output.value = Boolean.FALSE;
        String region = getRegion(str);
        if (region != null && region.equals("001")) {
            return null;
        }
        Boolean boolValueOf = SINGLE_COUNTRY_CACHE.get(str);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL_LOCATION, region, null).size() <= 1);
            SINGLE_COUNTRY_CACHE.put(str, boolValueOf);
        }
        if (boolValueOf.booleanValue()) {
            output.value = Boolean.TRUE;
            return region;
        }
        try {
            String string = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "metaZones").get("primaryZones").getString(region);
            if (str.equals(string)) {
                output.value = Boolean.TRUE;
                return region;
            }
            String canonicalCLDRID = getCanonicalCLDRID(str);
            if (canonicalCLDRID != null && canonicalCLDRID.equals(string)) {
                output.value = Boolean.TRUE;
            }
            return region;
        } catch (MissingResourceException unused) {
        }
    }

    private static Set<String> getCanonicalSystemLocationZIDs() {
        Set<String> setUnmodifiableSet;
        String region;
        SoftReference<Set<String>> softReference = REF_CANONICAL_SYSTEM_LOCATION_ZONES;
        Set<String> set = softReference != null ? softReference.get() : null;
        if (set != null) {
            return set;
        }
        synchronized (ZoneMeta.class) {
            try {
                SoftReference<Set<String>> softReference2 = REF_CANONICAL_SYSTEM_LOCATION_ZONES;
                setUnmodifiableSet = softReference2 != null ? softReference2.get() : null;
                if (setUnmodifiableSet == null) {
                    TreeSet treeSet = new TreeSet();
                    for (String str : getZoneIDs()) {
                        if (!str.equals(TimeZone.UNKNOWN_ZONE_ID) && str.equals(getCanonicalCLDRID(str)) && (region = getRegion(str)) != null && !region.equals("001")) {
                            treeSet.add(str);
                        }
                    }
                    HashSet hashSet = new HashSet(treeSet.size());
                    for (Object obj : treeSet) {
                        Objects.requireNonNull(obj);
                        hashSet.add(obj);
                    }
                    setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
                    REF_CANONICAL_SYSTEM_LOCATION_ZONES = new SoftReference<>(setUnmodifiableSet);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return setUnmodifiableSet;
    }

    private static Set<String> getCanonicalSystemZIDs() {
        Set<String> setUnmodifiableSet;
        SoftReference<Set<String>> softReference = REF_CANONICAL_SYSTEM_ZONES;
        Set<String> set = softReference != null ? softReference.get() : null;
        if (set != null) {
            return set;
        }
        synchronized (ZoneMeta.class) {
            try {
                SoftReference<Set<String>> softReference2 = REF_CANONICAL_SYSTEM_ZONES;
                setUnmodifiableSet = softReference2 != null ? softReference2.get() : null;
                if (setUnmodifiableSet == null) {
                    TreeSet treeSet = new TreeSet();
                    for (String str : getZoneIDs()) {
                        if (!str.equals(TimeZone.UNKNOWN_ZONE_ID) && str.equals(getCanonicalCLDRID(str))) {
                            treeSet.add(str);
                        }
                    }
                    HashSet hashSet = new HashSet(treeSet.size());
                    for (Object obj : treeSet) {
                        Objects.requireNonNull(obj);
                        hashSet.add(obj);
                    }
                    setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
                    REF_CANONICAL_SYSTEM_ZONES = new SoftReference<>(setUnmodifiableSet);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return setUnmodifiableSet;
    }

    public static String getCustomID(String str) {
        int[] iArr = new int[4];
        if (parseCustomID(str, iArr)) {
            return formatCustomID(iArr[1], iArr[2], iArr[3], iArr[0] < 0);
        }
        return null;
    }

    public static SimpleTimeZone getCustomTimeZone(String str) {
        int[] iArr = new int[4];
        if (!parseCustomID(str, iArr)) {
            return null;
        }
        return CUSTOM_ZONE_CACHE.getInstance(Integer.valueOf(iArr[0] * (iArr[1] | (iArr[2] << 5) | (iArr[3] << 11))), iArr);
    }

    public static String getEquivalentID(String str, int i) {
        UResourceBundle uResourceBundleOpenOlsonResource;
        String zoneID;
        if (i >= 0 && (uResourceBundleOpenOlsonResource = openOlsonResource(null, str)) != null) {
            int i2 = -1;
            try {
                int[] intVector = uResourceBundleOpenOlsonResource.get("links").getIntVector();
                if (i < intVector.length) {
                    i2 = intVector[i];
                }
            } catch (MissingResourceException unused) {
            }
            if (i2 >= 0 && (zoneID = getZoneID(i2)) != null) {
                return zoneID;
            }
        }
        return "";
    }

    public static String getIanaID(String str) {
        String canonicalCLDRID = getCanonicalCLDRID(str);
        if (canonicalCLDRID == null) {
            return null;
        }
        try {
            return UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("ianaMap").get("timezone").getString(canonicalCLDRID.replace('/', ':'));
        } catch (MissingResourceException unused) {
            return canonicalCLDRID;
        }
    }

    public static String getRegion(String str) {
        int zoneIndex;
        String string = REGION_CACHE.get(str);
        if (string == null && (zoneIndex = getZoneIndex(str)) >= 0) {
            try {
                UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ZONEINFORESNAME, ICUResourceBundle.ICU_DATA_CLASS_LOADER).get(kREGIONS);
                if (zoneIndex < uResourceBundle.getSize()) {
                    string = uResourceBundle.getString(zoneIndex);
                }
            } catch (MissingResourceException unused) {
            }
            if (string != null) {
                REGION_CACHE.put(str, string);
            }
        }
        return string;
    }

    public static String getShortID(TimeZone timeZone) {
        String canonicalID = timeZone instanceof OlsonTimeZone ? ((OlsonTimeZone) timeZone).getCanonicalID() : getCanonicalCLDRID(timeZone.getID());
        if (canonicalID == null) {
            return null;
        }
        return getShortIDFromCanonical(canonicalID);
    }

    private static String getShortIDFromCanonical(String str) {
        try {
            return UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("typeMap").get("timezone").getString(str.replace('/', ':'));
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public static OlsonTimeZone getSystemTimeZone(String str) {
        return SYSTEM_ZONE_CACHE.getInstance(str, str);
    }

    private static Set<String> getSystemZIDs() {
        Set<String> setUnmodifiableSet;
        SoftReference<Set<String>> softReference = REF_SYSTEM_ZONES;
        Set<String> set = softReference != null ? softReference.get() : null;
        if (set != null) {
            return set;
        }
        synchronized (ZoneMeta.class) {
            try {
                SoftReference<Set<String>> softReference2 = REF_SYSTEM_ZONES;
                setUnmodifiableSet = softReference2 != null ? softReference2.get() : null;
                if (setUnmodifiableSet == null) {
                    TreeSet treeSet = new TreeSet();
                    for (String str : getZoneIDs()) {
                        if (!str.equals(TimeZone.UNKNOWN_ZONE_ID)) {
                            treeSet.add(str);
                        }
                    }
                    HashSet hashSet = new HashSet(treeSet.size());
                    for (Object obj : treeSet) {
                        Objects.requireNonNull(obj);
                        hashSet.add(obj);
                    }
                    setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
                    REF_SYSTEM_ZONES = new SoftReference<>(setUnmodifiableSet);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return setUnmodifiableSet;
    }

    private static String getZoneID(int i) {
        if (i < 0) {
            return null;
        }
        String[] zoneIDs = getZoneIDs();
        if (i < zoneIDs.length) {
            return zoneIDs[i];
        }
        return null;
    }

    private static String[] getZoneIDs() {
        if (ZONEIDS == null) {
            synchronized (ZoneMeta.class) {
                String[] stringArray = ZONEIDS;
                if (stringArray == null) {
                    try {
                        stringArray = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ZONEINFORESNAME, ICUResourceBundle.ICU_DATA_CLASS_LOADER).getStringArray(kNAMES);
                    } catch (MissingResourceException unused) {
                    }
                    if (stringArray == null) {
                        stringArray = new String[0];
                    }
                    ZONEIDS = stringArray;
                }
            }
        }
        return ZONEIDS;
    }

    private static int getZoneIndex(String str) {
        String[] zoneIDs = getZoneIDs();
        if (zoneIDs.length <= 0) {
            return -1;
        }
        int length = zoneIDs.length;
        int i = 0;
        int i2 = Integer.MAX_VALUE;
        while (true) {
            int i3 = (i + length) / 2;
            if (i2 == i3) {
                return -1;
            }
            int iCompareTo = str.compareTo(zoneIDs[i3]);
            if (iCompareTo == 0) {
                return i3;
            }
            if (iCompareTo < 0) {
                length = i3;
            } else {
                i = i3;
            }
            i2 = i3;
        }
    }

    public static UResourceBundle openOlsonResource(UResourceBundle uResourceBundle, String str) {
        int zoneIndex = getZoneIndex(str);
        if (zoneIndex >= 0) {
            if (uResourceBundle == null) {
                try {
                    uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ZONEINFORESNAME, ICUResourceBundle.ICU_DATA_CLASS_LOADER);
                } catch (MissingResourceException unused) {
                }
            }
            UResourceBundle uResourceBundle2 = uResourceBundle.get(kZONES);
            UResourceBundle uResourceBundle3 = uResourceBundle2.get(zoneIndex);
            return uResourceBundle3.getType() == 7 ? uResourceBundle2.get(uResourceBundle3.getInt()) : uResourceBundle3;
        }
        return null;
    }

    public static boolean parseCustomID(String str, int[] iArr) {
        int i;
        int i2;
        int i3;
        if (str != null && str.length() > 3 && str.substring(0, 3).equalsIgnoreCase("GMT")) {
            int[] iArr2 = {3};
            if (str.charAt(3) == '-') {
                i = -1;
            } else {
                if (str.charAt(iArr2[0]) != '+') {
                    return false;
                }
                i = 1;
            }
            int i4 = iArr2[0] + 1;
            iArr2[0] = i4;
            int number = Utility.parseNumber(str, iArr2, 10);
            if (iArr2[0] == str.length()) {
                switch (iArr2[0] - i4) {
                    case 1:
                    case 2:
                        i2 = 0;
                        i3 = 0;
                        break;
                    case 3:
                    case 4:
                        i3 = number % 100;
                        number /= 100;
                        i2 = 0;
                        break;
                    case 5:
                    case 6:
                        i2 = number % 100;
                        i3 = (number / 100) % 100;
                        number /= 10000;
                        break;
                    default:
                        return false;
                }
            } else {
                int i5 = iArr2[0];
                if (i5 - i4 >= 1 && i5 - i4 <= 2 && str.charAt(i5) == ':') {
                    iArr2[0] = iArr2[0] + 1;
                    int length = str.length();
                    int i6 = iArr2[0];
                    if (length == i6) {
                        return false;
                    }
                    int number2 = Utility.parseNumber(str, iArr2, 10);
                    if (iArr2[0] - i6 != 2) {
                        return false;
                    }
                    int length2 = str.length();
                    int i7 = iArr2[0];
                    if (length2 <= i7) {
                        i2 = 0;
                        i3 = number2;
                    } else {
                        if (str.charAt(i7) != ':') {
                            return false;
                        }
                        int i8 = iArr2[0] + 1;
                        iArr2[0] = i8;
                        int number3 = Utility.parseNumber(str, iArr2, 10);
                        if (iArr2[0] - i8 != 2 || str.length() > iArr2[0]) {
                            return false;
                        }
                        i3 = number2;
                        i2 = number3;
                    }
                }
            }
            if (number <= 23 && i3 <= 59 && i2 <= 59) {
                if (iArr != null) {
                    if (iArr.length >= 1) {
                        iArr[0] = i;
                    }
                    if (iArr.length >= 2) {
                        iArr[1] = number;
                    }
                    if (iArr.length >= 3) {
                        iArr[2] = i3;
                    }
                    if (iArr.length >= 4) {
                        iArr[3] = i2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CustomTimeZoneCache extends SoftCache<Integer, SimpleTimeZone, int[]> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public /* synthetic */ CustomTimeZoneCache(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.CacheBase
        public SimpleTimeZone createInstance(Integer num, int[] iArr) {
            SimpleTimeZone simpleTimeZone = new SimpleTimeZone(((((iArr[1] * 60) + iArr[2]) * 60) + iArr[3]) * iArr[0] * 1000, ZoneMeta.formatCustomID(iArr[1], iArr[2], iArr[3], iArr[0] < 0));
            simpleTimeZone.freeze();
            return simpleTimeZone;
        }

        private CustomTimeZoneCache() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SystemTimeZoneCache extends SoftCache<String, OlsonTimeZone, String> {
        public /* synthetic */ SystemTimeZoneCache(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.CacheBase
        public OlsonTimeZone createInstance(String str, String str2) {
            try {
                UResourceBundle bundleInstance = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ZoneMeta.ZONEINFORESNAME, ICUResourceBundle.ICU_DATA_CLASS_LOADER);
                UResourceBundle uResourceBundleOpenOlsonResource = ZoneMeta.openOlsonResource(bundleInstance, str2);
                if (uResourceBundleOpenOlsonResource == null) {
                    return null;
                }
                OlsonTimeZone olsonTimeZone = new OlsonTimeZone(bundleInstance, uResourceBundleOpenOlsonResource, str2);
                try {
                    olsonTimeZone.freeze();
                    return olsonTimeZone;
                } catch (MissingResourceException unused) {
                    return olsonTimeZone;
                }
            } catch (MissingResourceException unused2) {
                return null;
            }
        }

        private SystemTimeZoneCache() {
        }
    }

    public static String getShortID(String str) {
        String canonicalCLDRID = getCanonicalCLDRID(str);
        if (canonicalCLDRID == null) {
            return null;
        }
        return getShortIDFromCanonical(canonicalCLDRID);
    }

    public static SimpleTimeZone getCustomTimeZone(int i) {
        boolean z;
        int i2;
        if (i < 0) {
            i2 = -i;
            z = true;
        } else {
            z = false;
            i2 = i;
        }
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = i3 / 60;
        return new SimpleTimeZone(i, formatCustomID(i5 / 60, i5 % 60, i4, z));
    }

    public static String getCanonicalCLDRID(TimeZone timeZone) {
        if (timeZone instanceof OlsonTimeZone) {
            return ((OlsonTimeZone) timeZone).getCanonicalID();
        }
        return getCanonicalCLDRID(timeZone.getID());
    }

    public static String getCanonicalCountry(String str) {
        String region = getRegion(str);
        if (region == null || !region.equals("001")) {
            return region;
        }
        return null;
    }
}
