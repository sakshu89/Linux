package com.ibm.icu.impl.number.parse;

import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ULocale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class AffixTokenMatcherFactory {
    public Currency currency;
    public IgnorablesMatcher ignorables;
    public ULocale locale;
    public int parseFlags;
    public DecimalFormatSymbols symbols;

    public ApproximatelySignMatcher approximatelySign() {
        return ApproximatelySignMatcher.getInstance(this.symbols, true);
    }

    public CombinedCurrencyMatcher currency() {
        return CombinedCurrencyMatcher.getInstance(this.currency, this.symbols, this.parseFlags);
    }

    public IgnorablesMatcher ignorables() {
        return this.ignorables;
    }

    public MinusSignMatcher minusSign() {
        return MinusSignMatcher.getInstance(this.symbols, true);
    }

    public PercentMatcher percent() {
        return PercentMatcher.getInstance(this.symbols);
    }

    public PermilleMatcher permille() {
        return PermilleMatcher.getInstance(this.symbols);
    }

    public PlusSignMatcher plusSign() {
        return PlusSignMatcher.getInstance(this.symbols, true);
    }
}
