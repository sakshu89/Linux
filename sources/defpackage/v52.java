package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v52 implements lb1 {
    public final /* synthetic */ db1 a;
    public final /* synthetic */ t42 b;
    public final /* synthetic */ s70 c;
    public final /* synthetic */ db1 e;
    public final /* synthetic */ yv f;
    public final /* synthetic */ an1 i;
    public final /* synthetic */ vq0 j;

    public v52(db1 db1Var, t42 t42Var, s70 s70Var, db1 db1Var2, yv yvVar, an1 an1Var, vq0 vq0Var) {
        this.a = db1Var;
        this.b = t42Var;
        this.c = s70Var;
        this.e = db1Var2;
        this.f = yvVar;
        this.i = an1Var;
        this.j = vq0Var;
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        db1 db1Var2 = this.a;
        t42 t42Var = this.b;
        x50 x50Var = null;
        if (db1Var == db1Var2) {
            t42Var.a = uf4.b(this.c, null, new aa(this.i, this.j, x50Var, 8), 3);
            return;
        }
        if (db1Var == this.e) {
            f41 f41Var = (f41) t42Var.a;
            if (f41Var != null) {
                f41Var.e(null);
            }
            t42Var.a = null;
        }
        if (db1Var == db1.ON_DESTROY) {
            this.f.h(q43.a);
        }
    }
}
