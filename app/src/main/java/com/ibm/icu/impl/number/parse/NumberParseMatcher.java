package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StringSegment;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface NumberParseMatcher {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Flexible {
    }

    boolean match(StringSegment stringSegment, ParsedNumber parsedNumber);

    void postProcess(ParsedNumber parsedNumber);

    boolean smokeTest(StringSegment stringSegment);
}
