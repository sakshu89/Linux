package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wi1 implements db2 {
    public final j1 a;
    public final s43 b;
    public final xk0 c;

    public wi1(s43 s43Var, xk0 xk0Var, j1 j1Var) {
        this.b = s43Var;
        xk0Var.getClass();
        this.c = xk0Var;
        this.a = j1Var;
    }

    @Override // defpackage.db2
    public final int a(yt0 yt0Var) {
        this.b.getClass();
        return yt0Var.unknownFields.hashCode();
    }

    @Override // defpackage.db2
    public final void b(Object obj, Object obj2) {
        gb2.k(this.b, obj, obj2);
    }

    @Override // defpackage.db2
    public final void c(Object obj) {
        this.b.getClass();
        r43 r43Var = ((yt0) obj).unknownFields;
        if (r43Var.e) {
            r43Var.e = false;
        }
        this.c.getClass();
        ky0.x(obj);
        throw null;
    }

    @Override // defpackage.db2
    public final int d(yt0 yt0Var) {
        this.b.getClass();
        r43 r43Var = yt0Var.unknownFields;
        int i = r43Var.d;
        if (i != -1) {
            return i;
        }
        int iF = 0;
        for (int i2 = 0; i2 < r43Var.a; i2++) {
            int i3 = r43Var.b[i2] >>> 3;
            iF += kz.f(3, (no) r43Var.c[i2]) + kz.i(i3) + kz.h(2) + (kz.h(1) * 2);
        }
        r43Var.d = iF;
        return iF;
    }

    @Override // defpackage.db2
    public final void e(Object obj, uf1 uf1Var) {
        this.c.getClass();
        ky0.x(obj);
        throw null;
    }

    @Override // defpackage.db2
    public final boolean f(Object obj) {
        this.c.getClass();
        ky0.x(obj);
        throw null;
    }

    @Override // defpackage.db2
    public final boolean g(yt0 yt0Var, yt0 yt0Var2) {
        this.b.getClass();
        return yt0Var.unknownFields.equals(yt0Var2.unknownFields);
    }

    @Override // defpackage.db2
    public final void h(Object obj, iz izVar, wk0 wk0Var) {
        this.b.getClass();
        s43.a(obj);
        this.c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.db2
    public final yt0 i() {
        j1 j1Var = this.a;
        return j1Var instanceof yt0 ? ((yt0) j1Var).i() : ((wt0) ((yt0) j1Var).c(5)).b();
    }
}
