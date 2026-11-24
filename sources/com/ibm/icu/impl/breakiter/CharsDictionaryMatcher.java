package com.ibm.icu.impl.breakiter;

import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.CharsTrie;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class CharsDictionaryMatcher extends DictionaryMatcher {
    private CharSequence characters;

    public CharsDictionaryMatcher(CharSequence charSequence) {
        this.characters = charSequence;
    }

    @Override // com.ibm.icu.impl.breakiter.DictionaryMatcher
    public int getType() {
        return 1;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0038 A[PHI: r4
      0x0038: PHI (r4v3 int) = (r4v1 int), (r4v4 int) binds: [B:16:0x0035, B:13:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.ibm.icu.impl.breakiter.DictionaryMatcher
    public int matches(CharacterIterator characterIterator, int i, int[] iArr, int[] iArr2, int i2, int[] iArr3) {
        int iNextCodePoint;
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(characterIterator);
        CharsTrie charsTrie = new CharsTrie(this.characters, 0);
        int iNextCodePoint2 = uCharacterIterator.nextCodePoint();
        if (iNextCodePoint2 == -1) {
            return 0;
        }
        BytesTrie.Result resultFirstForCodePoint = charsTrie.firstForCodePoint(iNextCodePoint2);
        int i3 = 1;
        int i4 = 0;
        while (true) {
            if (resultFirstForCodePoint.hasValue()) {
                if (i4 < i2) {
                    if (iArr3 != null) {
                        iArr3[i4] = charsTrie.getValue();
                    }
                    iArr[i4] = i3;
                    i4++;
                }
                if (resultFirstForCodePoint != BytesTrie.Result.FINAL_VALUE) {
                    if (i3 < i || (iNextCodePoint = uCharacterIterator.nextCodePoint()) == -1) {
                        break;
                    }
                    i3++;
                    resultFirstForCodePoint = charsTrie.nextForCodePoint(iNextCodePoint);
                } else {
                    break;
                }
            } else {
                if (resultFirstForCodePoint == BytesTrie.Result.NO_MATCH) {
                    break;
                }
                if (i3 < i) {
                    break;
                }
                i3++;
                resultFirstForCodePoint = charsTrie.nextForCodePoint(iNextCodePoint);
            }
        }
        iArr2[0] = i4;
        return i3;
    }
}
