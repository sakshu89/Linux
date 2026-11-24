package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tz3 {
    public static final py0 a;
    public static final py0 b;
    public static final py0 c;
    public static final py0 d;
    public static final py0 e;
    public static final di0 f = new di0(false);
    public static final di0 g = new di0(true);

    static {
        int i = 16;
        a = new py0(i, "COMPLETING_ALREADY");
        b = new py0(i, "COMPLETING_WAITING_CHILDREN");
        c = new py0(i, "COMPLETING_RETRY");
        d = new py0(i, "TOO_LATE_TO_CANCEL");
        e = new py0(i, "SEALED");
    }

    public static final void a(gm1 gm1Var, Object obj, Object obj2) {
        int iF = gm1Var.f(obj);
        boolean z = iF < 0;
        Object obj3 = z ? null : gm1Var.c[iF];
        if (obj3 != null) {
            if (obj3 instanceof hm1) {
                ((hm1) obj3).a(obj2);
            } else if (obj3 != obj2) {
                hm1 hm1Var = new hm1();
                hm1Var.a(obj3);
                hm1Var.a(obj2);
                obj2 = hm1Var;
            }
            obj2 = obj3;
        }
        if (!z) {
            gm1Var.c[iF] = obj2;
            return;
        }
        int i = ~iF;
        gm1Var.b[i] = obj;
        gm1Var.c[i] = obj2;
    }

    public static gm1 b() {
        long[] jArr = ya2.a;
        return new gm1();
    }

    public static final boolean c(gm1 gm1Var, Object obj, Object obj2) {
        Object objG = gm1Var.g(obj);
        if (objG == null) {
            return false;
        }
        if (!(objG instanceof hm1)) {
            if (!objG.equals(obj2)) {
                return false;
            }
            gm1Var.k(obj);
            return true;
        }
        hm1 hm1Var = (hm1) objG;
        boolean zL = hm1Var.l(obj2);
        if (zL && hm1Var.g()) {
            gm1Var.k(obj);
        }
        return zL;
    }

    public static final void d(gm1 gm1Var, Object obj) {
        boolean zG;
        long[] jArr = gm1Var.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj2 = gm1Var.b[i4];
                        Object obj3 = gm1Var.c[i4];
                        if (obj3 instanceof hm1) {
                            hm1 hm1Var = (hm1) obj3;
                            hm1Var.l(obj);
                            zG = hm1Var.g();
                        } else {
                            zG = obj3 == obj;
                        }
                        if (zG) {
                            gm1Var.l(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public static final Object e(Object obj) {
        rz0 rz0Var;
        sz0 sz0Var = obj instanceof sz0 ? (sz0) obj : null;
        return (sz0Var == null || (rz0Var = sz0Var.a) == null) ? obj : rz0Var;
    }
}
