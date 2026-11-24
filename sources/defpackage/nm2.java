package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nm2 extends qr2 {
    public Object c;

    public nm2(long j, Object obj) {
        super(j);
        this.c = obj;
    }

    @Override // defpackage.qr2
    public final void a(qr2 qr2Var) {
        qr2Var.getClass();
        this.c = ((nm2) qr2Var).c;
    }

    @Override // defpackage.qr2
    public final qr2 b(long j) {
        return new nm2(im2.j().g(), this.c);
    }
}
