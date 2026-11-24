package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.util.Currency;
import defpackage.cq;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CombinedCurrencyMatcher implements NumberParseMatcher {
    private final String afterPrefixInsert;
    private final String beforeSuffixInsert;
    private final String currency1;
    private final String currency2;
    private final String isoCode;
    private final String[] localLongNames;
    private final TextTrieMap<Currency.CurrencyStringInfo> longNameTrie;
    private final TextTrieMap<Currency.CurrencyStringInfo> symbolTrie;

    private CombinedCurrencyMatcher(Currency currency, DecimalFormatSymbols decimalFormatSymbols, int i) {
        this.isoCode = currency.getSubtype();
        this.currency1 = currency.getSymbol(decimalFormatSymbols.getULocale());
        this.currency2 = currency.getCurrencyCode();
        this.afterPrefixInsert = decimalFormatSymbols.getPatternForCurrencySpacing(2, false);
        this.beforeSuffixInsert = decimalFormatSymbols.getPatternForCurrencySpacing(2, true);
        if ((i & 8192) == 0) {
            this.longNameTrie = Currency.getParsingTrie(decimalFormatSymbols.getULocale(), 1);
            this.symbolTrie = Currency.getParsingTrie(decimalFormatSymbols.getULocale(), 0);
            this.localLongNames = null;
            return;
        }
        this.longNameTrie = null;
        this.symbolTrie = null;
        this.localLongNames = new String[StandardPlural.COUNT];
        for (int i2 = 0; i2 < StandardPlural.COUNT; i2++) {
            this.localLongNames[i2] = currency.getName(decimalFormatSymbols.getLocale(), 2, StandardPlural.VALUES.get(i2).getKeyword(), (boolean[]) null);
        }
    }

    public static CombinedCurrencyMatcher getInstance(Currency currency, DecimalFormatSymbols decimalFormatSymbols, int i) {
        return new CombinedCurrencyMatcher(currency, decimalFormatSymbols, i);
    }

    private boolean matchCurrency(StringSegment stringSegment, ParsedNumber parsedNumber) {
        int caseSensitivePrefixLength = !this.currency1.isEmpty() ? stringSegment.getCaseSensitivePrefixLength(this.currency1) : -1;
        boolean z = true;
        boolean z2 = caseSensitivePrefixLength == stringSegment.length();
        if (caseSensitivePrefixLength == this.currency1.length()) {
            parsedNumber.currencyCode = this.isoCode;
            stringSegment.adjustOffset(caseSensitivePrefixLength);
            parsedNumber.setCharsConsumed(stringSegment);
            return z2;
        }
        int commonPrefixLength = this.currency2.isEmpty() ? -1 : stringSegment.getCommonPrefixLength(this.currency2);
        boolean z3 = z2 || commonPrefixLength == stringSegment.length();
        if (commonPrefixLength == this.currency2.length()) {
            parsedNumber.currencyCode = this.isoCode;
            stringSegment.adjustOffset(commonPrefixLength);
            parsedNumber.setCharsConsumed(stringSegment);
            return z3;
        }
        if (this.longNameTrie != null) {
            TextTrieMap.Output output = new TextTrieMap.Output();
            Iterator<Currency.CurrencyStringInfo> it = this.longNameTrie.get(stringSegment, 0, output);
            boolean z4 = z3 || output.partialMatch;
            if (it == null) {
                it = this.symbolTrie.get(stringSegment, 0, output);
                if (!z4 && !output.partialMatch) {
                    z = false;
                }
                z4 = z;
            }
            if (it != null) {
                parsedNumber.currencyCode = it.next().getISOCode();
                stringSegment.adjustOffset(output.matchLength);
                parsedNumber.setCharsConsumed(stringSegment);
            }
            return z4;
        }
        int length = 0;
        for (int i = 0; i < StandardPlural.COUNT; i++) {
            String str = this.localLongNames[i];
            if (!str.isEmpty()) {
                int commonPrefixLength2 = stringSegment.getCommonPrefixLength(str);
                if (commonPrefixLength2 == str.length() && str.length() > length) {
                    length = str.length();
                }
                z3 = z3 || commonPrefixLength2 > 0;
            }
        }
        if (length > 0) {
            parsedNumber.currencyCode = this.isoCode;
            stringSegment.adjustOffset(length);
            parsedNumber.setCharsConsumed(stringSegment);
        }
        return z3;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean match(StringSegment stringSegment, ParsedNumber parsedNumber) {
        boolean z;
        if (parsedNumber.currencyCode != null) {
            return false;
        }
        int offset = stringSegment.getOffset();
        if (parsedNumber.seenNumber() && !this.beforeSuffixInsert.isEmpty()) {
            int commonPrefixLength = stringSegment.getCommonPrefixLength(this.beforeSuffixInsert);
            if (commonPrefixLength == this.beforeSuffixInsert.length()) {
                stringSegment.adjustOffset(commonPrefixLength);
            }
            if (commonPrefixLength == stringSegment.length()) {
                z = true;
            } else if (matchCurrency(stringSegment, parsedNumber)) {
                z = true;
            } else {
                z = false;
            }
        } else if (matchCurrency(stringSegment, parsedNumber)) {
            z = true;
        } else {
            z = false;
        }
        if (parsedNumber.currencyCode == null) {
            stringSegment.setOffset(offset);
            return z;
        }
        if (parsedNumber.seenNumber() || this.afterPrefixInsert.isEmpty()) {
            return z;
        }
        int commonPrefixLength2 = stringSegment.getCommonPrefixLength(this.afterPrefixInsert);
        if (commonPrefixLength2 == this.afterPrefixInsert.length()) {
            stringSegment.adjustOffset(commonPrefixLength2);
        }
        return z || commonPrefixLength2 == stringSegment.length();
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean smokeTest(StringSegment stringSegment) {
        return true;
    }

    public String toString() {
        return cq.v("<CombinedCurrencyMatcher ", this.isoCode, ">");
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
    }
}
