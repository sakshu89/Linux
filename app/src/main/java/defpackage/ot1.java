package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ot1 extends dk1 implements f71 {
    public float H;
    public float X;
    public float Y;
    public boolean Z;
    public float x;

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        int iR = qh1Var.R(this.X) + qh1Var.R(this.x);
        int iR2 = qh1Var.R(this.Y) + qh1Var.R(this.H);
        zw1 zw1VarE = jh1Var.e(r40.i(-iR, -iR2, j));
        return qh1Var.j0(r40.g(zw1VarE.a + iR, j), r40.f(zw1VarE.b + iR2, j), ji0.a, new o0(14, this, zw1VarE));
    }
}
