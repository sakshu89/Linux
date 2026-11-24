package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class od0 implements j52 {
    public final hq0 a;
    public pd0 b;

    public od0(hq0 hq0Var) {
        this.a = hq0Var;
    }

    @Override // defpackage.j52
    public final void a() {
        this.b = (pd0) this.a.j(bz3.a);
    }

    @Override // defpackage.j52
    public final void d() {
        pd0 pd0Var = this.b;
        if (pd0Var != null) {
            pd0Var.a();
        }
        this.b = null;
    }

    @Override // defpackage.j52
    public final void b() {
    }
}
