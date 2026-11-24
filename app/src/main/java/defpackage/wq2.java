package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wq2 implements x50, u70 {
    public final x50 a;
    public final j70 b;

    public wq2(x50 x50Var, j70 j70Var) {
        this.a = x50Var;
        this.b = j70Var;
    }

    @Override // defpackage.u70
    public final u70 d() {
        x50 x50Var = this.a;
        if (x50Var instanceof u70) {
            return (u70) x50Var;
        }
        return null;
    }

    @Override // defpackage.x50
    public final j70 f() {
        return this.b;
    }

    @Override // defpackage.x50
    public final void h(Object obj) {
        this.a.h(obj);
    }
}
