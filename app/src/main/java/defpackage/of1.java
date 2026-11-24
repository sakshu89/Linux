package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class of1 extends mf1 implements jh1 {
    public LinkedHashMap X;
    public ph1 Z;
    public final ul1 c0;
    public final co1 x;
    public long H = 0;
    public final pf1 Y = new pf1(this);

    public of1(co1 co1Var) {
        this.x = co1Var;
        ul1 ul1Var = xo1.a;
        this.c0 = new ul1();
    }

    public static final void K0(of1 of1Var, ph1 ph1Var) {
        LinkedHashMap linkedHashMap;
        if (ph1Var != null) {
            of1Var.o0((((long) ph1Var.a()) & 4294967295L) | (((long) ph1Var.b()) << 32));
        } else {
            of1Var.o0(0L);
        }
        if (!g31.a(of1Var.Z, ph1Var) && ph1Var != null && ((((linkedHashMap = of1Var.X) != null && !linkedHashMap.isEmpty()) || !ph1Var.d().isEmpty()) && !g31.a(ph1Var.d(), of1Var.X))) {
            sf1 sf1Var = of1Var.x.x.p0.q;
            sf1Var.getClass();
            sf1Var.X.f();
            LinkedHashMap linkedHashMap2 = of1Var.X;
            if (linkedHashMap2 == null) {
                linkedHashMap2 = new LinkedHashMap();
                of1Var.X = linkedHashMap2;
            }
            linkedHashMap2.clear();
            linkedHashMap2.putAll(ph1Var.d());
        }
        of1Var.Z = ph1Var;
    }

    @Override // defpackage.mf1
    public final y61 A0() {
        return this.Y;
    }

    @Override // defpackage.mf1
    public final boolean B0() {
        return this.Z != null;
    }

    @Override // defpackage.mf1
    public final n71 C0() {
        return this.x.x;
    }

    @Override // defpackage.mf1
    public final ph1 D0() {
        ph1 ph1Var = this.Z;
        if (ph1Var != null) {
            return ph1Var;
        }
        throw cq.e("LookaheadDelegate has not been measured yet when measureResult is requested.");
    }

    @Override // defpackage.mf1
    public final mf1 E0() {
        co1 co1Var = this.x.X;
        if (co1Var != null) {
            return co1Var.T0();
        }
        return null;
    }

    @Override // defpackage.mf1
    public final long F0() {
        return this.H;
    }

    @Override // defpackage.mf1
    public final void J0() {
        n0(this.H, 0.0f, null);
    }

    public void L0() {
        D0().c();
    }

    public final void M0(long j) {
        if (!e21.a(this.H, j)) {
            this.H = j;
            co1 co1Var = this.x;
            sf1 sf1Var = co1Var.x.p0.q;
            if (sf1Var != null) {
                sf1Var.x0();
            }
            mf1.H0(co1Var);
        }
        if (this.t) {
            return;
        }
        x0(D0());
    }

    public final long N0(of1 of1Var, boolean z) {
        long jC = 0;
        while (!this.equals(of1Var)) {
            if (!this.n || !z) {
                jC = e21.c(jC, this.H);
            }
            co1 co1Var = this.x.X;
            co1Var.getClass();
            this = co1Var.T0();
            this.getClass();
        }
        return jC;
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.x.b();
    }

    @Override // defpackage.z21
    public final z61 getLayoutDirection() {
        return this.x.x.i0;
    }

    @Override // defpackage.zw1, defpackage.jh1
    public final Object k() {
        return this.x.k();
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.x.l();
    }

    @Override // defpackage.zw1
    public final void n0(long j, float f, hq0 hq0Var) {
        M0(j);
        if (this.s) {
            return;
        }
        L0();
    }

    @Override // defpackage.mf1, defpackage.z21
    public final boolean s() {
        return true;
    }

    @Override // defpackage.mf1
    public final mf1 z0() {
        co1 co1Var = this.x.H;
        if (co1Var != null) {
            return co1Var.T0();
        }
        return null;
    }
}
