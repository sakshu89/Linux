package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class az3 {
    public static final ek1 a(ek1 ek1Var, hq0 hq0Var) {
        return ek1Var.c(new mf0(hq0Var));
    }

    public static final ek1 b(ek1 ek1Var, hq0 hq0Var) {
        return ek1Var.c(new tf0(hq0Var));
    }

    public static final ek1 c(ek1 ek1Var, hq0 hq0Var) {
        return ek1Var.c(new uf0(hq0Var));
    }

    public static final Object d(qb1 qb1Var, eb1 eb1Var, vq0 vq0Var, nu2 nu2Var) {
        Object objC;
        if (eb1Var != eb1.b) {
            return (qb1Var.d != eb1.a && (objC = tl4.c(new aa(qb1Var, eb1Var, vq0Var, null, 9), nu2Var)) == t70.a) ? objC : q43.a;
        }
        og.i("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        return null;
    }
}
