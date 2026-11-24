package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hu0 extends lm1 {
    @Override // defpackage.lm1
    public final lm1 C(hq0 hq0Var, hq0 hq0Var2) {
        return (lm1) ((bm2) im2.e(new f2(new b70(1, hq0Var, hq0Var2), 1)));
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final void c() {
        synchronized (im2.c) {
            o();
        }
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
        im2.a();
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final bm2 u(hq0 hq0Var) {
        return (f32) ((bm2) im2.e(new f2(new gu0(hq0Var, 0), 1)));
    }

    @Override // defpackage.lm1
    public final k44 w() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }
}
