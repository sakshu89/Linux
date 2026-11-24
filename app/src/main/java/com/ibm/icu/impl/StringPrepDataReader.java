package com.ibm.icu.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class StringPrepDataReader implements ICUBinary.Authenticate {
    private static final int DATA_FORMAT_ID = 1397772880;
    private ByteBuffer byteBuffer;
    private int unicodeVersion;
    private static final boolean debug = ICUDebug.enabled("NormalizerDataReader");
    private static final byte[] DATA_FORMAT_VERSION = {3, 2, 5, 2};

    public StringPrepDataReader(ByteBuffer byteBuffer) {
        boolean z = debug;
        if (z) {
            System.out.println("Bytes in buffer " + byteBuffer.remaining());
        }
        this.byteBuffer = byteBuffer;
        this.unicodeVersion = ICUBinary.readHeader(byteBuffer, DATA_FORMAT_ID, this);
        if (z) {
            System.out.println("Bytes left in byteBuffer " + this.byteBuffer.remaining());
        }
    }

    public byte[] getUnicodeVersion() {
        return ICUBinary.getVersionByteArrayFromCompactInt(this.unicodeVersion);
    }

    @Override // com.ibm.icu.impl.ICUBinary.Authenticate
    public boolean isDataVersionAcceptable(byte[] bArr) {
        byte b = bArr[0];
        byte[] bArr2 = DATA_FORMAT_VERSION;
        return b == bArr2[0] && bArr[2] == bArr2[2] && bArr[3] == bArr2[3];
    }

    public char[] read(int i) {
        return ICUBinary.getChars(this.byteBuffer, i, 0);
    }

    public int[] readIndexes(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.byteBuffer.getInt();
        }
        return iArr;
    }
}
