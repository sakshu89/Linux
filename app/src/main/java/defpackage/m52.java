package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m52 extends c1 implements m70 {
    public final /* synthetic */ e30 b;
    public final /* synthetic */ n52 c;

    /* JADX WARN: Illegal instructions before constructor call */
    public m52(e30 e30Var, n52 n52Var) {
        ak1 ak1Var = ak1.c;
        this.b = e30Var;
        this.c = n52Var;
        super(ak1Var);
    }

    @Override // defpackage.m70
    public final void w(j70 j70Var, Throwable th) throws Throwable {
        e30 e30Var = this.b;
        n52 n52Var = this.c;
        ej4.b(th, new zb(4, e30Var, n52Var));
        m70 m70Var = (m70) n52Var.a.v(ak1.c);
        if (m70Var == null) {
            throw th;
        }
        m70Var.w(j70Var, th);
    }
}
