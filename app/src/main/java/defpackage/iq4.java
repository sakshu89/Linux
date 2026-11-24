package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class iq4 {
    public static final void a(b83 b83Var, q91 q91Var, qb1 qb1Var) {
        q91Var.getClass();
        qb1Var.getClass();
        ga2 ga2Var = (ga2) b83Var.c("androidx.lifecycle.savedstate.vm.tag");
        if (ga2Var == null || ga2Var.c) {
            return;
        }
        ga2Var.c(q91Var, qb1Var);
        eb1 eb1Var = qb1Var.d;
        if (eb1Var == eb1.b || eb1Var.compareTo(eb1.e) >= 0) {
            q91Var.G();
        } else {
            qb1Var.a(new va0(q91Var, qb1Var));
        }
    }
}
