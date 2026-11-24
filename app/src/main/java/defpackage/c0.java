package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends nu2 implements vq0 {
    public /* synthetic */ Object f;
    public final /* synthetic */ long i;
    public final /* synthetic */ f0 j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String n;
    public final /* synthetic */ long s;
    public final /* synthetic */ o42 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(long j, f0 f0Var, String str, String str2, long j2, o42 o42Var, x50 x50Var) {
        super(2, x50Var);
        this.i = j;
        this.j = f0Var;
        this.k = str;
        this.n = str2;
        this.s = j2;
        this.t = o42Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        c0 c0Var = (c0) q((x50) obj2, (dm1) obj);
        q43 q43Var = q43.a;
        c0Var.s(q43Var);
        return q43Var;
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        c0 c0Var = new c0(this.i, this.j, this.k, this.n, this.s, this.t, x50Var);
        c0Var.f = obj;
        return c0Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        dm1 dm1Var = (dm1) this.f;
        bz3.g(obj);
        Long l = (Long) dm1Var.c(f0.c);
        if ((l != null ? l.longValue() : 0L) == this.i) {
            f0 f0Var = this.j;
            String str = this.k;
            dm1Var.f(f0.d(f0Var, str), this.n);
            dm1Var.f(f0.c(f0Var, str), new Long(this.s));
            this.t.a = true;
        }
        return q43.a;
    }
}
