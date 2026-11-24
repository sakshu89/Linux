package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cg2 implements og2, Iterable, x41 {
    public final gm1 a;
    public ah1 b;
    public boolean c;
    public boolean e;

    public cg2() {
        long[] jArr = ya2.a;
        this.a = new gm1();
    }

    @Override // defpackage.og2
    public final void a(ng2 ng2Var, Object obj) {
        boolean z = obj instanceof b2;
        gm1 gm1Var = this.a;
        if (z && gm1Var.c(ng2Var)) {
            Object objG = gm1Var.g(ng2Var);
            objG.getClass();
            b2 b2Var = (b2) objG;
            b2 b2Var2 = (b2) obj;
            String str = b2Var2.a;
            if (str == null) {
                str = b2Var.a;
            }
            rq0 rq0Var = b2Var2.b;
            if (rq0Var == null) {
                rq0Var = b2Var.b;
            }
            gm1Var.m(ng2Var, new b2(str, rq0Var));
        } else {
            gm1Var.m(ng2Var, obj);
        }
        ng2Var.getClass();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x005d A[LOOP:0: B:5:0x0026->B:15:0x005d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:18:0x0060 A[EDGE_INSN: B:18:0x0060->B:16:0x0060 BREAK  A[LOOP:0: B:5:0x0026->B:15:0x005d], SYNTHETIC] */
    public final cg2 b() {
        cg2 cg2Var = new cg2();
        cg2Var.c = this.c;
        cg2Var.e = this.e;
        gm1 gm1Var = cg2Var.a;
        gm1Var.getClass();
        gm1 gm1Var2 = this.a;
        gm1Var2.getClass();
        Object[] objArr = gm1Var2.b;
        Object[] objArr2 = gm1Var2.c;
        long[] jArr = gm1Var2.a;
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
                            int i4 = (i << 3) + i3;
                            gm1Var.m(objArr[i4], objArr2[i4]);
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
        return cg2Var;
    }

    public final Object d(ng2 ng2Var) {
        Object objG = this.a.g(ng2Var);
        if (objG != null) {
            return objG;
        }
        throw new IllegalStateException("Key not present: " + ng2Var + " - consider getOrElse or getOrNull");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cg2)) {
            return false;
        }
        cg2 cg2Var = (cg2) obj;
        return g31.a(this.a, cg2Var.a) && this.c == cg2Var.c && this.e == cg2Var.e;
    }

    public final void f(cg2 cg2Var) {
        gm1 gm1Var = cg2Var.a;
        Object[] objArr = gm1Var.b;
        Object[] objArr2 = gm1Var.c;
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
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        ng2 ng2Var = (ng2) obj;
                        gm1 gm1Var2 = this.a;
                        Object objG = gm1Var2.g(ng2Var);
                        ng2Var.getClass();
                        Object objE = ng2Var.b.e(objG, obj2);
                        if (objE != null) {
                            gm1Var2.m(ng2Var, objE);
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

    public final int hashCode() {
        return Boolean.hashCode(this.e) + ky0.e(this.a.hashCode() * 31, 31, this.c);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        ah1 ah1Var = this.b;
        if (ah1Var == null) {
            gm1 gm1Var = this.a;
            gm1Var.getClass();
            ah1 ah1Var2 = new ah1(gm1Var);
            this.b = ah1Var2;
            ah1Var = ah1Var2;
        }
        return ((ej0) ah1Var.entrySet()).iterator();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0078 A[DONT_INVERT, PHI: r2
      0x0078: PHI (r2v6 java.lang.String) = (r2v5 java.lang.String), (r2v7 java.lang.String) binds: [B:13:0x003f, B:20:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x007a A[LOOP:0: B:12:0x0031->B:22:0x007a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x007d A[EDGE_INSN: B:26:0x007d->B:23:0x007d BREAK  A[LOOP:0: B:12:0x0031->B:22:0x007a], SYNTHETIC] */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.c) {
            sb.append("mergeDescendants=true");
            str = ", ";
        } else {
            str = "";
        }
        if (this.e) {
            sb.append(str);
            sb.append("isClearingSemantics=true");
            str = ", ";
        }
        gm1 gm1Var = this.a;
        Object[] objArr = gm1Var.b;
        Object[] objArr2 = gm1Var.c;
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
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            Object obj2 = objArr2[i4];
                            sb.append(str);
                            sb.append(((ng2) obj).a);
                            sb.append(" : ");
                            sb.append(obj2);
                            str = ", ";
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
        return ip4.a(this) + "{ " + ((Object) sb) + " }";
    }
}
