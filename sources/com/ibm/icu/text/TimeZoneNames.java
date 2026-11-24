package com.ibm.icu.text;

import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.TZDBTimeZoneNames;
import com.ibm.icu.impl.TimeZoneNamesImpl;
import com.ibm.icu.util.ULocale;
import defpackage.og;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class TimeZoneNames implements Serializable {
    private static final String DEFAULT_FACTORY_CLASS = "com.ibm.icu.impl.TimeZoneNamesFactoryImpl";
    private static final String FACTORY_NAME_PROP = "com.ibm.icu.text.TimeZoneNames.Factory.impl";
    private static Cache TZNAMES_CACHE = new Cache(0);
    private static final Factory TZNAMES_FACTORY;
    private static final long serialVersionUID = -9180227029248969153L;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static abstract class Factory {
        @Deprecated
        public Factory() {
        }

        @Deprecated
        public abstract TimeZoneNames getTimeZoneNames(ULocale uLocale);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MatchInfo {
        private int _matchLength;
        private String _mzID;
        private NameType _nameType;
        private String _tzID;

        public MatchInfo(NameType nameType, String str, String str2, int i) {
            if (nameType == null) {
                og.i("nameType is null");
                throw null;
            }
            if (str == null && str2 == null) {
                og.i("Either tzID or mzID must be available");
                throw null;
            }
            if (i <= 0) {
                og.i("matchLength must be positive value");
                throw null;
            }
            this._nameType = nameType;
            this._tzID = str;
            this._mzID = str2;
            this._matchLength = i;
        }

        public int matchLength() {
            return this._matchLength;
        }

        public String mzID() {
            return this._mzID;
        }

        public NameType nameType() {
            return this._nameType;
        }

        public String tzID() {
            return this._tzID;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum NameType {
        LONG_GENERIC,
        LONG_STANDARD,
        LONG_DAYLIGHT,
        SHORT_GENERIC,
        SHORT_STANDARD,
        SHORT_DAYLIGHT,
        EXEMPLAR_LOCATION
    }

    static {
        Factory factoryImpl;
        String str = ICUConfig.get(FACTORY_NAME_PROP, DEFAULT_FACTORY_CLASS);
        while (true) {
            try {
                factoryImpl = (Factory) Class.forName(str).newInstance();
                break;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
                if (str.equals(DEFAULT_FACTORY_CLASS)) {
                    factoryImpl = null;
                    break;
                }
                str = DEFAULT_FACTORY_CLASS;
            }
        }
        if (factoryImpl == null) {
            factoryImpl = new DefaultTimeZoneNames.FactoryImpl();
        }
        TZNAMES_FACTORY = factoryImpl;
    }

    public static TimeZoneNames getInstance(ULocale uLocale) {
        return TZNAMES_CACHE.getInstance(uLocale.getBaseName(), uLocale);
    }

    public static TimeZoneNames getTZDBInstance(ULocale uLocale) {
        return new TZDBTimeZoneNames(uLocale);
    }

    public Collection<MatchInfo> find(CharSequence charSequence, int i, EnumSet<NameType> enumSet) {
        throw new UnsupportedOperationException("The method is not implemented in TimeZoneNames base class.");
    }

    public abstract Set<String> getAvailableMetaZoneIDs();

    public abstract Set<String> getAvailableMetaZoneIDs(String str);

    public final String getDisplayName(String str, NameType nameType, long j) {
        String timeZoneDisplayName = getTimeZoneDisplayName(str, nameType);
        return timeZoneDisplayName == null ? getMetaZoneDisplayName(getMetaZoneID(str, j), nameType) : timeZoneDisplayName;
    }

    @Deprecated
    public void getDisplayNames(String str, NameType[] nameTypeArr, long j, String[] strArr, int i) {
        if (str == null || str.length() == 0) {
            return;
        }
        String metaZoneID = null;
        for (int i2 = 0; i2 < nameTypeArr.length; i2++) {
            NameType nameType = nameTypeArr[i2];
            String timeZoneDisplayName = getTimeZoneDisplayName(str, nameType);
            if (timeZoneDisplayName == null) {
                if (metaZoneID == null) {
                    metaZoneID = getMetaZoneID(str, j);
                }
                timeZoneDisplayName = getMetaZoneDisplayName(metaZoneID, nameType);
            }
            strArr[i + i2] = timeZoneDisplayName;
        }
    }

    public String getExemplarLocationName(String str) {
        return TimeZoneNamesImpl.getDefaultExemplarLocationName(str);
    }

    public abstract String getMetaZoneDisplayName(String str, NameType nameType);

    public abstract String getMetaZoneID(String str, long j);

    public abstract String getReferenceZoneID(String str, String str2);

    public abstract String getTimeZoneDisplayName(String str, NameType nameType);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DefaultTimeZoneNames extends TimeZoneNames {
        public static final DefaultTimeZoneNames INSTANCE = new DefaultTimeZoneNames();
        private static final long serialVersionUID = -995672072494349071L;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static class FactoryImpl extends Factory {
            @Override // com.ibm.icu.text.TimeZoneNames.Factory
            public TimeZoneNames getTimeZoneNames(ULocale uLocale) {
                return DefaultTimeZoneNames.INSTANCE;
            }
        }

        private DefaultTimeZoneNames() {
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public Collection<MatchInfo> find(CharSequence charSequence, int i, EnumSet<NameType> enumSet) {
            return Collections.EMPTY_LIST;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public Set<String> getAvailableMetaZoneIDs() {
            return Collections.EMPTY_SET;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public String getMetaZoneDisplayName(String str, NameType nameType) {
            return null;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public String getMetaZoneID(String str, long j) {
            return null;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public String getReferenceZoneID(String str, String str2) {
            return null;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public String getTimeZoneDisplayName(String str, NameType nameType) {
            return null;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public Set<String> getAvailableMetaZoneIDs(String str) {
            return Collections.EMPTY_SET;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Cache extends SoftCache<String, TimeZoneNames, ULocale> {
        public /* synthetic */ Cache(int i) {
            this();
        }

        private Cache() {
        }

        @Override // com.ibm.icu.impl.CacheBase
        public TimeZoneNames createInstance(String str, ULocale uLocale) {
            return TimeZoneNames.TZNAMES_FACTORY.getTimeZoneNames(uLocale);
        }
    }

    public static TimeZoneNames getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    @Deprecated
    public void loadAllDisplayNames() {
    }
}
