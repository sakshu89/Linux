package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.UnicodeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class NanMatcher extends SymbolMatcher {
    private static final NanMatcher DEFAULT = new NanMatcher("NaN");

    private NanMatcher(String str) {
        super(str, UnicodeSet.EMPTY);
    }

    public static NanMatcher getInstance(DecimalFormatSymbols decimalFormatSymbols, int i) {
        String naN = decimalFormatSymbols.getNaN();
        NanMatcher nanMatcher = DEFAULT;
        return nanMatcher.string.equals(naN) ? nanMatcher : new NanMatcher(naN);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public void accept(StringSegment stringSegment, ParsedNumber parsedNumber) {
        parsedNumber.flags |= 64;
        parsedNumber.setCharsConsumed(stringSegment);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public boolean isDisabled(ParsedNumber parsedNumber) {
        return parsedNumber.seenNumber();
    }

    public String toString() {
        return "<NanMatcher>";
    }
}
