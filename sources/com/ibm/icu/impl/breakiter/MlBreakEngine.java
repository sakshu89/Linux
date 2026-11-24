package com.ibm.icu.impl.breakiter;

import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MlBreakEngine {
    private static final int MAX_FEATURE = 13;
    private UnicodeSet fClosePunctuationSet;
    private UnicodeSet fDigitOrOpenPunctuationOrAlphabetSet;
    private List<HashMap<String, Integer>> fModel = new ArrayList(13);
    private int fNegativeSum;

    public MlBreakEngine(UnicodeSet unicodeSet, UnicodeSet unicodeSet2) {
        this.fDigitOrOpenPunctuationOrAlphabetSet = unicodeSet;
        this.fClosePunctuationSet = unicodeSet2;
        for (int i = 0; i < 13; i++) {
            this.fModel.add(new HashMap<>());
        }
        this.fNegativeSum = 0;
        loadMLModel();
    }

    private void evaluateBreakpoint(String str, int[] iArr, int i, int i2, ArrayList<Integer> arrayList) {
        int iIntValue = this.fNegativeSum;
        for (int i3 = 0; i3 < 6; i3++) {
            int i4 = i + i3;
            if (iArr[i4] != -1) {
                int i5 = iArr[i4 + 1];
                if (i5 == -1) {
                    i5 = i2;
                }
                iIntValue = this.fModel.get(ModelIndex.kUWStart.getValue() + i3).getOrDefault(str.substring(iArr[i4], i5), 0).intValue() + iIntValue;
            }
        }
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = i + i6;
            int i8 = i7 + 1;
            if (iArr[i8] != -1 && iArr[i7 + 2] != -1) {
                int i9 = iArr[i7 + 3];
                if (i9 == -1) {
                    i9 = i2;
                }
                iIntValue = this.fModel.get(ModelIndex.kBWStart.getValue() + i6).getOrDefault(str.substring(iArr[i8], i9), 0).intValue() + iIntValue;
            }
        }
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = i + i10;
            if (iArr[i11] != -1 && iArr[i11 + 1] != -1 && iArr[i11 + 2] != -1) {
                int i12 = iArr[i11 + 3];
                if (i12 == -1) {
                    i12 = i2;
                }
                iIntValue = this.fModel.get(ModelIndex.kTWStart.getValue() + i10).getOrDefault(str.substring(iArr[i11], i12), 0).intValue() + iIntValue;
            }
        }
        if (iIntValue > 0) {
            arrayList.add(Integer.valueOf(i + 1));
        }
    }

    private int initIndexList(CharacterIterator characterIterator, int[] iArr, int i) {
        int iCharCount = 0;
        characterIterator.setIndex(0);
        Arrays.fill(iArr, -1);
        if (i > 0) {
            iArr[2] = 0;
            iCharCount = Character.charCount(CharacterIteration.current32(characterIterator));
            if (i > 1) {
                iArr[3] = iCharCount;
                int iCharCount2 = Character.charCount(CharacterIteration.next32(characterIterator)) + iCharCount;
                if (i <= 2) {
                    return iCharCount2;
                }
                iArr[4] = iCharCount2;
                int iCharCount3 = Character.charCount(CharacterIteration.next32(characterIterator)) + iCharCount2;
                if (i <= 3) {
                    return iCharCount3;
                }
                iArr[5] = iCharCount3;
                return Character.charCount(CharacterIteration.next32(characterIterator)) + iCharCount3;
            }
        }
        return iCharCount;
    }

    private void initKeyValue(UResourceBundle uResourceBundle, String str, String str2, HashMap<String, Integer> map) {
        UResourceBundle uResourceBundle2 = uResourceBundle.get(str);
        int[] intVector = uResourceBundle.get(str2).getIntVector();
        UResourceBundleIterator iterator = uResourceBundle2.getIterator();
        int i = 0;
        while (iterator.hasNext()) {
            this.fNegativeSum -= intVector[i];
            map.put(iterator.nextString(), Integer.valueOf(intVector[i]));
            i++;
        }
    }

    private void loadMLModel() {
        UResourceBundle bundleInstance = UResourceBundle.getBundleInstance(ICUData.ICU_BRKITR_BASE_NAME, "jaml");
        initKeyValue(bundleInstance, "UW1Keys", "UW1Values", this.fModel.get(0));
        initKeyValue(bundleInstance, "UW2Keys", "UW2Values", this.fModel.get(1));
        initKeyValue(bundleInstance, "UW3Keys", "UW3Values", this.fModel.get(2));
        initKeyValue(bundleInstance, "UW4Keys", "UW4Values", this.fModel.get(3));
        initKeyValue(bundleInstance, "UW5Keys", "UW5Values", this.fModel.get(4));
        initKeyValue(bundleInstance, "UW6Keys", "UW6Values", this.fModel.get(5));
        initKeyValue(bundleInstance, "BW1Keys", "BW1Values", this.fModel.get(6));
        initKeyValue(bundleInstance, "BW2Keys", "BW2Values", this.fModel.get(7));
        initKeyValue(bundleInstance, "BW3Keys", "BW3Values", this.fModel.get(8));
        initKeyValue(bundleInstance, "TW1Keys", "TW1Values", this.fModel.get(9));
        initKeyValue(bundleInstance, "TW2Keys", "TW2Values", this.fModel.get(10));
        initKeyValue(bundleInstance, "TW3Keys", "TW3Values", this.fModel.get(11));
        initKeyValue(bundleInstance, "TW4Keys", "TW4Values", this.fModel.get(12));
        this.fNegativeSum /= 2;
    }

    private String transform(CharacterIterator characterIterator) {
        StringBuilder sb = new StringBuilder();
        characterIterator.setIndex(0);
        char cFirst = characterIterator.first();
        while (cFirst != 65535) {
            sb.append(cFirst);
            cFirst = characterIterator.next();
        }
        return sb.toString();
    }

    public int divideUpRange(CharacterIterator characterIterator, int i, int i2, CharacterIterator characterIterator2, int i3, int[] iArr, DictionaryBreakEngine.DequeI dequeI) {
        int i4 = 0;
        if (i >= i2) {
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>(i3);
        String strTransform = transform(characterIterator2);
        int[] iArr2 = new int[i3 + 4];
        int iInitIndexList = initIndexList(characterIterator2, iArr2, i3);
        arrayList.add(0, 0);
        int i5 = 0;
        int iCharCount = iInitIndexList;
        while (true) {
            int i6 = i5 + 1;
            if (i6 >= i3) {
                break;
            }
            MlBreakEngine mlBreakEngine = this;
            mlBreakEngine.evaluateBreakpoint(strTransform, iArr2, i5, iCharCount, arrayList);
            if (i5 + 4 < i3) {
                iArr2[i5 + 6] = iCharCount;
                iCharCount = Character.charCount(CharacterIteration.next32(characterIterator2)) + iCharCount;
            }
            this = mlBreakEngine;
            i5 = i6;
        }
        MlBreakEngine mlBreakEngine2 = this;
        if (arrayList.get(arrayList.size() - 1).intValue() != i3) {
            arrayList.add(Integer.valueOf(i3));
        }
        int size = arrayList.size();
        int i7 = -1;
        int i8 = 0;
        while (i4 < size) {
            int i9 = iArr[arrayList.get(i4).intValue()] + i;
            characterIterator.setIndex(i9);
            if (i9 > i7 && (i9 != i || (i9 > 0 && mlBreakEngine2.fClosePunctuationSet.contains(CharacterIteration.previous32(characterIterator))))) {
                dequeI.push(i9);
                i8++;
            }
            i4++;
            i7 = i9;
        }
        if (!dequeI.isEmpty() && dequeI.peek() == i2) {
            characterIterator.setIndex(i2);
            int iCurrent32 = CharacterIteration.current32(characterIterator);
            if (iCurrent32 != Integer.MAX_VALUE && !mlBreakEngine2.fDigitOrOpenPunctuationOrAlphabetSet.contains(iCurrent32)) {
                dequeI.pop();
                i8--;
            }
        }
        if (!dequeI.isEmpty()) {
            characterIterator.setIndex(dequeI.peek());
        }
        return i8;
    }
}
