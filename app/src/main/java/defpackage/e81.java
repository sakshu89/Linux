package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e81 extends dk1 implements lu1 {
    public boolean H;
    public float x;

    @Override // defpackage.lu1
    public final Object n0(Object obj) {
        c92 c92Var = obj instanceof c92 ? (c92) obj : null;
        if (c92Var == null) {
            c92Var = new c92();
            c92Var.a = 0.0f;
            c92Var.b = true;
        }
        c92Var.a = this.x;
        c92Var.b = this.H;
        return c92Var;
    }
}
