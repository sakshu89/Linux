package com.ibm.icu.number;

import defpackage.og;
import java.math.MathContext;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class FractionPrecision extends Precision {
    public FractionPrecision() {
    }

    public Precision withMaxDigits(int i) {
        if (i >= 1 && i <= 999) {
            return Precision.constructFractionSignificant(this, 1, i, NumberFormatter.RoundingPriority.STRICT, true);
        }
        og.i("Significant digits must be between 1 and 999 (inclusive)");
        return null;
    }

    public Precision withMinDigits(int i) {
        if (i >= 1 && i <= 999) {
            return Precision.constructFractionSignificant(this, 1, i, NumberFormatter.RoundingPriority.RELAXED, true);
        }
        og.i("Significant digits must be between 1 and 999 (inclusive)");
        return null;
    }

    public Precision withSignificantDigits(int i, int i2, NumberFormatter.RoundingPriority roundingPriority) {
        if (i2 >= 1 && i2 >= i && i2 <= 999) {
            return Precision.constructFractionSignificant(this, i, i2, roundingPriority, false);
        }
        og.i("Significant digits must be between 1 and 999 (inclusive)");
        return null;
    }

    public FractionPrecision(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
        super(mathContext, trailingZeroDisplay);
    }
}
