package com.ibm.icu.text;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class AbsoluteValueSubstitution extends NFSubstitution {
    public AbsoluteValueSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, str);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return Double.MAX_VALUE;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return -d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '>';
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return Math.abs(j);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return Math.abs(d);
    }
}
