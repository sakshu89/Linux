package com.ibm.icu.impl;

import com.ibm.icu.text.CurrencyDisplayNames;
import com.ibm.icu.util.ULocale;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CurrencyData {
    public static final CurrencyDisplayInfoProvider provider;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class CurrencyDisplayInfo extends CurrencyDisplayNames {
        public abstract CurrencyFormatInfo getFormatInfo(String str);

        public abstract CurrencySpacingInfo getSpacingInfo();

        public abstract Map<String, String> getUnitPatterns();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface CurrencyDisplayInfoProvider {
        CurrencyDisplayInfo getInstance(ULocale uLocale, boolean z);

        boolean hasData();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CurrencyFormatInfo {
        public final String currencyPattern;
        public final String isoCode;
        public final String monetaryDecimalSeparator;
        public final String monetaryGroupingSeparator;

        public CurrencyFormatInfo(String str, String str2, String str3, String str4) {
            this.isoCode = str;
            this.currencyPattern = str2;
            this.monetaryDecimalSeparator = str3;
            this.monetaryGroupingSeparator = str4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DefaultInfo extends CurrencyDisplayInfo {
        private static final CurrencyDisplayInfo FALLBACK_INSTANCE = new DefaultInfo(true);
        private static final CurrencyDisplayInfo NO_FALLBACK_INSTANCE = new DefaultInfo(false);
        private final boolean fallback;

        private DefaultInfo(boolean z) {
            this.fallback = z;
        }

        public static final CurrencyDisplayInfo getWithFallback(boolean z) {
            return z ? FALLBACK_INSTANCE : NO_FALLBACK_INSTANCE;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getFormalSymbol(String str) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public CurrencyFormatInfo getFormatInfo(String str) {
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getName(String str) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getNarrowSymbol(String str) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getPluralName(String str, String str2) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public CurrencySpacingInfo getSpacingInfo() {
            if (this.fallback) {
                return CurrencySpacingInfo.DEFAULT;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getSymbol(String str) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public ULocale getULocale() {
            return ULocale.ROOT;
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public Map<String, String> getUnitPatterns() {
            if (this.fallback) {
                return Collections.EMPTY_MAP;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getVariantSymbol(String str) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public Map<String, String> nameMap() {
            return Collections.EMPTY_MAP;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public Map<String, String> symbolMap() {
            return Collections.EMPTY_MAP;
        }
    }

    static {
        CurrencyDisplayInfoProvider currencyDisplayInfoProvider;
        try {
            currencyDisplayInfoProvider = (CurrencyDisplayInfoProvider) ICUCurrencyDisplayInfoProvider.class.newInstance();
        } catch (Throwable unused) {
            currencyDisplayInfoProvider = new CurrencyDisplayInfoProvider() { // from class: com.ibm.icu.impl.CurrencyData.1
                @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfoProvider
                public CurrencyDisplayInfo getInstance(ULocale uLocale, boolean z) {
                    return DefaultInfo.getWithFallback(z);
                }

                @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfoProvider
                public boolean hasData() {
                    return false;
                }
            };
        }
        provider = currencyDisplayInfoProvider;
    }

    private CurrencyData() {
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CurrencySpacingInfo {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String DEFAULT_INSERT = " ";
        private static final String DEFAULT_CUR_MATCH = "[:letter:]";
        private static final String DEFAULT_CTX_MATCH = "[:digit:]";
        public static final CurrencySpacingInfo DEFAULT = new CurrencySpacingInfo(DEFAULT_CUR_MATCH, DEFAULT_CTX_MATCH, " ", DEFAULT_CUR_MATCH, DEFAULT_CTX_MATCH, " ");
        private final String[][] symbols = (String[][]) Array.newInstance((Class<?>) String.class, SpacingType.COUNT.ordinal(), SpacingPattern.COUNT.ordinal());
        public boolean hasBeforeCurrency = false;
        public boolean hasAfterCurrency = false;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum SpacingType {
            BEFORE,
            AFTER,
            COUNT
        }

        public CurrencySpacingInfo(String... strArr) {
            int i = 0;
            for (int i2 = 0; i2 < SpacingType.COUNT.ordinal(); i2++) {
                for (int i3 = 0; i3 < SpacingPattern.COUNT.ordinal(); i3++) {
                    this.symbols[i2][i3] = strArr[i];
                    i++;
                }
            }
        }

        public String[] getAfterSymbols() {
            return this.symbols[SpacingType.AFTER.ordinal()];
        }

        public String[] getBeforeSymbols() {
            return this.symbols[SpacingType.BEFORE.ordinal()];
        }

        public void setSymbolIfNull(SpacingType spacingType, SpacingPattern spacingPattern, String str) {
            int iOrdinal = spacingType.ordinal();
            int iOrdinal2 = spacingPattern.ordinal();
            String[] strArr = this.symbols[iOrdinal];
            if (strArr[iOrdinal2] == null) {
                strArr[iOrdinal2] = str;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum SpacingPattern {
            CURRENCY_MATCH(0),
            SURROUNDING_MATCH(1),
            INSERT_BETWEEN(2),
            COUNT;

            static final /* synthetic */ boolean $assertionsDisabled = false;

            SpacingPattern(int i) {
            }
        }

        public CurrencySpacingInfo() {
        }
    }
}
