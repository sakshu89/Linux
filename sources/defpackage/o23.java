package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o23 extends bm2 {
    public final bm2 e;
    public final boolean f;
    public final boolean g;
    public hq0 h;
    public final long i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o23(bm2 bm2Var, hq0 hq0Var, boolean z, boolean z2) {
        hq0 hq0VarE;
        super(0L, gm2.f);
        sa2 sa2Var = im2.a;
        this.e = bm2Var;
        this.f = z;
        this.g = z2;
        this.h = im2.k(hq0Var, (bm2Var == null || (hq0VarE = bm2Var.e()) == null) ? im2.j.e : hq0VarE, z);
        this.i = tc4.a();
    }

    @Override // defpackage.bm2
    public final void c() {
        bm2 bm2Var;
        this.c = true;
        if (!this.g || (bm2Var = this.e) == null) {
            return;
        }
        bm2Var.c();
    }

    @Override // defpackage.bm2
    public final gm2 d() {
        return v().d();
    }

    @Override // defpackage.bm2
    public final hq0 e() {
        return this.h;
    }

    @Override // defpackage.bm2
    public final boolean f() {
        return v().f();
    }

    @Override // defpackage.bm2
    public final long g() {
        return v().g();
    }

    @Override // defpackage.bm2
    public final hq0 i() {
        return null;
    }

    @Override // defpackage.bm2
    public final void k() {
        q44.j();
        throw null;
    }

    @Override // defpackage.bm2
    public final void l() {
        q44.j();
        throw null;
    }

    @Override // defpackage.bm2
    public final void m() {
        v().m();
    }

    @Override // defpackage.bm2
    public final void n(nr2 nr2Var) {
        v().n(nr2Var);
    }

    @Override // defpackage.bm2
    public final bm2 u(hq0 hq0Var) {
        hq0 hq0VarK = im2.k(hq0Var, this.h, true);
        return !this.f ? im2.g(v().u(null), hq0VarK, true) : v().u(hq0VarK);
    }

    public final bm2 v() {
        bm2 bm2Var = this.e;
        return bm2Var == null ? im2.j : bm2Var;
    }
}
