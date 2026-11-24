package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a42 {
    public g30 a;
    public int b;
    public j6 c;
    public vq0 d;
    public int e;
    public ul1 f;
    public gm1 g;

    public a42(g30 g30Var) {
        this.a = g30Var;
    }

    public final boolean a() {
        if (this.a != null) {
            j6 j6Var = this.c;
            if (j6Var != null ? j6Var.a() : false) {
                return true;
            }
        }
        return false;
    }

    public final s31 b(Object obj) {
        s31 s31VarS;
        g30 g30Var = this.a;
        return (g30Var == null || (s31VarS = g30Var.s(this, obj)) == null) ? s31.a : s31VarS;
    }

    public final void c() {
        g30 g30Var = this.a;
        if (g30Var != null) {
            g30Var.x = true;
            g30Var.c0.w();
        }
        this.a = null;
        this.f = null;
        this.g = null;
        this.d = null;
    }

    public final void d(boolean z) {
        int i = this.b;
        this.b = z ? i | 32 : i & (-33);
    }
}
