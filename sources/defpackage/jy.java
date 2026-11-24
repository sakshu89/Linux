package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jy implements wq0 {
    public final /* synthetic */ c01 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ m82 c;
    public final /* synthetic */ fq0 e;

    public jy(c01 c01Var, boolean z, m82 m82Var, fq0 fq0Var) {
        this.a = c01Var;
        this.b = z;
        this.c = m82Var;
        this.e = fq0Var;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        x20 x20Var = (x20) obj2;
        ((Number) obj3).intValue();
        x20Var.W(-1525724089);
        Object objL = x20Var.L();
        if (objL == r20.a) {
            objL = new ol1();
            x20Var.g0(objL);
        }
        ol1 ol1Var = (ol1) objL;
        m30 m30Var = zz0.a;
        c01 c01Var = this.a;
        ek1 ek1VarC = (c01Var == null ? bk1.a : new a01(ol1Var, c01Var)).c(new iy(ol1Var, null, false, this.b, null, this.c, this.e));
        x20Var.p(false);
        return ek1VarC;
    }
}
