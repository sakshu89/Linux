package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mr2 extends qr2 {
    public n1 c;
    public int d;
    public int e;

    public mr2(long j, n1 n1Var) {
        super(j);
        this.c = n1Var;
    }

    @Override // defpackage.qr2
    public final void a(qr2 qr2Var) {
        synchronized (y44.a) {
            qr2Var.getClass();
            this.c = ((mr2) qr2Var).c;
            this.d = ((mr2) qr2Var).d;
            this.e = ((mr2) qr2Var).e;
        }
    }

    @Override // defpackage.qr2
    public final qr2 b(long j) {
        return new mr2(j, this.c);
    }
}
