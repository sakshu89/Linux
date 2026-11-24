package com.ibm.icu.text;

import com.ibm.icu.impl.number.DecimalFormatProperties;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CompactDecimalFormat extends DecimalFormat {
    private static final long serialVersionUID = 4716293295276629682L;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum CompactStyle {
        SHORT,
        LONG
    }

    public CompactDecimalFormat(ULocale uLocale, CompactStyle compactStyle) {
        this.symbols = DecimalFormatSymbols.getInstance(uLocale);
        DecimalFormatProperties decimalFormatProperties = new DecimalFormatProperties();
        this.properties = decimalFormatProperties;
        decimalFormatProperties.setCompactStyle(compactStyle);
        this.properties.setGroupingSize(-2);
        this.properties.setMinimumGroupingDigits(2);
        this.exportedProperties = new DecimalFormatProperties();
        refreshFormatter();
    }

    public static CompactDecimalFormat getInstance(Locale locale, CompactStyle compactStyle) {
        return new CompactDecimalFormat(ULocale.forLocale(locale), compactStyle);
    }

    @Override // com.ibm.icu.text.DecimalFormat, com.ibm.icu.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    @Override // com.ibm.icu.text.DecimalFormat, com.ibm.icu.text.NumberFormat
    public CurrencyAmount parseCurrency(CharSequence charSequence, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    public static CompactDecimalFormat getInstance(ULocale uLocale, CompactStyle compactStyle) {
        return new CompactDecimalFormat(uLocale, compactStyle);
    }
}
