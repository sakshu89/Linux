package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ms2 extends zb0 implements qy1, rn0, ho0 {
    public fq0 X;
    public boolean Y;
    public final tu2 Z;

    public ms2(fq0 fq0Var) {
        this.X = fq0Var;
        e9 e9Var = new e9(3, this);
        gy1 gy1Var = pu2.a;
        tu2 tu2Var = new tu2(null, null, e9Var);
        I0(tu2Var);
        this.Z = tu2Var;
    }

    @Override // defpackage.qy1
    public final void H(gy1 gy1Var, hy1 hy1Var, long j) {
        this.Z.H(gy1Var, hy1Var, j);
    }

    @Override // defpackage.rn0
    public final void V(jo0 jo0Var) {
        this.Y = jo0Var.a();
    }

    @Override // defpackage.qy1
    public final void h0() {
        this.Z.h0();
    }

    @Override // defpackage.qy1
    public final long q() {
        jc0 jc0Var = cm4.g(this).h0;
        la4.a.getClass();
        int i = q13.b;
        return xy.r(jc0Var.R(10.0f), jc0Var.R(40.0f), jc0Var.R(10.0f), jc0Var.R(40.0f));
    }
}
