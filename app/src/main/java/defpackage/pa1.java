package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pa1 extends dk1 implements h30, du0 {
    public ua1 H;
    public ny2 X;
    public final ku1 Y = o44.g(null);
    public ba x;

    public pa1(ba baVar, ua1 ua1Var, ny2 ny2Var) {
        this.x = baVar;
        this.H = ua1Var;
        this.X = ny2Var;
    }

    @Override // defpackage.dk1
    public final void A0() {
        ba baVar = this.x;
        if (baVar.a != null) {
            c11.c("Expected textInputModifierNode to be null");
        }
        baVar.a = this;
    }

    @Override // defpackage.dk1
    public final void B0() {
        this.x.k(this);
    }

    @Override // defpackage.du0
    public final void u(co1 co1Var) {
        this.Y.setValue(co1Var);
    }
}
