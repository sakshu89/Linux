package com.ibm.icu.text;

import defpackage.ky0;
import defpackage.og;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class SearchIterator {
    public static final int DONE = -1;
    protected BreakIterator breakIterator;
    protected int matchLength;
    Search search_ = new Search();
    protected CharacterIterator targetText;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ElementComparisonType {
        STANDARD_ELEMENT_COMPARISON,
        PATTERN_BASE_WEIGHT_IS_WILDCARD,
        ANY_BASE_WEIGHT_IS_WILDCARD
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public final class Search {
        ElementComparisonType elementComparisonType_;
        BreakIterator internalBreakIter_;
        boolean isCanonicalMatch_;
        boolean isForwardSearching_;
        boolean isOverlap_;
        int matchedIndex_;
        boolean reset_;

        public Search() {
        }

        public int beginIndex() {
            CharacterIterator characterIterator = SearchIterator.this.targetText;
            if (characterIterator == null) {
                return 0;
            }
            return characterIterator.getBeginIndex();
        }

        public BreakIterator breakIter() {
            return SearchIterator.this.breakIterator;
        }

        public int endIndex() {
            CharacterIterator characterIterator = SearchIterator.this.targetText;
            if (characterIterator == null) {
                return 0;
            }
            return characterIterator.getEndIndex();
        }

        public int matchedLength() {
            return SearchIterator.this.matchLength;
        }

        public void setBreakIter(BreakIterator breakIterator) {
            SearchIterator.this.breakIterator = breakIterator;
        }

        public void setMatchedLength(int i) {
            SearchIterator.this.matchLength = i;
        }

        public void setTarget(CharacterIterator characterIterator) {
            SearchIterator.this.targetText = characterIterator;
        }

        public CharacterIterator text() {
            return SearchIterator.this.targetText;
        }
    }

    public SearchIterator(CharacterIterator characterIterator, BreakIterator breakIterator) {
        if (characterIterator == null || characterIterator.getEndIndex() - characterIterator.getBeginIndex() == 0) {
            og.i("Illegal argument target.  Argument can not be null or of length 0");
            throw null;
        }
        this.search_.setTarget(characterIterator);
        this.search_.setBreakIter(breakIterator);
        if (this.search_.breakIter() != null) {
            this.search_.breakIter().setText((CharacterIterator) characterIterator.clone());
        }
        Search search = this.search_;
        search.isOverlap_ = false;
        search.isCanonicalMatch_ = false;
        search.elementComparisonType_ = ElementComparisonType.STANDARD_ELEMENT_COMPARISON;
        search.isForwardSearching_ = true;
        search.reset_ = true;
        search.matchedIndex_ = -1;
        search.setMatchedLength(0);
    }

    public final int first() {
        int iBeginIndex = this.search_.beginIndex();
        setIndex(iBeginIndex);
        return handleNext(iBeginIndex);
    }

    public final int following(int i) {
        setIndex(i);
        return handleNext(i);
    }

    public BreakIterator getBreakIterator() {
        return this.search_.breakIter();
    }

    public ElementComparisonType getElementComparisonType() {
        return this.search_.elementComparisonType_;
    }

    public abstract int getIndex();

    public int getMatchLength() {
        return this.search_.matchedLength();
    }

    public int getMatchStart() {
        return this.search_.matchedIndex_;
    }

    public String getMatchedText() {
        if (this.search_.matchedLength() <= 0) {
            return null;
        }
        Search search = this.search_;
        int iMatchedLength = search.matchedIndex_ + search.matchedLength();
        StringBuilder sb = new StringBuilder(this.search_.matchedLength());
        CharacterIterator characterIteratorText = this.search_.text();
        characterIteratorText.setIndex(this.search_.matchedIndex_);
        while (characterIteratorText.getIndex() < iMatchedLength) {
            sb.append(characterIteratorText.current());
            characterIteratorText.next();
        }
        characterIteratorText.setIndex(this.search_.matchedIndex_);
        return sb.toString();
    }

    public CharacterIterator getTarget() {
        return this.search_.text();
    }

    public abstract int handleNext(int i);

    public abstract int handlePrevious(int i);

    public boolean isOverlapping() {
        return this.search_.isOverlap_;
    }

    public final int last() {
        int iEndIndex = this.search_.endIndex();
        setIndex(iEndIndex);
        return handlePrevious(iEndIndex);
    }

    public int next() {
        int index = getIndex();
        Search search = this.search_;
        int i = search.matchedIndex_;
        int iMatchedLength = search.matchedLength();
        Search search2 = this.search_;
        search2.reset_ = false;
        if (search2.isForwardSearching_) {
            int iEndIndex = search2.endIndex();
            if (index == iEndIndex || i == iEndIndex || (i != -1 && i + iMatchedLength >= iEndIndex)) {
                setMatchNotFound();
                return -1;
            }
        } else {
            search2.isForwardSearching_ = true;
            if (search2.matchedIndex_ != -1) {
                return i;
            }
        }
        if (iMatchedLength > 0) {
            index = this.search_.isOverlap_ ? index + 1 : index + iMatchedLength;
        }
        return handleNext(index);
    }

    public final int preceding(int i) {
        setIndex(i);
        return handlePrevious(i);
    }

    public int previous() {
        int index;
        Search search = this.search_;
        if (search.reset_) {
            index = search.endIndex();
            Search search2 = this.search_;
            search2.isForwardSearching_ = false;
            search2.reset_ = false;
            setIndex(index);
        } else {
            index = getIndex();
        }
        Search search3 = this.search_;
        int iMatchedLength = search3.matchedIndex_;
        if (search3.isForwardSearching_) {
            search3.isForwardSearching_ = false;
            if (iMatchedLength != -1) {
                return iMatchedLength;
            }
        } else {
            int iBeginIndex = search3.beginIndex();
            if (index == iBeginIndex || iMatchedLength == iBeginIndex) {
                setMatchNotFound();
                return -1;
            }
        }
        if (iMatchedLength == -1) {
            return handlePrevious(index);
        }
        Search search4 = this.search_;
        if (search4.isOverlap_) {
            iMatchedLength += search4.matchedLength() - 2;
        }
        return handlePrevious(iMatchedLength);
    }

    public void reset() {
        setMatchNotFound();
        setIndex(this.search_.beginIndex());
        Search search = this.search_;
        search.isOverlap_ = false;
        search.isCanonicalMatch_ = false;
        search.elementComparisonType_ = ElementComparisonType.STANDARD_ELEMENT_COMPARISON;
        search.isForwardSearching_ = true;
        search.reset_ = true;
    }

    public void setBreakIterator(BreakIterator breakIterator) {
        this.search_.setBreakIter(breakIterator);
        if (this.search_.breakIter() == null || this.search_.text() == null) {
            return;
        }
        this.search_.breakIter().setText((CharacterIterator) this.search_.text().clone());
    }

    public void setElementComparisonType(ElementComparisonType elementComparisonType) {
        this.search_.elementComparisonType_ = elementComparisonType;
    }

    public void setIndex(int i) {
        if (i < this.search_.beginIndex() || i > this.search_.endIndex()) {
            og.o(ky0.i("setIndex(int) expected position to be between ", this.search_.beginIndex(), this.search_.endIndex(), " and "));
            return;
        }
        Search search = this.search_;
        search.reset_ = false;
        search.setMatchedLength(0);
        this.search_.matchedIndex_ = -1;
    }

    public void setMatchLength(int i) {
        this.search_.setMatchedLength(i);
    }

    @Deprecated
    public void setMatchNotFound() {
        Search search = this.search_;
        search.matchedIndex_ = -1;
        search.setMatchedLength(0);
    }

    public void setOverlapping(boolean z) {
        this.search_.isOverlap_ = z;
    }

    public void setTarget(CharacterIterator characterIterator) {
        if (characterIterator == null || characterIterator.getEndIndex() == characterIterator.getIndex()) {
            og.i("Illegal null or empty text");
            return;
        }
        characterIterator.setIndex(characterIterator.getBeginIndex());
        this.search_.setTarget(characterIterator);
        Search search = this.search_;
        search.matchedIndex_ = -1;
        search.setMatchedLength(0);
        Search search2 = this.search_;
        search2.reset_ = true;
        search2.isForwardSearching_ = true;
        if (search2.breakIter() != null) {
            this.search_.breakIter().setText((CharacterIterator) characterIterator.clone());
        }
        BreakIterator breakIterator = this.search_.internalBreakIter_;
        if (breakIterator != null) {
            breakIterator.setText((CharacterIterator) characterIterator.clone());
        }
    }
}
