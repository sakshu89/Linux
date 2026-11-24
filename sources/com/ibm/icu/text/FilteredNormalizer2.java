package com.ibm.icu.text;

import defpackage.dk0;
import defpackage.kf2;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class FilteredNormalizer2 extends Normalizer2 {
    private Normalizer2 norm2;
    private UnicodeSet set;

    public FilteredNormalizer2(Normalizer2 normalizer2, UnicodeSet unicodeSet) {
        this.norm2 = normalizer2;
        this.set = unicodeSet;
    }

    private Appendable normalize(CharSequence charSequence, Appendable appendable, UnicodeSet.SpanCondition spanCondition) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < charSequence.length()) {
            try {
                int iSpan = this.set.span(charSequence, i, spanCondition);
                int i2 = iSpan - i;
                UnicodeSet.SpanCondition spanCondition2 = UnicodeSet.SpanCondition.NOT_CONTAINED;
                if (spanCondition == spanCondition2) {
                    if (i2 != 0) {
                        appendable.append(charSequence, i, iSpan);
                    }
                    spanCondition = UnicodeSet.SpanCondition.SIMPLE;
                } else {
                    if (i2 != 0) {
                        appendable.append(this.norm2.normalize(charSequence.subSequence(i, iSpan), sb));
                    }
                    spanCondition = spanCondition2;
                }
                i = iSpan;
            } catch (IOException e) {
                kf2.h(e);
                return null;
            }
        }
        return appendable;
    }

    private StringBuilder normalizeSecondAndAppend(StringBuilder sb, CharSequence charSequence, boolean z) {
        if (sb == charSequence) {
            dk0.v();
            return null;
        }
        if (sb.length() == 0) {
            if (z) {
                return normalize(charSequence, sb);
            }
            sb.append(charSequence);
            return sb;
        }
        UnicodeSet unicodeSet = this.set;
        UnicodeSet.SpanCondition spanCondition = UnicodeSet.SpanCondition.SIMPLE;
        int iSpan = unicodeSet.span(charSequence, 0, spanCondition);
        if (iSpan != 0) {
            CharSequence charSequenceSubSequence = charSequence.subSequence(0, iSpan);
            int iSpanBack = this.set.spanBack(sb, Integer.MAX_VALUE, spanCondition);
            if (iSpanBack == 0) {
                Normalizer2 normalizer2 = this.norm2;
                if (z) {
                    normalizer2.normalizeSecondAndAppend(sb, charSequenceSubSequence);
                } else {
                    normalizer2.append(sb, charSequenceSubSequence);
                }
            } else {
                StringBuilder sb2 = new StringBuilder(sb.subSequence(iSpanBack, sb.length()));
                Normalizer2 normalizer3 = this.norm2;
                if (z) {
                    normalizer3.normalizeSecondAndAppend(sb2, charSequenceSubSequence);
                } else {
                    normalizer3.append(sb2, charSequenceSubSequence);
                }
                sb.delete(iSpanBack, Integer.MAX_VALUE).append((CharSequence) sb2);
            }
        }
        if (iSpan < charSequence.length()) {
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(iSpan, charSequence.length());
            if (z) {
                normalize(charSequenceSubSequence2, sb, UnicodeSet.SpanCondition.NOT_CONTAINED);
                return sb;
            }
            sb.append(charSequenceSubSequence2);
        }
        return sb;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public StringBuilder append(StringBuilder sb, CharSequence charSequence) {
        return normalizeSecondAndAppend(sb, charSequence, false);
    }

    @Override // com.ibm.icu.text.Normalizer2
    public int composePair(int i, int i2) {
        if (this.set.contains(i) && this.set.contains(i2)) {
            return this.norm2.composePair(i, i2);
        }
        return -1;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public int getCombiningClass(int i) {
        if (this.set.contains(i)) {
            return this.norm2.getCombiningClass(i);
        }
        return 0;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public String getDecomposition(int i) {
        if (this.set.contains(i)) {
            return this.norm2.getDecomposition(i);
        }
        return null;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public String getRawDecomposition(int i) {
        if (this.set.contains(i)) {
            return this.norm2.getRawDecomposition(i);
        }
        return null;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public boolean hasBoundaryAfter(int i) {
        return !this.set.contains(i) || this.norm2.hasBoundaryAfter(i);
    }

    @Override // com.ibm.icu.text.Normalizer2
    public boolean hasBoundaryBefore(int i) {
        return !this.set.contains(i) || this.norm2.hasBoundaryBefore(i);
    }

    @Override // com.ibm.icu.text.Normalizer2
    public boolean isInert(int i) {
        return !this.set.contains(i) || this.norm2.isInert(i);
    }

    @Override // com.ibm.icu.text.Normalizer2
    public boolean isNormalized(CharSequence charSequence) {
        UnicodeSet.SpanCondition spanCondition = UnicodeSet.SpanCondition.SIMPLE;
        int i = 0;
        while (i < charSequence.length()) {
            int iSpan = this.set.span(charSequence, i, spanCondition);
            UnicodeSet.SpanCondition spanCondition2 = UnicodeSet.SpanCondition.NOT_CONTAINED;
            if (spanCondition == spanCondition2) {
                spanCondition = UnicodeSet.SpanCondition.SIMPLE;
            } else {
                if (!this.norm2.isNormalized(charSequence.subSequence(i, iSpan))) {
                    return false;
                }
                spanCondition = spanCondition2;
            }
            i = iSpan;
        }
        return true;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public Normalizer.QuickCheckResult quickCheck(CharSequence charSequence) {
        Normalizer.QuickCheckResult quickCheckResult = Normalizer.YES;
        UnicodeSet.SpanCondition spanCondition = UnicodeSet.SpanCondition.SIMPLE;
        int i = 0;
        while (i < charSequence.length()) {
            int iSpan = this.set.span(charSequence, i, spanCondition);
            UnicodeSet.SpanCondition spanCondition2 = UnicodeSet.SpanCondition.NOT_CONTAINED;
            if (spanCondition == spanCondition2) {
                spanCondition = UnicodeSet.SpanCondition.SIMPLE;
            } else {
                Normalizer.QuickCheckResult quickCheckResultQuickCheck = this.norm2.quickCheck(charSequence.subSequence(i, iSpan));
                if (quickCheckResultQuickCheck == Normalizer.NO) {
                    return quickCheckResultQuickCheck;
                }
                if (quickCheckResultQuickCheck == Normalizer.MAYBE) {
                    quickCheckResult = quickCheckResultQuickCheck;
                }
                spanCondition = spanCondition2;
            }
            i = iSpan;
        }
        return quickCheckResult;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public int spanQuickCheckYes(CharSequence charSequence) {
        UnicodeSet.SpanCondition spanCondition = UnicodeSet.SpanCondition.SIMPLE;
        int i = 0;
        while (i < charSequence.length()) {
            int iSpan = this.set.span(charSequence, i, spanCondition);
            UnicodeSet.SpanCondition spanCondition2 = UnicodeSet.SpanCondition.NOT_CONTAINED;
            if (spanCondition == spanCondition2) {
                spanCondition = UnicodeSet.SpanCondition.SIMPLE;
            } else {
                int iSpanQuickCheckYes = this.norm2.spanQuickCheckYes(charSequence.subSequence(i, iSpan)) + i;
                if (iSpanQuickCheckYes < iSpan) {
                    return iSpanQuickCheckYes;
                }
                spanCondition = spanCondition2;
            }
            i = iSpan;
        }
        return charSequence.length();
    }

    @Override // com.ibm.icu.text.Normalizer2
    public Appendable normalize(CharSequence charSequence, Appendable appendable) {
        if (appendable != charSequence) {
            return normalize(charSequence, appendable, UnicodeSet.SpanCondition.SIMPLE);
        }
        dk0.v();
        return null;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public StringBuilder normalize(CharSequence charSequence, StringBuilder sb) {
        if (sb != charSequence) {
            sb.setLength(0);
            normalize(charSequence, sb, UnicodeSet.SpanCondition.SIMPLE);
            return sb;
        }
        dk0.v();
        return null;
    }

    @Override // com.ibm.icu.text.Normalizer2
    public StringBuilder normalizeSecondAndAppend(StringBuilder sb, CharSequence charSequence) {
        return normalizeSecondAndAppend(sb, charSequence, true);
    }
}
