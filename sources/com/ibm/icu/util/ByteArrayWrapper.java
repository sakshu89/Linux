package com.ibm.icu.util;

import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacterEnums;
import defpackage.ky0;
import defpackage.og;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ByteArrayWrapper implements Comparable<ByteArrayWrapper> {
    public byte[] bytes;
    public int size;

    public ByteArrayWrapper(byte[] bArr, int i) {
        if ((bArr == null && i != 0) || i < 0 || (bArr != null && i > bArr.length)) {
            og.o(ky0.h(i, "illegal size: "));
            throw null;
        }
        this.bytes = bArr;
        this.size = i;
    }

    private static final void copyBytes(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i3 >= 64) {
            System.arraycopy(bArr, i, bArr2, i2, i3);
            return;
        }
        while (true) {
            i3--;
            if (i3 < 0) {
                return;
            }
            bArr2[i2] = bArr[i];
            i++;
            i2++;
        }
    }

    public final ByteArrayWrapper append(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        ensureCapacity(this.size + i3);
        copyBytes(bArr, i, this.bytes, this.size, i3);
        this.size += i3;
        return this;
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteArrayWrapper byteArrayWrapper) {
        int i;
        int i2;
        if (this == byteArrayWrapper) {
            return 0;
        }
        int i3 = this.size;
        int i4 = byteArrayWrapper.size;
        if (i3 >= i4) {
            i3 = i4;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            byte b = this.bytes[i5];
            byte b2 = byteArrayWrapper.bytes[i5];
            if (b != b2) {
                i = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                i2 = b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                return i - i2;
            }
        }
        i = this.size;
        i2 = byteArrayWrapper.size;
        return i - i2;
    }

    public ByteArrayWrapper ensureCapacity(int i) {
        byte[] bArr = this.bytes;
        if (bArr != null && bArr.length >= i) {
            return this;
        }
        byte[] bArr2 = new byte[i];
        if (bArr != null) {
            copyBytes(bArr, 0, bArr2, 0, this.size);
        }
        this.bytes = bArr2;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            ByteArrayWrapper byteArrayWrapper = (ByteArrayWrapper) obj;
            if (this.size != byteArrayWrapper.size) {
                return false;
            }
            for (int i = 0; i < this.size; i++) {
                if (this.bytes[i] != byteArrayWrapper.bytes[i]) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        int i = this.size;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 37) + this.bytes[i2];
        }
        return i;
    }

    public final byte[] releaseBytes() {
        byte[] bArr = this.bytes;
        this.bytes = null;
        this.size = 0;
        return bArr;
    }

    public final ByteArrayWrapper set(byte[] bArr, int i, int i2) {
        this.size = 0;
        append(bArr, i, i2);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                sb.append(Padder.FALLBACK_PADDING_STRING);
            }
            sb.append(Utility.hex(this.bytes[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED, 2));
        }
        return sb.toString();
    }

    public ByteArrayWrapper() {
    }

    public ByteArrayWrapper(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        this.size = iLimit;
        byte[] bArr = new byte[iLimit];
        this.bytes = bArr;
        byteBuffer.get(bArr, 0, iLimit);
    }
}
