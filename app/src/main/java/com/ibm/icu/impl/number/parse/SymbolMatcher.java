package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.text.UnicodeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class SymbolMatcher implements NumberParseMatcher {
    protected final String string;
    protected final UnicodeSet uniSet;

    public SymbolMatcher(StaticUnicodeSets.Key key) {
        this.string = "";
        this.uniSet = StaticUnicodeSets.get(key);
    }

    public abstract void accept(StringSegment stringSegment, ParsedNumber parsedNumber);

    public UnicodeSet getSet() {
        return this.uniSet;
    }

    public abstract boolean isDisabled(ParsedNumber parsedNumber);

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean match(StringSegment stringSegment, ParsedNumber parsedNumber) {
        int commonPrefixLength;
        if (isDisabled(parsedNumber)) {
            return false;
        }
        if (this.string.isEmpty()) {
            commonPrefixLength = 0;
        } else {
            commonPrefixLength = stringSegment.getCommonPrefixLength(this.string);
            if (commonPrefixLength == this.string.length()) {
                stringSegment.adjustOffset(this.string.length());
                accept(stringSegment, parsedNumber);
                return false;
            }
        }
        if (!stringSegment.startsWith(this.uniSet)) {
            return commonPrefixLength == stringSegment.length();
        }
        stringSegment.adjustOffsetByCodePoint();
        accept(stringSegment, parsedNumber);
        return false;
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean smokeTest(StringSegment stringSegment) {
        return stringSegment.startsWith(this.uniSet) || stringSegment.startsWith(this.string);
    }

    public SymbolMatcher(String str, UnicodeSet unicodeSet) {
        this.string = str;
        this.uniSet = unicodeSet;
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
    }
}
