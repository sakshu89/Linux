package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class km2 extends qr2 {
    public int c;

    public km2(int i, long j) {
        super(j);
        this.c = i;
    }

    @Override // defpackage.qr2
    public final void a(qr2 qr2Var) {
        qr2Var.getClass();
        this.c = ((km2) qr2Var).c;
    }

    @Override // defpackage.qr2
    public final qr2 b(long j) {
        return new km2(this.c, j);
    }
}
