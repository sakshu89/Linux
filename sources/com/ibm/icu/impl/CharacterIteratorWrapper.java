package com.ibm.icu.impl;

import com.ibm.icu.text.UCharacterIterator;
import defpackage.dk0;
import defpackage.og;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CharacterIteratorWrapper extends UCharacterIterator implements Cloneable {
    private CharacterIterator iterator;

    public CharacterIteratorWrapper(CharacterIterator characterIterator) {
        if (characterIterator != null) {
            this.iterator = characterIterator;
        } else {
            dk0.v();
            throw null;
        }
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CharacterIteratorWrapper mo2clone() {
        try {
            CharacterIteratorWrapper characterIteratorWrapper = (CharacterIteratorWrapper) super.mo2clone();
            characterIteratorWrapper.iterator = (CharacterIterator) this.iterator.clone();
            return characterIteratorWrapper;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int current() {
        char cCurrent = this.iterator.current();
        if (cCurrent == 65535) {
            return -1;
        }
        return cCurrent;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public CharacterIterator getCharacterIterator() {
        return (CharacterIterator) this.iterator.clone();
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getIndex() {
        return this.iterator.getIndex();
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getLength() {
        return this.iterator.getEndIndex() - this.iterator.getBeginIndex();
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getText(char[] cArr, int i) {
        int endIndex = this.iterator.getEndIndex() - this.iterator.getBeginIndex();
        int index = this.iterator.getIndex();
        if (i < 0 || i + endIndex > cArr.length) {
            og.o(Integer.toString(endIndex));
            return 0;
        }
        char cFirst = this.iterator.first();
        while (cFirst != 65535) {
            cArr[i] = cFirst;
            cFirst = this.iterator.next();
            i++;
        }
        this.iterator.setIndex(index);
        return endIndex;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int moveIndex(int i) {
        int endIndex = this.iterator.getEndIndex() - this.iterator.getBeginIndex();
        int index = this.iterator.getIndex() + i;
        if (index < 0) {
            endIndex = 0;
        } else if (index <= endIndex) {
            endIndex = index;
        }
        return this.iterator.setIndex(endIndex);
    }

    @Override // com.ibm.icu.text.UCharacterIterator, com.ibm.icu.text.UForwardCharacterIterator
    public int next() {
        char cCurrent = this.iterator.current();
        this.iterator.next();
        if (cCurrent == 65535) {
            return -1;
        }
        return cCurrent;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int previous() {
        char cPrevious = this.iterator.previous();
        if (cPrevious == 65535) {
            return -1;
        }
        return cPrevious;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public void setIndex(int i) {
        try {
            this.iterator.setIndex(i);
        } catch (IllegalArgumentException unused) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public void setToLimit() {
        CharacterIterator characterIterator = this.iterator;
        characterIterator.setIndex(characterIterator.getEndIndex());
    }
}
