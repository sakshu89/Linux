package com.ibm.icu.impl.number.parse;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RequireDecimalSeparatorValidator extends ValidationMatcher {
    private static final RequireDecimalSeparatorValidator A = new RequireDecimalSeparatorValidator(true);
    private static final RequireDecimalSeparatorValidator B = new RequireDecimalSeparatorValidator(false);
    private final boolean patternHasDecimalSeparator;

    private RequireDecimalSeparatorValidator(boolean z) {
        this.patternHasDecimalSeparator = z;
    }

    public static RequireDecimalSeparatorValidator getInstance(boolean z) {
        return z ? A : B;
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
        int i = parsedNumber.flags;
        boolean z = ((i & 128) == 0 && (i & 64) == 0) ? false : true;
        boolean z2 = (i & 32) != 0;
        if (z || z2 == this.patternHasDecimalSeparator) {
            return;
        }
        parsedNumber.flags = i | 256;
    }

    public String toString() {
        return "<RequireDecimalSeparator>";
    }
}
