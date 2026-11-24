package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ea0 extends dk1 implements qf0 {
    public boolean H;
    public boolean X;
    public boolean Y;
    public final ol1 x;

    public ea0(ol1 ol1Var) {
        this.x = ol1Var;
    }

    @Override // defpackage.dk1
    public final void A0() {
        uf4.b(w0(), null, new l2(this, (x50) null, 1), 3);
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        p71Var.a();
        ew ewVar = p71Var.a;
        if (this.H) {
            rf0.E(p71Var, sz.b(0.3f, sz.b), ewVar.c(), 122);
        } else if (this.X || this.Y) {
            rf0.E(p71Var, sz.b(0.1f, sz.b), ewVar.c(), 122);
        }
    }
}
