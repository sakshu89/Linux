package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.DecimalFormatSymbols;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PlusSignMatcher extends SymbolMatcher {
    private static final PlusSignMatcher DEFAULT = new PlusSignMatcher(false);
    private static final PlusSignMatcher DEFAULT_ALLOW_TRAILING = new PlusSignMatcher(true);
    private final boolean allowTrailing;

    private PlusSignMatcher(String str, boolean z) {
        super(str, DEFAULT.uniSet);
        this.allowTrailing = z;
    }

    public static PlusSignMatcher getInstance(DecimalFormatSymbols decimalFormatSymbols, boolean z) {
        String plusSignString = decimalFormatSymbols.getPlusSignString();
        PlusSignMatcher plusSignMatcher = DEFAULT;
        if (plusSignMatcher.uniSet.contains(plusSignString)) {
            return z ? DEFAULT_ALLOW_TRAILING : plusSignMatcher;
        }
        return new PlusSignMatcher(plusSignString, z);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public void accept(StringSegment stringSegment, ParsedNumber parsedNumber) {
        parsedNumber.setCharsConsumed(stringSegment);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public boolean isDisabled(ParsedNumber parsedNumber) {
        return !this.allowTrailing && parsedNumber.seenNumber();
    }

    public String toString() {
        return "<PlusSignMatcher>";
    }

    private PlusSignMatcher(boolean z) {
        super(StaticUnicodeSets.Key.PLUS_SIGN);
        this.allowTrailing = z;
    }
}
