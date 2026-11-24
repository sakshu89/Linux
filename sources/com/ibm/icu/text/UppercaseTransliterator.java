package com.ibm.icu.text;

import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.ULocale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class UppercaseTransliterator extends Transliterator {
    static final String _ID = "Any-Upper";
    private int caseLocale;
    private final UCaseProps csp;
    private final ULocale locale;
    volatile SourceTargetUtility sourceTargetUtility;

    public UppercaseTransliterator(ULocale uLocale) {
        super(_ID, null);
        this.sourceTargetUtility = null;
        this.locale = uLocale;
        this.csp = UCaseProps.INSTANCE;
        this.caseLocale = UCaseProps.getCaseLocale(uLocale);
    }

    public static void register() {
        Transliterator.registerFactory(_ID, new Transliterator.Factory() { // from class: com.ibm.icu.text.UppercaseTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UppercaseTransliterator(ULocale.US);
            }
        });
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        synchronized (this) {
            try {
                if (this.sourceTargetUtility == null) {
                    this.sourceTargetUtility = new SourceTargetUtility(new Transform<String, String>() { // from class: com.ibm.icu.text.UppercaseTransliterator.2
                        @Override // com.ibm.icu.text.Transform
                        public String transform(String str) {
                            return UCharacter.toUpperCase(UppercaseTransliterator.this.locale, str);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.sourceTargetUtility.addSourceTargetSet(this, unicodeSet, unicodeSet2, unicodeSet3);
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
            int fullUpper = this.csp.toFullUpper(iNextCaseMapCP, replaceableContextIterator, sb, this.caseLocale);
            if (replaceableContextIterator.didReachLimit() && z) {
                position.start = replaceableContextIterator.getCaseMapCPStart();
                return;
            }
            if (fullUpper >= 0) {
                if (fullUpper <= 31) {
                    iReplace = replaceableContextIterator.replace(sb.toString());
                    sb.setLength(0);
                } else {
                    iReplace = replaceableContextIterator.replace(UTF16.valueOf(fullUpper));
                }
                if (iReplace != 0) {
                    position.limit += iReplace;
                    position.contextLimit += iReplace;
                }
            }
        }
    }
}
