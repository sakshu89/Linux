package defpackage;

import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pc3 implements z20, lb1 {
    public final r7 a;
    public final g30 b;
    public boolean c;
    public qb1 e;
    public vq0 f = b20.a;

    public pc3(r7 r7Var, g30 g30Var) {
        this.a = r7Var;
        this.b = g30Var;
    }

    public final void a() {
        if (!this.c) {
            this.c = true;
            this.a.getView().setTag(R.id.wrapped_composition_tag, null);
            qb1 qb1Var = this.e;
            if (qb1Var != null) {
                qb1Var.f(this);
            }
        }
        this.b.m();
    }

    public final void b(vq0 vq0Var) {
        this.a.setOnViewTreeOwnersAvailable(new k8(10, this, vq0Var));
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        if (db1Var == db1.ON_DESTROY) {
            a();
        } else {
            if (db1Var != db1.ON_CREATE || this.c) {
                return;
            }
            b(this.f);
        }
    }
}
