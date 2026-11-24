package com.ibm.icu.text;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class RemoveTransliterator extends Transliterator {
    private static final String _ID = "Any-Remove";

    public RemoveTransliterator() {
        super(_ID, null);
    }

    public static void register() {
        Transliterator.registerFactory(_ID, new Transliterator.Factory() { // from class: com.ibm.icu.text.RemoveTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new RemoveTransliterator();
            }
        });
        Transliterator.registerSpecialInverse("Remove", "Null", false);
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        unicodeSet2.addAll(getFilterAsUnicodeSet(unicodeSet));
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        replaceable.replace(position.start, position.limit, "");
        int i = position.limit;
        int i2 = i - position.start;
        position.contextLimit -= i2;
        position.limit = i - i2;
    }
}
