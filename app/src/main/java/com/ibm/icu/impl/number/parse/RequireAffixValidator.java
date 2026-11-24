package com.ibm.icu.impl.number.parse;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RequireAffixValidator extends ValidationMatcher {
    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
        if (parsedNumber.prefix == null || parsedNumber.suffix == null) {
            parsedNumber.flags |= 256;
        }
    }

    public String toString() {
        return "<RequireAffix>";
    }
}
