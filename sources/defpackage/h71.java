package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h71 extends co1 {
    public static final fa C0;
    public f71 A0;
    public g71 B0;

    static {
        fa faVarA = ld4.a();
        int i = sz.h;
        faVarA.e(sz.e);
        faVarA.k(1.0f);
        faVarA.l(1);
        C0 = faVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h71(n71 n71Var, f71 f71Var) {
        super(n71Var);
        this.A0 = f71Var;
        this.B0 = n71Var.n != null ? new g71(this) : null;
        if ((((dk1) f71Var).a.c & 512) == 0) {
            return;
        }
        dk0.t();
        throw null;
    }

    @Override // defpackage.co1
    public final void Q0() {
        if (this.B0 == null) {
            this.B0 = new g71(this);
        }
    }

    @Override // defpackage.co1
    public final of1 T0() {
        return this.B0;
    }

    @Override // defpackage.jh1
    public final int V(int i) {
        f71 f71Var = this.A0;
        co1 co1Var = this.H;
        co1Var.getClass();
        return f71Var.S(this, co1Var, i);
    }

    @Override // defpackage.co1
    public final dk1 V0() {
        return ((dk1) this.A0).a;
    }

    @Override // defpackage.jh1
    public final int c0(int i) {
        f71 f71Var = this.A0;
        co1 co1Var = this.H;
        co1Var.getClass();
        return f71Var.e(this, co1Var, i);
    }

    @Override // defpackage.jh1
    public final zw1 e(long j) {
        q0(j);
        f71 f71Var = this.A0;
        co1 co1Var = this.H;
        co1Var.getClass();
        o1(f71Var.d(this, co1Var, j));
        f1();
        return this;
    }

    @Override // defpackage.jh1
    public final int e0(int i) {
        f71 f71Var = this.A0;
        co1 co1Var = this.H;
        co1Var.getClass();
        return f71Var.B(this, co1Var, i);
    }

    @Override // defpackage.jh1
    public final int f(int i) {
        f71 f71Var = this.A0;
        co1 co1Var = this.H;
        co1Var.getClass();
        return f71Var.n(this, co1Var, i);
    }

    @Override // defpackage.co1
    public final void k1(cw cwVar, vu0 vu0Var) {
        co1 co1Var;
        co1 co1Var2 = this.H;
        co1Var2.getClass();
        co1Var2.O0(cwVar, vu0Var);
        if (!((r7) q71.a(this.x)).getShowLayoutBounds() || (co1Var = this.H) == null) {
            return;
        }
        if (l21.a(this.c, co1Var.c) && e21.a(co1Var.i0, 0L)) {
            return;
        }
        long j = this.c;
        cwVar.q(0.5f, 0.5f, ((int) (j >> 32)) - 0.5f, ((int) (j & 4294967295L)) - 0.5f, C0);
    }

    @Override // defpackage.zw1
    public final void n0(long j, float f, hq0 hq0Var) {
        l1(j, f, hq0Var);
        if (this.s) {
            return;
        }
        g1();
        co1 co1Var = this.H;
        co1Var.getClass();
        co1Var.t = this.t;
        D0().c();
        co1Var.t = false;
    }

    @Override // defpackage.mf1
    public final int t0(d6 d6Var) {
        g71 g71Var = this.B0;
        if (g71Var == null) {
            return tp4.a(this, d6Var);
        }
        ul1 ul1Var = g71Var.c0;
        int iD = ul1Var.d(d6Var);
        if (iD >= 0) {
            return ul1Var.c[iD];
        }
        return Integer.MIN_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w1(f71 f71Var) {
        if (f71Var.equals(this.A0) || (((dk1) f71Var).a.c & 512) == 0) {
            this.A0 = f71Var;
        } else {
            dk0.t();
        }
    }
}
