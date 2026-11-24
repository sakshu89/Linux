package com.ibm.icu.message2;

import com.ibm.icu.text.ConstrainedFieldPosition;
import com.ibm.icu.text.FormattedValue;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.text.AttributedCharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PlainStringFormattedValue implements FormattedValue {
    private final String value;

    public PlainStringFormattedValue(String str) {
        if (str == null) {
            throw new IllegalAccessError("Should not try to wrap a null in a formatted value");
        }
        this.value = str;
    }

    @Override // com.ibm.icu.text.FormattedValue
    public <A extends Appendable> A appendTo(A a) {
        try {
            a.append(this.value);
            return a;
        } catch (IOException e) {
            throw new UncheckedIOException("problem appending", e);
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.value.charAt(i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        String str = this.value;
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    @Override // com.ibm.icu.text.FormattedValue
    public boolean nextPosition(ConstrainedFieldPosition constrainedFieldPosition) {
        throw new RuntimeException("nextPosition not yet implemented");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.value.subSequence(i, i2);
    }

    @Override // com.ibm.icu.text.FormattedValue
    public AttributedCharacterIterator toCharacterIterator() {
        throw new RuntimeException("toCharacterIterator not yet implemented");
    }

    @Override // com.ibm.icu.text.FormattedValue, java.lang.CharSequence
    public String toString() {
        return this.value;
    }
}
