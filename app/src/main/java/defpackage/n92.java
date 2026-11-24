package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n92 extends y50 implements nm0 {
    public final nm0 e;
    public final j70 f;
    public final int i;
    public j70 j;
    public x50 k;

    public n92(nm0 nm0Var, j70 j70Var) {
        super(z00.c, gi0.a);
        this.e = nm0Var;
        this.f = j70Var;
        this.i = ((Number) j70Var.y(new ag(9), 0)).intValue();
    }

    @Override // defpackage.pk, defpackage.u70
    public final u70 d() {
        x50 x50Var = this.k;
        if (x50Var instanceof u70) {
            return (u70) x50Var;
        }
        return null;
    }

    @Override // defpackage.y50, defpackage.x50
    public final j70 f() {
        j70 j70Var = this.j;
        return j70Var == null ? gi0.a : j70Var;
    }

    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        try {
            Object objV = v(x50Var, obj);
            return objV == t70.a ? objV : q43.a;
        } catch (Throwable th) {
            this.j = new ce0(x50Var.f(), th);
            throw th;
        }
    }

    @Override // defpackage.pk
    public final StackTraceElement r() {
        return null;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        Throwable thA = i72.a(obj);
        if (thA != null) {
            this.j = new ce0(f(), thA);
        }
        x50 x50Var = this.k;
        if (x50Var != null) {
            x50Var.h(obj);
        }
        return t70.a;
    }

    public final Object v(x50 x50Var, Object obj) {
        j70 j70VarF = x50Var.f();
        hp4.b(j70VarF);
        j70 j70Var = this.j;
        if (j70Var != j70VarF) {
            if (j70Var instanceof ce0) {
                throw new IllegalStateException(ds2.b("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((ce0) j70Var).b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) j70VarF.y(new ha(9, this), 0)).intValue() != this.i) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f + ",\n\t\tbut emission happened in " + j70VarF + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.j = j70VarF;
        }
        this.k = x50Var;
        wq0 wq0Var = p92.a;
        nm0 nm0Var = this.e;
        nm0Var.getClass();
        Object objC = wq0Var.c(nm0Var, obj, this);
        if (!g31.a(objC, t70.a)) {
            this.k = null;
        }
        return objC;
    }
}
