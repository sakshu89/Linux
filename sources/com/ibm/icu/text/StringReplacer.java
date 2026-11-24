package com.ibm.icu.text;

import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.number.Padder;
import defpackage.ky0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class StringReplacer implements UnicodeReplacer {
    private int cursorPos;
    private final RuleBasedTransliterator.Data data;
    private boolean hasCursor;
    private boolean isComplex;
    private String output;

    public StringReplacer(String str, RuleBasedTransliterator.Data data) {
        this.output = str;
        this.cursorPos = 0;
        this.hasCursor = false;
        this.data = data;
        this.isComplex = true;
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public void addReplacementSetTo(UnicodeSet unicodeSet) {
        int charCount = 0;
        while (charCount < this.output.length()) {
            int iCharAt = UTF16.charAt(this.output, charCount);
            UnicodeReplacer unicodeReplacerLookupReplacer = this.data.lookupReplacer(iCharAt);
            if (unicodeReplacerLookupReplacer == null) {
                unicodeSet.add(iCharAt);
            } else {
                unicodeReplacerLookupReplacer.addReplacementSetTo(unicodeSet);
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public int replace(Replaceable replaceable, int i, int i2, int[] iArr) {
        int i3;
        int i4;
        int length;
        int i5;
        if (this.isComplex) {
            StringBuilder sb = new StringBuilder();
            this.isComplex = false;
            int length2 = replaceable.length();
            if (i > 0) {
                int charCount = UTF16.getCharCount(replaceable.char32At(i - 1));
                replaceable.copy(i - charCount, i, length2);
                i3 = charCount + length2;
            } else {
                replaceable.replace(length2, length2, "\uffff");
                i3 = length2 + 1;
            }
            int charCount2 = 0;
            int length3 = 0;
            int charCount3 = 0;
            int length4 = i3;
            while (charCount2 < this.output.length()) {
                if (charCount2 == this.cursorPos) {
                    length3 = (sb.length() + length4) - i3;
                }
                int iCharAt = UTF16.charAt(this.output, charCount2);
                charCount2 += UTF16.getCharCount(iCharAt);
                if (charCount2 == this.output.length()) {
                    charCount3 = UTF16.getCharCount(replaceable.char32At(i2));
                    replaceable.copy(i2, i2 + charCount3, length4);
                }
                UnicodeReplacer unicodeReplacerLookupReplacer = this.data.lookupReplacer(iCharAt);
                if (unicodeReplacerLookupReplacer == null) {
                    sb.appendCodePoint(iCharAt);
                } else {
                    this.isComplex = true;
                    if (sb.length() > 0) {
                        replaceable.replace(length4, length4, sb.toString());
                        length4 += sb.length();
                        sb.setLength(0);
                    }
                    length4 += unicodeReplacerLookupReplacer.replace(replaceable, length4, length4, iArr);
                }
            }
            if (sb.length() > 0) {
                replaceable.replace(length4, length4, sb.toString());
                length4 += sb.length();
            }
            i4 = charCount2 == this.cursorPos ? length4 - i3 : length3;
            int i6 = length4 - i3;
            replaceable.copy(i3, length4, i);
            replaceable.replace(length2 + i6, length4 + charCount3 + i6, "");
            replaceable.replace(i + i6, i2 + i6, "");
            length = i6;
        } else {
            replaceable.replace(i, i2, this.output);
            length = this.output.length();
            i4 = this.cursorPos;
        }
        if (this.hasCursor) {
            int i7 = this.cursorPos;
            if (i7 < 0) {
                while (i7 < 0 && i > 0) {
                    i -= UTF16.getCharCount(replaceable.char32At(i - 1));
                    i7++;
                }
                i5 = i + i7;
            } else if (i7 > this.output.length()) {
                int charCount4 = i + length;
                int length5 = this.cursorPos - this.output.length();
                while (length5 > 0 && charCount4 < replaceable.length()) {
                    charCount4 += UTF16.getCharCount(replaceable.char32At(charCount4));
                    length5--;
                }
                i5 = charCount4 + length5;
            } else {
                i5 = i + i4;
            }
            iArr[0] = i5;
        }
        return length;
    }

    @Override // com.ibm.icu.text.UnicodeReplacer
    public String toReplacerPattern(boolean z) {
        boolean z2;
        int i;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i2 = this.cursorPos;
        if (this.hasCursor && i2 < 0) {
            while (true) {
                i = i2 + 1;
                if (i2 >= 0) {
                    break;
                }
                Utility.appendToRule(sb, 64, true, z, sb2);
                i2 = i;
            }
            i2 = i;
        }
        int i3 = 0;
        while (true) {
            int length = this.output.length();
            z2 = this.hasCursor;
            if (i3 >= length) {
                break;
            }
            if (z2 && i3 == i2) {
                Utility.appendToRule(sb, 124, true, z, sb2);
            }
            char cCharAt = this.output.charAt(i3);
            UnicodeReplacer unicodeReplacerLookupReplacer = this.data.lookupReplacer(cCharAt);
            if (unicodeReplacerLookupReplacer == null) {
                Utility.appendToRule(sb, (int) cCharAt, false, z, sb2);
            } else {
                Utility.appendToRule(sb, ky0.n(new StringBuilder(Padder.FALLBACK_PADDING_STRING), unicodeReplacerLookupReplacer.toReplacerPattern(z), ' '), true, z, sb2);
            }
            i3++;
        }
        if (z2 && i2 > this.output.length()) {
            int length2 = i2 - this.output.length();
            while (true) {
                int i4 = length2 - 1;
                if (length2 <= 0) {
                    break;
                }
                Utility.appendToRule(sb, 64, true, z, sb2);
                length2 = i4;
            }
            Utility.appendToRule(sb, 124, true, z, sb2);
        }
        Utility.appendToRule(sb, -1, true, z, sb2);
        return sb.toString();
    }

    public StringReplacer(String str, int i, RuleBasedTransliterator.Data data) {
        this.output = str;
        this.cursorPos = i;
        this.hasCursor = true;
        this.data = data;
        this.isComplex = true;
    }
}
