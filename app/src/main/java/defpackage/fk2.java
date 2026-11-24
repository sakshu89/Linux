package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fk2 implements rd0 {
    public final hk2 a;
    public final long b;
    public final Object c;
    public final yv e;

    public fk2(hk2 hk2Var, long j, Object obj, yv yvVar) {
        this.a = hk2Var;
        this.b = j;
        this.c = obj;
        this.e = yvVar;
    }

    @Override // defpackage.rd0
    public final void a() {
        hk2 hk2Var = this.a;
        synchronized (hk2Var) {
            if (this.b < hk2Var.o()) {
                return;
            }
            Object[] objArr = hk2Var.k;
            objArr.getClass();
            long j = this.b;
            if (objArr[((int) j) & (objArr.length - 1)] != this) {
                return;
            }
            s44.c(objArr, j, s44.a);
            hk2Var.i();
        }
    }
}
