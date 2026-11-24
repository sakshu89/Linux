package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.DecimalFormatSymbols;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ApproximatelySignMatcher extends SymbolMatcher {
    private static final ApproximatelySignMatcher DEFAULT = new ApproximatelySignMatcher(false);
    private static final ApproximatelySignMatcher DEFAULT_ALLOW_TRAILING = new ApproximatelySignMatcher(true);
    private final boolean allowTrailing;

    private ApproximatelySignMatcher(String str, boolean z) {
        super(str, DEFAULT.uniSet);
        this.allowTrailing = z;
    }

    public static ApproximatelySignMatcher getInstance(DecimalFormatSymbols decimalFormatSymbols, boolean z) {
        String approximatelySignString = decimalFormatSymbols.getApproximatelySignString();
        ApproximatelySignMatcher approximatelySignMatcher = DEFAULT;
        if (approximatelySignMatcher.uniSet.contains(approximatelySignString)) {
            return z ? DEFAULT_ALLOW_TRAILING : approximatelySignMatcher;
        }
        return new ApproximatelySignMatcher(approximatelySignString, z);
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
        return "<ApproximatelySignMatcher>";
    }

    private ApproximatelySignMatcher(boolean z) {
        super(StaticUnicodeSets.Key.APPROXIMATELY_SIGN);
        this.allowTrailing = z;
    }
}
