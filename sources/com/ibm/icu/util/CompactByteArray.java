package com.ibm.icu.util;

import com.ibm.icu.impl.Utility;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class CompactByteArray implements Cloneable {
    private static final int BLOCKCOUNT = 128;
    private static final int BLOCKMASK = 127;
    private static final int BLOCKSHIFT = 7;
    private static final int INDEXCOUNT = 512;
    private static final int INDEXSHIFT = 9;

    @Deprecated
    public static final int UNICODECOUNT = 65536;
    byte defaultValue;
    private int[] hashes;
    private char[] indices;
    private boolean isCompact;
    private byte[] values;

    @Deprecated
    public CompactByteArray(byte b) {
        this.values = new byte[65536];
        this.indices = new char[512];
        this.hashes = new int[512];
        for (int i = 0; i < 65536; i++) {
            this.values[i] = b;
        }
        for (int i2 = 0; i2 < 512; i2++) {
            this.indices[i2] = (char) (i2 << 7);
            this.hashes[i2] = 0;
        }
        this.isCompact = false;
        this.defaultValue = b;
    }

    public static final boolean arrayRegionMatches(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i3 + i;
        int i5 = i2 - i;
        while (i < i4) {
            if (bArr[i] != bArr2[i + i5]) {
                return false;
            }
            i++;
        }
        return true;
    }

    private final boolean blockTouched(int i) {
        return this.hashes[i] != 0;
    }

    private void expand() {
        if (this.isCompact) {
            this.hashes = new int[512];
            byte[] bArr = new byte[65536];
            for (int i = 0; i < 65536; i++) {
                byte bElementAt = elementAt((char) i);
                bArr[i] = bElementAt;
                touchBlock(i >> 7, bElementAt);
            }
            for (int i2 = 0; i2 < 512; i2++) {
                this.indices[i2] = (char) (i2 << 7);
            }
            this.values = bArr;
            this.isCompact = false;
        }
    }

    private final void touchBlock(int i, int i2) {
        int[] iArr = this.hashes;
        iArr[i] = (iArr[i] + (i2 << 1)) | 1;
    }

    @Deprecated
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CompactByteArray m24clone() {
        try {
            CompactByteArray compactByteArray = (CompactByteArray) super.clone();
            compactByteArray.values = (byte[]) this.values.clone();
            compactByteArray.indices = (char[]) this.indices.clone();
            int[] iArr = this.hashes;
            if (iArr != null) {
                compactByteArray.hashes = (int[]) iArr.clone();
            }
            return compactByteArray;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Deprecated
    public void compact(boolean z) {
        if (this.isCompact) {
            return;
        }
        char c = 65535;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            char[] cArr = this.indices;
            if (i >= cArr.length) {
                int i4 = i2 * 128;
                byte[] bArr = new byte[i4];
                System.arraycopy(this.values, 0, bArr, 0, i4);
                this.values = bArr;
                this.isCompact = true;
                this.hashes = null;
                return;
            }
            cArr[i] = 65535;
            boolean zBlockTouched = blockTouched(i);
            if (zBlockTouched || c == 65535) {
                int i5 = 0;
                int i6 = 0;
                while (i5 < i2) {
                    int[] iArr = this.hashes;
                    if (iArr[i] == iArr[i5]) {
                        byte[] bArr2 = this.values;
                        if (arrayRegionMatches(bArr2, i3, bArr2, i6, 128)) {
                            this.indices[i] = (char) i6;
                            break;
                        }
                    }
                    i5++;
                    i6 += 128;
                }
                if (this.indices[i] == 65535) {
                    byte[] bArr3 = this.values;
                    System.arraycopy(bArr3, i3, bArr3, i6, 128);
                    char c2 = (char) i6;
                    this.indices[i] = c2;
                    int[] iArr2 = this.hashes;
                    iArr2[i5] = iArr2[i];
                    i2++;
                    if (!zBlockTouched) {
                        c = c2;
                    }
                }
            } else {
                this.indices[i] = c;
            }
            i++;
            i3 += 128;
        }
    }

    @Deprecated
    public byte elementAt(char c) {
        return this.values[(this.indices[c >> 7] & 65535) + (c & 127)];
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (CompactByteArray.class != obj.getClass()) {
            return false;
        }
        CompactByteArray compactByteArray = (CompactByteArray) obj;
        for (int i = 0; i < 65536; i++) {
            char c = (char) i;
            if (elementAt(c) != compactByteArray.elementAt(c)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public char[] getIndexArray() {
        return this.indices;
    }

    @Deprecated
    public byte[] getValueArray() {
        return this.values;
    }

    @Deprecated
    public int hashCode() {
        int iMin = Math.min(3, this.values.length / 16);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.values;
            if (i >= bArr.length) {
                return i2;
            }
            i2 = (i2 * 37) + bArr[i];
            i += iMin;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [char] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    @Deprecated
    public void setElementAt(char c, char c2, byte b) {
        if (this.isCompact) {
            expand();
        }
        while (c <= c2) {
            this.values[c] = b;
            touchBlock(c >> 7, b);
            c++;
        }
    }

    @Deprecated
    public void setElementAt(char c, byte b) {
        if (this.isCompact) {
            expand();
        }
        this.values[c] = b;
        touchBlock(c >> 7, b);
    }

    @Deprecated
    public CompactByteArray() {
        this((byte) 0);
    }

    @Deprecated
    public CompactByteArray(char[] cArr, byte[] bArr) {
        if (cArr.length == 512) {
            for (int i = 0; i < 512; i++) {
                if (cArr[i] >= bArr.length + 128) {
                    og.i("Index out of bounds.");
                    throw null;
                }
            }
            this.indices = cArr;
            this.values = bArr;
            this.isCompact = true;
            return;
        }
        og.i("Index out of bounds.");
        throw null;
    }

    @Deprecated
    public CompactByteArray(String str, String str2) {
        this(Utility.RLEStringToCharArray(str), Utility.RLEStringToByteArray(str2));
    }

    @Deprecated
    public void compact() {
        compact(false);
    }
}
