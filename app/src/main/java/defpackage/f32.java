package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f32 extends bm2 {
    public final hq0 e;
    public int f;

    public f32(long j, gm2 gm2Var, hq0 hq0Var) {
        super(j, gm2Var);
        this.e = hq0Var;
        this.f = 1;
    }

    @Override // defpackage.bm2
    public final void c() {
        if (this.c) {
            return;
        }
        l();
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
        this.f++;
    }

    @Override // defpackage.bm2
    public final void l() {
        int i = this.f - 1;
        this.f = i;
        if (i == 0) {
            a();
        }
    }

    @Override // defpackage.bm2
    public final void n(nr2 nr2Var) {
        sa2 sa2Var = im2.a;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @Override // defpackage.bm2
    public final bm2 u(hq0 hq0Var) {
        im2.c(this);
        return new en1(this.b, this.a, im2.k(hq0Var, this.e, true), this);
    }

    @Override // defpackage.bm2
    public final void m() {
    }
}
