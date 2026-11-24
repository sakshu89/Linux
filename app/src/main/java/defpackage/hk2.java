package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class hk2 extends z1 implements km1, mm0, hr0 {
    public final int f;
    public final int i;
    public final nn j;
    public Object[] k;
    public long n;
    public long s;
    public int t;
    public int u;

    public hk2(int i, int i2, nn nnVar) {
        this.f = i;
        this.i = i2;
        this.j = nnVar;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0080 A[Catch: all -> 0x0036, TRY_ENTER, TryCatch #1 {all -> 0x0036, blocks: (B:15:0x002f, B:32:0x0076, B:35:0x0080, B:39:0x0093, B:42:0x009a, B:43:0x009e, B:44:0x009f, B:22:0x0047), top: B:53:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0093 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:15:0x002f, B:32:0x0076, B:35:0x0080, B:39:0x0093, B:42:0x009a, B:43:0x009e, B:44:0x009f, B:22:0x0047), top: B:53:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4, types: [nm0] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v1, types: [z1] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [hk2] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [nm0] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2, types: [a2] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [ik2] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [ik2] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ad -> B:16:0x0032). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:35:0x0080
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static void j(defpackage.hk2 r8, defpackage.nm0 r9, defpackage.x50 r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof defpackage.gk2
            if (r0 == 0) goto L13
            r0 = r10
            gk2 r0 = (defpackage.gk2) r0
            int r1 = r0.s
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.s = r1
            goto L18
        L13:
            gk2 r0 = new gk2
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.k
            int r1 = r0.s
            r2 = 3
            r3 = 2
            if (r1 == 0) goto L5a
            r8 = 1
            if (r1 == r8) goto L4b
            if (r1 == r3) goto L3f
            if (r1 != r2) goto L39
            f41 r8 = r0.j
            ik2 r9 = r0.i
            nm0 r1 = r0.f
            hk2 r4 = r0.e
            defpackage.bz3.g(r10)     // Catch: java.lang.Throwable -> L36
        L32:
            r10 = r1
            r1 = r8
            r8 = r4
            goto L73
        L36:
            r8 = move-exception
            goto Lb3
        L39:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r8)
            return
        L3f:
            f41 r8 = r0.j
            ik2 r9 = r0.i
            nm0 r1 = r0.f
            hk2 r4 = r0.e
            defpackage.bz3.g(r10)     // Catch: java.lang.Throwable -> L36
            goto L76
        L4b:
            ik2 r9 = r0.i
            nm0 r8 = r0.f
            hk2 r1 = r0.e
            defpackage.bz3.g(r10)     // Catch: java.lang.Throwable -> L57
            r10 = r8
            r8 = r1
            goto L66
        L57:
            r8 = move-exception
            r4 = r1
            goto Lb3
        L5a:
            defpackage.bz3.g(r10)
            a2 r10 = r8.c()
            ik2 r10 = (defpackage.ik2) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L66:
            j70 r1 = r0.b     // Catch: java.lang.Throwable -> Lb0
            r1.getClass()     // Catch: java.lang.Throwable -> Lb0
            nr4 r4 = defpackage.nr4.k     // Catch: java.lang.Throwable -> Lb0
            h70 r1 = r1.v(r4)     // Catch: java.lang.Throwable -> Lb0
            f41 r1 = (defpackage.f41) r1     // Catch: java.lang.Throwable -> Lb0
        L73:
            r4 = r8
            r8 = r1
            r1 = r10
        L76:
            java.lang.Object r10 = r4.t(r9)     // Catch: java.lang.Throwable -> L36
            py0 r5 = defpackage.s44.a     // Catch: java.lang.Throwable -> L36
            t70 r6 = defpackage.t70.a
            if (r10 != r5) goto L91
            r0.e = r4     // Catch: java.lang.Throwable -> L36
            r0.f = r1     // Catch: java.lang.Throwable -> L36
            r0.i = r9     // Catch: java.lang.Throwable -> L36
            r0.j = r8     // Catch: java.lang.Throwable -> L36
            r0.s = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r10 = r4.h(r9, r0)     // Catch: java.lang.Throwable -> L36
            if (r10 != r6) goto L76
            goto Laf
        L91:
            if (r8 == 0) goto L9f
            boolean r5 = r8.c()     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L9a
            goto L9f
        L9a:
            java.util.concurrent.CancellationException r8 = r8.x()     // Catch: java.lang.Throwable -> L36
            throw r8     // Catch: java.lang.Throwable -> L36
        L9f:
            r0.e = r4     // Catch: java.lang.Throwable -> L36
            r0.f = r1     // Catch: java.lang.Throwable -> L36
            r0.i = r9     // Catch: java.lang.Throwable -> L36
            r0.j = r8     // Catch: java.lang.Throwable -> L36
            r0.s = r2     // Catch: java.lang.Throwable -> L36
            java.lang.Object r10 = r1.n(r10, r0)     // Catch: java.lang.Throwable -> L36
            if (r10 != r6) goto L32
        Laf:
            return
        Lb0:
            r10 = move-exception
            r4 = r8
            r8 = r10
        Lb3:
            r4.f(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hk2.j(hk2, nm0, x50):void");
    }

    @Override // defpackage.mm0
    public final Object a(nm0 nm0Var, x50 x50Var) throws Throwable {
        j(this, nm0Var, x50Var);
        return t70.a;
    }

    @Override // defpackage.hr0
    public final mm0 b(j70 j70Var, int i, nn nnVar) {
        return s44.d(this, j70Var, i, nnVar);
    }

    @Override // defpackage.z1
    public final a2 d() {
        ik2 ik2Var = new ik2();
        ik2Var.a = -1L;
        return ik2Var;
    }

    @Override // defpackage.z1
    public final a2[] e() {
        return new ik2[2];
    }

    public final Object h(ik2 ik2Var, gk2 gk2Var) {
        yv yvVar = new yv(1, fp4.b(gk2Var));
        yvVar.x();
        synchronized (this) {
            try {
                if (s(ik2Var) < 0) {
                    ik2Var.b = yvVar;
                } else {
                    yvVar.h(q43.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objV = yvVar.v();
        return objV == t70.a ? objV : q43.a;
    }

    public final void i() {
        if (this.i != 0 || this.u > 1) {
            Object[] objArr = this.k;
            objArr.getClass();
            while (this.u > 0) {
                long jO = o();
                int i = this.t;
                int i2 = this.u;
                if (objArr[((int) ((jO + ((long) (i + i2))) - 1)) & (objArr.length - 1)] != s44.a) {
                    return;
                }
                this.u = i2 - 1;
                s44.c(objArr, o() + ((long) (this.t + this.u)), null);
            }
        }
    }

    public final void k() {
        a2[] a2VarArr;
        Object[] objArr = this.k;
        objArr.getClass();
        s44.c(objArr, o(), null);
        this.t--;
        long jO = o() + 1;
        if (this.n < jO) {
            this.n = jO;
        }
        if (this.s < jO) {
            if (this.b != 0 && (a2VarArr = this.a) != null) {
                for (a2 a2Var : a2VarArr) {
                    if (a2Var != null) {
                        ik2 ik2Var = (ik2) a2Var;
                        long j = ik2Var.a;
                        if (j >= 0 && j < jO) {
                            ik2Var.a = jO;
                        }
                    }
                }
            }
            this.s = jO;
        }
    }

    public final void l(Object obj) {
        int i = this.t + this.u;
        Object[] objArrP = this.k;
        if (objArrP == null) {
            objArrP = p(null, 0, 2);
        } else if (i >= objArrP.length) {
            objArrP = p(objArrP, i, objArrP.length * 2);
        }
        s44.c(objArrP, o() + ((long) i), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [x50[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final x50[] m(x50[] x50VarArr) {
        a2[] a2VarArr;
        ik2 ik2Var;
        yv yvVar;
        int length = x50VarArr.length;
        if (this.b != 0 && (a2VarArr = this.a) != null) {
            int length2 = a2VarArr.length;
            int i = 0;
            x50VarArr = x50VarArr;
            while (i < length2) {
                a2 a2Var = a2VarArr[i];
                if (a2Var != null && (yvVar = (ik2Var = (ik2) a2Var).b) != null && s(ik2Var) >= 0) {
                    int length3 = x50VarArr.length;
                    x50VarArr = x50VarArr;
                    if (length >= length3) {
                        x50VarArr = Arrays.copyOf((Object[]) x50VarArr, Math.max(2, x50VarArr.length * 2));
                    }
                    ((x50[]) x50VarArr)[length] = yvVar;
                    ik2Var.b = null;
                    length++;
                }
                i++;
                x50VarArr = x50VarArr;
            }
        }
        return (x50[]) x50VarArr;
    }

    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) throws Throwable {
        hk2 hk2Var;
        Throwable th;
        x50[] x50VarArrM;
        fk2 fk2Var;
        if (q(obj)) {
            return q43.a;
        }
        int i = 1;
        yv yvVar = new yv(1, fp4.b(x50Var));
        yvVar.x();
        x50[] x50VarArrM2 = n80.a;
        synchronized (this) {
            try {
                if (r(obj)) {
                    try {
                        yvVar.h(q43.a);
                        x50VarArrM = m(x50VarArrM2);
                        fk2Var = null;
                        hk2Var = this;
                    } catch (Throwable th2) {
                        th = th2;
                        hk2Var = this;
                        throw th;
                    }
                } else {
                    try {
                        hk2Var = this;
                        try {
                            fk2 fk2Var2 = new fk2(hk2Var, o() + ((long) (this.t + this.u)), obj, yvVar);
                            hk2Var.l(fk2Var2);
                            hk2Var.u++;
                            if (hk2Var.i == 0) {
                                x50VarArrM2 = hk2Var.m(x50VarArrM2);
                            }
                            x50VarArrM = x50VarArrM2;
                            fk2Var = fk2Var2;
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        hk2Var = this;
                        th = th4;
                        throw th;
                    }
                }
                if (fk2Var != null) {
                    yvVar.A(new rv(i, fk2Var));
                }
                for (x50 x50Var2 : x50VarArrM) {
                    if (x50Var2 != null) {
                        x50Var2.h(q43.a);
                    }
                }
                Object objV = yvVar.v();
                t70 t70Var = t70.a;
                if (objV != t70Var) {
                    objV = q43.a;
                }
                return objV == t70Var ? objV : q43.a;
            } catch (Throwable th5) {
                th = th5;
                hk2Var = this;
            }
        }
    }

    public final long o() {
        return Math.min(this.s, this.n);
    }

    public final Object[] p(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            og.n("Buffer size overflow");
            return null;
        }
        Object[] objArr2 = new Object[i2];
        this.k = objArr2;
        if (objArr != null) {
            long jO = o();
            for (int i3 = 0; i3 < i; i3++) {
                long j = ((long) i3) + jO;
                s44.c(objArr2, j, objArr[((int) j) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    public final boolean q(Object obj) {
        int i;
        boolean z;
        x50[] x50VarArrM = n80.a;
        synchronized (this) {
            if (r(obj)) {
                x50VarArrM = m(x50VarArrM);
                z = true;
            } else {
                z = false;
            }
        }
        for (x50 x50Var : x50VarArrM) {
            if (x50Var != null) {
                x50Var.h(q43.a);
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    public final boolean r(Object obj) {
        int i;
        long jO;
        long j;
        int i2 = this.b;
        int i3 = this.f;
        if (i2 != 0) {
            int i4 = this.t;
            int i5 = this.i;
            if (i4 < i5 || this.s > this.n) {
                l(obj);
                i = this.t + 1;
                this.t = i;
                if (i > i5) {
                    k();
                }
                jO = o() + ((long) this.t);
                j = this.n;
                if (((int) (jO - j)) > i3) {
                    u(1 + j, this.s, o() + ((long) this.t), o() + ((long) this.t) + ((long) this.u));
                }
            } else {
                int iOrdinal = this.j.ordinal();
                if (iOrdinal == 0) {
                    return false;
                }
                if (iOrdinal == 1) {
                    l(obj);
                    i = this.t + 1;
                    this.t = i;
                    if (i > i5) {
                        k();
                    }
                    jO = o() + ((long) this.t);
                    j = this.n;
                    if (((int) (jO - j)) > i3) {
                        u(1 + j, this.s, o() + ((long) this.t), o() + ((long) this.t) + ((long) this.u));
                    }
                } else if (iOrdinal != 2) {
                    dk0.l();
                    return false;
                }
            }
        } else if (i3 != 0) {
            l(obj);
            int i6 = this.t + 1;
            this.t = i6;
            if (i6 > i3) {
                k();
            }
            this.s = o() + ((long) this.t);
            return true;
        }
        return true;
    }

    public final long s(ik2 ik2Var) {
        long j = ik2Var.a;
        if (j >= o() + ((long) this.t) && (this.i > 0 || j > o() || this.u == 0)) {
            return -1L;
        }
        return j;
    }

    public final Object t(ik2 ik2Var) {
        Object obj;
        x50[] x50VarArrV = n80.a;
        synchronized (this) {
            try {
                long jS = s(ik2Var);
                if (jS < 0) {
                    obj = s44.a;
                } else {
                    long j = ik2Var.a;
                    Object[] objArr = this.k;
                    objArr.getClass();
                    Object obj2 = objArr[((int) jS) & (objArr.length - 1)];
                    if (obj2 instanceof fk2) {
                        obj2 = ((fk2) obj2).c;
                    }
                    ik2Var.a = jS + 1;
                    Object obj3 = obj2;
                    x50VarArrV = v(j);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (x50 x50Var : x50VarArrV) {
            if (x50Var != null) {
                x50Var.h(q43.a);
            }
        }
        return obj;
    }

    public final void u(long j, long j2, long j3, long j4) {
        long jMin = Math.min(j2, j);
        for (long jO = o(); jO < jMin; jO++) {
            Object[] objArr = this.k;
            objArr.getClass();
            s44.c(objArr, jO, null);
        }
        this.n = j;
        this.s = j2;
        this.t = (int) (j3 - jMin);
        this.u = (int) (j4 - j3);
    }

    public final x50[] v(long j) {
        long j2;
        long j3;
        long j4;
        x50[] x50VarArr;
        a2[] a2VarArr;
        long j5 = this.s;
        x50[] x50VarArr2 = n80.a;
        if (j <= j5) {
            long jO = o();
            long j6 = ((long) this.t) + jO;
            int i = this.i;
            if (i == 0 && this.u > 0) {
                j6++;
            }
            int i2 = 0;
            if (this.b != 0 && (a2VarArr = this.a) != null) {
                for (a2 a2Var : a2VarArr) {
                    if (a2Var != null) {
                        long j7 = ((ik2) a2Var).a;
                        if (j7 >= 0 && j7 < j6) {
                            j6 = j7;
                        }
                    }
                }
            }
            if (j6 > this.s) {
                long jO2 = o() + ((long) this.t);
                int i3 = this.b;
                int iMin = this.u;
                if (i3 > 0) {
                    iMin = Math.min(iMin, i - ((int) (jO2 - j6)));
                }
                long j8 = ((long) this.u) + jO2;
                py0 py0Var = s44.a;
                if (iMin > 0) {
                    x50[] x50VarArr3 = new x50[iMin];
                    j4 = 1;
                    Object[] objArr = this.k;
                    objArr.getClass();
                    long j9 = jO2;
                    while (true) {
                        if (jO2 >= j8) {
                            j2 = jO;
                            j3 = j6;
                            break;
                        }
                        j2 = jO;
                        Object obj = objArr[((int) jO2) & (objArr.length - 1)];
                        if (obj != py0Var) {
                            obj.getClass();
                            fk2 fk2Var = (fk2) obj;
                            int i4 = i2 + 1;
                            j3 = j6;
                            x50VarArr3[i2] = fk2Var.e;
                            s44.c(objArr, jO2, py0Var);
                            s44.c(objArr, j9, fk2Var.c);
                            j9++;
                            if (i4 >= iMin) {
                                break;
                            }
                            i2 = i4;
                        } else {
                            j3 = j6;
                        }
                        jO2++;
                        jO = j2;
                        j6 = j3;
                    }
                    jO2 = j9;
                    x50VarArr = x50VarArr3;
                } else {
                    j2 = jO;
                    j3 = j6;
                    j4 = 1;
                    x50VarArr = x50VarArr2;
                }
                int i5 = (int) (jO2 - j2);
                long j10 = this.b == 0 ? jO2 : j3;
                long jMax = Math.max(this.n, jO2 - ((long) Math.min(this.f, i5)));
                if (i == 0 && jMax < j8) {
                    Object[] objArr2 = this.k;
                    objArr2.getClass();
                    if (g31.a(objArr2[((int) jMax) & (objArr2.length - 1)], py0Var)) {
                        jO2 += j4;
                        jMax += j4;
                    }
                }
                u(jMax, j10, jO2, j8);
                i();
                return x50VarArr.length == 0 ? x50VarArr : m(x50VarArr);
            }
        }
        return x50VarArr2;
    }
}
