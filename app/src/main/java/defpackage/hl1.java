package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hl1 {
    public final gm1 a;

    public /* synthetic */ hl1(gm1 gm1Var) {
        this.a = gm1Var;
    }

    public static final Object a(gm1 gm1Var) {
        Object objG = gm1Var.g(null);
        if (objG == null) {
            return null;
        }
        if (!(objG instanceof yl1)) {
            gm1Var.k(null);
            return objG;
        }
        yl1 yl1Var = (yl1) objG;
        if (yl1Var.h()) {
            kf2.g("List is empty.");
            return null;
        }
        int i = yl1Var.b - 1;
        Object objF = yl1Var.f(i);
        yl1Var.k(i);
        objF.getClass();
        if (yl1Var.h()) {
            gm1Var.k(null);
        }
        if (yl1Var.b == 1) {
            gm1Var.m(null, yl1Var.e());
        }
        return objF;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x005e A[LOOP:0: B:9:0x001c->B:22:0x005e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[EDGE_INSN: B:25:0x0061->B:23:0x0061 BREAK  A[LOOP:0: B:9:0x001c->B:22:0x005e], SYNTHETIC] */
    public static final yl1 b(gm1 gm1Var) {
        if (gm1Var.i()) {
            yl1 yl1Var = yo1.b;
            yl1Var.getClass();
            return yl1Var;
        }
        yl1 yl1Var2 = new yl1();
        Object[] objArr = gm1Var.c;
        long[] jArr = gm1Var.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            Object obj = objArr[(i << 3) + i3];
                            if (obj instanceof yl1) {
                                yl1Var2.b((yl1) obj);
                            } else {
                                obj.getClass();
                                yl1Var2.a(obj);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return yl1Var2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof hl1) {
            return this.a.equals(((hl1) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MultiValueMap(map=" + this.a + ')';
    }
}
