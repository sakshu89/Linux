package com.ibm.icu.text;

import java.text.AttributedCharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface FormattedValue extends CharSequence {
    <A extends Appendable> A appendTo(A a);

    boolean nextPosition(ConstrainedFieldPosition constrainedFieldPosition);

    AttributedCharacterIterator toCharacterIterator();

    @Override // java.lang.CharSequence
    String toString();
}
