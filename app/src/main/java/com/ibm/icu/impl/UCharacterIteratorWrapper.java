package com.ibm.icu.impl;

import com.ibm.icu.text.UCharacterIterator;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UCharacterIteratorWrapper implements CharacterIterator, Cloneable {
    private UCharacterIterator iterator;

    public UCharacterIteratorWrapper(UCharacterIterator uCharacterIterator) {
        this.iterator = uCharacterIterator;
    }

    @Override // java.text.CharacterIterator
    public UCharacterIteratorWrapper clone() {
        try {
            UCharacterIteratorWrapper uCharacterIteratorWrapper = (UCharacterIteratorWrapper) super.clone();
            uCharacterIteratorWrapper.iterator = this.iterator.mo2clone();
            return uCharacterIteratorWrapper;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.text.CharacterIterator
    public char current() {
        return (char) this.iterator.current();
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.iterator.setToStart();
        return (char) this.iterator.current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return 0;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.iterator.getLength();
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.iterator.getIndex();
    }

    @Override // java.text.CharacterIterator
    public char last() {
        this.iterator.setToLimit();
        return (char) this.iterator.previous();
    }

    @Override // java.text.CharacterIterator
    public char next() {
        this.iterator.next();
        return (char) this.iterator.current();
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        return (char) this.iterator.previous();
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int i) {
        this.iterator.setIndex(i);
        return (char) this.iterator.current();
    }
}
