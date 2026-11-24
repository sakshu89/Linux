package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class UnicodeNameTransliterator extends Transliterator {
    static final char CLOSE_DELIM = '}';
    static final String OPEN_DELIM = "\\N{";
    static final int OPEN_DELIM_LEN = 3;
    static final String _ID = "Any-Name";

    public UnicodeNameTransliterator(UnicodeFilter unicodeFilter) {
        super(_ID, unicodeFilter);
    }

    public static void register() {
        Transliterator.registerFactory(_ID, new Transliterator.Factory() { // from class: com.ibm.icu.text.UnicodeNameTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UnicodeNameTransliterator(null);
            }
        });
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        UnicodeSet filterAsUnicodeSet = getFilterAsUnicodeSet(unicodeSet);
        if (filterAsUnicodeSet.size() > 0) {
            unicodeSet2.addAll(filterAsUnicodeSet);
            unicodeSet3.addAll(48, 57).addAll(65, 90).add(45).add(32).addAll(OPEN_DELIM).add(125).addAll(97, 122).add(60).add(62).add(40).add(41);
        }
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        int i = position.start;
        int i2 = position.limit;
        StringBuilder sb = new StringBuilder();
        sb.append(OPEN_DELIM);
        while (i < i2) {
            int iChar32At = replaceable.char32At(i);
            String extendedName = UCharacter.getExtendedName(iChar32At);
            if (extendedName != null) {
                sb.setLength(3);
                sb.append(extendedName);
                sb.append(CLOSE_DELIM);
                int charCount = UTF16.getCharCount(iChar32At);
                replaceable.replace(i, i + charCount, sb.toString());
                int length = sb.length();
                i += length;
                i2 = (length - charCount) + i2;
            } else {
                i++;
            }
        }
        position.contextLimit = (i2 - position.limit) + position.contextLimit;
        position.limit = i2;
        position.start = i;
    }
}
