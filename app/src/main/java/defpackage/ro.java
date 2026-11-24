package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ro extends dk1 implements ep1, zn, qf0 {
    public boolean H;
    public hq0 X;
    public final so x;

    public ro(so soVar, hq0 hq0Var) {
        this.x = soVar;
        this.X = hq0Var;
        soVar.a = this;
    }

    @Override // defpackage.dk1
    public final void C0() {
        I0();
    }

    public final void I0() {
        this.H = false;
        this.x.b = null;
        vm4.a(this);
    }

    @Override // defpackage.ep1
    public final void J() {
        I0();
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        boolean z = this.H;
        so soVar = this.x;
        if (!z) {
            soVar.b = null;
            tr4.a(this, new h7(3, this, soVar));
            if (soVar.b == null) {
                throw cq.e("DrawResult not defined, did you forget to call onDraw?");
            }
            this.H = true;
        }
        uf1 uf1Var = soVar.b;
        uf1Var.getClass();
        ((hq0) uf1Var.b).j(p71Var);
    }

    @Override // defpackage.xb0, defpackage.qy1
    public final void a() {
        I0();
    }

    @Override // defpackage.zn
    public final jc0 b() {
        return cm4.g(this).h0;
    }

    @Override // defpackage.zn
    public final long c() {
        return cp4.a(cm4.e(this, 4).c);
    }

    @Override // defpackage.zn
    public final z61 getLayoutDirection() {
        return cm4.g(this).i0;
    }

    @Override // defpackage.qf0
    public final void o0() {
        I0();
    }

    @Override // defpackage.xb0
    public final void t0() {
        I0();
    }

    @Override // defpackage.dk1
    public final void B0() {
    }
}
