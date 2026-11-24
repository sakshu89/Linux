package com.ibm.icu.text;

import defpackage.cq;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class FunctionReplacer implements UnicodeReplacer {
    private UnicodeReplacer replacer;
    private Transliterator translit;

    public FunctionReplacer(Transliterator transliterator, UnicodeReplacer unicodeReplacer) {
        this.translit = transliterator;
        this.replacer = unicodeReplacer;
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public void addReplacementSetTo(UnicodeSet unicodeSet) {
        unicodeSet.addAll(this.translit.getTargetSet());
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public int replace(Replaceable replaceable, int i, int i2, int[] iArr) {
        return this.translit.transliterate(replaceable, i, this.replacer.replace(replaceable, i, i2, iArr) + i) - i;
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public String toReplacerPattern(boolean z) {
        StringBuilder sb = new StringBuilder("&");
        sb.append(this.translit.getID());
        sb.append("( ");
        return cq.n(sb, this.replacer.toReplacerPattern(z), " )");
    }
}
