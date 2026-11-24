package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xo4 {
    public static final q01 a(s01 s01Var, float f, float f2, p01 p01Var, x20 x20Var) {
        Float fValueOf = Float.valueOf(f);
        Float fValueOf2 = Float.valueOf(f2);
        Object objL = x20Var.L();
        xy xyVar = r20.a;
        if (objL == xyVar) {
            objL = new q01(s01Var, fValueOf, fValueOf2, p01Var);
            x20Var.g0(objL);
        }
        q01 q01Var = (q01) objL;
        boolean zH = x20Var.h(p01Var);
        Object objL2 = x20Var.L();
        if (zH || objL2 == xyVar) {
            objL2 = new t01(fValueOf, q01Var, fValueOf2, p01Var);
            x20Var.g0(objL2);
        }
        bz3.d((fq0) objL2, x20Var);
        boolean zH2 = x20Var.h(s01Var);
        Object objL3 = x20Var.L();
        if (zH2 || objL3 == xyVar) {
            objL3 = new o0(10, s01Var, q01Var);
            x20Var.g0(objL3);
        }
        bz3.a(q01Var, (hq0) objL3, x20Var);
        return q01Var;
    }
}
