package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.DecimalFormatSymbols;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PermilleMatcher extends SymbolMatcher {
    private static final PermilleMatcher DEFAULT = new PermilleMatcher();

    private PermilleMatcher(String str) {
        super(str, DEFAULT.uniSet);
    }

    public static PermilleMatcher getInstance(DecimalFormatSymbols decimalFormatSymbols) {
        String perMillString = decimalFormatSymbols.getPerMillString();
        PermilleMatcher permilleMatcher = DEFAULT;
        return permilleMatcher.uniSet.contains(perMillString) ? permilleMatcher : new PermilleMatcher(perMillString);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public void accept(StringSegment stringSegment, ParsedNumber parsedNumber) {
        parsedNumber.flags |= 4;
        parsedNumber.setCharsConsumed(stringSegment);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public boolean isDisabled(ParsedNumber parsedNumber) {
        return (parsedNumber.flags & 4) != 0;
    }

    public String toString() {
        return "<PermilleMatcher>";
    }

    private PermilleMatcher() {
        super(StaticUnicodeSets.Key.PERMILLE_SIGN);
    }
}
