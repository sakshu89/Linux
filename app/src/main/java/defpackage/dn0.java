package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dn0 extends nu2 implements vq0 {
    public /* synthetic */ int f;

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((dn0) q((x50) obj2, Integer.valueOf(((Number) obj).intValue()))).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        dn0 dn0Var = new dn0(2, x50Var);
        dn0Var.f = ((Number) obj).intValue();
        return dn0Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        bz3.g(obj);
        return Boolean.valueOf(this.f > 0);
    }
}
