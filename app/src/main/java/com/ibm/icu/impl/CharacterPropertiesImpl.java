package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UnicodeSet;
import defpackage.cq;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CharacterPropertiesImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int NUM_INCLUSIONS = 47;
    private static final UnicodeSet[] inclusions = new UnicodeSet[47];

    public static synchronized void clear() {
        int i = 0;
        while (true) {
            UnicodeSet[] unicodeSetArr = inclusions;
            if (i < unicodeSetArr.length) {
                unicodeSetArr[i] = null;
                i++;
            }
        }
    }

    public static synchronized UnicodeSet getInclusionsForProperty(int i) {
        try {
            if (4096 > i || i >= 4123) {
                return getInclusionsForSource(UCharacterProperty.INSTANCE.getSource(i));
            }
            return getIntPropInclusions(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    private static UnicodeSet getInclusionsForSource(int i) {
        UnicodeSet[] unicodeSetArr = inclusions;
        if (unicodeSetArr[i] == null) {
            UnicodeSet unicodeSet = new UnicodeSet();
            switch (i) {
                case 1:
                    UCharacterProperty.INSTANCE.addPropertyStarts(unicodeSet);
                    break;
                case 2:
                    UCharacterProperty.INSTANCE.upropsvec_addPropertyStarts(unicodeSet);
                    break;
                case 3:
                default:
                    og.n(cq.h("getInclusions(unknown src ", i, ")"));
                    return null;
                case 4:
                    UCaseProps.INSTANCE.addPropertyStarts(unicodeSet);
                    break;
                case 5:
                    UBiDiProps.INSTANCE.addPropertyStarts(unicodeSet);
                    break;
                case 6:
                    UCharacterProperty uCharacterProperty = UCharacterProperty.INSTANCE;
                    uCharacterProperty.addPropertyStarts(unicodeSet);
                    uCharacterProperty.upropsvec_addPropertyStarts(unicodeSet);
                    break;
                case 7:
                    Norm2AllModes.getNFCInstance().impl.addPropertyStarts(unicodeSet);
                    UCaseProps.INSTANCE.addPropertyStarts(unicodeSet);
                    break;
                case 8:
                    Norm2AllModes.getNFCInstance().impl.addPropertyStarts(unicodeSet);
                    break;
                case 9:
                    Norm2AllModes.getNFKCInstance().impl.addPropertyStarts(unicodeSet);
                    break;
                case 10:
                    Norm2AllModes.getNFKC_CFInstance().impl.addPropertyStarts(unicodeSet);
                    break;
                case 11:
                    Norm2AllModes.getNFCInstance().impl.addCanonIterPropertyStarts(unicodeSet);
                    break;
                case 12:
                case 13:
                case 14:
                    UCharacterProperty.ulayout_addPropertyStarts(i, unicodeSet);
                    break;
                case 15:
                    EmojiProps.INSTANCE.addPropertyStarts(unicodeSet);
                    break;
                case 16:
                    unicodeSet.add(12286);
                    unicodeSet.add(12288);
                    break;
                case 17:
                    UCharacterProperty.mathCompat_addPropertyStarts(unicodeSet);
                    break;
                case 18:
                    UCharacterProperty.INSTANCE.ublock_addPropertyStarts(unicodeSet);
                    break;
                case 19:
                    UCharacterProperty.mcm_addPropertyStarts(unicodeSet);
                    break;
            }
            unicodeSetArr[i] = unicodeSet.compact();
        }
        return unicodeSetArr[i];
    }

    private static UnicodeSet getIntPropInclusions(int i) {
        int i2 = i - 4076;
        UnicodeSet unicodeSet = inclusions[i2];
        if (unicodeSet != null) {
            return unicodeSet;
        }
        UnicodeSet inclusionsForSource = getInclusionsForSource(UCharacterProperty.INSTANCE.getSource(i));
        UnicodeSet unicodeSet2 = new UnicodeSet(0, 0);
        int rangeCount = inclusionsForSource.getRangeCount();
        int i3 = 0;
        for (int i4 = 0; i4 < rangeCount; i4++) {
            int rangeEnd = inclusionsForSource.getRangeEnd(i4);
            for (int rangeStart = inclusionsForSource.getRangeStart(i4); rangeStart <= rangeEnd; rangeStart++) {
                int intPropertyValue = UCharacter.getIntPropertyValue(rangeStart, i);
                if (intPropertyValue != i3) {
                    unicodeSet2.add(rangeStart);
                    i3 = intPropertyValue;
                }
            }
        }
        UnicodeSet[] unicodeSetArr = inclusions;
        UnicodeSet unicodeSetCompact = unicodeSet2.compact();
        unicodeSetArr[i2] = unicodeSetCompact;
        return unicodeSetCompact;
    }
}
