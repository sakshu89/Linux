package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r01 extends nu2 implements vq0 {
    public /* synthetic */ float f;

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((r01) q((x50) obj2, Float.valueOf(((Number) obj).floatValue()))).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        r01 r01Var = new r01(2, x50Var);
        r01Var.f = ((Number) obj).floatValue();
        return r01Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        bz3.g(obj);
        return Boolean.valueOf(this.f > 0.0f);
    }
}
