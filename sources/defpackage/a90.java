package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a90 extends nu2 implements hq0 {
    public int f;

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        a90 a90Var = new a90(1, (x50) obj);
        q43 q43Var = q43.a;
        a90Var.s(q43Var);
        return q43Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        if (i == 0) {
            bz3.g(obj);
            this.f = 1;
            throw null;
        }
        if (i == 1) {
            bz3.g(obj);
            return q43.a;
        }
        og.n("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
