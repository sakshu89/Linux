package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r71 {
    public final n71 a;
    public boolean b;
    public boolean c;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public sf1 q;
    public j71 d = j71.f;
    public final nh1 p = new nh1(this);

    public r71(n71 n71Var) {
        this.a = n71Var;
    }

    public final co1 a() {
        return this.a.o0.d;
    }

    public final void b() {
        j71 j71Var = this.a.p0.d;
        j71 j71Var2 = j71.c;
        j71 j71Var3 = j71.e;
        if (j71Var == j71Var2 || j71Var == j71Var3) {
            if (this.p.i0) {
                g(true);
            } else {
                f(true);
            }
        }
        if (j71Var == j71Var3) {
            sf1 sf1Var = this.q;
            if (sf1Var == null || !sf1Var.c0) {
                h(true);
            } else {
                i(true);
            }
        }
    }

    public final void c(long j) {
        sf1 sf1Var = this.q;
        if (sf1Var != null) {
            r71 r71Var = sf1Var.i;
            r71Var.d = j71.b;
            n71 n71Var = r71Var.a;
            r71Var.e = false;
            sf1Var.g0 = j;
            lt1 snapshotObserver = ((r7) q71.a(n71Var)).getSnapshotObserver();
            rf1 rf1Var = sf1Var.h0;
            snapshotObserver.a.c(n71Var, snapshotObserver.b, rf1Var);
            r71Var.f = true;
            r71Var.g = true;
            boolean zA = vp4.a(n71Var);
            nh1 nh1Var = r71Var.p;
            if (zA) {
                nh1Var.d0 = true;
                nh1Var.e0 = true;
            } else {
                nh1Var.c0 = true;
            }
            r71Var.d = j71.f;
        }
    }

    public final void d(int i) {
        int i2 = this.l;
        this.l = i;
        if ((i2 == 0) != (i == 0)) {
            n71 n71VarU = this.a.u();
            r71 r71Var = n71VarU != null ? n71VarU.p0 : null;
            if (r71Var != null) {
                int i3 = r71Var.l;
                if (i == 0) {
                    r71Var.d(i3 - 1);
                } else {
                    r71Var.d(i3 + 1);
                }
            }
        }
    }

    public final void e(int i) {
        int i2 = this.o;
        this.o = i;
        if ((i2 == 0) != (i == 0)) {
            n71 n71VarU = this.a.u();
            r71 r71Var = n71VarU != null ? n71VarU.p0 : null;
            if (r71Var != null) {
                int i3 = r71Var.o;
                if (i == 0) {
                    r71Var.e(i3 - 1);
                } else {
                    r71Var.e(i3 + 1);
                }
            }
        }
    }

    public final void f(boolean z) {
        if (this.k != z) {
            this.k = z;
            if (z && !this.j) {
                d(this.l + 1);
            } else {
                if (z || this.j) {
                    return;
                }
                d(this.l - 1);
            }
        }
    }

    public final void g(boolean z) {
        if (this.j != z) {
            this.j = z;
            if (z && !this.k) {
                d(this.l + 1);
            } else {
                if (z || this.k) {
                    return;
                }
                d(this.l - 1);
            }
        }
    }

    public final void h(boolean z) {
        if (this.n != z) {
            this.n = z;
            if (z && !this.m) {
                e(this.o + 1);
            } else {
                if (z || this.m) {
                    return;
                }
                e(this.o - 1);
            }
        }
    }

    public final void i(boolean z) {
        if (this.m != z) {
            this.m = z;
            if (z && !this.n) {
                e(this.o + 1);
            } else {
                if (z || this.n) {
                    return;
                }
                e(this.o - 1);
            }
        }
    }

    public final void j() {
        nh1 nh1Var = this.p;
        r71 r71Var = nh1Var.i;
        Object obj = nh1Var.X;
        n71 n71Var = this.a;
        if ((obj != null || r71Var.a().k() != null) && nh1Var.H) {
            nh1Var.H = false;
            nh1Var.X = r71Var.a().k();
            n71 n71VarU = n71Var.u();
            if (n71VarU != null) {
                n71.V(n71VarU, false, 7);
            }
        }
        sf1 sf1Var = this.q;
        if (sf1Var != null) {
            r71 r71Var2 = sf1Var.i;
            if (sf1Var.f0 == null) {
                of1 of1VarT0 = r71Var2.a().T0();
                of1VarT0.getClass();
                if (of1VarT0.x.k() == null) {
                    return;
                }
            }
            if (sf1Var.e0) {
                sf1Var.e0 = false;
                of1 of1VarT1 = r71Var2.a().T0();
                of1VarT1.getClass();
                sf1Var.f0 = of1VarT1.x.k();
                if (vp4.a(n71Var)) {
                    n71 n71VarU2 = n71Var.u();
                    if (n71VarU2 != null) {
                        n71.V(n71VarU2, false, 7);
                        return;
                    }
                    return;
                }
                n71 n71VarU3 = n71Var.u();
                if (n71VarU3 != null) {
                    n71.T(n71VarU3, false, 7);
                }
            }
        }
    }
}
