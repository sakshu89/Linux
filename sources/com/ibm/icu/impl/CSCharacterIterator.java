package com.ibm.icu.impl;

import defpackage.dk0;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CSCharacterIterator implements CharacterIterator, Cloneable {
    private int index;
    private CharSequence seq;

    public CSCharacterIterator(CharSequence charSequence) {
        charSequence.getClass();
        this.seq = charSequence;
        this.index = 0;
    }

    @Override // java.text.CharacterIterator
    public CSCharacterIterator clone() {
        CSCharacterIterator cSCharacterIterator = new CSCharacterIterator(this.seq);
        cSCharacterIterator.setIndex(this.index);
        return cSCharacterIterator;
    }

    @Override // java.text.CharacterIterator
    public char current() {
        if (this.index == this.seq.length()) {
            return (char) 65535;
        }
        return this.seq.charAt(this.index);
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.index = 0;
        return current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return 0;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.seq.length();
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.index;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        this.index = this.seq.length();
        return previous();
    }

    @Override // java.text.CharacterIterator
    public char next() {
        if (this.index < this.seq.length()) {
            this.index++;
        }
        return current();
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int i = this.index;
        if (i == 0) {
            return (char) 65535;
        }
        this.index = i - 1;
        return current();
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int i) {
        if (i < 0 || i > this.seq.length()) {
            dk0.v();
            return (char) 0;
        }
        this.index = i;
        return current();
    }
}
