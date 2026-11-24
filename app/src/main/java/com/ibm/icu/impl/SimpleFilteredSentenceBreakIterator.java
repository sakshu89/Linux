package com.ibm.icu.impl;

import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.FilteredBreakIteratorBuilder;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.CharsTrieBuilder;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.StringTrieBuilder;
import com.ibm.icu.util.ULocale;
import java.text.CharacterIterator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SimpleFilteredSentenceBreakIterator extends BreakIterator implements Cloneable {
    private CharsTrie backwardsTrie;
    private BreakIterator delegate;
    private CharsTrie forwardsPartialTrie;
    private UCharacterIterator text;

    public SimpleFilteredSentenceBreakIterator(BreakIterator breakIterator, CharsTrie charsTrie, CharsTrie charsTrie2) {
        this.delegate = breakIterator;
        this.forwardsPartialTrie = charsTrie;
        this.backwardsTrie = charsTrie2;
    }

    private final boolean breakExceptionAt(int i) {
        CharsTrie charsTrie;
        BytesTrie.Result resultNextForCodePoint;
        this.text.setIndex(i);
        this.backwardsTrie.reset();
        if (this.text.previousCodePoint() != 32) {
            this.text.nextCodePoint();
        }
        int index = -1;
        int value = -1;
        do {
            int iPreviousCodePoint = this.text.previousCodePoint();
            if (iPreviousCodePoint < 0) {
                break;
            }
            resultNextForCodePoint = this.backwardsTrie.nextForCodePoint(iPreviousCodePoint);
            if (resultNextForCodePoint.hasValue()) {
                index = this.text.getIndex();
                value = this.backwardsTrie.getValue();
            }
        } while (resultNextForCodePoint.hasNext());
        this.backwardsTrie.reset();
        if (index < 0) {
            return false;
        }
        if (value == 2) {
            return true;
        }
        if (value != 1 || (charsTrie = this.forwardsPartialTrie) == null) {
            return false;
        }
        charsTrie.reset();
        BytesTrie.Result resultNextForCodePoint2 = BytesTrie.Result.INTERMEDIATE_VALUE;
        this.text.setIndex(index);
        do {
            int iNextCodePoint = this.text.nextCodePoint();
            if (iNextCodePoint == -1) {
                break;
            }
            resultNextForCodePoint2 = this.forwardsPartialTrie.nextForCodePoint(iNextCodePoint);
        } while (resultNextForCodePoint2.hasNext());
        this.forwardsPartialTrie.reset();
        return resultNextForCodePoint2.matches();
    }

    private final int internalNext(int i) {
        if (i != -1 && this.backwardsTrie != null) {
            resetState();
            int length = this.text.getLength();
            while (i != -1 && i != length && breakExceptionAt(i)) {
                i = this.delegate.next();
            }
        }
        return i;
    }

    private final int internalPrev(int i) {
        if (i != 0 && i != -1 && this.backwardsTrie != null) {
            resetState();
            while (i != -1 && i != 0 && breakExceptionAt(i)) {
                i = this.delegate.previous();
            }
        }
        return i;
    }

    private final void resetState() {
        this.text = UCharacterIterator.getInstance((CharacterIterator) this.delegate.getText().clone());
    }

    @Override // com.ibm.icu.text.BreakIterator
    /* JADX INFO: renamed from: clone */
    public SimpleFilteredSentenceBreakIterator mo5clone() {
        SimpleFilteredSentenceBreakIterator simpleFilteredSentenceBreakIterator = (SimpleFilteredSentenceBreakIterator) super.mo5clone();
        try {
            BreakIterator breakIterator = this.delegate;
            if (breakIterator != null) {
                simpleFilteredSentenceBreakIterator.delegate = breakIterator.mo5clone();
            }
            UCharacterIterator uCharacterIterator = this.text;
            if (uCharacterIterator != null) {
                simpleFilteredSentenceBreakIterator.text = uCharacterIterator.mo2clone();
            }
            CharsTrie charsTrie = this.backwardsTrie;
            if (charsTrie != null) {
                simpleFilteredSentenceBreakIterator.backwardsTrie = charsTrie.m23clone();
            }
            CharsTrie charsTrie2 = this.forwardsPartialTrie;
            if (charsTrie2 != null) {
                simpleFilteredSentenceBreakIterator.forwardsPartialTrie = charsTrie2.m23clone();
            }
            return simpleFilteredSentenceBreakIterator;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int current() {
        return this.delegate.current();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SimpleFilteredSentenceBreakIterator simpleFilteredSentenceBreakIterator = (SimpleFilteredSentenceBreakIterator) obj;
        return this.delegate.equals(simpleFilteredSentenceBreakIterator.delegate) && this.text.equals(simpleFilteredSentenceBreakIterator.text) && this.backwardsTrie.equals(simpleFilteredSentenceBreakIterator.backwardsTrie) && this.forwardsPartialTrie.equals(simpleFilteredSentenceBreakIterator.forwardsPartialTrie);
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int first() {
        return this.delegate.first();
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int following(int i) {
        return internalNext(this.delegate.following(i));
    }

    @Override // com.ibm.icu.text.BreakIterator
    public CharacterIterator getText() {
        return this.delegate.getText();
    }

    public int hashCode() {
        return this.delegate.hashCode() + (this.backwardsTrie.hashCode() * 11) + (this.forwardsPartialTrie.hashCode() * 39);
    }

    @Override // com.ibm.icu.text.BreakIterator
    public boolean isBoundary(int i) {
        if (!this.delegate.isBoundary(i)) {
            return false;
        }
        if (this.backwardsTrie == null) {
            return true;
        }
        resetState();
        return !breakExceptionAt(i);
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int last() {
        return this.delegate.last();
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int next() {
        return internalNext(this.delegate.next());
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int preceding(int i) {
        return internalPrev(this.delegate.preceding(i));
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int previous() {
        return internalPrev(this.delegate.previous());
    }

    @Override // com.ibm.icu.text.BreakIterator
    public void setText(CharacterIterator characterIterator) {
        this.delegate.setText(characterIterator);
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int next(int i) {
        return internalNext(this.delegate.next(i));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Builder extends FilteredBreakIteratorBuilder {
        static final int AddToForward = 2;
        static final int MATCH = 2;
        static final int PARTIAL = 1;
        static final int SuppressInReverse = 1;
        private HashSet<CharSequence> filterSet;

        public Builder(ULocale uLocale) {
            this.filterSet = new HashSet<>();
            ICUResourceBundle iCUResourceBundleFindWithFallback = ICUResourceBundle.getBundleInstance(ICUData.ICU_BRKITR_BASE_NAME, uLocale, ICUResourceBundle.OpenType.LOCALE_ROOT).findWithFallback("exceptions/SentenceBreak");
            if (iCUResourceBundleFindWithFallback != null) {
                int size = iCUResourceBundleFindWithFallback.getSize();
                for (int i = 0; i < size; i++) {
                    this.filterSet.add(((ICUResourceBundle) iCUResourceBundleFindWithFallback.get(i)).getString());
                }
            }
        }

        @Override // com.ibm.icu.text.FilteredBreakIteratorBuilder
        public boolean suppressBreakAfter(CharSequence charSequence) {
            return this.filterSet.add(charSequence);
        }

        @Override // com.ibm.icu.text.FilteredBreakIteratorBuilder
        public boolean unsuppressBreakAfter(CharSequence charSequence) {
            return this.filterSet.remove(charSequence);
        }

        @Override // com.ibm.icu.text.FilteredBreakIteratorBuilder
        public BreakIterator wrapIteratorWithFilter(BreakIterator breakIterator) {
            int i;
            if (this.filterSet.isEmpty()) {
                return breakIterator;
            }
            CharsTrieBuilder charsTrieBuilder = new CharsTrieBuilder();
            CharsTrieBuilder charsTrieBuilder2 = new CharsTrieBuilder();
            int size = this.filterSet.size();
            CharSequence[] charSequenceArr = new CharSequence[size];
            int[] iArr = new int[size];
            Iterator<CharSequence> it = this.filterSet.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                charSequenceArr[i2] = it.next();
                iArr[i2] = 0;
                i2++;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                String string = charSequenceArr[i4].toString();
                int iIndexOf = string.indexOf(46);
                if (iIndexOf > -1 && (i = iIndexOf + 1) != string.length()) {
                    int i5 = -1;
                    for (int i6 = 0; i6 < size; i6++) {
                        if (i6 != i4 && string.regionMatches(0, charSequenceArr[i6].toString(), 0, i)) {
                            int i7 = iArr[i6];
                            if (i7 == 0) {
                                iArr[i6] = 3;
                            } else if ((i7 & 1) != 0) {
                                i5 = i6;
                            }
                        }
                    }
                    if (i5 == -1 && iArr[i4] == 0) {
                        StringBuilder sb = new StringBuilder(string.substring(0, i));
                        sb.reverse();
                        charsTrieBuilder.add(sb, 1);
                        i3++;
                        iArr[i4] = 3;
                    }
                }
            }
            int i8 = 0;
            for (int i9 = 0; i9 < size; i9++) {
                String string2 = charSequenceArr[i9].toString();
                if (iArr[i9] == 0) {
                    charsTrieBuilder.add(new StringBuilder(string2).reverse(), 2);
                    i3++;
                } else {
                    charsTrieBuilder2.add(string2, 2);
                    i8++;
                }
            }
            return new SimpleFilteredSentenceBreakIterator(breakIterator, i8 > 0 ? charsTrieBuilder2.build(StringTrieBuilder.Option.FAST) : null, i3 > 0 ? charsTrieBuilder.build(StringTrieBuilder.Option.FAST) : null);
        }

        public Builder(Locale locale) {
            this(ULocale.forLocale(locale));
        }

        public Builder() {
            this.filterSet = new HashSet<>();
        }
    }
}
