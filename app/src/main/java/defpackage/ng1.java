package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ng1 implements pi1 {
    public pi1[] a;

    @Override // defpackage.pi1
    public final v22 a(Class cls) {
        for (pi1 pi1Var : this.a) {
            if (pi1Var.b(cls)) {
                return pi1Var.a(cls);
            }
        }
        dk0.r("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    @Override // defpackage.pi1
    public final boolean b(Class cls) {
        for (pi1 pi1Var : this.a) {
            if (pi1Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
