package com.ibm.icu.impl.breakiter;

import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.text.UnicodeSet;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class DictionaryBreakEngine implements LanguageBreakEngine {
    UnicodeSet fSet = new UnicodeSet();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DequeI implements Cloneable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int[] data = new int[50];
        private int lastIdx = 4;
        private int firstIdx = 4;

        private void grow() {
            int[] iArr = this.data;
            int[] iArr2 = new int[iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.data = iArr2;
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DequeI m7clone() {
            DequeI dequeI = (DequeI) super.clone();
            dequeI.data = (int[]) this.data.clone();
            return dequeI;
        }

        public boolean contains(int i) {
            for (int i2 = this.lastIdx; i2 < this.firstIdx; i2++) {
                if (this.data[i2] == i) {
                    return true;
                }
            }
            return false;
        }

        public int elementAt(int i) {
            return this.data[this.lastIdx + i];
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public void offer(int i) {
            int[] iArr = this.data;
            int i2 = this.lastIdx - 1;
            this.lastIdx = i2;
            iArr[i2] = i;
        }

        public int peek() {
            return this.data[this.firstIdx - 1];
        }

        public int peekLast() {
            return this.data[this.lastIdx];
        }

        public int pollLast() {
            int[] iArr = this.data;
            int i = this.lastIdx;
            this.lastIdx = i + 1;
            return iArr[i];
        }

        public int pop() {
            int[] iArr = this.data;
            int i = this.firstIdx - 1;
            this.firstIdx = i;
            return iArr[i];
        }

        public void push(int i) {
            if (this.firstIdx >= this.data.length) {
                grow();
            }
            int[] iArr = this.data;
            int i2 = this.firstIdx;
            this.firstIdx = i2 + 1;
            iArr[i2] = i;
        }

        public void removeAllElements() {
            this.firstIdx = 4;
            this.lastIdx = 4;
        }

        public int size() {
            return this.firstIdx - this.lastIdx;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class PossibleWord {
        private static final int POSSIBLE_WORD_LIST_MAX = 20;
        private int current;
        private int mark;
        private int prefix;
        private int[] lengths = new int[20];
        private int[] count = new int[1];
        private int offset = -1;

        public int acceptMarked(CharacterIterator characterIterator) {
            characterIterator.setIndex(this.offset + this.lengths[this.mark]);
            return this.lengths[this.mark];
        }

        public boolean backUp(CharacterIterator characterIterator) {
            int i = this.current;
            if (i <= 0) {
                return false;
            }
            int i2 = this.offset;
            int[] iArr = this.lengths;
            int i3 = i - 1;
            this.current = i3;
            characterIterator.setIndex(i2 + iArr[i3]);
            return true;
        }

        public int candidates(CharacterIterator characterIterator, DictionaryMatcher dictionaryMatcher, int i) {
            CharacterIterator characterIterator2;
            int index = characterIterator.getIndex();
            if (index != this.offset) {
                this.offset = index;
                int[] iArr = this.lengths;
                characterIterator2 = characterIterator;
                this.prefix = dictionaryMatcher.matches(characterIterator2, i - index, iArr, this.count, iArr.length);
                if (this.count[0] <= 0) {
                    characterIterator2.setIndex(index);
                }
            } else {
                characterIterator2 = characterIterator;
            }
            int i2 = this.count[0];
            if (i2 > 0) {
                characterIterator2.setIndex(index + this.lengths[i2 - 1]);
            }
            int i3 = this.count[0];
            int i4 = i3 - 1;
            this.current = i4;
            this.mark = i4;
            return i3;
        }

        public int longestPrefix() {
            return this.prefix;
        }

        public void markCurrent() {
            this.mark = this.current;
        }
    }

    public abstract int divideUpDictionaryRange(CharacterIterator characterIterator, int i, int i2, DequeI dequeI, boolean z);

    @Override // com.ibm.icu.impl.breakiter.LanguageBreakEngine
    public int findBreaks(CharacterIterator characterIterator, int i, int i2, DequeI dequeI, boolean z) {
        int index;
        int index2 = characterIterator.getIndex();
        int iCurrent32 = CharacterIteration.current32(characterIterator);
        while (true) {
            index = characterIterator.getIndex();
            if (index >= i2 || !this.fSet.contains(iCurrent32)) {
                break;
            }
            CharacterIteration.next32(characterIterator);
            iCurrent32 = CharacterIteration.current32(characterIterator);
        }
        int iDivideUpDictionaryRange = divideUpDictionaryRange(characterIterator, index2, index, dequeI, z);
        characterIterator.setIndex(index);
        return iDivideUpDictionaryRange;
    }

    @Override // com.ibm.icu.impl.breakiter.LanguageBreakEngine
    public boolean handles(int i) {
        return this.fSet.contains(i);
    }

    public void setCharacters(UnicodeSet unicodeSet) {
        UnicodeSet unicodeSet2 = new UnicodeSet(unicodeSet);
        this.fSet = unicodeSet2;
        unicodeSet2.compact();
    }
}
