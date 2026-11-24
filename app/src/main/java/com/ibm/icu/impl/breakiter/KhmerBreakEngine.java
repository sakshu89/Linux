package com.ibm.icu.impl.breakiter;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.text.UnicodeSet;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class KhmerBreakEngine extends DictionaryBreakEngine {
    private static final byte KHMER_LOOKAHEAD = 3;
    private static final byte KHMER_MIN_WORD = 2;
    private static final byte KHMER_MIN_WORD_SPAN = 4;
    private static final byte KHMER_PREFIX_COMBINE_THRESHOLD = 3;
    private static final byte KHMER_ROOT_COMBINE_THRESHOLD = 3;
    private UnicodeSet fBeginWordSet;
    private DictionaryMatcher fDictionary;
    private UnicodeSet fEndWordSet;
    private UnicodeSet fMarkSet;

    public KhmerBreakEngine() {
        UnicodeSet unicodeSet = new UnicodeSet("[[:Khmer:]&[:LineBreak=SA:]]");
        UnicodeSet unicodeSet2 = new UnicodeSet("[[:Khmer:]&[:LineBreak=SA:]&[:M:]]");
        this.fMarkSet = unicodeSet2;
        unicodeSet2.add(32);
        this.fBeginWordSet = new UnicodeSet(6016, 6067);
        unicodeSet.compact();
        UnicodeSet unicodeSet3 = new UnicodeSet(unicodeSet);
        this.fEndWordSet = unicodeSet3;
        unicodeSet3.remove(6098);
        this.fMarkSet.compact();
        this.fEndWordSet.compact();
        this.fBeginWordSet.compact();
        unicodeSet.freeze();
        this.fMarkSet.freeze();
        this.fEndWordSet.freeze();
        this.fBeginWordSet.freeze();
        setCharacters(unicodeSet);
        this.fDictionary = DictionaryData.loadDictionaryFor("Khmr");
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0083 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:71:0x0116 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x010e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0085 A[EDGE_INSN: B:85:0x0085->B:32:0x0085 BREAK  A[LOOP:4: B:19:0x0046->B:87:?], SYNTHETIC] */
    @Override // com.ibm.icu.impl.breakiter.DictionaryBreakEngine
    public int divideUpDictionaryRange(CharacterIterator characterIterator, int i, int i2, DictionaryBreakEngine.DequeI dequeI, boolean z) {
        int iAcceptMarked;
        int index;
        int i3;
        if (i2 - i < 4) {
            return 0;
        }
        DictionaryBreakEngine.PossibleWord[] possibleWordArr = new DictionaryBreakEngine.PossibleWord[3];
        for (int i4 = 0; i4 < 3; i4++) {
            possibleWordArr[i4] = new DictionaryBreakEngine.PossibleWord();
        }
        characterIterator.setIndex(i);
        int i5 = 0;
        while (true) {
            int index2 = characterIterator.getIndex();
            if (index2 >= i2) {
                break;
            }
            int i6 = i5 % 3;
            int iCandidates = possibleWordArr[i6].candidates(characterIterator, this.fDictionary, i2);
            if (iCandidates == 1) {
                iAcceptMarked = possibleWordArr[i6].acceptMarked(characterIterator);
            } else {
                if (iCandidates > 1) {
                    if (characterIterator.getIndex() < i2) {
                        boolean z2 = false;
                        do {
                            int i7 = (i5 + 1) % 3;
                            if (possibleWordArr[i7].candidates(characterIterator, this.fDictionary, i2) > 0) {
                                possibleWordArr[i6].markCurrent();
                                if (characterIterator.getIndex() >= i2) {
                                    break;
                                }
                                do {
                                    if (possibleWordArr[(i5 + 2) % 3].candidates(characterIterator, this.fDictionary, i2) > 0) {
                                        possibleWordArr[i6].markCurrent();
                                        z2 = true;
                                        break;
                                    }
                                } while (possibleWordArr[i7].backUp(characterIterator));
                                if (possibleWordArr[i6].backUp(characterIterator)) {
                                    break;
                                }
                            } else {
                                if (possibleWordArr[i6].backUp(characterIterator)) {
                                    break;
                                    break;
                                }
                            }
                        } while (!z2);
                    }
                    iAcceptMarked = possibleWordArr[i6].acceptMarked(characterIterator);
                } else {
                    iAcceptMarked = 0;
                }
                if (characterIterator.getIndex() < i2 && iAcceptMarked < 3) {
                    i3 = i5 % 3;
                    if (possibleWordArr[i3].candidates(characterIterator, this.fDictionary, i2) <= 0 || (iAcceptMarked != 0 && possibleWordArr[i3].longestPrefix() >= 3)) {
                        characterIterator.setIndex(index2 + iAcceptMarked);
                    } else {
                        int i8 = index2 + iAcceptMarked;
                        int i9 = i2 - i8;
                        char cCurrent = characterIterator.current();
                        int i10 = 0;
                        while (true) {
                            characterIterator.next();
                            char cCurrent2 = characterIterator.current();
                            i10++;
                            i9--;
                            if (i9 <= 0) {
                                break;
                            }
                            if (this.fEndWordSet.contains(cCurrent) && this.fBeginWordSet.contains(cCurrent2)) {
                                int iCandidates2 = possibleWordArr[(i5 + 1) % 3].candidates(characterIterator, this.fDictionary, i2);
                                characterIterator.setIndex(i8 + i10);
                                if (iCandidates2 > 0) {
                                    break;
                                }
                            }
                            cCurrent = cCurrent2;
                        }
                        if (iAcceptMarked <= 0) {
                            i5++;
                        }
                        iAcceptMarked += i10;
                    }
                }
                while (true) {
                    index = characterIterator.getIndex();
                    if (index >= i2 || !this.fMarkSet.contains(characterIterator.current())) {
                        break;
                    }
                    characterIterator.next();
                    iAcceptMarked += characterIterator.getIndex() - index;
                }
                if (iAcceptMarked > 0) {
                    dequeI.push(index2 + iAcceptMarked);
                }
            }
            i5++;
            if (characterIterator.getIndex() < i2) {
                i3 = i5 % 3;
                if (possibleWordArr[i3].candidates(characterIterator, this.fDictionary, i2) <= 0) {
                    characterIterator.setIndex(index2 + iAcceptMarked);
                } else {
                    characterIterator.setIndex(index2 + iAcceptMarked);
                }
            }
            while (true) {
                index = characterIterator.getIndex();
                if (index >= i2) {
                    break;
                }
                break;
                break;
                characterIterator.next();
                iAcceptMarked += characterIterator.getIndex() - index;
            }
            if (iAcceptMarked > 0) {
                dequeI.push(index2 + iAcceptMarked);
            }
        }
        if (dequeI.peek() < i2) {
            return i5;
        }
        dequeI.pop();
        return i5 - 1;
    }

    public boolean equals(Object obj) {
        return obj instanceof KhmerBreakEngine;
    }

    @Override // com.ibm.icu.impl.breakiter.DictionaryBreakEngine, com.ibm.icu.impl.breakiter.LanguageBreakEngine
    public boolean handles(int i) {
        return UCharacter.getIntPropertyValue(i, UProperty.SCRIPT) == 23;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
