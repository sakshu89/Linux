package com.ibm.icu.impl.coll;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UVector32 {
    private int[] buffer = new int[32];
    private int length = 0;

    private void ensureAppendCapacity() {
        int i = this.length;
        int[] iArr = this.buffer;
        if (i >= iArr.length) {
            int[] iArr2 = new int[iArr.length <= 65535 ? iArr.length * 4 : iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.buffer = iArr2;
        }
    }

    public void addElement(int i) {
        ensureAppendCapacity();
        int[] iArr = this.buffer;
        int i2 = this.length;
        this.length = i2 + 1;
        iArr[i2] = i;
    }

    public int elementAti(int i) {
        return this.buffer[i];
    }

    public int[] getBuffer() {
        return this.buffer;
    }

    public void insertElementAt(int i, int i2) {
        ensureAppendCapacity();
        int[] iArr = this.buffer;
        System.arraycopy(iArr, i2, iArr, i2 + 1, this.length - i2);
        this.buffer[i2] = i;
        this.length++;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void removeAllElements() {
        this.length = 0;
    }

    public void setElementAt(int i, int i2) {
        this.buffer[i2] = i;
    }

    public int size() {
        return this.length;
    }
}
