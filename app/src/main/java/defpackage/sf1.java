package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sf1 extends zw1 implements jh1, i6, sk1 {
    public boolean c0;
    public Object f0;
    public final r71 i;
    public boolean j;
    public boolean j0;
    public boolean t;
    public boolean u;
    public q40 v;
    public hq0 x;
    public int k = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;
    public l71 s = l71.c;
    public long w = 0;
    public qf1 H = qf1.c;
    public final o71 X = new o71(this, 1);
    public final pm1 Y = new pm1(new sf1[16]);
    public boolean Z = true;
    public final rf1 d0 = new rf1(this, 0);
    public boolean e0 = true;
    public long g0 = r40.b(0, 0, 15);
    public final rf1 h0 = new rf1(this, 2);
    public final rf1 i0 = new rf1(this, 1);

    public sf1(r71 r71Var) {
        this.i = r71Var;
        this.f0 = r71Var.p.X;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006e A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0013, B:9:0x0018, B:12:0x001d, B:14:0x0021, B:15:0x0026, B:17:0x0035, B:19:0x0039, B:22:0x003f, B:21:0x003d, B:23:0x0042, B:25:0x004c, B:30:0x0056, B:32:0x0084, B:31:0x006e), top: B:36:0x0007 }] */
    public final void A0(long j, hq0 hq0Var) {
        r71 r71Var = this.i;
        n71 n71Var = r71Var.a;
        n71 n71Var2 = r71Var.a;
        try {
            n71 n71VarU = n71Var.u();
            j71 j71Var = n71VarU != null ? n71VarU.p0.d : null;
            j71 j71Var2 = j71.e;
            if (j71Var == j71Var2) {
                r71Var.c = false;
            }
            if (n71Var2.x0) {
                z01.a("place is called on a deactivated node");
            }
            r71Var.d = j71Var2;
            boolean z = true;
            this.t = true;
            this.j0 = false;
            if (!e21.a(j, this.w)) {
                if (r71Var.n || r71Var.m) {
                    r71Var.f = true;
                }
                x0();
            }
            it1 it1VarA = q71.a(n71Var2);
            this.w = j;
            if (r71Var.f) {
                r71Var.h(false);
                this.X.e = false;
                lt1 snapshotObserver = ((r7) it1VarA).getSnapshotObserver();
                snapshotObserver.a.c(n71Var2, snapshotObserver.g, this.i0);
            } else {
                if (this.H == qf1.c) {
                    z = false;
                }
                if (z) {
                    of1 of1VarT0 = r71Var.a().T0();
                    of1VarT0.getClass();
                    of1VarT0.M0(e21.c(j, of1VarT0.f));
                    z0();
                } else {
                    r71Var.h(false);
                    this.X.e = false;
                    lt1 snapshotObserver2 = ((r7) it1VarA).getSnapshotObserver();
                    snapshotObserver2.a.c(n71Var2, snapshotObserver2.g, this.i0);
                }
            }
            this.x = hq0Var;
            r71Var.d = j71.f;
        } catch (Throwable th) {
            n71Var.Y(th);
            throw null;
        }
    }

    public final boolean B0(long j) {
        r71 r71Var = this.i;
        n71 n71Var = r71Var.a;
        n71 n71Var2 = r71Var.a;
        try {
            if (n71Var.x0) {
                z01.a("measure is called on a deactivated node");
            }
            n71 n71VarU = n71Var2.u();
            n71Var2.n0 = n71Var2.n0 || (n71VarU != null && n71VarU.n0);
            if (!n71Var2.p0.e) {
                q40 q40Var = this.v;
                if (q40Var == null ? false : q40.b(q40Var.a, j)) {
                    it1 it1Var = n71Var2.x;
                    if (it1Var != null) {
                        ((r7) it1Var).g(n71Var2, true);
                    }
                    n71Var2.X();
                    return false;
                }
            }
            this.v = new q40(j);
            q0(j);
            this.X.d = false;
            pm1 pm1VarZ = n71Var2.z();
            Object[] objArr = pm1VarZ.a;
            int i = pm1VarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                sf1 sf1Var = ((n71) objArr[i2]).p0.q;
                sf1Var.getClass();
                sf1Var.X.getClass();
            }
            long j2 = this.u ? this.c : -9223372034707292160L;
            this.u = true;
            of1 of1VarT0 = r71Var.a().T0();
            if (of1VarT0 == null) {
                z01.b("Lookahead result from lookaheadRemeasure cannot be null");
            }
            r71Var.c(j);
            o0((((long) of1VarT0.a) << 32) | (((long) of1VarT0.b) & 4294967295L));
            return (((int) (j2 >> 32)) == of1VarT0.a && ((int) (j2 & 4294967295L)) == of1VarT0.b) ? false : true;
        } catch (Throwable th) {
            n71Var.Y(th);
            throw null;
        }
    }

    @Override // defpackage.jh1
    public final int V(int i) {
        y0();
        of1 of1VarT0 = this.i.a().T0();
        of1VarT0.getClass();
        return of1VarT0.V(i);
    }

    @Override // defpackage.i6
    public final int Y() {
        return this.n;
    }

    @Override // defpackage.i6
    public final void b0() {
        n71.T(this.i.a, false, 7);
    }

    @Override // defpackage.jh1
    public final int c0(int i) {
        y0();
        of1 of1VarT0 = this.i.a().T0();
        of1VarT0.getClass();
        return of1VarT0.c0(i);
    }

    @Override // defpackage.i6
    public final o71 d() {
        return this.X;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    @Override // defpackage.jh1
    public final zw1 e(long j) {
        l71 l71Var;
        r71 r71Var = this.i;
        n71 n71Var = r71Var.a;
        n71 n71Var2 = r71Var.a;
        n71 n71VarU = n71Var.u();
        if ((n71VarU != null ? n71VarU.p0.d : null) == j71.b) {
            r71Var.b = false;
        } else {
            n71 n71VarU2 = n71Var2.u();
            if ((n71VarU2 != null ? n71VarU2.p0.d : null) == j71.e) {
                r71Var.b = false;
            }
        }
        n71 n71VarU3 = n71Var2.u();
        l71 l71Var2 = l71.c;
        if (n71VarU3 != null) {
            r71 r71Var2 = n71VarU3.p0;
            if (this.s != l71Var2 && !n71Var2.n0) {
                z01.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = r71Var2.d.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                l71Var = l71.a;
            } else {
                if (iOrdinal != 2 && iOrdinal != 3) {
                    dk0.x(r71Var2.d, "Measurable could be only measured from the parent's measure or layout block. Parents state is ");
                    return null;
                }
                l71Var = l71.b;
            }
            this.s = l71Var;
        } else {
            this.s = l71Var2;
        }
        if (n71Var2.l0 == l71Var2) {
            n71Var2.e();
        }
        B0(j);
        return this;
    }

    @Override // defpackage.jh1
    public final int e0(int i) {
        y0();
        of1 of1VarT0 = this.i.a().T0();
        of1VarT0.getClass();
        return of1VarT0.e0(i);
    }

    @Override // defpackage.jh1
    public final int f(int i) {
        y0();
        of1 of1VarT0 = this.i.a().T0();
        of1VarT0.getClass();
        return of1VarT0.f(i);
    }

    @Override // defpackage.zw1
    public final int h0() {
        of1 of1VarT0 = this.i.a().T0();
        of1VarT0.getClass();
        return of1VarT0.h0();
    }

    @Override // defpackage.zw1
    public final int i0() {
        of1 of1VarT0 = this.i.a().T0();
        of1VarT0.getClass();
        return of1VarT0.i0();
    }

    @Override // defpackage.zw1, defpackage.jh1
    public final Object k() {
        return this.f0;
    }

    @Override // defpackage.i6
    public final void n(h6 h6Var) {
        pm1 pm1VarZ = this.i.a.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            sf1 sf1Var = ((n71) objArr[i2]).p0.q;
            sf1Var.getClass();
            h6Var.j(sf1Var);
        }
    }

    @Override // defpackage.zw1
    public final void n0(long j, float f, hq0 hq0Var) {
        A0(j, hq0Var);
    }

    @Override // defpackage.sk1
    public final void o(boolean z) {
        of1 of1VarT0;
        r71 r71Var = this.i;
        of1 of1VarT1 = r71Var.a().T0();
        if (Boolean.valueOf(z).equals(of1VarT1 != null ? Boolean.valueOf(of1VarT1.n) : null) || (of1VarT0 = r71Var.a().T0()) == null) {
            return;
        }
        of1VarT0.n = z;
    }

    @Override // defpackage.i6
    public final f11 p() {
        return this.i.a.o0.c;
    }

    @Override // defpackage.i6
    public final i6 q() {
        r71 r71Var;
        n71 n71VarU = this.i.a.u();
        if (n71VarU == null || (r71Var = n71VarU.p0) == null) {
            return null;
        }
        return r71Var.q;
    }

    @Override // defpackage.i6
    public final void r() {
        this.c0 = true;
        o71 o71Var = this.X;
        o71Var.h();
        r71 r71Var = this.i;
        boolean z = r71Var.f;
        n71 n71Var = r71Var.a;
        if (z) {
            pm1 pm1VarZ = n71Var.z();
            Object[] objArr = pm1VarZ.a;
            int i = pm1VarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                n71 n71Var2 = (n71) objArr[i2];
                r71 r71Var2 = n71Var2.p0;
                if (r71Var2.e && n71Var2.s() == l71.a) {
                    sf1 sf1Var = r71Var2.q;
                    sf1Var.getClass();
                    sf1 sf1Var2 = r71Var2.q;
                    q40 q40Var = sf1Var2 != null ? sf1Var2.v : null;
                    q40Var.getClass();
                    if (sf1Var.B0(q40Var.a)) {
                        n71.T(n71Var, false, 7);
                    }
                }
            }
        }
        e11 e11Var = p().B0;
        e11Var.getClass();
        if (r71Var.g || (!e11Var.t && r71Var.f)) {
            r71Var.f = false;
            j71 j71Var = r71Var.d;
            r71Var.d = j71.e;
            r71Var.i(false);
            lt1 snapshotObserver = ((r7) q71.a(n71Var)).getSnapshotObserver();
            snapshotObserver.a.c(n71Var, snapshotObserver.h, this.d0);
            r71Var.d = j71Var;
            if (r71Var.m && e11Var.t) {
                requestLayout();
            }
            r71Var.g = false;
        }
        if (o71Var.b && o71Var.e()) {
            o71Var.g();
        }
        this.c0 = false;
    }

    @Override // defpackage.i6
    public final void requestLayout() {
        this.i.a.S(false);
    }

    public final boolean s0() {
        r71 r71Var = this.i;
        return vp4.a(r71Var.a) || r71Var.c;
    }

    public final void t0(boolean z) {
        if (z && s0()) {
            return;
        }
        if (z || s0()) {
            this.H = qf1.c;
            pm1 pm1VarZ = this.i.a.z();
            Object[] objArr = pm1VarZ.a;
            int i = pm1VarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                sf1 sf1Var = ((n71) objArr[i2]).p0.q;
                sf1Var.getClass();
                sf1Var.t0(true);
            }
        }
    }

    public final void w0() {
        qf1 qf1Var = this.H;
        r71 r71Var = this.i;
        boolean z = r71Var.c;
        n71 n71Var = r71Var.a;
        qf1 qf1Var2 = qf1.a;
        if (z) {
            this.H = qf1.b;
        } else {
            this.H = qf1Var2;
        }
        if (qf1Var != qf1Var2 && r71Var.e) {
            n71.T(n71Var, true, 6);
        }
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            sf1 sf1Var = n71Var2.p0.q;
            if (sf1Var == null) {
                og.i("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
                return;
            }
            if (sf1Var.n != Integer.MAX_VALUE) {
                sf1Var.w0();
                n71.W(n71Var2);
            }
        }
    }

    public final void x0() {
        r71 r71Var = this.i;
        if (r71Var.o > 0) {
            pm1 pm1VarZ = r71Var.a.z();
            Object[] objArr = pm1VarZ.a;
            int i = pm1VarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                n71 n71Var = (n71) objArr[i2];
                r71 r71Var2 = n71Var.p0;
                if ((r71Var2.m || r71Var2.n) && !r71Var2.f) {
                    n71Var.S(false);
                }
                sf1 sf1Var = r71Var2.q;
                if (sf1Var != null) {
                    sf1Var.x0();
                }
            }
        }
    }

    public final void y0() {
        l71 l71Var;
        r71 r71Var = this.i;
        n71.T(r71Var.a, false, 7);
        n71 n71Var = r71Var.a;
        n71 n71VarU = n71Var.u();
        if (n71VarU == null || n71Var.l0 != l71.c) {
            return;
        }
        int iOrdinal = n71VarU.p0.d.ordinal();
        if (iOrdinal != 0) {
            l71Var = iOrdinal != 2 ? n71VarU.l0 : l71.b;
        } else {
            l71Var = l71.a;
        }
        n71Var.l0 = l71Var;
    }

    public final void z0() {
        j71 j71Var;
        this.j0 = true;
        r71 r71Var = this.i;
        n71 n71VarU = r71Var.a.u();
        qf1 qf1Var = this.H;
        if ((qf1Var != qf1.a && !r71Var.c) || (qf1Var != qf1.b && r71Var.c)) {
            w0();
            if (this.j && n71VarU != null) {
                n71VarU.S(false);
            }
        }
        if (n71VarU != null) {
            r71 r71Var2 = n71VarU.p0;
            if (!this.j && ((j71Var = r71Var2.d) == j71.c || j71Var == j71.e)) {
                if (this.n != Integer.MAX_VALUE) {
                    z01.b("Place was called on a node which was placed already");
                }
                int i = r71Var2.h;
                this.n = i;
                r71Var2.h = i + 1;
            }
        } else {
            this.n = 0;
        }
        r();
    }
}
