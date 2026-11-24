package com.ibm.icu.impl.breakiter;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.text.UnicodeSet;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ThaiBreakEngine extends DictionaryBreakEngine {
    private static final byte THAI_LOOKAHEAD = 3;
    private static final char THAI_MAIYAMOK = 3654;
    private static final byte THAI_MIN_WORD = 2;
    private static final byte THAI_MIN_WORD_SPAN = 4;
    private static final char THAI_PAIYANNOI = 3631;
    private static final byte THAI_PREFIX_COMBINE_THRESHOLD = 3;
    private static final byte THAI_ROOT_COMBINE_THRESHOLD = 3;
    private UnicodeSet fBeginWordSet;
    private DictionaryMatcher fDictionary;
    private UnicodeSet fEndWordSet;
    private UnicodeSet fMarkSet;
    private UnicodeSet fSuffixSet;

    public ThaiBreakEngine() {
        UnicodeSet unicodeSet = new UnicodeSet("[[:Thai:]&[:LineBreak=SA:]]");
        UnicodeSet unicodeSet2 = new UnicodeSet("[[:Thai:]&[:LineBreak=SA:]&[:M:]]");
        this.fMarkSet = unicodeSet2;
        unicodeSet2.add(32);
        this.fBeginWordSet = new UnicodeSet(3585, 3630, 3648, 3652);
        UnicodeSet unicodeSet3 = new UnicodeSet();
        this.fSuffixSet = unicodeSet3;
        unicodeSet3.add(3631);
        this.fSuffixSet.add(3654);
        unicodeSet.compact();
        UnicodeSet unicodeSet4 = new UnicodeSet(unicodeSet);
        this.fEndWordSet = unicodeSet4;
        unicodeSet4.remove(3633);
        this.fEndWordSet.remove(3648, 3652);
        this.fMarkSet.compact();
        this.fEndWordSet.compact();
        this.fBeginWordSet.compact();
        this.fSuffixSet.compact();
        unicodeSet.freeze();
        this.fMarkSet.freeze();
        this.fEndWordSet.freeze();
        this.fBeginWordSet.freeze();
        this.fSuffixSet.freeze();
        setCharacters(unicodeSet);
        this.fDictionary = DictionaryData.loadDictionaryFor("Thai");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:65:0x011c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0128  */
    /* JADX WARN: Code duplicated, block: B:69:0x012c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0138  */
    /* JADX WARN: Code duplicated, block: B:72:0x0145  */
    /* JADX WARN: Code duplicated, block: B:75:0x014c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0152  */
    /* JADX WARN: Code duplicated, block: B:78:0x015b  */
    /* JADX WARN: Code duplicated, block: B:79:0x015f  */
    /* JADX WARN: Code duplicated, block: B:89:0x016e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0166 A[SYNTHETIC] */
    @Override // com.ibm.icu.impl.breakiter.DictionaryBreakEngine
    public int divideUpDictionaryRange(CharacterIterator characterIterator, int i, int i2, DictionaryBreakEngine.DequeI dequeI, boolean z) {
        int iAcceptMarked;
        int index;
        UnicodeSet unicodeSet;
        char cCurrent;
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
                                        break;
                                    }
                                } while (possibleWordArr[i7].backUp(characterIterator));
                            }
                        } while (possibleWordArr[i6].backUp(characterIterator));
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
                        char cCurrent2 = characterIterator.current();
                        int i10 = 0;
                        while (true) {
                            characterIterator.next();
                            char cCurrent3 = characterIterator.current();
                            i10++;
                            i9--;
                            if (i9 <= 0) {
                                break;
                            }
                            if (this.fEndWordSet.contains(cCurrent2) && this.fBeginWordSet.contains(cCurrent3)) {
                                int iCandidates2 = possibleWordArr[(i5 + 1) % 3].candidates(characterIterator, this.fDictionary, i2);
                                characterIterator.setIndex(i8 + i10);
                                if (iCandidates2 > 0) {
                                    break;
                                }
                            }
                            cCurrent2 = cCurrent3;
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
                if (characterIterator.getIndex() < i2 && iAcceptMarked > 0) {
                    if (possibleWordArr[i5 % 3].candidates(characterIterator, this.fDictionary, i2) <= 0) {
                        unicodeSet = this.fSuffixSet;
                        cCurrent = characterIterator.current();
                        if (unicodeSet.contains(cCurrent)) {
                            if (cCurrent == 3631) {
                                if (this.fSuffixSet.contains(characterIterator.previous())) {
                                    characterIterator.next();
                                } else {
                                    characterIterator.next();
                                    characterIterator.next();
                                    iAcceptMarked++;
                                    cCurrent = characterIterator.current();
                                }
                            }
                            if (cCurrent == 3654) {
                                if (characterIterator.previous() != 3654) {
                                    characterIterator.next();
                                    characterIterator.next();
                                    iAcceptMarked++;
                                } else {
                                    characterIterator.next();
                                }
                            }
                        } else {
                            characterIterator.setIndex(index2 + iAcceptMarked);
                        }
                    } else {
                        characterIterator.setIndex(index2 + iAcceptMarked);
                    }
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
            if (characterIterator.getIndex() < i2) {
                if (possibleWordArr[i5 % 3].candidates(characterIterator, this.fDictionary, i2) <= 0) {
                    unicodeSet = this.fSuffixSet;
                    cCurrent = characterIterator.current();
                    if (unicodeSet.contains(cCurrent)) {
                        if (cCurrent == 3631) {
                            if (this.fSuffixSet.contains(characterIterator.previous())) {
                                characterIterator.next();
                                characterIterator.next();
                                iAcceptMarked++;
                                cCurrent = characterIterator.current();
                            } else {
                                characterIterator.next();
                            }
                        }
                        if (cCurrent == 3654) {
                            if (characterIterator.previous() != 3654) {
                                characterIterator.next();
                                characterIterator.next();
                                iAcceptMarked++;
                            } else {
                                characterIterator.next();
                            }
                        }
                    } else {
                        characterIterator.setIndex(index2 + iAcceptMarked);
                    }
                } else {
                    characterIterator.setIndex(index2 + iAcceptMarked);
                }
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
        return obj instanceof ThaiBreakEngine;
    }

    @Override // com.ibm.icu.impl.breakiter.DictionaryBreakEngine, com.ibm.icu.impl.breakiter.LanguageBreakEngine
    public boolean handles(int i) {
        return UCharacter.getIntPropertyValue(i, UProperty.SCRIPT) == 38;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
