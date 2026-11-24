package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lg1 implements az1 {
    public final q82 a;
    public l21 b;
    public z61 c;
    public l21 e;
    public e21 f;

    public lg1(q82 q82Var) {
        this.a = q82Var;
    }

    @Override // defpackage.az1
    public final long m(i21 i21Var, long j, z61 z61Var, long j2) {
        e21 e21Var = this.f;
        if (e21Var != null) {
            l21 l21Var = this.b;
            if ((l21Var == null ? false : l21.a(l21Var.a, j)) && this.c == z61Var) {
                l21 l21Var2 = this.e;
                if (l21Var2 != null ? l21.a(l21Var2.a, j2) : false) {
                    return e21Var.a;
                }
            }
        }
        long jM = this.a.m(i21Var, j, z61Var, j2);
        this.b = new l21(j);
        this.c = z61Var;
        this.e = new l21(j2);
        this.f = new e21(jM);
        return jM;
    }
}
