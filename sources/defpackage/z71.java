package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z71 implements us2 {
    public final nl1 a;
    public final /* synthetic */ b81 b;
    public final /* synthetic */ Object c;

    public z71(b81 b81Var, Object obj) {
        this.b = b81Var;
        this.c = obj;
        int[] iArr = k21.a;
        this.a = new nl1();
    }

    @Override // defpackage.us2
    public final void a() {
        b81.c(this.b, this.c);
    }

    @Override // defpackage.us2
    public final int b() {
        n71 n71Var = (n71) this.b.s.g(this.c);
        if (n71Var != null) {
            return ((pm1) ((wl1) n71Var.n()).b).c;
        }
        return 0;
    }

    @Override // defpackage.us2
    public final void c(int i, long j) {
        b81 b81Var = this.b;
        n71 n71Var = (n71) b81Var.s.g(this.c);
        if (n71Var == null || !n71Var.H()) {
            return;
        }
        int i2 = ((pm1) ((wl1) n71Var.n()).b).c;
        if (i < 0 || i >= i2) {
            z01.d("Index (" + i + ") is out of bound of [0, " + i2 + ')');
        }
        if (n71Var.I()) {
            z01.a("Pre-measure called on node that is not placed");
        }
        n71 n71Var2 = b81Var.a;
        n71Var2.X = true;
        ((r7) q71.a(n71Var)).r((n71) ((wl1) n71Var.n()).get(i), j);
        n71Var2.X = false;
        this.a.a(i);
    }

    @Override // defpackage.us2
    public final void d(x0 x0Var) {
        zn1 zn1Var;
        dk1 dk1Var;
        n71 n71Var = (n71) this.b.s.g(this.c);
        if (n71Var == null || (zn1Var = n71Var.o0) == null || (dk1Var = zn1Var.f) == null) {
            return;
        }
        jd4.d(dk1Var, "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", x0Var);
    }
}
