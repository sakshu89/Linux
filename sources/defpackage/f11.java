package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f11 extends co1 {
    public static final fa C0;
    public final jv2 A0;
    public e11 B0;

    static {
        fa faVarA = ld4.a();
        int i = sz.h;
        faVarA.e(sz.d);
        faVarA.k(1.0f);
        faVarA.l(1);
        C0 = faVarA;
    }

    public f11(n71 n71Var) {
        super(n71Var);
        jv2 jv2Var = new jv2();
        jv2Var.e = 0;
        this.A0 = jv2Var;
        jv2Var.k = this;
        this.B0 = n71Var.n != null ? new e11(this) : null;
    }

    @Override // defpackage.co1
    public final void Q0() {
        if (this.B0 == null) {
            this.B0 = new e11(this);
        }
    }

    @Override // defpackage.co1
    public final of1 T0() {
        return this.B0;
    }

    @Override // defpackage.jh1
    public final int V(int i) {
        l11 l11VarT = this.x.t();
        oh1 oh1VarZ = l11VarT.z();
        n71 n71Var = (n71) l11VarT.b;
        return oh1VarZ.i(n71Var.o0.d, n71Var.m(), i);
    }

    @Override // defpackage.co1
    public final dk1 V0() {
        return this.A0;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [dk1] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // defpackage.co1
    public final void b1(ao1 ao1Var, long j, pw0 pw0Var, int i, boolean z) {
        int i2;
        boolean z2;
        boolean z3;
        Object[] objArr;
        int i3;
        n71 n71Var;
        boolean z4;
        long jA;
        long j2 = j;
        n71 n71Var2 = this.x;
        ao1 ao1Var2 = ao1Var;
        if (ao1Var2.j(n71Var2)) {
            if (v1(j2)) {
                i2 = i;
                z2 = z;
                z3 = true;
            } else {
                i2 = i;
                if (i2 == 1 && (Float.floatToRawIntBits(N0(j2, U0())) & Integer.MAX_VALUE) < 2139095040) {
                    z3 = true;
                    z2 = false;
                }
            }
            if (z3) {
                int i4 = pw0Var.c;
                pm1 pm1VarX = n71Var2.x();
                objArr = pm1VarX.a;
                i3 = pm1VarX.c - 1;
                loop0: while (i3 >= 0) {
                    n71Var = (n71) objArr[i3];
                    if (n71Var.I()) {
                        int i5 = i2;
                        z4 = z2;
                        ao1Var2.i(n71Var, j2, pw0Var, i5, z4);
                        jA = pw0Var.a();
                        if (hm4.b(jA) < 0.0f && hm4.d(jA) && !hm4.c(jA)) {
                            co1 co1Var = n71Var.o0.d;
                            co1Var.getClass();
                            dk1 dk1VarX0 = co1Var.X0(do1.g(16));
                            if (dk1VarX0 == null || !dk1VarX0.w) {
                                break;
                            }
                            if (!dk1VarX0.a.w) {
                                z01.b("visitLocalDescendants called on an unattached node");
                            }
                            dk1 dk1Var = dk1VarX0.a;
                            if ((dk1Var.e & 16) == 0) {
                                break;
                            }
                            while (true) {
                                if (dk1Var == null) {
                                    break loop0;
                                }
                                if ((dk1Var.c & 16) != 0) {
                                    ?? B = dk1Var;
                                    ?? pm1Var = 0;
                                    while (B != 0) {
                                        if (B instanceof qy1) {
                                            if (((qy1) B).Y()) {
                                                pw0Var.c = pw0Var.a.b - 1;
                                                break;
                                            }
                                        } else if ((B.c & 16) != 0 && (B instanceof zb0)) {
                                            dk1 dk1Var2 = ((zb0) B).H;
                                            int i6 = 0;
                                            B = B;
                                            pm1Var = pm1Var;
                                            while (dk1Var2 != null) {
                                                if ((dk1Var2.c & 16) != 0) {
                                                    i6++;
                                                    pm1Var = pm1Var;
                                                    if (i6 == 1) {
                                                        B = dk1Var2;
                                                    } else {
                                                        if (pm1Var == 0) {
                                                            pm1Var = new pm1(new dk1[16]);
                                                        }
                                                        if (B != 0) {
                                                            pm1Var.b(B);
                                                            B = 0;
                                                        }
                                                        pm1Var.b(dk1Var2);
                                                    }
                                                }
                                                dk1Var2 = dk1Var2.i;
                                                B = B;
                                                pm1Var = pm1Var;
                                            }
                                            if (i6 == 1) {
                                            }
                                        }
                                        B = cm4.b(pm1Var);
                                    }
                                }
                                dk1Var = dk1Var.i;
                            }
                        }
                    } else {
                        z4 = z2;
                    }
                    i3--;
                    ao1Var2 = ao1Var;
                    j2 = j;
                    z2 = z4;
                    i2 = i;
                }
                pw0Var.c = i4;
            }
        }
        i2 = i;
        z2 = z;
        z3 = false;
        if (z3) {
            int i7 = pw0Var.c;
            pm1 pm1VarX2 = n71Var2.x();
            objArr = pm1VarX2.a;
            i3 = pm1VarX2.c - 1;
            loop0: while (i3 >= 0) {
                n71Var = (n71) objArr[i3];
                if (n71Var.I()) {
                    int i8 = i2;
                    z4 = z2;
                    ao1Var2.i(n71Var, j2, pw0Var, i8, z4);
                    jA = pw0Var.a();
                    if (hm4.b(jA) < 0.0f) {
                        continue;
                    }
                } else {
                    z4 = z2;
                }
                i3--;
                ao1Var2 = ao1Var;
                j2 = j;
                z2 = z4;
                i2 = i;
            }
            pw0Var.c = i7;
        }
    }

    @Override // defpackage.jh1
    public final int c0(int i) {
        l11 l11VarT = this.x.t();
        oh1 oh1VarZ = l11VarT.z();
        n71 n71Var = (n71) l11VarT.b;
        return oh1VarZ.c(n71Var.o0.d, n71Var.m(), i);
    }

    @Override // defpackage.jh1
    public final zw1 e(long j) {
        q0(j);
        n71 n71Var = this.x;
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((n71) objArr[i2]).p0.p.u = l71.c;
        }
        o1(n71Var.f0.f(this, n71Var.m(), j));
        f1();
        return this;
    }

    @Override // defpackage.jh1
    public final int e0(int i) {
        l11 l11VarT = this.x.t();
        oh1 oh1VarZ = l11VarT.z();
        n71 n71Var = (n71) l11VarT.b;
        return oh1VarZ.g(n71Var.o0.d, n71Var.m(), i);
    }

    @Override // defpackage.jh1
    public final int f(int i) {
        l11 l11VarT = this.x.t();
        oh1 oh1VarZ = l11VarT.z();
        n71 n71Var = (n71) l11VarT.b;
        return oh1VarZ.a(n71Var.o0.d, n71Var.m(), i);
    }

    @Override // defpackage.co1
    public final void k1(cw cwVar, vu0 vu0Var) {
        n71 n71Var = this.x;
        it1 it1VarA = q71.a(n71Var);
        pm1 pm1VarX = n71Var.x();
        Object[] objArr = pm1VarX.a;
        int i = pm1VarX.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            if (n71Var2.I()) {
                n71Var2.i(cwVar, vu0Var);
            }
        }
        if (((r7) it1VarA).getShowLayoutBounds()) {
            long j = this.c;
            cwVar.q(0.5f, 0.5f, ((int) (j >> 32)) - 0.5f, ((int) (j & 4294967295L)) - 0.5f, C0);
        }
    }

    @Override // defpackage.zw1
    public final void n0(long j, float f, hq0 hq0Var) {
        l1(j, f, hq0Var);
        if (this.s) {
            return;
        }
        this.x.p0.p.z0();
    }

    @Override // defpackage.mf1
    public final int t0(d6 d6Var) {
        e11 e11Var = this.B0;
        if (e11Var != null) {
            return e11Var.t0(d6Var);
        }
        nh1 nh1Var = this.x.p0.p;
        j71 j71Var = nh1Var.i.d;
        o71 o71Var = nh1Var.f0;
        if (j71Var == j71.a) {
            o71Var.d = true;
            if (o71Var.b) {
                nh1Var.d0 = true;
                nh1Var.e0 = true;
            }
        } else {
            o71Var.e = true;
        }
        f11 f11VarP = nh1Var.p();
        boolean z = f11VarP.t;
        f11VarP.t = true;
        nh1Var.r();
        f11VarP.t = z;
        Integer num = (Integer) o71Var.g.get(d6Var);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }
}
