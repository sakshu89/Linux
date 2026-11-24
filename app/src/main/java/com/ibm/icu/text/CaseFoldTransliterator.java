package com.ibm.icu.text;

import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class CaseFoldTransliterator extends Transliterator {
    static final String _ID = "Any-CaseFold";
    static volatile SourceTargetUtility sourceTargetUtility;
    private final UCaseProps csp;

    public CaseFoldTransliterator() {
        super(_ID, null);
        this.csp = UCaseProps.INSTANCE;
    }

    public static void register() {
        Transliterator.registerFactory(_ID, new Transliterator.Factory() { // from class: com.ibm.icu.text.CaseFoldTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new CaseFoldTransliterator();
            }
        });
        Transliterator.registerSpecialInverse("CaseFold", "Upper", false);
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        if (sourceTargetUtility == null) {
            synchronized (CaseFoldTransliterator.class) {
                try {
                    if (sourceTargetUtility == null) {
                        sourceTargetUtility = new SourceTargetUtility(new Transform<String, String>() { // from class: com.ibm.icu.text.CaseFoldTransliterator.2
                            @Override // com.ibm.icu.text.Transform
                            public String transform(String str) {
                                return UCharacter.foldCase(str, true);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        sourceTargetUtility.addSourceTargetSet(this, unicodeSet, unicodeSet2, unicodeSet3);
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        int iReplace;
        if (this.csp == null || position.start >= position.limit) {
            return;
        }
        ReplaceableContextIterator replaceableContextIterator = new ReplaceableContextIterator();
        StringBuilder sb = new StringBuilder();
        replaceableContextIterator.setText(replaceable);
        replaceableContextIterator.setIndex(position.start);
        replaceableContextIterator.setLimit(position.limit);
        replaceableContextIterator.setContextLimits(position.contextStart, position.contextLimit);
        while (true) {
            int iNextCaseMapCP = replaceableContextIterator.nextCaseMapCP();
            if (iNextCaseMapCP < 0) {
                position.start = position.limit;
                return;
            }
            int fullFolding = this.csp.toFullFolding(iNextCaseMapCP, sb, 0);
            if (replaceableContextIterator.didReachLimit() && z) {
                position.start = replaceableContextIterator.getCaseMapCPStart();
                return;
            }
            if (fullFolding >= 0) {
                if (fullFolding <= 31) {
                    iReplace = replaceableContextIterator.replace(sb.toString());
                    sb.setLength(0);
                } else {
                    iReplace = replaceableContextIterator.replace(UTF16.valueOf(fullFolding));
                }
                if (iReplace != 0) {
                    position.limit += iReplace;
                    position.contextLimit += iReplace;
                }
            }
        }
    }
}
