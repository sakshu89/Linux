package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n52 implements s70, j52 {
    public static final bw e = new bw(0);
    public final j70 a;
    public final n52 b = this;
    public volatile j70 c;

    public n52(j70 j70Var) {
        this.a = j70Var;
    }

    @Override // defpackage.j52
    public final void b() {
        c();
    }

    public final void c() {
        synchronized (this.b) {
            try {
                j70 j70Var = this.c;
                if (j70Var == null) {
                    this.c = e;
                } else {
                    tp0 tp0Var = new tp0(0);
                    f41 f41Var = (f41) j70Var.v(nr4.k);
                    if (f41Var != null) {
                        f41Var.e(tp0Var);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.j52
    public final void d() {
        c();
    }

    @Override // defpackage.s70
    public final j70 o() {
        j70 j70VarR;
        j70 j70Var = this.c;
        if (j70Var == null || j70Var == e) {
            e30 e30Var = (e30) this.a.v(e30.b);
            j70 m52Var = e30Var != null ? new m52(e30Var, this) : gi0.a;
            synchronized (this.b) {
                try {
                    j70 j70Var2 = this.c;
                    if (j70Var2 == null) {
                        j70 j70Var3 = this.a;
                        j70VarR = j70Var3.r(new h41((f41) j70Var3.v(nr4.k))).r(gi0.a).r(m52Var);
                    } else if (j70Var2 == e) {
                        j70 j70Var4 = this.a;
                        h41 h41Var = new h41((f41) j70Var4.v(nr4.k));
                        h41Var.A(new tp0(0));
                        j70VarR = j70Var4.r(h41Var).r(gi0.a).r(m52Var);
                    } else {
                        j70VarR = j70Var2;
                    }
                    this.c = j70VarR;
                } catch (Throwable th) {
                    throw th;
                }
            }
            j70Var = j70VarR;
        }
        j70Var.getClass();
        return j70Var;
    }

    @Override // defpackage.j52
    public final void a() {
    }
}
