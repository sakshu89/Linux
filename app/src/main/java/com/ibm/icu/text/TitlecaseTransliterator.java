package com.ibm.icu.text;

import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.ULocale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class TitlecaseTransliterator extends Transliterator {
    static final String _ID = "Any-Title";
    private int caseLocale;
    private final UCaseProps csp;
    private final ULocale locale;
    volatile SourceTargetUtility sourceTargetUtility;

    public TitlecaseTransliterator(ULocale uLocale) {
        super(_ID, null);
        this.sourceTargetUtility = null;
        this.locale = uLocale;
        setMaximumContextLength(2);
        this.csp = UCaseProps.INSTANCE;
        this.caseLocale = UCaseProps.getCaseLocale(uLocale);
    }

    public static void register() {
        Transliterator.registerFactory(_ID, new Transliterator.Factory() { // from class: com.ibm.icu.text.TitlecaseTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new TitlecaseTransliterator(ULocale.US);
            }
        });
        Transliterator.registerSpecialInverse("Title", "Lower", false);
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        synchronized (this) {
            try {
                if (this.sourceTargetUtility == null) {
                    this.sourceTargetUtility = new SourceTargetUtility(new Transform<String, String>() { // from class: com.ibm.icu.text.TitlecaseTransliterator.2
                        @Override // com.ibm.icu.text.Transform
                        public String transform(String str) {
                            return UCharacter.toTitleCase(TitlecaseTransliterator.this.locale, str, (BreakIterator) null);
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
        boolean z2;
        int iReplace;
        if (position.start >= position.limit) {
            return;
        }
        ReplaceableContextIterator replaceableContextIterator = new ReplaceableContextIterator();
        StringBuilder sb = new StringBuilder();
        int charCount = position.start - 1;
        while (true) {
            if (charCount >= position.contextStart) {
                int iChar32At = replaceable.char32At(charCount);
                int typeOrIgnorable = this.csp.getTypeOrIgnorable(iChar32At);
                if (typeOrIgnorable > 0) {
                    z2 = false;
                    break;
                } else if (typeOrIgnorable != 0) {
                    charCount -= UTF16.getCharCount(iChar32At);
                }
            }
            z2 = true;
            break;
        }
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
            int typeOrIgnorable2 = this.csp.getTypeOrIgnorable(iNextCaseMapCP);
            if (typeOrIgnorable2 >= 0) {
                UCaseProps uCaseProps = this.csp;
                int fullTitle = z2 ? uCaseProps.toFullTitle(iNextCaseMapCP, replaceableContextIterator, sb, this.caseLocale) : uCaseProps.toFullLower(iNextCaseMapCP, replaceableContextIterator, sb, this.caseLocale);
                z2 = typeOrIgnorable2 == 0;
                if (replaceableContextIterator.didReachLimit() && z) {
                    position.start = replaceableContextIterator.getCaseMapCPStart();
                    return;
                }
                if (fullTitle >= 0) {
                    if (fullTitle <= 31) {
                        iReplace = replaceableContextIterator.replace(sb.toString());
                        sb.setLength(0);
                    } else {
                        iReplace = replaceableContextIterator.replace(UTF16.valueOf(fullTitle));
                    }
                    if (iReplace != 0) {
                        position.limit += iReplace;
                        position.contextLimit += iReplace;
                    }
                }
            }
        }
    }
}
