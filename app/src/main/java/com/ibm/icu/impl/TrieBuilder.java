package com.ibm.icu.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TrieBuilder {
    protected static final int BMP_INDEX_LENGTH_ = 2048;
    public static final int DATA_BLOCK_LENGTH = 32;
    protected static final int DATA_GRANULARITY_ = 4;
    protected static final int INDEX_SHIFT_ = 2;
    protected static final int MASK_ = 31;
    private static final int MAX_BUILD_TIME_DATA_LENGTH_ = 1115168;
    protected static final int MAX_DATA_LENGTH_ = 262144;
    protected static final int MAX_INDEX_LENGTH_ = 34816;
    protected static final int OPTIONS_DATA_IS_32_BIT_ = 256;
    protected static final int OPTIONS_INDEX_SHIFT_ = 4;
    protected static final int OPTIONS_LATIN1_IS_LINEAR_ = 512;
    protected static final int SHIFT_ = 5;
    protected static final int SURROGATE_BLOCK_COUNT_ = 32;
    protected int m_dataCapacity_;
    protected int m_dataLength_;
    protected int m_indexLength_;
    protected int[] m_index_;
    protected boolean m_isCompacted_;
    protected boolean m_isLatin1Linear_;
    protected int[] m_map_;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface DataManipulate {
        int getFoldedValue(int i, int i2);
    }

    public TrieBuilder(TrieBuilder trieBuilder) {
        int[] iArr = new int[MAX_INDEX_LENGTH_];
        this.m_index_ = iArr;
        int i = trieBuilder.m_indexLength_;
        this.m_indexLength_ = i;
        System.arraycopy(trieBuilder.m_index_, 0, iArr, 0, i);
        this.m_dataCapacity_ = trieBuilder.m_dataCapacity_;
        this.m_dataLength_ = trieBuilder.m_dataLength_;
        int[] iArr2 = new int[trieBuilder.m_map_.length];
        this.m_map_ = iArr2;
        System.arraycopy(trieBuilder.m_map_, 0, iArr2, 0, iArr2.length);
        this.m_isLatin1Linear_ = trieBuilder.m_isLatin1Linear_;
        this.m_isCompacted_ = trieBuilder.m_isCompacted_;
    }

    public static final boolean equal_int(int[] iArr, int i, int i2, int i3) {
        while (i3 > 0 && iArr[i] == iArr[i2]) {
            i++;
            i2++;
            i3--;
        }
        return i3 == 0;
    }

    public static final int findSameIndexBlock(int[] iArr, int i, int i2) {
        for (int i3 = 2048; i3 < i; i3 += 32) {
            if (equal_int(iArr, i3, i2, 32)) {
                return i3;
            }
        }
        return i;
    }

    public void findUnusedBlocks() {
        Arrays.fill(this.m_map_, 255);
        int i = 0;
        while (true) {
            int i2 = this.m_indexLength_;
            int[] iArr = this.m_map_;
            if (i >= i2) {
                iArr[0] = 0;
                return;
            } else {
                iArr[Math.abs(this.m_index_[i]) >> 5] = 0;
                i++;
            }
        }
    }

    public boolean isInZeroBlock(int i) {
        return this.m_isCompacted_ || i > 1114111 || i < 0 || this.m_index_[i >> 5] == 0;
    }

    public TrieBuilder() {
        this.m_index_ = new int[MAX_INDEX_LENGTH_];
        this.m_map_ = new int[34849];
        this.m_isLatin1Linear_ = false;
        this.m_isCompacted_ = false;
        this.m_indexLength_ = MAX_INDEX_LENGTH_;
    }
}
