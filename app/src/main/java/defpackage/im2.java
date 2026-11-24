package defpackage;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class im2 {
    public static final sa2 a = new sa2(29);
    public static final kf b = new kf(26);
    public static final Object c = new Object();
    public static gm2 d;
    public static long e;
    public static final em2 f;
    public static final t9 g;
    public static List h;
    public static List i;
    public static final hu0 j;
    public static final hh k;

    static {
        int i2 = 26;
        gm2 gm2Var = gm2.f;
        d = gm2Var;
        e = 2L;
        em2 em2Var = new em2();
        em2Var.b = new long[16];
        em2Var.c = new int[16];
        int[] iArr = new int[16];
        boolean z = false;
        int i3 = 0;
        while (i3 < 16) {
            int i4 = i3 + 1;
            iArr[i3] = i4;
            i3 = i4;
        }
        em2Var.d = iArr;
        f = em2Var;
        t9 t9Var = new t9(6, z);
        t9Var.c = new int[16];
        t9Var.e = new n93[16];
        g = t9Var;
        ii0 ii0Var = ii0.a;
        h = ii0Var;
        i = ii0Var;
        long j2 = e;
        e = 1 + j2;
        hu0 hu0Var = new hu0(j2, gm2Var, null, new j(i2));
        d = d.g(hu0Var.b);
        j = hu0Var;
        k = new hh(0);
    }

    public static final void a() {
        e(a);
    }

    public static final HashMap b(long j2, lm1 lm1Var, gm2 gm2Var) {
        long[] jArr;
        gm2 gm2Var2;
        long[] jArr2;
        int i2;
        int i3;
        qr2 qr2VarS;
        hm1 hm1VarX = lm1Var.x();
        if (hm1VarX != null) {
            long jG = lm1Var.g();
            gm2 gm2VarF = lm1Var.d().g(jG).f(lm1Var.j);
            Object[] objArr = hm1VarX.b;
            long[] jArr3 = hm1VarX.a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i4 = 0;
                HashMap map = null;
                while (true) {
                    long j3 = jArr3[i4];
                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8;
                        int i6 = 8 - ((~(i4 - length)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((j3 & 255) < 128) {
                                nr2 nr2Var = (nr2) objArr[(i4 << 3) + i7];
                                qr2 qr2VarA = nr2Var.a();
                                jArr2 = jArr3;
                                i2 = i5;
                                i3 = i7;
                                qr2 qr2VarS2 = s(qr2VarA, j2, gm2Var);
                                if (qr2VarS2 != null && (qr2VarS = s(qr2VarA, jG, gm2VarF)) != null && !qr2VarS2.equals(qr2VarS)) {
                                    qr2 qr2VarS3 = s(qr2VarA, jG, lm1Var.d());
                                    if (qr2VarS3 == null) {
                                        r();
                                        throw null;
                                    }
                                    qr2 qr2VarB = nr2Var.b(qr2VarS, qr2VarS2, qr2VarS3);
                                    if (qr2VarB == null) {
                                        return null;
                                    }
                                    if (map == null) {
                                        map = new HashMap();
                                    }
                                    map.put(qr2VarS2, qr2VarB);
                                    map = map;
                                }
                            } else {
                                jArr2 = jArr3;
                                i2 = i5;
                                i3 = i7;
                            }
                            j3 >>= i2;
                            i7 = i3 + 1;
                            i5 = i2;
                            jArr3 = jArr2;
                            gm2VarF = gm2VarF;
                        }
                        jArr = jArr3;
                        gm2Var2 = gm2VarF;
                        if (i6 != i5) {
                            return map;
                        }
                    } else {
                        jArr = jArr3;
                        gm2Var2 = gm2VarF;
                    }
                    if (i4 == length) {
                        return map;
                    }
                    i4++;
                    jArr3 = jArr;
                    gm2VarF = gm2Var2;
                }
            }
        }
        return null;
    }

    public static final void c(bm2 bm2Var) {
        long j2;
        if (d.d(bm2Var.g())) {
            return;
        }
        StringBuilder sb = new StringBuilder("Snapshot is not open: snapshotId=");
        sb.append(bm2Var.g());
        sb.append(", disposed=");
        sb.append(bm2Var.c);
        sb.append(", applied=");
        lm1 lm1Var = bm2Var instanceof lm1 ? (lm1) bm2Var : null;
        sb.append(lm1Var != null ? Boolean.valueOf(lm1Var.m) : "read-only");
        sb.append(", lowestPin=");
        synchronized (c) {
            em2 em2Var = f;
            j2 = em2Var.a > 0 ? em2Var.b[0] : -1L;
        }
        sb.append(j2);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final gm2 d(gm2 gm2Var, long j2, long j3) {
        while (g31.c(j2, j3) < 0) {
            gm2Var = gm2Var.g(j2);
            j2++;
        }
        return gm2Var;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0090 A[LOOP:1: B:30:0x0056->B:43:0x0090, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x0093 A[EDGE_INSN: B:58:0x0093->B:44:0x0093 BREAK  A[LOOP:1: B:30:0x0056->B:43:0x0090], SYNTHETIC] */
    public static final Object e(hq0 hq0Var) {
        hm1 hm1Var;
        Object objV;
        hu0 hu0Var = j;
        synchronized (c) {
            try {
                hm1Var = hu0Var.h;
                if (hm1Var != null) {
                    k.addAndGet(1);
                }
                objV = v(hu0Var, hq0Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (hm1Var != null) {
            try {
                List list = h;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((vq0) list.get(i2)).e(new ab2(hm1Var), hu0Var);
                }
                k.addAndGet(-1);
            } catch (Throwable th2) {
                k.addAndGet(-1);
                throw th2;
            }
        }
        synchronized (c) {
            f();
            if (hm1Var != null) {
                Object[] objArr = hm1Var.b;
                long[] jArr = hm1Var.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i3 = 0;
                    while (true) {
                        long j2 = jArr[i3];
                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        } else {
                            int i4 = 8 - ((~(i3 - length)) >>> 31);
                            for (int i5 = 0; i5 < i4; i5++) {
                                if ((255 & j2) < 128) {
                                    q((nr2) objArr[(i3 << 3) + i5]);
                                }
                                j2 >>= 8;
                            }
                            if (i4 != 8) {
                                break;
                            }
                            if (i3 != length) {
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
        }
        return objV;
    }

    public static final void f() {
        t9 t9Var = g;
        int i2 = t9Var.b;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            n93 n93Var = ((n93[]) t9Var.e)[i3];
            Object obj = n93Var != null ? n93Var.get() : null;
            if (obj != null && p((nr2) obj)) {
                if (i4 != i3) {
                    ((n93[]) t9Var.e)[i4] = n93Var;
                    int[] iArr = (int[]) t9Var.c;
                    iArr[i4] = iArr[i3];
                }
                i4++;
            }
            i3++;
        }
        for (int i5 = i4; i5 < i2; i5++) {
            ((n93[]) t9Var.e)[i5] = null;
            ((int[]) t9Var.c)[i5] = 0;
        }
        if (i4 != i2) {
            t9Var.b = i4;
        }
    }

    public static final bm2 g(bm2 bm2Var, hq0 hq0Var, boolean z) {
        boolean z2 = bm2Var instanceof lm1;
        if (z2 || bm2Var == null) {
            return new n23(z2 ? (lm1) bm2Var : null, hq0Var, null, false, z);
        }
        return new o23(bm2Var, hq0Var, false, z);
    }

    public static final qr2 h(qr2 qr2Var) {
        qr2 qr2VarS;
        bm2 bm2VarJ = j();
        qr2 qr2VarS2 = s(qr2Var, bm2VarJ.g(), bm2VarJ.d());
        if (qr2VarS2 != null) {
            return qr2VarS2;
        }
        synchronized (c) {
            bm2 bm2VarJ2 = j();
            qr2VarS = s(qr2Var, bm2VarJ2.g(), bm2VarJ2.d());
        }
        if (qr2VarS != null) {
            return qr2VarS;
        }
        r();
        throw null;
    }

    public static final qr2 i(qr2 qr2Var, bm2 bm2Var) {
        qr2 qr2VarS;
        qr2 qr2VarS2 = s(qr2Var, bm2Var.g(), bm2Var.d());
        if (qr2VarS2 != null) {
            return qr2VarS2;
        }
        synchronized (c) {
            qr2VarS = s(qr2Var, bm2Var.g(), bm2Var.d());
        }
        if (qr2VarS != null) {
            return qr2VarS;
        }
        r();
        throw null;
    }

    public static final bm2 j() {
        bm2 bm2Var = (bm2) b.l();
        return bm2Var == null ? j : bm2Var;
    }

    public static final hq0 k(hq0 hq0Var, hq0 hq0Var2, boolean z) {
        if (!z) {
            hq0Var2 = null;
        }
        if (hq0Var == null || hq0Var2 == null || hq0Var == hq0Var2) {
            return hq0Var == null ? hq0Var2 : hq0Var;
        }
        return new hm2(hq0Var, hq0Var2, 0);
    }

    public static final hq0 l(hq0 hq0Var, hq0 hq0Var2) {
        if (hq0Var == null || hq0Var2 == null || hq0Var == hq0Var2) {
            return hq0Var == null ? hq0Var2 : hq0Var;
        }
        return new hm2(hq0Var, hq0Var2, 1);
    }

    public static final qr2 m(qr2 qr2Var, nr2 nr2Var) {
        long j2 = e;
        em2 em2Var = f;
        if (em2Var.a > 0) {
            j2 = em2Var.b[0];
        }
        long j3 = j2 - 1;
        qr2 qr2Var2 = null;
        qr2 qr2Var3 = null;
        for (qr2 qr2VarA = nr2Var.a(); qr2VarA != null; qr2VarA = qr2VarA.b) {
            long j4 = qr2VarA.a;
            if (j4 != 0) {
                if (j4 != 0 && g31.c(j4, j3) <= 0 && !gm2.f.d(j4)) {
                    if (qr2Var3 != null) {
                        if (g31.c(qr2VarA.a, qr2Var3.a) >= 0) {
                            qr2Var2 = qr2Var3;
                            break;
                        }
                        break;
                    }
                    qr2Var3 = qr2VarA;
                }
            }
            qr2Var2 = qr2VarA;
            break;
        }
        if (qr2Var2 != null) {
            qr2Var2.a = Long.MAX_VALUE;
            return qr2Var2;
        }
        qr2 qr2VarB = qr2Var.b(Long.MAX_VALUE);
        qr2VarB.b = nr2Var.a();
        nr2Var.d(qr2VarB);
        return qr2VarB;
    }

    public static final void n(bm2 bm2Var, nr2 nr2Var) {
        bm2Var.t(bm2Var.h() + 1);
        hq0 hq0VarI = bm2Var.i();
        if (hq0VarI != null) {
            hq0VarI.j(nr2Var);
        }
    }

    public static final qr2 o(qr2 qr2Var, or2 or2Var, bm2 bm2Var, qr2 qr2Var2) {
        qr2 qr2VarM;
        if (bm2Var.f()) {
            bm2Var.n(or2Var);
        }
        long jG = bm2Var.g();
        if (qr2Var2.a == jG) {
            return qr2Var2;
        }
        synchronized (c) {
            qr2VarM = m(qr2Var, or2Var);
        }
        qr2VarM.a = jG;
        if (qr2Var2.a != 1) {
            bm2Var.n(or2Var);
        }
        return qr2VarM;
    }

    public static final boolean p(nr2 nr2Var) {
        qr2 qr2Var;
        long j2 = e;
        em2 em2Var = f;
        if (em2Var.a > 0) {
            j2 = em2Var.b[0];
        }
        qr2 qr2Var2 = null;
        qr2 qr2VarA = null;
        int i2 = 0;
        for (qr2 qr2VarA2 = nr2Var.a(); qr2VarA2 != null; qr2VarA2 = qr2VarA2.b) {
            long j3 = qr2VarA2.a;
            if (j3 != 0) {
                if (g31.c(j3, j2) >= 0) {
                    i2++;
                } else if (qr2Var2 == null) {
                    i2++;
                    qr2Var2 = qr2VarA2;
                } else {
                    if (g31.c(qr2VarA2.a, qr2Var2.a) < 0) {
                        qr2Var = qr2Var2;
                        qr2Var2 = qr2VarA2;
                    } else {
                        qr2Var = qr2VarA2;
                    }
                    if (qr2VarA == null) {
                        qr2VarA = nr2Var.a();
                        qr2 qr2Var3 = qr2VarA;
                        while (true) {
                            if (qr2VarA == null) {
                                qr2VarA = qr2Var3;
                                break;
                            }
                            if (g31.c(qr2VarA.a, j2) >= 0) {
                                break;
                            }
                            if (g31.c(qr2Var3.a, qr2VarA.a) < 0) {
                                qr2Var3 = qr2VarA;
                            }
                            qr2VarA = qr2VarA.b;
                        }
                    }
                    qr2Var2.a = 0L;
                    qr2Var2.a(qr2VarA);
                    qr2Var2 = qr2Var;
                }
            }
        }
        return i2 > 1;
    }

    public static final void q(nr2 nr2Var) {
        if (p(nr2Var)) {
            t9 t9Var = g;
            int i2 = t9Var.b;
            int iIdentityHashCode = System.identityHashCode(nr2Var);
            int i3 = -1;
            if (i2 > 0) {
                int i4 = t9Var.b - 1;
                int i5 = 0;
                while (true) {
                    if (i5 > i4) {
                        i3 = -(i5 + 1);
                        break;
                    }
                    int i6 = (i5 + i4) >>> 1;
                    int i7 = ((int[]) t9Var.c)[i6];
                    if (i7 < iIdentityHashCode) {
                        i5 = i6 + 1;
                    } else if (i7 > iIdentityHashCode) {
                        i4 = i6 - 1;
                    } else {
                        n93 n93Var = ((n93[]) t9Var.e)[i6];
                        if (nr2Var == (n93Var != null ? n93Var.get() : null)) {
                            i3 = i6;
                            break;
                        }
                        int i8 = i6 - 1;
                        while (true) {
                            if (-1 >= i8 || ((int[]) t9Var.c)[i8] != iIdentityHashCode) {
                                i6++;
                                int i9 = t9Var.b;
                                while (true) {
                                    if (i6 >= i9) {
                                        i3 = -(t9Var.b + 1);
                                        break;
                                    }
                                    if (((int[]) t9Var.c)[i6] != iIdentityHashCode) {
                                        i3 = -(i6 + 1);
                                        break;
                                    }
                                    n93 n93Var2 = ((n93[]) t9Var.e)[i6];
                                    if ((n93Var2 != null ? n93Var2.get() : null) == nr2Var) {
                                        i3 = i6;
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                n93 n93Var3 = ((n93[]) t9Var.e)[i8];
                                if ((n93Var3 != null ? n93Var3.get() : null) == nr2Var) {
                                    i3 = i8;
                                    break;
                                }
                                i8--;
                            }
                        }
                    }
                }
                if (i3 >= 0) {
                    return;
                }
            }
            int i10 = -(i3 + 1);
            n93[] n93VarArr = (n93[]) t9Var.e;
            int length = n93VarArr.length;
            if (i2 == length) {
                int i11 = length * 2;
                n93[] n93VarArr2 = new n93[i11];
                int[] iArr = new int[i11];
                int i12 = i10 + 1;
                System.arraycopy(n93VarArr, i10, n93VarArr2, i12, i2 - i10);
                System.arraycopy((n93[]) t9Var.e, 0, n93VarArr2, 0, i10);
                qg.e((int[]) t9Var.c, i12, iArr, i10, i2);
                qg.h((int[]) t9Var.c, 0, iArr, i10, 6);
                t9Var.e = n93VarArr2;
                t9Var.c = iArr;
            } else {
                int i13 = i10 + 1;
                System.arraycopy(n93VarArr, i10, n93VarArr, i13, i2 - i10);
                int[] iArr2 = (int[]) t9Var.c;
                qg.e(iArr2, i13, iArr2, i10, i2);
            }
            ((n93[]) t9Var.e)[i10] = new n93(nr2Var);
            ((int[]) t9Var.c)[i10] = iIdentityHashCode;
            t9Var.b++;
        }
    }

    public static final void r() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    public static final qr2 s(qr2 qr2Var, long j2, gm2 gm2Var) {
        qr2 qr2Var2 = null;
        while (qr2Var != null) {
            long j3 = qr2Var.a;
            if (j3 != 0 && g31.c(j3, j2) <= 0 && !gm2Var.d(j3) && (qr2Var2 == null || g31.c(qr2Var2.a, qr2Var.a) < 0)) {
                qr2Var2 = qr2Var;
            }
            qr2Var = qr2Var.b;
        }
        if (qr2Var2 != null) {
            return qr2Var2;
        }
        return null;
    }

    public static final qr2 t(qr2 qr2Var, nr2 nr2Var) {
        qr2 qr2VarS;
        bm2 bm2VarJ = j();
        hq0 hq0VarE = bm2VarJ.e();
        if (hq0VarE != null) {
            hq0VarE.j(nr2Var);
        }
        qr2 qr2VarS2 = s(qr2Var, bm2VarJ.g(), bm2VarJ.d());
        if (qr2VarS2 != null) {
            return qr2VarS2;
        }
        synchronized (c) {
            bm2 bm2VarJ2 = j();
            qr2 qr2VarA = nr2Var.a();
            qr2VarA.getClass();
            qr2VarS = s(qr2VarA, bm2VarJ2.g(), bm2VarJ2.d());
            if (qr2VarS == null) {
                r();
                throw null;
            }
        }
        return qr2VarS;
    }

    public static final void u(int i2) {
        em2 em2Var = f;
        int i3 = em2Var.d[i2];
        em2Var.b(i3, em2Var.a - 1);
        em2Var.a--;
        long[] jArr = em2Var.b;
        long j2 = jArr[i3];
        int i4 = i3;
        while (i4 > 0) {
            int i5 = ((i4 + 1) >> 1) - 1;
            if (g31.c(jArr[i5], j2) <= 0) {
                break;
            }
            em2Var.b(i5, i4);
            i4 = i5;
        }
        long[] jArr2 = em2Var.b;
        int i6 = em2Var.a >> 1;
        while (i3 < i6) {
            int i7 = (i3 + 1) << 1;
            int i8 = i7 - 1;
            if (i7 < em2Var.a && g31.c(jArr2[i7], jArr2[i8]) < 0) {
                if (g31.c(jArr2[i7], jArr2[i3]) >= 0) {
                    break;
                }
                em2Var.b(i7, i3);
                i3 = i7;
            } else {
                if (g31.c(jArr2[i8], jArr2[i3]) >= 0) {
                    break;
                }
                em2Var.b(i8, i3);
                i3 = i8;
            }
        }
        em2Var.d[i2] = em2Var.e;
        em2Var.e = i2;
    }

    public static final Object v(hu0 hu0Var, hq0 hq0Var) {
        long j2 = hu0Var.b;
        Object objJ = hq0Var.j(d.b(j2));
        long j3 = e;
        e = 1 + j3;
        gm2 gm2VarB = d.b(j2);
        d = gm2VarB;
        hu0Var.b = j3;
        hu0Var.a = gm2VarB;
        hu0Var.g = 0;
        hu0Var.h = null;
        hu0Var.o();
        d = d.g(j3);
        return objJ;
    }

    public static final qr2 w(qr2 qr2Var, nr2 nr2Var, bm2 bm2Var) {
        qr2 qr2VarS;
        if (bm2Var.f()) {
            bm2Var.n(nr2Var);
        }
        long jG = bm2Var.g();
        qr2 qr2VarS2 = s(qr2Var, jG, bm2Var.d());
        if (qr2VarS2 == null) {
            r();
            throw null;
        }
        if (qr2VarS2.a == bm2Var.g()) {
            return qr2VarS2;
        }
        synchronized (c) {
            qr2VarS = s(nr2Var.a(), jG, bm2Var.d());
            if (qr2VarS == null) {
                r();
                throw null;
            }
            if (qr2VarS.a != jG) {
                qr2 qr2VarM = m(qr2VarS, nr2Var);
                qr2VarM.a(qr2VarS);
                qr2VarM.a = bm2Var.g();
                qr2VarS = qr2VarM;
            }
        }
        if (qr2VarS2.a != 1) {
            bm2Var.n(nr2Var);
        }
        return qr2VarS;
    }
}
