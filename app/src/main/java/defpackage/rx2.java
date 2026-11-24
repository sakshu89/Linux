package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rx2 extends zb0 implements h30, dx2 {
    public cu2 X;
    public n90 Y;
    public hy2 Z;
    public v60 c0;
    public yq2 d0;
    public final qc0 e0 = o44.b(new kb(23, this));
    public l42 f0 = l42.e;

    public rx2(cu2 cu2Var, n90 n90Var, hy2 hy2Var, v60 v60Var) {
        this.X = cu2Var;
        this.Y = n90Var;
        this.Z = hy2Var;
        this.c0 = v60Var;
    }

    @Override // defpackage.dk1
    public final void A0() {
        cu2 cu2Var = this.X;
        cu2Var.c = e13.c;
        cu2Var.b = this;
    }

    @Override // defpackage.dk1
    public final void B0() {
        cu2 cu2Var = this.X;
        cu2Var.c = e13.b;
        cu2Var.b = null;
    }

    @Override // defpackage.dx2
    public final long f(y61 y61Var) {
        return m(y61Var).d();
    }

    @Override // defpackage.dx2
    public final l42 m(y61 y61Var) {
        if (!this.w) {
            return this.f0;
        }
        l42 l42Var = (l42) this.c0.j(y61Var);
        if (l42Var == null) {
            return this.f0;
        }
        this.f0 = l42Var;
        return l42Var;
    }

    @Override // defpackage.dx2
    public final cx2 s0() {
        return (cx2) this.e0.getValue();
    }
}
