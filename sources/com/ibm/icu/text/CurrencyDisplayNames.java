package com.ibm.icu.text;

import com.ibm.icu.impl.CurrencyData;
import com.ibm.icu.util.ULocale;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class CurrencyDisplayNames {
    @Deprecated
    public CurrencyDisplayNames() {
    }

    public static CurrencyDisplayNames getInstance(ULocale uLocale, boolean z) {
        return CurrencyData.provider.getInstance(uLocale, !z);
    }

    @Deprecated
    public static boolean hasData() {
        return CurrencyData.provider.hasData();
    }

    public abstract String getFormalSymbol(String str);

    public abstract String getName(String str);

    public abstract String getNarrowSymbol(String str);

    public abstract String getPluralName(String str, String str2);

    public abstract String getSymbol(String str);

    public abstract ULocale getULocale();

    public abstract String getVariantSymbol(String str);

    public abstract Map<String, String> nameMap();

    public abstract Map<String, String> symbolMap();

    public static CurrencyDisplayNames getInstance(Locale locale) {
        return getInstance(locale, false);
    }

    public static CurrencyDisplayNames getInstance(ULocale uLocale) {
        return CurrencyData.provider.getInstance(uLocale, true);
    }

    public static CurrencyDisplayNames getInstance(Locale locale, boolean z) {
        return getInstance(ULocale.forLocale(locale), z);
    }
}
