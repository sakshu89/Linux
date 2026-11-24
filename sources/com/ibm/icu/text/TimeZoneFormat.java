package com.ibm.icu.text;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.TZDBTimeZoneNames;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.impl.TimeZoneGenericNames;
import com.ibm.icu.impl.TimeZoneNamesImpl;
import com.ibm.icu.impl.ZoneMeta;
import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.dk0;
import defpackage.kf2;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TimeZoneFormat extends UFormat implements Freezable<TimeZoneFormat>, Serializable, Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ASCII_DIGITS = "0123456789";
    private static final char DEFAULT_GMT_OFFSET_SEP = ':';
    private static final String DEFAULT_GMT_PATTERN = "GMT{0}";
    private static final String ISO8601_UTC = "Z";
    private static final int ISO_LOCAL_STYLE_FLAG = 256;
    private static final int ISO_Z_STYLE_FLAG = 128;
    private static final int MAX_OFFSET = 86400000;
    private static final int MAX_OFFSET_HOUR = 23;
    private static final int MAX_OFFSET_MINUTE = 59;
    private static final int MAX_OFFSET_SECOND = 59;
    private static final int MILLIS_PER_HOUR = 3600000;
    private static final int MILLIS_PER_MINUTE = 60000;
    private static final int MILLIS_PER_SECOND = 1000;
    private static volatile TextTrieMap<String> SHORT_ZONE_ID_TRIE = null;
    private static final String TZID_GMT = "Etc/GMT";
    private static final String UNKNOWN_LOCATION = "Unknown";
    private static final int UNKNOWN_OFFSET = Integer.MAX_VALUE;
    private static final String UNKNOWN_SHORT_ZONE_ID = "unk";
    private static final String UNKNOWN_ZONE_ID = "Etc/Unknown";
    private static volatile TextTrieMap<String> ZONE_ID_TRIE = null;
    private static final long serialVersionUID = 2281246852693575022L;
    private transient boolean _abuttingOffsetHoursAndMinutes;
    private volatile transient boolean _frozen;
    private String[] _gmtOffsetDigits;
    private transient Object[][] _gmtOffsetPatternItems;
    private String[] _gmtOffsetPatterns;
    private String _gmtPattern;
    private transient String _gmtPatternPrefix;
    private transient String _gmtPatternSuffix;
    private String _gmtZeroFormat;
    private volatile transient TimeZoneGenericNames _gnames;
    private ULocale _locale;
    private boolean _parseAllStyles;
    private boolean _parseTZDBNames;
    private volatile transient String _region;
    private volatile transient TimeZoneNames _tzdbNames;
    private TimeZoneNames _tznames;
    private static final String DEFAULT_GMT_ZERO = "GMT";
    private static final String[] ALT_GMT_STRINGS = {DEFAULT_GMT_ZERO, "UTC", "UT"};
    private static final String[] DEFAULT_GMT_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final GMTOffsetPatternType[] PARSE_GMT_OFFSET_TYPES = {GMTOffsetPatternType.POSITIVE_HMS, GMTOffsetPatternType.NEGATIVE_HMS, GMTOffsetPatternType.POSITIVE_HM, GMTOffsetPatternType.NEGATIVE_HM, GMTOffsetPatternType.POSITIVE_H, GMTOffsetPatternType.NEGATIVE_H};
    private static TimeZoneFormatCache _tzfCache = new TimeZoneFormatCache(0);
    private static final EnumSet<TimeZoneNames.NameType> ALL_SIMPLE_NAME_TYPES = EnumSet.of(TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT, TimeZoneNames.NameType.EXEMPLAR_LOCATION);
    private static final EnumSet<TimeZoneGenericNames.GenericNameType> ALL_GENERIC_NAME_TYPES = EnumSet.of(TimeZoneGenericNames.GenericNameType.LOCATION, TimeZoneGenericNames.GenericNameType.LONG, TimeZoneGenericNames.GenericNameType.SHORT);
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("_locale", ULocale.class), new ObjectStreamField("_tznames", TimeZoneNames.class), new ObjectStreamField("_gmtPattern", String.class), new ObjectStreamField("_gmtOffsetPatterns", String[].class), new ObjectStreamField("_gmtOffsetDigits", String[].class), new ObjectStreamField("_gmtZeroFormat", String.class), new ObjectStreamField("_parseAllStyles", Boolean.TYPE)};

    /* JADX INFO: renamed from: com.ibm.icu.text.TimeZoneFormat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType;

        static {
            int[] iArr = new int[TimeZoneNames.NameType.values().length];
            $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType = iArr;
            try {
                iArr[TimeZoneNames.NameType.LONG_STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.LONG_DAYLIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_DAYLIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Style.values().length];
            $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style = iArr2;
            try {
                iArr2[Style.GENERIC_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.GENERIC_LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.GENERIC_SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.SPECIFIC_LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.SPECIFIC_SHORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ZONE_ID.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ZONE_ID_SHORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.EXEMPLAR_LOCATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.LOCALIZED_GMT.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.LOCALIZED_GMT_SHORT.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_SHORT.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_LOCAL_SHORT.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_FIXED.ordinal()] = 13;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_LOCAL_FIXED.ordinal()] = 14;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_FULL.ordinal()] = 15;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_LOCAL_FULL.ordinal()] = 16;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_EXTENDED_FIXED.ordinal()] = 17;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_EXTENDED_LOCAL_FIXED.ordinal()] = 18;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_EXTENDED_FULL.ordinal()] = 19;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_EXTENDED_LOCAL_FULL.ordinal()] = 20;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class GMTOffsetField {
        final char _type;
        final int _width;

        public GMTOffsetField(char c, int i) {
            this._type = c;
            this._width = i;
        }

        public static boolean isValid(char c, int i) {
            return i == 1 || i == 2;
        }

        public char getType() {
            return this._type;
        }

        public int getWidth() {
            return this._width;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum GMTOffsetPatternType {
        POSITIVE_HM("+H:mm", DateFormat.HOUR24_MINUTE, true),
        POSITIVE_HMS("+H:mm:ss", DateFormat.HOUR24_MINUTE_SECOND, true),
        NEGATIVE_HM("-H:mm", DateFormat.HOUR24_MINUTE, false),
        NEGATIVE_HMS("-H:mm:ss", DateFormat.HOUR24_MINUTE_SECOND, false),
        POSITIVE_H("+H", DateFormat.HOUR24, true),
        NEGATIVE_H("-H", DateFormat.HOUR24, false);

        private String _defaultPattern;
        private boolean _isPositive;
        private String _required;

        GMTOffsetPatternType(String str, String str2, boolean z) {
            this._defaultPattern = str;
            this._required = str2;
            this._isPositive = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String defaultPattern() {
            return this._defaultPattern;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isPositive() {
            return this._isPositive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String required() {
            return this._required;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum OffsetFields {
        H,
        HM,
        HMS
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ParseOption {
        ALL_STYLES,
        TZ_DATABASE_ABBREVIATIONS
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Style {
        GENERIC_LOCATION(1),
        GENERIC_LONG(2),
        GENERIC_SHORT(4),
        SPECIFIC_LONG(8),
        SPECIFIC_SHORT(16),
        LOCALIZED_GMT(32),
        LOCALIZED_GMT_SHORT(64),
        ISO_BASIC_SHORT(128),
        ISO_BASIC_LOCAL_SHORT(256),
        ISO_BASIC_FIXED(128),
        ISO_BASIC_LOCAL_FIXED(256),
        ISO_BASIC_FULL(128),
        ISO_BASIC_LOCAL_FULL(256),
        ISO_EXTENDED_FIXED(128),
        ISO_EXTENDED_LOCAL_FIXED(256),
        ISO_EXTENDED_FULL(128),
        ISO_EXTENDED_LOCAL_FULL(256),
        ZONE_ID(512),
        ZONE_ID_SHORT(1024),
        EXEMPLAR_LOCATION(2048);

        final int flag;

        Style(int i) {
            this.flag = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum TimeType {
        UNKNOWN,
        STANDARD,
        DAYLIGHT
    }

    public TimeZoneFormat(ULocale uLocale) {
        String str;
        String stringWithFallback;
        this._locale = uLocale;
        this._tznames = TimeZoneNames.getInstance(uLocale);
        this._gmtZeroFormat = DEFAULT_GMT_ZERO;
        String stringWithFallback2 = null;
        try {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_ZONE_BASE_NAME, uLocale);
            try {
                stringWithFallback = iCUResourceBundle.getStringWithFallback("zoneStrings/gmtFormat");
            } catch (MissingResourceException unused) {
                stringWithFallback = null;
            }
            try {
                stringWithFallback2 = iCUResourceBundle.getStringWithFallback("zoneStrings/hourFormat");
            } catch (MissingResourceException unused2) {
            }
            try {
                this._gmtZeroFormat = iCUResourceBundle.getStringWithFallback("zoneStrings/gmtZeroFormat");
            } catch (MissingResourceException unused3) {
            }
            str = stringWithFallback2;
            stringWithFallback2 = stringWithFallback;
        } catch (MissingResourceException unused4) {
            str = null;
        }
        initGMTPattern(stringWithFallback2 == null ? DEFAULT_GMT_PATTERN : stringWithFallback2);
        String[] strArr = new String[GMTOffsetPatternType.values().length];
        if (str != null) {
            String[] strArrSplit = str.split(";", 2);
            strArr[GMTOffsetPatternType.POSITIVE_H.ordinal()] = truncateOffsetPattern(strArrSplit[0]);
            strArr[GMTOffsetPatternType.POSITIVE_HM.ordinal()] = strArrSplit[0];
            strArr[GMTOffsetPatternType.POSITIVE_HMS.ordinal()] = expandOffsetPattern(strArrSplit[0]);
            strArr[GMTOffsetPatternType.NEGATIVE_H.ordinal()] = truncateOffsetPattern(strArrSplit[1]);
            strArr[GMTOffsetPatternType.NEGATIVE_HM.ordinal()] = strArrSplit[1];
            strArr[GMTOffsetPatternType.NEGATIVE_HMS.ordinal()] = expandOffsetPattern(strArrSplit[1]);
        } else {
            for (GMTOffsetPatternType gMTOffsetPatternType : GMTOffsetPatternType.values()) {
                strArr[gMTOffsetPatternType.ordinal()] = gMTOffsetPatternType.defaultPattern();
            }
        }
        initGMTOffsetPatterns(strArr);
        this._gmtOffsetDigits = DEFAULT_GMT_DIGITS;
        NumberingSystem numberingSystem = NumberingSystem.getInstance(uLocale);
        if (numberingSystem.isAlgorithmic()) {
            return;
        }
        this._gmtOffsetDigits = toCodePoints(numberingSystem.getDescription());
    }

    private void appendOffsetDigits(StringBuilder sb, int i, int i2) {
        int i3 = i >= 10 ? 2 : 1;
        for (int i4 = 0; i4 < i2 - i3; i4++) {
            sb.append(this._gmtOffsetDigits[0]);
        }
        if (i3 == 2) {
            sb.append(this._gmtOffsetDigits[i / 10]);
        }
        sb.append(this._gmtOffsetDigits[i % 10]);
    }

    private void checkAbuttingHoursAndMinutes() {
        this._abuttingOffsetHoursAndMinutes = false;
        for (Object[] objArr : this._gmtOffsetPatternItems) {
            boolean z = false;
            for (Object obj : objArr) {
                if (!(obj instanceof GMTOffsetField)) {
                    if (z) {
                        break;
                    }
                } else {
                    GMTOffsetField gMTOffsetField = (GMTOffsetField) obj;
                    if (z) {
                        this._abuttingOffsetHoursAndMinutes = true;
                    } else if (gMTOffsetField.getType() == 'H') {
                        z = true;
                    }
                }
            }
        }
    }

    private static String expandOffsetPattern(String str) {
        int iIndexOf = str.indexOf("mm");
        if (iIndexOf < 0) {
            og.p("Bad time zone hour pattern data");
            return null;
        }
        int iLastIndexOf = str.substring(0, iIndexOf).lastIndexOf(DateFormat.HOUR24);
        String strSubstring = iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1, iIndexOf) : ":";
        int i = iIndexOf + 2;
        return ky0.k(str.substring(0, i), strSubstring, "ss", str.substring(i));
    }

    private String formatExemplarLocation(TimeZone timeZone) {
        String exemplarLocationName = getTimeZoneNames().getExemplarLocationName(ZoneMeta.getCanonicalCLDRID(timeZone));
        if (exemplarLocationName != null) {
            return exemplarLocationName;
        }
        String exemplarLocationName2 = getTimeZoneNames().getExemplarLocationName("Etc/Unknown");
        return exemplarLocationName2 == null ? UNKNOWN_LOCATION : exemplarLocationName2;
    }

    private String formatOffsetISO8601(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        char c;
        int i2 = i < 0 ? -i : i;
        if (z2) {
            if (i2 < 1000) {
                return ISO8601_UTC;
            }
            if (z4 && i2 < 60000) {
                return ISO8601_UTC;
            }
        }
        OffsetFields offsetFields = z3 ? OffsetFields.H : OffsetFields.HM;
        OffsetFields offsetFields2 = z4 ? OffsetFields.HM : OffsetFields.HMS;
        Character chValueOf = z ? null : Character.valueOf(DEFAULT_GMT_OFFSET_SEP);
        if (i2 >= 86400000) {
            og.i(ky0.h(i, "Offset out of range :"));
            return null;
        }
        int i3 = i2 / 3600000;
        int i4 = i2 % 3600000;
        int[] iArr = {i3, i4 / 60000, (i4 % 60000) / 1000};
        int iOrdinal = offsetFields2.ordinal();
        while (iOrdinal > offsetFields.ordinal() && iArr[iOrdinal] == 0) {
            iOrdinal--;
        }
        StringBuilder sb = new StringBuilder();
        if (i >= 0) {
            c = '+';
            break;
        }
        int i5 = 0;
        while (true) {
            if (i5 > iOrdinal) {
                c = '+';
                break;
            }
            if (iArr[i5] != 0) {
                c = '-';
                break;
            }
            i5++;
        }
        sb.append(c);
        for (int i6 = 0; i6 <= iOrdinal; i6++) {
            if (chValueOf != null && i6 != 0) {
                sb.append(chValueOf);
            }
            if (iArr[i6] < 10) {
                sb.append('0');
            }
            sb.append(iArr[i6]);
        }
        return sb.toString();
    }

    private String formatOffsetLocalizedGMT(int i, boolean z) {
        boolean z2;
        Object[] objArr;
        StringBuilder sb = new StringBuilder();
        if (i < 0) {
            i = -i;
            z2 = false;
        } else {
            z2 = true;
        }
        int i2 = i / 3600000;
        int i3 = i % 3600000;
        int i4 = i3 / 60000;
        int i5 = i3 % 60000;
        int i6 = i5 / 1000;
        if (i2 > 23 || i4 > 59 || i6 > 59) {
            og.i(ky0.h(i5, "Offset out of range :"));
            return null;
        }
        if (z2) {
            objArr = i6 != 0 ? this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_HMS.ordinal()] : (i4 == 0 && z) ? this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_H.ordinal()] : this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_HM.ordinal()];
        } else if (i6 != 0) {
            objArr = this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_HMS.ordinal()];
        } else {
            objArr = (i4 == 0 && z) ? this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_H.ordinal()] : this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_HM.ordinal()];
        }
        sb.append(this._gmtPatternPrefix);
        for (Object obj : objArr) {
            if (obj instanceof String) {
                sb.append((String) obj);
            } else if (obj instanceof GMTOffsetField) {
                char type = ((GMTOffsetField) obj).getType();
                if (type == 'H') {
                    appendOffsetDigits(sb, i2, z ? 1 : 2);
                } else if (type == 'm') {
                    appendOffsetDigits(sb, i4, 2);
                } else if (type == 's') {
                    appendOffsetDigits(sb, i6, 2);
                }
            }
        }
        sb.append(this._gmtPatternSuffix);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String formatSpecific(TimeZone timeZone, TimeZoneNames.NameType nameType, TimeZoneNames.NameType nameType2, long j, Output<TimeType> output) {
        boolean zInDaylightTime = timeZone.inDaylightTime(new Date(j));
        String displayName = zInDaylightTime ? getTimeZoneNames().getDisplayName(ZoneMeta.getCanonicalCLDRID(timeZone), nameType2, j) : getTimeZoneNames().getDisplayName(ZoneMeta.getCanonicalCLDRID(timeZone), nameType, j);
        if (displayName != null && output != null) {
            output.value = zInDaylightTime ? TimeType.DAYLIGHT : TimeType.STANDARD;
        }
        return displayName;
    }

    public static TimeZoneFormat getInstance(ULocale uLocale) {
        if (uLocale != null) {
            return _tzfCache.getInstance(uLocale, uLocale);
        }
        dk0.n("locale is null");
        return null;
    }

    private TimeZoneNames getTZDBTimeZoneNames() {
        if (this._tzdbNames == null) {
            synchronized (this) {
                try {
                    if (this._tzdbNames == null) {
                        this._tzdbNames = new TZDBTimeZoneNames(this._locale);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this._tzdbNames;
    }

    private String getTargetRegion() {
        if (this._region == null) {
            synchronized (this) {
                try {
                    if (this._region == null) {
                        String country = this._locale.getCountry();
                        if (country.length() == 0) {
                            country = ULocale.addLikelySubtags(this._locale).getCountry();
                            if (country.length() == 0) {
                                country = UnitsData.Constants.DEFAULT_REGION;
                            }
                        }
                        this._region = country;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this._region;
    }

    private TimeType getTimeType(TimeZoneNames.NameType nameType) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[nameType.ordinal()];
        if (i == 1 || i == 2) {
            return TimeType.STANDARD;
        }
        return (i == 3 || i == 4) ? TimeType.DAYLIGHT : TimeType.UNKNOWN;
    }

    private TimeZone getTimeZoneForOffset(int i) {
        return i == 0 ? TimeZone.getTimeZone(TZID_GMT) : ZoneMeta.getCustomTimeZone(i);
    }

    private TimeZoneGenericNames getTimeZoneGenericNames() {
        if (this._gnames == null) {
            synchronized (this) {
                try {
                    if (this._gnames == null) {
                        this._gnames = TimeZoneGenericNames.getInstance(this._locale);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this._gnames;
    }

    private String getTimeZoneID(String str, String str2) {
        if (str != null) {
            return str;
        }
        String referenceZoneID = this._tznames.getReferenceZoneID(str2, getTargetRegion());
        if (referenceZoneID != null) {
            return referenceZoneID;
        }
        og.i(cq.j("Invalid mzID: ", str2));
        return null;
    }

    private void initGMTOffsetPatterns(String[] strArr) {
        int length = GMTOffsetPatternType.values().length;
        if (strArr.length < length) {
            og.i("Insufficient number of elements in gmtOffsetPatterns");
            return;
        }
        Object[][] objArr = new Object[length][];
        for (GMTOffsetPatternType gMTOffsetPatternType : GMTOffsetPatternType.values()) {
            int iOrdinal = gMTOffsetPatternType.ordinal();
            objArr[iOrdinal] = parseOffsetPattern(strArr[iOrdinal], gMTOffsetPatternType.required());
        }
        String[] strArr2 = new String[length];
        this._gmtOffsetPatterns = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, length);
        this._gmtOffsetPatternItems = objArr;
        checkAbuttingHoursAndMinutes();
    }

    private void initGMTPattern(String str) {
        int iIndexOf = str.indexOf("{0}");
        if (iIndexOf < 0) {
            og.i("Bad localized GMT pattern: ".concat(str));
            return;
        }
        this._gmtPattern = str;
        this._gmtPatternPrefix = unquote(str.substring(0, iIndexOf));
        this._gmtPatternSuffix = unquote(str.substring(iIndexOf + 3));
    }

    private static int parseAbuttingAsciiOffsetFields(String str, ParsePosition parsePosition, OffsetFields offsetFields, OffsetFields offsetFields2, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int index = parsePosition.getIndex();
        boolean z2 = true;
        int iOrdinal = ((offsetFields.ordinal() + 1) * 2) - (!z ? 1 : 0);
        int iOrdinal2 = (offsetFields2.ordinal() + 1) * 2;
        int[] iArr = new int[iOrdinal2];
        int i6 = 0;
        for (int i7 = index; i6 < iOrdinal2 && i7 < str.length(); i7++) {
            int iIndexOf = ASCII_DIGITS.indexOf(str.charAt(i7));
            if (iIndexOf < 0) {
                break;
            }
            iArr[i6] = iIndexOf;
            i6++;
        }
        if (z && (i6 & 1) != 0) {
            i6--;
        }
        if (i6 < iOrdinal) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        while (true) {
            if (i6 >= iOrdinal) {
                switch (i6) {
                    case 1:
                        i2 = iArr[0];
                        i = 0;
                        i3 = 0;
                        break;
                    case 2:
                        i2 = (iArr[0] * 10) + iArr[1];
                        i = 0;
                        i3 = 0;
                        break;
                    case 3:
                        i2 = iArr[0];
                        i4 = iArr[1] * 10;
                        i5 = iArr[2];
                        i3 = i4 + i5;
                        i = 0;
                        break;
                    case 4:
                        i2 = iArr[1] + (iArr[0] * 10);
                        i4 = iArr[2] * 10;
                        i5 = iArr[3];
                        i3 = i4 + i5;
                        i = 0;
                        break;
                    case 5:
                        i2 = iArr[0];
                        i3 = (iArr[1] * 10) + iArr[2];
                        i = iArr[4] + (iArr[3] * 10);
                        break;
                    case 6:
                        i2 = (iArr[0] * 10) + iArr[1];
                        i3 = (iArr[2] * 10) + iArr[3];
                        i = (iArr[4] * 10) + iArr[5];
                        break;
                    default:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        break;
                }
                if (i2 > 23 || i3 > 59 || i > 59) {
                    i6 -= z ? 2 : 1;
                }
            } else {
                i = 0;
                z2 = false;
                i2 = 0;
                i3 = 0;
            }
        }
        if (z2) {
            parsePosition.setIndex(index + i6);
            return ((((i2 * 60) + i3) * 60) + i) * 1000;
        }
        parsePosition.setErrorIndex(index);
        return 0;
    }

    private int parseAbuttingOffsetFields(String str, int i, int[] iArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr2 = new int[6];
        int[] iArr3 = new int[6];
        int[] iArr4 = {0};
        int i7 = i;
        int i8 = 0;
        for (int i9 = 0; i9 < 6; i9++) {
            int singleLocalizedDigit = parseSingleLocalizedDigit(str, i7, iArr4);
            iArr2[i9] = singleLocalizedDigit;
            if (singleLocalizedDigit < 0) {
                break;
            }
            i7 += iArr4[0];
            iArr3[i9] = i7 - i;
            i8++;
        }
        if (i8 == 0) {
            iArr[0] = 0;
            return 0;
        }
        while (i8 > 0) {
            switch (i8) {
                case 1:
                    i2 = iArr2[0];
                    i3 = 0;
                    i4 = 0;
                    break;
                case 2:
                    i2 = (iArr2[0] * 10) + iArr2[1];
                    i3 = 0;
                    i4 = 0;
                    break;
                case 3:
                    i2 = iArr2[0];
                    i5 = iArr2[1] * 10;
                    i6 = iArr2[2];
                    i4 = i5 + i6;
                    i3 = 0;
                    break;
                case 4:
                    i2 = iArr2[1] + (iArr2[0] * 10);
                    i5 = iArr2[2] * 10;
                    i6 = iArr2[3];
                    i4 = i5 + i6;
                    i3 = 0;
                    break;
                case 5:
                    i2 = iArr2[0];
                    i4 = iArr2[2] + (iArr2[1] * 10);
                    i3 = iArr2[4] + (iArr2[3] * 10);
                    break;
                case 6:
                    i2 = (iArr2[0] * 10) + iArr2[1];
                    i4 = (iArr2[2] * 10) + iArr2[3];
                    i3 = (iArr2[4] * 10) + iArr2[5];
                    break;
                default:
                    i3 = 0;
                    i4 = 0;
                    i2 = 0;
                    break;
            }
            if (i2 <= 23 && i4 <= 59 && i3 <= 59) {
                int i10 = (i3 * 1000) + (i4 * 60000) + (i2 * 3600000);
                iArr[0] = iArr3[i8 - 1];
                return i10;
            }
            i8--;
        }
        return 0;
    }

    private static int parseAsciiOffsetFields(String str, ParsePosition parsePosition, char c, OffsetFields offsetFields, OffsetFields offsetFields2) {
        int i;
        OffsetFields offsetFields3;
        int i2;
        int i3;
        int iIndexOf;
        int index = parsePosition.getIndex();
        int[] iArr = new int[3];
        iArr[0] = 0;
        int i4 = 1;
        iArr[1] = 0;
        iArr[2] = 0;
        int[] iArr2 = new int[3];
        iArr2[0] = 0;
        iArr2[1] = -1;
        iArr2[2] = -1;
        int i5 = 0;
        for (int i6 = index; i6 < str.length() && i5 <= offsetFields2.ordinal(); i6++) {
            char cCharAt = str.charAt(i6);
            if (cCharAt != c) {
                if (iArr2[i5] == -1 || (iIndexOf = ASCII_DIGITS.indexOf(cCharAt)) < 0) {
                    break;
                }
                iArr[i5] = (iArr[i5] * 10) + iIndexOf;
                int i7 = iArr2[i5] + 1;
                iArr2[i5] = i7;
                if (i7 >= 2) {
                    i5++;
                }
            } else if (i5 == 0) {
                if (iArr2[0] == 0) {
                    break;
                }
                i5++;
            } else {
                if (iArr2[i5] != -1) {
                    break;
                }
                iArr2[i5] = 0;
            }
        }
        int i8 = iArr2[0];
        if (i8 == 0) {
            offsetFields3 = null;
            i = 0;
            i4 = 0;
        } else {
            int i9 = iArr[0];
            if (i9 > 23) {
                i = (i9 / 10) * 3600000;
                offsetFields3 = OffsetFields.H;
            } else {
                i = i9 * 3600000;
                OffsetFields offsetFields4 = OffsetFields.H;
                int i10 = iArr2[1];
                if (i10 != 2 || (i2 = iArr[1]) > 59) {
                    i4 = i8;
                    offsetFields3 = offsetFields4;
                } else {
                    i += i2 * 60000;
                    int i11 = i10 + 1 + i8;
                    offsetFields3 = OffsetFields.HM;
                    int i12 = iArr2[2];
                    if (i12 != 2 || (i3 = iArr[2]) > 59) {
                        i4 = i11;
                    } else {
                        i += i3 * 1000;
                        i4 = i12 + 1 + i11;
                        offsetFields3 = OffsetFields.HMS;
                    }
                }
            }
        }
        if (offsetFields3 == null || offsetFields3.ordinal() < offsetFields.ordinal()) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        parsePosition.setIndex(index + i4);
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    private int parseDefaultOffsetFields(String str, int i, char c, int[] iArr) {
        int i2;
        int offsetFieldWithLocalizedDigits;
        int i3;
        int offsetFieldWithLocalizedDigits2;
        int length = str.length();
        int[] iArr2 = {0};
        int offsetFieldWithLocalizedDigits3 = parseOffsetFieldWithLocalizedDigits(str, i, 1, 2, 0, 23, iArr2);
        int i4 = iArr2[0];
        if (i4 != 0) {
            i2 = i4 + i;
            int i5 = i2 + 1;
            if (i5 < length && str.charAt(i2) == c) {
                offsetFieldWithLocalizedDigits = parseOffsetFieldWithLocalizedDigits(str, i5, 2, 2, 0, 59, iArr2);
                int i6 = iArr2[0];
                if (i6 != 0 && (i3 = (i2 = i2 + i6 + 1) + 1) < length && str.charAt(i2) == c) {
                    offsetFieldWithLocalizedDigits2 = parseOffsetFieldWithLocalizedDigits(str, i3, 2, 2, 0, 59, iArr2);
                    int i7 = iArr2[0];
                    if (i7 != 0) {
                        i2 += i7 + 1;
                    }
                } else {
                    offsetFieldWithLocalizedDigits2 = 0;
                }
            }
            if (i2 == i) {
                iArr[0] = 0;
                return 0;
            }
            iArr[0] = i2 - i;
            return (offsetFieldWithLocalizedDigits2 * 1000) + (offsetFieldWithLocalizedDigits * 60000) + (offsetFieldWithLocalizedDigits3 * 3600000);
        }
        i2 = i;
        offsetFieldWithLocalizedDigits2 = 0;
        offsetFieldWithLocalizedDigits = 0;
        if (i2 == i) {
            iArr[0] = 0;
            return 0;
        }
        iArr[0] = i2 - i;
        return (offsetFieldWithLocalizedDigits2 * 1000) + (offsetFieldWithLocalizedDigits * 60000) + (offsetFieldWithLocalizedDigits3 * 3600000);
    }

    private String parseExemplarLocation(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        Collection<TimeZoneNames.MatchInfo> collectionFind = this._tznames.find(str, index, EnumSet.of(TimeZoneNames.NameType.EXEMPLAR_LOCATION));
        String timeZoneID = null;
        if (collectionFind != null) {
            int iMatchLength = -1;
            TimeZoneNames.MatchInfo matchInfo = null;
            for (TimeZoneNames.MatchInfo matchInfo2 : collectionFind) {
                if (matchInfo2.matchLength() + index > iMatchLength) {
                    iMatchLength = matchInfo2.matchLength() + index;
                    matchInfo = matchInfo2;
                }
            }
            if (matchInfo != null) {
                timeZoneID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                parsePosition.setIndex(iMatchLength);
            }
        }
        if (timeZoneID == null) {
            parsePosition.setErrorIndex(index);
        }
        return timeZoneID;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006b  */
    private int parseOffsetDefaultLocalizedGMT(String str, int i, int[] iArr) {
        String str2;
        int i2;
        int length;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String[] strArr = ALT_GMT_STRINGS;
        int length2 = strArr.length;
        int i9 = 0;
        while (true) {
            if (i9 >= length2) {
                str2 = str;
                i2 = i;
                length = 0;
                break;
            }
            String str3 = strArr[i9];
            length = str3.length();
            str2 = str;
            i2 = i;
            if (str2.regionMatches(true, i2, str3, 0, length)) {
                break;
            }
            i9++;
            str = str2;
            i = i2;
        }
        if (length != 0 && (i6 = (i5 = i2 + length) + 1) < str2.length()) {
            char cCharAt = str2.charAt(i5);
            if (cCharAt == '+') {
                i7 = 1;
            } else if (cCharAt == '-') {
                i7 = -1;
            } else {
                i3 = 0;
                i4 = 0;
            }
            int[] iArr2 = {0};
            int defaultOffsetFields = parseDefaultOffsetFields(str2, i6, DEFAULT_GMT_OFFSET_SEP, iArr2);
            if (iArr2[0] == str2.length() - i6) {
                i4 = defaultOffsetFields * i7;
                i8 = i6 + iArr2[0];
            } else {
                int[] iArr3 = {0};
                int abuttingOffsetFields = parseAbuttingOffsetFields(str2, i6, iArr3);
                int i10 = iArr2[0];
                int i11 = iArr3[0];
                if (i10 > i11) {
                    i4 = defaultOffsetFields * i7;
                    i8 = i6 + i10;
                } else {
                    i4 = abuttingOffsetFields * i7;
                    i8 = i6 + i11;
                }
            }
            i3 = i8 - i2;
        } else {
            i3 = 0;
            i4 = 0;
        }
        iArr[0] = i3;
        return i4;
    }

    private int parseOffsetFieldWithLocalizedDigits(String str, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int singleLocalizedDigit;
        int i6;
        iArr[0] = 0;
        int[] iArr2 = {0};
        int i7 = i;
        int i8 = 0;
        int i9 = 0;
        while (i7 < str.length() && i8 < i3 && (singleLocalizedDigit = parseSingleLocalizedDigit(str, i7, iArr2)) >= 0 && (i6 = (i9 * 10) + singleLocalizedDigit) <= i5) {
            i8++;
            i7 += iArr2[0];
            i9 = i6;
        }
        if (i8 < i2 || i9 < i4) {
            return -1;
        }
        iArr[0] = i7 - i;
        return i9;
    }

    private int parseOffsetFields(String str, int i, boolean z, int[] iArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TimeZoneFormat timeZoneFormat = this;
        if (iArr != null && iArr.length >= 1) {
            iArr[0] = 0;
        }
        int[] iArr2 = {0, 0, 0};
        GMTOffsetPatternType[] gMTOffsetPatternTypeArr = PARSE_GMT_OFFSET_TYPES;
        int length = gMTOffsetPatternTypeArr.length;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i2 = -1;
            if (i9 >= length) {
                i3 = i8;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 1;
                break;
            }
            GMTOffsetPatternType gMTOffsetPatternType = gMTOffsetPatternTypeArr[i9];
            int offsetFieldsWithPattern = timeZoneFormat.parseOffsetFieldsWithPattern(str, i, timeZoneFormat._gmtOffsetPatternItems[gMTOffsetPatternType.ordinal()], false, iArr2);
            if (offsetFieldsWithPattern > 0) {
                i7 = gMTOffsetPatternType.isPositive() ? 1 : -1;
                i4 = iArr2[0];
                i5 = iArr2[1];
                i6 = iArr2[2];
                i3 = offsetFieldsWithPattern;
                break;
            }
            i9++;
            i8 = offsetFieldsWithPattern;
        }
        if (i3 > 0 && timeZoneFormat._abuttingOffsetHoursAndMinutes) {
            GMTOffsetPatternType[] gMTOffsetPatternTypeArr2 = PARSE_GMT_OFFSET_TYPES;
            int length2 = gMTOffsetPatternTypeArr2.length;
            int i10 = 0;
            int offsetFieldsWithPattern2 = 0;
            while (true) {
                if (i10 < length2) {
                    GMTOffsetPatternType gMTOffsetPatternType2 = gMTOffsetPatternTypeArr2[i10];
                    int i11 = i10;
                    int i12 = length2;
                    GMTOffsetPatternType[] gMTOffsetPatternTypeArr3 = gMTOffsetPatternTypeArr2;
                    offsetFieldsWithPattern2 = timeZoneFormat.parseOffsetFieldsWithPattern(str, i, timeZoneFormat._gmtOffsetPatternItems[gMTOffsetPatternType2.ordinal()], true, iArr2);
                    if (offsetFieldsWithPattern2 > 0) {
                        if (!gMTOffsetPatternType2.isPositive()) {
                            break;
                        }
                        break;
                    }
                    i10 = i11 + 1;
                    timeZoneFormat = this;
                    gMTOffsetPatternTypeArr2 = gMTOffsetPatternTypeArr3;
                    length2 = i12;
                }
                i2 = 1;
                break;
            }
            if (offsetFieldsWithPattern2 > i3) {
                i4 = iArr2[0];
                i5 = iArr2[1];
                i6 = iArr2[2];
                i3 = offsetFieldsWithPattern2;
                i7 = i2;
            }
        }
        if (iArr != null && iArr.length >= 1) {
            iArr[0] = i3;
        }
        if (i3 > 0) {
            return ((((i4 * 60) + i5) * 60) + i6) * 1000 * i7;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:48:0x005c A[SYNTHETIC] */
    private int parseOffsetFieldsWithPattern(String str, int i, Object[] objArr, boolean z, int[] iArr) {
        boolean z2;
        int i2;
        int i3;
        iArr[2] = 0;
        iArr[1] = 0;
        iArr[0] = 0;
        int[] iArr2 = {0};
        int i4 = i;
        int i5 = 0;
        int offsetFieldWithLocalizedDigits = 0;
        int offsetFieldWithLocalizedDigits2 = 0;
        int offsetFieldWithLocalizedDigits3 = 0;
        while (true) {
            if (i5 >= objArr.length) {
                z2 = false;
                break;
            }
            Object obj = objArr[i5];
            if (obj instanceof String) {
                String str2 = (String) obj;
                int length = str2.length();
                if (i5 == 0 && i4 < str.length()) {
                    if (!PatternProps.isWhiteSpace(str.codePointAt(i4))) {
                        i2 = 0;
                        while (length > 0) {
                            int iCodePointAt = str2.codePointAt(i2);
                            if (!PatternProps.isWhiteSpace(iCodePointAt)) {
                                break;
                            }
                            int iCharCount = Character.charCount(iCodePointAt);
                            length -= iCharCount;
                            i2 += iCharCount;
                        }
                    }
                    i3 = length;
                    if (!str.regionMatches(true, i4, str2, i2, i3)) {
                        z2 = true;
                        break;
                    }
                    i4 += i3;
                    i5++;
                }
                i2 = 0;
                i3 = length;
                if (!str.regionMatches(true, i4, str2, i2, i3)) {
                    z2 = true;
                    break;
                }
                i4 += i3;
                i5++;
            } else {
                char type = ((GMTOffsetField) obj).getType();
                if (type == 'H') {
                    offsetFieldWithLocalizedDigits = parseOffsetFieldWithLocalizedDigits(str, i4, 1, z ? 1 : 2, 0, 23, iArr2);
                } else if (type == 'm') {
                    offsetFieldWithLocalizedDigits2 = parseOffsetFieldWithLocalizedDigits(str, i4, 2, 2, 0, 59, iArr2);
                } else if (type == 's') {
                    offsetFieldWithLocalizedDigits3 = parseOffsetFieldWithLocalizedDigits(str, i4, 2, 2, 0, 59, iArr2);
                }
                int i6 = iArr2[0];
                if (i6 == 0) {
                    z2 = true;
                    break;
                }
                i4 += i6;
                i5++;
            }
        }
        if (z2) {
            return 0;
        }
        iArr[0] = offsetFieldWithLocalizedDigits;
        iArr[1] = offsetFieldWithLocalizedDigits2;
        iArr[2] = offsetFieldWithLocalizedDigits3;
        return i4 - i;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.Boolean] */
    private static int parseOffsetISO8601(String str, ParsePosition parsePosition, boolean z, Output<Boolean> output) {
        if (output != null) {
            output.value = Boolean.FALSE;
        }
        int index = parsePosition.getIndex();
        if (index >= str.length()) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        char cCharAt = str.charAt(index);
        int i = 1;
        if (Character.toUpperCase(cCharAt) == ISO8601_UTC.charAt(0)) {
            parsePosition.setIndex(index + 1);
            return 0;
        }
        if (cCharAt != '+') {
            if (cCharAt != '-') {
                parsePosition.setErrorIndex(index);
                return 0;
            }
            i = -1;
        }
        int i2 = index + 1;
        ParsePosition parsePosition2 = new ParsePosition(i2);
        OffsetFields offsetFields = OffsetFields.H;
        OffsetFields offsetFields2 = OffsetFields.HMS;
        int asciiOffsetFields = parseAsciiOffsetFields(str, parsePosition2, DEFAULT_GMT_OFFSET_SEP, offsetFields, offsetFields2);
        if (parsePosition2.getErrorIndex() == -1 && !z && parsePosition2.getIndex() - index <= 3) {
            ParsePosition parsePosition3 = new ParsePosition(i2);
            int abuttingAsciiOffsetFields = parseAbuttingAsciiOffsetFields(str, parsePosition3, offsetFields, offsetFields2, false);
            if (parsePosition3.getErrorIndex() == -1 && parsePosition3.getIndex() > parsePosition2.getIndex()) {
                parsePosition2.setIndex(parsePosition3.getIndex());
                asciiOffsetFields = abuttingAsciiOffsetFields;
            }
        }
        if (parsePosition2.getErrorIndex() != -1) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        parsePosition.setIndex(parsePosition2.getIndex());
        if (output != null) {
            output.value = Boolean.TRUE;
        }
        return i * asciiOffsetFields;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r7v7, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r7v8, types: [T, java.lang.Boolean] */
    private int parseOffsetLocalizedGMT(String str, ParsePosition parsePosition, boolean z, Output<Boolean> output) {
        int index = parsePosition.getIndex();
        int[] iArr = {0};
        if (output != null) {
            output.value = Boolean.FALSE;
        }
        int offsetLocalizedGMTPattern = parseOffsetLocalizedGMTPattern(str, index, z, iArr);
        int i = iArr[0];
        if (i > 0) {
            if (output != null) {
                output.value = Boolean.TRUE;
            }
            parsePosition.setIndex(index + i);
            return offsetLocalizedGMTPattern;
        }
        int offsetDefaultLocalizedGMT = parseOffsetDefaultLocalizedGMT(str, index, iArr);
        int i2 = iArr[0];
        if (i2 > 0) {
            if (output != null) {
                output.value = Boolean.TRUE;
            }
            parsePosition.setIndex(index + i2);
            return offsetDefaultLocalizedGMT;
        }
        String str2 = this._gmtZeroFormat;
        if (str.regionMatches(true, index, str2, 0, str2.length())) {
            parsePosition.setIndex(this._gmtZeroFormat.length() + index);
            return 0;
        }
        for (String str3 : ALT_GMT_STRINGS) {
            if (str.regionMatches(true, index, str3, 0, str3.length())) {
                parsePosition.setIndex(str3.length() + index);
                return 0;
            }
        }
        parsePosition.setErrorIndex(index);
        return 0;
    }

    private int parseOffsetLocalizedGMTPattern(String str, int i, boolean z, int[] iArr) {
        int i2;
        boolean z2;
        int offsetFields;
        int length = this._gmtPatternPrefix.length();
        if (length <= 0 || str.regionMatches(true, i, this._gmtPatternPrefix, 0, length)) {
            i2 = i + length;
            z2 = true;
            int[] iArr2 = new int[1];
            offsetFields = parseOffsetFields(str, i2, false, iArr2);
            int i3 = iArr2[0];
            if (i3 == 0) {
                z2 = false;
            } else {
                int i4 = i2 + i3;
                int length2 = this._gmtPatternSuffix.length();
                if (length2 <= 0 || str.regionMatches(true, i4, this._gmtPatternSuffix, 0, length2)) {
                    i2 = i4 + length2;
                } else {
                    z2 = false;
                    i2 = i4;
                }
            }
        } else {
            i2 = i;
            z2 = false;
            offsetFields = 0;
        }
        iArr[0] = z2 ? i2 - i : 0;
        return offsetFields;
    }

    private static Object[] parseOffsetPattern(String str, String str2) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        BitSet bitSet = new BitSet(str2.length());
        boolean z2 = true;
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        char c = 0;
        int i2 = 1;
        while (true) {
            if (i >= str.length()) {
                z = false;
                break;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '\'') {
                if (z4) {
                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                    z4 = false;
                } else {
                    if (c != 0) {
                        if (!GMTOffsetField.isValid(c, i2)) {
                            z = true;
                            break;
                        }
                        arrayList.add(new GMTOffsetField(c, i2));
                        c = 0;
                    }
                    z4 = true;
                }
                z3 = !z3;
                i++;
            } else {
                if (z3) {
                    sb.append(cCharAt);
                } else {
                    int iIndexOf = str2.indexOf(cCharAt);
                    if (iIndexOf >= 0) {
                        if (cCharAt == c) {
                            i2++;
                        } else {
                            if (c != 0) {
                                if (!GMTOffsetField.isValid(c, i2)) {
                                    z = true;
                                    break;
                                }
                                arrayList.add(new GMTOffsetField(c, i2));
                            } else if (sb.length() > 0) {
                                arrayList.add(sb.toString());
                                sb.setLength(0);
                            }
                            bitSet.set(iIndexOf);
                            z4 = false;
                            i2 = 1;
                            c = cCharAt;
                        }
                        i++;
                    } else {
                        if (c != 0) {
                            if (!GMTOffsetField.isValid(c, i2)) {
                                z = true;
                                break;
                            }
                            arrayList.add(new GMTOffsetField(c, i2));
                            c = 0;
                        }
                        sb.append(cCharAt);
                    }
                }
                z4 = false;
                i++;
            }
        }
        if (z) {
            z2 = z;
        } else {
            if (c == 0) {
                if (sb.length() > 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
            } else if (GMTOffsetField.isValid(c, i2)) {
                arrayList.add(new GMTOffsetField(c, i2));
            }
            z2 = z;
        }
        if (!z2 && bitSet.cardinality() == str2.length()) {
            return arrayList.toArray(new Object[arrayList.size()]);
        }
        og.n("Bad localized GMT offset pattern: ".concat(str));
        return null;
    }

    private static String parseShortZoneID(String str, ParsePosition parsePosition) {
        if (SHORT_ZONE_ID_TRIE == null) {
            synchronized (TimeZoneFormat.class) {
                try {
                    if (SHORT_ZONE_ID_TRIE == null) {
                        TextTrieMap<String> textTrieMap = new TextTrieMap<>(true);
                        for (String str2 : TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL, null, null)) {
                            String shortID = ZoneMeta.getShortID(str2);
                            if (shortID != null) {
                                textTrieMap.put(shortID, str2);
                            }
                        }
                        textTrieMap.put(UNKNOWN_SHORT_ZONE_ID, "Etc/Unknown");
                        SHORT_ZONE_ID_TRIE = textTrieMap;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        TextTrieMap.Output output = new TextTrieMap.Output();
        Iterator<String> it = SHORT_ZONE_ID_TRIE.get(str, parsePosition.getIndex(), output);
        if (it == null) {
            parsePosition.setErrorIndex(parsePosition.getIndex());
            return null;
        }
        String next = it.next();
        parsePosition.setIndex(parsePosition.getIndex() + output.matchLength);
        return next;
    }

    private int parseSingleLocalizedDigit(String str, int i, int[] iArr) {
        iArr[0] = 0;
        int iDigit = -1;
        if (i < str.length()) {
            int iCodePointAt = Character.codePointAt(str, i);
            int i2 = 0;
            while (true) {
                String[] strArr = this._gmtOffsetDigits;
                if (i2 >= strArr.length) {
                    break;
                }
                if (iCodePointAt == strArr[i2].codePointAt(0)) {
                    iDigit = i2;
                    break;
                }
                i2++;
            }
            if (iDigit < 0) {
                iDigit = UCharacter.digit(iCodePointAt);
            }
            if (iDigit >= 0) {
                iArr[0] = Character.charCount(iCodePointAt);
            }
        }
        return iDigit;
    }

    private static String parseZoneID(String str, ParsePosition parsePosition) {
        if (ZONE_ID_TRIE == null) {
            synchronized (TimeZoneFormat.class) {
                try {
                    if (ZONE_ID_TRIE == null) {
                        TextTrieMap<String> textTrieMap = new TextTrieMap<>(true);
                        for (String str2 : TimeZone.getAvailableIDs()) {
                            textTrieMap.put(str2, str2);
                        }
                        ZONE_ID_TRIE = textTrieMap;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        TextTrieMap.Output output = new TextTrieMap.Output();
        Iterator<String> it = ZONE_ID_TRIE.get(str, parsePosition.getIndex(), output);
        if (it == null) {
            parsePosition.setErrorIndex(parsePosition.getIndex());
            return null;
        }
        String next = it.next();
        parsePosition.setIndex(parsePosition.getIndex() + output.matchLength);
        return next;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        String[] strArr;
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        ULocale uLocale = (ULocale) fields.get("_locale", (Object) null);
        this._locale = uLocale;
        if (uLocale == null) {
            kf2.i("Missing field: locale");
            return;
        }
        TimeZoneNames timeZoneNames = (TimeZoneNames) fields.get("_tznames", (Object) null);
        this._tznames = timeZoneNames;
        if (timeZoneNames == null) {
            kf2.i("Missing field: tznames");
            return;
        }
        String str = (String) fields.get("_gmtPattern", (Object) null);
        this._gmtPattern = str;
        if (str == null) {
            kf2.i("Missing field: gmtPattern");
            return;
        }
        String[] strArr2 = (String[]) fields.get("_gmtOffsetPatterns", (Object) null);
        if (strArr2 == null) {
            kf2.i("Missing field: gmtOffsetPatterns");
            return;
        }
        if (strArr2.length < 4) {
            kf2.i("Incompatible field: gmtOffsetPatterns");
            return;
        }
        this._gmtOffsetPatterns = new String[6];
        if (strArr2.length == 4) {
            int i = 0;
            while (true) {
                strArr = this._gmtOffsetPatterns;
                if (i >= 4) {
                    break;
                }
                strArr[i] = strArr2[i];
                i++;
            }
            strArr[GMTOffsetPatternType.POSITIVE_H.ordinal()] = truncateOffsetPattern(this._gmtOffsetPatterns[GMTOffsetPatternType.POSITIVE_HM.ordinal()]);
            this._gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_H.ordinal()] = truncateOffsetPattern(this._gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_HM.ordinal()]);
        } else {
            this._gmtOffsetPatterns = strArr2;
        }
        String[] strArr3 = (String[]) fields.get("_gmtOffsetDigits", (Object) null);
        this._gmtOffsetDigits = strArr3;
        if (strArr3 == null) {
            kf2.i("Missing field: gmtOffsetDigits");
            return;
        }
        if (strArr3.length != 10) {
            kf2.i("Incompatible field: gmtOffsetDigits");
            return;
        }
        String str2 = (String) fields.get("_gmtZeroFormat", (Object) null);
        this._gmtZeroFormat = str2;
        if (str2 == null) {
            kf2.i("Missing field: gmtZeroFormat");
            return;
        }
        this._parseAllStyles = fields.get("_parseAllStyles", false);
        if (fields.defaulted("_parseAllStyles")) {
            kf2.i("Missing field: parseAllStyles");
            return;
        }
        if (this._tznames instanceof TimeZoneNamesImpl) {
            this._tznames = TimeZoneNames.getInstance(this._locale);
            this._gnames = null;
        } else {
            this._gnames = new TimeZoneGenericNames(this._locale, this._tznames);
        }
        initGMTPattern(this._gmtPattern);
        initGMTOffsetPatterns(this._gmtOffsetPatterns);
    }

    private static String[] toCodePoints(String str) {
        int i = 0;
        int iCodePointCount = str.codePointCount(0, str.length());
        String[] strArr = new String[iCodePointCount];
        int i2 = 0;
        while (i < iCodePointCount) {
            int iCharCount = Character.charCount(str.codePointAt(i2)) + i2;
            strArr[i] = str.substring(i2, iCharCount);
            i++;
            i2 = iCharCount;
        }
        return strArr;
    }

    private static String truncateOffsetPattern(String str) {
        int iIndexOf = str.indexOf("mm");
        if (iIndexOf < 0) {
            og.p("Bad time zone hour pattern data");
            return null;
        }
        int iLastIndexOf = str.substring(0, iIndexOf).lastIndexOf("HH");
        if (iLastIndexOf >= 0) {
            return str.substring(0, iLastIndexOf + 2);
        }
        int iLastIndexOf2 = str.substring(0, iIndexOf).lastIndexOf(DateFormat.HOUR24);
        if (iLastIndexOf2 >= 0) {
            return str.substring(0, iLastIndexOf2 + 1);
        }
        og.p("Bad time zone hour pattern data");
        return null;
    }

    private static String unquote(String str) {
        if (str.indexOf(39) < 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\'' || z) {
                sb.append(cCharAt);
                z = false;
            } else {
                z = true;
            }
        }
        return sb.toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("_locale", this._locale);
        putFieldPutFields.put("_tznames", this._tznames);
        putFieldPutFields.put("_gmtPattern", this._gmtPattern);
        putFieldPutFields.put("_gmtOffsetPatterns", this._gmtOffsetPatterns);
        putFieldPutFields.put("_gmtOffsetDigits", this._gmtOffsetDigits);
        putFieldPutFields.put("_gmtZeroFormat", this._gmtZeroFormat);
        putFieldPutFields.put("_parseAllStyles", this._parseAllStyles);
        objectOutputStream.writeFields();
    }

    @Override // java.text.Format
    public TimeZoneFormat clone() {
        return (TimeZoneFormat) super.clone();
    }

    @Override // com.ibm.icu.util.Freezable
    public TimeZoneFormat cloneAsThawed() {
        TimeZoneFormat timeZoneFormat = (TimeZoneFormat) super.clone();
        timeZoneFormat._frozen = false;
        return timeZoneFormat;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0010. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v34, types: [T, com.ibm.icu.text.TimeZoneFormat$TimeType] */
    public String format(Style style, TimeZone timeZone, long j, Output<TimeType> output) {
        String genericLocationName;
        boolean z;
        if (output != null) {
            output.value = TimeType.UNKNOWN;
        }
        int[] iArr = AnonymousClass1.$SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style;
        switch (iArr[style.ordinal()]) {
            case 1:
                genericLocationName = getTimeZoneGenericNames().getGenericLocationName(ZoneMeta.getCanonicalCLDRID(timeZone));
                z = false;
                break;
            case 2:
                genericLocationName = getTimeZoneGenericNames().getDisplayName(timeZone, TimeZoneGenericNames.GenericNameType.LONG, j);
                z = false;
                break;
            case 3:
                genericLocationName = getTimeZoneGenericNames().getDisplayName(timeZone, TimeZoneGenericNames.GenericNameType.SHORT, j);
                z = false;
                break;
            case 4:
                genericLocationName = formatSpecific(timeZone, TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, j, output);
                z = false;
                break;
            case 5:
                genericLocationName = formatSpecific(timeZone, TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT, j, output);
                z = false;
                break;
            case 6:
                genericLocationName = timeZone.getID();
                z = true;
                break;
            case 7:
                genericLocationName = ZoneMeta.getShortID(timeZone);
                if (genericLocationName == null) {
                    genericLocationName = UNKNOWN_SHORT_ZONE_ID;
                }
                z = true;
                break;
            case 8:
                genericLocationName = formatExemplarLocation(timeZone);
                z = true;
                break;
            default:
                genericLocationName = null;
                z = false;
                break;
        }
        if (genericLocationName == null && !z) {
            int[] iArr2 = {0, 0};
            timeZone.getOffset(j, false, iArr2);
            int i = iArr2[0] + iArr2[1];
            switch (iArr[style.ordinal()]) {
                case 1:
                case 2:
                case 4:
                case 9:
                    genericLocationName = formatOffsetLocalizedGMT(i);
                    break;
                case 3:
                case 5:
                case 10:
                    genericLocationName = formatOffsetShortLocalizedGMT(i);
                    break;
                case 11:
                    genericLocationName = formatOffsetISO8601Basic(i, true, true, true);
                    break;
                case 12:
                    genericLocationName = formatOffsetISO8601Basic(i, false, true, true);
                    break;
                case 13:
                    genericLocationName = formatOffsetISO8601Basic(i, true, false, true);
                    break;
                case 14:
                    genericLocationName = formatOffsetISO8601Basic(i, false, false, true);
                    break;
                case 15:
                    genericLocationName = formatOffsetISO8601Basic(i, true, false, false);
                    break;
                case 16:
                    genericLocationName = formatOffsetISO8601Basic(i, false, false, false);
                    break;
                case 17:
                    genericLocationName = formatOffsetISO8601Extended(i, true, false, true);
                    break;
                case 18:
                    genericLocationName = formatOffsetISO8601Extended(i, false, false, true);
                    break;
                case 19:
                    genericLocationName = formatOffsetISO8601Extended(i, true, false, false);
                    break;
                case 20:
                    genericLocationName = formatOffsetISO8601Extended(i, false, false, false);
                    break;
            }
            if (output != null) {
                output.value = iArr2[1] != 0 ? TimeType.DAYLIGHT : TimeType.STANDARD;
            }
        }
        return genericLocationName;
    }

    public final String formatOffsetISO8601Basic(int i, boolean z, boolean z2, boolean z3) {
        return formatOffsetISO8601(i, true, z, z2, z3);
    }

    public final String formatOffsetISO8601Extended(int i, boolean z, boolean z2, boolean z3) {
        return formatOffsetISO8601(i, false, z, z2, z3);
    }

    public String formatOffsetShortLocalizedGMT(int i) {
        return formatOffsetLocalizedGMT(i, true);
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        AttributedString attributedString = new AttributedString(format(obj, new StringBuffer(), new FieldPosition(0)).toString());
        DateFormat.Field field = DateFormat.Field.TIME_ZONE;
        attributedString.addAttribute(field, field);
        return attributedString.getIterator();
    }

    public EnumSet<ParseOption> getDefaultParseOptions() {
        boolean z = this._parseAllStyles;
        if (z && this._parseTZDBNames) {
            return EnumSet.of(ParseOption.ALL_STYLES, ParseOption.TZ_DATABASE_ABBREVIATIONS);
        }
        if (z) {
            return EnumSet.of(ParseOption.ALL_STYLES);
        }
        return this._parseTZDBNames ? EnumSet.of(ParseOption.TZ_DATABASE_ABBREVIATIONS) : EnumSet.noneOf(ParseOption.class);
    }

    public String getGMTOffsetDigits() {
        StringBuilder sb = new StringBuilder(this._gmtOffsetDigits.length);
        for (String str : this._gmtOffsetDigits) {
            sb.append(str);
        }
        return sb.toString();
    }

    public String getGMTOffsetPattern(GMTOffsetPatternType gMTOffsetPatternType) {
        return this._gmtOffsetPatterns[gMTOffsetPatternType.ordinal()];
    }

    public String getGMTPattern() {
        return this._gmtPattern;
    }

    public String getGMTZeroFormat() {
        return this._gmtZeroFormat;
    }

    public TimeZoneNames getTimeZoneNames() {
        return this._tznames;
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this._frozen;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:129:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:131:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:136:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:150:0x030f  */
    /* JADX WARN: Code duplicated, block: B:154:0x0330  */
    /* JADX WARN: Code duplicated, block: B:156:0x0336  */
    /* JADX WARN: Code duplicated, block: B:165:0x035b  */
    /* JADX WARN: Code duplicated, block: B:169:0x037c  */
    /* JADX WARN: Code duplicated, block: B:171:0x0382  */
    /* JADX WARN: Code duplicated, block: B:180:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:181:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:183:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:184:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:186:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:189:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:192:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:194:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:195:0x0405  */
    /* JADX WARN: Code duplicated, block: B:197:0x0409 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:205:0x042c  */
    /* JADX WARN: Code duplicated, block: B:209:0x0442  */
    /* JADX WARN: Code duplicated, block: B:211:0x045c  */
    /* JADX WARN: Code duplicated, block: B:217:0x0482  */
    /* JADX WARN: Code duplicated, block: B:221:0x049b  */
    /* JADX WARN: Code duplicated, block: B:225:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:232:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:233:0x04da  */
    /* JADX WARN: Code duplicated, block: B:235:0x04df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:236:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:237:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:240:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:243:0x03e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:245:0x03cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x0439 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:0x0426 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.ibm.icu.text.TimeZoneFormat$TimeType] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.ibm.icu.text.TimeZoneFormat$TimeType] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.ibm.icu.text.TimeZoneFormat$TimeType] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, com.ibm.icu.text.TimeZoneFormat$TimeType] */
    public TimeZone parse(Style style, String str, ParsePosition parsePosition, EnumSet<ParseOption> enumSet, Output<TimeType> output) {
        int offsetLocalizedGMT;
        int index;
        int i;
        int i2;
        EnumSet<TimeZoneGenericNames.GenericNameType> enumSetOf;
        Collection<TimeZoneNames.MatchInfo> collectionFind;
        int i3;
        int i4;
        int i5;
        TimeType timeType;
        int i6;
        boolean zContains;
        int i7;
        String strTzID;
        T t;
        TimeZone timeZoneForOffset;
        TimeType timeType2;
        String zoneID;
        TimeZoneGenericNames.GenericMatchInfo genericMatchInfoFindBestMatch;
        Collection<TimeZoneNames.MatchInfo> collectionFind2;
        TimeZoneNames.MatchInfo matchInfo;
        int iMatchLength;
        Collection<TimeZoneNames.MatchInfo> collectionFind3;
        TimeZoneNames.MatchInfo matchInfo2;
        int iMatchLength2;
        int offsetLocalizedGMT2;
        int offsetLocalizedGMT3;
        Output<TimeType> output2 = output;
        if (output2 == null) {
            output2 = new Output<>(TimeType.UNKNOWN);
        } else {
            output2.value = TimeType.UNKNOWN;
        }
        int index2 = parsePosition.getIndex();
        int length = str.length();
        Style style2 = Style.SPECIFIC_LONG;
        boolean z = style == style2 || style == Style.GENERIC_LONG || style == Style.GENERIC_LOCATION;
        boolean z2 = style == Style.SPECIFIC_SHORT || style == Style.GENERIC_SHORT;
        ParsePosition parsePosition2 = new ParsePosition(index2);
        if (z || z2) {
            Output<Boolean> output3 = new Output<>(Boolean.FALSE);
            offsetLocalizedGMT = parseOffsetLocalizedGMT(str, parsePosition2, z2, output3);
            if (parsePosition2.getErrorIndex() != -1) {
                index = -1;
                offsetLocalizedGMT = Integer.MAX_VALUE;
            } else {
                if (parsePosition2.getIndex() == length || output3.value.booleanValue()) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                index = parsePosition2.getIndex();
            }
            i = Style.LOCALIZED_GMT_SHORT.flag | Style.LOCALIZED_GMT.flag;
        } else {
            index = -1;
            i = 0;
            offsetLocalizedGMT = Integer.MAX_VALUE;
        }
        boolean zContains2 = enumSet == null ? getDefaultParseOptions().contains(ParseOption.TZ_DATABASE_ABBREVIATIONS) : enumSet.contains(ParseOption.TZ_DATABASE_ABBREVIATIONS);
        int[] iArr = AnonymousClass1.$SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style;
        switch (iArr[style.ordinal()]) {
            case 1:
            case 2:
            case 3:
                i2 = i;
                int i8 = iArr[style.ordinal()];
                if (i8 == 1) {
                    enumSetOf = EnumSet.of(TimeZoneGenericNames.GenericNameType.LOCATION);
                } else if (i8 != 2) {
                    enumSetOf = i8 != 3 ? null : EnumSet.of(TimeZoneGenericNames.GenericNameType.SHORT, TimeZoneGenericNames.GenericNameType.LOCATION);
                } else {
                    enumSetOf = EnumSet.of(TimeZoneGenericNames.GenericNameType.LONG, TimeZoneGenericNames.GenericNameType.LOCATION);
                }
                TimeZoneGenericNames.GenericMatchInfo genericMatchInfoFindBestMatch2 = getTimeZoneGenericNames().findBestMatch(str, index2, enumSetOf);
                if (genericMatchInfoFindBestMatch2 != null && genericMatchInfoFindBestMatch2.matchLength() + index2 > index) {
                    output2.value = genericMatchInfoFindBestMatch2.timeType();
                    parsePosition.setIndex(genericMatchInfoFindBestMatch2.matchLength() + index2);
                    return TimeZone.getTimeZone(genericMatchInfoFindBestMatch2.tzID());
                }
                i4 = i2;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length || !((i5 & 128) == 0 || (i5 & 256) == 0)) {
                    i6 = i5;
                } else {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output output4 = new Output(Boolean.FALSE);
                    i6 = i5;
                    int offsetISO8601 = parseOffsetISO8601(str, parsePosition2, false, output4);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() == length || ((Boolean) output4.value).booleanValue()) {
                            parsePosition.setIndex(parsePosition2.getIndex());
                            return getTimeZoneForOffset(offsetISO8601);
                        }
                        if (index < parsePosition2.getIndex()) {
                            index = parsePosition2.getIndex();
                            offsetLocalizedGMT = offsetISO8601;
                        }
                    }
                }
                if (index < length && (i6 & Style.LOCALIZED_GMT.flag) == 0) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output5 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output5);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length || output5.value.booleanValue()) {
                            parsePosition.setIndex(parsePosition2.getIndex());
                            return getTimeZoneForOffset(offsetLocalizedGMT3);
                        }
                        if (index < parsePosition2.getIndex()) {
                            index = parsePosition2.getIndex();
                            offsetLocalizedGMT = offsetLocalizedGMT3;
                        }
                    }
                }
                if (index < length && (i6 & Style.LOCALIZED_GMT_SHORT.flag) == 0) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output6 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output6);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length || output6.value.booleanValue()) {
                            parsePosition.setIndex(parsePosition2.getIndex());
                            return getTimeZoneForOffset(offsetLocalizedGMT2);
                        }
                        if (index < parsePosition2.getIndex()) {
                            index = parsePosition2.getIndex();
                            offsetLocalizedGMT = offsetLocalizedGMT2;
                        }
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            for (TimeZoneNames.MatchInfo matchInfo3 : collectionFind3) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2 && index < length && (i6 & Style.SPECIFIC_SHORT.flag) == 0 && (collectionFind2 = getTZDBTimeZoneNames().find(str, index2, ALL_SIMPLE_NAME_TYPES)) != null) {
                        matchInfo = null;
                        iMatchLength = -1;
                        for (TimeZoneNames.MatchInfo matchInfo4 : collectionFind2) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length && (genericMatchInfoFindBestMatch = getTimeZoneGenericNames().findBestMatch(str, index2, ALL_GENERIC_NAME_TYPES)) != null && index < genericMatchInfoFindBestMatch.matchLength() + index2) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length && (i6 & Style.ZONE_ID.flag) == 0) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1 && index < parsePosition2.getIndex()) {
                            int index3 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index3;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length || (i6 & Style.ZONE_ID_SHORT.flag) != 0) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        String shortZoneID = parseShortZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() != -1 || index >= parsePosition2.getIndex()) {
                            i7 = offsetLocalizedGMT;
                            t = timeType2;
                        } else {
                            index = parsePosition2.getIndex();
                            strTzID = shortZoneID;
                            i7 = Integer.MAX_VALUE;
                            t = TimeType.UNKNOWN;
                        }
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            case 4:
            case 5:
                i2 = i;
                EnumSet<TimeZoneNames.NameType> enumSetOf2 = style == style2 ? EnumSet.of(TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT) : EnumSet.of(TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT);
                Collection<TimeZoneNames.MatchInfo> collectionFind4 = this._tznames.find(str, index2, enumSetOf2);
                if (collectionFind4 != null) {
                    TimeZoneNames.MatchInfo matchInfo5 = null;
                    for (TimeZoneNames.MatchInfo matchInfo6 : collectionFind4) {
                        if (matchInfo6.matchLength() + index2 > index) {
                            index = matchInfo6.matchLength() + index2;
                            matchInfo5 = matchInfo6;
                        }
                    }
                    if (matchInfo5 != null) {
                        output2.value = getTimeType(matchInfo5.nameType());
                        parsePosition.setIndex(index);
                        return TimeZone.getTimeZone(getTimeZoneID(matchInfo5.tzID(), matchInfo5.mzID()));
                    }
                }
                if (zContains2 && style == Style.SPECIFIC_SHORT && (collectionFind = getTZDBTimeZoneNames().find(str, index2, enumSetOf2)) != null) {
                    TimeZoneNames.MatchInfo matchInfo7 = null;
                    for (TimeZoneNames.MatchInfo matchInfo8 : collectionFind) {
                        if (matchInfo8.matchLength() + index2 > index) {
                            index = matchInfo8.matchLength() + index2;
                            matchInfo7 = matchInfo8;
                        }
                    }
                    if (matchInfo7 != null) {
                        output2.value = getTimeType(matchInfo7.nameType());
                        parsePosition.setIndex(index);
                        return TimeZone.getTimeZone(getTimeZoneID(matchInfo7.tzID(), matchInfo7.mzID()));
                    }
                }
                i4 = i2;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output7 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output7);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output8 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output8);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index4 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index4;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            case 6:
                i2 = i;
                parsePosition2.setIndex(index2);
                parsePosition2.setErrorIndex(-1);
                String zoneID2 = parseZoneID(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return TimeZone.getTimeZone(zoneID2);
                }
                i4 = i2;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output9 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output9);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output10 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output10);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index5 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index5;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            case 7:
                i2 = i;
                parsePosition2.setIndex(index2);
                parsePosition2.setErrorIndex(-1);
                String shortZoneID2 = parseShortZoneID(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return TimeZone.getTimeZone(shortZoneID2);
                }
                i4 = i2;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output11 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output11);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output12 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output12);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index6 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index6;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            case 8:
                i2 = i;
                parsePosition2.setIndex(index2);
                parsePosition2.setErrorIndex(-1);
                String exemplarLocation = parseExemplarLocation(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return TimeZone.getTimeZone(exemplarLocation);
                }
                i4 = i2;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output13 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output13);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output14 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output14);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index7 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index7;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            case 9:
                parsePosition2.setIndex(index2);
                parsePosition2.setErrorIndex(-1);
                int offsetLocalizedGMT4 = parseOffsetLocalizedGMT(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(offsetLocalizedGMT4);
                }
                i3 = Style.LOCALIZED_GMT_SHORT.flag;
                i4 = i | i3;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output15 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output15);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output16 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output16);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index8 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index8;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            case 10:
                parsePosition2.setIndex(index2);
                parsePosition2.setErrorIndex(-1);
                int offsetShortLocalizedGMT = parseOffsetShortLocalizedGMT(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(offsetShortLocalizedGMT);
                }
                i3 = Style.LOCALIZED_GMT.flag;
                i4 = i | i3;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output17 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output17);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output18 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output18);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index9 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index9;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            case 11:
            case 13:
            case 15:
            case 17:
            case 19:
                i2 = i;
                parsePosition2.setIndex(index2);
                parsePosition2.setErrorIndex(-1);
                int offsetISO8602 = parseOffsetISO8601(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(offsetISO8602);
                }
                i4 = i2;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output19 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output19);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output110 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output110);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index10 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index10;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            case 12:
            case 14:
            case 16:
            case 18:
            case 20:
                parsePosition2.setIndex(index2);
                parsePosition2.setErrorIndex(-1);
                Output output20 = new Output(Boolean.FALSE);
                i2 = i;
                int offsetISO8603 = parseOffsetISO8601(str, parsePosition2, false, output20);
                if (parsePosition2.getErrorIndex() == -1 && ((Boolean) output20.value).booleanValue()) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(offsetISO8603);
                }
                i4 = i2;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output111 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output111);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output112 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output112);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index11 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index11;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
            default:
                i2 = i;
                i4 = i2;
                i5 = style.flag | i4;
                if (index > index2) {
                    parsePosition.setIndex(index);
                    return getTimeZoneForOffset(offsetLocalizedGMT);
                }
                timeType = TimeType.UNKNOWN;
                if (index < length) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output113 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output113);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT3);
                    }
                }
                if (index < length) {
                    parsePosition2.setIndex(index2);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output114 = new Output<>(Boolean.FALSE);
                    offsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2, true, output114);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() != length) {
                            break;
                        }
                        parsePosition.setIndex(parsePosition2.getIndex());
                        return getTimeZoneForOffset(offsetLocalizedGMT2);
                    }
                }
                if (enumSet == null) {
                    zContains = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    zContains = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (zContains) {
                    if (index >= length) {
                        strTzID = null;
                        timeType2 = timeType;
                    } else {
                        collectionFind3 = this._tznames.find(str, index2, ALL_SIMPLE_NAME_TYPES);
                        if (collectionFind3 != null) {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                            while (r1.hasNext()) {
                                if (matchInfo3.matchLength() + index2 > iMatchLength2) {
                                    iMatchLength2 = matchInfo3.matchLength() + index2;
                                    matchInfo2 = matchInfo3;
                                }
                            }
                        } else {
                            matchInfo2 = null;
                            iMatchLength2 = -1;
                        }
                        if (index < iMatchLength2) {
                            strTzID = getTimeZoneID(matchInfo2.tzID(), matchInfo2.mzID());
                            index = iMatchLength2;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                            timeType2 = getTimeType(matchInfo2.nameType());
                        } else {
                            strTzID = null;
                            timeType2 = timeType;
                        }
                    }
                    if (zContains2) {
                        matchInfo = null;
                        iMatchLength = -1;
                        while (r4.hasNext()) {
                            if (matchInfo4.matchLength() + index2 > iMatchLength) {
                                iMatchLength = matchInfo4.matchLength() + index2;
                                matchInfo = matchInfo4;
                            }
                        }
                        if (index < iMatchLength) {
                            strTzID = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                            timeType2 = getTimeType(matchInfo.nameType());
                            index = iMatchLength;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        index = genericMatchInfoFindBestMatch.matchLength() + index2;
                        strTzID = genericMatchInfoFindBestMatch.tzID();
                        timeType2 = genericMatchInfoFindBestMatch.timeType();
                        offsetLocalizedGMT = Integer.MAX_VALUE;
                    }
                    if (index < length) {
                        parsePosition2.setIndex(index2);
                        parsePosition2.setErrorIndex(-1);
                        zoneID = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1) {
                            int index12 = parsePosition2.getIndex();
                            timeType2 = TimeType.UNKNOWN;
                            index = index12;
                            strTzID = zoneID;
                            offsetLocalizedGMT = Integer.MAX_VALUE;
                        }
                    }
                    if (index < length) {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    } else {
                        i7 = offsetLocalizedGMT;
                        t = timeType2;
                    }
                } else {
                    i7 = offsetLocalizedGMT;
                    strTzID = null;
                    t = timeType;
                }
                if (index > index2) {
                    parsePosition.setErrorIndex(index2);
                    return null;
                }
                if (strTzID != null) {
                    timeZoneForOffset = TimeZone.getTimeZone(strTzID);
                } else {
                    timeZoneForOffset = getTimeZoneForOffset(i7);
                }
                output2.value = t;
                parsePosition.setIndex(index);
                return timeZoneForOffset;
        }
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public int parseOffsetShortLocalizedGMT(String str, ParsePosition parsePosition) {
        return parseOffsetLocalizedGMT(str, parsePosition, true, null);
    }

    public TimeZoneFormat setDefaultParseOptions(EnumSet<ParseOption> enumSet) {
        this._parseAllStyles = enumSet.contains(ParseOption.ALL_STYLES);
        this._parseTZDBNames = enumSet.contains(ParseOption.TZ_DATABASE_ABBREVIATIONS);
        return this;
    }

    public TimeZoneFormat setGMTOffsetDigits(String str) {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen object");
            return null;
        }
        if (str == null) {
            dk0.n("Null GMT offset digits");
            return null;
        }
        String[] codePoints = toCodePoints(str);
        if (codePoints.length == 10) {
            this._gmtOffsetDigits = codePoints;
            return this;
        }
        og.i("Length of digits must be 10");
        return null;
    }

    public TimeZoneFormat setGMTOffsetPattern(GMTOffsetPatternType gMTOffsetPatternType, String str) {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen object");
            return null;
        }
        if (str == null) {
            dk0.n("Null GMT offset pattern");
            return null;
        }
        Object[] offsetPattern = parseOffsetPattern(str, gMTOffsetPatternType.required());
        this._gmtOffsetPatterns[gMTOffsetPatternType.ordinal()] = str;
        this._gmtOffsetPatternItems[gMTOffsetPatternType.ordinal()] = offsetPattern;
        checkAbuttingHoursAndMinutes();
        return this;
    }

    public TimeZoneFormat setGMTPattern(String str) {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen object");
            return null;
        }
        initGMTPattern(str);
        return this;
    }

    public TimeZoneFormat setGMTZeroFormat(String str) {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen object");
            return null;
        }
        if (str == null) {
            dk0.n("Null GMT zero format");
            return null;
        }
        if (str.length() != 0) {
            this._gmtZeroFormat = str;
            return this;
        }
        og.i("Empty GMT zero format");
        return null;
    }

    public TimeZoneFormat setTimeZoneNames(TimeZoneNames timeZoneNames) {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen object");
            return null;
        }
        this._tznames = timeZoneNames;
        this._gnames = new TimeZoneGenericNames(this._locale, this._tznames);
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class TimeZoneFormatCache extends SoftCache<ULocale, TimeZoneFormat, ULocale> {
        public /* synthetic */ TimeZoneFormatCache(int i) {
            this();
        }

        private TimeZoneFormatCache() {
        }

        @Override // com.ibm.icu.impl.CacheBase
        public TimeZoneFormat createInstance(ULocale uLocale, ULocale uLocale2) {
            TimeZoneFormat timeZoneFormat = new TimeZoneFormat(uLocale2);
            timeZoneFormat.freeze();
            return timeZoneFormat;
        }
    }

    @Override // com.ibm.icu.util.Freezable
    public TimeZoneFormat freeze() {
        this._frozen = true;
        return this;
    }

    public static TimeZoneFormat getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    public int parseOffsetLocalizedGMT(String str, ParsePosition parsePosition) {
        return parseOffsetLocalizedGMT(str, parsePosition, false, null);
    }

    public final int parseOffsetISO8601(String str, ParsePosition parsePosition) {
        return parseOffsetISO8601(str, parsePosition, false, null);
    }

    public String formatOffsetLocalizedGMT(int i) {
        return formatOffsetLocalizedGMT(i, false);
    }

    public final String format(Style style, TimeZone timeZone, long j) {
        return format(style, timeZone, j, null);
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (obj instanceof TimeZone) {
            timeZone = (TimeZone) obj;
        } else if (obj instanceof Calendar) {
            Calendar calendar = (Calendar) obj;
            TimeZone timeZone2 = calendar.getTimeZone();
            long timeInMillis = calendar.getTimeInMillis();
            timeZone = timeZone2;
            jCurrentTimeMillis = timeInMillis;
        } else {
            og.i(cq.v("Cannot format given Object (", obj.getClass().getName(), ") as a time zone"));
            return null;
        }
        String offsetLocalizedGMT = formatOffsetLocalizedGMT(timeZone.getOffset(jCurrentTimeMillis));
        stringBuffer.append(offsetLocalizedGMT);
        if (fieldPosition.getFieldAttribute() != DateFormat.Field.TIME_ZONE && fieldPosition.getField() != 17) {
            return stringBuffer;
        }
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(offsetLocalizedGMT.length());
        return stringBuffer;
    }

    public TimeZone parse(Style style, String str, ParsePosition parsePosition, Output<TimeType> output) {
        return parse(style, str, parsePosition, null, output);
    }

    public final TimeZone parse(String str, ParsePosition parsePosition) {
        return parse(Style.GENERIC_LOCATION, str, parsePosition, EnumSet.of(ParseOption.ALL_STYLES), null);
    }

    public final TimeZone parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        TimeZone timeZone = parse(str, parsePosition);
        if (parsePosition.getErrorIndex() < 0) {
            return timeZone;
        }
        throw new ParseException(cq.v("Unparseable time zone: \"", str, "\""), 0);
    }
}
