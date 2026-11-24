package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k2 extends nu2 implements vq0 {
    public /* synthetic */ boolean f;

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((k2) q((x50) obj2, bool)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        k2 k2Var = new k2(2, x50Var);
        k2Var.f = ((Boolean) obj).booleanValue();
        return k2Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        boolean z = this.f;
        bz3.g(obj);
        return Boolean.valueOf(z);
    }
}
