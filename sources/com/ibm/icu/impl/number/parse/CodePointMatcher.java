package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StringSegment;
import defpackage.cq;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CodePointMatcher implements NumberParseMatcher {
    private final int cp;

    private CodePointMatcher(int i) {
        this.cp = i;
    }

    public static CodePointMatcher getInstance(int i) {
        return new CodePointMatcher(i);
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean match(StringSegment stringSegment, ParsedNumber parsedNumber) {
        if (!stringSegment.startsWith(this.cp)) {
            return false;
        }
        stringSegment.adjustOffsetByCodePoint();
        parsedNumber.setCharsConsumed(stringSegment);
        return false;
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean smokeTest(StringSegment stringSegment) {
        return stringSegment.startsWith(this.cp);
    }

    public String toString() {
        return cq.v("<CodePointMatcher U+", Integer.toHexString(this.cp), ">");
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
    }
}
