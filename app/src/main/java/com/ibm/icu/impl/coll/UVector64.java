package com.ibm.icu.impl.coll;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UVector64 {
    private long[] buffer = new long[32];
    private int length = 0;

    private void ensureAppendCapacity() {
        int i = this.length;
        long[] jArr = this.buffer;
        if (i >= jArr.length) {
            long[] jArr2 = new long[jArr.length <= 65535 ? jArr.length * 4 : jArr.length * 2];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.buffer = jArr2;
        }
    }

    public void addElement(long j) {
        ensureAppendCapacity();
        long[] jArr = this.buffer;
        int i = this.length;
        this.length = i + 1;
        jArr[i] = j;
    }

    public long elementAti(int i) {
        return this.buffer[i];
    }

    public long[] getBuffer() {
        return this.buffer;
    }

    public void insertElementAt(long j, int i) {
        ensureAppendCapacity();
        long[] jArr = this.buffer;
        System.arraycopy(jArr, i, jArr, i + 1, this.length - i);
        this.buffer[i] = j;
        this.length++;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void removeAllElements() {
        this.length = 0;
    }

    public void setElementAt(long j, int i) {
        this.buffer[i] = j;
    }

    public int size() {
        return this.length;
    }
}
