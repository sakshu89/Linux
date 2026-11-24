package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nh1 extends zw1 implements jh1, i6, sk1 {
    public Object X;
    public boolean Y;
    public boolean Z;
    public boolean c0;
    public boolean d0;
    public boolean e0;
    public final r71 i;
    public boolean i0;
    public boolean j;
    public float m0;
    public boolean n0;
    public hq0 o0;
    public float q0;
    public boolean s;
    public boolean s0;
    public boolean t;
    public hq0 w;
    public float x;
    public int k = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;
    public l71 u = l71.c;
    public long v = 0;
    public boolean H = true;
    public final o71 f0 = new o71(this, 0);
    public final pm1 g0 = new pm1(new nh1[16]);
    public boolean h0 = true;
    public long j0 = r40.b(0, 0, 15);
    public final mh1 k0 = new mh1(this, 1);
    public final mh1 l0 = new mh1(this, 0);
    public long p0 = 0;
    public final mh1 r0 = new mh1(this, 2);

    public nh1(r71 r71Var) {
        this.i = r71Var;
    }

    public final void A0(long j, float f, hq0 hq0Var) {
        r71 r71Var = this.i;
        n71 n71Var = r71Var.a;
        n71 n71Var2 = r71Var.a;
        if (n71Var.x0) {
            z01.a("place is called on a deactivated node");
        }
        r71Var.d = j71.c;
        this.v = j;
        this.x = f;
        this.w = hq0Var;
        this.n0 = false;
        it1 it1VarA = q71.a(n71Var2);
        if (this.d0 || !this.Y) {
            this.f0.e = false;
            r71Var.f(false);
            this.o0 = hq0Var;
            this.p0 = j;
            this.q0 = f;
            lt1 snapshotObserver = ((r7) it1VarA).getSnapshotObserver();
            snapshotObserver.a.c(n71Var2, snapshotObserver.f, this.r0);
        } else {
            co1 co1VarA = r71Var.a();
            co1VarA.l1(e21.c(j, co1VarA.f), f, hq0Var);
            z0();
        }
        r71Var.d = j71.f;
        if (r71Var.a().t && (r71Var.k || r71Var.j)) {
            requestLayout();
        }
        this.t = true;
    }

    public final boolean B0(long j) {
        r71 r71Var = this.i;
        n71 n71Var = r71Var.a;
        n71 n71Var2 = r71Var.a;
        try {
            if (n71Var.x0) {
                z01.a("measure is called on a deactivated node");
            }
            it1 it1VarA = q71.a(n71Var2);
            n71 n71VarU = n71Var2.u();
            boolean z = true;
            n71Var2.n0 = n71Var2.n0 || (n71VarU != null && n71VarU.n0);
            if (!n71Var2.q() && q40.b(this.e, j)) {
                ((r7) it1VarA).g(n71Var2, false);
                n71Var2.X();
                return false;
            }
            this.f0.d = false;
            pm1 pm1VarZ = n71Var2.z();
            Object[] objArr = pm1VarZ.a;
            int i = pm1VarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                ((n71) objArr[i2]).p0.p.f0.getClass();
            }
            this.s = true;
            long j2 = r71Var.a().c;
            q0(j);
            j71 j71Var = r71Var.d;
            j71 j71Var2 = j71.f;
            if (j71Var != j71Var2) {
                z01.b("layout state is not idle before measure starts");
            }
            this.j0 = j;
            j71 j71Var3 = j71.a;
            r71Var.d = j71Var3;
            this.c0 = false;
            lt1 snapshotObserver = ((r7) q71.a(n71Var2)).getSnapshotObserver();
            snapshotObserver.a.c(n71Var2, snapshotObserver.c, this.k0);
            if (r71Var.d == j71Var3) {
                this.d0 = true;
                this.e0 = true;
                r71Var.d = j71Var2;
            }
            if (l21.a(r71Var.a().c, j2) && r71Var.a().a == this.a && r71Var.a().b == this.b) {
                z = false;
            }
            o0((((long) r71Var.a().b) & 4294967295L) | (((long) r71Var.a().a) << 32));
            return z;
        } catch (Throwable th) {
            n71Var.Y(th);
            throw null;
        }
    }

    @Override // defpackage.jh1
    public final int V(int i) {
        r71 r71Var = this.i;
        if (!vp4.a(r71Var.a)) {
            y0();
            return r71Var.a().V(i);
        }
        sf1 sf1Var = r71Var.q;
        sf1Var.getClass();
        return sf1Var.V(i);
    }

    @Override // defpackage.i6
    public final int Y() {
        return this.n;
    }

    @Override // defpackage.i6
    public final void b0() {
        n71.V(this.i.a, false, 7);
    }

    @Override // defpackage.jh1
    public final int c0(int i) {
        r71 r71Var = this.i;
        if (!vp4.a(r71Var.a)) {
            y0();
            return r71Var.a().c0(i);
        }
        sf1 sf1Var = r71Var.q;
        sf1Var.getClass();
        return sf1Var.c0(i);
    }

    @Override // defpackage.i6
    public final o71 d() {
        return this.f0;
    }

    @Override // defpackage.jh1
    public final zw1 e(long j) {
        l71 l71Var;
        r71 r71Var = this.i;
        n71 n71Var = r71Var.a;
        n71 n71Var2 = r71Var.a;
        l71 l71Var2 = n71Var.l0;
        l71 l71Var3 = l71.c;
        if (l71Var2 == l71Var3) {
            n71Var.e();
        }
        if (vp4.a(n71Var2)) {
            sf1 sf1Var = r71Var.q;
            sf1Var.getClass();
            sf1Var.s = l71Var3;
            sf1Var.e(j);
        }
        n71 n71VarU = n71Var2.u();
        if (n71VarU != null) {
            r71 r71Var2 = n71VarU.p0;
            if (this.u != l71Var3 && !n71Var2.n0) {
                z01.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = r71Var2.d.ordinal();
            if (iOrdinal == 0) {
                l71Var = l71.a;
            } else {
                if (iOrdinal != 2) {
                    dk0.x(r71Var2.d, "Measurable could be only measured from the parent's measure or layout block. Parents state is ");
                    return null;
                }
                l71Var = l71.b;
            }
            this.u = l71Var;
        } else {
            this.u = l71Var3;
        }
        B0(j);
        return this;
    }

    @Override // defpackage.jh1
    public final int e0(int i) {
        r71 r71Var = this.i;
        if (!vp4.a(r71Var.a)) {
            y0();
            return r71Var.a().e0(i);
        }
        sf1 sf1Var = r71Var.q;
        sf1Var.getClass();
        return sf1Var.e0(i);
    }

    @Override // defpackage.jh1
    public final int f(int i) {
        r71 r71Var = this.i;
        if (!vp4.a(r71Var.a)) {
            y0();
            return r71Var.a().f(i);
        }
        sf1 sf1Var = r71Var.q;
        sf1Var.getClass();
        return sf1Var.f(i);
    }

    @Override // defpackage.zw1
    public final int h0() {
        return this.i.a().h0();
    }

    @Override // defpackage.zw1
    public final int i0() {
        return this.i.a().i0();
    }

    @Override // defpackage.zw1, defpackage.jh1
    public final Object k() {
        return this.X;
    }

    @Override // defpackage.i6
    public final void n(h6 h6Var) {
        pm1 pm1VarZ = this.i.a.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            h6Var.j(((n71) objArr[i2]).p0.p);
        }
    }

    @Override // defpackage.zw1
    public final void n0(long j, float f, hq0 hq0Var) {
        yw1 placementScope;
        r71 r71Var = this.i;
        n71 n71Var = r71Var.a;
        n71 n71Var2 = r71Var.a;
        try {
            this.Z = true;
            if (!e21.a(j, this.v) || this.s0) {
                if (r71Var.k || r71Var.j || this.s0) {
                    this.d0 = true;
                    this.s0 = false;
                }
                x0();
            }
            sf1 sf1Var = r71Var.q;
            if (sf1Var != null) {
                r71 r71Var2 = sf1Var.i;
                if (sf1Var.H == qf1.c && !vp4.a(r71Var2.a)) {
                    r71Var2.c = true;
                }
            }
            sf1 sf1Var2 = r71Var.q;
            if (sf1Var2 != null && sf1Var2.s0()) {
                co1 co1Var = r71Var.a().X;
                if (co1Var == null || (placementScope = co1Var.u) == null) {
                    placementScope = ((r7) q71.a(n71Var2)).getPlacementScope();
                }
                sf1 sf1Var3 = r71Var.q;
                sf1Var3.getClass();
                n71 n71VarU = n71Var2.u();
                if (n71VarU != null) {
                    n71VarU.p0.h = 0;
                }
                sf1Var3.n = Integer.MAX_VALUE;
                yw1.h(placementScope, sf1Var3, (int) (j >> 32), (int) (4294967295L & j));
            }
            sf1 sf1Var4 = r71Var.q;
            if (sf1Var4 != null && !sf1Var4.t) {
                z01.b("Error: Placement happened before lookahead.");
            }
            A0(j, f, hq0Var);
        } catch (Throwable th) {
            n71Var.Y(th);
            throw null;
        }
    }

    @Override // defpackage.sk1
    public final void o(boolean z) {
        r71 r71Var = this.i;
        if (z != r71Var.a().n) {
            r71Var.a().n = z;
            this.s0 = true;
        }
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
        return r71Var.p;
    }

    @Override // defpackage.i6
    public final void r() {
        boolean zB0;
        this.i0 = true;
        o71 o71Var = this.f0;
        o71Var.h();
        boolean z = this.d0;
        r71 r71Var = this.i;
        if (z) {
            pm1 pm1VarZ = r71Var.a.z();
            Object[] objArr = pm1VarZ.a;
            int i = pm1VarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                n71 n71Var = (n71) objArr[i2];
                boolean zQ = n71Var.q();
                r71 r71Var2 = n71Var.p0;
                if (zQ && n71Var.r() == l71.a) {
                    nh1 nh1Var = r71Var2.p;
                    q40 q40Var = nh1Var.s ? new q40(nh1Var.e) : null;
                    if (q40Var != null) {
                        if (n71Var.l0 == l71.c) {
                            n71Var.e();
                        }
                        zB0 = r71Var2.p.B0(q40Var.a);
                    } else {
                        zB0 = false;
                    }
                    if (zB0) {
                        n71.V(r71Var.a, false, 7);
                    }
                }
            }
        }
        if (this.e0 || (!p().t && this.d0)) {
            this.d0 = false;
            j71 j71Var = r71Var.d;
            r71Var.d = j71.c;
            r71Var.g(false);
            n71 n71Var2 = r71Var.a;
            lt1 snapshotObserver = ((r7) q71.a(n71Var2)).getSnapshotObserver();
            snapshotObserver.a.c(n71Var2, snapshotObserver.e, this.l0);
            r71Var.d = j71Var;
            this.e0 = false;
        }
        if (o71Var.b && o71Var.e()) {
            o71Var.g();
        }
        this.i0 = false;
    }

    @Override // defpackage.i6
    public final void requestLayout() {
        this.i.a.U(false);
    }

    public final List s0() {
        r71 r71Var = this.i;
        r71Var.a.f0();
        boolean z = this.h0;
        pm1 pm1Var = this.g0;
        if (!z) {
            return pm1Var.g();
        }
        n71 n71Var = r71Var.a;
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            if (pm1Var.c <= i2) {
                pm1Var.b(n71Var2.p0.p);
            } else {
                nh1 nh1Var = n71Var2.p0.p;
                Object[] objArr2 = pm1Var.a;
                Object obj = objArr2[i2];
                objArr2[i2] = nh1Var;
            }
        }
        pm1Var.m(((pm1) ((wl1) n71Var.n()).b).c, pm1Var.c);
        this.h0 = false;
        return pm1Var.g();
    }

    public final void t0() {
        boolean z = this.Y;
        this.Y = true;
        r71 r71Var = this.i;
        n71 n71Var = r71Var.a;
        zn1 zn1Var = n71Var.o0;
        if (!z) {
            zn1Var.c.g1();
            ((r7) q71.a(n71Var)).getRectManager().f(r71Var.a, true);
            if (n71Var.q()) {
                n71.V(n71Var, true, 6);
            } else if (n71Var.p0.e) {
                n71.T(n71Var, true, 6);
            }
        }
        co1 co1Var = zn1Var.c.H;
        for (co1 co1Var2 = zn1Var.d; !g31.a(co1Var2, co1Var) && co1Var2 != null; co1Var2 = co1Var2.H) {
            if (co1Var2.t0) {
                co1Var2.c1();
            }
        }
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            if (n71Var2.v() != Integer.MAX_VALUE) {
                n71Var2.p0.p.t0();
                n71.W(n71Var2);
            }
        }
    }

    public final void w0() {
        if (this.Y) {
            this.Y = false;
            r71 r71Var = this.i;
            n71 n71Var = r71Var.a;
            n71 n71Var2 = r71Var.a;
            ((r7) q71.a(n71Var)).getRectManager().h(n71Var2);
            zn1 zn1Var = n71Var2.o0;
            co1 co1Var = zn1Var.c.H;
            for (co1 co1Var2 = zn1Var.d; !g31.a(co1Var2, co1Var) && co1Var2 != null; co1Var2 = co1Var2.H) {
                co1Var2.i1();
                co1Var2.n1();
            }
            pm1 pm1VarZ = n71Var2.z();
            Object[] objArr = pm1VarZ.a;
            int i = pm1VarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                ((n71) objArr[i2]).p0.p.w0();
            }
        }
    }

    public final void x0() {
        r71 r71Var = this.i;
        if (r71Var.l > 0) {
            pm1 pm1VarZ = r71Var.a.z();
            Object[] objArr = pm1VarZ.a;
            int i = pm1VarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                n71 n71Var = (n71) objArr[i2];
                r71 r71Var2 = n71Var.p0;
                boolean z = r71Var2.j;
                nh1 nh1Var = r71Var2.p;
                if ((z || r71Var2.k) && !nh1Var.d0) {
                    n71Var.U(false);
                }
                nh1Var.x0();
            }
        }
    }

    public final void y0() {
        l71 l71Var;
        r71 r71Var = this.i;
        n71.V(r71Var.a, false, 7);
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
        this.n0 = true;
        r71 r71Var = this.i;
        n71 n71VarU = r71Var.a.u();
        float f = p().j0;
        n71 n71Var = r71Var.a;
        zn1 zn1Var = n71Var.o0;
        co1 co1Var = zn1Var.d;
        f11 f11Var = zn1Var.c;
        while (co1Var != f11Var) {
            co1Var.getClass();
            h71 h71Var = (h71) co1Var;
            f += h71Var.j0;
            co1Var = h71Var.H;
        }
        if (f != this.m0) {
            this.m0 = f;
            if (n71VarU != null) {
                n71VarU.O();
            }
            if (n71VarU != null) {
                n71VarU.C();
            }
        }
        if (!p().t) {
            boolean z = this.Y;
            if (!z || this.f0.d()) {
                t0();
            }
            if (z) {
                n71Var.o0.c.g1();
            } else {
                if (n71VarU != null) {
                    n71VarU.C();
                }
                if (this.j && n71VarU != null) {
                    n71VarU.U(false);
                }
            }
        }
        if (n71VarU != null) {
            r71 r71Var2 = n71VarU.p0;
            if (!this.j && r71Var2.d == j71.c) {
                if (this.n != Integer.MAX_VALUE) {
                    z01.b("Place was called on a node which was placed already");
                }
                int i = r71Var2.i;
                this.n = i;
                r71Var2.i = i + 1;
            }
        } else {
            this.n = 0;
        }
        r();
    }
}
