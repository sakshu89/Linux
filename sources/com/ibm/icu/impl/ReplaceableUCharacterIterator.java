package com.ibm.icu.impl;

import com.ibm.icu.text.Replaceable;
import com.ibm.icu.text.ReplaceableString;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.text.UTF16;
import defpackage.dk0;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ReplaceableUCharacterIterator extends UCharacterIterator implements Cloneable {
    private int currentIndex;
    private Replaceable replaceable;

    public ReplaceableUCharacterIterator(String str) {
        if (str == null) {
            dk0.v();
            throw null;
        }
        this.replaceable = new ReplaceableString(str);
        this.currentIndex = 0;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    /* JADX INFO: renamed from: clone */
    public ReplaceableUCharacterIterator mo2clone() {
        try {
            return (ReplaceableUCharacterIterator) super.mo2clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int current() {
        if (this.currentIndex < this.replaceable.length()) {
            return this.replaceable.charAt(this.currentIndex);
        }
        return -1;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int currentCodePoint() {
        int iCurrent = current();
        if (UTF16.isLeadSurrogate(iCurrent)) {
            next();
            int iCurrent2 = current();
            previous();
            if (UTF16.isTrailSurrogate(iCurrent2)) {
                return Character.toCodePoint((char) iCurrent, (char) iCurrent2);
            }
        }
        return iCurrent;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getIndex() {
        return this.currentIndex;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getLength() {
        return this.replaceable.length();
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getText(char[] cArr, int i) {
        int length = this.replaceable.length();
        if (i < 0 || i + length > cArr.length) {
            og.o(Integer.toString(length));
            return 0;
        }
        this.replaceable.getChars(0, length, cArr, i);
        return length;
    }

    @Override // com.ibm.icu.text.UCharacterIterator, com.ibm.icu.text.UForwardCharacterIterator
    public int next() {
        if (this.currentIndex >= this.replaceable.length()) {
            return -1;
        }
        Replaceable replaceable = this.replaceable;
        int i = this.currentIndex;
        this.currentIndex = i + 1;
        return replaceable.charAt(i);
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int previous() {
        int i = this.currentIndex;
        if (i <= 0) {
            return -1;
        }
        Replaceable replaceable = this.replaceable;
        int i2 = i - 1;
        this.currentIndex = i2;
        return replaceable.charAt(i2);
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public void setIndex(int i) {
        if (i < 0 || i > this.replaceable.length()) {
            throw new IndexOutOfBoundsException();
        }
        this.currentIndex = i;
    }

    public ReplaceableUCharacterIterator(Replaceable replaceable) {
        if (replaceable != null) {
            this.replaceable = replaceable;
            this.currentIndex = 0;
        } else {
            dk0.v();
            throw null;
        }
    }

    public ReplaceableUCharacterIterator(StringBuffer stringBuffer) {
        if (stringBuffer != null) {
            this.replaceable = new ReplaceableString(stringBuffer);
            this.currentIndex = 0;
        } else {
            dk0.v();
            throw null;
        }
    }
}
