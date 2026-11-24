package com.ibm.icu.number;

import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocalizedNumberRangeFormatter extends NumberRangeFormatterSettings<LocalizedNumberRangeFormatter> {
    private volatile NumberRangeFormatterImpl fImpl;

    public LocalizedNumberRangeFormatter(NumberRangeFormatterSettings<?> numberRangeFormatterSettings, int i, Object obj) {
        super(numberRangeFormatterSettings, i, obj);
    }

    @Override // com.ibm.icu.number.NumberRangeFormatterSettings
    public LocalizedNumberRangeFormatter create(int i, Object obj) {
        return new LocalizedNumberRangeFormatter(this, i, obj);
    }

    public FormattedNumberRange formatImpl(DecimalQuantity decimalQuantity, DecimalQuantity decimalQuantity2, boolean z) {
        if (this.fImpl == null) {
            this.fImpl = new NumberRangeFormatterImpl(resolve());
        }
        return this.fImpl.format(decimalQuantity, decimalQuantity2, z);
    }

    public FormattedNumberRange formatRange(Number number, Number number2) {
        if (number != null && number2 != null) {
            return formatImpl(new DecimalQuantity_DualStorageBCD(number), new DecimalQuantity_DualStorageBCD(number2), number.equals(number2));
        }
        og.i("Cannot format null values in range");
        return null;
    }

    public UnlocalizedNumberRangeFormatter withoutLocale() {
        return new UnlocalizedNumberRangeFormatter(this, 1, null);
    }

    public FormattedNumberRange formatRange(double d, double d2) {
        return formatImpl(new DecimalQuantity_DualStorageBCD(d), new DecimalQuantity_DualStorageBCD(d2), d == d2);
    }

    public FormattedNumberRange formatRange(int i, int i2) {
        return formatImpl(new DecimalQuantity_DualStorageBCD(i), new DecimalQuantity_DualStorageBCD(i2), i == i2);
    }
}
