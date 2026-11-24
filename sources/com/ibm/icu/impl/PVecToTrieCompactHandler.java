package com.ibm.icu.impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PVecToTrieCompactHandler implements PropsVectors.CompactHandler {
    public IntTrieBuilder builder;
    public int initialValue;

    @Override // com.ibm.icu.impl.PropsVectors.CompactHandler
    public void setRowIndexForInitialValue(int i) {
        this.initialValue = i;
    }

    @Override // com.ibm.icu.impl.PropsVectors.CompactHandler
    public void setRowIndexForRange(int i, int i2, int i3) {
        this.builder.setRange(i, i2 + 1, i3, true);
    }

    @Override // com.ibm.icu.impl.PropsVectors.CompactHandler
    public void startRealValues(int i) {
        if (i > 65535) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = this.initialValue;
        this.builder = new IntTrieBuilder(null, 100000, i2, i2, false);
    }

    @Override // com.ibm.icu.impl.PropsVectors.CompactHandler
    public void setRowIndexForErrorValue(int i) {
    }
}
