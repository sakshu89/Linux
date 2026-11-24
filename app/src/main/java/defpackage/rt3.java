package defpackage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class rt3 implements Iterable, Serializable {
    public static final qt3 b = new qt3(nu3.b);
    public int a;

    static {
        int i = lt3.a;
    }

    public static int f(int i, int i2, int i3) {
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

    public static qt3 g(int i, byte[] bArr, int i2) {
        f(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new qt3(bArr2);
    }

    public abstract byte a(int i);

    public abstract byte b(int i);

    public abstract int d();

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int iD = d();
        qt3 qt3Var = (qt3) this;
        int i2 = iD;
        for (int i3 = 0; i3 < iD; i3++) {
            i2 = (i2 * 31) + qt3Var.c[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.a = i2;
        return i2;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new ko(this);
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iD = d();
        if (d() <= 50) {
            strConcat = xg4.d(this);
        } else {
            qt3 qt3Var = (qt3) this;
            int iF = f(0, 47, qt3Var.d());
            strConcat = xg4.d(iF == 0 ? b : new ot3(qt3Var.c, iF)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iD);
        sb.append(" contents=\"");
        return cq.n(sb, strConcat, "\">");
    }
}
