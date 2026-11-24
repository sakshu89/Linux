package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends nu2 implements vq0 {
    public /* synthetic */ Object f;
    public final /* synthetic */ Long i;
    public final /* synthetic */ f0 j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(Long l, f0 f0Var, String str, long j, x50 x50Var) {
        super(2, x50Var);
        this.i = l;
        this.j = f0Var;
        this.k = str;
        this.n = j;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        a0 a0Var = (a0) q((x50) obj2, (dm1) obj);
        q43 q43Var = q43.a;
        a0Var.s(q43Var);
        return q43Var;
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        a0 a0Var = new a0(this.i, this.j, this.k, this.n, x50Var);
        a0Var.f = obj;
        return a0Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        dm1 dm1Var = (dm1) this.f;
        bz3.g(obj);
        Long l = (Long) dm1Var.c(f0.c);
        long jLongValue = l != null ? l.longValue() : 0L;
        long jLongValue2 = this.i.longValue();
        q43 q43Var = q43.a;
        if (jLongValue != jLongValue2) {
            return q43Var;
        }
        f0 f0Var = this.j;
        iz1 iz1VarD = f0.d(f0Var, "gemini");
        String string = cs2.V(this.k).toString();
        dm1Var.getClass();
        dm1Var.f(iz1VarD, string);
        dm1Var.f(f0.c(f0Var, "gemini"), new Long(this.n));
        return q43Var;
    }
}
