package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacterEnums;
import defpackage.ky0;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationKey implements Comparable<CollationKey> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MERGE_SEPERATOR_ = 2;
    private int m_hashCode_;
    private byte[] m_key_;
    private int m_length_;
    private String m_source_;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class BoundMode {

        @Deprecated
        public static final int COUNT = 3;
        public static final int LOWER = 0;
        public static final int UPPER = 1;
        public static final int UPPER_LONG = 2;

        private BoundMode() {
        }
    }

    public CollationKey(String str, RawCollationKey rawCollationKey) {
        this.m_source_ = str;
        this.m_length_ = rawCollationKey.size - 1;
        this.m_key_ = rawCollationKey.releaseBytes();
        this.m_hashCode_ = 0;
    }

    private int getLength() {
        int i = this.m_length_;
        if (i >= 0) {
            return i;
        }
        int length = this.m_key_.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.m_key_[i2] == 0) {
                length = i2;
                break;
            }
        }
        this.m_length_ = length;
        return length;
    }

    @Override // java.lang.Comparable
    public int compareTo(CollationKey collationKey) {
        int i = 0;
        while (true) {
            int i2 = this.m_key_[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            int i3 = collationKey.m_key_[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            if (i2 == 0) {
                return 0;
            }
            i++;
        }
    }

    public boolean equals(CollationKey collationKey) {
        if (this == collationKey) {
            return true;
        }
        if (collationKey == null) {
            return false;
        }
        int i = 0;
        while (true) {
            byte b = this.m_key_[i];
            if (b != collationKey.m_key_[i]) {
                return false;
            }
            if (b == 0) {
                return true;
            }
            i++;
        }
    }

    public CollationKey getBound(int i, int i2) {
        byte b;
        int i3 = 0;
        int i4 = 0;
        if (i2 > 0) {
            while (true) {
                byte[] bArr = this.m_key_;
                if (i3 >= bArr.length || (b = bArr[i3]) == 0) {
                    break;
                }
                int i5 = i3 + 1;
                if (b == 1) {
                    i4++;
                    i2--;
                    if (i2 == 0 || i5 == bArr.length || bArr[i5] == 0) {
                        break;
                    }
                }
                i3 = i5;
            }
        }
        if (i2 > 0) {
            og.i(ky0.i("Source collation key has only ", i4, i4, " strength level. Call getBound() again  with noOfLevels < "));
            return null;
        }
        byte[] bArr2 = new byte[i3 + i + 1];
        System.arraycopy(this.m_key_, 0, bArr2, 0, i3);
        if (i != 0) {
            if (i == 1) {
                bArr2[i3] = 2;
                i3++;
            } else {
                if (i != 2) {
                    og.i("Illegal boundType argument");
                    return null;
                }
                int i6 = i3 + 1;
                bArr2[i3] = -1;
                i3 += 2;
                bArr2[i6] = -1;
            }
        }
        bArr2[i3] = 0;
        return new CollationKey(null, bArr2, i3);
    }

    public String getSourceString() {
        return this.m_source_;
    }

    public int hashCode() {
        byte b;
        byte b2;
        if (this.m_hashCode_ == 0) {
            byte[] bArr = this.m_key_;
            if (bArr == null) {
                this.m_hashCode_ = 1;
            } else {
                StringBuilder sb = new StringBuilder(bArr.length >> 1);
                int i = 0;
                while (true) {
                    byte[] bArr2 = this.m_key_;
                    b = bArr2[i];
                    if (b == 0 || (b2 = bArr2[i + 1]) == 0) {
                        break;
                    }
                    sb.append((char) ((b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | (b << 8)));
                    i += 2;
                }
                if (b != 0) {
                    sb.append((char) (b << 8));
                }
                this.m_hashCode_ = sb.toString().hashCode();
            }
        }
        return this.m_hashCode_;
    }

    public CollationKey merge(CollationKey collationKey) {
        int i;
        byte[] bArr;
        byte b;
        byte[] bArr2;
        if (collationKey == null || collationKey.getLength() == 0) {
            og.i("CollationKey argument can not be null or of 0 length");
            return null;
        }
        byte[] bArr3 = new byte[getLength() + collationKey.getLength() + 2];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            byte b2 = this.m_key_[i2];
            if (b2 < 0 || b2 >= 2) {
                i2++;
                bArr3[i3] = b2;
                i3++;
            } else {
                i = i3 + 1;
                bArr3[i3] = 2;
                while (true) {
                    bArr = collationKey.m_key_;
                    b = bArr[i4];
                    if (b >= 0 && b < 2) {
                        break;
                    }
                    i4++;
                    bArr3[i] = b;
                    i++;
                }
                bArr2 = this.m_key_;
                if (bArr2[i2] != 1 || b != 1) {
                    break;
                }
                i2++;
                i4++;
                i3 = i + 1;
                bArr3[i] = 1;
            }
        }
        int i5 = this.m_length_ - i2;
        if (i5 <= 0) {
            i5 = collationKey.m_length_ - i4;
            if (i5 > 0) {
                System.arraycopy(bArr, i4, bArr3, i, i5);
            }
            bArr3[i] = 0;
            return new CollationKey(null, bArr3, i);
        }
        System.arraycopy(bArr2, i2, bArr3, i, i5);
        i += i5;
        bArr3[i] = 0;
        return new CollationKey(null, bArr3, i);
    }

    public byte[] toByteArray() {
        int length = getLength() + 1;
        byte[] bArr = new byte[length];
        System.arraycopy(this.m_key_, 0, bArr, 0, length);
        return bArr;
    }

    private CollationKey(String str, byte[] bArr, int i) {
        this.m_source_ = str;
        this.m_key_ = bArr;
        this.m_hashCode_ = 0;
        this.m_length_ = i;
    }

    public CollationKey(String str, byte[] bArr) {
        this(str, bArr, -1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CollationKey) {
            return equals((CollationKey) obj);
        }
        return false;
    }
}
