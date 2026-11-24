package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.util.RangeValueIterator;
import defpackage.dk0;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TrieIterator implements RangeValueIterator {
    private static final int BMP_INDEX_LENGTH_ = 2048;
    private static final int DATA_BLOCK_LENGTH_ = 32;
    private static final int LEAD_SURROGATE_MIN_VALUE_ = 55296;
    private static final int TRAIL_SURROGATE_COUNT_ = 1024;
    private static final int TRAIL_SURROGATE_INDEX_BLOCK_LENGTH_ = 32;
    private static final int TRAIL_SURROGATE_MIN_VALUE_ = 56320;
    private int m_currentCodepoint_;
    private int m_initialValue_;
    private int m_nextBlockIndex_;
    private int m_nextBlock_;
    private int m_nextCodepoint_;
    private int m_nextIndex_;
    private int m_nextTrailIndexOffset_;
    private int m_nextValue_;
    private Trie m_trie_;

    public TrieIterator(Trie trie) {
        if (trie == null) {
            og.i("Argument trie cannot be null");
            throw null;
        }
        this.m_trie_ = trie;
        this.m_initialValue_ = extract(trie.getInitialValue());
        reset();
    }

    private final boolean calculateNextBMPElement(RangeValueIterator.Element element) {
        int i = this.m_nextValue_;
        int i2 = this.m_nextCodepoint_;
        this.m_currentCodepoint_ = i2;
        this.m_nextCodepoint_ = i2 + 1;
        this.m_nextBlockIndex_++;
        if (!checkBlockDetail(i)) {
            setResult(element, this.m_currentCodepoint_, this.m_nextCodepoint_, i);
            return true;
        }
        do {
            int i3 = this.m_nextCodepoint_;
            if (i3 >= 65536) {
                this.m_nextCodepoint_ = i3 - 1;
                this.m_nextBlockIndex_--;
                return false;
            }
            if (i3 == 55296) {
                this.m_nextIndex_ = 2048;
            } else if (i3 == 56320) {
                this.m_nextIndex_ = i3 >> 5;
            } else {
                this.m_nextIndex_++;
            }
            this.m_nextBlockIndex_ = 0;
        } while (checkBlock(i));
        setResult(element, this.m_currentCodepoint_, this.m_nextCodepoint_, i);
        return true;
    }

    private final void calculateNextSupplementaryElement(RangeValueIterator.Element element) {
        int i = this.m_nextValue_;
        int i2 = this.m_nextCodepoint_ + 1;
        this.m_nextCodepoint_ = i2;
        this.m_nextBlockIndex_++;
        if (UTF16.getTrailSurrogate(i2) != 56320) {
            if (!checkNullNextTrailIndex() && !checkBlockDetail(i)) {
                setResult(element, this.m_currentCodepoint_, this.m_nextCodepoint_, i);
                this.m_currentCodepoint_ = this.m_nextCodepoint_;
                return;
            }
            this.m_nextIndex_++;
            this.m_nextTrailIndexOffset_++;
            if (!checkTrailBlock(i)) {
                setResult(element, this.m_currentCodepoint_, this.m_nextCodepoint_, i);
                this.m_currentCodepoint_ = this.m_nextCodepoint_;
                return;
            }
        }
        int leadSurrogate = UTF16.getLeadSurrogate(this.m_nextCodepoint_);
        while (leadSurrogate < 56320) {
            Trie trie = this.m_trie_;
            int i3 = trie.m_index_[leadSurrogate >> 5] << 2;
            if (i3 == trie.m_dataOffset_) {
                int i4 = this.m_initialValue_;
                if (i != i4) {
                    this.m_nextValue_ = i4;
                    this.m_nextBlock_ = i3;
                    this.m_nextBlockIndex_ = 0;
                    setResult(element, this.m_currentCodepoint_, this.m_nextCodepoint_, i);
                    this.m_currentCodepoint_ = this.m_nextCodepoint_;
                    return;
                }
                leadSurrogate += 32;
                this.m_nextCodepoint_ = Character.toCodePoint((char) leadSurrogate, UCharacter.MIN_LOW_SURROGATE);
            } else {
                Trie.DataManipulate dataManipulate = trie.m_dataManipulate_;
                if (dataManipulate == null) {
                    dk0.n("The field DataManipulate in this Trie is null");
                    return;
                }
                int foldingOffset = dataManipulate.getFoldingOffset(trie.getValue(i3 + (leadSurrogate & 31)));
                this.m_nextIndex_ = foldingOffset;
                if (foldingOffset <= 0) {
                    int i5 = this.m_initialValue_;
                    if (i != i5) {
                        this.m_nextValue_ = i5;
                        this.m_nextBlock_ = this.m_trie_.m_dataOffset_;
                        this.m_nextBlockIndex_ = 0;
                        setResult(element, this.m_currentCodepoint_, this.m_nextCodepoint_, i);
                        this.m_currentCodepoint_ = this.m_nextCodepoint_;
                        return;
                    }
                    this.m_nextCodepoint_ += 1024;
                } else {
                    this.m_nextTrailIndexOffset_ = 0;
                    if (!checkTrailBlock(i)) {
                        setResult(element, this.m_currentCodepoint_, this.m_nextCodepoint_, i);
                        this.m_currentCodepoint_ = this.m_nextCodepoint_;
                        return;
                    }
                }
                leadSurrogate++;
            }
        }
        setResult(element, this.m_currentCodepoint_, 1114112, i);
    }

    private final boolean checkBlock(int i) {
        int i2 = this.m_nextBlock_;
        Trie trie = this.m_trie_;
        int i3 = trie.m_index_[this.m_nextIndex_] << 2;
        this.m_nextBlock_ = i3;
        if (i3 == i2) {
            int i4 = this.m_nextCodepoint_;
            if (i4 - this.m_currentCodepoint_ >= 32) {
                this.m_nextCodepoint_ = i4 + 32;
                return true;
            }
        }
        if (i3 != trie.m_dataOffset_) {
            return checkBlockDetail(i);
        }
        int i5 = this.m_initialValue_;
        if (i == i5) {
            this.m_nextCodepoint_ += 32;
            return true;
        }
        this.m_nextValue_ = i5;
        this.m_nextBlockIndex_ = 0;
        return false;
    }

    private final boolean checkBlockDetail(int i) {
        while (true) {
            int i2 = this.m_nextBlockIndex_;
            if (i2 >= 32) {
                return true;
            }
            int iExtract = extract(this.m_trie_.getValue(this.m_nextBlock_ + i2));
            this.m_nextValue_ = iExtract;
            if (iExtract != i) {
                return false;
            }
            this.m_nextBlockIndex_++;
            this.m_nextCodepoint_++;
        }
    }

    private final boolean checkNullNextTrailIndex() {
        if (this.m_nextIndex_ > 0) {
            return false;
        }
        int i = this.m_nextCodepoint_ + UCharacterProperty.MAX_SCRIPT;
        this.m_nextCodepoint_ = i;
        char leadSurrogate = UTF16.getLeadSurrogate(i);
        Trie trie = this.m_trie_;
        int i2 = trie.m_index_[leadSurrogate >> 5] << 2;
        Trie.DataManipulate dataManipulate = trie.m_dataManipulate_;
        if (dataManipulate == null) {
            dk0.n("The field DataManipulate in this Trie is null");
            return false;
        }
        this.m_nextIndex_ = dataManipulate.getFoldingOffset(trie.getValue(i2 + (leadSurrogate & 31))) - 1;
        this.m_nextBlockIndex_ = 32;
        return true;
    }

    private final boolean checkTrailBlock(int i) {
        while (this.m_nextTrailIndexOffset_ < 32) {
            this.m_nextBlockIndex_ = 0;
            if (!checkBlock(i)) {
                return false;
            }
            this.m_nextTrailIndexOffset_++;
            this.m_nextIndex_++;
        }
        return true;
    }

    private final void setResult(RangeValueIterator.Element element, int i, int i2, int i3) {
        element.start = i;
        element.limit = i2;
        element.value = i3;
    }

    @Override // com.ibm.icu.util.RangeValueIterator
    public final boolean next(RangeValueIterator.Element element) {
        int i = this.m_nextCodepoint_;
        if (i > 1114111) {
            return false;
        }
        if (i < 65536 && calculateNextBMPElement(element)) {
            return true;
        }
        calculateNextSupplementaryElement(element);
        return true;
    }

    @Override // com.ibm.icu.util.RangeValueIterator
    public final void reset() {
        this.m_currentCodepoint_ = 0;
        this.m_nextCodepoint_ = 0;
        this.m_nextIndex_ = 0;
        Trie trie = this.m_trie_;
        int i = trie.m_index_[0] << 2;
        this.m_nextBlock_ = i;
        if (i == trie.m_dataOffset_) {
            this.m_nextValue_ = this.m_initialValue_;
        } else {
            this.m_nextValue_ = extract(trie.getValue(i));
        }
        this.m_nextBlockIndex_ = 0;
        this.m_nextTrailIndexOffset_ = 32;
    }

    public int extract(int i) {
        return i;
    }
}
