package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yg1 {
    public static xg1 a(Object obj, Object obj2) {
        xg1 xg1VarB = (xg1) obj;
        xg1 xg1Var = (xg1) obj2;
        if (!xg1Var.isEmpty()) {
            if (!xg1VarB.a) {
                xg1VarB = xg1VarB.b();
            }
            xg1VarB.a();
            if (!xg1Var.isEmpty()) {
                xg1VarB.putAll(xg1Var);
            }
        }
        return xg1VarB;
    }
}
