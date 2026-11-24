package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ik2 extends a2 {
    public long a;
    public yv b;

    @Override // defpackage.a2
    public final boolean a(z1 z1Var) {
        hk2 hk2Var = (hk2) z1Var;
        if (this.a >= 0) {
            return false;
        }
        long j = hk2Var.n;
        if (j < hk2Var.s) {
            hk2Var.s = j;
        }
        this.a = j;
        return true;
    }

    @Override // defpackage.a2
    public final x50[] b(z1 z1Var) {
        long j = this.a;
        this.a = -1L;
        this.b = null;
        return ((hk2) z1Var).v(j);
    }
}
