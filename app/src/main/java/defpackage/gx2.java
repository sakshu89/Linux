package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gx2 implements dx2 {
    public final long a;
    public final /* synthetic */ hx2 b;

    public gx2(hx2 hx2Var, long j) {
        this.b = hx2Var;
        this.a = j;
    }

    @Override // defpackage.dx2
    public final long f(y61 y61Var) {
        y61 y61Var2 = (y61) this.b.Y.getValue();
        if (y61Var2 != null) {
            return y61Var.u(y61Var2, this.a);
        }
        c11.d("Tried to open context menu before the anchor was placed.");
        og.k();
        return 0L;
    }

    @Override // defpackage.dx2
    public final l42 m(y61 y61Var) {
        return ry3.a(f(y61Var), 0L);
    }

    @Override // defpackage.dx2
    public final cx2 s0() {
        return kb4.a(this.b);
    }
}
