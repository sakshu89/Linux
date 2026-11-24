package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.DecimalFormatSymbols;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MinusSignMatcher extends SymbolMatcher {
    private static final MinusSignMatcher DEFAULT = new MinusSignMatcher(false);
    private static final MinusSignMatcher DEFAULT_ALLOW_TRAILING = new MinusSignMatcher(true);
    private final boolean allowTrailing;

    private MinusSignMatcher(String str, boolean z) {
        super(str, DEFAULT.uniSet);
        this.allowTrailing = z;
    }

    public static MinusSignMatcher getInstance(DecimalFormatSymbols decimalFormatSymbols, boolean z) {
        String minusSignString = decimalFormatSymbols.getMinusSignString();
        MinusSignMatcher minusSignMatcher = DEFAULT;
        if (minusSignMatcher.uniSet.contains(minusSignString)) {
            return z ? DEFAULT_ALLOW_TRAILING : minusSignMatcher;
        }
        return new MinusSignMatcher(minusSignString, z);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public void accept(StringSegment stringSegment, ParsedNumber parsedNumber) {
        parsedNumber.flags |= 1;
        parsedNumber.setCharsConsumed(stringSegment);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public boolean isDisabled(ParsedNumber parsedNumber) {
        return !this.allowTrailing && parsedNumber.seenNumber();
    }

    public String toString() {
        return "<MinusSignMatcher>";
    }

    private MinusSignMatcher(boolean z) {
        super(StaticUnicodeSets.Key.MINUS_SIGN);
        this.allowTrailing = z;
    }
}
