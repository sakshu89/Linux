package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ga2 implements lb1, AutoCloseable {
    public final String a;
    public final fa2 b;
    public boolean c;

    public ga2(String str, fa2 fa2Var) {
        this.a = str;
        this.b = fa2Var;
    }

    public final void c(q91 q91Var, qb1 qb1Var) {
        q91Var.getClass();
        qb1Var.getClass();
        if (this.c) {
            og.n("Already attached to lifecycleOwner");
            return;
        }
        this.c = true;
        qb1Var.a(this);
        q91Var.F(this.a, (i10) this.b.a.a);
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        if (db1Var == db1.ON_DESTROY) {
            this.c = false;
            ob1Var.f().f(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }
}
