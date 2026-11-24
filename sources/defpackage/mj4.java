package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class mj4 {
    public static final Object a(gw1 gw1Var, z12 z12Var) {
        z12Var.getClass();
        Object objB = gw1Var.get(z12Var);
        if (objB == null) {
            objB = z12Var.b();
        }
        return ((h63) objB).a(gw1Var);
    }

    public static final gw1 b(a22[] a22VarArr, gw1 gw1Var, gw1 gw1Var2) {
        fw1 fw1Var = new fw1(gw1.e);
        for (a22 a22Var : a22VarArr) {
            z12 z12Var = (z12) a22Var.d;
            if (a22Var.c || !gw1Var.containsKey(z12Var)) {
                fw1Var.put(z12Var, z12Var.c(a22Var, (h63) gw1Var2.get(z12Var)));
            }
        }
        return fw1Var.a();
    }
}
