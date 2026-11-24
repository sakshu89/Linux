package com.ibm.icu.text;

import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import defpackage.og;
import java.text.FieldPosition;
import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class CurrencyFormat extends MeasureFormat {
    static final long serialVersionUID = -931679363692504634L;

    public CurrencyFormat(ULocale uLocale) {
        super(uLocale, MeasureFormat.FormatWidth.DEFAULT_CURRENCY);
    }

    private Object readResolve() {
        return new CurrencyFormat(getLocale(ULocale.ACTUAL_LOCALE));
    }

    private Object writeReplace() {
        return toCurrencyProxy();
    }

    @Override // com.ibm.icu.text.MeasureFormat, java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof CurrencyAmount) {
            return super.format(obj, stringBuffer, fieldPosition);
        }
        og.i("Invalid type: ".concat(obj.getClass().getName()));
        return null;
    }

    @Override // com.ibm.icu.text.MeasureFormat, java.text.Format
    public CurrencyAmount parseObject(String str, ParsePosition parsePosition) {
        return getNumberFormatInternal().parseCurrency(str, parsePosition);
    }
}
