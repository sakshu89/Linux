package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UnicodeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class StringSegment implements CharSequence {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int end;
    private boolean foldCase;
    private int start = 0;
    private final String str;

    public StringSegment(String str, boolean z) {
        this.str = str;
        this.end = str.length();
        this.foldCase = z;
    }

    private static final boolean codePointsEqual(int i, int i2, boolean z) {
        if (i == i2) {
            return true;
        }
        return z && UCharacter.foldCase(i, true) == UCharacter.foldCase(i2, true);
    }

    private int getPrefixLengthInternal(CharSequence charSequence, boolean z) {
        int iCharCount = 0;
        while (iCharCount < Math.min(length(), charSequence.length())) {
            int iCodePointAt = Character.codePointAt(this, iCharCount);
            if (!codePointsEqual(iCodePointAt, Character.codePointAt(charSequence, iCharCount), z)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return iCharCount;
    }

    public void adjustOffset(int i) {
        this.start += i;
    }

    public void adjustOffsetByCodePoint() {
        this.start = Character.charCount(getCodePoint()) + this.start;
    }

    public String asString() {
        return this.str.substring(this.start, this.end);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.str.charAt(i + this.start);
    }

    public int codePointAt(int i) {
        return this.str.codePointAt(this.start + i);
    }

    public boolean contentEquals(CharSequence charSequence) {
        return Utility.charSequenceEquals(this, charSequence);
    }

    public int getCaseSensitivePrefixLength(CharSequence charSequence) {
        return getPrefixLengthInternal(charSequence, false);
    }

    public int getCodePoint() {
        char cCharAt = this.str.charAt(this.start);
        if (Character.isHighSurrogate(cCharAt)) {
            int i = this.start;
            if (i + 1 < this.end) {
                char cCharAt2 = this.str.charAt(i + 1);
                if (Character.isLowSurrogate(cCharAt2)) {
                    return Character.toCodePoint(cCharAt, cCharAt2);
                }
            }
        }
        return cCharAt;
    }

    public int getCommonPrefixLength(CharSequence charSequence) {
        return getPrefixLengthInternal(charSequence, this.foldCase);
    }

    public int getOffset() {
        return this.start;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.end - this.start;
    }

    public void resetLength() {
        this.end = this.str.length();
    }

    public void setLength(int i) {
        this.end = this.start + i;
    }

    public void setOffset(int i) {
        this.start = i;
    }

    public boolean startsWith(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0 || length() == 0) {
            return false;
        }
        return codePointsEqual(Character.codePointAt(this, 0), Character.codePointAt(charSequence, 0), this.foldCase);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        String str = this.str;
        int i3 = this.start;
        return str.subSequence(i + i3, i2 + i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.str.substring(0, this.start) + "[" + this.str.substring(this.start, this.end) + "]" + this.str.substring(this.end);
    }

    public boolean startsWith(UnicodeSet unicodeSet) {
        int codePoint = getCodePoint();
        if (codePoint == -1) {
            return false;
        }
        return unicodeSet.contains(codePoint);
    }

    public boolean startsWith(int i) {
        return codePointsEqual(getCodePoint(), i, this.foldCase);
    }
}
