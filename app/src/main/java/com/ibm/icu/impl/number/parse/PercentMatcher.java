package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.DecimalFormatSymbols;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PercentMatcher extends SymbolMatcher {
    private static final PercentMatcher DEFAULT = new PercentMatcher();

    private PercentMatcher(String str) {
        super(str, DEFAULT.uniSet);
    }

    public static PercentMatcher getInstance(DecimalFormatSymbols decimalFormatSymbols) {
        String percentString = decimalFormatSymbols.getPercentString();
        PercentMatcher percentMatcher = DEFAULT;
        return percentMatcher.uniSet.contains(percentString) ? percentMatcher : new PercentMatcher(percentString);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public void accept(StringSegment stringSegment, ParsedNumber parsedNumber) {
        parsedNumber.flags |= 2;
        parsedNumber.setCharsConsumed(stringSegment);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public boolean isDisabled(ParsedNumber parsedNumber) {
        return (parsedNumber.flags & 2) != 0;
    }

    public String toString() {
        return "<PercentMatcher>";
    }

    private PercentMatcher() {
        super(StaticUnicodeSets.Key.PERCENT_SIGN);
    }
}
