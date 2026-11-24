package com.ibm.icu.text;

import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.ULocale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class UnescapeTransliterator extends Transliterator {
    private static final char END = 65535;
    private char[] spec;

    public UnescapeTransliterator(String str, char[] cArr) {
        super(str, null);
        this.spec = cArr;
    }

    public static void register() {
        Transliterator.registerFactory("Hex-Any/Unicode", new Transliterator.Factory() { // from class: com.ibm.icu.text.UnescapeTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UnescapeTransliterator("Hex-Any/Unicode", new char[]{2, 0, 16, 4, 6, 'U', '+', 65535});
            }
        });
        Transliterator.registerFactory("Hex-Any/Java", new Transliterator.Factory() { // from class: com.ibm.icu.text.UnescapeTransliterator.2
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UnescapeTransliterator("Hex-Any/Java", new char[]{2, 0, 16, 4, 4, PatternTokenizer.BACK_SLASH, 'u', 65535});
            }
        });
        Transliterator.registerFactory("Hex-Any/C", new Transliterator.Factory() { // from class: com.ibm.icu.text.UnescapeTransliterator.3
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UnescapeTransliterator("Hex-Any/C", new char[]{2, 0, 16, 4, 4, PatternTokenizer.BACK_SLASH, 'u', 2, 0, 16, '\b', '\b', PatternTokenizer.BACK_SLASH, 'U', 65535});
            }
        });
        Transliterator.registerFactory("Hex-Any/XML", new Transliterator.Factory() { // from class: com.ibm.icu.text.UnescapeTransliterator.4
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UnescapeTransliterator("Hex-Any/XML", new char[]{3, 1, 16, 1, 6, '&', '#', ULocale.PRIVATE_USE_EXTENSION, ';', 65535});
            }
        });
        Transliterator.registerFactory("Hex-Any/XML10", new Transliterator.Factory() { // from class: com.ibm.icu.text.UnescapeTransliterator.5
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UnescapeTransliterator("Hex-Any/XML10", new char[]{2, 1, '\n', 1, 7, '&', '#', ';', 65535});
            }
        });
        Transliterator.registerFactory("Hex-Any/Perl", new Transliterator.Factory() { // from class: com.ibm.icu.text.UnescapeTransliterator.6
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UnescapeTransliterator("Hex-Any/Perl", new char[]{3, 1, 16, 1, 6, PatternTokenizer.BACK_SLASH, ULocale.PRIVATE_USE_EXTENSION, '{', '}', 65535});
            }
        });
        Transliterator.registerFactory("Hex-Any", new Transliterator.Factory() { // from class: com.ibm.icu.text.UnescapeTransliterator.7
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new UnescapeTransliterator("Hex-Any", new char[]{2, 0, 16, 4, 6, 'U', '+', 2, 0, 16, 4, 4, PatternTokenizer.BACK_SLASH, 'u', 2, 0, 16, '\b', '\b', PatternTokenizer.BACK_SLASH, 'U', 3, 1, 16, 1, 6, '&', '#', ULocale.PRIVATE_USE_EXTENSION, ';', 2, 1, '\n', 1, 7, '&', '#', ';', 3, 1, 16, 1, 6, PatternTokenizer.BACK_SLASH, ULocale.PRIVATE_USE_EXTENSION, '{', '}', 65535});
            }
        });
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        UnicodeSet filterAsUnicodeSet = getFilterAsUnicodeSet(unicodeSet);
        UnicodeSet unicodeSet4 = new UnicodeSet();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            char[] cArr = this.spec;
            char c = cArr[i];
            if (c == 65535) {
                break;
            }
            int i2 = c + i + cArr[i + 1] + 5;
            char c2 = cArr[i + 2];
            for (int i3 = 0; i3 < c2; i3++) {
                Utility.appendNumber(sb, i3, c2, 0);
            }
            for (int i4 = i + 5; i4 < i2; i4++) {
                unicodeSet4.add(this.spec[i4]);
            }
            i = i2;
        }
        unicodeSet4.addAll(sb.toString());
        unicodeSet4.retainAll(filterAsUnicodeSet);
        if (unicodeSet4.size() > 0) {
            unicodeSet2.addAll(unicodeSet4);
            unicodeSet3.addAll(0, 1114111);
        }
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        boolean z2;
        int charCount = position.start;
        int length = position.limit;
        loop0: while (charCount < length) {
            int i = 0;
            while (true) {
                char[] cArr = this.spec;
                char c = cArr[i];
                if (c == 65535) {
                    break;
                }
                char c2 = cArr[i + 1];
                char c3 = cArr[i + 2];
                int i2 = i + 4;
                char c4 = cArr[i + 3];
                int i3 = i + 5;
                char c5 = cArr[i2];
                int charCount2 = charCount;
                int i4 = 0;
                while (true) {
                    if (i4 >= c) {
                        z2 = true;
                        break;
                    }
                    if (charCount2 >= length && i4 > 0) {
                        if (!z) {
                            break loop0;
                        } else {
                            break loop0;
                        }
                    } else {
                        int i5 = charCount2 + 1;
                        if (replaceable.charAt(charCount2) != this.spec[i3 + i4]) {
                            charCount2 = i5;
                        } else {
                            i4++;
                            charCount2 = i5;
                        }
                    }
                    z2 = false;
                    break;
                }
                if (z2) {
                    int i6 = 0;
                    int i7 = 0;
                    do {
                        if (charCount2 >= length) {
                            if (charCount2 > charCount && z) {
                                break loop0;
                            } else {
                                break;
                            }
                        } else {
                            int iChar32At = replaceable.char32At(charCount2);
                            int iDigit = UCharacter.digit(iChar32At, c3);
                            if (iDigit < 0) {
                                break;
                            }
                            charCount2 += UTF16.getCharCount(iChar32At);
                            i6 = (i6 * c3) + iDigit;
                            i7++;
                        }
                    } while (i7 != c5);
                    boolean z3 = i7 >= c4;
                    if (z3) {
                        int i8 = 0;
                        while (i8 < c2) {
                            if (charCount2 < length) {
                                int i9 = charCount2 + 1;
                                if (replaceable.charAt(charCount2) != this.spec[i3 + c + i8]) {
                                    charCount2 = i9;
                                } else {
                                    i8++;
                                    charCount2 = i9;
                                }
                            } else if (charCount2 > charCount && z) {
                                break loop0;
                            }
                            z3 = false;
                            break;
                        }
                        if (z3) {
                            String strValueOf = UTF16.valueOf(i6);
                            replaceable.replace(charCount, charCount2, strValueOf);
                            length -= (charCount2 - charCount) - strValueOf.length();
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i = i3 + c + c2;
            }
            if (charCount < length) {
                charCount += UTF16.getCharCount(replaceable.char32At(charCount));
            }
        }
        position.contextLimit = (length - position.limit) + position.contextLimit;
        position.limit = length;
        position.start = charCount;
    }
}
