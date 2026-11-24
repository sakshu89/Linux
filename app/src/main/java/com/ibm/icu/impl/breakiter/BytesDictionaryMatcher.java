package com.ibm.icu.impl.breakiter;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.util.BytesTrie;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class BytesDictionaryMatcher extends DictionaryMatcher {
    private final byte[] characters;
    private final int transform;

    public BytesDictionaryMatcher(byte[] bArr, int i) {
        this.characters = bArr;
        Assert.assrt((2130706432 & i) == 16777216);
        this.transform = i;
    }

    private int transform(int i) {
        if (i == 8205) {
            return 255;
        }
        if (i == 8204) {
            return 254;
        }
        int i2 = i - (this.transform & DictionaryData.TRANSFORM_OFFSET_MASK);
        if (i2 < 0 || 253 < i2) {
            return -1;
        }
        return i2;
    }

    @Override // com.ibm.icu.impl.breakiter.DictionaryMatcher
    public int getType() {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c A[PHI: r5
      0x003c: PHI (r5v3 int) = (r5v1 int), (r5v4 int) binds: [B:16:0x0039, B:13:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.ibm.icu.impl.breakiter.DictionaryMatcher
    public int matches(CharacterIterator characterIterator, int i, int[] iArr, int[] iArr2, int i2, int[] iArr3) {
        int iNextCodePoint;
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(characterIterator);
        BytesTrie bytesTrie = new BytesTrie(this.characters, 0);
        int iNextCodePoint2 = uCharacterIterator.nextCodePoint();
        if (iNextCodePoint2 == -1) {
            return 0;
        }
        BytesTrie.Result resultFirst = bytesTrie.first(transform(iNextCodePoint2));
        int i3 = 1;
        int i4 = 0;
        while (true) {
            if (resultFirst.hasValue()) {
                if (i4 < i2) {
                    if (iArr3 != null) {
                        iArr3[i4] = bytesTrie.getValue();
                    }
                    iArr[i4] = i3;
                    i4++;
                }
                if (resultFirst != BytesTrie.Result.FINAL_VALUE) {
                    if (i3 < i || (iNextCodePoint = uCharacterIterator.nextCodePoint()) == -1) {
                        break;
                    }
                    i3++;
                    resultFirst = bytesTrie.next(transform(iNextCodePoint));
                } else {
                    break;
                }
            } else {
                if (resultFirst == BytesTrie.Result.NO_MATCH) {
                    break;
                }
                if (i3 < i) {
                    break;
                }
                i3++;
                resultFirst = bytesTrie.next(transform(iNextCodePoint));
            }
        }
        iArr2[0] = i4;
        return i3;
    }
}
