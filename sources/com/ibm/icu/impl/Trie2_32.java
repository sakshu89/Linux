package com.ibm.icu.impl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Trie2_32 extends Trie2 {
    public static Trie2_32 createFromSerialized(ByteBuffer byteBuffer) {
        return (Trie2_32) Trie2.createFromSerialized(byteBuffer);
    }

    @Override // com.ibm.icu.impl.Trie2
    public final int get(int i) {
        if (i >= 0) {
            if (i < 55296 || (i > 56319 && i <= 65535)) {
                return this.data32[(this.index[i >> 5] << 2) + (i & 31)];
            }
            if (i <= 65535) {
                return this.data32[(this.index[((i - 55296) >> 5) + 2048] << 2) + (i & 31)];
            }
            if (i < this.highStart) {
                char[] cArr = this.index;
                return this.data32[(cArr[cArr[(i >> 11) + 2080] + ((i >> 5) & 63)] << 2) + (i & 31)];
            }
            if (i <= 1114111) {
                return this.data32[this.highValueIndex];
            }
        }
        return this.errorValue;
    }

    @Override // com.ibm.icu.impl.Trie2
    public int getFromU16SingleLead(char c) {
        return this.data32[(this.index[c >> 5] << 2) + (c & 31)];
    }

    public int getSerializedLength() {
        return (this.dataLength * 4) + (this.header.indexLength * 2) + 16;
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
                    if (i >= this.highStart) {
                        if (i3 != this.data32[this.highValueIndex]) {
                            break;
                        }
                        i = i2;
                        break;
                    }
                    char[] cArr = this.index;
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
                int i5 = (i & 31) + i4;
                int i6 = i4 + 32;
                for (int i7 = i5; i7 < i6; i7++) {
                    if (this.data32[i7] != i3) {
                        i += i7 - i5;
                        break loop0;
                    }
                }
                i += i6 - i5;
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
                return (i2 * 4) + iSerializeHeader;
            }
            dataOutputStream.writeInt(this.data32[i]);
            i++;
        }
    }
}
