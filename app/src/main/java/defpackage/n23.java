package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n23 extends lm1 {
    public final lm1 o;
    public final boolean p;
    public final boolean q;
    public hq0 r;
    public hq0 s;
    public final long t;

    /* JADX WARN: Illegal instructions before constructor call */
    public n23(lm1 lm1Var, hq0 hq0Var, hq0 hq0Var2, boolean z, boolean z2) {
        hq0 hq0VarI;
        hq0 hq0VarE;
        sa2 sa2Var = im2.a;
        super(0L, gm2.f, im2.k(hq0Var, (lm1Var == null || (hq0VarE = lm1Var.e()) == null) ? im2.j.e : hq0VarE, z), im2.l(hq0Var2, (lm1Var == null || (hq0VarI = lm1Var.i()) == null) ? im2.j.f : hq0VarI));
        this.o = lm1Var;
        this.p = z;
        this.q = z2;
        this.r = this.e;
        this.s = this.f;
        this.t = tc4.a();
    }

    @Override // defpackage.lm1
    public final void B(hm1 hm1Var) {
        q44.j();
        throw null;
    }

    @Override // defpackage.lm1
    public final lm1 C(hq0 hq0Var, hq0 hq0Var2) {
        hq0 hq0VarK = im2.k(hq0Var, this.r, true);
        hq0 hq0VarL = im2.l(hq0Var2, this.s);
        return !this.p ? new n23(D().C(null, hq0VarL), hq0VarK, hq0VarL, false, true) : D().C(hq0VarK, hq0VarL);
    }

    public final lm1 D() {
        lm1 lm1Var = this.o;
        return lm1Var == null ? im2.j : lm1Var;
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final void c() {
        lm1 lm1Var;
        this.c = true;
        if (!this.q || (lm1Var = this.o) == null) {
            return;
        }
        lm1Var.c();
    }

    @Override // defpackage.bm2
    public final gm2 d() {
        return D().d();
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final hq0 e() {
        return this.r;
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final boolean f() {
        return D().f();
    }

    @Override // defpackage.bm2
    public final long g() {
        return D().g();
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final int h() {
        return D().h();
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final hq0 i() {
        return this.s;
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final void k() {
        q44.j();
        throw null;
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final void l() {
        q44.j();
        throw null;
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final void m() {
        D().m();
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final void n(nr2 nr2Var) {
        D().n(nr2Var);
    }

    @Override // defpackage.bm2
    public final void r(gm2 gm2Var) {
        q44.j();
        throw null;
    }

    @Override // defpackage.bm2
    public final void s(long j) {
        q44.j();
        throw null;
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final void t(int i) {
        D().t(i);
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final bm2 u(hq0 hq0Var) {
        hq0 hq0VarK = im2.k(hq0Var, this.r, true);
        return !this.p ? im2.g(D().u(null), hq0VarK, true) : D().u(hq0VarK);
    }

    @Override // defpackage.lm1
    public final k44 w() {
        return D().w();
    }

    @Override // defpackage.lm1
    public final hm1 x() {
        return D().x();
    }

    @Override // defpackage.lm1
    /* JADX INFO: renamed from: y */
    public final hq0 e() {
        return this.r;
    }
}
