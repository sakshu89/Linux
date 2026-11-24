package com.ibm.icu.util;

import com.ibm.icu.impl.Grego;
import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.JavaTimeZone;
import com.ibm.icu.impl.OlsonTimeZone;
import com.ibm.icu.impl.TimeZoneAdapter;
import com.ibm.icu.impl.ZoneMeta;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.text.TimeZoneFormat;
import com.ibm.icu.text.TimeZoneNames;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class TimeZone implements Serializable, Cloneable, Freezable<TimeZone> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int GENERIC_LOCATION = 7;
    public static final int LONG = 1;
    public static final int LONG_GENERIC = 3;
    public static final int LONG_GMT = 5;
    public static final int SHORT = 0;
    public static final int SHORT_COMMONLY_USED = 6;
    public static final int SHORT_GENERIC = 2;
    public static final int SHORT_GMT = 4;
    public static final int TIMEZONE_ICU = 0;
    public static final int TIMEZONE_JDK = 1;
    private static final String TZIMPL_CONFIG_ICU = "ICU";
    private static final String TZIMPL_CONFIG_JDK = "JDK";
    private static final String TZIMPL_CONFIG_KEY = "com.ibm.icu.util.TimeZone.DefaultTimeZoneType";
    private static volatile int TZ_IMPL = 0;
    private static final long serialVersionUID = -744942128318337471L;
    private String ID;
    private static final Logger LOGGER = Logger.getLogger("com.ibm.icu.util.TimeZone");
    public static final String UNKNOWN_ZONE_ID = "Etc/Unknown";
    public static final TimeZone UNKNOWN_ZONE = new ConstantZone(UNKNOWN_ZONE_ID).freeze();
    static final String GMT_ZONE_ID = "Etc/GMT";
    public static final TimeZone GMT_ZONE = new ConstantZone(GMT_ZONE_ID).freeze();
    private static volatile TimeZone defaultZone = null;
    private static final Object defaultZoneLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum SystemTimeZoneType {
        ANY,
        CANONICAL,
        CANONICAL_LOCATION
    }

    static {
        TZ_IMPL = 0;
        if (ICUConfig.get(TZIMPL_CONFIG_KEY, TZIMPL_CONFIG_ICU).equalsIgnoreCase(TZIMPL_CONFIG_JDK)) {
            TZ_IMPL = 1;
        }
    }

    @Deprecated
    public TimeZone(String str) {
        str.getClass();
        this.ID = str;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x002e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0030  */
    /* JADX WARN: Code duplicated, block: B:24:0x0033  */
    private String _getDisplayName(int i, boolean z, ULocale uLocale) {
        TimeZone timeZone;
        int rawOffset;
        String offsetShortLocalizedGMT;
        int rawOffset2;
        int rawOffset3;
        String str = null;
        TimeZoneNames.NameType nameType = null;
        if (uLocale == null) {
            dk0.n("locale is null");
            return null;
        }
        if (i == 7 || i == 3 || i == 2) {
            TimeZoneFormat timeZoneFormat = TimeZoneFormat.getInstance(uLocale);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Output<TimeZoneFormat.TimeType> output = new Output<>(TimeZoneFormat.TimeType.UNKNOWN);
            if (i == 2) {
                timeZone = this;
                str = timeZoneFormat.format(TimeZoneFormat.Style.GENERIC_SHORT, timeZone, jCurrentTimeMillis, output);
            } else if (i == 3) {
                timeZone = this;
                str = timeZoneFormat.format(TimeZoneFormat.Style.GENERIC_LONG, timeZone, jCurrentTimeMillis, output);
            } else if (i != 7) {
                timeZone = this;
            } else {
                timeZone = this;
                str = timeZoneFormat.format(TimeZoneFormat.Style.GENERIC_LOCATION, timeZone, jCurrentTimeMillis, output);
            }
            if (!(z && output.value == TimeZoneFormat.TimeType.STANDARD) && (z || output.value != TimeZoneFormat.TimeType.DAYLIGHT)) {
                return str;
            }
            if (z) {
                rawOffset = timeZone.getDSTSavings() + timeZone.getRawOffset();
            } else {
                rawOffset = timeZone.getRawOffset();
            }
            offsetShortLocalizedGMT = i == 2 ? timeZoneFormat.formatOffsetShortLocalizedGMT(rawOffset) : timeZoneFormat.formatOffsetLocalizedGMT(rawOffset);
        } else {
            if (i == 5 || i == 4) {
                TimeZoneFormat timeZoneFormat2 = TimeZoneFormat.getInstance(uLocale);
                if (z && useDaylightTime()) {
                    rawOffset2 = getDSTSavings() + getRawOffset();
                } else {
                    rawOffset2 = getRawOffset();
                }
                if (i == 4) {
                    return timeZoneFormat2.formatOffsetISO8601Basic(rawOffset2, false, false, false);
                }
                if (i != 5) {
                    return null;
                }
                return timeZoneFormat2.formatOffsetLocalizedGMT(rawOffset2);
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            TimeZoneNames timeZoneNames = TimeZoneNames.getInstance(uLocale);
            if (i == 0) {
                if (z) {
                    nameType = TimeZoneNames.NameType.SHORT_DAYLIGHT;
                } else {
                    nameType = TimeZoneNames.NameType.SHORT_STANDARD;
                }
            } else if (i == 1) {
                nameType = z ? TimeZoneNames.NameType.LONG_DAYLIGHT : TimeZoneNames.NameType.LONG_STANDARD;
            } else if (i == 6) {
                if (z) {
                    nameType = TimeZoneNames.NameType.SHORT_DAYLIGHT;
                } else {
                    nameType = TimeZoneNames.NameType.SHORT_STANDARD;
                }
            }
            String displayName = timeZoneNames.getDisplayName(ZoneMeta.getCanonicalCLDRID(this), nameType, jCurrentTimeMillis2);
            if (displayName != null) {
                return displayName;
            }
            TimeZoneFormat timeZoneFormat3 = TimeZoneFormat.getInstance(uLocale);
            if (z && useDaylightTime()) {
                rawOffset3 = getDSTSavings() + getRawOffset();
            } else {
                rawOffset3 = getRawOffset();
            }
            offsetShortLocalizedGMT = i == 1 ? timeZoneFormat3.formatOffsetLocalizedGMT(rawOffset3) : timeZoneFormat3.formatOffsetShortLocalizedGMT(rawOffset3);
        }
        return offsetShortLocalizedGMT;
    }

    public static int countEquivalentIDs(String str) {
        return ZoneMeta.countEquivalentIDs(str);
    }

    @Deprecated
    public static TimeZone forLocaleOrDefault(Locale locale) {
        return forULocaleOrDefault(ULocale.forLocale(locale));
    }

    @Deprecated
    public static TimeZone forULocaleOrDefault(ULocale uLocale) {
        String keywordValue = uLocale.getKeywordValue("timezone");
        return keywordValue == null ? getDefault() : getTimeZone(keywordValue);
    }

    public static String[] getAvailableIDs(int i) {
        return (String[]) getAvailableIDs(SystemTimeZoneType.ANY, null, Integer.valueOf(i)).toArray(new String[0]);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0024  */
    public static String getCanonicalID(String str, boolean[] zArr) {
        String canonicalCLDRID;
        boolean z;
        if (str != null && str.length() != 0) {
            canonicalCLDRID = UNKNOWN_ZONE_ID;
            if (!str.equals(UNKNOWN_ZONE_ID)) {
                canonicalCLDRID = ZoneMeta.getCanonicalCLDRID(str);
                if (canonicalCLDRID != null) {
                    z = true;
                } else {
                    canonicalCLDRID = ZoneMeta.getCustomID(str);
                }
            }
            if (zArr != null) {
                zArr[0] = z;
            }
            return canonicalCLDRID;
        }
        canonicalCLDRID = null;
        z = false;
        if (zArr != null) {
            zArr[0] = z;
        }
        return canonicalCLDRID;
    }

    public static TimeZone getDefault() {
        TimeZone javaTimeZone = defaultZone;
        if (javaTimeZone == null) {
            synchronized (defaultZoneLock) {
                try {
                    javaTimeZone = defaultZone;
                    if (javaTimeZone == null) {
                        javaTimeZone = TZ_IMPL == 1 ? new JavaTimeZone() : getFrozenTimeZone(java.util.TimeZone.getDefault().getID());
                        defaultZone = javaTimeZone;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return javaTimeZone.cloneAsThawed();
    }

    public static int getDefaultTimeZoneType() {
        return TZ_IMPL;
    }

    public static String getEquivalentID(String str, int i) {
        return ZoneMeta.getEquivalentID(str, i);
    }

    public static BasicTimeZone getFrozenICUTimeZone(String str, boolean z) {
        OlsonTimeZone systemTimeZone = z ? ZoneMeta.getSystemTimeZone(str) : null;
        return systemTimeZone == null ? ZoneMeta.getCustomTimeZone(str) : systemTimeZone;
    }

    public static TimeZone getFrozenTimeZone(String str) {
        return getTimeZone(str, TZ_IMPL, true);
    }

    public static String getIDForWindowsID(String str, String str2) {
        int iIndexOf;
        String string = null;
        try {
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "windowsZones", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("mapTimezones").get(str);
            if (str2 != null) {
                try {
                    string = uResourceBundle.getString(str2);
                    if (string != null && (iIndexOf = string.indexOf(32)) > 0) {
                        string = string.substring(0, iIndexOf);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            return string == null ? uResourceBundle.getString(UnitsData.Constants.DEFAULT_REGION) : string;
        } catch (MissingResourceException unused2) {
            return null;
        }
    }

    public static String getIanaID(String str) {
        String ianaID;
        return (str == null || str.length() == 0 || str.equals(UNKNOWN_ZONE_ID) || (ianaID = ZoneMeta.getIanaID(str)) == null) ? UNKNOWN_ZONE_ID : ianaID;
    }

    public static String getRegion(String str) {
        String region = !str.equals(UNKNOWN_ZONE_ID) ? ZoneMeta.getRegion(str) : null;
        if (region != null) {
            return region;
        }
        og.i("Unknown system zone id: ".concat(str));
        return null;
    }

    public static String getTZDataVersion() {
        return VersionInfo.getTZDataVersion();
    }

    private static TimeZone getTimeZone(String str, int i, boolean z) {
        TimeZone frozenICUTimeZone;
        if (i == 1) {
            JavaTimeZone javaTimeZoneCreateTimeZone = JavaTimeZone.createTimeZone(str);
            if (javaTimeZoneCreateTimeZone != null) {
                return z ? javaTimeZoneCreateTimeZone.freeze() : javaTimeZoneCreateTimeZone;
            }
            frozenICUTimeZone = getFrozenICUTimeZone(str, false);
        } else {
            frozenICUTimeZone = getFrozenICUTimeZone(str, true);
        }
        if (frozenICUTimeZone == null) {
            LOGGER.fine("\"" + str + "\" is a bogus id so timezone is falling back to Etc/Unknown(GMT).");
            frozenICUTimeZone = UNKNOWN_ZONE;
        }
        return z ? frozenICUTimeZone : frozenICUTimeZone.cloneAsThawed();
    }

    public static String getWindowsID(String str) {
        boolean[] zArr = {false};
        String canonicalID = getCanonicalID(str, zArr);
        if (!zArr[0]) {
            return null;
        }
        UResourceBundleIterator iterator = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "windowsZones", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("mapTimezones").getIterator();
        while (iterator.hasNext()) {
            UResourceBundle next = iterator.next();
            if (next.getType() == 2) {
                UResourceBundleIterator iterator2 = next.getIterator();
                while (iterator2.hasNext()) {
                    UResourceBundle next2 = iterator2.next();
                    if (next2.getType() == 0) {
                        for (String str2 : next2.getString().split(Padder.FALLBACK_PADDING_STRING)) {
                            if (str2.equals(canonicalID)) {
                                return next.getKey();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003f  */
    public static void setDefault(TimeZone timeZone) {
        java.util.TimeZone timeZoneWrap;
        synchronized (defaultZoneLock) {
            try {
                setICUDefault(timeZone);
                if (timeZone != null) {
                    if (timeZone instanceof JavaTimeZone) {
                        timeZoneWrap = ((JavaTimeZone) timeZone).unwrap();
                    } else if (timeZone instanceof OlsonTimeZone) {
                        String id = timeZone.getID();
                        java.util.TimeZone timeZone2 = java.util.TimeZone.getTimeZone(id);
                        if (!id.equals(timeZone2.getID())) {
                            String canonicalID = getCanonicalID(id);
                            timeZone2 = java.util.TimeZone.getTimeZone(canonicalID);
                            if (!canonicalID.equals(timeZone2.getID())) {
                                timeZoneWrap = null;
                            }
                        }
                        timeZoneWrap = timeZone2;
                    } else {
                        timeZoneWrap = null;
                    }
                    if (timeZoneWrap == null) {
                        timeZoneWrap = TimeZoneAdapter.wrap(timeZone);
                    }
                    java.util.TimeZone.setDefault(timeZoneWrap);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void setDefaultTimeZoneType(int i) {
        try {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException("Invalid timezone type");
            }
            TZ_IMPL = i;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public static void setICUDefault(TimeZone timeZone) {
        synchronized (defaultZoneLock) {
            try {
                if (timeZone == null) {
                    defaultZone = null;
                } else if (timeZone.isFrozen()) {
                    defaultZone = timeZone;
                } else {
                    defaultZone = timeZone.mo3clone().freeze();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TimeZone mo3clone() {
        return isFrozen() ? this : cloneAsThawed();
    }

    public TimeZone cloneAsThawed() {
        try {
            return (TimeZone) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ID.equals(((TimeZone) obj).ID);
    }

    public TimeZone freeze() {
        throw new UnsupportedOperationException("Needs to be implemented by the subclass.");
    }

    public int getDSTSavings() {
        return useDaylightTime() ? 3600000 : 0;
    }

    public String getDisplayName(boolean z, int i, ULocale uLocale) {
        if (i >= 0 && i <= 7) {
            return _getDisplayName(i, z, uLocale);
        }
        og.i(ky0.h(i, "Illegal style: "));
        return null;
    }

    public String getID() {
        return this.ID;
    }

    public abstract int getOffset(int i, int i2, int i3, int i4, int i5, int i6);

    public void getOffset(long j, boolean z, int[] iArr) {
        int rawOffset = getRawOffset();
        iArr[0] = rawOffset;
        if (!z) {
            j += (long) rawOffset;
        }
        int[] iArr2 = new int[6];
        int i = 0;
        while (true) {
            Grego.timeToFields(j, iArr2);
            TimeZone timeZone = this;
            int offset = timeZone.getOffset(1, iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[5]) - iArr[0];
            iArr[1] = offset;
            if (i != 0 || !z || offset == 0) {
                return;
            }
            j -= (long) offset;
            i++;
            this = timeZone;
        }
    }

    public abstract int getRawOffset();

    public boolean hasSameRules(TimeZone timeZone) {
        return timeZone != null && getRawOffset() == timeZone.getRawOffset() && useDaylightTime() == timeZone.useDaylightTime();
    }

    public int hashCode() {
        return this.ID.hashCode();
    }

    public abstract boolean inDaylightTime(Date date);

    public boolean isFrozen() {
        return false;
    }

    public boolean observesDaylightTime() {
        return useDaylightTime() || inDaylightTime(new Date());
    }

    public void setID(String str) {
        str.getClass();
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen TimeZone instance.");
        } else {
            this.ID = str;
        }
    }

    public abstract void setRawOffset(int i);

    public abstract boolean useDaylightTime();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ConstantZone extends TimeZone {
        private static final long serialVersionUID = 1;
        private volatile transient boolean isFrozen;
        private int rawOffset;

        private ConstantZone(int i, String str) {
            super(str);
            this.isFrozen = false;
            this.rawOffset = i;
        }

        @Override // com.ibm.icu.util.TimeZone
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo3clone() {
            return super.mo3clone();
        }

        @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
        public TimeZone cloneAsThawed() {
            ConstantZone constantZone = (ConstantZone) super.cloneAsThawed();
            constantZone.isFrozen = false;
            return constantZone;
        }

        @Override // com.ibm.icu.util.TimeZone
        public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
            return this.rawOffset;
        }

        @Override // com.ibm.icu.util.TimeZone
        public int getRawOffset() {
            return this.rawOffset;
        }

        @Override // com.ibm.icu.util.TimeZone
        public boolean inDaylightTime(Date date) {
            return false;
        }

        @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
        public boolean isFrozen() {
            return this.isFrozen;
        }

        @Override // com.ibm.icu.util.TimeZone
        public void setRawOffset(int i) {
            if (isFrozen()) {
                dk0.r("Attempt to modify a frozen TimeZone instance.");
            } else {
                this.rawOffset = i;
            }
        }

        @Override // com.ibm.icu.util.TimeZone
        public boolean useDaylightTime() {
            return false;
        }

        @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
        public TimeZone freeze() {
            this.isFrozen = true;
            return this;
        }

        public /* synthetic */ ConstantZone(String str) {
            this(0, str);
        }
    }

    public TimeZone() {
    }

    public static Set<String> getAvailableIDs(SystemTimeZoneType systemTimeZoneType, String str, Integer num) {
        return ZoneMeta.getAvailableIDs(systemTimeZoneType, str, num);
    }

    public final String getDisplayName(Locale locale) {
        return _getDisplayName(3, false, ULocale.forLocale(locale));
    }

    public static String[] getAvailableIDs(String str) {
        return (String[]) getAvailableIDs(SystemTimeZoneType.ANY, str, null).toArray(new String[0]);
    }

    public final String getDisplayName(ULocale uLocale) {
        return _getDisplayName(3, false, uLocale);
    }

    public final String getDisplayName(boolean z, int i) {
        return getDisplayName(z, i, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public static String[] getAvailableIDs() {
        return (String[]) getAvailableIDs(SystemTimeZoneType.ANY, null, null).toArray(new String[0]);
    }

    public String getDisplayName(boolean z, int i, Locale locale) {
        return getDisplayName(z, i, ULocale.forLocale(locale));
    }

    public final String getDisplayName() {
        return _getDisplayName(3, false, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public static String getCanonicalID(String str) {
        return getCanonicalID(str, null);
    }

    public int getOffset(long j) {
        int[] iArr = new int[2];
        getOffset(j, false, iArr);
        return iArr[0] + iArr[1];
    }

    public static TimeZone getTimeZone(String str, int i) {
        return getTimeZone(str, i, false);
    }

    public static TimeZone getTimeZone(String str) {
        return getTimeZone(str, TZ_IMPL, false);
    }
}
