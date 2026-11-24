package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.UnicodeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PaddingMatcher extends SymbolMatcher implements NumberParseMatcher.Flexible {
    private PaddingMatcher(String str) {
        super(str, UnicodeSet.EMPTY);
    }

    public static PaddingMatcher getInstance(String str) {
        return new PaddingMatcher(str);
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public boolean isDisabled(ParsedNumber parsedNumber) {
        return false;
    }

    public String toString() {
        return "<PaddingMatcher>";
    }

    @Override // com.ibm.icu.impl.number.parse.SymbolMatcher
    public void accept(StringSegment stringSegment, ParsedNumber parsedNumber) {
    }
}
