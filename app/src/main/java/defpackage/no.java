package defpackage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class no implements Iterable, Serializable {
    public static final no c = new no(x21.b);
    public static final mo e;
    public int a = 0;
    public final byte[] b;

    static {
        e = n6.a() ? new qs4(9) : new fl4(9);
    }

    public no(byte[] bArr) {
        bArr.getClass();
        this.b = bArr;
    }

    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            og.o(cq.h("Beginning index: ", i, " < 0"));
            return 0;
        }
        if (i2 < i) {
            og.o(ky0.i("Beginning index larger than ending index: ", i, i2, ", "));
            return 0;
        }
        og.o(ky0.i("End index: ", i2, i3, " >= "));
        return 0;
    }

    public static no d(int i, byte[] bArr, int i2) {
        b(i, i + i2, bArr.length);
        return new no(e.b(i, bArr, i2));
    }

    public byte a(int i) {
        return this.b[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof no) && size() == ((no) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof no)) {
                return obj.equals(this);
            }
            no noVar = (no) obj;
            int i = this.a;
            int i2 = noVar.a;
            if (i == 0 || i2 == 0 || i == i2) {
                int size = size();
                if (size > noVar.size()) {
                    throw new IllegalArgumentException("Length too large: " + size + size());
                }
                if (size > noVar.size()) {
                    og.e(noVar.size(), ky0.p("Ran off end of other: 0, ", size, ", "));
                    return false;
                }
                byte[] bArr = noVar.b;
                int iG = g() + size;
                int iG2 = g();
                int iG3 = noVar.g();
                while (iG2 < iG) {
                    if (this.b[iG2] == bArr[iG3]) {
                        iG2++;
                        iG3++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void f(byte[] bArr, int i) {
        System.arraycopy(this.b, 0, bArr, 0, i);
    }

    public int g() {
        return 0;
    }

    public byte h(int i) {
        return this.b[i];
    }

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iG = g();
        int i2 = size;
        for (int i3 = iG; i3 < iG + size; i3++) {
            i2 = (i2 * 31) + this.b[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.a = i2;
        return i2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new ko(this);
    }

    public int size() {
        return this.b.length;
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strConcat = dc4.a(this);
        } else {
            int iB = b(0, 47, size());
            strConcat = dc4.a(iB == 0 ? c : new lo(this.b, g(), iB)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return cq.n(sb, strConcat, "\">");
    }
}
