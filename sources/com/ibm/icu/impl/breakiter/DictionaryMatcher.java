package com.ibm.icu.impl.breakiter;

import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
abstract class DictionaryMatcher {
    public abstract int getType();

    public int matches(CharacterIterator characterIterator, int i, int[] iArr, int[] iArr2, int i2) {
        return matches(characterIterator, i, iArr, iArr2, i2, null);
    }

    public abstract int matches(CharacterIterator characterIterator, int i, int[] iArr, int[] iArr2, int i2, int[] iArr3);
}
