package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class nh4 {
    public static un a(int i, int i2, nn nnVar) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        int i3 = i2 & 2;
        nn nnVar2 = nn.a;
        if (i3 != 0) {
            nnVar = nnVar2;
        }
        if (i == -2) {
            if (nnVar != nnVar2) {
                return new v30(1, nnVar);
            }
            bx.o.getClass();
            return new un(ax.b);
        }
        if (i == -1) {
            if (nnVar == nnVar2) {
                return new v30(1, nn.b);
            }
            og.i("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            return null;
        }
        if (i == 0) {
            return nnVar == nnVar2 ? new un(0) : new v30(1, nnVar);
        }
        if (i != Integer.MAX_VALUE) {
            return nnVar == nnVar2 ? new un(i) : new v30(i, nnVar);
        }
        return new un(Integer.MAX_VALUE);
    }

    public static void b(int i, int i2) {
        String strD;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strD = ph4.d("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    og.i(ky0.h(i2, "negative size: "));
                    return;
                }
                strD = ph4.d("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strD);
        }
    }

    public static void c(int i, int i2, int i3) {
        String strD;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strD = d(i, i3, "start index");
            } else {
                strD = (i2 < 0 || i2 > i3) ? d(i2, i3, "end index") : ph4.d("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strD);
        }
    }

    public static String d(int i, int i2, String str) {
        if (i < 0) {
            return ph4.d("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return ph4.d("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        og.i(ky0.h(i2, "negative size: "));
        return null;
    }
}
