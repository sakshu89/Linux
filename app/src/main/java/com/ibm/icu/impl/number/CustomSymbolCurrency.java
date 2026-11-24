package com.ibm.icu.impl.number;

import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ULocale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CustomSymbolCurrency extends Currency {
    private static final long serialVersionUID = 2497493016770137670L;
    private String symbol1;
    private String symbol2;

    public CustomSymbolCurrency(String str, String str2, String str3) {
        super(str);
        this.symbol1 = str2;
        this.symbol2 = str3;
    }

    public static Currency resolve(Currency currency, ULocale uLocale, DecimalFormatSymbols decimalFormatSymbols) {
        if (currency == null) {
            currency = decimalFormatSymbols.getCurrency();
        }
        if (currency == null) {
            return Currency.getInstance("XXX");
        }
        if (currency.equals(decimalFormatSymbols.getCurrency())) {
            String currencySymbol = decimalFormatSymbols.getCurrencySymbol();
            String internationalCurrencySymbol = decimalFormatSymbols.getInternationalCurrencySymbol();
            String name = currency.getName(decimalFormatSymbols.getULocale(), 0, (boolean[]) null);
            String currencyCode = currency.getCurrencyCode();
            if (!name.equals(currencySymbol) || !currencyCode.equals(internationalCurrencySymbol)) {
                return new CustomSymbolCurrency(currencyCode, currencySymbol, internationalCurrencySymbol);
            }
        }
        return currency;
    }

    @Override // com.ibm.icu.util.MeasureUnit
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof CustomSymbolCurrency)) {
            return false;
        }
        CustomSymbolCurrency customSymbolCurrency = (CustomSymbolCurrency) obj;
        return Objects.equals(this.symbol1, customSymbolCurrency.symbol1) && Objects.equals(this.symbol2, customSymbolCurrency.symbol2);
    }

    @Override // com.ibm.icu.util.Currency
    public String getCurrencyCode() {
        return this.symbol2;
    }

    @Override // com.ibm.icu.util.Currency
    public String getName(ULocale uLocale, int i, boolean[] zArr) {
        if (i != 0) {
            return super.getName(uLocale, i, zArr);
        }
        if (zArr != null) {
            zArr[0] = false;
        }
        return this.symbol1;
    }

    @Override // com.ibm.icu.util.MeasureUnit
    public int hashCode() {
        return this.symbol2.hashCode() ^ (super.hashCode() ^ this.symbol1.hashCode());
    }

    @Override // com.ibm.icu.util.Currency
    public String getName(ULocale uLocale, int i, String str, boolean[] zArr) {
        return super.getName(uLocale, i, str, zArr);
    }
}
