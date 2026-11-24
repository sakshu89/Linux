package com.ibm.icu.lang;

import com.ibm.icu.impl.CharacterPropertiesImpl;
import com.ibm.icu.impl.EmojiProps;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.CodePointMap;
import com.ibm.icu.util.CodePointTrie;
import com.ibm.icu.util.MutableCodePointTrie;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CharacterProperties {
    private static final AtomicReferenceArray<UnicodeSet> SETS = new AtomicReferenceArray<>(76);
    private static final AtomicReferenceArray<CodePointMap> MAPS = new AtomicReferenceArray<>(27);

    private CharacterProperties() {
    }

    public static final UnicodeSet getBinaryPropertySet(int i) {
        if (i < 0 || 76 <= i) {
            throw new IllegalArgumentException(i + " is not a constant for a UProperty binary property");
        }
        AtomicReferenceArray<UnicodeSet> atomicReferenceArray = SETS;
        UnicodeSet unicodeSet = atomicReferenceArray.get(i);
        if (unicodeSet != null) {
            return unicodeSet;
        }
        UnicodeSet unicodeSetMakeSet = makeSet(i);
        while (!atomicReferenceArray.compareAndSet(i, null, unicodeSetMakeSet)) {
            if (atomicReferenceArray.get(i) != null) {
                return SETS.get(i);
            }
        }
        return unicodeSetMakeSet;
    }

    public static final CodePointMap getIntPropertyMap(int i) {
        if (i < 4096 || 4123 <= i) {
            throw new IllegalArgumentException(i + " is not a constant for a UProperty int property");
        }
        int i2 = i - 4096;
        AtomicReferenceArray<CodePointMap> atomicReferenceArray = MAPS;
        CodePointMap codePointMap = atomicReferenceArray.get(i2);
        if (codePointMap != null) {
            return codePointMap;
        }
        CodePointMap codePointMapMakeMap = makeMap(i);
        while (!atomicReferenceArray.compareAndSet(i2, null, codePointMapMakeMap)) {
            if (atomicReferenceArray.get(i2) != null) {
                return MAPS.get(i2);
            }
        }
        return codePointMapMakeMap;
    }

    private static CodePointMap makeMap(int i) {
        int i2 = i == 4106 ? 103 : 0;
        MutableCodePointTrie mutableCodePointTrie = new MutableCodePointTrie(i2, i2);
        UnicodeSet inclusionsForProperty = CharacterPropertiesImpl.getInclusionsForProperty(i);
        int rangeCount = inclusionsForProperty.getRangeCount();
        int i3 = i2;
        int i4 = 0;
        for (int i5 = 0; i5 < rangeCount; i5++) {
            int rangeEnd = inclusionsForProperty.getRangeEnd(i5);
            for (int rangeStart = inclusionsForProperty.getRangeStart(i5); rangeStart <= rangeEnd; rangeStart++) {
                int intPropertyValue = UCharacter.getIntPropertyValue(rangeStart, i);
                if (i3 != intPropertyValue) {
                    if (i3 != i2) {
                        mutableCodePointTrie.setRange(i4, rangeStart - 1, i3);
                    }
                    i4 = rangeStart;
                    i3 = intPropertyValue;
                }
            }
        }
        if (i3 != 0) {
            mutableCodePointTrie.setRange(i4, 1114111, i3);
        }
        CodePointTrie.Type type = (i == 4096 || i == 4101) ? CodePointTrie.Type.FAST : CodePointTrie.Type.SMALL;
        int intPropertyMaxValue = UCharacter.getIntPropertyMaxValue(i);
        return mutableCodePointTrie.buildImmutable(type, intPropertyMaxValue <= 255 ? CodePointTrie.ValueWidth.BITS_8 : intPropertyMaxValue <= 65535 ? CodePointTrie.ValueWidth.BITS_16 : CodePointTrie.ValueWidth.BITS_32);
    }

    private static UnicodeSet makeSet(int i) {
        UnicodeSet unicodeSet = new UnicodeSet();
        if (65 <= i && i <= 71) {
            EmojiProps.INSTANCE.addStrings(i, unicodeSet);
            if (i != 65 && i != 71) {
                return unicodeSet.freeze();
            }
        }
        UnicodeSet inclusionsForProperty = CharacterPropertiesImpl.getInclusionsForProperty(i);
        int rangeCount = inclusionsForProperty.getRangeCount();
        int i2 = -1;
        for (int i3 = 0; i3 < rangeCount; i3++) {
            int rangeEnd = inclusionsForProperty.getRangeEnd(i3);
            for (int rangeStart = inclusionsForProperty.getRangeStart(i3); rangeStart <= rangeEnd; rangeStart++) {
                if (UCharacter.hasBinaryProperty(rangeStart, i)) {
                    if (i2 < 0) {
                        i2 = rangeStart;
                    }
                } else if (i2 >= 0) {
                    unicodeSet.add(i2, rangeStart - 1);
                    i2 = -1;
                }
            }
        }
        if (i2 >= 0) {
            unicodeSet.add(i2, 1114111);
        }
        return unicodeSet.freeze();
    }
}
