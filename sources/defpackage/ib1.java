package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ib1 implements lb1, s70 {
    public final qb1 a;
    public final j70 b;

    public ib1(qb1 qb1Var, j70 j70Var) {
        f41 f41Var;
        j70Var.getClass();
        this.a = qb1Var;
        this.b = j70Var;
        if (qb1Var.d != eb1.a || (f41Var = (f41) j70Var.v(nr4.k)) == null) {
            return;
        }
        f41Var.e(null);
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        qb1 qb1Var = this.a;
        if (qb1Var.d.compareTo(eb1.a) <= 0) {
            qb1Var.f(this);
            f41 f41Var = (f41) this.b.v(nr4.k);
            if (f41Var != null) {
                f41Var.e(null);
            }
        }
    }

    @Override // defpackage.s70
    public final j70 o() {
        return this.b;
    }
}
