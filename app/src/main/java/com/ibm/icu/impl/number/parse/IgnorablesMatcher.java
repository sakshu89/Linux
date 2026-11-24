package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.UnicodeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class IgnorablesMatcher extends SymbolMatcher implements NumberParseMatcher.Flexible {
    private static final IgnorablesMatcher DEFAULT = new IgnorablesMatcher(StaticUnicodeSets.get(StaticUnicodeSets.Key.DEFAULT_IGNORABLES));
    private static final IgnorablesMatcher STRICT = new IgnorablesMatcher(StaticUnicodeSets.get(StaticUnicodeSets.Key.STRICT_IGNORABLES));
    private static final IgnorablesMatcher JAVA_COMPATIBILITY = new IgnorablesMatcher(StaticUnicodeSets.get(StaticUnicodeSets.Key.EMPTY));

    private IgnorablesMatcher(UnicodeSet unicodeSet) {
        super("", unicodeSet);
    }

    public static IgnorablesMatcher getInstance(int i) {
        if ((65536 & i) != 0) {
            return JAVA_COMPATIBILITY;
        }
        return (i & 32768) != 0 ? STRICT : DEFAULT;
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public boolean isDisabled(ParsedNumber parsedNumber) {
        return false;
    }

    public String toString() {
        return "<IgnorablesMatcher>";
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public void accept(StringSegment stringSegment, ParsedNumber parsedNumber) {
    }
}
