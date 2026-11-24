package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jm2 extends qr2 {
    public float c;

    public jm2(float f, long j) {
        super(j);
        this.c = f;
    }

    @Override // defpackage.qr2
    public final void a(qr2 qr2Var) {
        qr2Var.getClass();
        this.c = ((jm2) qr2Var).c;
    }

    @Override // defpackage.qr2
    public final qr2 b(long j) {
        return new jm2(this.c, j);
    }
}
