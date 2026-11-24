package com.ibm.icu.text;

import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.ULocale;
import defpackage.og;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class BreakTransliterator extends Transliterator implements Cloneable {
    static final int LETTER_OR_MARK_MASK = 510;
    private BreakIterator bi;
    private String insertion;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ReplaceableCharacterIterator implements CharacterIterator {
        private int begin;
        private int end;
        private int pos;
        private Replaceable text;

        public ReplaceableCharacterIterator(Replaceable replaceable, int i, int i2, int i3) {
            replaceable.getClass();
            this.text = replaceable;
            if (i < 0 || i > i2 || i2 > replaceable.length()) {
                og.i("Invalid substring range");
                throw null;
            }
            if (i3 < i || i3 > i2) {
                og.i("Invalid position");
                throw null;
            }
            this.begin = i;
            this.end = i2;
            this.pos = i3;
        }

        @Override // java.text.CharacterIterator
        public ReplaceableCharacterIterator clone() {
            try {
                return (ReplaceableCharacterIterator) super.clone();
            } catch (CloneNotSupportedException unused) {
                throw new ICUCloneNotSupportedException();
            }
        }

        @Override // java.text.CharacterIterator
        public char current() {
            int i = this.pos;
            if (i < this.begin || i >= this.end) {
                return (char) 65535;
            }
            return this.text.charAt(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReplaceableCharacterIterator)) {
                return false;
            }
            ReplaceableCharacterIterator replaceableCharacterIterator = (ReplaceableCharacterIterator) obj;
            return hashCode() == replaceableCharacterIterator.hashCode() && this.text.equals(replaceableCharacterIterator.text) && this.pos == replaceableCharacterIterator.pos && this.begin == replaceableCharacterIterator.begin && this.end == replaceableCharacterIterator.end;
        }

        @Override // java.text.CharacterIterator
        public char first() {
            this.pos = this.begin;
            return current();
        }

        @Override // java.text.CharacterIterator
        public int getBeginIndex() {
            return this.begin;
        }

        @Override // java.text.CharacterIterator
        public int getEndIndex() {
            return this.end;
        }

        @Override // java.text.CharacterIterator
        public int getIndex() {
            return this.pos;
        }

        public int hashCode() {
            return this.end ^ ((this.text.hashCode() ^ this.pos) ^ this.begin);
        }

        @Override // java.text.CharacterIterator
        public char last() {
            int i = this.end;
            if (i != this.begin) {
                this.pos = i - 1;
            } else {
                this.pos = i;
            }
            return current();
        }

        @Override // java.text.CharacterIterator
        public char next() {
            int i = this.pos;
            int i2 = this.end;
            if (i >= i2 - 1) {
                this.pos = i2;
                return (char) 65535;
            }
            int i3 = i + 1;
            this.pos = i3;
            return this.text.charAt(i3);
        }

        @Override // java.text.CharacterIterator
        public char previous() {
            int i = this.pos;
            if (i <= this.begin) {
                return (char) 65535;
            }
            int i2 = i - 1;
            this.pos = i2;
            return this.text.charAt(i2);
        }

        @Override // java.text.CharacterIterator
        public char setIndex(int i) {
            if (i < this.begin || i > this.end) {
                og.i("Invalid index");
                return (char) 0;
            }
            this.pos = i;
            return current();
        }

        public void setText(Replaceable replaceable) {
            replaceable.getClass();
            this.text = replaceable;
            this.begin = 0;
            this.end = replaceable.length();
            this.pos = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class WordBreakIteratorHolder {
        static final BreakIterator BI = BreakIterator.getWordInstance(new ULocale("th_TH"));

        private WordBreakIteratorHolder() {
        }
    }

    public BreakTransliterator(String str, UnicodeFilter unicodeFilter, BreakIterator breakIterator, String str2) {
        super(str, unicodeFilter);
        this.bi = breakIterator;
        this.insertion = str2;
    }

    public static void register() {
        Transliterator.registerInstance(new BreakTransliterator("Any-BreakInternal", null), false);
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        if (getFilterAsUnicodeSet(unicodeSet).size() != 0) {
            unicodeSet3.addAll(this.insertion);
        }
    }

    public BreakIterator getBreakIterator() {
        if (this.bi == null) {
            this.bi = WordBreakIteratorHolder.BI;
        }
        return this.bi.mo5clone();
    }

    public String getInsertion() {
        return this.insertion;
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        int i;
        int[] iArr = new int[50];
        BreakIterator breakIterator = getBreakIterator();
        int i2 = position.start;
        breakIterator.setText(new ReplaceableCharacterIterator(replaceable, i2, position.limit, i2));
        int length = 0;
        int i3 = 0;
        for (int iFirst = breakIterator.first(); iFirst != -1 && iFirst < position.limit; iFirst = breakIterator.next()) {
            if (iFirst != 0 && ((1 << UCharacter.getType(UTF16.charAt(replaceable, iFirst - 1))) & LETTER_OR_MARK_MASK) != 0 && ((1 << UCharacter.getType(UTF16.charAt(replaceable, iFirst))) & LETTER_OR_MARK_MASK) != 0) {
                if (i3 >= iArr.length) {
                    int[] iArr2 = new int[iArr.length * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    iArr = iArr2;
                }
                iArr[i3] = iFirst;
                i3++;
            }
        }
        if (i3 != 0) {
            length = this.insertion.length() * i3;
            i = iArr[i3 - 1];
            while (i3 > 0) {
                i3--;
                int i4 = iArr[i3];
                replaceable.replace(i4, i4, this.insertion);
            }
        } else {
            i = 0;
        }
        position.contextLimit += length;
        int i5 = position.limit + length;
        position.limit = i5;
        if (z) {
            i5 = i + length;
        }
        position.start = i5;
    }

    public void setBreakIterator(BreakIterator breakIterator) {
        this.bi = breakIterator;
    }

    public void setInsertion(String str) {
        this.insertion = str;
    }

    public BreakTransliterator(String str, UnicodeFilter unicodeFilter) {
        this(str, unicodeFilter, null, Padder.FALLBACK_PADDING_STRING);
    }
}
