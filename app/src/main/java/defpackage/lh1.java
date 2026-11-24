package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lh1 {
    public final n71 a;
    public boolean c;
    public boolean d;
    public q40 i;
    public final kf b = new kf(10);
    public final q91 e = new q91(15);
    public final pm1 f = new pm1(new n71[16]);
    public final long g = 1;
    public final pm1 h = new pm1(new kh1[16]);

    public lh1(n71 n71Var) {
        this.a = n71Var;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public static boolean b(n71 n71Var, q40 q40Var) {
        boolean zB0;
        n71 n71Var2 = n71Var.n;
        r71 r71Var = n71Var.p0;
        if (n71Var2 == null) {
            return false;
        }
        if (q40Var == null) {
            sf1 sf1Var = r71Var.q;
            q40 q40Var2 = sf1Var != null ? sf1Var.v : null;
            if (q40Var2 == null || n71Var2 == null) {
                zB0 = false;
            } else {
                sf1Var.getClass();
                zB0 = sf1Var.B0(q40Var2.a);
            }
        } else if (n71Var2 != null) {
            sf1 sf1Var2 = r71Var.q;
            sf1Var2.getClass();
            zB0 = sf1Var2.B0(q40Var.a);
        } else {
            zB0 = false;
        }
        n71 n71VarU = n71Var.u();
        if (zB0 && n71VarU != null) {
            if (n71VarU.n == null) {
                n71.V(n71VarU, false, 3);
                return zB0;
            }
            if (n71Var.s() == l71.a) {
                n71.T(n71VarU, false, 3);
                return zB0;
            }
            if (n71Var.s() == l71.b) {
                n71VarU.S(false);
            }
        }
        return zB0;
    }

    public static boolean c(n71 n71Var, q40 q40Var) {
        boolean zB0;
        l71 l71Var = l71.c;
        if (q40Var != null) {
            if (n71Var.l0 == l71Var) {
                n71Var.e();
            }
            zB0 = n71Var.p0.p.B0(q40Var.a);
        } else {
            nh1 nh1Var = n71Var.p0.p;
            q40 q40Var2 = nh1Var.s ? new q40(nh1Var.e) : null;
            if (q40Var2 != null) {
                if (n71Var.l0 == l71Var) {
                    n71Var.e();
                }
                zB0 = n71Var.p0.p.B0(q40Var2.a);
            } else {
                n71Var.getClass();
                zB0 = false;
            }
        }
        n71 n71VarU = n71Var.u();
        if (zB0 && n71VarU != null) {
            if (n71Var.r() == l71.a) {
                n71.V(n71VarU, false, 3);
                return zB0;
            }
            if (n71Var.r() == l71.b) {
                n71VarU.U(false);
            }
        }
        return zB0;
    }

    public static boolean h(n71 n71Var) {
        sf1 sf1Var;
        o71 o71Var;
        if (n71Var.p0.e) {
            return (n71Var.s() == l71.c && ((sf1Var = n71Var.p0.q) == null || (o71Var = sf1Var.X) == null || !o71Var.e())) ? false : true;
        }
        return false;
    }

    public static boolean i(n71 n71Var) {
        if (!n71Var.q()) {
            return false;
        }
        do {
            if (n71Var.r() == l71.c && !n71Var.p0.p.f0.e()) {
                n71 n71VarU = n71Var.u();
                if ((n71VarU != null ? n71VarU.p0.d : null) != j71.a) {
                    return false;
                }
            }
            n71Var = n71Var.u();
            if (n71Var == null) {
                return false;
            }
        } while (!n71Var.I());
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(boolean z) {
        Object[] objArr;
        q91 q91Var = this.e;
        if (z) {
            pm1 pm1Var = (pm1) q91Var.b;
            n71 n71Var = this.a;
            if (n71Var.w0 > 0) {
                pm1Var.h();
                pm1Var.b(n71Var);
                n71Var.v0 = true;
            }
        }
        pm1 pm1Var2 = (pm1) q91Var.b;
        int i = pm1Var2.c;
        if (i != 0) {
            Arrays.sort(pm1Var2.a, 0, i, lo0.e);
            int i2 = pm1Var2.c;
            n71[] n71VarArr = (n71[]) q91Var.c;
            if (n71VarArr != null) {
                int length = n71VarArr.length;
                objArr = n71VarArr;
                if (length < i2) {
                    objArr = new n71[Math.max(16, i2)];
                }
            } else {
                objArr = new n71[Math.max(16, i2)];
            }
            q91Var.c = null;
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = pm1Var2.a[i3];
            }
            pm1Var2.h();
            for (int i4 = i2 - 1; -1 < i4; i4--) {
                n71 n71Var2 = objArr[i4];
                n71Var2.getClass();
                if (n71Var2.v0) {
                    q91.z(n71Var2);
                }
                objArr[i4] = 0;
            }
            q91Var.c = objArr;
        }
    }

    public final void d() {
        pm1 pm1Var = this.h;
        int i = pm1Var.c;
        if (i != 0) {
            Object[] objArr = pm1Var.a;
            for (int i2 = 0; i2 < i; i2++) {
                kh1 kh1Var = (kh1) objArr[i2];
                if (kh1Var.a.H()) {
                    boolean z = kh1Var.b;
                    n71 n71Var = kh1Var.a;
                    boolean z2 = kh1Var.c;
                    if (z) {
                        n71.T(n71Var, z2, 2);
                    } else {
                        n71.V(n71Var, z2, 2);
                    }
                }
            }
            pm1Var.h();
        }
    }

    public final void e(n71 n71Var) {
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            if (g31.a(n71Var2.J(), Boolean.TRUE) && !n71Var2.x0) {
                if (this.b.f(n71Var2)) {
                    n71Var2.K();
                }
                e(n71Var2);
            }
        }
    }

    public final void f(n71 n71Var, boolean z) {
        if (!this.c) {
            z01.b("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (z ? n71Var.p0.e : n71Var.q()) {
            z01.a("node not yet measured");
        }
        g(n71Var, z);
    }

    public final void g(n71 n71Var, boolean z) {
        sf1 sf1Var;
        o71 o71Var;
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            l71 l71Var = l71.a;
            if ((!z && (n71Var2.r() == l71Var || n71Var2.p0.p.f0.e())) || (z && (n71Var2.s() == l71Var || ((sf1Var = n71Var2.p0.q) != null && (o71Var = sf1Var.X) != null && o71Var.e())))) {
                boolean zA = vp4.a(n71Var2);
                r71 r71Var = n71Var2.p0;
                if (zA && !z) {
                    if (r71Var.e && this.b.f(n71Var2)) {
                        m(n71Var2, true, false);
                    } else {
                        f(n71Var2, true);
                    }
                }
                if (z ? r71Var.e : n71Var2.q()) {
                    m(n71Var2, z, false);
                }
                if (!(z ? r71Var.e : n71Var2.q())) {
                    g(n71Var2, z);
                }
            }
        }
        if (z ? n71Var.p0.e : n71Var.q()) {
            m(n71Var, z, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [dk1] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [pm1] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [pm1] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v4 */
    public final boolean j(n7 n7Var) {
        boolean z;
        dk1 dk1Var;
        Object B;
        boolean z2;
        n71 n71Var;
        boolean z3;
        kf kfVar = this.b;
        n71 n71Var2 = this.a;
        if (!n71Var2.H()) {
            z01.a("performMeasureAndLayout called with unattached root");
        }
        if (!n71Var2.I()) {
            z01.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.c) {
            z01.a("performMeasureAndLayout called during measure layout");
        }
        int i = 0;
        if (this.i != null) {
            this.c = true;
            this.d = true;
            try {
                boolean zW = kfVar.w();
                uf1 uf1Var = (uf1) kfVar.b;
                if (zW) {
                    z = false;
                    while (true) {
                        uf1 uf1Var2 = (uf1) kfVar.e;
                        uf1 uf1Var3 = (uf1) kfVar.c;
                        if (!((ep2) uf1Var.b).isEmpty()) {
                            n71Var = (n71) ((ep2) uf1Var.b).first();
                            uf1Var.w(n71Var);
                            z3 = n71Var.n != null;
                            z2 = false;
                        } else if (!((ep2) uf1Var3.b).isEmpty()) {
                            n71Var = (n71) ((ep2) uf1Var3.b).first();
                            uf1Var3.w(n71Var);
                            z3 = n71Var.n != null;
                            z2 = true;
                        } else {
                            if (((ep2) uf1Var2.b).isEmpty()) {
                                break;
                            }
                            n71 n71Var3 = (n71) ((ep2) uf1Var2.b).first();
                            uf1Var2.w(n71Var3);
                            z2 = true;
                            n71Var = n71Var3;
                            z3 = false;
                        }
                        boolean zM = m(n71Var, z3, z2);
                        if (!z2) {
                            if (n71Var.p0.f) {
                                kfVar.e(n71Var, q31.b);
                            }
                            if (n71Var.p()) {
                                kfVar.e(n71Var, q31.e);
                            }
                        }
                        if (n71Var == n71Var2 && zM) {
                            z = true;
                        }
                    }
                    if (n7Var != null) {
                        n7Var.a();
                    }
                } else {
                    z = false;
                }
                this.c = false;
                this.d = false;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    this.c = false;
                    this.d = false;
                    throw th2;
                }
            }
        } else {
            z = false;
        }
        pm1 pm1Var = this.f;
        Object[] objArr = pm1Var.a;
        int i2 = pm1Var.c;
        int i3 = 0;
        while (i3 < i2) {
            zn1 zn1Var = ((n71) objArr[i3]).o0;
            f11 f11Var = zn1Var.c;
            boolean zG = do1.g(4194304);
            if (zG) {
                dk1Var = f11Var.A0;
            } else {
                dk1Var = f11Var.A0.f;
                if (dk1Var == null) {
                }
                i3++;
                i = 0;
            }
            r72 r72Var = co1.v0;
            dk1 dk1VarX0 = f11Var.X0(zG);
            while (dk1VarX0 != null && (dk1VarX0.e & 4194304) != 0) {
                if ((dk1VarX0.c & 4194304) != 0) {
                    var r12 = dk1VarX0;
                    var pm1Var2 = 0;
                    while (r12 != 0) {
                        if (r12 instanceof w61) {
                            ((w61) r12).o(zn1Var.c);
                        } else {
                            if ((r12.c & 4194304) != 0 && (r12 instanceof zb0)) {
                                dk1 dk1Var2 = ((zb0) r12).H;
                                int i4 = i;
                                B = r12;
                                pm1Var2 = pm1Var2;
                                while (dk1Var2 != null) {
                                    if ((dk1Var2.c & 4194304) != 0) {
                                        i4++;
                                        pm1Var2 = pm1Var2;
                                        if (i4 == 1) {
                                            B = dk1Var2;
                                        } else {
                                            if (pm1Var2 == 0) {
                                                pm1Var2 = new pm1(new dk1[16]);
                                            }
                                            if (B != 0) {
                                                pm1Var2.b(B);
                                                B = 0;
                                            }
                                            pm1Var2.b(dk1Var2);
                                        }
                                    }
                                    dk1Var2 = dk1Var2.i;
                                    B = B;
                                    pm1Var2 = pm1Var2;
                                }
                                if (i4 == 1) {
                                }
                            }
                            i = 0;
                            r12 = B;
                            pm1Var2 = pm1Var2;
                        }
                        B = cm4.b(pm1Var2);
                        i = 0;
                        r12 = B;
                        pm1Var2 = pm1Var2;
                    }
                }
                if (dk1VarX0 == dk1Var) {
                    break;
                }
                dk1VarX0 = dk1VarX0.i;
                i = 0;
            }
            i3++;
            i = 0;
        }
        pm1Var.h();
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public final void k(n71 n71Var, long j) {
        dk1 dk1Var;
        boolean z = n71Var.x0;
        r71 r71Var = n71Var.p0;
        if (z) {
            return;
        }
        n71 n71Var2 = this.a;
        if (n71Var == n71Var2) {
            z01.a("measureAndLayout called on root");
        }
        if (!n71Var2.H()) {
            z01.a("performMeasureAndLayout called with unattached root");
        }
        if (!n71Var2.I()) {
            z01.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.c) {
            z01.a("performMeasureAndLayout called during measure layout");
        }
        if (this.i != null) {
            this.c = true;
            this.d = false;
            try {
                kf kfVar = this.b;
                ((uf1) kfVar.b).w(n71Var);
                ((uf1) kfVar.c).w(n71Var);
                ((uf1) kfVar.e).w(n71Var);
                if (b(n71Var, new q40(j)) || r71Var.f) {
                    if (g31.a(n71Var.J(), Boolean.TRUE)) {
                        n71Var.K();
                    }
                }
                e(n71Var);
                if (n71Var.l0 == l71.c) {
                    n71Var.e();
                }
                boolean zB0 = r71Var.p.B0(j);
                n71 n71VarU = n71Var.u();
                if (zB0 && n71VarU != null) {
                    if (n71Var.r() == l71.a) {
                        n71.V(n71VarU, false, 3);
                    } else if (n71Var.r() == l71.b) {
                        n71VarU.U(false);
                    }
                }
                if (n71Var.p() && n71Var.I()) {
                    n71Var.R();
                    q91 q91Var = this.e;
                    q91Var.getClass();
                    if (n71Var.w0 > 0) {
                        ((pm1) q91Var.b).b(n71Var);
                        n71Var.v0 = true;
                    }
                }
                d();
                this.c = false;
                this.d = false;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    this.c = false;
                    this.d = false;
                    throw th2;
                }
            }
        }
        pm1 pm1Var = this.f;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            zn1 zn1Var = ((n71) objArr[i2]).o0;
            f11 f11Var = zn1Var.c;
            boolean zG = do1.g(4194304);
            if (zG) {
                dk1Var = f11Var.A0;
            } else {
                dk1Var = f11Var.A0.f;
                if (dk1Var == null) {
                }
            }
            r72 r72Var = co1.v0;
            for (dk1 dk1VarX0 = f11Var.X0(zG); dk1VarX0 != null && (dk1VarX0.e & 4194304) != 0; dk1VarX0 = dk1VarX0.i) {
                if ((dk1VarX0.c & 4194304) != 0) {
                    var B = dk1VarX0;
                    var pm1Var2 = 0;
                    while (B != 0) {
                        if (B instanceof w61) {
                            ((w61) B).o(zn1Var.c);
                        } else if ((B.c & 4194304) != 0 && (B instanceof zb0)) {
                            dk1 dk1Var2 = ((zb0) B).H;
                            int i3 = 0;
                            B = B;
                            pm1Var2 = pm1Var2;
                            while (dk1Var2 != null) {
                                if ((dk1Var2.c & 4194304) != 0) {
                                    i3++;
                                    pm1Var2 = pm1Var2;
                                    if (i3 == 1) {
                                        B = dk1Var2;
                                    } else {
                                        if (pm1Var2 == 0) {
                                            pm1Var2 = new pm1(new dk1[16]);
                                        }
                                        if (B != 0) {
                                            pm1Var2.b(B);
                                            B = 0;
                                        }
                                        pm1Var2.b(dk1Var2);
                                    }
                                }
                                dk1Var2 = dk1Var2.i;
                                B = B;
                                pm1Var2 = pm1Var2;
                            }
                            if (i3 == 1) {
                            }
                        }
                        B = cm4.b(pm1Var2);
                    }
                }
                if (dk1VarX0 == dk1Var) {
                    break;
                }
            }
        }
        pm1Var.h();
    }

    public final void l() {
        kf kfVar = this.b;
        if (kfVar.w()) {
            n71 n71Var = this.a;
            if (!n71Var.H()) {
                z01.a("performMeasureAndLayout called with unattached root");
            }
            if (!n71Var.I()) {
                z01.a("performMeasureAndLayout called with unplaced root");
            }
            if (this.c) {
                z01.a("performMeasureAndLayout called during measure layout");
            }
            if (this.i != null) {
                this.c = true;
                this.d = false;
                try {
                    if (!((ep2) ((uf1) kfVar.e).b).isEmpty() && !((ep2) ((uf1) kfVar.b).b).isEmpty()) {
                        if (n71Var.n != null) {
                            o(n71Var, true);
                        } else {
                            n(n71Var);
                        }
                    }
                    o(n71Var, false);
                    this.c = false;
                    this.d = false;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        this.c = false;
                        this.d = false;
                        throw th2;
                    }
                }
            }
        }
    }

    public final boolean m(n71 n71Var, boolean z, boolean z2) {
        q40 q40Var;
        boolean zB;
        yw1 placementScope;
        f11 f11Var;
        n71 n71VarU;
        sf1 sf1Var;
        o71 o71Var;
        boolean z3 = n71Var.x0;
        r71 r71Var = n71Var.p0;
        if (z3 || (!n71Var.I() && !r71Var.p.Z && !i(n71Var) && !g31.a(n71Var.J(), Boolean.TRUE) && !h(n71Var) && !r71Var.p.f0.e() && ((sf1Var = r71Var.q) == null || (o71Var = sf1Var.X) == null || !o71Var.e()))) {
            return false;
        }
        n71 n71Var2 = this.a;
        if (n71Var == n71Var2) {
            q40Var = this.i;
            q40Var.getClass();
        } else {
            q40Var = null;
        }
        if (z) {
            zB = r71Var.e ? b(n71Var, q40Var) : false;
            if (z2 && ((zB || r71Var.f) && g31.a(n71Var.J(), Boolean.TRUE))) {
                n71Var.K();
            }
        } else {
            boolean zC = n71Var.q() ? c(n71Var, q40Var) : false;
            if (z2 && n71Var.p() && (n71Var == n71Var2 || ((n71VarU = n71Var.u()) != null && n71VarU.I() && r71Var.p.Z))) {
                if (n71Var == n71Var2) {
                    if (n71Var.l0 == l71.c) {
                        n71Var.f();
                    }
                    n71 n71VarU2 = n71Var.u();
                    if (n71VarU2 == null || (f11Var = n71VarU2.o0.c) == null || (placementScope = f11Var.u) == null) {
                        placementScope = ((r7) q71.a(n71Var)).getPlacementScope();
                    }
                    yw1.k(placementScope, r71Var.p, 0, 0);
                } else {
                    n71Var.R();
                }
                q91 q91Var = this.e;
                q91Var.getClass();
                if (n71Var.w0 > 0) {
                    ((pm1) q91Var.b).b(n71Var);
                    n71Var.v0 = true;
                }
            }
            zB = zC;
        }
        d();
        return zB;
    }

    public final void n(n71 n71Var) {
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            if (n71Var2.r() == l71.a || n71Var2.p0.p.f0.e()) {
                if (vp4.a(n71Var2)) {
                    o(n71Var2, true);
                } else {
                    n(n71Var2);
                }
            }
        }
    }

    public final void o(n71 n71Var, boolean z) {
        q40 q40Var;
        if (n71Var.x0) {
            return;
        }
        if (n71Var == this.a) {
            q40Var = this.i;
            q40Var.getClass();
        } else {
            q40Var = null;
        }
        if (z) {
            b(n71Var, q40Var);
        } else {
            c(n71Var, q40Var);
        }
    }

    public final boolean p(n71 n71Var, boolean z) {
        int iOrdinal = n71Var.p0.d.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 || iOrdinal == 3) {
                this.h.b(new kh1(n71Var, false, z));
            } else {
                if (iOrdinal != 4) {
                    dk0.l();
                    return false;
                }
                if (!n71Var.q() || z) {
                    n71Var.p0.p.c0 = true;
                    if (!n71Var.x0 && (n71Var.I() || i(n71Var))) {
                        n71 n71VarU = n71Var.u();
                        if (n71VarU == null || !n71VarU.q()) {
                            this.b.e(n71Var, q31.c);
                        }
                        if (!this.d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void q(long j) {
        q40 q40Var = this.i;
        if (q40Var == null ? false : q40.b(q40Var.a, j)) {
            return;
        }
        if (this.c) {
            z01.a("updateRootConstraints called while measuring");
        }
        this.i = new q40(j);
        n71 n71Var = this.a;
        n71 n71Var2 = n71Var.n;
        r71 r71Var = n71Var.p0;
        if (n71Var2 != null) {
            r71Var.e = true;
        }
        r71Var.p.c0 = true;
        this.b.e(n71Var, n71Var2 != null ? q31.a : q31.c);
    }
}
