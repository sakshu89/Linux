package com.ibm.icu.text;

import com.ibm.icu.impl.Utility;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class StringMatcher implements UnicodeMatcher, UnicodeReplacer {
    private final RuleBasedTransliterator.Data data;
    private int matchLimit;
    private int matchStart;
    private String pattern;
    private int segmentNumber;

    public StringMatcher(String str, int i, RuleBasedTransliterator.Data data) {
        this.data = data;
        this.pattern = str;
        this.matchLimit = -1;
        this.matchStart = -1;
        this.segmentNumber = i;
    }

    @Override // com.ibm.icu.text.UnicodeMatcher
    public void addMatchSetTo(UnicodeSet unicodeSet) {
        int charCount = 0;
        while (charCount < this.pattern.length()) {
            int iCharAt = UTF16.charAt(this.pattern, charCount);
            UnicodeMatcher unicodeMatcherLookupMatcher = this.data.lookupMatcher(iCharAt);
            if (unicodeMatcherLookupMatcher == null) {
                unicodeSet.add(iCharAt);
            } else {
                unicodeMatcherLookupMatcher.addMatchSetTo(unicodeSet);
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
    }

    @Override // com.ibm.icu.text.UnicodeMatcher
    public int matches(Replaceable replaceable, int[] iArr, int i, boolean z) {
        int i2 = iArr[0];
        int[] iArr2 = {i2};
        if (i < i2) {
            for (int length = this.pattern.length() - 1; length >= 0; length--) {
                char cCharAt = this.pattern.charAt(length);
                UnicodeMatcher unicodeMatcherLookupMatcher = this.data.lookupMatcher(cCharAt);
                if (unicodeMatcherLookupMatcher == null) {
                    int i3 = iArr2[0];
                    if (i3 <= i || cCharAt != replaceable.charAt(i3)) {
                        return 0;
                    }
                    iArr2[0] = iArr2[0] - 1;
                } else {
                    int iMatches = unicodeMatcherLookupMatcher.matches(replaceable, iArr2, i, z);
                    if (iMatches != 2) {
                        return iMatches;
                    }
                }
            }
            if (this.matchStart < 0) {
                this.matchStart = iArr2[0] + 1;
                this.matchLimit = iArr[0] + 1;
            }
        } else {
            for (int i4 = 0; i4 < this.pattern.length(); i4++) {
                if (z && iArr2[0] == i) {
                    return 1;
                }
                char cCharAt2 = this.pattern.charAt(i4);
                UnicodeMatcher unicodeMatcherLookupMatcher2 = this.data.lookupMatcher(cCharAt2);
                if (unicodeMatcherLookupMatcher2 == null) {
                    int i5 = iArr2[0];
                    if (i5 >= i || cCharAt2 != replaceable.charAt(i5)) {
                        return 0;
                    }
                    iArr2[0] = iArr2[0] + 1;
                } else {
                    int iMatches2 = unicodeMatcherLookupMatcher2.matches(replaceable, iArr2, i, z);
                    if (iMatches2 != 2) {
                        return iMatches2;
                    }
                }
            }
            this.matchStart = iArr[0];
            this.matchLimit = iArr2[0];
        }
        iArr[0] = iArr2[0];
        return 2;
    }

    @Override // com.ibm.icu.text.UnicodeMatcher
    public boolean matchesIndexValue(int i) {
        if (this.pattern.length() == 0) {
            return true;
        }
        int iCharAt = UTF16.charAt(this.pattern, 0);
        UnicodeMatcher unicodeMatcherLookupMatcher = this.data.lookupMatcher(iCharAt);
        if (unicodeMatcherLookupMatcher == null) {
            return (iCharAt & 255) == i;
        }
        return unicodeMatcherLookupMatcher.matchesIndexValue(i);
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public int replace(Replaceable replaceable, int i, int i2, int[] iArr) {
        int i3;
        int i4;
        int i5 = this.matchStart;
        if (i5 < 0 || i5 == (i4 = this.matchLimit)) {
            i3 = 0;
        } else {
            replaceable.copy(i5, i4, i2);
            i3 = this.matchLimit - this.matchStart;
        }
        replaceable.replace(i, i2, "");
        return i3;
    }

    public void resetMatch() {
        this.matchLimit = -1;
        this.matchStart = -1;
    }

    @Override // com.ibm.icu.text.UnicodeMatcher
    public String toPattern(boolean z) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.segmentNumber > 0) {
            sb.append('(');
        }
        for (int i = 0; i < this.pattern.length(); i++) {
            char cCharAt = this.pattern.charAt(i);
            UnicodeMatcher unicodeMatcherLookupMatcher = this.data.lookupMatcher(cCharAt);
            if (unicodeMatcherLookupMatcher == null) {
                Utility.appendToRule(sb, (int) cCharAt, false, z, sb2);
            } else {
                Utility.appendToRule(sb, unicodeMatcherLookupMatcher.toPattern(z), true, z, sb2);
            }
        }
        if (this.segmentNumber > 0) {
            sb.append(')');
        }
        Utility.appendToRule(sb, -1, true, z, sb2);
        return sb.toString();
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public String toReplacerPattern(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        Utility.appendNumber(sb, this.segmentNumber, 10, 1);
        return sb.toString();
    }

    public StringMatcher(String str, int i, int i2, int i3, RuleBasedTransliterator.Data data) {
        this(str.substring(i, i2), i3, data);
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public void addReplacementSetTo(UnicodeSet unicodeSet) {
    }
}
