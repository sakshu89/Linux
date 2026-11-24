package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class en1 extends bm2 {
    public final hq0 e;
    public final bm2 f;

    public en1(long j, gm2 gm2Var, hq0 hq0Var, bm2 bm2Var) {
        super(j, gm2Var);
        this.e = hq0Var;
        this.f = bm2Var;
        bm2Var.k();
    }

    @Override // defpackage.bm2
    public final void c() {
        bm2 bm2Var = this.f;
        if (this.c) {
            return;
        }
        if (this.b != bm2Var.g()) {
            a();
        }
        bm2Var.l();
        this.c = true;
        synchronized (im2.c) {
            o();
        }
    }

    @Override // defpackage.bm2
    public final hq0 e() {
        return this.e;
    }

    @Override // defpackage.bm2
    public final boolean f() {
        return true;
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
    public final void n(nr2 nr2Var) {
        sa2 sa2Var = im2.a;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @Override // defpackage.bm2
    public final bm2 u(hq0 hq0Var) {
        return new en1(this.b, this.a, im2.k(hq0Var, this.e, true), this.f);
    }

    @Override // defpackage.bm2
    public final void m() {
    }
}
