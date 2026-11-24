package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y62 {
    public lj1 a;
    public y12 b;
    public String d;
    public yv0 e;
    public b72 g;
    public z62 h;
    public z62 i;
    public z62 j;
    public long k;
    public long l;
    public ux m;
    public int c = -1;
    public uf1 f = new uf1(22);

    public static void b(z62 z62Var, String str) {
        if (z62Var != null) {
            if (z62Var.j != null) {
                og.g(str.concat(".body != null"));
                return;
            }
            if (z62Var.k != null) {
                og.g(str.concat(".networkResponse != null"));
            } else if (z62Var.n != null) {
                og.g(str.concat(".cacheResponse != null"));
            } else {
                if (z62Var.s == null) {
                    return;
                }
                og.g(str.concat(".priorResponse != null"));
            }
        }
    }

    public final z62 a() {
        int i = this.c;
        if (i < 0) {
            dk0.e(this.c, "code < 0: ");
            return null;
        }
        lj1 lj1Var = this.a;
        if (lj1Var == null) {
            og.n("request == null");
            return null;
        }
        y12 y12Var = this.b;
        if (y12Var == null) {
            og.n("protocol == null");
            return null;
        }
        String str = this.d;
        if (str != null) {
            return new z62(lj1Var, y12Var, str, i, this.e, this.f.k(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }
        og.n("message == null");
        return null;
    }
}
