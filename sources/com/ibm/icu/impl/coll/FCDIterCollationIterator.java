package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.text.UCharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class FCDIterCollationIterator extends IterCollationIterator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int limit;
    private final Normalizer2Impl nfcImpl;
    private StringBuilder normalized;
    private int pos;
    private StringBuilder s;
    private int start;
    private State state;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum State {
        ITER_CHECK_FWD,
        ITER_CHECK_BWD,
        ITER_IN_FCD_SEGMENT,
        IN_NORM_ITER_AT_LIMIT,
        IN_NORM_ITER_AT_START
    }

    public FCDIterCollationIterator(CollationData collationData, boolean z, UCharacterIterator uCharacterIterator, int i) {
        super(collationData, z, uCharacterIterator);
        this.state = State.ITER_CHECK_FWD;
        this.start = i;
        this.nfcImpl = collationData.nfcImpl;
    }

    private boolean nextSegment() {
        this.pos = this.iter.getIndex();
        StringBuilder sb = this.s;
        if (sb == null) {
            this.s = new StringBuilder();
        } else {
            sb.setLength(0);
        }
        int i = 0;
        do {
            int iNextCodePoint = this.iter.nextCodePoint();
            if (iNextCodePoint < 0) {
                break;
            }
            int fcd16 = this.nfcImpl.getFCD16(iNextCodePoint);
            int i2 = fcd16 >> 8;
            if (i2 == 0 && this.s.length() != 0) {
                this.iter.previousCodePoint();
                break;
            }
            this.s.appendCodePoint(iNextCodePoint);
            if (i2 != 0 && (i > i2 || CollationFCD.isFCD16OfTibetanCompositeVowel(fcd16))) {
                while (true) {
                    int iNextCodePoint2 = this.iter.nextCodePoint();
                    if (iNextCodePoint2 < 0) {
                        break;
                    }
                    if (this.nfcImpl.getFCD16(iNextCodePoint2) <= 255) {
                        this.iter.previousCodePoint();
                        break;
                    }
                    this.s.appendCodePoint(iNextCodePoint2);
                }
                normalize(this.s);
                int i3 = this.pos;
                this.start = i3;
                this.limit = this.s.length() + i3;
                this.state = State.IN_NORM_ITER_AT_LIMIT;
                this.pos = 0;
                return true;
            }
            i = fcd16 & 255;
        } while (i != 0);
        this.limit = this.s.length() + this.pos;
        this.iter.moveIndex(-this.s.length());
        this.state = State.ITER_IN_FCD_SEGMENT;
        return true;
    }

    private void normalize(CharSequence charSequence) {
        if (this.normalized == null) {
            this.normalized = new StringBuilder();
        }
        this.nfcImpl.decompose(charSequence, this.normalized);
    }

    private boolean previousSegment() {
        int fcd16;
        int iPreviousCodePoint;
        this.pos = this.iter.getIndex();
        StringBuilder sb = this.s;
        int i = 0;
        if (sb == null) {
            this.s = new StringBuilder();
        } else {
            sb.setLength(0);
        }
        while (true) {
            int iPreviousCodePoint2 = this.iter.previousCodePoint();
            if (iPreviousCodePoint2 >= 0) {
                fcd16 = this.nfcImpl.getFCD16(iPreviousCodePoint2);
                int i2 = fcd16 & 255;
                if (i2 != 0 || this.s.length() == 0) {
                    this.s.appendCodePoint(iPreviousCodePoint2);
                    if (i2 != 0 && ((i != 0 && i2 > i) || CollationFCD.isFCD16OfTibetanCompositeVowel(fcd16))) {
                        break;
                    }
                    i = fcd16 >> 8;
                    if (i == 0) {
                    }
                } else {
                    this.iter.nextCodePoint();
                }
            }
            this.start = this.pos - this.s.length();
            this.iter.moveIndex(this.s.length());
            this.state = State.ITER_IN_FCD_SEGMENT;
            return true;
        }
        while (fcd16 > 255 && (iPreviousCodePoint = this.iter.previousCodePoint()) >= 0) {
            fcd16 = this.nfcImpl.getFCD16(iPreviousCodePoint);
            if (fcd16 == 0) {
                this.iter.nextCodePoint();
                break;
            }
            this.s.appendCodePoint(iPreviousCodePoint);
        }
        this.s.reverse();
        normalize(this.s);
        int i3 = this.pos;
        this.limit = i3;
        this.start = i3 - this.s.length();
        this.state = State.IN_NORM_ITER_AT_START;
        this.pos = this.normalized.length();
        return true;
    }

    private void switchToBackward() {
        State state = this.state;
        if (state != State.ITER_CHECK_FWD) {
            if (state != State.ITER_IN_FCD_SEGMENT) {
                if (state == State.IN_NORM_ITER_AT_LIMIT) {
                    this.iter.moveIndex(this.start - this.limit);
                }
                this.limit = this.start;
            }
            this.state = State.ITER_CHECK_BWD;
            return;
        }
        int index = this.iter.getIndex();
        this.pos = index;
        this.limit = index;
        if (index == this.start) {
            this.state = State.ITER_CHECK_BWD;
        } else {
            this.state = State.ITER_IN_FCD_SEGMENT;
        }
    }

    private void switchToForward() {
        State state = this.state;
        if (state != State.ITER_CHECK_BWD) {
            if (state != State.ITER_IN_FCD_SEGMENT) {
                if (state == State.IN_NORM_ITER_AT_START) {
                    this.iter.moveIndex(this.limit - this.start);
                }
                this.start = this.limit;
            }
            this.state = State.ITER_CHECK_FWD;
            return;
        }
        int index = this.iter.getIndex();
        this.pos = index;
        this.start = index;
        if (index == this.limit) {
            this.state = State.ITER_CHECK_FWD;
        } else {
            this.state = State.ITER_IN_FCD_SEGMENT;
        }
    }

    @Override // com.ibm.icu.impl.coll.IterCollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public void backwardNumCodePoints(int i) {
        while (i > 0 && previousCodePoint() >= 0) {
            i--;
        }
    }

    @Override // com.ibm.icu.impl.coll.IterCollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public void forwardNumCodePoints(int i) {
        while (i > 0 && nextCodePoint() >= 0) {
            i--;
        }
    }

    @Override // com.ibm.icu.impl.coll.IterCollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int getOffset() {
        if (this.state.compareTo(State.ITER_CHECK_BWD) <= 0) {
            return this.iter.getIndex();
        }
        State state = this.state;
        State state2 = State.ITER_IN_FCD_SEGMENT;
        int i = this.pos;
        if (state == state2) {
            return i;
        }
        return i == 0 ? this.start : this.limit;
    }

    @Override // com.ibm.icu.impl.coll.IterCollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public char handleGetTrailSurrogate() {
        State state = this.state;
        State state2 = State.ITER_IN_FCD_SEGMENT;
        if (state.compareTo(state2) > 0) {
            char cCharAt = this.normalized.charAt(this.pos);
            if (Character.isLowSurrogate(cCharAt)) {
                this.pos++;
            }
            return cCharAt;
        }
        int next = this.iter.next();
        if (CollationIterator.isTrailSurrogate(next)) {
            if (this.state == state2) {
                this.pos++;
            }
        } else if (next >= 0) {
            this.iter.previous();
        }
        return (char) next;
    }

    @Override // com.ibm.icu.impl.coll.IterCollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public long handleNextCE32() {
        int next;
        while (true) {
            State state = this.state;
            if (state != State.ITER_CHECK_FWD) {
                if (state == State.ITER_IN_FCD_SEGMENT && this.pos != this.limit) {
                    next = this.iter.next();
                    this.pos++;
                } else if (state.compareTo(State.IN_NORM_ITER_AT_LIMIT) < 0 || this.pos == this.normalized.length()) {
                    switchToForward();
                } else {
                    StringBuilder sb = this.normalized;
                    int i = this.pos;
                    this.pos = i + 1;
                    next = sb.charAt(i);
                }
                return makeCodePointAndCE32Pair(next, this.trie.getFromU16SingleLead((char) next));
            }
            next = this.iter.next();
            if (next < 0) {
                return -4294967104L;
            }
            if (!CollationFCD.hasTccc(next) || (!CollationFCD.maybeTibetanCompositeVowel(next) && !CollationFCD.hasLccc(this.iter.current()))) {
                return makeCodePointAndCE32Pair(next, this.trie.getFromU16SingleLead((char) next));
            }
            this.iter.previous();
            if (!nextSegment()) {
                return 192L;
            }
        }
    }

    @Override // com.ibm.icu.impl.coll.IterCollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int nextCodePoint() {
        int next;
        while (true) {
            State state = this.state;
            if (state == State.ITER_CHECK_FWD) {
                next = this.iter.next();
                if (next < 0) {
                    break;
                }
                if (!CollationFCD.hasTccc(next) || (!CollationFCD.maybeTibetanCompositeVowel(next) && !CollationFCD.hasLccc(this.iter.current()))) {
                    if (!CollationIterator.isLeadSurrogate(next)) {
                        break;
                    }
                    int next2 = this.iter.next();
                    if (!CollationIterator.isTrailSurrogate(next2)) {
                        if (next2 < 0) {
                            break;
                        }
                        this.iter.previous();
                        break;
                    }
                    return Character.toCodePoint((char) next, (char) next2);
                }
                this.iter.previous();
                if (!nextSegment()) {
                    return -1;
                }
            } else {
                if (state == State.ITER_IN_FCD_SEGMENT && this.pos != this.limit) {
                    int iNextCodePoint = this.iter.nextCodePoint();
                    this.pos = Character.charCount(iNextCodePoint) + this.pos;
                    return iNextCodePoint;
                }
                if (state.compareTo(State.IN_NORM_ITER_AT_LIMIT) >= 0 && this.pos != this.normalized.length()) {
                    int iCodePointAt = this.normalized.codePointAt(this.pos);
                    this.pos = Character.charCount(iCodePointAt) + this.pos;
                    return iCodePointAt;
                }
                switchToForward();
            }
        }
        return next;
    }

    @Override // com.ibm.icu.impl.coll.IterCollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int previousCodePoint() {
        int iPrevious;
        int i;
        while (true) {
            State state = this.state;
            if (state == State.ITER_CHECK_BWD) {
                int iPrevious2 = this.iter.previous();
                if (iPrevious2 < 0) {
                    this.pos = 0;
                    this.start = 0;
                    this.state = State.ITER_IN_FCD_SEGMENT;
                    return -1;
                }
                if (CollationFCD.hasLccc(iPrevious2)) {
                    if (CollationFCD.maybeTibetanCompositeVowel(iPrevious2)) {
                        iPrevious = -1;
                    } else {
                        iPrevious = this.iter.previous();
                        if (!CollationFCD.hasTccc(iPrevious)) {
                            if (CollationIterator.isTrailSurrogate(iPrevious2)) {
                                if (iPrevious < 0) {
                                    iPrevious = this.iter.previous();
                                }
                                if (CollationIterator.isLeadSurrogate(iPrevious)) {
                                    return Character.toCodePoint((char) iPrevious, (char) iPrevious2);
                                }
                            }
                            if (iPrevious >= 0) {
                                this.iter.next();
                                return iPrevious2;
                            }
                        }
                    }
                    this.iter.next();
                    if (iPrevious >= 0) {
                        this.iter.next();
                    }
                    if (!previousSegment()) {
                        return -1;
                    }
                }
                return iPrevious2;
            }
            if (state == State.ITER_IN_FCD_SEGMENT && this.pos != this.start) {
                int iPreviousCodePoint = this.iter.previousCodePoint();
                this.pos -= Character.charCount(iPreviousCodePoint);
                return iPreviousCodePoint;
            }
            if (state.compareTo(State.IN_NORM_ITER_AT_LIMIT) >= 0 && (i = this.pos) != 0) {
                int iCodePointBefore = this.normalized.codePointBefore(i);
                this.pos -= Character.charCount(iCodePointBefore);
                return iCodePointBefore;
            }
            switchToBackward();
        }
    }

    @Override // com.ibm.icu.impl.coll.IterCollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public void resetToOffset(int i) {
        super.resetToOffset(i);
        this.start = i;
        this.state = State.ITER_CHECK_FWD;
    }
}
