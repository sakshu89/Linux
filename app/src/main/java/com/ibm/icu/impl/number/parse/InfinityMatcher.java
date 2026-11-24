package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.DecimalFormatSymbols;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class InfinityMatcher extends SymbolMatcher {
    private static final InfinityMatcher DEFAULT = new InfinityMatcher();

    private InfinityMatcher(String str) {
        super(str, DEFAULT.uniSet);
    }

    public static InfinityMatcher getInstance(DecimalFormatSymbols decimalFormatSymbols) {
        String infinity = decimalFormatSymbols.getInfinity();
        InfinityMatcher infinityMatcher = DEFAULT;
        return infinityMatcher.uniSet.contains(infinity) ? infinityMatcher : new InfinityMatcher(infinity);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public void accept(StringSegment stringSegment, ParsedNumber parsedNumber) {
        parsedNumber.flags |= 128;
        parsedNumber.setCharsConsumed(stringSegment);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public boolean isDisabled(ParsedNumber parsedNumber) {
        return (parsedNumber.flags & 128) != 0;
    }

    public String toString() {
        return "<InfinityMatcher>";
    }

    private InfinityMatcher() {
        super(StaticUnicodeSets.Key.INFINITY_SIGN);
    }
}
