package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vn0 {
    public final do0 a;
    public final r7 b;
    public final hm1 c;
    public final hm1 d;
    public boolean e;

    public vn0(do0 do0Var, r7 r7Var) {
        this.a = do0Var;
        this.b = r7Var;
        hm1 hm1Var = za2.a;
        this.c = new hm1();
        this.d = new hm1();
    }

    public final void a() {
        if (this.e) {
            return;
        }
        g7 g7Var = new g7(0, this, vn0.class, "invalidateNodes", "invalidateNodes()V", 0, 0, 2);
        yl1 yl1Var = this.b.f1;
        if (yl1Var.g(g7Var) < 0) {
            yl1Var.a(g7Var);
        }
        this.e = true;
    }
}
