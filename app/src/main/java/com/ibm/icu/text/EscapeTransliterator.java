package com.ibm.icu.text;

import com.ibm.icu.impl.Utility;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class EscapeTransliterator extends Transliterator {
    private boolean grokSupplementals;
    private int minDigits;
    private String prefix;
    private int radix;
    private String suffix;
    private EscapeTransliterator supplementalHandler;

    public EscapeTransliterator(String str, String str2, String str3, int i, int i2, boolean z, EscapeTransliterator escapeTransliterator) {
        super(str, null);
        this.prefix = str2;
        this.suffix = str3;
        this.radix = i;
        this.minDigits = i2;
        this.grokSupplementals = z;
        this.supplementalHandler = escapeTransliterator;
    }

    public static void register() {
        Transliterator.registerFactory("Any-Hex/Unicode", new Transliterator.Factory() { // from class: com.ibm.icu.text.EscapeTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new EscapeTransliterator("Any-Hex/Unicode", "U+", "", 16, 4, true, null);
            }
        });
        Transliterator.registerFactory("Any-Hex/Java", new Transliterator.Factory() { // from class: com.ibm.icu.text.EscapeTransliterator.2
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new EscapeTransliterator("Any-Hex/Java", "\\u", "", 16, 4, false, null);
            }
        });
        Transliterator.registerFactory("Any-Hex/C", new Transliterator.Factory() { // from class: com.ibm.icu.text.EscapeTransliterator.3
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new EscapeTransliterator("Any-Hex/C", "\\u", "", 16, 4, true, new EscapeTransliterator("", "\\U", "", 16, 8, true, null));
            }
        });
        Transliterator.registerFactory("Any-Hex/XML", new Transliterator.Factory() { // from class: com.ibm.icu.text.EscapeTransliterator.4
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new EscapeTransliterator("Any-Hex/XML", "&#x", ";", 16, 1, true, null);
            }
        });
        Transliterator.registerFactory("Any-Hex/XML10", new Transliterator.Factory() { // from class: com.ibm.icu.text.EscapeTransliterator.5
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new EscapeTransliterator("Any-Hex/XML10", "&#", ";", 10, 1, true, null);
            }
        });
        Transliterator.registerFactory("Any-Hex/Perl", new Transliterator.Factory() { // from class: com.ibm.icu.text.EscapeTransliterator.6
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new EscapeTransliterator("Any-Hex/Perl", "\\x{", "}", 16, 1, true, null);
            }
        });
        Transliterator.registerFactory("Any-Hex/Plain", new Transliterator.Factory() { // from class: com.ibm.icu.text.EscapeTransliterator.7
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new EscapeTransliterator("Any-Hex/Plain", "", "", 16, 4, true, null);
            }
        });
        Transliterator.registerFactory("Any-Hex", new Transliterator.Factory() { // from class: com.ibm.icu.text.EscapeTransliterator.8
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new EscapeTransliterator("Any-Hex", "\\u", "", 16, 4, false, null);
            }
        });
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        unicodeSet2.addAll(getFilterAsUnicodeSet(unicodeSet));
        while (this != null) {
            if (unicodeSet.size() != 0) {
                unicodeSet3.addAll(this.prefix);
                unicodeSet3.addAll(this.suffix);
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (true) {
                    int i2 = this.radix;
                    if (i >= i2) {
                        break;
                    }
                    Utility.appendNumber(sb, i, i2, this.minDigits);
                    i++;
                }
                unicodeSet3.addAll(sb.toString());
            }
            this = this.supplementalHandler;
        }
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        int length = position.start;
        int length2 = position.limit;
        StringBuilder sb = new StringBuilder(this.prefix);
        int length3 = this.prefix.length();
        boolean z2 = false;
        while (length < length2) {
            int iChar32At = this.grokSupplementals ? replaceable.char32At(length) : replaceable.charAt(length);
            int charCount = this.grokSupplementals ? UTF16.getCharCount(iChar32At) : 1;
            if (((-65536) & iChar32At) == 0 || this.supplementalHandler == null) {
                if (z2) {
                    sb.setLength(0);
                    sb.append(this.prefix);
                    z2 = false;
                } else {
                    sb.setLength(length3);
                }
                Utility.appendNumber(sb, iChar32At, this.radix, this.minDigits);
                sb.append(this.suffix);
            } else {
                sb.setLength(0);
                sb.append(this.supplementalHandler.prefix);
                EscapeTransliterator escapeTransliterator = this.supplementalHandler;
                Utility.appendNumber(sb, iChar32At, escapeTransliterator.radix, escapeTransliterator.minDigits);
                sb.append(this.supplementalHandler.suffix);
                z2 = true;
            }
            replaceable.replace(length, length + charCount, sb.toString());
            length += sb.length();
            length2 += sb.length() - charCount;
        }
        position.contextLimit = (length2 - position.limit) + position.contextLimit;
        position.limit = length2;
        position.start = length;
    }
}
