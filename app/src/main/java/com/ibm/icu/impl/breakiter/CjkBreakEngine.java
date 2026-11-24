package com.ibm.icu.impl.breakiter;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.text.Normalizer;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.text.UnicodeSetIterator;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CjkBreakEngine extends DictionaryBreakEngine {
    private static final int kMaxKatakanaGroupLength = 20;
    private static final int kMaxKatakanaLength = 8;
    private static final int kint32max = Integer.MAX_VALUE;
    private static final int maxSnlp = 255;
    private UnicodeSet fClosePunctuationSet;
    private DictionaryMatcher fDictionary;
    private UnicodeSet fDigitOrOpenPunctuationOrAlphabetSet;
    private UnicodeSet fHangulWordSet;
    private MlBreakEngine fMlBreakEngine;
    private HashSet<String> fSkipSet;
    private boolean isCj;

    public CjkBreakEngine(boolean z) {
        this.fDictionary = null;
        this.isCj = false;
        UnicodeSet unicodeSet = new UnicodeSet("[\\uac00-\\ud7a3]");
        this.fHangulWordSet = unicodeSet;
        unicodeSet.freeze();
        UnicodeSet unicodeSet2 = new UnicodeSet("[[:Nd:][:Pi:][:Ps:][:Alphabetic:]]");
        this.fDigitOrOpenPunctuationOrAlphabetSet = unicodeSet2;
        unicodeSet2.freeze();
        UnicodeSet unicodeSet3 = new UnicodeSet("[[:Pc:][:Pd:][:Pe:][:Pf:][:Po:]]");
        this.fClosePunctuationSet = unicodeSet3;
        unicodeSet3.freeze();
        this.fSkipSet = new HashSet<>();
        this.fDictionary = DictionaryData.loadDictionaryFor("Hira");
        if (z) {
            setCharacters(this.fHangulWordSet);
            return;
        }
        this.isCj = true;
        setCharacters(new UnicodeSet("[[:Han:][:Hiragana:][:Katakana:]\\u30fc\\uff70\\uff9e\\uff9f]"));
        if (Boolean.parseBoolean(ICUConfig.get("com.ibm.icu.impl.breakiter.useMLPhraseBreaking", "false"))) {
            this.fMlBreakEngine = new MlBreakEngine(this.fDigitOrOpenPunctuationOrAlphabetSet, this.fClosePunctuationSet);
        } else {
            initializeJapanesePhraseParamater();
        }
    }

    private static int getKatakanaCost(int i) {
        int[] iArr = {8192, 984, 408, 240, 204, 252, 300, 372, 480};
        if (i > 8) {
            return 8192;
        }
        return iArr[i];
    }

    private String getPatternFromText(CharacterIterator characterIterator, StringBuffer stringBuffer, int i, int i2) {
        stringBuffer.setLength(0);
        if (i2 > 0) {
            characterIterator.setIndex(i);
            stringBuffer.append(characterIterator.current());
            for (int i3 = 1; i3 < i2; i3++) {
                stringBuffer.append(characterIterator.next());
            }
        }
        return stringBuffer.toString();
    }

    private void initializeJapanesePhraseParamater() {
        loadJapaneseExtensions();
        loadHiragana();
    }

    private static boolean isKatakana(int i) {
        if (i < 12449 || i > 12542 || i == 12539) {
            return i >= 65382 && i <= 65439;
        }
        return true;
    }

    private void loadHiragana() {
        UnicodeSet unicodeSet = new UnicodeSet("[:Hiragana:]");
        unicodeSet.freeze();
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(unicodeSet);
        while (unicodeSetIterator.next()) {
            this.fSkipSet.add(unicodeSetIterator.getString());
        }
    }

    private void loadJapaneseExtensions() {
        UResourceBundleIterator iterator = UResourceBundle.getBundleInstance(ICUData.ICU_BRKITR_BASE_NAME, "ja").get("extensions").getIterator();
        while (iterator.hasNext()) {
            this.fSkipSet.add(iterator.nextString());
        }
    }

    @Override // com.ibm.icu.impl.breakiter.DictionaryBreakEngine
    public int divideUpDictionaryRange(CharacterIterator characterIterator, int i, int i2, DictionaryBreakEngine.DequeI dequeI, boolean z) {
        StringCharacterIterator stringCharacterIterator;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int[] iArr2;
        int katakanaCost;
        int i8 = 0;
        if (i >= i2) {
            return 0;
        }
        characterIterator.setIndex(i);
        int[] iArr3 = new int[(i2 - i) + 1];
        StringBuffer stringBuffer = new StringBuffer("");
        characterIterator.setIndex(i);
        while (characterIterator.getIndex() < i2) {
            stringBuffer.append(characterIterator.current());
            characterIterator.next();
        }
        String string = stringBuffer.toString();
        Normalizer.Mode mode = Normalizer.NFKC;
        if (Normalizer.quickCheck(string, mode) == Normalizer.YES || Normalizer.isNormalized(string, mode, 0)) {
            StringCharacterIterator stringCharacterIterator2 = new StringCharacterIterator(string);
            iArr3[0] = 0;
            int iCharCount = 0;
            i3 = 0;
            while (iCharCount < string.length()) {
                iCharCount += Character.charCount(string.codePointAt(iCharCount));
                i3++;
                iArr3[i3] = iCharCount;
            }
            stringCharacterIterator = stringCharacterIterator2;
        } else {
            String strNormalize = Normalizer.normalize(string, mode);
            stringCharacterIterator = new StringCharacterIterator(strNormalize);
            iArr3 = new int[strNormalize.length() + 1];
            Normalizer normalizer = new Normalizer(string, mode, 0);
            iArr3[0] = 0;
            int i9 = 0;
            int index = 0;
            while (index < normalizer.endIndex()) {
                normalizer.next();
                i9++;
                index = normalizer.getIndex();
                iArr3[i9] = index;
            }
            i3 = i9;
        }
        if (Boolean.parseBoolean(ICUConfig.get("com.ibm.icu.impl.breakiter.useMLPhraseBreaking", "false")) && z && this.isCj) {
            return this.fMlBreakEngine.divideUpRange(characterIterator, i, i2, stringCharacterIterator, i3, iArr3, dequeI);
        }
        int[] iArr4 = iArr3;
        int i10 = i3;
        int i11 = i10 + 1;
        int[] iArr5 = new int[i11];
        iArr5[0] = 0;
        int i12 = 1;
        while (true) {
            i4 = Integer.MAX_VALUE;
            if (i12 > i10) {
                break;
            }
            iArr5[i12] = Integer.MAX_VALUE;
            i12++;
        }
        int[] iArr6 = new int[i11];
        for (int i13 = 0; i13 <= i10; i13++) {
            iArr6[i13] = -1;
        }
        int[] iArr7 = new int[i10];
        int[] iArr8 = iArr6;
        int[] iArr9 = new int[i10];
        stringCharacterIterator.setIndex(0);
        int i14 = 0;
        boolean z2 = false;
        while (i8 < i10) {
            int index2 = stringCharacterIterator.getIndex();
            int i15 = i8;
            if (iArr5[i15] == i4) {
                i7 = i11;
                iArr2 = iArr5;
                iArr = iArr8;
            } else {
                int i16 = i15 + 20 < i10 ? 20 : i10 - i15;
                int[] iArr10 = new int[1];
                iArr = iArr8;
                int i17 = i16;
                int[] iArr11 = iArr5;
                int i18 = i16;
                i7 = i11;
                iArr2 = iArr11;
                this.fDictionary.matches(stringCharacterIterator, i18, iArr9, iArr10, i17, iArr7);
                int i19 = iArr10[0];
                stringCharacterIterator.setIndex(index2);
                if ((i19 == 0 || iArr9[0] != 1) && CharacterIteration.current32(stringCharacterIterator) != Integer.MAX_VALUE && !this.fHangulWordSet.contains(CharacterIteration.current32(stringCharacterIterator))) {
                    iArr7[i19] = 255;
                    iArr9[i19] = 1;
                    i19++;
                }
                for (int i20 = 0; i20 < i19; i20++) {
                    int i21 = iArr2[i15] + iArr7[i20];
                    int i22 = iArr9[i20];
                    if (i21 < iArr2[i22 + i15]) {
                        iArr2[i22 + i15] = i21;
                        iArr[iArr9[i20] + i15] = i15;
                    }
                }
                boolean zIsKatakana = isKatakana(CharacterIteration.current32(stringCharacterIterator));
                if (!z2 && zIsKatakana) {
                    int i23 = i15 + 1;
                    CharacterIteration.next32(stringCharacterIterator);
                    while (i23 < i10 && i23 - i15 < 20 && isKatakana(CharacterIteration.current32(stringCharacterIterator))) {
                        CharacterIteration.next32(stringCharacterIterator);
                        i23++;
                    }
                    int i24 = i23 - i15;
                    if (i24 < 20 && (katakanaCost = iArr2[i15] + getKatakanaCost(i24)) < iArr2[i23]) {
                        iArr2[i23] = katakanaCost;
                        iArr[i23] = i15;
                    }
                }
                z2 = zIsKatakana;
            }
            stringCharacterIterator.setIndex(index2);
            CharacterIteration.next32(stringCharacterIterator);
            i11 = i7;
            i8 = i15 + 1;
            iArr5 = iArr2;
            iArr8 = iArr;
            i4 = Integer.MAX_VALUE;
        }
        int[] iArr12 = iArr8;
        int[] iArr13 = new int[i11];
        if (iArr5[i10] == Integer.MAX_VALUE) {
            iArr13[0] = i10;
            i5 = 1;
        } else if (z) {
            iArr13[0] = i10;
            int i25 = iArr12[i10];
            i5 = 1;
            while (i25 > 0) {
                int i26 = i14;
                int iOffsetByCodePoints = string.offsetByCodePoints(i26, i25);
                String patternFromText = getPatternFromText(stringCharacterIterator, stringBuffer, iOffsetByCodePoints, string.offsetByCodePoints(i26, i10) - iOffsetByCodePoints);
                stringCharacterIterator.setIndex(iOffsetByCodePoints);
                if (!this.fSkipSet.contains(patternFromText) && (!isKatakana(CharacterIteration.current32(stringCharacterIterator)) || !isKatakana(CharacterIteration.previous32(stringCharacterIterator)))) {
                    iArr13[i5] = i25;
                    i5++;
                }
                int i27 = i25;
                i25 = iArr12[i25];
                i10 = i27;
                i14 = 0;
            }
        } else {
            i5 = 0;
            for (int i28 = i10; i28 > 0; i28 = iArr12[i28]) {
                iArr13[i5] = i28;
                i5++;
            }
            Assert.assrt(iArr12[iArr13[i5 + (-1)]] == 0);
        }
        if (dequeI.size() == 0 || dequeI.peek() < i) {
            i6 = 0;
            iArr13[i5] = 0;
            i5++;
        } else {
            i6 = 0;
        }
        int i29 = i5 - 1;
        int i30 = -1;
        while (i29 >= 0) {
            int i31 = iArr4[iArr13[i29]] + i;
            characterIterator.setIndex(i31);
            if (i31 > i30 && (i31 != i || (z && i31 > 0 && this.fClosePunctuationSet.contains(CharacterIteration.previous32(characterIterator))))) {
                dequeI.push(iArr4[iArr13[i29]] + i);
                i6++;
            }
            i29--;
            i30 = i31;
        }
        if (!dequeI.isEmpty() && dequeI.peek() == i2) {
            if (z) {
                characterIterator.setIndex(i2);
                int iCurrent32 = CharacterIteration.current32(characterIterator);
                if (iCurrent32 != Integer.MAX_VALUE && !this.fDigitOrOpenPunctuationOrAlphabetSet.contains(iCurrent32)) {
                    dequeI.pop();
                }
            } else {
                dequeI.pop();
            }
            i6--;
        }
        if (!dequeI.isEmpty()) {
            characterIterator.setIndex(dequeI.peek());
        }
        return i6;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CjkBreakEngine) {
            return this.fSet.equals(((CjkBreakEngine) obj).fSet);
        }
        return false;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
