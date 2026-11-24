package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StringSegment;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ValidationMatcher implements NumberParseMatcher {
    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean match(StringSegment stringSegment, ParsedNumber parsedNumber) {
        return false;
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean smokeTest(StringSegment stringSegment) {
        return false;
    }
}
