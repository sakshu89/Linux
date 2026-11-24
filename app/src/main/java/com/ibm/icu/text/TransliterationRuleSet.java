package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class TransliterationRuleSet {
    private int[] index;
    private TransliterationRule[] rules;
    private List<TransliterationRule> ruleVector = new ArrayList();
    private int maxContextLength = 0;

    public void addRule(TransliterationRule transliterationRule) {
        this.ruleVector.add(transliterationRule);
        int anteContextLength = transliterationRule.getAnteContextLength();
        if (anteContextLength > this.maxContextLength) {
            this.maxContextLength = anteContextLength;
        }
        this.rules = null;
    }

    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        UnicodeSet unicodeSet4 = new UnicodeSet(unicodeSet);
        UnicodeSet unicodeSet5 = new UnicodeSet();
        int size = this.ruleVector.size();
        for (int i = 0; i < size; i++) {
            this.ruleVector.get(i).addSourceTargetSet(unicodeSet4, unicodeSet2, unicodeSet3, unicodeSet5.clear());
            unicodeSet4.addAll(unicodeSet5);
        }
    }

    public void freeze() {
        int[] iArr;
        int i;
        int size = this.ruleVector.size();
        this.index = new int[UCharacter.UnicodeBlock.EARLY_DYNASTIC_CUNEIFORM_ID];
        ArrayList arrayList = new ArrayList(size * 2);
        int[] iArr2 = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = this.ruleVector.get(i3).getIndexValue();
        }
        int i4 = 0;
        while (true) {
            iArr = this.index;
            if (i4 >= 256) {
                break;
            }
            iArr[i4] = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                int i6 = iArr2[i5];
                if (i6 < 0) {
                    TransliterationRule transliterationRule = this.ruleVector.get(i5);
                    if (transliterationRule.matchesIndexValue(i4)) {
                        arrayList.add(transliterationRule);
                    }
                } else if (i6 == i4) {
                    arrayList.add(this.ruleVector.get(i5));
                }
            }
            i4++;
        }
        iArr[256] = arrayList.size();
        TransliterationRule[] transliterationRuleArr = new TransliterationRule[arrayList.size()];
        this.rules = transliterationRuleArr;
        arrayList.toArray(transliterationRuleArr);
        StringBuilder sb = null;
        while (i2 < 256) {
            int i7 = this.index[i2];
            while (true) {
                i = i2 + 1;
                if (i7 < this.index[i] - 1) {
                    TransliterationRule transliterationRule2 = this.rules[i7];
                    i7++;
                    for (int i8 = i7; i8 < this.index[i]; i8++) {
                        TransliterationRule transliterationRule3 = this.rules[i8];
                        if (transliterationRule2.masks(transliterationRule3)) {
                            if (sb == null) {
                                sb = new StringBuilder();
                            } else {
                                sb.append("\n");
                            }
                            sb.append("Rule " + String.valueOf(transliterationRule2) + " masks " + String.valueOf(transliterationRule3));
                        }
                    }
                }
            }
            i2 = i;
        }
        if (sb != null) {
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public int getMaximumContextLength() {
        return this.maxContextLength;
    }

    public String toRules(boolean z) {
        int size = this.ruleVector.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append('\n');
            }
            sb.append(this.ruleVector.get(i).toRule(z));
        }
        return sb.toString();
    }

    public boolean transliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        int iChar32At = replaceable.char32At(position.start) & 255;
        for (int i = this.index[iChar32At]; i < this.index[iChar32At + 1]; i++) {
            int iMatchAndReplace = this.rules[i].matchAndReplace(replaceable, position, z);
            if (iMatchAndReplace == 1) {
                return false;
            }
            if (iMatchAndReplace == 2) {
                return true;
            }
        }
        int i2 = position.start;
        position.start = UTF16.getCharCount(replaceable.char32At(i2)) + i2;
        return true;
    }
}
