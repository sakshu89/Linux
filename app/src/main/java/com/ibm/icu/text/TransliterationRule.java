package com.ibm.icu.text;

import com.ibm.icu.impl.Utility;
import defpackage.cq;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class TransliterationRule {
    static final int ANCHOR_END = 2;
    static final int ANCHOR_START = 1;
    private StringMatcher anteContext;
    private int anteContextLength;
    private final RuleBasedTransliterator.Data data;
    byte flags;
    private StringMatcher key;
    private int keyLength;
    private UnicodeReplacer output;
    private String pattern;
    private StringMatcher postContext;
    UnicodeMatcher[] segments;

    public TransliterationRule(String str, int i, int i2, String str2, int i3, int i4, UnicodeMatcher[] unicodeMatcherArr, boolean z, boolean z2, RuleBasedTransliterator.Data data) {
        this.data = data;
        if (i < 0) {
            this.anteContextLength = 0;
        } else {
            if (i > str.length()) {
                og.i("Invalid ante context");
                throw null;
            }
            this.anteContextLength = i;
        }
        if (i2 < 0) {
            this.keyLength = str.length() - this.anteContextLength;
        } else {
            if (i2 < this.anteContextLength || i2 > str.length()) {
                og.i("Invalid post context");
                throw null;
            }
            this.keyLength = i2 - this.anteContextLength;
        }
        if (i3 < 0) {
            i3 = str2.length();
        } else if (i3 > str2.length()) {
            og.i("Invalid cursor position");
            throw null;
        }
        this.segments = unicodeMatcherArr;
        this.pattern = str;
        this.flags = (byte) 0;
        if (z) {
            this.flags = (byte) 1;
        }
        if (z2) {
            this.flags = (byte) (this.flags | 2);
        }
        this.anteContext = null;
        int i5 = this.anteContextLength;
        if (i5 > 0) {
            this.anteContext = new StringMatcher(str.substring(0, i5), 0, data);
        }
        this.key = null;
        int i6 = this.keyLength;
        if (i6 > 0) {
            String str3 = this.pattern;
            int i7 = this.anteContextLength;
            this.key = new StringMatcher(str3.substring(i7, i6 + i7), 0, data);
        }
        int length = this.pattern.length();
        int i8 = this.keyLength;
        int i9 = this.anteContextLength;
        int i10 = (length - i8) - i9;
        this.postContext = null;
        if (i10 > 0) {
            this.postContext = new StringMatcher(this.pattern.substring(i9 + i8), 0, data);
        }
        this.output = new StringReplacer(str2, i3 + i4, data);
    }

    public static final int posAfter(Replaceable replaceable, int i) {
        return (i < 0 || i >= replaceable.length()) ? i + 1 : UTF16.getCharCount(replaceable.char32At(i)) + i;
    }

    public static final int posBefore(Replaceable replaceable, int i) {
        return i > 0 ? i - UTF16.getCharCount(replaceable.char32At(i - 1)) : i - 1;
    }

    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3, UnicodeSet unicodeSet4) {
        int i = this.anteContextLength + this.keyLength;
        UnicodeSet unicodeSet5 = new UnicodeSet();
        UnicodeSet unicodeSet6 = new UnicodeSet();
        int charCount = this.anteContextLength;
        while (charCount < i) {
            int iCharAt = UTF16.charAt(this.pattern, charCount);
            charCount += UTF16.getCharCount(iCharAt);
            UnicodeMatcher unicodeMatcherLookupMatcher = this.data.lookupMatcher(iCharAt);
            if (unicodeMatcherLookupMatcher != null) {
                try {
                    if (!unicodeSet.containsSome((UnicodeSet) unicodeMatcherLookupMatcher)) {
                        return;
                    } else {
                        unicodeMatcherLookupMatcher.addMatchSetTo(unicodeSet5);
                    }
                } catch (ClassCastException unused) {
                    unicodeSet6.clear();
                    unicodeMatcherLookupMatcher.addMatchSetTo(unicodeSet6);
                    if (!unicodeSet.containsSome(unicodeSet6)) {
                        return;
                    } else {
                        unicodeSet5.addAll(unicodeSet6);
                    }
                }
            } else if (!unicodeSet.contains(iCharAt)) {
                return;
            } else {
                unicodeSet5.add(iCharAt);
            }
        }
        unicodeSet2.addAll(unicodeSet5);
        this.output.addReplacementSetTo(unicodeSet3);
    }

    public int getAnteContextLength() {
        return this.anteContextLength + ((this.flags & 1) == 0 ? 0 : 1);
    }

    public final int getIndexValue() {
        if (this.anteContextLength == this.pattern.length()) {
            return -1;
        }
        int iCharAt = UTF16.charAt(this.pattern, this.anteContextLength);
        if (this.data.lookupMatcher(iCharAt) == null) {
            return iCharAt & 255;
        }
        return -1;
    }

    public boolean masks(TransliterationRule transliterationRule) {
        int length = this.pattern.length();
        int i = this.anteContextLength;
        int i2 = transliterationRule.anteContextLength;
        int length2 = this.pattern.length() - i;
        int length3 = transliterationRule.pattern.length() - i2;
        if (i != i2 || length2 != length3 || this.keyLength > transliterationRule.keyLength || !transliterationRule.pattern.regionMatches(0, this.pattern, 0, length)) {
            return i <= i2 && (length2 < length3 || (length2 == length3 && this.keyLength <= transliterationRule.keyLength)) && transliterationRule.pattern.regionMatches(i2 - i, this.pattern, 0, length);
        }
        byte b = this.flags;
        byte b2 = transliterationRule.flags;
        return b == b2 || ((b & 1) == 0 && (b & 2) == 0) || !((b2 & 1) == 0 || (b2 & 2) == 0);
    }

    public int matchAndReplace(Replaceable replaceable, Transliterator.Position position, boolean z) {
        int iMatches;
        if (this.segments != null) {
            int i = 0;
            while (true) {
                UnicodeMatcher[] unicodeMatcherArr = this.segments;
                if (i >= unicodeMatcherArr.length) {
                    break;
                }
                ((StringMatcher) unicodeMatcherArr[i]).resetMatch();
                i++;
            }
        }
        int iPosBefore = posBefore(replaceable, position.contextStart);
        int[] iArr = {posBefore(replaceable, position.start)};
        StringMatcher stringMatcher = this.anteContext;
        if (stringMatcher != null && stringMatcher.matches(replaceable, iArr, iPosBefore, false) != 2) {
            return 0;
        }
        int i2 = iArr[0];
        int iPosAfter = posAfter(replaceable, i2);
        if ((this.flags & 1) != 0 && i2 != iPosBefore) {
            return 0;
        }
        iArr[0] = position.start;
        StringMatcher stringMatcher2 = this.key;
        if (stringMatcher2 != null && (iMatches = stringMatcher2.matches(replaceable, iArr, position.limit, z)) != 2) {
            return iMatches;
        }
        int i3 = iArr[0];
        StringMatcher stringMatcher3 = this.postContext;
        if (stringMatcher3 != null) {
            if (z && i3 == position.limit) {
                return 1;
            }
            int iMatches2 = stringMatcher3.matches(replaceable, iArr, position.contextLimit, z);
            if (iMatches2 != 2) {
                return iMatches2;
            }
        }
        int i4 = iArr[0];
        if ((this.flags & 2) != 0) {
            if (i4 != position.contextLimit) {
                return 0;
            }
            if (z) {
                return 1;
            }
        }
        int iReplace = this.output.replace(replaceable, position.start, i3, iArr) - (i3 - position.start);
        int i5 = iArr[0];
        int i6 = position.limit + iReplace;
        position.limit = i6;
        position.contextLimit += iReplace;
        position.start = Math.max(iPosAfter, Math.min(Math.min(i4 + iReplace, i6), i5));
        return 2;
    }

    public final boolean matchesIndexValue(int i) {
        StringMatcher stringMatcher = this.key;
        if (stringMatcher == null) {
            stringMatcher = this.postContext;
        }
        if (stringMatcher != null) {
            return stringMatcher.matchesIndexValue(i);
        }
        return true;
    }

    public String toRule(boolean z) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = (this.anteContext == null && this.postContext == null) ? false : true;
        if ((this.flags & 1) != 0) {
            sb.append('^');
        }
        Utility.appendToRule(sb, this.anteContext, z, sb2);
        if (z2) {
            Utility.appendToRule(sb, 123, true, z, sb2);
        }
        Utility.appendToRule(sb, this.key, z, sb2);
        if (z2) {
            Utility.appendToRule(sb, 125, true, z, sb2);
        }
        Utility.appendToRule(sb, this.postContext, z, sb2);
        if ((this.flags & 2) != 0) {
            sb.append(SymbolTable.SYMBOL_REF);
        }
        Utility.appendToRule(sb, " > ", true, z, sb2);
        Utility.appendToRule(sb, this.output.toReplacerPattern(z), true, z, sb2);
        Utility.appendToRule(sb, 59, true, z, sb2);
        return sb.toString();
    }

    public String toString() {
        return cq.v("{", toRule(true), "}");
    }
}
