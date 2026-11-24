package com.ibm.icu.util;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.text.UnicodeSet;
import defpackage.cq;
import java.util.MissingResourceException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleData {
    public static final int ALT_QUOTATION_END = 3;
    public static final int ALT_QUOTATION_START = 2;

    @Deprecated
    public static final int DELIMITER_COUNT = 4;
    public static final int ES_AUXILIARY = 1;

    @Deprecated
    public static final int ES_COUNT = 5;

    @Deprecated
    public static final int ES_CURRENCY = 3;
    public static final int ES_INDEX = 2;
    public static final int ES_PUNCTUATION = 4;
    public static final int ES_STANDARD = 0;
    private static final String LOCALE_DISPLAY_PATTERN = "localeDisplayPattern";
    private static final String MEASUREMENT_SYSTEM = "MeasurementSystem";
    private static final String PAPER_SIZE = "PaperSize";
    private static final String PATTERN = "pattern";
    public static final int QUOTATION_END = 1;
    public static final int QUOTATION_START = 0;
    private static final String SEPARATOR = "separator";
    private ICUResourceBundle bundle;
    private ICUResourceBundle langBundle;
    private MissingResourceException langBundleException;
    private boolean noSubstitute;
    private static final String[] DELIMITER_TYPES = {"quotationStart", "quotationEnd", "alternateQuotationStart", "alternateQuotationEnd"};
    private static volatile VersionInfo gCLDRVersion = null;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class MeasurementSystem {
        public static final MeasurementSystem SI = new MeasurementSystem();
        public static final MeasurementSystem US = new MeasurementSystem();
        public static final MeasurementSystem UK = new MeasurementSystem();

        private MeasurementSystem() {
        }

        public String toString() {
            if (this == SI) {
                return "SI";
            }
            if (this == US) {
                return "US";
            }
            return this == UK ? "UK" : cq.j("Unknown MeasurementSystem: ", Objects.toString(this));
        }
    }

    private LocaleData() {
    }

    public static VersionInfo getCLDRVersion() {
        if (gCLDRVersion == null) {
            gCLDRVersion = VersionInfo.getInstance(UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("cldrVersion").getString());
        }
        return gCLDRVersion;
    }

    public static final LocaleData getInstance(ULocale uLocale) {
        LocaleData localeData = new LocaleData();
        localeData.bundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        try {
            localeData.langBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_LANG_BASE_NAME, uLocale);
        } catch (MissingResourceException e) {
            localeData.langBundleException = e;
        }
        localeData.noSubstitute = false;
        return localeData;
    }

    public static final MeasurementSystem getMeasurementSystem(ULocale uLocale) {
        int i = measurementTypeBundleForLocale(uLocale, MEASUREMENT_SYSTEM).getInt();
        if (i == 0) {
            return MeasurementSystem.SI;
        }
        if (i == 1) {
            return MeasurementSystem.US;
        }
        if (i != 2) {
            return null;
        }
        return MeasurementSystem.UK;
    }

    public static final PaperSize getPaperSize(ULocale uLocale) {
        int[] intVector = measurementTypeBundleForLocale(uLocale, PAPER_SIZE).getIntVector();
        return new PaperSize(intVector[0], intVector[1], 0);
    }

    private static UResourceBundle measurementTypeBundleForLocale(ULocale uLocale, String str) {
        UResourceBundle uResourceBundle;
        String regionForSupplementalData = ULocale.getRegionForSupplementalData(uLocale, true);
        try {
            UResourceBundle uResourceBundle2 = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("measurementData");
            try {
                uResourceBundle = uResourceBundle2.get(regionForSupplementalData).get(str);
            } catch (MissingResourceException unused) {
                uResourceBundle = uResourceBundle2.get(UnitsData.Constants.DEFAULT_REGION).get(str);
            }
            return uResourceBundle;
        } catch (MissingResourceException unused2) {
            return null;
        }
    }

    public String getDelimiter(int i) {
        ICUResourceBundle withFallback = ((ICUResourceBundle) this.bundle.get("delimiters")).getWithFallback(DELIMITER_TYPES[i]);
        if (this.noSubstitute && !this.bundle.isRoot() && withFallback.isRoot()) {
            return null;
        }
        return withFallback.getString();
    }

    public UnicodeSet getExemplarSet(int i, int i2) {
        String[] strArr = {"ExemplarCharacters", "AuxExemplarCharacters", "ExemplarCharactersIndex", "ExemplarCharactersCurrency", "ExemplarCharactersPunctuation"};
        if (i2 == 3) {
            if (this.noSubstitute) {
                return null;
            }
            return UnicodeSet.EMPTY;
        }
        try {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) this.bundle.get(strArr[i2]);
            if (this.noSubstitute && !this.bundle.isRoot() && iCUResourceBundle.isRoot()) {
                return null;
            }
            return new UnicodeSet(iCUResourceBundle.getString(), i | 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        } catch (Exception unused) {
            if (this.noSubstitute) {
                return null;
            }
            return UnicodeSet.EMPTY;
        }
    }

    public String getLocaleDisplayPattern() {
        ICUResourceBundle iCUResourceBundle = this.langBundle;
        if (iCUResourceBundle != null) {
            return ((ICUResourceBundle) iCUResourceBundle.get(LOCALE_DISPLAY_PATTERN)).getStringWithFallback(PATTERN);
        }
        throw this.langBundleException;
    }

    public String getLocaleSeparator() {
        ICUResourceBundle iCUResourceBundle = this.langBundle;
        if (iCUResourceBundle == null) {
            throw this.langBundleException;
        }
        String stringWithFallback = ((ICUResourceBundle) iCUResourceBundle.get(LOCALE_DISPLAY_PATTERN)).getStringWithFallback(SEPARATOR);
        int iIndexOf = stringWithFallback.indexOf("{0}");
        int iIndexOf2 = stringWithFallback.indexOf("{1}");
        return (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf > iIndexOf2) ? stringWithFallback : stringWithFallback.substring(iIndexOf + 3, iIndexOf2);
    }

    public boolean getNoSubstitute() {
        return this.noSubstitute;
    }

    public void setNoSubstitute(boolean z) {
        this.noSubstitute = z;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class PaperSize {
        private int height;
        private int width;

        private PaperSize(int i, int i2) {
            this.height = i;
            this.width = i2;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public /* synthetic */ PaperSize(int i, int i2, int i3) {
            this(i, i2);
        }
    }

    public static final LocaleData getInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public static UnicodeSet getExemplarSet(ULocale uLocale, int i, int i2) {
        return getInstance(uLocale).getExemplarSet(i, i2);
    }

    public static UnicodeSet getExemplarSet(ULocale uLocale, int i) {
        return getInstance(uLocale).getExemplarSet(i, 0);
    }
}
