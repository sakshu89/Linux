package com.ibm.icu.text;

import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class SameValueSubstitution extends NFSubstitution {
    public SameValueSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, str);
        if (str.equals("==")) {
            og.i("== is not a legal token");
            throw null;
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '=';
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return j;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return d;
    }
}
