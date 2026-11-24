package com.ibm.icu.impl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Trie2_16 extends Trie2 {
    public static Trie2_16 createFromSerialized(ByteBuffer byteBuffer) {
        return (Trie2_16) Trie2.createFromSerialized(byteBuffer);
    }

    @Override // com.ibm.icu.impl.Trie2
    public final int get(int i) {
        if (i >= 0) {
            if (i < 55296 || (i > 56319 && i <= 65535)) {
                char[] cArr = this.index;
                return cArr[(cArr[i >> 5] << 2) + (i & 31)];
            }
            if (i <= 65535) {
                char[] cArr2 = this.index;
                return cArr2[(cArr2[((i - 55296) >> 5) + 2048] << 2) + (i & 31)];
            }
            if (i < this.highStart) {
                char[] cArr3 = this.index;
                return cArr3[(cArr3[cArr3[(i >> 11) + 2080] + ((i >> 5) & 63)] << 2) + (i & 31)];
            }
            if (i <= 1114111) {
                return this.index[this.highValueIndex];
            }
        }
        return this.errorValue;
    }

    @Override // com.ibm.icu.impl.Trie2
    public int getFromU16SingleLead(char c) {
        char[] cArr = this.index;
        return cArr[(cArr[c >> 5] << 2) + (c & 31)];
    }

    public int getSerializedLength() {
        return ((this.header.indexLength + this.dataLength) * 2) + 16;
    }

    @Override // com.ibm.icu.impl.Trie2
    public int rangeEnd(int i, int i2, int i3) {
        int i4;
        char c;
        char c2;
        loop0: while (i < i2) {
            if (i < 55296 || (i > 56319 && i <= 65535)) {
                i4 = this.index[i >> 5] << 2;
                c = 0;
            } else {
                if (i >= 65535) {
                    int i5 = this.highStart;
                    char[] cArr = this.index;
                    if (i >= i5) {
                        if (i3 != cArr[this.highValueIndex]) {
                            break;
                        }
                        i = i2;
                        break;
                    }
                    c = cArr[(i >> 11) + 2080];
                    c2 = cArr[((i >> 5) & 63) + c];
                } else {
                    c = 2048;
                    c2 = this.index[((i - 55296) >> 5) + 2048];
                }
                i4 = c2 << 2;
            }
            if (c == this.index2NullOffset) {
                if (i3 != this.initialValue) {
                    break;
                }
                i += 2048;
            } else if (i4 != this.dataNullOffset) {
                int i6 = (i & 31) + i4;
                int i7 = i4 + 32;
                for (int i8 = i6; i8 < i7; i8++) {
                    if (this.index[i8] != i3) {
                        i += i8 - i6;
                        break loop0;
                    }
                }
                i += i7 - i6;
            } else {
                if (i3 != this.initialValue) {
                    break;
                }
                i += 32;
            }
        }
        if (i <= i2) {
            i2 = i;
        }
        return i2 - 1;
    }

    public int serialize(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        int iSerializeHeader = serializeHeader(dataOutputStream);
        int i = 0;
        while (true) {
            int i2 = this.dataLength;
            if (i >= i2) {
                return (i2 * 2) + iSerializeHeader;
            }
            dataOutputStream.writeChar(this.index[this.data16 + i]);
            i++;
        }
    }
}
