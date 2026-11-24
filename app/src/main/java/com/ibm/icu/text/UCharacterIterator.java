package com.ibm.icu.text;

import com.ibm.icu.impl.CharacterIteratorWrapper;
import com.ibm.icu.impl.ReplaceableUCharacterIterator;
import com.ibm.icu.impl.UCharArrayIterator;
import com.ibm.icu.impl.UCharacterIteratorWrapper;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class UCharacterIterator implements Cloneable, UForwardCharacterIterator {
    public static final UCharacterIterator getInstance(char[] cArr) {
        return getInstance(cArr, 0, cArr.length);
    }

    @Override // 
    /* JADX INFO: renamed from: clone */
    public UCharacterIterator mo2clone() {
        return (UCharacterIterator) super.clone();
    }

    public abstract int current();

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

    public CharacterIterator getCharacterIterator() {
        return new UCharacterIteratorWrapper(this);
    }

    public abstract int getIndex();

    public abstract int getLength();

    public abstract int getText(char[] cArr, int i);

    public String getText() {
        char[] cArr = new char[getLength()];
        getText(cArr);
        return new String(cArr);
    }

    public int moveCodePointIndex(int i) {
        if (i > 0) {
            while (i > 0 && nextCodePoint() != -1) {
                i--;
            }
        } else {
            while (i < 0 && previousCodePoint() != -1) {
                i++;
            }
        }
        if (i == 0) {
            return getIndex();
        }
        throw new IndexOutOfBoundsException();
    }

    public int moveIndex(int i) {
        int iMax = Math.max(0, Math.min(getIndex() + i, getLength()));
        setIndex(iMax);
        return iMax;
    }

    public abstract int next();

    @Override // com.ibm.icu.text.UForwardCharacterIterator
    public int nextCodePoint() {
        int next = next();
        if (UTF16.isLeadSurrogate(next)) {
            int next2 = next();
            if (UTF16.isTrailSurrogate(next2)) {
                return Character.toCodePoint((char) next, (char) next2);
            }
            if (next2 != -1) {
                previous();
            }
        }
        return next;
    }

    public abstract int previous();

    public int previousCodePoint() {
        int iPrevious = previous();
        if (UTF16.isTrailSurrogate(iPrevious)) {
            int iPrevious2 = previous();
            if (UTF16.isLeadSurrogate(iPrevious2)) {
                return Character.toCodePoint((char) iPrevious2, (char) iPrevious);
            }
            if (iPrevious2 != -1) {
                next();
            }
        }
        return iPrevious;
    }

    public abstract void setIndex(int i);

    public void setToLimit() {
        setIndex(getLength());
    }

    public void setToStart() {
        setIndex(0);
    }

    public static final UCharacterIterator getInstance(String str) {
        return new ReplaceableUCharacterIterator(str);
    }

    public static final UCharacterIterator getInstance(Replaceable replaceable) {
        return new ReplaceableUCharacterIterator(replaceable);
    }

    public static final UCharacterIterator getInstance(char[] cArr, int i, int i2) {
        return new UCharArrayIterator(cArr, i, i2);
    }

    public static final UCharacterIterator getInstance(StringBuffer stringBuffer) {
        return new ReplaceableUCharacterIterator(stringBuffer);
    }

    public static final UCharacterIterator getInstance(CharacterIterator characterIterator) {
        return new CharacterIteratorWrapper(characterIterator);
    }

    public final int getText(char[] cArr) {
        return getText(cArr, 0);
    }
}
