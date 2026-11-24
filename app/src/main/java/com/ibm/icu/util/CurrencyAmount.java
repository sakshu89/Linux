package com.ibm.icu.util;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CurrencyAmount extends Measure {
    public CurrencyAmount(double d, Currency currency) {
        super(Double.valueOf(d), currency);
    }

    public Currency getCurrency() {
        return (Currency) getUnit();
    }

    public CurrencyAmount(Number number, Currency currency) {
        super(number, currency);
    }

    public CurrencyAmount(Number number, java.util.Currency currency) {
        this(number, Currency.fromJavaCurrency(currency));
    }

    public CurrencyAmount(double d, java.util.Currency currency) {
        this(d, Currency.fromJavaCurrency(currency));
    }
}
