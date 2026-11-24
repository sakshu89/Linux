package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a60 {
    public long b;
    public final jr2 d;
    public final g32 e;
    public final jr2 f;
    public final g32 g;
    public final e4 a = new e4(9);
    public final jr2 c = o54.a(i60.i);

    public a60() {
        jr2 jr2VarA = o54.a(null);
        this.d = jr2VarA;
        this.e = new g32(jr2VarA);
        jr2 jr2VarA2 = o54.a(ii0.a);
        this.f = jr2VarA2;
        this.g = new g32(jr2VarA2);
    }

    public final synchronized rv1 a() {
        rv1 rv1Var = (rv1) this.d.getValue();
        if (rv1Var == null) {
            return null;
        }
        if ((rv1Var instanceof pv1) || ((Number) this.a.a()).longValue() - this.b < 120000) {
            return rv1Var;
        }
        this.d.i(null);
        return null;
    }

    public final synchronized void b() {
        this.d.i(null);
    }

    public final synchronized void c(rv1 rv1Var) {
        try {
            rv1Var.getClass();
            if (!g31.a(this.d.getValue(), rv1Var)) {
                this.b = ((Number) this.a.a()).longValue();
            }
            jr2 jr2Var = this.d;
            jr2Var.getClass();
            jr2Var.j(null, rv1Var);
        } catch (Throwable th) {
            throw th;
        }
    }
}
