package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class h00 {
    public static final j00 a = new j00(jg1.d, xy.w);

    public static final j00 a(fg fgVar, jl jlVar, x20 x20Var, int i) {
        if (fgVar.equals(jg1.d) && jlVar.equals(xy.w)) {
            x20Var.W(-1446604504);
            x20Var.p(false);
            return a;
        }
        x20Var.W(-1446550657);
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && x20Var.f(fgVar)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !x20Var.f(jlVar)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objL = x20Var.L();
        if (z3 || objL == r20.a) {
            objL = new j00(fgVar, jlVar);
            x20Var.g0(objL);
        }
        j00 j00Var = (j00) objL;
        x20Var.p(false);
        return j00Var;
    }
}
