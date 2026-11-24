package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.UCharacterName;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class NameUnicodeTransliterator extends Transliterator {
    static final char CLOSE_DELIM = '}';
    static final char OPEN_DELIM = '\\';
    static final String OPEN_PAT = "\\N~{~";
    static final char SPACE = ' ';
    static final String _ID = "Name-Any";

    public NameUnicodeTransliterator(UnicodeFilter unicodeFilter) {
        super(_ID, unicodeFilter);
    }

    public static void register() {
        Transliterator.registerFactory(_ID, new Transliterator.Factory() { // from class: com.ibm.icu.text.NameUnicodeTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new NameUnicodeTransliterator(null);
            }
        });
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        UnicodeSet filterAsUnicodeSet = getFilterAsUnicodeSet(unicodeSet);
        if (filterAsUnicodeSet.containsAll("\\N{") && filterAsUnicodeSet.contains(125)) {
            UnicodeSet unicodeSetAdd = new UnicodeSet().addAll(48, 57).addAll(65, 70).addAll(97, 122).add(60).add(62).add(40).add(41).add(45).add(32).addAll("\\N{").add(125);
            unicodeSetAdd.retainAll(filterAsUnicodeSet);
            if (unicodeSetAdd.size() > 0) {
                unicodeSet2.addAll(unicodeSetAdd);
                unicodeSet3.addAll(0, 1114111);
            }
        }
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        int i;
        UCharacterName uCharacterName = UCharacterName.INSTANCE;
        int maxCharNameLength = uCharacterName.getMaxCharNameLength() + 1;
        StringBuilder sb = new StringBuilder(maxCharNameLength);
        UnicodeSet unicodeSet = new UnicodeSet();
        uCharacterName.getCharNameCharacters(unicodeSet);
        int charCount = position.start;
        int i2 = position.limit;
        loop0: while (true) {
            boolean z2 = false;
            i = -1;
            while (true) {
                if (charCount >= i2) {
                    break loop0;
                }
                int iChar32At = replaceable.char32At(charCount);
                if (z2) {
                    if (z2) {
                        if (PatternProps.isWhiteSpace(iChar32At)) {
                            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                                sb.append(SPACE);
                                if (sb.length() > maxCharNameLength) {
                                    z2 = false;
                                }
                            }
                        } else {
                            if (iChar32At == 125) {
                                break;
                            }
                            if (unicodeSet.contains(iChar32At)) {
                                sb.appendCodePoint(iChar32At);
                                if (sb.length() >= maxCharNameLength) {
                                }
                            } else {
                                charCount--;
                            }
                            z2 = false;
                        }
                    }
                } else if (iChar32At == 92) {
                    int pattern = Utility.parsePattern(OPEN_PAT, replaceable, charCount, i2);
                    if (pattern < 0 || pattern >= i2) {
                        i = charCount;
                    } else {
                        sb.setLength(0);
                        i = charCount;
                        charCount = pattern;
                        z2 = true;
                    }
                }
                charCount += UTF16.getCharCount(iChar32At);
            }
            int length = sb.length();
            if (length > 0 && sb.charAt(length - 1) == ' ') {
                sb.setLength(length - 1);
            }
            int charFromExtendedName = UCharacter.getCharFromExtendedName(sb.toString());
            if (charFromExtendedName != -1) {
                int i3 = charCount + 1;
                String strValueOf = UTF16.valueOf(charFromExtendedName);
                replaceable.replace(i, i3, strValueOf);
                int length2 = (i3 - i) - strValueOf.length();
                charCount = i3 - length2;
                i2 -= length2;
            }
        }
        position.contextLimit = (i2 - position.limit) + position.contextLimit;
        position.limit = i2;
        if (z && i >= 0) {
            charCount = i;
        }
        position.start = charCount;
    }
}
