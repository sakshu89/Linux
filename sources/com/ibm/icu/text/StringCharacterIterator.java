package com.ibm.icu.text;

import com.ibm.icu.util.ICUCloneNotSupportedException;
import defpackage.og;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class StringCharacterIterator implements CharacterIterator, Cloneable {
    private int begin;
    private int end;
    private int pos;
    private String text;

    @Deprecated
    public StringCharacterIterator(String str, int i, int i2, int i3) {
        str.getClass();
        this.text = str;
        if (i < 0 || i > i2 || i2 > str.length()) {
            og.i("Invalid substring range");
            throw null;
        }
        if (i3 < i || i3 > i2) {
            og.i("Invalid position");
            throw null;
        }
        this.begin = i;
        this.end = i2;
        this.pos = i3;
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public StringCharacterIterator clone() {
        try {
            return (StringCharacterIterator) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public char current() {
        int i = this.pos;
        if (i < this.begin || i >= this.end) {
            return (char) 65535;
        }
        return this.text.charAt(i);
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringCharacterIterator)) {
            return false;
        }
        StringCharacterIterator stringCharacterIterator = (StringCharacterIterator) obj;
        return hashCode() == stringCharacterIterator.hashCode() && this.text.equals(stringCharacterIterator.text) && this.pos == stringCharacterIterator.pos && this.begin == stringCharacterIterator.begin && this.end == stringCharacterIterator.end;
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public char first() {
        this.pos = this.begin;
        return current();
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public int getBeginIndex() {
        return this.begin;
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public int getIndex() {
        return this.pos;
    }

    @Deprecated
    public int hashCode() {
        return this.end ^ ((this.text.hashCode() ^ this.pos) ^ this.begin);
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public char last() {
        int i = this.end;
        if (i != this.begin) {
            this.pos = i - 1;
        } else {
            this.pos = i;
        }
        return current();
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public char next() {
        int i = this.pos;
        int i2 = this.end;
        if (i >= i2 - 1) {
            this.pos = i2;
            return (char) 65535;
        }
        int i3 = i + 1;
        this.pos = i3;
        return this.text.charAt(i3);
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public char previous() {
        int i = this.pos;
        if (i <= this.begin) {
            return (char) 65535;
        }
        int i2 = i - 1;
        this.pos = i2;
        return this.text.charAt(i2);
    }

    @Override // java.text.CharacterIterator
    @Deprecated
    public char setIndex(int i) {
        if (i < this.begin || i > this.end) {
            og.i("Invalid index");
            return (char) 0;
        }
        this.pos = i;
        return current();
    }

    @Deprecated
    public void setText(String str) {
        str.getClass();
        this.text = str;
        this.begin = 0;
        this.end = str.length();
        this.pos = 0;
    }

    @Deprecated
    public StringCharacterIterator(String str, int i) {
        this(str, 0, str.length(), i);
    }

    @Deprecated
    public StringCharacterIterator(String str) {
        this(str, 0);
    }
}
