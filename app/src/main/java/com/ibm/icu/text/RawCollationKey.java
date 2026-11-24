package com.ibm.icu.text;

import com.ibm.icu.util.ByteArrayWrapper;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class RawCollationKey extends ByteArrayWrapper {
    public RawCollationKey(int i) {
        this.bytes = new byte[i];
    }

    public int compareTo(RawCollationKey rawCollationKey) {
        int iCompareTo = super.compareTo((ByteArrayWrapper) rawCollationKey);
        if (iCompareTo < 0) {
            return -1;
        }
        return iCompareTo == 0 ? 0 : 1;
    }

    public RawCollationKey() {
    }

    public RawCollationKey(byte[] bArr) {
        this.bytes = bArr;
    }

    public RawCollationKey(byte[] bArr, int i) {
        super(bArr, i);
    }
}
