package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w90 implements c90 {
    public final kl0 a;
    public final fl4 b;
    public final s70 c;
    public final l90 e;
    public int i;
    public yq2 j;
    public final p6 n;
    public final cv2 s;
    public final cv2 t;
    public final p6 u;
    public final an1 f = new an1();
    public final q82 k = new q82(18);

    public w90(kl0 kl0Var, List list, fl4 fl4Var, s70 s70Var) {
        this.a = kl0Var;
        this.b = fl4Var;
        this.c = s70Var;
        x50 x50Var = null;
        int i = 1;
        this.e = new l90(i, new r0(this, x50Var, 4));
        p6 p6Var = new p6();
        p6Var.e = this;
        p6Var.a = new an1();
        p6Var.b = ui4.a();
        p6Var.c = mz.O(list);
        this.n = p6Var;
        this.s = new cv2(new h90(this, i));
        this.t = new cv2(new h90(this, 0));
        h6 h6Var = new h6(9, this);
        p0 p0Var = new p0(this, x50Var, 16);
        p6 p6Var2 = new p6();
        p6Var2.a = s70Var;
        p6Var2.b = p0Var;
        p6Var2.c = nh4.a(Integer.MAX_VALUE, 6, null);
        p6Var2.e = new q82(6);
        f41 f41Var = (f41) s70Var.o().v(nr4.k);
        if (f41Var != null) {
            f41Var.C(new k8(8, h6Var, p6Var2));
        }
        this.u = p6Var2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(w90 w90Var, y50 y50Var) {
        m90 m90Var;
        an1 an1Var;
        if (y50Var instanceof m90) {
            m90Var = (m90) y50Var;
            int i = m90Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                m90Var.k = i - Integer.MIN_VALUE;
            } else {
                m90Var = new m90(w90Var, y50Var);
            }
        } else {
            m90Var = new m90(w90Var, y50Var);
        }
        Object obj = m90Var.i;
        int i2 = m90Var.k;
        if (i2 == 0) {
            bz3.g(obj);
            an1Var = w90Var.f;
            m90Var.e = w90Var;
            m90Var.f = an1Var;
            m90Var.k = 1;
            Object objE = an1Var.e(m90Var);
            t70 t70Var = t70.a;
            if (objE == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            an1 an1Var2 = m90Var.f;
            w90 w90Var2 = m90Var.e;
            bz3.g(obj);
            an1Var = an1Var2;
            w90Var = w90Var2;
        }
        try {
            int i3 = w90Var.i - 1;
            w90Var.i = i3;
            if (i3 == 0) {
                yq2 yq2Var = w90Var.j;
                if (yq2Var != null) {
                    yq2Var.e(null);
                }
                w90Var.j = null;
            }
            return q43.a;
        } finally {
            an1Var.h(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b3, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(defpackage.w90 r9, defpackage.li1 r10, defpackage.y50 r11) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w90.c(w90, li1, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object e(w90 w90Var, y50 y50Var) {
        p90 p90Var;
        an1 an1Var;
        if (y50Var instanceof p90) {
            p90Var = (p90) y50Var;
            int i = p90Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                p90Var.k = i - Integer.MIN_VALUE;
            } else {
                p90Var = new p90(w90Var, y50Var);
            }
        } else {
            p90Var = new p90(w90Var, y50Var);
        }
        Object obj = p90Var.i;
        int i2 = p90Var.k;
        int i3 = 1;
        x50 x50Var = null;
        if (i2 == 0) {
            bz3.g(obj);
            an1Var = w90Var.f;
            p90Var.e = w90Var;
            p90Var.f = an1Var;
            p90Var.k = 1;
            Object objE = an1Var.e(p90Var);
            t70 t70Var = t70.a;
            if (objE == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            an1 an1Var2 = p90Var.f;
            w90 w90Var2 = p90Var.e;
            bz3.g(obj);
            an1Var = an1Var2;
            w90Var = w90Var2;
        }
        try {
            int i4 = w90Var.i + 1;
            w90Var.i = i4;
            if (i4 == 1) {
                w90Var.j = uf4.b(w90Var.c, null, new i90(w90Var, x50Var, i3), 3);
            }
            return q43.a;
        } finally {
            an1Var.h(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object f(w90 w90Var, boolean z, x50 x50Var) {
        r90 r90Var;
        w90 w90Var2;
        fr2 fr2Var;
        w90 w90Var3;
        wt1 wt1Var;
        fr2 fr2Var2;
        if (x50Var instanceof r90) {
            r90Var = (r90) x50Var;
            int i = r90Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                r90Var.n = i - Integer.MIN_VALUE;
            } else {
                r90Var = new r90(w90Var, x50Var);
            }
        } else {
            r90Var = new r90(w90Var, x50Var);
        }
        Object objC = r90Var.j;
        int i2 = r90Var.n;
        int i3 = 2;
        int i4 = 1;
        x50 x50Var2 = null;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objC);
            fr2 fr2VarB = w90Var.k.B();
            if (fr2VarB instanceof i43) {
                og.n("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                return null;
            }
            uk2 uk2VarH = w90Var.h();
            r90Var.e = w90Var;
            r90Var.f = fr2VarB;
            r90Var.i = z;
            r90Var.n = 1;
            Integer numA = uk2VarH.a();
            if (numA != t70Var) {
                w90Var2 = w90Var;
                fr2Var = fr2VarB;
                objC = numA;
            }
            return t70Var;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                w90Var3 = r90Var.e;
                bz3.g(objC);
                wt1Var = (wt1) objC;
                fr2Var2 = (fr2) wt1Var.a;
                if (((Boolean) wt1Var.b).booleanValue()) {
                    w90Var3.k.K(fr2Var2);
                }
                return fr2Var2;
            }
            if (i2 != 3) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            w90Var3 = r90Var.e;
            bz3.g(objC);
            wt1Var = (wt1) objC;
            fr2Var2 = (fr2) wt1Var.a;
            if (((Boolean) wt1Var.b).booleanValue()) {
                w90Var3.k.K(fr2Var2);
            }
            return fr2Var2;
        }
        z = r90Var.i;
        fr2Var = r90Var.f;
        w90Var2 = r90Var.e;
        bz3.g(objC);
        int iIntValue = ((Number) objC).intValue();
        boolean z2 = fr2Var instanceof y80;
        int i5 = z2 ? fr2Var.a : -1;
        if (z2 && iIntValue == i5) {
            return fr2Var;
        }
        if (z) {
            uk2 uk2VarH2 = w90Var2.h();
            ec ecVar = new ec(w90Var2, x50Var2, i3);
            r90Var.e = w90Var2;
            r90Var.f = null;
            r90Var.n = 2;
            objC = uk2VarH2.b(ecVar, r90Var);
            if (objC != t70Var) {
                w90Var3 = w90Var2;
                wt1Var = (wt1) objC;
                fr2Var2 = (fr2) wt1Var.a;
                if (((Boolean) wt1Var.b).booleanValue()) {
                    w90Var3.k.K(fr2Var2);
                }
                return fr2Var2;
            }
        } else {
            uk2 uk2VarH3 = w90Var2.h();
            hw hwVar = new hw(w90Var2, i5, x50Var2, i4);
            r90Var.e = w90Var2;
            r90Var.f = null;
            r90Var.n = 3;
            objC = uk2VarH3.c(hwVar, r90Var);
            if (objC != t70Var) {
                w90Var3 = w90Var2;
                wt1Var = (wt1) objC;
                fr2Var2 = (fr2) wt1Var.a;
                if (((Boolean) wt1Var.b).booleanValue()) {
                    w90Var3.k.K(fr2Var2);
                }
                return fr2Var2;
            }
        }
        return t70Var;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0089  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e5 A[Catch: x70 -> 0x00a6, TryCatch #0 {x70 -> 0x00a6, blocks: (B:36:0x00a1, B:70:0x013e, B:41:0x00af, B:67:0x0121, B:49:0x00cc, B:57:0x00e5, B:58:0x00e9, B:53:0x00d5, B:64:0x010f), top: B:74:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x013b, code lost:
    
        if (r10 == r5) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(defpackage.w90 r8, boolean r9, defpackage.y50 r10) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w90.g(w90, boolean, y50):java.lang.Object");
    }

    @Override // defpackage.c90
    public final Object b(vq0 vq0Var, x50 x50Var) {
        j53 j53Var = (j53) x50Var.f().v(nr4.t);
        if (j53Var != null) {
            j53Var.a(this);
        }
        return uf4.d(new j53(j53Var, this), new r0(this, vq0Var, null, 5), x50Var);
    }

    @Override // defpackage.c90
    public final mm0 d() {
        return this.e;
    }

    public final uk2 h() {
        return (uk2) this.t.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if (r1.p(r0) == r4) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(defpackage.y50 r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof defpackage.q90
            if (r0 == 0) goto L13
            r0 = r7
            q90 r0 = (defpackage.q90) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            q90 r0 = new q90
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.i
            int r1 = r0.k
            r2 = 2
            r3 = 1
            t70 r4 = defpackage.t70.a
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L37
            if (r1 != r2) goto L30
            int r6 = r0.f
            w90 r0 = r0.e
            defpackage.bz3.g(r7)     // Catch: java.lang.Throwable -> L2e
            goto L64
        L2e:
            r7 = move-exception
            goto L6c
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r6)
            r6 = 0
            return r6
        L37:
            w90 r6 = r0.e
            defpackage.bz3.g(r7)
            goto L4f
        L3d:
            defpackage.bz3.g(r7)
            uk2 r7 = r6.h()
            r0.e = r6
            r0.k = r3
            java.lang.Integer r7 = r7.a()
            if (r7 != r4) goto L4f
            goto L63
        L4f:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            p6 r1 = r6.n     // Catch: java.lang.Throwable -> L67
            r0.e = r6     // Catch: java.lang.Throwable -> L67
            r0.f = r7     // Catch: java.lang.Throwable -> L67
            r0.k = r2     // Catch: java.lang.Throwable -> L67
            java.lang.Object r6 = r1.p(r0)     // Catch: java.lang.Throwable -> L67
            if (r6 != r4) goto L64
        L63:
            return r4
        L64:
            q43 r6 = defpackage.q43.a
            return r6
        L67:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L6c:
            q82 r0 = r0.k
            w22 r1 = new w22
            r1.<init>(r6, r7)
            r0.K(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w90.i(y50):java.lang.Object");
    }

    public final Object j(y50 y50Var) {
        return ((nl0) this.s.getValue()).a(new j90(3, (x50) null), y50Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object k(Object obj, boolean z, y50 y50Var) {
        u90 u90Var;
        r42 r42Var;
        if (y50Var instanceof u90) {
            u90Var = (u90) y50Var;
            int i = u90Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                u90Var.j = i - Integer.MIN_VALUE;
            } else {
                u90Var = new u90(this, y50Var);
            }
        } else {
            u90Var = new u90(this, y50Var);
        }
        Object obj2 = u90Var.f;
        int i2 = u90Var.j;
        if (i2 == 0) {
            bz3.g(obj2);
            r42 r42Var2 = new r42();
            nl0 nl0Var = (nl0) this.s.getValue();
            v90 v90Var = new v90(r42Var2, this, obj, z, null);
            u90Var.e = r42Var2;
            u90Var.j = 1;
            Object objB = nl0Var.b(v90Var, u90Var);
            t70 t70Var = t70.a;
            if (objB == t70Var) {
                return t70Var;
            }
            r42Var = r42Var2;
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            r42Var = u90Var.e;
            bz3.g(obj2);
        }
        return new Integer(r42Var.a);
    }
}
