package com.ibm.icu.number;

import com.ibm.icu.util.Currency;
import defpackage.og;
import java.math.MathContext;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class CurrencyPrecision extends Precision {
    public CurrencyPrecision() {
    }

    public Precision withCurrency(Currency currency) {
        if (currency != null) {
            return Precision.constructFromCurrency(this, currency).trailingZeroDisplay(this.trailingZeroDisplay);
        }
        og.i("Currency must not be null");
        return null;
    }

    public CurrencyPrecision(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
        super(mathContext, trailingZeroDisplay);
    }
}
